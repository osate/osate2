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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:88:1: entryRuleCategoriesDefinitions : ruleCategoriesDefinitions EOF ;
    public final void entryRuleCategoriesDefinitions() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:89:1: ( ruleCategoriesDefinitions EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:90:1: ruleCategoriesDefinitions EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:97:1: ruleCategoriesDefinitions : ( ( rule__CategoriesDefinitions__UnorderedGroup ) ) ;
    public final void ruleCategoriesDefinitions() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:101:5: ( ( ( rule__CategoriesDefinitions__UnorderedGroup ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:102:1: ( ( rule__CategoriesDefinitions__UnorderedGroup ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:102:1: ( ( rule__CategoriesDefinitions__UnorderedGroup ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:103:1: ( rule__CategoriesDefinitions__UnorderedGroup )
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:104:1: ( rule__CategoriesDefinitions__UnorderedGroup )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:104:2: rule__CategoriesDefinitions__UnorderedGroup
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:116:1: entryRuleRequirementCategories : ruleRequirementCategories EOF ;
    public final void entryRuleRequirementCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:117:1: ( ruleRequirementCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:118:1: ruleRequirementCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:125:1: ruleRequirementCategories : ( ( rule__RequirementCategories__Group__0 ) ) ;
    public final void ruleRequirementCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:129:5: ( ( ( rule__RequirementCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:130:1: ( ( rule__RequirementCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:130:1: ( ( rule__RequirementCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:131:1: ( rule__RequirementCategories__Group__0 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:132:1: ( rule__RequirementCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:132:2: rule__RequirementCategories__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:144:1: entryRuleMethodCategories : ruleMethodCategories EOF ;
    public final void entryRuleMethodCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:145:1: ( ruleMethodCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:146:1: ruleMethodCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:153:1: ruleMethodCategories : ( ( rule__MethodCategories__Group__0 ) ) ;
    public final void ruleMethodCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:157:5: ( ( ( rule__MethodCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:158:1: ( ( rule__MethodCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:158:1: ( ( rule__MethodCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:159:1: ( rule__MethodCategories__Group__0 )
            {
             before(grammarAccess.getMethodCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:160:1: ( rule__MethodCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:160:2: rule__MethodCategories__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:172:1: entryRuleSelectionCategories : ruleSelectionCategories EOF ;
    public final void entryRuleSelectionCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:173:1: ( ruleSelectionCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:174:1: ruleSelectionCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:181:1: ruleSelectionCategories : ( ( rule__SelectionCategories__Group__0 ) ) ;
    public final void ruleSelectionCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:185:5: ( ( ( rule__SelectionCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:186:1: ( ( rule__SelectionCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:186:1: ( ( rule__SelectionCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:187:1: ( rule__SelectionCategories__Group__0 )
            {
             before(grammarAccess.getSelectionCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:188:1: ( rule__SelectionCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:188:2: rule__SelectionCategories__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:200:1: entryRuleQualityCategories : ruleQualityCategories EOF ;
    public final void entryRuleQualityCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:201:1: ( ruleQualityCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:202:1: ruleQualityCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:209:1: ruleQualityCategories : ( ( rule__QualityCategories__Group__0 ) ) ;
    public final void ruleQualityCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:213:5: ( ( ( rule__QualityCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:214:1: ( ( rule__QualityCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:214:1: ( ( rule__QualityCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:215:1: ( rule__QualityCategories__Group__0 )
            {
             before(grammarAccess.getQualityCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:216:1: ( rule__QualityCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:216:2: rule__QualityCategories__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:228:1: entryRulePhaseCategories : rulePhaseCategories EOF ;
    public final void entryRulePhaseCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:229:1: ( rulePhaseCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:230:1: rulePhaseCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:237:1: rulePhaseCategories : ( ( rule__PhaseCategories__Group__0 ) ) ;
    public final void rulePhaseCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:241:5: ( ( ( rule__PhaseCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:242:1: ( ( rule__PhaseCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:242:1: ( ( rule__PhaseCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:243:1: ( rule__PhaseCategories__Group__0 )
            {
             before(grammarAccess.getPhaseCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:244:1: ( rule__PhaseCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:244:2: rule__PhaseCategories__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:256:1: entryRuleComponentCategories : ruleComponentCategories EOF ;
    public final void entryRuleComponentCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:257:1: ( ruleComponentCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:258:1: ruleComponentCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:265:1: ruleComponentCategories : ( ( rule__ComponentCategories__Group__0 ) ) ;
    public final void ruleComponentCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:269:5: ( ( ( rule__ComponentCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:270:1: ( ( rule__ComponentCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:270:1: ( ( rule__ComponentCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:271:1: ( rule__ComponentCategories__Group__0 )
            {
             before(grammarAccess.getComponentCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:272:1: ( rule__ComponentCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:272:2: rule__ComponentCategories__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:284:1: entryRuleRequirementCategory : ruleRequirementCategory EOF ;
    public final void entryRuleRequirementCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:285:1: ( ruleRequirementCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:286:1: ruleRequirementCategory EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:293:1: ruleRequirementCategory : ( ( rule__RequirementCategory__Group__0 ) ) ;
    public final void ruleRequirementCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:297:5: ( ( ( rule__RequirementCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:298:1: ( ( rule__RequirementCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:298:1: ( ( rule__RequirementCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:299:1: ( rule__RequirementCategory__Group__0 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:300:1: ( rule__RequirementCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:300:2: rule__RequirementCategory__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:312:1: entryRuleMethodCategory : ruleMethodCategory EOF ;
    public final void entryRuleMethodCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:313:1: ( ruleMethodCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:314:1: ruleMethodCategory EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:321:1: ruleMethodCategory : ( ( rule__MethodCategory__Group__0 ) ) ;
    public final void ruleMethodCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:325:5: ( ( ( rule__MethodCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:326:1: ( ( rule__MethodCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:326:1: ( ( rule__MethodCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:327:1: ( rule__MethodCategory__Group__0 )
            {
             before(grammarAccess.getMethodCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:328:1: ( rule__MethodCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:328:2: rule__MethodCategory__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:340:1: entryRuleSelectionCategory : ruleSelectionCategory EOF ;
    public final void entryRuleSelectionCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:341:1: ( ruleSelectionCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:342:1: ruleSelectionCategory EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:349:1: ruleSelectionCategory : ( ( rule__SelectionCategory__Group__0 ) ) ;
    public final void ruleSelectionCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:353:5: ( ( ( rule__SelectionCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:354:1: ( ( rule__SelectionCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:354:1: ( ( rule__SelectionCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:355:1: ( rule__SelectionCategory__Group__0 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:356:1: ( rule__SelectionCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:356:2: rule__SelectionCategory__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:368:1: entryRuleQualityCategory : ruleQualityCategory EOF ;
    public final void entryRuleQualityCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:369:1: ( ruleQualityCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:370:1: ruleQualityCategory EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:377:1: ruleQualityCategory : ( ( rule__QualityCategory__Group__0 ) ) ;
    public final void ruleQualityCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:381:5: ( ( ( rule__QualityCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:382:1: ( ( rule__QualityCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:382:1: ( ( rule__QualityCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:383:1: ( rule__QualityCategory__Group__0 )
            {
             before(grammarAccess.getQualityCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:384:1: ( rule__QualityCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:384:2: rule__QualityCategory__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:396:1: entryRulePhaseCategory : rulePhaseCategory EOF ;
    public final void entryRulePhaseCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:397:1: ( rulePhaseCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:398:1: rulePhaseCategory EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:405:1: rulePhaseCategory : ( ( rule__PhaseCategory__Group__0 ) ) ;
    public final void rulePhaseCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:409:5: ( ( ( rule__PhaseCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:410:1: ( ( rule__PhaseCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:410:1: ( ( rule__PhaseCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:411:1: ( rule__PhaseCategory__Group__0 )
            {
             before(grammarAccess.getPhaseCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:412:1: ( rule__PhaseCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:412:2: rule__PhaseCategory__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:424:1: entryRuleComponentCategory : ruleComponentCategory EOF ;
    public final void entryRuleComponentCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:425:1: ( ruleComponentCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:426:1: ruleComponentCategory EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:433:1: ruleComponentCategory : ( ( rule__ComponentCategory__Group__0 ) ) ;
    public final void ruleComponentCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:437:5: ( ( ( rule__ComponentCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:438:1: ( ( rule__ComponentCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:438:1: ( ( rule__ComponentCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:439:1: ( rule__ComponentCategory__Group__0 )
            {
             before(grammarAccess.getComponentCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:440:1: ( rule__ComponentCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:440:2: rule__ComponentCategory__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:452:1: entryRuleCategoryFilters : ruleCategoryFilters EOF ;
    public final void entryRuleCategoryFilters() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:453:1: ( ruleCategoryFilters EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:454:1: ruleCategoryFilters EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:461:1: ruleCategoryFilters : ( ( rule__CategoryFilters__Group__0 ) ) ;
    public final void ruleCategoryFilters() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:465:5: ( ( ( rule__CategoryFilters__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:466:1: ( ( rule__CategoryFilters__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:466:1: ( ( rule__CategoryFilters__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:467:1: ( rule__CategoryFilters__Group__0 )
            {
             before(grammarAccess.getCategoryFiltersAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:468:1: ( rule__CategoryFilters__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:468:2: rule__CategoryFilters__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:480:1: entryRuleCategorySet : ruleCategorySet EOF ;
    public final void entryRuleCategorySet() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:481:1: ( ruleCategorySet EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:482:1: ruleCategorySet EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:489:1: ruleCategorySet : ( ( rule__CategorySet__Group__0 ) ) ;
    public final void ruleCategorySet() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:493:5: ( ( ( rule__CategorySet__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:494:1: ( ( rule__CategorySet__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:494:1: ( ( rule__CategorySet__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:495:1: ( rule__CategorySet__Group__0 )
            {
             before(grammarAccess.getCategorySetAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:496:1: ( rule__CategorySet__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:496:2: rule__CategorySet__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:508:1: entryRuleCatRef : ruleCatRef EOF ;
    public final void entryRuleCatRef() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:509:1: ( ruleCatRef EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:510:1: ruleCatRef EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:517:1: ruleCatRef : ( RULE_ID ) ;
    public final void ruleCatRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:521:5: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:522:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:522:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:523:1: RULE_ID
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:538:1: rule__RequirementCategories__Group__0 : rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 ;
    public final void rule__RequirementCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:542:1: ( rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:543:2: rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:550:1: rule__RequirementCategories__Group__0__Impl : ( () ) ;
    public final void rule__RequirementCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:554:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:555:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:555:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:556:1: ()
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRequirementCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:557:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:559:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:569:1: rule__RequirementCategories__Group__1 : rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 ;
    public final void rule__RequirementCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:573:1: ( rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:574:2: rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:581:1: rule__RequirementCategories__Group__1__Impl : ( Requirement ) ;
    public final void rule__RequirementCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:585:1: ( ( Requirement ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:586:1: ( Requirement )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:586:1: ( Requirement )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:587:1: Requirement
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:600:1: rule__RequirementCategories__Group__2 : rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 ;
    public final void rule__RequirementCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:604:1: ( rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:605:2: rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:612:1: rule__RequirementCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__RequirementCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:616:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:617:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:617:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:618:1: Categories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:631:1: rule__RequirementCategories__Group__3 : rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 ;
    public final void rule__RequirementCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:635:1: ( rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:636:2: rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:643:1: rule__RequirementCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__RequirementCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:647:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:648:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:648:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:649:1: LeftSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:662:1: rule__RequirementCategories__Group__4 : rule__RequirementCategories__Group__4__Impl rule__RequirementCategories__Group__5 ;
    public final void rule__RequirementCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:666:1: ( rule__RequirementCategories__Group__4__Impl rule__RequirementCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:667:2: rule__RequirementCategories__Group__4__Impl rule__RequirementCategories__Group__5
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:674:1: rule__RequirementCategories__Group__4__Impl : ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__RequirementCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:678:1: ( ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:679:1: ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:679:1: ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:680:1: ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:680:1: ( ( rule__RequirementCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:681:1: ( rule__RequirementCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:682:1: ( rule__RequirementCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:682:2: rule__RequirementCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_4_in_rule__RequirementCategories__Group__4__Impl1363);
            rule__RequirementCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:685:1: ( ( rule__RequirementCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:686:1: ( rule__RequirementCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:687:1: ( rule__RequirementCategories__CategoryAssignment_4 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:687:2: rule__RequirementCategories__CategoryAssignment_4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:698:1: rule__RequirementCategories__Group__5 : rule__RequirementCategories__Group__5__Impl ;
    public final void rule__RequirementCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:702:1: ( rule__RequirementCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:703:2: rule__RequirementCategories__Group__5__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:709:1: rule__RequirementCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__RequirementCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:713:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:714:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:714:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:715:1: RightSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:740:1: rule__MethodCategories__Group__0 : rule__MethodCategories__Group__0__Impl rule__MethodCategories__Group__1 ;
    public final void rule__MethodCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:744:1: ( rule__MethodCategories__Group__0__Impl rule__MethodCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:745:2: rule__MethodCategories__Group__0__Impl rule__MethodCategories__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:752:1: rule__MethodCategories__Group__0__Impl : ( () ) ;
    public final void rule__MethodCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:756:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:757:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:757:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:758:1: ()
            {
             before(grammarAccess.getMethodCategoriesAccess().getMethodCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:759:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:761:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:771:1: rule__MethodCategories__Group__1 : rule__MethodCategories__Group__1__Impl rule__MethodCategories__Group__2 ;
    public final void rule__MethodCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:775:1: ( rule__MethodCategories__Group__1__Impl rule__MethodCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:776:2: rule__MethodCategories__Group__1__Impl rule__MethodCategories__Group__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:783:1: rule__MethodCategories__Group__1__Impl : ( Method ) ;
    public final void rule__MethodCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:787:1: ( ( Method ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:788:1: ( Method )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:788:1: ( Method )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:789:1: Method
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:802:1: rule__MethodCategories__Group__2 : rule__MethodCategories__Group__2__Impl rule__MethodCategories__Group__3 ;
    public final void rule__MethodCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:806:1: ( rule__MethodCategories__Group__2__Impl rule__MethodCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:807:2: rule__MethodCategories__Group__2__Impl rule__MethodCategories__Group__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:814:1: rule__MethodCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__MethodCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:818:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:819:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:819:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:820:1: Categories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:833:1: rule__MethodCategories__Group__3 : rule__MethodCategories__Group__3__Impl rule__MethodCategories__Group__4 ;
    public final void rule__MethodCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:837:1: ( rule__MethodCategories__Group__3__Impl rule__MethodCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:838:2: rule__MethodCategories__Group__3__Impl rule__MethodCategories__Group__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:845:1: rule__MethodCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__MethodCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:849:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:850:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:850:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:851:1: LeftSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:864:1: rule__MethodCategories__Group__4 : rule__MethodCategories__Group__4__Impl rule__MethodCategories__Group__5 ;
    public final void rule__MethodCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:868:1: ( rule__MethodCategories__Group__4__Impl rule__MethodCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:869:2: rule__MethodCategories__Group__4__Impl rule__MethodCategories__Group__5
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:876:1: rule__MethodCategories__Group__4__Impl : ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__MethodCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:880:1: ( ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:881:1: ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:881:1: ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:882:1: ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:882:1: ( ( rule__MethodCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:883:1: ( rule__MethodCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:884:1: ( rule__MethodCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:884:2: rule__MethodCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__MethodCategories__CategoryAssignment_4_in_rule__MethodCategories__Group__4__Impl1758);
            rule__MethodCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:887:1: ( ( rule__MethodCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:888:1: ( rule__MethodCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:889:1: ( rule__MethodCategories__CategoryAssignment_4 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:889:2: rule__MethodCategories__CategoryAssignment_4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:900:1: rule__MethodCategories__Group__5 : rule__MethodCategories__Group__5__Impl ;
    public final void rule__MethodCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:904:1: ( rule__MethodCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:905:2: rule__MethodCategories__Group__5__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:911:1: rule__MethodCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__MethodCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:915:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:916:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:916:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:917:1: RightSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:942:1: rule__SelectionCategories__Group__0 : rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1 ;
    public final void rule__SelectionCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:946:1: ( rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:947:2: rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:954:1: rule__SelectionCategories__Group__0__Impl : ( () ) ;
    public final void rule__SelectionCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:958:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:959:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:959:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:960:1: ()
            {
             before(grammarAccess.getSelectionCategoriesAccess().getSelectionCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:961:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:963:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:973:1: rule__SelectionCategories__Group__1 : rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2 ;
    public final void rule__SelectionCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:977:1: ( rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:978:2: rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:985:1: rule__SelectionCategories__Group__1__Impl : ( Selection ) ;
    public final void rule__SelectionCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:989:1: ( ( Selection ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:990:1: ( Selection )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:990:1: ( Selection )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:991:1: Selection
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1004:1: rule__SelectionCategories__Group__2 : rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3 ;
    public final void rule__SelectionCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1008:1: ( rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1009:2: rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1016:1: rule__SelectionCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__SelectionCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1020:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1021:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1021:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1022:1: Categories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1035:1: rule__SelectionCategories__Group__3 : rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4 ;
    public final void rule__SelectionCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1039:1: ( rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1040:2: rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1047:1: rule__SelectionCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__SelectionCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1051:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1052:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1052:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1053:1: LeftSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1066:1: rule__SelectionCategories__Group__4 : rule__SelectionCategories__Group__4__Impl rule__SelectionCategories__Group__5 ;
    public final void rule__SelectionCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1070:1: ( rule__SelectionCategories__Group__4__Impl rule__SelectionCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1071:2: rule__SelectionCategories__Group__4__Impl rule__SelectionCategories__Group__5
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1078:1: rule__SelectionCategories__Group__4__Impl : ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__SelectionCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1082:1: ( ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1083:1: ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1083:1: ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1084:1: ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1084:1: ( ( rule__SelectionCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1085:1: ( rule__SelectionCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1086:1: ( rule__SelectionCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1086:2: rule__SelectionCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__SelectionCategories__CategoryAssignment_4_in_rule__SelectionCategories__Group__4__Impl2153);
            rule__SelectionCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1089:1: ( ( rule__SelectionCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1090:1: ( rule__SelectionCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1091:1: ( rule__SelectionCategories__CategoryAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1091:2: rule__SelectionCategories__CategoryAssignment_4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1102:1: rule__SelectionCategories__Group__5 : rule__SelectionCategories__Group__5__Impl ;
    public final void rule__SelectionCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1106:1: ( rule__SelectionCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1107:2: rule__SelectionCategories__Group__5__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1113:1: rule__SelectionCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__SelectionCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1117:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1118:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1118:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1119:1: RightSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1144:1: rule__QualityCategories__Group__0 : rule__QualityCategories__Group__0__Impl rule__QualityCategories__Group__1 ;
    public final void rule__QualityCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1148:1: ( rule__QualityCategories__Group__0__Impl rule__QualityCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1149:2: rule__QualityCategories__Group__0__Impl rule__QualityCategories__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1156:1: rule__QualityCategories__Group__0__Impl : ( () ) ;
    public final void rule__QualityCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1160:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1161:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1161:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1162:1: ()
            {
             before(grammarAccess.getQualityCategoriesAccess().getQualityCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1163:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1165:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1175:1: rule__QualityCategories__Group__1 : rule__QualityCategories__Group__1__Impl rule__QualityCategories__Group__2 ;
    public final void rule__QualityCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1179:1: ( rule__QualityCategories__Group__1__Impl rule__QualityCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1180:2: rule__QualityCategories__Group__1__Impl rule__QualityCategories__Group__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1187:1: rule__QualityCategories__Group__1__Impl : ( Quality ) ;
    public final void rule__QualityCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1191:1: ( ( Quality ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1192:1: ( Quality )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1192:1: ( Quality )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1193:1: Quality
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1206:1: rule__QualityCategories__Group__2 : rule__QualityCategories__Group__2__Impl rule__QualityCategories__Group__3 ;
    public final void rule__QualityCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1210:1: ( rule__QualityCategories__Group__2__Impl rule__QualityCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1211:2: rule__QualityCategories__Group__2__Impl rule__QualityCategories__Group__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1218:1: rule__QualityCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__QualityCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1222:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1223:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1223:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1224:1: Categories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1237:1: rule__QualityCategories__Group__3 : rule__QualityCategories__Group__3__Impl rule__QualityCategories__Group__4 ;
    public final void rule__QualityCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1241:1: ( rule__QualityCategories__Group__3__Impl rule__QualityCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1242:2: rule__QualityCategories__Group__3__Impl rule__QualityCategories__Group__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1249:1: rule__QualityCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__QualityCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1253:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1254:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1254:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1255:1: LeftSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1268:1: rule__QualityCategories__Group__4 : rule__QualityCategories__Group__4__Impl rule__QualityCategories__Group__5 ;
    public final void rule__QualityCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1272:1: ( rule__QualityCategories__Group__4__Impl rule__QualityCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1273:2: rule__QualityCategories__Group__4__Impl rule__QualityCategories__Group__5
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1280:1: rule__QualityCategories__Group__4__Impl : ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__QualityCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1284:1: ( ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1285:1: ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1285:1: ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1286:1: ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1286:1: ( ( rule__QualityCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1287:1: ( rule__QualityCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1288:1: ( rule__QualityCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1288:2: rule__QualityCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__QualityCategories__CategoryAssignment_4_in_rule__QualityCategories__Group__4__Impl2548);
            rule__QualityCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1291:1: ( ( rule__QualityCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1292:1: ( rule__QualityCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1293:1: ( rule__QualityCategories__CategoryAssignment_4 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1293:2: rule__QualityCategories__CategoryAssignment_4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1304:1: rule__QualityCategories__Group__5 : rule__QualityCategories__Group__5__Impl ;
    public final void rule__QualityCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1308:1: ( rule__QualityCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1309:2: rule__QualityCategories__Group__5__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1315:1: rule__QualityCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__QualityCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1319:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1320:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1320:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1321:1: RightSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1346:1: rule__PhaseCategories__Group__0 : rule__PhaseCategories__Group__0__Impl rule__PhaseCategories__Group__1 ;
    public final void rule__PhaseCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1350:1: ( rule__PhaseCategories__Group__0__Impl rule__PhaseCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1351:2: rule__PhaseCategories__Group__0__Impl rule__PhaseCategories__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1358:1: rule__PhaseCategories__Group__0__Impl : ( () ) ;
    public final void rule__PhaseCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1362:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1363:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1363:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1364:1: ()
            {
             before(grammarAccess.getPhaseCategoriesAccess().getQualityCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1365:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1367:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1377:1: rule__PhaseCategories__Group__1 : rule__PhaseCategories__Group__1__Impl rule__PhaseCategories__Group__2 ;
    public final void rule__PhaseCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1381:1: ( rule__PhaseCategories__Group__1__Impl rule__PhaseCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1382:2: rule__PhaseCategories__Group__1__Impl rule__PhaseCategories__Group__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1389:1: rule__PhaseCategories__Group__1__Impl : ( Phase ) ;
    public final void rule__PhaseCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1393:1: ( ( Phase ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1394:1: ( Phase )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1394:1: ( Phase )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1395:1: Phase
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1408:1: rule__PhaseCategories__Group__2 : rule__PhaseCategories__Group__2__Impl rule__PhaseCategories__Group__3 ;
    public final void rule__PhaseCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1412:1: ( rule__PhaseCategories__Group__2__Impl rule__PhaseCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1413:2: rule__PhaseCategories__Group__2__Impl rule__PhaseCategories__Group__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1420:1: rule__PhaseCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__PhaseCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1424:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1425:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1425:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1426:1: Categories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1439:1: rule__PhaseCategories__Group__3 : rule__PhaseCategories__Group__3__Impl rule__PhaseCategories__Group__4 ;
    public final void rule__PhaseCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1443:1: ( rule__PhaseCategories__Group__3__Impl rule__PhaseCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1444:2: rule__PhaseCategories__Group__3__Impl rule__PhaseCategories__Group__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1451:1: rule__PhaseCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__PhaseCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1455:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1456:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1456:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1457:1: LeftSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1470:1: rule__PhaseCategories__Group__4 : rule__PhaseCategories__Group__4__Impl rule__PhaseCategories__Group__5 ;
    public final void rule__PhaseCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1474:1: ( rule__PhaseCategories__Group__4__Impl rule__PhaseCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1475:2: rule__PhaseCategories__Group__4__Impl rule__PhaseCategories__Group__5
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1482:1: rule__PhaseCategories__Group__4__Impl : ( ( ( rule__PhaseCategories__CategoryAssignment_4 ) ) ( ( rule__PhaseCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__PhaseCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1486:1: ( ( ( ( rule__PhaseCategories__CategoryAssignment_4 ) ) ( ( rule__PhaseCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1487:1: ( ( ( rule__PhaseCategories__CategoryAssignment_4 ) ) ( ( rule__PhaseCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1487:1: ( ( ( rule__PhaseCategories__CategoryAssignment_4 ) ) ( ( rule__PhaseCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1488:1: ( ( rule__PhaseCategories__CategoryAssignment_4 ) ) ( ( rule__PhaseCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1488:1: ( ( rule__PhaseCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1489:1: ( rule__PhaseCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1490:1: ( rule__PhaseCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1490:2: rule__PhaseCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__PhaseCategories__CategoryAssignment_4_in_rule__PhaseCategories__Group__4__Impl2943);
            rule__PhaseCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1493:1: ( ( rule__PhaseCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1494:1: ( rule__PhaseCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1495:1: ( rule__PhaseCategories__CategoryAssignment_4 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1495:2: rule__PhaseCategories__CategoryAssignment_4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1506:1: rule__PhaseCategories__Group__5 : rule__PhaseCategories__Group__5__Impl ;
    public final void rule__PhaseCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1510:1: ( rule__PhaseCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1511:2: rule__PhaseCategories__Group__5__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1517:1: rule__PhaseCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__PhaseCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1521:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1522:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1522:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1523:1: RightSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1548:1: rule__ComponentCategories__Group__0 : rule__ComponentCategories__Group__0__Impl rule__ComponentCategories__Group__1 ;
    public final void rule__ComponentCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1552:1: ( rule__ComponentCategories__Group__0__Impl rule__ComponentCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1553:2: rule__ComponentCategories__Group__0__Impl rule__ComponentCategories__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1560:1: rule__ComponentCategories__Group__0__Impl : ( () ) ;
    public final void rule__ComponentCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1564:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1565:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1565:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1566:1: ()
            {
             before(grammarAccess.getComponentCategoriesAccess().getComponentCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1567:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1569:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1579:1: rule__ComponentCategories__Group__1 : rule__ComponentCategories__Group__1__Impl rule__ComponentCategories__Group__2 ;
    public final void rule__ComponentCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1583:1: ( rule__ComponentCategories__Group__1__Impl rule__ComponentCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1584:2: rule__ComponentCategories__Group__1__Impl rule__ComponentCategories__Group__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1591:1: rule__ComponentCategories__Group__1__Impl : ( Component ) ;
    public final void rule__ComponentCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1595:1: ( ( Component ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1596:1: ( Component )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1596:1: ( Component )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1597:1: Component
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1610:1: rule__ComponentCategories__Group__2 : rule__ComponentCategories__Group__2__Impl rule__ComponentCategories__Group__3 ;
    public final void rule__ComponentCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1614:1: ( rule__ComponentCategories__Group__2__Impl rule__ComponentCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1615:2: rule__ComponentCategories__Group__2__Impl rule__ComponentCategories__Group__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1622:1: rule__ComponentCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__ComponentCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1626:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1627:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1627:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1628:1: Categories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1641:1: rule__ComponentCategories__Group__3 : rule__ComponentCategories__Group__3__Impl rule__ComponentCategories__Group__4 ;
    public final void rule__ComponentCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1645:1: ( rule__ComponentCategories__Group__3__Impl rule__ComponentCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1646:2: rule__ComponentCategories__Group__3__Impl rule__ComponentCategories__Group__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1653:1: rule__ComponentCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__ComponentCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1657:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1658:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1658:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1659:1: LeftSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1672:1: rule__ComponentCategories__Group__4 : rule__ComponentCategories__Group__4__Impl rule__ComponentCategories__Group__5 ;
    public final void rule__ComponentCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1676:1: ( rule__ComponentCategories__Group__4__Impl rule__ComponentCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1677:2: rule__ComponentCategories__Group__4__Impl rule__ComponentCategories__Group__5
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1684:1: rule__ComponentCategories__Group__4__Impl : ( ( ( rule__ComponentCategories__CategoryAssignment_4 ) ) ( ( rule__ComponentCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__ComponentCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1688:1: ( ( ( ( rule__ComponentCategories__CategoryAssignment_4 ) ) ( ( rule__ComponentCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1689:1: ( ( ( rule__ComponentCategories__CategoryAssignment_4 ) ) ( ( rule__ComponentCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1689:1: ( ( ( rule__ComponentCategories__CategoryAssignment_4 ) ) ( ( rule__ComponentCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1690:1: ( ( rule__ComponentCategories__CategoryAssignment_4 ) ) ( ( rule__ComponentCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1690:1: ( ( rule__ComponentCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1691:1: ( rule__ComponentCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getComponentCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1692:1: ( rule__ComponentCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1692:2: rule__ComponentCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__ComponentCategories__CategoryAssignment_4_in_rule__ComponentCategories__Group__4__Impl3338);
            rule__ComponentCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getComponentCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1695:1: ( ( rule__ComponentCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1696:1: ( rule__ComponentCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getComponentCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1697:1: ( rule__ComponentCategories__CategoryAssignment_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1697:2: rule__ComponentCategories__CategoryAssignment_4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1708:1: rule__ComponentCategories__Group__5 : rule__ComponentCategories__Group__5__Impl ;
    public final void rule__ComponentCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1712:1: ( rule__ComponentCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1713:2: rule__ComponentCategories__Group__5__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1719:1: rule__ComponentCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__ComponentCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1723:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1724:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1724:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1725:1: RightSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1750:1: rule__RequirementCategory__Group__0 : rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 ;
    public final void rule__RequirementCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1754:1: ( rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1755:2: rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1762:1: rule__RequirementCategory__Group__0__Impl : ( () ) ;
    public final void rule__RequirementCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1766:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1767:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1767:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1768:1: ()
            {
             before(grammarAccess.getRequirementCategoryAccess().getRequirementCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1769:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1771:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1781:1: rule__RequirementCategory__Group__1 : rule__RequirementCategory__Group__1__Impl ;
    public final void rule__RequirementCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1785:1: ( rule__RequirementCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1786:2: rule__RequirementCategory__Group__1__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1792:1: rule__RequirementCategory__Group__1__Impl : ( ( rule__RequirementCategory__NameAssignment_1 ) ) ;
    public final void rule__RequirementCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1796:1: ( ( ( rule__RequirementCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1797:1: ( ( rule__RequirementCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1797:1: ( ( rule__RequirementCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1798:1: ( rule__RequirementCategory__NameAssignment_1 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1799:1: ( rule__RequirementCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1799:2: rule__RequirementCategory__NameAssignment_1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1813:1: rule__MethodCategory__Group__0 : rule__MethodCategory__Group__0__Impl rule__MethodCategory__Group__1 ;
    public final void rule__MethodCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1817:1: ( rule__MethodCategory__Group__0__Impl rule__MethodCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1818:2: rule__MethodCategory__Group__0__Impl rule__MethodCategory__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1825:1: rule__MethodCategory__Group__0__Impl : ( () ) ;
    public final void rule__MethodCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1829:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1830:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1830:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1831:1: ()
            {
             before(grammarAccess.getMethodCategoryAccess().getMethodCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1832:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1834:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1844:1: rule__MethodCategory__Group__1 : rule__MethodCategory__Group__1__Impl ;
    public final void rule__MethodCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1848:1: ( rule__MethodCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1849:2: rule__MethodCategory__Group__1__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1855:1: rule__MethodCategory__Group__1__Impl : ( ( rule__MethodCategory__NameAssignment_1 ) ) ;
    public final void rule__MethodCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1859:1: ( ( ( rule__MethodCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1860:1: ( ( rule__MethodCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1860:1: ( ( rule__MethodCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1861:1: ( rule__MethodCategory__NameAssignment_1 )
            {
             before(grammarAccess.getMethodCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1862:1: ( rule__MethodCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1862:2: rule__MethodCategory__NameAssignment_1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1876:1: rule__SelectionCategory__Group__0 : rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1 ;
    public final void rule__SelectionCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1880:1: ( rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1881:2: rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1888:1: rule__SelectionCategory__Group__0__Impl : ( () ) ;
    public final void rule__SelectionCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1892:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1893:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1893:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1894:1: ()
            {
             before(grammarAccess.getSelectionCategoryAccess().getSelectionCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1895:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1897:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1907:1: rule__SelectionCategory__Group__1 : rule__SelectionCategory__Group__1__Impl ;
    public final void rule__SelectionCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1911:1: ( rule__SelectionCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1912:2: rule__SelectionCategory__Group__1__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1918:1: rule__SelectionCategory__Group__1__Impl : ( ( rule__SelectionCategory__NameAssignment_1 ) ) ;
    public final void rule__SelectionCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1922:1: ( ( ( rule__SelectionCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1923:1: ( ( rule__SelectionCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1923:1: ( ( rule__SelectionCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1924:1: ( rule__SelectionCategory__NameAssignment_1 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1925:1: ( rule__SelectionCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1925:2: rule__SelectionCategory__NameAssignment_1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1939:1: rule__QualityCategory__Group__0 : rule__QualityCategory__Group__0__Impl rule__QualityCategory__Group__1 ;
    public final void rule__QualityCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1943:1: ( rule__QualityCategory__Group__0__Impl rule__QualityCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1944:2: rule__QualityCategory__Group__0__Impl rule__QualityCategory__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1951:1: rule__QualityCategory__Group__0__Impl : ( () ) ;
    public final void rule__QualityCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1955:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1956:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1956:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1957:1: ()
            {
             before(grammarAccess.getQualityCategoryAccess().getQualityCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1958:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1960:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1970:1: rule__QualityCategory__Group__1 : rule__QualityCategory__Group__1__Impl ;
    public final void rule__QualityCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1974:1: ( rule__QualityCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1975:2: rule__QualityCategory__Group__1__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1981:1: rule__QualityCategory__Group__1__Impl : ( ( rule__QualityCategory__NameAssignment_1 ) ) ;
    public final void rule__QualityCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1985:1: ( ( ( rule__QualityCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1986:1: ( ( rule__QualityCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1986:1: ( ( rule__QualityCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1987:1: ( rule__QualityCategory__NameAssignment_1 )
            {
             before(grammarAccess.getQualityCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1988:1: ( rule__QualityCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1988:2: rule__QualityCategory__NameAssignment_1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2002:1: rule__PhaseCategory__Group__0 : rule__PhaseCategory__Group__0__Impl rule__PhaseCategory__Group__1 ;
    public final void rule__PhaseCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2006:1: ( rule__PhaseCategory__Group__0__Impl rule__PhaseCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2007:2: rule__PhaseCategory__Group__0__Impl rule__PhaseCategory__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2014:1: rule__PhaseCategory__Group__0__Impl : ( () ) ;
    public final void rule__PhaseCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2018:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2019:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2019:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2020:1: ()
            {
             before(grammarAccess.getPhaseCategoryAccess().getPhaseCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2021:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2023:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2033:1: rule__PhaseCategory__Group__1 : rule__PhaseCategory__Group__1__Impl ;
    public final void rule__PhaseCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2037:1: ( rule__PhaseCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2038:2: rule__PhaseCategory__Group__1__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2044:1: rule__PhaseCategory__Group__1__Impl : ( ( rule__PhaseCategory__NameAssignment_1 ) ) ;
    public final void rule__PhaseCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2048:1: ( ( ( rule__PhaseCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2049:1: ( ( rule__PhaseCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2049:1: ( ( rule__PhaseCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2050:1: ( rule__PhaseCategory__NameAssignment_1 )
            {
             before(grammarAccess.getPhaseCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2051:1: ( rule__PhaseCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2051:2: rule__PhaseCategory__NameAssignment_1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2065:1: rule__ComponentCategory__Group__0 : rule__ComponentCategory__Group__0__Impl rule__ComponentCategory__Group__1 ;
    public final void rule__ComponentCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2069:1: ( rule__ComponentCategory__Group__0__Impl rule__ComponentCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2070:2: rule__ComponentCategory__Group__0__Impl rule__ComponentCategory__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2077:1: rule__ComponentCategory__Group__0__Impl : ( () ) ;
    public final void rule__ComponentCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2081:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2082:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2082:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2083:1: ()
            {
             before(grammarAccess.getComponentCategoryAccess().getComponentCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2084:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2086:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2096:1: rule__ComponentCategory__Group__1 : rule__ComponentCategory__Group__1__Impl ;
    public final void rule__ComponentCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2100:1: ( rule__ComponentCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2101:2: rule__ComponentCategory__Group__1__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2107:1: rule__ComponentCategory__Group__1__Impl : ( ( rule__ComponentCategory__NameAssignment_1 ) ) ;
    public final void rule__ComponentCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2111:1: ( ( ( rule__ComponentCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2112:1: ( ( rule__ComponentCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2112:1: ( ( rule__ComponentCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2113:1: ( rule__ComponentCategory__NameAssignment_1 )
            {
             before(grammarAccess.getComponentCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2114:1: ( rule__ComponentCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2114:2: rule__ComponentCategory__NameAssignment_1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2128:1: rule__CategoryFilters__Group__0 : rule__CategoryFilters__Group__0__Impl rule__CategoryFilters__Group__1 ;
    public final void rule__CategoryFilters__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2132:1: ( rule__CategoryFilters__Group__0__Impl rule__CategoryFilters__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2133:2: rule__CategoryFilters__Group__0__Impl rule__CategoryFilters__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2140:1: rule__CategoryFilters__Group__0__Impl : ( Category ) ;
    public final void rule__CategoryFilters__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2144:1: ( ( Category ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2145:1: ( Category )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2145:1: ( Category )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2146:1: Category
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2159:1: rule__CategoryFilters__Group__1 : rule__CategoryFilters__Group__1__Impl rule__CategoryFilters__Group__2 ;
    public final void rule__CategoryFilters__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2163:1: ( rule__CategoryFilters__Group__1__Impl rule__CategoryFilters__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2164:2: rule__CategoryFilters__Group__1__Impl rule__CategoryFilters__Group__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2171:1: rule__CategoryFilters__Group__1__Impl : ( Filters ) ;
    public final void rule__CategoryFilters__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2175:1: ( ( Filters ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2176:1: ( Filters )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2176:1: ( Filters )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2177:1: Filters
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2190:1: rule__CategoryFilters__Group__2 : rule__CategoryFilters__Group__2__Impl rule__CategoryFilters__Group__3 ;
    public final void rule__CategoryFilters__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2194:1: ( rule__CategoryFilters__Group__2__Impl rule__CategoryFilters__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2195:2: rule__CategoryFilters__Group__2__Impl rule__CategoryFilters__Group__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2202:1: rule__CategoryFilters__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__CategoryFilters__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2206:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2207:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2207:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2208:1: LeftSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2221:1: rule__CategoryFilters__Group__3 : rule__CategoryFilters__Group__3__Impl rule__CategoryFilters__Group__4 ;
    public final void rule__CategoryFilters__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2225:1: ( rule__CategoryFilters__Group__3__Impl rule__CategoryFilters__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2226:2: rule__CategoryFilters__Group__3__Impl rule__CategoryFilters__Group__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2233:1: rule__CategoryFilters__Group__3__Impl : ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) ) ;
    public final void rule__CategoryFilters__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2237:1: ( ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2238:1: ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2238:1: ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2239:1: ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2239:1: ( ( rule__CategoryFilters__FiltersAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2240:1: ( rule__CategoryFilters__FiltersAssignment_3 )
            {
             before(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2241:1: ( rule__CategoryFilters__FiltersAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2241:2: rule__CategoryFilters__FiltersAssignment_3
            {
            pushFollow(FOLLOW_rule__CategoryFilters__FiltersAssignment_3_in_rule__CategoryFilters__Group__3__Impl4404);
            rule__CategoryFilters__FiltersAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2244:1: ( ( rule__CategoryFilters__FiltersAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2245:1: ( rule__CategoryFilters__FiltersAssignment_3 )*
            {
             before(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2246:1: ( rule__CategoryFilters__FiltersAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2246:2: rule__CategoryFilters__FiltersAssignment_3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2257:1: rule__CategoryFilters__Group__4 : rule__CategoryFilters__Group__4__Impl ;
    public final void rule__CategoryFilters__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2261:1: ( rule__CategoryFilters__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2262:2: rule__CategoryFilters__Group__4__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2268:1: rule__CategoryFilters__Group__4__Impl : ( RightSquareBracket ) ;
    public final void rule__CategoryFilters__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2272:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2273:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2273:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2274:1: RightSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2297:1: rule__CategorySet__Group__0 : rule__CategorySet__Group__0__Impl rule__CategorySet__Group__1 ;
    public final void rule__CategorySet__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2301:1: ( rule__CategorySet__Group__0__Impl rule__CategorySet__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2302:2: rule__CategorySet__Group__0__Impl rule__CategorySet__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2309:1: rule__CategorySet__Group__0__Impl : ( () ) ;
    public final void rule__CategorySet__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2313:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2314:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2314:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2315:1: ()
            {
             before(grammarAccess.getCategorySetAccess().getCategorySetAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2316:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2318:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2328:1: rule__CategorySet__Group__1 : rule__CategorySet__Group__1__Impl rule__CategorySet__Group__2 ;
    public final void rule__CategorySet__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2332:1: ( rule__CategorySet__Group__1__Impl rule__CategorySet__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2333:2: rule__CategorySet__Group__1__Impl rule__CategorySet__Group__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2340:1: rule__CategorySet__Group__1__Impl : ( ( rule__CategorySet__NameAssignment_1 ) ) ;
    public final void rule__CategorySet__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2344:1: ( ( ( rule__CategorySet__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2345:1: ( ( rule__CategorySet__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2345:1: ( ( rule__CategorySet__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2346:1: ( rule__CategorySet__NameAssignment_1 )
            {
             before(grammarAccess.getCategorySetAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2347:1: ( rule__CategorySet__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2347:2: rule__CategorySet__NameAssignment_1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2357:1: rule__CategorySet__Group__2 : rule__CategorySet__Group__2__Impl rule__CategorySet__Group__3 ;
    public final void rule__CategorySet__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2361:1: ( rule__CategorySet__Group__2__Impl rule__CategorySet__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2362:2: rule__CategorySet__Group__2__Impl rule__CategorySet__Group__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2369:1: rule__CategorySet__Group__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__CategorySet__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2373:1: ( ( LeftCurlyBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2374:1: ( LeftCurlyBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2374:1: ( LeftCurlyBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2375:1: LeftCurlyBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2388:1: rule__CategorySet__Group__3 : rule__CategorySet__Group__3__Impl rule__CategorySet__Group__4 ;
    public final void rule__CategorySet__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2392:1: ( rule__CategorySet__Group__3__Impl rule__CategorySet__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2393:2: rule__CategorySet__Group__3__Impl rule__CategorySet__Group__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2400:1: rule__CategorySet__Group__3__Impl : ( ( rule__CategorySet__ElementsAssignment_3 )* ) ;
    public final void rule__CategorySet__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2404:1: ( ( ( rule__CategorySet__ElementsAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2405:1: ( ( rule__CategorySet__ElementsAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2405:1: ( ( rule__CategorySet__ElementsAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2406:1: ( rule__CategorySet__ElementsAssignment_3 )*
            {
             before(grammarAccess.getCategorySetAccess().getElementsAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2407:1: ( rule__CategorySet__ElementsAssignment_3 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2407:2: rule__CategorySet__ElementsAssignment_3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2417:1: rule__CategorySet__Group__4 : rule__CategorySet__Group__4__Impl ;
    public final void rule__CategorySet__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2421:1: ( rule__CategorySet__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2422:2: rule__CategorySet__Group__4__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2428:1: rule__CategorySet__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__CategorySet__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2432:1: ( ( RightCurlyBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2433:1: ( RightCurlyBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2433:1: ( RightCurlyBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2434:1: RightCurlyBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2458:1: rule__CategoriesDefinitions__UnorderedGroup : ( rule__CategoriesDefinitions__UnorderedGroup__0 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2463:1: ( ( rule__CategoriesDefinitions__UnorderedGroup__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2464:2: ( rule__CategoriesDefinitions__UnorderedGroup__0 )?
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2464:2: ( rule__CategoriesDefinitions__UnorderedGroup__0 )?
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2464:2: rule__CategoriesDefinitions__UnorderedGroup__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2474:1: rule__CategoriesDefinitions__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) ) ) ) ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2479:1: ( ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) ) ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2480:3: ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) ) ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2480:3: ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) ) ) )
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2482:4: ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2482:4: ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2483:5: {...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2483:116: ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2484:6: ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2490:6: ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2492:7: ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getRequirementcategoriesAssignment_0()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2493:7: ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2493:8: rule__CategoriesDefinitions__RequirementcategoriesAssignment_0
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2502:4: ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2502:4: ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2503:5: {...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2503:116: ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2504:6: ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2510:6: ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2512:7: ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getComponentcategoriesAssignment_1()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2513:7: ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2513:8: rule__CategoriesDefinitions__ComponentcategoriesAssignment_1
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2522:4: ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2522:4: ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2523:5: {...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2523:116: ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2524:6: ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2530:6: ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2532:7: ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesAssignment_2()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2533:7: ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2533:8: rule__CategoriesDefinitions__MethodcategoriesAssignment_2
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2542:4: ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2542:4: ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2543:5: {...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2543:116: ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2544:6: ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2550:6: ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2552:7: ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesAssignment_3()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2553:7: ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2553:8: rule__CategoriesDefinitions__SelectioncategoriesAssignment_3
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2562:4: ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2562:4: ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2563:5: {...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2563:116: ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2564:6: ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2570:6: ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2572:7: ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getPhasecategoriesAssignment_4()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2573:7: ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2573:8: rule__CategoriesDefinitions__PhasecategoriesAssignment_4
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2582:4: ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2582:4: ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2583:5: {...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2583:116: ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2584:6: ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2590:6: ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2592:7: ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesAssignment_5()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2593:7: ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2593:8: rule__CategoriesDefinitions__QualitycategoriesAssignment_5
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2602:4: ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2602:4: ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2603:5: {...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 6) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 6)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2603:116: ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2604:6: ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 6);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2610:6: ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2612:7: ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterAssignment_6()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2613:7: ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2613:8: rule__CategoriesDefinitions__CategoryfilterAssignment_6
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2631:1: rule__CategoriesDefinitions__UnorderedGroup__0 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2635:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2636:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__05573);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2637:2: ( rule__CategoriesDefinitions__UnorderedGroup__1 )?
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2637:2: rule__CategoriesDefinitions__UnorderedGroup__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2644:1: rule__CategoriesDefinitions__UnorderedGroup__1 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2648:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2649:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__15601);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2650:2: ( rule__CategoriesDefinitions__UnorderedGroup__2 )?
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2650:2: rule__CategoriesDefinitions__UnorderedGroup__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2657:1: rule__CategoriesDefinitions__UnorderedGroup__2 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__3 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2661:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__3 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2662:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__3 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__25629);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2663:2: ( rule__CategoriesDefinitions__UnorderedGroup__3 )?
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2663:2: rule__CategoriesDefinitions__UnorderedGroup__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2670:1: rule__CategoriesDefinitions__UnorderedGroup__3 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__4 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2674:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__4 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2675:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__4 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__35657);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2676:2: ( rule__CategoriesDefinitions__UnorderedGroup__4 )?
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2676:2: rule__CategoriesDefinitions__UnorderedGroup__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2683:1: rule__CategoriesDefinitions__UnorderedGroup__4 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__5 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2687:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__5 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2688:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__5 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__45685);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2689:2: ( rule__CategoriesDefinitions__UnorderedGroup__5 )?
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2689:2: rule__CategoriesDefinitions__UnorderedGroup__5
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2696:1: rule__CategoriesDefinitions__UnorderedGroup__5 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__6 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2700:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__6 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2701:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__6 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__55713);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2702:2: ( rule__CategoriesDefinitions__UnorderedGroup__6 )?
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2702:2: rule__CategoriesDefinitions__UnorderedGroup__6
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2709:1: rule__CategoriesDefinitions__UnorderedGroup__6 : rule__CategoriesDefinitions__UnorderedGroup__Impl ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2713:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2714:2: rule__CategoriesDefinitions__UnorderedGroup__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2735:1: rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 : ( ruleRequirementCategories ) ;
    public final void rule__CategoriesDefinitions__RequirementcategoriesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2739:1: ( ( ruleRequirementCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2740:1: ( ruleRequirementCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2740:1: ( ruleRequirementCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2741:1: ruleRequirementCategories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2750:1: rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 : ( ruleComponentCategories ) ;
    public final void rule__CategoriesDefinitions__ComponentcategoriesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2754:1: ( ( ruleComponentCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2755:1: ( ruleComponentCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2755:1: ( ruleComponentCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2756:1: ruleComponentCategories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2765:1: rule__CategoriesDefinitions__MethodcategoriesAssignment_2 : ( ruleMethodCategories ) ;
    public final void rule__CategoriesDefinitions__MethodcategoriesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2769:1: ( ( ruleMethodCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2770:1: ( ruleMethodCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2770:1: ( ruleMethodCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2771:1: ruleMethodCategories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2780:1: rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 : ( ruleSelectionCategories ) ;
    public final void rule__CategoriesDefinitions__SelectioncategoriesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2784:1: ( ( ruleSelectionCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2785:1: ( ruleSelectionCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2785:1: ( ruleSelectionCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2786:1: ruleSelectionCategories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2795:1: rule__CategoriesDefinitions__PhasecategoriesAssignment_4 : ( rulePhaseCategories ) ;
    public final void rule__CategoriesDefinitions__PhasecategoriesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2799:1: ( ( rulePhaseCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2800:1: ( rulePhaseCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2800:1: ( rulePhaseCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2801:1: rulePhaseCategories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2810:1: rule__CategoriesDefinitions__QualitycategoriesAssignment_5 : ( ruleQualityCategories ) ;
    public final void rule__CategoriesDefinitions__QualitycategoriesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2814:1: ( ( ruleQualityCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2815:1: ( ruleQualityCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2815:1: ( ruleQualityCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2816:1: ruleQualityCategories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2825:1: rule__CategoriesDefinitions__CategoryfilterAssignment_6 : ( ruleCategoryFilters ) ;
    public final void rule__CategoriesDefinitions__CategoryfilterAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2829:1: ( ( ruleCategoryFilters ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2830:1: ( ruleCategoryFilters )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2830:1: ( ruleCategoryFilters )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2831:1: ruleCategoryFilters
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2840:1: rule__RequirementCategories__CategoryAssignment_4 : ( ruleRequirementCategory ) ;
    public final void rule__RequirementCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2844:1: ( ( ruleRequirementCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2845:1: ( ruleRequirementCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2845:1: ( ruleRequirementCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2846:1: ruleRequirementCategory
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2855:1: rule__MethodCategories__CategoryAssignment_4 : ( ruleMethodCategory ) ;
    public final void rule__MethodCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2859:1: ( ( ruleMethodCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2860:1: ( ruleMethodCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2860:1: ( ruleMethodCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2861:1: ruleMethodCategory
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2870:1: rule__SelectionCategories__CategoryAssignment_4 : ( ruleSelectionCategory ) ;
    public final void rule__SelectionCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2874:1: ( ( ruleSelectionCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2875:1: ( ruleSelectionCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2875:1: ( ruleSelectionCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2876:1: ruleSelectionCategory
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2885:1: rule__QualityCategories__CategoryAssignment_4 : ( ruleQualityCategory ) ;
    public final void rule__QualityCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2889:1: ( ( ruleQualityCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2890:1: ( ruleQualityCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2890:1: ( ruleQualityCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2891:1: ruleQualityCategory
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2900:1: rule__PhaseCategories__CategoryAssignment_4 : ( rulePhaseCategory ) ;
    public final void rule__PhaseCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2904:1: ( ( rulePhaseCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2905:1: ( rulePhaseCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2905:1: ( rulePhaseCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2906:1: rulePhaseCategory
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2915:1: rule__ComponentCategories__CategoryAssignment_4 : ( ruleComponentCategory ) ;
    public final void rule__ComponentCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2919:1: ( ( ruleComponentCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2920:1: ( ruleComponentCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2920:1: ( ruleComponentCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2921:1: ruleComponentCategory
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2930:1: rule__RequirementCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RequirementCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2934:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2935:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2935:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2936:1: RULE_ID
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2945:1: rule__MethodCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__MethodCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2949:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2950:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2950:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2951:1: RULE_ID
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2960:1: rule__SelectionCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SelectionCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2964:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2965:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2965:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2966:1: RULE_ID
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2975:1: rule__QualityCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__QualityCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2979:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2980:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2980:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2981:1: RULE_ID
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2990:1: rule__PhaseCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PhaseCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2994:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2995:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2995:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2996:1: RULE_ID
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3005:1: rule__ComponentCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ComponentCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3009:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3010:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3010:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3011:1: RULE_ID
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3020:1: rule__CategoryFilters__FiltersAssignment_3 : ( ruleCategorySet ) ;
    public final void rule__CategoryFilters__FiltersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3024:1: ( ( ruleCategorySet ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3025:1: ( ruleCategorySet )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3025:1: ( ruleCategorySet )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3026:1: ruleCategorySet
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3035:1: rule__CategorySet__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CategorySet__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3039:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3040:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3040:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3041:1: RULE_ID
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3050:1: rule__CategorySet__ElementsAssignment_3 : ( ( ruleCatRef ) ) ;
    public final void rule__CategorySet__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3054:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3055:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3055:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3056:1: ( ruleCatRef )
            {
             before(grammarAccess.getCategorySetAccess().getElementsCategoryCrossReference_3_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3057:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3058:1: ruleCatRef
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

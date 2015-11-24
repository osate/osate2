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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Development", "Requirement", "Attribute", "Selection", "Quality", "Method", "Phase", "Type", "User", "Any", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Phase=10;
    public static final int User=12;
    public static final int Attribute=6;
    public static final int Selection=7;
    public static final int RULE_STRING=18;
    public static final int Any=13;
    public static final int RULE_SL_COMMENT=20;
    public static final int Quality=8;
    public static final int Development=4;
    public static final int EOF=-1;
    public static final int RightSquareBracket=15;
    public static final int RULE_ID=16;
    public static final int RULE_WS=21;
    public static final int Method=9;
    public static final int RULE_ANY_OTHER=22;
    public static final int Requirement=5;
    public static final int Type=11;
    public static final int RULE_INT=17;
    public static final int RULE_ML_COMMENT=19;
    public static final int LeftSquareBracket=14;

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
    		tokenNameToValue.put("Type", "'type'");
    		tokenNameToValue.put("User", "'user'");
    		tokenNameToValue.put("Phase", "'phase'");
    		tokenNameToValue.put("Method", "'method'");
    		tokenNameToValue.put("Quality", "'quality'");
    		tokenNameToValue.put("Attribute", "'attribute'");
    		tokenNameToValue.put("Selection", "'selection'");
    		tokenNameToValue.put("Development", "'development'");
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:86:1: entryRuleCategoriesDefinitions : ruleCategoriesDefinitions EOF ;
    public final void entryRuleCategoriesDefinitions() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:87:1: ( ruleCategoriesDefinitions EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:88:1: ruleCategoriesDefinitions EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:95:1: ruleCategoriesDefinitions : ( ( rule__CategoriesDefinitions__UnorderedGroup ) ) ;
    public final void ruleCategoriesDefinitions() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:99:5: ( ( ( rule__CategoriesDefinitions__UnorderedGroup ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:100:1: ( ( rule__CategoriesDefinitions__UnorderedGroup ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:100:1: ( ( rule__CategoriesDefinitions__UnorderedGroup ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:101:1: ( rule__CategoriesDefinitions__UnorderedGroup )
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:102:1: ( rule__CategoriesDefinitions__UnorderedGroup )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:102:2: rule__CategoriesDefinitions__UnorderedGroup
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


    // $ANTLR start "entryRuleRequirementTypeCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:114:1: entryRuleRequirementTypeCategories : ruleRequirementTypeCategories EOF ;
    public final void entryRuleRequirementTypeCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:115:1: ( ruleRequirementTypeCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:116:1: ruleRequirementTypeCategories EOF
            {
             before(grammarAccess.getRequirementTypeCategoriesRule()); 
            pushFollow(FOLLOW_ruleRequirementTypeCategories_in_entryRuleRequirementTypeCategories118);
            ruleRequirementTypeCategories();

            state._fsp--;

             after(grammarAccess.getRequirementTypeCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementTypeCategories125); 

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
    // $ANTLR end "entryRuleRequirementTypeCategories"


    // $ANTLR start "ruleRequirementTypeCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:123:1: ruleRequirementTypeCategories : ( ( rule__RequirementTypeCategories__Group__0 ) ) ;
    public final void ruleRequirementTypeCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:127:5: ( ( ( rule__RequirementTypeCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:128:1: ( ( rule__RequirementTypeCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:128:1: ( ( rule__RequirementTypeCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:129:1: ( rule__RequirementTypeCategories__Group__0 )
            {
             before(grammarAccess.getRequirementTypeCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:130:1: ( rule__RequirementTypeCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:130:2: rule__RequirementTypeCategories__Group__0
            {
            pushFollow(FOLLOW_rule__RequirementTypeCategories__Group__0_in_ruleRequirementTypeCategories155);
            rule__RequirementTypeCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRequirementTypeCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRequirementTypeCategories"


    // $ANTLR start "entryRuleMethodTypeCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:142:1: entryRuleMethodTypeCategories : ruleMethodTypeCategories EOF ;
    public final void entryRuleMethodTypeCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:143:1: ( ruleMethodTypeCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:144:1: ruleMethodTypeCategories EOF
            {
             before(grammarAccess.getMethodTypeCategoriesRule()); 
            pushFollow(FOLLOW_ruleMethodTypeCategories_in_entryRuleMethodTypeCategories182);
            ruleMethodTypeCategories();

            state._fsp--;

             after(grammarAccess.getMethodTypeCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodTypeCategories189); 

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
    // $ANTLR end "entryRuleMethodTypeCategories"


    // $ANTLR start "ruleMethodTypeCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:151:1: ruleMethodTypeCategories : ( ( rule__MethodTypeCategories__Group__0 ) ) ;
    public final void ruleMethodTypeCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:155:5: ( ( ( rule__MethodTypeCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:156:1: ( ( rule__MethodTypeCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:156:1: ( ( rule__MethodTypeCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:157:1: ( rule__MethodTypeCategories__Group__0 )
            {
             before(grammarAccess.getMethodTypeCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:158:1: ( rule__MethodTypeCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:158:2: rule__MethodTypeCategories__Group__0
            {
            pushFollow(FOLLOW_rule__MethodTypeCategories__Group__0_in_ruleMethodTypeCategories219);
            rule__MethodTypeCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMethodTypeCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMethodTypeCategories"


    // $ANTLR start "entryRuleUserSelectionCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:170:1: entryRuleUserSelectionCategories : ruleUserSelectionCategories EOF ;
    public final void entryRuleUserSelectionCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:171:1: ( ruleUserSelectionCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:172:1: ruleUserSelectionCategories EOF
            {
             before(grammarAccess.getUserSelectionCategoriesRule()); 
            pushFollow(FOLLOW_ruleUserSelectionCategories_in_entryRuleUserSelectionCategories246);
            ruleUserSelectionCategories();

            state._fsp--;

             after(grammarAccess.getUserSelectionCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUserSelectionCategories253); 

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
    // $ANTLR end "entryRuleUserSelectionCategories"


    // $ANTLR start "ruleUserSelectionCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:179:1: ruleUserSelectionCategories : ( ( rule__UserSelectionCategories__Group__0 ) ) ;
    public final void ruleUserSelectionCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:183:5: ( ( ( rule__UserSelectionCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:184:1: ( ( rule__UserSelectionCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:184:1: ( ( rule__UserSelectionCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:185:1: ( rule__UserSelectionCategories__Group__0 )
            {
             before(grammarAccess.getUserSelectionCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:186:1: ( rule__UserSelectionCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:186:2: rule__UserSelectionCategories__Group__0
            {
            pushFollow(FOLLOW_rule__UserSelectionCategories__Group__0_in_ruleUserSelectionCategories283);
            rule__UserSelectionCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUserSelectionCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUserSelectionCategories"


    // $ANTLR start "entryRuleQualityAttributeCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:198:1: entryRuleQualityAttributeCategories : ruleQualityAttributeCategories EOF ;
    public final void entryRuleQualityAttributeCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:199:1: ( ruleQualityAttributeCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:200:1: ruleQualityAttributeCategories EOF
            {
             before(grammarAccess.getQualityAttributeCategoriesRule()); 
            pushFollow(FOLLOW_ruleQualityAttributeCategories_in_entryRuleQualityAttributeCategories310);
            ruleQualityAttributeCategories();

            state._fsp--;

             after(grammarAccess.getQualityAttributeCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualityAttributeCategories317); 

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
    // $ANTLR end "entryRuleQualityAttributeCategories"


    // $ANTLR start "ruleQualityAttributeCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:207:1: ruleQualityAttributeCategories : ( ( rule__QualityAttributeCategories__Group__0 ) ) ;
    public final void ruleQualityAttributeCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:211:5: ( ( ( rule__QualityAttributeCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:212:1: ( ( rule__QualityAttributeCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:212:1: ( ( rule__QualityAttributeCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:213:1: ( rule__QualityAttributeCategories__Group__0 )
            {
             before(grammarAccess.getQualityAttributeCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:214:1: ( rule__QualityAttributeCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:214:2: rule__QualityAttributeCategories__Group__0
            {
            pushFollow(FOLLOW_rule__QualityAttributeCategories__Group__0_in_ruleQualityAttributeCategories347);
            rule__QualityAttributeCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualityAttributeCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualityAttributeCategories"


    // $ANTLR start "entryRuleDevelopmentPhaseCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:226:1: entryRuleDevelopmentPhaseCategories : ruleDevelopmentPhaseCategories EOF ;
    public final void entryRuleDevelopmentPhaseCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:227:1: ( ruleDevelopmentPhaseCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:228:1: ruleDevelopmentPhaseCategories EOF
            {
             before(grammarAccess.getDevelopmentPhaseCategoriesRule()); 
            pushFollow(FOLLOW_ruleDevelopmentPhaseCategories_in_entryRuleDevelopmentPhaseCategories374);
            ruleDevelopmentPhaseCategories();

            state._fsp--;

             after(grammarAccess.getDevelopmentPhaseCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDevelopmentPhaseCategories381); 

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
    // $ANTLR end "entryRuleDevelopmentPhaseCategories"


    // $ANTLR start "ruleDevelopmentPhaseCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:235:1: ruleDevelopmentPhaseCategories : ( ( rule__DevelopmentPhaseCategories__Group__0 ) ) ;
    public final void ruleDevelopmentPhaseCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:239:5: ( ( ( rule__DevelopmentPhaseCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:240:1: ( ( rule__DevelopmentPhaseCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:240:1: ( ( rule__DevelopmentPhaseCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:241:1: ( rule__DevelopmentPhaseCategories__Group__0 )
            {
             before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:242:1: ( rule__DevelopmentPhaseCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:242:2: rule__DevelopmentPhaseCategories__Group__0
            {
            pushFollow(FOLLOW_rule__DevelopmentPhaseCategories__Group__0_in_ruleDevelopmentPhaseCategories411);
            rule__DevelopmentPhaseCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDevelopmentPhaseCategories"


    // $ANTLR start "entryRuleRequirementType"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:254:1: entryRuleRequirementType : ruleRequirementType EOF ;
    public final void entryRuleRequirementType() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:255:1: ( ruleRequirementType EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:256:1: ruleRequirementType EOF
            {
             before(grammarAccess.getRequirementTypeRule()); 
            pushFollow(FOLLOW_ruleRequirementType_in_entryRuleRequirementType438);
            ruleRequirementType();

            state._fsp--;

             after(grammarAccess.getRequirementTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementType445); 

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
    // $ANTLR end "entryRuleRequirementType"


    // $ANTLR start "ruleRequirementType"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:263:1: ruleRequirementType : ( ( rule__RequirementType__Group__0 ) ) ;
    public final void ruleRequirementType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:267:5: ( ( ( rule__RequirementType__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:268:1: ( ( rule__RequirementType__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:268:1: ( ( rule__RequirementType__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:269:1: ( rule__RequirementType__Group__0 )
            {
             before(grammarAccess.getRequirementTypeAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:270:1: ( rule__RequirementType__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:270:2: rule__RequirementType__Group__0
            {
            pushFollow(FOLLOW_rule__RequirementType__Group__0_in_ruleRequirementType475);
            rule__RequirementType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRequirementTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRequirementType"


    // $ANTLR start "entryRuleMethodType"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:282:1: entryRuleMethodType : ruleMethodType EOF ;
    public final void entryRuleMethodType() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:283:1: ( ruleMethodType EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:284:1: ruleMethodType EOF
            {
             before(grammarAccess.getMethodTypeRule()); 
            pushFollow(FOLLOW_ruleMethodType_in_entryRuleMethodType502);
            ruleMethodType();

            state._fsp--;

             after(grammarAccess.getMethodTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodType509); 

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
    // $ANTLR end "entryRuleMethodType"


    // $ANTLR start "ruleMethodType"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:291:1: ruleMethodType : ( ( rule__MethodType__Group__0 ) ) ;
    public final void ruleMethodType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:295:5: ( ( ( rule__MethodType__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:296:1: ( ( rule__MethodType__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:296:1: ( ( rule__MethodType__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:297:1: ( rule__MethodType__Group__0 )
            {
             before(grammarAccess.getMethodTypeAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:298:1: ( rule__MethodType__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:298:2: rule__MethodType__Group__0
            {
            pushFollow(FOLLOW_rule__MethodType__Group__0_in_ruleMethodType539);
            rule__MethodType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMethodTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMethodType"


    // $ANTLR start "entryRuleUserSelection"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:310:1: entryRuleUserSelection : ruleUserSelection EOF ;
    public final void entryRuleUserSelection() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:311:1: ( ruleUserSelection EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:312:1: ruleUserSelection EOF
            {
             before(grammarAccess.getUserSelectionRule()); 
            pushFollow(FOLLOW_ruleUserSelection_in_entryRuleUserSelection566);
            ruleUserSelection();

            state._fsp--;

             after(grammarAccess.getUserSelectionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUserSelection573); 

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
    // $ANTLR end "entryRuleUserSelection"


    // $ANTLR start "ruleUserSelection"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:319:1: ruleUserSelection : ( ( rule__UserSelection__Group__0 ) ) ;
    public final void ruleUserSelection() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:323:5: ( ( ( rule__UserSelection__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:324:1: ( ( rule__UserSelection__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:324:1: ( ( rule__UserSelection__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:325:1: ( rule__UserSelection__Group__0 )
            {
             before(grammarAccess.getUserSelectionAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:326:1: ( rule__UserSelection__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:326:2: rule__UserSelection__Group__0
            {
            pushFollow(FOLLOW_rule__UserSelection__Group__0_in_ruleUserSelection603);
            rule__UserSelection__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUserSelectionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUserSelection"


    // $ANTLR start "entryRuleQualityAttribute"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:338:1: entryRuleQualityAttribute : ruleQualityAttribute EOF ;
    public final void entryRuleQualityAttribute() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:339:1: ( ruleQualityAttribute EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:340:1: ruleQualityAttribute EOF
            {
             before(grammarAccess.getQualityAttributeRule()); 
            pushFollow(FOLLOW_ruleQualityAttribute_in_entryRuleQualityAttribute630);
            ruleQualityAttribute();

            state._fsp--;

             after(grammarAccess.getQualityAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualityAttribute637); 

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
    // $ANTLR end "entryRuleQualityAttribute"


    // $ANTLR start "ruleQualityAttribute"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:347:1: ruleQualityAttribute : ( ( rule__QualityAttribute__Group__0 ) ) ;
    public final void ruleQualityAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:351:5: ( ( ( rule__QualityAttribute__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:352:1: ( ( rule__QualityAttribute__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:352:1: ( ( rule__QualityAttribute__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:353:1: ( rule__QualityAttribute__Group__0 )
            {
             before(grammarAccess.getQualityAttributeAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:354:1: ( rule__QualityAttribute__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:354:2: rule__QualityAttribute__Group__0
            {
            pushFollow(FOLLOW_rule__QualityAttribute__Group__0_in_ruleQualityAttribute667);
            rule__QualityAttribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualityAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualityAttribute"


    // $ANTLR start "entryRuleDevelopmentPhase"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:366:1: entryRuleDevelopmentPhase : ruleDevelopmentPhase EOF ;
    public final void entryRuleDevelopmentPhase() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:367:1: ( ruleDevelopmentPhase EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:368:1: ruleDevelopmentPhase EOF
            {
             before(grammarAccess.getDevelopmentPhaseRule()); 
            pushFollow(FOLLOW_ruleDevelopmentPhase_in_entryRuleDevelopmentPhase694);
            ruleDevelopmentPhase();

            state._fsp--;

             after(grammarAccess.getDevelopmentPhaseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDevelopmentPhase701); 

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
    // $ANTLR end "entryRuleDevelopmentPhase"


    // $ANTLR start "ruleDevelopmentPhase"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:375:1: ruleDevelopmentPhase : ( ( rule__DevelopmentPhase__Group__0 ) ) ;
    public final void ruleDevelopmentPhase() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:379:5: ( ( ( rule__DevelopmentPhase__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:380:1: ( ( rule__DevelopmentPhase__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:380:1: ( ( rule__DevelopmentPhase__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:381:1: ( rule__DevelopmentPhase__Group__0 )
            {
             before(grammarAccess.getDevelopmentPhaseAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:382:1: ( rule__DevelopmentPhase__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:382:2: rule__DevelopmentPhase__Group__0
            {
            pushFollow(FOLLOW_rule__DevelopmentPhase__Group__0_in_ruleDevelopmentPhase731);
            rule__DevelopmentPhase__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDevelopmentPhaseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDevelopmentPhase"


    // $ANTLR start "rule__RequirementTypeCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:400:1: rule__RequirementTypeCategories__Group__0 : rule__RequirementTypeCategories__Group__0__Impl rule__RequirementTypeCategories__Group__1 ;
    public final void rule__RequirementTypeCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:404:1: ( rule__RequirementTypeCategories__Group__0__Impl rule__RequirementTypeCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:405:2: rule__RequirementTypeCategories__Group__0__Impl rule__RequirementTypeCategories__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementTypeCategories__Group__0__Impl_in_rule__RequirementTypeCategories__Group__0769);
            rule__RequirementTypeCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementTypeCategories__Group__1_in_rule__RequirementTypeCategories__Group__0772);
            rule__RequirementTypeCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementTypeCategories__Group__0"


    // $ANTLR start "rule__RequirementTypeCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:412:1: rule__RequirementTypeCategories__Group__0__Impl : ( () ) ;
    public final void rule__RequirementTypeCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:416:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:417:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:417:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:418:1: ()
            {
             before(grammarAccess.getRequirementTypeCategoriesAccess().getRequirementTypeCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:419:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:421:1: 
            {
            }

             after(grammarAccess.getRequirementTypeCategoriesAccess().getRequirementTypeCategoriesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementTypeCategories__Group__0__Impl"


    // $ANTLR start "rule__RequirementTypeCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:431:1: rule__RequirementTypeCategories__Group__1 : rule__RequirementTypeCategories__Group__1__Impl rule__RequirementTypeCategories__Group__2 ;
    public final void rule__RequirementTypeCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:435:1: ( rule__RequirementTypeCategories__Group__1__Impl rule__RequirementTypeCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:436:2: rule__RequirementTypeCategories__Group__1__Impl rule__RequirementTypeCategories__Group__2
            {
            pushFollow(FOLLOW_rule__RequirementTypeCategories__Group__1__Impl_in_rule__RequirementTypeCategories__Group__1830);
            rule__RequirementTypeCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementTypeCategories__Group__2_in_rule__RequirementTypeCategories__Group__1833);
            rule__RequirementTypeCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementTypeCategories__Group__1"


    // $ANTLR start "rule__RequirementTypeCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:443:1: rule__RequirementTypeCategories__Group__1__Impl : ( Requirement ) ;
    public final void rule__RequirementTypeCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:447:1: ( ( Requirement ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:448:1: ( Requirement )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:448:1: ( Requirement )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:449:1: Requirement
            {
             before(grammarAccess.getRequirementTypeCategoriesAccess().getRequirementKeyword_1()); 
            match(input,Requirement,FOLLOW_Requirement_in_rule__RequirementTypeCategories__Group__1__Impl861); 
             after(grammarAccess.getRequirementTypeCategoriesAccess().getRequirementKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementTypeCategories__Group__1__Impl"


    // $ANTLR start "rule__RequirementTypeCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:462:1: rule__RequirementTypeCategories__Group__2 : rule__RequirementTypeCategories__Group__2__Impl rule__RequirementTypeCategories__Group__3 ;
    public final void rule__RequirementTypeCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:466:1: ( rule__RequirementTypeCategories__Group__2__Impl rule__RequirementTypeCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:467:2: rule__RequirementTypeCategories__Group__2__Impl rule__RequirementTypeCategories__Group__3
            {
            pushFollow(FOLLOW_rule__RequirementTypeCategories__Group__2__Impl_in_rule__RequirementTypeCategories__Group__2892);
            rule__RequirementTypeCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementTypeCategories__Group__3_in_rule__RequirementTypeCategories__Group__2895);
            rule__RequirementTypeCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementTypeCategories__Group__2"


    // $ANTLR start "rule__RequirementTypeCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:474:1: rule__RequirementTypeCategories__Group__2__Impl : ( Type ) ;
    public final void rule__RequirementTypeCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:478:1: ( ( Type ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:479:1: ( Type )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:479:1: ( Type )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:480:1: Type
            {
             before(grammarAccess.getRequirementTypeCategoriesAccess().getTypeKeyword_2()); 
            match(input,Type,FOLLOW_Type_in_rule__RequirementTypeCategories__Group__2__Impl923); 
             after(grammarAccess.getRequirementTypeCategoriesAccess().getTypeKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementTypeCategories__Group__2__Impl"


    // $ANTLR start "rule__RequirementTypeCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:493:1: rule__RequirementTypeCategories__Group__3 : rule__RequirementTypeCategories__Group__3__Impl rule__RequirementTypeCategories__Group__4 ;
    public final void rule__RequirementTypeCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:497:1: ( rule__RequirementTypeCategories__Group__3__Impl rule__RequirementTypeCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:498:2: rule__RequirementTypeCategories__Group__3__Impl rule__RequirementTypeCategories__Group__4
            {
            pushFollow(FOLLOW_rule__RequirementTypeCategories__Group__3__Impl_in_rule__RequirementTypeCategories__Group__3954);
            rule__RequirementTypeCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementTypeCategories__Group__4_in_rule__RequirementTypeCategories__Group__3957);
            rule__RequirementTypeCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementTypeCategories__Group__3"


    // $ANTLR start "rule__RequirementTypeCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:505:1: rule__RequirementTypeCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__RequirementTypeCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:509:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:510:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:510:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:511:1: LeftSquareBracket
            {
             before(grammarAccess.getRequirementTypeCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__RequirementTypeCategories__Group__3__Impl985); 
             after(grammarAccess.getRequirementTypeCategoriesAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementTypeCategories__Group__3__Impl"


    // $ANTLR start "rule__RequirementTypeCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:524:1: rule__RequirementTypeCategories__Group__4 : rule__RequirementTypeCategories__Group__4__Impl rule__RequirementTypeCategories__Group__5 ;
    public final void rule__RequirementTypeCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:528:1: ( rule__RequirementTypeCategories__Group__4__Impl rule__RequirementTypeCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:529:2: rule__RequirementTypeCategories__Group__4__Impl rule__RequirementTypeCategories__Group__5
            {
            pushFollow(FOLLOW_rule__RequirementTypeCategories__Group__4__Impl_in_rule__RequirementTypeCategories__Group__41016);
            rule__RequirementTypeCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementTypeCategories__Group__5_in_rule__RequirementTypeCategories__Group__41019);
            rule__RequirementTypeCategories__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementTypeCategories__Group__4"


    // $ANTLR start "rule__RequirementTypeCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:536:1: rule__RequirementTypeCategories__Group__4__Impl : ( ( ( rule__RequirementTypeCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementTypeCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__RequirementTypeCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:540:1: ( ( ( ( rule__RequirementTypeCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementTypeCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:541:1: ( ( ( rule__RequirementTypeCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementTypeCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:541:1: ( ( ( rule__RequirementTypeCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementTypeCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:542:1: ( ( rule__RequirementTypeCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementTypeCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:542:1: ( ( rule__RequirementTypeCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:543:1: ( rule__RequirementTypeCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getRequirementTypeCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:544:1: ( rule__RequirementTypeCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:544:2: rule__RequirementTypeCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__RequirementTypeCategories__CategoryAssignment_4_in_rule__RequirementTypeCategories__Group__4__Impl1048);
            rule__RequirementTypeCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getRequirementTypeCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:547:1: ( ( rule__RequirementTypeCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:548:1: ( rule__RequirementTypeCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getRequirementTypeCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:549:1: ( rule__RequirementTypeCategories__CategoryAssignment_4 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:549:2: rule__RequirementTypeCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__RequirementTypeCategories__CategoryAssignment_4_in_rule__RequirementTypeCategories__Group__4__Impl1060);
            	    rule__RequirementTypeCategories__CategoryAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getRequirementTypeCategoriesAccess().getCategoryAssignment_4()); 

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
    // $ANTLR end "rule__RequirementTypeCategories__Group__4__Impl"


    // $ANTLR start "rule__RequirementTypeCategories__Group__5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:560:1: rule__RequirementTypeCategories__Group__5 : rule__RequirementTypeCategories__Group__5__Impl ;
    public final void rule__RequirementTypeCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:564:1: ( rule__RequirementTypeCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:565:2: rule__RequirementTypeCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__RequirementTypeCategories__Group__5__Impl_in_rule__RequirementTypeCategories__Group__51093);
            rule__RequirementTypeCategories__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementTypeCategories__Group__5"


    // $ANTLR start "rule__RequirementTypeCategories__Group__5__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:571:1: rule__RequirementTypeCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__RequirementTypeCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:575:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:576:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:576:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:577:1: RightSquareBracket
            {
             before(grammarAccess.getRequirementTypeCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__RequirementTypeCategories__Group__5__Impl1121); 
             after(grammarAccess.getRequirementTypeCategoriesAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementTypeCategories__Group__5__Impl"


    // $ANTLR start "rule__MethodTypeCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:602:1: rule__MethodTypeCategories__Group__0 : rule__MethodTypeCategories__Group__0__Impl rule__MethodTypeCategories__Group__1 ;
    public final void rule__MethodTypeCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:606:1: ( rule__MethodTypeCategories__Group__0__Impl rule__MethodTypeCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:607:2: rule__MethodTypeCategories__Group__0__Impl rule__MethodTypeCategories__Group__1
            {
            pushFollow(FOLLOW_rule__MethodTypeCategories__Group__0__Impl_in_rule__MethodTypeCategories__Group__01164);
            rule__MethodTypeCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodTypeCategories__Group__1_in_rule__MethodTypeCategories__Group__01167);
            rule__MethodTypeCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodTypeCategories__Group__0"


    // $ANTLR start "rule__MethodTypeCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:614:1: rule__MethodTypeCategories__Group__0__Impl : ( () ) ;
    public final void rule__MethodTypeCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:618:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:619:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:619:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:620:1: ()
            {
             before(grammarAccess.getMethodTypeCategoriesAccess().getMethodTypeCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:621:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:623:1: 
            {
            }

             after(grammarAccess.getMethodTypeCategoriesAccess().getMethodTypeCategoriesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodTypeCategories__Group__0__Impl"


    // $ANTLR start "rule__MethodTypeCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:633:1: rule__MethodTypeCategories__Group__1 : rule__MethodTypeCategories__Group__1__Impl rule__MethodTypeCategories__Group__2 ;
    public final void rule__MethodTypeCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:637:1: ( rule__MethodTypeCategories__Group__1__Impl rule__MethodTypeCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:638:2: rule__MethodTypeCategories__Group__1__Impl rule__MethodTypeCategories__Group__2
            {
            pushFollow(FOLLOW_rule__MethodTypeCategories__Group__1__Impl_in_rule__MethodTypeCategories__Group__11225);
            rule__MethodTypeCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodTypeCategories__Group__2_in_rule__MethodTypeCategories__Group__11228);
            rule__MethodTypeCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodTypeCategories__Group__1"


    // $ANTLR start "rule__MethodTypeCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:645:1: rule__MethodTypeCategories__Group__1__Impl : ( Method ) ;
    public final void rule__MethodTypeCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:649:1: ( ( Method ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:650:1: ( Method )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:650:1: ( Method )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:651:1: Method
            {
             before(grammarAccess.getMethodTypeCategoriesAccess().getMethodKeyword_1()); 
            match(input,Method,FOLLOW_Method_in_rule__MethodTypeCategories__Group__1__Impl1256); 
             after(grammarAccess.getMethodTypeCategoriesAccess().getMethodKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodTypeCategories__Group__1__Impl"


    // $ANTLR start "rule__MethodTypeCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:664:1: rule__MethodTypeCategories__Group__2 : rule__MethodTypeCategories__Group__2__Impl rule__MethodTypeCategories__Group__3 ;
    public final void rule__MethodTypeCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:668:1: ( rule__MethodTypeCategories__Group__2__Impl rule__MethodTypeCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:669:2: rule__MethodTypeCategories__Group__2__Impl rule__MethodTypeCategories__Group__3
            {
            pushFollow(FOLLOW_rule__MethodTypeCategories__Group__2__Impl_in_rule__MethodTypeCategories__Group__21287);
            rule__MethodTypeCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodTypeCategories__Group__3_in_rule__MethodTypeCategories__Group__21290);
            rule__MethodTypeCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodTypeCategories__Group__2"


    // $ANTLR start "rule__MethodTypeCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:676:1: rule__MethodTypeCategories__Group__2__Impl : ( Type ) ;
    public final void rule__MethodTypeCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:680:1: ( ( Type ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:681:1: ( Type )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:681:1: ( Type )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:682:1: Type
            {
             before(grammarAccess.getMethodTypeCategoriesAccess().getTypeKeyword_2()); 
            match(input,Type,FOLLOW_Type_in_rule__MethodTypeCategories__Group__2__Impl1318); 
             after(grammarAccess.getMethodTypeCategoriesAccess().getTypeKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodTypeCategories__Group__2__Impl"


    // $ANTLR start "rule__MethodTypeCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:695:1: rule__MethodTypeCategories__Group__3 : rule__MethodTypeCategories__Group__3__Impl rule__MethodTypeCategories__Group__4 ;
    public final void rule__MethodTypeCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:699:1: ( rule__MethodTypeCategories__Group__3__Impl rule__MethodTypeCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:700:2: rule__MethodTypeCategories__Group__3__Impl rule__MethodTypeCategories__Group__4
            {
            pushFollow(FOLLOW_rule__MethodTypeCategories__Group__3__Impl_in_rule__MethodTypeCategories__Group__31349);
            rule__MethodTypeCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodTypeCategories__Group__4_in_rule__MethodTypeCategories__Group__31352);
            rule__MethodTypeCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodTypeCategories__Group__3"


    // $ANTLR start "rule__MethodTypeCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:707:1: rule__MethodTypeCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__MethodTypeCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:711:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:712:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:712:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:713:1: LeftSquareBracket
            {
             before(grammarAccess.getMethodTypeCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__MethodTypeCategories__Group__3__Impl1380); 
             after(grammarAccess.getMethodTypeCategoriesAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodTypeCategories__Group__3__Impl"


    // $ANTLR start "rule__MethodTypeCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:726:1: rule__MethodTypeCategories__Group__4 : rule__MethodTypeCategories__Group__4__Impl rule__MethodTypeCategories__Group__5 ;
    public final void rule__MethodTypeCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:730:1: ( rule__MethodTypeCategories__Group__4__Impl rule__MethodTypeCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:731:2: rule__MethodTypeCategories__Group__4__Impl rule__MethodTypeCategories__Group__5
            {
            pushFollow(FOLLOW_rule__MethodTypeCategories__Group__4__Impl_in_rule__MethodTypeCategories__Group__41411);
            rule__MethodTypeCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodTypeCategories__Group__5_in_rule__MethodTypeCategories__Group__41414);
            rule__MethodTypeCategories__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodTypeCategories__Group__4"


    // $ANTLR start "rule__MethodTypeCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:738:1: rule__MethodTypeCategories__Group__4__Impl : ( ( ( rule__MethodTypeCategories__CategoryAssignment_4 ) ) ( ( rule__MethodTypeCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__MethodTypeCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:742:1: ( ( ( ( rule__MethodTypeCategories__CategoryAssignment_4 ) ) ( ( rule__MethodTypeCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:743:1: ( ( ( rule__MethodTypeCategories__CategoryAssignment_4 ) ) ( ( rule__MethodTypeCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:743:1: ( ( ( rule__MethodTypeCategories__CategoryAssignment_4 ) ) ( ( rule__MethodTypeCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:744:1: ( ( rule__MethodTypeCategories__CategoryAssignment_4 ) ) ( ( rule__MethodTypeCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:744:1: ( ( rule__MethodTypeCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:745:1: ( rule__MethodTypeCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getMethodTypeCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:746:1: ( rule__MethodTypeCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:746:2: rule__MethodTypeCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__MethodTypeCategories__CategoryAssignment_4_in_rule__MethodTypeCategories__Group__4__Impl1443);
            rule__MethodTypeCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getMethodTypeCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:749:1: ( ( rule__MethodTypeCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:750:1: ( rule__MethodTypeCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getMethodTypeCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:751:1: ( rule__MethodTypeCategories__CategoryAssignment_4 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:751:2: rule__MethodTypeCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__MethodTypeCategories__CategoryAssignment_4_in_rule__MethodTypeCategories__Group__4__Impl1455);
            	    rule__MethodTypeCategories__CategoryAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getMethodTypeCategoriesAccess().getCategoryAssignment_4()); 

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
    // $ANTLR end "rule__MethodTypeCategories__Group__4__Impl"


    // $ANTLR start "rule__MethodTypeCategories__Group__5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:762:1: rule__MethodTypeCategories__Group__5 : rule__MethodTypeCategories__Group__5__Impl ;
    public final void rule__MethodTypeCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:766:1: ( rule__MethodTypeCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:767:2: rule__MethodTypeCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__MethodTypeCategories__Group__5__Impl_in_rule__MethodTypeCategories__Group__51488);
            rule__MethodTypeCategories__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodTypeCategories__Group__5"


    // $ANTLR start "rule__MethodTypeCategories__Group__5__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:773:1: rule__MethodTypeCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__MethodTypeCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:777:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:778:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:778:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:779:1: RightSquareBracket
            {
             before(grammarAccess.getMethodTypeCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__MethodTypeCategories__Group__5__Impl1516); 
             after(grammarAccess.getMethodTypeCategoriesAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodTypeCategories__Group__5__Impl"


    // $ANTLR start "rule__UserSelectionCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:804:1: rule__UserSelectionCategories__Group__0 : rule__UserSelectionCategories__Group__0__Impl rule__UserSelectionCategories__Group__1 ;
    public final void rule__UserSelectionCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:808:1: ( rule__UserSelectionCategories__Group__0__Impl rule__UserSelectionCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:809:2: rule__UserSelectionCategories__Group__0__Impl rule__UserSelectionCategories__Group__1
            {
            pushFollow(FOLLOW_rule__UserSelectionCategories__Group__0__Impl_in_rule__UserSelectionCategories__Group__01559);
            rule__UserSelectionCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UserSelectionCategories__Group__1_in_rule__UserSelectionCategories__Group__01562);
            rule__UserSelectionCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelectionCategories__Group__0"


    // $ANTLR start "rule__UserSelectionCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:816:1: rule__UserSelectionCategories__Group__0__Impl : ( () ) ;
    public final void rule__UserSelectionCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:820:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:821:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:821:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:822:1: ()
            {
             before(grammarAccess.getUserSelectionCategoriesAccess().getUserSelectionCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:823:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:825:1: 
            {
            }

             after(grammarAccess.getUserSelectionCategoriesAccess().getUserSelectionCategoriesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelectionCategories__Group__0__Impl"


    // $ANTLR start "rule__UserSelectionCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:835:1: rule__UserSelectionCategories__Group__1 : rule__UserSelectionCategories__Group__1__Impl rule__UserSelectionCategories__Group__2 ;
    public final void rule__UserSelectionCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:839:1: ( rule__UserSelectionCategories__Group__1__Impl rule__UserSelectionCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:840:2: rule__UserSelectionCategories__Group__1__Impl rule__UserSelectionCategories__Group__2
            {
            pushFollow(FOLLOW_rule__UserSelectionCategories__Group__1__Impl_in_rule__UserSelectionCategories__Group__11620);
            rule__UserSelectionCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UserSelectionCategories__Group__2_in_rule__UserSelectionCategories__Group__11623);
            rule__UserSelectionCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelectionCategories__Group__1"


    // $ANTLR start "rule__UserSelectionCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:847:1: rule__UserSelectionCategories__Group__1__Impl : ( User ) ;
    public final void rule__UserSelectionCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:851:1: ( ( User ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:852:1: ( User )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:852:1: ( User )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:853:1: User
            {
             before(grammarAccess.getUserSelectionCategoriesAccess().getUserKeyword_1()); 
            match(input,User,FOLLOW_User_in_rule__UserSelectionCategories__Group__1__Impl1651); 
             after(grammarAccess.getUserSelectionCategoriesAccess().getUserKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelectionCategories__Group__1__Impl"


    // $ANTLR start "rule__UserSelectionCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:866:1: rule__UserSelectionCategories__Group__2 : rule__UserSelectionCategories__Group__2__Impl rule__UserSelectionCategories__Group__3 ;
    public final void rule__UserSelectionCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:870:1: ( rule__UserSelectionCategories__Group__2__Impl rule__UserSelectionCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:871:2: rule__UserSelectionCategories__Group__2__Impl rule__UserSelectionCategories__Group__3
            {
            pushFollow(FOLLOW_rule__UserSelectionCategories__Group__2__Impl_in_rule__UserSelectionCategories__Group__21682);
            rule__UserSelectionCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UserSelectionCategories__Group__3_in_rule__UserSelectionCategories__Group__21685);
            rule__UserSelectionCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelectionCategories__Group__2"


    // $ANTLR start "rule__UserSelectionCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:878:1: rule__UserSelectionCategories__Group__2__Impl : ( Selection ) ;
    public final void rule__UserSelectionCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:882:1: ( ( Selection ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:883:1: ( Selection )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:883:1: ( Selection )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:884:1: Selection
            {
             before(grammarAccess.getUserSelectionCategoriesAccess().getSelectionKeyword_2()); 
            match(input,Selection,FOLLOW_Selection_in_rule__UserSelectionCategories__Group__2__Impl1713); 
             after(grammarAccess.getUserSelectionCategoriesAccess().getSelectionKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelectionCategories__Group__2__Impl"


    // $ANTLR start "rule__UserSelectionCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:897:1: rule__UserSelectionCategories__Group__3 : rule__UserSelectionCategories__Group__3__Impl rule__UserSelectionCategories__Group__4 ;
    public final void rule__UserSelectionCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:901:1: ( rule__UserSelectionCategories__Group__3__Impl rule__UserSelectionCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:902:2: rule__UserSelectionCategories__Group__3__Impl rule__UserSelectionCategories__Group__4
            {
            pushFollow(FOLLOW_rule__UserSelectionCategories__Group__3__Impl_in_rule__UserSelectionCategories__Group__31744);
            rule__UserSelectionCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UserSelectionCategories__Group__4_in_rule__UserSelectionCategories__Group__31747);
            rule__UserSelectionCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelectionCategories__Group__3"


    // $ANTLR start "rule__UserSelectionCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:909:1: rule__UserSelectionCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__UserSelectionCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:913:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:914:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:914:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:915:1: LeftSquareBracket
            {
             before(grammarAccess.getUserSelectionCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__UserSelectionCategories__Group__3__Impl1775); 
             after(grammarAccess.getUserSelectionCategoriesAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelectionCategories__Group__3__Impl"


    // $ANTLR start "rule__UserSelectionCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:928:1: rule__UserSelectionCategories__Group__4 : rule__UserSelectionCategories__Group__4__Impl rule__UserSelectionCategories__Group__5 ;
    public final void rule__UserSelectionCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:932:1: ( rule__UserSelectionCategories__Group__4__Impl rule__UserSelectionCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:933:2: rule__UserSelectionCategories__Group__4__Impl rule__UserSelectionCategories__Group__5
            {
            pushFollow(FOLLOW_rule__UserSelectionCategories__Group__4__Impl_in_rule__UserSelectionCategories__Group__41806);
            rule__UserSelectionCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UserSelectionCategories__Group__5_in_rule__UserSelectionCategories__Group__41809);
            rule__UserSelectionCategories__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelectionCategories__Group__4"


    // $ANTLR start "rule__UserSelectionCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:940:1: rule__UserSelectionCategories__Group__4__Impl : ( ( ( rule__UserSelectionCategories__CategoryAssignment_4 ) ) ( ( rule__UserSelectionCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__UserSelectionCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:944:1: ( ( ( ( rule__UserSelectionCategories__CategoryAssignment_4 ) ) ( ( rule__UserSelectionCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:945:1: ( ( ( rule__UserSelectionCategories__CategoryAssignment_4 ) ) ( ( rule__UserSelectionCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:945:1: ( ( ( rule__UserSelectionCategories__CategoryAssignment_4 ) ) ( ( rule__UserSelectionCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:946:1: ( ( rule__UserSelectionCategories__CategoryAssignment_4 ) ) ( ( rule__UserSelectionCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:946:1: ( ( rule__UserSelectionCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:947:1: ( rule__UserSelectionCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getUserSelectionCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:948:1: ( rule__UserSelectionCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:948:2: rule__UserSelectionCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__UserSelectionCategories__CategoryAssignment_4_in_rule__UserSelectionCategories__Group__4__Impl1838);
            rule__UserSelectionCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getUserSelectionCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:951:1: ( ( rule__UserSelectionCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:952:1: ( rule__UserSelectionCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getUserSelectionCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:953:1: ( rule__UserSelectionCategories__CategoryAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:953:2: rule__UserSelectionCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__UserSelectionCategories__CategoryAssignment_4_in_rule__UserSelectionCategories__Group__4__Impl1850);
            	    rule__UserSelectionCategories__CategoryAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getUserSelectionCategoriesAccess().getCategoryAssignment_4()); 

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
    // $ANTLR end "rule__UserSelectionCategories__Group__4__Impl"


    // $ANTLR start "rule__UserSelectionCategories__Group__5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:964:1: rule__UserSelectionCategories__Group__5 : rule__UserSelectionCategories__Group__5__Impl ;
    public final void rule__UserSelectionCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:968:1: ( rule__UserSelectionCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:969:2: rule__UserSelectionCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__UserSelectionCategories__Group__5__Impl_in_rule__UserSelectionCategories__Group__51883);
            rule__UserSelectionCategories__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelectionCategories__Group__5"


    // $ANTLR start "rule__UserSelectionCategories__Group__5__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:975:1: rule__UserSelectionCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__UserSelectionCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:979:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:980:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:980:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:981:1: RightSquareBracket
            {
             before(grammarAccess.getUserSelectionCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__UserSelectionCategories__Group__5__Impl1911); 
             after(grammarAccess.getUserSelectionCategoriesAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelectionCategories__Group__5__Impl"


    // $ANTLR start "rule__QualityAttributeCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1006:1: rule__QualityAttributeCategories__Group__0 : rule__QualityAttributeCategories__Group__0__Impl rule__QualityAttributeCategories__Group__1 ;
    public final void rule__QualityAttributeCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1010:1: ( rule__QualityAttributeCategories__Group__0__Impl rule__QualityAttributeCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1011:2: rule__QualityAttributeCategories__Group__0__Impl rule__QualityAttributeCategories__Group__1
            {
            pushFollow(FOLLOW_rule__QualityAttributeCategories__Group__0__Impl_in_rule__QualityAttributeCategories__Group__01954);
            rule__QualityAttributeCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityAttributeCategories__Group__1_in_rule__QualityAttributeCategories__Group__01957);
            rule__QualityAttributeCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttributeCategories__Group__0"


    // $ANTLR start "rule__QualityAttributeCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1018:1: rule__QualityAttributeCategories__Group__0__Impl : ( () ) ;
    public final void rule__QualityAttributeCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1022:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1023:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1023:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1024:1: ()
            {
             before(grammarAccess.getQualityAttributeCategoriesAccess().getQualityAttributeCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1025:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1027:1: 
            {
            }

             after(grammarAccess.getQualityAttributeCategoriesAccess().getQualityAttributeCategoriesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttributeCategories__Group__0__Impl"


    // $ANTLR start "rule__QualityAttributeCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1037:1: rule__QualityAttributeCategories__Group__1 : rule__QualityAttributeCategories__Group__1__Impl rule__QualityAttributeCategories__Group__2 ;
    public final void rule__QualityAttributeCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1041:1: ( rule__QualityAttributeCategories__Group__1__Impl rule__QualityAttributeCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1042:2: rule__QualityAttributeCategories__Group__1__Impl rule__QualityAttributeCategories__Group__2
            {
            pushFollow(FOLLOW_rule__QualityAttributeCategories__Group__1__Impl_in_rule__QualityAttributeCategories__Group__12015);
            rule__QualityAttributeCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityAttributeCategories__Group__2_in_rule__QualityAttributeCategories__Group__12018);
            rule__QualityAttributeCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttributeCategories__Group__1"


    // $ANTLR start "rule__QualityAttributeCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1049:1: rule__QualityAttributeCategories__Group__1__Impl : ( Quality ) ;
    public final void rule__QualityAttributeCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1053:1: ( ( Quality ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1054:1: ( Quality )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1054:1: ( Quality )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1055:1: Quality
            {
             before(grammarAccess.getQualityAttributeCategoriesAccess().getQualityKeyword_1()); 
            match(input,Quality,FOLLOW_Quality_in_rule__QualityAttributeCategories__Group__1__Impl2046); 
             after(grammarAccess.getQualityAttributeCategoriesAccess().getQualityKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttributeCategories__Group__1__Impl"


    // $ANTLR start "rule__QualityAttributeCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1068:1: rule__QualityAttributeCategories__Group__2 : rule__QualityAttributeCategories__Group__2__Impl rule__QualityAttributeCategories__Group__3 ;
    public final void rule__QualityAttributeCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1072:1: ( rule__QualityAttributeCategories__Group__2__Impl rule__QualityAttributeCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1073:2: rule__QualityAttributeCategories__Group__2__Impl rule__QualityAttributeCategories__Group__3
            {
            pushFollow(FOLLOW_rule__QualityAttributeCategories__Group__2__Impl_in_rule__QualityAttributeCategories__Group__22077);
            rule__QualityAttributeCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityAttributeCategories__Group__3_in_rule__QualityAttributeCategories__Group__22080);
            rule__QualityAttributeCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttributeCategories__Group__2"


    // $ANTLR start "rule__QualityAttributeCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1080:1: rule__QualityAttributeCategories__Group__2__Impl : ( Attribute ) ;
    public final void rule__QualityAttributeCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1084:1: ( ( Attribute ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1085:1: ( Attribute )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1085:1: ( Attribute )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1086:1: Attribute
            {
             before(grammarAccess.getQualityAttributeCategoriesAccess().getAttributeKeyword_2()); 
            match(input,Attribute,FOLLOW_Attribute_in_rule__QualityAttributeCategories__Group__2__Impl2108); 
             after(grammarAccess.getQualityAttributeCategoriesAccess().getAttributeKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttributeCategories__Group__2__Impl"


    // $ANTLR start "rule__QualityAttributeCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1099:1: rule__QualityAttributeCategories__Group__3 : rule__QualityAttributeCategories__Group__3__Impl rule__QualityAttributeCategories__Group__4 ;
    public final void rule__QualityAttributeCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1103:1: ( rule__QualityAttributeCategories__Group__3__Impl rule__QualityAttributeCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1104:2: rule__QualityAttributeCategories__Group__3__Impl rule__QualityAttributeCategories__Group__4
            {
            pushFollow(FOLLOW_rule__QualityAttributeCategories__Group__3__Impl_in_rule__QualityAttributeCategories__Group__32139);
            rule__QualityAttributeCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityAttributeCategories__Group__4_in_rule__QualityAttributeCategories__Group__32142);
            rule__QualityAttributeCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttributeCategories__Group__3"


    // $ANTLR start "rule__QualityAttributeCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1111:1: rule__QualityAttributeCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__QualityAttributeCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1115:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1116:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1116:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1117:1: LeftSquareBracket
            {
             before(grammarAccess.getQualityAttributeCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__QualityAttributeCategories__Group__3__Impl2170); 
             after(grammarAccess.getQualityAttributeCategoriesAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttributeCategories__Group__3__Impl"


    // $ANTLR start "rule__QualityAttributeCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1130:1: rule__QualityAttributeCategories__Group__4 : rule__QualityAttributeCategories__Group__4__Impl rule__QualityAttributeCategories__Group__5 ;
    public final void rule__QualityAttributeCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1134:1: ( rule__QualityAttributeCategories__Group__4__Impl rule__QualityAttributeCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1135:2: rule__QualityAttributeCategories__Group__4__Impl rule__QualityAttributeCategories__Group__5
            {
            pushFollow(FOLLOW_rule__QualityAttributeCategories__Group__4__Impl_in_rule__QualityAttributeCategories__Group__42201);
            rule__QualityAttributeCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityAttributeCategories__Group__5_in_rule__QualityAttributeCategories__Group__42204);
            rule__QualityAttributeCategories__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttributeCategories__Group__4"


    // $ANTLR start "rule__QualityAttributeCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1142:1: rule__QualityAttributeCategories__Group__4__Impl : ( ( ( rule__QualityAttributeCategories__CategoryAssignment_4 ) ) ( ( rule__QualityAttributeCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__QualityAttributeCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1146:1: ( ( ( ( rule__QualityAttributeCategories__CategoryAssignment_4 ) ) ( ( rule__QualityAttributeCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1147:1: ( ( ( rule__QualityAttributeCategories__CategoryAssignment_4 ) ) ( ( rule__QualityAttributeCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1147:1: ( ( ( rule__QualityAttributeCategories__CategoryAssignment_4 ) ) ( ( rule__QualityAttributeCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1148:1: ( ( rule__QualityAttributeCategories__CategoryAssignment_4 ) ) ( ( rule__QualityAttributeCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1148:1: ( ( rule__QualityAttributeCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1149:1: ( rule__QualityAttributeCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getQualityAttributeCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1150:1: ( rule__QualityAttributeCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1150:2: rule__QualityAttributeCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__QualityAttributeCategories__CategoryAssignment_4_in_rule__QualityAttributeCategories__Group__4__Impl2233);
            rule__QualityAttributeCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getQualityAttributeCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1153:1: ( ( rule__QualityAttributeCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1154:1: ( rule__QualityAttributeCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getQualityAttributeCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1155:1: ( rule__QualityAttributeCategories__CategoryAssignment_4 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1155:2: rule__QualityAttributeCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__QualityAttributeCategories__CategoryAssignment_4_in_rule__QualityAttributeCategories__Group__4__Impl2245);
            	    rule__QualityAttributeCategories__CategoryAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getQualityAttributeCategoriesAccess().getCategoryAssignment_4()); 

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
    // $ANTLR end "rule__QualityAttributeCategories__Group__4__Impl"


    // $ANTLR start "rule__QualityAttributeCategories__Group__5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1166:1: rule__QualityAttributeCategories__Group__5 : rule__QualityAttributeCategories__Group__5__Impl ;
    public final void rule__QualityAttributeCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1170:1: ( rule__QualityAttributeCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1171:2: rule__QualityAttributeCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__QualityAttributeCategories__Group__5__Impl_in_rule__QualityAttributeCategories__Group__52278);
            rule__QualityAttributeCategories__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttributeCategories__Group__5"


    // $ANTLR start "rule__QualityAttributeCategories__Group__5__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1177:1: rule__QualityAttributeCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__QualityAttributeCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1181:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1182:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1182:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1183:1: RightSquareBracket
            {
             before(grammarAccess.getQualityAttributeCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__QualityAttributeCategories__Group__5__Impl2306); 
             after(grammarAccess.getQualityAttributeCategoriesAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttributeCategories__Group__5__Impl"


    // $ANTLR start "rule__DevelopmentPhaseCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1208:1: rule__DevelopmentPhaseCategories__Group__0 : rule__DevelopmentPhaseCategories__Group__0__Impl rule__DevelopmentPhaseCategories__Group__1 ;
    public final void rule__DevelopmentPhaseCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1212:1: ( rule__DevelopmentPhaseCategories__Group__0__Impl rule__DevelopmentPhaseCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1213:2: rule__DevelopmentPhaseCategories__Group__0__Impl rule__DevelopmentPhaseCategories__Group__1
            {
            pushFollow(FOLLOW_rule__DevelopmentPhaseCategories__Group__0__Impl_in_rule__DevelopmentPhaseCategories__Group__02349);
            rule__DevelopmentPhaseCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DevelopmentPhaseCategories__Group__1_in_rule__DevelopmentPhaseCategories__Group__02352);
            rule__DevelopmentPhaseCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhaseCategories__Group__0"


    // $ANTLR start "rule__DevelopmentPhaseCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1220:1: rule__DevelopmentPhaseCategories__Group__0__Impl : ( () ) ;
    public final void rule__DevelopmentPhaseCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1224:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1225:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1225:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1226:1: ()
            {
             before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getDevelopmentPhaseCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1227:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1229:1: 
            {
            }

             after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getDevelopmentPhaseCategoriesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhaseCategories__Group__0__Impl"


    // $ANTLR start "rule__DevelopmentPhaseCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1239:1: rule__DevelopmentPhaseCategories__Group__1 : rule__DevelopmentPhaseCategories__Group__1__Impl rule__DevelopmentPhaseCategories__Group__2 ;
    public final void rule__DevelopmentPhaseCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1243:1: ( rule__DevelopmentPhaseCategories__Group__1__Impl rule__DevelopmentPhaseCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1244:2: rule__DevelopmentPhaseCategories__Group__1__Impl rule__DevelopmentPhaseCategories__Group__2
            {
            pushFollow(FOLLOW_rule__DevelopmentPhaseCategories__Group__1__Impl_in_rule__DevelopmentPhaseCategories__Group__12410);
            rule__DevelopmentPhaseCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DevelopmentPhaseCategories__Group__2_in_rule__DevelopmentPhaseCategories__Group__12413);
            rule__DevelopmentPhaseCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhaseCategories__Group__1"


    // $ANTLR start "rule__DevelopmentPhaseCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1251:1: rule__DevelopmentPhaseCategories__Group__1__Impl : ( Development ) ;
    public final void rule__DevelopmentPhaseCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1255:1: ( ( Development ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1256:1: ( Development )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1256:1: ( Development )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1257:1: Development
            {
             before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getDevelopmentKeyword_1()); 
            match(input,Development,FOLLOW_Development_in_rule__DevelopmentPhaseCategories__Group__1__Impl2441); 
             after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getDevelopmentKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhaseCategories__Group__1__Impl"


    // $ANTLR start "rule__DevelopmentPhaseCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1270:1: rule__DevelopmentPhaseCategories__Group__2 : rule__DevelopmentPhaseCategories__Group__2__Impl rule__DevelopmentPhaseCategories__Group__3 ;
    public final void rule__DevelopmentPhaseCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1274:1: ( rule__DevelopmentPhaseCategories__Group__2__Impl rule__DevelopmentPhaseCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1275:2: rule__DevelopmentPhaseCategories__Group__2__Impl rule__DevelopmentPhaseCategories__Group__3
            {
            pushFollow(FOLLOW_rule__DevelopmentPhaseCategories__Group__2__Impl_in_rule__DevelopmentPhaseCategories__Group__22472);
            rule__DevelopmentPhaseCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DevelopmentPhaseCategories__Group__3_in_rule__DevelopmentPhaseCategories__Group__22475);
            rule__DevelopmentPhaseCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhaseCategories__Group__2"


    // $ANTLR start "rule__DevelopmentPhaseCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1282:1: rule__DevelopmentPhaseCategories__Group__2__Impl : ( Phase ) ;
    public final void rule__DevelopmentPhaseCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1286:1: ( ( Phase ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1287:1: ( Phase )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1287:1: ( Phase )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1288:1: Phase
            {
             before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getPhaseKeyword_2()); 
            match(input,Phase,FOLLOW_Phase_in_rule__DevelopmentPhaseCategories__Group__2__Impl2503); 
             after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getPhaseKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhaseCategories__Group__2__Impl"


    // $ANTLR start "rule__DevelopmentPhaseCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1301:1: rule__DevelopmentPhaseCategories__Group__3 : rule__DevelopmentPhaseCategories__Group__3__Impl rule__DevelopmentPhaseCategories__Group__4 ;
    public final void rule__DevelopmentPhaseCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1305:1: ( rule__DevelopmentPhaseCategories__Group__3__Impl rule__DevelopmentPhaseCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1306:2: rule__DevelopmentPhaseCategories__Group__3__Impl rule__DevelopmentPhaseCategories__Group__4
            {
            pushFollow(FOLLOW_rule__DevelopmentPhaseCategories__Group__3__Impl_in_rule__DevelopmentPhaseCategories__Group__32534);
            rule__DevelopmentPhaseCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DevelopmentPhaseCategories__Group__4_in_rule__DevelopmentPhaseCategories__Group__32537);
            rule__DevelopmentPhaseCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhaseCategories__Group__3"


    // $ANTLR start "rule__DevelopmentPhaseCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1313:1: rule__DevelopmentPhaseCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__DevelopmentPhaseCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1317:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1318:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1318:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1319:1: LeftSquareBracket
            {
             before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__DevelopmentPhaseCategories__Group__3__Impl2565); 
             after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhaseCategories__Group__3__Impl"


    // $ANTLR start "rule__DevelopmentPhaseCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1332:1: rule__DevelopmentPhaseCategories__Group__4 : rule__DevelopmentPhaseCategories__Group__4__Impl rule__DevelopmentPhaseCategories__Group__5 ;
    public final void rule__DevelopmentPhaseCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1336:1: ( rule__DevelopmentPhaseCategories__Group__4__Impl rule__DevelopmentPhaseCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1337:2: rule__DevelopmentPhaseCategories__Group__4__Impl rule__DevelopmentPhaseCategories__Group__5
            {
            pushFollow(FOLLOW_rule__DevelopmentPhaseCategories__Group__4__Impl_in_rule__DevelopmentPhaseCategories__Group__42596);
            rule__DevelopmentPhaseCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DevelopmentPhaseCategories__Group__5_in_rule__DevelopmentPhaseCategories__Group__42599);
            rule__DevelopmentPhaseCategories__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhaseCategories__Group__4"


    // $ANTLR start "rule__DevelopmentPhaseCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1344:1: rule__DevelopmentPhaseCategories__Group__4__Impl : ( ( ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 ) ) ( ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__DevelopmentPhaseCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1348:1: ( ( ( ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 ) ) ( ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1349:1: ( ( ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 ) ) ( ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1349:1: ( ( ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 ) ) ( ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1350:1: ( ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 ) ) ( ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1350:1: ( ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1351:1: ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1352:1: ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1352:2: rule__DevelopmentPhaseCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__DevelopmentPhaseCategories__CategoryAssignment_4_in_rule__DevelopmentPhaseCategories__Group__4__Impl2628);
            rule__DevelopmentPhaseCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1355:1: ( ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1356:1: ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1357:1: ( rule__DevelopmentPhaseCategories__CategoryAssignment_4 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1357:2: rule__DevelopmentPhaseCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__DevelopmentPhaseCategories__CategoryAssignment_4_in_rule__DevelopmentPhaseCategories__Group__4__Impl2640);
            	    rule__DevelopmentPhaseCategories__CategoryAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getCategoryAssignment_4()); 

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
    // $ANTLR end "rule__DevelopmentPhaseCategories__Group__4__Impl"


    // $ANTLR start "rule__DevelopmentPhaseCategories__Group__5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1368:1: rule__DevelopmentPhaseCategories__Group__5 : rule__DevelopmentPhaseCategories__Group__5__Impl ;
    public final void rule__DevelopmentPhaseCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1372:1: ( rule__DevelopmentPhaseCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1373:2: rule__DevelopmentPhaseCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__DevelopmentPhaseCategories__Group__5__Impl_in_rule__DevelopmentPhaseCategories__Group__52673);
            rule__DevelopmentPhaseCategories__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhaseCategories__Group__5"


    // $ANTLR start "rule__DevelopmentPhaseCategories__Group__5__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1379:1: rule__DevelopmentPhaseCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__DevelopmentPhaseCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1383:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1384:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1384:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1385:1: RightSquareBracket
            {
             before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__DevelopmentPhaseCategories__Group__5__Impl2701); 
             after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhaseCategories__Group__5__Impl"


    // $ANTLR start "rule__RequirementType__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1410:1: rule__RequirementType__Group__0 : rule__RequirementType__Group__0__Impl rule__RequirementType__Group__1 ;
    public final void rule__RequirementType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1414:1: ( rule__RequirementType__Group__0__Impl rule__RequirementType__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1415:2: rule__RequirementType__Group__0__Impl rule__RequirementType__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementType__Group__0__Impl_in_rule__RequirementType__Group__02744);
            rule__RequirementType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementType__Group__1_in_rule__RequirementType__Group__02747);
            rule__RequirementType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementType__Group__0"


    // $ANTLR start "rule__RequirementType__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1422:1: rule__RequirementType__Group__0__Impl : ( () ) ;
    public final void rule__RequirementType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1426:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1427:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1427:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1428:1: ()
            {
             before(grammarAccess.getRequirementTypeAccess().getRequirementTypeAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1429:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1431:1: 
            {
            }

             after(grammarAccess.getRequirementTypeAccess().getRequirementTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementType__Group__0__Impl"


    // $ANTLR start "rule__RequirementType__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1441:1: rule__RequirementType__Group__1 : rule__RequirementType__Group__1__Impl ;
    public final void rule__RequirementType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1445:1: ( rule__RequirementType__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1446:2: rule__RequirementType__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RequirementType__Group__1__Impl_in_rule__RequirementType__Group__12805);
            rule__RequirementType__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementType__Group__1"


    // $ANTLR start "rule__RequirementType__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1452:1: rule__RequirementType__Group__1__Impl : ( ( rule__RequirementType__NameAssignment_1 ) ) ;
    public final void rule__RequirementType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1456:1: ( ( ( rule__RequirementType__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1457:1: ( ( rule__RequirementType__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1457:1: ( ( rule__RequirementType__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1458:1: ( rule__RequirementType__NameAssignment_1 )
            {
             before(grammarAccess.getRequirementTypeAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1459:1: ( rule__RequirementType__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1459:2: rule__RequirementType__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__RequirementType__NameAssignment_1_in_rule__RequirementType__Group__1__Impl2832);
            rule__RequirementType__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRequirementTypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementType__Group__1__Impl"


    // $ANTLR start "rule__MethodType__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1473:1: rule__MethodType__Group__0 : rule__MethodType__Group__0__Impl rule__MethodType__Group__1 ;
    public final void rule__MethodType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1477:1: ( rule__MethodType__Group__0__Impl rule__MethodType__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1478:2: rule__MethodType__Group__0__Impl rule__MethodType__Group__1
            {
            pushFollow(FOLLOW_rule__MethodType__Group__0__Impl_in_rule__MethodType__Group__02866);
            rule__MethodType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodType__Group__1_in_rule__MethodType__Group__02869);
            rule__MethodType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodType__Group__0"


    // $ANTLR start "rule__MethodType__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1485:1: rule__MethodType__Group__0__Impl : ( () ) ;
    public final void rule__MethodType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1489:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1490:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1490:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1491:1: ()
            {
             before(grammarAccess.getMethodTypeAccess().getMethodTypeAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1492:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1494:1: 
            {
            }

             after(grammarAccess.getMethodTypeAccess().getMethodTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodType__Group__0__Impl"


    // $ANTLR start "rule__MethodType__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1504:1: rule__MethodType__Group__1 : rule__MethodType__Group__1__Impl ;
    public final void rule__MethodType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1508:1: ( rule__MethodType__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1509:2: rule__MethodType__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MethodType__Group__1__Impl_in_rule__MethodType__Group__12927);
            rule__MethodType__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodType__Group__1"


    // $ANTLR start "rule__MethodType__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1515:1: rule__MethodType__Group__1__Impl : ( ( rule__MethodType__NameAssignment_1 ) ) ;
    public final void rule__MethodType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1519:1: ( ( ( rule__MethodType__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1520:1: ( ( rule__MethodType__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1520:1: ( ( rule__MethodType__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1521:1: ( rule__MethodType__NameAssignment_1 )
            {
             before(grammarAccess.getMethodTypeAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1522:1: ( rule__MethodType__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1522:2: rule__MethodType__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__MethodType__NameAssignment_1_in_rule__MethodType__Group__1__Impl2954);
            rule__MethodType__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMethodTypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodType__Group__1__Impl"


    // $ANTLR start "rule__UserSelection__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1536:1: rule__UserSelection__Group__0 : rule__UserSelection__Group__0__Impl rule__UserSelection__Group__1 ;
    public final void rule__UserSelection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1540:1: ( rule__UserSelection__Group__0__Impl rule__UserSelection__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1541:2: rule__UserSelection__Group__0__Impl rule__UserSelection__Group__1
            {
            pushFollow(FOLLOW_rule__UserSelection__Group__0__Impl_in_rule__UserSelection__Group__02988);
            rule__UserSelection__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UserSelection__Group__1_in_rule__UserSelection__Group__02991);
            rule__UserSelection__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelection__Group__0"


    // $ANTLR start "rule__UserSelection__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1548:1: rule__UserSelection__Group__0__Impl : ( () ) ;
    public final void rule__UserSelection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1552:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1553:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1553:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1554:1: ()
            {
             before(grammarAccess.getUserSelectionAccess().getUserSelectionAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1555:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1557:1: 
            {
            }

             after(grammarAccess.getUserSelectionAccess().getUserSelectionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelection__Group__0__Impl"


    // $ANTLR start "rule__UserSelection__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1567:1: rule__UserSelection__Group__1 : rule__UserSelection__Group__1__Impl ;
    public final void rule__UserSelection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1571:1: ( rule__UserSelection__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1572:2: rule__UserSelection__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__UserSelection__Group__1__Impl_in_rule__UserSelection__Group__13049);
            rule__UserSelection__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelection__Group__1"


    // $ANTLR start "rule__UserSelection__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1578:1: rule__UserSelection__Group__1__Impl : ( ( rule__UserSelection__NameAssignment_1 ) ) ;
    public final void rule__UserSelection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1582:1: ( ( ( rule__UserSelection__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1583:1: ( ( rule__UserSelection__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1583:1: ( ( rule__UserSelection__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1584:1: ( rule__UserSelection__NameAssignment_1 )
            {
             before(grammarAccess.getUserSelectionAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1585:1: ( rule__UserSelection__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1585:2: rule__UserSelection__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__UserSelection__NameAssignment_1_in_rule__UserSelection__Group__1__Impl3076);
            rule__UserSelection__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUserSelectionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelection__Group__1__Impl"


    // $ANTLR start "rule__QualityAttribute__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1599:1: rule__QualityAttribute__Group__0 : rule__QualityAttribute__Group__0__Impl rule__QualityAttribute__Group__1 ;
    public final void rule__QualityAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1603:1: ( rule__QualityAttribute__Group__0__Impl rule__QualityAttribute__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1604:2: rule__QualityAttribute__Group__0__Impl rule__QualityAttribute__Group__1
            {
            pushFollow(FOLLOW_rule__QualityAttribute__Group__0__Impl_in_rule__QualityAttribute__Group__03110);
            rule__QualityAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityAttribute__Group__1_in_rule__QualityAttribute__Group__03113);
            rule__QualityAttribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttribute__Group__0"


    // $ANTLR start "rule__QualityAttribute__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1611:1: rule__QualityAttribute__Group__0__Impl : ( () ) ;
    public final void rule__QualityAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1615:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1616:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1616:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1617:1: ()
            {
             before(grammarAccess.getQualityAttributeAccess().getQualityAttributeAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1618:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1620:1: 
            {
            }

             after(grammarAccess.getQualityAttributeAccess().getQualityAttributeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttribute__Group__0__Impl"


    // $ANTLR start "rule__QualityAttribute__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1630:1: rule__QualityAttribute__Group__1 : rule__QualityAttribute__Group__1__Impl ;
    public final void rule__QualityAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1634:1: ( rule__QualityAttribute__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1635:2: rule__QualityAttribute__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualityAttribute__Group__1__Impl_in_rule__QualityAttribute__Group__13171);
            rule__QualityAttribute__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttribute__Group__1"


    // $ANTLR start "rule__QualityAttribute__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1641:1: rule__QualityAttribute__Group__1__Impl : ( ( rule__QualityAttribute__NameAssignment_1 ) ) ;
    public final void rule__QualityAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1645:1: ( ( ( rule__QualityAttribute__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1646:1: ( ( rule__QualityAttribute__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1646:1: ( ( rule__QualityAttribute__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1647:1: ( rule__QualityAttribute__NameAssignment_1 )
            {
             before(grammarAccess.getQualityAttributeAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1648:1: ( rule__QualityAttribute__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1648:2: rule__QualityAttribute__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__QualityAttribute__NameAssignment_1_in_rule__QualityAttribute__Group__1__Impl3198);
            rule__QualityAttribute__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQualityAttributeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttribute__Group__1__Impl"


    // $ANTLR start "rule__DevelopmentPhase__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1662:1: rule__DevelopmentPhase__Group__0 : rule__DevelopmentPhase__Group__0__Impl rule__DevelopmentPhase__Group__1 ;
    public final void rule__DevelopmentPhase__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1666:1: ( rule__DevelopmentPhase__Group__0__Impl rule__DevelopmentPhase__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1667:2: rule__DevelopmentPhase__Group__0__Impl rule__DevelopmentPhase__Group__1
            {
            pushFollow(FOLLOW_rule__DevelopmentPhase__Group__0__Impl_in_rule__DevelopmentPhase__Group__03232);
            rule__DevelopmentPhase__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DevelopmentPhase__Group__1_in_rule__DevelopmentPhase__Group__03235);
            rule__DevelopmentPhase__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhase__Group__0"


    // $ANTLR start "rule__DevelopmentPhase__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1674:1: rule__DevelopmentPhase__Group__0__Impl : ( () ) ;
    public final void rule__DevelopmentPhase__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1678:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1679:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1679:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1680:1: ()
            {
             before(grammarAccess.getDevelopmentPhaseAccess().getDevelopmentPhaseAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1681:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1683:1: 
            {
            }

             after(grammarAccess.getDevelopmentPhaseAccess().getDevelopmentPhaseAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhase__Group__0__Impl"


    // $ANTLR start "rule__DevelopmentPhase__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1693:1: rule__DevelopmentPhase__Group__1 : rule__DevelopmentPhase__Group__1__Impl ;
    public final void rule__DevelopmentPhase__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1697:1: ( rule__DevelopmentPhase__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1698:2: rule__DevelopmentPhase__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DevelopmentPhase__Group__1__Impl_in_rule__DevelopmentPhase__Group__13293);
            rule__DevelopmentPhase__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhase__Group__1"


    // $ANTLR start "rule__DevelopmentPhase__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1704:1: rule__DevelopmentPhase__Group__1__Impl : ( ( rule__DevelopmentPhase__NameAssignment_1 ) ) ;
    public final void rule__DevelopmentPhase__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1708:1: ( ( ( rule__DevelopmentPhase__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1709:1: ( ( rule__DevelopmentPhase__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1709:1: ( ( rule__DevelopmentPhase__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1710:1: ( rule__DevelopmentPhase__NameAssignment_1 )
            {
             before(grammarAccess.getDevelopmentPhaseAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1711:1: ( rule__DevelopmentPhase__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1711:2: rule__DevelopmentPhase__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__DevelopmentPhase__NameAssignment_1_in_rule__DevelopmentPhase__Group__1__Impl3320);
            rule__DevelopmentPhase__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDevelopmentPhaseAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhase__Group__1__Impl"


    // $ANTLR start "rule__CategoriesDefinitions__UnorderedGroup"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1733:1: rule__CategoriesDefinitions__UnorderedGroup : ( rule__CategoriesDefinitions__UnorderedGroup__0 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1738:1: ( ( rule__CategoriesDefinitions__UnorderedGroup__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1739:2: ( rule__CategoriesDefinitions__UnorderedGroup__0 )?
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1739:2: ( rule__CategoriesDefinitions__UnorderedGroup__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( LA6_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt6=1;
            }
            else if ( LA6_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt6=1;
            }
            else if ( LA6_0 ==User && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt6=1;
            }
            else if ( LA6_0 ==Development && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt6=1;
            }
            else if ( LA6_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1739:2: rule__CategoriesDefinitions__UnorderedGroup__0
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__0_in_rule__CategoriesDefinitions__UnorderedGroup3362);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1749:1: rule__CategoriesDefinitions__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4 ) ) ) ) ) ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1754:1: ( ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4 ) ) ) ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1755:3: ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4 ) ) ) ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1755:3: ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4 ) ) ) ) )
            int alt7=5;
            int LA7_0 = input.LA(1);

            if ( LA7_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt7=1;
            }
            else if ( LA7_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt7=2;
            }
            else if ( LA7_0 ==User && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt7=3;
            }
            else if ( LA7_0 ==Development && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt7=4;
            }
            else if ( LA7_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt7=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1757:4: ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1757:4: ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1758:5: {...}? => ( ( ( rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1758:116: ( ( ( rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1759:6: ( ( rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1765:6: ( ( rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1767:7: ( rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getRequirementTypeCategoriesAssignment_0()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1768:7: ( rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1768:8: rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0_in_rule__CategoriesDefinitions__UnorderedGroup__Impl3449);
                    rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getRequirementTypeCategoriesAssignment_0()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1777:4: ({...}? => ( ( ( rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1777:4: ({...}? => ( ( ( rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1778:5: {...}? => ( ( ( rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1778:116: ( ( ( rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1779:6: ( ( rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1785:6: ( ( rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1787:7: ( rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getMethodTypeCategoriesAssignment_1()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1788:7: ( rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1788:8: rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1_in_rule__CategoriesDefinitions__UnorderedGroup__Impl3547);
                    rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getMethodTypeCategoriesAssignment_1()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1797:4: ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1797:4: ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1798:5: {...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1798:116: ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1799:6: ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1805:6: ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1807:7: ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesAssignment_2()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1808:7: ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1808:8: rule__CategoriesDefinitions__SelectioncategoriesAssignment_2
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__SelectioncategoriesAssignment_2_in_rule__CategoriesDefinitions__UnorderedGroup__Impl3645);
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1817:4: ({...}? => ( ( ( rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1817:4: ({...}? => ( ( ( rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1818:5: {...}? => ( ( ( rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1818:116: ( ( ( rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1819:6: ( ( rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1825:6: ( ( rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1827:7: ( rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getDevelopmentPhaseCategoriesAssignment_3()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1828:7: ( rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1828:8: rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3_in_rule__CategoriesDefinitions__UnorderedGroup__Impl3743);
                    rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getDevelopmentPhaseCategoriesAssignment_3()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1837:4: ({...}? => ( ( ( rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1837:4: ({...}? => ( ( ( rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1838:5: {...}? => ( ( ( rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1838:116: ( ( ( rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1839:6: ( ( rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1845:6: ( ( rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1847:7: ( rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getQualityAttributeCategoriesAssignment_4()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1848:7: ( rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1848:8: rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4_in_rule__CategoriesDefinitions__UnorderedGroup__Impl3841);
                    rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getQualityAttributeCategoriesAssignment_4()); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1866:1: rule__CategoriesDefinitions__UnorderedGroup__0 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1870:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1871:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__03907);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1872:2: ( rule__CategoriesDefinitions__UnorderedGroup__1 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( LA8_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt8=1;
            }
            else if ( LA8_0 ==User && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Development && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1872:2: rule__CategoriesDefinitions__UnorderedGroup__1
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__1_in_rule__CategoriesDefinitions__UnorderedGroup__03910);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1879:1: rule__CategoriesDefinitions__UnorderedGroup__1 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1883:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1884:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__13935);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1885:2: ( rule__CategoriesDefinitions__UnorderedGroup__2 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( LA9_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt9=1;
            }
            else if ( LA9_0 ==User && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Development && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1885:2: rule__CategoriesDefinitions__UnorderedGroup__2
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__2_in_rule__CategoriesDefinitions__UnorderedGroup__13938);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1892:1: rule__CategoriesDefinitions__UnorderedGroup__2 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__3 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1896:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__3 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1897:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__3 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__23963);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1898:2: ( rule__CategoriesDefinitions__UnorderedGroup__3 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( LA10_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt10=1;
            }
            else if ( LA10_0 ==User && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Development && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1898:2: rule__CategoriesDefinitions__UnorderedGroup__3
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__3_in_rule__CategoriesDefinitions__UnorderedGroup__23966);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1905:1: rule__CategoriesDefinitions__UnorderedGroup__3 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__4 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1909:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__4 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1910:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__4 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__33991);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1911:2: ( rule__CategoriesDefinitions__UnorderedGroup__4 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( LA11_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt11=1;
            }
            else if ( LA11_0 ==User && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Development && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1911:2: rule__CategoriesDefinitions__UnorderedGroup__4
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__4_in_rule__CategoriesDefinitions__UnorderedGroup__33994);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1918:1: rule__CategoriesDefinitions__UnorderedGroup__4 : rule__CategoriesDefinitions__UnorderedGroup__Impl ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1922:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1923:2: rule__CategoriesDefinitions__UnorderedGroup__Impl
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__44019);
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
    // $ANTLR end "rule__CategoriesDefinitions__UnorderedGroup__4"


    // $ANTLR start "rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1941:1: rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0 : ( ruleRequirementTypeCategories ) ;
    public final void rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1945:1: ( ( ruleRequirementTypeCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1946:1: ( ruleRequirementTypeCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1946:1: ( ruleRequirementTypeCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1947:1: ruleRequirementTypeCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getRequirementTypeCategoriesRequirementTypeCategoriesParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleRequirementTypeCategories_in_rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_04058);
            ruleRequirementTypeCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getRequirementTypeCategoriesRequirementTypeCategoriesParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0"


    // $ANTLR start "rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1956:1: rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1 : ( ruleMethodTypeCategories ) ;
    public final void rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1960:1: ( ( ruleMethodTypeCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1961:1: ( ruleMethodTypeCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1961:1: ( ruleMethodTypeCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1962:1: ruleMethodTypeCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getMethodTypeCategoriesMethodTypeCategoriesParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMethodTypeCategories_in_rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_14089);
            ruleMethodTypeCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getMethodTypeCategoriesMethodTypeCategoriesParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1"


    // $ANTLR start "rule__CategoriesDefinitions__SelectioncategoriesAssignment_2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1971:1: rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 : ( ruleUserSelectionCategories ) ;
    public final void rule__CategoriesDefinitions__SelectioncategoriesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1975:1: ( ( ruleUserSelectionCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1976:1: ( ruleUserSelectionCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1976:1: ( ruleUserSelectionCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1977:1: ruleUserSelectionCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesUserSelectionCategoriesParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleUserSelectionCategories_in_rule__CategoriesDefinitions__SelectioncategoriesAssignment_24120);
            ruleUserSelectionCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesUserSelectionCategoriesParserRuleCall_2_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1986:1: rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3 : ( ruleDevelopmentPhaseCategories ) ;
    public final void rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1990:1: ( ( ruleDevelopmentPhaseCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1991:1: ( ruleDevelopmentPhaseCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1991:1: ( ruleDevelopmentPhaseCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1992:1: ruleDevelopmentPhaseCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getDevelopmentPhaseCategoriesDevelopmentPhaseCategoriesParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDevelopmentPhaseCategories_in_rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_34151);
            ruleDevelopmentPhaseCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getDevelopmentPhaseCategoriesDevelopmentPhaseCategoriesParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3"


    // $ANTLR start "rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2001:1: rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4 : ( ruleQualityAttributeCategories ) ;
    public final void rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2005:1: ( ( ruleQualityAttributeCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2006:1: ( ruleQualityAttributeCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2006:1: ( ruleQualityAttributeCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2007:1: ruleQualityAttributeCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getQualityAttributeCategoriesQualityAttributeCategoriesParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleQualityAttributeCategories_in_rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_44182);
            ruleQualityAttributeCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getQualityAttributeCategoriesQualityAttributeCategoriesParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4"


    // $ANTLR start "rule__RequirementTypeCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2016:1: rule__RequirementTypeCategories__CategoryAssignment_4 : ( ruleRequirementType ) ;
    public final void rule__RequirementTypeCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2020:1: ( ( ruleRequirementType ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2021:1: ( ruleRequirementType )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2021:1: ( ruleRequirementType )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2022:1: ruleRequirementType
            {
             before(grammarAccess.getRequirementTypeCategoriesAccess().getCategoryRequirementTypeParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleRequirementType_in_rule__RequirementTypeCategories__CategoryAssignment_44213);
            ruleRequirementType();

            state._fsp--;

             after(grammarAccess.getRequirementTypeCategoriesAccess().getCategoryRequirementTypeParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementTypeCategories__CategoryAssignment_4"


    // $ANTLR start "rule__MethodTypeCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2031:1: rule__MethodTypeCategories__CategoryAssignment_4 : ( ruleMethodType ) ;
    public final void rule__MethodTypeCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2035:1: ( ( ruleMethodType ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2036:1: ( ruleMethodType )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2036:1: ( ruleMethodType )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2037:1: ruleMethodType
            {
             before(grammarAccess.getMethodTypeCategoriesAccess().getCategoryMethodTypeParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleMethodType_in_rule__MethodTypeCategories__CategoryAssignment_44244);
            ruleMethodType();

            state._fsp--;

             after(grammarAccess.getMethodTypeCategoriesAccess().getCategoryMethodTypeParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodTypeCategories__CategoryAssignment_4"


    // $ANTLR start "rule__UserSelectionCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2046:1: rule__UserSelectionCategories__CategoryAssignment_4 : ( ruleUserSelection ) ;
    public final void rule__UserSelectionCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2050:1: ( ( ruleUserSelection ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2051:1: ( ruleUserSelection )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2051:1: ( ruleUserSelection )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2052:1: ruleUserSelection
            {
             before(grammarAccess.getUserSelectionCategoriesAccess().getCategoryUserSelectionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleUserSelection_in_rule__UserSelectionCategories__CategoryAssignment_44275);
            ruleUserSelection();

            state._fsp--;

             after(grammarAccess.getUserSelectionCategoriesAccess().getCategoryUserSelectionParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelectionCategories__CategoryAssignment_4"


    // $ANTLR start "rule__QualityAttributeCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2061:1: rule__QualityAttributeCategories__CategoryAssignment_4 : ( ruleQualityAttribute ) ;
    public final void rule__QualityAttributeCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2065:1: ( ( ruleQualityAttribute ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2066:1: ( ruleQualityAttribute )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2066:1: ( ruleQualityAttribute )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2067:1: ruleQualityAttribute
            {
             before(grammarAccess.getQualityAttributeCategoriesAccess().getCategoryQualityAttributeParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleQualityAttribute_in_rule__QualityAttributeCategories__CategoryAssignment_44306);
            ruleQualityAttribute();

            state._fsp--;

             after(grammarAccess.getQualityAttributeCategoriesAccess().getCategoryQualityAttributeParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttributeCategories__CategoryAssignment_4"


    // $ANTLR start "rule__DevelopmentPhaseCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2076:1: rule__DevelopmentPhaseCategories__CategoryAssignment_4 : ( ruleDevelopmentPhase ) ;
    public final void rule__DevelopmentPhaseCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2080:1: ( ( ruleDevelopmentPhase ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2081:1: ( ruleDevelopmentPhase )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2081:1: ( ruleDevelopmentPhase )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2082:1: ruleDevelopmentPhase
            {
             before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getCategoryDevelopmentPhaseParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleDevelopmentPhase_in_rule__DevelopmentPhaseCategories__CategoryAssignment_44337);
            ruleDevelopmentPhase();

            state._fsp--;

             after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getCategoryDevelopmentPhaseParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhaseCategories__CategoryAssignment_4"


    // $ANTLR start "rule__RequirementType__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2091:1: rule__RequirementType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RequirementType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2095:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2096:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2096:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2097:1: RULE_ID
            {
             before(grammarAccess.getRequirementTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RequirementType__NameAssignment_14368); 
             after(grammarAccess.getRequirementTypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementType__NameAssignment_1"


    // $ANTLR start "rule__MethodType__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2106:1: rule__MethodType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__MethodType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2110:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2111:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2111:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2112:1: RULE_ID
            {
             before(grammarAccess.getMethodTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MethodType__NameAssignment_14399); 
             after(grammarAccess.getMethodTypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodType__NameAssignment_1"


    // $ANTLR start "rule__UserSelection__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2121:1: rule__UserSelection__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__UserSelection__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2125:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2126:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2126:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2127:1: RULE_ID
            {
             before(grammarAccess.getUserSelectionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__UserSelection__NameAssignment_14430); 
             after(grammarAccess.getUserSelectionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserSelection__NameAssignment_1"


    // $ANTLR start "rule__QualityAttribute__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2136:1: rule__QualityAttribute__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__QualityAttribute__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2140:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2141:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2141:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2142:1: RULE_ID
            {
             before(grammarAccess.getQualityAttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualityAttribute__NameAssignment_14461); 
             after(grammarAccess.getQualityAttributeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityAttribute__NameAssignment_1"


    // $ANTLR start "rule__DevelopmentPhase__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2151:1: rule__DevelopmentPhase__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DevelopmentPhase__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2155:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2156:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2156:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2157:1: RULE_ID
            {
             before(grammarAccess.getDevelopmentPhaseAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DevelopmentPhase__NameAssignment_14492); 
             after(grammarAccess.getDevelopmentPhaseAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DevelopmentPhase__NameAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleCategoriesDefinitions_in_entryRuleCategoriesDefinitions54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategoriesDefinitions61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup_in_ruleCategoriesDefinitions91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementTypeCategories_in_entryRuleRequirementTypeCategories118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementTypeCategories125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementTypeCategories__Group__0_in_ruleRequirementTypeCategories155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodTypeCategories_in_entryRuleMethodTypeCategories182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodTypeCategories189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodTypeCategories__Group__0_in_ruleMethodTypeCategories219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUserSelectionCategories_in_entryRuleUserSelectionCategories246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUserSelectionCategories253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserSelectionCategories__Group__0_in_ruleUserSelectionCategories283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityAttributeCategories_in_entryRuleQualityAttributeCategories310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualityAttributeCategories317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityAttributeCategories__Group__0_in_ruleQualityAttributeCategories347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDevelopmentPhaseCategories_in_entryRuleDevelopmentPhaseCategories374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDevelopmentPhaseCategories381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DevelopmentPhaseCategories__Group__0_in_ruleDevelopmentPhaseCategories411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementType_in_entryRuleRequirementType438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementType445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementType__Group__0_in_ruleRequirementType475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodType_in_entryRuleMethodType502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodType509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodType__Group__0_in_ruleMethodType539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUserSelection_in_entryRuleUserSelection566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUserSelection573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserSelection__Group__0_in_ruleUserSelection603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityAttribute_in_entryRuleQualityAttribute630 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualityAttribute637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityAttribute__Group__0_in_ruleQualityAttribute667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDevelopmentPhase_in_entryRuleDevelopmentPhase694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDevelopmentPhase701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DevelopmentPhase__Group__0_in_ruleDevelopmentPhase731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementTypeCategories__Group__0__Impl_in_rule__RequirementTypeCategories__Group__0769 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RequirementTypeCategories__Group__1_in_rule__RequirementTypeCategories__Group__0772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementTypeCategories__Group__1__Impl_in_rule__RequirementTypeCategories__Group__1830 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__RequirementTypeCategories__Group__2_in_rule__RequirementTypeCategories__Group__1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_rule__RequirementTypeCategories__Group__1__Impl861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementTypeCategories__Group__2__Impl_in_rule__RequirementTypeCategories__Group__2892 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__RequirementTypeCategories__Group__3_in_rule__RequirementTypeCategories__Group__2895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Type_in_rule__RequirementTypeCategories__Group__2__Impl923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementTypeCategories__Group__3__Impl_in_rule__RequirementTypeCategories__Group__3954 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__RequirementTypeCategories__Group__4_in_rule__RequirementTypeCategories__Group__3957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__RequirementTypeCategories__Group__3__Impl985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementTypeCategories__Group__4__Impl_in_rule__RequirementTypeCategories__Group__41016 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__RequirementTypeCategories__Group__5_in_rule__RequirementTypeCategories__Group__41019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementTypeCategories__CategoryAssignment_4_in_rule__RequirementTypeCategories__Group__4__Impl1048 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__RequirementTypeCategories__CategoryAssignment_4_in_rule__RequirementTypeCategories__Group__4__Impl1060 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__RequirementTypeCategories__Group__5__Impl_in_rule__RequirementTypeCategories__Group__51093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__RequirementTypeCategories__Group__5__Impl1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodTypeCategories__Group__0__Impl_in_rule__MethodTypeCategories__Group__01164 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__MethodTypeCategories__Group__1_in_rule__MethodTypeCategories__Group__01167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodTypeCategories__Group__1__Impl_in_rule__MethodTypeCategories__Group__11225 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__MethodTypeCategories__Group__2_in_rule__MethodTypeCategories__Group__11228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Method_in_rule__MethodTypeCategories__Group__1__Impl1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodTypeCategories__Group__2__Impl_in_rule__MethodTypeCategories__Group__21287 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__MethodTypeCategories__Group__3_in_rule__MethodTypeCategories__Group__21290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Type_in_rule__MethodTypeCategories__Group__2__Impl1318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodTypeCategories__Group__3__Impl_in_rule__MethodTypeCategories__Group__31349 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__MethodTypeCategories__Group__4_in_rule__MethodTypeCategories__Group__31352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__MethodTypeCategories__Group__3__Impl1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodTypeCategories__Group__4__Impl_in_rule__MethodTypeCategories__Group__41411 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__MethodTypeCategories__Group__5_in_rule__MethodTypeCategories__Group__41414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodTypeCategories__CategoryAssignment_4_in_rule__MethodTypeCategories__Group__4__Impl1443 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__MethodTypeCategories__CategoryAssignment_4_in_rule__MethodTypeCategories__Group__4__Impl1455 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__MethodTypeCategories__Group__5__Impl_in_rule__MethodTypeCategories__Group__51488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__MethodTypeCategories__Group__5__Impl1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserSelectionCategories__Group__0__Impl_in_rule__UserSelectionCategories__Group__01559 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__UserSelectionCategories__Group__1_in_rule__UserSelectionCategories__Group__01562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserSelectionCategories__Group__1__Impl_in_rule__UserSelectionCategories__Group__11620 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__UserSelectionCategories__Group__2_in_rule__UserSelectionCategories__Group__11623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_User_in_rule__UserSelectionCategories__Group__1__Impl1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserSelectionCategories__Group__2__Impl_in_rule__UserSelectionCategories__Group__21682 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__UserSelectionCategories__Group__3_in_rule__UserSelectionCategories__Group__21685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Selection_in_rule__UserSelectionCategories__Group__2__Impl1713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserSelectionCategories__Group__3__Impl_in_rule__UserSelectionCategories__Group__31744 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__UserSelectionCategories__Group__4_in_rule__UserSelectionCategories__Group__31747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__UserSelectionCategories__Group__3__Impl1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserSelectionCategories__Group__4__Impl_in_rule__UserSelectionCategories__Group__41806 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__UserSelectionCategories__Group__5_in_rule__UserSelectionCategories__Group__41809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserSelectionCategories__CategoryAssignment_4_in_rule__UserSelectionCategories__Group__4__Impl1838 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__UserSelectionCategories__CategoryAssignment_4_in_rule__UserSelectionCategories__Group__4__Impl1850 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__UserSelectionCategories__Group__5__Impl_in_rule__UserSelectionCategories__Group__51883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__UserSelectionCategories__Group__5__Impl1911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityAttributeCategories__Group__0__Impl_in_rule__QualityAttributeCategories__Group__01954 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__QualityAttributeCategories__Group__1_in_rule__QualityAttributeCategories__Group__01957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityAttributeCategories__Group__1__Impl_in_rule__QualityAttributeCategories__Group__12015 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__QualityAttributeCategories__Group__2_in_rule__QualityAttributeCategories__Group__12018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Quality_in_rule__QualityAttributeCategories__Group__1__Impl2046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityAttributeCategories__Group__2__Impl_in_rule__QualityAttributeCategories__Group__22077 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__QualityAttributeCategories__Group__3_in_rule__QualityAttributeCategories__Group__22080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Attribute_in_rule__QualityAttributeCategories__Group__2__Impl2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityAttributeCategories__Group__3__Impl_in_rule__QualityAttributeCategories__Group__32139 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__QualityAttributeCategories__Group__4_in_rule__QualityAttributeCategories__Group__32142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__QualityAttributeCategories__Group__3__Impl2170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityAttributeCategories__Group__4__Impl_in_rule__QualityAttributeCategories__Group__42201 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__QualityAttributeCategories__Group__5_in_rule__QualityAttributeCategories__Group__42204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityAttributeCategories__CategoryAssignment_4_in_rule__QualityAttributeCategories__Group__4__Impl2233 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__QualityAttributeCategories__CategoryAssignment_4_in_rule__QualityAttributeCategories__Group__4__Impl2245 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__QualityAttributeCategories__Group__5__Impl_in_rule__QualityAttributeCategories__Group__52278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__QualityAttributeCategories__Group__5__Impl2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DevelopmentPhaseCategories__Group__0__Impl_in_rule__DevelopmentPhaseCategories__Group__02349 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DevelopmentPhaseCategories__Group__1_in_rule__DevelopmentPhaseCategories__Group__02352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DevelopmentPhaseCategories__Group__1__Impl_in_rule__DevelopmentPhaseCategories__Group__12410 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__DevelopmentPhaseCategories__Group__2_in_rule__DevelopmentPhaseCategories__Group__12413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Development_in_rule__DevelopmentPhaseCategories__Group__1__Impl2441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DevelopmentPhaseCategories__Group__2__Impl_in_rule__DevelopmentPhaseCategories__Group__22472 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__DevelopmentPhaseCategories__Group__3_in_rule__DevelopmentPhaseCategories__Group__22475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Phase_in_rule__DevelopmentPhaseCategories__Group__2__Impl2503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DevelopmentPhaseCategories__Group__3__Impl_in_rule__DevelopmentPhaseCategories__Group__32534 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__DevelopmentPhaseCategories__Group__4_in_rule__DevelopmentPhaseCategories__Group__32537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__DevelopmentPhaseCategories__Group__3__Impl2565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DevelopmentPhaseCategories__Group__4__Impl_in_rule__DevelopmentPhaseCategories__Group__42596 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__DevelopmentPhaseCategories__Group__5_in_rule__DevelopmentPhaseCategories__Group__42599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DevelopmentPhaseCategories__CategoryAssignment_4_in_rule__DevelopmentPhaseCategories__Group__4__Impl2628 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__DevelopmentPhaseCategories__CategoryAssignment_4_in_rule__DevelopmentPhaseCategories__Group__4__Impl2640 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__DevelopmentPhaseCategories__Group__5__Impl_in_rule__DevelopmentPhaseCategories__Group__52673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__DevelopmentPhaseCategories__Group__5__Impl2701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementType__Group__0__Impl_in_rule__RequirementType__Group__02744 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__RequirementType__Group__1_in_rule__RequirementType__Group__02747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementType__Group__1__Impl_in_rule__RequirementType__Group__12805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementType__NameAssignment_1_in_rule__RequirementType__Group__1__Impl2832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodType__Group__0__Impl_in_rule__MethodType__Group__02866 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__MethodType__Group__1_in_rule__MethodType__Group__02869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodType__Group__1__Impl_in_rule__MethodType__Group__12927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodType__NameAssignment_1_in_rule__MethodType__Group__1__Impl2954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserSelection__Group__0__Impl_in_rule__UserSelection__Group__02988 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__UserSelection__Group__1_in_rule__UserSelection__Group__02991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserSelection__Group__1__Impl_in_rule__UserSelection__Group__13049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserSelection__NameAssignment_1_in_rule__UserSelection__Group__1__Impl3076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityAttribute__Group__0__Impl_in_rule__QualityAttribute__Group__03110 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__QualityAttribute__Group__1_in_rule__QualityAttribute__Group__03113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityAttribute__Group__1__Impl_in_rule__QualityAttribute__Group__13171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityAttribute__NameAssignment_1_in_rule__QualityAttribute__Group__1__Impl3198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DevelopmentPhase__Group__0__Impl_in_rule__DevelopmentPhase__Group__03232 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__DevelopmentPhase__Group__1_in_rule__DevelopmentPhase__Group__03235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DevelopmentPhase__Group__1__Impl_in_rule__DevelopmentPhase__Group__13293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DevelopmentPhase__NameAssignment_1_in_rule__DevelopmentPhase__Group__1__Impl3320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__0_in_rule__CategoriesDefinitions__UnorderedGroup3362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0_in_rule__CategoriesDefinitions__UnorderedGroup__Impl3449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1_in_rule__CategoriesDefinitions__UnorderedGroup__Impl3547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__SelectioncategoriesAssignment_2_in_rule__CategoriesDefinitions__UnorderedGroup__Impl3645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3_in_rule__CategoriesDefinitions__UnorderedGroup__Impl3743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4_in_rule__CategoriesDefinitions__UnorderedGroup__Impl3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__03907 = new BitSet(new long[]{0x0000000000001332L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__1_in_rule__CategoriesDefinitions__UnorderedGroup__03910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__13935 = new BitSet(new long[]{0x0000000000001332L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__2_in_rule__CategoriesDefinitions__UnorderedGroup__13938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__23963 = new BitSet(new long[]{0x0000000000001332L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__3_in_rule__CategoriesDefinitions__UnorderedGroup__23966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__33991 = new BitSet(new long[]{0x0000000000001332L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__4_in_rule__CategoriesDefinitions__UnorderedGroup__33994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__44019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementTypeCategories_in_rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_04058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodTypeCategories_in_rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_14089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUserSelectionCategories_in_rule__CategoriesDefinitions__SelectioncategoriesAssignment_24120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDevelopmentPhaseCategories_in_rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_34151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityAttributeCategories_in_rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_44182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementType_in_rule__RequirementTypeCategories__CategoryAssignment_44213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodType_in_rule__MethodTypeCategories__CategoryAssignment_44244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUserSelection_in_rule__UserSelectionCategories__CategoryAssignment_44275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityAttribute_in_rule__QualityAttributeCategories__CategoryAssignment_44306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDevelopmentPhase_in_rule__DevelopmentPhaseCategories__CategoryAssignment_44337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RequirementType__NameAssignment_14368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MethodType__NameAssignment_14399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__UserSelection__NameAssignment_14430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualityAttribute__NameAssignment_14461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DevelopmentPhase__NameAssignment_14492 = new BitSet(new long[]{0x0000000000000002L});

}

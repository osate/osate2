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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Category", "Quality", "Phase", "Any", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Category=4;
    public static final int Phase=6;
    public static final int RULE_ID=10;
    public static final int RULE_WS=15;
    public static final int RULE_STRING=12;
    public static final int RULE_ANY_OTHER=16;
    public static final int Any=7;
    public static final int RULE_SL_COMMENT=14;
    public static final int Quality=5;
    public static final int RULE_INT=11;
    public static final int RULE_ML_COMMENT=13;
    public static final int LeftSquareBracket=8;
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
    		tokenNameToValue.put("Phase", "'phase'");
    		tokenNameToValue.put("Quality", "'quality'");
    		tokenNameToValue.put("Category", "'category'");
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:80:1: entryRuleCategoriesDefinitions : ruleCategoriesDefinitions EOF ;
    public final void entryRuleCategoriesDefinitions() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:81:1: ( ruleCategoriesDefinitions EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:82:1: ruleCategoriesDefinitions EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:89:1: ruleCategoriesDefinitions : ( ( rule__CategoriesDefinitions__UnorderedGroup ) ) ;
    public final void ruleCategoriesDefinitions() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:93:5: ( ( ( rule__CategoriesDefinitions__UnorderedGroup ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:94:1: ( ( rule__CategoriesDefinitions__UnorderedGroup ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:94:1: ( ( rule__CategoriesDefinitions__UnorderedGroup ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:95:1: ( rule__CategoriesDefinitions__UnorderedGroup )
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:96:1: ( rule__CategoriesDefinitions__UnorderedGroup )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:96:2: rule__CategoriesDefinitions__UnorderedGroup
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


    // $ANTLR start "entryRuleUserCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:108:1: entryRuleUserCategories : ruleUserCategories EOF ;
    public final void entryRuleUserCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:109:1: ( ruleUserCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:110:1: ruleUserCategories EOF
            {
             before(grammarAccess.getUserCategoriesRule()); 
            pushFollow(FOLLOW_ruleUserCategories_in_entryRuleUserCategories118);
            ruleUserCategories();

            state._fsp--;

             after(grammarAccess.getUserCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUserCategories125); 

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
    // $ANTLR end "entryRuleUserCategories"


    // $ANTLR start "ruleUserCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:117:1: ruleUserCategories : ( ( rule__UserCategories__Group__0 ) ) ;
    public final void ruleUserCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:121:5: ( ( ( rule__UserCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:122:1: ( ( rule__UserCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:122:1: ( ( rule__UserCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:123:1: ( rule__UserCategories__Group__0 )
            {
             before(grammarAccess.getUserCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:124:1: ( rule__UserCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:124:2: rule__UserCategories__Group__0
            {
            pushFollow(FOLLOW_rule__UserCategories__Group__0_in_ruleUserCategories155);
            rule__UserCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUserCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUserCategories"


    // $ANTLR start "entryRuleQualityCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:136:1: entryRuleQualityCategories : ruleQualityCategories EOF ;
    public final void entryRuleQualityCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:137:1: ( ruleQualityCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:138:1: ruleQualityCategories EOF
            {
             before(grammarAccess.getQualityCategoriesRule()); 
            pushFollow(FOLLOW_ruleQualityCategories_in_entryRuleQualityCategories182);
            ruleQualityCategories();

            state._fsp--;

             after(grammarAccess.getQualityCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualityCategories189); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:145:1: ruleQualityCategories : ( ( rule__QualityCategories__Group__0 ) ) ;
    public final void ruleQualityCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:149:5: ( ( ( rule__QualityCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:150:1: ( ( rule__QualityCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:150:1: ( ( rule__QualityCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:151:1: ( rule__QualityCategories__Group__0 )
            {
             before(grammarAccess.getQualityCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:152:1: ( rule__QualityCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:152:2: rule__QualityCategories__Group__0
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__0_in_ruleQualityCategories219);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:164:1: entryRulePhaseCategories : rulePhaseCategories EOF ;
    public final void entryRulePhaseCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:165:1: ( rulePhaseCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:166:1: rulePhaseCategories EOF
            {
             before(grammarAccess.getPhaseCategoriesRule()); 
            pushFollow(FOLLOW_rulePhaseCategories_in_entryRulePhaseCategories246);
            rulePhaseCategories();

            state._fsp--;

             after(grammarAccess.getPhaseCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhaseCategories253); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:173:1: rulePhaseCategories : ( ( rule__PhaseCategories__Group__0 ) ) ;
    public final void rulePhaseCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:177:5: ( ( ( rule__PhaseCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:178:1: ( ( rule__PhaseCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:178:1: ( ( rule__PhaseCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:179:1: ( rule__PhaseCategories__Group__0 )
            {
             before(grammarAccess.getPhaseCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:180:1: ( rule__PhaseCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:180:2: rule__PhaseCategories__Group__0
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__0_in_rulePhaseCategories283);
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


    // $ANTLR start "entryRuleUserCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:192:1: entryRuleUserCategory : ruleUserCategory EOF ;
    public final void entryRuleUserCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:193:1: ( ruleUserCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:194:1: ruleUserCategory EOF
            {
             before(grammarAccess.getUserCategoryRule()); 
            pushFollow(FOLLOW_ruleUserCategory_in_entryRuleUserCategory310);
            ruleUserCategory();

            state._fsp--;

             after(grammarAccess.getUserCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUserCategory317); 

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
    // $ANTLR end "entryRuleUserCategory"


    // $ANTLR start "ruleUserCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:201:1: ruleUserCategory : ( ( rule__UserCategory__Group__0 ) ) ;
    public final void ruleUserCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:205:5: ( ( ( rule__UserCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:206:1: ( ( rule__UserCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:206:1: ( ( rule__UserCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:207:1: ( rule__UserCategory__Group__0 )
            {
             before(grammarAccess.getUserCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:208:1: ( rule__UserCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:208:2: rule__UserCategory__Group__0
            {
            pushFollow(FOLLOW_rule__UserCategory__Group__0_in_ruleUserCategory347);
            rule__UserCategory__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUserCategoryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUserCategory"


    // $ANTLR start "entryRuleQualityCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:220:1: entryRuleQualityCategory : ruleQualityCategory EOF ;
    public final void entryRuleQualityCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:221:1: ( ruleQualityCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:222:1: ruleQualityCategory EOF
            {
             before(grammarAccess.getQualityCategoryRule()); 
            pushFollow(FOLLOW_ruleQualityCategory_in_entryRuleQualityCategory374);
            ruleQualityCategory();

            state._fsp--;

             after(grammarAccess.getQualityCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualityCategory381); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:229:1: ruleQualityCategory : ( ( rule__QualityCategory__Group__0 ) ) ;
    public final void ruleQualityCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:233:5: ( ( ( rule__QualityCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:234:1: ( ( rule__QualityCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:234:1: ( ( rule__QualityCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:235:1: ( rule__QualityCategory__Group__0 )
            {
             before(grammarAccess.getQualityCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:236:1: ( rule__QualityCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:236:2: rule__QualityCategory__Group__0
            {
            pushFollow(FOLLOW_rule__QualityCategory__Group__0_in_ruleQualityCategory411);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:248:1: entryRulePhaseCategory : rulePhaseCategory EOF ;
    public final void entryRulePhaseCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:249:1: ( rulePhaseCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:250:1: rulePhaseCategory EOF
            {
             before(grammarAccess.getPhaseCategoryRule()); 
            pushFollow(FOLLOW_rulePhaseCategory_in_entryRulePhaseCategory438);
            rulePhaseCategory();

            state._fsp--;

             after(grammarAccess.getPhaseCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhaseCategory445); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:257:1: rulePhaseCategory : ( ( rule__PhaseCategory__Group__0 ) ) ;
    public final void rulePhaseCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:261:5: ( ( ( rule__PhaseCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:262:1: ( ( rule__PhaseCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:262:1: ( ( rule__PhaseCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:263:1: ( rule__PhaseCategory__Group__0 )
            {
             before(grammarAccess.getPhaseCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:264:1: ( rule__PhaseCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:264:2: rule__PhaseCategory__Group__0
            {
            pushFollow(FOLLOW_rule__PhaseCategory__Group__0_in_rulePhaseCategory475);
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


    // $ANTLR start "rule__UserCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:282:1: rule__UserCategories__Group__0 : rule__UserCategories__Group__0__Impl rule__UserCategories__Group__1 ;
    public final void rule__UserCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:286:1: ( rule__UserCategories__Group__0__Impl rule__UserCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:287:2: rule__UserCategories__Group__0__Impl rule__UserCategories__Group__1
            {
            pushFollow(FOLLOW_rule__UserCategories__Group__0__Impl_in_rule__UserCategories__Group__0513);
            rule__UserCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UserCategories__Group__1_in_rule__UserCategories__Group__0516);
            rule__UserCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserCategories__Group__0"


    // $ANTLR start "rule__UserCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:294:1: rule__UserCategories__Group__0__Impl : ( () ) ;
    public final void rule__UserCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:298:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:299:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:299:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:300:1: ()
            {
             before(grammarAccess.getUserCategoriesAccess().getUserCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:301:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:303:1: 
            {
            }

             after(grammarAccess.getUserCategoriesAccess().getUserCategoriesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserCategories__Group__0__Impl"


    // $ANTLR start "rule__UserCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:313:1: rule__UserCategories__Group__1 : rule__UserCategories__Group__1__Impl rule__UserCategories__Group__2 ;
    public final void rule__UserCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:317:1: ( rule__UserCategories__Group__1__Impl rule__UserCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:318:2: rule__UserCategories__Group__1__Impl rule__UserCategories__Group__2
            {
            pushFollow(FOLLOW_rule__UserCategories__Group__1__Impl_in_rule__UserCategories__Group__1574);
            rule__UserCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UserCategories__Group__2_in_rule__UserCategories__Group__1577);
            rule__UserCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserCategories__Group__1"


    // $ANTLR start "rule__UserCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:325:1: rule__UserCategories__Group__1__Impl : ( Category ) ;
    public final void rule__UserCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:329:1: ( ( Category ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:330:1: ( Category )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:330:1: ( Category )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:331:1: Category
            {
             before(grammarAccess.getUserCategoriesAccess().getCategoryKeyword_1()); 
            match(input,Category,FOLLOW_Category_in_rule__UserCategories__Group__1__Impl605); 
             after(grammarAccess.getUserCategoriesAccess().getCategoryKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserCategories__Group__1__Impl"


    // $ANTLR start "rule__UserCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:344:1: rule__UserCategories__Group__2 : rule__UserCategories__Group__2__Impl rule__UserCategories__Group__3 ;
    public final void rule__UserCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:348:1: ( rule__UserCategories__Group__2__Impl rule__UserCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:349:2: rule__UserCategories__Group__2__Impl rule__UserCategories__Group__3
            {
            pushFollow(FOLLOW_rule__UserCategories__Group__2__Impl_in_rule__UserCategories__Group__2636);
            rule__UserCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UserCategories__Group__3_in_rule__UserCategories__Group__2639);
            rule__UserCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserCategories__Group__2"


    // $ANTLR start "rule__UserCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:356:1: rule__UserCategories__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__UserCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:360:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:361:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:361:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:362:1: LeftSquareBracket
            {
             before(grammarAccess.getUserCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__UserCategories__Group__2__Impl667); 
             after(grammarAccess.getUserCategoriesAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserCategories__Group__2__Impl"


    // $ANTLR start "rule__UserCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:375:1: rule__UserCategories__Group__3 : rule__UserCategories__Group__3__Impl rule__UserCategories__Group__4 ;
    public final void rule__UserCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:379:1: ( rule__UserCategories__Group__3__Impl rule__UserCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:380:2: rule__UserCategories__Group__3__Impl rule__UserCategories__Group__4
            {
            pushFollow(FOLLOW_rule__UserCategories__Group__3__Impl_in_rule__UserCategories__Group__3698);
            rule__UserCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UserCategories__Group__4_in_rule__UserCategories__Group__3701);
            rule__UserCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserCategories__Group__3"


    // $ANTLR start "rule__UserCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:387:1: rule__UserCategories__Group__3__Impl : ( ( ( rule__UserCategories__CategoryAssignment_3 ) ) ( ( rule__UserCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__UserCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:391:1: ( ( ( ( rule__UserCategories__CategoryAssignment_3 ) ) ( ( rule__UserCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:392:1: ( ( ( rule__UserCategories__CategoryAssignment_3 ) ) ( ( rule__UserCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:392:1: ( ( ( rule__UserCategories__CategoryAssignment_3 ) ) ( ( rule__UserCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:393:1: ( ( rule__UserCategories__CategoryAssignment_3 ) ) ( ( rule__UserCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:393:1: ( ( rule__UserCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:394:1: ( rule__UserCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getUserCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:395:1: ( rule__UserCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:395:2: rule__UserCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__UserCategories__CategoryAssignment_3_in_rule__UserCategories__Group__3__Impl730);
            rule__UserCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getUserCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:398:1: ( ( rule__UserCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:399:1: ( rule__UserCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getUserCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:400:1: ( rule__UserCategories__CategoryAssignment_3 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:400:2: rule__UserCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__UserCategories__CategoryAssignment_3_in_rule__UserCategories__Group__3__Impl742);
            	    rule__UserCategories__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getUserCategoriesAccess().getCategoryAssignment_3()); 

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
    // $ANTLR end "rule__UserCategories__Group__3__Impl"


    // $ANTLR start "rule__UserCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:411:1: rule__UserCategories__Group__4 : rule__UserCategories__Group__4__Impl ;
    public final void rule__UserCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:415:1: ( rule__UserCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:416:2: rule__UserCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__UserCategories__Group__4__Impl_in_rule__UserCategories__Group__4775);
            rule__UserCategories__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserCategories__Group__4"


    // $ANTLR start "rule__UserCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:422:1: rule__UserCategories__Group__4__Impl : ( RightSquareBracket ) ;
    public final void rule__UserCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:426:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:427:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:427:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:428:1: RightSquareBracket
            {
             before(grammarAccess.getUserCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__UserCategories__Group__4__Impl803); 
             after(grammarAccess.getUserCategoriesAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserCategories__Group__4__Impl"


    // $ANTLR start "rule__QualityCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:451:1: rule__QualityCategories__Group__0 : rule__QualityCategories__Group__0__Impl rule__QualityCategories__Group__1 ;
    public final void rule__QualityCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:455:1: ( rule__QualityCategories__Group__0__Impl rule__QualityCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:456:2: rule__QualityCategories__Group__0__Impl rule__QualityCategories__Group__1
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__0__Impl_in_rule__QualityCategories__Group__0844);
            rule__QualityCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategories__Group__1_in_rule__QualityCategories__Group__0847);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:463:1: rule__QualityCategories__Group__0__Impl : ( () ) ;
    public final void rule__QualityCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:467:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:468:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:468:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:469:1: ()
            {
             before(grammarAccess.getQualityCategoriesAccess().getQualityCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:470:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:472:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:482:1: rule__QualityCategories__Group__1 : rule__QualityCategories__Group__1__Impl rule__QualityCategories__Group__2 ;
    public final void rule__QualityCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:486:1: ( rule__QualityCategories__Group__1__Impl rule__QualityCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:487:2: rule__QualityCategories__Group__1__Impl rule__QualityCategories__Group__2
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__1__Impl_in_rule__QualityCategories__Group__1905);
            rule__QualityCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategories__Group__2_in_rule__QualityCategories__Group__1908);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:494:1: rule__QualityCategories__Group__1__Impl : ( Quality ) ;
    public final void rule__QualityCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:498:1: ( ( Quality ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:499:1: ( Quality )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:499:1: ( Quality )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:500:1: Quality
            {
             before(grammarAccess.getQualityCategoriesAccess().getQualityKeyword_1()); 
            match(input,Quality,FOLLOW_Quality_in_rule__QualityCategories__Group__1__Impl936); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:513:1: rule__QualityCategories__Group__2 : rule__QualityCategories__Group__2__Impl rule__QualityCategories__Group__3 ;
    public final void rule__QualityCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:517:1: ( rule__QualityCategories__Group__2__Impl rule__QualityCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:518:2: rule__QualityCategories__Group__2__Impl rule__QualityCategories__Group__3
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__2__Impl_in_rule__QualityCategories__Group__2967);
            rule__QualityCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategories__Group__3_in_rule__QualityCategories__Group__2970);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:525:1: rule__QualityCategories__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__QualityCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:529:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:530:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:530:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:531:1: LeftSquareBracket
            {
             before(grammarAccess.getQualityCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__QualityCategories__Group__2__Impl998); 
             after(grammarAccess.getQualityCategoriesAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:544:1: rule__QualityCategories__Group__3 : rule__QualityCategories__Group__3__Impl rule__QualityCategories__Group__4 ;
    public final void rule__QualityCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:548:1: ( rule__QualityCategories__Group__3__Impl rule__QualityCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:549:2: rule__QualityCategories__Group__3__Impl rule__QualityCategories__Group__4
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__3__Impl_in_rule__QualityCategories__Group__31029);
            rule__QualityCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategories__Group__4_in_rule__QualityCategories__Group__31032);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:556:1: rule__QualityCategories__Group__3__Impl : ( ( ( rule__QualityCategories__CategoryAssignment_3 ) ) ( ( rule__QualityCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__QualityCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:560:1: ( ( ( ( rule__QualityCategories__CategoryAssignment_3 ) ) ( ( rule__QualityCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:561:1: ( ( ( rule__QualityCategories__CategoryAssignment_3 ) ) ( ( rule__QualityCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:561:1: ( ( ( rule__QualityCategories__CategoryAssignment_3 ) ) ( ( rule__QualityCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:562:1: ( ( rule__QualityCategories__CategoryAssignment_3 ) ) ( ( rule__QualityCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:562:1: ( ( rule__QualityCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:563:1: ( rule__QualityCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:564:1: ( rule__QualityCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:564:2: rule__QualityCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__QualityCategories__CategoryAssignment_3_in_rule__QualityCategories__Group__3__Impl1061);
            rule__QualityCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:567:1: ( ( rule__QualityCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:568:1: ( rule__QualityCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:569:1: ( rule__QualityCategories__CategoryAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:569:2: rule__QualityCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__QualityCategories__CategoryAssignment_3_in_rule__QualityCategories__Group__3__Impl1073);
            	    rule__QualityCategories__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_3()); 

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
    // $ANTLR end "rule__QualityCategories__Group__3__Impl"


    // $ANTLR start "rule__QualityCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:580:1: rule__QualityCategories__Group__4 : rule__QualityCategories__Group__4__Impl ;
    public final void rule__QualityCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:584:1: ( rule__QualityCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:585:2: rule__QualityCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__4__Impl_in_rule__QualityCategories__Group__41106);
            rule__QualityCategories__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:591:1: rule__QualityCategories__Group__4__Impl : ( RightSquareBracket ) ;
    public final void rule__QualityCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:595:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:596:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:596:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:597:1: RightSquareBracket
            {
             before(grammarAccess.getQualityCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__QualityCategories__Group__4__Impl1134); 
             after(grammarAccess.getQualityCategoriesAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__PhaseCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:620:1: rule__PhaseCategories__Group__0 : rule__PhaseCategories__Group__0__Impl rule__PhaseCategories__Group__1 ;
    public final void rule__PhaseCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:624:1: ( rule__PhaseCategories__Group__0__Impl rule__PhaseCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:625:2: rule__PhaseCategories__Group__0__Impl rule__PhaseCategories__Group__1
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__0__Impl_in_rule__PhaseCategories__Group__01175);
            rule__PhaseCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategories__Group__1_in_rule__PhaseCategories__Group__01178);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:632:1: rule__PhaseCategories__Group__0__Impl : ( () ) ;
    public final void rule__PhaseCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:636:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:637:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:637:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:638:1: ()
            {
             before(grammarAccess.getPhaseCategoriesAccess().getPhaseCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:639:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:641:1: 
            {
            }

             after(grammarAccess.getPhaseCategoriesAccess().getPhaseCategoriesAction_0()); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:651:1: rule__PhaseCategories__Group__1 : rule__PhaseCategories__Group__1__Impl rule__PhaseCategories__Group__2 ;
    public final void rule__PhaseCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:655:1: ( rule__PhaseCategories__Group__1__Impl rule__PhaseCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:656:2: rule__PhaseCategories__Group__1__Impl rule__PhaseCategories__Group__2
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__1__Impl_in_rule__PhaseCategories__Group__11236);
            rule__PhaseCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategories__Group__2_in_rule__PhaseCategories__Group__11239);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:663:1: rule__PhaseCategories__Group__1__Impl : ( Phase ) ;
    public final void rule__PhaseCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:667:1: ( ( Phase ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:668:1: ( Phase )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:668:1: ( Phase )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:669:1: Phase
            {
             before(grammarAccess.getPhaseCategoriesAccess().getPhaseKeyword_1()); 
            match(input,Phase,FOLLOW_Phase_in_rule__PhaseCategories__Group__1__Impl1267); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:682:1: rule__PhaseCategories__Group__2 : rule__PhaseCategories__Group__2__Impl rule__PhaseCategories__Group__3 ;
    public final void rule__PhaseCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:686:1: ( rule__PhaseCategories__Group__2__Impl rule__PhaseCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:687:2: rule__PhaseCategories__Group__2__Impl rule__PhaseCategories__Group__3
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__2__Impl_in_rule__PhaseCategories__Group__21298);
            rule__PhaseCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategories__Group__3_in_rule__PhaseCategories__Group__21301);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:694:1: rule__PhaseCategories__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__PhaseCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:698:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:699:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:699:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:700:1: LeftSquareBracket
            {
             before(grammarAccess.getPhaseCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__PhaseCategories__Group__2__Impl1329); 
             after(grammarAccess.getPhaseCategoriesAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:713:1: rule__PhaseCategories__Group__3 : rule__PhaseCategories__Group__3__Impl rule__PhaseCategories__Group__4 ;
    public final void rule__PhaseCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:717:1: ( rule__PhaseCategories__Group__3__Impl rule__PhaseCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:718:2: rule__PhaseCategories__Group__3__Impl rule__PhaseCategories__Group__4
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__3__Impl_in_rule__PhaseCategories__Group__31360);
            rule__PhaseCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategories__Group__4_in_rule__PhaseCategories__Group__31363);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:725:1: rule__PhaseCategories__Group__3__Impl : ( ( ( rule__PhaseCategories__CategoryAssignment_3 ) ) ( ( rule__PhaseCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__PhaseCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:729:1: ( ( ( ( rule__PhaseCategories__CategoryAssignment_3 ) ) ( ( rule__PhaseCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:730:1: ( ( ( rule__PhaseCategories__CategoryAssignment_3 ) ) ( ( rule__PhaseCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:730:1: ( ( ( rule__PhaseCategories__CategoryAssignment_3 ) ) ( ( rule__PhaseCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:731:1: ( ( rule__PhaseCategories__CategoryAssignment_3 ) ) ( ( rule__PhaseCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:731:1: ( ( rule__PhaseCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:732:1: ( rule__PhaseCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:733:1: ( rule__PhaseCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:733:2: rule__PhaseCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__PhaseCategories__CategoryAssignment_3_in_rule__PhaseCategories__Group__3__Impl1392);
            rule__PhaseCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:736:1: ( ( rule__PhaseCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:737:1: ( rule__PhaseCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:738:1: ( rule__PhaseCategories__CategoryAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:738:2: rule__PhaseCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PhaseCategories__CategoryAssignment_3_in_rule__PhaseCategories__Group__3__Impl1404);
            	    rule__PhaseCategories__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_3()); 

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
    // $ANTLR end "rule__PhaseCategories__Group__3__Impl"


    // $ANTLR start "rule__PhaseCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:749:1: rule__PhaseCategories__Group__4 : rule__PhaseCategories__Group__4__Impl ;
    public final void rule__PhaseCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:753:1: ( rule__PhaseCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:754:2: rule__PhaseCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__4__Impl_in_rule__PhaseCategories__Group__41437);
            rule__PhaseCategories__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:760:1: rule__PhaseCategories__Group__4__Impl : ( RightSquareBracket ) ;
    public final void rule__PhaseCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:764:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:765:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:765:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:766:1: RightSquareBracket
            {
             before(grammarAccess.getPhaseCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__PhaseCategories__Group__4__Impl1465); 
             after(grammarAccess.getPhaseCategoriesAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__UserCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:789:1: rule__UserCategory__Group__0 : rule__UserCategory__Group__0__Impl rule__UserCategory__Group__1 ;
    public final void rule__UserCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:793:1: ( rule__UserCategory__Group__0__Impl rule__UserCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:794:2: rule__UserCategory__Group__0__Impl rule__UserCategory__Group__1
            {
            pushFollow(FOLLOW_rule__UserCategory__Group__0__Impl_in_rule__UserCategory__Group__01506);
            rule__UserCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UserCategory__Group__1_in_rule__UserCategory__Group__01509);
            rule__UserCategory__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserCategory__Group__0"


    // $ANTLR start "rule__UserCategory__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:801:1: rule__UserCategory__Group__0__Impl : ( () ) ;
    public final void rule__UserCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:805:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:806:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:806:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:807:1: ()
            {
             before(grammarAccess.getUserCategoryAccess().getUserCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:808:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:810:1: 
            {
            }

             after(grammarAccess.getUserCategoryAccess().getUserCategoryAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserCategory__Group__0__Impl"


    // $ANTLR start "rule__UserCategory__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:820:1: rule__UserCategory__Group__1 : rule__UserCategory__Group__1__Impl ;
    public final void rule__UserCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:824:1: ( rule__UserCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:825:2: rule__UserCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__UserCategory__Group__1__Impl_in_rule__UserCategory__Group__11567);
            rule__UserCategory__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserCategory__Group__1"


    // $ANTLR start "rule__UserCategory__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:831:1: rule__UserCategory__Group__1__Impl : ( ( rule__UserCategory__NameAssignment_1 ) ) ;
    public final void rule__UserCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:835:1: ( ( ( rule__UserCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:836:1: ( ( rule__UserCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:836:1: ( ( rule__UserCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:837:1: ( rule__UserCategory__NameAssignment_1 )
            {
             before(grammarAccess.getUserCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:838:1: ( rule__UserCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:838:2: rule__UserCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__UserCategory__NameAssignment_1_in_rule__UserCategory__Group__1__Impl1594);
            rule__UserCategory__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUserCategoryAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserCategory__Group__1__Impl"


    // $ANTLR start "rule__QualityCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:852:1: rule__QualityCategory__Group__0 : rule__QualityCategory__Group__0__Impl rule__QualityCategory__Group__1 ;
    public final void rule__QualityCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:856:1: ( rule__QualityCategory__Group__0__Impl rule__QualityCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:857:2: rule__QualityCategory__Group__0__Impl rule__QualityCategory__Group__1
            {
            pushFollow(FOLLOW_rule__QualityCategory__Group__0__Impl_in_rule__QualityCategory__Group__01628);
            rule__QualityCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategory__Group__1_in_rule__QualityCategory__Group__01631);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:864:1: rule__QualityCategory__Group__0__Impl : ( () ) ;
    public final void rule__QualityCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:868:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:869:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:869:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:870:1: ()
            {
             before(grammarAccess.getQualityCategoryAccess().getQualityCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:871:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:873:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:883:1: rule__QualityCategory__Group__1 : rule__QualityCategory__Group__1__Impl ;
    public final void rule__QualityCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:887:1: ( rule__QualityCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:888:2: rule__QualityCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualityCategory__Group__1__Impl_in_rule__QualityCategory__Group__11689);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:894:1: rule__QualityCategory__Group__1__Impl : ( ( rule__QualityCategory__NameAssignment_1 ) ) ;
    public final void rule__QualityCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:898:1: ( ( ( rule__QualityCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:899:1: ( ( rule__QualityCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:899:1: ( ( rule__QualityCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:900:1: ( rule__QualityCategory__NameAssignment_1 )
            {
             before(grammarAccess.getQualityCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:901:1: ( rule__QualityCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:901:2: rule__QualityCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__QualityCategory__NameAssignment_1_in_rule__QualityCategory__Group__1__Impl1716);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:915:1: rule__PhaseCategory__Group__0 : rule__PhaseCategory__Group__0__Impl rule__PhaseCategory__Group__1 ;
    public final void rule__PhaseCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:919:1: ( rule__PhaseCategory__Group__0__Impl rule__PhaseCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:920:2: rule__PhaseCategory__Group__0__Impl rule__PhaseCategory__Group__1
            {
            pushFollow(FOLLOW_rule__PhaseCategory__Group__0__Impl_in_rule__PhaseCategory__Group__01750);
            rule__PhaseCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategory__Group__1_in_rule__PhaseCategory__Group__01753);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:927:1: rule__PhaseCategory__Group__0__Impl : ( () ) ;
    public final void rule__PhaseCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:931:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:932:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:932:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:933:1: ()
            {
             before(grammarAccess.getPhaseCategoryAccess().getPhaseCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:934:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:936:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:946:1: rule__PhaseCategory__Group__1 : rule__PhaseCategory__Group__1__Impl ;
    public final void rule__PhaseCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:950:1: ( rule__PhaseCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:951:2: rule__PhaseCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PhaseCategory__Group__1__Impl_in_rule__PhaseCategory__Group__11811);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:957:1: rule__PhaseCategory__Group__1__Impl : ( ( rule__PhaseCategory__NameAssignment_1 ) ) ;
    public final void rule__PhaseCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:961:1: ( ( ( rule__PhaseCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:962:1: ( ( rule__PhaseCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:962:1: ( ( rule__PhaseCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:963:1: ( rule__PhaseCategory__NameAssignment_1 )
            {
             before(grammarAccess.getPhaseCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:964:1: ( rule__PhaseCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:964:2: rule__PhaseCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PhaseCategory__NameAssignment_1_in_rule__PhaseCategory__Group__1__Impl1838);
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


    // $ANTLR start "rule__CategoriesDefinitions__UnorderedGroup"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:984:1: rule__CategoriesDefinitions__UnorderedGroup : ( rule__CategoriesDefinitions__UnorderedGroup__0 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:989:1: ( ( rule__CategoriesDefinitions__UnorderedGroup__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:990:2: ( rule__CategoriesDefinitions__UnorderedGroup__0 )?
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:990:2: ( rule__CategoriesDefinitions__UnorderedGroup__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( LA4_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt4=1;
            }
            else if ( LA4_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt4=1;
            }
            else if ( LA4_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:990:2: rule__CategoriesDefinitions__UnorderedGroup__0
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__0_in_rule__CategoriesDefinitions__UnorderedGroup1878);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1000:1: rule__CategoriesDefinitions__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__CategoriesDefinitions__UserCategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhaseCategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualityCategoriesAssignment_2 ) ) ) ) ) ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1005:1: ( ( ({...}? => ( ( ( rule__CategoriesDefinitions__UserCategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhaseCategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualityCategoriesAssignment_2 ) ) ) ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1006:3: ( ({...}? => ( ( ( rule__CategoriesDefinitions__UserCategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhaseCategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualityCategoriesAssignment_2 ) ) ) ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1006:3: ( ({...}? => ( ( ( rule__CategoriesDefinitions__UserCategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhaseCategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualityCategoriesAssignment_2 ) ) ) ) )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( LA5_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt5=1;
            }
            else if ( LA5_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt5=2;
            }
            else if ( LA5_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt5=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1008:4: ({...}? => ( ( ( rule__CategoriesDefinitions__UserCategoriesAssignment_0 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1008:4: ({...}? => ( ( ( rule__CategoriesDefinitions__UserCategoriesAssignment_0 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1009:5: {...}? => ( ( ( rule__CategoriesDefinitions__UserCategoriesAssignment_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1009:116: ( ( ( rule__CategoriesDefinitions__UserCategoriesAssignment_0 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1010:6: ( ( rule__CategoriesDefinitions__UserCategoriesAssignment_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1016:6: ( ( rule__CategoriesDefinitions__UserCategoriesAssignment_0 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1018:7: ( rule__CategoriesDefinitions__UserCategoriesAssignment_0 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getUserCategoriesAssignment_0()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1019:7: ( rule__CategoriesDefinitions__UserCategoriesAssignment_0 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1019:8: rule__CategoriesDefinitions__UserCategoriesAssignment_0
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UserCategoriesAssignment_0_in_rule__CategoriesDefinitions__UnorderedGroup__Impl1965);
                    rule__CategoriesDefinitions__UserCategoriesAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getUserCategoriesAssignment_0()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1028:4: ({...}? => ( ( ( rule__CategoriesDefinitions__PhaseCategoriesAssignment_1 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1028:4: ({...}? => ( ( ( rule__CategoriesDefinitions__PhaseCategoriesAssignment_1 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1029:5: {...}? => ( ( ( rule__CategoriesDefinitions__PhaseCategoriesAssignment_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1029:116: ( ( ( rule__CategoriesDefinitions__PhaseCategoriesAssignment_1 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1030:6: ( ( rule__CategoriesDefinitions__PhaseCategoriesAssignment_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1036:6: ( ( rule__CategoriesDefinitions__PhaseCategoriesAssignment_1 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1038:7: ( rule__CategoriesDefinitions__PhaseCategoriesAssignment_1 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getPhaseCategoriesAssignment_1()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1039:7: ( rule__CategoriesDefinitions__PhaseCategoriesAssignment_1 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1039:8: rule__CategoriesDefinitions__PhaseCategoriesAssignment_1
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__PhaseCategoriesAssignment_1_in_rule__CategoriesDefinitions__UnorderedGroup__Impl2063);
                    rule__CategoriesDefinitions__PhaseCategoriesAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getPhaseCategoriesAssignment_1()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1048:4: ({...}? => ( ( ( rule__CategoriesDefinitions__QualityCategoriesAssignment_2 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1048:4: ({...}? => ( ( ( rule__CategoriesDefinitions__QualityCategoriesAssignment_2 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1049:5: {...}? => ( ( ( rule__CategoriesDefinitions__QualityCategoriesAssignment_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1049:116: ( ( ( rule__CategoriesDefinitions__QualityCategoriesAssignment_2 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1050:6: ( ( rule__CategoriesDefinitions__QualityCategoriesAssignment_2 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1056:6: ( ( rule__CategoriesDefinitions__QualityCategoriesAssignment_2 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1058:7: ( rule__CategoriesDefinitions__QualityCategoriesAssignment_2 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getQualityCategoriesAssignment_2()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1059:7: ( rule__CategoriesDefinitions__QualityCategoriesAssignment_2 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1059:8: rule__CategoriesDefinitions__QualityCategoriesAssignment_2
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__QualityCategoriesAssignment_2_in_rule__CategoriesDefinitions__UnorderedGroup__Impl2161);
                    rule__CategoriesDefinitions__QualityCategoriesAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getQualityCategoriesAssignment_2()); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1077:1: rule__CategoriesDefinitions__UnorderedGroup__0 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1081:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1082:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__02227);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1083:2: ( rule__CategoriesDefinitions__UnorderedGroup__1 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( LA6_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt6=1;
            }
            else if ( LA6_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt6=1;
            }
            else if ( LA6_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1083:2: rule__CategoriesDefinitions__UnorderedGroup__1
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__1_in_rule__CategoriesDefinitions__UnorderedGroup__02230);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1090:1: rule__CategoriesDefinitions__UnorderedGroup__1 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1094:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1095:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__12255);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1096:2: ( rule__CategoriesDefinitions__UnorderedGroup__2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( LA7_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt7=1;
            }
            else if ( LA7_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt7=1;
            }
            else if ( LA7_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1096:2: rule__CategoriesDefinitions__UnorderedGroup__2
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__2_in_rule__CategoriesDefinitions__UnorderedGroup__12258);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1103:1: rule__CategoriesDefinitions__UnorderedGroup__2 : rule__CategoriesDefinitions__UnorderedGroup__Impl ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1107:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1108:2: rule__CategoriesDefinitions__UnorderedGroup__Impl
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__22283);
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
    // $ANTLR end "rule__CategoriesDefinitions__UnorderedGroup__2"


    // $ANTLR start "rule__CategoriesDefinitions__UserCategoriesAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1122:1: rule__CategoriesDefinitions__UserCategoriesAssignment_0 : ( ruleUserCategories ) ;
    public final void rule__CategoriesDefinitions__UserCategoriesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1126:1: ( ( ruleUserCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1127:1: ( ruleUserCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1127:1: ( ruleUserCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1128:1: ruleUserCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getUserCategoriesUserCategoriesParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleUserCategories_in_rule__CategoriesDefinitions__UserCategoriesAssignment_02318);
            ruleUserCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getUserCategoriesUserCategoriesParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__UserCategoriesAssignment_0"


    // $ANTLR start "rule__CategoriesDefinitions__PhaseCategoriesAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1137:1: rule__CategoriesDefinitions__PhaseCategoriesAssignment_1 : ( rulePhaseCategories ) ;
    public final void rule__CategoriesDefinitions__PhaseCategoriesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1141:1: ( ( rulePhaseCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1142:1: ( rulePhaseCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1142:1: ( rulePhaseCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1143:1: rulePhaseCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getPhaseCategoriesPhaseCategoriesParserRuleCall_1_0()); 
            pushFollow(FOLLOW_rulePhaseCategories_in_rule__CategoriesDefinitions__PhaseCategoriesAssignment_12349);
            rulePhaseCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getPhaseCategoriesPhaseCategoriesParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__PhaseCategoriesAssignment_1"


    // $ANTLR start "rule__CategoriesDefinitions__QualityCategoriesAssignment_2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1152:1: rule__CategoriesDefinitions__QualityCategoriesAssignment_2 : ( ruleQualityCategories ) ;
    public final void rule__CategoriesDefinitions__QualityCategoriesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1156:1: ( ( ruleQualityCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1157:1: ( ruleQualityCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1157:1: ( ruleQualityCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1158:1: ruleQualityCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getQualityCategoriesQualityCategoriesParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualityCategories_in_rule__CategoriesDefinitions__QualityCategoriesAssignment_22380);
            ruleQualityCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getQualityCategoriesQualityCategoriesParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__QualityCategoriesAssignment_2"


    // $ANTLR start "rule__UserCategories__CategoryAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1167:1: rule__UserCategories__CategoryAssignment_3 : ( ruleUserCategory ) ;
    public final void rule__UserCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1171:1: ( ( ruleUserCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1172:1: ( ruleUserCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1172:1: ( ruleUserCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1173:1: ruleUserCategory
            {
             before(grammarAccess.getUserCategoriesAccess().getCategoryUserCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleUserCategory_in_rule__UserCategories__CategoryAssignment_32411);
            ruleUserCategory();

            state._fsp--;

             after(grammarAccess.getUserCategoriesAccess().getCategoryUserCategoryParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserCategories__CategoryAssignment_3"


    // $ANTLR start "rule__QualityCategories__CategoryAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1182:1: rule__QualityCategories__CategoryAssignment_3 : ( ruleQualityCategory ) ;
    public final void rule__QualityCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1186:1: ( ( ruleQualityCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1187:1: ( ruleQualityCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1187:1: ( ruleQualityCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1188:1: ruleQualityCategory
            {
             before(grammarAccess.getQualityCategoriesAccess().getCategoryQualityCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleQualityCategory_in_rule__QualityCategories__CategoryAssignment_32442);
            ruleQualityCategory();

            state._fsp--;

             after(grammarAccess.getQualityCategoriesAccess().getCategoryQualityCategoryParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategories__CategoryAssignment_3"


    // $ANTLR start "rule__PhaseCategories__CategoryAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1197:1: rule__PhaseCategories__CategoryAssignment_3 : ( rulePhaseCategory ) ;
    public final void rule__PhaseCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1201:1: ( ( rulePhaseCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1202:1: ( rulePhaseCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1202:1: ( rulePhaseCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1203:1: rulePhaseCategory
            {
             before(grammarAccess.getPhaseCategoriesAccess().getCategoryPhaseCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_rulePhaseCategory_in_rule__PhaseCategories__CategoryAssignment_32473);
            rulePhaseCategory();

            state._fsp--;

             after(grammarAccess.getPhaseCategoriesAccess().getCategoryPhaseCategoryParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategories__CategoryAssignment_3"


    // $ANTLR start "rule__UserCategory__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1212:1: rule__UserCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__UserCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1216:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1217:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1217:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1218:1: RULE_ID
            {
             before(grammarAccess.getUserCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__UserCategory__NameAssignment_12504); 
             after(grammarAccess.getUserCategoryAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UserCategory__NameAssignment_1"


    // $ANTLR start "rule__QualityCategory__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1227:1: rule__QualityCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__QualityCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1231:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1232:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1232:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1233:1: RULE_ID
            {
             before(grammarAccess.getQualityCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualityCategory__NameAssignment_12535); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1242:1: rule__PhaseCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PhaseCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1246:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1247:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1247:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1248:1: RULE_ID
            {
             before(grammarAccess.getPhaseCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PhaseCategory__NameAssignment_12566); 
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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleCategoriesDefinitions_in_entryRuleCategoriesDefinitions54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategoriesDefinitions61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup_in_ruleCategoriesDefinitions91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUserCategories_in_entryRuleUserCategories118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUserCategories125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserCategories__Group__0_in_ruleUserCategories155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategories_in_entryRuleQualityCategories182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualityCategories189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__0_in_ruleQualityCategories219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhaseCategories_in_entryRulePhaseCategories246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhaseCategories253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__0_in_rulePhaseCategories283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUserCategory_in_entryRuleUserCategory310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUserCategory317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserCategory__Group__0_in_ruleUserCategory347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategory_in_entryRuleQualityCategory374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualityCategory381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategory__Group__0_in_ruleQualityCategory411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhaseCategory_in_entryRulePhaseCategory438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhaseCategory445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategory__Group__0_in_rulePhaseCategory475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserCategories__Group__0__Impl_in_rule__UserCategories__Group__0513 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__UserCategories__Group__1_in_rule__UserCategories__Group__0516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserCategories__Group__1__Impl_in_rule__UserCategories__Group__1574 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__UserCategories__Group__2_in_rule__UserCategories__Group__1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Category_in_rule__UserCategories__Group__1__Impl605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserCategories__Group__2__Impl_in_rule__UserCategories__Group__2636 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__UserCategories__Group__3_in_rule__UserCategories__Group__2639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__UserCategories__Group__2__Impl667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserCategories__Group__3__Impl_in_rule__UserCategories__Group__3698 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__UserCategories__Group__4_in_rule__UserCategories__Group__3701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserCategories__CategoryAssignment_3_in_rule__UserCategories__Group__3__Impl730 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_rule__UserCategories__CategoryAssignment_3_in_rule__UserCategories__Group__3__Impl742 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_rule__UserCategories__Group__4__Impl_in_rule__UserCategories__Group__4775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__UserCategories__Group__4__Impl803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__0__Impl_in_rule__QualityCategories__Group__0844 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__1_in_rule__QualityCategories__Group__0847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__1__Impl_in_rule__QualityCategories__Group__1905 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__2_in_rule__QualityCategories__Group__1908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Quality_in_rule__QualityCategories__Group__1__Impl936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__2__Impl_in_rule__QualityCategories__Group__2967 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__3_in_rule__QualityCategories__Group__2970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__QualityCategories__Group__2__Impl998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__3__Impl_in_rule__QualityCategories__Group__31029 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__4_in_rule__QualityCategories__Group__31032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__CategoryAssignment_3_in_rule__QualityCategories__Group__3__Impl1061 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_rule__QualityCategories__CategoryAssignment_3_in_rule__QualityCategories__Group__3__Impl1073 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__4__Impl_in_rule__QualityCategories__Group__41106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__QualityCategories__Group__4__Impl1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__0__Impl_in_rule__PhaseCategories__Group__01175 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__1_in_rule__PhaseCategories__Group__01178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__1__Impl_in_rule__PhaseCategories__Group__11236 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__2_in_rule__PhaseCategories__Group__11239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Phase_in_rule__PhaseCategories__Group__1__Impl1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__2__Impl_in_rule__PhaseCategories__Group__21298 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__3_in_rule__PhaseCategories__Group__21301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__PhaseCategories__Group__2__Impl1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__3__Impl_in_rule__PhaseCategories__Group__31360 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__4_in_rule__PhaseCategories__Group__31363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__CategoryAssignment_3_in_rule__PhaseCategories__Group__3__Impl1392 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_rule__PhaseCategories__CategoryAssignment_3_in_rule__PhaseCategories__Group__3__Impl1404 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__4__Impl_in_rule__PhaseCategories__Group__41437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__PhaseCategories__Group__4__Impl1465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserCategory__Group__0__Impl_in_rule__UserCategory__Group__01506 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__UserCategory__Group__1_in_rule__UserCategory__Group__01509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserCategory__Group__1__Impl_in_rule__UserCategory__Group__11567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UserCategory__NameAssignment_1_in_rule__UserCategory__Group__1__Impl1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategory__Group__0__Impl_in_rule__QualityCategory__Group__01628 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__QualityCategory__Group__1_in_rule__QualityCategory__Group__01631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategory__Group__1__Impl_in_rule__QualityCategory__Group__11689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategory__NameAssignment_1_in_rule__QualityCategory__Group__1__Impl1716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategory__Group__0__Impl_in_rule__PhaseCategory__Group__01750 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__PhaseCategory__Group__1_in_rule__PhaseCategory__Group__01753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategory__Group__1__Impl_in_rule__PhaseCategory__Group__11811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategory__NameAssignment_1_in_rule__PhaseCategory__Group__1__Impl1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__0_in_rule__CategoriesDefinitions__UnorderedGroup1878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UserCategoriesAssignment_0_in_rule__CategoriesDefinitions__UnorderedGroup__Impl1965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__PhaseCategoriesAssignment_1_in_rule__CategoriesDefinitions__UnorderedGroup__Impl2063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__QualityCategoriesAssignment_2_in_rule__CategoriesDefinitions__UnorderedGroup__Impl2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__02227 = new BitSet(new long[]{0x0000000000000072L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__1_in_rule__CategoriesDefinitions__UnorderedGroup__02230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__12255 = new BitSet(new long[]{0x0000000000000072L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__2_in_rule__CategoriesDefinitions__UnorderedGroup__12258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__22283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUserCategories_in_rule__CategoriesDefinitions__UserCategoriesAssignment_02318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhaseCategories_in_rule__CategoriesDefinitions__PhaseCategoriesAssignment_12349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategories_in_rule__CategoriesDefinitions__QualityCategoriesAssignment_22380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUserCategory_in_rule__UserCategories__CategoryAssignment_32411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategory_in_rule__QualityCategories__CategoryAssignment_32442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhaseCategory_in_rule__PhaseCategories__CategoryAssignment_32473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__UserCategory__NameAssignment_12504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualityCategory__NameAssignment_12535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PhaseCategory__NameAssignment_12566 = new BitSet(new long[]{0x0000000000000002L});

}

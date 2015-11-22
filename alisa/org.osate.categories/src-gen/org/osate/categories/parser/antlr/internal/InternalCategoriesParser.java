package org.osate.categories.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
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
public class InternalCategoriesParser extends AbstractInternalAntlrParser {
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
    public String getGrammarFileName() { return "../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g"; }




    	private CategoriesGrammarAccess grammarAccess;
    	 	
    	public InternalCategoriesParser(TokenStream input, CategoriesGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "CategoriesDefinitions";	
    	} 
    	   	   	
    	@Override
    	protected CategoriesGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleCategoriesDefinitions"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:73:1: entryRuleCategoriesDefinitions returns [EObject current=null] : iv_ruleCategoriesDefinitions= ruleCategoriesDefinitions EOF ;
    public final EObject entryRuleCategoriesDefinitions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategoriesDefinitions = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:74:2: (iv_ruleCategoriesDefinitions= ruleCategoriesDefinitions EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:75:2: iv_ruleCategoriesDefinitions= ruleCategoriesDefinitions EOF
            {
             newCompositeNode(grammarAccess.getCategoriesDefinitionsRule()); 
            pushFollow(FOLLOW_ruleCategoriesDefinitions_in_entryRuleCategoriesDefinitions67);
            iv_ruleCategoriesDefinitions=ruleCategoriesDefinitions();

            state._fsp--;

             current =iv_ruleCategoriesDefinitions; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategoriesDefinitions77); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCategoriesDefinitions"


    // $ANTLR start "ruleCategoriesDefinitions"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:82:1: ruleCategoriesDefinitions returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* ) ) ) ;
    public final EObject ruleCategoriesDefinitions() throws RecognitionException {
        EObject current = null;

        EObject lv_requirementcategories_1_0 = null;

        EObject lv_methodcategories_2_0 = null;

        EObject lv_selectioncategories_3_0 = null;

        EObject lv_phasecategories_4_0 = null;

        EObject lv_qualitycategories_5_0 = null;

        EObject lv_categoryfilter_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:85:28: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:86:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:86:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:88:1: ( ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:88:1: ( ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:89:2: ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:92:2: ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:93:3: ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )*
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:93:3: ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )*
            loop1:
            do {
                int alt1=7;
                int LA1_0 = input.LA(1);

                if ( LA1_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                    alt1=1;
                }
                else if ( LA1_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                    alt1=2;
                }
                else if ( LA1_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                    alt1=3;
                }
                else if ( LA1_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                    alt1=4;
                }
                else if ( LA1_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                    alt1=5;
                }
                else if ( LA1_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                    alt1=6;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:95:4: ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:95:4: ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:96:5: {...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:96:116: ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:97:6: ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:100:6: ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:100:7: {...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:100:16: ( (lv_requirementcategories_1_0= ruleRequirementCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:101:1: (lv_requirementcategories_1_0= ruleRequirementCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:101:1: (lv_requirementcategories_1_0= ruleRequirementCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:102:3: lv_requirementcategories_1_0= ruleRequirementCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getRequirementcategoriesRequirementCategoriesParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRequirementCategories_in_ruleCategoriesDefinitions167);
            	    lv_requirementcategories_1_0=ruleRequirementCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"requirementcategories",
            	            		lv_requirementcategories_1_0, 
            	            		"RequirementCategories");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:125:4: ({...}? => ( ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:125:4: ({...}? => ( ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:126:5: {...}? => ( ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:126:116: ( ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:127:6: ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:130:6: ({...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:130:7: {...}? => ( (lv_methodcategories_2_0= ruleMethodCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:130:16: ( (lv_methodcategories_2_0= ruleMethodCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:131:1: (lv_methodcategories_2_0= ruleMethodCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:131:1: (lv_methodcategories_2_0= ruleMethodCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:132:3: lv_methodcategories_2_0= ruleMethodCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesMethodCategoriesParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMethodCategories_in_ruleCategoriesDefinitions242);
            	    lv_methodcategories_2_0=ruleMethodCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"methodcategories",
            	            		lv_methodcategories_2_0, 
            	            		"MethodCategories");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:155:4: ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:155:4: ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:156:5: {...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:156:116: ( ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:157:6: ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:160:6: ({...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:160:7: {...}? => ( (lv_selectioncategories_3_0= ruleSelectionCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:160:16: ( (lv_selectioncategories_3_0= ruleSelectionCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:161:1: (lv_selectioncategories_3_0= ruleSelectionCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:161:1: (lv_selectioncategories_3_0= ruleSelectionCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:162:3: lv_selectioncategories_3_0= ruleSelectionCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesSelectionCategoriesParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSelectionCategories_in_ruleCategoriesDefinitions317);
            	    lv_selectioncategories_3_0=ruleSelectionCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"selectioncategories",
            	            		lv_selectioncategories_3_0, 
            	            		"SelectionCategories");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:185:4: ({...}? => ( ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:185:4: ({...}? => ( ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:186:5: {...}? => ( ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:186:116: ( ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:187:6: ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:190:6: ({...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:190:7: {...}? => ( (lv_phasecategories_4_0= rulePhaseCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:190:16: ( (lv_phasecategories_4_0= rulePhaseCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:191:1: (lv_phasecategories_4_0= rulePhaseCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:191:1: (lv_phasecategories_4_0= rulePhaseCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:192:3: lv_phasecategories_4_0= rulePhaseCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getPhasecategoriesPhaseCategoriesParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePhaseCategories_in_ruleCategoriesDefinitions392);
            	    lv_phasecategories_4_0=rulePhaseCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"phasecategories",
            	            		lv_phasecategories_4_0, 
            	            		"PhaseCategories");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:215:4: ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:215:4: ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:216:5: {...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:216:116: ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:217:6: ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:220:6: ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:220:7: {...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:220:16: ( (lv_qualitycategories_5_0= ruleQualityCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:221:1: (lv_qualitycategories_5_0= ruleQualityCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:221:1: (lv_qualitycategories_5_0= ruleQualityCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:222:3: lv_qualitycategories_5_0= ruleQualityCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesQualityCategoriesParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualityCategories_in_ruleCategoriesDefinitions467);
            	    lv_qualitycategories_5_0=ruleQualityCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"qualitycategories",
            	            		lv_qualitycategories_5_0, 
            	            		"QualityCategories");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:245:4: ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:245:4: ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:246:5: {...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:246:116: ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:247:6: ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:250:6: ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:250:7: {...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:250:16: ( (lv_categoryfilter_6_0= ruleCategoryFilters ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:251:1: (lv_categoryfilter_6_0= ruleCategoryFilters )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:251:1: (lv_categoryfilter_6_0= ruleCategoryFilters )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:252:3: lv_categoryfilter_6_0= ruleCategoryFilters
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterCategoryFiltersParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCategoryFilters_in_ruleCategoriesDefinitions542);
            	    lv_categoryfilter_6_0=ruleCategoryFilters();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"categoryfilter",
            	            		lv_categoryfilter_6_0, 
            	            		"CategoryFilters");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCategoriesDefinitions"


    // $ANTLR start "entryRuleRequirementCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:290:1: entryRuleRequirementCategories returns [EObject current=null] : iv_ruleRequirementCategories= ruleRequirementCategories EOF ;
    public final EObject entryRuleRequirementCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:291:2: (iv_ruleRequirementCategories= ruleRequirementCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:292:2: iv_ruleRequirementCategories= ruleRequirementCategories EOF
            {
             newCompositeNode(grammarAccess.getRequirementCategoriesRule()); 
            pushFollow(FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories616);
            iv_ruleRequirementCategories=ruleRequirementCategories();

            state._fsp--;

             current =iv_ruleRequirementCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategories626); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequirementCategories"


    // $ANTLR start "ruleRequirementCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:299:1: ruleRequirementCategories returns [EObject current=null] : ( () otherlv_1= Requirement otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= RightSquareBracket ) ;
    public final EObject ruleRequirementCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:302:28: ( ( () otherlv_1= Requirement otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:303:1: ( () otherlv_1= Requirement otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:303:1: ( () otherlv_1= Requirement otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:303:2: () otherlv_1= Requirement otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:303:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:304:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRequirementCategoriesAccess().getRequirementCategoriesAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirementCategories673); 

                	newLeafNode(otherlv_1, grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_1());
                
            otherlv_2=(Token)match(input,Categories,FOLLOW_Categories_in_ruleRequirementCategories685); 

                	newLeafNode(otherlv_2, grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_2());
                
            otherlv_3=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleRequirementCategories697); 

                	newLeafNode(otherlv_3, grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:324:1: ( (lv_category_4_0= ruleRequirementCategory ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:325:1: (lv_category_4_0= ruleRequirementCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:325:1: (lv_category_4_0= ruleRequirementCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:326:3: lv_category_4_0= ruleRequirementCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRequirementCategory_in_ruleRequirementCategories717);
            	    lv_category_4_0=ruleRequirementCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_4_0, 
            	            		"RequirementCategory");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleRequirementCategories731); 

                	newLeafNode(otherlv_5, grammarAccess.getRequirementCategoriesAccess().getRightSquareBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequirementCategories"


    // $ANTLR start "entryRuleMethodCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:355:1: entryRuleMethodCategories returns [EObject current=null] : iv_ruleMethodCategories= ruleMethodCategories EOF ;
    public final EObject entryRuleMethodCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:356:2: (iv_ruleMethodCategories= ruleMethodCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:357:2: iv_ruleMethodCategories= ruleMethodCategories EOF
            {
             newCompositeNode(grammarAccess.getMethodCategoriesRule()); 
            pushFollow(FOLLOW_ruleMethodCategories_in_entryRuleMethodCategories765);
            iv_ruleMethodCategories=ruleMethodCategories();

            state._fsp--;

             current =iv_ruleMethodCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodCategories775); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethodCategories"


    // $ANTLR start "ruleMethodCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:364:1: ruleMethodCategories returns [EObject current=null] : ( () otherlv_1= Method otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleMethodCategory ) )+ otherlv_5= RightSquareBracket ) ;
    public final EObject ruleMethodCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:367:28: ( ( () otherlv_1= Method otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleMethodCategory ) )+ otherlv_5= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:368:1: ( () otherlv_1= Method otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleMethodCategory ) )+ otherlv_5= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:368:1: ( () otherlv_1= Method otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleMethodCategory ) )+ otherlv_5= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:368:2: () otherlv_1= Method otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleMethodCategory ) )+ otherlv_5= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:368:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:369:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMethodCategoriesAccess().getMethodCategoriesAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Method,FOLLOW_Method_in_ruleMethodCategories822); 

                	newLeafNode(otherlv_1, grammarAccess.getMethodCategoriesAccess().getMethodKeyword_1());
                
            otherlv_2=(Token)match(input,Categories,FOLLOW_Categories_in_ruleMethodCategories834); 

                	newLeafNode(otherlv_2, grammarAccess.getMethodCategoriesAccess().getCategoriesKeyword_2());
                
            otherlv_3=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleMethodCategories846); 

                	newLeafNode(otherlv_3, grammarAccess.getMethodCategoriesAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:389:1: ( (lv_category_4_0= ruleMethodCategory ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:390:1: (lv_category_4_0= ruleMethodCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:390:1: (lv_category_4_0= ruleMethodCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:391:3: lv_category_4_0= ruleMethodCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMethodCategoriesAccess().getCategoryMethodCategoryParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMethodCategory_in_ruleMethodCategories866);
            	    lv_category_4_0=ruleMethodCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMethodCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_4_0, 
            	            		"MethodCategory");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleMethodCategories880); 

                	newLeafNode(otherlv_5, grammarAccess.getMethodCategoriesAccess().getRightSquareBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethodCategories"


    // $ANTLR start "entryRuleSelectionCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:420:1: entryRuleSelectionCategories returns [EObject current=null] : iv_ruleSelectionCategories= ruleSelectionCategories EOF ;
    public final EObject entryRuleSelectionCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:421:2: (iv_ruleSelectionCategories= ruleSelectionCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:422:2: iv_ruleSelectionCategories= ruleSelectionCategories EOF
            {
             newCompositeNode(grammarAccess.getSelectionCategoriesRule()); 
            pushFollow(FOLLOW_ruleSelectionCategories_in_entryRuleSelectionCategories914);
            iv_ruleSelectionCategories=ruleSelectionCategories();

            state._fsp--;

             current =iv_ruleSelectionCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategories924); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelectionCategories"


    // $ANTLR start "ruleSelectionCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:429:1: ruleSelectionCategories returns [EObject current=null] : ( () otherlv_1= Selection otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleSelectionCategory ) )+ otherlv_5= RightSquareBracket ) ;
    public final EObject ruleSelectionCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:432:28: ( ( () otherlv_1= Selection otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleSelectionCategory ) )+ otherlv_5= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:433:1: ( () otherlv_1= Selection otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleSelectionCategory ) )+ otherlv_5= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:433:1: ( () otherlv_1= Selection otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleSelectionCategory ) )+ otherlv_5= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:433:2: () otherlv_1= Selection otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleSelectionCategory ) )+ otherlv_5= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:433:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:434:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSelectionCategoriesAccess().getSelectionCategoriesAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Selection,FOLLOW_Selection_in_ruleSelectionCategories971); 

                	newLeafNode(otherlv_1, grammarAccess.getSelectionCategoriesAccess().getSelectionKeyword_1());
                
            otherlv_2=(Token)match(input,Categories,FOLLOW_Categories_in_ruleSelectionCategories983); 

                	newLeafNode(otherlv_2, grammarAccess.getSelectionCategoriesAccess().getCategoriesKeyword_2());
                
            otherlv_3=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleSelectionCategories995); 

                	newLeafNode(otherlv_3, grammarAccess.getSelectionCategoriesAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:454:1: ( (lv_category_4_0= ruleSelectionCategory ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:455:1: (lv_category_4_0= ruleSelectionCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:455:1: (lv_category_4_0= ruleSelectionCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:456:3: lv_category_4_0= ruleSelectionCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSelectionCategoriesAccess().getCategorySelectionCategoryParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSelectionCategory_in_ruleSelectionCategories1015);
            	    lv_category_4_0=ruleSelectionCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSelectionCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_4_0, 
            	            		"SelectionCategory");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleSelectionCategories1029); 

                	newLeafNode(otherlv_5, grammarAccess.getSelectionCategoriesAccess().getRightSquareBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelectionCategories"


    // $ANTLR start "entryRuleQualityCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:485:1: entryRuleQualityCategories returns [EObject current=null] : iv_ruleQualityCategories= ruleQualityCategories EOF ;
    public final EObject entryRuleQualityCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualityCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:486:2: (iv_ruleQualityCategories= ruleQualityCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:487:2: iv_ruleQualityCategories= ruleQualityCategories EOF
            {
             newCompositeNode(grammarAccess.getQualityCategoriesRule()); 
            pushFollow(FOLLOW_ruleQualityCategories_in_entryRuleQualityCategories1063);
            iv_ruleQualityCategories=ruleQualityCategories();

            state._fsp--;

             current =iv_ruleQualityCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualityCategories1073); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualityCategories"


    // $ANTLR start "ruleQualityCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:494:1: ruleQualityCategories returns [EObject current=null] : ( () otherlv_1= Quality otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleQualityCategory ) )+ otherlv_5= RightSquareBracket ) ;
    public final EObject ruleQualityCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:497:28: ( ( () otherlv_1= Quality otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleQualityCategory ) )+ otherlv_5= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:498:1: ( () otherlv_1= Quality otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleQualityCategory ) )+ otherlv_5= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:498:1: ( () otherlv_1= Quality otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleQualityCategory ) )+ otherlv_5= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:498:2: () otherlv_1= Quality otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleQualityCategory ) )+ otherlv_5= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:498:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:499:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getQualityCategoriesAccess().getQualityCategoriesAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Quality,FOLLOW_Quality_in_ruleQualityCategories1120); 

                	newLeafNode(otherlv_1, grammarAccess.getQualityCategoriesAccess().getQualityKeyword_1());
                
            otherlv_2=(Token)match(input,Categories,FOLLOW_Categories_in_ruleQualityCategories1132); 

                	newLeafNode(otherlv_2, grammarAccess.getQualityCategoriesAccess().getCategoriesKeyword_2());
                
            otherlv_3=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleQualityCategories1144); 

                	newLeafNode(otherlv_3, grammarAccess.getQualityCategoriesAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:519:1: ( (lv_category_4_0= ruleQualityCategory ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:520:1: (lv_category_4_0= ruleQualityCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:520:1: (lv_category_4_0= ruleQualityCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:521:3: lv_category_4_0= ruleQualityCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQualityCategoriesAccess().getCategoryQualityCategoryParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualityCategory_in_ruleQualityCategories1164);
            	    lv_category_4_0=ruleQualityCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getQualityCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_4_0, 
            	            		"QualityCategory");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleQualityCategories1178); 

                	newLeafNode(otherlv_5, grammarAccess.getQualityCategoriesAccess().getRightSquareBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualityCategories"


    // $ANTLR start "entryRulePhaseCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:550:1: entryRulePhaseCategories returns [EObject current=null] : iv_rulePhaseCategories= rulePhaseCategories EOF ;
    public final EObject entryRulePhaseCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhaseCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:551:2: (iv_rulePhaseCategories= rulePhaseCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:552:2: iv_rulePhaseCategories= rulePhaseCategories EOF
            {
             newCompositeNode(grammarAccess.getPhaseCategoriesRule()); 
            pushFollow(FOLLOW_rulePhaseCategories_in_entryRulePhaseCategories1212);
            iv_rulePhaseCategories=rulePhaseCategories();

            state._fsp--;

             current =iv_rulePhaseCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhaseCategories1222); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhaseCategories"


    // $ANTLR start "rulePhaseCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:559:1: rulePhaseCategories returns [EObject current=null] : ( () otherlv_1= Phase otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= rulePhaseCategory ) )+ otherlv_5= RightSquareBracket ) ;
    public final EObject rulePhaseCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:562:28: ( ( () otherlv_1= Phase otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= rulePhaseCategory ) )+ otherlv_5= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:563:1: ( () otherlv_1= Phase otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= rulePhaseCategory ) )+ otherlv_5= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:563:1: ( () otherlv_1= Phase otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= rulePhaseCategory ) )+ otherlv_5= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:563:2: () otherlv_1= Phase otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= rulePhaseCategory ) )+ otherlv_5= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:563:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:564:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPhaseCategoriesAccess().getQualityCategoriesAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Phase,FOLLOW_Phase_in_rulePhaseCategories1269); 

                	newLeafNode(otherlv_1, grammarAccess.getPhaseCategoriesAccess().getPhaseKeyword_1());
                
            otherlv_2=(Token)match(input,Categories,FOLLOW_Categories_in_rulePhaseCategories1281); 

                	newLeafNode(otherlv_2, grammarAccess.getPhaseCategoriesAccess().getCategoriesKeyword_2());
                
            otherlv_3=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rulePhaseCategories1293); 

                	newLeafNode(otherlv_3, grammarAccess.getPhaseCategoriesAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:584:1: ( (lv_category_4_0= rulePhaseCategory ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:585:1: (lv_category_4_0= rulePhaseCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:585:1: (lv_category_4_0= rulePhaseCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:586:3: lv_category_4_0= rulePhaseCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhaseCategoriesAccess().getCategoryPhaseCategoryParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePhaseCategory_in_rulePhaseCategories1313);
            	    lv_category_4_0=rulePhaseCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhaseCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_4_0, 
            	            		"PhaseCategory");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rulePhaseCategories1327); 

                	newLeafNode(otherlv_5, grammarAccess.getPhaseCategoriesAccess().getRightSquareBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhaseCategories"


    // $ANTLR start "entryRuleRequirementCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:615:1: entryRuleRequirementCategory returns [EObject current=null] : iv_ruleRequirementCategory= ruleRequirementCategory EOF ;
    public final EObject entryRuleRequirementCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:616:2: (iv_ruleRequirementCategory= ruleRequirementCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:617:2: iv_ruleRequirementCategory= ruleRequirementCategory EOF
            {
             newCompositeNode(grammarAccess.getRequirementCategoryRule()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory1361);
            iv_ruleRequirementCategory=ruleRequirementCategory();

            state._fsp--;

             current =iv_ruleRequirementCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategory1371); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequirementCategory"


    // $ANTLR start "ruleRequirementCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:624:1: ruleRequirementCategory returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleRequirementCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:627:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:628:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:628:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:628:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:628:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:629:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRequirementCategoryAccess().getRequirementCategoryAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:634:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:635:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:635:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:636:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirementCategory1422); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRequirementCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequirementCategory"


    // $ANTLR start "entryRuleMethodCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:660:1: entryRuleMethodCategory returns [EObject current=null] : iv_ruleMethodCategory= ruleMethodCategory EOF ;
    public final EObject entryRuleMethodCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:661:2: (iv_ruleMethodCategory= ruleMethodCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:662:2: iv_ruleMethodCategory= ruleMethodCategory EOF
            {
             newCompositeNode(grammarAccess.getMethodCategoryRule()); 
            pushFollow(FOLLOW_ruleMethodCategory_in_entryRuleMethodCategory1462);
            iv_ruleMethodCategory=ruleMethodCategory();

            state._fsp--;

             current =iv_ruleMethodCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodCategory1472); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethodCategory"


    // $ANTLR start "ruleMethodCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:669:1: ruleMethodCategory returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleMethodCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:672:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:673:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:673:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:673:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:673:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:674:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMethodCategoryAccess().getMethodCategoryAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:679:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:680:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:680:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:681:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethodCategory1523); 

            			newLeafNode(lv_name_1_0, grammarAccess.getMethodCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethodCategory"


    // $ANTLR start "entryRuleSelectionCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:705:1: entryRuleSelectionCategory returns [EObject current=null] : iv_ruleSelectionCategory= ruleSelectionCategory EOF ;
    public final EObject entryRuleSelectionCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:706:2: (iv_ruleSelectionCategory= ruleSelectionCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:707:2: iv_ruleSelectionCategory= ruleSelectionCategory EOF
            {
             newCompositeNode(grammarAccess.getSelectionCategoryRule()); 
            pushFollow(FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory1563);
            iv_ruleSelectionCategory=ruleSelectionCategory();

            state._fsp--;

             current =iv_ruleSelectionCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategory1573); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelectionCategory"


    // $ANTLR start "ruleSelectionCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:714:1: ruleSelectionCategory returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSelectionCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:717:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:718:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:718:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:718:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:718:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:719:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSelectionCategoryAccess().getSelectionCategoryAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:724:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:725:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:725:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:726:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSelectionCategory1624); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSelectionCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSelectionCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelectionCategory"


    // $ANTLR start "entryRuleQualityCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:750:1: entryRuleQualityCategory returns [EObject current=null] : iv_ruleQualityCategory= ruleQualityCategory EOF ;
    public final EObject entryRuleQualityCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualityCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:751:2: (iv_ruleQualityCategory= ruleQualityCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:752:2: iv_ruleQualityCategory= ruleQualityCategory EOF
            {
             newCompositeNode(grammarAccess.getQualityCategoryRule()); 
            pushFollow(FOLLOW_ruleQualityCategory_in_entryRuleQualityCategory1664);
            iv_ruleQualityCategory=ruleQualityCategory();

            state._fsp--;

             current =iv_ruleQualityCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualityCategory1674); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualityCategory"


    // $ANTLR start "ruleQualityCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:759:1: ruleQualityCategory returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleQualityCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:762:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:763:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:763:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:763:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:763:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:764:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getQualityCategoryAccess().getQualityCategoryAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:769:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:770:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:770:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:771:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualityCategory1725); 

            			newLeafNode(lv_name_1_0, grammarAccess.getQualityCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQualityCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualityCategory"


    // $ANTLR start "entryRulePhaseCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:795:1: entryRulePhaseCategory returns [EObject current=null] : iv_rulePhaseCategory= rulePhaseCategory EOF ;
    public final EObject entryRulePhaseCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhaseCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:796:2: (iv_rulePhaseCategory= rulePhaseCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:797:2: iv_rulePhaseCategory= rulePhaseCategory EOF
            {
             newCompositeNode(grammarAccess.getPhaseCategoryRule()); 
            pushFollow(FOLLOW_rulePhaseCategory_in_entryRulePhaseCategory1765);
            iv_rulePhaseCategory=rulePhaseCategory();

            state._fsp--;

             current =iv_rulePhaseCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhaseCategory1775); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhaseCategory"


    // $ANTLR start "rulePhaseCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:804:1: rulePhaseCategory returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulePhaseCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:807:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:808:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:808:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:808:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:808:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:809:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPhaseCategoryAccess().getPhaseCategoryAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:814:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:815:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:815:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:816:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePhaseCategory1826); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPhaseCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPhaseCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhaseCategory"


    // $ANTLR start "entryRuleCategoryFilters"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:840:1: entryRuleCategoryFilters returns [EObject current=null] : iv_ruleCategoryFilters= ruleCategoryFilters EOF ;
    public final EObject entryRuleCategoryFilters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategoryFilters = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:841:2: (iv_ruleCategoryFilters= ruleCategoryFilters EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:842:2: iv_ruleCategoryFilters= ruleCategoryFilters EOF
            {
             newCompositeNode(grammarAccess.getCategoryFiltersRule()); 
            pushFollow(FOLLOW_ruleCategoryFilters_in_entryRuleCategoryFilters1866);
            iv_ruleCategoryFilters=ruleCategoryFilters();

            state._fsp--;

             current =iv_ruleCategoryFilters; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategoryFilters1876); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCategoryFilters"


    // $ANTLR start "ruleCategoryFilters"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:849:1: ruleCategoryFilters returns [EObject current=null] : (otherlv_0= Category otherlv_1= Filters otherlv_2= LeftSquareBracket ( (lv_filters_3_0= ruleCategorySet ) )+ otherlv_4= RightSquareBracket ) ;
    public final EObject ruleCategoryFilters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_filters_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:852:28: ( (otherlv_0= Category otherlv_1= Filters otherlv_2= LeftSquareBracket ( (lv_filters_3_0= ruleCategorySet ) )+ otherlv_4= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:853:1: (otherlv_0= Category otherlv_1= Filters otherlv_2= LeftSquareBracket ( (lv_filters_3_0= ruleCategorySet ) )+ otherlv_4= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:853:1: (otherlv_0= Category otherlv_1= Filters otherlv_2= LeftSquareBracket ( (lv_filters_3_0= ruleCategorySet ) )+ otherlv_4= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:854:2: otherlv_0= Category otherlv_1= Filters otherlv_2= LeftSquareBracket ( (lv_filters_3_0= ruleCategorySet ) )+ otherlv_4= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Category,FOLLOW_Category_in_ruleCategoryFilters1914); 

                	newLeafNode(otherlv_0, grammarAccess.getCategoryFiltersAccess().getCategoryKeyword_0());
                
            otherlv_1=(Token)match(input,Filters,FOLLOW_Filters_in_ruleCategoryFilters1926); 

                	newLeafNode(otherlv_1, grammarAccess.getCategoryFiltersAccess().getFiltersKeyword_1());
                
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleCategoryFilters1938); 

                	newLeafNode(otherlv_2, grammarAccess.getCategoryFiltersAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:868:1: ( (lv_filters_3_0= ruleCategorySet ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:869:1: (lv_filters_3_0= ruleCategorySet )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:869:1: (lv_filters_3_0= ruleCategorySet )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:870:3: lv_filters_3_0= ruleCategorySet
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoryFiltersAccess().getFiltersCategorySetParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCategorySet_in_ruleCategoryFilters1958);
            	    lv_filters_3_0=ruleCategorySet();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoryFiltersRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"filters",
            	            		lv_filters_3_0, 
            	            		"CategorySet");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleCategoryFilters1972); 

                	newLeafNode(otherlv_4, grammarAccess.getCategoryFiltersAccess().getRightSquareBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCategoryFilters"


    // $ANTLR start "entryRuleCategorySet"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:899:1: entryRuleCategorySet returns [EObject current=null] : iv_ruleCategorySet= ruleCategorySet EOF ;
    public final EObject entryRuleCategorySet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategorySet = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:900:2: (iv_ruleCategorySet= ruleCategorySet EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:901:2: iv_ruleCategorySet= ruleCategorySet EOF
            {
             newCompositeNode(grammarAccess.getCategorySetRule()); 
            pushFollow(FOLLOW_ruleCategorySet_in_entryRuleCategorySet2006);
            iv_ruleCategorySet=ruleCategorySet();

            state._fsp--;

             current =iv_ruleCategorySet; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategorySet2016); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCategorySet"


    // $ANTLR start "ruleCategorySet"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:908:1: ruleCategorySet returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_4= RightCurlyBracket ) ;
    public final EObject ruleCategorySet() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:911:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_4= RightCurlyBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:912:1: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_4= RightCurlyBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:912:1: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_4= RightCurlyBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:912:2: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_4= RightCurlyBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:912:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:913:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCategorySetAccess().getCategorySetAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:918:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:919:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:919:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:920:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCategorySet2067); 

            			newLeafNode(lv_name_1_0, grammarAccess.getCategorySetAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCategorySetRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,LeftCurlyBracket,FOLLOW_LeftCurlyBracket_in_ruleCategorySet2085); 

                	newLeafNode(otherlv_2, grammarAccess.getCategorySetAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:941:1: ( ( ruleCatRef ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:942:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:942:1: ( ruleCatRef )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:943:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getCategorySetRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getCategorySetAccess().getElementsCategoryCrossReference_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleCategorySet2107);
            	    ruleCatRef();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_4=(Token)match(input,RightCurlyBracket,FOLLOW_RightCurlyBracket_in_ruleCategorySet2121); 

                	newLeafNode(otherlv_4, grammarAccess.getCategorySetAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCategorySet"


    // $ANTLR start "entryRuleCatRef"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:969:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:970:1: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:971:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef2156);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef2167); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCatRef"


    // $ANTLR start "ruleCatRef"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:978:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:982:6: (this_ID_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:983:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef2206); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getCatRefAccess().getIDTerminalRuleCall()); 
                

            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCatRef"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleCategoriesDefinitions_in_entryRuleCategoriesDefinitions67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategoriesDefinitions77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_ruleCategoriesDefinitions167 = new BitSet(new long[]{0x0000000000000ED2L});
    public static final BitSet FOLLOW_ruleMethodCategories_in_ruleCategoriesDefinitions242 = new BitSet(new long[]{0x0000000000000ED2L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_ruleCategoriesDefinitions317 = new BitSet(new long[]{0x0000000000000ED2L});
    public static final BitSet FOLLOW_rulePhaseCategories_in_ruleCategoriesDefinitions392 = new BitSet(new long[]{0x0000000000000ED2L});
    public static final BitSet FOLLOW_ruleQualityCategories_in_ruleCategoriesDefinitions467 = new BitSet(new long[]{0x0000000000000ED2L});
    public static final BitSet FOLLOW_ruleCategoryFilters_in_ruleCategoriesDefinitions542 = new BitSet(new long[]{0x0000000000000ED2L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategories626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirementCategories673 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Categories_in_ruleRequirementCategories685 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleRequirementCategories697 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_ruleRequirementCategories717 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleRequirementCategories731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCategories_in_entryRuleMethodCategories765 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodCategories775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Method_in_ruleMethodCategories822 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Categories_in_ruleMethodCategories834 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleMethodCategories846 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleMethodCategory_in_ruleMethodCategories866 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleMethodCategories880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_entryRuleSelectionCategories914 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategories924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Selection_in_ruleSelectionCategories971 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Categories_in_ruleSelectionCategories983 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleSelectionCategories995 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_ruleSelectionCategories1015 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleSelectionCategories1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategories_in_entryRuleQualityCategories1063 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualityCategories1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Quality_in_ruleQualityCategories1120 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Categories_in_ruleQualityCategories1132 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleQualityCategories1144 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleQualityCategory_in_ruleQualityCategories1164 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleQualityCategories1178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhaseCategories_in_entryRulePhaseCategories1212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhaseCategories1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Phase_in_rulePhaseCategories1269 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Categories_in_rulePhaseCategories1281 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rulePhaseCategories1293 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rulePhaseCategory_in_rulePhaseCategories1313 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rulePhaseCategories1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory1361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategory1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirementCategory1422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCategory_in_entryRuleMethodCategory1462 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodCategory1472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethodCategory1523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory1563 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategory1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSelectionCategory1624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategory_in_entryRuleQualityCategory1664 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualityCategory1674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualityCategory1725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhaseCategory_in_entryRulePhaseCategory1765 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhaseCategory1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePhaseCategory1826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategoryFilters_in_entryRuleCategoryFilters1866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategoryFilters1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Category_in_ruleCategoryFilters1914 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_Filters_in_ruleCategoryFilters1926 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleCategoryFilters1938 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleCategorySet_in_ruleCategoryFilters1958 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleCategoryFilters1972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategorySet_in_entryRuleCategorySet2006 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategorySet2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCategorySet2067 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LeftCurlyBracket_in_ruleCategorySet2085 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleCategorySet2107 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_RightCurlyBracket_in_ruleCategorySet2121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef2156 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef2206 = new BitSet(new long[]{0x0000000000000002L});

}

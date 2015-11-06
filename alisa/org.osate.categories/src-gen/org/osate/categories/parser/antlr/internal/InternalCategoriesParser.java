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

@SuppressWarnings("all")
public class InternalCategoriesParser extends AbstractInternalAntlrParser {
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:61:1: entryRuleCategoriesDefinitions returns [EObject current=null] : iv_ruleCategoriesDefinitions= ruleCategoriesDefinitions EOF ;
    public final EObject entryRuleCategoriesDefinitions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategoriesDefinitions = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:62:2: (iv_ruleCategoriesDefinitions= ruleCategoriesDefinitions EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:63:2: iv_ruleCategoriesDefinitions= ruleCategoriesDefinitions EOF
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:70:1: ruleCategoriesDefinitions returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* ) ) ) ;
    public final EObject ruleCategoriesDefinitions() throws RecognitionException {
        EObject current = null;

        EObject lv_requirementcategories_1_0 = null;

        EObject lv_componentcategories_2_0 = null;

        EObject lv_methodcategories_3_0 = null;

        EObject lv_selectioncategories_4_0 = null;

        EObject lv_qualitycategories_5_0 = null;

        EObject lv_categoryfilter_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:73:28: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:74:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:74:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:76:1: ( ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:76:1: ( ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:77:2: ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:80:2: ( ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )* )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:81:3: ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )*
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:81:3: ( ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) ) )*
            loop1:
            do {
                int alt1=7;
                int LA1_0 = input.LA(1);

                if ( LA1_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                    alt1=1;
                }
                else if ( LA1_0 ==Component && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                    alt1=2;
                }
                else if ( LA1_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                    alt1=3;
                }
                else if ( LA1_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:83:4: ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:83:4: ({...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:84:5: {...}? => ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:84:116: ( ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:85:6: ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:88:6: ({...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:88:7: {...}? => ( (lv_requirementcategories_1_0= ruleRequirementCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:88:16: ( (lv_requirementcategories_1_0= ruleRequirementCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:89:1: (lv_requirementcategories_1_0= ruleRequirementCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:89:1: (lv_requirementcategories_1_0= ruleRequirementCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:90:3: lv_requirementcategories_1_0= ruleRequirementCategories
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:113:4: ({...}? => ( ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:113:4: ({...}? => ( ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:114:5: {...}? => ( ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:114:116: ( ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:115:6: ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:118:6: ({...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:118:7: {...}? => ( (lv_componentcategories_2_0= ruleComponentCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:118:16: ( (lv_componentcategories_2_0= ruleComponentCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:119:1: (lv_componentcategories_2_0= ruleComponentCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:119:1: (lv_componentcategories_2_0= ruleComponentCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:120:3: lv_componentcategories_2_0= ruleComponentCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getComponentcategoriesComponentCategoriesParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleComponentCategories_in_ruleCategoriesDefinitions242);
            	    lv_componentcategories_2_0=ruleComponentCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"componentcategories",
            	            		lv_componentcategories_2_0, 
            	            		"ComponentCategories");
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:143:4: ({...}? => ( ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:143:4: ({...}? => ( ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:144:5: {...}? => ( ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:144:116: ( ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:145:6: ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:148:6: ({...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:148:7: {...}? => ( (lv_methodcategories_3_0= ruleMethodCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:148:16: ( (lv_methodcategories_3_0= ruleMethodCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:149:1: (lv_methodcategories_3_0= ruleMethodCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:149:1: (lv_methodcategories_3_0= ruleMethodCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:150:3: lv_methodcategories_3_0= ruleMethodCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesMethodCategoriesParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMethodCategories_in_ruleCategoriesDefinitions317);
            	    lv_methodcategories_3_0=ruleMethodCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"methodcategories",
            	            		lv_methodcategories_3_0, 
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
            	case 4 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:173:4: ({...}? => ( ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:173:4: ({...}? => ( ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:174:5: {...}? => ( ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:174:116: ( ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:175:6: ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:178:6: ({...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:178:7: {...}? => ( (lv_selectioncategories_4_0= ruleSelectionCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:178:16: ( (lv_selectioncategories_4_0= ruleSelectionCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:179:1: (lv_selectioncategories_4_0= ruleSelectionCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:179:1: (lv_selectioncategories_4_0= ruleSelectionCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:180:3: lv_selectioncategories_4_0= ruleSelectionCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesSelectionCategoriesParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSelectionCategories_in_ruleCategoriesDefinitions392);
            	    lv_selectioncategories_4_0=ruleSelectionCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"selectioncategories",
            	            		lv_selectioncategories_4_0, 
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
            	case 5 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:203:4: ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:203:4: ({...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:204:5: {...}? => ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:204:116: ( ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:205:6: ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:208:6: ({...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:208:7: {...}? => ( (lv_qualitycategories_5_0= ruleQualityCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:208:16: ( (lv_qualitycategories_5_0= ruleQualityCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:209:1: (lv_qualitycategories_5_0= ruleQualityCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:209:1: (lv_qualitycategories_5_0= ruleQualityCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:210:3: lv_qualitycategories_5_0= ruleQualityCategories
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:233:4: ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:233:4: ({...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:234:5: {...}? => ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:234:116: ( ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:235:6: ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:238:6: ({...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:238:7: {...}? => ( (lv_categoryfilter_6_0= ruleCategoryFilters ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:238:16: ( (lv_categoryfilter_6_0= ruleCategoryFilters ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:239:1: (lv_categoryfilter_6_0= ruleCategoryFilters )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:239:1: (lv_categoryfilter_6_0= ruleCategoryFilters )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:240:3: lv_categoryfilter_6_0= ruleCategoryFilters
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:278:1: entryRuleRequirementCategories returns [EObject current=null] : iv_ruleRequirementCategories= ruleRequirementCategories EOF ;
    public final EObject entryRuleRequirementCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:279:2: (iv_ruleRequirementCategories= ruleRequirementCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:280:2: iv_ruleRequirementCategories= ruleRequirementCategories EOF
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:287:1: ruleRequirementCategories returns [EObject current=null] : ( () otherlv_1= Requirement otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= RightSquareBracket ) ;
    public final EObject ruleRequirementCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:290:28: ( ( () otherlv_1= Requirement otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:291:1: ( () otherlv_1= Requirement otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:291:1: ( () otherlv_1= Requirement otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:291:2: () otherlv_1= Requirement otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:291:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:292:5: 
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
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:312:1: ( (lv_category_4_0= ruleRequirementCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:313:1: (lv_category_4_0= ruleRequirementCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:313:1: (lv_category_4_0= ruleRequirementCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:314:3: lv_category_4_0= ruleRequirementCategory
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:343:1: entryRuleMethodCategories returns [EObject current=null] : iv_ruleMethodCategories= ruleMethodCategories EOF ;
    public final EObject entryRuleMethodCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:344:2: (iv_ruleMethodCategories= ruleMethodCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:345:2: iv_ruleMethodCategories= ruleMethodCategories EOF
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:352:1: ruleMethodCategories returns [EObject current=null] : ( () otherlv_1= Method otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleMethodCategory ) )+ otherlv_5= RightSquareBracket ) ;
    public final EObject ruleMethodCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:355:28: ( ( () otherlv_1= Method otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleMethodCategory ) )+ otherlv_5= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:356:1: ( () otherlv_1= Method otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleMethodCategory ) )+ otherlv_5= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:356:1: ( () otherlv_1= Method otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleMethodCategory ) )+ otherlv_5= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:356:2: () otherlv_1= Method otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleMethodCategory ) )+ otherlv_5= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:356:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:357:5: 
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
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:377:1: ( (lv_category_4_0= ruleMethodCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:378:1: (lv_category_4_0= ruleMethodCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:378:1: (lv_category_4_0= ruleMethodCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:379:3: lv_category_4_0= ruleMethodCategory
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:408:1: entryRuleSelectionCategories returns [EObject current=null] : iv_ruleSelectionCategories= ruleSelectionCategories EOF ;
    public final EObject entryRuleSelectionCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:409:2: (iv_ruleSelectionCategories= ruleSelectionCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:410:2: iv_ruleSelectionCategories= ruleSelectionCategories EOF
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:417:1: ruleSelectionCategories returns [EObject current=null] : ( () otherlv_1= Selection otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleSelectionCategory ) )+ otherlv_5= RightSquareBracket ) ;
    public final EObject ruleSelectionCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:420:28: ( ( () otherlv_1= Selection otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleSelectionCategory ) )+ otherlv_5= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:421:1: ( () otherlv_1= Selection otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleSelectionCategory ) )+ otherlv_5= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:421:1: ( () otherlv_1= Selection otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleSelectionCategory ) )+ otherlv_5= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:421:2: () otherlv_1= Selection otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleSelectionCategory ) )+ otherlv_5= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:421:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:422:5: 
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
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:442:1: ( (lv_category_4_0= ruleSelectionCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:443:1: (lv_category_4_0= ruleSelectionCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:443:1: (lv_category_4_0= ruleSelectionCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:444:3: lv_category_4_0= ruleSelectionCategory
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:473:1: entryRuleQualityCategories returns [EObject current=null] : iv_ruleQualityCategories= ruleQualityCategories EOF ;
    public final EObject entryRuleQualityCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualityCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:474:2: (iv_ruleQualityCategories= ruleQualityCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:475:2: iv_ruleQualityCategories= ruleQualityCategories EOF
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:482:1: ruleQualityCategories returns [EObject current=null] : ( () otherlv_1= Quality otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleQualityCategory ) )+ otherlv_5= RightSquareBracket ) ;
    public final EObject ruleQualityCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:485:28: ( ( () otherlv_1= Quality otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleQualityCategory ) )+ otherlv_5= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:486:1: ( () otherlv_1= Quality otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleQualityCategory ) )+ otherlv_5= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:486:1: ( () otherlv_1= Quality otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleQualityCategory ) )+ otherlv_5= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:486:2: () otherlv_1= Quality otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleQualityCategory ) )+ otherlv_5= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:486:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:487:5: 
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
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:507:1: ( (lv_category_4_0= ruleQualityCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:508:1: (lv_category_4_0= ruleQualityCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:508:1: (lv_category_4_0= ruleQualityCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:509:3: lv_category_4_0= ruleQualityCategory
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


    // $ANTLR start "entryRuleComponentCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:538:1: entryRuleComponentCategories returns [EObject current=null] : iv_ruleComponentCategories= ruleComponentCategories EOF ;
    public final EObject entryRuleComponentCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:539:2: (iv_ruleComponentCategories= ruleComponentCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:540:2: iv_ruleComponentCategories= ruleComponentCategories EOF
            {
             newCompositeNode(grammarAccess.getComponentCategoriesRule()); 
            pushFollow(FOLLOW_ruleComponentCategories_in_entryRuleComponentCategories1212);
            iv_ruleComponentCategories=ruleComponentCategories();

            state._fsp--;

             current =iv_ruleComponentCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategories1222); 

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
    // $ANTLR end "entryRuleComponentCategories"


    // $ANTLR start "ruleComponentCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:547:1: ruleComponentCategories returns [EObject current=null] : ( () otherlv_1= Component otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleComponentCategory ) )+ otherlv_5= RightSquareBracket ) ;
    public final EObject ruleComponentCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:550:28: ( ( () otherlv_1= Component otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleComponentCategory ) )+ otherlv_5= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:551:1: ( () otherlv_1= Component otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleComponentCategory ) )+ otherlv_5= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:551:1: ( () otherlv_1= Component otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleComponentCategory ) )+ otherlv_5= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:551:2: () otherlv_1= Component otherlv_2= Categories otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleComponentCategory ) )+ otherlv_5= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:551:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:552:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getComponentCategoriesAccess().getComponentCategoriesAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Component,FOLLOW_Component_in_ruleComponentCategories1269); 

                	newLeafNode(otherlv_1, grammarAccess.getComponentCategoriesAccess().getComponentKeyword_1());
                
            otherlv_2=(Token)match(input,Categories,FOLLOW_Categories_in_ruleComponentCategories1281); 

                	newLeafNode(otherlv_2, grammarAccess.getComponentCategoriesAccess().getCategoriesKeyword_2());
                
            otherlv_3=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleComponentCategories1293); 

                	newLeafNode(otherlv_3, grammarAccess.getComponentCategoriesAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:572:1: ( (lv_category_4_0= ruleComponentCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:573:1: (lv_category_4_0= ruleComponentCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:573:1: (lv_category_4_0= ruleComponentCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:574:3: lv_category_4_0= ruleComponentCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentCategoriesAccess().getCategoryComponentCategoryParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleComponentCategory_in_ruleComponentCategories1313);
            	    lv_category_4_0=ruleComponentCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getComponentCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_4_0, 
            	            		"ComponentCategory");
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

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleComponentCategories1327); 

                	newLeafNode(otherlv_5, grammarAccess.getComponentCategoriesAccess().getRightSquareBracketKeyword_5());
                

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
    // $ANTLR end "ruleComponentCategories"


    // $ANTLR start "entryRuleRequirementCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:603:1: entryRuleRequirementCategory returns [EObject current=null] : iv_ruleRequirementCategory= ruleRequirementCategory EOF ;
    public final EObject entryRuleRequirementCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:604:2: (iv_ruleRequirementCategory= ruleRequirementCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:605:2: iv_ruleRequirementCategory= ruleRequirementCategory EOF
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:612:1: ruleRequirementCategory returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleRequirementCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:615:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:616:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:616:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:616:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:616:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:617:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRequirementCategoryAccess().getRequirementCategoryAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:622:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:623:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:623:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:624:3: lv_name_1_0= RULE_ID
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:648:1: entryRuleMethodCategory returns [EObject current=null] : iv_ruleMethodCategory= ruleMethodCategory EOF ;
    public final EObject entryRuleMethodCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:649:2: (iv_ruleMethodCategory= ruleMethodCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:650:2: iv_ruleMethodCategory= ruleMethodCategory EOF
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:657:1: ruleMethodCategory returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleMethodCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:660:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:661:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:661:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:661:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:661:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:662:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMethodCategoryAccess().getMethodCategoryAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:667:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:668:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:668:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:669:3: lv_name_1_0= RULE_ID
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:693:1: entryRuleSelectionCategory returns [EObject current=null] : iv_ruleSelectionCategory= ruleSelectionCategory EOF ;
    public final EObject entryRuleSelectionCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:694:2: (iv_ruleSelectionCategory= ruleSelectionCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:695:2: iv_ruleSelectionCategory= ruleSelectionCategory EOF
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:702:1: ruleSelectionCategory returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSelectionCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:705:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:706:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:706:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:706:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:706:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:707:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSelectionCategoryAccess().getSelectionCategoryAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:712:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:713:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:713:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:714:3: lv_name_1_0= RULE_ID
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:738:1: entryRuleQualityCategory returns [EObject current=null] : iv_ruleQualityCategory= ruleQualityCategory EOF ;
    public final EObject entryRuleQualityCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualityCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:739:2: (iv_ruleQualityCategory= ruleQualityCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:740:2: iv_ruleQualityCategory= ruleQualityCategory EOF
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:747:1: ruleQualityCategory returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleQualityCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:750:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:751:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:751:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:751:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:751:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:752:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getQualityCategoryAccess().getQualityCategoryAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:757:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:758:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:758:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:759:3: lv_name_1_0= RULE_ID
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


    // $ANTLR start "entryRuleComponentCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:783:1: entryRuleComponentCategory returns [EObject current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final EObject entryRuleComponentCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:784:2: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:785:2: iv_ruleComponentCategory= ruleComponentCategory EOF
            {
             newCompositeNode(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory1765);
            iv_ruleComponentCategory=ruleComponentCategory();

            state._fsp--;

             current =iv_ruleComponentCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory1775); 

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
    // $ANTLR end "entryRuleComponentCategory"


    // $ANTLR start "ruleComponentCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:792:1: ruleComponentCategory returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleComponentCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:795:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:796:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:796:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:796:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:796:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:797:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getComponentCategoryAccess().getComponentCategoryAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:802:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:803:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:803:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:804:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentCategory1826); 

            			newLeafNode(lv_name_1_0, grammarAccess.getComponentCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentCategoryRule());
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
    // $ANTLR end "ruleComponentCategory"


    // $ANTLR start "entryRuleCategoryFilters"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:828:1: entryRuleCategoryFilters returns [EObject current=null] : iv_ruleCategoryFilters= ruleCategoryFilters EOF ;
    public final EObject entryRuleCategoryFilters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategoryFilters = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:829:2: (iv_ruleCategoryFilters= ruleCategoryFilters EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:830:2: iv_ruleCategoryFilters= ruleCategoryFilters EOF
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:837:1: ruleCategoryFilters returns [EObject current=null] : (otherlv_0= Category otherlv_1= Filters otherlv_2= LeftSquareBracket ( (lv_filters_3_0= ruleCategorySet ) )+ otherlv_4= RightSquareBracket ) ;
    public final EObject ruleCategoryFilters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_filters_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:840:28: ( (otherlv_0= Category otherlv_1= Filters otherlv_2= LeftSquareBracket ( (lv_filters_3_0= ruleCategorySet ) )+ otherlv_4= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:841:1: (otherlv_0= Category otherlv_1= Filters otherlv_2= LeftSquareBracket ( (lv_filters_3_0= ruleCategorySet ) )+ otherlv_4= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:841:1: (otherlv_0= Category otherlv_1= Filters otherlv_2= LeftSquareBracket ( (lv_filters_3_0= ruleCategorySet ) )+ otherlv_4= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:842:2: otherlv_0= Category otherlv_1= Filters otherlv_2= LeftSquareBracket ( (lv_filters_3_0= ruleCategorySet ) )+ otherlv_4= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Category,FOLLOW_Category_in_ruleCategoryFilters1914); 

                	newLeafNode(otherlv_0, grammarAccess.getCategoryFiltersAccess().getCategoryKeyword_0());
                
            otherlv_1=(Token)match(input,Filters,FOLLOW_Filters_in_ruleCategoryFilters1926); 

                	newLeafNode(otherlv_1, grammarAccess.getCategoryFiltersAccess().getFiltersKeyword_1());
                
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleCategoryFilters1938); 

                	newLeafNode(otherlv_2, grammarAccess.getCategoryFiltersAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:856:1: ( (lv_filters_3_0= ruleCategorySet ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:857:1: (lv_filters_3_0= ruleCategorySet )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:857:1: (lv_filters_3_0= ruleCategorySet )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:858:3: lv_filters_3_0= ruleCategorySet
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:887:1: entryRuleCategorySet returns [EObject current=null] : iv_ruleCategorySet= ruleCategorySet EOF ;
    public final EObject entryRuleCategorySet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategorySet = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:888:2: (iv_ruleCategorySet= ruleCategorySet EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:889:2: iv_ruleCategorySet= ruleCategorySet EOF
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:896:1: ruleCategorySet returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_4= RightCurlyBracket ) ;
    public final EObject ruleCategorySet() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:899:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_4= RightCurlyBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:900:1: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_4= RightCurlyBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:900:1: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_4= RightCurlyBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:900:2: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_4= RightCurlyBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:900:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:901:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCategorySetAccess().getCategorySetAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:906:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:907:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:907:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:908:3: lv_name_1_0= RULE_ID
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
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:929:1: ( ( ruleCatRef ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:930:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:930:1: ( ruleCatRef )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:931:3: ruleCatRef
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:957:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:958:1: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:959:2: iv_ruleCatRef= ruleCatRef EOF
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:966:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:970:6: (this_ID_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:971:5: this_ID_0= RULE_ID
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
    public static final BitSet FOLLOW_ruleRequirementCategories_in_ruleCategoriesDefinitions167 = new BitSet(new long[]{0x0000000000000DD2L});
    public static final BitSet FOLLOW_ruleComponentCategories_in_ruleCategoriesDefinitions242 = new BitSet(new long[]{0x0000000000000DD2L});
    public static final BitSet FOLLOW_ruleMethodCategories_in_ruleCategoriesDefinitions317 = new BitSet(new long[]{0x0000000000000DD2L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_ruleCategoriesDefinitions392 = new BitSet(new long[]{0x0000000000000DD2L});
    public static final BitSet FOLLOW_ruleQualityCategories_in_ruleCategoriesDefinitions467 = new BitSet(new long[]{0x0000000000000DD2L});
    public static final BitSet FOLLOW_ruleCategoryFilters_in_ruleCategoriesDefinitions542 = new BitSet(new long[]{0x0000000000000DD2L});
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
    public static final BitSet FOLLOW_ruleComponentCategories_in_entryRuleComponentCategories1212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategories1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Component_in_ruleComponentCategories1269 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Categories_in_ruleComponentCategories1281 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleComponentCategories1293 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_ruleComponentCategories1313 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleComponentCategories1327 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory1765 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentCategory1826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategoryFilters_in_entryRuleCategoryFilters1866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategoryFilters1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Category_in_ruleCategoryFilters1914 = new BitSet(new long[]{0x0000000000000200L});
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

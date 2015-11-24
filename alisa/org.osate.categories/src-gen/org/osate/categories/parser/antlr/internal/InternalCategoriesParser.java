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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:82:1: ruleCategoriesDefinitions returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) ) ) ) )* ) ) ) ;
    public final EObject ruleCategoriesDefinitions() throws RecognitionException {
        EObject current = null;

        EObject lv_requirementTypeCategories_1_0 = null;

        EObject lv_methodTypeCategories_2_0 = null;

        EObject lv_selectioncategories_3_0 = null;

        EObject lv_developmentPhaseCategories_4_0 = null;

        EObject lv_qualityAttributeCategories_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:85:28: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) ) ) ) )* ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:86:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) ) ) ) )* ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:86:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) ) ) ) )* ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:88:1: ( ( ( ({...}? => ( ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) ) ) ) )* ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:88:1: ( ( ( ({...}? => ( ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) ) ) ) )* ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:89:2: ( ( ({...}? => ( ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:92:2: ( ( ({...}? => ( ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) ) ) ) )* )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:93:3: ( ({...}? => ( ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) ) ) ) )*
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:93:3: ( ({...}? => ( ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) ) ) ) )*
            loop1:
            do {
                int alt1=6;
                int LA1_0 = input.LA(1);

                if ( LA1_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                    alt1=1;
                }
                else if ( LA1_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                    alt1=2;
                }
                else if ( LA1_0 ==User && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                    alt1=3;
                }
                else if ( LA1_0 ==Development && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                    alt1=4;
                }
                else if ( LA1_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                    alt1=5;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:95:4: ({...}? => ( ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:95:4: ({...}? => ( ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:96:5: {...}? => ( ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:96:116: ( ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:97:6: ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:100:6: ({...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:100:7: {...}? => ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:100:16: ( (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:101:1: (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:101:1: (lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:102:3: lv_requirementTypeCategories_1_0= ruleRequirementTypeCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getRequirementTypeCategoriesRequirementTypeCategoriesParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRequirementTypeCategories_in_ruleCategoriesDefinitions167);
            	    lv_requirementTypeCategories_1_0=ruleRequirementTypeCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"requirementTypeCategories",
            	            		lv_requirementTypeCategories_1_0, 
            	            		"RequirementTypeCategories");
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:125:4: ({...}? => ( ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:125:4: ({...}? => ( ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:126:5: {...}? => ( ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:126:116: ( ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:127:6: ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:130:6: ({...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:130:7: {...}? => ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:130:16: ( (lv_methodTypeCategories_2_0= ruleMethodTypeCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:131:1: (lv_methodTypeCategories_2_0= ruleMethodTypeCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:131:1: (lv_methodTypeCategories_2_0= ruleMethodTypeCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:132:3: lv_methodTypeCategories_2_0= ruleMethodTypeCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getMethodTypeCategoriesMethodTypeCategoriesParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMethodTypeCategories_in_ruleCategoriesDefinitions242);
            	    lv_methodTypeCategories_2_0=ruleMethodTypeCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"methodTypeCategories",
            	            		lv_methodTypeCategories_2_0, 
            	            		"MethodTypeCategories");
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:155:4: ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:155:4: ({...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:156:5: {...}? => ( ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:156:116: ( ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:157:6: ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:160:6: ({...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:160:7: {...}? => ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:160:16: ( (lv_selectioncategories_3_0= ruleUserSelectionCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:161:1: (lv_selectioncategories_3_0= ruleUserSelectionCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:161:1: (lv_selectioncategories_3_0= ruleUserSelectionCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:162:3: lv_selectioncategories_3_0= ruleUserSelectionCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesUserSelectionCategoriesParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUserSelectionCategories_in_ruleCategoriesDefinitions317);
            	    lv_selectioncategories_3_0=ruleUserSelectionCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"selectioncategories",
            	            		lv_selectioncategories_3_0, 
            	            		"UserSelectionCategories");
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:185:4: ({...}? => ( ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:185:4: ({...}? => ( ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:186:5: {...}? => ( ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:186:116: ( ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:187:6: ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:190:6: ({...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:190:7: {...}? => ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:190:16: ( (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:191:1: (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:191:1: (lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:192:3: lv_developmentPhaseCategories_4_0= ruleDevelopmentPhaseCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getDevelopmentPhaseCategoriesDevelopmentPhaseCategoriesParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDevelopmentPhaseCategories_in_ruleCategoriesDefinitions392);
            	    lv_developmentPhaseCategories_4_0=ruleDevelopmentPhaseCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"developmentPhaseCategories",
            	            		lv_developmentPhaseCategories_4_0, 
            	            		"DevelopmentPhaseCategories");
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:215:4: ({...}? => ( ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:215:4: ({...}? => ( ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:216:5: {...}? => ( ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:216:116: ( ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:217:6: ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:220:6: ({...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:220:7: {...}? => ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:220:16: ( (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:221:1: (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:221:1: (lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:222:3: lv_qualityAttributeCategories_5_0= ruleQualityAttributeCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getQualityAttributeCategoriesQualityAttributeCategoriesParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualityAttributeCategories_in_ruleCategoriesDefinitions467);
            	    lv_qualityAttributeCategories_5_0=ruleQualityAttributeCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"qualityAttributeCategories",
            	            		lv_qualityAttributeCategories_5_0, 
            	            		"QualityAttributeCategories");
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


    // $ANTLR start "entryRuleRequirementTypeCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:260:1: entryRuleRequirementTypeCategories returns [EObject current=null] : iv_ruleRequirementTypeCategories= ruleRequirementTypeCategories EOF ;
    public final EObject entryRuleRequirementTypeCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementTypeCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:261:2: (iv_ruleRequirementTypeCategories= ruleRequirementTypeCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:262:2: iv_ruleRequirementTypeCategories= ruleRequirementTypeCategories EOF
            {
             newCompositeNode(grammarAccess.getRequirementTypeCategoriesRule()); 
            pushFollow(FOLLOW_ruleRequirementTypeCategories_in_entryRuleRequirementTypeCategories541);
            iv_ruleRequirementTypeCategories=ruleRequirementTypeCategories();

            state._fsp--;

             current =iv_ruleRequirementTypeCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementTypeCategories551); 

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
    // $ANTLR end "entryRuleRequirementTypeCategories"


    // $ANTLR start "ruleRequirementTypeCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:269:1: ruleRequirementTypeCategories returns [EObject current=null] : ( () otherlv_1= Requirement otherlv_2= Type otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleRequirementType ) )+ otherlv_5= RightSquareBracket ) ;
    public final EObject ruleRequirementTypeCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:272:28: ( ( () otherlv_1= Requirement otherlv_2= Type otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleRequirementType ) )+ otherlv_5= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:273:1: ( () otherlv_1= Requirement otherlv_2= Type otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleRequirementType ) )+ otherlv_5= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:273:1: ( () otherlv_1= Requirement otherlv_2= Type otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleRequirementType ) )+ otherlv_5= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:273:2: () otherlv_1= Requirement otherlv_2= Type otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleRequirementType ) )+ otherlv_5= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:273:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:274:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRequirementTypeCategoriesAccess().getRequirementTypeCategoriesAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirementTypeCategories598); 

                	newLeafNode(otherlv_1, grammarAccess.getRequirementTypeCategoriesAccess().getRequirementKeyword_1());
                
            otherlv_2=(Token)match(input,Type,FOLLOW_Type_in_ruleRequirementTypeCategories610); 

                	newLeafNode(otherlv_2, grammarAccess.getRequirementTypeCategoriesAccess().getTypeKeyword_2());
                
            otherlv_3=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleRequirementTypeCategories622); 

                	newLeafNode(otherlv_3, grammarAccess.getRequirementTypeCategoriesAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:294:1: ( (lv_category_4_0= ruleRequirementType ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:295:1: (lv_category_4_0= ruleRequirementType )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:295:1: (lv_category_4_0= ruleRequirementType )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:296:3: lv_category_4_0= ruleRequirementType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementTypeCategoriesAccess().getCategoryRequirementTypeParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRequirementType_in_ruleRequirementTypeCategories642);
            	    lv_category_4_0=ruleRequirementType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementTypeCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_4_0, 
            	            		"RequirementType");
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

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleRequirementTypeCategories656); 

                	newLeafNode(otherlv_5, grammarAccess.getRequirementTypeCategoriesAccess().getRightSquareBracketKeyword_5());
                

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
    // $ANTLR end "ruleRequirementTypeCategories"


    // $ANTLR start "entryRuleMethodTypeCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:325:1: entryRuleMethodTypeCategories returns [EObject current=null] : iv_ruleMethodTypeCategories= ruleMethodTypeCategories EOF ;
    public final EObject entryRuleMethodTypeCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodTypeCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:326:2: (iv_ruleMethodTypeCategories= ruleMethodTypeCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:327:2: iv_ruleMethodTypeCategories= ruleMethodTypeCategories EOF
            {
             newCompositeNode(grammarAccess.getMethodTypeCategoriesRule()); 
            pushFollow(FOLLOW_ruleMethodTypeCategories_in_entryRuleMethodTypeCategories690);
            iv_ruleMethodTypeCategories=ruleMethodTypeCategories();

            state._fsp--;

             current =iv_ruleMethodTypeCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodTypeCategories700); 

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
    // $ANTLR end "entryRuleMethodTypeCategories"


    // $ANTLR start "ruleMethodTypeCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:334:1: ruleMethodTypeCategories returns [EObject current=null] : ( () otherlv_1= Method otherlv_2= Type otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleMethodType ) )+ otherlv_5= RightSquareBracket ) ;
    public final EObject ruleMethodTypeCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:337:28: ( ( () otherlv_1= Method otherlv_2= Type otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleMethodType ) )+ otherlv_5= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:338:1: ( () otherlv_1= Method otherlv_2= Type otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleMethodType ) )+ otherlv_5= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:338:1: ( () otherlv_1= Method otherlv_2= Type otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleMethodType ) )+ otherlv_5= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:338:2: () otherlv_1= Method otherlv_2= Type otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleMethodType ) )+ otherlv_5= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:338:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:339:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMethodTypeCategoriesAccess().getMethodTypeCategoriesAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Method,FOLLOW_Method_in_ruleMethodTypeCategories747); 

                	newLeafNode(otherlv_1, grammarAccess.getMethodTypeCategoriesAccess().getMethodKeyword_1());
                
            otherlv_2=(Token)match(input,Type,FOLLOW_Type_in_ruleMethodTypeCategories759); 

                	newLeafNode(otherlv_2, grammarAccess.getMethodTypeCategoriesAccess().getTypeKeyword_2());
                
            otherlv_3=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleMethodTypeCategories771); 

                	newLeafNode(otherlv_3, grammarAccess.getMethodTypeCategoriesAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:359:1: ( (lv_category_4_0= ruleMethodType ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:360:1: (lv_category_4_0= ruleMethodType )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:360:1: (lv_category_4_0= ruleMethodType )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:361:3: lv_category_4_0= ruleMethodType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMethodTypeCategoriesAccess().getCategoryMethodTypeParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMethodType_in_ruleMethodTypeCategories791);
            	    lv_category_4_0=ruleMethodType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMethodTypeCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_4_0, 
            	            		"MethodType");
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

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleMethodTypeCategories805); 

                	newLeafNode(otherlv_5, grammarAccess.getMethodTypeCategoriesAccess().getRightSquareBracketKeyword_5());
                

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
    // $ANTLR end "ruleMethodTypeCategories"


    // $ANTLR start "entryRuleUserSelectionCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:390:1: entryRuleUserSelectionCategories returns [EObject current=null] : iv_ruleUserSelectionCategories= ruleUserSelectionCategories EOF ;
    public final EObject entryRuleUserSelectionCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUserSelectionCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:391:2: (iv_ruleUserSelectionCategories= ruleUserSelectionCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:392:2: iv_ruleUserSelectionCategories= ruleUserSelectionCategories EOF
            {
             newCompositeNode(grammarAccess.getUserSelectionCategoriesRule()); 
            pushFollow(FOLLOW_ruleUserSelectionCategories_in_entryRuleUserSelectionCategories839);
            iv_ruleUserSelectionCategories=ruleUserSelectionCategories();

            state._fsp--;

             current =iv_ruleUserSelectionCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUserSelectionCategories849); 

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
    // $ANTLR end "entryRuleUserSelectionCategories"


    // $ANTLR start "ruleUserSelectionCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:399:1: ruleUserSelectionCategories returns [EObject current=null] : ( () otherlv_1= User otherlv_2= Selection otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleUserSelection ) )+ otherlv_5= RightSquareBracket ) ;
    public final EObject ruleUserSelectionCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:402:28: ( ( () otherlv_1= User otherlv_2= Selection otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleUserSelection ) )+ otherlv_5= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:403:1: ( () otherlv_1= User otherlv_2= Selection otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleUserSelection ) )+ otherlv_5= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:403:1: ( () otherlv_1= User otherlv_2= Selection otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleUserSelection ) )+ otherlv_5= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:403:2: () otherlv_1= User otherlv_2= Selection otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleUserSelection ) )+ otherlv_5= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:403:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:404:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUserSelectionCategoriesAccess().getUserSelectionCategoriesAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,User,FOLLOW_User_in_ruleUserSelectionCategories896); 

                	newLeafNode(otherlv_1, grammarAccess.getUserSelectionCategoriesAccess().getUserKeyword_1());
                
            otherlv_2=(Token)match(input,Selection,FOLLOW_Selection_in_ruleUserSelectionCategories908); 

                	newLeafNode(otherlv_2, grammarAccess.getUserSelectionCategoriesAccess().getSelectionKeyword_2());
                
            otherlv_3=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleUserSelectionCategories920); 

                	newLeafNode(otherlv_3, grammarAccess.getUserSelectionCategoriesAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:424:1: ( (lv_category_4_0= ruleUserSelection ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:425:1: (lv_category_4_0= ruleUserSelection )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:425:1: (lv_category_4_0= ruleUserSelection )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:426:3: lv_category_4_0= ruleUserSelection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUserSelectionCategoriesAccess().getCategoryUserSelectionParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUserSelection_in_ruleUserSelectionCategories940);
            	    lv_category_4_0=ruleUserSelection();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getUserSelectionCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_4_0, 
            	            		"UserSelection");
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

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleUserSelectionCategories954); 

                	newLeafNode(otherlv_5, grammarAccess.getUserSelectionCategoriesAccess().getRightSquareBracketKeyword_5());
                

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
    // $ANTLR end "ruleUserSelectionCategories"


    // $ANTLR start "entryRuleQualityAttributeCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:455:1: entryRuleQualityAttributeCategories returns [EObject current=null] : iv_ruleQualityAttributeCategories= ruleQualityAttributeCategories EOF ;
    public final EObject entryRuleQualityAttributeCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualityAttributeCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:456:2: (iv_ruleQualityAttributeCategories= ruleQualityAttributeCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:457:2: iv_ruleQualityAttributeCategories= ruleQualityAttributeCategories EOF
            {
             newCompositeNode(grammarAccess.getQualityAttributeCategoriesRule()); 
            pushFollow(FOLLOW_ruleQualityAttributeCategories_in_entryRuleQualityAttributeCategories988);
            iv_ruleQualityAttributeCategories=ruleQualityAttributeCategories();

            state._fsp--;

             current =iv_ruleQualityAttributeCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualityAttributeCategories998); 

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
    // $ANTLR end "entryRuleQualityAttributeCategories"


    // $ANTLR start "ruleQualityAttributeCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:464:1: ruleQualityAttributeCategories returns [EObject current=null] : ( () otherlv_1= Quality otherlv_2= Attribute otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleQualityAttribute ) )+ otherlv_5= RightSquareBracket ) ;
    public final EObject ruleQualityAttributeCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:467:28: ( ( () otherlv_1= Quality otherlv_2= Attribute otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleQualityAttribute ) )+ otherlv_5= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:468:1: ( () otherlv_1= Quality otherlv_2= Attribute otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleQualityAttribute ) )+ otherlv_5= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:468:1: ( () otherlv_1= Quality otherlv_2= Attribute otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleQualityAttribute ) )+ otherlv_5= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:468:2: () otherlv_1= Quality otherlv_2= Attribute otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleQualityAttribute ) )+ otherlv_5= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:468:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:469:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getQualityAttributeCategoriesAccess().getQualityAttributeCategoriesAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Quality,FOLLOW_Quality_in_ruleQualityAttributeCategories1045); 

                	newLeafNode(otherlv_1, grammarAccess.getQualityAttributeCategoriesAccess().getQualityKeyword_1());
                
            otherlv_2=(Token)match(input,Attribute,FOLLOW_Attribute_in_ruleQualityAttributeCategories1057); 

                	newLeafNode(otherlv_2, grammarAccess.getQualityAttributeCategoriesAccess().getAttributeKeyword_2());
                
            otherlv_3=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleQualityAttributeCategories1069); 

                	newLeafNode(otherlv_3, grammarAccess.getQualityAttributeCategoriesAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:489:1: ( (lv_category_4_0= ruleQualityAttribute ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:490:1: (lv_category_4_0= ruleQualityAttribute )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:490:1: (lv_category_4_0= ruleQualityAttribute )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:491:3: lv_category_4_0= ruleQualityAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQualityAttributeCategoriesAccess().getCategoryQualityAttributeParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualityAttribute_in_ruleQualityAttributeCategories1089);
            	    lv_category_4_0=ruleQualityAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getQualityAttributeCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_4_0, 
            	            		"QualityAttribute");
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

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleQualityAttributeCategories1103); 

                	newLeafNode(otherlv_5, grammarAccess.getQualityAttributeCategoriesAccess().getRightSquareBracketKeyword_5());
                

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
    // $ANTLR end "ruleQualityAttributeCategories"


    // $ANTLR start "entryRuleDevelopmentPhaseCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:520:1: entryRuleDevelopmentPhaseCategories returns [EObject current=null] : iv_ruleDevelopmentPhaseCategories= ruleDevelopmentPhaseCategories EOF ;
    public final EObject entryRuleDevelopmentPhaseCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDevelopmentPhaseCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:521:2: (iv_ruleDevelopmentPhaseCategories= ruleDevelopmentPhaseCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:522:2: iv_ruleDevelopmentPhaseCategories= ruleDevelopmentPhaseCategories EOF
            {
             newCompositeNode(grammarAccess.getDevelopmentPhaseCategoriesRule()); 
            pushFollow(FOLLOW_ruleDevelopmentPhaseCategories_in_entryRuleDevelopmentPhaseCategories1137);
            iv_ruleDevelopmentPhaseCategories=ruleDevelopmentPhaseCategories();

            state._fsp--;

             current =iv_ruleDevelopmentPhaseCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDevelopmentPhaseCategories1147); 

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
    // $ANTLR end "entryRuleDevelopmentPhaseCategories"


    // $ANTLR start "ruleDevelopmentPhaseCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:529:1: ruleDevelopmentPhaseCategories returns [EObject current=null] : ( () otherlv_1= Development otherlv_2= Phase otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleDevelopmentPhase ) )+ otherlv_5= RightSquareBracket ) ;
    public final EObject ruleDevelopmentPhaseCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:532:28: ( ( () otherlv_1= Development otherlv_2= Phase otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleDevelopmentPhase ) )+ otherlv_5= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:533:1: ( () otherlv_1= Development otherlv_2= Phase otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleDevelopmentPhase ) )+ otherlv_5= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:533:1: ( () otherlv_1= Development otherlv_2= Phase otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleDevelopmentPhase ) )+ otherlv_5= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:533:2: () otherlv_1= Development otherlv_2= Phase otherlv_3= LeftSquareBracket ( (lv_category_4_0= ruleDevelopmentPhase ) )+ otherlv_5= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:533:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:534:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDevelopmentPhaseCategoriesAccess().getDevelopmentPhaseCategoriesAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Development,FOLLOW_Development_in_ruleDevelopmentPhaseCategories1194); 

                	newLeafNode(otherlv_1, grammarAccess.getDevelopmentPhaseCategoriesAccess().getDevelopmentKeyword_1());
                
            otherlv_2=(Token)match(input,Phase,FOLLOW_Phase_in_ruleDevelopmentPhaseCategories1206); 

                	newLeafNode(otherlv_2, grammarAccess.getDevelopmentPhaseCategoriesAccess().getPhaseKeyword_2());
                
            otherlv_3=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleDevelopmentPhaseCategories1218); 

                	newLeafNode(otherlv_3, grammarAccess.getDevelopmentPhaseCategoriesAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:554:1: ( (lv_category_4_0= ruleDevelopmentPhase ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:555:1: (lv_category_4_0= ruleDevelopmentPhase )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:555:1: (lv_category_4_0= ruleDevelopmentPhase )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:556:3: lv_category_4_0= ruleDevelopmentPhase
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDevelopmentPhaseCategoriesAccess().getCategoryDevelopmentPhaseParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDevelopmentPhase_in_ruleDevelopmentPhaseCategories1238);
            	    lv_category_4_0=ruleDevelopmentPhase();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDevelopmentPhaseCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_4_0, 
            	            		"DevelopmentPhase");
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

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleDevelopmentPhaseCategories1252); 

                	newLeafNode(otherlv_5, grammarAccess.getDevelopmentPhaseCategoriesAccess().getRightSquareBracketKeyword_5());
                

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
    // $ANTLR end "ruleDevelopmentPhaseCategories"


    // $ANTLR start "entryRuleRequirementType"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:585:1: entryRuleRequirementType returns [EObject current=null] : iv_ruleRequirementType= ruleRequirementType EOF ;
    public final EObject entryRuleRequirementType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementType = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:586:2: (iv_ruleRequirementType= ruleRequirementType EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:587:2: iv_ruleRequirementType= ruleRequirementType EOF
            {
             newCompositeNode(grammarAccess.getRequirementTypeRule()); 
            pushFollow(FOLLOW_ruleRequirementType_in_entryRuleRequirementType1286);
            iv_ruleRequirementType=ruleRequirementType();

            state._fsp--;

             current =iv_ruleRequirementType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementType1296); 

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
    // $ANTLR end "entryRuleRequirementType"


    // $ANTLR start "ruleRequirementType"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:594:1: ruleRequirementType returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleRequirementType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:597:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:598:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:598:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:598:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:598:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:599:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRequirementTypeAccess().getRequirementTypeAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:604:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:605:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:605:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:606:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirementType1347); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRequirementTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRequirementTypeRule());
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
    // $ANTLR end "ruleRequirementType"


    // $ANTLR start "entryRuleMethodType"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:630:1: entryRuleMethodType returns [EObject current=null] : iv_ruleMethodType= ruleMethodType EOF ;
    public final EObject entryRuleMethodType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodType = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:631:2: (iv_ruleMethodType= ruleMethodType EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:632:2: iv_ruleMethodType= ruleMethodType EOF
            {
             newCompositeNode(grammarAccess.getMethodTypeRule()); 
            pushFollow(FOLLOW_ruleMethodType_in_entryRuleMethodType1387);
            iv_ruleMethodType=ruleMethodType();

            state._fsp--;

             current =iv_ruleMethodType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodType1397); 

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
    // $ANTLR end "entryRuleMethodType"


    // $ANTLR start "ruleMethodType"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:639:1: ruleMethodType returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleMethodType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:642:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:643:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:643:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:643:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:643:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:644:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMethodTypeAccess().getMethodTypeAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:649:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:650:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:650:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:651:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethodType1448); 

            			newLeafNode(lv_name_1_0, grammarAccess.getMethodTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodTypeRule());
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
    // $ANTLR end "ruleMethodType"


    // $ANTLR start "entryRuleUserSelection"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:675:1: entryRuleUserSelection returns [EObject current=null] : iv_ruleUserSelection= ruleUserSelection EOF ;
    public final EObject entryRuleUserSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUserSelection = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:676:2: (iv_ruleUserSelection= ruleUserSelection EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:677:2: iv_ruleUserSelection= ruleUserSelection EOF
            {
             newCompositeNode(grammarAccess.getUserSelectionRule()); 
            pushFollow(FOLLOW_ruleUserSelection_in_entryRuleUserSelection1488);
            iv_ruleUserSelection=ruleUserSelection();

            state._fsp--;

             current =iv_ruleUserSelection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUserSelection1498); 

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
    // $ANTLR end "entryRuleUserSelection"


    // $ANTLR start "ruleUserSelection"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:684:1: ruleUserSelection returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleUserSelection() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:687:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:688:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:688:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:688:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:688:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:689:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUserSelectionAccess().getUserSelectionAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:694:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:695:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:695:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:696:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUserSelection1549); 

            			newLeafNode(lv_name_1_0, grammarAccess.getUserSelectionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUserSelectionRule());
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
    // $ANTLR end "ruleUserSelection"


    // $ANTLR start "entryRuleQualityAttribute"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:720:1: entryRuleQualityAttribute returns [EObject current=null] : iv_ruleQualityAttribute= ruleQualityAttribute EOF ;
    public final EObject entryRuleQualityAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualityAttribute = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:721:2: (iv_ruleQualityAttribute= ruleQualityAttribute EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:722:2: iv_ruleQualityAttribute= ruleQualityAttribute EOF
            {
             newCompositeNode(grammarAccess.getQualityAttributeRule()); 
            pushFollow(FOLLOW_ruleQualityAttribute_in_entryRuleQualityAttribute1589);
            iv_ruleQualityAttribute=ruleQualityAttribute();

            state._fsp--;

             current =iv_ruleQualityAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualityAttribute1599); 

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
    // $ANTLR end "entryRuleQualityAttribute"


    // $ANTLR start "ruleQualityAttribute"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:729:1: ruleQualityAttribute returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleQualityAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:732:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:733:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:733:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:733:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:733:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:734:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getQualityAttributeAccess().getQualityAttributeAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:739:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:740:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:740:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:741:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualityAttribute1650); 

            			newLeafNode(lv_name_1_0, grammarAccess.getQualityAttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQualityAttributeRule());
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
    // $ANTLR end "ruleQualityAttribute"


    // $ANTLR start "entryRuleDevelopmentPhase"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:765:1: entryRuleDevelopmentPhase returns [EObject current=null] : iv_ruleDevelopmentPhase= ruleDevelopmentPhase EOF ;
    public final EObject entryRuleDevelopmentPhase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDevelopmentPhase = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:766:2: (iv_ruleDevelopmentPhase= ruleDevelopmentPhase EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:767:2: iv_ruleDevelopmentPhase= ruleDevelopmentPhase EOF
            {
             newCompositeNode(grammarAccess.getDevelopmentPhaseRule()); 
            pushFollow(FOLLOW_ruleDevelopmentPhase_in_entryRuleDevelopmentPhase1690);
            iv_ruleDevelopmentPhase=ruleDevelopmentPhase();

            state._fsp--;

             current =iv_ruleDevelopmentPhase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDevelopmentPhase1700); 

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
    // $ANTLR end "entryRuleDevelopmentPhase"


    // $ANTLR start "ruleDevelopmentPhase"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:774:1: ruleDevelopmentPhase returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleDevelopmentPhase() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:777:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:778:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:778:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:778:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:778:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:779:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDevelopmentPhaseAccess().getDevelopmentPhaseAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:784:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:785:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:785:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:786:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDevelopmentPhase1751); 

            			newLeafNode(lv_name_1_0, grammarAccess.getDevelopmentPhaseAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDevelopmentPhaseRule());
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
    // $ANTLR end "ruleDevelopmentPhase"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleCategoriesDefinitions_in_entryRuleCategoriesDefinitions67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategoriesDefinitions77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementTypeCategories_in_ruleCategoriesDefinitions167 = new BitSet(new long[]{0x0000000000001332L});
    public static final BitSet FOLLOW_ruleMethodTypeCategories_in_ruleCategoriesDefinitions242 = new BitSet(new long[]{0x0000000000001332L});
    public static final BitSet FOLLOW_ruleUserSelectionCategories_in_ruleCategoriesDefinitions317 = new BitSet(new long[]{0x0000000000001332L});
    public static final BitSet FOLLOW_ruleDevelopmentPhaseCategories_in_ruleCategoriesDefinitions392 = new BitSet(new long[]{0x0000000000001332L});
    public static final BitSet FOLLOW_ruleQualityAttributeCategories_in_ruleCategoriesDefinitions467 = new BitSet(new long[]{0x0000000000001332L});
    public static final BitSet FOLLOW_ruleRequirementTypeCategories_in_entryRuleRequirementTypeCategories541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementTypeCategories551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirementTypeCategories598 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_Type_in_ruleRequirementTypeCategories610 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleRequirementTypeCategories622 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleRequirementType_in_ruleRequirementTypeCategories642 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleRequirementTypeCategories656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodTypeCategories_in_entryRuleMethodTypeCategories690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodTypeCategories700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Method_in_ruleMethodTypeCategories747 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_Type_in_ruleMethodTypeCategories759 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleMethodTypeCategories771 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleMethodType_in_ruleMethodTypeCategories791 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleMethodTypeCategories805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUserSelectionCategories_in_entryRuleUserSelectionCategories839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUserSelectionCategories849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_User_in_ruleUserSelectionCategories896 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Selection_in_ruleUserSelectionCategories908 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleUserSelectionCategories920 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleUserSelection_in_ruleUserSelectionCategories940 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleUserSelectionCategories954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityAttributeCategories_in_entryRuleQualityAttributeCategories988 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualityAttributeCategories998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Quality_in_ruleQualityAttributeCategories1045 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Attribute_in_ruleQualityAttributeCategories1057 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleQualityAttributeCategories1069 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleQualityAttribute_in_ruleQualityAttributeCategories1089 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleQualityAttributeCategories1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDevelopmentPhaseCategories_in_entryRuleDevelopmentPhaseCategories1137 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDevelopmentPhaseCategories1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Development_in_ruleDevelopmentPhaseCategories1194 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_Phase_in_ruleDevelopmentPhaseCategories1206 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleDevelopmentPhaseCategories1218 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDevelopmentPhase_in_ruleDevelopmentPhaseCategories1238 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleDevelopmentPhaseCategories1252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementType_in_entryRuleRequirementType1286 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementType1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirementType1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodType_in_entryRuleMethodType1387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodType1397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethodType1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUserSelection_in_entryRuleUserSelection1488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUserSelection1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUserSelection1549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityAttribute_in_entryRuleQualityAttribute1589 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualityAttribute1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualityAttribute1650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDevelopmentPhase_in_entryRuleDevelopmentPhase1690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDevelopmentPhase1700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDevelopmentPhase1751 = new BitSet(new long[]{0x0000000000000002L});

}

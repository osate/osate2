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
parser grammar InternalCategoriesParser;

options {
	tokenVocab=InternalCategoriesLexer;
	superClass=AbstractInternalAntlrParser;
	
}

@header {
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

}

@members {


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
}

@rulecatch { 
	catch (RecognitionException re) { 
	    recover(input,re); 
	    appendSkippedTokens();
	}
}




// Entry rule entryRuleCategoriesDefinitions
entryRuleCategoriesDefinitions returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getCategoriesDefinitionsRule()); }
	 iv_ruleCategoriesDefinitions=ruleCategoriesDefinitions 
	 { $current=$iv_ruleCategoriesDefinitions.current; } 
	 EOF 
;

// Rule CategoriesDefinitions
ruleCategoriesDefinitions returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getRequirementcategoriesRequirementCategoriesParserRuleCall_0_0()); 
	    }
		lv_requirementcategories_1_0=ruleRequirementCategories		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
	        }
       		set(
       			$current, 
       			"requirementcategories",
        		lv_requirementcategories_1_0, 
        		"RequirementCategories");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesMethodCategoriesParserRuleCall_1_0()); 
	    }
		lv_methodcategories_2_0=ruleMethodCategories		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
	        }
       		set(
       			$current, 
       			"methodcategories",
        		lv_methodcategories_2_0, 
        		"MethodCategories");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesSelectionCategoriesParserRuleCall_2_0()); 
	    }
		lv_selectioncategories_3_0=ruleSelectionCategories		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
	        }
       		set(
       			$current, 
       			"selectioncategories",
        		lv_selectioncategories_3_0, 
        		"SelectionCategories");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getPhasecategoriesPhaseCategoriesParserRuleCall_3_0()); 
	    }
		lv_phasecategories_4_0=rulePhaseCategories		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
	        }
       		set(
       			$current, 
       			"phasecategories",
        		lv_phasecategories_4_0, 
        		"PhaseCategories");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesQualityCategoriesParserRuleCall_4_0()); 
	    }
		lv_qualitycategories_5_0=ruleQualityCategories		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
	        }
       		set(
       			$current, 
       			"qualitycategories",
        		lv_qualitycategories_5_0, 
        		"QualityCategories");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterCategoryFiltersParserRuleCall_5_0()); 
	    }
		lv_categoryfilter_6_0=ruleCategoryFilters		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
	        }
       		set(
       			$current, 
       			"categoryfilter",
        		lv_categoryfilter_6_0, 
        		"CategoryFilters");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
	}

)
;





// Entry rule entryRuleRequirementCategories
entryRuleRequirementCategories returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getRequirementCategoriesRule()); }
	 iv_ruleRequirementCategories=ruleRequirementCategories 
	 { $current=$iv_ruleRequirementCategories.current; } 
	 EOF 
;

// Rule RequirementCategories
ruleRequirementCategories returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getRequirementCategoriesAccess().getRequirementCategoriesAction_0(),
            $current);
    }
)
	otherlv_1=Requirement
    {
    	newLeafNode(otherlv_1, grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_1());
    }

	otherlv_2=Categories
    {
    	newLeafNode(otherlv_2, grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_2());
    }

	otherlv_3=LeftSquareBracket
    {
    	newLeafNode(otherlv_3, grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_4_0()); 
	    }
		lv_category_4_0=ruleRequirementCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRequirementCategoriesRule());
	        }
       		add(
       			$current, 
       			"category",
        		lv_category_4_0, 
        		"RequirementCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)+
	otherlv_5=RightSquareBracket
    {
    	newLeafNode(otherlv_5, grammarAccess.getRequirementCategoriesAccess().getRightSquareBracketKeyword_5());
    }
)
;





// Entry rule entryRuleMethodCategories
entryRuleMethodCategories returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getMethodCategoriesRule()); }
	 iv_ruleMethodCategories=ruleMethodCategories 
	 { $current=$iv_ruleMethodCategories.current; } 
	 EOF 
;

// Rule MethodCategories
ruleMethodCategories returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getMethodCategoriesAccess().getMethodCategoriesAction_0(),
            $current);
    }
)
	otherlv_1=Method
    {
    	newLeafNode(otherlv_1, grammarAccess.getMethodCategoriesAccess().getMethodKeyword_1());
    }

	otherlv_2=Categories
    {
    	newLeafNode(otherlv_2, grammarAccess.getMethodCategoriesAccess().getCategoriesKeyword_2());
    }

	otherlv_3=LeftSquareBracket
    {
    	newLeafNode(otherlv_3, grammarAccess.getMethodCategoriesAccess().getLeftSquareBracketKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMethodCategoriesAccess().getCategoryMethodCategoryParserRuleCall_4_0()); 
	    }
		lv_category_4_0=ruleMethodCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMethodCategoriesRule());
	        }
       		add(
       			$current, 
       			"category",
        		lv_category_4_0, 
        		"MethodCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)+
	otherlv_5=RightSquareBracket
    {
    	newLeafNode(otherlv_5, grammarAccess.getMethodCategoriesAccess().getRightSquareBracketKeyword_5());
    }
)
;





// Entry rule entryRuleSelectionCategories
entryRuleSelectionCategories returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getSelectionCategoriesRule()); }
	 iv_ruleSelectionCategories=ruleSelectionCategories 
	 { $current=$iv_ruleSelectionCategories.current; } 
	 EOF 
;

// Rule SelectionCategories
ruleSelectionCategories returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getSelectionCategoriesAccess().getSelectionCategoriesAction_0(),
            $current);
    }
)
	otherlv_1=Selection
    {
    	newLeafNode(otherlv_1, grammarAccess.getSelectionCategoriesAccess().getSelectionKeyword_1());
    }

	otherlv_2=Categories
    {
    	newLeafNode(otherlv_2, grammarAccess.getSelectionCategoriesAccess().getCategoriesKeyword_2());
    }

	otherlv_3=LeftSquareBracket
    {
    	newLeafNode(otherlv_3, grammarAccess.getSelectionCategoriesAccess().getLeftSquareBracketKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSelectionCategoriesAccess().getCategorySelectionCategoryParserRuleCall_4_0()); 
	    }
		lv_category_4_0=ruleSelectionCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSelectionCategoriesRule());
	        }
       		add(
       			$current, 
       			"category",
        		lv_category_4_0, 
        		"SelectionCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)+
	otherlv_5=RightSquareBracket
    {
    	newLeafNode(otherlv_5, grammarAccess.getSelectionCategoriesAccess().getRightSquareBracketKeyword_5());
    }
)
;





// Entry rule entryRuleQualityCategories
entryRuleQualityCategories returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getQualityCategoriesRule()); }
	 iv_ruleQualityCategories=ruleQualityCategories 
	 { $current=$iv_ruleQualityCategories.current; } 
	 EOF 
;

// Rule QualityCategories
ruleQualityCategories returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getQualityCategoriesAccess().getQualityCategoriesAction_0(),
            $current);
    }
)
	otherlv_1=Quality
    {
    	newLeafNode(otherlv_1, grammarAccess.getQualityCategoriesAccess().getQualityKeyword_1());
    }

	otherlv_2=Categories
    {
    	newLeafNode(otherlv_2, grammarAccess.getQualityCategoriesAccess().getCategoriesKeyword_2());
    }

	otherlv_3=LeftSquareBracket
    {
    	newLeafNode(otherlv_3, grammarAccess.getQualityCategoriesAccess().getLeftSquareBracketKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getQualityCategoriesAccess().getCategoryQualityCategoryParserRuleCall_4_0()); 
	    }
		lv_category_4_0=ruleQualityCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getQualityCategoriesRule());
	        }
       		add(
       			$current, 
       			"category",
        		lv_category_4_0, 
        		"QualityCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)+
	otherlv_5=RightSquareBracket
    {
    	newLeafNode(otherlv_5, grammarAccess.getQualityCategoriesAccess().getRightSquareBracketKeyword_5());
    }
)
;





// Entry rule entryRulePhaseCategories
entryRulePhaseCategories returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPhaseCategoriesRule()); }
	 iv_rulePhaseCategories=rulePhaseCategories 
	 { $current=$iv_rulePhaseCategories.current; } 
	 EOF 
;

// Rule PhaseCategories
rulePhaseCategories returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getPhaseCategoriesAccess().getQualityCategoriesAction_0(),
            $current);
    }
)
	otherlv_1=Phase
    {
    	newLeafNode(otherlv_1, grammarAccess.getPhaseCategoriesAccess().getPhaseKeyword_1());
    }

	otherlv_2=Categories
    {
    	newLeafNode(otherlv_2, grammarAccess.getPhaseCategoriesAccess().getCategoriesKeyword_2());
    }

	otherlv_3=LeftSquareBracket
    {
    	newLeafNode(otherlv_3, grammarAccess.getPhaseCategoriesAccess().getLeftSquareBracketKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPhaseCategoriesAccess().getCategoryPhaseCategoryParserRuleCall_4_0()); 
	    }
		lv_category_4_0=rulePhaseCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPhaseCategoriesRule());
	        }
       		add(
       			$current, 
       			"category",
        		lv_category_4_0, 
        		"PhaseCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)+
	otherlv_5=RightSquareBracket
    {
    	newLeafNode(otherlv_5, grammarAccess.getPhaseCategoriesAccess().getRightSquareBracketKeyword_5());
    }
)
;





// Entry rule entryRuleRequirementCategory
entryRuleRequirementCategory returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getRequirementCategoryRule()); }
	 iv_ruleRequirementCategory=ruleRequirementCategory 
	 { $current=$iv_ruleRequirementCategory.current; } 
	 EOF 
;

// Rule RequirementCategory
ruleRequirementCategory returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getRequirementCategoryAccess().getRequirementCategoryAction_0(),
            $current);
    }
)(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getRequirementCategoryRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
))
;





// Entry rule entryRuleMethodCategory
entryRuleMethodCategory returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getMethodCategoryRule()); }
	 iv_ruleMethodCategory=ruleMethodCategory 
	 { $current=$iv_ruleMethodCategory.current; } 
	 EOF 
;

// Rule MethodCategory
ruleMethodCategory returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getMethodCategoryAccess().getMethodCategoryAction_0(),
            $current);
    }
)(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getMethodCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMethodCategoryRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
))
;





// Entry rule entryRuleSelectionCategory
entryRuleSelectionCategory returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getSelectionCategoryRule()); }
	 iv_ruleSelectionCategory=ruleSelectionCategory 
	 { $current=$iv_ruleSelectionCategory.current; } 
	 EOF 
;

// Rule SelectionCategory
ruleSelectionCategory returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getSelectionCategoryAccess().getSelectionCategoryAction_0(),
            $current);
    }
)(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getSelectionCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSelectionCategoryRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
))
;





// Entry rule entryRuleQualityCategory
entryRuleQualityCategory returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getQualityCategoryRule()); }
	 iv_ruleQualityCategory=ruleQualityCategory 
	 { $current=$iv_ruleQualityCategory.current; } 
	 EOF 
;

// Rule QualityCategory
ruleQualityCategory returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getQualityCategoryAccess().getQualityCategoryAction_0(),
            $current);
    }
)(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getQualityCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getQualityCategoryRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
))
;





// Entry rule entryRulePhaseCategory
entryRulePhaseCategory returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPhaseCategoryRule()); }
	 iv_rulePhaseCategory=rulePhaseCategory 
	 { $current=$iv_rulePhaseCategory.current; } 
	 EOF 
;

// Rule PhaseCategory
rulePhaseCategory returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getPhaseCategoryAccess().getPhaseCategoryAction_0(),
            $current);
    }
)(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getPhaseCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPhaseCategoryRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
))
;





// Entry rule entryRuleCategoryFilters
entryRuleCategoryFilters returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getCategoryFiltersRule()); }
	 iv_ruleCategoryFilters=ruleCategoryFilters 
	 { $current=$iv_ruleCategoryFilters.current; } 
	 EOF 
;

// Rule CategoryFilters
ruleCategoryFilters returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Category
    {
    	newLeafNode(otherlv_0, grammarAccess.getCategoryFiltersAccess().getCategoryKeyword_0());
    }

	otherlv_1=Filters
    {
    	newLeafNode(otherlv_1, grammarAccess.getCategoryFiltersAccess().getFiltersKeyword_1());
    }

	otherlv_2=LeftSquareBracket
    {
    	newLeafNode(otherlv_2, grammarAccess.getCategoryFiltersAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCategoryFiltersAccess().getFiltersCategorySetParserRuleCall_3_0()); 
	    }
		lv_filters_3_0=ruleCategorySet		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCategoryFiltersRule());
	        }
       		add(
       			$current, 
       			"filters",
        		lv_filters_3_0, 
        		"CategorySet");
	        afterParserOrEnumRuleCall();
	    }

)
)+
	otherlv_4=RightSquareBracket
    {
    	newLeafNode(otherlv_4, grammarAccess.getCategoryFiltersAccess().getRightSquareBracketKeyword_4());
    }
)
;





// Entry rule entryRuleCategorySet
entryRuleCategorySet returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getCategorySetRule()); }
	 iv_ruleCategorySet=ruleCategorySet 
	 { $current=$iv_ruleCategorySet.current; } 
	 EOF 
;

// Rule CategorySet
ruleCategorySet returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getCategorySetAccess().getCategorySetAction_0(),
            $current);
    }
)(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getCategorySetAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCategorySetRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)
	otherlv_2=LeftCurlyBracket
    {
    	newLeafNode(otherlv_2, grammarAccess.getCategorySetAccess().getLeftCurlyBracketKeyword_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getCategorySetRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getCategorySetAccess().getElementsCategoryCrossReference_3_0()); 
	    }
		ruleCatRef		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)*
	otherlv_4=RightCurlyBracket
    {
    	newLeafNode(otherlv_4, grammarAccess.getCategorySetAccess().getRightCurlyBracketKeyword_4());
    }
)
;





// Entry rule entryRuleCatRef
entryRuleCatRef returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getCatRefRule()); } 
	 iv_ruleCatRef=ruleCatRef 
	 { $current=$iv_ruleCatRef.current.getText(); }  
	 EOF 
;

// Rule CatRef
ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getCatRefAccess().getIDTerminalRuleCall()); 
    }

    ;






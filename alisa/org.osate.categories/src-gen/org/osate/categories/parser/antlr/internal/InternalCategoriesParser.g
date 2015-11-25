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
	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getUserCategoriesUserCategoriesParserRuleCall_0_0()); 
	    }
		lv_userCategories_1_0=ruleUserCategories		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
	        }
       		set(
       			$current, 
       			"userCategories",
        		lv_userCategories_1_0, 
        		"UserCategories");
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
	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getPhaseCategoriesPhaseCategoriesParserRuleCall_1_0()); 
	    }
		lv_phaseCategories_2_0=rulePhaseCategories		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
	        }
       		set(
       			$current, 
       			"phaseCategories",
        		lv_phaseCategories_2_0, 
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
				{getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getQualityCategoriesQualityCategoriesParserRuleCall_2_0()); 
	    }
		lv_qualityCategories_3_0=ruleQualityCategories		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
	        }
       		set(
       			$current, 
       			"qualityCategories",
        		lv_qualityCategories_3_0, 
        		"QualityCategories");
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





// Entry rule entryRuleUserCategories
entryRuleUserCategories returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getUserCategoriesRule()); }
	 iv_ruleUserCategories=ruleUserCategories 
	 { $current=$iv_ruleUserCategories.current; } 
	 EOF 
;

// Rule UserCategories
ruleUserCategories returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getUserCategoriesAccess().getUserCategoriesAction_0(),
            $current);
    }
)
	otherlv_1=Category
    {
    	newLeafNode(otherlv_1, grammarAccess.getUserCategoriesAccess().getCategoryKeyword_1());
    }

	otherlv_2=LeftSquareBracket
    {
    	newLeafNode(otherlv_2, grammarAccess.getUserCategoriesAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUserCategoriesAccess().getCategoryUserCategoryParserRuleCall_3_0()); 
	    }
		lv_category_3_0=ruleUserCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUserCategoriesRule());
	        }
       		add(
       			$current, 
       			"category",
        		lv_category_3_0, 
        		"UserCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)+
	otherlv_4=RightSquareBracket
    {
    	newLeafNode(otherlv_4, grammarAccess.getUserCategoriesAccess().getRightSquareBracketKeyword_4());
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

	otherlv_2=LeftSquareBracket
    {
    	newLeafNode(otherlv_2, grammarAccess.getQualityCategoriesAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getQualityCategoriesAccess().getCategoryQualityCategoryParserRuleCall_3_0()); 
	    }
		lv_category_3_0=ruleQualityCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getQualityCategoriesRule());
	        }
       		add(
       			$current, 
       			"category",
        		lv_category_3_0, 
        		"QualityCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)+
	otherlv_4=RightSquareBracket
    {
    	newLeafNode(otherlv_4, grammarAccess.getQualityCategoriesAccess().getRightSquareBracketKeyword_4());
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
            grammarAccess.getPhaseCategoriesAccess().getPhaseCategoriesAction_0(),
            $current);
    }
)
	otherlv_1=Phase
    {
    	newLeafNode(otherlv_1, grammarAccess.getPhaseCategoriesAccess().getPhaseKeyword_1());
    }

	otherlv_2=LeftSquareBracket
    {
    	newLeafNode(otherlv_2, grammarAccess.getPhaseCategoriesAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPhaseCategoriesAccess().getCategoryPhaseCategoryParserRuleCall_3_0()); 
	    }
		lv_category_3_0=rulePhaseCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPhaseCategoriesRule());
	        }
       		add(
       			$current, 
       			"category",
        		lv_category_3_0, 
        		"PhaseCategory");
	        afterParserOrEnumRuleCall();
	    }

)
)+
	otherlv_4=RightSquareBracket
    {
    	newLeafNode(otherlv_4, grammarAccess.getPhaseCategoriesAccess().getRightSquareBracketKeyword_4());
    }
)
;





// Entry rule entryRuleUserCategory
entryRuleUserCategory returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getUserCategoryRule()); }
	 iv_ruleUserCategory=ruleUserCategory 
	 { $current=$iv_ruleUserCategory.current; } 
	 EOF 
;

// Rule UserCategory
ruleUserCategory returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getUserCategoryAccess().getUserCategoryAction_0(),
            $current);
    }
)(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getUserCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getUserCategoryRule());
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










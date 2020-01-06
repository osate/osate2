/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
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
((
(
		{ 
	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesCategoriesParserRuleCall_0_0()); 
	    }
		lv_categories_0_0=ruleCategories		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
	        }
       		add(
       			$current, 
       			"categories",
        		lv_categories_0_0, 
        		"org.osate.categories.Categories.Categories");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getCategoryFiltersCategoryFilterParserRuleCall_1_0()); 
	    }
		lv_categoryFilters_1_0=ruleCategoryFilter		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
	        }
       		add(
       			$current, 
       			"categoryFilters",
        		lv_categoryFilters_1_0, 
        		"org.osate.categories.Categories.CategoryFilter");
	        afterParserOrEnumRuleCall();
	    }

)
)*)
;





// Entry rule entryRuleCategories
entryRuleCategories returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getCategoriesRule()); }
	 iv_ruleCategories=ruleCategories 
	 { $current=$iv_ruleCategories.current; } 
	 EOF 
;

// Rule Categories
ruleCategories returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getCategoriesAccess().getNameIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCategoriesRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
)
	otherlv_1=LeftSquareBracket
    {
    	newLeafNode(otherlv_1, grammarAccess.getCategoriesAccess().getLeftSquareBracketKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCategoriesAccess().getCategoryCategoryParserRuleCall_2_0()); 
	    }
		lv_category_2_0=ruleCategory		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCategoriesRule());
	        }
       		add(
       			$current, 
       			"category",
        		lv_category_2_0, 
        		"org.osate.categories.Categories.Category");
	        afterParserOrEnumRuleCall();
	    }

)
)+
	otherlv_3=RightSquareBracket
    {
    	newLeafNode(otherlv_3, grammarAccess.getCategoriesAccess().getRightSquareBracketKeyword_3());
    }
)
;





// Entry rule entryRuleCategory
entryRuleCategory returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getCategoryRule()); }
	 iv_ruleCategory=ruleCategory 
	 { $current=$iv_ruleCategory.current; } 
	 EOF 
;

// Rule Category
ruleCategory returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getCategoryAccess().getNameIDTerminalRuleCall_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCategoryRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
)
;





// Entry rule entryRuleCategoryFilter
entryRuleCategoryFilter returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getCategoryFilterRule()); }
	 iv_ruleCategoryFilter=ruleCategoryFilter 
	 { $current=$iv_ruleCategoryFilter.current; } 
	 EOF 
;

// Rule CategoryFilter
ruleCategoryFilter returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=Filter
    {
    	newLeafNode(otherlv_0, grammarAccess.getCategoryFilterAccess().getFilterKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getCategoryFilterAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCategoryFilterRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
)
	otherlv_2=LeftSquareBracket
    {
    	newLeafNode(otherlv_2, grammarAccess.getCategoryFilterAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getCategoryFilterRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getCategoryFilterAccess().getCategoryCategoryCrossReference_3_0()); 
	    }
		ruleCatRef
		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		lv_anyCategory_4_0=
	Any
    {
        newLeafNode(lv_anyCategory_4_0, grammarAccess.getCategoryFilterAccess().getAnyCategoryAnyKeyword_4_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCategoryFilterRule());
	        }
       		setWithLastConsumed($current, "anyCategory", true, "any");
	    }

)
)?
	otherlv_5=RightSquareBracket
    {
    	newLeafNode(otherlv_5, grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_5());
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
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getCatRefAccess().getIDTerminalRuleCall_0()); 
    }

	kw=FullStop 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getCatRefAccess().getFullStopKeyword_1()); 
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getCatRefAccess().getIDTerminalRuleCall_2()); 
    }
)
    ;






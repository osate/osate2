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
	superClass=AbstractInternalContentAssistParser;
	
}

@header {
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

}

@members {
 
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
}




// Entry rule entryRuleCategoriesDefinitions
entryRuleCategoriesDefinitions 
:
{ before(grammarAccess.getCategoriesDefinitionsRule()); }
	 ruleCategoriesDefinitions
{ after(grammarAccess.getCategoriesDefinitionsRule()); } 
	 EOF 
;

// Rule CategoriesDefinitions
ruleCategoriesDefinitions 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup()); }
(rule__CategoriesDefinitions__UnorderedGroup)
{ after(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUserCategories
entryRuleUserCategories 
:
{ before(grammarAccess.getUserCategoriesRule()); }
	 ruleUserCategories
{ after(grammarAccess.getUserCategoriesRule()); } 
	 EOF 
;

// Rule UserCategories
ruleUserCategories 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getUserCategoriesAccess().getGroup()); }
(rule__UserCategories__Group__0)
{ after(grammarAccess.getUserCategoriesAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleQualityCategories
entryRuleQualityCategories 
:
{ before(grammarAccess.getQualityCategoriesRule()); }
	 ruleQualityCategories
{ after(grammarAccess.getQualityCategoriesRule()); } 
	 EOF 
;

// Rule QualityCategories
ruleQualityCategories 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getQualityCategoriesAccess().getGroup()); }
(rule__QualityCategories__Group__0)
{ after(grammarAccess.getQualityCategoriesAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePhaseCategories
entryRulePhaseCategories 
:
{ before(grammarAccess.getPhaseCategoriesRule()); }
	 rulePhaseCategories
{ after(grammarAccess.getPhaseCategoriesRule()); } 
	 EOF 
;

// Rule PhaseCategories
rulePhaseCategories 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getPhaseCategoriesAccess().getGroup()); }
(rule__PhaseCategories__Group__0)
{ after(grammarAccess.getPhaseCategoriesAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUserCategory
entryRuleUserCategory 
:
{ before(grammarAccess.getUserCategoryRule()); }
	 ruleUserCategory
{ after(grammarAccess.getUserCategoryRule()); } 
	 EOF 
;

// Rule UserCategory
ruleUserCategory 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getUserCategoryAccess().getGroup()); }
(rule__UserCategory__Group__0)
{ after(grammarAccess.getUserCategoryAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleQualityCategory
entryRuleQualityCategory 
:
{ before(grammarAccess.getQualityCategoryRule()); }
	 ruleQualityCategory
{ after(grammarAccess.getQualityCategoryRule()); } 
	 EOF 
;

// Rule QualityCategory
ruleQualityCategory 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getQualityCategoryAccess().getGroup()); }
(rule__QualityCategory__Group__0)
{ after(grammarAccess.getQualityCategoryAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePhaseCategory
entryRulePhaseCategory 
:
{ before(grammarAccess.getPhaseCategoryRule()); }
	 rulePhaseCategory
{ after(grammarAccess.getPhaseCategoryRule()); } 
	 EOF 
;

// Rule PhaseCategory
rulePhaseCategory 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getPhaseCategoryAccess().getGroup()); }
(rule__PhaseCategory__Group__0)
{ after(grammarAccess.getPhaseCategoryAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__UserCategories__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UserCategories__Group__0__Impl
	rule__UserCategories__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UserCategories__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserCategoriesAccess().getUserCategoriesAction_0()); }
(

)
{ after(grammarAccess.getUserCategoriesAccess().getUserCategoriesAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UserCategories__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UserCategories__Group__1__Impl
	rule__UserCategories__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__UserCategories__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserCategoriesAccess().getCategoryKeyword_1()); }

	Category 

{ after(grammarAccess.getUserCategoriesAccess().getCategoryKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UserCategories__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UserCategories__Group__2__Impl
	rule__UserCategories__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__UserCategories__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserCategoriesAccess().getLeftSquareBracketKeyword_2()); }

	LeftSquareBracket 

{ after(grammarAccess.getUserCategoriesAccess().getLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UserCategories__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UserCategories__Group__3__Impl
	rule__UserCategories__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__UserCategories__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getUserCategoriesAccess().getCategoryAssignment_3()); }
(rule__UserCategories__CategoryAssignment_3)
{ after(grammarAccess.getUserCategoriesAccess().getCategoryAssignment_3()); }
)
(
{ before(grammarAccess.getUserCategoriesAccess().getCategoryAssignment_3()); }
(rule__UserCategories__CategoryAssignment_3)*
{ after(grammarAccess.getUserCategoriesAccess().getCategoryAssignment_3()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UserCategories__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UserCategories__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UserCategories__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserCategoriesAccess().getRightSquareBracketKeyword_4()); }

	RightSquareBracket 

{ after(grammarAccess.getUserCategoriesAccess().getRightSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__QualityCategories__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityCategories__Group__0__Impl
	rule__QualityCategories__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityCategories__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityCategoriesAccess().getQualityCategoriesAction_0()); }
(

)
{ after(grammarAccess.getQualityCategoriesAccess().getQualityCategoriesAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualityCategories__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityCategories__Group__1__Impl
	rule__QualityCategories__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityCategories__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityCategoriesAccess().getQualityKeyword_1()); }

	Quality 

{ after(grammarAccess.getQualityCategoriesAccess().getQualityKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualityCategories__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityCategories__Group__2__Impl
	rule__QualityCategories__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityCategories__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityCategoriesAccess().getLeftSquareBracketKeyword_2()); }

	LeftSquareBracket 

{ after(grammarAccess.getQualityCategoriesAccess().getLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualityCategories__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityCategories__Group__3__Impl
	rule__QualityCategories__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityCategories__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_3()); }
(rule__QualityCategories__CategoryAssignment_3)
{ after(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_3()); }
)
(
{ before(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_3()); }
(rule__QualityCategories__CategoryAssignment_3)*
{ after(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_3()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualityCategories__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityCategories__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityCategories__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityCategoriesAccess().getRightSquareBracketKeyword_4()); }

	RightSquareBracket 

{ after(grammarAccess.getQualityCategoriesAccess().getRightSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__PhaseCategories__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PhaseCategories__Group__0__Impl
	rule__PhaseCategories__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PhaseCategories__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPhaseCategoriesAccess().getPhaseCategoriesAction_0()); }
(

)
{ after(grammarAccess.getPhaseCategoriesAccess().getPhaseCategoriesAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PhaseCategories__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PhaseCategories__Group__1__Impl
	rule__PhaseCategories__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PhaseCategories__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPhaseCategoriesAccess().getPhaseKeyword_1()); }

	Phase 

{ after(grammarAccess.getPhaseCategoriesAccess().getPhaseKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PhaseCategories__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PhaseCategories__Group__2__Impl
	rule__PhaseCategories__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__PhaseCategories__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPhaseCategoriesAccess().getLeftSquareBracketKeyword_2()); }

	LeftSquareBracket 

{ after(grammarAccess.getPhaseCategoriesAccess().getLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PhaseCategories__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PhaseCategories__Group__3__Impl
	rule__PhaseCategories__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__PhaseCategories__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_3()); }
(rule__PhaseCategories__CategoryAssignment_3)
{ after(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_3()); }
)
(
{ before(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_3()); }
(rule__PhaseCategories__CategoryAssignment_3)*
{ after(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_3()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PhaseCategories__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PhaseCategories__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PhaseCategories__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPhaseCategoriesAccess().getRightSquareBracketKeyword_4()); }

	RightSquareBracket 

{ after(grammarAccess.getPhaseCategoriesAccess().getRightSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__UserCategory__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UserCategory__Group__0__Impl
	rule__UserCategory__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UserCategory__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserCategoryAccess().getUserCategoryAction_0()); }
(

)
{ after(grammarAccess.getUserCategoryAccess().getUserCategoryAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UserCategory__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UserCategory__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UserCategory__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserCategoryAccess().getNameAssignment_1()); }
(rule__UserCategory__NameAssignment_1)
{ after(grammarAccess.getUserCategoryAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QualityCategory__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityCategory__Group__0__Impl
	rule__QualityCategory__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityCategory__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityCategoryAccess().getQualityCategoryAction_0()); }
(

)
{ after(grammarAccess.getQualityCategoryAccess().getQualityCategoryAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualityCategory__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityCategory__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityCategory__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityCategoryAccess().getNameAssignment_1()); }
(rule__QualityCategory__NameAssignment_1)
{ after(grammarAccess.getQualityCategoryAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PhaseCategory__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PhaseCategory__Group__0__Impl
	rule__PhaseCategory__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PhaseCategory__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPhaseCategoryAccess().getPhaseCategoryAction_0()); }
(

)
{ after(grammarAccess.getPhaseCategoryAccess().getPhaseCategoryAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PhaseCategory__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PhaseCategory__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PhaseCategory__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPhaseCategoryAccess().getNameAssignment_1()); }
(rule__PhaseCategory__NameAssignment_1)
{ after(grammarAccess.getPhaseCategoryAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__CategoriesDefinitions__UnorderedGroup
    @init {
    	int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
    }
:
	rule__CategoriesDefinitions__UnorderedGroup__0
	?
	
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
	restoreStackSize(stackSize);
}


rule__CategoriesDefinitions__UnorderedGroup__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
    }
:
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getCategoriesDefinitionsAccess().getUserCategoriesAssignment_0()); }
						(rule__CategoriesDefinitions__UserCategoriesAssignment_0)
						{ after(grammarAccess.getCategoriesDefinitionsAccess().getUserCategoriesAssignment_0()); }
					)
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
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getCategoriesDefinitionsAccess().getPhaseCategoriesAssignment_1()); }
						(rule__CategoriesDefinitions__PhaseCategoriesAssignment_1)
						{ after(grammarAccess.getCategoriesDefinitionsAccess().getPhaseCategoriesAssignment_1()); }
					)
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
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getCategoriesDefinitionsAccess().getQualityCategoriesAssignment_2()); }
						(rule__CategoriesDefinitions__QualityCategoriesAssignment_2)
						{ after(grammarAccess.getCategoriesDefinitionsAccess().getQualityCategoriesAssignment_2()); }
					)
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
	 				}
 				)
			)  

		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
	restoreStackSize(stackSize);
}


rule__CategoriesDefinitions__UnorderedGroup__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoriesDefinitions__UnorderedGroup__Impl
	rule__CategoriesDefinitions__UnorderedGroup__1?
;
finally {
	restoreStackSize(stackSize);
}


rule__CategoriesDefinitions__UnorderedGroup__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoriesDefinitions__UnorderedGroup__Impl
	rule__CategoriesDefinitions__UnorderedGroup__2?
;
finally {
	restoreStackSize(stackSize);
}


rule__CategoriesDefinitions__UnorderedGroup__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoriesDefinitions__UnorderedGroup__Impl
;
finally {
	restoreStackSize(stackSize);
}









rule__CategoriesDefinitions__UserCategoriesAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getUserCategoriesUserCategoriesParserRuleCall_0_0()); }
	ruleUserCategories{ after(grammarAccess.getCategoriesDefinitionsAccess().getUserCategoriesUserCategoriesParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategoriesDefinitions__PhaseCategoriesAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getPhaseCategoriesPhaseCategoriesParserRuleCall_1_0()); }
	rulePhaseCategories{ after(grammarAccess.getCategoriesDefinitionsAccess().getPhaseCategoriesPhaseCategoriesParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategoriesDefinitions__QualityCategoriesAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getQualityCategoriesQualityCategoriesParserRuleCall_2_0()); }
	ruleQualityCategories{ after(grammarAccess.getCategoriesDefinitionsAccess().getQualityCategoriesQualityCategoriesParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__UserCategories__CategoryAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserCategoriesAccess().getCategoryUserCategoryParserRuleCall_3_0()); }
	ruleUserCategory{ after(grammarAccess.getUserCategoriesAccess().getCategoryUserCategoryParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualityCategories__CategoryAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityCategoriesAccess().getCategoryQualityCategoryParserRuleCall_3_0()); }
	ruleQualityCategory{ after(grammarAccess.getQualityCategoriesAccess().getCategoryQualityCategoryParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PhaseCategories__CategoryAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPhaseCategoriesAccess().getCategoryPhaseCategoryParserRuleCall_3_0()); }
	rulePhaseCategory{ after(grammarAccess.getPhaseCategoriesAccess().getCategoryPhaseCategoryParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__UserCategory__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserCategoryAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getUserCategoryAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualityCategory__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityCategoryAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getQualityCategoryAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PhaseCategory__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPhaseCategoryAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getPhaseCategoryAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}










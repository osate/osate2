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
		tokenNameToValue.put("LeftCurlyBracket", "'{'");
		tokenNameToValue.put("RightCurlyBracket", "'}'");
		tokenNameToValue.put("Phase", "'phase'");
		tokenNameToValue.put("Method", "'method'");
		tokenNameToValue.put("Filters", "'filters'");
		tokenNameToValue.put("Quality", "'quality'");
		tokenNameToValue.put("Category", "'category'");
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



// Entry rule entryRuleRequirementCategories
entryRuleRequirementCategories 
:
{ before(grammarAccess.getRequirementCategoriesRule()); }
	 ruleRequirementCategories
{ after(grammarAccess.getRequirementCategoriesRule()); } 
	 EOF 
;

// Rule RequirementCategories
ruleRequirementCategories 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getRequirementCategoriesAccess().getGroup()); }
(rule__RequirementCategories__Group__0)
{ after(grammarAccess.getRequirementCategoriesAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMethodCategories
entryRuleMethodCategories 
:
{ before(grammarAccess.getMethodCategoriesRule()); }
	 ruleMethodCategories
{ after(grammarAccess.getMethodCategoriesRule()); } 
	 EOF 
;

// Rule MethodCategories
ruleMethodCategories 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getMethodCategoriesAccess().getGroup()); }
(rule__MethodCategories__Group__0)
{ after(grammarAccess.getMethodCategoriesAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSelectionCategories
entryRuleSelectionCategories 
:
{ before(grammarAccess.getSelectionCategoriesRule()); }
	 ruleSelectionCategories
{ after(grammarAccess.getSelectionCategoriesRule()); } 
	 EOF 
;

// Rule SelectionCategories
ruleSelectionCategories 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getSelectionCategoriesAccess().getGroup()); }
(rule__SelectionCategories__Group__0)
{ after(grammarAccess.getSelectionCategoriesAccess().getGroup()); }
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



// Entry rule entryRuleRequirementCategory
entryRuleRequirementCategory 
:
{ before(grammarAccess.getRequirementCategoryRule()); }
	 ruleRequirementCategory
{ after(grammarAccess.getRequirementCategoryRule()); } 
	 EOF 
;

// Rule RequirementCategory
ruleRequirementCategory 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getRequirementCategoryAccess().getGroup()); }
(rule__RequirementCategory__Group__0)
{ after(grammarAccess.getRequirementCategoryAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMethodCategory
entryRuleMethodCategory 
:
{ before(grammarAccess.getMethodCategoryRule()); }
	 ruleMethodCategory
{ after(grammarAccess.getMethodCategoryRule()); } 
	 EOF 
;

// Rule MethodCategory
ruleMethodCategory 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getMethodCategoryAccess().getGroup()); }
(rule__MethodCategory__Group__0)
{ after(grammarAccess.getMethodCategoryAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSelectionCategory
entryRuleSelectionCategory 
:
{ before(grammarAccess.getSelectionCategoryRule()); }
	 ruleSelectionCategory
{ after(grammarAccess.getSelectionCategoryRule()); } 
	 EOF 
;

// Rule SelectionCategory
ruleSelectionCategory 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getSelectionCategoryAccess().getGroup()); }
(rule__SelectionCategory__Group__0)
{ after(grammarAccess.getSelectionCategoryAccess().getGroup()); }
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



// Entry rule entryRuleCategoryFilters
entryRuleCategoryFilters 
:
{ before(grammarAccess.getCategoryFiltersRule()); }
	 ruleCategoryFilters
{ after(grammarAccess.getCategoryFiltersRule()); } 
	 EOF 
;

// Rule CategoryFilters
ruleCategoryFilters 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getCategoryFiltersAccess().getGroup()); }
(rule__CategoryFilters__Group__0)
{ after(grammarAccess.getCategoryFiltersAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCategorySet
entryRuleCategorySet 
:
{ before(grammarAccess.getCategorySetRule()); }
	 ruleCategorySet
{ after(grammarAccess.getCategorySetRule()); } 
	 EOF 
;

// Rule CategorySet
ruleCategorySet 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getCategorySetAccess().getGroup()); }
(rule__CategorySet__Group__0)
{ after(grammarAccess.getCategorySetAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCatRef
entryRuleCatRef 
:
{ before(grammarAccess.getCatRefRule()); }
	 ruleCatRef
{ after(grammarAccess.getCatRefRule()); } 
	 EOF 
;

// Rule CatRef
ruleCatRef 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getCatRefAccess().getIDTerminalRuleCall()); }
	RULE_ID
{ after(grammarAccess.getCatRefAccess().getIDTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__RequirementCategories__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementCategories__Group__0__Impl
	rule__RequirementCategories__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementCategories__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementCategoriesAccess().getRequirementCategoriesAction_0()); }
(

)
{ after(grammarAccess.getRequirementCategoriesAccess().getRequirementCategoriesAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RequirementCategories__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementCategories__Group__1__Impl
	rule__RequirementCategories__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementCategories__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_1()); }

	Requirement 

{ after(grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RequirementCategories__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementCategories__Group__2__Impl
	rule__RequirementCategories__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementCategories__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_2()); }

	Categories 

{ after(grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RequirementCategories__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementCategories__Group__3__Impl
	rule__RequirementCategories__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementCategories__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_3()); }

	LeftSquareBracket 

{ after(grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RequirementCategories__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementCategories__Group__4__Impl
	rule__RequirementCategories__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementCategories__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); }
(rule__RequirementCategories__CategoryAssignment_4)
{ after(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); }
)
(
{ before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); }
(rule__RequirementCategories__CategoryAssignment_4)*
{ after(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RequirementCategories__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementCategories__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementCategories__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementCategoriesAccess().getRightSquareBracketKeyword_5()); }

	RightSquareBracket 

{ after(grammarAccess.getRequirementCategoriesAccess().getRightSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__MethodCategories__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodCategories__Group__0__Impl
	rule__MethodCategories__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodCategories__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodCategoriesAccess().getMethodCategoriesAction_0()); }
(

)
{ after(grammarAccess.getMethodCategoriesAccess().getMethodCategoriesAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MethodCategories__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodCategories__Group__1__Impl
	rule__MethodCategories__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodCategories__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodCategoriesAccess().getMethodKeyword_1()); }

	Method 

{ after(grammarAccess.getMethodCategoriesAccess().getMethodKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MethodCategories__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodCategories__Group__2__Impl
	rule__MethodCategories__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodCategories__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodCategoriesAccess().getCategoriesKeyword_2()); }

	Categories 

{ after(grammarAccess.getMethodCategoriesAccess().getCategoriesKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MethodCategories__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodCategories__Group__3__Impl
	rule__MethodCategories__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodCategories__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodCategoriesAccess().getLeftSquareBracketKeyword_3()); }

	LeftSquareBracket 

{ after(grammarAccess.getMethodCategoriesAccess().getLeftSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MethodCategories__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodCategories__Group__4__Impl
	rule__MethodCategories__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodCategories__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); }
(rule__MethodCategories__CategoryAssignment_4)
{ after(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); }
)
(
{ before(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); }
(rule__MethodCategories__CategoryAssignment_4)*
{ after(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MethodCategories__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodCategories__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodCategories__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodCategoriesAccess().getRightSquareBracketKeyword_5()); }

	RightSquareBracket 

{ after(grammarAccess.getMethodCategoriesAccess().getRightSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__SelectionCategories__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SelectionCategories__Group__0__Impl
	rule__SelectionCategories__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SelectionCategories__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSelectionCategoriesAccess().getSelectionCategoriesAction_0()); }
(

)
{ after(grammarAccess.getSelectionCategoriesAccess().getSelectionCategoriesAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SelectionCategories__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SelectionCategories__Group__1__Impl
	rule__SelectionCategories__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SelectionCategories__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSelectionCategoriesAccess().getSelectionKeyword_1()); }

	Selection 

{ after(grammarAccess.getSelectionCategoriesAccess().getSelectionKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SelectionCategories__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SelectionCategories__Group__2__Impl
	rule__SelectionCategories__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SelectionCategories__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSelectionCategoriesAccess().getCategoriesKeyword_2()); }

	Categories 

{ after(grammarAccess.getSelectionCategoriesAccess().getCategoriesKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SelectionCategories__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SelectionCategories__Group__3__Impl
	rule__SelectionCategories__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__SelectionCategories__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSelectionCategoriesAccess().getLeftSquareBracketKeyword_3()); }

	LeftSquareBracket 

{ after(grammarAccess.getSelectionCategoriesAccess().getLeftSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SelectionCategories__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SelectionCategories__Group__4__Impl
	rule__SelectionCategories__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__SelectionCategories__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); }
(rule__SelectionCategories__CategoryAssignment_4)
{ after(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); }
)
(
{ before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); }
(rule__SelectionCategories__CategoryAssignment_4)*
{ after(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SelectionCategories__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SelectionCategories__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SelectionCategories__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSelectionCategoriesAccess().getRightSquareBracketKeyword_5()); }

	RightSquareBracket 

{ after(grammarAccess.getSelectionCategoriesAccess().getRightSquareBracketKeyword_5()); }
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
{ before(grammarAccess.getQualityCategoriesAccess().getCategoriesKeyword_2()); }

	Categories 

{ after(grammarAccess.getQualityCategoriesAccess().getCategoriesKeyword_2()); }
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
{ before(grammarAccess.getQualityCategoriesAccess().getLeftSquareBracketKeyword_3()); }

	LeftSquareBracket 

{ after(grammarAccess.getQualityCategoriesAccess().getLeftSquareBracketKeyword_3()); }
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
	rule__QualityCategories__Group__5
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
(
{ before(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); }
(rule__QualityCategories__CategoryAssignment_4)
{ after(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); }
)
(
{ before(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); }
(rule__QualityCategories__CategoryAssignment_4)*
{ after(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualityCategories__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityCategories__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityCategories__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityCategoriesAccess().getRightSquareBracketKeyword_5()); }

	RightSquareBracket 

{ after(grammarAccess.getQualityCategoriesAccess().getRightSquareBracketKeyword_5()); }
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
{ before(grammarAccess.getPhaseCategoriesAccess().getQualityCategoriesAction_0()); }
(

)
{ after(grammarAccess.getPhaseCategoriesAccess().getQualityCategoriesAction_0()); }
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
{ before(grammarAccess.getPhaseCategoriesAccess().getCategoriesKeyword_2()); }

	Categories 

{ after(grammarAccess.getPhaseCategoriesAccess().getCategoriesKeyword_2()); }
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
{ before(grammarAccess.getPhaseCategoriesAccess().getLeftSquareBracketKeyword_3()); }

	LeftSquareBracket 

{ after(grammarAccess.getPhaseCategoriesAccess().getLeftSquareBracketKeyword_3()); }
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
	rule__PhaseCategories__Group__5
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
(
{ before(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_4()); }
(rule__PhaseCategories__CategoryAssignment_4)
{ after(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_4()); }
)
(
{ before(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_4()); }
(rule__PhaseCategories__CategoryAssignment_4)*
{ after(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_4()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PhaseCategories__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PhaseCategories__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PhaseCategories__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPhaseCategoriesAccess().getRightSquareBracketKeyword_5()); }

	RightSquareBracket 

{ after(grammarAccess.getPhaseCategoriesAccess().getRightSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__RequirementCategory__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementCategory__Group__0__Impl
	rule__RequirementCategory__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementCategory__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementCategoryAccess().getRequirementCategoryAction_0()); }
(

)
{ after(grammarAccess.getRequirementCategoryAccess().getRequirementCategoryAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RequirementCategory__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementCategory__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementCategory__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementCategoryAccess().getNameAssignment_1()); }
(rule__RequirementCategory__NameAssignment_1)
{ after(grammarAccess.getRequirementCategoryAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MethodCategory__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodCategory__Group__0__Impl
	rule__MethodCategory__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodCategory__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodCategoryAccess().getMethodCategoryAction_0()); }
(

)
{ after(grammarAccess.getMethodCategoryAccess().getMethodCategoryAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MethodCategory__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodCategory__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodCategory__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodCategoryAccess().getNameAssignment_1()); }
(rule__MethodCategory__NameAssignment_1)
{ after(grammarAccess.getMethodCategoryAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SelectionCategory__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SelectionCategory__Group__0__Impl
	rule__SelectionCategory__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SelectionCategory__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSelectionCategoryAccess().getSelectionCategoryAction_0()); }
(

)
{ after(grammarAccess.getSelectionCategoryAccess().getSelectionCategoryAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SelectionCategory__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SelectionCategory__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SelectionCategory__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSelectionCategoryAccess().getNameAssignment_1()); }
(rule__SelectionCategory__NameAssignment_1)
{ after(grammarAccess.getSelectionCategoryAccess().getNameAssignment_1()); }
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






rule__CategoryFilters__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoryFilters__Group__0__Impl
	rule__CategoryFilters__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CategoryFilters__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoryFiltersAccess().getCategoryKeyword_0()); }

	Category 

{ after(grammarAccess.getCategoryFiltersAccess().getCategoryKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CategoryFilters__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoryFilters__Group__1__Impl
	rule__CategoryFilters__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CategoryFilters__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoryFiltersAccess().getFiltersKeyword_1()); }

	Filters 

{ after(grammarAccess.getCategoryFiltersAccess().getFiltersKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CategoryFilters__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoryFilters__Group__2__Impl
	rule__CategoryFilters__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CategoryFilters__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoryFiltersAccess().getLeftSquareBracketKeyword_2()); }

	LeftSquareBracket 

{ after(grammarAccess.getCategoryFiltersAccess().getLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CategoryFilters__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoryFilters__Group__3__Impl
	rule__CategoryFilters__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__CategoryFilters__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); }
(rule__CategoryFilters__FiltersAssignment_3)
{ after(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); }
)
(
{ before(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); }
(rule__CategoryFilters__FiltersAssignment_3)*
{ after(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CategoryFilters__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoryFilters__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CategoryFilters__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoryFiltersAccess().getRightSquareBracketKeyword_4()); }

	RightSquareBracket 

{ after(grammarAccess.getCategoryFiltersAccess().getRightSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__CategorySet__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategorySet__Group__0__Impl
	rule__CategorySet__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CategorySet__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategorySetAccess().getCategorySetAction_0()); }
(

)
{ after(grammarAccess.getCategorySetAccess().getCategorySetAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CategorySet__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategorySet__Group__1__Impl
	rule__CategorySet__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CategorySet__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategorySetAccess().getNameAssignment_1()); }
(rule__CategorySet__NameAssignment_1)
{ after(grammarAccess.getCategorySetAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CategorySet__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategorySet__Group__2__Impl
	rule__CategorySet__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CategorySet__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategorySetAccess().getLeftCurlyBracketKeyword_2()); }

	LeftCurlyBracket 

{ after(grammarAccess.getCategorySetAccess().getLeftCurlyBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CategorySet__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategorySet__Group__3__Impl
	rule__CategorySet__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__CategorySet__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategorySetAccess().getElementsAssignment_3()); }
(rule__CategorySet__ElementsAssignment_3)*
{ after(grammarAccess.getCategorySetAccess().getElementsAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CategorySet__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategorySet__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CategorySet__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategorySetAccess().getRightCurlyBracketKeyword_4()); }

	RightCurlyBracket 

{ after(grammarAccess.getCategorySetAccess().getRightCurlyBracketKeyword_4()); }
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
					
						{ before(grammarAccess.getCategoriesDefinitionsAccess().getRequirementcategoriesAssignment_0()); }
						(rule__CategoriesDefinitions__RequirementcategoriesAssignment_0)
						{ after(grammarAccess.getCategoriesDefinitionsAccess().getRequirementcategoriesAssignment_0()); }
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
					
						{ before(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesAssignment_1()); }
						(rule__CategoriesDefinitions__MethodcategoriesAssignment_1)
						{ after(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesAssignment_1()); }
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
					
						{ before(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesAssignment_2()); }
						(rule__CategoriesDefinitions__SelectioncategoriesAssignment_2)
						{ after(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesAssignment_2()); }
					)
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
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getCategoriesDefinitionsAccess().getPhasecategoriesAssignment_3()); }
						(rule__CategoriesDefinitions__PhasecategoriesAssignment_3)
						{ after(grammarAccess.getCategoriesDefinitionsAccess().getPhasecategoriesAssignment_3()); }
					)
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
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesAssignment_4()); }
						(rule__CategoriesDefinitions__QualitycategoriesAssignment_4)
						{ after(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesAssignment_4()); }
					)
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
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterAssignment_5()); }
						(rule__CategoriesDefinitions__CategoryfilterAssignment_5)
						{ after(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterAssignment_5()); }
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
	rule__CategoriesDefinitions__UnorderedGroup__3?
;
finally {
	restoreStackSize(stackSize);
}


rule__CategoriesDefinitions__UnorderedGroup__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoriesDefinitions__UnorderedGroup__Impl
	rule__CategoriesDefinitions__UnorderedGroup__4?
;
finally {
	restoreStackSize(stackSize);
}


rule__CategoriesDefinitions__UnorderedGroup__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoriesDefinitions__UnorderedGroup__Impl
	rule__CategoriesDefinitions__UnorderedGroup__5?
;
finally {
	restoreStackSize(stackSize);
}


rule__CategoriesDefinitions__UnorderedGroup__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoriesDefinitions__UnorderedGroup__Impl
;
finally {
	restoreStackSize(stackSize);
}














rule__CategoriesDefinitions__RequirementcategoriesAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getRequirementcategoriesRequirementCategoriesParserRuleCall_0_0()); }
	ruleRequirementCategories{ after(grammarAccess.getCategoriesDefinitionsAccess().getRequirementcategoriesRequirementCategoriesParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategoriesDefinitions__MethodcategoriesAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesMethodCategoriesParserRuleCall_1_0()); }
	ruleMethodCategories{ after(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesMethodCategoriesParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategoriesDefinitions__SelectioncategoriesAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesSelectionCategoriesParserRuleCall_2_0()); }
	ruleSelectionCategories{ after(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesSelectionCategoriesParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategoriesDefinitions__PhasecategoriesAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getPhasecategoriesPhaseCategoriesParserRuleCall_3_0()); }
	rulePhaseCategories{ after(grammarAccess.getCategoriesDefinitionsAccess().getPhasecategoriesPhaseCategoriesParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategoriesDefinitions__QualitycategoriesAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesQualityCategoriesParserRuleCall_4_0()); }
	ruleQualityCategories{ after(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesQualityCategoriesParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategoriesDefinitions__CategoryfilterAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterCategoryFiltersParserRuleCall_5_0()); }
	ruleCategoryFilters{ after(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterCategoryFiltersParserRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementCategories__CategoryAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_4_0()); }
	ruleRequirementCategory{ after(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MethodCategories__CategoryAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodCategoriesAccess().getCategoryMethodCategoryParserRuleCall_4_0()); }
	ruleMethodCategory{ after(grammarAccess.getMethodCategoriesAccess().getCategoryMethodCategoryParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SelectionCategories__CategoryAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSelectionCategoriesAccess().getCategorySelectionCategoryParserRuleCall_4_0()); }
	ruleSelectionCategory{ after(grammarAccess.getSelectionCategoriesAccess().getCategorySelectionCategoryParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualityCategories__CategoryAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityCategoriesAccess().getCategoryQualityCategoryParserRuleCall_4_0()); }
	ruleQualityCategory{ after(grammarAccess.getQualityCategoriesAccess().getCategoryQualityCategoryParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PhaseCategories__CategoryAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPhaseCategoriesAccess().getCategoryPhaseCategoryParserRuleCall_4_0()); }
	rulePhaseCategory{ after(grammarAccess.getPhaseCategoriesAccess().getCategoryPhaseCategoryParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementCategory__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MethodCategory__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodCategoryAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getMethodCategoryAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SelectionCategory__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSelectionCategoryAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getSelectionCategoryAccess().getNameIDTerminalRuleCall_1_0()); }
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

rule__CategoryFilters__FiltersAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoryFiltersAccess().getFiltersCategorySetParserRuleCall_3_0()); }
	ruleCategorySet{ after(grammarAccess.getCategoryFiltersAccess().getFiltersCategorySetParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategorySet__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategorySetAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getCategorySetAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategorySet__ElementsAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategorySetAccess().getElementsCategoryCrossReference_3_0()); }
(
{ before(grammarAccess.getCategorySetAccess().getElementsCategoryCatRefParserRuleCall_3_0_1()); }
	ruleCatRef{ after(grammarAccess.getCategorySetAccess().getElementsCategoryCatRefParserRuleCall_3_0_1()); }
)
{ after(grammarAccess.getCategorySetAccess().getElementsCategoryCrossReference_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}



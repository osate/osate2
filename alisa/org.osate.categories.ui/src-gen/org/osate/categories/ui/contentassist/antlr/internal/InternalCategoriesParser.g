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
		tokenNameToValue.put("FullStop", "'.'");
		tokenNameToValue.put("LeftSquareBracket", "'['");
		tokenNameToValue.put("RightSquareBracket", "']'");
		tokenNameToValue.put("Any", "'any'");
		tokenNameToValue.put("Filter", "'filter'");
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
{ before(grammarAccess.getCategoriesDefinitionsAccess().getGroup()); }
(rule__CategoriesDefinitions__Group__0)
{ after(grammarAccess.getCategoriesDefinitionsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCategories
entryRuleCategories 
:
{ before(grammarAccess.getCategoriesRule()); }
	 ruleCategories
{ after(grammarAccess.getCategoriesRule()); } 
	 EOF 
;

// Rule Categories
ruleCategories 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getCategoriesAccess().getGroup()); }
(rule__Categories__Group__0)
{ after(grammarAccess.getCategoriesAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCategory
entryRuleCategory 
:
{ before(grammarAccess.getCategoryRule()); }
	 ruleCategory
{ after(grammarAccess.getCategoryRule()); } 
	 EOF 
;

// Rule Category
ruleCategory 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getCategoryAccess().getNameAssignment()); }
(rule__Category__NameAssignment)
{ after(grammarAccess.getCategoryAccess().getNameAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCategoryFilter
entryRuleCategoryFilter 
:
{ before(grammarAccess.getCategoryFilterRule()); }
	 ruleCategoryFilter
{ after(grammarAccess.getCategoryFilterRule()); } 
	 EOF 
;

// Rule CategoryFilter
ruleCategoryFilter 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getCategoryFilterAccess().getGroup()); }
(rule__CategoryFilter__Group__0)
{ after(grammarAccess.getCategoryFilterAccess().getGroup()); }
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
{ before(grammarAccess.getCatRefAccess().getGroup()); }
(rule__CatRef__Group__0)
{ after(grammarAccess.getCatRefAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CategoriesDefinitions__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoriesDefinitions__Group__0__Impl
	rule__CategoriesDefinitions__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CategoriesDefinitions__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesAssignment_0()); }
(rule__CategoriesDefinitions__CategoriesAssignment_0)*
{ after(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CategoriesDefinitions__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoriesDefinitions__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CategoriesDefinitions__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getCategoryFiltersAssignment_1()); }
(rule__CategoriesDefinitions__CategoryFiltersAssignment_1)*
{ after(grammarAccess.getCategoriesDefinitionsAccess().getCategoryFiltersAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Categories__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Categories__Group__0__Impl
	rule__Categories__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Categories__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesAccess().getNameAssignment_0()); }
(rule__Categories__NameAssignment_0)
{ after(grammarAccess.getCategoriesAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Categories__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Categories__Group__1__Impl
	rule__Categories__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Categories__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesAccess().getLeftSquareBracketKeyword_1()); }

	LeftSquareBracket 

{ after(grammarAccess.getCategoriesAccess().getLeftSquareBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Categories__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Categories__Group__2__Impl
	rule__Categories__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Categories__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); }
(rule__Categories__CategoryAssignment_2)
{ after(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); }
)
(
{ before(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); }
(rule__Categories__CategoryAssignment_2)*
{ after(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Categories__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Categories__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Categories__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesAccess().getRightSquareBracketKeyword_3()); }

	RightSquareBracket 

{ after(grammarAccess.getCategoriesAccess().getRightSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__CategoryFilter__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoryFilter__Group__0__Impl
	rule__CategoryFilter__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CategoryFilter__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoryFilterAccess().getFilterKeyword_0()); }

	Filter 

{ after(grammarAccess.getCategoryFilterAccess().getFilterKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CategoryFilter__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoryFilter__Group__1__Impl
	rule__CategoryFilter__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CategoryFilter__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoryFilterAccess().getNameAssignment_1()); }
(rule__CategoryFilter__NameAssignment_1)
{ after(grammarAccess.getCategoryFilterAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CategoryFilter__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoryFilter__Group__2__Impl
	rule__CategoryFilter__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CategoryFilter__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoryFilterAccess().getLeftSquareBracketKeyword_2()); }

	LeftSquareBracket 

{ after(grammarAccess.getCategoryFilterAccess().getLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CategoryFilter__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoryFilter__Group__3__Impl
	rule__CategoryFilter__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__CategoryFilter__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoryFilterAccess().getCategoryAssignment_3()); }
(rule__CategoryFilter__CategoryAssignment_3)*
{ after(grammarAccess.getCategoryFilterAccess().getCategoryAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CategoryFilter__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoryFilter__Group__4__Impl
	rule__CategoryFilter__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__CategoryFilter__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoryFilterAccess().getAnyCategoryAssignment_4()); }
(rule__CategoryFilter__AnyCategoryAssignment_4)?
{ after(grammarAccess.getCategoryFilterAccess().getAnyCategoryAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CategoryFilter__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CategoryFilter__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CategoryFilter__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_5()); }

	RightSquareBracket 

{ after(grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__CatRef__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CatRef__Group__0__Impl
	rule__CatRef__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CatRef__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCatRefAccess().getIDTerminalRuleCall_0()); }
	RULE_ID
{ after(grammarAccess.getCatRefAccess().getIDTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CatRef__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CatRef__Group__1__Impl
	rule__CatRef__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CatRef__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCatRefAccess().getFullStopKeyword_1()); }

	FullStop 

{ after(grammarAccess.getCatRefAccess().getFullStopKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CatRef__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CatRef__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CatRef__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCatRefAccess().getIDTerminalRuleCall_2()); }
	RULE_ID
{ after(grammarAccess.getCatRefAccess().getIDTerminalRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}









rule__CategoriesDefinitions__CategoriesAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesCategoriesParserRuleCall_0_0()); }
	ruleCategories{ after(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesCategoriesParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategoriesDefinitions__CategoryFiltersAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getCategoryFiltersCategoryFilterParserRuleCall_1_0()); }
	ruleCategoryFilter{ after(grammarAccess.getCategoriesDefinitionsAccess().getCategoryFiltersCategoryFilterParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Categories__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getCategoriesAccess().getNameIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Categories__CategoryAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesAccess().getCategoryCategoryParserRuleCall_2_0()); }
	ruleCategory{ after(grammarAccess.getCategoriesAccess().getCategoryCategoryParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Category__NameAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoryAccess().getNameIDTerminalRuleCall_0()); }
	RULE_ID{ after(grammarAccess.getCategoryAccess().getNameIDTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategoryFilter__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoryFilterAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getCategoryFilterAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategoryFilter__CategoryAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoryFilterAccess().getCategoryCategoryCrossReference_3_0()); }
(
{ before(grammarAccess.getCategoryFilterAccess().getCategoryCategoryCatRefParserRuleCall_3_0_1()); }
	ruleCatRef{ after(grammarAccess.getCategoryFilterAccess().getCategoryCategoryCatRefParserRuleCall_3_0_1()); }
)
{ after(grammarAccess.getCategoryFilterAccess().getCategoryCategoryCrossReference_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategoryFilter__AnyCategoryAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoryFilterAccess().getAnyCategoryAnyKeyword_4_0()); }
(
{ before(grammarAccess.getCategoryFilterAccess().getAnyCategoryAnyKeyword_4_0()); }

	Any 

{ after(grammarAccess.getCategoryFilterAccess().getAnyCategoryAnyKeyword_4_0()); }
)

{ after(grammarAccess.getCategoryFilterAccess().getAnyCategoryAnyKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}



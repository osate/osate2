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
		tokenNameToValue.put("Type", "'type'");
		tokenNameToValue.put("User", "'user'");
		tokenNameToValue.put("Phase", "'phase'");
		tokenNameToValue.put("Method", "'method'");
		tokenNameToValue.put("Quality", "'quality'");
		tokenNameToValue.put("Attribute", "'attribute'");
		tokenNameToValue.put("Selection", "'selection'");
		tokenNameToValue.put("Development", "'development'");
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



// Entry rule entryRuleRequirementTypeCategories
entryRuleRequirementTypeCategories 
:
{ before(grammarAccess.getRequirementTypeCategoriesRule()); }
	 ruleRequirementTypeCategories
{ after(grammarAccess.getRequirementTypeCategoriesRule()); } 
	 EOF 
;

// Rule RequirementTypeCategories
ruleRequirementTypeCategories 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getRequirementTypeCategoriesAccess().getGroup()); }
(rule__RequirementTypeCategories__Group__0)
{ after(grammarAccess.getRequirementTypeCategoriesAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMethodTypeCategories
entryRuleMethodTypeCategories 
:
{ before(grammarAccess.getMethodTypeCategoriesRule()); }
	 ruleMethodTypeCategories
{ after(grammarAccess.getMethodTypeCategoriesRule()); } 
	 EOF 
;

// Rule MethodTypeCategories
ruleMethodTypeCategories 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getMethodTypeCategoriesAccess().getGroup()); }
(rule__MethodTypeCategories__Group__0)
{ after(grammarAccess.getMethodTypeCategoriesAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUserSelectionCategories
entryRuleUserSelectionCategories 
:
{ before(grammarAccess.getUserSelectionCategoriesRule()); }
	 ruleUserSelectionCategories
{ after(grammarAccess.getUserSelectionCategoriesRule()); } 
	 EOF 
;

// Rule UserSelectionCategories
ruleUserSelectionCategories 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getUserSelectionCategoriesAccess().getGroup()); }
(rule__UserSelectionCategories__Group__0)
{ after(grammarAccess.getUserSelectionCategoriesAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleQualityAttributeCategories
entryRuleQualityAttributeCategories 
:
{ before(grammarAccess.getQualityAttributeCategoriesRule()); }
	 ruleQualityAttributeCategories
{ after(grammarAccess.getQualityAttributeCategoriesRule()); } 
	 EOF 
;

// Rule QualityAttributeCategories
ruleQualityAttributeCategories 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getQualityAttributeCategoriesAccess().getGroup()); }
(rule__QualityAttributeCategories__Group__0)
{ after(grammarAccess.getQualityAttributeCategoriesAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDevelopmentPhaseCategories
entryRuleDevelopmentPhaseCategories 
:
{ before(grammarAccess.getDevelopmentPhaseCategoriesRule()); }
	 ruleDevelopmentPhaseCategories
{ after(grammarAccess.getDevelopmentPhaseCategoriesRule()); } 
	 EOF 
;

// Rule DevelopmentPhaseCategories
ruleDevelopmentPhaseCategories 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getGroup()); }
(rule__DevelopmentPhaseCategories__Group__0)
{ after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRequirementType
entryRuleRequirementType 
:
{ before(grammarAccess.getRequirementTypeRule()); }
	 ruleRequirementType
{ after(grammarAccess.getRequirementTypeRule()); } 
	 EOF 
;

// Rule RequirementType
ruleRequirementType 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getRequirementTypeAccess().getGroup()); }
(rule__RequirementType__Group__0)
{ after(grammarAccess.getRequirementTypeAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMethodType
entryRuleMethodType 
:
{ before(grammarAccess.getMethodTypeRule()); }
	 ruleMethodType
{ after(grammarAccess.getMethodTypeRule()); } 
	 EOF 
;

// Rule MethodType
ruleMethodType 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getMethodTypeAccess().getGroup()); }
(rule__MethodType__Group__0)
{ after(grammarAccess.getMethodTypeAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUserSelection
entryRuleUserSelection 
:
{ before(grammarAccess.getUserSelectionRule()); }
	 ruleUserSelection
{ after(grammarAccess.getUserSelectionRule()); } 
	 EOF 
;

// Rule UserSelection
ruleUserSelection 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getUserSelectionAccess().getGroup()); }
(rule__UserSelection__Group__0)
{ after(grammarAccess.getUserSelectionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleQualityAttribute
entryRuleQualityAttribute 
:
{ before(grammarAccess.getQualityAttributeRule()); }
	 ruleQualityAttribute
{ after(grammarAccess.getQualityAttributeRule()); } 
	 EOF 
;

// Rule QualityAttribute
ruleQualityAttribute 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getQualityAttributeAccess().getGroup()); }
(rule__QualityAttribute__Group__0)
{ after(grammarAccess.getQualityAttributeAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDevelopmentPhase
entryRuleDevelopmentPhase 
:
{ before(grammarAccess.getDevelopmentPhaseRule()); }
	 ruleDevelopmentPhase
{ after(grammarAccess.getDevelopmentPhaseRule()); } 
	 EOF 
;

// Rule DevelopmentPhase
ruleDevelopmentPhase 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getDevelopmentPhaseAccess().getGroup()); }
(rule__DevelopmentPhase__Group__0)
{ after(grammarAccess.getDevelopmentPhaseAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__RequirementTypeCategories__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementTypeCategories__Group__0__Impl
	rule__RequirementTypeCategories__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementTypeCategories__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementTypeCategoriesAccess().getRequirementTypeCategoriesAction_0()); }
(

)
{ after(grammarAccess.getRequirementTypeCategoriesAccess().getRequirementTypeCategoriesAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RequirementTypeCategories__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementTypeCategories__Group__1__Impl
	rule__RequirementTypeCategories__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementTypeCategories__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementTypeCategoriesAccess().getRequirementKeyword_1()); }

	Requirement 

{ after(grammarAccess.getRequirementTypeCategoriesAccess().getRequirementKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RequirementTypeCategories__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementTypeCategories__Group__2__Impl
	rule__RequirementTypeCategories__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementTypeCategories__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementTypeCategoriesAccess().getTypeKeyword_2()); }

	Type 

{ after(grammarAccess.getRequirementTypeCategoriesAccess().getTypeKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RequirementTypeCategories__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementTypeCategories__Group__3__Impl
	rule__RequirementTypeCategories__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementTypeCategories__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementTypeCategoriesAccess().getLeftSquareBracketKeyword_3()); }

	LeftSquareBracket 

{ after(grammarAccess.getRequirementTypeCategoriesAccess().getLeftSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RequirementTypeCategories__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementTypeCategories__Group__4__Impl
	rule__RequirementTypeCategories__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementTypeCategories__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getRequirementTypeCategoriesAccess().getCategoryAssignment_4()); }
(rule__RequirementTypeCategories__CategoryAssignment_4)
{ after(grammarAccess.getRequirementTypeCategoriesAccess().getCategoryAssignment_4()); }
)
(
{ before(grammarAccess.getRequirementTypeCategoriesAccess().getCategoryAssignment_4()); }
(rule__RequirementTypeCategories__CategoryAssignment_4)*
{ after(grammarAccess.getRequirementTypeCategoriesAccess().getCategoryAssignment_4()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RequirementTypeCategories__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementTypeCategories__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementTypeCategories__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementTypeCategoriesAccess().getRightSquareBracketKeyword_5()); }

	RightSquareBracket 

{ after(grammarAccess.getRequirementTypeCategoriesAccess().getRightSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__MethodTypeCategories__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodTypeCategories__Group__0__Impl
	rule__MethodTypeCategories__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodTypeCategories__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodTypeCategoriesAccess().getMethodTypeCategoriesAction_0()); }
(

)
{ after(grammarAccess.getMethodTypeCategoriesAccess().getMethodTypeCategoriesAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MethodTypeCategories__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodTypeCategories__Group__1__Impl
	rule__MethodTypeCategories__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodTypeCategories__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodTypeCategoriesAccess().getMethodKeyword_1()); }

	Method 

{ after(grammarAccess.getMethodTypeCategoriesAccess().getMethodKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MethodTypeCategories__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodTypeCategories__Group__2__Impl
	rule__MethodTypeCategories__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodTypeCategories__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodTypeCategoriesAccess().getTypeKeyword_2()); }

	Type 

{ after(grammarAccess.getMethodTypeCategoriesAccess().getTypeKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MethodTypeCategories__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodTypeCategories__Group__3__Impl
	rule__MethodTypeCategories__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodTypeCategories__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodTypeCategoriesAccess().getLeftSquareBracketKeyword_3()); }

	LeftSquareBracket 

{ after(grammarAccess.getMethodTypeCategoriesAccess().getLeftSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MethodTypeCategories__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodTypeCategories__Group__4__Impl
	rule__MethodTypeCategories__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodTypeCategories__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getMethodTypeCategoriesAccess().getCategoryAssignment_4()); }
(rule__MethodTypeCategories__CategoryAssignment_4)
{ after(grammarAccess.getMethodTypeCategoriesAccess().getCategoryAssignment_4()); }
)
(
{ before(grammarAccess.getMethodTypeCategoriesAccess().getCategoryAssignment_4()); }
(rule__MethodTypeCategories__CategoryAssignment_4)*
{ after(grammarAccess.getMethodTypeCategoriesAccess().getCategoryAssignment_4()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MethodTypeCategories__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodTypeCategories__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodTypeCategories__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodTypeCategoriesAccess().getRightSquareBracketKeyword_5()); }

	RightSquareBracket 

{ after(grammarAccess.getMethodTypeCategoriesAccess().getRightSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__UserSelectionCategories__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UserSelectionCategories__Group__0__Impl
	rule__UserSelectionCategories__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UserSelectionCategories__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserSelectionCategoriesAccess().getUserSelectionCategoriesAction_0()); }
(

)
{ after(grammarAccess.getUserSelectionCategoriesAccess().getUserSelectionCategoriesAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UserSelectionCategories__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UserSelectionCategories__Group__1__Impl
	rule__UserSelectionCategories__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__UserSelectionCategories__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserSelectionCategoriesAccess().getUserKeyword_1()); }

	User 

{ after(grammarAccess.getUserSelectionCategoriesAccess().getUserKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UserSelectionCategories__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UserSelectionCategories__Group__2__Impl
	rule__UserSelectionCategories__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__UserSelectionCategories__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserSelectionCategoriesAccess().getSelectionKeyword_2()); }

	Selection 

{ after(grammarAccess.getUserSelectionCategoriesAccess().getSelectionKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UserSelectionCategories__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UserSelectionCategories__Group__3__Impl
	rule__UserSelectionCategories__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__UserSelectionCategories__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserSelectionCategoriesAccess().getLeftSquareBracketKeyword_3()); }

	LeftSquareBracket 

{ after(grammarAccess.getUserSelectionCategoriesAccess().getLeftSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UserSelectionCategories__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UserSelectionCategories__Group__4__Impl
	rule__UserSelectionCategories__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__UserSelectionCategories__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getUserSelectionCategoriesAccess().getCategoryAssignment_4()); }
(rule__UserSelectionCategories__CategoryAssignment_4)
{ after(grammarAccess.getUserSelectionCategoriesAccess().getCategoryAssignment_4()); }
)
(
{ before(grammarAccess.getUserSelectionCategoriesAccess().getCategoryAssignment_4()); }
(rule__UserSelectionCategories__CategoryAssignment_4)*
{ after(grammarAccess.getUserSelectionCategoriesAccess().getCategoryAssignment_4()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UserSelectionCategories__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UserSelectionCategories__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UserSelectionCategories__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserSelectionCategoriesAccess().getRightSquareBracketKeyword_5()); }

	RightSquareBracket 

{ after(grammarAccess.getUserSelectionCategoriesAccess().getRightSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__QualityAttributeCategories__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityAttributeCategories__Group__0__Impl
	rule__QualityAttributeCategories__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityAttributeCategories__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityAttributeCategoriesAccess().getQualityAttributeCategoriesAction_0()); }
(

)
{ after(grammarAccess.getQualityAttributeCategoriesAccess().getQualityAttributeCategoriesAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualityAttributeCategories__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityAttributeCategories__Group__1__Impl
	rule__QualityAttributeCategories__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityAttributeCategories__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityAttributeCategoriesAccess().getQualityKeyword_1()); }

	Quality 

{ after(grammarAccess.getQualityAttributeCategoriesAccess().getQualityKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualityAttributeCategories__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityAttributeCategories__Group__2__Impl
	rule__QualityAttributeCategories__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityAttributeCategories__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityAttributeCategoriesAccess().getAttributeKeyword_2()); }

	Attribute 

{ after(grammarAccess.getQualityAttributeCategoriesAccess().getAttributeKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualityAttributeCategories__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityAttributeCategories__Group__3__Impl
	rule__QualityAttributeCategories__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityAttributeCategories__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityAttributeCategoriesAccess().getLeftSquareBracketKeyword_3()); }

	LeftSquareBracket 

{ after(grammarAccess.getQualityAttributeCategoriesAccess().getLeftSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualityAttributeCategories__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityAttributeCategories__Group__4__Impl
	rule__QualityAttributeCategories__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityAttributeCategories__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getQualityAttributeCategoriesAccess().getCategoryAssignment_4()); }
(rule__QualityAttributeCategories__CategoryAssignment_4)
{ after(grammarAccess.getQualityAttributeCategoriesAccess().getCategoryAssignment_4()); }
)
(
{ before(grammarAccess.getQualityAttributeCategoriesAccess().getCategoryAssignment_4()); }
(rule__QualityAttributeCategories__CategoryAssignment_4)*
{ after(grammarAccess.getQualityAttributeCategoriesAccess().getCategoryAssignment_4()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualityAttributeCategories__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityAttributeCategories__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityAttributeCategories__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityAttributeCategoriesAccess().getRightSquareBracketKeyword_5()); }

	RightSquareBracket 

{ after(grammarAccess.getQualityAttributeCategoriesAccess().getRightSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__DevelopmentPhaseCategories__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DevelopmentPhaseCategories__Group__0__Impl
	rule__DevelopmentPhaseCategories__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DevelopmentPhaseCategories__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getDevelopmentPhaseCategoriesAction_0()); }
(

)
{ after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getDevelopmentPhaseCategoriesAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DevelopmentPhaseCategories__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DevelopmentPhaseCategories__Group__1__Impl
	rule__DevelopmentPhaseCategories__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DevelopmentPhaseCategories__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getDevelopmentKeyword_1()); }

	Development 

{ after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getDevelopmentKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DevelopmentPhaseCategories__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DevelopmentPhaseCategories__Group__2__Impl
	rule__DevelopmentPhaseCategories__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DevelopmentPhaseCategories__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getPhaseKeyword_2()); }

	Phase 

{ after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getPhaseKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DevelopmentPhaseCategories__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DevelopmentPhaseCategories__Group__3__Impl
	rule__DevelopmentPhaseCategories__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DevelopmentPhaseCategories__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getLeftSquareBracketKeyword_3()); }

	LeftSquareBracket 

{ after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getLeftSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DevelopmentPhaseCategories__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DevelopmentPhaseCategories__Group__4__Impl
	rule__DevelopmentPhaseCategories__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__DevelopmentPhaseCategories__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getCategoryAssignment_4()); }
(rule__DevelopmentPhaseCategories__CategoryAssignment_4)
{ after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getCategoryAssignment_4()); }
)
(
{ before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getCategoryAssignment_4()); }
(rule__DevelopmentPhaseCategories__CategoryAssignment_4)*
{ after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getCategoryAssignment_4()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DevelopmentPhaseCategories__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DevelopmentPhaseCategories__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DevelopmentPhaseCategories__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getRightSquareBracketKeyword_5()); }

	RightSquareBracket 

{ after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getRightSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__RequirementType__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementType__Group__0__Impl
	rule__RequirementType__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementType__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementTypeAccess().getRequirementTypeAction_0()); }
(

)
{ after(grammarAccess.getRequirementTypeAccess().getRequirementTypeAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RequirementType__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RequirementType__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementType__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementTypeAccess().getNameAssignment_1()); }
(rule__RequirementType__NameAssignment_1)
{ after(grammarAccess.getRequirementTypeAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MethodType__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodType__Group__0__Impl
	rule__MethodType__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodType__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodTypeAccess().getMethodTypeAction_0()); }
(

)
{ after(grammarAccess.getMethodTypeAccess().getMethodTypeAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MethodType__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MethodType__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodType__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodTypeAccess().getNameAssignment_1()); }
(rule__MethodType__NameAssignment_1)
{ after(grammarAccess.getMethodTypeAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__UserSelection__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UserSelection__Group__0__Impl
	rule__UserSelection__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UserSelection__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserSelectionAccess().getUserSelectionAction_0()); }
(

)
{ after(grammarAccess.getUserSelectionAccess().getUserSelectionAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UserSelection__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UserSelection__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UserSelection__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserSelectionAccess().getNameAssignment_1()); }
(rule__UserSelection__NameAssignment_1)
{ after(grammarAccess.getUserSelectionAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QualityAttribute__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityAttribute__Group__0__Impl
	rule__QualityAttribute__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityAttribute__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityAttributeAccess().getQualityAttributeAction_0()); }
(

)
{ after(grammarAccess.getQualityAttributeAccess().getQualityAttributeAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualityAttribute__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualityAttribute__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualityAttribute__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityAttributeAccess().getNameAssignment_1()); }
(rule__QualityAttribute__NameAssignment_1)
{ after(grammarAccess.getQualityAttributeAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DevelopmentPhase__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DevelopmentPhase__Group__0__Impl
	rule__DevelopmentPhase__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DevelopmentPhase__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDevelopmentPhaseAccess().getDevelopmentPhaseAction_0()); }
(

)
{ after(grammarAccess.getDevelopmentPhaseAccess().getDevelopmentPhaseAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DevelopmentPhase__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DevelopmentPhase__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DevelopmentPhase__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDevelopmentPhaseAccess().getNameAssignment_1()); }
(rule__DevelopmentPhase__NameAssignment_1)
{ after(grammarAccess.getDevelopmentPhaseAccess().getNameAssignment_1()); }
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
					
						{ before(grammarAccess.getCategoriesDefinitionsAccess().getRequirementTypeCategoriesAssignment_0()); }
						(rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0)
						{ after(grammarAccess.getCategoriesDefinitionsAccess().getRequirementTypeCategoriesAssignment_0()); }
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
					
						{ before(grammarAccess.getCategoriesDefinitionsAccess().getMethodTypeCategoriesAssignment_1()); }
						(rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1)
						{ after(grammarAccess.getCategoriesDefinitionsAccess().getMethodTypeCategoriesAssignment_1()); }
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
					
						{ before(grammarAccess.getCategoriesDefinitionsAccess().getDevelopmentPhaseCategoriesAssignment_3()); }
						(rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3)
						{ after(grammarAccess.getCategoriesDefinitionsAccess().getDevelopmentPhaseCategoriesAssignment_3()); }
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
					
						{ before(grammarAccess.getCategoriesDefinitionsAccess().getQualityAttributeCategoriesAssignment_4()); }
						(rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4)
						{ after(grammarAccess.getCategoriesDefinitionsAccess().getQualityAttributeCategoriesAssignment_4()); }
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
;
finally {
	restoreStackSize(stackSize);
}













rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getRequirementTypeCategoriesRequirementTypeCategoriesParserRuleCall_0_0()); }
	ruleRequirementTypeCategories{ after(grammarAccess.getCategoriesDefinitionsAccess().getRequirementTypeCategoriesRequirementTypeCategoriesParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getMethodTypeCategoriesMethodTypeCategoriesParserRuleCall_1_0()); }
	ruleMethodTypeCategories{ after(grammarAccess.getCategoriesDefinitionsAccess().getMethodTypeCategoriesMethodTypeCategoriesParserRuleCall_1_0()); }
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
{ before(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesUserSelectionCategoriesParserRuleCall_2_0()); }
	ruleUserSelectionCategories{ after(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesUserSelectionCategoriesParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getDevelopmentPhaseCategoriesDevelopmentPhaseCategoriesParserRuleCall_3_0()); }
	ruleDevelopmentPhaseCategories{ after(grammarAccess.getCategoriesDefinitionsAccess().getDevelopmentPhaseCategoriesDevelopmentPhaseCategoriesParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCategoriesDefinitionsAccess().getQualityAttributeCategoriesQualityAttributeCategoriesParserRuleCall_4_0()); }
	ruleQualityAttributeCategories{ after(grammarAccess.getCategoriesDefinitionsAccess().getQualityAttributeCategoriesQualityAttributeCategoriesParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementTypeCategories__CategoryAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementTypeCategoriesAccess().getCategoryRequirementTypeParserRuleCall_4_0()); }
	ruleRequirementType{ after(grammarAccess.getRequirementTypeCategoriesAccess().getCategoryRequirementTypeParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MethodTypeCategories__CategoryAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodTypeCategoriesAccess().getCategoryMethodTypeParserRuleCall_4_0()); }
	ruleMethodType{ after(grammarAccess.getMethodTypeCategoriesAccess().getCategoryMethodTypeParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__UserSelectionCategories__CategoryAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserSelectionCategoriesAccess().getCategoryUserSelectionParserRuleCall_4_0()); }
	ruleUserSelection{ after(grammarAccess.getUserSelectionCategoriesAccess().getCategoryUserSelectionParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualityAttributeCategories__CategoryAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityAttributeCategoriesAccess().getCategoryQualityAttributeParserRuleCall_4_0()); }
	ruleQualityAttribute{ after(grammarAccess.getQualityAttributeCategoriesAccess().getCategoryQualityAttributeParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DevelopmentPhaseCategories__CategoryAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDevelopmentPhaseCategoriesAccess().getCategoryDevelopmentPhaseParserRuleCall_4_0()); }
	ruleDevelopmentPhase{ after(grammarAccess.getDevelopmentPhaseCategoriesAccess().getCategoryDevelopmentPhaseParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RequirementType__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRequirementTypeAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getRequirementTypeAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MethodType__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMethodTypeAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getMethodTypeAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__UserSelection__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUserSelectionAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getUserSelectionAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualityAttribute__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualityAttributeAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getQualityAttributeAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DevelopmentPhase__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDevelopmentPhaseAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getDevelopmentPhaseAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}














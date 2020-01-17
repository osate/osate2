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
parser grammar InternalReqSpecParser;

options {
	tokenVocab=InternalReqSpecLexer;
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;
	
}

@header {
package org.osate.reqspec.ui.contentassist.antlr.internal; 

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
import org.osate.reqspec.services.ReqSpecGrammarAccess;

}

@members {
 
 	private ReqSpecGrammarAccess grammarAccess;
 	
 	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
 	
 	{
		tokenNameToValue.put("NumberSign", "'#'");
		tokenNameToValue.put("PercentSign", "'\%'");
		tokenNameToValue.put("LeftParenthesis", "'('");
		tokenNameToValue.put("RightParenthesis", "')'");
		tokenNameToValue.put("Asterisk", "'*'");
		tokenNameToValue.put("PlusSign", "'+'");
		tokenNameToValue.put("Comma", "','");
		tokenNameToValue.put("HyphenMinus", "'-'");
		tokenNameToValue.put("FullStop", "'.'");
		tokenNameToValue.put("Solidus", "'/'");
		tokenNameToValue.put("Colon", "':'");
		tokenNameToValue.put("LessThanSign", "'<'");
		tokenNameToValue.put("EqualsSign", "'='");
		tokenNameToValue.put("GreaterThanSign", "'>'");
		tokenNameToValue.put("LeftSquareBracket", "'['");
		tokenNameToValue.put("RightSquareBracket", "']'");
		tokenNameToValue.put("ExclamationMarkEqualsSign", "'!='");
		tokenNameToValue.put("AmpersandAmpersand", "'&&'");
		tokenNameToValue.put("FullStopFullStop", "'..'");
		tokenNameToValue.put("ColonColon", "'::'");
		tokenNameToValue.put("LessThanSignEqualsSign", "'<='");
		tokenNameToValue.put("EqualsSignEqualsSign", "'=='");
		tokenNameToValue.put("GreaterThanSignLessThanSign", "'><'");
		tokenNameToValue.put("GreaterThanSignEqualsSign", "'>='");
		tokenNameToValue.put("As", "'as'");
		tokenNameToValue.put("If", "'if'");
		tokenNameToValue.put("In", "'in'");
		tokenNameToValue.put("Or", "'or'");
		tokenNameToValue.put("VerticalLineVerticalLine", "'||'");
		tokenNameToValue.put("And", "'and'");
		tokenNameToValue.put("Bus", "'bus'");
		tokenNameToValue.put("Div", "'div'");
		tokenNameToValue.put("For", "'for'");
		tokenNameToValue.put("Img", "'img'");
		tokenNameToValue.put("Mod", "'mod'");
		tokenNameToValue.put("Not", "'not'");
		tokenNameToValue.put("See", "'see'");
		tokenNameToValue.put("Use", "'use'");
		tokenNameToValue.put("Val", "'val'");
		tokenNameToValue.put("Data", "'data'");
		tokenNameToValue.put("Else", "'else'");
		tokenNameToValue.put("Flow", "'flow'");
		tokenNameToValue.put("Goal", "'goal'");
		tokenNameToValue.put("Mode", "'mode'");
		tokenNameToValue.put("Real", "'real'");
		tokenNameToValue.put("Root", "'root'");
		tokenNameToValue.put("Self", "'self'");
		tokenNameToValue.put("Then", "'then'");
		tokenNameToValue.put("This", "'this'");
		tokenNameToValue.put("True", "'true'");
		tokenNameToValue.put("Upto", "'upto'");
		tokenNameToValue.put("When", "'when'");
		tokenNameToValue.put("With", "'with'");
		tokenNameToValue.put("Delta", "'delta'");
		tokenNameToValue.put("Endif", "'endif'");
		tokenNameToValue.put("Error", "'error'");
		tokenNameToValue.put("False", "'false'");
		tokenNameToValue.put("Goals", "'goals'");
		tokenNameToValue.put("Group", "'group'");
		tokenNameToValue.put("Model", "'model'");
		tokenNameToValue.put("State", "'state'");
		tokenNameToValue.put("Units", "'units'");
		tokenNameToValue.put("Value", "'value'");
		tokenNameToValue.put("Device", "'device'");
		tokenNameToValue.put("Downto", "'downto'");
		tokenNameToValue.put("Global", "'global'");
		tokenNameToValue.put("Impact", "'impact'");
		tokenNameToValue.put("Issues", "'issues'");
		tokenNameToValue.put("Memory", "'memory'");
		tokenNameToValue.put("String", "'string'");
		tokenNameToValue.put("KW_System", "'system'");
		tokenNameToValue.put("Thread", "'thread'");
		tokenNameToValue.put("Typeof", "'typeof'");
		tokenNameToValue.put("Boolean", "'boolean'");
		tokenNameToValue.put("Compute", "'compute'");
		tokenNameToValue.put("Dropped", "'dropped'");
		tokenNameToValue.put("Element", "'element'");
		tokenNameToValue.put("Evolves", "'evolves'");
		tokenNameToValue.put("Feature", "'feature'");
		tokenNameToValue.put("Include", "'include'");
		tokenNameToValue.put("Integer", "'integer'");
		tokenNameToValue.put("Process", "'process'");
		tokenNameToValue.put("Refines", "'refines'");
		tokenNameToValue.put("Section", "'section'");
		tokenNameToValue.put("Virtual", "'virtual'");
		tokenNameToValue.put("Abstract", "'abstract'");
		tokenNameToValue.put("Category", "'category'");
		tokenNameToValue.put("Document", "'document'");
		tokenNameToValue.put("Informal", "'informal'");
		tokenNameToValue.put("Inherits", "'inherits'");
		tokenNameToValue.put("Component", "'component'");
		tokenNameToValue.put("Conflicts", "'conflicts'");
		tokenNameToValue.put("Constants", "'constants'");
		tokenNameToValue.put("Mitigates", "'mitigates'");
		tokenNameToValue.put("Predicate", "'predicate'");
		tokenNameToValue.put("Processor", "'processor'");
		tokenNameToValue.put("Rationale", "'rationale'");
		tokenNameToValue.put("Connection", "'connection'");
		tokenNameToValue.put("Decomposes", "'decomposes'");
		tokenNameToValue.put("Precedence", "'precedence'");
		tokenNameToValue.put("Subprogram", "'subprogram'");
		tokenNameToValue.put("Volatility", "'volatility'");
		tokenNameToValue.put("Description", "'description'");
		tokenNameToValue.put("Development", "'development'");
		tokenNameToValue.put("Requirement", "'requirement'");
		tokenNameToValue.put("Stakeholder", "'stakeholder'");
		tokenNameToValue.put("Uncertainty", "'uncertainty'");
		tokenNameToValue.put("Requirements", "'requirements'");
 	}
 	
    public void setGrammarAccess(ReqSpecGrammarAccess grammarAccess) {
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




// Entry rule entryRuleReqSpec
entryRuleReqSpec 
:
{ before(grammarAccess.getReqSpecRule()); }
	 ruleReqSpec
{ after(grammarAccess.getReqSpecRule()); } 
	 EOF 
;

// Rule ReqSpec
ruleReqSpec 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
(
{ before(grammarAccess.getReqSpecAccess().getPartsAssignment()); }
(rule__ReqSpec__PartsAssignment)
{ after(grammarAccess.getReqSpecAccess().getPartsAssignment()); }
)
(
{ before(grammarAccess.getReqSpecAccess().getPartsAssignment()); }
(rule__ReqSpec__PartsAssignment)*
{ after(grammarAccess.getReqSpecAccess().getPartsAssignment()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleGlobalConstants
entryRuleGlobalConstants 
:
{ before(grammarAccess.getGlobalConstantsRule()); }
	 ruleGlobalConstants
{ after(grammarAccess.getGlobalConstantsRule()); } 
	 EOF 
;

// Rule GlobalConstants
ruleGlobalConstants 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getGlobalConstantsAccess().getGroup()); }
(rule__GlobalConstants__Group__0)
{ after(grammarAccess.getGlobalConstantsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}







// Entry rule entryRuleStakeholderGoals
entryRuleStakeholderGoals 
:
{ before(grammarAccess.getStakeholderGoalsRule()); }
	 ruleStakeholderGoals
{ after(grammarAccess.getStakeholderGoalsRule()); } 
	 EOF 
;

// Rule StakeholderGoals
ruleStakeholderGoals 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getStakeholderGoalsAccess().getGroup()); }
(rule__StakeholderGoals__Group__0)
{ after(grammarAccess.getStakeholderGoalsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleReqDocument
entryRuleReqDocument 
:
{ before(grammarAccess.getReqDocumentRule()); }
	 ruleReqDocument
{ after(grammarAccess.getReqDocumentRule()); } 
	 EOF 
;

// Rule ReqDocument
ruleReqDocument 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getReqDocumentAccess().getGroup()); }
(rule__ReqDocument__Group__0)
{ after(grammarAccess.getReqDocumentAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDocumentSection
entryRuleDocumentSection 
:
{ before(grammarAccess.getDocumentSectionRule()); }
	 ruleDocumentSection
{ after(grammarAccess.getDocumentSectionRule()); } 
	 EOF 
;

// Rule DocumentSection
ruleDocumentSection 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getDocumentSectionAccess().getGroup()); }
(rule__DocumentSection__Group__0)
{ after(grammarAccess.getDocumentSectionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSystemRequirementSet
entryRuleSystemRequirementSet 
:
{ before(grammarAccess.getSystemRequirementSetRule()); }
	 ruleSystemRequirementSet
{ after(grammarAccess.getSystemRequirementSetRule()); } 
	 EOF 
;

// Rule SystemRequirementSet
ruleSystemRequirementSet 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getSystemRequirementSetAccess().getGroup()); }
(rule__SystemRequirementSet__Group__0)
{ after(grammarAccess.getSystemRequirementSetAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleGlobalRequirementSet
entryRuleGlobalRequirementSet 
:
{ before(grammarAccess.getGlobalRequirementSetRule()); }
	 ruleGlobalRequirementSet
{ after(grammarAccess.getGlobalRequirementSetRule()); } 
	 EOF 
;

// Rule GlobalRequirementSet
ruleGlobalRequirementSet 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getGroup()); }
(rule__GlobalRequirementSet__Group__0)
{ after(grammarAccess.getGlobalRequirementSetAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDocGoal
entryRuleDocGoal 
:
{ before(grammarAccess.getDocGoalRule()); }
	 ruleDocGoal
{ after(grammarAccess.getDocGoalRule()); } 
	 EOF 
;

// Rule DocGoal
ruleDocGoal 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getDocGoalAccess().getGroup()); }
(rule__DocGoal__Group__0)
{ after(grammarAccess.getDocGoalAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleGoal
entryRuleGoal 
:
{ before(grammarAccess.getGoalRule()); }
	 ruleGoal
{ after(grammarAccess.getGoalRule()); } 
	 EOF 
;

// Rule Goal
ruleGoal 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getGoalAccess().getGroup()); }
(rule__Goal__Group__0)
{ after(grammarAccess.getGoalAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSystemRequirement
entryRuleSystemRequirement 
:
{ before(grammarAccess.getSystemRequirementRule()); }
	 ruleSystemRequirement
{ after(grammarAccess.getSystemRequirementRule()); } 
	 EOF 
;

// Rule SystemRequirement
ruleSystemRequirement 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getSystemRequirementAccess().getGroup()); }
(rule__SystemRequirement__Group__0)
{ after(grammarAccess.getSystemRequirementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleGlobalRequirement
entryRuleGlobalRequirement 
:
{ before(grammarAccess.getGlobalRequirementRule()); }
	 ruleGlobalRequirement
{ after(grammarAccess.getGlobalRequirementRule()); } 
	 EOF 
;

// Rule GlobalRequirement
ruleGlobalRequirement 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getGlobalRequirementAccess().getGroup()); }
(rule__GlobalRequirement__Group__0)
{ after(grammarAccess.getGlobalRequirementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDocRequirement
entryRuleDocRequirement 
:
{ before(grammarAccess.getDocRequirementRule()); }
	 ruleDocRequirement
{ after(grammarAccess.getDocRequirementRule()); } 
	 EOF 
;

// Rule DocRequirement
ruleDocRequirement 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getDocRequirementAccess().getGroup()); }
(rule__DocRequirement__Group__0)
{ after(grammarAccess.getDocRequirementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleIncludeGlobalRequirement
entryRuleIncludeGlobalRequirement 
:
{ before(grammarAccess.getIncludeGlobalRequirementRule()); }
	 ruleIncludeGlobalRequirement
{ after(grammarAccess.getIncludeGlobalRequirementRule()); } 
	 EOF 
;

// Rule IncludeGlobalRequirement
ruleIncludeGlobalRequirement 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getIncludeGlobalRequirementAccess().getGroup()); }
(rule__IncludeGlobalRequirement__Group__0)
{ after(grammarAccess.getIncludeGlobalRequirementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleWhenCondition
entryRuleWhenCondition 
:
{ before(grammarAccess.getWhenConditionRule()); }
	 ruleWhenCondition
{ after(grammarAccess.getWhenConditionRule()); } 
	 EOF 
;

// Rule WhenCondition
ruleWhenCondition 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getWhenConditionAccess().getGroup()); }
(rule__WhenCondition__Group__0)
{ after(grammarAccess.getWhenConditionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleReqPredicate
entryRuleReqPredicate 
:
{ before(grammarAccess.getReqPredicateRule()); }
	 ruleReqPredicate
{ after(grammarAccess.getReqPredicateRule()); } 
	 EOF 
;

// Rule ReqPredicate
ruleReqPredicate 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getReqPredicateAccess().getAlternatives()); }
(rule__ReqPredicate__Alternatives)
{ after(grammarAccess.getReqPredicateAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleInformalPredicate
entryRuleInformalPredicate 
:
{ before(grammarAccess.getInformalPredicateRule()); }
	 ruleInformalPredicate
{ after(grammarAccess.getInformalPredicateRule()); } 
	 EOF 
;

// Rule InformalPredicate
ruleInformalPredicate 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getInformalPredicateAccess().getGroup()); }
(rule__InformalPredicate__Group__0)
{ after(grammarAccess.getInformalPredicateAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleValuePredicate
entryRuleValuePredicate 
:
{ before(grammarAccess.getValuePredicateRule()); }
	 ruleValuePredicate
{ after(grammarAccess.getValuePredicateRule()); } 
	 EOF 
;

// Rule ValuePredicate
ruleValuePredicate 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getValuePredicateAccess().getGroup()); }
(rule__ValuePredicate__Group__0)
{ after(grammarAccess.getValuePredicateAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDesiredValue
entryRuleDesiredValue 
:
{ before(grammarAccess.getDesiredValueRule()); }
	 ruleDesiredValue
{ after(grammarAccess.getDesiredValueRule()); } 
	 EOF 
;

// Rule DesiredValue
ruleDesiredValue 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getDesiredValueAccess().getGroup()); }
(rule__DesiredValue__Group__0)
{ after(grammarAccess.getDesiredValueAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleExternalDocument
entryRuleExternalDocument 
:
{ before(grammarAccess.getExternalDocumentRule()); }
	 ruleExternalDocument
{ after(grammarAccess.getExternalDocumentRule()); } 
	 EOF 
;

// Rule ExternalDocument
ruleExternalDocument 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getExternalDocumentAccess().getGroup()); }
(rule__ExternalDocument__Group__0)
{ after(grammarAccess.getExternalDocumentAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleValDeclaration
entryRuleValDeclaration 
:
{ before(grammarAccess.getValDeclarationRule()); }
	 ruleValDeclaration
{ after(grammarAccess.getValDeclarationRule()); } 
	 EOF 
;

// Rule ValDeclaration
ruleValDeclaration 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getValDeclarationAccess().getGroup()); }
(rule__ValDeclaration__Group__0)
{ after(grammarAccess.getValDeclarationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDOCPATH
entryRuleDOCPATH 
:
{ before(grammarAccess.getDOCPATHRule()); }
	 ruleDOCPATH
{ after(grammarAccess.getDOCPATHRule()); } 
	 EOF 
;

// Rule DOCPATH
ruleDOCPATH 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getDOCPATHAccess().getGroup()); }
(rule__DOCPATH__Group__0)
{ after(grammarAccess.getDOCPATHAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDescription
entryRuleDescription 
:
{ before(grammarAccess.getDescriptionRule()); }
	 ruleDescription
{ after(grammarAccess.getDescriptionRule()); } 
	 EOF 
;

// Rule Description
ruleDescription 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getDescriptionAccess().getGroup()); }
(rule__Description__Group__0)
{ after(grammarAccess.getDescriptionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDescriptionElement
entryRuleDescriptionElement 
:
{ before(grammarAccess.getDescriptionElementRule()); }
	 ruleDescriptionElement
{ after(grammarAccess.getDescriptionElementRule()); } 
	 EOF 
;

// Rule DescriptionElement
ruleDescriptionElement 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getDescriptionElementAccess().getAlternatives()); }
(rule__DescriptionElement__Alternatives)
{ after(grammarAccess.getDescriptionElementAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRationale
entryRuleRationale 
:
{ before(grammarAccess.getRationaleRule()); }
	 ruleRationale
{ after(grammarAccess.getRationaleRule()); } 
	 EOF 
;

// Rule Rationale
ruleRationale 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getRationaleAccess().getGroup()); }
(rule__Rationale__Group__0)
{ after(grammarAccess.getRationaleAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUncertainty
entryRuleUncertainty 
:
{ before(grammarAccess.getUncertaintyRule()); }
	 ruleUncertainty
{ after(grammarAccess.getUncertaintyRule()); } 
	 EOF 
;

// Rule Uncertainty
ruleUncertainty 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getUncertaintyAccess().getGroup()); }
(rule__Uncertainty__Group__0)
{ after(grammarAccess.getUncertaintyAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeRef
entryRuleTypeRef 
:
{ before(grammarAccess.getTypeRefRule()); }
	 ruleTypeRef
{ after(grammarAccess.getTypeRefRule()); } 
	 EOF 
;

// Rule TypeRef
ruleTypeRef 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeRefAccess().getAlternatives()); }
(rule__TypeRef__Alternatives)
{ after(grammarAccess.getTypeRefAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePropertyRef
entryRulePropertyRef 
:
{ before(grammarAccess.getPropertyRefRule()); }
	 rulePropertyRef
{ after(grammarAccess.getPropertyRefRule()); } 
	 EOF 
;

// Rule PropertyRef
rulePropertyRef 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getPropertyRefAccess().getGroup()); }
(rule__PropertyRef__Group__0)
{ after(grammarAccess.getPropertyRefAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleComputeDeclaration
entryRuleComputeDeclaration 
:
{ before(grammarAccess.getComputeDeclarationRule()); }
	 ruleComputeDeclaration
{ after(grammarAccess.getComputeDeclarationRule()); } 
	 EOF 
;

// Rule ComputeDeclaration
ruleComputeDeclaration 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getComputeDeclarationAccess().getGroup()); }
(rule__ComputeDeclaration__Group__0)
{ after(grammarAccess.getComputeDeclarationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAModelOrPropertyReference
entryRuleAModelOrPropertyReference 
:
{ before(grammarAccess.getAModelOrPropertyReferenceRule()); }
	 ruleAModelOrPropertyReference
{ after(grammarAccess.getAModelOrPropertyReferenceRule()); } 
	 EOF 
;

// Rule AModelOrPropertyReference
ruleAModelOrPropertyReference 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getAlternatives()); }
(rule__AModelOrPropertyReference__Alternatives)
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAModelReference
entryRuleAModelReference 
:
{ before(grammarAccess.getAModelReferenceRule()); }
	 ruleAModelReference
{ after(grammarAccess.getAModelReferenceRule()); } 
	 EOF 
;

// Rule AModelReference
ruleAModelReference 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAModelReferenceAccess().getGroup()); }
(rule__AModelReference__Group__0)
{ after(grammarAccess.getAModelReferenceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAPropertyReference
entryRuleAPropertyReference 
:
{ before(grammarAccess.getAPropertyReferenceRule()); }
	 ruleAPropertyReference
{ after(grammarAccess.getAPropertyReferenceRule()); } 
	 EOF 
;

// Rule APropertyReference
ruleAPropertyReference 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAPropertyReferenceAccess().getGroup()); }
(rule__APropertyReference__Group__0)
{ after(grammarAccess.getAPropertyReferenceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAVariableReference
entryRuleAVariableReference 
:
{ before(grammarAccess.getAVariableReferenceRule()); }
	 ruleAVariableReference
{ after(grammarAccess.getAVariableReferenceRule()); } 
	 EOF 
;

// Rule AVariableReference
ruleAVariableReference 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAVariableReferenceAccess().getGroup()); }
(rule__AVariableReference__Group__0)
{ after(grammarAccess.getAVariableReferenceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleShowValue
entryRuleShowValue 
:
{ before(grammarAccess.getShowValueRule()); }
	 ruleShowValue
{ after(grammarAccess.getShowValueRule()); } 
	 EOF 
;

// Rule ShowValue
ruleShowValue 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getShowValueAccess().getGroup()); }
(rule__ShowValue__Group__0)
{ after(grammarAccess.getShowValueAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleImageReference
entryRuleImageReference 
:
{ before(grammarAccess.getImageReferenceRule()); }
	 ruleImageReference
{ after(grammarAccess.getImageReferenceRule()); } 
	 EOF 
;

// Rule ImageReference
ruleImageReference 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getImageReferenceAccess().getGroup()); }
(rule__ImageReference__Group__0)
{ after(grammarAccess.getImageReferenceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleIMGREF
entryRuleIMGREF 
:
{ before(grammarAccess.getIMGREFRule()); }
	 ruleIMGREF
{ after(grammarAccess.getIMGREFRule()); } 
	 EOF 
;

// Rule IMGREF
ruleIMGREF 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getIMGREFAccess().getGroup()); }
(rule__IMGREF__Group__0)
{ after(grammarAccess.getIMGREFAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAExpression
entryRuleAExpression 
:
{ before(grammarAccess.getAExpressionRule()); }
	 ruleAExpression
{ after(grammarAccess.getAExpressionRule()); } 
	 EOF 
;

// Rule AExpression
ruleAExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAExpressionAccess().getAOrExpressionParserRuleCall()); }
	ruleAOrExpression
{ after(grammarAccess.getAExpressionAccess().getAOrExpressionParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAOrExpression
entryRuleAOrExpression 
:
{ before(grammarAccess.getAOrExpressionRule()); }
	 ruleAOrExpression
{ after(grammarAccess.getAOrExpressionRule()); } 
	 EOF 
;

// Rule AOrExpression
ruleAOrExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAOrExpressionAccess().getGroup()); }
(rule__AOrExpression__Group__0)
{ after(grammarAccess.getAOrExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOpOr
entryRuleOpOr 
:
{ before(grammarAccess.getOpOrRule()); }
	 ruleOpOr
{ after(grammarAccess.getOpOrRule()); } 
	 EOF 
;

// Rule OpOr
ruleOpOr 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getOpOrAccess().getAlternatives()); }
(rule__OpOr__Alternatives)
{ after(grammarAccess.getOpOrAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAAndExpression
entryRuleAAndExpression 
:
{ before(grammarAccess.getAAndExpressionRule()); }
	 ruleAAndExpression
{ after(grammarAccess.getAAndExpressionRule()); } 
	 EOF 
;

// Rule AAndExpression
ruleAAndExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAAndExpressionAccess().getGroup()); }
(rule__AAndExpression__Group__0)
{ after(grammarAccess.getAAndExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOpAnd
entryRuleOpAnd 
:
{ before(grammarAccess.getOpAndRule()); }
	 ruleOpAnd
{ after(grammarAccess.getOpAndRule()); } 
	 EOF 
;

// Rule OpAnd
ruleOpAnd 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getOpAndAccess().getAlternatives()); }
(rule__OpAnd__Alternatives)
{ after(grammarAccess.getOpAndAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAEqualityExpression
entryRuleAEqualityExpression 
:
{ before(grammarAccess.getAEqualityExpressionRule()); }
	 ruleAEqualityExpression
{ after(grammarAccess.getAEqualityExpressionRule()); } 
	 EOF 
;

// Rule AEqualityExpression
ruleAEqualityExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAEqualityExpressionAccess().getGroup()); }
(rule__AEqualityExpression__Group__0)
{ after(grammarAccess.getAEqualityExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOpEquality
entryRuleOpEquality 
:
{ before(grammarAccess.getOpEqualityRule()); }
	 ruleOpEquality
{ after(grammarAccess.getOpEqualityRule()); } 
	 EOF 
;

// Rule OpEquality
ruleOpEquality 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getOpEqualityAccess().getAlternatives()); }
(rule__OpEquality__Alternatives)
{ after(grammarAccess.getOpEqualityAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleARelationalExpression
entryRuleARelationalExpression 
:
{ before(grammarAccess.getARelationalExpressionRule()); }
	 ruleARelationalExpression
{ after(grammarAccess.getARelationalExpressionRule()); } 
	 EOF 
;

// Rule ARelationalExpression
ruleARelationalExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getARelationalExpressionAccess().getGroup()); }
(rule__ARelationalExpression__Group__0)
{ after(grammarAccess.getARelationalExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOpCompare
entryRuleOpCompare 
:
{ before(grammarAccess.getOpCompareRule()); }
	 ruleOpCompare
{ after(grammarAccess.getOpCompareRule()); } 
	 EOF 
;

// Rule OpCompare
ruleOpCompare 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getOpCompareAccess().getAlternatives()); }
(rule__OpCompare__Alternatives)
{ after(grammarAccess.getOpCompareAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAAdditiveExpression
entryRuleAAdditiveExpression 
:
{ before(grammarAccess.getAAdditiveExpressionRule()); }
	 ruleAAdditiveExpression
{ after(grammarAccess.getAAdditiveExpressionRule()); } 
	 EOF 
;

// Rule AAdditiveExpression
ruleAAdditiveExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getGroup()); }
(rule__AAdditiveExpression__Group__0)
{ after(grammarAccess.getAAdditiveExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOpAdd
entryRuleOpAdd 
:
{ before(grammarAccess.getOpAddRule()); }
	 ruleOpAdd
{ after(grammarAccess.getOpAddRule()); } 
	 EOF 
;

// Rule OpAdd
ruleOpAdd 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getOpAddAccess().getAlternatives()); }
(rule__OpAdd__Alternatives)
{ after(grammarAccess.getOpAddAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAMultiplicativeExpression
entryRuleAMultiplicativeExpression 
:
{ before(grammarAccess.getAMultiplicativeExpressionRule()); }
	 ruleAMultiplicativeExpression
{ after(grammarAccess.getAMultiplicativeExpressionRule()); } 
	 EOF 
;

// Rule AMultiplicativeExpression
ruleAMultiplicativeExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getGroup()); }
(rule__AMultiplicativeExpression__Group__0)
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOpMulti
entryRuleOpMulti 
:
{ before(grammarAccess.getOpMultiRule()); }
	 ruleOpMulti
{ after(grammarAccess.getOpMultiRule()); } 
	 EOF 
;

// Rule OpMulti
ruleOpMulti 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getOpMultiAccess().getAlternatives()); }
(rule__OpMulti__Alternatives)
{ after(grammarAccess.getOpMultiAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAUnaryOperation
entryRuleAUnaryOperation 
:
{ before(grammarAccess.getAUnaryOperationRule()); }
	 ruleAUnaryOperation
{ after(grammarAccess.getAUnaryOperationRule()); } 
	 EOF 
;

// Rule AUnaryOperation
ruleAUnaryOperation 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAUnaryOperationAccess().getAlternatives()); }
(rule__AUnaryOperation__Alternatives)
{ after(grammarAccess.getAUnaryOperationAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOpUnary
entryRuleOpUnary 
:
{ before(grammarAccess.getOpUnaryRule()); }
	 ruleOpUnary
{ after(grammarAccess.getOpUnaryRule()); } 
	 EOF 
;

// Rule OpUnary
ruleOpUnary 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getOpUnaryAccess().getAlternatives()); }
(rule__OpUnary__Alternatives)
{ after(grammarAccess.getOpUnaryAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAUnitExpression
entryRuleAUnitExpression 
:
{ before(grammarAccess.getAUnitExpressionRule()); }
	 ruleAUnitExpression
{ after(grammarAccess.getAUnitExpressionRule()); } 
	 EOF 
;

// Rule AUnitExpression
ruleAUnitExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAUnitExpressionAccess().getGroup()); }
(rule__AUnitExpression__Group__0)
{ after(grammarAccess.getAUnitExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAPrimaryExpression
entryRuleAPrimaryExpression 
:
{ before(grammarAccess.getAPrimaryExpressionRule()); }
	 ruleAPrimaryExpression
{ after(grammarAccess.getAPrimaryExpressionRule()); } 
	 EOF 
;

// Rule APrimaryExpression
ruleAPrimaryExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAPrimaryExpressionAccess().getAlternatives()); }
(rule__APrimaryExpression__Alternatives)
{ after(grammarAccess.getAPrimaryExpressionAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAFunctionCall
entryRuleAFunctionCall 
:
{ before(grammarAccess.getAFunctionCallRule()); }
	 ruleAFunctionCall
{ after(grammarAccess.getAFunctionCallRule()); } 
	 EOF 
;

// Rule AFunctionCall
ruleAFunctionCall 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAFunctionCallAccess().getGroup()); }
(rule__AFunctionCall__Group__0)
{ after(grammarAccess.getAFunctionCallAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleARangeExpression
entryRuleARangeExpression 
:
{ before(grammarAccess.getARangeExpressionRule()); }
	 ruleARangeExpression
{ after(grammarAccess.getARangeExpressionRule()); } 
	 EOF 
;

// Rule ARangeExpression
ruleARangeExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getARangeExpressionAccess().getGroup()); }
(rule__ARangeExpression__Group__0)
{ after(grammarAccess.getARangeExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAIfExpression
entryRuleAIfExpression 
:
{ before(grammarAccess.getAIfExpressionRule()); }
	 ruleAIfExpression
{ after(grammarAccess.getAIfExpressionRule()); } 
	 EOF 
;

// Rule AIfExpression
ruleAIfExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAIfExpressionAccess().getGroup()); }
(rule__AIfExpression__Group__0)
{ after(grammarAccess.getAIfExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleALiteral
entryRuleALiteral 
:
{ before(grammarAccess.getALiteralRule()); }
	 ruleALiteral
{ after(grammarAccess.getALiteralRule()); } 
	 EOF 
;

// Rule ALiteral
ruleALiteral 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getALiteralAccess().getAlternatives()); }
(rule__ALiteral__Alternatives)
{ after(grammarAccess.getALiteralAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAIntegerTerm
entryRuleAIntegerTerm 
:
{ before(grammarAccess.getAIntegerTermRule()); }
	 ruleAIntegerTerm
{ after(grammarAccess.getAIntegerTermRule()); } 
	 EOF 
;

// Rule AIntegerTerm
ruleAIntegerTerm 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAIntegerTermAccess().getValueAssignment()); }
(rule__AIntegerTerm__ValueAssignment)
{ after(grammarAccess.getAIntegerTermAccess().getValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAInt
entryRuleAInt 
:
{ before(grammarAccess.getAIntRule()); }
	 ruleAInt
{ after(grammarAccess.getAIntRule()); } 
	 EOF 
;

// Rule AInt
ruleAInt 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAIntAccess().getINTTerminalRuleCall()); }
	RULE_INT
{ after(grammarAccess.getAIntAccess().getINTTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleARealTerm
entryRuleARealTerm 
:
{ before(grammarAccess.getARealTermRule()); }
	 ruleARealTerm
{ after(grammarAccess.getARealTermRule()); } 
	 EOF 
;

// Rule ARealTerm
ruleARealTerm 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getARealTermAccess().getValueAssignment()); }
(rule__ARealTerm__ValueAssignment)
{ after(grammarAccess.getARealTermAccess().getValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAReal
entryRuleAReal 
:
{ before(grammarAccess.getARealRule()); }
	 ruleAReal
{ after(grammarAccess.getARealRule()); } 
	 EOF 
;

// Rule AReal
ruleAReal 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getARealAccess().getREAL_LITTerminalRuleCall()); }
	RULE_REAL_LIT
{ after(grammarAccess.getARealAccess().getREAL_LITTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleABooleanLiteral
entryRuleABooleanLiteral 
:
{ before(grammarAccess.getABooleanLiteralRule()); }
	 ruleABooleanLiteral
{ after(grammarAccess.getABooleanLiteralRule()); } 
	 EOF 
;

// Rule ABooleanLiteral
ruleABooleanLiteral 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getABooleanLiteralAccess().getGroup()); }
(rule__ABooleanLiteral__Group__0)
{ after(grammarAccess.getABooleanLiteralAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleStringTerm
entryRuleStringTerm 
:
{ before(grammarAccess.getStringTermRule()); }
	 ruleStringTerm
{ after(grammarAccess.getStringTermRule()); } 
	 EOF 
;

// Rule StringTerm
ruleStringTerm 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getStringTermAccess().getValueAssignment()); }
(rule__StringTerm__ValueAssignment)
{ after(grammarAccess.getStringTermAccess().getValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNoQuoteString
entryRuleNoQuoteString 
:
{ before(grammarAccess.getNoQuoteStringRule()); }
	 ruleNoQuoteString
{ after(grammarAccess.getNoQuoteStringRule()); } 
	 EOF 
;

// Rule NoQuoteString
ruleNoQuoteString 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); }
	RULE_STRING
{ after(grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAParenthesizedExpression
entryRuleAParenthesizedExpression 
:
{ before(grammarAccess.getAParenthesizedExpressionRule()); }
	 ruleAParenthesizedExpression
{ after(grammarAccess.getAParenthesizedExpressionRule()); } 
	 EOF 
;

// Rule AParenthesizedExpression
ruleAParenthesizedExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAParenthesizedExpressionAccess().getGroup()); }
(rule__AParenthesizedExpression__Group__0)
{ after(grammarAccess.getAParenthesizedExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleComponentCategory
entryRuleComponentCategory 
:
{ before(grammarAccess.getComponentCategoryRule()); }
	 ruleComponentCategory
{ after(grammarAccess.getComponentCategoryRule()); } 
	 EOF 
;

// Rule ComponentCategory
ruleComponentCategory 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getComponentCategoryAccess().getAlternatives()); }
(rule__ComponentCategory__Alternatives)
{ after(grammarAccess.getComponentCategoryAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAadlClassifierReference
entryRuleAadlClassifierReference 
:
{ before(grammarAccess.getAadlClassifierReferenceRule()); }
	 ruleAadlClassifierReference
{ after(grammarAccess.getAadlClassifierReferenceRule()); } 
	 EOF 
;

// Rule AadlClassifierReference
ruleAadlClassifierReference 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAadlClassifierReferenceAccess().getGroup()); }
(rule__AadlClassifierReference__Group__0)
{ after(grammarAccess.getAadlClassifierReferenceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAADLPROPERTYREFERENCE
entryRuleAADLPROPERTYREFERENCE 
:
{ before(grammarAccess.getAADLPROPERTYREFERENCERule()); }
	 ruleAADLPROPERTYREFERENCE
{ after(grammarAccess.getAADLPROPERTYREFERENCERule()); } 
	 EOF 
;

// Rule AADLPROPERTYREFERENCE
ruleAADLPROPERTYREFERENCE 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAADLPROPERTYREFERENCEAccess().getGroup()); }
(rule__AADLPROPERTYREFERENCE__Group__0)
{ after(grammarAccess.getAADLPROPERTYREFERENCEAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}





// Entry rule entryRuleQualifiedName
entryRuleQualifiedName 
:
{ before(grammarAccess.getQualifiedNameRule()); }
	 ruleQualifiedName
{ after(grammarAccess.getQualifiedNameRule()); } 
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getQualifiedNameAccess().getGroup()); }
(rule__QualifiedName__Group__0)
{ after(grammarAccess.getQualifiedNameAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleThisKeyword
entryRuleThisKeyword 
:
{ before(grammarAccess.getThisKeywordRule()); }
	 ruleThisKeyword
{ after(grammarAccess.getThisKeywordRule()); } 
	 EOF 
;

// Rule ThisKeyword
ruleThisKeyword 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getThisKeywordAccess().getThisKeyword()); }

	This 

{ after(grammarAccess.getThisKeywordAccess().getThisKeyword()); }
)

;
finally {
	restoreStackSize(stackSize);
}






// Rule TargetType
ruleTargetType
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTargetTypeAccess().getAlternatives()); }
(rule__TargetType__Alternatives)
{ after(grammarAccess.getTargetTypeAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__ReqSpec__PartsAlternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqSpecAccess().getPartsSystemRequirementSetParserRuleCall_0_0()); }
	ruleSystemRequirementSet
{ after(grammarAccess.getReqSpecAccess().getPartsSystemRequirementSetParserRuleCall_0_0()); }
)

    |(
{ before(grammarAccess.getReqSpecAccess().getPartsGlobalRequirementSetParserRuleCall_0_1()); }
	ruleGlobalRequirementSet
{ after(grammarAccess.getReqSpecAccess().getPartsGlobalRequirementSetParserRuleCall_0_1()); }
)

    |(
{ before(grammarAccess.getReqSpecAccess().getPartsStakeholderGoalsParserRuleCall_0_2()); }
	ruleStakeholderGoals
{ after(grammarAccess.getReqSpecAccess().getPartsStakeholderGoalsParserRuleCall_0_2()); }
)

    |(
{ before(grammarAccess.getReqSpecAccess().getPartsReqDocumentParserRuleCall_0_3()); }
	ruleReqDocument
{ after(grammarAccess.getReqSpecAccess().getPartsReqDocumentParserRuleCall_0_3()); }
)

    |(
{ before(grammarAccess.getReqSpecAccess().getPartsGlobalConstantsParserRuleCall_0_4()); }
	ruleGlobalConstants
{ after(grammarAccess.getReqSpecAccess().getPartsGlobalConstantsParserRuleCall_0_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__StakeholderGoals__Alternatives_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getTargetAssignment_4_1_0()); }
(rule__StakeholderGoals__TargetAssignment_4_1_0)
{ after(grammarAccess.getStakeholderGoalsAccess().getTargetAssignment_4_1_0()); }
)

    |(
(
{ before(grammarAccess.getStakeholderGoalsAccess().getComponentCategoryAssignment_4_1_1()); }
(rule__StakeholderGoals__ComponentCategoryAssignment_4_1_1)
{ after(grammarAccess.getStakeholderGoalsAccess().getComponentCategoryAssignment_4_1_1()); }
)
(
{ before(grammarAccess.getStakeholderGoalsAccess().getComponentCategoryAssignment_4_1_1()); }
(rule__StakeholderGoals__ComponentCategoryAssignment_4_1_1)*
{ after(grammarAccess.getStakeholderGoalsAccess().getComponentCategoryAssignment_4_1_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__ContentAlternatives_4_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getContentDocGoalParserRuleCall_4_1_0_0()); }
	ruleDocGoal
{ after(grammarAccess.getReqDocumentAccess().getContentDocGoalParserRuleCall_4_1_0_0()); }
)

    |(
{ before(grammarAccess.getReqDocumentAccess().getContentDocRequirementParserRuleCall_4_1_0_1()); }
	ruleDocRequirement
{ after(grammarAccess.getReqDocumentAccess().getContentDocRequirementParserRuleCall_4_1_0_1()); }
)

    |(
{ before(grammarAccess.getReqDocumentAccess().getContentDocumentSectionParserRuleCall_4_1_0_2()); }
	ruleDocumentSection
{ after(grammarAccess.getReqDocumentAccess().getContentDocumentSectionParserRuleCall_4_1_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getGroup_1_0()); }
(rule__DocumentSection__Group_1_0__0)
{ after(grammarAccess.getDocumentSectionAccess().getGroup_1_0()); }
)

    |(
{ before(grammarAccess.getDocumentSectionAccess().getTitleAssignment_1_1()); }
(rule__DocumentSection__TitleAssignment_1_1)
{ after(grammarAccess.getDocumentSectionAccess().getTitleAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__ContentAlternatives_3_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getContentDocGoalParserRuleCall_3_1_0_0()); }
	ruleDocGoal
{ after(grammarAccess.getDocumentSectionAccess().getContentDocGoalParserRuleCall_3_1_0_0()); }
)

    |(
{ before(grammarAccess.getDocumentSectionAccess().getContentDocRequirementParserRuleCall_3_1_0_1()); }
	ruleDocRequirement
{ after(grammarAccess.getDocumentSectionAccess().getContentDocRequirementParserRuleCall_3_1_0_1()); }
)

    |(
{ before(grammarAccess.getDocumentSectionAccess().getContentDocumentSectionParserRuleCall_3_1_0_2()); }
	ruleDocumentSection
{ after(grammarAccess.getDocumentSectionAccess().getContentDocumentSectionParserRuleCall_3_1_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Alternatives_9
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getDescriptionAssignment_9_0()); }
(rule__SystemRequirementSet__DescriptionAssignment_9_0)
{ after(grammarAccess.getSystemRequirementSetAccess().getDescriptionAssignment_9_0()); }
)

    |(
{ before(grammarAccess.getSystemRequirementSetAccess().getConstantsAssignment_9_1()); }
(rule__SystemRequirementSet__ConstantsAssignment_9_1)
{ after(grammarAccess.getSystemRequirementSetAccess().getConstantsAssignment_9_1()); }
)

    |(
{ before(grammarAccess.getSystemRequirementSetAccess().getComputesAssignment_9_2()); }
(rule__SystemRequirementSet__ComputesAssignment_9_2)
{ after(grammarAccess.getSystemRequirementSetAccess().getComputesAssignment_9_2()); }
)

    |(
{ before(grammarAccess.getSystemRequirementSetAccess().getRequirementsAssignment_9_3()); }
(rule__SystemRequirementSet__RequirementsAssignment_9_3)
{ after(grammarAccess.getSystemRequirementSetAccess().getRequirementsAssignment_9_3()); }
)

    |(
{ before(grammarAccess.getSystemRequirementSetAccess().getIncludeAssignment_9_4()); }
(rule__SystemRequirementSet__IncludeAssignment_9_4)
{ after(grammarAccess.getSystemRequirementSetAccess().getIncludeAssignment_9_4()); }
)

    |(
{ before(grammarAccess.getSystemRequirementSetAccess().getGroup_9_5()); }
(rule__SystemRequirementSet__Group_9_5__0)
{ after(grammarAccess.getSystemRequirementSetAccess().getGroup_9_5()); }
)

    |(
{ before(grammarAccess.getSystemRequirementSetAccess().getGroup_9_6()); }
(rule__SystemRequirementSet__Group_9_6__0)
{ after(grammarAccess.getSystemRequirementSetAccess().getGroup_9_6()); }
)

    |(
{ before(grammarAccess.getSystemRequirementSetAccess().getGroup_9_7()); }
(rule__SystemRequirementSet__Group_9_7__0)
{ after(grammarAccess.getSystemRequirementSetAccess().getGroup_9_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Alternatives_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getDescriptionAssignment_7_0()); }
(rule__GlobalRequirementSet__DescriptionAssignment_7_0)
{ after(grammarAccess.getGlobalRequirementSetAccess().getDescriptionAssignment_7_0()); }
)

    |(
{ before(grammarAccess.getGlobalRequirementSetAccess().getConstantsAssignment_7_1()); }
(rule__GlobalRequirementSet__ConstantsAssignment_7_1)
{ after(grammarAccess.getGlobalRequirementSetAccess().getConstantsAssignment_7_1()); }
)

    |(
{ before(grammarAccess.getGlobalRequirementSetAccess().getComputesAssignment_7_2()); }
(rule__GlobalRequirementSet__ComputesAssignment_7_2)
{ after(grammarAccess.getGlobalRequirementSetAccess().getComputesAssignment_7_2()); }
)

    |(
{ before(grammarAccess.getGlobalRequirementSetAccess().getRequirementsAssignment_7_3()); }
(rule__GlobalRequirementSet__RequirementsAssignment_7_3)
{ after(grammarAccess.getGlobalRequirementSetAccess().getRequirementsAssignment_7_3()); }
)

    |(
{ before(grammarAccess.getGlobalRequirementSetAccess().getGroup_7_4()); }
(rule__GlobalRequirementSet__Group_7_4__0)
{ after(grammarAccess.getGlobalRequirementSetAccess().getGroup_7_4()); }
)

    |(
{ before(grammarAccess.getGlobalRequirementSetAccess().getGroup_7_5()); }
(rule__GlobalRequirementSet__Group_7_5__0)
{ after(grammarAccess.getGlobalRequirementSetAccess().getGroup_7_5()); }
)

    |(
{ before(grammarAccess.getGlobalRequirementSetAccess().getGroup_7_6()); }
(rule__GlobalRequirementSet__Group_7_6__0)
{ after(grammarAccess.getGlobalRequirementSetAccess().getGroup_7_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Alternatives_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getTargetDescriptionAssignment_3_1_0()); }
(rule__DocGoal__TargetDescriptionAssignment_3_1_0)
{ after(grammarAccess.getDocGoalAccess().getTargetDescriptionAssignment_3_1_0()); }
)

    |(
{ before(grammarAccess.getDocGoalAccess().getGroup_3_1_1()); }
(rule__DocGoal__Group_3_1_1__0)
{ after(grammarAccess.getDocGoalAccess().getGroup_3_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Alternatives_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getGroup_5_0()); }
(rule__SystemRequirement__Group_5_0__0)
{ after(grammarAccess.getSystemRequirementAccess().getGroup_5_0()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getDescriptionAssignment_5_1()); }
(rule__SystemRequirement__DescriptionAssignment_5_1)
{ after(grammarAccess.getSystemRequirementAccess().getDescriptionAssignment_5_1()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getWhenconditionAssignment_5_2()); }
(rule__SystemRequirement__WhenconditionAssignment_5_2)
{ after(grammarAccess.getSystemRequirementAccess().getWhenconditionAssignment_5_2()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getPredicateAssignment_5_3()); }
(rule__SystemRequirement__PredicateAssignment_5_3)
{ after(grammarAccess.getSystemRequirementAccess().getPredicateAssignment_5_3()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getRationaleAssignment_5_4()); }
(rule__SystemRequirement__RationaleAssignment_5_4)
{ after(grammarAccess.getSystemRequirementAccess().getRationaleAssignment_5_4()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getChangeUncertaintyAssignment_5_5()); }
(rule__SystemRequirement__ChangeUncertaintyAssignment_5_5)
{ after(grammarAccess.getSystemRequirementAccess().getChangeUncertaintyAssignment_5_5()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getGroup_5_6()); }
(rule__SystemRequirement__Group_5_6__0)
{ after(grammarAccess.getSystemRequirementAccess().getGroup_5_6()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getGroup_5_7()); }
(rule__SystemRequirement__Group_5_7__0)
{ after(grammarAccess.getSystemRequirementAccess().getGroup_5_7()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getGroup_5_8()); }
(rule__SystemRequirement__Group_5_8__0)
{ after(grammarAccess.getSystemRequirementAccess().getGroup_5_8()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getConstantsAssignment_5_9()); }
(rule__SystemRequirement__ConstantsAssignment_5_9)
{ after(grammarAccess.getSystemRequirementAccess().getConstantsAssignment_5_9()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getComputesAssignment_5_10()); }
(rule__SystemRequirement__ComputesAssignment_5_10)
{ after(grammarAccess.getSystemRequirementAccess().getComputesAssignment_5_10()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getGroup_5_11()); }
(rule__SystemRequirement__Group_5_11__0)
{ after(grammarAccess.getSystemRequirementAccess().getGroup_5_11()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getGroup_5_12()); }
(rule__SystemRequirement__Group_5_12__0)
{ after(grammarAccess.getSystemRequirementAccess().getGroup_5_12()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getGroup_5_13()); }
(rule__SystemRequirement__Group_5_13__0)
{ after(grammarAccess.getSystemRequirementAccess().getGroup_5_13()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getGroup_5_14()); }
(rule__SystemRequirement__Group_5_14__0)
{ after(grammarAccess.getSystemRequirementAccess().getGroup_5_14()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getGroup_5_15()); }
(rule__SystemRequirement__Group_5_15__0)
{ after(grammarAccess.getSystemRequirementAccess().getGroup_5_15()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getGroup_5_16()); }
(rule__SystemRequirement__Group_5_16__0)
{ after(grammarAccess.getSystemRequirementAccess().getGroup_5_16()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getGroup_5_17()); }
(rule__SystemRequirement__Group_5_17__0)
{ after(grammarAccess.getSystemRequirementAccess().getGroup_5_17()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getGroup_5_18()); }
(rule__SystemRequirement__Group_5_18__0)
{ after(grammarAccess.getSystemRequirementAccess().getGroup_5_18()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Alternatives_5_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getExceptionAssignment_5_6_1_0()); }
(rule__SystemRequirement__ExceptionAssignment_5_6_1_0)
{ after(grammarAccess.getSystemRequirementAccess().getExceptionAssignment_5_6_1_0()); }
)

    |(
{ before(grammarAccess.getSystemRequirementAccess().getExceptionTextAssignment_5_6_1_1()); }
(rule__SystemRequirement__ExceptionTextAssignment_5_6_1_1)
{ after(grammarAccess.getSystemRequirementAccess().getExceptionTextAssignment_5_6_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Alternatives_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGlobalRequirementAccess().getComponentCategoryAssignment_3_1_0()); }
(rule__GlobalRequirement__ComponentCategoryAssignment_3_1_0)
{ after(grammarAccess.getGlobalRequirementAccess().getComponentCategoryAssignment_3_1_0()); }
)
(
{ before(grammarAccess.getGlobalRequirementAccess().getComponentCategoryAssignment_3_1_0()); }
(rule__GlobalRequirement__ComponentCategoryAssignment_3_1_0)*
{ after(grammarAccess.getGlobalRequirementAccess().getComponentCategoryAssignment_3_1_0()); }
)
)

    |(
{ before(grammarAccess.getGlobalRequirementAccess().getTargetTypeAssignment_3_1_1()); }
(rule__GlobalRequirement__TargetTypeAssignment_3_1_1)
{ after(grammarAccess.getGlobalRequirementAccess().getTargetTypeAssignment_3_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Alternatives_5_8_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getExceptionAssignment_5_8_1_0()); }
(rule__GlobalRequirement__ExceptionAssignment_5_8_1_0)
{ after(grammarAccess.getGlobalRequirementAccess().getExceptionAssignment_5_8_1_0()); }
)

    |(
{ before(grammarAccess.getGlobalRequirementAccess().getExceptionTextAssignment_5_8_1_1()); }
(rule__GlobalRequirement__ExceptionTextAssignment_5_8_1_1)
{ after(grammarAccess.getGlobalRequirementAccess().getExceptionTextAssignment_5_8_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Alternatives_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getTargetDescriptionAssignment_3_1_0()); }
(rule__DocRequirement__TargetDescriptionAssignment_3_1_0)
{ after(grammarAccess.getDocRequirementAccess().getTargetDescriptionAssignment_3_1_0()); }
)

    |(
{ before(grammarAccess.getDocRequirementAccess().getGroup_3_1_1()); }
(rule__DocRequirement__Group_3_1_1__0)
{ after(grammarAccess.getDocRequirementAccess().getGroup_3_1_1()); }
)

    |(
(
{ before(grammarAccess.getDocRequirementAccess().getComponentCategoryAssignment_3_1_2()); }
(rule__DocRequirement__ComponentCategoryAssignment_3_1_2)
{ after(grammarAccess.getDocRequirementAccess().getComponentCategoryAssignment_3_1_2()); }
)
(
{ before(grammarAccess.getDocRequirementAccess().getComponentCategoryAssignment_3_1_2()); }
(rule__DocRequirement__ComponentCategoryAssignment_3_1_2)*
{ after(grammarAccess.getDocRequirementAccess().getComponentCategoryAssignment_3_1_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Alternatives_5_8_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getExceptionAssignment_5_8_1_0()); }
(rule__DocRequirement__ExceptionAssignment_5_8_1_0)
{ after(grammarAccess.getDocRequirementAccess().getExceptionAssignment_5_8_1_0()); }
)

    |(
{ before(grammarAccess.getDocRequirementAccess().getExceptionTextAssignment_5_8_1_1()); }
(rule__DocRequirement__ExceptionTextAssignment_5_8_1_1)
{ after(grammarAccess.getDocRequirementAccess().getExceptionTextAssignment_5_8_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IncludeGlobalRequirement__Alternatives_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIncludeGlobalRequirementAccess().getLocalAssignment_2_1_0()); }
(rule__IncludeGlobalRequirement__LocalAssignment_2_1_0)
{ after(grammarAccess.getIncludeGlobalRequirementAccess().getLocalAssignment_2_1_0()); }
)

    |(
{ before(grammarAccess.getIncludeGlobalRequirementAccess().getTargetElementAssignment_2_1_1()); }
(rule__IncludeGlobalRequirement__TargetElementAssignment_2_1_1)
{ after(grammarAccess.getIncludeGlobalRequirementAccess().getTargetElementAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getGroup_1_0()); }
(rule__WhenCondition__Group_1_0__0)
{ after(grammarAccess.getWhenConditionAccess().getGroup_1_0()); }
)

    |(
{ before(grammarAccess.getWhenConditionAccess().getGroup_1_1()); }
(rule__WhenCondition__Group_1_1__0)
{ after(grammarAccess.getWhenConditionAccess().getGroup_1_1()); }
)

    |(
{ before(grammarAccess.getWhenConditionAccess().getGroup_1_2()); }
(rule__WhenCondition__Group_1_2__0)
{ after(grammarAccess.getWhenConditionAccess().getGroup_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReqPredicate__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqPredicateAccess().getInformalPredicateParserRuleCall_0()); }
	ruleInformalPredicate
{ after(grammarAccess.getReqPredicateAccess().getInformalPredicateParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getReqPredicateAccess().getValuePredicateParserRuleCall_1()); }
	ruleValuePredicate
{ after(grammarAccess.getReqPredicateAccess().getValuePredicateParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DesiredValue__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDesiredValueAccess().getUptoAssignment_1_0()); }
(rule__DesiredValue__UptoAssignment_1_0)
{ after(grammarAccess.getDesiredValueAccess().getUptoAssignment_1_0()); }
)

    |(
{ before(grammarAccess.getDesiredValueAccess().getDowntoKeyword_1_1()); }

	Downto 

{ after(grammarAccess.getDesiredValueAccess().getDowntoKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Alternatives_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_0()); }
(rule__ValDeclaration__TypeAssignment_3_1_0)
{ after(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_0()); }
)

    |(
{ before(grammarAccess.getValDeclarationAccess().getGroup_3_1_1()); }
(rule__ValDeclaration__Group_3_1_1__0)
{ after(grammarAccess.getValDeclarationAccess().getGroup_3_1_1()); }
)

    |(
{ before(grammarAccess.getValDeclarationAccess().getGroup_3_1_2()); }
(rule__ValDeclaration__Group_3_1_2__0)
{ after(grammarAccess.getValDeclarationAccess().getGroup_3_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Alternatives_3_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_2_1_0()); }
(rule__ValDeclaration__TypeAssignment_3_1_2_1_0)
{ after(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_2_1_0()); }
)

    |(
{ before(grammarAccess.getValDeclarationAccess().getGroup_3_1_2_1_1()); }
(rule__ValDeclaration__Group_3_1_2_1_1__0)
{ after(grammarAccess.getValDeclarationAccess().getGroup_3_1_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionElement__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); }
(rule__DescriptionElement__TextAssignment_0)
{ after(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); }
)

    |(
{ before(grammarAccess.getDescriptionElementAccess().getThisTargetAssignment_1()); }
(rule__DescriptionElement__ThisTargetAssignment_1)
{ after(grammarAccess.getDescriptionElementAccess().getThisTargetAssignment_1()); }
)

    |(
{ before(grammarAccess.getDescriptionElementAccess().getImageAssignment_2()); }
(rule__DescriptionElement__ImageAssignment_2)
{ after(grammarAccess.getDescriptionElementAccess().getImageAssignment_2()); }
)

    |(
{ before(grammarAccess.getDescriptionElementAccess().getShowValueAssignment_3()); }
(rule__DescriptionElement__ShowValueAssignment_3)
{ after(grammarAccess.getDescriptionElementAccess().getShowValueAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getGroup_0()); }
(rule__TypeRef__Group_0__0)
{ after(grammarAccess.getTypeRefAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getTypeRefAccess().getGroup_1()); }
(rule__TypeRef__Group_1__0)
{ after(grammarAccess.getTypeRefAccess().getGroup_1()); }
)

    |(
{ before(grammarAccess.getTypeRefAccess().getGroup_2()); }
(rule__TypeRef__Group_2__0)
{ after(grammarAccess.getTypeRefAccess().getGroup_2()); }
)

    |(
{ before(grammarAccess.getTypeRefAccess().getGroup_3()); }
(rule__TypeRef__Group_3__0)
{ after(grammarAccess.getTypeRefAccess().getGroup_3()); }
)

    |(
{ before(grammarAccess.getTypeRefAccess().getGroup_4()); }
(rule__TypeRef__Group_4__0)
{ after(grammarAccess.getTypeRefAccess().getGroup_4()); }
)

    |(
{ before(grammarAccess.getTypeRefAccess().getGroup_5()); }
(rule__TypeRef__Group_5__0)
{ after(grammarAccess.getTypeRefAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__Alternatives_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_0()); }
(rule__ComputeDeclaration__TypeAssignment_4_0)
{ after(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_0()); }
)

    |(
{ before(grammarAccess.getComputeDeclarationAccess().getGroup_4_1()); }
(rule__ComputeDeclaration__Group_4_1__0)
{ after(grammarAccess.getComputeDeclarationAccess().getGroup_4_1()); }
)

    |(
{ before(grammarAccess.getComputeDeclarationAccess().getGroup_4_2()); }
(rule__ComputeDeclaration__Group_4_2__0)
{ after(grammarAccess.getComputeDeclarationAccess().getGroup_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__Alternatives_4_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_2_1_0()); }
(rule__ComputeDeclaration__TypeAssignment_4_2_1_0)
{ after(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_2_1_0()); }
)

    |(
{ before(grammarAccess.getComputeDeclarationAccess().getGroup_4_2_1_1()); }
(rule__ComputeDeclaration__Group_4_2_1_1__0)
{ after(grammarAccess.getComputeDeclarationAccess().getGroup_4_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0()); }
(rule__AModelOrPropertyReference__Group_0__0)
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceParserRuleCall_1()); }
	ruleAPropertyReference
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__Alternatives_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getConvertAssignment_1_0_0()); }
(rule__ShowValue__ConvertAssignment_1_0_0)
{ after(grammarAccess.getShowValueAccess().getConvertAssignment_1_0_0()); }
)

    |(
{ before(grammarAccess.getShowValueAccess().getDropAssignment_1_0_1()); }
(rule__ShowValue__DropAssignment_1_0_1)
{ after(grammarAccess.getShowValueAccess().getDropAssignment_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OpOr__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOpOrAccess().getOrKeyword_0()); }

	Or 

{ after(grammarAccess.getOpOrAccess().getOrKeyword_0()); }
)

    |(
{ before(grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword_1()); }

	VerticalLineVerticalLine 

{ after(grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OpAnd__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOpAndAccess().getAndKeyword_0()); }

	And 

{ after(grammarAccess.getOpAndAccess().getAndKeyword_0()); }
)

    |(
{ before(grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword_1()); }

	AmpersandAmpersand 

{ after(grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OpEquality__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); }

	EqualsSignEqualsSign 

{ after(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); }
)

    |(
{ before(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); }

	ExclamationMarkEqualsSign 

{ after(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OpCompare__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); }

	GreaterThanSignEqualsSign 

{ after(grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); }
)

    |(
{ before(grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); }

	LessThanSignEqualsSign 

{ after(grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); }
)

    |(
{ before(grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); }

	GreaterThanSign 

{ after(grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); }
)

    |(
{ before(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); }

	LessThanSign 

{ after(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); }
)

    |(
{ before(grammarAccess.getOpCompareAccess().getGreaterThanSignLessThanSignKeyword_4()); }

	GreaterThanSignLessThanSign 

{ after(grammarAccess.getOpCompareAccess().getGreaterThanSignLessThanSignKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OpAdd__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); }

	PlusSign 

{ after(grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); }
)

    |(
{ before(grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); }

	HyphenMinus 

{ after(grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OpMulti__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); }

	Asterisk 

{ after(grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); }
)

    |(
{ before(grammarAccess.getOpMultiAccess().getSolidusKeyword_1()); }

	Solidus 

{ after(grammarAccess.getOpMultiAccess().getSolidusKeyword_1()); }
)

    |(
{ before(grammarAccess.getOpMultiAccess().getDivKeyword_2()); }

	Div 

{ after(grammarAccess.getOpMultiAccess().getDivKeyword_2()); }
)

    |(
{ before(grammarAccess.getOpMultiAccess().getModKeyword_3()); }

	Mod 

{ after(grammarAccess.getOpMultiAccess().getModKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AUnaryOperation__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnaryOperationAccess().getGroup_0()); }
(rule__AUnaryOperation__Group_0__0)
{ after(grammarAccess.getAUnaryOperationAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getAUnaryOperationAccess().getAUnitExpressionParserRuleCall_1()); }
	ruleAUnitExpression
{ after(grammarAccess.getAUnaryOperationAccess().getAUnitExpressionParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OpUnary__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOpUnaryAccess().getNotKeyword_0()); }

	Not 

{ after(grammarAccess.getOpUnaryAccess().getNotKeyword_0()); }
)

    |(
{ before(grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); }

	HyphenMinus 

{ after(grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); }
)

    |(
{ before(grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); }

	PlusSign 

{ after(grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__Alternatives_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getConvertAssignment_1_1_0()); }
(rule__AUnitExpression__ConvertAssignment_1_1_0)
{ after(grammarAccess.getAUnitExpressionAccess().getConvertAssignment_1_1_0()); }
)

    |(
{ before(grammarAccess.getAUnitExpressionAccess().getDropAssignment_1_1_1()); }
(rule__AUnitExpression__DropAssignment_1_1_1)
{ after(grammarAccess.getAUnitExpressionAccess().getDropAssignment_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__APrimaryExpression__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAPrimaryExpressionAccess().getALiteralParserRuleCall_0()); }
	ruleALiteral
{ after(grammarAccess.getAPrimaryExpressionAccess().getALiteralParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getAPrimaryExpressionAccess().getAVariableReferenceParserRuleCall_1()); }
	ruleAVariableReference
{ after(grammarAccess.getAPrimaryExpressionAccess().getAVariableReferenceParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getAPrimaryExpressionAccess().getAModelOrPropertyReferenceParserRuleCall_2()); }
	ruleAModelOrPropertyReference
{ after(grammarAccess.getAPrimaryExpressionAccess().getAModelOrPropertyReferenceParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getAPrimaryExpressionAccess().getAFunctionCallParserRuleCall_3()); }
	ruleAFunctionCall
{ after(grammarAccess.getAPrimaryExpressionAccess().getAFunctionCallParserRuleCall_3()); }
)

    |(
{ before(grammarAccess.getAPrimaryExpressionAccess().getARangeExpressionParserRuleCall_4()); }
	ruleARangeExpression
{ after(grammarAccess.getAPrimaryExpressionAccess().getARangeExpressionParserRuleCall_4()); }
)

    |(
{ before(grammarAccess.getAPrimaryExpressionAccess().getAIfExpressionParserRuleCall_5()); }
	ruleAIfExpression
{ after(grammarAccess.getAPrimaryExpressionAccess().getAIfExpressionParserRuleCall_5()); }
)

    |(
{ before(grammarAccess.getAPrimaryExpressionAccess().getAParenthesizedExpressionParserRuleCall_6()); }
	ruleAParenthesizedExpression
{ after(grammarAccess.getAPrimaryExpressionAccess().getAParenthesizedExpressionParserRuleCall_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ALiteral__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getALiteralAccess().getABooleanLiteralParserRuleCall_0()); }
	ruleABooleanLiteral
{ after(grammarAccess.getALiteralAccess().getABooleanLiteralParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getALiteralAccess().getARealTermParserRuleCall_1()); }
	ruleARealTerm
{ after(grammarAccess.getALiteralAccess().getARealTermParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getALiteralAccess().getAIntegerTermParserRuleCall_2()); }
	ruleAIntegerTerm
{ after(grammarAccess.getALiteralAccess().getAIntegerTermParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getALiteralAccess().getStringTermParserRuleCall_3()); }
	ruleStringTerm
{ after(grammarAccess.getALiteralAccess().getStringTermParserRuleCall_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ABooleanLiteral__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getABooleanLiteralAccess().getValueAssignment_1_0()); }
(rule__ABooleanLiteral__ValueAssignment_1_0)
{ after(grammarAccess.getABooleanLiteralAccess().getValueAssignment_1_0()); }
)

    |(
{ before(grammarAccess.getABooleanLiteralAccess().getFalseKeyword_1_1()); }

	False 

{ after(grammarAccess.getABooleanLiteralAccess().getFalseKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentCategory__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); }

	Abstract 

{ after(grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); }

	Bus 

{ after(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); }

	Data 

{ after(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); }

	Device 

{ after(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); }

	Memory 

{ after(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); }

	Process 

{ after(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); }

	Processor 

{ after(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); }

	Subprogram 

{ after(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getGroup_8()); }
(rule__ComponentCategory__Group_8__0)
{ after(grammarAccess.getComponentCategoryAccess().getGroup_8()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); }

	KW_System 

{ after(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getGroup_10()); }
(rule__ComponentCategory__Group_10__0)
{ after(grammarAccess.getComponentCategoryAccess().getGroup_10()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); }

	Thread 

{ after(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getGroup_12()); }
(rule__ComponentCategory__Group_12__0)
{ after(grammarAccess.getComponentCategoryAccess().getGroup_12()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getGroup_13()); }
(rule__ComponentCategory__Group_13__0)
{ after(grammarAccess.getComponentCategoryAccess().getGroup_13()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TargetType__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTargetTypeAccess().getCOMPONENTEnumLiteralDeclaration_0()); }
(	Component
)
{ after(grammarAccess.getTargetTypeAccess().getCOMPONENTEnumLiteralDeclaration_0()); }
)

    |(
{ before(grammarAccess.getTargetTypeAccess().getFEATUREEnumLiteralDeclaration_1()); }
(	Feature
)
{ after(grammarAccess.getTargetTypeAccess().getFEATUREEnumLiteralDeclaration_1()); }
)

    |(
{ before(grammarAccess.getTargetTypeAccess().getCONNECTIONEnumLiteralDeclaration_2()); }
(	Connection
)
{ after(grammarAccess.getTargetTypeAccess().getCONNECTIONEnumLiteralDeclaration_2()); }
)

    |(
{ before(grammarAccess.getTargetTypeAccess().getFLOWEnumLiteralDeclaration_3()); }
(	Flow
)
{ after(grammarAccess.getTargetTypeAccess().getFLOWEnumLiteralDeclaration_3()); }
)

    |(
{ before(grammarAccess.getTargetTypeAccess().getMODEEnumLiteralDeclaration_4()); }
(	Mode
)
{ after(grammarAccess.getTargetTypeAccess().getMODEEnumLiteralDeclaration_4()); }
)

    |(
{ before(grammarAccess.getTargetTypeAccess().getELEMENTEnumLiteralDeclaration_5()); }
(	Element
)
{ after(grammarAccess.getTargetTypeAccess().getELEMENTEnumLiteralDeclaration_5()); }
)

    |(
{ before(grammarAccess.getTargetTypeAccess().getROOTEnumLiteralDeclaration_6()); }
(	Root
)
{ after(grammarAccess.getTargetTypeAccess().getROOTEnumLiteralDeclaration_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__GlobalConstants__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalConstants__Group__0__Impl
	rule__GlobalConstants__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalConstants__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalConstantsAccess().getConstantsKeyword_0()); }

	Constants 

{ after(grammarAccess.getGlobalConstantsAccess().getConstantsKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalConstants__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalConstants__Group__1__Impl
	rule__GlobalConstants__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalConstants__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalConstantsAccess().getNameAssignment_1()); }
(rule__GlobalConstants__NameAssignment_1)
{ after(grammarAccess.getGlobalConstantsAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalConstants__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalConstants__Group__2__Impl
	rule__GlobalConstants__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalConstants__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalConstantsAccess().getLeftSquareBracketKeyword_2()); }

	LeftSquareBracket 

{ after(grammarAccess.getGlobalConstantsAccess().getLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalConstants__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalConstants__Group__3__Impl
	rule__GlobalConstants__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalConstants__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalConstantsAccess().getConstantsAssignment_3()); }
(rule__GlobalConstants__ConstantsAssignment_3)*
{ after(grammarAccess.getGlobalConstantsAccess().getConstantsAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalConstants__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalConstants__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalConstants__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalConstantsAccess().getRightSquareBracketKeyword_4()); }

	RightSquareBracket 

{ after(grammarAccess.getGlobalConstantsAccess().getRightSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__StakeholderGoals__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group__0__Impl
	rule__StakeholderGoals__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getStakeholderKeyword_0()); }

	Stakeholder 

{ after(grammarAccess.getStakeholderGoalsAccess().getStakeholderKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group__1__Impl
	rule__StakeholderGoals__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getGoalsKeyword_1()); }

	Goals 

{ after(grammarAccess.getStakeholderGoalsAccess().getGoalsKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group__2__Impl
	rule__StakeholderGoals__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getNameAssignment_2()); }
(rule__StakeholderGoals__NameAssignment_2)
{ after(grammarAccess.getStakeholderGoalsAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group__3__Impl
	rule__StakeholderGoals__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getGroup_3()); }
(rule__StakeholderGoals__Group_3__0)?
{ after(grammarAccess.getStakeholderGoalsAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group__4__Impl
	rule__StakeholderGoals__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getGroup_4()); }
(rule__StakeholderGoals__Group_4__0)
{ after(grammarAccess.getStakeholderGoalsAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group__5__Impl
	rule__StakeholderGoals__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getGroup_5()); }
(rule__StakeholderGoals__Group_5__0)?
{ after(grammarAccess.getStakeholderGoalsAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group__6__Impl
	rule__StakeholderGoals__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getLeftSquareBracketKeyword_6()); }

	LeftSquareBracket 

{ after(grammarAccess.getStakeholderGoalsAccess().getLeftSquareBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group__7__Impl
	rule__StakeholderGoals__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7()); }
(rule__StakeholderGoals__UnorderedGroup_7)
{ after(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getRightSquareBracketKeyword_8()); }

	RightSquareBracket 

{ after(grammarAccess.getStakeholderGoalsAccess().getRightSquareBracketKeyword_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}




















rule__StakeholderGoals__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group_3__0__Impl
	rule__StakeholderGoals__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getColonKeyword_3_0()); }

	Colon 

{ after(grammarAccess.getStakeholderGoalsAccess().getColonKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getTitleAssignment_3_1()); }
(rule__StakeholderGoals__TitleAssignment_3_1)
{ after(grammarAccess.getStakeholderGoalsAccess().getTitleAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__StakeholderGoals__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group_4__0__Impl
	rule__StakeholderGoals__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getForKeyword_4_0()); }

	For 

{ after(grammarAccess.getStakeholderGoalsAccess().getForKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getAlternatives_4_1()); }
(rule__StakeholderGoals__Alternatives_4_1)
{ after(grammarAccess.getStakeholderGoalsAccess().getAlternatives_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__StakeholderGoals__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group_5__0__Impl
	rule__StakeholderGoals__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getUseKeyword_5_0()); }

	Use 

{ after(grammarAccess.getStakeholderGoalsAccess().getUseKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group_5__1__Impl
	rule__StakeholderGoals__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getConstantsKeyword_5_1()); }

	Constants 

{ after(grammarAccess.getStakeholderGoalsAccess().getConstantsKeyword_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getStakeholderGoalsAccess().getImportConstantsAssignment_5_2()); }
(rule__StakeholderGoals__ImportConstantsAssignment_5_2)
{ after(grammarAccess.getStakeholderGoalsAccess().getImportConstantsAssignment_5_2()); }
)
(
{ before(grammarAccess.getStakeholderGoalsAccess().getImportConstantsAssignment_5_2()); }
(rule__StakeholderGoals__ImportConstantsAssignment_5_2)*
{ after(grammarAccess.getStakeholderGoalsAccess().getImportConstantsAssignment_5_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__StakeholderGoals__Group_7_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group_7_3__0__Impl
	rule__StakeholderGoals__Group_7_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group_7_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getSeeKeyword_7_3_0()); }

	See 

{ after(grammarAccess.getStakeholderGoalsAccess().getSeeKeyword_7_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__Group_7_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group_7_3__1__Impl
	rule__StakeholderGoals__Group_7_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group_7_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getDocumentKeyword_7_3_1()); }

	Document 

{ after(grammarAccess.getStakeholderGoalsAccess().getDocumentKeyword_7_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__Group_7_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group_7_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group_7_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getStakeholderGoalsAccess().getDocReferenceAssignment_7_3_2()); }
(rule__StakeholderGoals__DocReferenceAssignment_7_3_2)
{ after(grammarAccess.getStakeholderGoalsAccess().getDocReferenceAssignment_7_3_2()); }
)
(
{ before(grammarAccess.getStakeholderGoalsAccess().getDocReferenceAssignment_7_3_2()); }
(rule__StakeholderGoals__DocReferenceAssignment_7_3_2)*
{ after(grammarAccess.getStakeholderGoalsAccess().getDocReferenceAssignment_7_3_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__StakeholderGoals__Group_7_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group_7_4__0__Impl
	rule__StakeholderGoals__Group_7_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group_7_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getIssuesKeyword_7_4_0()); }

	Issues 

{ after(grammarAccess.getStakeholderGoalsAccess().getIssuesKeyword_7_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__Group_7_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__Group_7_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__Group_7_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getStakeholderGoalsAccess().getIssuesAssignment_7_4_1()); }
(rule__StakeholderGoals__IssuesAssignment_7_4_1)
{ after(grammarAccess.getStakeholderGoalsAccess().getIssuesAssignment_7_4_1()); }
)
(
{ before(grammarAccess.getStakeholderGoalsAccess().getIssuesAssignment_7_4_1()); }
(rule__StakeholderGoals__IssuesAssignment_7_4_1)*
{ after(grammarAccess.getStakeholderGoalsAccess().getIssuesAssignment_7_4_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReqDocument__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__Group__0__Impl
	rule__ReqDocument__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getDocumentKeyword_0()); }

	Document 

{ after(grammarAccess.getReqDocumentAccess().getDocumentKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReqDocument__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__Group__1__Impl
	rule__ReqDocument__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getNameAssignment_1()); }
(rule__ReqDocument__NameAssignment_1)
{ after(grammarAccess.getReqDocumentAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReqDocument__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__Group__2__Impl
	rule__ReqDocument__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getGroup_2()); }
(rule__ReqDocument__Group_2__0)?
{ after(grammarAccess.getReqDocumentAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReqDocument__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__Group__3__Impl
	rule__ReqDocument__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getLeftSquareBracketKeyword_3()); }

	LeftSquareBracket 

{ after(grammarAccess.getReqDocumentAccess().getLeftSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReqDocument__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__Group__4__Impl
	rule__ReqDocument__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4()); }
(rule__ReqDocument__UnorderedGroup_4)
{ after(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReqDocument__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getRightSquareBracketKeyword_5()); }

	RightSquareBracket 

{ after(grammarAccess.getReqDocumentAccess().getRightSquareBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__ReqDocument__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__Group_2__0__Impl
	rule__ReqDocument__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getColonKeyword_2_0()); }

	Colon 

{ after(grammarAccess.getReqDocumentAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReqDocument__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getTitleAssignment_2_1()); }
(rule__ReqDocument__TitleAssignment_2_1)
{ after(grammarAccess.getReqDocumentAccess().getTitleAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReqDocument__Group_4_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__Group_4_2__0__Impl
	rule__ReqDocument__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__Group_4_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getSeeKeyword_4_2_0()); }

	See 

{ after(grammarAccess.getReqDocumentAccess().getSeeKeyword_4_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReqDocument__Group_4_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__Group_4_2__1__Impl
	rule__ReqDocument__Group_4_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__Group_4_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getDocumentKeyword_4_2_1()); }

	Document 

{ after(grammarAccess.getReqDocumentAccess().getDocumentKeyword_4_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReqDocument__Group_4_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__Group_4_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__Group_4_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getReqDocumentAccess().getDocReferenceAssignment_4_2_2()); }
(rule__ReqDocument__DocReferenceAssignment_4_2_2)
{ after(grammarAccess.getReqDocumentAccess().getDocReferenceAssignment_4_2_2()); }
)
(
{ before(grammarAccess.getReqDocumentAccess().getDocReferenceAssignment_4_2_2()); }
(rule__ReqDocument__DocReferenceAssignment_4_2_2)*
{ after(grammarAccess.getReqDocumentAccess().getDocReferenceAssignment_4_2_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ReqDocument__Group_4_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__Group_4_3__0__Impl
	rule__ReqDocument__Group_4_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__Group_4_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getIssuesKeyword_4_3_0()); }

	Issues 

{ after(grammarAccess.getReqDocumentAccess().getIssuesKeyword_4_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReqDocument__Group_4_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__Group_4_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__Group_4_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getReqDocumentAccess().getIssuesAssignment_4_3_1()); }
(rule__ReqDocument__IssuesAssignment_4_3_1)
{ after(grammarAccess.getReqDocumentAccess().getIssuesAssignment_4_3_1()); }
)
(
{ before(grammarAccess.getReqDocumentAccess().getIssuesAssignment_4_3_1()); }
(rule__ReqDocument__IssuesAssignment_4_3_1)*
{ after(grammarAccess.getReqDocumentAccess().getIssuesAssignment_4_3_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocumentSection__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentSection__Group__0__Impl
	rule__DocumentSection__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getSectionKeyword_0()); }

	Section 

{ after(grammarAccess.getDocumentSectionAccess().getSectionKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentSection__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentSection__Group__1__Impl
	rule__DocumentSection__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getAlternatives_1()); }
(rule__DocumentSection__Alternatives_1)
{ after(grammarAccess.getDocumentSectionAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentSection__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentSection__Group__2__Impl
	rule__DocumentSection__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getLeftSquareBracketKeyword_2()); }

	LeftSquareBracket 

{ after(grammarAccess.getDocumentSectionAccess().getLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentSection__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentSection__Group__3__Impl
	rule__DocumentSection__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3()); }
(rule__DocumentSection__UnorderedGroup_3)
{ after(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentSection__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentSection__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getRightSquareBracketKeyword_4()); }

	RightSquareBracket 

{ after(grammarAccess.getDocumentSectionAccess().getRightSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__DocumentSection__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentSection__Group_1_0__0__Impl
	rule__DocumentSection__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getLabelAssignment_1_0_0()); }
(rule__DocumentSection__LabelAssignment_1_0_0)
{ after(grammarAccess.getDocumentSectionAccess().getLabelAssignment_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentSection__Group_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentSection__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__Group_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getGroup_1_0_1()); }
(rule__DocumentSection__Group_1_0_1__0)?
{ after(grammarAccess.getDocumentSectionAccess().getGroup_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocumentSection__Group_1_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentSection__Group_1_0_1__0__Impl
	rule__DocumentSection__Group_1_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__Group_1_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getColonKeyword_1_0_1_0()); }

	Colon 

{ after(grammarAccess.getDocumentSectionAccess().getColonKeyword_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentSection__Group_1_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentSection__Group_1_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__Group_1_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getTitleAssignment_1_0_1_1()); }
(rule__DocumentSection__TitleAssignment_1_0_1_1)
{ after(grammarAccess.getDocumentSectionAccess().getTitleAssignment_1_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SystemRequirementSet__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group__0__Impl
	rule__SystemRequirementSet__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getSystemRequirementSetAction_0()); }
(

)
{ after(grammarAccess.getSystemRequirementSetAccess().getSystemRequirementSetAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group__1__Impl
	rule__SystemRequirementSet__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getSystemKeyword_1()); }

	KW_System 

{ after(grammarAccess.getSystemRequirementSetAccess().getSystemKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group__2__Impl
	rule__SystemRequirementSet__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getRequirementsKeyword_2()); }

	Requirements 

{ after(grammarAccess.getSystemRequirementSetAccess().getRequirementsKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group__3__Impl
	rule__SystemRequirementSet__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getNameAssignment_3()); }
(rule__SystemRequirementSet__NameAssignment_3)
{ after(grammarAccess.getSystemRequirementSetAccess().getNameAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group__4__Impl
	rule__SystemRequirementSet__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getGroup_4()); }
(rule__SystemRequirementSet__Group_4__0)?
{ after(grammarAccess.getSystemRequirementSetAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group__5__Impl
	rule__SystemRequirementSet__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getForKeyword_5()); }

	For 

{ after(grammarAccess.getSystemRequirementSetAccess().getForKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group__6__Impl
	rule__SystemRequirementSet__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getTargetAssignment_6()); }
(rule__SystemRequirementSet__TargetAssignment_6)
{ after(grammarAccess.getSystemRequirementSetAccess().getTargetAssignment_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group__7__Impl
	rule__SystemRequirementSet__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getGroup_7()); }
(rule__SystemRequirementSet__Group_7__0)?
{ after(grammarAccess.getSystemRequirementSetAccess().getGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group__8__Impl
	rule__SystemRequirementSet__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getLeftSquareBracketKeyword_8()); }

	LeftSquareBracket 

{ after(grammarAccess.getSystemRequirementSetAccess().getLeftSquareBracketKeyword_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group__9__Impl
	rule__SystemRequirementSet__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getAlternatives_9()); }
(rule__SystemRequirementSet__Alternatives_9)*
{ after(grammarAccess.getSystemRequirementSetAccess().getAlternatives_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group__10__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getRightSquareBracketKeyword_10()); }

	RightSquareBracket 

{ after(grammarAccess.getSystemRequirementSetAccess().getRightSquareBracketKeyword_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}
























rule__SystemRequirementSet__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group_4__0__Impl
	rule__SystemRequirementSet__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getColonKeyword_4_0()); }

	Colon 

{ after(grammarAccess.getSystemRequirementSetAccess().getColonKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getTitleAssignment_4_1()); }
(rule__SystemRequirementSet__TitleAssignment_4_1)
{ after(grammarAccess.getSystemRequirementSetAccess().getTitleAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SystemRequirementSet__Group_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group_7__0__Impl
	rule__SystemRequirementSet__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getUseKeyword_7_0()); }

	Use 

{ after(grammarAccess.getSystemRequirementSetAccess().getUseKeyword_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group_7__1__Impl
	rule__SystemRequirementSet__Group_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getConstantsKeyword_7_1()); }

	Constants 

{ after(grammarAccess.getSystemRequirementSetAccess().getConstantsKeyword_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group_7__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group_7__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group_7__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getSystemRequirementSetAccess().getImportConstantsAssignment_7_2()); }
(rule__SystemRequirementSet__ImportConstantsAssignment_7_2)
{ after(grammarAccess.getSystemRequirementSetAccess().getImportConstantsAssignment_7_2()); }
)
(
{ before(grammarAccess.getSystemRequirementSetAccess().getImportConstantsAssignment_7_2()); }
(rule__SystemRequirementSet__ImportConstantsAssignment_7_2)*
{ after(grammarAccess.getSystemRequirementSetAccess().getImportConstantsAssignment_7_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SystemRequirementSet__Group_9_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group_9_5__0__Impl
	rule__SystemRequirementSet__Group_9_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group_9_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getSeeKeyword_9_5_0()); }

	See 

{ after(grammarAccess.getSystemRequirementSetAccess().getSeeKeyword_9_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group_9_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group_9_5__1__Impl
	rule__SystemRequirementSet__Group_9_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group_9_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getDocumentKeyword_9_5_1()); }

	Document 

{ after(grammarAccess.getSystemRequirementSetAccess().getDocumentKeyword_9_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group_9_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group_9_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group_9_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getSystemRequirementSetAccess().getDocReferenceAssignment_9_5_2()); }
(rule__SystemRequirementSet__DocReferenceAssignment_9_5_2)
{ after(grammarAccess.getSystemRequirementSetAccess().getDocReferenceAssignment_9_5_2()); }
)
(
{ before(grammarAccess.getSystemRequirementSetAccess().getDocReferenceAssignment_9_5_2()); }
(rule__SystemRequirementSet__DocReferenceAssignment_9_5_2)*
{ after(grammarAccess.getSystemRequirementSetAccess().getDocReferenceAssignment_9_5_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SystemRequirementSet__Group_9_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group_9_6__0__Impl
	rule__SystemRequirementSet__Group_9_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group_9_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getSeeKeyword_9_6_0()); }

	See 

{ after(grammarAccess.getSystemRequirementSetAccess().getSeeKeyword_9_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group_9_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group_9_6__1__Impl
	rule__SystemRequirementSet__Group_9_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group_9_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getGoalsKeyword_9_6_1()); }

	Goals 

{ after(grammarAccess.getSystemRequirementSetAccess().getGoalsKeyword_9_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group_9_6__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group_9_6__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group_9_6__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getSystemRequirementSetAccess().getStakeholderGoalsAssignment_9_6_2()); }
(rule__SystemRequirementSet__StakeholderGoalsAssignment_9_6_2)
{ after(grammarAccess.getSystemRequirementSetAccess().getStakeholderGoalsAssignment_9_6_2()); }
)
(
{ before(grammarAccess.getSystemRequirementSetAccess().getStakeholderGoalsAssignment_9_6_2()); }
(rule__SystemRequirementSet__StakeholderGoalsAssignment_9_6_2)*
{ after(grammarAccess.getSystemRequirementSetAccess().getStakeholderGoalsAssignment_9_6_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SystemRequirementSet__Group_9_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group_9_7__0__Impl
	rule__SystemRequirementSet__Group_9_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group_9_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getIssuesKeyword_9_7_0()); }

	Issues 

{ after(grammarAccess.getSystemRequirementSetAccess().getIssuesKeyword_9_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirementSet__Group_9_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirementSet__Group_9_7__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__Group_9_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getSystemRequirementSetAccess().getIssuesAssignment_9_7_1()); }
(rule__SystemRequirementSet__IssuesAssignment_9_7_1)
{ after(grammarAccess.getSystemRequirementSetAccess().getIssuesAssignment_9_7_1()); }
)
(
{ before(grammarAccess.getSystemRequirementSetAccess().getIssuesAssignment_9_7_1()); }
(rule__SystemRequirementSet__IssuesAssignment_9_7_1)*
{ after(grammarAccess.getSystemRequirementSetAccess().getIssuesAssignment_9_7_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__GlobalRequirementSet__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group__0__Impl
	rule__GlobalRequirementSet__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getGlobalRequirementSetAction_0()); }
(

)
{ after(grammarAccess.getGlobalRequirementSetAccess().getGlobalRequirementSetAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group__1__Impl
	rule__GlobalRequirementSet__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getGlobalKeyword_1()); }

	Global 

{ after(grammarAccess.getGlobalRequirementSetAccess().getGlobalKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group__2__Impl
	rule__GlobalRequirementSet__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getRequirementsKeyword_2()); }

	Requirements 

{ after(grammarAccess.getGlobalRequirementSetAccess().getRequirementsKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group__3__Impl
	rule__GlobalRequirementSet__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getNameAssignment_3()); }
(rule__GlobalRequirementSet__NameAssignment_3)
{ after(grammarAccess.getGlobalRequirementSetAccess().getNameAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group__4__Impl
	rule__GlobalRequirementSet__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getGroup_4()); }
(rule__GlobalRequirementSet__Group_4__0)?
{ after(grammarAccess.getGlobalRequirementSetAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group__5__Impl
	rule__GlobalRequirementSet__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getGroup_5()); }
(rule__GlobalRequirementSet__Group_5__0)?
{ after(grammarAccess.getGlobalRequirementSetAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group__6__Impl
	rule__GlobalRequirementSet__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getLeftSquareBracketKeyword_6()); }

	LeftSquareBracket 

{ after(grammarAccess.getGlobalRequirementSetAccess().getLeftSquareBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group__7__Impl
	rule__GlobalRequirementSet__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getAlternatives_7()); }
(rule__GlobalRequirementSet__Alternatives_7)*
{ after(grammarAccess.getGlobalRequirementSetAccess().getAlternatives_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getRightSquareBracketKeyword_8()); }

	RightSquareBracket 

{ after(grammarAccess.getGlobalRequirementSetAccess().getRightSquareBracketKeyword_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}




















rule__GlobalRequirementSet__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group_4__0__Impl
	rule__GlobalRequirementSet__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getColonKeyword_4_0()); }

	Colon 

{ after(grammarAccess.getGlobalRequirementSetAccess().getColonKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getTitleAssignment_4_1()); }
(rule__GlobalRequirementSet__TitleAssignment_4_1)
{ after(grammarAccess.getGlobalRequirementSetAccess().getTitleAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__GlobalRequirementSet__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group_5__0__Impl
	rule__GlobalRequirementSet__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getUseKeyword_5_0()); }

	Use 

{ after(grammarAccess.getGlobalRequirementSetAccess().getUseKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group_5__1__Impl
	rule__GlobalRequirementSet__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getConstantsKeyword_5_1()); }

	Constants 

{ after(grammarAccess.getGlobalRequirementSetAccess().getConstantsKeyword_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getImportConstantsAssignment_5_2()); }
(rule__GlobalRequirementSet__ImportConstantsAssignment_5_2)
{ after(grammarAccess.getGlobalRequirementSetAccess().getImportConstantsAssignment_5_2()); }
)
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getImportConstantsAssignment_5_2()); }
(rule__GlobalRequirementSet__ImportConstantsAssignment_5_2)*
{ after(grammarAccess.getGlobalRequirementSetAccess().getImportConstantsAssignment_5_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__GlobalRequirementSet__Group_7_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group_7_4__0__Impl
	rule__GlobalRequirementSet__Group_7_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group_7_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getSeeKeyword_7_4_0()); }

	See 

{ after(grammarAccess.getGlobalRequirementSetAccess().getSeeKeyword_7_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group_7_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group_7_4__1__Impl
	rule__GlobalRequirementSet__Group_7_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group_7_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getDocumentKeyword_7_4_1()); }

	Document 

{ after(grammarAccess.getGlobalRequirementSetAccess().getDocumentKeyword_7_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group_7_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group_7_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group_7_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getDocReferenceAssignment_7_4_2()); }
(rule__GlobalRequirementSet__DocReferenceAssignment_7_4_2)
{ after(grammarAccess.getGlobalRequirementSetAccess().getDocReferenceAssignment_7_4_2()); }
)
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getDocReferenceAssignment_7_4_2()); }
(rule__GlobalRequirementSet__DocReferenceAssignment_7_4_2)*
{ after(grammarAccess.getGlobalRequirementSetAccess().getDocReferenceAssignment_7_4_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__GlobalRequirementSet__Group_7_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group_7_5__0__Impl
	rule__GlobalRequirementSet__Group_7_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group_7_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getSeeKeyword_7_5_0()); }

	See 

{ after(grammarAccess.getGlobalRequirementSetAccess().getSeeKeyword_7_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group_7_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group_7_5__1__Impl
	rule__GlobalRequirementSet__Group_7_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group_7_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getGoalsKeyword_7_5_1()); }

	Goals 

{ after(grammarAccess.getGlobalRequirementSetAccess().getGoalsKeyword_7_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group_7_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group_7_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group_7_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getStakeholderGoalsAssignment_7_5_2()); }
(rule__GlobalRequirementSet__StakeholderGoalsAssignment_7_5_2)
{ after(grammarAccess.getGlobalRequirementSetAccess().getStakeholderGoalsAssignment_7_5_2()); }
)
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getStakeholderGoalsAssignment_7_5_2()); }
(rule__GlobalRequirementSet__StakeholderGoalsAssignment_7_5_2)*
{ after(grammarAccess.getGlobalRequirementSetAccess().getStakeholderGoalsAssignment_7_5_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__GlobalRequirementSet__Group_7_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group_7_6__0__Impl
	rule__GlobalRequirementSet__Group_7_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group_7_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getIssuesKeyword_7_6_0()); }

	Issues 

{ after(grammarAccess.getGlobalRequirementSetAccess().getIssuesKeyword_7_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirementSet__Group_7_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirementSet__Group_7_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__Group_7_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getIssuesAssignment_7_6_1()); }
(rule__GlobalRequirementSet__IssuesAssignment_7_6_1)
{ after(grammarAccess.getGlobalRequirementSetAccess().getIssuesAssignment_7_6_1()); }
)
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getIssuesAssignment_7_6_1()); }
(rule__GlobalRequirementSet__IssuesAssignment_7_6_1)*
{ after(grammarAccess.getGlobalRequirementSetAccess().getIssuesAssignment_7_6_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocGoal__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group__0__Impl
	rule__DocGoal__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getGoalKeyword_0()); }

	Goal 

{ after(grammarAccess.getDocGoalAccess().getGoalKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group__1__Impl
	rule__DocGoal__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getNameAssignment_1()); }
(rule__DocGoal__NameAssignment_1)
{ after(grammarAccess.getDocGoalAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group__2__Impl
	rule__DocGoal__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getGroup_2()); }
(rule__DocGoal__Group_2__0)?
{ after(grammarAccess.getDocGoalAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group__3__Impl
	rule__DocGoal__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getGroup_3()); }
(rule__DocGoal__Group_3__0)?
{ after(grammarAccess.getDocGoalAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group__4__Impl
	rule__DocGoal__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getLeftSquareBracketKeyword_4()); }

	LeftSquareBracket 

{ after(grammarAccess.getDocGoalAccess().getLeftSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group__5__Impl
	rule__DocGoal__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getUnorderedGroup_5()); }
(rule__DocGoal__UnorderedGroup_5)
{ after(grammarAccess.getDocGoalAccess().getUnorderedGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getRightSquareBracketKeyword_6()); }

	RightSquareBracket 

{ after(grammarAccess.getDocGoalAccess().getRightSquareBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__DocGoal__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_2__0__Impl
	rule__DocGoal__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getColonKeyword_2_0()); }

	Colon 

{ after(grammarAccess.getDocGoalAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getTitleAssignment_2_1()); }
(rule__DocGoal__TitleAssignment_2_1)
{ after(grammarAccess.getDocGoalAccess().getTitleAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocGoal__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_3__0__Impl
	rule__DocGoal__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getForKeyword_3_0()); }

	For 

{ after(grammarAccess.getDocGoalAccess().getForKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getAlternatives_3_1()); }
(rule__DocGoal__Alternatives_3_1)
{ after(grammarAccess.getDocGoalAccess().getAlternatives_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocGoal__Group_3_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_3_1_1__0__Impl
	rule__DocGoal__Group_3_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_3_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getTargetAssignment_3_1_1_0()); }
(rule__DocGoal__TargetAssignment_3_1_1_0)
{ after(grammarAccess.getDocGoalAccess().getTargetAssignment_3_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group_3_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_3_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_3_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getTargetElementAssignment_3_1_1_1()); }
(rule__DocGoal__TargetElementAssignment_3_1_1_1)?
{ after(grammarAccess.getDocGoalAccess().getTargetElementAssignment_3_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocGoal__Group_5_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_0__0__Impl
	rule__DocGoal__Group_5_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getCategoryKeyword_5_0_0()); }

	Category 

{ after(grammarAccess.getDocGoalAccess().getCategoryKeyword_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group_5_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDocGoalAccess().getCategoryAssignment_5_0_1()); }
(rule__DocGoal__CategoryAssignment_5_0_1)
{ after(grammarAccess.getDocGoalAccess().getCategoryAssignment_5_0_1()); }
)
(
{ before(grammarAccess.getDocGoalAccess().getCategoryAssignment_5_0_1()); }
(rule__DocGoal__CategoryAssignment_5_0_1)*
{ after(grammarAccess.getDocGoalAccess().getCategoryAssignment_5_0_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocGoal__Group_5_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_6__0__Impl
	rule__DocGoal__Group_5_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getRefinesKeyword_5_6_0()); }

	Refines 

{ after(grammarAccess.getDocGoalAccess().getRefinesKeyword_5_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group_5_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDocGoalAccess().getRefinesReferenceAssignment_5_6_1()); }
(rule__DocGoal__RefinesReferenceAssignment_5_6_1)
{ after(grammarAccess.getDocGoalAccess().getRefinesReferenceAssignment_5_6_1()); }
)
(
{ before(grammarAccess.getDocGoalAccess().getRefinesReferenceAssignment_5_6_1()); }
(rule__DocGoal__RefinesReferenceAssignment_5_6_1)*
{ after(grammarAccess.getDocGoalAccess().getRefinesReferenceAssignment_5_6_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocGoal__Group_5_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_7__0__Impl
	rule__DocGoal__Group_5_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getConflictsKeyword_5_7_0()); }

	Conflicts 

{ after(grammarAccess.getDocGoalAccess().getConflictsKeyword_5_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group_5_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_7__1__Impl
	rule__DocGoal__Group_5_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getWithKeyword_5_7_1()); }

	With 

{ after(grammarAccess.getDocGoalAccess().getWithKeyword_5_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group_5_7__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_7__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_7__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDocGoalAccess().getConflictsReferenceAssignment_5_7_2()); }
(rule__DocGoal__ConflictsReferenceAssignment_5_7_2)
{ after(grammarAccess.getDocGoalAccess().getConflictsReferenceAssignment_5_7_2()); }
)
(
{ before(grammarAccess.getDocGoalAccess().getConflictsReferenceAssignment_5_7_2()); }
(rule__DocGoal__ConflictsReferenceAssignment_5_7_2)*
{ after(grammarAccess.getDocGoalAccess().getConflictsReferenceAssignment_5_7_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__DocGoal__Group_5_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_8__0__Impl
	rule__DocGoal__Group_5_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getEvolvesKeyword_5_8_0()); }

	Evolves 

{ after(grammarAccess.getDocGoalAccess().getEvolvesKeyword_5_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group_5_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_8__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDocGoalAccess().getEvolvesReferenceAssignment_5_8_1()); }
(rule__DocGoal__EvolvesReferenceAssignment_5_8_1)
{ after(grammarAccess.getDocGoalAccess().getEvolvesReferenceAssignment_5_8_1()); }
)
(
{ before(grammarAccess.getDocGoalAccess().getEvolvesReferenceAssignment_5_8_1()); }
(rule__DocGoal__EvolvesReferenceAssignment_5_8_1)*
{ after(grammarAccess.getDocGoalAccess().getEvolvesReferenceAssignment_5_8_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocGoal__Group_5_9__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_9__0__Impl
	rule__DocGoal__Group_5_9__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_9__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getDroppedAssignment_5_9_0()); }
(rule__DocGoal__DroppedAssignment_5_9_0)
{ after(grammarAccess.getDocGoalAccess().getDroppedAssignment_5_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group_5_9__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_9__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_9__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getDropRationaleAssignment_5_9_1()); }
(rule__DocGoal__DropRationaleAssignment_5_9_1)?
{ after(grammarAccess.getDocGoalAccess().getDropRationaleAssignment_5_9_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocGoal__Group_5_10__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_10__0__Impl
	rule__DocGoal__Group_5_10__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_10__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getStakeholderKeyword_5_10_0()); }

	Stakeholder 

{ after(grammarAccess.getDocGoalAccess().getStakeholderKeyword_5_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group_5_10__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_10__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_10__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDocGoalAccess().getStakeholderReferenceAssignment_5_10_1()); }
(rule__DocGoal__StakeholderReferenceAssignment_5_10_1)
{ after(grammarAccess.getDocGoalAccess().getStakeholderReferenceAssignment_5_10_1()); }
)
(
{ before(grammarAccess.getDocGoalAccess().getStakeholderReferenceAssignment_5_10_1()); }
(rule__DocGoal__StakeholderReferenceAssignment_5_10_1)*
{ after(grammarAccess.getDocGoalAccess().getStakeholderReferenceAssignment_5_10_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocGoal__Group_5_11__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_11__0__Impl
	rule__DocGoal__Group_5_11__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_11__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getSeeKeyword_5_11_0()); }

	See 

{ after(grammarAccess.getDocGoalAccess().getSeeKeyword_5_11_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group_5_11__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_11__1__Impl
	rule__DocGoal__Group_5_11__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_11__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getDocumentKeyword_5_11_1()); }

	Document 

{ after(grammarAccess.getDocGoalAccess().getDocumentKeyword_5_11_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group_5_11__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_11__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_11__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDocGoalAccess().getDocReferenceAssignment_5_11_2()); }
(rule__DocGoal__DocReferenceAssignment_5_11_2)
{ after(grammarAccess.getDocGoalAccess().getDocReferenceAssignment_5_11_2()); }
)
(
{ before(grammarAccess.getDocGoalAccess().getDocReferenceAssignment_5_11_2()); }
(rule__DocGoal__DocReferenceAssignment_5_11_2)*
{ after(grammarAccess.getDocGoalAccess().getDocReferenceAssignment_5_11_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__DocGoal__Group_5_12__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_12__0__Impl
	rule__DocGoal__Group_5_12__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_12__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getIssuesKeyword_5_12_0()); }

	Issues 

{ after(grammarAccess.getDocGoalAccess().getIssuesKeyword_5_12_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__Group_5_12__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__Group_5_12__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__Group_5_12__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDocGoalAccess().getIssuesAssignment_5_12_1()); }
(rule__DocGoal__IssuesAssignment_5_12_1)
{ after(grammarAccess.getDocGoalAccess().getIssuesAssignment_5_12_1()); }
)
(
{ before(grammarAccess.getDocGoalAccess().getIssuesAssignment_5_12_1()); }
(rule__DocGoal__IssuesAssignment_5_12_1)*
{ after(grammarAccess.getDocGoalAccess().getIssuesAssignment_5_12_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Goal__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group__0__Impl
	rule__Goal__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getGoalKeyword_0()); }

	Goal 

{ after(grammarAccess.getGoalAccess().getGoalKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group__1__Impl
	rule__Goal__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getNameAssignment_1()); }
(rule__Goal__NameAssignment_1)
{ after(grammarAccess.getGoalAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group__2__Impl
	rule__Goal__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getGroup_2()); }
(rule__Goal__Group_2__0)?
{ after(grammarAccess.getGoalAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group__3__Impl
	rule__Goal__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getGroup_3()); }
(rule__Goal__Group_3__0)?
{ after(grammarAccess.getGoalAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group__4__Impl
	rule__Goal__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getLeftSquareBracketKeyword_4()); }

	LeftSquareBracket 

{ after(grammarAccess.getGoalAccess().getLeftSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group__5__Impl
	rule__Goal__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getUnorderedGroup_5()); }
(rule__Goal__UnorderedGroup_5)
{ after(grammarAccess.getGoalAccess().getUnorderedGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getRightSquareBracketKeyword_6()); }

	RightSquareBracket 

{ after(grammarAccess.getGoalAccess().getRightSquareBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__Goal__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_2__0__Impl
	rule__Goal__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getColonKeyword_2_0()); }

	Colon 

{ after(grammarAccess.getGoalAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getTitleAssignment_2_1()); }
(rule__Goal__TitleAssignment_2_1)
{ after(grammarAccess.getGoalAccess().getTitleAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Goal__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_3__0__Impl
	rule__Goal__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getForKeyword_3_0()); }

	For 

{ after(grammarAccess.getGoalAccess().getForKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getTargetElementAssignment_3_1()); }
(rule__Goal__TargetElementAssignment_3_1)
{ after(grammarAccess.getGoalAccess().getTargetElementAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Goal__Group_5_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_0__0__Impl
	rule__Goal__Group_5_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getCategoryKeyword_5_0_0()); }

	Category 

{ after(grammarAccess.getGoalAccess().getCategoryKeyword_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group_5_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGoalAccess().getCategoryAssignment_5_0_1()); }
(rule__Goal__CategoryAssignment_5_0_1)
{ after(grammarAccess.getGoalAccess().getCategoryAssignment_5_0_1()); }
)
(
{ before(grammarAccess.getGoalAccess().getCategoryAssignment_5_0_1()); }
(rule__Goal__CategoryAssignment_5_0_1)*
{ after(grammarAccess.getGoalAccess().getCategoryAssignment_5_0_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Goal__Group_5_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_6__0__Impl
	rule__Goal__Group_5_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getRefinesKeyword_5_6_0()); }

	Refines 

{ after(grammarAccess.getGoalAccess().getRefinesKeyword_5_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group_5_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGoalAccess().getRefinesReferenceAssignment_5_6_1()); }
(rule__Goal__RefinesReferenceAssignment_5_6_1)
{ after(grammarAccess.getGoalAccess().getRefinesReferenceAssignment_5_6_1()); }
)
(
{ before(grammarAccess.getGoalAccess().getRefinesReferenceAssignment_5_6_1()); }
(rule__Goal__RefinesReferenceAssignment_5_6_1)*
{ after(grammarAccess.getGoalAccess().getRefinesReferenceAssignment_5_6_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Goal__Group_5_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_7__0__Impl
	rule__Goal__Group_5_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getConflictsKeyword_5_7_0()); }

	Conflicts 

{ after(grammarAccess.getGoalAccess().getConflictsKeyword_5_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group_5_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_7__1__Impl
	rule__Goal__Group_5_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getWithKeyword_5_7_1()); }

	With 

{ after(grammarAccess.getGoalAccess().getWithKeyword_5_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group_5_7__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_7__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_7__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGoalAccess().getConflictsReferenceAssignment_5_7_2()); }
(rule__Goal__ConflictsReferenceAssignment_5_7_2)
{ after(grammarAccess.getGoalAccess().getConflictsReferenceAssignment_5_7_2()); }
)
(
{ before(grammarAccess.getGoalAccess().getConflictsReferenceAssignment_5_7_2()); }
(rule__Goal__ConflictsReferenceAssignment_5_7_2)*
{ after(grammarAccess.getGoalAccess().getConflictsReferenceAssignment_5_7_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Goal__Group_5_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_8__0__Impl
	rule__Goal__Group_5_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getEvolvesKeyword_5_8_0()); }

	Evolves 

{ after(grammarAccess.getGoalAccess().getEvolvesKeyword_5_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group_5_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_8__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGoalAccess().getEvolvesReferenceAssignment_5_8_1()); }
(rule__Goal__EvolvesReferenceAssignment_5_8_1)
{ after(grammarAccess.getGoalAccess().getEvolvesReferenceAssignment_5_8_1()); }
)
(
{ before(grammarAccess.getGoalAccess().getEvolvesReferenceAssignment_5_8_1()); }
(rule__Goal__EvolvesReferenceAssignment_5_8_1)*
{ after(grammarAccess.getGoalAccess().getEvolvesReferenceAssignment_5_8_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Goal__Group_5_9__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_9__0__Impl
	rule__Goal__Group_5_9__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_9__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getDroppedAssignment_5_9_0()); }
(rule__Goal__DroppedAssignment_5_9_0)
{ after(grammarAccess.getGoalAccess().getDroppedAssignment_5_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group_5_9__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_9__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_9__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getDropRationaleAssignment_5_9_1()); }
(rule__Goal__DropRationaleAssignment_5_9_1)?
{ after(grammarAccess.getGoalAccess().getDropRationaleAssignment_5_9_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Goal__Group_5_10__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_10__0__Impl
	rule__Goal__Group_5_10__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_10__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getStakeholderKeyword_5_10_0()); }

	Stakeholder 

{ after(grammarAccess.getGoalAccess().getStakeholderKeyword_5_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group_5_10__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_10__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_10__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGoalAccess().getStakeholderReferenceAssignment_5_10_1()); }
(rule__Goal__StakeholderReferenceAssignment_5_10_1)
{ after(grammarAccess.getGoalAccess().getStakeholderReferenceAssignment_5_10_1()); }
)
(
{ before(grammarAccess.getGoalAccess().getStakeholderReferenceAssignment_5_10_1()); }
(rule__Goal__StakeholderReferenceAssignment_5_10_1)*
{ after(grammarAccess.getGoalAccess().getStakeholderReferenceAssignment_5_10_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Goal__Group_5_11__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_11__0__Impl
	rule__Goal__Group_5_11__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_11__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getSeeKeyword_5_11_0()); }

	See 

{ after(grammarAccess.getGoalAccess().getSeeKeyword_5_11_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group_5_11__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_11__1__Impl
	rule__Goal__Group_5_11__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_11__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getGoalKeyword_5_11_1()); }

	Goal 

{ after(grammarAccess.getGoalAccess().getGoalKeyword_5_11_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group_5_11__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_11__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_11__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGoalAccess().getGoalReferenceAssignment_5_11_2()); }
(rule__Goal__GoalReferenceAssignment_5_11_2)
{ after(grammarAccess.getGoalAccess().getGoalReferenceAssignment_5_11_2()); }
)
(
{ before(grammarAccess.getGoalAccess().getGoalReferenceAssignment_5_11_2()); }
(rule__Goal__GoalReferenceAssignment_5_11_2)*
{ after(grammarAccess.getGoalAccess().getGoalReferenceAssignment_5_11_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Goal__Group_5_12__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_12__0__Impl
	rule__Goal__Group_5_12__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_12__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getSeeKeyword_5_12_0()); }

	See 

{ after(grammarAccess.getGoalAccess().getSeeKeyword_5_12_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group_5_12__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_12__1__Impl
	rule__Goal__Group_5_12__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_12__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getDocumentKeyword_5_12_1()); }

	Document 

{ after(grammarAccess.getGoalAccess().getDocumentKeyword_5_12_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group_5_12__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_12__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_12__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGoalAccess().getDocReferenceAssignment_5_12_2()); }
(rule__Goal__DocReferenceAssignment_5_12_2)
{ after(grammarAccess.getGoalAccess().getDocReferenceAssignment_5_12_2()); }
)
(
{ before(grammarAccess.getGoalAccess().getDocReferenceAssignment_5_12_2()); }
(rule__Goal__DocReferenceAssignment_5_12_2)*
{ after(grammarAccess.getGoalAccess().getDocReferenceAssignment_5_12_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Goal__Group_5_13__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_13__0__Impl
	rule__Goal__Group_5_13__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_13__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getIssuesKeyword_5_13_0()); }

	Issues 

{ after(grammarAccess.getGoalAccess().getIssuesKeyword_5_13_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__Group_5_13__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__Group_5_13__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__Group_5_13__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGoalAccess().getIssuesAssignment_5_13_1()); }
(rule__Goal__IssuesAssignment_5_13_1)
{ after(grammarAccess.getGoalAccess().getIssuesAssignment_5_13_1()); }
)
(
{ before(grammarAccess.getGoalAccess().getIssuesAssignment_5_13_1()); }
(rule__Goal__IssuesAssignment_5_13_1)*
{ after(grammarAccess.getGoalAccess().getIssuesAssignment_5_13_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SystemRequirement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group__0__Impl
	rule__SystemRequirement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getRequirementKeyword_0()); }

	Requirement 

{ after(grammarAccess.getSystemRequirementAccess().getRequirementKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group__1__Impl
	rule__SystemRequirement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getNameAssignment_1()); }
(rule__SystemRequirement__NameAssignment_1)
{ after(grammarAccess.getSystemRequirementAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group__2__Impl
	rule__SystemRequirement__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getGroup_2()); }
(rule__SystemRequirement__Group_2__0)?
{ after(grammarAccess.getSystemRequirementAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group__3__Impl
	rule__SystemRequirement__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getGroup_3()); }
(rule__SystemRequirement__Group_3__0)?
{ after(grammarAccess.getSystemRequirementAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group__4__Impl
	rule__SystemRequirement__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getLeftSquareBracketKeyword_4()); }

	LeftSquareBracket 

{ after(grammarAccess.getSystemRequirementAccess().getLeftSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group__5__Impl
	rule__SystemRequirement__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getAlternatives_5()); }
(rule__SystemRequirement__Alternatives_5)*
{ after(grammarAccess.getSystemRequirementAccess().getAlternatives_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getRightSquareBracketKeyword_6()); }

	RightSquareBracket 

{ after(grammarAccess.getSystemRequirementAccess().getRightSquareBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__SystemRequirement__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_2__0__Impl
	rule__SystemRequirement__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getColonKeyword_2_0()); }

	Colon 

{ after(grammarAccess.getSystemRequirementAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getTitleAssignment_2_1()); }
(rule__SystemRequirement__TitleAssignment_2_1)
{ after(grammarAccess.getSystemRequirementAccess().getTitleAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SystemRequirement__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_3__0__Impl
	rule__SystemRequirement__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getForKeyword_3_0()); }

	For 

{ after(grammarAccess.getSystemRequirementAccess().getForKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getTargetElementAssignment_3_1()); }
(rule__SystemRequirement__TargetElementAssignment_3_1)
{ after(grammarAccess.getSystemRequirementAccess().getTargetElementAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SystemRequirement__Group_5_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_0__0__Impl
	rule__SystemRequirement__Group_5_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getCategoryKeyword_5_0_0()); }

	Category 

{ after(grammarAccess.getSystemRequirementAccess().getCategoryKeyword_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getSystemRequirementAccess().getCategoryAssignment_5_0_1()); }
(rule__SystemRequirement__CategoryAssignment_5_0_1)
{ after(grammarAccess.getSystemRequirementAccess().getCategoryAssignment_5_0_1()); }
)
(
{ before(grammarAccess.getSystemRequirementAccess().getCategoryAssignment_5_0_1()); }
(rule__SystemRequirement__CategoryAssignment_5_0_1)*
{ after(grammarAccess.getSystemRequirementAccess().getCategoryAssignment_5_0_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SystemRequirement__Group_5_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_6__0__Impl
	rule__SystemRequirement__Group_5_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getMitigatesKeyword_5_6_0()); }

	Mitigates 

{ after(grammarAccess.getSystemRequirementAccess().getMitigatesKeyword_5_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getAlternatives_5_6_1()); }
(rule__SystemRequirement__Alternatives_5_6_1)
{ after(grammarAccess.getSystemRequirementAccess().getAlternatives_5_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SystemRequirement__Group_5_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_7__0__Impl
	rule__SystemRequirement__Group_5_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getInheritsKeyword_5_7_0()); }

	Inherits 

{ after(grammarAccess.getSystemRequirementAccess().getInheritsKeyword_5_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_7__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getInheritsReferenceAssignment_5_7_1()); }
(rule__SystemRequirement__InheritsReferenceAssignment_5_7_1)
{ after(grammarAccess.getSystemRequirementAccess().getInheritsReferenceAssignment_5_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SystemRequirement__Group_5_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_8__0__Impl
	rule__SystemRequirement__Group_5_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getDroppedAssignment_5_8_0()); }
(rule__SystemRequirement__DroppedAssignment_5_8_0)
{ after(grammarAccess.getSystemRequirementAccess().getDroppedAssignment_5_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_8__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getDropRationaleAssignment_5_8_1()); }
(rule__SystemRequirement__DropRationaleAssignment_5_8_1)?
{ after(grammarAccess.getSystemRequirementAccess().getDropRationaleAssignment_5_8_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SystemRequirement__Group_5_11__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_11__0__Impl
	rule__SystemRequirement__Group_5_11__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_11__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getRefinesKeyword_5_11_0()); }

	Refines 

{ after(grammarAccess.getSystemRequirementAccess().getRefinesKeyword_5_11_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_11__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_11__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_11__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getSystemRequirementAccess().getRefinesReferenceAssignment_5_11_1()); }
(rule__SystemRequirement__RefinesReferenceAssignment_5_11_1)
{ after(grammarAccess.getSystemRequirementAccess().getRefinesReferenceAssignment_5_11_1()); }
)
(
{ before(grammarAccess.getSystemRequirementAccess().getRefinesReferenceAssignment_5_11_1()); }
(rule__SystemRequirement__RefinesReferenceAssignment_5_11_1)*
{ after(grammarAccess.getSystemRequirementAccess().getRefinesReferenceAssignment_5_11_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SystemRequirement__Group_5_12__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_12__0__Impl
	rule__SystemRequirement__Group_5_12__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_12__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getDecomposesKeyword_5_12_0()); }

	Decomposes 

{ after(grammarAccess.getSystemRequirementAccess().getDecomposesKeyword_5_12_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_12__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_12__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_12__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getSystemRequirementAccess().getDecomposesReferenceAssignment_5_12_1()); }
(rule__SystemRequirement__DecomposesReferenceAssignment_5_12_1)
{ after(grammarAccess.getSystemRequirementAccess().getDecomposesReferenceAssignment_5_12_1()); }
)
(
{ before(grammarAccess.getSystemRequirementAccess().getDecomposesReferenceAssignment_5_12_1()); }
(rule__SystemRequirement__DecomposesReferenceAssignment_5_12_1)*
{ after(grammarAccess.getSystemRequirementAccess().getDecomposesReferenceAssignment_5_12_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SystemRequirement__Group_5_13__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_13__0__Impl
	rule__SystemRequirement__Group_5_13__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_13__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getEvolvesKeyword_5_13_0()); }

	Evolves 

{ after(grammarAccess.getSystemRequirementAccess().getEvolvesKeyword_5_13_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_13__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_13__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_13__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getSystemRequirementAccess().getEvolvesReferenceAssignment_5_13_1()); }
(rule__SystemRequirement__EvolvesReferenceAssignment_5_13_1)
{ after(grammarAccess.getSystemRequirementAccess().getEvolvesReferenceAssignment_5_13_1()); }
)
(
{ before(grammarAccess.getSystemRequirementAccess().getEvolvesReferenceAssignment_5_13_1()); }
(rule__SystemRequirement__EvolvesReferenceAssignment_5_13_1)*
{ after(grammarAccess.getSystemRequirementAccess().getEvolvesReferenceAssignment_5_13_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SystemRequirement__Group_5_14__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_14__0__Impl
	rule__SystemRequirement__Group_5_14__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_14__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getDevelopmentKeyword_5_14_0()); }

	Development 

{ after(grammarAccess.getSystemRequirementAccess().getDevelopmentKeyword_5_14_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_14__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_14__1__Impl
	rule__SystemRequirement__Group_5_14__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_14__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getStakeholderKeyword_5_14_1()); }

	Stakeholder 

{ after(grammarAccess.getSystemRequirementAccess().getStakeholderKeyword_5_14_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_14__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_14__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_14__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getSystemRequirementAccess().getDevelopmentStakeholderAssignment_5_14_2()); }
(rule__SystemRequirement__DevelopmentStakeholderAssignment_5_14_2)
{ after(grammarAccess.getSystemRequirementAccess().getDevelopmentStakeholderAssignment_5_14_2()); }
)
(
{ before(grammarAccess.getSystemRequirementAccess().getDevelopmentStakeholderAssignment_5_14_2()); }
(rule__SystemRequirement__DevelopmentStakeholderAssignment_5_14_2)*
{ after(grammarAccess.getSystemRequirementAccess().getDevelopmentStakeholderAssignment_5_14_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SystemRequirement__Group_5_15__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_15__0__Impl
	rule__SystemRequirement__Group_5_15__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_15__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getSeeKeyword_5_15_0()); }

	See 

{ after(grammarAccess.getSystemRequirementAccess().getSeeKeyword_5_15_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_15__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_15__1__Impl
	rule__SystemRequirement__Group_5_15__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_15__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getGoalKeyword_5_15_1()); }

	Goal 

{ after(grammarAccess.getSystemRequirementAccess().getGoalKeyword_5_15_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_15__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_15__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_15__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getSystemRequirementAccess().getGoalReferenceAssignment_5_15_2()); }
(rule__SystemRequirement__GoalReferenceAssignment_5_15_2)
{ after(grammarAccess.getSystemRequirementAccess().getGoalReferenceAssignment_5_15_2()); }
)
(
{ before(grammarAccess.getSystemRequirementAccess().getGoalReferenceAssignment_5_15_2()); }
(rule__SystemRequirement__GoalReferenceAssignment_5_15_2)*
{ after(grammarAccess.getSystemRequirementAccess().getGoalReferenceAssignment_5_15_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SystemRequirement__Group_5_16__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_16__0__Impl
	rule__SystemRequirement__Group_5_16__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_16__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getSeeKeyword_5_16_0()); }

	See 

{ after(grammarAccess.getSystemRequirementAccess().getSeeKeyword_5_16_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_16__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_16__1__Impl
	rule__SystemRequirement__Group_5_16__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_16__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getRequirementKeyword_5_16_1()); }

	Requirement 

{ after(grammarAccess.getSystemRequirementAccess().getRequirementKeyword_5_16_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_16__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_16__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_16__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getSystemRequirementAccess().getRequirementReferenceAssignment_5_16_2()); }
(rule__SystemRequirement__RequirementReferenceAssignment_5_16_2)
{ after(grammarAccess.getSystemRequirementAccess().getRequirementReferenceAssignment_5_16_2()); }
)
(
{ before(grammarAccess.getSystemRequirementAccess().getRequirementReferenceAssignment_5_16_2()); }
(rule__SystemRequirement__RequirementReferenceAssignment_5_16_2)*
{ after(grammarAccess.getSystemRequirementAccess().getRequirementReferenceAssignment_5_16_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SystemRequirement__Group_5_17__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_17__0__Impl
	rule__SystemRequirement__Group_5_17__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_17__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getSeeKeyword_5_17_0()); }

	See 

{ after(grammarAccess.getSystemRequirementAccess().getSeeKeyword_5_17_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_17__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_17__1__Impl
	rule__SystemRequirement__Group_5_17__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_17__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getDocumentKeyword_5_17_1()); }

	Document 

{ after(grammarAccess.getSystemRequirementAccess().getDocumentKeyword_5_17_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_17__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_17__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_17__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getSystemRequirementAccess().getDocReferenceAssignment_5_17_2()); }
(rule__SystemRequirement__DocReferenceAssignment_5_17_2)
{ after(grammarAccess.getSystemRequirementAccess().getDocReferenceAssignment_5_17_2()); }
)
(
{ before(grammarAccess.getSystemRequirementAccess().getDocReferenceAssignment_5_17_2()); }
(rule__SystemRequirement__DocReferenceAssignment_5_17_2)*
{ after(grammarAccess.getSystemRequirementAccess().getDocReferenceAssignment_5_17_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SystemRequirement__Group_5_18__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_18__0__Impl
	rule__SystemRequirement__Group_5_18__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_18__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getIssuesKeyword_5_18_0()); }

	Issues 

{ after(grammarAccess.getSystemRequirementAccess().getIssuesKeyword_5_18_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemRequirement__Group_5_18__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemRequirement__Group_5_18__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__Group_5_18__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getSystemRequirementAccess().getIssuesAssignment_5_18_1()); }
(rule__SystemRequirement__IssuesAssignment_5_18_1)
{ after(grammarAccess.getSystemRequirementAccess().getIssuesAssignment_5_18_1()); }
)
(
{ before(grammarAccess.getSystemRequirementAccess().getIssuesAssignment_5_18_1()); }
(rule__SystemRequirement__IssuesAssignment_5_18_1)*
{ after(grammarAccess.getSystemRequirementAccess().getIssuesAssignment_5_18_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__GlobalRequirement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group__0__Impl
	rule__GlobalRequirement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getRequirementKeyword_0()); }

	Requirement 

{ after(grammarAccess.getGlobalRequirementAccess().getRequirementKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group__1__Impl
	rule__GlobalRequirement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getNameAssignment_1()); }
(rule__GlobalRequirement__NameAssignment_1)
{ after(grammarAccess.getGlobalRequirementAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group__2__Impl
	rule__GlobalRequirement__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getGroup_2()); }
(rule__GlobalRequirement__Group_2__0)?
{ after(grammarAccess.getGlobalRequirementAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group__3__Impl
	rule__GlobalRequirement__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getGroup_3()); }
(rule__GlobalRequirement__Group_3__0)?
{ after(grammarAccess.getGlobalRequirementAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group__4__Impl
	rule__GlobalRequirement__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getLeftSquareBracketKeyword_4()); }

	LeftSquareBracket 

{ after(grammarAccess.getGlobalRequirementAccess().getLeftSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group__5__Impl
	rule__GlobalRequirement__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5()); }
(rule__GlobalRequirement__UnorderedGroup_5)
{ after(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getRightSquareBracketKeyword_6()); }

	RightSquareBracket 

{ after(grammarAccess.getGlobalRequirementAccess().getRightSquareBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__GlobalRequirement__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_2__0__Impl
	rule__GlobalRequirement__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getColonKeyword_2_0()); }

	Colon 

{ after(grammarAccess.getGlobalRequirementAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getTitleAssignment_2_1()); }
(rule__GlobalRequirement__TitleAssignment_2_1)
{ after(grammarAccess.getGlobalRequirementAccess().getTitleAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__GlobalRequirement__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_3__0__Impl
	rule__GlobalRequirement__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getForKeyword_3_0()); }

	For 

{ after(grammarAccess.getGlobalRequirementAccess().getForKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getAlternatives_3_1()); }
(rule__GlobalRequirement__Alternatives_3_1)
{ after(grammarAccess.getGlobalRequirementAccess().getAlternatives_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__GlobalRequirement__Group_5_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_0__0__Impl
	rule__GlobalRequirement__Group_5_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getCategoryKeyword_5_0_0()); }

	Category 

{ after(grammarAccess.getGlobalRequirementAccess().getCategoryKeyword_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_5_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGlobalRequirementAccess().getCategoryAssignment_5_0_1()); }
(rule__GlobalRequirement__CategoryAssignment_5_0_1)
{ after(grammarAccess.getGlobalRequirementAccess().getCategoryAssignment_5_0_1()); }
)
(
{ before(grammarAccess.getGlobalRequirementAccess().getCategoryAssignment_5_0_1()); }
(rule__GlobalRequirement__CategoryAssignment_5_0_1)*
{ after(grammarAccess.getGlobalRequirementAccess().getCategoryAssignment_5_0_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__GlobalRequirement__Group_5_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_8__0__Impl
	rule__GlobalRequirement__Group_5_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getMitigatesKeyword_5_8_0()); }

	Mitigates 

{ after(grammarAccess.getGlobalRequirementAccess().getMitigatesKeyword_5_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_5_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_8__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getAlternatives_5_8_1()); }
(rule__GlobalRequirement__Alternatives_5_8_1)
{ after(grammarAccess.getGlobalRequirementAccess().getAlternatives_5_8_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__GlobalRequirement__Group_5_9__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_9__0__Impl
	rule__GlobalRequirement__Group_5_9__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_9__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getRefinesKeyword_5_9_0()); }

	Refines 

{ after(grammarAccess.getGlobalRequirementAccess().getRefinesKeyword_5_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_5_9__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_9__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_9__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGlobalRequirementAccess().getRefinesReferenceAssignment_5_9_1()); }
(rule__GlobalRequirement__RefinesReferenceAssignment_5_9_1)
{ after(grammarAccess.getGlobalRequirementAccess().getRefinesReferenceAssignment_5_9_1()); }
)
(
{ before(grammarAccess.getGlobalRequirementAccess().getRefinesReferenceAssignment_5_9_1()); }
(rule__GlobalRequirement__RefinesReferenceAssignment_5_9_1)*
{ after(grammarAccess.getGlobalRequirementAccess().getRefinesReferenceAssignment_5_9_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__GlobalRequirement__Group_5_10__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_10__0__Impl
	rule__GlobalRequirement__Group_5_10__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_10__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getDecomposesKeyword_5_10_0()); }

	Decomposes 

{ after(grammarAccess.getGlobalRequirementAccess().getDecomposesKeyword_5_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_5_10__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_10__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_10__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGlobalRequirementAccess().getDecomposesReferenceAssignment_5_10_1()); }
(rule__GlobalRequirement__DecomposesReferenceAssignment_5_10_1)
{ after(grammarAccess.getGlobalRequirementAccess().getDecomposesReferenceAssignment_5_10_1()); }
)
(
{ before(grammarAccess.getGlobalRequirementAccess().getDecomposesReferenceAssignment_5_10_1()); }
(rule__GlobalRequirement__DecomposesReferenceAssignment_5_10_1)*
{ after(grammarAccess.getGlobalRequirementAccess().getDecomposesReferenceAssignment_5_10_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__GlobalRequirement__Group_5_11__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_11__0__Impl
	rule__GlobalRequirement__Group_5_11__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_11__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getEvolvesKeyword_5_11_0()); }

	Evolves 

{ after(grammarAccess.getGlobalRequirementAccess().getEvolvesKeyword_5_11_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_5_11__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_11__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_11__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGlobalRequirementAccess().getEvolvesReferenceAssignment_5_11_1()); }
(rule__GlobalRequirement__EvolvesReferenceAssignment_5_11_1)
{ after(grammarAccess.getGlobalRequirementAccess().getEvolvesReferenceAssignment_5_11_1()); }
)
(
{ before(grammarAccess.getGlobalRequirementAccess().getEvolvesReferenceAssignment_5_11_1()); }
(rule__GlobalRequirement__EvolvesReferenceAssignment_5_11_1)*
{ after(grammarAccess.getGlobalRequirementAccess().getEvolvesReferenceAssignment_5_11_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__GlobalRequirement__Group_5_12__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_12__0__Impl
	rule__GlobalRequirement__Group_5_12__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_12__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getDroppedAssignment_5_12_0()); }
(rule__GlobalRequirement__DroppedAssignment_5_12_0)
{ after(grammarAccess.getGlobalRequirementAccess().getDroppedAssignment_5_12_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_5_12__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_12__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_12__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getDropRationaleAssignment_5_12_1()); }
(rule__GlobalRequirement__DropRationaleAssignment_5_12_1)?
{ after(grammarAccess.getGlobalRequirementAccess().getDropRationaleAssignment_5_12_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__GlobalRequirement__Group_5_13__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_13__0__Impl
	rule__GlobalRequirement__Group_5_13__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_13__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getDevelopmentKeyword_5_13_0()); }

	Development 

{ after(grammarAccess.getGlobalRequirementAccess().getDevelopmentKeyword_5_13_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_5_13__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_13__1__Impl
	rule__GlobalRequirement__Group_5_13__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_13__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getStakeholderKeyword_5_13_1()); }

	Stakeholder 

{ after(grammarAccess.getGlobalRequirementAccess().getStakeholderKeyword_5_13_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_5_13__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_13__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_13__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGlobalRequirementAccess().getDevelopmentStakeholderAssignment_5_13_2()); }
(rule__GlobalRequirement__DevelopmentStakeholderAssignment_5_13_2)
{ after(grammarAccess.getGlobalRequirementAccess().getDevelopmentStakeholderAssignment_5_13_2()); }
)
(
{ before(grammarAccess.getGlobalRequirementAccess().getDevelopmentStakeholderAssignment_5_13_2()); }
(rule__GlobalRequirement__DevelopmentStakeholderAssignment_5_13_2)*
{ after(grammarAccess.getGlobalRequirementAccess().getDevelopmentStakeholderAssignment_5_13_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__GlobalRequirement__Group_5_14__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_14__0__Impl
	rule__GlobalRequirement__Group_5_14__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_14__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getSeeKeyword_5_14_0()); }

	See 

{ after(grammarAccess.getGlobalRequirementAccess().getSeeKeyword_5_14_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_5_14__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_14__1__Impl
	rule__GlobalRequirement__Group_5_14__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_14__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getGoalKeyword_5_14_1()); }

	Goal 

{ after(grammarAccess.getGlobalRequirementAccess().getGoalKeyword_5_14_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_5_14__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_14__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_14__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGlobalRequirementAccess().getGoalReferenceAssignment_5_14_2()); }
(rule__GlobalRequirement__GoalReferenceAssignment_5_14_2)
{ after(grammarAccess.getGlobalRequirementAccess().getGoalReferenceAssignment_5_14_2()); }
)
(
{ before(grammarAccess.getGlobalRequirementAccess().getGoalReferenceAssignment_5_14_2()); }
(rule__GlobalRequirement__GoalReferenceAssignment_5_14_2)*
{ after(grammarAccess.getGlobalRequirementAccess().getGoalReferenceAssignment_5_14_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__GlobalRequirement__Group_5_15__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_15__0__Impl
	rule__GlobalRequirement__Group_5_15__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_15__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getSeeKeyword_5_15_0()); }

	See 

{ after(grammarAccess.getGlobalRequirementAccess().getSeeKeyword_5_15_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_5_15__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_15__1__Impl
	rule__GlobalRequirement__Group_5_15__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_15__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getRequirementKeyword_5_15_1()); }

	Requirement 

{ after(grammarAccess.getGlobalRequirementAccess().getRequirementKeyword_5_15_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_5_15__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_15__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_15__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGlobalRequirementAccess().getRequirementReferenceAssignment_5_15_2()); }
(rule__GlobalRequirement__RequirementReferenceAssignment_5_15_2)
{ after(grammarAccess.getGlobalRequirementAccess().getRequirementReferenceAssignment_5_15_2()); }
)
(
{ before(grammarAccess.getGlobalRequirementAccess().getRequirementReferenceAssignment_5_15_2()); }
(rule__GlobalRequirement__RequirementReferenceAssignment_5_15_2)*
{ after(grammarAccess.getGlobalRequirementAccess().getRequirementReferenceAssignment_5_15_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__GlobalRequirement__Group_5_16__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_16__0__Impl
	rule__GlobalRequirement__Group_5_16__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_16__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getSeeKeyword_5_16_0()); }

	See 

{ after(grammarAccess.getGlobalRequirementAccess().getSeeKeyword_5_16_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_5_16__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_16__1__Impl
	rule__GlobalRequirement__Group_5_16__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_16__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getDocumentKeyword_5_16_1()); }

	Document 

{ after(grammarAccess.getGlobalRequirementAccess().getDocumentKeyword_5_16_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_5_16__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_16__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_16__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGlobalRequirementAccess().getDocReferenceAssignment_5_16_2()); }
(rule__GlobalRequirement__DocReferenceAssignment_5_16_2)
{ after(grammarAccess.getGlobalRequirementAccess().getDocReferenceAssignment_5_16_2()); }
)
(
{ before(grammarAccess.getGlobalRequirementAccess().getDocReferenceAssignment_5_16_2()); }
(rule__GlobalRequirement__DocReferenceAssignment_5_16_2)*
{ after(grammarAccess.getGlobalRequirementAccess().getDocReferenceAssignment_5_16_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__GlobalRequirement__Group_5_17__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_17__0__Impl
	rule__GlobalRequirement__Group_5_17__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_17__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getIssuesKeyword_5_17_0()); }

	Issues 

{ after(grammarAccess.getGlobalRequirementAccess().getIssuesKeyword_5_17_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__Group_5_17__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__Group_5_17__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__Group_5_17__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGlobalRequirementAccess().getIssuesAssignment_5_17_1()); }
(rule__GlobalRequirement__IssuesAssignment_5_17_1)
{ after(grammarAccess.getGlobalRequirementAccess().getIssuesAssignment_5_17_1()); }
)
(
{ before(grammarAccess.getGlobalRequirementAccess().getIssuesAssignment_5_17_1()); }
(rule__GlobalRequirement__IssuesAssignment_5_17_1)*
{ after(grammarAccess.getGlobalRequirementAccess().getIssuesAssignment_5_17_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocRequirement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group__0__Impl
	rule__DocRequirement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getRequirementKeyword_0()); }

	Requirement 

{ after(grammarAccess.getDocRequirementAccess().getRequirementKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group__1__Impl
	rule__DocRequirement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getNameAssignment_1()); }
(rule__DocRequirement__NameAssignment_1)
{ after(grammarAccess.getDocRequirementAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group__2__Impl
	rule__DocRequirement__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getGroup_2()); }
(rule__DocRequirement__Group_2__0)?
{ after(grammarAccess.getDocRequirementAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group__3__Impl
	rule__DocRequirement__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getGroup_3()); }
(rule__DocRequirement__Group_3__0)?
{ after(grammarAccess.getDocRequirementAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group__4__Impl
	rule__DocRequirement__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getLeftSquareBracketKeyword_4()); }

	LeftSquareBracket 

{ after(grammarAccess.getDocRequirementAccess().getLeftSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group__5__Impl
	rule__DocRequirement__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5()); }
(rule__DocRequirement__UnorderedGroup_5)
{ after(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getRightSquareBracketKeyword_6()); }

	RightSquareBracket 

{ after(grammarAccess.getDocRequirementAccess().getRightSquareBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__DocRequirement__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_2__0__Impl
	rule__DocRequirement__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getColonKeyword_2_0()); }

	Colon 

{ after(grammarAccess.getDocRequirementAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getTitleAssignment_2_1()); }
(rule__DocRequirement__TitleAssignment_2_1)
{ after(grammarAccess.getDocRequirementAccess().getTitleAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocRequirement__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_3__0__Impl
	rule__DocRequirement__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getForKeyword_3_0()); }

	For 

{ after(grammarAccess.getDocRequirementAccess().getForKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getAlternatives_3_1()); }
(rule__DocRequirement__Alternatives_3_1)
{ after(grammarAccess.getDocRequirementAccess().getAlternatives_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocRequirement__Group_3_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_3_1_1__0__Impl
	rule__DocRequirement__Group_3_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_3_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getTargetAssignment_3_1_1_0()); }
(rule__DocRequirement__TargetAssignment_3_1_1_0)
{ after(grammarAccess.getDocRequirementAccess().getTargetAssignment_3_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_3_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_3_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_3_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getTargetElementAssignment_3_1_1_1()); }
(rule__DocRequirement__TargetElementAssignment_3_1_1_1)?
{ after(grammarAccess.getDocRequirementAccess().getTargetElementAssignment_3_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocRequirement__Group_5_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_0__0__Impl
	rule__DocRequirement__Group_5_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getCategoryKeyword_5_0_0()); }

	Category 

{ after(grammarAccess.getDocRequirementAccess().getCategoryKeyword_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_5_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDocRequirementAccess().getCategoryAssignment_5_0_1()); }
(rule__DocRequirement__CategoryAssignment_5_0_1)
{ after(grammarAccess.getDocRequirementAccess().getCategoryAssignment_5_0_1()); }
)
(
{ before(grammarAccess.getDocRequirementAccess().getCategoryAssignment_5_0_1()); }
(rule__DocRequirement__CategoryAssignment_5_0_1)*
{ after(grammarAccess.getDocRequirementAccess().getCategoryAssignment_5_0_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocRequirement__Group_5_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_8__0__Impl
	rule__DocRequirement__Group_5_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getMitigatesKeyword_5_8_0()); }

	Mitigates 

{ after(grammarAccess.getDocRequirementAccess().getMitigatesKeyword_5_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_5_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_8__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getAlternatives_5_8_1()); }
(rule__DocRequirement__Alternatives_5_8_1)
{ after(grammarAccess.getDocRequirementAccess().getAlternatives_5_8_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocRequirement__Group_5_9__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_9__0__Impl
	rule__DocRequirement__Group_5_9__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_9__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getRefinesKeyword_5_9_0()); }

	Refines 

{ after(grammarAccess.getDocRequirementAccess().getRefinesKeyword_5_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_5_9__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_9__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_9__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDocRequirementAccess().getRefinesReferenceAssignment_5_9_1()); }
(rule__DocRequirement__RefinesReferenceAssignment_5_9_1)
{ after(grammarAccess.getDocRequirementAccess().getRefinesReferenceAssignment_5_9_1()); }
)
(
{ before(grammarAccess.getDocRequirementAccess().getRefinesReferenceAssignment_5_9_1()); }
(rule__DocRequirement__RefinesReferenceAssignment_5_9_1)*
{ after(grammarAccess.getDocRequirementAccess().getRefinesReferenceAssignment_5_9_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocRequirement__Group_5_10__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_10__0__Impl
	rule__DocRequirement__Group_5_10__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_10__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getDecomposesKeyword_5_10_0()); }

	Decomposes 

{ after(grammarAccess.getDocRequirementAccess().getDecomposesKeyword_5_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_5_10__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_10__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_10__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDocRequirementAccess().getDecomposesReferenceAssignment_5_10_1()); }
(rule__DocRequirement__DecomposesReferenceAssignment_5_10_1)
{ after(grammarAccess.getDocRequirementAccess().getDecomposesReferenceAssignment_5_10_1()); }
)
(
{ before(grammarAccess.getDocRequirementAccess().getDecomposesReferenceAssignment_5_10_1()); }
(rule__DocRequirement__DecomposesReferenceAssignment_5_10_1)*
{ after(grammarAccess.getDocRequirementAccess().getDecomposesReferenceAssignment_5_10_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocRequirement__Group_5_11__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_11__0__Impl
	rule__DocRequirement__Group_5_11__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_11__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getInheritsKeyword_5_11_0()); }

	Inherits 

{ after(grammarAccess.getDocRequirementAccess().getInheritsKeyword_5_11_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_5_11__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_11__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_11__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getInheritsReferenceAssignment_5_11_1()); }
(rule__DocRequirement__InheritsReferenceAssignment_5_11_1)
{ after(grammarAccess.getDocRequirementAccess().getInheritsReferenceAssignment_5_11_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocRequirement__Group_5_12__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_12__0__Impl
	rule__DocRequirement__Group_5_12__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_12__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getEvolvesKeyword_5_12_0()); }

	Evolves 

{ after(grammarAccess.getDocRequirementAccess().getEvolvesKeyword_5_12_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_5_12__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_12__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_12__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDocRequirementAccess().getEvolvesReferenceAssignment_5_12_1()); }
(rule__DocRequirement__EvolvesReferenceAssignment_5_12_1)
{ after(grammarAccess.getDocRequirementAccess().getEvolvesReferenceAssignment_5_12_1()); }
)
(
{ before(grammarAccess.getDocRequirementAccess().getEvolvesReferenceAssignment_5_12_1()); }
(rule__DocRequirement__EvolvesReferenceAssignment_5_12_1)*
{ after(grammarAccess.getDocRequirementAccess().getEvolvesReferenceAssignment_5_12_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocRequirement__Group_5_13__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_13__0__Impl
	rule__DocRequirement__Group_5_13__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_13__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getDroppedAssignment_5_13_0()); }
(rule__DocRequirement__DroppedAssignment_5_13_0)
{ after(grammarAccess.getDocRequirementAccess().getDroppedAssignment_5_13_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_5_13__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_13__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_13__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getDropRationaleAssignment_5_13_1()); }
(rule__DocRequirement__DropRationaleAssignment_5_13_1)?
{ after(grammarAccess.getDocRequirementAccess().getDropRationaleAssignment_5_13_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DocRequirement__Group_5_14__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_14__0__Impl
	rule__DocRequirement__Group_5_14__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_14__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getDevelopmentKeyword_5_14_0()); }

	Development 

{ after(grammarAccess.getDocRequirementAccess().getDevelopmentKeyword_5_14_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_5_14__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_14__1__Impl
	rule__DocRequirement__Group_5_14__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_14__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getStakeholderKeyword_5_14_1()); }

	Stakeholder 

{ after(grammarAccess.getDocRequirementAccess().getStakeholderKeyword_5_14_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_5_14__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_14__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_14__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDocRequirementAccess().getDevelopmentStakeholderAssignment_5_14_2()); }
(rule__DocRequirement__DevelopmentStakeholderAssignment_5_14_2)
{ after(grammarAccess.getDocRequirementAccess().getDevelopmentStakeholderAssignment_5_14_2()); }
)
(
{ before(grammarAccess.getDocRequirementAccess().getDevelopmentStakeholderAssignment_5_14_2()); }
(rule__DocRequirement__DevelopmentStakeholderAssignment_5_14_2)*
{ after(grammarAccess.getDocRequirementAccess().getDevelopmentStakeholderAssignment_5_14_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__DocRequirement__Group_5_15__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_15__0__Impl
	rule__DocRequirement__Group_5_15__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_15__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getSeeKeyword_5_15_0()); }

	See 

{ after(grammarAccess.getDocRequirementAccess().getSeeKeyword_5_15_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_5_15__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_15__1__Impl
	rule__DocRequirement__Group_5_15__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_15__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getGoalKeyword_5_15_1()); }

	Goal 

{ after(grammarAccess.getDocRequirementAccess().getGoalKeyword_5_15_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_5_15__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_15__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_15__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDocRequirementAccess().getGoalReferenceAssignment_5_15_2()); }
(rule__DocRequirement__GoalReferenceAssignment_5_15_2)
{ after(grammarAccess.getDocRequirementAccess().getGoalReferenceAssignment_5_15_2()); }
)
(
{ before(grammarAccess.getDocRequirementAccess().getGoalReferenceAssignment_5_15_2()); }
(rule__DocRequirement__GoalReferenceAssignment_5_15_2)*
{ after(grammarAccess.getDocRequirementAccess().getGoalReferenceAssignment_5_15_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__DocRequirement__Group_5_16__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_16__0__Impl
	rule__DocRequirement__Group_5_16__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_16__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getSeeKeyword_5_16_0()); }

	See 

{ after(grammarAccess.getDocRequirementAccess().getSeeKeyword_5_16_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_5_16__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_16__1__Impl
	rule__DocRequirement__Group_5_16__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_16__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getDocumentKeyword_5_16_1()); }

	Document 

{ after(grammarAccess.getDocRequirementAccess().getDocumentKeyword_5_16_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_5_16__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_16__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_16__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDocRequirementAccess().getDocReferenceAssignment_5_16_2()); }
(rule__DocRequirement__DocReferenceAssignment_5_16_2)
{ after(grammarAccess.getDocRequirementAccess().getDocReferenceAssignment_5_16_2()); }
)
(
{ before(grammarAccess.getDocRequirementAccess().getDocReferenceAssignment_5_16_2()); }
(rule__DocRequirement__DocReferenceAssignment_5_16_2)*
{ after(grammarAccess.getDocRequirementAccess().getDocReferenceAssignment_5_16_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}








rule__DocRequirement__Group_5_17__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_17__0__Impl
	rule__DocRequirement__Group_5_17__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_17__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getIssuesKeyword_5_17_0()); }

	Issues 

{ after(grammarAccess.getDocRequirementAccess().getIssuesKeyword_5_17_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__Group_5_17__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__Group_5_17__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__Group_5_17__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDocRequirementAccess().getIssuesAssignment_5_17_1()); }
(rule__DocRequirement__IssuesAssignment_5_17_1)
{ after(grammarAccess.getDocRequirementAccess().getIssuesAssignment_5_17_1()); }
)
(
{ before(grammarAccess.getDocRequirementAccess().getIssuesAssignment_5_17_1()); }
(rule__DocRequirement__IssuesAssignment_5_17_1)*
{ after(grammarAccess.getDocRequirementAccess().getIssuesAssignment_5_17_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__IncludeGlobalRequirement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IncludeGlobalRequirement__Group__0__Impl
	rule__IncludeGlobalRequirement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IncludeGlobalRequirement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIncludeGlobalRequirementAccess().getIncludeKeyword_0()); }

	Include 

{ after(grammarAccess.getIncludeGlobalRequirementAccess().getIncludeKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IncludeGlobalRequirement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IncludeGlobalRequirement__Group__1__Impl
	rule__IncludeGlobalRequirement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IncludeGlobalRequirement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIncludeGlobalRequirementAccess().getIncludeAssignment_1()); }
(rule__IncludeGlobalRequirement__IncludeAssignment_1)
{ after(grammarAccess.getIncludeGlobalRequirementAccess().getIncludeAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IncludeGlobalRequirement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IncludeGlobalRequirement__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IncludeGlobalRequirement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIncludeGlobalRequirementAccess().getGroup_2()); }
(rule__IncludeGlobalRequirement__Group_2__0)?
{ after(grammarAccess.getIncludeGlobalRequirementAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__IncludeGlobalRequirement__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IncludeGlobalRequirement__Group_2__0__Impl
	rule__IncludeGlobalRequirement__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IncludeGlobalRequirement__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIncludeGlobalRequirementAccess().getForKeyword_2_0()); }

	For 

{ after(grammarAccess.getIncludeGlobalRequirementAccess().getForKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IncludeGlobalRequirement__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IncludeGlobalRequirement__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IncludeGlobalRequirement__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIncludeGlobalRequirementAccess().getAlternatives_2_1()); }
(rule__IncludeGlobalRequirement__Alternatives_2_1)
{ after(grammarAccess.getIncludeGlobalRequirementAccess().getAlternatives_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__WhenCondition__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group__0__Impl
	rule__WhenCondition__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getWhenKeyword_0()); }

	When 

{ after(grammarAccess.getWhenConditionAccess().getWhenKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WhenCondition__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getAlternatives_1()); }
(rule__WhenCondition__Alternatives_1)
{ after(grammarAccess.getWhenConditionAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__WhenCondition__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_0__0__Impl
	rule__WhenCondition__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getInKeyword_1_0_0()); }

	In 

{ after(grammarAccess.getWhenConditionAccess().getInKeyword_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WhenCondition__Group_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_0__1__Impl
	rule__WhenCondition__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getModeKeyword_1_0_1()); }

	Mode 

{ after(grammarAccess.getWhenConditionAccess().getModeKeyword_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WhenCondition__Group_1_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_0__2__Impl
	rule__WhenCondition__Group_1_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getInModeAssignment_1_0_2()); }
(rule__WhenCondition__InModeAssignment_1_0_2)
{ after(grammarAccess.getWhenConditionAccess().getInModeAssignment_1_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WhenCondition__Group_1_0__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_0__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_0__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getGroup_1_0_3()); }
(rule__WhenCondition__Group_1_0_3__0)*
{ after(grammarAccess.getWhenConditionAccess().getGroup_1_0_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__WhenCondition__Group_1_0_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_0_3__0__Impl
	rule__WhenCondition__Group_1_0_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_0_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getCommaKeyword_1_0_3_0()); }

	Comma 

{ after(grammarAccess.getWhenConditionAccess().getCommaKeyword_1_0_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WhenCondition__Group_1_0_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_0_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_0_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getInModeAssignment_1_0_3_1()); }
(rule__WhenCondition__InModeAssignment_1_0_3_1)
{ after(grammarAccess.getWhenConditionAccess().getInModeAssignment_1_0_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__WhenCondition__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_1__0__Impl
	rule__WhenCondition__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getInKeyword_1_1_0()); }

	In 

{ after(grammarAccess.getWhenConditionAccess().getInKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WhenCondition__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_1__1__Impl
	rule__WhenCondition__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getErrorKeyword_1_1_1()); }

	Error 

{ after(grammarAccess.getWhenConditionAccess().getErrorKeyword_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WhenCondition__Group_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_1__2__Impl
	rule__WhenCondition__Group_1_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getStateKeyword_1_1_2()); }

	State 

{ after(grammarAccess.getWhenConditionAccess().getStateKeyword_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WhenCondition__Group_1_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_1__3__Impl
	rule__WhenCondition__Group_1_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getInErrorStateAssignment_1_1_3()); }
(rule__WhenCondition__InErrorStateAssignment_1_1_3)
{ after(grammarAccess.getWhenConditionAccess().getInErrorStateAssignment_1_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WhenCondition__Group_1_1__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_1__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getGroup_1_1_4()); }
(rule__WhenCondition__Group_1_1_4__0)*
{ after(grammarAccess.getWhenConditionAccess().getGroup_1_1_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__WhenCondition__Group_1_1_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_1_4__0__Impl
	rule__WhenCondition__Group_1_1_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_1_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getCommaKeyword_1_1_4_0()); }

	Comma 

{ after(grammarAccess.getWhenConditionAccess().getCommaKeyword_1_1_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WhenCondition__Group_1_1_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_1_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_1_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getInErrorStateAssignment_1_1_4_1()); }
(rule__WhenCondition__InErrorStateAssignment_1_1_4_1)
{ after(grammarAccess.getWhenConditionAccess().getInErrorStateAssignment_1_1_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__WhenCondition__Group_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_2__0__Impl
	rule__WhenCondition__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getConditionAssignment_1_2_0()); }
(rule__WhenCondition__ConditionAssignment_1_2_0)
{ after(grammarAccess.getWhenConditionAccess().getConditionAssignment_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WhenCondition__Group_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_2__1__Impl
	rule__WhenCondition__Group_1_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getLeftParenthesisKeyword_1_2_1()); }

	LeftParenthesis 

{ after(grammarAccess.getWhenConditionAccess().getLeftParenthesisKeyword_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WhenCondition__Group_1_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WhenCondition__Group_1_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__Group_1_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getRightParenthesisKeyword_1_2_2()); }

	RightParenthesis 

{ after(grammarAccess.getWhenConditionAccess().getRightParenthesisKeyword_1_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__InformalPredicate__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InformalPredicate__Group__0__Impl
	rule__InformalPredicate__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InformalPredicate__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInformalPredicateAccess().getInformalKeyword_0()); }

	Informal 

{ after(grammarAccess.getInformalPredicateAccess().getInformalKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InformalPredicate__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InformalPredicate__Group__1__Impl
	rule__InformalPredicate__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__InformalPredicate__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInformalPredicateAccess().getPredicateKeyword_1()); }

	Predicate 

{ after(grammarAccess.getInformalPredicateAccess().getPredicateKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InformalPredicate__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InformalPredicate__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InformalPredicate__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInformalPredicateAccess().getDescriptionAssignment_2()); }
(rule__InformalPredicate__DescriptionAssignment_2)
{ after(grammarAccess.getInformalPredicateAccess().getDescriptionAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ValuePredicate__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValuePredicate__Group__0__Impl
	rule__ValuePredicate__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ValuePredicate__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValuePredicateAccess().getValueKeyword_0()); }

	Value 

{ after(grammarAccess.getValuePredicateAccess().getValueKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValuePredicate__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValuePredicate__Group__1__Impl
	rule__ValuePredicate__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ValuePredicate__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValuePredicateAccess().getPredicateKeyword_1()); }

	Predicate 

{ after(grammarAccess.getValuePredicateAccess().getPredicateKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValuePredicate__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValuePredicate__Group__2__Impl
	rule__ValuePredicate__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ValuePredicate__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValuePredicateAccess().getXpressionAssignment_2()); }
(rule__ValuePredicate__XpressionAssignment_2)
{ after(grammarAccess.getValuePredicateAccess().getXpressionAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValuePredicate__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValuePredicate__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ValuePredicate__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValuePredicateAccess().getGroup_3()); }
(rule__ValuePredicate__Group_3__0)?
{ after(grammarAccess.getValuePredicateAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ValuePredicate__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValuePredicate__Group_3__0__Impl
	rule__ValuePredicate__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ValuePredicate__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValuePredicateAccess().getWithKeyword_3_0()); }

	With 

{ after(grammarAccess.getValuePredicateAccess().getWithKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValuePredicate__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValuePredicate__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ValuePredicate__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getValuePredicateAccess().getDesiredValueAssignment_3_1()); }
(rule__ValuePredicate__DesiredValueAssignment_3_1)
{ after(grammarAccess.getValuePredicateAccess().getDesiredValueAssignment_3_1()); }
)
(
{ before(grammarAccess.getValuePredicateAccess().getDesiredValueAssignment_3_1()); }
(rule__ValuePredicate__DesiredValueAssignment_3_1)*
{ after(grammarAccess.getValuePredicateAccess().getDesiredValueAssignment_3_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DesiredValue__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DesiredValue__Group__0__Impl
	rule__DesiredValue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DesiredValue__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDesiredValueAccess().getDesiredAssignment_0()); }
(rule__DesiredValue__DesiredAssignment_0)
{ after(grammarAccess.getDesiredValueAccess().getDesiredAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DesiredValue__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DesiredValue__Group__1__Impl
	rule__DesiredValue__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DesiredValue__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDesiredValueAccess().getAlternatives_1()); }
(rule__DesiredValue__Alternatives_1)
{ after(grammarAccess.getDesiredValueAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DesiredValue__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DesiredValue__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DesiredValue__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDesiredValueAccess().getValueAssignment_2()); }
(rule__DesiredValue__ValueAssignment_2)
{ after(grammarAccess.getDesiredValueAccess().getValueAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ExternalDocument__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExternalDocument__Group__0__Impl
	rule__ExternalDocument__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ExternalDocument__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExternalDocumentAccess().getDocReferenceAssignment_0()); }
(rule__ExternalDocument__DocReferenceAssignment_0)
{ after(grammarAccess.getExternalDocumentAccess().getDocReferenceAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExternalDocument__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExternalDocument__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ExternalDocument__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExternalDocumentAccess().getGroup_1()); }
(rule__ExternalDocument__Group_1__0)?
{ after(grammarAccess.getExternalDocumentAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ExternalDocument__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExternalDocument__Group_1__0__Impl
	rule__ExternalDocument__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ExternalDocument__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExternalDocumentAccess().getNumberSignKeyword_1_0()); }

	NumberSign 

{ after(grammarAccess.getExternalDocumentAccess().getNumberSignKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExternalDocument__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExternalDocument__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ExternalDocument__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExternalDocumentAccess().getDocFragmentAssignment_1_1()); }
(rule__ExternalDocument__DocFragmentAssignment_1_1)
{ after(grammarAccess.getExternalDocumentAccess().getDocFragmentAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ValDeclaration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group__0__Impl
	rule__ValDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getReqValDeclarationAction_0()); }
(

)
{ after(grammarAccess.getValDeclarationAccess().getReqValDeclarationAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValDeclaration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group__1__Impl
	rule__ValDeclaration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getValKeyword_1()); }

	Val 

{ after(grammarAccess.getValDeclarationAccess().getValKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValDeclaration__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group__2__Impl
	rule__ValDeclaration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getNameAssignment_2()); }
(rule__ValDeclaration__NameAssignment_2)
{ after(grammarAccess.getValDeclarationAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValDeclaration__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group__3__Impl
	rule__ValDeclaration__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getGroup_3()); }
(rule__ValDeclaration__Group_3__0)?
{ after(grammarAccess.getValDeclarationAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValDeclaration__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group__4__Impl
	rule__ValDeclaration__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getEqualsSignKeyword_4()); }

	EqualsSign 

{ after(grammarAccess.getValDeclarationAccess().getEqualsSignKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValDeclaration__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group__5__Impl
	rule__ValDeclaration__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getValueAssignment_5()); }
(rule__ValDeclaration__ValueAssignment_5)
{ after(grammarAccess.getValDeclarationAccess().getValueAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValDeclaration__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getGroup_6()); }
(rule__ValDeclaration__Group_6__0)?
{ after(grammarAccess.getValDeclarationAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__ValDeclaration__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group_3__0__Impl
	rule__ValDeclaration__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getColonKeyword_3_0()); }

	Colon 

{ after(grammarAccess.getValDeclarationAccess().getColonKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValDeclaration__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getAlternatives_3_1()); }
(rule__ValDeclaration__Alternatives_3_1)
{ after(grammarAccess.getValDeclarationAccess().getAlternatives_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ValDeclaration__Group_3_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group_3_1_1__0__Impl
	rule__ValDeclaration__Group_3_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group_3_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getTypeofKeyword_3_1_1_0()); }

	Typeof 

{ after(grammarAccess.getValDeclarationAccess().getTypeofKeyword_3_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValDeclaration__Group_3_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group_3_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group_3_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_1_1()); }
(rule__ValDeclaration__TypeAssignment_3_1_1_1)
{ after(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ValDeclaration__Group_3_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group_3_1_2__0__Impl
	rule__ValDeclaration__Group_3_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group_3_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getRangeAssignment_3_1_2_0()); }
(rule__ValDeclaration__RangeAssignment_3_1_2_0)
{ after(grammarAccess.getValDeclarationAccess().getRangeAssignment_3_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValDeclaration__Group_3_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group_3_1_2__1__Impl
	rule__ValDeclaration__Group_3_1_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group_3_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getAlternatives_3_1_2_1()); }
(rule__ValDeclaration__Alternatives_3_1_2_1)
{ after(grammarAccess.getValDeclarationAccess().getAlternatives_3_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValDeclaration__Group_3_1_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group_3_1_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group_3_1_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getRightSquareBracketKeyword_3_1_2_2()); }

	RightSquareBracket 

{ after(grammarAccess.getValDeclarationAccess().getRightSquareBracketKeyword_3_1_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ValDeclaration__Group_3_1_2_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group_3_1_2_1_1__0__Impl
	rule__ValDeclaration__Group_3_1_2_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group_3_1_2_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getTypeofKeyword_3_1_2_1_1_0()); }

	Typeof 

{ after(grammarAccess.getValDeclarationAccess().getTypeofKeyword_3_1_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValDeclaration__Group_3_1_2_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group_3_1_2_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group_3_1_2_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_2_1_1_1()); }
(rule__ValDeclaration__TypeAssignment_3_1_2_1_1_1)
{ after(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_2_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ValDeclaration__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group_6__0__Impl
	rule__ValDeclaration__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getAsKeyword_6_0()); }

	As 

{ after(grammarAccess.getValDeclarationAccess().getAsKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ValDeclaration__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ValDeclaration__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getPropertyAssignment_6_1()); }
(rule__ValDeclaration__PropertyAssignment_6_1)
{ after(grammarAccess.getValDeclarationAccess().getPropertyAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DOCPATH__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DOCPATH__Group__0__Impl
	rule__DOCPATH__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DOCPATH__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDOCPATHAccess().getGroup_0()); }
(rule__DOCPATH__Group_0__0)*
{ after(grammarAccess.getDOCPATHAccess().getGroup_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DOCPATH__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DOCPATH__Group__1__Impl
	rule__DOCPATH__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DOCPATH__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_1()); }
	RULE_ID
{ after(grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DOCPATH__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DOCPATH__Group__2__Impl
	rule__DOCPATH__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DOCPATH__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDOCPATHAccess().getFullStopKeyword_2()); }

	FullStop 

{ after(grammarAccess.getDOCPATHAccess().getFullStopKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DOCPATH__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DOCPATH__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DOCPATH__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_3()); }
	RULE_ID
{ after(grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__DOCPATH__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DOCPATH__Group_0__0__Impl
	rule__DOCPATH__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DOCPATH__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_0_0()); }
	RULE_ID
{ after(grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DOCPATH__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DOCPATH__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DOCPATH__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDOCPATHAccess().getSolidusKeyword_0_1()); }

	Solidus 

{ after(grammarAccess.getDOCPATHAccess().getSolidusKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Description__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Description__Group__0__Impl
	rule__Description__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDescriptionAccess().getDescriptionKeyword_0()); }

	Description 

{ after(grammarAccess.getDescriptionAccess().getDescriptionKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Description__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Description__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Description__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDescriptionAccess().getDescriptionAssignment_1()); }
(rule__Description__DescriptionAssignment_1)
{ after(grammarAccess.getDescriptionAccess().getDescriptionAssignment_1()); }
)
(
{ before(grammarAccess.getDescriptionAccess().getDescriptionAssignment_1()); }
(rule__Description__DescriptionAssignment_1)*
{ after(grammarAccess.getDescriptionAccess().getDescriptionAssignment_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Rationale__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Rationale__Group__0__Impl
	rule__Rationale__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Rationale__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRationaleAccess().getRationaleKeyword_0()); }

	Rationale 

{ after(grammarAccess.getRationaleAccess().getRationaleKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Rationale__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Rationale__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Rationale__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getRationaleAccess().getDescriptionAssignment_1()); }
(rule__Rationale__DescriptionAssignment_1)
{ after(grammarAccess.getRationaleAccess().getDescriptionAssignment_1()); }
)
(
{ before(grammarAccess.getRationaleAccess().getDescriptionAssignment_1()); }
(rule__Rationale__DescriptionAssignment_1)*
{ after(grammarAccess.getRationaleAccess().getDescriptionAssignment_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Uncertainty__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Uncertainty__Group__0__Impl
	rule__Uncertainty__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Uncertainty__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUncertaintyAccess().getUncertaintyAction_0()); }
(

)
{ after(grammarAccess.getUncertaintyAccess().getUncertaintyAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Uncertainty__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Uncertainty__Group__1__Impl
	rule__Uncertainty__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Uncertainty__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUncertaintyAccess().getUncertaintyKeyword_1()); }

	Uncertainty 

{ after(grammarAccess.getUncertaintyAccess().getUncertaintyKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Uncertainty__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Uncertainty__Group__2__Impl
	rule__Uncertainty__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Uncertainty__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUncertaintyAccess().getLeftSquareBracketKeyword_2()); }

	LeftSquareBracket 

{ after(grammarAccess.getUncertaintyAccess().getLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Uncertainty__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Uncertainty__Group__3__Impl
	rule__Uncertainty__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Uncertainty__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3()); }
(rule__Uncertainty__UnorderedGroup_3)
{ after(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Uncertainty__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Uncertainty__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Uncertainty__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUncertaintyAccess().getRightSquareBracketKeyword_4()); }

	RightSquareBracket 

{ after(grammarAccess.getUncertaintyAccess().getRightSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__Uncertainty__Group_3_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Uncertainty__Group_3_0__0__Impl
	rule__Uncertainty__Group_3_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Uncertainty__Group_3_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUncertaintyAccess().getVolatilityKeyword_3_0_0()); }

	Volatility 

{ after(grammarAccess.getUncertaintyAccess().getVolatilityKeyword_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Uncertainty__Group_3_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Uncertainty__Group_3_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Uncertainty__Group_3_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUncertaintyAccess().getVolatilityAssignment_3_0_1()); }
(rule__Uncertainty__VolatilityAssignment_3_0_1)
{ after(grammarAccess.getUncertaintyAccess().getVolatilityAssignment_3_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Uncertainty__Group_3_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Uncertainty__Group_3_1__0__Impl
	rule__Uncertainty__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Uncertainty__Group_3_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUncertaintyAccess().getPrecedenceKeyword_3_1_0()); }

	Precedence 

{ after(grammarAccess.getUncertaintyAccess().getPrecedenceKeyword_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Uncertainty__Group_3_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Uncertainty__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Uncertainty__Group_3_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUncertaintyAccess().getPrecedenceAssignment_3_1_1()); }
(rule__Uncertainty__PrecedenceAssignment_3_1_1)
{ after(grammarAccess.getUncertaintyAccess().getPrecedenceAssignment_3_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Uncertainty__Group_3_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Uncertainty__Group_3_2__0__Impl
	rule__Uncertainty__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Uncertainty__Group_3_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUncertaintyAccess().getImpactKeyword_3_2_0()); }

	Impact 

{ after(grammarAccess.getUncertaintyAccess().getImpactKeyword_3_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Uncertainty__Group_3_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Uncertainty__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Uncertainty__Group_3_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUncertaintyAccess().getImpactAssignment_3_2_1()); }
(rule__Uncertainty__ImpactAssignment_3_2_1)
{ after(grammarAccess.getUncertaintyAccess().getImpactAssignment_3_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeRef__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_0__0__Impl
	rule__TypeRef__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getAadlBooleanAction_0_0()); }
(

)
{ after(grammarAccess.getTypeRefAccess().getAadlBooleanAction_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getBooleanKeyword_0_1()); }

	Boolean 

{ after(grammarAccess.getTypeRefAccess().getBooleanKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeRef__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_1__0__Impl
	rule__TypeRef__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getAadlIntegerAction_1_0()); }
(

)
{ after(grammarAccess.getTypeRefAccess().getAadlIntegerAction_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_1__1__Impl
	rule__TypeRef__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getIntegerKeyword_1_1()); }

	Integer 

{ after(grammarAccess.getTypeRefAccess().getIntegerKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getGroup_1_2()); }
(rule__TypeRef__Group_1_2__0)?
{ after(grammarAccess.getTypeRefAccess().getGroup_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypeRef__Group_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_1_2__0__Impl
	rule__TypeRef__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getUnitsKeyword_1_2_0()); }

	Units 

{ after(grammarAccess.getTypeRefAccess().getUnitsKeyword_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeAssignment_1_2_1()); }
(rule__TypeRef__ReferencedUnitsTypeAssignment_1_2_1)
{ after(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeAssignment_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeRef__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_2__0__Impl
	rule__TypeRef__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getAadlRealAction_2_0()); }
(

)
{ after(grammarAccess.getTypeRefAccess().getAadlRealAction_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_2__1__Impl
	rule__TypeRef__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getRealKeyword_2_1()); }

	Real 

{ after(grammarAccess.getTypeRefAccess().getRealKeyword_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getGroup_2_2()); }
(rule__TypeRef__Group_2_2__0)?
{ after(grammarAccess.getTypeRefAccess().getGroup_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypeRef__Group_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_2_2__0__Impl
	rule__TypeRef__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getUnitsKeyword_2_2_0()); }

	Units 

{ after(grammarAccess.getTypeRefAccess().getUnitsKeyword_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeAssignment_2_2_1()); }
(rule__TypeRef__ReferencedUnitsTypeAssignment_2_2_1)
{ after(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeAssignment_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeRef__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_3__0__Impl
	rule__TypeRef__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getAadlStringAction_3_0()); }
(

)
{ after(grammarAccess.getTypeRefAccess().getAadlStringAction_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getStringKeyword_3_1()); }

	String 

{ after(grammarAccess.getTypeRefAccess().getStringKeyword_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeRef__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_4__0__Impl
	rule__TypeRef__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getModelRefAction_4_0()); }
(

)
{ after(grammarAccess.getTypeRefAccess().getModelRefAction_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_4__1__Impl
	rule__TypeRef__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getModelKeyword_4_1()); }

	Model 

{ after(grammarAccess.getTypeRefAccess().getModelKeyword_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getElementKeyword_4_2()); }

	Element 

{ after(grammarAccess.getTypeRefAccess().getElementKeyword_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypeRef__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_5__0__Impl
	rule__TypeRef__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getTypeRefAction_5_0()); }
(

)
{ after(grammarAccess.getTypeRefAccess().getTypeRefAction_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRef__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getRefAssignment_5_1()); }
(rule__TypeRef__RefAssignment_5_1)
{ after(grammarAccess.getTypeRefAccess().getRefAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PropertyRef__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyRef__Group__0__Impl
	rule__PropertyRef__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyRef__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyRefAccess().getPropertyRefAction_0()); }
(

)
{ after(grammarAccess.getPropertyRefAccess().getPropertyRefAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyRef__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyRef__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyRef__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyRefAccess().getRefAssignment_1()); }
(rule__PropertyRef__RefAssignment_1)
{ after(grammarAccess.getPropertyRefAccess().getRefAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ComputeDeclaration__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputeDeclaration__Group__0__Impl
	rule__ComputeDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getComputeDeclarationAction_0()); }
(

)
{ after(grammarAccess.getComputeDeclarationAccess().getComputeDeclarationAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComputeDeclaration__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputeDeclaration__Group__1__Impl
	rule__ComputeDeclaration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getComputeKeyword_1()); }

	Compute 

{ after(grammarAccess.getComputeDeclarationAccess().getComputeKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComputeDeclaration__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputeDeclaration__Group__2__Impl
	rule__ComputeDeclaration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getNameAssignment_2()); }
(rule__ComputeDeclaration__NameAssignment_2)
{ after(grammarAccess.getComputeDeclarationAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComputeDeclaration__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputeDeclaration__Group__3__Impl
	rule__ComputeDeclaration__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getColonKeyword_3()); }

	Colon 

{ after(grammarAccess.getComputeDeclarationAccess().getColonKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComputeDeclaration__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputeDeclaration__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getAlternatives_4()); }
(rule__ComputeDeclaration__Alternatives_4)
{ after(grammarAccess.getComputeDeclarationAccess().getAlternatives_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__ComputeDeclaration__Group_4_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputeDeclaration__Group_4_1__0__Impl
	rule__ComputeDeclaration__Group_4_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__Group_4_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getTypeofKeyword_4_1_0()); }

	Typeof 

{ after(grammarAccess.getComputeDeclarationAccess().getTypeofKeyword_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComputeDeclaration__Group_4_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputeDeclaration__Group_4_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__Group_4_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_1_1()); }
(rule__ComputeDeclaration__TypeAssignment_4_1_1)
{ after(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ComputeDeclaration__Group_4_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputeDeclaration__Group_4_2__0__Impl
	rule__ComputeDeclaration__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__Group_4_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getRangeAssignment_4_2_0()); }
(rule__ComputeDeclaration__RangeAssignment_4_2_0)
{ after(grammarAccess.getComputeDeclarationAccess().getRangeAssignment_4_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComputeDeclaration__Group_4_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputeDeclaration__Group_4_2__1__Impl
	rule__ComputeDeclaration__Group_4_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__Group_4_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getAlternatives_4_2_1()); }
(rule__ComputeDeclaration__Alternatives_4_2_1)
{ after(grammarAccess.getComputeDeclarationAccess().getAlternatives_4_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComputeDeclaration__Group_4_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputeDeclaration__Group_4_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__Group_4_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getRightSquareBracketKeyword_4_2_2()); }

	RightSquareBracket 

{ after(grammarAccess.getComputeDeclarationAccess().getRightSquareBracketKeyword_4_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ComputeDeclaration__Group_4_2_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputeDeclaration__Group_4_2_1_1__0__Impl
	rule__ComputeDeclaration__Group_4_2_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__Group_4_2_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getTypeofKeyword_4_2_1_1_0()); }

	Typeof 

{ after(grammarAccess.getComputeDeclarationAccess().getTypeofKeyword_4_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComputeDeclaration__Group_4_2_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputeDeclaration__Group_4_2_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__Group_4_2_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_2_1_1_1()); }
(rule__ComputeDeclaration__TypeAssignment_4_2_1_1_1)
{ after(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_2_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AModelOrPropertyReference__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelOrPropertyReference__Group_0__0__Impl
	rule__AModelOrPropertyReference__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getAModelReferenceParserRuleCall_0_0()); }
	ruleAModelReference
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getAModelReferenceParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AModelOrPropertyReference__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelOrPropertyReference__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1()); }
(rule__AModelOrPropertyReference__Group_0_1__0)?
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AModelOrPropertyReference__Group_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelOrPropertyReference__Group_0_1__0__Impl
	rule__AModelOrPropertyReference__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__Group_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1_0()); }
(rule__AModelOrPropertyReference__Group_0_1_0__0)
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AModelOrPropertyReference__Group_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelOrPropertyReference__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__Group_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAssignment_0_1_1()); }
(rule__AModelOrPropertyReference__PropertyAssignment_0_1_1)
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AModelOrPropertyReference__Group_0_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelOrPropertyReference__Group_0_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__Group_0_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1_0_0()); }
(rule__AModelOrPropertyReference__Group_0_1_0_0__0)
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__AModelOrPropertyReference__Group_0_1_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelOrPropertyReference__Group_0_1_0_0__0__Impl
	rule__AModelOrPropertyReference__Group_0_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__Group_0_1_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceModelElementReferenceAction_0_1_0_0_0()); }
(

)
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceModelElementReferenceAction_0_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AModelOrPropertyReference__Group_0_1_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelOrPropertyReference__Group_0_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__Group_0_1_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getNumberSignKeyword_0_1_0_0_1()); }

	NumberSign 

{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getNumberSignKeyword_0_1_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AModelReference__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelReference__Group__0__Impl
	rule__AModelReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelReference__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelReferenceAccess().getModelElementAssignment_0()); }
(rule__AModelReference__ModelElementAssignment_0)
{ after(grammarAccess.getAModelReferenceAccess().getModelElementAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AModelReference__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelReference__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelReference__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelReferenceAccess().getGroup_1()); }
(rule__AModelReference__Group_1__0)*
{ after(grammarAccess.getAModelReferenceAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AModelReference__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelReference__Group_1__0__Impl
	rule__AModelReference__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelReference__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelReferenceAccess().getAModelReferencePrevAction_1_0()); }
(

)
{ after(grammarAccess.getAModelReferenceAccess().getAModelReferencePrevAction_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AModelReference__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelReference__Group_1__1__Impl
	rule__AModelReference__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelReference__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelReferenceAccess().getFullStopKeyword_1_1()); }

	FullStop 

{ after(grammarAccess.getAModelReferenceAccess().getFullStopKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AModelReference__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AModelReference__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AModelReference__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelReferenceAccess().getModelElementAssignment_1_2()); }
(rule__AModelReference__ModelElementAssignment_1_2)
{ after(grammarAccess.getAModelReferenceAccess().getModelElementAssignment_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__APropertyReference__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__APropertyReference__Group__0__Impl
	rule__APropertyReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__APropertyReference__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAPropertyReferenceAccess().getAPropertyReferenceAction_0()); }
(

)
{ after(grammarAccess.getAPropertyReferenceAccess().getAPropertyReferenceAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__APropertyReference__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__APropertyReference__Group__1__Impl
	rule__APropertyReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__APropertyReference__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAPropertyReferenceAccess().getNumberSignKeyword_1()); }

	NumberSign 

{ after(grammarAccess.getAPropertyReferenceAccess().getNumberSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__APropertyReference__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__APropertyReference__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__APropertyReference__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAPropertyReferenceAccess().getPropertyAssignment_2()); }
(rule__APropertyReference__PropertyAssignment_2)
{ after(grammarAccess.getAPropertyReferenceAccess().getPropertyAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AVariableReference__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AVariableReference__Group__0__Impl
	rule__AVariableReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AVariableReference__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAVariableReferenceAccess().getAVariableReferenceAction_0()); }
(

)
{ after(grammarAccess.getAVariableReferenceAccess().getAVariableReferenceAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AVariableReference__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AVariableReference__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AVariableReference__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAVariableReferenceAccess().getVariableAssignment_1()); }
(rule__AVariableReference__VariableAssignment_1)
{ after(grammarAccess.getAVariableReferenceAccess().getVariableAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ShowValue__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ShowValue__Group__0__Impl
	rule__ShowValue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getExpressionAssignment_0()); }
(rule__ShowValue__ExpressionAssignment_0)
{ after(grammarAccess.getShowValueAccess().getExpressionAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ShowValue__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ShowValue__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getGroup_1()); }
(rule__ShowValue__Group_1__0)?
{ after(grammarAccess.getShowValueAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ShowValue__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ShowValue__Group_1__0__Impl
	rule__ShowValue__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getAlternatives_1_0()); }
(rule__ShowValue__Alternatives_1_0)
{ after(grammarAccess.getShowValueAccess().getAlternatives_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ShowValue__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ShowValue__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getUnitAssignment_1_1()); }
(rule__ShowValue__UnitAssignment_1_1)
{ after(grammarAccess.getShowValueAccess().getUnitAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ImageReference__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImageReference__Group__0__Impl
	rule__ImageReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ImageReference__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImageReferenceAccess().getImgKeyword_0()); }

	Img 

{ after(grammarAccess.getImageReferenceAccess().getImgKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImageReference__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImageReference__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ImageReference__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImageReferenceAccess().getImgfileAssignment_1()); }
(rule__ImageReference__ImgfileAssignment_1)
{ after(grammarAccess.getImageReferenceAccess().getImgfileAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__IMGREF__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IMGREF__Group__0__Impl
	rule__IMGREF__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IMGREF__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIMGREFAccess().getGroup_0()); }
(rule__IMGREF__Group_0__0)*
{ after(grammarAccess.getIMGREFAccess().getGroup_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IMGREF__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IMGREF__Group__1__Impl
	rule__IMGREF__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IMGREF__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_1()); }
	RULE_ID
{ after(grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IMGREF__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IMGREF__Group__2__Impl
	rule__IMGREF__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__IMGREF__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIMGREFAccess().getFullStopKeyword_2()); }

	FullStop 

{ after(grammarAccess.getIMGREFAccess().getFullStopKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IMGREF__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IMGREF__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IMGREF__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_3()); }
	RULE_ID
{ after(grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__IMGREF__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IMGREF__Group_0__0__Impl
	rule__IMGREF__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IMGREF__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_0_0()); }
	RULE_ID
{ after(grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IMGREF__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IMGREF__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IMGREF__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIMGREFAccess().getSolidusKeyword_0_1()); }

	Solidus 

{ after(grammarAccess.getIMGREFAccess().getSolidusKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AOrExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AOrExpression__Group__0__Impl
	rule__AOrExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getAAndExpressionParserRuleCall_0()); }
	ruleAAndExpression
{ after(grammarAccess.getAOrExpressionAccess().getAAndExpressionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AOrExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AOrExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getGroup_1()); }
(rule__AOrExpression__Group_1__0)*
{ after(grammarAccess.getAOrExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AOrExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AOrExpression__Group_1__0__Impl
	rule__AOrExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getGroup_1_0()); }
(rule__AOrExpression__Group_1_0__0)
{ after(grammarAccess.getAOrExpressionAccess().getGroup_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AOrExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AOrExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getRightAssignment_1_1()); }
(rule__AOrExpression__RightAssignment_1_1)
{ after(grammarAccess.getAOrExpressionAccess().getRightAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AOrExpression__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AOrExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getGroup_1_0_0()); }
(rule__AOrExpression__Group_1_0_0__0)
{ after(grammarAccess.getAOrExpressionAccess().getGroup_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__AOrExpression__Group_1_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AOrExpression__Group_1_0_0__0__Impl
	rule__AOrExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__Group_1_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
(

)
{ after(grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AOrExpression__Group_1_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AOrExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__Group_1_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getOperatorAssignment_1_0_0_1()); }
(rule__AOrExpression__OperatorAssignment_1_0_0_1)
{ after(grammarAccess.getAOrExpressionAccess().getOperatorAssignment_1_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AAndExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAndExpression__Group__0__Impl
	rule__AAndExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getAEqualityExpressionParserRuleCall_0()); }
	ruleAEqualityExpression
{ after(grammarAccess.getAAndExpressionAccess().getAEqualityExpressionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AAndExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAndExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getGroup_1()); }
(rule__AAndExpression__Group_1__0)*
{ after(grammarAccess.getAAndExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AAndExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAndExpression__Group_1__0__Impl
	rule__AAndExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getGroup_1_0()); }
(rule__AAndExpression__Group_1_0__0)
{ after(grammarAccess.getAAndExpressionAccess().getGroup_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AAndExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAndExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getRightAssignment_1_1()); }
(rule__AAndExpression__RightAssignment_1_1)
{ after(grammarAccess.getAAndExpressionAccess().getRightAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AAndExpression__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAndExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getGroup_1_0_0()); }
(rule__AAndExpression__Group_1_0_0__0)
{ after(grammarAccess.getAAndExpressionAccess().getGroup_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__AAndExpression__Group_1_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAndExpression__Group_1_0_0__0__Impl
	rule__AAndExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__Group_1_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
(

)
{ after(grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AAndExpression__Group_1_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAndExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__Group_1_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getOperatorAssignment_1_0_0_1()); }
(rule__AAndExpression__OperatorAssignment_1_0_0_1)
{ after(grammarAccess.getAAndExpressionAccess().getOperatorAssignment_1_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AEqualityExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AEqualityExpression__Group__0__Impl
	rule__AEqualityExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getARelationalExpressionParserRuleCall_0()); }
	ruleARelationalExpression
{ after(grammarAccess.getAEqualityExpressionAccess().getARelationalExpressionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AEqualityExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AEqualityExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getGroup_1()); }
(rule__AEqualityExpression__Group_1__0)*
{ after(grammarAccess.getAEqualityExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AEqualityExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AEqualityExpression__Group_1__0__Impl
	rule__AEqualityExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getGroup_1_0()); }
(rule__AEqualityExpression__Group_1_0__0)
{ after(grammarAccess.getAEqualityExpressionAccess().getGroup_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AEqualityExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AEqualityExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getRightAssignment_1_1()); }
(rule__AEqualityExpression__RightAssignment_1_1)
{ after(grammarAccess.getAEqualityExpressionAccess().getRightAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AEqualityExpression__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AEqualityExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getGroup_1_0_0()); }
(rule__AEqualityExpression__Group_1_0_0__0)
{ after(grammarAccess.getAEqualityExpressionAccess().getGroup_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__AEqualityExpression__Group_1_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AEqualityExpression__Group_1_0_0__0__Impl
	rule__AEqualityExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__Group_1_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
(

)
{ after(grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AEqualityExpression__Group_1_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AEqualityExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__Group_1_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getOperatorAssignment_1_0_0_1()); }
(rule__AEqualityExpression__OperatorAssignment_1_0_0_1)
{ after(grammarAccess.getAEqualityExpressionAccess().getOperatorAssignment_1_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ARelationalExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARelationalExpression__Group__0__Impl
	rule__ARelationalExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getAAdditiveExpressionParserRuleCall_0()); }
	ruleAAdditiveExpression
{ after(grammarAccess.getARelationalExpressionAccess().getAAdditiveExpressionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARelationalExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARelationalExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getGroup_1()); }
(rule__ARelationalExpression__Group_1__0)*
{ after(grammarAccess.getARelationalExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ARelationalExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARelationalExpression__Group_1__0__Impl
	rule__ARelationalExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getGroup_1_0()); }
(rule__ARelationalExpression__Group_1_0__0)
{ after(grammarAccess.getARelationalExpressionAccess().getGroup_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARelationalExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARelationalExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getRightAssignment_1_1()); }
(rule__ARelationalExpression__RightAssignment_1_1)
{ after(grammarAccess.getARelationalExpressionAccess().getRightAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ARelationalExpression__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARelationalExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getGroup_1_0_0()); }
(rule__ARelationalExpression__Group_1_0_0__0)
{ after(grammarAccess.getARelationalExpressionAccess().getGroup_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__ARelationalExpression__Group_1_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARelationalExpression__Group_1_0_0__0__Impl
	rule__ARelationalExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__Group_1_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
(

)
{ after(grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARelationalExpression__Group_1_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARelationalExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__Group_1_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getOperatorAssignment_1_0_0_1()); }
(rule__ARelationalExpression__OperatorAssignment_1_0_0_1)
{ after(grammarAccess.getARelationalExpressionAccess().getOperatorAssignment_1_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AAdditiveExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAdditiveExpression__Group__0__Impl
	rule__AAdditiveExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getAMultiplicativeExpressionParserRuleCall_0()); }
	ruleAMultiplicativeExpression
{ after(grammarAccess.getAAdditiveExpressionAccess().getAMultiplicativeExpressionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AAdditiveExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAdditiveExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getGroup_1()); }
(rule__AAdditiveExpression__Group_1__0)*
{ after(grammarAccess.getAAdditiveExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AAdditiveExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAdditiveExpression__Group_1__0__Impl
	rule__AAdditiveExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0()); }
(rule__AAdditiveExpression__Group_1_0__0)
{ after(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AAdditiveExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAdditiveExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getRightAssignment_1_1()); }
(rule__AAdditiveExpression__RightAssignment_1_1)
{ after(grammarAccess.getAAdditiveExpressionAccess().getRightAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AAdditiveExpression__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAdditiveExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0_0()); }
(rule__AAdditiveExpression__Group_1_0_0__0)
{ after(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__AAdditiveExpression__Group_1_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAdditiveExpression__Group_1_0_0__0__Impl
	rule__AAdditiveExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__Group_1_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
(

)
{ after(grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AAdditiveExpression__Group_1_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AAdditiveExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__Group_1_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getOperatorAssignment_1_0_0_1()); }
(rule__AAdditiveExpression__OperatorAssignment_1_0_0_1)
{ after(grammarAccess.getAAdditiveExpressionAccess().getOperatorAssignment_1_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AMultiplicativeExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AMultiplicativeExpression__Group__0__Impl
	rule__AMultiplicativeExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getAUnaryOperationParserRuleCall_0()); }
	ruleAUnaryOperation
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getAUnaryOperationParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AMultiplicativeExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AMultiplicativeExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1()); }
(rule__AMultiplicativeExpression__Group_1__0)*
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AMultiplicativeExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AMultiplicativeExpression__Group_1__0__Impl
	rule__AMultiplicativeExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0()); }
(rule__AMultiplicativeExpression__Group_1_0__0)
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AMultiplicativeExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AMultiplicativeExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getRightAssignment_1_1()); }
(rule__AMultiplicativeExpression__RightAssignment_1_1)
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getRightAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AMultiplicativeExpression__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AMultiplicativeExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0_0()); }
(rule__AMultiplicativeExpression__Group_1_0_0__0)
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__AMultiplicativeExpression__Group_1_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AMultiplicativeExpression__Group_1_0_0__0__Impl
	rule__AMultiplicativeExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__Group_1_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
(

)
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AMultiplicativeExpression__Group_1_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AMultiplicativeExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__Group_1_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorAssignment_1_0_0_1()); }
(rule__AMultiplicativeExpression__OperatorAssignment_1_0_0_1)
{ after(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorAssignment_1_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AUnaryOperation__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnaryOperation__Group_0__0__Impl
	rule__AUnaryOperation__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnaryOperation__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnaryOperationAccess().getAUnaryOperationAction_0_0()); }
(

)
{ after(grammarAccess.getAUnaryOperationAccess().getAUnaryOperationAction_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AUnaryOperation__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnaryOperation__Group_0__1__Impl
	rule__AUnaryOperation__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnaryOperation__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnaryOperationAccess().getOperatorAssignment_0_1()); }
(rule__AUnaryOperation__OperatorAssignment_0_1)
{ after(grammarAccess.getAUnaryOperationAccess().getOperatorAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AUnaryOperation__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnaryOperation__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnaryOperation__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnaryOperationAccess().getOperandAssignment_0_2()); }
(rule__AUnaryOperation__OperandAssignment_0_2)
{ after(grammarAccess.getAUnaryOperationAccess().getOperandAssignment_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AUnitExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnitExpression__Group__0__Impl
	rule__AUnitExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getAPrimaryExpressionParserRuleCall_0()); }
	ruleAPrimaryExpression
{ after(grammarAccess.getAUnitExpressionAccess().getAPrimaryExpressionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AUnitExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnitExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getGroup_1()); }
(rule__AUnitExpression__Group_1__0)?
{ after(grammarAccess.getAUnitExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AUnitExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnitExpression__Group_1__0__Impl
	rule__AUnitExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getAUnitExpressionExpressionAction_1_0()); }
(

)
{ after(grammarAccess.getAUnitExpressionAccess().getAUnitExpressionExpressionAction_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AUnitExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnitExpression__Group_1__1__Impl
	rule__AUnitExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getAlternatives_1_1()); }
(rule__AUnitExpression__Alternatives_1_1)?
{ after(grammarAccess.getAUnitExpressionAccess().getAlternatives_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AUnitExpression__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AUnitExpression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getUnitAssignment_1_2()); }
(rule__AUnitExpression__UnitAssignment_1_2)
{ after(grammarAccess.getAUnitExpressionAccess().getUnitAssignment_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AFunctionCall__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group__0__Impl
	rule__AFunctionCall__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getAFunctionCallAction_0()); }
(

)
{ after(grammarAccess.getAFunctionCallAccess().getAFunctionCallAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AFunctionCall__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group__1__Impl
	rule__AFunctionCall__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getFunctionAssignment_1()); }
(rule__AFunctionCall__FunctionAssignment_1)
{ after(grammarAccess.getAFunctionCallAccess().getFunctionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AFunctionCall__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group__2__Impl
	rule__AFunctionCall__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getLeftParenthesisKeyword_2()); }

	LeftParenthesis 

{ after(grammarAccess.getAFunctionCallAccess().getLeftParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AFunctionCall__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group__3__Impl
	rule__AFunctionCall__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getGroup_3()); }
(rule__AFunctionCall__Group_3__0)?
{ after(grammarAccess.getAFunctionCallAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AFunctionCall__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getRightParenthesisKeyword_4()); }

	RightParenthesis 

{ after(grammarAccess.getAFunctionCallAccess().getRightParenthesisKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__AFunctionCall__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group_3__0__Impl
	rule__AFunctionCall__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getArgumentsAssignment_3_0()); }
(rule__AFunctionCall__ArgumentsAssignment_3_0)
{ after(grammarAccess.getAFunctionCallAccess().getArgumentsAssignment_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AFunctionCall__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getGroup_3_1()); }
(rule__AFunctionCall__Group_3_1__0)*
{ after(grammarAccess.getAFunctionCallAccess().getGroup_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AFunctionCall__Group_3_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group_3_1__0__Impl
	rule__AFunctionCall__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group_3_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getCommaKeyword_3_1_0()); }

	Comma 

{ after(grammarAccess.getAFunctionCallAccess().getCommaKeyword_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AFunctionCall__Group_3_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AFunctionCall__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__Group_3_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getArgumentsAssignment_3_1_1()); }
(rule__AFunctionCall__ArgumentsAssignment_3_1_1)
{ after(grammarAccess.getAFunctionCallAccess().getArgumentsAssignment_3_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ARangeExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group__0__Impl
	rule__ARangeExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getARangeAction_0()); }
(

)
{ after(grammarAccess.getARangeExpressionAccess().getARangeAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARangeExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group__1__Impl
	rule__ARangeExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getLeftSquareBracketKeyword_1()); }

	LeftSquareBracket 

{ after(grammarAccess.getARangeExpressionAccess().getLeftSquareBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARangeExpression__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group__2__Impl
	rule__ARangeExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getMinimumAssignment_2()); }
(rule__ARangeExpression__MinimumAssignment_2)
{ after(grammarAccess.getARangeExpressionAccess().getMinimumAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARangeExpression__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group__3__Impl
	rule__ARangeExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getFullStopFullStopKeyword_3()); }

	FullStopFullStop 

{ after(grammarAccess.getARangeExpressionAccess().getFullStopFullStopKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARangeExpression__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group__4__Impl
	rule__ARangeExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getMaximumAssignment_4()); }
(rule__ARangeExpression__MaximumAssignment_4)
{ after(grammarAccess.getARangeExpressionAccess().getMaximumAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARangeExpression__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group__5__Impl
	rule__ARangeExpression__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getGroup_5()); }
(rule__ARangeExpression__Group_5__0)?
{ after(grammarAccess.getARangeExpressionAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARangeExpression__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getRightSquareBracketKeyword_6()); }

	RightSquareBracket 

{ after(grammarAccess.getARangeExpressionAccess().getRightSquareBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__ARangeExpression__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group_5__0__Impl
	rule__ARangeExpression__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getDeltaKeyword_5_0()); }
(
	Delta 
)
{ after(grammarAccess.getARangeExpressionAccess().getDeltaKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ARangeExpression__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ARangeExpression__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getDeltaAssignment_5_1()); }
(rule__ARangeExpression__DeltaAssignment_5_1)
{ after(grammarAccess.getARangeExpressionAccess().getDeltaAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AIfExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group__0__Impl
	rule__AIfExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getAConditionalAction_0()); }
(

)
{ after(grammarAccess.getAIfExpressionAccess().getAConditionalAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AIfExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group__1__Impl
	rule__AIfExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getIfKeyword_1()); }

	If 

{ after(grammarAccess.getAIfExpressionAccess().getIfKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AIfExpression__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group__2__Impl
	rule__AIfExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getIfAssignment_2()); }
(rule__AIfExpression__IfAssignment_2)
{ after(grammarAccess.getAIfExpressionAccess().getIfAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AIfExpression__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group__3__Impl
	rule__AIfExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getThenKeyword_3()); }

	Then 

{ after(grammarAccess.getAIfExpressionAccess().getThenKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AIfExpression__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group__4__Impl
	rule__AIfExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getThenAssignment_4()); }
(rule__AIfExpression__ThenAssignment_4)
{ after(grammarAccess.getAIfExpressionAccess().getThenAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AIfExpression__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group__5__Impl
	rule__AIfExpression__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getGroup_5()); }
(rule__AIfExpression__Group_5__0)?
{ after(grammarAccess.getAIfExpressionAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AIfExpression__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getEndifKeyword_6()); }

	Endif 

{ after(grammarAccess.getAIfExpressionAccess().getEndifKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__AIfExpression__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group_5__0__Impl
	rule__AIfExpression__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getElseKeyword_5_0()); }

	Else 

{ after(grammarAccess.getAIfExpressionAccess().getElseKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AIfExpression__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AIfExpression__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getElseAssignment_5_1()); }
(rule__AIfExpression__ElseAssignment_5_1)
{ after(grammarAccess.getAIfExpressionAccess().getElseAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ABooleanLiteral__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ABooleanLiteral__Group__0__Impl
	rule__ABooleanLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ABooleanLiteral__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getABooleanLiteralAccess().getBooleanLiteralAction_0()); }
(

)
{ after(grammarAccess.getABooleanLiteralAccess().getBooleanLiteralAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ABooleanLiteral__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ABooleanLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ABooleanLiteral__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getABooleanLiteralAccess().getAlternatives_1()); }
(rule__ABooleanLiteral__Alternatives_1)
{ after(grammarAccess.getABooleanLiteralAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AParenthesizedExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AParenthesizedExpression__Group__0__Impl
	rule__AParenthesizedExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AParenthesizedExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()); }

	LeftParenthesis 

{ after(grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AParenthesizedExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AParenthesizedExpression__Group__1__Impl
	rule__AParenthesizedExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AParenthesizedExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAParenthesizedExpressionAccess().getAExpressionParserRuleCall_1()); }
	ruleAExpression
{ after(grammarAccess.getAParenthesizedExpressionAccess().getAExpressionParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AParenthesizedExpression__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AParenthesizedExpression__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AParenthesizedExpression__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAParenthesizedExpressionAccess().getRightParenthesisKeyword_2()); }

	RightParenthesis 

{ after(grammarAccess.getAParenthesizedExpressionAccess().getRightParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ComponentCategory__Group_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentCategory__Group_8__0__Impl
	rule__ComponentCategory__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentCategory__Group_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); }

	Subprogram 

{ after(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentCategory__Group_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentCategory__Group_8__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentCategory__Group_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); }

	Group 

{ after(grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ComponentCategory__Group_10__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentCategory__Group_10__0__Impl
	rule__ComponentCategory__Group_10__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentCategory__Group_10__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); }

	Thread 

{ after(grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentCategory__Group_10__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentCategory__Group_10__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentCategory__Group_10__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); }

	Group 

{ after(grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ComponentCategory__Group_12__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentCategory__Group_12__0__Impl
	rule__ComponentCategory__Group_12__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentCategory__Group_12__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); }

	Virtual 

{ after(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentCategory__Group_12__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentCategory__Group_12__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentCategory__Group_12__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); }

	Bus 

{ after(grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ComponentCategory__Group_13__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentCategory__Group_13__0__Impl
	rule__ComponentCategory__Group_13__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentCategory__Group_13__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); }

	Virtual 

{ after(grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentCategory__Group_13__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentCategory__Group_13__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentCategory__Group_13__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1()); }

	Processor 

{ after(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AadlClassifierReference__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AadlClassifierReference__Group__0__Impl
	rule__AadlClassifierReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AadlClassifierReference__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0()); }
	RULE_ID
{ after(grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AadlClassifierReference__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AadlClassifierReference__Group__1__Impl
	rule__AadlClassifierReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AadlClassifierReference__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getAadlClassifierReferenceAccess().getGroup_1()); }
(rule__AadlClassifierReference__Group_1__0)
{ after(grammarAccess.getAadlClassifierReferenceAccess().getGroup_1()); }
)
(
{ before(grammarAccess.getAadlClassifierReferenceAccess().getGroup_1()); }
(rule__AadlClassifierReference__Group_1__0)*
{ after(grammarAccess.getAadlClassifierReferenceAccess().getGroup_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AadlClassifierReference__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AadlClassifierReference__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AadlClassifierReference__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAadlClassifierReferenceAccess().getGroup_2()); }
(rule__AadlClassifierReference__Group_2__0)?
{ after(grammarAccess.getAadlClassifierReferenceAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AadlClassifierReference__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AadlClassifierReference__Group_1__0__Impl
	rule__AadlClassifierReference__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AadlClassifierReference__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_1_0()); }

	ColonColon 

{ after(grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AadlClassifierReference__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AadlClassifierReference__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AadlClassifierReference__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1_1()); }
	RULE_ID
{ after(grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AadlClassifierReference__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AadlClassifierReference__Group_2__0__Impl
	rule__AadlClassifierReference__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AadlClassifierReference__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); }

	FullStop 

{ after(grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AadlClassifierReference__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AadlClassifierReference__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AadlClassifierReference__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_2_1()); }
	RULE_ID
{ after(grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AADLPROPERTYREFERENCE__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AADLPROPERTYREFERENCE__Group__0__Impl
	rule__AADLPROPERTYREFERENCE__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AADLPROPERTYREFERENCE__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_0()); }
	RULE_ID
{ after(grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AADLPROPERTYREFERENCE__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AADLPROPERTYREFERENCE__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AADLPROPERTYREFERENCE__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAADLPROPERTYREFERENCEAccess().getGroup_1()); }
(rule__AADLPROPERTYREFERENCE__Group_1__0)?
{ after(grammarAccess.getAADLPROPERTYREFERENCEAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AADLPROPERTYREFERENCE__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AADLPROPERTYREFERENCE__Group_1__0__Impl
	rule__AADLPROPERTYREFERENCE__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AADLPROPERTYREFERENCE__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAADLPROPERTYREFERENCEAccess().getColonColonKeyword_1_0()); }

	ColonColon 

{ after(grammarAccess.getAADLPROPERTYREFERENCEAccess().getColonColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AADLPROPERTYREFERENCE__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AADLPROPERTYREFERENCE__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AADLPROPERTYREFERENCE__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_1_1()); }
	RULE_ID
{ after(grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QualifiedName__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedName__Group__0__Impl
	rule__QualifiedName__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); }
	RULE_ID
{ after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedName__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedNameAccess().getGroup_1()); }
(rule__QualifiedName__Group_1__0)*
{ after(grammarAccess.getQualifiedNameAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QualifiedName__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedName__Group_1__0__Impl
	rule__QualifiedName__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); }

	FullStop 

{ after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedName__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); }
	RULE_ID
{ after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}







rule__StakeholderGoals__UnorderedGroup_7
    @init {
    	int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7());
    }
:
	rule__StakeholderGoals__UnorderedGroup_7__0
	?
	
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7());
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__UnorderedGroup_7__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
    }
:
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 0);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getStakeholderGoalsAccess().getDescriptionAssignment_7_0()); }
						(rule__StakeholderGoals__DescriptionAssignment_7_0)
						{ after(grammarAccess.getStakeholderGoalsAccess().getDescriptionAssignment_7_0()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 1);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					(
						{ before(grammarAccess.getStakeholderGoalsAccess().getConstantsAssignment_7_1()); }
						(rule__StakeholderGoals__ConstantsAssignment_7_1)
						{ after(grammarAccess.getStakeholderGoalsAccess().getConstantsAssignment_7_1()); }
					)
					(
						{ before(grammarAccess.getStakeholderGoalsAccess().getConstantsAssignment_7_1()); }
						((rule__StakeholderGoals__ConstantsAssignment_7_1)=>rule__StakeholderGoals__ConstantsAssignment_7_1)*
						{ after(grammarAccess.getStakeholderGoalsAccess().getConstantsAssignment_7_1()); }
					)					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 2);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					(
						{ before(grammarAccess.getStakeholderGoalsAccess().getGoalsAssignment_7_2()); }
						(rule__StakeholderGoals__GoalsAssignment_7_2)
						{ after(grammarAccess.getStakeholderGoalsAccess().getGoalsAssignment_7_2()); }
					)
					(
						{ before(grammarAccess.getStakeholderGoalsAccess().getGoalsAssignment_7_2()); }
						((rule__StakeholderGoals__GoalsAssignment_7_2)=>rule__StakeholderGoals__GoalsAssignment_7_2)*
						{ after(grammarAccess.getStakeholderGoalsAccess().getGoalsAssignment_7_2()); }
					)					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 3);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getStakeholderGoalsAccess().getGroup_7_3()); }
						(rule__StakeholderGoals__Group_7_3__0)
						{ after(grammarAccess.getStakeholderGoalsAccess().getGroup_7_3()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), 4);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getStakeholderGoalsAccess().getGroup_7_4()); }
						(rule__StakeholderGoals__Group_7_4__0)
						{ after(grammarAccess.getStakeholderGoalsAccess().getGroup_7_4()); }
					)
 				)
			)  

		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7());
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__UnorderedGroup_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__UnorderedGroup_7__Impl
	rule__StakeholderGoals__UnorderedGroup_7__1?
;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__UnorderedGroup_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__UnorderedGroup_7__Impl
	rule__StakeholderGoals__UnorderedGroup_7__2?
;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__UnorderedGroup_7__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__UnorderedGroup_7__Impl
	rule__StakeholderGoals__UnorderedGroup_7__3?
;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__UnorderedGroup_7__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__UnorderedGroup_7__Impl
	rule__StakeholderGoals__UnorderedGroup_7__4?
;
finally {
	restoreStackSize(stackSize);
}


rule__StakeholderGoals__UnorderedGroup_7__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StakeholderGoals__UnorderedGroup_7__Impl
;
finally {
	restoreStackSize(stackSize);
}












rule__ReqDocument__UnorderedGroup_4
    @init {
    	int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4());
    }
:
	rule__ReqDocument__UnorderedGroup_4__0
	?
	
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}


rule__ReqDocument__UnorderedGroup_4__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
    }
:
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 0);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getReqDocumentAccess().getDescriptionAssignment_4_0()); }
						(rule__ReqDocument__DescriptionAssignment_4_0)
						{ after(grammarAccess.getReqDocumentAccess().getDescriptionAssignment_4_0()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 1);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					(
						{ before(grammarAccess.getReqDocumentAccess().getContentAssignment_4_1()); }
						(rule__ReqDocument__ContentAssignment_4_1)
						{ after(grammarAccess.getReqDocumentAccess().getContentAssignment_4_1()); }
					)
					(
						{ before(grammarAccess.getReqDocumentAccess().getContentAssignment_4_1()); }
						((rule__ReqDocument__ContentAssignment_4_1)=>rule__ReqDocument__ContentAssignment_4_1)*
						{ after(grammarAccess.getReqDocumentAccess().getContentAssignment_4_1()); }
					)					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 2);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getReqDocumentAccess().getGroup_4_2()); }
						(rule__ReqDocument__Group_4_2__0)
						{ after(grammarAccess.getReqDocumentAccess().getGroup_4_2()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), 3);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getReqDocumentAccess().getGroup_4_3()); }
						(rule__ReqDocument__Group_4_3__0)
						{ after(grammarAccess.getReqDocumentAccess().getGroup_4_3()); }
					)
 				)
			)  

		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}


rule__ReqDocument__UnorderedGroup_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__UnorderedGroup_4__Impl
	rule__ReqDocument__UnorderedGroup_4__1?
;
finally {
	restoreStackSize(stackSize);
}


rule__ReqDocument__UnorderedGroup_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__UnorderedGroup_4__Impl
	rule__ReqDocument__UnorderedGroup_4__2?
;
finally {
	restoreStackSize(stackSize);
}


rule__ReqDocument__UnorderedGroup_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__UnorderedGroup_4__Impl
	rule__ReqDocument__UnorderedGroup_4__3?
;
finally {
	restoreStackSize(stackSize);
}


rule__ReqDocument__UnorderedGroup_4__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReqDocument__UnorderedGroup_4__Impl
;
finally {
	restoreStackSize(stackSize);
}










rule__DocumentSection__UnorderedGroup_3
    @init {
    	int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3());
    }
:
	rule__DocumentSection__UnorderedGroup_3__0
	?
	
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}


rule__DocumentSection__UnorderedGroup_3__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
    }
:
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3(), 0);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocumentSectionAccess().getDescriptionAssignment_3_0()); }
						(rule__DocumentSection__DescriptionAssignment_3_0)
						{ after(grammarAccess.getDocumentSectionAccess().getDescriptionAssignment_3_0()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3(), 1);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					(
						{ before(grammarAccess.getDocumentSectionAccess().getContentAssignment_3_1()); }
						(rule__DocumentSection__ContentAssignment_3_1)
						{ after(grammarAccess.getDocumentSectionAccess().getContentAssignment_3_1()); }
					)
					(
						{ before(grammarAccess.getDocumentSectionAccess().getContentAssignment_3_1()); }
						((rule__DocumentSection__ContentAssignment_3_1)=>rule__DocumentSection__ContentAssignment_3_1)*
						{ after(grammarAccess.getDocumentSectionAccess().getContentAssignment_3_1()); }
					)					)
 				)
			)  

		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}


rule__DocumentSection__UnorderedGroup_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentSection__UnorderedGroup_3__Impl
	rule__DocumentSection__UnorderedGroup_3__1?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocumentSection__UnorderedGroup_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocumentSection__UnorderedGroup_3__Impl
;
finally {
	restoreStackSize(stackSize);
}






rule__DocGoal__UnorderedGroup_5
    @init {
    	int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
    }
:
	rule__DocGoal__UnorderedGroup_5__0
	?
	
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	restoreStackSize(stackSize);
}


rule__DocGoal__UnorderedGroup_5__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
    }
:
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 0);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocGoalAccess().getGroup_5_0()); }
						(rule__DocGoal__Group_5_0__0)
						{ after(grammarAccess.getDocGoalAccess().getGroup_5_0()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 1);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocGoalAccess().getDescriptionAssignment_5_1()); }
						(rule__DocGoal__DescriptionAssignment_5_1)
						{ after(grammarAccess.getDocGoalAccess().getDescriptionAssignment_5_1()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 2);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					(
						{ before(grammarAccess.getDocGoalAccess().getConstantsAssignment_5_2()); }
						(rule__DocGoal__ConstantsAssignment_5_2)
						{ after(grammarAccess.getDocGoalAccess().getConstantsAssignment_5_2()); }
					)
					(
						{ before(grammarAccess.getDocGoalAccess().getConstantsAssignment_5_2()); }
						((rule__DocGoal__ConstantsAssignment_5_2)=>rule__DocGoal__ConstantsAssignment_5_2)*
						{ after(grammarAccess.getDocGoalAccess().getConstantsAssignment_5_2()); }
					)					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 3);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocGoalAccess().getWhenconditionAssignment_5_3()); }
						(rule__DocGoal__WhenconditionAssignment_5_3)
						{ after(grammarAccess.getDocGoalAccess().getWhenconditionAssignment_5_3()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 4);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocGoalAccess().getRationaleAssignment_5_4()); }
						(rule__DocGoal__RationaleAssignment_5_4)
						{ after(grammarAccess.getDocGoalAccess().getRationaleAssignment_5_4()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 5);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocGoalAccess().getChangeUncertaintyAssignment_5_5()); }
						(rule__DocGoal__ChangeUncertaintyAssignment_5_5)
						{ after(grammarAccess.getDocGoalAccess().getChangeUncertaintyAssignment_5_5()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 6)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 6);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocGoalAccess().getGroup_5_6()); }
						(rule__DocGoal__Group_5_6__0)
						{ after(grammarAccess.getDocGoalAccess().getGroup_5_6()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 7)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 7);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocGoalAccess().getGroup_5_7()); }
						(rule__DocGoal__Group_5_7__0)
						{ after(grammarAccess.getDocGoalAccess().getGroup_5_7()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 8)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 8);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocGoalAccess().getGroup_5_8()); }
						(rule__DocGoal__Group_5_8__0)
						{ after(grammarAccess.getDocGoalAccess().getGroup_5_8()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 9)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 9);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocGoalAccess().getGroup_5_9()); }
						(rule__DocGoal__Group_5_9__0)
						{ after(grammarAccess.getDocGoalAccess().getGroup_5_9()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 10)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 10);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocGoalAccess().getGroup_5_10()); }
						(rule__DocGoal__Group_5_10__0)
						{ after(grammarAccess.getDocGoalAccess().getGroup_5_10()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 11)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 11);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocGoalAccess().getGroup_5_11()); }
						(rule__DocGoal__Group_5_11__0)
						{ after(grammarAccess.getDocGoalAccess().getGroup_5_11()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 12)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), 12);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocGoalAccess().getGroup_5_12()); }
						(rule__DocGoal__Group_5_12__0)
						{ after(grammarAccess.getDocGoalAccess().getGroup_5_12()); }
					)
 				)
			)  

		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocGoalAccess().getUnorderedGroup_5());
	restoreStackSize(stackSize);
}


rule__DocGoal__UnorderedGroup_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__UnorderedGroup_5__Impl
	rule__DocGoal__UnorderedGroup_5__1?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__UnorderedGroup_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__UnorderedGroup_5__Impl
	rule__DocGoal__UnorderedGroup_5__2?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__UnorderedGroup_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__UnorderedGroup_5__Impl
	rule__DocGoal__UnorderedGroup_5__3?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__UnorderedGroup_5__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__UnorderedGroup_5__Impl
	rule__DocGoal__UnorderedGroup_5__4?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__UnorderedGroup_5__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__UnorderedGroup_5__Impl
	rule__DocGoal__UnorderedGroup_5__5?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__UnorderedGroup_5__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__UnorderedGroup_5__Impl
	rule__DocGoal__UnorderedGroup_5__6?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__UnorderedGroup_5__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__UnorderedGroup_5__Impl
	rule__DocGoal__UnorderedGroup_5__7?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__UnorderedGroup_5__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__UnorderedGroup_5__Impl
	rule__DocGoal__UnorderedGroup_5__8?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__UnorderedGroup_5__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__UnorderedGroup_5__Impl
	rule__DocGoal__UnorderedGroup_5__9?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__UnorderedGroup_5__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__UnorderedGroup_5__Impl
	rule__DocGoal__UnorderedGroup_5__10?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__UnorderedGroup_5__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__UnorderedGroup_5__Impl
	rule__DocGoal__UnorderedGroup_5__11?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__UnorderedGroup_5__11
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__UnorderedGroup_5__Impl
	rule__DocGoal__UnorderedGroup_5__12?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocGoal__UnorderedGroup_5__12
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocGoal__UnorderedGroup_5__Impl
;
finally {
	restoreStackSize(stackSize);
}




























rule__Goal__UnorderedGroup_5
    @init {
    	int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getGoalAccess().getUnorderedGroup_5());
    }
:
	rule__Goal__UnorderedGroup_5__0
	?
	
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	restoreStackSize(stackSize);
}


rule__Goal__UnorderedGroup_5__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
    }
:
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGoalAccess().getGroup_5_0()); }
						(rule__Goal__Group_5_0__0)
						{ after(grammarAccess.getGoalAccess().getGroup_5_0()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGoalAccess().getDescriptionAssignment_5_1()); }
						(rule__Goal__DescriptionAssignment_5_1)
						{ after(grammarAccess.getGoalAccess().getDescriptionAssignment_5_1()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					(
						{ before(grammarAccess.getGoalAccess().getConstantsAssignment_5_2()); }
						(rule__Goal__ConstantsAssignment_5_2)
						{ after(grammarAccess.getGoalAccess().getConstantsAssignment_5_2()); }
					)
					(
						{ before(grammarAccess.getGoalAccess().getConstantsAssignment_5_2()); }
						((rule__Goal__ConstantsAssignment_5_2)=>rule__Goal__ConstantsAssignment_5_2)*
						{ after(grammarAccess.getGoalAccess().getConstantsAssignment_5_2()); }
					)					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGoalAccess().getWhenconditionAssignment_5_3()); }
						(rule__Goal__WhenconditionAssignment_5_3)
						{ after(grammarAccess.getGoalAccess().getWhenconditionAssignment_5_3()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGoalAccess().getRationaleAssignment_5_4()); }
						(rule__Goal__RationaleAssignment_5_4)
						{ after(grammarAccess.getGoalAccess().getRationaleAssignment_5_4()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGoalAccess().getChangeUncertaintyAssignment_5_5()); }
						(rule__Goal__ChangeUncertaintyAssignment_5_5)
						{ after(grammarAccess.getGoalAccess().getChangeUncertaintyAssignment_5_5()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGoalAccess().getGroup_5_6()); }
						(rule__Goal__Group_5_6__0)
						{ after(grammarAccess.getGoalAccess().getGroup_5_6()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGoalAccess().getGroup_5_7()); }
						(rule__Goal__Group_5_7__0)
						{ after(grammarAccess.getGoalAccess().getGroup_5_7()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGoalAccess().getGroup_5_8()); }
						(rule__Goal__Group_5_8__0)
						{ after(grammarAccess.getGoalAccess().getGroup_5_8()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGoalAccess().getGroup_5_9()); }
						(rule__Goal__Group_5_9__0)
						{ after(grammarAccess.getGoalAccess().getGroup_5_9()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGoalAccess().getGroup_5_10()); }
						(rule__Goal__Group_5_10__0)
						{ after(grammarAccess.getGoalAccess().getGroup_5_10()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGoalAccess().getGroup_5_11()); }
						(rule__Goal__Group_5_11__0)
						{ after(grammarAccess.getGoalAccess().getGroup_5_11()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGoalAccess().getGroup_5_12()); }
						(rule__Goal__Group_5_12__0)
						{ after(grammarAccess.getGoalAccess().getGroup_5_12()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGoalAccess().getGroup_5_13()); }
						(rule__Goal__Group_5_13__0)
						{ after(grammarAccess.getGoalAccess().getGroup_5_13()); }
					)
 				)
			)  

		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
	restoreStackSize(stackSize);
}


rule__Goal__UnorderedGroup_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__UnorderedGroup_5__Impl
	rule__Goal__UnorderedGroup_5__1?
;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__UnorderedGroup_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__UnorderedGroup_5__Impl
	rule__Goal__UnorderedGroup_5__2?
;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__UnorderedGroup_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__UnorderedGroup_5__Impl
	rule__Goal__UnorderedGroup_5__3?
;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__UnorderedGroup_5__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__UnorderedGroup_5__Impl
	rule__Goal__UnorderedGroup_5__4?
;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__UnorderedGroup_5__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__UnorderedGroup_5__Impl
	rule__Goal__UnorderedGroup_5__5?
;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__UnorderedGroup_5__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__UnorderedGroup_5__Impl
	rule__Goal__UnorderedGroup_5__6?
;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__UnorderedGroup_5__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__UnorderedGroup_5__Impl
	rule__Goal__UnorderedGroup_5__7?
;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__UnorderedGroup_5__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__UnorderedGroup_5__Impl
	rule__Goal__UnorderedGroup_5__8?
;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__UnorderedGroup_5__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__UnorderedGroup_5__Impl
	rule__Goal__UnorderedGroup_5__9?
;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__UnorderedGroup_5__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__UnorderedGroup_5__Impl
	rule__Goal__UnorderedGroup_5__10?
;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__UnorderedGroup_5__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__UnorderedGroup_5__Impl
	rule__Goal__UnorderedGroup_5__11?
;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__UnorderedGroup_5__11
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__UnorderedGroup_5__Impl
	rule__Goal__UnorderedGroup_5__12?
;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__UnorderedGroup_5__12
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__UnorderedGroup_5__Impl
	rule__Goal__UnorderedGroup_5__13?
;
finally {
	restoreStackSize(stackSize);
}


rule__Goal__UnorderedGroup_5__13
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Goal__UnorderedGroup_5__Impl
;
finally {
	restoreStackSize(stackSize);
}






























rule__GlobalRequirement__UnorderedGroup_5
    @init {
    	int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__0
	?
	
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
    }
:
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 0);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getGroup_5_0()); }
						(rule__GlobalRequirement__Group_5_0__0)
						{ after(grammarAccess.getGlobalRequirementAccess().getGroup_5_0()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 1);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getDescriptionAssignment_5_1()); }
						(rule__GlobalRequirement__DescriptionAssignment_5_1)
						{ after(grammarAccess.getGlobalRequirementAccess().getDescriptionAssignment_5_1()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 2);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					(
						{ before(grammarAccess.getGlobalRequirementAccess().getConstantsAssignment_5_2()); }
						(rule__GlobalRequirement__ConstantsAssignment_5_2)
						{ after(grammarAccess.getGlobalRequirementAccess().getConstantsAssignment_5_2()); }
					)
					(
						{ before(grammarAccess.getGlobalRequirementAccess().getConstantsAssignment_5_2()); }
						((rule__GlobalRequirement__ConstantsAssignment_5_2)=>rule__GlobalRequirement__ConstantsAssignment_5_2)*
						{ after(grammarAccess.getGlobalRequirementAccess().getConstantsAssignment_5_2()); }
					)					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 3);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					(
						{ before(grammarAccess.getGlobalRequirementAccess().getComputesAssignment_5_3()); }
						(rule__GlobalRequirement__ComputesAssignment_5_3)
						{ after(grammarAccess.getGlobalRequirementAccess().getComputesAssignment_5_3()); }
					)
					(
						{ before(grammarAccess.getGlobalRequirementAccess().getComputesAssignment_5_3()); }
						((rule__GlobalRequirement__ComputesAssignment_5_3)=>rule__GlobalRequirement__ComputesAssignment_5_3)*
						{ after(grammarAccess.getGlobalRequirementAccess().getComputesAssignment_5_3()); }
					)					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 4);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getWhenconditionAssignment_5_4()); }
						(rule__GlobalRequirement__WhenconditionAssignment_5_4)
						{ after(grammarAccess.getGlobalRequirementAccess().getWhenconditionAssignment_5_4()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 5);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getPredicateAssignment_5_5()); }
						(rule__GlobalRequirement__PredicateAssignment_5_5)
						{ after(grammarAccess.getGlobalRequirementAccess().getPredicateAssignment_5_5()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 6)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 6);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getRationaleAssignment_5_6()); }
						(rule__GlobalRequirement__RationaleAssignment_5_6)
						{ after(grammarAccess.getGlobalRequirementAccess().getRationaleAssignment_5_6()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 7)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 7);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getChangeUncertaintyAssignment_5_7()); }
						(rule__GlobalRequirement__ChangeUncertaintyAssignment_5_7)
						{ after(grammarAccess.getGlobalRequirementAccess().getChangeUncertaintyAssignment_5_7()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 8)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 8);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getGroup_5_8()); }
						(rule__GlobalRequirement__Group_5_8__0)
						{ after(grammarAccess.getGlobalRequirementAccess().getGroup_5_8()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 9)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 9);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getGroup_5_9()); }
						(rule__GlobalRequirement__Group_5_9__0)
						{ after(grammarAccess.getGlobalRequirementAccess().getGroup_5_9()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 10)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 10);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getGroup_5_10()); }
						(rule__GlobalRequirement__Group_5_10__0)
						{ after(grammarAccess.getGlobalRequirementAccess().getGroup_5_10()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 11)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 11);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getGroup_5_11()); }
						(rule__GlobalRequirement__Group_5_11__0)
						{ after(grammarAccess.getGlobalRequirementAccess().getGroup_5_11()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 12)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 12);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getGroup_5_12()); }
						(rule__GlobalRequirement__Group_5_12__0)
						{ after(grammarAccess.getGlobalRequirementAccess().getGroup_5_12()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 13)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 13);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getGroup_5_13()); }
						(rule__GlobalRequirement__Group_5_13__0)
						{ after(grammarAccess.getGlobalRequirementAccess().getGroup_5_13()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 14)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 14);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getGroup_5_14()); }
						(rule__GlobalRequirement__Group_5_14__0)
						{ after(grammarAccess.getGlobalRequirementAccess().getGroup_5_14()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 15)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 15);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getGroup_5_15()); }
						(rule__GlobalRequirement__Group_5_15__0)
						{ after(grammarAccess.getGlobalRequirementAccess().getGroup_5_15()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 16)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 16);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getGroup_5_16()); }
						(rule__GlobalRequirement__Group_5_16__0)
						{ after(grammarAccess.getGlobalRequirementAccess().getGroup_5_16()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 17)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), 17);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getGlobalRequirementAccess().getGroup_5_17()); }
						(rule__GlobalRequirement__Group_5_17__0)
						{ after(grammarAccess.getGlobalRequirementAccess().getGroup_5_17()); }
					)
 				)
			)  

		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5());
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__1?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__2?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__3?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__4?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__5?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__6?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__7?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__8?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__9?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__10?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__11?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__11
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__12?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__12
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__13?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__13
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__14?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__14
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__15?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__15
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__16?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__16
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
	rule__GlobalRequirement__UnorderedGroup_5__17?
;
finally {
	restoreStackSize(stackSize);
}


rule__GlobalRequirement__UnorderedGroup_5__17
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GlobalRequirement__UnorderedGroup_5__Impl
;
finally {
	restoreStackSize(stackSize);
}






































rule__DocRequirement__UnorderedGroup_5
    @init {
    	int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
    }
:
	rule__DocRequirement__UnorderedGroup_5__0
	?
	
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
    }
:
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 0);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getGroup_5_0()); }
						(rule__DocRequirement__Group_5_0__0)
						{ after(grammarAccess.getDocRequirementAccess().getGroup_5_0()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 1);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getDescriptionAssignment_5_1()); }
						(rule__DocRequirement__DescriptionAssignment_5_1)
						{ after(grammarAccess.getDocRequirementAccess().getDescriptionAssignment_5_1()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 2);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					(
						{ before(grammarAccess.getDocRequirementAccess().getConstantsAssignment_5_2()); }
						(rule__DocRequirement__ConstantsAssignment_5_2)
						{ after(grammarAccess.getDocRequirementAccess().getConstantsAssignment_5_2()); }
					)
					(
						{ before(grammarAccess.getDocRequirementAccess().getConstantsAssignment_5_2()); }
						((rule__DocRequirement__ConstantsAssignment_5_2)=>rule__DocRequirement__ConstantsAssignment_5_2)*
						{ after(grammarAccess.getDocRequirementAccess().getConstantsAssignment_5_2()); }
					)					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 3)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 3);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					(
						{ before(grammarAccess.getDocRequirementAccess().getComputesAssignment_5_3()); }
						(rule__DocRequirement__ComputesAssignment_5_3)
						{ after(grammarAccess.getDocRequirementAccess().getComputesAssignment_5_3()); }
					)
					(
						{ before(grammarAccess.getDocRequirementAccess().getComputesAssignment_5_3()); }
						((rule__DocRequirement__ComputesAssignment_5_3)=>rule__DocRequirement__ComputesAssignment_5_3)*
						{ after(grammarAccess.getDocRequirementAccess().getComputesAssignment_5_3()); }
					)					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 4)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 4);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getWhenconditionAssignment_5_4()); }
						(rule__DocRequirement__WhenconditionAssignment_5_4)
						{ after(grammarAccess.getDocRequirementAccess().getWhenconditionAssignment_5_4()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 5)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 5);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getPredicateAssignment_5_5()); }
						(rule__DocRequirement__PredicateAssignment_5_5)
						{ after(grammarAccess.getDocRequirementAccess().getPredicateAssignment_5_5()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 6)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 6);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getRationaleAssignment_5_6()); }
						(rule__DocRequirement__RationaleAssignment_5_6)
						{ after(grammarAccess.getDocRequirementAccess().getRationaleAssignment_5_6()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 7)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 7);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getChangeUncertaintyAssignment_5_7()); }
						(rule__DocRequirement__ChangeUncertaintyAssignment_5_7)
						{ after(grammarAccess.getDocRequirementAccess().getChangeUncertaintyAssignment_5_7()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 8)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 8);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getGroup_5_8()); }
						(rule__DocRequirement__Group_5_8__0)
						{ after(grammarAccess.getDocRequirementAccess().getGroup_5_8()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 9)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 9);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getGroup_5_9()); }
						(rule__DocRequirement__Group_5_9__0)
						{ after(grammarAccess.getDocRequirementAccess().getGroup_5_9()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 10)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 10);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getGroup_5_10()); }
						(rule__DocRequirement__Group_5_10__0)
						{ after(grammarAccess.getDocRequirementAccess().getGroup_5_10()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 11)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 11);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getGroup_5_11()); }
						(rule__DocRequirement__Group_5_11__0)
						{ after(grammarAccess.getDocRequirementAccess().getGroup_5_11()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 12)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 12);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getGroup_5_12()); }
						(rule__DocRequirement__Group_5_12__0)
						{ after(grammarAccess.getDocRequirementAccess().getGroup_5_12()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 13)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 13);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getGroup_5_13()); }
						(rule__DocRequirement__Group_5_13__0)
						{ after(grammarAccess.getDocRequirementAccess().getGroup_5_13()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 14)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 14);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getGroup_5_14()); }
						(rule__DocRequirement__Group_5_14__0)
						{ after(grammarAccess.getDocRequirementAccess().getGroup_5_14()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 15)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 15);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getGroup_5_15()); }
						(rule__DocRequirement__Group_5_15__0)
						{ after(grammarAccess.getDocRequirementAccess().getGroup_5_15()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 16)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 16);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getGroup_5_16()); }
						(rule__DocRequirement__Group_5_16__0)
						{ after(grammarAccess.getDocRequirementAccess().getGroup_5_16()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 17)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), 17);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getDocRequirementAccess().getGroup_5_17()); }
						(rule__DocRequirement__Group_5_17__0)
						{ after(grammarAccess.getDocRequirementAccess().getGroup_5_17()); }
					)
 				)
			)  

		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5());
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__1?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__2?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__3?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__4?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__5?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__6?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__7?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__8?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__9?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__10?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__11?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__11
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__12?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__12
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__13?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__13
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__14?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__14
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__15?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__15
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__16?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__16
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
	rule__DocRequirement__UnorderedGroup_5__17?
;
finally {
	restoreStackSize(stackSize);
}


rule__DocRequirement__UnorderedGroup_5__17
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DocRequirement__UnorderedGroup_5__Impl
;
finally {
	restoreStackSize(stackSize);
}






































rule__Uncertainty__UnorderedGroup_3
    @init {
    	int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3());
    }
:
	rule__Uncertainty__UnorderedGroup_3__0
	?
	
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}


rule__Uncertainty__UnorderedGroup_3__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
    }
:
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3(), 0);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getUncertaintyAccess().getGroup_3_0()); }
						(rule__Uncertainty__Group_3_0__0)
						{ after(grammarAccess.getUncertaintyAccess().getGroup_3_0()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3(), 1);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getUncertaintyAccess().getGroup_3_1()); }
						(rule__Uncertainty__Group_3_1__0)
						{ after(grammarAccess.getUncertaintyAccess().getGroup_3_1()); }
					)
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3(), 2);
	 				}
	 				{
	 				  selected = true;
	 				}
					(
					
						{ before(grammarAccess.getUncertaintyAccess().getGroup_3_2()); }
						(rule__Uncertainty__Group_3_2__0)
						{ after(grammarAccess.getUncertaintyAccess().getGroup_3_2()); }
					)
 				)
			)  

		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}


rule__Uncertainty__UnorderedGroup_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Uncertainty__UnorderedGroup_3__Impl
	rule__Uncertainty__UnorderedGroup_3__1?
;
finally {
	restoreStackSize(stackSize);
}


rule__Uncertainty__UnorderedGroup_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Uncertainty__UnorderedGroup_3__Impl
	rule__Uncertainty__UnorderedGroup_3__2?
;
finally {
	restoreStackSize(stackSize);
}


rule__Uncertainty__UnorderedGroup_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Uncertainty__UnorderedGroup_3__Impl
;
finally {
	restoreStackSize(stackSize);
}








rule__ReqSpec__PartsAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqSpecAccess().getPartsAlternatives_0()); }
(rule__ReqSpec__PartsAlternatives_0)
{ after(grammarAccess.getReqSpecAccess().getPartsAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalConstants__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalConstantsAccess().getNameQualifiedNameParserRuleCall_1_0()); }
	ruleQualifiedName{ after(grammarAccess.getGlobalConstantsAccess().getNameQualifiedNameParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalConstants__ConstantsAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalConstantsAccess().getConstantsValDeclarationParserRuleCall_3_0()); }
	ruleValDeclaration{ after(grammarAccess.getGlobalConstantsAccess().getConstantsValDeclarationParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getNameQualifiedNameParserRuleCall_2_0()); }
	ruleQualifiedName{ after(grammarAccess.getStakeholderGoalsAccess().getNameQualifiedNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__TitleAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); }
	RULE_STRING{ after(grammarAccess.getStakeholderGoalsAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__TargetAssignment_4_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getTargetComponentClassifierCrossReference_4_1_0_0()); }
(
{ before(grammarAccess.getStakeholderGoalsAccess().getTargetComponentClassifierAadlClassifierReferenceParserRuleCall_4_1_0_0_1()); }
	ruleAadlClassifierReference{ after(grammarAccess.getStakeholderGoalsAccess().getTargetComponentClassifierAadlClassifierReferenceParserRuleCall_4_1_0_0_1()); }
)
{ after(grammarAccess.getStakeholderGoalsAccess().getTargetComponentClassifierCrossReference_4_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__ComponentCategoryAssignment_4_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getComponentCategoryComponentCategoryParserRuleCall_4_1_1_0()); }
	ruleComponentCategory{ after(grammarAccess.getStakeholderGoalsAccess().getComponentCategoryComponentCategoryParserRuleCall_4_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__ImportConstantsAssignment_5_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getImportConstantsGlobalConstantsCrossReference_5_2_0()); }
(
{ before(grammarAccess.getStakeholderGoalsAccess().getImportConstantsGlobalConstantsQualifiedNameParserRuleCall_5_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getStakeholderGoalsAccess().getImportConstantsGlobalConstantsQualifiedNameParserRuleCall_5_2_0_1()); }
)
{ after(grammarAccess.getStakeholderGoalsAccess().getImportConstantsGlobalConstantsCrossReference_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__DescriptionAssignment_7_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getDescriptionDescriptionParserRuleCall_7_0_0()); }
	ruleDescription{ after(grammarAccess.getStakeholderGoalsAccess().getDescriptionDescriptionParserRuleCall_7_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__ConstantsAssignment_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getConstantsValDeclarationParserRuleCall_7_1_0()); }
	ruleValDeclaration{ after(grammarAccess.getStakeholderGoalsAccess().getConstantsValDeclarationParserRuleCall_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__GoalsAssignment_7_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getGoalsGoalParserRuleCall_7_2_0()); }
	ruleGoal{ after(grammarAccess.getStakeholderGoalsAccess().getGoalsGoalParserRuleCall_7_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__DocReferenceAssignment_7_3_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getDocReferenceExternalDocumentParserRuleCall_7_3_2_0()); }
	ruleExternalDocument{ after(grammarAccess.getStakeholderGoalsAccess().getDocReferenceExternalDocumentParserRuleCall_7_3_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StakeholderGoals__IssuesAssignment_7_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStakeholderGoalsAccess().getIssuesSTRINGTerminalRuleCall_7_4_1_0()); }
	RULE_STRING{ after(grammarAccess.getStakeholderGoalsAccess().getIssuesSTRINGTerminalRuleCall_7_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getNameQualifiedNameParserRuleCall_1_0()); }
	ruleQualifiedName{ after(grammarAccess.getReqDocumentAccess().getNameQualifiedNameParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__TitleAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
	RULE_STRING{ after(grammarAccess.getReqDocumentAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__DescriptionAssignment_4_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getDescriptionDescriptionParserRuleCall_4_0_0()); }
	ruleDescription{ after(grammarAccess.getReqDocumentAccess().getDescriptionDescriptionParserRuleCall_4_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__ContentAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getContentAlternatives_4_1_0()); }
(rule__ReqDocument__ContentAlternatives_4_1_0)
{ after(grammarAccess.getReqDocumentAccess().getContentAlternatives_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__DocReferenceAssignment_4_2_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getDocReferenceExternalDocumentParserRuleCall_4_2_2_0()); }
	ruleExternalDocument{ after(grammarAccess.getReqDocumentAccess().getDocReferenceExternalDocumentParserRuleCall_4_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReqDocument__IssuesAssignment_4_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReqDocumentAccess().getIssuesSTRINGTerminalRuleCall_4_3_1_0()); }
	RULE_STRING{ after(grammarAccess.getReqDocumentAccess().getIssuesSTRINGTerminalRuleCall_4_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__LabelAssignment_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getLabelIDTerminalRuleCall_1_0_0_0()); }
	RULE_ID{ after(grammarAccess.getDocumentSectionAccess().getLabelIDTerminalRuleCall_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__TitleAssignment_1_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getTitleSTRINGTerminalRuleCall_1_0_1_1_0()); }
	RULE_STRING{ after(grammarAccess.getDocumentSectionAccess().getTitleSTRINGTerminalRuleCall_1_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__TitleAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getTitleSTRINGTerminalRuleCall_1_1_0()); }
	RULE_STRING{ after(grammarAccess.getDocumentSectionAccess().getTitleSTRINGTerminalRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__DescriptionAssignment_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getDescriptionDescriptionParserRuleCall_3_0_0()); }
	ruleDescription{ after(grammarAccess.getDocumentSectionAccess().getDescriptionDescriptionParserRuleCall_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocumentSection__ContentAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocumentSectionAccess().getContentAlternatives_3_1_0()); }
(rule__DocumentSection__ContentAlternatives_3_1_0)
{ after(grammarAccess.getDocumentSectionAccess().getContentAlternatives_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__NameAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getNameQualifiedNameParserRuleCall_3_0()); }
	ruleQualifiedName{ after(grammarAccess.getSystemRequirementSetAccess().getNameQualifiedNameParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__TitleAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getTitleSTRINGTerminalRuleCall_4_1_0()); }
	RULE_STRING{ after(grammarAccess.getSystemRequirementSetAccess().getTitleSTRINGTerminalRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__TargetAssignment_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getTargetComponentClassifierCrossReference_6_0()); }
(
{ before(grammarAccess.getSystemRequirementSetAccess().getTargetComponentClassifierAadlClassifierReferenceParserRuleCall_6_0_1()); }
	ruleAadlClassifierReference{ after(grammarAccess.getSystemRequirementSetAccess().getTargetComponentClassifierAadlClassifierReferenceParserRuleCall_6_0_1()); }
)
{ after(grammarAccess.getSystemRequirementSetAccess().getTargetComponentClassifierCrossReference_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__ImportConstantsAssignment_7_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getImportConstantsGlobalConstantsCrossReference_7_2_0()); }
(
{ before(grammarAccess.getSystemRequirementSetAccess().getImportConstantsGlobalConstantsQualifiedNameParserRuleCall_7_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getSystemRequirementSetAccess().getImportConstantsGlobalConstantsQualifiedNameParserRuleCall_7_2_0_1()); }
)
{ after(grammarAccess.getSystemRequirementSetAccess().getImportConstantsGlobalConstantsCrossReference_7_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__DescriptionAssignment_9_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getDescriptionDescriptionParserRuleCall_9_0_0()); }
	ruleDescription{ after(grammarAccess.getSystemRequirementSetAccess().getDescriptionDescriptionParserRuleCall_9_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__ConstantsAssignment_9_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getConstantsValDeclarationParserRuleCall_9_1_0()); }
	ruleValDeclaration{ after(grammarAccess.getSystemRequirementSetAccess().getConstantsValDeclarationParserRuleCall_9_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__ComputesAssignment_9_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getComputesComputeDeclarationParserRuleCall_9_2_0()); }
	ruleComputeDeclaration{ after(grammarAccess.getSystemRequirementSetAccess().getComputesComputeDeclarationParserRuleCall_9_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__RequirementsAssignment_9_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getRequirementsSystemRequirementParserRuleCall_9_3_0()); }
	ruleSystemRequirement{ after(grammarAccess.getSystemRequirementSetAccess().getRequirementsSystemRequirementParserRuleCall_9_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__IncludeAssignment_9_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getIncludeIncludeGlobalRequirementParserRuleCall_9_4_0()); }
	ruleIncludeGlobalRequirement{ after(grammarAccess.getSystemRequirementSetAccess().getIncludeIncludeGlobalRequirementParserRuleCall_9_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__DocReferenceAssignment_9_5_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getDocReferenceExternalDocumentParserRuleCall_9_5_2_0()); }
	ruleExternalDocument{ after(grammarAccess.getSystemRequirementSetAccess().getDocReferenceExternalDocumentParserRuleCall_9_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__StakeholderGoalsAssignment_9_6_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getStakeholderGoalsReqRootCrossReference_9_6_2_0()); }
(
{ before(grammarAccess.getSystemRequirementSetAccess().getStakeholderGoalsReqRootQualifiedNameParserRuleCall_9_6_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getSystemRequirementSetAccess().getStakeholderGoalsReqRootQualifiedNameParserRuleCall_9_6_2_0_1()); }
)
{ after(grammarAccess.getSystemRequirementSetAccess().getStakeholderGoalsReqRootCrossReference_9_6_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirementSet__IssuesAssignment_9_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementSetAccess().getIssuesSTRINGTerminalRuleCall_9_7_1_0()); }
	RULE_STRING{ after(grammarAccess.getSystemRequirementSetAccess().getIssuesSTRINGTerminalRuleCall_9_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__NameAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getNameQualifiedNameParserRuleCall_3_0()); }
	ruleQualifiedName{ after(grammarAccess.getGlobalRequirementSetAccess().getNameQualifiedNameParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__TitleAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getTitleSTRINGTerminalRuleCall_4_1_0()); }
	RULE_STRING{ after(grammarAccess.getGlobalRequirementSetAccess().getTitleSTRINGTerminalRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__ImportConstantsAssignment_5_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getImportConstantsGlobalConstantsCrossReference_5_2_0()); }
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getImportConstantsGlobalConstantsQualifiedNameParserRuleCall_5_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getGlobalRequirementSetAccess().getImportConstantsGlobalConstantsQualifiedNameParserRuleCall_5_2_0_1()); }
)
{ after(grammarAccess.getGlobalRequirementSetAccess().getImportConstantsGlobalConstantsCrossReference_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__DescriptionAssignment_7_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getDescriptionDescriptionParserRuleCall_7_0_0()); }
	ruleDescription{ after(grammarAccess.getGlobalRequirementSetAccess().getDescriptionDescriptionParserRuleCall_7_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__ConstantsAssignment_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getConstantsValDeclarationParserRuleCall_7_1_0()); }
	ruleValDeclaration{ after(grammarAccess.getGlobalRequirementSetAccess().getConstantsValDeclarationParserRuleCall_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__ComputesAssignment_7_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getComputesComputeDeclarationParserRuleCall_7_2_0()); }
	ruleComputeDeclaration{ after(grammarAccess.getGlobalRequirementSetAccess().getComputesComputeDeclarationParserRuleCall_7_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__RequirementsAssignment_7_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getRequirementsGlobalRequirementParserRuleCall_7_3_0()); }
	ruleGlobalRequirement{ after(grammarAccess.getGlobalRequirementSetAccess().getRequirementsGlobalRequirementParserRuleCall_7_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__DocReferenceAssignment_7_4_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getDocReferenceExternalDocumentParserRuleCall_7_4_2_0()); }
	ruleExternalDocument{ after(grammarAccess.getGlobalRequirementSetAccess().getDocReferenceExternalDocumentParserRuleCall_7_4_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__StakeholderGoalsAssignment_7_5_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getStakeholderGoalsReqRootCrossReference_7_5_2_0()); }
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getStakeholderGoalsReqRootQualifiedNameParserRuleCall_7_5_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getGlobalRequirementSetAccess().getStakeholderGoalsReqRootQualifiedNameParserRuleCall_7_5_2_0_1()); }
)
{ after(grammarAccess.getGlobalRequirementSetAccess().getStakeholderGoalsReqRootCrossReference_7_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirementSet__IssuesAssignment_7_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementSetAccess().getIssuesSTRINGTerminalRuleCall_7_6_1_0()); }
	RULE_STRING{ after(grammarAccess.getGlobalRequirementSetAccess().getIssuesSTRINGTerminalRuleCall_7_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getDocGoalAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__TitleAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
	RULE_STRING{ after(grammarAccess.getDocGoalAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__TargetDescriptionAssignment_3_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getTargetDescriptionSTRINGTerminalRuleCall_3_1_0_0()); }
	RULE_STRING{ after(grammarAccess.getDocGoalAccess().getTargetDescriptionSTRINGTerminalRuleCall_3_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__TargetAssignment_3_1_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getTargetComponentClassifierCrossReference_3_1_1_0_0()); }
(
{ before(grammarAccess.getDocGoalAccess().getTargetComponentClassifierAadlClassifierReferenceParserRuleCall_3_1_1_0_0_1()); }
	ruleAadlClassifierReference{ after(grammarAccess.getDocGoalAccess().getTargetComponentClassifierAadlClassifierReferenceParserRuleCall_3_1_1_0_0_1()); }
)
{ after(grammarAccess.getDocGoalAccess().getTargetComponentClassifierCrossReference_3_1_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__TargetElementAssignment_3_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getTargetElementNamedElementCrossReference_3_1_1_1_0()); }
(
{ before(grammarAccess.getDocGoalAccess().getTargetElementNamedElementIDTerminalRuleCall_3_1_1_1_0_1()); }
	RULE_ID{ after(grammarAccess.getDocGoalAccess().getTargetElementNamedElementIDTerminalRuleCall_3_1_1_1_0_1()); }
)
{ after(grammarAccess.getDocGoalAccess().getTargetElementNamedElementCrossReference_3_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__CategoryAssignment_5_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getCategoryCategoryCrossReference_5_0_1_0()); }
(
{ before(grammarAccess.getDocGoalAccess().getCategoryCategoryQualifiedNameParserRuleCall_5_0_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getDocGoalAccess().getCategoryCategoryQualifiedNameParserRuleCall_5_0_1_0_1()); }
)
{ after(grammarAccess.getDocGoalAccess().getCategoryCategoryCrossReference_5_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__DescriptionAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getDescriptionDescriptionParserRuleCall_5_1_0()); }
	ruleDescription{ after(grammarAccess.getDocGoalAccess().getDescriptionDescriptionParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__ConstantsAssignment_5_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getConstantsValDeclarationParserRuleCall_5_2_0()); }
	ruleValDeclaration{ after(grammarAccess.getDocGoalAccess().getConstantsValDeclarationParserRuleCall_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__WhenconditionAssignment_5_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getWhenconditionWhenConditionParserRuleCall_5_3_0()); }
	ruleWhenCondition{ after(grammarAccess.getDocGoalAccess().getWhenconditionWhenConditionParserRuleCall_5_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__RationaleAssignment_5_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getRationaleRationaleParserRuleCall_5_4_0()); }
	ruleRationale{ after(grammarAccess.getDocGoalAccess().getRationaleRationaleParserRuleCall_5_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__ChangeUncertaintyAssignment_5_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_5_0()); }
	ruleUncertainty{ after(grammarAccess.getDocGoalAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__RefinesReferenceAssignment_5_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getRefinesReferenceGoalCrossReference_5_6_1_0()); }
(
{ before(grammarAccess.getDocGoalAccess().getRefinesReferenceGoalQualifiedNameParserRuleCall_5_6_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getDocGoalAccess().getRefinesReferenceGoalQualifiedNameParserRuleCall_5_6_1_0_1()); }
)
{ after(grammarAccess.getDocGoalAccess().getRefinesReferenceGoalCrossReference_5_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__ConflictsReferenceAssignment_5_7_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getConflictsReferenceGoalCrossReference_5_7_2_0()); }
(
{ before(grammarAccess.getDocGoalAccess().getConflictsReferenceGoalQualifiedNameParserRuleCall_5_7_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getDocGoalAccess().getConflictsReferenceGoalQualifiedNameParserRuleCall_5_7_2_0_1()); }
)
{ after(grammarAccess.getDocGoalAccess().getConflictsReferenceGoalCrossReference_5_7_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__EvolvesReferenceAssignment_5_8_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getEvolvesReferenceRequirementCrossReference_5_8_1_0()); }
(
{ before(grammarAccess.getDocGoalAccess().getEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_8_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getDocGoalAccess().getEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_8_1_0_1()); }
)
{ after(grammarAccess.getDocGoalAccess().getEvolvesReferenceRequirementCrossReference_5_8_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__DroppedAssignment_5_9_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getDroppedDroppedKeyword_5_9_0_0()); }
(
{ before(grammarAccess.getDocGoalAccess().getDroppedDroppedKeyword_5_9_0_0()); }

	Dropped 

{ after(grammarAccess.getDocGoalAccess().getDroppedDroppedKeyword_5_9_0_0()); }
)

{ after(grammarAccess.getDocGoalAccess().getDroppedDroppedKeyword_5_9_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__DropRationaleAssignment_5_9_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getDropRationaleSTRINGTerminalRuleCall_5_9_1_0()); }
	RULE_STRING{ after(grammarAccess.getDocGoalAccess().getDropRationaleSTRINGTerminalRuleCall_5_9_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__StakeholderReferenceAssignment_5_10_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_10_1_0()); }
(
{ before(grammarAccess.getDocGoalAccess().getStakeholderReferenceStakeholderQualifiedNameParserRuleCall_5_10_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getDocGoalAccess().getStakeholderReferenceStakeholderQualifiedNameParserRuleCall_5_10_1_0_1()); }
)
{ after(grammarAccess.getDocGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_10_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__DocReferenceAssignment_5_11_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_11_2_0()); }
	ruleExternalDocument{ after(grammarAccess.getDocGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_11_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocGoal__IssuesAssignment_5_12_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocGoalAccess().getIssuesSTRINGTerminalRuleCall_5_12_1_0()); }
	RULE_STRING{ after(grammarAccess.getDocGoalAccess().getIssuesSTRINGTerminalRuleCall_5_12_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getGoalAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__TitleAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
	RULE_STRING{ after(grammarAccess.getGoalAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__TargetElementAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getTargetElementNamedElementCrossReference_3_1_0()); }
(
{ before(grammarAccess.getGoalAccess().getTargetElementNamedElementIDTerminalRuleCall_3_1_0_1()); }
	RULE_ID{ after(grammarAccess.getGoalAccess().getTargetElementNamedElementIDTerminalRuleCall_3_1_0_1()); }
)
{ after(grammarAccess.getGoalAccess().getTargetElementNamedElementCrossReference_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__CategoryAssignment_5_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getCategoryCategoryCrossReference_5_0_1_0()); }
(
{ before(grammarAccess.getGoalAccess().getCategoryCategoryQualifiedNameParserRuleCall_5_0_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getGoalAccess().getCategoryCategoryQualifiedNameParserRuleCall_5_0_1_0_1()); }
)
{ after(grammarAccess.getGoalAccess().getCategoryCategoryCrossReference_5_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__DescriptionAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getDescriptionDescriptionParserRuleCall_5_1_0()); }
	ruleDescription{ after(grammarAccess.getGoalAccess().getDescriptionDescriptionParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__ConstantsAssignment_5_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getConstantsValDeclarationParserRuleCall_5_2_0()); }
	ruleValDeclaration{ after(grammarAccess.getGoalAccess().getConstantsValDeclarationParserRuleCall_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__WhenconditionAssignment_5_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getWhenconditionWhenConditionParserRuleCall_5_3_0()); }
	ruleWhenCondition{ after(grammarAccess.getGoalAccess().getWhenconditionWhenConditionParserRuleCall_5_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__RationaleAssignment_5_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getRationaleRationaleParserRuleCall_5_4_0()); }
	ruleRationale{ after(grammarAccess.getGoalAccess().getRationaleRationaleParserRuleCall_5_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__ChangeUncertaintyAssignment_5_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_5_0()); }
	ruleUncertainty{ after(grammarAccess.getGoalAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__RefinesReferenceAssignment_5_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_6_1_0()); }
(
{ before(grammarAccess.getGoalAccess().getRefinesReferenceGoalQualifiedNameParserRuleCall_5_6_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getGoalAccess().getRefinesReferenceGoalQualifiedNameParserRuleCall_5_6_1_0_1()); }
)
{ after(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__ConflictsReferenceAssignment_5_7_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_7_2_0()); }
(
{ before(grammarAccess.getGoalAccess().getConflictsReferenceGoalQualifiedNameParserRuleCall_5_7_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getGoalAccess().getConflictsReferenceGoalQualifiedNameParserRuleCall_5_7_2_0_1()); }
)
{ after(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_7_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__EvolvesReferenceAssignment_5_8_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getEvolvesReferenceRequirementCrossReference_5_8_1_0()); }
(
{ before(grammarAccess.getGoalAccess().getEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_8_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getGoalAccess().getEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_8_1_0_1()); }
)
{ after(grammarAccess.getGoalAccess().getEvolvesReferenceRequirementCrossReference_5_8_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__DroppedAssignment_5_9_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getDroppedDroppedKeyword_5_9_0_0()); }
(
{ before(grammarAccess.getGoalAccess().getDroppedDroppedKeyword_5_9_0_0()); }

	Dropped 

{ after(grammarAccess.getGoalAccess().getDroppedDroppedKeyword_5_9_0_0()); }
)

{ after(grammarAccess.getGoalAccess().getDroppedDroppedKeyword_5_9_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__DropRationaleAssignment_5_9_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getDropRationaleSTRINGTerminalRuleCall_5_9_1_0()); }
	RULE_STRING{ after(grammarAccess.getGoalAccess().getDropRationaleSTRINGTerminalRuleCall_5_9_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__StakeholderReferenceAssignment_5_10_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_10_1_0()); }
(
{ before(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderQualifiedNameParserRuleCall_5_10_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderQualifiedNameParserRuleCall_5_10_1_0_1()); }
)
{ after(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_10_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__GoalReferenceAssignment_5_11_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getGoalReferenceGoalCrossReference_5_11_2_0()); }
(
{ before(grammarAccess.getGoalAccess().getGoalReferenceGoalQualifiedNameParserRuleCall_5_11_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getGoalAccess().getGoalReferenceGoalQualifiedNameParserRuleCall_5_11_2_0_1()); }
)
{ after(grammarAccess.getGoalAccess().getGoalReferenceGoalCrossReference_5_11_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__DocReferenceAssignment_5_12_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_12_2_0()); }
	ruleExternalDocument{ after(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_12_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Goal__IssuesAssignment_5_13_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGoalAccess().getIssuesSTRINGTerminalRuleCall_5_13_1_0()); }
	RULE_STRING{ after(grammarAccess.getGoalAccess().getIssuesSTRINGTerminalRuleCall_5_13_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getSystemRequirementAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__TitleAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
	RULE_STRING{ after(grammarAccess.getSystemRequirementAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__TargetElementAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getTargetElementNamedElementCrossReference_3_1_0()); }
(
{ before(grammarAccess.getSystemRequirementAccess().getTargetElementNamedElementIDTerminalRuleCall_3_1_0_1()); }
	RULE_ID{ after(grammarAccess.getSystemRequirementAccess().getTargetElementNamedElementIDTerminalRuleCall_3_1_0_1()); }
)
{ after(grammarAccess.getSystemRequirementAccess().getTargetElementNamedElementCrossReference_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__CategoryAssignment_5_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getCategoryCategoryCrossReference_5_0_1_0()); }
(
{ before(grammarAccess.getSystemRequirementAccess().getCategoryCategoryQualifiedNameParserRuleCall_5_0_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getSystemRequirementAccess().getCategoryCategoryQualifiedNameParserRuleCall_5_0_1_0_1()); }
)
{ after(grammarAccess.getSystemRequirementAccess().getCategoryCategoryCrossReference_5_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__DescriptionAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getDescriptionDescriptionParserRuleCall_5_1_0()); }
	ruleDescription{ after(grammarAccess.getSystemRequirementAccess().getDescriptionDescriptionParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__WhenconditionAssignment_5_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getWhenconditionWhenConditionParserRuleCall_5_2_0()); }
	ruleWhenCondition{ after(grammarAccess.getSystemRequirementAccess().getWhenconditionWhenConditionParserRuleCall_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__PredicateAssignment_5_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getPredicateReqPredicateParserRuleCall_5_3_0()); }
	ruleReqPredicate{ after(grammarAccess.getSystemRequirementAccess().getPredicateReqPredicateParserRuleCall_5_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__RationaleAssignment_5_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getRationaleRationaleParserRuleCall_5_4_0()); }
	ruleRationale{ after(grammarAccess.getSystemRequirementAccess().getRationaleRationaleParserRuleCall_5_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__ChangeUncertaintyAssignment_5_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_5_0()); }
	ruleUncertainty{ after(grammarAccess.getSystemRequirementAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__ExceptionAssignment_5_6_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getExceptionEObjectCrossReference_5_6_1_0_0()); }
(
{ before(grammarAccess.getSystemRequirementAccess().getExceptionEObjectIDTerminalRuleCall_5_6_1_0_0_1()); }
	RULE_ID{ after(grammarAccess.getSystemRequirementAccess().getExceptionEObjectIDTerminalRuleCall_5_6_1_0_0_1()); }
)
{ after(grammarAccess.getSystemRequirementAccess().getExceptionEObjectCrossReference_5_6_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__ExceptionTextAssignment_5_6_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getExceptionTextSTRINGTerminalRuleCall_5_6_1_1_0()); }
	RULE_STRING{ after(grammarAccess.getSystemRequirementAccess().getExceptionTextSTRINGTerminalRuleCall_5_6_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__InheritsReferenceAssignment_5_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getInheritsReferenceRequirementCrossReference_5_7_1_0()); }
(
{ before(grammarAccess.getSystemRequirementAccess().getInheritsReferenceRequirementQualifiedNameParserRuleCall_5_7_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getSystemRequirementAccess().getInheritsReferenceRequirementQualifiedNameParserRuleCall_5_7_1_0_1()); }
)
{ after(grammarAccess.getSystemRequirementAccess().getInheritsReferenceRequirementCrossReference_5_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__DroppedAssignment_5_8_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getDroppedDroppedKeyword_5_8_0_0()); }
(
{ before(grammarAccess.getSystemRequirementAccess().getDroppedDroppedKeyword_5_8_0_0()); }

	Dropped 

{ after(grammarAccess.getSystemRequirementAccess().getDroppedDroppedKeyword_5_8_0_0()); }
)

{ after(grammarAccess.getSystemRequirementAccess().getDroppedDroppedKeyword_5_8_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__DropRationaleAssignment_5_8_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getDropRationaleSTRINGTerminalRuleCall_5_8_1_0()); }
	RULE_STRING{ after(grammarAccess.getSystemRequirementAccess().getDropRationaleSTRINGTerminalRuleCall_5_8_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__ConstantsAssignment_5_9
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getConstantsValDeclarationParserRuleCall_5_9_0()); }
	ruleValDeclaration{ after(grammarAccess.getSystemRequirementAccess().getConstantsValDeclarationParserRuleCall_5_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__ComputesAssignment_5_10
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getComputesComputeDeclarationParserRuleCall_5_10_0()); }
	ruleComputeDeclaration{ after(grammarAccess.getSystemRequirementAccess().getComputesComputeDeclarationParserRuleCall_5_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__RefinesReferenceAssignment_5_11_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getRefinesReferenceRequirementCrossReference_5_11_1_0()); }
(
{ before(grammarAccess.getSystemRequirementAccess().getRefinesReferenceRequirementQualifiedNameParserRuleCall_5_11_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getSystemRequirementAccess().getRefinesReferenceRequirementQualifiedNameParserRuleCall_5_11_1_0_1()); }
)
{ after(grammarAccess.getSystemRequirementAccess().getRefinesReferenceRequirementCrossReference_5_11_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__DecomposesReferenceAssignment_5_12_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getDecomposesReferenceRequirementCrossReference_5_12_1_0()); }
(
{ before(grammarAccess.getSystemRequirementAccess().getDecomposesReferenceRequirementQualifiedNameParserRuleCall_5_12_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getSystemRequirementAccess().getDecomposesReferenceRequirementQualifiedNameParserRuleCall_5_12_1_0_1()); }
)
{ after(grammarAccess.getSystemRequirementAccess().getDecomposesReferenceRequirementCrossReference_5_12_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__EvolvesReferenceAssignment_5_13_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getEvolvesReferenceRequirementCrossReference_5_13_1_0()); }
(
{ before(grammarAccess.getSystemRequirementAccess().getEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_13_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getSystemRequirementAccess().getEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_13_1_0_1()); }
)
{ after(grammarAccess.getSystemRequirementAccess().getEvolvesReferenceRequirementCrossReference_5_13_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__DevelopmentStakeholderAssignment_5_14_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getDevelopmentStakeholderStakeholderCrossReference_5_14_2_0()); }
(
{ before(grammarAccess.getSystemRequirementAccess().getDevelopmentStakeholderStakeholderQualifiedNameParserRuleCall_5_14_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getSystemRequirementAccess().getDevelopmentStakeholderStakeholderQualifiedNameParserRuleCall_5_14_2_0_1()); }
)
{ after(grammarAccess.getSystemRequirementAccess().getDevelopmentStakeholderStakeholderCrossReference_5_14_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__GoalReferenceAssignment_5_15_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getGoalReferenceGoalCrossReference_5_15_2_0()); }
(
{ before(grammarAccess.getSystemRequirementAccess().getGoalReferenceGoalQualifiedNameParserRuleCall_5_15_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getSystemRequirementAccess().getGoalReferenceGoalQualifiedNameParserRuleCall_5_15_2_0_1()); }
)
{ after(grammarAccess.getSystemRequirementAccess().getGoalReferenceGoalCrossReference_5_15_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__RequirementReferenceAssignment_5_16_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getRequirementReferenceRequirementCrossReference_5_16_2_0()); }
(
{ before(grammarAccess.getSystemRequirementAccess().getRequirementReferenceRequirementQualifiedNameParserRuleCall_5_16_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getSystemRequirementAccess().getRequirementReferenceRequirementQualifiedNameParserRuleCall_5_16_2_0_1()); }
)
{ after(grammarAccess.getSystemRequirementAccess().getRequirementReferenceRequirementCrossReference_5_16_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__DocReferenceAssignment_5_17_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_17_2_0()); }
	ruleExternalDocument{ after(grammarAccess.getSystemRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_17_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemRequirement__IssuesAssignment_5_18_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemRequirementAccess().getIssuesSTRINGTerminalRuleCall_5_18_1_0()); }
	RULE_STRING{ after(grammarAccess.getSystemRequirementAccess().getIssuesSTRINGTerminalRuleCall_5_18_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getGlobalRequirementAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__TitleAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
	RULE_STRING{ after(grammarAccess.getGlobalRequirementAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__ComponentCategoryAssignment_3_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getComponentCategoryComponentCategoryParserRuleCall_3_1_0_0()); }
	ruleComponentCategory{ after(grammarAccess.getGlobalRequirementAccess().getComponentCategoryComponentCategoryParserRuleCall_3_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__TargetTypeAssignment_3_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getTargetTypeTargetTypeEnumRuleCall_3_1_1_0()); }
	ruleTargetType{ after(grammarAccess.getGlobalRequirementAccess().getTargetTypeTargetTypeEnumRuleCall_3_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__CategoryAssignment_5_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getCategoryCategoryCrossReference_5_0_1_0()); }
(
{ before(grammarAccess.getGlobalRequirementAccess().getCategoryCategoryQualifiedNameParserRuleCall_5_0_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getGlobalRequirementAccess().getCategoryCategoryQualifiedNameParserRuleCall_5_0_1_0_1()); }
)
{ after(grammarAccess.getGlobalRequirementAccess().getCategoryCategoryCrossReference_5_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__DescriptionAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getDescriptionDescriptionParserRuleCall_5_1_0()); }
	ruleDescription{ after(grammarAccess.getGlobalRequirementAccess().getDescriptionDescriptionParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__ConstantsAssignment_5_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getConstantsValDeclarationParserRuleCall_5_2_0()); }
	ruleValDeclaration{ after(grammarAccess.getGlobalRequirementAccess().getConstantsValDeclarationParserRuleCall_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__ComputesAssignment_5_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getComputesComputeDeclarationParserRuleCall_5_3_0()); }
	ruleComputeDeclaration{ after(grammarAccess.getGlobalRequirementAccess().getComputesComputeDeclarationParserRuleCall_5_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__WhenconditionAssignment_5_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getWhenconditionWhenConditionParserRuleCall_5_4_0()); }
	ruleWhenCondition{ after(grammarAccess.getGlobalRequirementAccess().getWhenconditionWhenConditionParserRuleCall_5_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__PredicateAssignment_5_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getPredicateReqPredicateParserRuleCall_5_5_0()); }
	ruleReqPredicate{ after(grammarAccess.getGlobalRequirementAccess().getPredicateReqPredicateParserRuleCall_5_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__RationaleAssignment_5_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getRationaleRationaleParserRuleCall_5_6_0()); }
	ruleRationale{ after(grammarAccess.getGlobalRequirementAccess().getRationaleRationaleParserRuleCall_5_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__ChangeUncertaintyAssignment_5_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_7_0()); }
	ruleUncertainty{ after(grammarAccess.getGlobalRequirementAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__ExceptionAssignment_5_8_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getExceptionEObjectCrossReference_5_8_1_0_0()); }
(
{ before(grammarAccess.getGlobalRequirementAccess().getExceptionEObjectIDTerminalRuleCall_5_8_1_0_0_1()); }
	RULE_ID{ after(grammarAccess.getGlobalRequirementAccess().getExceptionEObjectIDTerminalRuleCall_5_8_1_0_0_1()); }
)
{ after(grammarAccess.getGlobalRequirementAccess().getExceptionEObjectCrossReference_5_8_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__ExceptionTextAssignment_5_8_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getExceptionTextSTRINGTerminalRuleCall_5_8_1_1_0()); }
	RULE_STRING{ after(grammarAccess.getGlobalRequirementAccess().getExceptionTextSTRINGTerminalRuleCall_5_8_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__RefinesReferenceAssignment_5_9_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getRefinesReferenceRequirementCrossReference_5_9_1_0()); }
(
{ before(grammarAccess.getGlobalRequirementAccess().getRefinesReferenceRequirementQualifiedNameParserRuleCall_5_9_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getGlobalRequirementAccess().getRefinesReferenceRequirementQualifiedNameParserRuleCall_5_9_1_0_1()); }
)
{ after(grammarAccess.getGlobalRequirementAccess().getRefinesReferenceRequirementCrossReference_5_9_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__DecomposesReferenceAssignment_5_10_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getDecomposesReferenceRequirementCrossReference_5_10_1_0()); }
(
{ before(grammarAccess.getGlobalRequirementAccess().getDecomposesReferenceRequirementQualifiedNameParserRuleCall_5_10_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getGlobalRequirementAccess().getDecomposesReferenceRequirementQualifiedNameParserRuleCall_5_10_1_0_1()); }
)
{ after(grammarAccess.getGlobalRequirementAccess().getDecomposesReferenceRequirementCrossReference_5_10_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__EvolvesReferenceAssignment_5_11_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getEvolvesReferenceRequirementCrossReference_5_11_1_0()); }
(
{ before(grammarAccess.getGlobalRequirementAccess().getEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_11_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getGlobalRequirementAccess().getEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_11_1_0_1()); }
)
{ after(grammarAccess.getGlobalRequirementAccess().getEvolvesReferenceRequirementCrossReference_5_11_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__DroppedAssignment_5_12_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getDroppedDroppedKeyword_5_12_0_0()); }
(
{ before(grammarAccess.getGlobalRequirementAccess().getDroppedDroppedKeyword_5_12_0_0()); }

	Dropped 

{ after(grammarAccess.getGlobalRequirementAccess().getDroppedDroppedKeyword_5_12_0_0()); }
)

{ after(grammarAccess.getGlobalRequirementAccess().getDroppedDroppedKeyword_5_12_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__DropRationaleAssignment_5_12_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getDropRationaleSTRINGTerminalRuleCall_5_12_1_0()); }
	RULE_STRING{ after(grammarAccess.getGlobalRequirementAccess().getDropRationaleSTRINGTerminalRuleCall_5_12_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__DevelopmentStakeholderAssignment_5_13_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getDevelopmentStakeholderStakeholderCrossReference_5_13_2_0()); }
(
{ before(grammarAccess.getGlobalRequirementAccess().getDevelopmentStakeholderStakeholderQualifiedNameParserRuleCall_5_13_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getGlobalRequirementAccess().getDevelopmentStakeholderStakeholderQualifiedNameParserRuleCall_5_13_2_0_1()); }
)
{ after(grammarAccess.getGlobalRequirementAccess().getDevelopmentStakeholderStakeholderCrossReference_5_13_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__GoalReferenceAssignment_5_14_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getGoalReferenceGoalCrossReference_5_14_2_0()); }
(
{ before(grammarAccess.getGlobalRequirementAccess().getGoalReferenceGoalQualifiedNameParserRuleCall_5_14_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getGlobalRequirementAccess().getGoalReferenceGoalQualifiedNameParserRuleCall_5_14_2_0_1()); }
)
{ after(grammarAccess.getGlobalRequirementAccess().getGoalReferenceGoalCrossReference_5_14_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__RequirementReferenceAssignment_5_15_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getRequirementReferenceRequirementCrossReference_5_15_2_0()); }
(
{ before(grammarAccess.getGlobalRequirementAccess().getRequirementReferenceRequirementQualifiedNameParserRuleCall_5_15_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getGlobalRequirementAccess().getRequirementReferenceRequirementQualifiedNameParserRuleCall_5_15_2_0_1()); }
)
{ after(grammarAccess.getGlobalRequirementAccess().getRequirementReferenceRequirementCrossReference_5_15_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__DocReferenceAssignment_5_16_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_16_2_0()); }
	ruleExternalDocument{ after(grammarAccess.getGlobalRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_16_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GlobalRequirement__IssuesAssignment_5_17_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalRequirementAccess().getIssuesSTRINGTerminalRuleCall_5_17_1_0()); }
	RULE_STRING{ after(grammarAccess.getGlobalRequirementAccess().getIssuesSTRINGTerminalRuleCall_5_17_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getDocRequirementAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__TitleAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
	RULE_STRING{ after(grammarAccess.getDocRequirementAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__TargetDescriptionAssignment_3_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getTargetDescriptionSTRINGTerminalRuleCall_3_1_0_0()); }
	RULE_STRING{ after(grammarAccess.getDocRequirementAccess().getTargetDescriptionSTRINGTerminalRuleCall_3_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__TargetAssignment_3_1_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getTargetComponentClassifierCrossReference_3_1_1_0_0()); }
(
{ before(grammarAccess.getDocRequirementAccess().getTargetComponentClassifierAadlClassifierReferenceParserRuleCall_3_1_1_0_0_1()); }
	ruleAadlClassifierReference{ after(grammarAccess.getDocRequirementAccess().getTargetComponentClassifierAadlClassifierReferenceParserRuleCall_3_1_1_0_0_1()); }
)
{ after(grammarAccess.getDocRequirementAccess().getTargetComponentClassifierCrossReference_3_1_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__TargetElementAssignment_3_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getTargetElementNamedElementCrossReference_3_1_1_1_0()); }
(
{ before(grammarAccess.getDocRequirementAccess().getTargetElementNamedElementIDTerminalRuleCall_3_1_1_1_0_1()); }
	RULE_ID{ after(grammarAccess.getDocRequirementAccess().getTargetElementNamedElementIDTerminalRuleCall_3_1_1_1_0_1()); }
)
{ after(grammarAccess.getDocRequirementAccess().getTargetElementNamedElementCrossReference_3_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__ComponentCategoryAssignment_3_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getComponentCategoryComponentCategoryParserRuleCall_3_1_2_0()); }
	ruleComponentCategory{ after(grammarAccess.getDocRequirementAccess().getComponentCategoryComponentCategoryParserRuleCall_3_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__CategoryAssignment_5_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getCategoryCategoryCrossReference_5_0_1_0()); }
(
{ before(grammarAccess.getDocRequirementAccess().getCategoryCategoryQualifiedNameParserRuleCall_5_0_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getDocRequirementAccess().getCategoryCategoryQualifiedNameParserRuleCall_5_0_1_0_1()); }
)
{ after(grammarAccess.getDocRequirementAccess().getCategoryCategoryCrossReference_5_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__DescriptionAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getDescriptionDescriptionParserRuleCall_5_1_0()); }
	ruleDescription{ after(grammarAccess.getDocRequirementAccess().getDescriptionDescriptionParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__ConstantsAssignment_5_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getConstantsValDeclarationParserRuleCall_5_2_0()); }
	ruleValDeclaration{ after(grammarAccess.getDocRequirementAccess().getConstantsValDeclarationParserRuleCall_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__ComputesAssignment_5_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getComputesComputeDeclarationParserRuleCall_5_3_0()); }
	ruleComputeDeclaration{ after(grammarAccess.getDocRequirementAccess().getComputesComputeDeclarationParserRuleCall_5_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__WhenconditionAssignment_5_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getWhenconditionWhenConditionParserRuleCall_5_4_0()); }
	ruleWhenCondition{ after(grammarAccess.getDocRequirementAccess().getWhenconditionWhenConditionParserRuleCall_5_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__PredicateAssignment_5_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getPredicateReqPredicateParserRuleCall_5_5_0()); }
	ruleReqPredicate{ after(grammarAccess.getDocRequirementAccess().getPredicateReqPredicateParserRuleCall_5_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__RationaleAssignment_5_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getRationaleRationaleParserRuleCall_5_6_0()); }
	ruleRationale{ after(grammarAccess.getDocRequirementAccess().getRationaleRationaleParserRuleCall_5_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__ChangeUncertaintyAssignment_5_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_7_0()); }
	ruleUncertainty{ after(grammarAccess.getDocRequirementAccess().getChangeUncertaintyUncertaintyParserRuleCall_5_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__ExceptionAssignment_5_8_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getExceptionEObjectCrossReference_5_8_1_0_0()); }
(
{ before(grammarAccess.getDocRequirementAccess().getExceptionEObjectIDTerminalRuleCall_5_8_1_0_0_1()); }
	RULE_ID{ after(grammarAccess.getDocRequirementAccess().getExceptionEObjectIDTerminalRuleCall_5_8_1_0_0_1()); }
)
{ after(grammarAccess.getDocRequirementAccess().getExceptionEObjectCrossReference_5_8_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__ExceptionTextAssignment_5_8_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getExceptionTextSTRINGTerminalRuleCall_5_8_1_1_0()); }
	RULE_STRING{ after(grammarAccess.getDocRequirementAccess().getExceptionTextSTRINGTerminalRuleCall_5_8_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__RefinesReferenceAssignment_5_9_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getRefinesReferenceRequirementCrossReference_5_9_1_0()); }
(
{ before(grammarAccess.getDocRequirementAccess().getRefinesReferenceRequirementQualifiedNameParserRuleCall_5_9_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getDocRequirementAccess().getRefinesReferenceRequirementQualifiedNameParserRuleCall_5_9_1_0_1()); }
)
{ after(grammarAccess.getDocRequirementAccess().getRefinesReferenceRequirementCrossReference_5_9_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__DecomposesReferenceAssignment_5_10_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getDecomposesReferenceRequirementCrossReference_5_10_1_0()); }
(
{ before(grammarAccess.getDocRequirementAccess().getDecomposesReferenceRequirementQualifiedNameParserRuleCall_5_10_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getDocRequirementAccess().getDecomposesReferenceRequirementQualifiedNameParserRuleCall_5_10_1_0_1()); }
)
{ after(grammarAccess.getDocRequirementAccess().getDecomposesReferenceRequirementCrossReference_5_10_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__InheritsReferenceAssignment_5_11_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getInheritsReferenceRequirementCrossReference_5_11_1_0()); }
(
{ before(grammarAccess.getDocRequirementAccess().getInheritsReferenceRequirementQualifiedNameParserRuleCall_5_11_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getDocRequirementAccess().getInheritsReferenceRequirementQualifiedNameParserRuleCall_5_11_1_0_1()); }
)
{ after(grammarAccess.getDocRequirementAccess().getInheritsReferenceRequirementCrossReference_5_11_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__EvolvesReferenceAssignment_5_12_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getEvolvesReferenceRequirementCrossReference_5_12_1_0()); }
(
{ before(grammarAccess.getDocRequirementAccess().getEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_12_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getDocRequirementAccess().getEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_12_1_0_1()); }
)
{ after(grammarAccess.getDocRequirementAccess().getEvolvesReferenceRequirementCrossReference_5_12_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__DroppedAssignment_5_13_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getDroppedDroppedKeyword_5_13_0_0()); }
(
{ before(grammarAccess.getDocRequirementAccess().getDroppedDroppedKeyword_5_13_0_0()); }

	Dropped 

{ after(grammarAccess.getDocRequirementAccess().getDroppedDroppedKeyword_5_13_0_0()); }
)

{ after(grammarAccess.getDocRequirementAccess().getDroppedDroppedKeyword_5_13_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__DropRationaleAssignment_5_13_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getDropRationaleSTRINGTerminalRuleCall_5_13_1_0()); }
	RULE_STRING{ after(grammarAccess.getDocRequirementAccess().getDropRationaleSTRINGTerminalRuleCall_5_13_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__DevelopmentStakeholderAssignment_5_14_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getDevelopmentStakeholderStakeholderCrossReference_5_14_2_0()); }
(
{ before(grammarAccess.getDocRequirementAccess().getDevelopmentStakeholderStakeholderQualifiedNameParserRuleCall_5_14_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getDocRequirementAccess().getDevelopmentStakeholderStakeholderQualifiedNameParserRuleCall_5_14_2_0_1()); }
)
{ after(grammarAccess.getDocRequirementAccess().getDevelopmentStakeholderStakeholderCrossReference_5_14_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__GoalReferenceAssignment_5_15_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getGoalReferenceGoalCrossReference_5_15_2_0()); }
(
{ before(grammarAccess.getDocRequirementAccess().getGoalReferenceGoalQualifiedNameParserRuleCall_5_15_2_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getDocRequirementAccess().getGoalReferenceGoalQualifiedNameParserRuleCall_5_15_2_0_1()); }
)
{ after(grammarAccess.getDocRequirementAccess().getGoalReferenceGoalCrossReference_5_15_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__DocReferenceAssignment_5_16_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_16_2_0()); }
	ruleExternalDocument{ after(grammarAccess.getDocRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_16_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DocRequirement__IssuesAssignment_5_17_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDocRequirementAccess().getIssuesSTRINGTerminalRuleCall_5_17_1_0()); }
	RULE_STRING{ after(grammarAccess.getDocRequirementAccess().getIssuesSTRINGTerminalRuleCall_5_17_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IncludeGlobalRequirement__IncludeAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIncludeGlobalRequirementAccess().getIncludeEObjectCrossReference_1_0()); }
(
{ before(grammarAccess.getIncludeGlobalRequirementAccess().getIncludeEObjectQualifiedNameParserRuleCall_1_0_1()); }
	ruleQualifiedName{ after(grammarAccess.getIncludeGlobalRequirementAccess().getIncludeEObjectQualifiedNameParserRuleCall_1_0_1()); }
)
{ after(grammarAccess.getIncludeGlobalRequirementAccess().getIncludeEObjectCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IncludeGlobalRequirement__LocalAssignment_2_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIncludeGlobalRequirementAccess().getLocalSelfKeyword_2_1_0_0()); }
(
{ before(grammarAccess.getIncludeGlobalRequirementAccess().getLocalSelfKeyword_2_1_0_0()); }

	Self 

{ after(grammarAccess.getIncludeGlobalRequirementAccess().getLocalSelfKeyword_2_1_0_0()); }
)

{ after(grammarAccess.getIncludeGlobalRequirementAccess().getLocalSelfKeyword_2_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IncludeGlobalRequirement__TargetElementAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIncludeGlobalRequirementAccess().getTargetElementNamedElementCrossReference_2_1_1_0()); }
(
{ before(grammarAccess.getIncludeGlobalRequirementAccess().getTargetElementNamedElementIDTerminalRuleCall_2_1_1_0_1()); }
	RULE_ID{ after(grammarAccess.getIncludeGlobalRequirementAccess().getTargetElementNamedElementIDTerminalRuleCall_2_1_1_0_1()); }
)
{ after(grammarAccess.getIncludeGlobalRequirementAccess().getTargetElementNamedElementCrossReference_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__InModeAssignment_1_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getInModeModeCrossReference_1_0_2_0()); }
(
{ before(grammarAccess.getWhenConditionAccess().getInModeModeIDTerminalRuleCall_1_0_2_0_1()); }
	RULE_ID{ after(grammarAccess.getWhenConditionAccess().getInModeModeIDTerminalRuleCall_1_0_2_0_1()); }
)
{ after(grammarAccess.getWhenConditionAccess().getInModeModeCrossReference_1_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__InModeAssignment_1_0_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getInModeModeCrossReference_1_0_3_1_0()); }
(
{ before(grammarAccess.getWhenConditionAccess().getInModeModeIDTerminalRuleCall_1_0_3_1_0_1()); }
	RULE_ID{ after(grammarAccess.getWhenConditionAccess().getInModeModeIDTerminalRuleCall_1_0_3_1_0_1()); }
)
{ after(grammarAccess.getWhenConditionAccess().getInModeModeCrossReference_1_0_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__InErrorStateAssignment_1_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getInErrorStateEObjectCrossReference_1_1_3_0()); }
(
{ before(grammarAccess.getWhenConditionAccess().getInErrorStateEObjectIDTerminalRuleCall_1_1_3_0_1()); }
	RULE_ID{ after(grammarAccess.getWhenConditionAccess().getInErrorStateEObjectIDTerminalRuleCall_1_1_3_0_1()); }
)
{ after(grammarAccess.getWhenConditionAccess().getInErrorStateEObjectCrossReference_1_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__InErrorStateAssignment_1_1_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getInErrorStateEObjectCrossReference_1_1_4_1_0()); }
(
{ before(grammarAccess.getWhenConditionAccess().getInErrorStateEObjectIDTerminalRuleCall_1_1_4_1_0_1()); }
	RULE_ID{ after(grammarAccess.getWhenConditionAccess().getInErrorStateEObjectIDTerminalRuleCall_1_1_4_1_0_1()); }
)
{ after(grammarAccess.getWhenConditionAccess().getInErrorStateEObjectCrossReference_1_1_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__WhenCondition__ConditionAssignment_1_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWhenConditionAccess().getConditionQualifiedNameParserRuleCall_1_2_0_0()); }
	ruleQualifiedName{ after(grammarAccess.getWhenConditionAccess().getConditionQualifiedNameParserRuleCall_1_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__InformalPredicate__DescriptionAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInformalPredicateAccess().getDescriptionSTRINGTerminalRuleCall_2_0()); }
	RULE_STRING{ after(grammarAccess.getInformalPredicateAccess().getDescriptionSTRINGTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ValuePredicate__XpressionAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValuePredicateAccess().getXpressionAAndExpressionParserRuleCall_2_0()); }
	ruleAAndExpression{ after(grammarAccess.getValuePredicateAccess().getXpressionAAndExpressionParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ValuePredicate__DesiredValueAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValuePredicateAccess().getDesiredValueDesiredValueParserRuleCall_3_1_0()); }
	ruleDesiredValue{ after(grammarAccess.getValuePredicateAccess().getDesiredValueDesiredValueParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DesiredValue__DesiredAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDesiredValueAccess().getDesiredAVariableReferenceParserRuleCall_0_0()); }
	ruleAVariableReference{ after(grammarAccess.getDesiredValueAccess().getDesiredAVariableReferenceParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DesiredValue__UptoAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDesiredValueAccess().getUptoUptoKeyword_1_0_0()); }
(
{ before(grammarAccess.getDesiredValueAccess().getUptoUptoKeyword_1_0_0()); }

	Upto 

{ after(grammarAccess.getDesiredValueAccess().getUptoUptoKeyword_1_0_0()); }
)

{ after(grammarAccess.getDesiredValueAccess().getUptoUptoKeyword_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DesiredValue__ValueAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDesiredValueAccess().getValueAExpressionParserRuleCall_2_0()); }
	ruleAExpression{ after(grammarAccess.getDesiredValueAccess().getValueAExpressionParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ExternalDocument__DocReferenceAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExternalDocumentAccess().getDocReferenceDOCPATHParserRuleCall_0_0()); }
	ruleDOCPATH{ after(grammarAccess.getExternalDocumentAccess().getDocReferenceDOCPATHParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ExternalDocument__DocFragmentAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExternalDocumentAccess().getDocFragmentQualifiedNameParserRuleCall_1_1_0()); }
	ruleQualifiedName{ after(grammarAccess.getExternalDocumentAccess().getDocFragmentQualifiedNameParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getNameIDTerminalRuleCall_2_0()); }
	RULE_ID{ after(grammarAccess.getValDeclarationAccess().getNameIDTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__TypeAssignment_3_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getTypeTypeRefParserRuleCall_3_1_0_0()); }
	ruleTypeRef{ after(grammarAccess.getValDeclarationAccess().getTypeTypeRefParserRuleCall_3_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__TypeAssignment_3_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getTypePropertyRefParserRuleCall_3_1_1_1_0()); }
	rulePropertyRef{ after(grammarAccess.getValDeclarationAccess().getTypePropertyRefParserRuleCall_3_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__RangeAssignment_3_1_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getRangeLeftSquareBracketKeyword_3_1_2_0_0()); }
(
{ before(grammarAccess.getValDeclarationAccess().getRangeLeftSquareBracketKeyword_3_1_2_0_0()); }

	LeftSquareBracket 

{ after(grammarAccess.getValDeclarationAccess().getRangeLeftSquareBracketKeyword_3_1_2_0_0()); }
)

{ after(grammarAccess.getValDeclarationAccess().getRangeLeftSquareBracketKeyword_3_1_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__TypeAssignment_3_1_2_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getTypeTypeRefParserRuleCall_3_1_2_1_0_0()); }
	ruleTypeRef{ after(grammarAccess.getValDeclarationAccess().getTypeTypeRefParserRuleCall_3_1_2_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__TypeAssignment_3_1_2_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getTypePropertyRefParserRuleCall_3_1_2_1_1_1_0()); }
	rulePropertyRef{ after(grammarAccess.getValDeclarationAccess().getTypePropertyRefParserRuleCall_3_1_2_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__ValueAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getValueAExpressionParserRuleCall_5_0()); }
	ruleAExpression{ after(grammarAccess.getValDeclarationAccess().getValueAExpressionParserRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ValDeclaration__PropertyAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getValDeclarationAccess().getPropertyPropertyRefParserRuleCall_6_1_0()); }
	rulePropertyRef{ after(grammarAccess.getValDeclarationAccess().getPropertyPropertyRefParserRuleCall_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Description__DescriptionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_1_0()); }
	ruleDescriptionElement{ after(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionElement__TextAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); }
	RULE_STRING{ after(grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionElement__ThisTargetAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_1_0()); }
(
{ before(grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_1_0()); }

	This 

{ after(grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_1_0()); }
)

{ after(grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionElement__ImageAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDescriptionElementAccess().getImageImageReferenceParserRuleCall_2_0()); }
	ruleImageReference{ after(grammarAccess.getDescriptionElementAccess().getImageImageReferenceParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionElement__ShowValueAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDescriptionElementAccess().getShowValueShowValueParserRuleCall_3_0()); }
	ruleShowValue{ after(grammarAccess.getDescriptionElementAccess().getShowValueShowValueParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Rationale__DescriptionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRationaleAccess().getDescriptionDescriptionElementParserRuleCall_1_0()); }
	ruleDescriptionElement{ after(grammarAccess.getRationaleAccess().getDescriptionDescriptionElementParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Uncertainty__VolatilityAssignment_3_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUncertaintyAccess().getVolatilityINTTerminalRuleCall_3_0_1_0()); }
	RULE_INT{ after(grammarAccess.getUncertaintyAccess().getVolatilityINTTerminalRuleCall_3_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Uncertainty__PrecedenceAssignment_3_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUncertaintyAccess().getPrecedenceINTTerminalRuleCall_3_1_1_0()); }
	RULE_INT{ after(grammarAccess.getUncertaintyAccess().getPrecedenceINTTerminalRuleCall_3_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Uncertainty__ImpactAssignment_3_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUncertaintyAccess().getImpactINTTerminalRuleCall_3_2_1_0()); }
	RULE_INT{ after(grammarAccess.getUncertaintyAccess().getImpactINTTerminalRuleCall_3_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__ReferencedUnitsTypeAssignment_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_1_2_1_0()); }
(
{ before(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeAADLPROPERTYREFERENCEParserRuleCall_1_2_1_0_1()); }
	ruleAADLPROPERTYREFERENCE{ after(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeAADLPROPERTYREFERENCEParserRuleCall_1_2_1_0_1()); }
)
{ after(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__ReferencedUnitsTypeAssignment_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_2_2_1_0()); }
(
{ before(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeAADLPROPERTYREFERENCEParserRuleCall_2_2_1_0_1()); }
	ruleAADLPROPERTYREFERENCE{ after(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeAADLPROPERTYREFERENCEParserRuleCall_2_2_1_0_1()); }
)
{ after(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__RefAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefAccess().getRefPropertyTypeCrossReference_5_1_0()); }
(
{ before(grammarAccess.getTypeRefAccess().getRefPropertyTypeAADLPROPERTYREFERENCEParserRuleCall_5_1_0_1()); }
	ruleAADLPROPERTYREFERENCE{ after(grammarAccess.getTypeRefAccess().getRefPropertyTypeAADLPROPERTYREFERENCEParserRuleCall_5_1_0_1()); }
)
{ after(grammarAccess.getTypeRefAccess().getRefPropertyTypeCrossReference_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyRef__RefAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyRefAccess().getRefPropertyCrossReference_1_0()); }
(
{ before(grammarAccess.getPropertyRefAccess().getRefPropertyAADLPROPERTYREFERENCEParserRuleCall_1_0_1()); }
	ruleAADLPROPERTYREFERENCE{ after(grammarAccess.getPropertyRefAccess().getRefPropertyAADLPROPERTYREFERENCEParserRuleCall_1_0_1()); }
)
{ after(grammarAccess.getPropertyRefAccess().getRefPropertyCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getNameIDTerminalRuleCall_2_0()); }
	RULE_ID{ after(grammarAccess.getComputeDeclarationAccess().getNameIDTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__TypeAssignment_4_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getTypeTypeRefParserRuleCall_4_0_0()); }
	ruleTypeRef{ after(grammarAccess.getComputeDeclarationAccess().getTypeTypeRefParserRuleCall_4_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__TypeAssignment_4_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getTypePropertyRefParserRuleCall_4_1_1_0()); }
	rulePropertyRef{ after(grammarAccess.getComputeDeclarationAccess().getTypePropertyRefParserRuleCall_4_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__RangeAssignment_4_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getRangeLeftSquareBracketKeyword_4_2_0_0()); }
(
{ before(grammarAccess.getComputeDeclarationAccess().getRangeLeftSquareBracketKeyword_4_2_0_0()); }

	LeftSquareBracket 

{ after(grammarAccess.getComputeDeclarationAccess().getRangeLeftSquareBracketKeyword_4_2_0_0()); }
)

{ after(grammarAccess.getComputeDeclarationAccess().getRangeLeftSquareBracketKeyword_4_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__TypeAssignment_4_2_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getTypeTypeRefParserRuleCall_4_2_1_0_0()); }
	ruleTypeRef{ after(grammarAccess.getComputeDeclarationAccess().getTypeTypeRefParserRuleCall_4_2_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComputeDeclaration__TypeAssignment_4_2_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputeDeclarationAccess().getTypePropertyRefParserRuleCall_4_2_1_1_1_0()); }
	rulePropertyRef{ after(grammarAccess.getComputeDeclarationAccess().getTypePropertyRefParserRuleCall_4_2_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AModelOrPropertyReference__PropertyAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_0_1_1_0()); }
(
{ before(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_0_1_1_0_1()); }
	ruleAADLPROPERTYREFERENCE{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_0_1_1_0_1()); }
)
{ after(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AModelReference__ModelElementAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelReferenceAccess().getModelElementNamedElementCrossReference_0_0()); }
(
{ before(grammarAccess.getAModelReferenceAccess().getModelElementNamedElementThisKeywordParserRuleCall_0_0_1()); }
	ruleThisKeyword{ after(grammarAccess.getAModelReferenceAccess().getModelElementNamedElementThisKeywordParserRuleCall_0_0_1()); }
)
{ after(grammarAccess.getAModelReferenceAccess().getModelElementNamedElementCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AModelReference__ModelElementAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAModelReferenceAccess().getModelElementNamedElementCrossReference_1_2_0()); }
(
{ before(grammarAccess.getAModelReferenceAccess().getModelElementNamedElementIDTerminalRuleCall_1_2_0_1()); }
	RULE_ID{ after(grammarAccess.getAModelReferenceAccess().getModelElementNamedElementIDTerminalRuleCall_1_2_0_1()); }
)
{ after(grammarAccess.getAModelReferenceAccess().getModelElementNamedElementCrossReference_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__APropertyReference__PropertyAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0()); }
(
{ before(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_2_0_1()); }
	ruleAADLPROPERTYREFERENCE{ after(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_2_0_1()); }
)
{ after(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AVariableReference__VariableAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAVariableReferenceAccess().getVariableAVariableDeclarationCrossReference_1_0()); }
(
{ before(grammarAccess.getAVariableReferenceAccess().getVariableAVariableDeclarationIDTerminalRuleCall_1_0_1()); }
	RULE_ID{ after(grammarAccess.getAVariableReferenceAccess().getVariableAVariableDeclarationIDTerminalRuleCall_1_0_1()); }
)
{ after(grammarAccess.getAVariableReferenceAccess().getVariableAVariableDeclarationCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__ExpressionAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getExpressionAVariableReferenceParserRuleCall_0_0()); }
	ruleAVariableReference{ after(grammarAccess.getShowValueAccess().getExpressionAVariableReferenceParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__ConvertAssignment_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getConvertPercentSignKeyword_1_0_0_0()); }
(
{ before(grammarAccess.getShowValueAccess().getConvertPercentSignKeyword_1_0_0_0()); }

	PercentSign 

{ after(grammarAccess.getShowValueAccess().getConvertPercentSignKeyword_1_0_0_0()); }
)

{ after(grammarAccess.getShowValueAccess().getConvertPercentSignKeyword_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__DropAssignment_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getDropInKeyword_1_0_1_0()); }
(
{ before(grammarAccess.getShowValueAccess().getDropInKeyword_1_0_1_0()); }

	In 

{ after(grammarAccess.getShowValueAccess().getDropInKeyword_1_0_1_0()); }
)

{ after(grammarAccess.getShowValueAccess().getDropInKeyword_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShowValue__UnitAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShowValueAccess().getUnitUnitLiteralCrossReference_1_1_0()); }
(
{ before(grammarAccess.getShowValueAccess().getUnitUnitLiteralIDTerminalRuleCall_1_1_0_1()); }
	RULE_ID{ after(grammarAccess.getShowValueAccess().getUnitUnitLiteralIDTerminalRuleCall_1_1_0_1()); }
)
{ after(grammarAccess.getShowValueAccess().getUnitUnitLiteralCrossReference_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImageReference__ImgfileAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImageReferenceAccess().getImgfileIMGREFParserRuleCall_1_0()); }
	ruleIMGREF{ after(grammarAccess.getImageReferenceAccess().getImgfileIMGREFParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__OperatorAssignment_1_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getOperatorOpOrParserRuleCall_1_0_0_1_0()); }
	ruleOpOr{ after(grammarAccess.getAOrExpressionAccess().getOperatorOpOrParserRuleCall_1_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AOrExpression__RightAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAOrExpressionAccess().getRightAAndExpressionParserRuleCall_1_1_0()); }
	ruleAAndExpression{ after(grammarAccess.getAOrExpressionAccess().getRightAAndExpressionParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__OperatorAssignment_1_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getOperatorOpAndParserRuleCall_1_0_0_1_0()); }
	ruleOpAnd{ after(grammarAccess.getAAndExpressionAccess().getOperatorOpAndParserRuleCall_1_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AAndExpression__RightAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAndExpressionAccess().getRightAEqualityExpressionParserRuleCall_1_1_0()); }
	ruleAEqualityExpression{ after(grammarAccess.getAAndExpressionAccess().getRightAEqualityExpressionParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__OperatorAssignment_1_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getOperatorOpEqualityParserRuleCall_1_0_0_1_0()); }
	ruleOpEquality{ after(grammarAccess.getAEqualityExpressionAccess().getOperatorOpEqualityParserRuleCall_1_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AEqualityExpression__RightAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAEqualityExpressionAccess().getRightARelationalExpressionParserRuleCall_1_1_0()); }
	ruleARelationalExpression{ after(grammarAccess.getAEqualityExpressionAccess().getRightARelationalExpressionParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__OperatorAssignment_1_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getOperatorOpCompareParserRuleCall_1_0_0_1_0()); }
	ruleOpCompare{ after(grammarAccess.getARelationalExpressionAccess().getOperatorOpCompareParserRuleCall_1_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ARelationalExpression__RightAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARelationalExpressionAccess().getRightAAdditiveExpressionParserRuleCall_1_1_0()); }
	ruleAAdditiveExpression{ after(grammarAccess.getARelationalExpressionAccess().getRightAAdditiveExpressionParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__OperatorAssignment_1_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getOperatorOpAddParserRuleCall_1_0_0_1_0()); }
	ruleOpAdd{ after(grammarAccess.getAAdditiveExpressionAccess().getOperatorOpAddParserRuleCall_1_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AAdditiveExpression__RightAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAAdditiveExpressionAccess().getRightAMultiplicativeExpressionParserRuleCall_1_1_0()); }
	ruleAMultiplicativeExpression{ after(grammarAccess.getAAdditiveExpressionAccess().getRightAMultiplicativeExpressionParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__OperatorAssignment_1_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorOpMultiParserRuleCall_1_0_0_1_0()); }
	ruleOpMulti{ after(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorOpMultiParserRuleCall_1_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AMultiplicativeExpression__RightAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAMultiplicativeExpressionAccess().getRightAUnaryOperationParserRuleCall_1_1_0()); }
	ruleAUnaryOperation{ after(grammarAccess.getAMultiplicativeExpressionAccess().getRightAUnaryOperationParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AUnaryOperation__OperatorAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0()); }
	ruleOpUnary{ after(grammarAccess.getAUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AUnaryOperation__OperandAssignment_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnaryOperationAccess().getOperandAUnaryOperationParserRuleCall_0_2_0()); }
	ruleAUnaryOperation{ after(grammarAccess.getAUnaryOperationAccess().getOperandAUnaryOperationParserRuleCall_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__ConvertAssignment_1_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0()); }
(
{ before(grammarAccess.getAUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0()); }

	PercentSign 

{ after(grammarAccess.getAUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0()); }
)

{ after(grammarAccess.getAUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__DropAssignment_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getDropInKeyword_1_1_1_0()); }
(
{ before(grammarAccess.getAUnitExpressionAccess().getDropInKeyword_1_1_1_0()); }

	In 

{ after(grammarAccess.getAUnitExpressionAccess().getDropInKeyword_1_1_1_0()); }
)

{ after(grammarAccess.getAUnitExpressionAccess().getDropInKeyword_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AUnitExpression__UnitAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAUnitExpressionAccess().getUnitUnitLiteralCrossReference_1_2_0()); }
(
{ before(grammarAccess.getAUnitExpressionAccess().getUnitUnitLiteralIDTerminalRuleCall_1_2_0_1()); }
	RULE_ID{ after(grammarAccess.getAUnitExpressionAccess().getUnitUnitLiteralIDTerminalRuleCall_1_2_0_1()); }
)
{ after(grammarAccess.getAUnitExpressionAccess().getUnitUnitLiteralCrossReference_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__FunctionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getFunctionQualifiedNameParserRuleCall_1_0()); }
	ruleQualifiedName{ after(grammarAccess.getAFunctionCallAccess().getFunctionQualifiedNameParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__ArgumentsAssignment_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_0_0()); }
	ruleAExpression{ after(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AFunctionCall__ArgumentsAssignment_3_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_1_1_0()); }
	ruleAExpression{ after(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__MinimumAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getMinimumAExpressionParserRuleCall_2_0()); }
	ruleAExpression{ after(grammarAccess.getARangeExpressionAccess().getMinimumAExpressionParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__MaximumAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getMaximumAExpressionParserRuleCall_4_0()); }
	ruleAExpression{ after(grammarAccess.getARangeExpressionAccess().getMaximumAExpressionParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ARangeExpression__DeltaAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARangeExpressionAccess().getDeltaAExpressionParserRuleCall_5_1_0()); }
	ruleAExpression{ after(grammarAccess.getARangeExpressionAccess().getDeltaAExpressionParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__IfAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getIfAExpressionParserRuleCall_2_0()); }
	ruleAExpression{ after(grammarAccess.getAIfExpressionAccess().getIfAExpressionParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__ThenAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getThenAExpressionParserRuleCall_4_0()); }
	ruleAExpression{ after(grammarAccess.getAIfExpressionAccess().getThenAExpressionParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AIfExpression__ElseAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIfExpressionAccess().getElseAExpressionParserRuleCall_5_1_0()); }
	ruleAExpression{ after(grammarAccess.getAIfExpressionAccess().getElseAExpressionParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AIntegerTerm__ValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAIntegerTermAccess().getValueAIntParserRuleCall_0()); }
	ruleAInt{ after(grammarAccess.getAIntegerTermAccess().getValueAIntParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ARealTerm__ValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getARealTermAccess().getValueARealParserRuleCall_0()); }
	ruleAReal{ after(grammarAccess.getARealTermAccess().getValueARealParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ABooleanLiteral__ValueAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getABooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }
(
{ before(grammarAccess.getABooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }

	True 

{ after(grammarAccess.getABooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }
)

{ after(grammarAccess.getABooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StringTerm__ValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); }
	ruleNoQuoteString{ after(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}



/*
<copyright>
Copyright  2016 by Carnegie Mellon University, all rights reserved.

Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
at http://www.eclipse.org/org/documents/epl-v10.html.

NO WARRANTY

ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.

Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
employees, and agents from all claims or demands made against them (and any related losses, expenses, or
attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
product liability, personal injury, death, damage to property, or violation of any laws or regulations.

Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
under the contract clause at 252.227.7013.
</copyright>
 */
grammar InternalInstance;

options {
	superClass=AbstractInternalContentAssistParser;
	
}

@lexer::header {
package org.osate.aadl2.instance.textual.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.osate.aadl2.instance.textual.ui.contentassist.antlr.internal; 

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
import org.osate.aadl2.instance.textual.services.InstanceGrammarAccess;

}

@parser::members {
 
 	private InstanceGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(InstanceGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }
    
    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleSystemInstance
entryRuleSystemInstance 
:
{ before(grammarAccess.getSystemInstanceRule()); }
	 ruleSystemInstance
{ after(grammarAccess.getSystemInstanceRule()); } 
	 EOF 
;

// Rule SystemInstance
ruleSystemInstance
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSystemInstanceAccess().getGroup()); }
(rule__SystemInstance__Group__0)
{ after(grammarAccess.getSystemInstanceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleFeatureInstance
entryRuleFeatureInstance 
:
{ before(grammarAccess.getFeatureInstanceRule()); }
	 ruleFeatureInstance
{ after(grammarAccess.getFeatureInstanceRule()); } 
	 EOF 
;

// Rule FeatureInstance
ruleFeatureInstance
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getFeatureInstanceAccess().getGroup()); }
(rule__FeatureInstance__Group__0)
{ after(grammarAccess.getFeatureInstanceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleComponentInstance
entryRuleComponentInstance 
:
{ before(grammarAccess.getComponentInstanceRule()); }
	 ruleComponentInstance
{ after(grammarAccess.getComponentInstanceRule()); } 
	 EOF 
;

// Rule ComponentInstance
ruleComponentInstance
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getComponentInstanceAccess().getGroup()); }
(rule__ComponentInstance__Group__0)
{ after(grammarAccess.getComponentInstanceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleConnectionInstance
entryRuleConnectionInstance 
:
{ before(grammarAccess.getConnectionInstanceRule()); }
	 ruleConnectionInstance
{ after(grammarAccess.getConnectionInstanceRule()); } 
	 EOF 
;

// Rule ConnectionInstance
ruleConnectionInstance
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getConnectionInstanceAccess().getGroup()); }
(rule__ConnectionInstance__Group__0)
{ after(grammarAccess.getConnectionInstanceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleConnectionReference
entryRuleConnectionReference 
:
{ before(grammarAccess.getConnectionReferenceRule()); }
	 ruleConnectionReference
{ after(grammarAccess.getConnectionReferenceRule()); } 
	 EOF 
;

// Rule ConnectionReference
ruleConnectionReference
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getConnectionReferenceAccess().getGroup()); }
(rule__ConnectionReference__Group__0)
{ after(grammarAccess.getConnectionReferenceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleFlowSpecificationInstance
entryRuleFlowSpecificationInstance 
:
{ before(grammarAccess.getFlowSpecificationInstanceRule()); }
	 ruleFlowSpecificationInstance
{ after(grammarAccess.getFlowSpecificationInstanceRule()); } 
	 EOF 
;

// Rule FlowSpecificationInstance
ruleFlowSpecificationInstance
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getGroup()); }
(rule__FlowSpecificationInstance__Group__0)
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEndToEndFlowInstance
entryRuleEndToEndFlowInstance 
:
{ before(grammarAccess.getEndToEndFlowInstanceRule()); }
	 ruleEndToEndFlowInstance
{ after(grammarAccess.getEndToEndFlowInstanceRule()); } 
	 EOF 
;

// Rule EndToEndFlowInstance
ruleEndToEndFlowInstance
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getGroup()); }
(rule__EndToEndFlowInstance__Group__0)
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleModeInstance
entryRuleModeInstance 
:
{ before(grammarAccess.getModeInstanceRule()); }
	 ruleModeInstance
{ after(grammarAccess.getModeInstanceRule()); } 
	 EOF 
;

// Rule ModeInstance
ruleModeInstance
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getModeInstanceAccess().getGroup()); }
(rule__ModeInstance__Group__0)
{ after(grammarAccess.getModeInstanceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleModeTransitionInstance
entryRuleModeTransitionInstance 
:
{ before(grammarAccess.getModeTransitionInstanceRule()); }
	 ruleModeTransitionInstance
{ after(grammarAccess.getModeTransitionInstanceRule()); } 
	 EOF 
;

// Rule ModeTransitionInstance
ruleModeTransitionInstance
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getGroup()); }
(rule__ModeTransitionInstance__Group__0)
{ after(grammarAccess.getModeTransitionInstanceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSystemOperationMode
entryRuleSystemOperationMode 
:
{ before(grammarAccess.getSystemOperationModeRule()); }
	 ruleSystemOperationMode
{ after(grammarAccess.getSystemOperationModeRule()); } 
	 EOF 
;

// Rule SystemOperationMode
ruleSystemOperationMode
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSystemOperationModeAccess().getGroup()); }
(rule__SystemOperationMode__Group__0)
{ after(grammarAccess.getSystemOperationModeAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePropertyAssociationInstance
entryRulePropertyAssociationInstance 
:
{ before(grammarAccess.getPropertyAssociationInstanceRule()); }
	 rulePropertyAssociationInstance
{ after(grammarAccess.getPropertyAssociationInstanceRule()); } 
	 EOF 
;

// Rule PropertyAssociationInstance
rulePropertyAssociationInstance
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPropertyAssociationInstanceAccess().getGroup()); }
(rule__PropertyAssociationInstance__Group__0)
{ after(grammarAccess.getPropertyAssociationInstanceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOptionalModalPropertyValue
entryRuleOptionalModalPropertyValue 
:
{ before(grammarAccess.getOptionalModalPropertyValueRule()); }
	 ruleOptionalModalPropertyValue
{ after(grammarAccess.getOptionalModalPropertyValueRule()); } 
	 EOF 
;

// Rule OptionalModalPropertyValue
ruleOptionalModalPropertyValue
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getGroup()); }
(rule__OptionalModalPropertyValue__Group__0)
{ after(grammarAccess.getOptionalModalPropertyValueAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePropertyExpression
entryRulePropertyExpression 
:
{ before(grammarAccess.getPropertyExpressionRule()); }
	 rulePropertyExpression
{ after(grammarAccess.getPropertyExpressionRule()); } 
	 EOF 
;

// Rule PropertyExpression
rulePropertyExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPropertyExpressionAccess().getAlternatives()); }
(rule__PropertyExpression__Alternatives)
{ after(grammarAccess.getPropertyExpressionAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleContainmentPathElement
entryRuleContainmentPathElement 
:
{ before(grammarAccess.getContainmentPathElementRule()); }
	 ruleContainmentPathElement
{ after(grammarAccess.getContainmentPathElementRule()); } 
	 EOF 
;

// Rule ContainmentPathElement
ruleContainmentPathElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getContainmentPathElementAccess().getGroup()); }
(rule__ContainmentPathElement__Group__0)
{ after(grammarAccess.getContainmentPathElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleInstanceReferenceValue
entryRuleInstanceReferenceValue 
:
{ before(grammarAccess.getInstanceReferenceValueRule()); }
	 ruleInstanceReferenceValue
{ after(grammarAccess.getInstanceReferenceValueRule()); } 
	 EOF 
;

// Rule InstanceReferenceValue
ruleInstanceReferenceValue
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getInstanceReferenceValueAccess().getGroup()); }
(rule__InstanceReferenceValue__Group__0)
{ after(grammarAccess.getInstanceReferenceValueAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDirectionType
entryRuleDirectionType 
:
{ before(grammarAccess.getDirectionTypeRule()); }
	 ruleDirectionType
{ after(grammarAccess.getDirectionTypeRule()); } 
	 EOF 
;

// Rule DirectionType
ruleDirectionType
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDirectionTypeAccess().getAlternatives()); }
(rule__DirectionType__Alternatives)
{ after(grammarAccess.getDirectionTypeAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleFeatureCategory
entryRuleFeatureCategory 
:
{ before(grammarAccess.getFeatureCategoryRule()); }
	 ruleFeatureCategory
{ after(grammarAccess.getFeatureCategoryRule()); } 
	 EOF 
;

// Rule FeatureCategory
ruleFeatureCategory
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getFeatureCategoryAccess().getAlternatives()); }
(rule__FeatureCategory__Alternatives)
{ after(grammarAccess.getFeatureCategoryAccess().getAlternatives()); }
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



// Entry rule entryRuleConnectionKind
entryRuleConnectionKind 
:
{ before(grammarAccess.getConnectionKindRule()); }
	 ruleConnectionKind
{ after(grammarAccess.getConnectionKindRule()); } 
	 EOF 
;

// Rule ConnectionKind
ruleConnectionKind
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getConnectionKindAccess().getAlternatives()); }
(rule__ConnectionKind__Alternatives)
{ after(grammarAccess.getConnectionKindAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleClassifierRef
entryRuleClassifierRef 
:
{ before(grammarAccess.getClassifierRefRule()); }
	 ruleClassifierRef
{ after(grammarAccess.getClassifierRefRule()); } 
	 EOF 
;

// Rule ClassifierRef
ruleClassifierRef
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getClassifierRefAccess().getGroup()); }
(rule__ClassifierRef__Group__0)
{ after(grammarAccess.getClassifierRefAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleImplRef
entryRuleImplRef 
:
{ before(grammarAccess.getImplRefRule()); }
	 ruleImplRef
{ after(grammarAccess.getImplRefRule()); } 
	 EOF 
;

// Rule ImplRef
ruleImplRef
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getImplRefAccess().getGroup()); }
(rule__ImplRef__Group__0)
{ after(grammarAccess.getImplRefAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDeclarativeRef
entryRuleDeclarativeRef 
:
{ before(grammarAccess.getDeclarativeRefRule()); }
	 ruleDeclarativeRef
{ after(grammarAccess.getDeclarativeRefRule()); } 
	 EOF 
;

// Rule DeclarativeRef
ruleDeclarativeRef
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDeclarativeRefAccess().getGroup()); }
(rule__DeclarativeRef__Group__0)
{ after(grammarAccess.getDeclarativeRefAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleInstanceRef
entryRuleInstanceRef 
:
{ before(grammarAccess.getInstanceRefRule()); }
	 ruleInstanceRef
{ after(grammarAccess.getInstanceRefRule()); } 
	 EOF 
;

// Rule InstanceRef
ruleInstanceRef
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getInstanceRefAccess().getAlternatives()); }
(rule__InstanceRef__Alternatives)
{ after(grammarAccess.getInstanceRefAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTransitionRef
entryRuleTransitionRef 
:
{ before(grammarAccess.getTransitionRefRule()); }
	 ruleTransitionRef
{ after(grammarAccess.getTransitionRefRule()); } 
	 EOF 
;

// Rule TransitionRef
ruleTransitionRef
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTransitionRefAccess().getGroup()); }
(rule__TransitionRef__Group__0)
{ after(grammarAccess.getTransitionRefAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePropertyAssociationRef
entryRulePropertyAssociationRef 
:
{ before(grammarAccess.getPropertyAssociationRefRule()); }
	 rulePropertyAssociationRef
{ after(grammarAccess.getPropertyAssociationRefRule()); } 
	 EOF 
;

// Rule PropertyAssociationRef
rulePropertyAssociationRef
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getGroup()); }
(rule__PropertyAssociationRef__Group__0)
{ after(grammarAccess.getPropertyAssociationRefAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLong
entryRuleLong 
:
{ before(grammarAccess.getLongRule()); }
	 ruleLong
{ after(grammarAccess.getLongRule()); } 
	 EOF 
;

// Rule Long
ruleLong
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLongAccess().getINTEGER_LITTerminalRuleCall()); }
	RULE_INTEGER_LIT
{ after(grammarAccess.getLongAccess().getINTEGER_LITTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}





// Entry rule entryRuleContainedPropertyAssociation
entryRuleContainedPropertyAssociation 
:
{ before(grammarAccess.getContainedPropertyAssociationRule()); }
	 ruleContainedPropertyAssociation
{ after(grammarAccess.getContainedPropertyAssociationRule()); } 
	 EOF 
;

// Rule ContainedPropertyAssociation
ruleContainedPropertyAssociation
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getGroup()); }
(rule__ContainedPropertyAssociation__Group__0)
{ after(grammarAccess.getContainedPropertyAssociationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}







// Entry rule entryRuleContainmentPath
entryRuleContainmentPath 
:
{ before(grammarAccess.getContainmentPathRule()); }
	 ruleContainmentPath
{ after(grammarAccess.getContainmentPathRule()); } 
	 EOF 
;

// Rule ContainmentPath
ruleContainmentPath
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getContainmentPathAccess().getPathAssignment()); }
(rule__ContainmentPath__PathAssignment)
{ after(grammarAccess.getContainmentPathAccess().getPathAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}





// Entry rule entryRulePropertyValue
entryRulePropertyValue 
:
{ before(grammarAccess.getPropertyValueRule()); }
	 rulePropertyValue
{ after(grammarAccess.getPropertyValueRule()); } 
	 EOF 
;

// Rule PropertyValue
rulePropertyValue
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPropertyValueAccess().getOwnedValueAssignment()); }
(rule__PropertyValue__OwnedValueAssignment)
{ after(grammarAccess.getPropertyValueAccess().getOwnedValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLiteralorReferenceTerm
entryRuleLiteralorReferenceTerm 
:
{ before(grammarAccess.getLiteralorReferenceTermRule()); }
	 ruleLiteralorReferenceTerm
{ after(grammarAccess.getLiteralorReferenceTermRule()); } 
	 EOF 
;

// Rule LiteralorReferenceTerm
ruleLiteralorReferenceTerm
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAssignment()); }
(rule__LiteralorReferenceTerm__NamedValueAssignment)
{ after(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleBooleanLiteral
entryRuleBooleanLiteral 
:
{ before(grammarAccess.getBooleanLiteralRule()); }
	 ruleBooleanLiteral
{ after(grammarAccess.getBooleanLiteralRule()); } 
	 EOF 
;

// Rule BooleanLiteral
ruleBooleanLiteral
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getBooleanLiteralAccess().getGroup()); }
(rule__BooleanLiteral__Group__0)
{ after(grammarAccess.getBooleanLiteralAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleConstantValue
entryRuleConstantValue 
:
{ before(grammarAccess.getConstantValueRule()); }
	 ruleConstantValue
{ after(grammarAccess.getConstantValueRule()); } 
	 EOF 
;

// Rule ConstantValue
ruleConstantValue
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getConstantValueAccess().getNamedValueAssignment()); }
(rule__ConstantValue__NamedValueAssignment)
{ after(grammarAccess.getConstantValueAccess().getNamedValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleReferenceTerm
entryRuleReferenceTerm 
:
{ before(grammarAccess.getReferenceTermRule()); }
	 ruleReferenceTerm
{ after(grammarAccess.getReferenceTermRule()); } 
	 EOF 
;

// Rule ReferenceTerm
ruleReferenceTerm
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getReferenceTermAccess().getGroup()); }
(rule__ReferenceTerm__Group__0)
{ after(grammarAccess.getReferenceTermAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRecordTerm
entryRuleRecordTerm 
:
{ before(grammarAccess.getRecordTermRule()); }
	 ruleRecordTerm
{ after(grammarAccess.getRecordTermRule()); } 
	 EOF 
;

// Rule RecordTerm
ruleRecordTerm
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRecordTermAccess().getGroup()); }
(rule__RecordTerm__Group__0)
{ after(grammarAccess.getRecordTermAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}





// Entry rule entryRuleComputedTerm
entryRuleComputedTerm 
:
{ before(grammarAccess.getComputedTermRule()); }
	 ruleComputedTerm
{ after(grammarAccess.getComputedTermRule()); } 
	 EOF 
;

// Rule ComputedTerm
ruleComputedTerm
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getComputedTermAccess().getGroup()); }
(rule__ComputedTerm__Group__0)
{ after(grammarAccess.getComputedTermAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleComponentClassifierTerm
entryRuleComponentClassifierTerm 
:
{ before(grammarAccess.getComponentClassifierTermRule()); }
	 ruleComponentClassifierTerm
{ after(grammarAccess.getComponentClassifierTermRule()); } 
	 EOF 
;

// Rule ComponentClassifierTerm
ruleComponentClassifierTerm
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getComponentClassifierTermAccess().getGroup()); }
(rule__ComponentClassifierTerm__Group__0)
{ after(grammarAccess.getComponentClassifierTermAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleListTerm
entryRuleListTerm 
:
{ before(grammarAccess.getListTermRule()); }
	 ruleListTerm
{ after(grammarAccess.getListTermRule()); } 
	 EOF 
;

// Rule ListTerm
ruleListTerm
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getListTermAccess().getGroup()); }
(rule__ListTerm__Group__0)
{ after(grammarAccess.getListTermAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleFieldPropertyAssociation
entryRuleFieldPropertyAssociation 
:
{ before(grammarAccess.getFieldPropertyAssociationRule()); }
	 ruleFieldPropertyAssociation
{ after(grammarAccess.getFieldPropertyAssociationRule()); } 
	 EOF 
;

// Rule FieldPropertyAssociation
ruleFieldPropertyAssociation
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getFieldPropertyAssociationAccess().getGroup()); }
(rule__FieldPropertyAssociation__Group__0)
{ after(grammarAccess.getFieldPropertyAssociationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}





// Entry rule entryRulePlusMinus
entryRulePlusMinus 
:
{ before(grammarAccess.getPlusMinusRule()); }
	 rulePlusMinus
{ after(grammarAccess.getPlusMinusRule()); } 
	 EOF 
;

// Rule PlusMinus
rulePlusMinus
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPlusMinusAccess().getAlternatives()); }
(rule__PlusMinus__Alternatives)
{ after(grammarAccess.getPlusMinusAccess().getAlternatives()); }
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



// Entry rule entryRuleArrayRange
entryRuleArrayRange 
:
{ before(grammarAccess.getArrayRangeRule()); }
	 ruleArrayRange
{ after(grammarAccess.getArrayRangeRule()); } 
	 EOF 
;

// Rule ArrayRange
ruleArrayRange
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getArrayRangeAccess().getGroup()); }
(rule__ArrayRange__Group__0)
{ after(grammarAccess.getArrayRangeAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSignedConstant
entryRuleSignedConstant 
:
{ before(grammarAccess.getSignedConstantRule()); }
	 ruleSignedConstant
{ after(grammarAccess.getSignedConstantRule()); } 
	 EOF 
;

// Rule SignedConstant
ruleSignedConstant
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSignedConstantAccess().getGroup()); }
(rule__SignedConstant__Group__0)
{ after(grammarAccess.getSignedConstantAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleIntegerTerm
entryRuleIntegerTerm 
:
{ before(grammarAccess.getIntegerTermRule()); }
	 ruleIntegerTerm
{ after(grammarAccess.getIntegerTermRule()); } 
	 EOF 
;

// Rule IntegerTerm
ruleIntegerTerm
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getIntegerTermAccess().getGroup()); }
(rule__IntegerTerm__Group__0)
{ after(grammarAccess.getIntegerTermAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSignedInt
entryRuleSignedInt 
:
{ before(grammarAccess.getSignedIntRule()); }
	 ruleSignedInt
{ after(grammarAccess.getSignedIntRule()); } 
	 EOF 
;

// Rule SignedInt
ruleSignedInt
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSignedIntAccess().getGroup()); }
(rule__SignedInt__Group__0)
{ after(grammarAccess.getSignedIntAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRealTerm
entryRuleRealTerm 
:
{ before(grammarAccess.getRealTermRule()); }
	 ruleRealTerm
{ after(grammarAccess.getRealTermRule()); } 
	 EOF 
;

// Rule RealTerm
ruleRealTerm
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRealTermAccess().getGroup()); }
(rule__RealTerm__Group__0)
{ after(grammarAccess.getRealTermAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSignedReal
entryRuleSignedReal 
:
{ before(grammarAccess.getSignedRealRule()); }
	 ruleSignedReal
{ after(grammarAccess.getSignedRealRule()); } 
	 EOF 
;

// Rule SignedReal
ruleSignedReal
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSignedRealAccess().getGroup()); }
(rule__SignedReal__Group__0)
{ after(grammarAccess.getSignedRealAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNumericRangeTerm
entryRuleNumericRangeTerm 
:
{ before(grammarAccess.getNumericRangeTermRule()); }
	 ruleNumericRangeTerm
{ after(grammarAccess.getNumericRangeTermRule()); } 
	 EOF 
;

// Rule NumericRangeTerm
ruleNumericRangeTerm
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNumericRangeTermAccess().getGroup()); }
(rule__NumericRangeTerm__Group__0)
{ after(grammarAccess.getNumericRangeTermAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNumAlt
entryRuleNumAlt 
:
{ before(grammarAccess.getNumAltRule()); }
	 ruleNumAlt
{ after(grammarAccess.getNumAltRule()); } 
	 EOF 
;

// Rule NumAlt
ruleNumAlt
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNumAltAccess().getAlternatives()); }
(rule__NumAlt__Alternatives)
{ after(grammarAccess.getNumAltAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAppliesToKeywords
entryRuleAppliesToKeywords 
:
{ before(grammarAccess.getAppliesToKeywordsRule()); }
	 ruleAppliesToKeywords
{ after(grammarAccess.getAppliesToKeywordsRule()); } 
	 EOF 
;

// Rule AppliesToKeywords
ruleAppliesToKeywords
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAppliesToKeywordsAccess().getGroup()); }
(rule__AppliesToKeywords__Group__0)
{ after(grammarAccess.getAppliesToKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleInBindingKeywords
entryRuleInBindingKeywords 
:
{ before(grammarAccess.getInBindingKeywordsRule()); }
	 ruleInBindingKeywords
{ after(grammarAccess.getInBindingKeywordsRule()); } 
	 EOF 
;

// Rule InBindingKeywords
ruleInBindingKeywords
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getInBindingKeywordsAccess().getGroup()); }
(rule__InBindingKeywords__Group__0)
{ after(grammarAccess.getInBindingKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleInModesKeywords
entryRuleInModesKeywords 
:
{ before(grammarAccess.getInModesKeywordsRule()); }
	 ruleInModesKeywords
{ after(grammarAccess.getInModesKeywordsRule()); } 
	 EOF 
;

// Rule InModesKeywords
ruleInModesKeywords
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getInModesKeywordsAccess().getGroup()); }
(rule__InModesKeywords__Group__0)
{ after(grammarAccess.getInModesKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleINTVALUE
entryRuleINTVALUE 
:
{ before(grammarAccess.getINTVALUERule()); }
	 ruleINTVALUE
{ after(grammarAccess.getINTVALUERule()); } 
	 EOF 
;

// Rule INTVALUE
ruleINTVALUE
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall()); }
	RULE_INTEGER_LIT
{ after(grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}





// Entry rule entryRuleQPREF
entryRuleQPREF 
:
{ before(grammarAccess.getQPREFRule()); }
	 ruleQPREF
{ after(grammarAccess.getQPREFRule()); } 
	 EOF 
;

// Rule QPREF
ruleQPREF
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getQPREFAccess().getGroup()); }
(rule__QPREF__Group__0)
{ after(grammarAccess.getQPREFAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleQCREF
entryRuleQCREF 
:
{ before(grammarAccess.getQCREFRule()); }
	 ruleQCREF
{ after(grammarAccess.getQCREFRule()); } 
	 EOF 
;

// Rule QCREF
ruleQCREF
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getQCREFAccess().getGroup()); }
(rule__QCREF__Group__0)
{ after(grammarAccess.getQCREFAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSTAR
entryRuleSTAR 
:
{ before(grammarAccess.getSTARRule()); }
	 ruleSTAR
{ after(grammarAccess.getSTARRule()); } 
	 EOF 
;

// Rule STAR
ruleSTAR
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSTARAccess().getAsteriskKeyword()); }

	'*' 

{ after(grammarAccess.getSTARAccess().getAsteriskKeyword()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__SystemInstance__Alternatives_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getFeatureInstanceAssignment_5_0()); }
(rule__SystemInstance__FeatureInstanceAssignment_5_0)
{ after(grammarAccess.getSystemInstanceAccess().getFeatureInstanceAssignment_5_0()); }
)

    |(
{ before(grammarAccess.getSystemInstanceAccess().getComponentInstanceAssignment_5_1()); }
(rule__SystemInstance__ComponentInstanceAssignment_5_1)
{ after(grammarAccess.getSystemInstanceAccess().getComponentInstanceAssignment_5_1()); }
)

    |(
{ before(grammarAccess.getSystemInstanceAccess().getConnectionInstanceAssignment_5_2()); }
(rule__SystemInstance__ConnectionInstanceAssignment_5_2)
{ after(grammarAccess.getSystemInstanceAccess().getConnectionInstanceAssignment_5_2()); }
)

    |(
{ before(grammarAccess.getSystemInstanceAccess().getFlowSpecificationAssignment_5_3()); }
(rule__SystemInstance__FlowSpecificationAssignment_5_3)
{ after(grammarAccess.getSystemInstanceAccess().getFlowSpecificationAssignment_5_3()); }
)

    |(
{ before(grammarAccess.getSystemInstanceAccess().getEndToEndFlowAssignment_5_4()); }
(rule__SystemInstance__EndToEndFlowAssignment_5_4)
{ after(grammarAccess.getSystemInstanceAccess().getEndToEndFlowAssignment_5_4()); }
)

    |(
{ before(grammarAccess.getSystemInstanceAccess().getModeInstanceAssignment_5_5()); }
(rule__SystemInstance__ModeInstanceAssignment_5_5)
{ after(grammarAccess.getSystemInstanceAccess().getModeInstanceAssignment_5_5()); }
)

    |(
{ before(grammarAccess.getSystemInstanceAccess().getModeTransitionInstanceAssignment_5_6()); }
(rule__SystemInstance__ModeTransitionInstanceAssignment_5_6)
{ after(grammarAccess.getSystemInstanceAccess().getModeTransitionInstanceAssignment_5_6()); }
)

    |(
{ before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_5_7()); }
(rule__SystemInstance__SystemOperationModeAssignment_5_7)
{ after(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_5_7()); }
)

    |(
{ before(grammarAccess.getSystemInstanceAccess().getOwnedPropertyAssociationAssignment_5_8()); }
(rule__SystemInstance__OwnedPropertyAssociationAssignment_5_8)
{ after(grammarAccess.getSystemInstanceAccess().getOwnedPropertyAssociationAssignment_5_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__Alternatives_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceAssignment_6_1_0()); }
(rule__FeatureInstance__FeatureInstanceAssignment_6_1_0)
{ after(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceAssignment_6_1_0()); }
)

    |(
{ before(grammarAccess.getFeatureInstanceAccess().getOwnedPropertyAssociationAssignment_6_1_1()); }
(rule__FeatureInstance__OwnedPropertyAssociationAssignment_6_1_1)
{ after(grammarAccess.getFeatureInstanceAccess().getOwnedPropertyAssociationAssignment_6_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Alternatives_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getFeatureInstanceAssignment_7_1_0()); }
(rule__ComponentInstance__FeatureInstanceAssignment_7_1_0)
{ after(grammarAccess.getComponentInstanceAccess().getFeatureInstanceAssignment_7_1_0()); }
)

    |(
{ before(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_7_1_1()); }
(rule__ComponentInstance__ComponentInstanceAssignment_7_1_1)
{ after(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_7_1_1()); }
)

    |(
{ before(grammarAccess.getComponentInstanceAccess().getConnectionInstanceAssignment_7_1_2()); }
(rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2)
{ after(grammarAccess.getComponentInstanceAccess().getConnectionInstanceAssignment_7_1_2()); }
)

    |(
{ before(grammarAccess.getComponentInstanceAccess().getFlowSpecificationAssignment_7_1_3()); }
(rule__ComponentInstance__FlowSpecificationAssignment_7_1_3)
{ after(grammarAccess.getComponentInstanceAccess().getFlowSpecificationAssignment_7_1_3()); }
)

    |(
{ before(grammarAccess.getComponentInstanceAccess().getEndToEndFlowAssignment_7_1_4()); }
(rule__ComponentInstance__EndToEndFlowAssignment_7_1_4)
{ after(grammarAccess.getComponentInstanceAccess().getEndToEndFlowAssignment_7_1_4()); }
)

    |(
{ before(grammarAccess.getComponentInstanceAccess().getModeInstanceAssignment_7_1_5()); }
(rule__ComponentInstance__ModeInstanceAssignment_7_1_5)
{ after(grammarAccess.getComponentInstanceAccess().getModeInstanceAssignment_7_1_5()); }
)

    |(
{ before(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceAssignment_7_1_6()); }
(rule__ComponentInstance__ModeTransitionInstanceAssignment_7_1_6)
{ after(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceAssignment_7_1_6()); }
)

    |(
{ before(grammarAccess.getComponentInstanceAccess().getOwnedPropertyAssociationAssignment_7_1_7()); }
(rule__ComponentInstance__OwnedPropertyAssociationAssignment_7_1_7)
{ after(grammarAccess.getComponentInstanceAccess().getOwnedPropertyAssociationAssignment_7_1_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Alternatives_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getBidirectionalAssignment_5_0()); }
(rule__ConnectionInstance__BidirectionalAssignment_5_0)
{ after(grammarAccess.getConnectionInstanceAccess().getBidirectionalAssignment_5_0()); }
)

    |(
{ before(grammarAccess.getConnectionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1()); }

	'->' 

{ after(grammarAccess.getConnectionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Alternatives_10
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_10_0()); }
(rule__ConnectionInstance__ConnectionReferenceAssignment_10_0)
{ after(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_10_0()); }
)

    |(
{ before(grammarAccess.getConnectionInstanceAccess().getOwnedPropertyAssociationAssignment_10_1()); }
(rule__ConnectionInstance__OwnedPropertyAssociationAssignment_10_1)
{ after(grammarAccess.getConnectionInstanceAccess().getOwnedPropertyAssociationAssignment_10_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Alternatives_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getParentAssignment_4_1_0()); }
(rule__ModeInstance__ParentAssignment_4_1_0)
{ after(grammarAccess.getModeInstanceAccess().getParentAssignment_4_1_0()); }
)

    |(
{ before(grammarAccess.getModeInstanceAccess().getGroup_4_1_1()); }
(rule__ModeInstance__Group_4_1_1__0)
{ after(grammarAccess.getModeInstanceAccess().getGroup_4_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyExpression__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0()); }
	ruleRecordTerm
{ after(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_1()); }
	ruleReferenceTerm
{ after(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getInstanceReferenceValueParserRuleCall_2()); }
	ruleInstanceReferenceValue
{ after(grammarAccess.getPropertyExpressionAccess().getInstanceReferenceValueParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_3()); }
	ruleComponentClassifierTerm
{ after(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_3()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_4()); }
	ruleComputedTerm
{ after(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_4()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_5()); }
	ruleStringTerm
{ after(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_5()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_6()); }
	ruleNumericRangeTerm
{ after(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_6()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_7()); }
	ruleRealTerm
{ after(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_7()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_8()); }
	ruleIntegerTerm
{ after(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_8()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_9()); }
	ruleListTerm
{ after(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_9()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_10()); }
	ruleBooleanLiteral
{ after(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_10()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_11()); }
	ruleLiteralorReferenceTerm
{ after(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_11()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionType__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionTypeAccess().getInKeyword_0()); }

	'in' 

{ after(grammarAccess.getDirectionTypeAccess().getInKeyword_0()); }
)

    |(
{ before(grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); }

	'out' 

{ after(grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); }
)

    |(
{ before(grammarAccess.getDirectionTypeAccess().getGroup_2()); }
(rule__DirectionType__Group_2__0)
{ after(grammarAccess.getDirectionTypeAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCategory__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); }

	'dataPort' 

{ after(grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); }
)

    |(
{ before(grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); }

	'eventPort' 

{ after(grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); }
)

    |(
{ before(grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); }

	'eventDataPort' 

{ after(grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); }
)

    |(
{ before(grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); }

	'parameter' 

{ after(grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); }
)

    |(
{ before(grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); }

	'busAccess' 

{ after(grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); }
)

    |(
{ before(grammarAccess.getFeatureCategoryAccess().getDataAccessKeyword_5()); }

	'dataAccess' 

{ after(grammarAccess.getFeatureCategoryAccess().getDataAccessKeyword_5()); }
)

    |(
{ before(grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_6()); }

	'subprogramAccess' 

{ after(grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_6()); }
)

    |(
{ before(grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_7()); }

	'subprogramGroupAccess' 

{ after(grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_7()); }
)

    |(
{ before(grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_8()); }

	'featureGroup' 

{ after(grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_8()); }
)

    |(
{ before(grammarAccess.getFeatureCategoryAccess().getAbstractFeatureKeyword_9()); }

	'abstractFeature' 

{ after(grammarAccess.getFeatureCategoryAccess().getAbstractFeatureKeyword_9()); }
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

	'abstract' 

{ after(grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); }

	'bus' 

{ after(grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); }

	'data' 

{ after(grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); }

	'device' 

{ after(grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); }

	'memory' 

{ after(grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); }

	'process' 

{ after(grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); }

	'processor' 

{ after(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); }

	'subprogram' 

{ after(grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getGroup_8()); }
(rule__ComponentCategory__Group_8__0)
{ after(grammarAccess.getComponentCategoryAccess().getGroup_8()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); }

	'system' 

{ after(grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getGroup_10()); }
(rule__ComponentCategory__Group_10__0)
{ after(grammarAccess.getComponentCategoryAccess().getGroup_10()); }
)

    |(
{ before(grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); }

	'thread' 

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

rule__ConnectionKind__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionKindAccess().getFeatureConnectionKeyword_0()); }

	'featureConnection' 

{ after(grammarAccess.getConnectionKindAccess().getFeatureConnectionKeyword_0()); }
)

    |(
{ before(grammarAccess.getConnectionKindAccess().getAccessConnectionKeyword_1()); }

	'accessConnection' 

{ after(grammarAccess.getConnectionKindAccess().getAccessConnectionKeyword_1()); }
)

    |(
{ before(grammarAccess.getConnectionKindAccess().getParameterConnectionKeyword_2()); }

	'parameterConnection' 

{ after(grammarAccess.getConnectionKindAccess().getParameterConnectionKeyword_2()); }
)

    |(
{ before(grammarAccess.getConnectionKindAccess().getPortConnectionKeyword_3()); }

	'portConnection' 

{ after(grammarAccess.getConnectionKindAccess().getPortConnectionKeyword_3()); }
)

    |(
{ before(grammarAccess.getConnectionKindAccess().getFeatureGroupConnectionKeyword_4()); }

	'featureGroupConnection' 

{ after(grammarAccess.getConnectionKindAccess().getFeatureGroupConnectionKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DeclarativeRef__Alternatives_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclarativeRefAccess().getGroup_4_0()); }
(rule__DeclarativeRef__Group_4_0__0)
{ after(grammarAccess.getDeclarativeRefAccess().getGroup_4_0()); }
)

    |(
{ before(grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_4_1()); }
	RULE_ID
{ after(grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getParentKeyword_0()); }

	'parent' 

{ after(grammarAccess.getInstanceRefAccess().getParentKeyword_0()); }
)

    |(
{ before(grammarAccess.getInstanceRefAccess().getGroup_1()); }
(rule__InstanceRef__Group_1__0)
{ after(grammarAccess.getInstanceRefAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Alternatives_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getGroup_1_1_0()); }
(rule__InstanceRef__Group_1_1_0__0)
{ after(grammarAccess.getInstanceRefAccess().getGroup_1_1_0()); }
)

    |(
{ before(grammarAccess.getInstanceRefAccess().getGroup_1_1_1()); }
(rule__InstanceRef__Group_1_1_1__0)
{ after(grammarAccess.getInstanceRefAccess().getGroup_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Alternatives_4_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_4_0_0()); }
	RULE_ID
{ after(grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_4_0_0()); }
)

    |(
{ before(grammarAccess.getPropertyAssociationRefAccess().getGroup_4_0_1()); }
(rule__PropertyAssociationRef__Group_4_0_1__0)
{ after(grammarAccess.getPropertyAssociationRefAccess().getGroup_4_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0()); }

	'=>' 

{ after(grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0()); }
)

    |(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppendAssignment_1_1()); }
(rule__ContainedPropertyAssociation__AppendAssignment_1_1)
{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppendAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BooleanLiteral__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBooleanLiteralAccess().getValueAssignment_1_0()); }
(rule__BooleanLiteral__ValueAssignment_1_0)
{ after(grammarAccess.getBooleanLiteralAccess().getValueAssignment_1_0()); }
)

    |(
{ before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1()); }

	'false' 

{ after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PlusMinus__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); }

	'+' 

{ after(grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); }
)

    |(
{ before(grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1()); }

	'-' 

{ after(grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SignedInt__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); }

	'+' 

{ after(grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); }
)

    |(
{ before(grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1()); }

	'-' 

{ after(grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SignedReal__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); }

	'+' 

{ after(grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); }
)

    |(
{ before(grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1()); }

	'-' 

{ after(grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NumAlt__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0()); }
	ruleRealTerm
{ after(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1()); }
	ruleIntegerTerm
{ after(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2()); }
	ruleSignedConstant
{ after(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3()); }
	ruleConstantValue
{ after(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__SystemInstance__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemInstance__Group__0__Impl
	rule__SystemInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getCategoryAssignment_0()); }
(rule__SystemInstance__CategoryAssignment_0)
{ after(grammarAccess.getSystemInstanceAccess().getCategoryAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemInstance__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemInstance__Group__1__Impl
	rule__SystemInstance__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getNameAssignment_1()); }
(rule__SystemInstance__NameAssignment_1)
{ after(grammarAccess.getSystemInstanceAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemInstance__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemInstance__Group__2__Impl
	rule__SystemInstance__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getColonKeyword_2()); }

	':' 

{ after(grammarAccess.getSystemInstanceAccess().getColonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemInstance__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemInstance__Group__3__Impl
	rule__SystemInstance__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getComponentImplementationAssignment_3()); }
(rule__SystemInstance__ComponentImplementationAssignment_3)
{ after(grammarAccess.getSystemInstanceAccess().getComponentImplementationAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemInstance__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemInstance__Group__4__Impl
	rule__SystemInstance__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getLeftCurlyBracketKeyword_4()); }

	'{' 

{ after(grammarAccess.getSystemInstanceAccess().getLeftCurlyBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemInstance__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemInstance__Group__5__Impl
	rule__SystemInstance__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getAlternatives_5()); }
(rule__SystemInstance__Alternatives_5)*
{ after(grammarAccess.getSystemInstanceAccess().getAlternatives_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemInstance__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemInstance__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6()); }

	'}' 

{ after(grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__FeatureInstance__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureInstance__Group__0__Impl
	rule__FeatureInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getDirectionAssignment_0()); }
(rule__FeatureInstance__DirectionAssignment_0)
{ after(grammarAccess.getFeatureInstanceAccess().getDirectionAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureInstance__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureInstance__Group__1__Impl
	rule__FeatureInstance__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getCategoryAssignment_1()); }
(rule__FeatureInstance__CategoryAssignment_1)
{ after(grammarAccess.getFeatureInstanceAccess().getCategoryAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureInstance__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureInstance__Group__2__Impl
	rule__FeatureInstance__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getNameAssignment_2()); }
(rule__FeatureInstance__NameAssignment_2)
{ after(grammarAccess.getFeatureInstanceAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureInstance__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureInstance__Group__3__Impl
	rule__FeatureInstance__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getGroup_3()); }
(rule__FeatureInstance__Group_3__0)?
{ after(grammarAccess.getFeatureInstanceAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureInstance__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureInstance__Group__4__Impl
	rule__FeatureInstance__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getColonKeyword_4()); }

	':' 

{ after(grammarAccess.getFeatureInstanceAccess().getColonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureInstance__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureInstance__Group__5__Impl
	rule__FeatureInstance__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getFeatureAssignment_5()); }
(rule__FeatureInstance__FeatureAssignment_5)
{ after(grammarAccess.getFeatureInstanceAccess().getFeatureAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureInstance__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureInstance__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getGroup_6()); }
(rule__FeatureInstance__Group_6__0)?
{ after(grammarAccess.getFeatureInstanceAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__FeatureInstance__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureInstance__Group_3__0__Impl
	rule__FeatureInstance__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0()); }

	'[' 

{ after(grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureInstance__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureInstance__Group_3__1__Impl
	rule__FeatureInstance__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getIndexAssignment_3_1()); }
(rule__FeatureInstance__IndexAssignment_3_1)
{ after(grammarAccess.getFeatureInstanceAccess().getIndexAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureInstance__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureInstance__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2()); }

	']' 

{ after(grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__FeatureInstance__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureInstance__Group_6__0__Impl
	rule__FeatureInstance__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getLeftCurlyBracketKeyword_6_0()); }

	'{' 

{ after(grammarAccess.getFeatureInstanceAccess().getLeftCurlyBracketKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureInstance__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureInstance__Group_6__1__Impl
	rule__FeatureInstance__Group_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getAlternatives_6_1()); }
(rule__FeatureInstance__Alternatives_6_1)*
{ after(grammarAccess.getFeatureInstanceAccess().getAlternatives_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureInstance__Group_6__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureInstance__Group_6__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__Group_6__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getRightCurlyBracketKeyword_6_2()); }

	'}' 

{ after(grammarAccess.getFeatureInstanceAccess().getRightCurlyBracketKeyword_6_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ComponentInstance__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group__0__Impl
	rule__ComponentInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getCategoryAssignment_0()); }
(rule__ComponentInstance__CategoryAssignment_0)
{ after(grammarAccess.getComponentInstanceAccess().getCategoryAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group__1__Impl
	rule__ComponentInstance__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getClassifierAssignment_1()); }
(rule__ComponentInstance__ClassifierAssignment_1)?
{ after(grammarAccess.getComponentInstanceAccess().getClassifierAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group__2__Impl
	rule__ComponentInstance__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getNameAssignment_2()); }
(rule__ComponentInstance__NameAssignment_2)
{ after(grammarAccess.getComponentInstanceAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group__3__Impl
	rule__ComponentInstance__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getGroup_3()); }
(rule__ComponentInstance__Group_3__0)*
{ after(grammarAccess.getComponentInstanceAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group__4__Impl
	rule__ComponentInstance__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getGroup_4()); }
(rule__ComponentInstance__Group_4__0)?
{ after(grammarAccess.getComponentInstanceAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group__5__Impl
	rule__ComponentInstance__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getColonKeyword_5()); }

	':' 

{ after(grammarAccess.getComponentInstanceAccess().getColonKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group__6__Impl
	rule__ComponentInstance__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getSubcomponentAssignment_6()); }
(rule__ComponentInstance__SubcomponentAssignment_6)
{ after(grammarAccess.getComponentInstanceAccess().getSubcomponentAssignment_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getGroup_7()); }
(rule__ComponentInstance__Group_7__0)?
{ after(grammarAccess.getComponentInstanceAccess().getGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__ComponentInstance__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group_3__0__Impl
	rule__ComponentInstance__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_3_0()); }

	'[' 

{ after(grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group_3__1__Impl
	rule__ComponentInstance__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getIndexAssignment_3_1()); }
(rule__ComponentInstance__IndexAssignment_3_1)
{ after(grammarAccess.getComponentInstanceAccess().getIndexAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_3_2()); }

	']' 

{ after(grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ComponentInstance__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group_4__0__Impl
	rule__ComponentInstance__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getInKeyword_4_0()); }

	'in' 

{ after(grammarAccess.getComponentInstanceAccess().getInKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group_4__1__Impl
	rule__ComponentInstance__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getModesKeyword_4_1()); }

	'modes' 

{ after(grammarAccess.getComponentInstanceAccess().getModesKeyword_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group_4__2__Impl
	rule__ComponentInstance__Group_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_4_2()); }

	'(' 

{ after(grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group_4__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group_4__3__Impl
	rule__ComponentInstance__Group_4__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group_4__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getInModeAssignment_4_3()); }
(rule__ComponentInstance__InModeAssignment_4_3)
{ after(grammarAccess.getComponentInstanceAccess().getInModeAssignment_4_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group_4__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group_4__4__Impl
	rule__ComponentInstance__Group_4__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group_4__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getGroup_4_4()); }
(rule__ComponentInstance__Group_4_4__0)*
{ after(grammarAccess.getComponentInstanceAccess().getGroup_4_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group_4__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group_4__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group_4__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_4_5()); }

	')' 

{ after(grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_4_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__ComponentInstance__Group_4_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group_4_4__0__Impl
	rule__ComponentInstance__Group_4_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group_4_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getCommaKeyword_4_4_0()); }

	',' 

{ after(grammarAccess.getComponentInstanceAccess().getCommaKeyword_4_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group_4_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group_4_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group_4_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getInModeAssignment_4_4_1()); }
(rule__ComponentInstance__InModeAssignment_4_4_1)
{ after(grammarAccess.getComponentInstanceAccess().getInModeAssignment_4_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ComponentInstance__Group_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group_7__0__Impl
	rule__ComponentInstance__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_7_0()); }

	'{' 

{ after(grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group_7__1__Impl
	rule__ComponentInstance__Group_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getAlternatives_7_1()); }
(rule__ComponentInstance__Alternatives_7_1)*
{ after(grammarAccess.getComponentInstanceAccess().getAlternatives_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentInstance__Group_7__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentInstance__Group_7__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__Group_7__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_7_2()); }

	'}' 

{ after(grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_7_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ConnectionInstance__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group__0__Impl
	rule__ConnectionInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getCompleteAssignment_0()); }
(rule__ConnectionInstance__CompleteAssignment_0)?
{ after(grammarAccess.getConnectionInstanceAccess().getCompleteAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group__1__Impl
	rule__ConnectionInstance__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getKindAssignment_1()); }
(rule__ConnectionInstance__KindAssignment_1)
{ after(grammarAccess.getConnectionInstanceAccess().getKindAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group__2__Impl
	rule__ConnectionInstance__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getNameAssignment_2()); }
(rule__ConnectionInstance__NameAssignment_2)
{ after(grammarAccess.getConnectionInstanceAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group__3__Impl
	rule__ConnectionInstance__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getColonKeyword_3()); }

	':' 

{ after(grammarAccess.getConnectionInstanceAccess().getColonKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group__4__Impl
	rule__ConnectionInstance__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getSourceAssignment_4()); }
(rule__ConnectionInstance__SourceAssignment_4)
{ after(grammarAccess.getConnectionInstanceAccess().getSourceAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group__5__Impl
	rule__ConnectionInstance__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getAlternatives_5()); }
(rule__ConnectionInstance__Alternatives_5)
{ after(grammarAccess.getConnectionInstanceAccess().getAlternatives_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group__6__Impl
	rule__ConnectionInstance__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getDestinationAssignment_6()); }
(rule__ConnectionInstance__DestinationAssignment_6)
{ after(grammarAccess.getConnectionInstanceAccess().getDestinationAssignment_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group__7__Impl
	rule__ConnectionInstance__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getGroup_7()); }
(rule__ConnectionInstance__Group_7__0)?
{ after(grammarAccess.getConnectionInstanceAccess().getGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group__8__Impl
	rule__ConnectionInstance__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getGroup_8()); }
(rule__ConnectionInstance__Group_8__0)?
{ after(grammarAccess.getConnectionInstanceAccess().getGroup_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group__9__Impl
	rule__ConnectionInstance__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getLeftCurlyBracketKeyword_9()); }

	'{' 

{ after(grammarAccess.getConnectionInstanceAccess().getLeftCurlyBracketKeyword_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group__10__Impl
	rule__ConnectionInstance__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getConnectionInstanceAccess().getAlternatives_10()); }
(rule__ConnectionInstance__Alternatives_10)
{ after(grammarAccess.getConnectionInstanceAccess().getAlternatives_10()); }
)
(
{ before(grammarAccess.getConnectionInstanceAccess().getAlternatives_10()); }
(rule__ConnectionInstance__Alternatives_10)*
{ after(grammarAccess.getConnectionInstanceAccess().getAlternatives_10()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group__11
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group__11__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group__11__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getRightCurlyBracketKeyword_11()); }

	'}' 

{ after(grammarAccess.getConnectionInstanceAccess().getRightCurlyBracketKeyword_11()); }
)

;
finally {
	restoreStackSize(stackSize);
}


























rule__ConnectionInstance__Group_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_7__0__Impl
	rule__ConnectionInstance__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getInKeyword_7_0()); }

	'in' 

{ after(grammarAccess.getConnectionInstanceAccess().getInKeyword_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_7__1__Impl
	rule__ConnectionInstance__Group_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getModesKeyword_7_1()); }

	'modes' 

{ after(grammarAccess.getConnectionInstanceAccess().getModesKeyword_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group_7__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_7__2__Impl
	rule__ConnectionInstance__Group_7__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_7__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getLeftParenthesisKeyword_7_2()); }

	'(' 

{ after(grammarAccess.getConnectionInstanceAccess().getLeftParenthesisKeyword_7_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group_7__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_7__3__Impl
	rule__ConnectionInstance__Group_7__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_7__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeAssignment_7_3()); }
(rule__ConnectionInstance__InSystemOperationModeAssignment_7_3)
{ after(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeAssignment_7_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group_7__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_7__4__Impl
	rule__ConnectionInstance__Group_7__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_7__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getGroup_7_4()); }
(rule__ConnectionInstance__Group_7_4__0)*
{ after(grammarAccess.getConnectionInstanceAccess().getGroup_7_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group_7__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_7__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_7__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getRightParenthesisKeyword_7_5()); }

	')' 

{ after(grammarAccess.getConnectionInstanceAccess().getRightParenthesisKeyword_7_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__ConnectionInstance__Group_7_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_7_4__0__Impl
	rule__ConnectionInstance__Group_7_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_7_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getCommaKeyword_7_4_0()); }

	',' 

{ after(grammarAccess.getConnectionInstanceAccess().getCommaKeyword_7_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group_7_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_7_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_7_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeAssignment_7_4_1()); }
(rule__ConnectionInstance__InSystemOperationModeAssignment_7_4_1)
{ after(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeAssignment_7_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ConnectionInstance__Group_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_8__0__Impl
	rule__ConnectionInstance__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getInKeyword_8_0()); }

	'in' 

{ after(grammarAccess.getConnectionInstanceAccess().getInKeyword_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_8__1__Impl
	rule__ConnectionInstance__Group_8__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getTransitionsKeyword_8_1()); }

	'transitions' 

{ after(grammarAccess.getConnectionInstanceAccess().getTransitionsKeyword_8_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group_8__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_8__2__Impl
	rule__ConnectionInstance__Group_8__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_8__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getLeftParenthesisKeyword_8_2()); }

	'(' 

{ after(grammarAccess.getConnectionInstanceAccess().getLeftParenthesisKeyword_8_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group_8__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_8__3__Impl
	rule__ConnectionInstance__Group_8__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_8__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getInModeTransitionAssignment_8_3()); }
(rule__ConnectionInstance__InModeTransitionAssignment_8_3)
{ after(grammarAccess.getConnectionInstanceAccess().getInModeTransitionAssignment_8_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group_8__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_8__4__Impl
	rule__ConnectionInstance__Group_8__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_8__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getGroup_8_4()); }
(rule__ConnectionInstance__Group_8_4__0)*
{ after(grammarAccess.getConnectionInstanceAccess().getGroup_8_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group_8__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_8__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_8__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getRightParenthesisKeyword_8_5()); }

	')' 

{ after(grammarAccess.getConnectionInstanceAccess().getRightParenthesisKeyword_8_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__ConnectionInstance__Group_8_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_8_4__0__Impl
	rule__ConnectionInstance__Group_8_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_8_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getCommaKeyword_8_4_0()); }

	',' 

{ after(grammarAccess.getConnectionInstanceAccess().getCommaKeyword_8_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionInstance__Group_8_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionInstance__Group_8_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__Group_8_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getInModeTransitionAssignment_8_4_1()); }
(rule__ConnectionInstance__InModeTransitionAssignment_8_4_1)
{ after(grammarAccess.getConnectionInstanceAccess().getInModeTransitionAssignment_8_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ConnectionReference__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionReference__Group__0__Impl
	rule__ConnectionReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionReference__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionReferenceAccess().getSourceAssignment_0()); }
(rule__ConnectionReference__SourceAssignment_0)
{ after(grammarAccess.getConnectionReferenceAccess().getSourceAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionReference__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionReference__Group__1__Impl
	rule__ConnectionReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionReference__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionReferenceAccess().getHyphenMinusGreaterThanSignKeyword_1()); }

	'->' 

{ after(grammarAccess.getConnectionReferenceAccess().getHyphenMinusGreaterThanSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionReference__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionReference__Group__2__Impl
	rule__ConnectionReference__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionReference__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionReferenceAccess().getDestinationAssignment_2()); }
(rule__ConnectionReference__DestinationAssignment_2)
{ after(grammarAccess.getConnectionReferenceAccess().getDestinationAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionReference__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionReference__Group__3__Impl
	rule__ConnectionReference__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionReference__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionReferenceAccess().getColonKeyword_3()); }

	':' 

{ after(grammarAccess.getConnectionReferenceAccess().getColonKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionReference__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionReference__Group__4__Impl
	rule__ConnectionReference__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionReference__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionReferenceAccess().getReverseAssignment_4()); }
(rule__ConnectionReference__ReverseAssignment_4)?
{ after(grammarAccess.getConnectionReferenceAccess().getReverseAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionReference__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionReference__Group__5__Impl
	rule__ConnectionReference__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionReference__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionReferenceAccess().getConnectionAssignment_5()); }
(rule__ConnectionReference__ConnectionAssignment_5)
{ after(grammarAccess.getConnectionReferenceAccess().getConnectionAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionReference__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionReference__Group__6__Impl
	rule__ConnectionReference__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionReference__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionReferenceAccess().getInKeyword_6()); }

	'in' 

{ after(grammarAccess.getConnectionReferenceAccess().getInKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionReference__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionReference__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionReference__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionReferenceAccess().getContextAssignment_7()); }
(rule__ConnectionReference__ContextAssignment_7)
{ after(grammarAccess.getConnectionReferenceAccess().getContextAssignment_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__FlowSpecificationInstance__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group__0__Impl
	rule__FlowSpecificationInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getFlowKeyword_0()); }

	'flow' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getFlowKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group__1__Impl
	rule__FlowSpecificationInstance__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getNameAssignment_1()); }
(rule__FlowSpecificationInstance__NameAssignment_1)
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group__2__Impl
	rule__FlowSpecificationInstance__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_2()); }

	'(' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group__3__Impl
	rule__FlowSpecificationInstance__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getSourceAssignment_3()); }
(rule__FlowSpecificationInstance__SourceAssignment_3)?
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getSourceAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group__4__Impl
	rule__FlowSpecificationInstance__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4()); }

	'->' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group__5__Impl
	rule__FlowSpecificationInstance__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationAssignment_5()); }
(rule__FlowSpecificationInstance__DestinationAssignment_5)?
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group__6__Impl
	rule__FlowSpecificationInstance__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_6()); }

	')' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group__7__Impl
	rule__FlowSpecificationInstance__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getGroup_7()); }
(rule__FlowSpecificationInstance__Group_7__0)?
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group__8__Impl
	rule__FlowSpecificationInstance__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getGroup_8()); }
(rule__FlowSpecificationInstance__Group_8__0)?
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getGroup_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group__9__Impl
	rule__FlowSpecificationInstance__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getColonKeyword_9()); }

	':' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getColonKeyword_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group__10__Impl
	rule__FlowSpecificationInstance__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationAssignment_10()); }
(rule__FlowSpecificationInstance__FlowSpecificationAssignment_10)
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationAssignment_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group__11
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group__11__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group__11__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getGroup_11()); }
(rule__FlowSpecificationInstance__Group_11__0)?
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getGroup_11()); }
)

;
finally {
	restoreStackSize(stackSize);
}


























rule__FlowSpecificationInstance__Group_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_7__0__Impl
	rule__FlowSpecificationInstance__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getInKeyword_7_0()); }

	'in' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getInKeyword_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_7__1__Impl
	rule__FlowSpecificationInstance__Group_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getModesKeyword_7_1()); }

	'modes' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getModesKeyword_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group_7__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_7__2__Impl
	rule__FlowSpecificationInstance__Group_7__3
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_7__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_7_2()); }

	'(' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_7_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group_7__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_7__3__Impl
	rule__FlowSpecificationInstance__Group_7__4
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_7__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getInModeAssignment_7_3()); }
(rule__FlowSpecificationInstance__InModeAssignment_7_3)
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getInModeAssignment_7_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group_7__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_7__4__Impl
	rule__FlowSpecificationInstance__Group_7__5
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_7__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getGroup_7_4()); }
(rule__FlowSpecificationInstance__Group_7_4__0)*
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getGroup_7_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group_7__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_7__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_7__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_7_5()); }

	')' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_7_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__FlowSpecificationInstance__Group_7_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_7_4__0__Impl
	rule__FlowSpecificationInstance__Group_7_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_7_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getCommaKeyword_7_4_0()); }

	',' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getCommaKeyword_7_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group_7_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_7_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_7_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getInModeAssignment_7_4_1()); }
(rule__FlowSpecificationInstance__InModeAssignment_7_4_1)
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getInModeAssignment_7_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__FlowSpecificationInstance__Group_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_8__0__Impl
	rule__FlowSpecificationInstance__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getInKeyword_8_0()); }

	'in' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getInKeyword_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_8__1__Impl
	rule__FlowSpecificationInstance__Group_8__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getTransitionsKeyword_8_1()); }

	'transitions' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getTransitionsKeyword_8_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group_8__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_8__2__Impl
	rule__FlowSpecificationInstance__Group_8__3
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_8__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_8_2()); }

	'(' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_8_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group_8__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_8__3__Impl
	rule__FlowSpecificationInstance__Group_8__4
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_8__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionAssignment_8_3()); }
(rule__FlowSpecificationInstance__InModeTransitionAssignment_8_3)
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionAssignment_8_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group_8__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_8__4__Impl
	rule__FlowSpecificationInstance__Group_8__5
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_8__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getGroup_8_4()); }
(rule__FlowSpecificationInstance__Group_8_4__0)*
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getGroup_8_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group_8__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_8__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_8__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_8_5()); }

	')' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_8_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__FlowSpecificationInstance__Group_8_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_8_4__0__Impl
	rule__FlowSpecificationInstance__Group_8_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_8_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getCommaKeyword_8_4_0()); }

	',' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getCommaKeyword_8_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group_8_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_8_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_8_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionAssignment_8_4_1()); }
(rule__FlowSpecificationInstance__InModeTransitionAssignment_8_4_1)
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionAssignment_8_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__FlowSpecificationInstance__Group_11__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_11__0__Impl
	rule__FlowSpecificationInstance__Group_11__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_11__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getLeftCurlyBracketKeyword_11_0()); }

	'{' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getLeftCurlyBracketKeyword_11_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group_11__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_11__1__Impl
	rule__FlowSpecificationInstance__Group_11__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_11__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getOwnedPropertyAssociationAssignment_11_1()); }
(rule__FlowSpecificationInstance__OwnedPropertyAssociationAssignment_11_1)
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getOwnedPropertyAssociationAssignment_11_1()); }
)
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getOwnedPropertyAssociationAssignment_11_1()); }
(rule__FlowSpecificationInstance__OwnedPropertyAssociationAssignment_11_1)*
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getOwnedPropertyAssociationAssignment_11_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FlowSpecificationInstance__Group_11__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FlowSpecificationInstance__Group_11__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__Group_11__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getRightCurlyBracketKeyword_11_2()); }

	'}' 

{ after(grammarAccess.getFlowSpecificationInstanceAccess().getRightCurlyBracketKeyword_11_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__EndToEndFlowInstance__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group__0__Impl
	rule__EndToEndFlowInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_0()); }

	'end' 

{ after(grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group__1__Impl
	rule__EndToEndFlowInstance__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getToKeyword_1()); }

	'to' 

{ after(grammarAccess.getEndToEndFlowInstanceAccess().getToKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group__2__Impl
	rule__EndToEndFlowInstance__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_2()); }

	'end' 

{ after(grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group__3__Impl
	rule__EndToEndFlowInstance__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowKeyword_3()); }

	'flow' 

{ after(grammarAccess.getEndToEndFlowInstanceAccess().getFlowKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group__4__Impl
	rule__EndToEndFlowInstance__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getNameAssignment_4()); }
(rule__EndToEndFlowInstance__NameAssignment_4)
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getNameAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group__5__Impl
	rule__EndToEndFlowInstance__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_5()); }
(rule__EndToEndFlowInstance__Group_5__0)?
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group__6__Impl
	rule__EndToEndFlowInstance__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_6()); }
(rule__EndToEndFlowInstance__Group_6__0)?
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group__7__Impl
	rule__EndToEndFlowInstance__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getColonKeyword_7()); }

	':' 

{ after(grammarAccess.getEndToEndFlowInstanceAccess().getColonKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group__8__Impl
	rule__EndToEndFlowInstance__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowAssignment_8()); }
(rule__EndToEndFlowInstance__EndToEndFlowAssignment_8)
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowAssignment_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_9()); }
(rule__EndToEndFlowInstance__Group_9__0)?
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}






















rule__EndToEndFlowInstance__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group_5__0__Impl
	rule__EndToEndFlowInstance__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementAssignment_5_0()); }
(rule__EndToEndFlowInstance__FlowElementAssignment_5_0)
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementAssignment_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_5_1()); }
(rule__EndToEndFlowInstance__Group_5_1__0)*
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EndToEndFlowInstance__Group_5_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group_5_1__0__Impl
	rule__EndToEndFlowInstance__Group_5_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group_5_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1_0()); }

	'->' 

{ after(grammarAccess.getEndToEndFlowInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group_5_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group_5_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group_5_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementAssignment_5_1_1()); }
(rule__EndToEndFlowInstance__FlowElementAssignment_5_1_1)
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementAssignment_5_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EndToEndFlowInstance__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group_6__0__Impl
	rule__EndToEndFlowInstance__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_6_0()); }

	'in' 

{ after(grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group_6__1__Impl
	rule__EndToEndFlowInstance__Group_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getModesKeyword_6_1()); }

	'modes' 

{ after(grammarAccess.getEndToEndFlowInstanceAccess().getModesKeyword_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group_6__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group_6__2__Impl
	rule__EndToEndFlowInstance__Group_6__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group_6__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getLeftParenthesisKeyword_6_2()); }

	'(' 

{ after(grammarAccess.getEndToEndFlowInstanceAccess().getLeftParenthesisKeyword_6_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group_6__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group_6__3__Impl
	rule__EndToEndFlowInstance__Group_6__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group_6__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeAssignment_6_3()); }
(rule__EndToEndFlowInstance__InSystemOperationModeAssignment_6_3)
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeAssignment_6_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group_6__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group_6__4__Impl
	rule__EndToEndFlowInstance__Group_6__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group_6__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_6_4()); }
(rule__EndToEndFlowInstance__Group_6_4__0)*
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_6_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group_6__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group_6__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group_6__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getRightParenthesisKeyword_6_5()); }

	')' 

{ after(grammarAccess.getEndToEndFlowInstanceAccess().getRightParenthesisKeyword_6_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__EndToEndFlowInstance__Group_6_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group_6_4__0__Impl
	rule__EndToEndFlowInstance__Group_6_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group_6_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getCommaKeyword_6_4_0()); }

	',' 

{ after(grammarAccess.getEndToEndFlowInstanceAccess().getCommaKeyword_6_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group_6_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group_6_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group_6_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeAssignment_6_4_1()); }
(rule__EndToEndFlowInstance__InSystemOperationModeAssignment_6_4_1)
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeAssignment_6_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EndToEndFlowInstance__Group_9__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group_9__0__Impl
	rule__EndToEndFlowInstance__Group_9__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group_9__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getLeftCurlyBracketKeyword_9_0()); }

	'{' 

{ after(grammarAccess.getEndToEndFlowInstanceAccess().getLeftCurlyBracketKeyword_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group_9__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group_9__1__Impl
	rule__EndToEndFlowInstance__Group_9__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group_9__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getOwnedPropertyAssociationAssignment_9_1()); }
(rule__EndToEndFlowInstance__OwnedPropertyAssociationAssignment_9_1)
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getOwnedPropertyAssociationAssignment_9_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndToEndFlowInstance__Group_9__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndToEndFlowInstance__Group_9__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__Group_9__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getRightCurlyBracketKeyword_9_2()); }

	'}' 

{ after(grammarAccess.getEndToEndFlowInstanceAccess().getRightCurlyBracketKeyword_9_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ModeInstance__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group__0__Impl
	rule__ModeInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getInitialAssignment_0()); }
(rule__ModeInstance__InitialAssignment_0)?
{ after(grammarAccess.getModeInstanceAccess().getInitialAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeInstance__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group__1__Impl
	rule__ModeInstance__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getDerivedAssignment_1()); }
(rule__ModeInstance__DerivedAssignment_1)?
{ after(grammarAccess.getModeInstanceAccess().getDerivedAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeInstance__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group__2__Impl
	rule__ModeInstance__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getModeKeyword_2()); }

	'mode' 

{ after(grammarAccess.getModeInstanceAccess().getModeKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeInstance__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group__3__Impl
	rule__ModeInstance__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getNameAssignment_3()); }
(rule__ModeInstance__NameAssignment_3)
{ after(grammarAccess.getModeInstanceAccess().getNameAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeInstance__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group__4__Impl
	rule__ModeInstance__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getGroup_4()); }
(rule__ModeInstance__Group_4__0)?
{ after(grammarAccess.getModeInstanceAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeInstance__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group__5__Impl
	rule__ModeInstance__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getColonKeyword_5()); }

	':' 

{ after(grammarAccess.getModeInstanceAccess().getColonKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeInstance__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group__6__Impl
	rule__ModeInstance__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getModeAssignment_6()); }
(rule__ModeInstance__ModeAssignment_6)
{ after(grammarAccess.getModeInstanceAccess().getModeAssignment_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeInstance__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getGroup_7()); }
(rule__ModeInstance__Group_7__0)?
{ after(grammarAccess.getModeInstanceAccess().getGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__ModeInstance__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group_4__0__Impl
	rule__ModeInstance__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getEqualsSignKeyword_4_0()); }

	'=' 

{ after(grammarAccess.getModeInstanceAccess().getEqualsSignKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeInstance__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getAlternatives_4_1()); }
(rule__ModeInstance__Alternatives_4_1)
{ after(grammarAccess.getModeInstanceAccess().getAlternatives_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ModeInstance__Group_4_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group_4_1_1__0__Impl
	rule__ModeInstance__Group_4_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group_4_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getLeftParenthesisKeyword_4_1_1_0()); }

	'(' 

{ after(grammarAccess.getModeInstanceAccess().getLeftParenthesisKeyword_4_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeInstance__Group_4_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group_4_1_1__1__Impl
	rule__ModeInstance__Group_4_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group_4_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getParentAssignment_4_1_1_1()); }
(rule__ModeInstance__ParentAssignment_4_1_1_1)
{ after(grammarAccess.getModeInstanceAccess().getParentAssignment_4_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeInstance__Group_4_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group_4_1_1__2__Impl
	rule__ModeInstance__Group_4_1_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group_4_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getModeInstanceAccess().getGroup_4_1_1_2()); }
(rule__ModeInstance__Group_4_1_1_2__0)
{ after(grammarAccess.getModeInstanceAccess().getGroup_4_1_1_2()); }
)
(
{ before(grammarAccess.getModeInstanceAccess().getGroup_4_1_1_2()); }
(rule__ModeInstance__Group_4_1_1_2__0)*
{ after(grammarAccess.getModeInstanceAccess().getGroup_4_1_1_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeInstance__Group_4_1_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group_4_1_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group_4_1_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getRightParenthesisKeyword_4_1_1_3()); }

	')' 

{ after(grammarAccess.getModeInstanceAccess().getRightParenthesisKeyword_4_1_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ModeInstance__Group_4_1_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group_4_1_1_2__0__Impl
	rule__ModeInstance__Group_4_1_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group_4_1_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getCommaKeyword_4_1_1_2_0()); }

	',' 

{ after(grammarAccess.getModeInstanceAccess().getCommaKeyword_4_1_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeInstance__Group_4_1_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group_4_1_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group_4_1_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getParentAssignment_4_1_1_2_1()); }
(rule__ModeInstance__ParentAssignment_4_1_1_2_1)
{ after(grammarAccess.getModeInstanceAccess().getParentAssignment_4_1_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ModeInstance__Group_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group_7__0__Impl
	rule__ModeInstance__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getLeftCurlyBracketKeyword_7_0()); }

	'{' 

{ after(grammarAccess.getModeInstanceAccess().getLeftCurlyBracketKeyword_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeInstance__Group_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group_7__1__Impl
	rule__ModeInstance__Group_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getOwnedPropertyAssociationAssignment_7_1()); }
(rule__ModeInstance__OwnedPropertyAssociationAssignment_7_1)
{ after(grammarAccess.getModeInstanceAccess().getOwnedPropertyAssociationAssignment_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeInstance__Group_7__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeInstance__Group_7__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__Group_7__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getRightCurlyBracketKeyword_7_2()); }

	'}' 

{ after(grammarAccess.getModeInstanceAccess().getRightCurlyBracketKeyword_7_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ModeTransitionInstance__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group__0__Impl
	rule__ModeTransitionInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getModeKeyword_0()); }

	'mode' 

{ after(grammarAccess.getModeTransitionInstanceAccess().getModeKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeTransitionInstance__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group__1__Impl
	rule__ModeTransitionInstance__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getTransitionKeyword_1()); }

	'transition' 

{ after(grammarAccess.getModeTransitionInstanceAccess().getTransitionKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeTransitionInstance__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group__2__Impl
	rule__ModeTransitionInstance__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getNameAssignment_2()); }
(rule__ModeTransitionInstance__NameAssignment_2)
{ after(grammarAccess.getModeTransitionInstanceAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeTransitionInstance__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group__3__Impl
	rule__ModeTransitionInstance__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getSourceAssignment_3()); }
(rule__ModeTransitionInstance__SourceAssignment_3)
{ after(grammarAccess.getModeTransitionInstanceAccess().getSourceAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeTransitionInstance__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group__4__Impl
	rule__ModeTransitionInstance__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getHyphenMinusLeftSquareBracketKeyword_4()); }

	'-[' 

{ after(grammarAccess.getModeTransitionInstanceAccess().getHyphenMinusLeftSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeTransitionInstance__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group__5__Impl
	rule__ModeTransitionInstance__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getGroup_5()); }
(rule__ModeTransitionInstance__Group_5__0)?
{ after(grammarAccess.getModeTransitionInstanceAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeTransitionInstance__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group__6__Impl
	rule__ModeTransitionInstance__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_6()); }

	']->' 

{ after(grammarAccess.getModeTransitionInstanceAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeTransitionInstance__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group__7__Impl
	rule__ModeTransitionInstance__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getDestinationAssignment_7()); }
(rule__ModeTransitionInstance__DestinationAssignment_7)
{ after(grammarAccess.getModeTransitionInstanceAccess().getDestinationAssignment_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeTransitionInstance__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group__8__Impl
	rule__ModeTransitionInstance__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getColonKeyword_8()); }

	':' 

{ after(grammarAccess.getModeTransitionInstanceAccess().getColonKeyword_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeTransitionInstance__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group__9__Impl
	rule__ModeTransitionInstance__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionAssignment_9()); }
(rule__ModeTransitionInstance__ModeTransitionAssignment_9)
{ after(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionAssignment_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeTransitionInstance__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group__10__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getGroup_10()); }
(rule__ModeTransitionInstance__Group_10__0)?
{ after(grammarAccess.getModeTransitionInstanceAccess().getGroup_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}
























rule__ModeTransitionInstance__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group_5__0__Impl
	rule__ModeTransitionInstance__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getTriggerAssignment_5_0()); }
(rule__ModeTransitionInstance__TriggerAssignment_5_0)
{ after(grammarAccess.getModeTransitionInstanceAccess().getTriggerAssignment_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeTransitionInstance__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getGroup_5_1()); }
(rule__ModeTransitionInstance__Group_5_1__0)*
{ after(grammarAccess.getModeTransitionInstanceAccess().getGroup_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ModeTransitionInstance__Group_5_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group_5_1__0__Impl
	rule__ModeTransitionInstance__Group_5_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group_5_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getCommaKeyword_5_1_0()); }

	',' 

{ after(grammarAccess.getModeTransitionInstanceAccess().getCommaKeyword_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeTransitionInstance__Group_5_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group_5_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group_5_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getTriggerAssignment_5_1_1()); }
(rule__ModeTransitionInstance__TriggerAssignment_5_1_1)
{ after(grammarAccess.getModeTransitionInstanceAccess().getTriggerAssignment_5_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ModeTransitionInstance__Group_10__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group_10__0__Impl
	rule__ModeTransitionInstance__Group_10__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group_10__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getLeftCurlyBracketKeyword_10_0()); }

	'{' 

{ after(grammarAccess.getModeTransitionInstanceAccess().getLeftCurlyBracketKeyword_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeTransitionInstance__Group_10__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group_10__1__Impl
	rule__ModeTransitionInstance__Group_10__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group_10__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getOwnedPropertyAssociationAssignment_10_1()); }
(rule__ModeTransitionInstance__OwnedPropertyAssociationAssignment_10_1)
{ after(grammarAccess.getModeTransitionInstanceAccess().getOwnedPropertyAssociationAssignment_10_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeTransitionInstance__Group_10__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeTransitionInstance__Group_10__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__Group_10__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getRightCurlyBracketKeyword_10_2()); }

	'}' 

{ after(grammarAccess.getModeTransitionInstanceAccess().getRightCurlyBracketKeyword_10_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SystemOperationMode__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemOperationMode__Group__0__Impl
	rule__SystemOperationMode__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemOperationMode__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemOperationModeAccess().getSomKeyword_0()); }

	'som' 

{ after(grammarAccess.getSystemOperationModeAccess().getSomKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemOperationMode__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemOperationMode__Group__1__Impl
	rule__SystemOperationMode__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemOperationMode__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemOperationModeAccess().getNameAssignment_1()); }
(rule__SystemOperationMode__NameAssignment_1)
{ after(grammarAccess.getSystemOperationModeAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemOperationMode__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemOperationMode__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemOperationMode__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemOperationModeAccess().getGroup_2()); }
(rule__SystemOperationMode__Group_2__0)?
{ after(grammarAccess.getSystemOperationModeAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SystemOperationMode__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemOperationMode__Group_2__0__Impl
	rule__SystemOperationMode__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemOperationMode__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemOperationModeAccess().getCurrentModeAssignment_2_0()); }
(rule__SystemOperationMode__CurrentModeAssignment_2_0)
{ after(grammarAccess.getSystemOperationModeAccess().getCurrentModeAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemOperationMode__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemOperationMode__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemOperationMode__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemOperationModeAccess().getGroup_2_1()); }
(rule__SystemOperationMode__Group_2_1__0)*
{ after(grammarAccess.getSystemOperationModeAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SystemOperationMode__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemOperationMode__Group_2_1__0__Impl
	rule__SystemOperationMode__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemOperationMode__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemOperationModeAccess().getCommaKeyword_2_1_0()); }

	',' 

{ after(grammarAccess.getSystemOperationModeAccess().getCommaKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SystemOperationMode__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SystemOperationMode__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SystemOperationMode__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemOperationModeAccess().getCurrentModeAssignment_2_1_1()); }
(rule__SystemOperationMode__CurrentModeAssignment_2_1_1)
{ after(grammarAccess.getSystemOperationModeAccess().getCurrentModeAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PropertyAssociationInstance__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationInstance__Group__0__Impl
	rule__PropertyAssociationInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationInstance__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyAssignment_0()); }
(rule__PropertyAssociationInstance__PropertyAssignment_0)
{ after(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationInstance__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationInstance__Group__1__Impl
	rule__PropertyAssociationInstance__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationInstance__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationInstanceAccess().getEqualsSignGreaterThanSignKeyword_1()); }

	'=>' 

{ after(grammarAccess.getPropertyAssociationInstanceAccess().getEqualsSignGreaterThanSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationInstance__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationInstance__Group__2__Impl
	rule__PropertyAssociationInstance__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationInstance__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueAssignment_2()); }
(rule__PropertyAssociationInstance__OwnedValueAssignment_2)
{ after(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationInstance__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationInstance__Group__3__Impl
	rule__PropertyAssociationInstance__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationInstance__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationInstanceAccess().getGroup_3()); }
(rule__PropertyAssociationInstance__Group_3__0)*
{ after(grammarAccess.getPropertyAssociationInstanceAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationInstance__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationInstance__Group__4__Impl
	rule__PropertyAssociationInstance__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationInstance__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationInstanceAccess().getColonKeyword_4()); }

	':' 

{ after(grammarAccess.getPropertyAssociationInstanceAccess().getColonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationInstance__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationInstance__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationInstance__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyAssociationAssignment_5()); }
(rule__PropertyAssociationInstance__PropertyAssociationAssignment_5)
{ after(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyAssociationAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__PropertyAssociationInstance__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationInstance__Group_3__0__Impl
	rule__PropertyAssociationInstance__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationInstance__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationInstanceAccess().getCommaKeyword_3_0()); }

	',' 

{ after(grammarAccess.getPropertyAssociationInstanceAccess().getCommaKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationInstance__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationInstance__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationInstance__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueAssignment_3_1()); }
(rule__PropertyAssociationInstance__OwnedValueAssignment_3_1)
{ after(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OptionalModalPropertyValue__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OptionalModalPropertyValue__Group__0__Impl
	rule__OptionalModalPropertyValue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValueAssignment_0()); }
(rule__OptionalModalPropertyValue__OwnedValueAssignment_0)
{ after(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValueAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OptionalModalPropertyValue__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OptionalModalPropertyValue__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1()); }
(rule__OptionalModalPropertyValue__Group_1__0)?
{ after(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OptionalModalPropertyValue__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OptionalModalPropertyValue__Group_1__0__Impl
	rule__OptionalModalPropertyValue__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInKeyword_1_0()); }

	'in' 

{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OptionalModalPropertyValue__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OptionalModalPropertyValue__Group_1__1__Impl
	rule__OptionalModalPropertyValue__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getModesKeyword_1_1()); }

	'modes' 

{ after(grammarAccess.getOptionalModalPropertyValueAccess().getModesKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OptionalModalPropertyValue__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OptionalModalPropertyValue__Group_1__2__Impl
	rule__OptionalModalPropertyValue__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_2()); }

	'(' 

{ after(grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OptionalModalPropertyValue__Group_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OptionalModalPropertyValue__Group_1__3__Impl
	rule__OptionalModalPropertyValue__Group_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_3()); }
(rule__OptionalModalPropertyValue__InModeAssignment_1_3)
{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OptionalModalPropertyValue__Group_1__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OptionalModalPropertyValue__Group_1__4__Impl
	rule__OptionalModalPropertyValue__Group_1__5
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1_4()); }
(rule__OptionalModalPropertyValue__Group_1_4__0)*
{ after(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OptionalModalPropertyValue__Group_1__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OptionalModalPropertyValue__Group_1__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_5()); }

	')' 

{ after(grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__OptionalModalPropertyValue__Group_1_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OptionalModalPropertyValue__Group_1_4__0__Impl
	rule__OptionalModalPropertyValue__Group_1_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_4_0()); }

	',' 

{ after(grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OptionalModalPropertyValue__Group_1_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OptionalModalPropertyValue__Group_1_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_4_1()); }
(rule__OptionalModalPropertyValue__InModeAssignment_1_4_1)
{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ContainmentPathElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainmentPathElement__Group__0__Impl
	rule__ContainmentPathElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathElementAccess().getNamedElementAssignment_0()); }
(rule__ContainmentPathElement__NamedElementAssignment_0)
{ after(grammarAccess.getContainmentPathElementAccess().getNamedElementAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainmentPathElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainmentPathElement__Group__1__Impl
	rule__ContainmentPathElement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathElementAccess().getArrayRangeAssignment_1()); }
(rule__ContainmentPathElement__ArrayRangeAssignment_1)?
{ after(grammarAccess.getContainmentPathElementAccess().getArrayRangeAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainmentPathElement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainmentPathElement__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathElementAccess().getGroup_2()); }
(rule__ContainmentPathElement__Group_2__0)?
{ after(grammarAccess.getContainmentPathElementAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ContainmentPathElement__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainmentPathElement__Group_2__0__Impl
	rule__ContainmentPathElement__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathElementAccess().getSolidusKeyword_2_0()); }

	'/' 

{ after(grammarAccess.getContainmentPathElementAccess().getSolidusKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainmentPathElement__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainmentPathElement__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathElementAccess().getPathAssignment_2_1()); }
(rule__ContainmentPathElement__PathAssignment_2_1)
{ after(grammarAccess.getContainmentPathElementAccess().getPathAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__InstanceReferenceValue__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceReferenceValue__Group__0__Impl
	rule__InstanceReferenceValue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceReferenceValue__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceReferenceValueAccess().getReferenceKeyword_0()); }

	'reference' 

{ after(grammarAccess.getInstanceReferenceValueAccess().getReferenceKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InstanceReferenceValue__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceReferenceValue__Group__1__Impl
	rule__InstanceReferenceValue__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceReferenceValue__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceReferenceValueAccess().getLeftParenthesisKeyword_1()); }

	'(' 

{ after(grammarAccess.getInstanceReferenceValueAccess().getLeftParenthesisKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InstanceReferenceValue__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceReferenceValue__Group__2__Impl
	rule__InstanceReferenceValue__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceReferenceValue__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceReferenceValueAccess().getReferencedInstanceObjectAssignment_2()); }
(rule__InstanceReferenceValue__ReferencedInstanceObjectAssignment_2)
{ after(grammarAccess.getInstanceReferenceValueAccess().getReferencedInstanceObjectAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InstanceReferenceValue__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceReferenceValue__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceReferenceValue__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceReferenceValueAccess().getRightParenthesisKeyword_3()); }

	')' 

{ after(grammarAccess.getInstanceReferenceValueAccess().getRightParenthesisKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__DirectionType__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DirectionType__Group_2__0__Impl
	rule__DirectionType__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionType__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); }

	'in' 

{ after(grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DirectionType__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DirectionType__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionType__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionTypeAccess().getOutKeyword_2_1()); }

	'out' 

{ after(grammarAccess.getDirectionTypeAccess().getOutKeyword_2_1()); }
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

	'subprogram' 

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

	'group' 

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

	'thread' 

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

	'group' 

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

	'virtual' 

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

	'bus' 

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

	'virtual' 

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

	'processor' 

{ after(grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ClassifierRef__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ClassifierRef__Group__0__Impl
	rule__ClassifierRef__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ClassifierRef__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getClassifierRefAccess().getGroup_0()); }
(rule__ClassifierRef__Group_0__0)
{ after(grammarAccess.getClassifierRefAccess().getGroup_0()); }
)
(
{ before(grammarAccess.getClassifierRefAccess().getGroup_0()); }
(rule__ClassifierRef__Group_0__0)*
{ after(grammarAccess.getClassifierRefAccess().getGroup_0()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ClassifierRef__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ClassifierRef__Group__1__Impl
	rule__ClassifierRef__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ClassifierRef__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_1()); }
	RULE_ID
{ after(grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ClassifierRef__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ClassifierRef__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ClassifierRef__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getClassifierRefAccess().getGroup_2()); }
(rule__ClassifierRef__Group_2__0)?
{ after(grammarAccess.getClassifierRefAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ClassifierRef__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ClassifierRef__Group_0__0__Impl
	rule__ClassifierRef__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ClassifierRef__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_0_0()); }
	RULE_ID
{ after(grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ClassifierRef__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ClassifierRef__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ClassifierRef__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getClassifierRefAccess().getColonColonKeyword_0_1()); }

	'::' 

{ after(grammarAccess.getClassifierRefAccess().getColonColonKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ClassifierRef__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ClassifierRef__Group_2__0__Impl
	rule__ClassifierRef__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ClassifierRef__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getClassifierRefAccess().getFullStopKeyword_2_0()); }

	'.' 

{ after(grammarAccess.getClassifierRefAccess().getFullStopKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ClassifierRef__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ClassifierRef__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ClassifierRef__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_2_1()); }
	RULE_ID
{ after(grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ImplRef__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplRef__Group__0__Impl
	rule__ImplRef__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplRef__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getImplRefAccess().getGroup_0()); }
(rule__ImplRef__Group_0__0)
{ after(grammarAccess.getImplRefAccess().getGroup_0()); }
)
(
{ before(grammarAccess.getImplRefAccess().getGroup_0()); }
(rule__ImplRef__Group_0__0)*
{ after(grammarAccess.getImplRefAccess().getGroup_0()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImplRef__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplRef__Group__1__Impl
	rule__ImplRef__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplRef__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplRefAccess().getIDTerminalRuleCall_1()); }
	RULE_ID
{ after(grammarAccess.getImplRefAccess().getIDTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImplRef__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplRef__Group__2__Impl
	rule__ImplRef__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplRef__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplRefAccess().getFullStopKeyword_2()); }

	'.' 

{ after(grammarAccess.getImplRefAccess().getFullStopKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImplRef__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplRef__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplRef__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplRefAccess().getIDTerminalRuleCall_3()); }
	RULE_ID
{ after(grammarAccess.getImplRefAccess().getIDTerminalRuleCall_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ImplRef__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplRef__Group_0__0__Impl
	rule__ImplRef__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplRef__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplRefAccess().getIDTerminalRuleCall_0_0()); }
	RULE_ID
{ after(grammarAccess.getImplRefAccess().getIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImplRef__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImplRef__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ImplRef__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImplRefAccess().getColonColonKeyword_0_1()); }

	'::' 

{ after(grammarAccess.getImplRefAccess().getColonColonKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DeclarativeRef__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DeclarativeRef__Group__0__Impl
	rule__DeclarativeRef__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DeclarativeRef__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getDeclarativeRefAccess().getGroup_0()); }
(rule__DeclarativeRef__Group_0__0)
{ after(grammarAccess.getDeclarativeRefAccess().getGroup_0()); }
)
(
{ before(grammarAccess.getDeclarativeRefAccess().getGroup_0()); }
(rule__DeclarativeRef__Group_0__0)*
{ after(grammarAccess.getDeclarativeRefAccess().getGroup_0()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DeclarativeRef__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DeclarativeRef__Group__1__Impl
	rule__DeclarativeRef__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DeclarativeRef__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_1()); }
	RULE_ID
{ after(grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DeclarativeRef__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DeclarativeRef__Group__2__Impl
	rule__DeclarativeRef__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DeclarativeRef__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclarativeRefAccess().getGroup_2()); }
(rule__DeclarativeRef__Group_2__0)?
{ after(grammarAccess.getDeclarativeRefAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DeclarativeRef__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DeclarativeRef__Group__3__Impl
	rule__DeclarativeRef__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DeclarativeRef__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclarativeRefAccess().getColonKeyword_3()); }

	':' 

{ after(grammarAccess.getDeclarativeRefAccess().getColonKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DeclarativeRef__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DeclarativeRef__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DeclarativeRef__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclarativeRefAccess().getAlternatives_4()); }
(rule__DeclarativeRef__Alternatives_4)
{ after(grammarAccess.getDeclarativeRefAccess().getAlternatives_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__DeclarativeRef__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DeclarativeRef__Group_0__0__Impl
	rule__DeclarativeRef__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DeclarativeRef__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_0_0()); }
	RULE_ID
{ after(grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DeclarativeRef__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DeclarativeRef__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DeclarativeRef__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclarativeRefAccess().getColonColonKeyword_0_1()); }

	'::' 

{ after(grammarAccess.getDeclarativeRefAccess().getColonColonKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DeclarativeRef__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DeclarativeRef__Group_2__0__Impl
	rule__DeclarativeRef__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DeclarativeRef__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclarativeRefAccess().getFullStopKeyword_2_0()); }

	'.' 

{ after(grammarAccess.getDeclarativeRefAccess().getFullStopKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DeclarativeRef__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DeclarativeRef__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DeclarativeRef__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_2_1()); }
	RULE_ID
{ after(grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DeclarativeRef__Group_4_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DeclarativeRef__Group_4_0__0__Impl
	rule__DeclarativeRef__Group_4_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DeclarativeRef__Group_4_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclarativeRefAccess().getTransitionKeyword_4_0_0()); }

	'transition' 

{ after(grammarAccess.getDeclarativeRefAccess().getTransitionKeyword_4_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DeclarativeRef__Group_4_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DeclarativeRef__Group_4_0__1__Impl
	rule__DeclarativeRef__Group_4_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DeclarativeRef__Group_4_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclarativeRefAccess().getNumberSignKeyword_4_0_1()); }

	'#' 

{ after(grammarAccess.getDeclarativeRefAccess().getNumberSignKeyword_4_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DeclarativeRef__Group_4_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DeclarativeRef__Group_4_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DeclarativeRef__Group_4_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclarativeRefAccess().getINTEGER_LITTerminalRuleCall_4_0_2()); }
	RULE_INTEGER_LIT
{ after(grammarAccess.getDeclarativeRefAccess().getINTEGER_LITTerminalRuleCall_4_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__InstanceRef__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1__0__Impl
	rule__InstanceRef__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getGroup_1_0()); }
(rule__InstanceRef__Group_1_0__0)*
{ after(grammarAccess.getInstanceRefAccess().getGroup_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InstanceRef__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getAlternatives_1_1()); }
(rule__InstanceRef__Alternatives_1_1)
{ after(grammarAccess.getInstanceRefAccess().getAlternatives_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__InstanceRef__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1_0__0__Impl
	rule__InstanceRef__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_0_0()); }
	RULE_ID
{ after(grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InstanceRef__Group_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1_0__1__Impl
	rule__InstanceRef__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getGroup_1_0_1()); }
(rule__InstanceRef__Group_1_0_1__0)*
{ after(grammarAccess.getInstanceRefAccess().getGroup_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InstanceRef__Group_1_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getFullStopKeyword_1_0_2()); }

	'.' 

{ after(grammarAccess.getInstanceRefAccess().getFullStopKeyword_1_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__InstanceRef__Group_1_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1_0_1__0__Impl
	rule__InstanceRef__Group_1_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getLeftSquareBracketKeyword_1_0_1_0()); }

	'[' 

{ after(grammarAccess.getInstanceRefAccess().getLeftSquareBracketKeyword_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InstanceRef__Group_1_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1_0_1__1__Impl
	rule__InstanceRef__Group_1_0_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_0_1_1()); }
	RULE_INTEGER_LIT
{ after(grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InstanceRef__Group_1_0_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1_0_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1_0_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getRightSquareBracketKeyword_1_0_1_2()); }

	']' 

{ after(grammarAccess.getInstanceRefAccess().getRightSquareBracketKeyword_1_0_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__InstanceRef__Group_1_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1_1_0__0__Impl
	rule__InstanceRef__Group_1_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getConnectionKeyword_1_1_0_0()); }

	'connection' 

{ after(grammarAccess.getInstanceRefAccess().getConnectionKeyword_1_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InstanceRef__Group_1_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1_1_0__1__Impl
	rule__InstanceRef__Group_1_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getNumberSignKeyword_1_1_0_1()); }

	'#' 

{ after(grammarAccess.getInstanceRefAccess().getNumberSignKeyword_1_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InstanceRef__Group_1_1_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1_1_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_1_0_2()); }
	RULE_INTEGER_LIT
{ after(grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_1_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__InstanceRef__Group_1_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1_1_1__0__Impl
	rule__InstanceRef__Group_1_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_1_1_0()); }
	RULE_ID
{ after(grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InstanceRef__Group_1_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getGroup_1_1_1_1()); }
(rule__InstanceRef__Group_1_1_1_1__0)*
{ after(grammarAccess.getInstanceRefAccess().getGroup_1_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__InstanceRef__Group_1_1_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1_1_1_1__0__Impl
	rule__InstanceRef__Group_1_1_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1_1_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getLeftSquareBracketKeyword_1_1_1_1_0()); }

	'[' 

{ after(grammarAccess.getInstanceRefAccess().getLeftSquareBracketKeyword_1_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InstanceRef__Group_1_1_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1_1_1_1__1__Impl
	rule__InstanceRef__Group_1_1_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1_1_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_1_1_1_1()); }
	RULE_INTEGER_LIT
{ after(grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_1_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InstanceRef__Group_1_1_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InstanceRef__Group_1_1_1_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceRef__Group_1_1_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceRefAccess().getRightSquareBracketKeyword_1_1_1_1_2()); }

	']' 

{ after(grammarAccess.getInstanceRefAccess().getRightSquareBracketKeyword_1_1_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TransitionRef__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransitionRef__Group__0__Impl
	rule__TransitionRef__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRef__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionRefAccess().getTransitionKeyword_0()); }

	'transition' 

{ after(grammarAccess.getTransitionRefAccess().getTransitionKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransitionRef__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransitionRef__Group__1__Impl
	rule__TransitionRef__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRef__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionRefAccess().getNumberSignKeyword_1()); }

	'#' 

{ after(grammarAccess.getTransitionRefAccess().getNumberSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransitionRef__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransitionRef__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionRef__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionRefAccess().getINTEGER_LITTerminalRuleCall_2()); }
	RULE_INTEGER_LIT
{ after(grammarAccess.getTransitionRefAccess().getINTEGER_LITTerminalRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PropertyAssociationRef__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group__0__Impl
	rule__PropertyAssociationRef__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getGroup_0()); }
(rule__PropertyAssociationRef__Group_0__0)
{ after(grammarAccess.getPropertyAssociationRefAccess().getGroup_0()); }
)
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getGroup_0()); }
(rule__PropertyAssociationRef__Group_0__0)*
{ after(grammarAccess.getPropertyAssociationRefAccess().getGroup_0()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationRef__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group__1__Impl
	rule__PropertyAssociationRef__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_1()); }
	RULE_ID
{ after(grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationRef__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group__2__Impl
	rule__PropertyAssociationRef__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getGroup_2()); }
(rule__PropertyAssociationRef__Group_2__0)?
{ after(grammarAccess.getPropertyAssociationRefAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationRef__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group__3__Impl
	rule__PropertyAssociationRef__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getColonKeyword_3()); }

	':' 

{ after(grammarAccess.getPropertyAssociationRefAccess().getColonKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationRef__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group__4__Impl
	rule__PropertyAssociationRef__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getGroup_4()); }
(rule__PropertyAssociationRef__Group_4__0)?
{ after(grammarAccess.getPropertyAssociationRefAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationRef__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group__5__Impl
	rule__PropertyAssociationRef__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getPropertyKeyword_5()); }

	'property' 

{ after(grammarAccess.getPropertyAssociationRefAccess().getPropertyKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationRef__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group__6__Impl
	rule__PropertyAssociationRef__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getNumberSignKeyword_6()); }

	'#' 

{ after(grammarAccess.getPropertyAssociationRefAccess().getNumberSignKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationRef__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getINTEGER_LITTerminalRuleCall_7()); }
	RULE_INTEGER_LIT
{ after(grammarAccess.getPropertyAssociationRefAccess().getINTEGER_LITTerminalRuleCall_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__PropertyAssociationRef__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group_0__0__Impl
	rule__PropertyAssociationRef__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_0_0()); }
	RULE_ID
{ after(grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationRef__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getColonColonKeyword_0_1()); }

	'::' 

{ after(grammarAccess.getPropertyAssociationRefAccess().getColonColonKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PropertyAssociationRef__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group_2__0__Impl
	rule__PropertyAssociationRef__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getFullStopKeyword_2_0()); }

	'.' 

{ after(grammarAccess.getPropertyAssociationRefAccess().getFullStopKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationRef__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_2_1()); }
	RULE_ID
{ after(grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PropertyAssociationRef__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group_4__0__Impl
	rule__PropertyAssociationRef__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getAlternatives_4_0()); }
(rule__PropertyAssociationRef__Alternatives_4_0)
{ after(grammarAccess.getPropertyAssociationRefAccess().getAlternatives_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationRef__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getColonKeyword_4_1()); }

	':' 

{ after(grammarAccess.getPropertyAssociationRefAccess().getColonKeyword_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PropertyAssociationRef__Group_4_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group_4_0_1__0__Impl
	rule__PropertyAssociationRef__Group_4_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group_4_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getTransitionKeyword_4_0_1_0()); }

	'transition' 

{ after(grammarAccess.getPropertyAssociationRefAccess().getTransitionKeyword_4_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationRef__Group_4_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group_4_0_1__1__Impl
	rule__PropertyAssociationRef__Group_4_0_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group_4_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getNumberSignKeyword_4_0_1_1()); }

	'#' 

{ after(grammarAccess.getPropertyAssociationRefAccess().getNumberSignKeyword_4_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropertyAssociationRef__Group_4_0_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropertyAssociationRef__Group_4_0_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationRef__Group_4_0_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationRefAccess().getINTEGER_LITTerminalRuleCall_4_0_1_2()); }
	RULE_INTEGER_LIT
{ after(grammarAccess.getPropertyAssociationRefAccess().getINTEGER_LITTerminalRuleCall_4_0_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ContainedPropertyAssociation__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group__0__Impl
	rule__ContainedPropertyAssociation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getPropertyAssignment_0()); }
(rule__ContainedPropertyAssociation__PropertyAssignment_0)
{ after(grammarAccess.getContainedPropertyAssociationAccess().getPropertyAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group__1__Impl
	rule__ContainedPropertyAssociation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getAlternatives_1()); }
(rule__ContainedPropertyAssociation__Alternatives_1)
{ after(grammarAccess.getContainedPropertyAssociationAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group__2__Impl
	rule__ContainedPropertyAssociation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getConstantAssignment_2()); }
(rule__ContainedPropertyAssociation__ConstantAssignment_2)?
{ after(grammarAccess.getContainedPropertyAssociationAccess().getConstantAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group__3__Impl
	rule__ContainedPropertyAssociation__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3()); }
(rule__ContainedPropertyAssociation__Group_3__0)
{ after(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group__4__Impl
	rule__ContainedPropertyAssociation__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4()); }
(rule__ContainedPropertyAssociation__Group_4__0)?
{ after(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group__5__Impl
	rule__ContainedPropertyAssociation__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getGroup_5()); }
(rule__ContainedPropertyAssociation__Group_5__0)?
{ after(grammarAccess.getContainedPropertyAssociationAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6()); }

	';' 

{ after(grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__ContainedPropertyAssociation__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group_3__0__Impl
	rule__ContainedPropertyAssociation__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_0()); }
(rule__ContainedPropertyAssociation__OwnedValueAssignment_3_0)
{ after(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3_1()); }
(rule__ContainedPropertyAssociation__Group_3_1__0)*
{ after(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ContainedPropertyAssociation__Group_3_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group_3_1__0__Impl
	rule__ContainedPropertyAssociation__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_3_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0()); }

	',' 

{ after(grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group_3_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_3_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_1_1()); }
(rule__ContainedPropertyAssociation__OwnedValueAssignment_3_1_1)
{ after(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ContainedPropertyAssociation__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group_4__0__Impl
	rule__ContainedPropertyAssociation__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_4_0()); }
	ruleAppliesToKeywords
{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group_4__1__Impl
	rule__ContainedPropertyAssociation__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_1()); }
(rule__ContainedPropertyAssociation__AppliesToAssignment_4_1)
{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4_2()); }
(rule__ContainedPropertyAssociation__Group_4_2__0)*
{ after(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ContainedPropertyAssociation__Group_4_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group_4_2__0__Impl
	rule__ContainedPropertyAssociation__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_4_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0()); }

	',' 

{ after(grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group_4_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_4_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_2_1()); }
(rule__ContainedPropertyAssociation__AppliesToAssignment_4_2_1)
{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ContainedPropertyAssociation__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group_5__0__Impl
	rule__ContainedPropertyAssociation__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_5_0()); }
	ruleInBindingKeywords
{ after(grammarAccess.getContainedPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group_5__1__Impl
	rule__ContainedPropertyAssociation__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_1()); }

	'(' 

{ after(grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group_5__2__Impl
	rule__ContainedPropertyAssociation__Group_5__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getInBindingAssignment_5_2()); }
(rule__ContainedPropertyAssociation__InBindingAssignment_5_2)
{ after(grammarAccess.getContainedPropertyAssociationAccess().getInBindingAssignment_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group_5__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainedPropertyAssociation__Group_5__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_5__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_3()); }

	')' 

{ after(grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

















rule__BooleanLiteral__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BooleanLiteral__Group__0__Impl
	rule__BooleanLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); }
(

)
{ after(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BooleanLiteral__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BooleanLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); }
(rule__BooleanLiteral__Alternatives_1)
{ after(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceTerm__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceTerm__Group__0__Impl
	rule__ReferenceTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceTerm__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceTermAccess().getReferenceKeyword_0()); }

	'reference' 

{ after(grammarAccess.getReferenceTermAccess().getReferenceKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceTerm__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceTerm__Group__1__Impl
	rule__ReferenceTerm__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceTerm__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1()); }

	'(' 

{ after(grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceTerm__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceTerm__Group__2__Impl
	rule__ReferenceTerm__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceTerm__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceTermAccess().getPathAssignment_2()); }
(rule__ReferenceTerm__PathAssignment_2)
{ after(grammarAccess.getReferenceTermAccess().getPathAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceTerm__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceTerm__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceTerm__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceTermAccess().getRightParenthesisKeyword_3()); }

	')' 

{ after(grammarAccess.getReferenceTermAccess().getRightParenthesisKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__RecordTerm__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecordTerm__Group__0__Impl
	rule__RecordTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RecordTerm__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0()); }

	'[' 

{ after(grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RecordTerm__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecordTerm__Group__1__Impl
	rule__RecordTerm__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RecordTerm__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getRecordTermAccess().getOwnedFieldValueAssignment_1()); }
(rule__RecordTerm__OwnedFieldValueAssignment_1)
{ after(grammarAccess.getRecordTermAccess().getOwnedFieldValueAssignment_1()); }
)
(
{ before(grammarAccess.getRecordTermAccess().getOwnedFieldValueAssignment_1()); }
(rule__RecordTerm__OwnedFieldValueAssignment_1)*
{ after(grammarAccess.getRecordTermAccess().getOwnedFieldValueAssignment_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RecordTerm__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecordTerm__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RecordTerm__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecordTermAccess().getRightSquareBracketKeyword_2()); }

	']' 

{ after(grammarAccess.getRecordTermAccess().getRightSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}









rule__ComputedTerm__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputedTerm__Group__0__Impl
	rule__ComputedTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputedTerm__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputedTermAccess().getComputeKeyword_0()); }

	'compute' 

{ after(grammarAccess.getComputedTermAccess().getComputeKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComputedTerm__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputedTerm__Group__1__Impl
	rule__ComputedTerm__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputedTerm__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1()); }

	'(' 

{ after(grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComputedTerm__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputedTerm__Group__2__Impl
	rule__ComputedTerm__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputedTerm__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputedTermAccess().getFunctionAssignment_2()); }
(rule__ComputedTerm__FunctionAssignment_2)
{ after(grammarAccess.getComputedTermAccess().getFunctionAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComputedTerm__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComputedTerm__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputedTerm__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputedTermAccess().getRightParenthesisKeyword_3()); }

	')' 

{ after(grammarAccess.getComputedTermAccess().getRightParenthesisKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ComponentClassifierTerm__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentClassifierTerm__Group__0__Impl
	rule__ComponentClassifierTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentClassifierTerm__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0()); }

	'classifier' 

{ after(grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentClassifierTerm__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentClassifierTerm__Group__1__Impl
	rule__ComponentClassifierTerm__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentClassifierTerm__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1()); }

	'(' 

{ after(grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentClassifierTerm__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentClassifierTerm__Group__2__Impl
	rule__ComponentClassifierTerm__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentClassifierTerm__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentClassifierTermAccess().getClassifierAssignment_2()); }
(rule__ComponentClassifierTerm__ClassifierAssignment_2)
{ after(grammarAccess.getComponentClassifierTermAccess().getClassifierAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentClassifierTerm__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentClassifierTerm__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentClassifierTerm__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentClassifierTermAccess().getRightParenthesisKeyword_3()); }

	')' 

{ after(grammarAccess.getComponentClassifierTermAccess().getRightParenthesisKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ListTerm__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ListTerm__Group__0__Impl
	rule__ListTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getListTermAccess().getListValueAction_0()); }
(

)
{ after(grammarAccess.getListTermAccess().getListValueAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ListTerm__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ListTerm__Group__1__Impl
	rule__ListTerm__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1()); }

	'(' 

{ after(grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ListTerm__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ListTerm__Group__2__Impl
	rule__ListTerm__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getListTermAccess().getGroup_2()); }
(rule__ListTerm__Group_2__0)?
{ after(grammarAccess.getListTermAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ListTerm__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ListTerm__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getListTermAccess().getRightParenthesisKeyword_3()); }

	')' 

{ after(grammarAccess.getListTermAccess().getRightParenthesisKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ListTerm__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ListTerm__Group_2__0__Impl
	rule__ListTerm__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getListTermAccess().getOwnedListElementAssignment_2_0()); }
(rule__ListTerm__OwnedListElementAssignment_2_0)
{ after(grammarAccess.getListTermAccess().getOwnedListElementAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ListTerm__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ListTerm__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getListTermAccess().getGroup_2_1()); }
(rule__ListTerm__Group_2_1__0)*
{ after(grammarAccess.getListTermAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ListTerm__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ListTerm__Group_2_1__0__Impl
	rule__ListTerm__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getListTermAccess().getCommaKeyword_2_1_0()); }

	',' 

{ after(grammarAccess.getListTermAccess().getCommaKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ListTerm__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ListTerm__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getListTermAccess().getOwnedListElementAssignment_2_1_1()); }
(rule__ListTerm__OwnedListElementAssignment_2_1_1)
{ after(grammarAccess.getListTermAccess().getOwnedListElementAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__FieldPropertyAssociation__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FieldPropertyAssociation__Group__0__Impl
	rule__FieldPropertyAssociation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FieldPropertyAssociation__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFieldPropertyAssociationAccess().getPropertyAssignment_0()); }
(rule__FieldPropertyAssociation__PropertyAssignment_0)
{ after(grammarAccess.getFieldPropertyAssociationAccess().getPropertyAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FieldPropertyAssociation__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FieldPropertyAssociation__Group__1__Impl
	rule__FieldPropertyAssociation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FieldPropertyAssociation__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1()); }

	'=>' 

{ after(grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FieldPropertyAssociation__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FieldPropertyAssociation__Group__2__Impl
	rule__FieldPropertyAssociation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__FieldPropertyAssociation__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValueAssignment_2()); }
(rule__FieldPropertyAssociation__OwnedValueAssignment_2)
{ after(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValueAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FieldPropertyAssociation__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FieldPropertyAssociation__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FieldPropertyAssociation__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3()); }

	';' 

{ after(grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}











rule__ArrayRange__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ArrayRange__Group__0__Impl
	rule__ArrayRange__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getArrayRangeAccess().getArrayRangeAction_0()); }
(

)
{ after(grammarAccess.getArrayRangeAccess().getArrayRangeAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ArrayRange__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ArrayRange__Group__1__Impl
	rule__ArrayRange__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1()); }

	'[' 

{ after(grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ArrayRange__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ArrayRange__Group__2__Impl
	rule__ArrayRange__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getArrayRangeAccess().getLowerBoundAssignment_2()); }
(rule__ArrayRange__LowerBoundAssignment_2)
{ after(grammarAccess.getArrayRangeAccess().getLowerBoundAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ArrayRange__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ArrayRange__Group__3__Impl
	rule__ArrayRange__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getArrayRangeAccess().getGroup_3()); }
(rule__ArrayRange__Group_3__0)?
{ after(grammarAccess.getArrayRangeAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ArrayRange__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ArrayRange__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4()); }

	']' 

{ after(grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__ArrayRange__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ArrayRange__Group_3__0__Impl
	rule__ArrayRange__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0()); }

	'..' 

{ after(grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ArrayRange__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ArrayRange__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getArrayRangeAccess().getUpperBoundAssignment_3_1()); }
(rule__ArrayRange__UpperBoundAssignment_3_1)
{ after(grammarAccess.getArrayRangeAccess().getUpperBoundAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SignedConstant__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SignedConstant__Group__0__Impl
	rule__SignedConstant__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedConstant__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignedConstantAccess().getOpAssignment_0()); }
(rule__SignedConstant__OpAssignment_0)
{ after(grammarAccess.getSignedConstantAccess().getOpAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SignedConstant__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SignedConstant__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedConstant__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionAssignment_1()); }
(rule__SignedConstant__OwnedPropertyExpressionAssignment_1)
{ after(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__IntegerTerm__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IntegerTerm__Group__0__Impl
	rule__IntegerTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerTerm__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIntegerTermAccess().getValueAssignment_0()); }
(rule__IntegerTerm__ValueAssignment_0)
{ after(grammarAccess.getIntegerTermAccess().getValueAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IntegerTerm__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IntegerTerm__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerTerm__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIntegerTermAccess().getUnitAssignment_1()); }
(rule__IntegerTerm__UnitAssignment_1)?
{ after(grammarAccess.getIntegerTermAccess().getUnitAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SignedInt__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SignedInt__Group__0__Impl
	rule__SignedInt__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedInt__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignedIntAccess().getAlternatives_0()); }
(rule__SignedInt__Alternatives_0)?
{ after(grammarAccess.getSignedIntAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SignedInt__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SignedInt__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedInt__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignedIntAccess().getINTEGER_LITTerminalRuleCall_1()); }
	RULE_INTEGER_LIT
{ after(grammarAccess.getSignedIntAccess().getINTEGER_LITTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__RealTerm__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RealTerm__Group__0__Impl
	rule__RealTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RealTerm__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRealTermAccess().getValueAssignment_0()); }
(rule__RealTerm__ValueAssignment_0)
{ after(grammarAccess.getRealTermAccess().getValueAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RealTerm__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RealTerm__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RealTerm__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRealTermAccess().getUnitAssignment_1()); }
(rule__RealTerm__UnitAssignment_1)?
{ after(grammarAccess.getRealTermAccess().getUnitAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SignedReal__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SignedReal__Group__0__Impl
	rule__SignedReal__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedReal__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignedRealAccess().getAlternatives_0()); }
(rule__SignedReal__Alternatives_0)?
{ after(grammarAccess.getSignedRealAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SignedReal__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SignedReal__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedReal__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall_1()); }
	RULE_REAL_LIT
{ after(grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NumericRangeTerm__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NumericRangeTerm__Group__0__Impl
	rule__NumericRangeTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNumericRangeTermAccess().getMinimumAssignment_0()); }
(rule__NumericRangeTerm__MinimumAssignment_0)
{ after(grammarAccess.getNumericRangeTermAccess().getMinimumAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NumericRangeTerm__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NumericRangeTerm__Group__1__Impl
	rule__NumericRangeTerm__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1()); }

	'..' 

{ after(grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NumericRangeTerm__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NumericRangeTerm__Group__2__Impl
	rule__NumericRangeTerm__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNumericRangeTermAccess().getMaximumAssignment_2()); }
(rule__NumericRangeTerm__MaximumAssignment_2)
{ after(grammarAccess.getNumericRangeTermAccess().getMaximumAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NumericRangeTerm__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NumericRangeTerm__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNumericRangeTermAccess().getGroup_3()); }
(rule__NumericRangeTerm__Group_3__0)?
{ after(grammarAccess.getNumericRangeTermAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__NumericRangeTerm__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NumericRangeTerm__Group_3__0__Impl
	rule__NumericRangeTerm__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0()); }

	'delta' 

{ after(grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NumericRangeTerm__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NumericRangeTerm__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNumericRangeTermAccess().getDeltaAssignment_3_1()); }
(rule__NumericRangeTerm__DeltaAssignment_3_1)
{ after(grammarAccess.getNumericRangeTermAccess().getDeltaAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AppliesToKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AppliesToKeywords__Group__0__Impl
	rule__AppliesToKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AppliesToKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAppliesToKeywordsAccess().getAppliesKeyword_0()); }

	'applies' 

{ after(grammarAccess.getAppliesToKeywordsAccess().getAppliesKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AppliesToKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AppliesToKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AppliesToKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAppliesToKeywordsAccess().getToKeyword_1()); }

	'to' 

{ after(grammarAccess.getAppliesToKeywordsAccess().getToKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__InBindingKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InBindingKeywords__Group__0__Impl
	rule__InBindingKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InBindingKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInBindingKeywordsAccess().getInKeyword_0()); }

	'in' 

{ after(grammarAccess.getInBindingKeywordsAccess().getInKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InBindingKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InBindingKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InBindingKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInBindingKeywordsAccess().getBindingKeyword_1()); }

	'binding' 

{ after(grammarAccess.getInBindingKeywordsAccess().getBindingKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__InModesKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InModesKeywords__Group__0__Impl
	rule__InModesKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InModesKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInModesKeywordsAccess().getInKeyword_0()); }

	'in' 

{ after(grammarAccess.getInModesKeywordsAccess().getInKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InModesKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InModesKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InModesKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInModesKeywordsAccess().getModesKeyword_1()); }

	'modes' 

{ after(grammarAccess.getInModesKeywordsAccess().getModesKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}







rule__QPREF__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QPREF__Group__0__Impl
	rule__QPREF__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QPREF__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); }
	RULE_ID
{ after(grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QPREF__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QPREF__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QPREF__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQPREFAccess().getGroup_1()); }
(rule__QPREF__Group_1__0)?
{ after(grammarAccess.getQPREFAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QPREF__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QPREF__Group_1__0__Impl
	rule__QPREF__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QPREF__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); }

	'::' 

{ after(grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QPREF__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QPREF__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QPREF__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1()); }
	RULE_ID
{ after(grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QCREF__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QCREF__Group__0__Impl
	rule__QCREF__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQCREFAccess().getGroup_0()); }
(rule__QCREF__Group_0__0)*
{ after(grammarAccess.getQCREFAccess().getGroup_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QCREF__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QCREF__Group__1__Impl
	rule__QCREF__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); }
	RULE_ID
{ after(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QCREF__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QCREF__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQCREFAccess().getGroup_2()); }
(rule__QCREF__Group_2__0)?
{ after(grammarAccess.getQCREFAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__QCREF__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QCREF__Group_0__0__Impl
	rule__QCREF__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); }
	RULE_ID
{ after(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QCREF__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QCREF__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); }

	'::' 

{ after(grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QCREF__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QCREF__Group_2__0__Impl
	rule__QCREF__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); }

	'.' 

{ after(grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QCREF__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QCREF__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1()); }
	RULE_ID
{ after(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}







rule__SystemInstance__CategoryAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); }
	ruleComponentCategory{ after(grammarAccess.getSystemInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getSystemInstanceAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__ComponentImplementationAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_3_0()); }
(
{ before(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationImplRefParserRuleCall_3_0_1()); }
	ruleImplRef{ after(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationImplRefParserRuleCall_3_0_1()); }
)
{ after(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__FeatureInstanceAssignment_5_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_5_0_0()); }
	ruleFeatureInstance{ after(grammarAccess.getSystemInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__ComponentInstanceAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_1_0()); }
	ruleComponentInstance{ after(grammarAccess.getSystemInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__ConnectionInstanceAssignment_5_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_5_2_0()); }
	ruleConnectionInstance{ after(grammarAccess.getSystemInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__FlowSpecificationAssignment_5_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_5_3_0()); }
	ruleFlowSpecificationInstance{ after(grammarAccess.getSystemInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_5_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__EndToEndFlowAssignment_5_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_5_4_0()); }
	ruleEndToEndFlowInstance{ after(grammarAccess.getSystemInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_5_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__ModeInstanceAssignment_5_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getModeInstanceModeInstanceParserRuleCall_5_5_0()); }
	ruleModeInstance{ after(grammarAccess.getSystemInstanceAccess().getModeInstanceModeInstanceParserRuleCall_5_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__ModeTransitionInstanceAssignment_5_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_5_6_0()); }
	ruleModeTransitionInstance{ after(grammarAccess.getSystemInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_5_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__SystemOperationModeAssignment_5_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_7_0()); }
	ruleSystemOperationMode{ after(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemInstance__OwnedPropertyAssociationAssignment_5_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_5_8_0()); }
	rulePropertyAssociationInstance{ after(grammarAccess.getSystemInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_5_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__DirectionAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_0_0()); }
	ruleDirectionType{ after(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__CategoryAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_1_0()); }
	ruleFeatureCategory{ after(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getNameIDTerminalRuleCall_2_0()); }
	RULE_ID{ after(grammarAccess.getFeatureInstanceAccess().getNameIDTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__IndexAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getIndexLongParserRuleCall_3_1_0()); }
	ruleLong{ after(grammarAccess.getFeatureInstanceAccess().getIndexLongParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__FeatureAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); }
(
{ before(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureDeclarativeRefParserRuleCall_5_0_1()); }
	ruleDeclarativeRef{ after(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureDeclarativeRefParserRuleCall_5_0_1()); }
)
{ after(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__FeatureInstanceAssignment_6_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_6_1_0_0()); }
	ruleFeatureInstance{ after(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_6_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureInstance__OwnedPropertyAssociationAssignment_6_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_6_1_1_0()); }
	rulePropertyAssociationInstance{ after(grammarAccess.getFeatureInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_6_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__CategoryAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); }
	ruleComponentCategory{ after(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__ClassifierAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getClassifierComponentClassifierCrossReference_1_0()); }
(
{ before(grammarAccess.getComponentInstanceAccess().getClassifierComponentClassifierClassifierRefParserRuleCall_1_0_1()); }
	ruleClassifierRef{ after(grammarAccess.getComponentInstanceAccess().getClassifierComponentClassifierClassifierRefParserRuleCall_1_0_1()); }
)
{ after(grammarAccess.getComponentInstanceAccess().getClassifierComponentClassifierCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_2_0()); }
	RULE_ID{ after(grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__IndexAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getIndexLongParserRuleCall_3_1_0()); }
	ruleLong{ after(grammarAccess.getComponentInstanceAccess().getIndexLongParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__InModeAssignment_4_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_4_3_0()); }
(
{ before(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceIDTerminalRuleCall_4_3_0_1()); }
	RULE_ID{ after(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceIDTerminalRuleCall_4_3_0_1()); }
)
{ after(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_4_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__InModeAssignment_4_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_4_4_1_0()); }
(
{ before(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceIDTerminalRuleCall_4_4_1_0_1()); }
	RULE_ID{ after(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceIDTerminalRuleCall_4_4_1_0_1()); }
)
{ after(grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_4_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__SubcomponentAssignment_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_6_0()); }
(
{ before(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentDeclarativeRefParserRuleCall_6_0_1()); }
	ruleDeclarativeRef{ after(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentDeclarativeRefParserRuleCall_6_0_1()); }
)
{ after(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__FeatureInstanceAssignment_7_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_7_1_0_0()); }
	ruleFeatureInstance{ after(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_7_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__ComponentInstanceAssignment_7_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_7_1_1_0()); }
	ruleComponentInstance{ after(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_7_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_7_1_2_0()); }
	ruleConnectionInstance{ after(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_7_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__FlowSpecificationAssignment_7_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_7_1_3_0()); }
	ruleFlowSpecificationInstance{ after(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_7_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__EndToEndFlowAssignment_7_1_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_7_1_4_0()); }
	ruleEndToEndFlowInstance{ after(grammarAccess.getComponentInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_7_1_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__ModeInstanceAssignment_7_1_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getModeInstanceModeInstanceParserRuleCall_7_1_5_0()); }
	ruleModeInstance{ after(grammarAccess.getComponentInstanceAccess().getModeInstanceModeInstanceParserRuleCall_7_1_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__ModeTransitionInstanceAssignment_7_1_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_7_1_6_0()); }
	ruleModeTransitionInstance{ after(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_7_1_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentInstance__OwnedPropertyAssociationAssignment_7_1_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_7_1_7_0()); }
	rulePropertyAssociationInstance{ after(grammarAccess.getComponentInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_7_1_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__CompleteAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0()); }
(
{ before(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0()); }

	'complete' 

{ after(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0()); }
)

{ after(grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__KindAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_1_0()); }
	ruleConnectionKind{ after(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getNameSTRINGTerminalRuleCall_2_0()); }
	RULE_STRING{ after(grammarAccess.getConnectionInstanceAccess().getNameSTRINGTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__SourceAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_4_0()); }
(
{ before(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndInstanceRefParserRuleCall_4_0_1()); }
	ruleInstanceRef{ after(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndInstanceRefParserRuleCall_4_0_1()); }
)
{ after(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__BidirectionalAssignment_5_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_0_0()); }
(
{ before(grammarAccess.getConnectionInstanceAccess().getBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_0_0()); }

	'<->' 

{ after(grammarAccess.getConnectionInstanceAccess().getBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_0_0()); }
)

{ after(grammarAccess.getConnectionInstanceAccess().getBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__DestinationAssignment_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_6_0()); }
(
{ before(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndInstanceRefParserRuleCall_6_0_1()); }
	ruleInstanceRef{ after(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndInstanceRefParserRuleCall_6_0_1()); }
)
{ after(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__InSystemOperationModeAssignment_7_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_3_0()); }
(
{ before(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeIDTerminalRuleCall_7_3_0_1()); }
	RULE_ID{ after(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeIDTerminalRuleCall_7_3_0_1()); }
)
{ after(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__InSystemOperationModeAssignment_7_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_4_1_0()); }
(
{ before(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeIDTerminalRuleCall_7_4_1_0_1()); }
	RULE_ID{ after(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeIDTerminalRuleCall_7_4_1_0_1()); }
)
{ after(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__InModeTransitionAssignment_8_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_3_0()); }
(
{ before(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_3_0_1()); }
	ruleTransitionRef{ after(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_3_0_1()); }
)
{ after(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__InModeTransitionAssignment_8_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0()); }
(
{ before(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_4_1_0_1()); }
	ruleTransitionRef{ after(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_4_1_0_1()); }
)
{ after(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__ConnectionReferenceAssignment_10_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_10_0_0()); }
	ruleConnectionReference{ after(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_10_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionInstance__OwnedPropertyAssociationAssignment_10_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_10_1_0()); }
	rulePropertyAssociationInstance{ after(grammarAccess.getConnectionInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_10_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionReference__SourceAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_0_0()); }
(
{ before(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndInstanceRefParserRuleCall_0_0_1()); }
	ruleInstanceRef{ after(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndInstanceRefParserRuleCall_0_0_1()); }
)
{ after(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionReference__DestinationAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_2_0()); }
(
{ before(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndInstanceRefParserRuleCall_2_0_1()); }
	ruleInstanceRef{ after(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndInstanceRefParserRuleCall_2_0_1()); }
)
{ after(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionReference__ReverseAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionReferenceAccess().getReverseReverseKeyword_4_0()); }
(
{ before(grammarAccess.getConnectionReferenceAccess().getReverseReverseKeyword_4_0()); }

	'reverse' 

{ after(grammarAccess.getConnectionReferenceAccess().getReverseReverseKeyword_4_0()); }
)

{ after(grammarAccess.getConnectionReferenceAccess().getReverseReverseKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionReference__ConnectionAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_5_0()); }
(
{ before(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionDeclarativeRefParserRuleCall_5_0_1()); }
	ruleDeclarativeRef{ after(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionDeclarativeRefParserRuleCall_5_0_1()); }
)
{ after(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionReference__ContextAssignment_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_7_0()); }
(
{ before(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceInstanceRefParserRuleCall_7_0_1()); }
	ruleInstanceRef{ after(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceInstanceRefParserRuleCall_7_0_1()); }
)
{ after(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getFlowSpecificationInstanceAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__SourceAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceCrossReference_3_0()); }
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceInstanceRefParserRuleCall_3_0_1()); }
	ruleInstanceRef{ after(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceInstanceRefParserRuleCall_3_0_1()); }
)
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceCrossReference_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__DestinationAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationFeatureInstanceCrossReference_5_0()); }
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationFeatureInstanceInstanceRefParserRuleCall_5_0_1()); }
	ruleInstanceRef{ after(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationFeatureInstanceInstanceRefParserRuleCall_5_0_1()); }
)
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationFeatureInstanceCrossReference_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__InModeAssignment_7_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceCrossReference_7_3_0()); }
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceIDTerminalRuleCall_7_3_0_1()); }
	RULE_ID{ after(grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceIDTerminalRuleCall_7_3_0_1()); }
)
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceCrossReference_7_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__InModeAssignment_7_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceCrossReference_7_4_1_0()); }
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceIDTerminalRuleCall_7_4_1_0_1()); }
	RULE_ID{ after(grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceIDTerminalRuleCall_7_4_1_0_1()); }
)
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceCrossReference_7_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__InModeTransitionAssignment_8_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_3_0()); }
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_3_0_1()); }
	ruleTransitionRef{ after(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_3_0_1()); }
)
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__InModeTransitionAssignment_8_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0()); }
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_4_1_0_1()); }
	ruleTransitionRef{ after(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceTransitionRefParserRuleCall_8_4_1_0_1()); }
)
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__FlowSpecificationAssignment_10
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_10_0()); }
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationFlowSpecificationDeclarativeRefParserRuleCall_10_0_1()); }
	ruleDeclarativeRef{ after(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationFlowSpecificationDeclarativeRefParserRuleCall_10_0_1()); }
)
{ after(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FlowSpecificationInstance__OwnedPropertyAssociationAssignment_11_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFlowSpecificationInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_11_1_0()); }
	rulePropertyAssociationInstance{ after(grammarAccess.getFlowSpecificationInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_11_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__NameAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getNameIDTerminalRuleCall_4_0()); }
	RULE_ID{ after(grammarAccess.getEndToEndFlowInstanceAccess().getNameIDTerminalRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__FlowElementAssignment_5_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_0_0()); }
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceInstanceRefParserRuleCall_5_0_0_1()); }
	ruleInstanceRef{ after(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceInstanceRefParserRuleCall_5_0_0_1()); }
)
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__FlowElementAssignment_5_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_1_1_0()); }
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceInstanceRefParserRuleCall_5_1_1_0_1()); }
	ruleInstanceRef{ after(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceInstanceRefParserRuleCall_5_1_1_0_1()); }
)
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__InSystemOperationModeAssignment_6_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_3_0()); }
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeIDTerminalRuleCall_6_3_0_1()); }
	RULE_ID{ after(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeIDTerminalRuleCall_6_3_0_1()); }
)
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__InSystemOperationModeAssignment_6_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_4_1_0()); }
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeIDTerminalRuleCall_6_4_1_0_1()); }
	RULE_ID{ after(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeIDTerminalRuleCall_6_4_1_0_1()); }
)
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__EndToEndFlowAssignment_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowCrossReference_8_0()); }
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowDeclarativeRefParserRuleCall_8_0_1()); }
	ruleDeclarativeRef{ after(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowDeclarativeRefParserRuleCall_8_0_1()); }
)
{ after(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowCrossReference_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EndToEndFlowInstance__OwnedPropertyAssociationAssignment_9_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndToEndFlowInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_9_1_0()); }
	rulePropertyAssociationInstance{ after(grammarAccess.getEndToEndFlowInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_9_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__InitialAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_0_0()); }
(
{ before(grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_0_0()); }

	'initial' 

{ after(grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_0_0()); }
)

{ after(grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__DerivedAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getDerivedDerivedKeyword_1_0()); }
(
{ before(grammarAccess.getModeInstanceAccess().getDerivedDerivedKeyword_1_0()); }

	'derived' 

{ after(grammarAccess.getModeInstanceAccess().getDerivedDerivedKeyword_1_0()); }
)

{ after(grammarAccess.getModeInstanceAccess().getDerivedDerivedKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__NameAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getNameIDTerminalRuleCall_3_0()); }
	RULE_ID{ after(grammarAccess.getModeInstanceAccess().getNameIDTerminalRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__ParentAssignment_4_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_0_0()); }
(
{ before(grammarAccess.getModeInstanceAccess().getParentModeInstanceIDTerminalRuleCall_4_1_0_0_1()); }
	RULE_ID{ after(grammarAccess.getModeInstanceAccess().getParentModeInstanceIDTerminalRuleCall_4_1_0_0_1()); }
)
{ after(grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__ParentAssignment_4_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_1_1_0()); }
(
{ before(grammarAccess.getModeInstanceAccess().getParentModeInstanceIDTerminalRuleCall_4_1_1_1_0_1()); }
	RULE_ID{ after(grammarAccess.getModeInstanceAccess().getParentModeInstanceIDTerminalRuleCall_4_1_1_1_0_1()); }
)
{ after(grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__ParentAssignment_4_1_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_1_2_1_0()); }
(
{ before(grammarAccess.getModeInstanceAccess().getParentModeInstanceIDTerminalRuleCall_4_1_1_2_1_0_1()); }
	RULE_ID{ after(grammarAccess.getModeInstanceAccess().getParentModeInstanceIDTerminalRuleCall_4_1_1_2_1_0_1()); }
)
{ after(grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__ModeAssignment_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getModeModeCrossReference_6_0()); }
(
{ before(grammarAccess.getModeInstanceAccess().getModeModeDeclarativeRefParserRuleCall_6_0_1()); }
	ruleDeclarativeRef{ after(grammarAccess.getModeInstanceAccess().getModeModeDeclarativeRefParserRuleCall_6_0_1()); }
)
{ after(grammarAccess.getModeInstanceAccess().getModeModeCrossReference_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeInstance__OwnedPropertyAssociationAssignment_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_7_1_0()); }
	rulePropertyAssociationInstance{ after(grammarAccess.getModeInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getNameIDTerminalRuleCall_2_0()); }
	RULE_ID{ after(grammarAccess.getModeTransitionInstanceAccess().getNameIDTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__SourceAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceCrossReference_3_0()); }
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceIDTerminalRuleCall_3_0_1()); }
	RULE_ID{ after(grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceIDTerminalRuleCall_3_0_1()); }
)
{ after(grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceCrossReference_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__TriggerAssignment_5_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getTriggerFeatureInstanceCrossReference_5_0_0()); }
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getTriggerFeatureInstanceInstanceRefParserRuleCall_5_0_0_1()); }
	ruleInstanceRef{ after(grammarAccess.getModeTransitionInstanceAccess().getTriggerFeatureInstanceInstanceRefParserRuleCall_5_0_0_1()); }
)
{ after(grammarAccess.getModeTransitionInstanceAccess().getTriggerFeatureInstanceCrossReference_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__TriggerAssignment_5_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getTriggerFeatureInstanceCrossReference_5_1_1_0()); }
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getTriggerFeatureInstanceInstanceRefParserRuleCall_5_1_1_0_1()); }
	ruleInstanceRef{ after(grammarAccess.getModeTransitionInstanceAccess().getTriggerFeatureInstanceInstanceRefParserRuleCall_5_1_1_0_1()); }
)
{ after(grammarAccess.getModeTransitionInstanceAccess().getTriggerFeatureInstanceCrossReference_5_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__DestinationAssignment_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceCrossReference_7_0()); }
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceIDTerminalRuleCall_7_0_1()); }
	RULE_ID{ after(grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceIDTerminalRuleCall_7_0_1()); }
)
{ after(grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceCrossReference_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__ModeTransitionAssignment_9
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionCrossReference_9_0()); }
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionDeclarativeRefParserRuleCall_9_0_1()); }
	ruleDeclarativeRef{ after(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionDeclarativeRefParserRuleCall_9_0_1()); }
)
{ after(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionCrossReference_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ModeTransitionInstance__OwnedPropertyAssociationAssignment_10_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeTransitionInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_10_1_0()); }
	rulePropertyAssociationInstance{ after(grammarAccess.getModeTransitionInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_10_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemOperationMode__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemOperationModeAccess().getNameSTRINGTerminalRuleCall_1_0()); }
	RULE_STRING{ after(grammarAccess.getSystemOperationModeAccess().getNameSTRINGTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemOperationMode__CurrentModeAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_0_0()); }
(
{ before(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceInstanceRefParserRuleCall_2_0_0_1()); }
	ruleInstanceRef{ after(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceInstanceRefParserRuleCall_2_0_0_1()); }
)
{ after(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SystemOperationMode__CurrentModeAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_1_1_0()); }
(
{ before(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceInstanceRefParserRuleCall_2_1_1_0_1()); }
	ruleInstanceRef{ after(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceInstanceRefParserRuleCall_2_1_1_0_1()); }
)
{ after(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationInstance__PropertyAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyPropertyCrossReference_0_0()); }
(
{ before(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyPropertyQPREFParserRuleCall_0_0_1()); }
	ruleQPREF{ after(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyPropertyQPREFParserRuleCall_0_0_1()); }
)
{ after(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyPropertyCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationInstance__OwnedValueAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_2_0()); }
	ruleOptionalModalPropertyValue{ after(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationInstance__OwnedValueAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_0()); }
	ruleOptionalModalPropertyValue{ after(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyAssociationInstance__PropertyAssociationAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyAssociationPropertyAssociationCrossReference_5_0()); }
(
{ before(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyAssociationPropertyAssociationPropertyAssociationRefParserRuleCall_5_0_1()); }
	rulePropertyAssociationRef{ after(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyAssociationPropertyAssociationPropertyAssociationRefParserRuleCall_5_0_1()); }
)
{ after(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyAssociationPropertyAssociationCrossReference_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__OwnedValueAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); }
	rulePropertyExpression{ after(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__InModeAssignment_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_0()); }
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeIDTerminalRuleCall_1_3_0_1()); }
	RULE_ID{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeIDTerminalRuleCall_1_3_0_1()); }
)
{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__InModeAssignment_1_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_4_1_0()); }
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeIDTerminalRuleCall_1_4_1_0_1()); }
	RULE_ID{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeIDTerminalRuleCall_1_4_1_0_1()); }
)
{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__NamedElementAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0()); }
(
{ before(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementDeclarativeRefParserRuleCall_0_0_1()); }
	ruleDeclarativeRef{ after(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementDeclarativeRefParserRuleCall_0_0_1()); }
)
{ after(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__ArrayRangeAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_1_0()); }
	ruleArrayRange{ after(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__PathAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_2_1_0()); }
	ruleContainmentPathElement{ after(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__InstanceReferenceValue__ReferencedInstanceObjectAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstanceReferenceValueAccess().getReferencedInstanceObjectInstanceObjectCrossReference_2_0()); }
(
{ before(grammarAccess.getInstanceReferenceValueAccess().getReferencedInstanceObjectInstanceObjectInstanceRefParserRuleCall_2_0_1()); }
	ruleInstanceRef{ after(grammarAccess.getInstanceReferenceValueAccess().getReferencedInstanceObjectInstanceObjectInstanceRefParserRuleCall_2_0_1()); }
)
{ after(grammarAccess.getInstanceReferenceValueAccess().getReferencedInstanceObjectInstanceObjectCrossReference_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__PropertyAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); }
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyQPREFParserRuleCall_0_0_1()); }
	ruleQPREF{ after(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyQPREFParserRuleCall_0_0_1()); }
)
{ after(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__AppendAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0()); }
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0()); }

	'+=>' 

{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0()); }
)

{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__ConstantAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0()); }
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0()); }

	'constant' 

{ after(grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0()); }
)

{ after(grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__OwnedValueAssignment_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0()); }
	ruleOptionalModalPropertyValue{ after(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__OwnedValueAssignment_3_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0()); }
	ruleOptionalModalPropertyValue{ after(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__AppliesToAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0()); }
	ruleContainmentPath{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__AppliesToAssignment_4_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0()); }
	ruleContainmentPath{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__InBindingAssignment_5_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_2_0()); }
(
{ before(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierQCREFParserRuleCall_5_2_0_1()); }
	ruleQCREF{ after(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierQCREFParserRuleCall_5_2_0_1()); }
)
{ after(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}









rule__ContainmentPath__PathAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0()); }
	ruleContainmentPathElement{ after(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__PropertyValue__OwnedValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0()); }
	rulePropertyExpression{ after(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralorReferenceTerm__NamedValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0()); }
(
{ before(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueQPREFParserRuleCall_0_1()); }
	ruleQPREF{ after(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueQPREFParserRuleCall_0_1()); }
)
{ after(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__ValueAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }
(
{ before(grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }

	'true' 

{ after(grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }
)

{ after(grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConstantValue__NamedValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0()); }
(
{ before(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantQPREFParserRuleCall_0_1()); }
	ruleQPREF{ after(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantQPREFParserRuleCall_0_1()); }
)
{ after(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceTerm__PathAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0()); }
	ruleContainmentPathElement{ after(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RecordTerm__OwnedFieldValueAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); }
	ruleFieldPropertyAssociation{ after(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComputedTerm__FunctionAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0()); }
	RULE_ID{ after(grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentClassifierTerm__ClassifierAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0()); }
(
{ before(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierQCREFParserRuleCall_2_0_1()); }
	ruleQCREF{ after(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierQCREFParserRuleCall_2_0_1()); }
)
{ after(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__OwnedListElementAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0()); }
	rulePropertyExpression{ after(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__OwnedListElementAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0()); }
	rulePropertyExpression{ after(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FieldPropertyAssociation__PropertyAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0()); }
(
{ before(grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyIDTerminalRuleCall_0_0_1()); }
	RULE_ID{ after(grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyIDTerminalRuleCall_0_0_1()); }
)
{ after(grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FieldPropertyAssociation__OwnedValueAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); }
	rulePropertyExpression{ after(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); }
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

rule__ArrayRange__LowerBoundAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); }
	ruleINTVALUE{ after(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__UpperBoundAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0()); }
	ruleINTVALUE{ after(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SignedConstant__OpAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); }
	rulePlusMinus{ after(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SignedConstant__OwnedPropertyExpressionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0()); }
	ruleConstantValue{ after(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerTerm__ValueAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); }
	ruleSignedInt{ after(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerTerm__UnitAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0()); }
(
{ before(grammarAccess.getIntegerTermAccess().getUnitUnitLiteralIDTerminalRuleCall_1_0_1()); }
	RULE_ID{ after(grammarAccess.getIntegerTermAccess().getUnitUnitLiteralIDTerminalRuleCall_1_0_1()); }
)
{ after(grammarAccess.getIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RealTerm__ValueAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); }
	ruleSignedReal{ after(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RealTerm__UnitAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRealTermAccess().getUnitUnitLiteralCrossReference_1_0()); }
(
{ before(grammarAccess.getRealTermAccess().getUnitUnitLiteralIDTerminalRuleCall_1_0_1()); }
	RULE_ID{ after(grammarAccess.getRealTermAccess().getUnitUnitLiteralIDTerminalRuleCall_1_0_1()); }
)
{ after(grammarAccess.getRealTermAccess().getUnitUnitLiteralCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__MinimumAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0()); }
	ruleNumAlt{ after(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__MaximumAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0()); }
	ruleNumAlt{ after(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__DeltaAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0()); }
	ruleNumAlt{ after(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

fragment RULE_EXPONENT : ('e'|'E') ('+'|'-')? RULE_DIGIT+;

fragment RULE_INT_EXPONENT : ('e'|'E') '+'? RULE_DIGIT+;

RULE_REAL_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* '.' RULE_DIGIT+ ('_' RULE_DIGIT+)* RULE_EXPONENT?;

RULE_INTEGER_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* ('#' RULE_BASED_INTEGER '#' RULE_INT_EXPONENT?|RULE_INT_EXPONENT?);

fragment RULE_DIGIT : '0'..'9';

fragment RULE_EXTENDED_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

fragment RULE_BASED_INTEGER : RULE_EXTENDED_DIGIT ('_'? RULE_EXTENDED_DIGIT)*;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ID : ('a'..'z'|'A'..'Z') ('_'? ('a'..'z'|'A'..'Z'|'0'..'9'))*;

RULE_WS : (' '|'\t'|'\r'|'\n')+;



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
parser grammar InternalErrorModelParser;

options {
	tokenVocab=InternalErrorModelLexer;
	superClass=AbstractInternalContentAssistParser;
	
}

@header {
package org.osate.xtext.aadl2.errormodel.ui.contentassist.antlr.internal; 

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
import org.osate.xtext.aadl2.errormodel.services.ErrorModelGrammarAccess;

}

@members {
 
 	private ErrorModelGrammarAccess grammarAccess;
 	
 	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
 	
 	{
		tokenNameToValue.put("ExclamationMark", "'!'");
		tokenNameToValue.put("LeftParenthesis", "'('");
		tokenNameToValue.put("RightParenthesis", "')'");
		tokenNameToValue.put("Asterisk", "'*'");
		tokenNameToValue.put("PlusSign", "'+'");
		tokenNameToValue.put("Comma", "','");
		tokenNameToValue.put("HyphenMinus", "'-'");
		tokenNameToValue.put("FullStop", "'.'");
		tokenNameToValue.put("Colon", "':'");
		tokenNameToValue.put("Semicolon", "';'");
		tokenNameToValue.put("CommercialAt", "'@'");
		tokenNameToValue.put("LeftSquareBracket", "'['");
		tokenNameToValue.put("RightSquareBracket", "']'");
		tokenNameToValue.put("CircumflexAccent", "'^'");
		tokenNameToValue.put("LeftCurlyBracket", "'{'");
		tokenNameToValue.put("RightCurlyBracket", "'}'");
		tokenNameToValue.put("HyphenMinusGreaterThanSign", "'->'");
		tokenNameToValue.put("HyphenMinusLeftSquareBracket", "'-['");
		tokenNameToValue.put("FullStopFullStop", "'..'");
		tokenNameToValue.put("ColonColon", "'::'");
		tokenNameToValue.put("EqualsSignGreaterThanSign", "'=>'");
		tokenNameToValue.put("If", "'if'");
		tokenNameToValue.put("In", "'in'");
		tokenNameToValue.put("Or", "'or'");
		tokenNameToValue.put("To", "'to'");
		tokenNameToValue.put("AsteriskAsteriskRightCurlyBracket", "'**}'");
		tokenNameToValue.put("PlusSignEqualsSignGreaterThanSign", "'+=>'");
		tokenNameToValue.put("RightSquareBracketHyphenMinusGreaterThanSign", "']->'");
		tokenNameToValue.put("All", "'all'");
		tokenNameToValue.put("And", "'and'");
		tokenNameToValue.put("End", "'end'");
		tokenNameToValue.put("Not", "'not'");
		tokenNameToValue.put("Out", "'out'");
		tokenNameToValue.put("Set", "'set'");
		tokenNameToValue.put("Use", "'use'");
		tokenNameToValue.put("LeftCurlyBracketAsteriskAsterisk", "'{**'");
		tokenNameToValue.put("Mode", "'mode'");
		tokenNameToValue.put("Path", "'path'");
		tokenNameToValue.put("Same", "'same'");
		tokenNameToValue.put("Sink", "'sink'");
		tokenNameToValue.put("True", "'true'");
		tokenNameToValue.put("Type", "'type'");
		tokenNameToValue.put("When", "'when'");
		tokenNameToValue.put("With", "'with'");
		tokenNameToValue.put("Annex", "'annex'");
		tokenNameToValue.put("Delta", "'delta'");
		tokenNameToValue.put("Error", "'error'");
		tokenNameToValue.put("Event", "'event'");
		tokenNameToValue.put("False", "'false'");
		tokenNameToValue.put("Flows", "'flows'");
		tokenNameToValue.put("Modes", "'modes'");
		tokenNameToValue.put("Paths", "'paths'");
		tokenNameToValue.put("Point", "'point'");
		tokenNameToValue.put("State", "'state'");
		tokenNameToValue.put("Types", "'types'");
		tokenNameToValue.put("Access", "'access'");
		tokenNameToValue.put("Events", "'events'");
		tokenNameToValue.put("Memory", "'memory'");
		tokenNameToValue.put("Orless", "'orless'");
		tokenNameToValue.put("Ormore", "'ormore'");
		tokenNameToValue.put("Others", "'others'");
		tokenNameToValue.put("Public", "'public'");
		tokenNameToValue.put("Repair", "'repair'");
		tokenNameToValue.put("Source", "'source'");
		tokenNameToValue.put("States", "'states'");
		tokenNameToValue.put("Applies", "'applies'");
		tokenNameToValue.put("Binding", "'binding'");
		tokenNameToValue.put("Compute", "'compute'");
		tokenNameToValue.put("Extends", "'extends'");
		tokenNameToValue.put("Initial", "'initial'");
		tokenNameToValue.put("Library", "'library'");
		tokenNameToValue.put("Noerror", "'noerror'");
		tokenNameToValue.put("Package", "'package'");
		tokenNameToValue.put("Recover", "'recover'");
		tokenNameToValue.put("Renames", "'renames'");
		tokenNameToValue.put("Behavior", "'behavior'");
		tokenNameToValue.put("Bindings", "'bindings'");
		tokenNameToValue.put("Constant", "'constant'");
		tokenNameToValue.put("Mappings", "'mappings'");
		tokenNameToValue.put("Component", "'component'");
		tokenNameToValue.put("Composite", "'composite'");
		tokenNameToValue.put("Processor", "'processor'");
		tokenNameToValue.put("Reference", "'reference'");
		tokenNameToValue.put("Subclause", "'subclause'");
		tokenNameToValue.put("Classifier", "'classifier'");
		tokenNameToValue.put("Connection", "'connection'");
		tokenNameToValue.put("Detections", "'detections'");
		tokenNameToValue.put("Properties", "'properties'");
		tokenNameToValue.put("Equivalence", "'equivalence'");
		tokenNameToValue.put("Propagation", "'propagation'");
		tokenNameToValue.put("Transitions", "'transitions'");
		tokenNameToValue.put("Propagations", "'propagations'");
		tokenNameToValue.put("Transformations", "'transformations'");
 	}
 	
    public void setGrammarAccess(ErrorModelGrammarAccess grammarAccess) {
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




// Entry rule entryRuleEMV2Root
entryRuleEMV2Root 
:
{ before(grammarAccess.getEMV2RootRule()); }
	 ruleEMV2Root
{ after(grammarAccess.getEMV2RootRule()); } 
	 EOF 
;

// Rule EMV2Root
ruleEMV2Root 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEMV2RootAccess().getGroup()); }
(rule__EMV2Root__Group__0)
{ after(grammarAccess.getEMV2RootAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}













// Entry rule entryRuleErrorModelSubclause
entryRuleErrorModelSubclause 
:
{ before(grammarAccess.getErrorModelSubclauseRule()); }
	 ruleErrorModelSubclause
{ after(grammarAccess.getErrorModelSubclauseRule()); } 
	 EOF 
;

// Rule ErrorModelSubclause
ruleErrorModelSubclause 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup()); }
(rule__ErrorModelSubclause__Group__0)
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEMV2Subclause
entryRuleEMV2Subclause 
:
{ before(grammarAccess.getEMV2SubclauseRule()); }
	 ruleEMV2Subclause
{ after(grammarAccess.getEMV2SubclauseRule()); } 
	 EOF 
;

// Rule EMV2Subclause
ruleEMV2Subclause 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup()); }
(rule__EMV2Subclause__Group__0)
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorModelLibrary
entryRuleErrorModelLibrary 
:
{ before(grammarAccess.getErrorModelLibraryRule()); }
	 ruleErrorModelLibrary
{ after(grammarAccess.getErrorModelLibraryRule()); } 
	 EOF 
;

// Rule ErrorModelLibrary
ruleErrorModelLibrary 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorModelLibraryAccess().getGroup()); }
(rule__ErrorModelLibrary__Group__0)
{ after(grammarAccess.getErrorModelLibraryAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEMV2Library
entryRuleEMV2Library 
:
{ before(grammarAccess.getEMV2LibraryRule()); }
	 ruleEMV2Library
{ after(grammarAccess.getEMV2LibraryRule()); } 
	 EOF 
;

// Rule EMV2Library
ruleEMV2Library 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEMV2LibraryAccess().getAlternatives()); }
(rule__EMV2Library__Alternatives)
{ after(grammarAccess.getEMV2LibraryAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEMV2PropertyAssociation
entryRuleEMV2PropertyAssociation 
:
{ before(grammarAccess.getEMV2PropertyAssociationRule()); }
	 ruleEMV2PropertyAssociation
{ after(grammarAccess.getEMV2PropertyAssociationRule()); } 
	 EOF 
;

// Rule EMV2PropertyAssociation
ruleEMV2PropertyAssociation 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getGroup()); }
(rule__EMV2PropertyAssociation__Group__0)
{ after(grammarAccess.getEMV2PropertyAssociationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleBasicEMV2PropertyAssociation
entryRuleBasicEMV2PropertyAssociation 
:
{ before(grammarAccess.getBasicEMV2PropertyAssociationRule()); }
	 ruleBasicEMV2PropertyAssociation
{ after(grammarAccess.getBasicEMV2PropertyAssociationRule()); } 
	 EOF 
;

// Rule BasicEMV2PropertyAssociation
ruleBasicEMV2PropertyAssociation 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup()); }
(rule__BasicEMV2PropertyAssociation__Group__0)
{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEMV2Path
entryRuleEMV2Path 
:
{ before(grammarAccess.getEMV2PathRule()); }
	 ruleEMV2Path
{ after(grammarAccess.getEMV2PathRule()); } 
	 EOF 
;

// Rule EMV2Path
ruleEMV2Path 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEMV2PathAccess().getGroup()); }
(rule__EMV2Path__Group__0)
{ after(grammarAccess.getEMV2PathAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleBasicEMV2Path
entryRuleBasicEMV2Path 
:
{ before(grammarAccess.getBasicEMV2PathRule()); }
	 ruleBasicEMV2Path
{ after(grammarAccess.getBasicEMV2PathRule()); } 
	 EOF 
;

// Rule BasicEMV2Path
ruleBasicEMV2Path 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getBasicEMV2PathAccess().getEmv2TargetAssignment()); }
(rule__BasicEMV2Path__Emv2TargetAssignment)
{ after(grammarAccess.getBasicEMV2PathAccess().getEmv2TargetAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEMV2PathElementOrKind
entryRuleEMV2PathElementOrKind 
:
{ before(grammarAccess.getEMV2PathElementOrKindRule()); }
	 ruleEMV2PathElementOrKind
{ after(grammarAccess.getEMV2PathElementOrKindRule()); } 
	 EOF 
;

// Rule EMV2PathElementOrKind
ruleEMV2PathElementOrKind 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getAlternatives()); }
(rule__EMV2PathElementOrKind__Alternatives)
{ after(grammarAccess.getEMV2PathElementOrKindAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEMV2PathElement
entryRuleEMV2PathElement 
:
{ before(grammarAccess.getEMV2PathElementRule()); }
	 ruleEMV2PathElement
{ after(grammarAccess.getEMV2PathElementRule()); } 
	 EOF 
;

// Rule EMV2PathElement
ruleEMV2PathElement 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEMV2PathElementAccess().getGroup()); }
(rule__EMV2PathElement__Group__0)
{ after(grammarAccess.getEMV2PathElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorTypes
entryRuleErrorTypes 
:
{ before(grammarAccess.getErrorTypesRule()); }
	 ruleErrorTypes
{ after(grammarAccess.getErrorTypesRule()); } 
	 EOF 
;

// Rule ErrorTypes
ruleErrorTypes 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorTypesAccess().getAlternatives()); }
(rule__ErrorTypes__Alternatives)
{ after(grammarAccess.getErrorTypesAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeDefinition
entryRuleTypeDefinition 
:
{ before(grammarAccess.getTypeDefinitionRule()); }
	 ruleTypeDefinition
{ after(grammarAccess.getTypeDefinitionRule()); } 
	 EOF 
;

// Rule TypeDefinition
ruleTypeDefinition 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeDefinitionAccess().getGroup()); }
(rule__TypeDefinition__Group__0)
{ after(grammarAccess.getTypeDefinitionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeSetDefinition
entryRuleTypeSetDefinition 
:
{ before(grammarAccess.getTypeSetDefinitionRule()); }
	 ruleTypeSetDefinition
{ after(grammarAccess.getTypeSetDefinitionRule()); } 
	 EOF 
;

// Rule TypeSetDefinition
ruleTypeSetDefinition 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getGroup()); }
(rule__TypeSetDefinition__Group__0)
{ after(grammarAccess.getTypeSetDefinitionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeSetConstructor
entryRuleTypeSetConstructor 
:
{ before(grammarAccess.getTypeSetConstructorRule()); }
	 ruleTypeSetConstructor
{ after(grammarAccess.getTypeSetConstructorRule()); } 
	 EOF 
;

// Rule TypeSetConstructor
ruleTypeSetConstructor 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeSetConstructorAccess().getGroup()); }
(rule__TypeSetConstructor__Group__0)
{ after(grammarAccess.getTypeSetConstructorAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeSetReference
entryRuleTypeSetReference 
:
{ before(grammarAccess.getTypeSetReferenceRule()); }
	 ruleTypeSetReference
{ after(grammarAccess.getTypeSetReferenceRule()); } 
	 EOF 
;

// Rule TypeSetReference
ruleTypeSetReference 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeSetReferenceAccess().getTypeSetConstructorParserRuleCall()); }
	ruleTypeSetConstructor
{ after(grammarAccess.getTypeSetReferenceAccess().getTypeSetConstructorParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeSetElement
entryRuleTypeSetElement 
:
{ before(grammarAccess.getTypeSetElementRule()); }
	 ruleTypeSetElement
{ after(grammarAccess.getTypeSetElementRule()); } 
	 EOF 
;

// Rule TypeSetElement
ruleTypeSetElement 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeSetElementAccess().getGroup()); }
(rule__TypeSetElement__Group__0)
{ after(grammarAccess.getTypeSetElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNoErrorTypeSet
entryRuleNoErrorTypeSet 
:
{ before(grammarAccess.getNoErrorTypeSetRule()); }
	 ruleNoErrorTypeSet
{ after(grammarAccess.getNoErrorTypeSetRule()); } 
	 EOF 
;

// Rule NoErrorTypeSet
ruleNoErrorTypeSet 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getNoErrorTypeSetAccess().getGroup()); }
(rule__NoErrorTypeSet__Group__0)
{ after(grammarAccess.getNoErrorTypeSetAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNoErrorTypeToken
entryRuleNoErrorTypeToken 
:
{ before(grammarAccess.getNoErrorTypeTokenRule()); }
	 ruleNoErrorTypeToken
{ after(grammarAccess.getNoErrorTypeTokenRule()); } 
	 EOF 
;

// Rule NoErrorTypeToken
ruleNoErrorTypeToken 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getNoErrorTypeTokenAccess().getGroup()); }
(rule__NoErrorTypeToken__Group__0)
{ after(grammarAccess.getNoErrorTypeTokenAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeToken
entryRuleTypeToken 
:
{ before(grammarAccess.getTypeTokenRule()); }
	 ruleTypeToken
{ after(grammarAccess.getTypeTokenRule()); } 
	 EOF 
;

// Rule TypeToken
ruleTypeToken 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeTokenAccess().getTypeSetReferenceParserRuleCall()); }
	ruleTypeSetReference
{ after(grammarAccess.getTypeTokenAccess().getTypeSetReferenceParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeTokenOrNoError
entryRuleTypeTokenOrNoError 
:
{ before(grammarAccess.getTypeTokenOrNoErrorRule()); }
	 ruleTypeTokenOrNoError
{ after(grammarAccess.getTypeTokenOrNoErrorRule()); } 
	 EOF 
;

// Rule TypeTokenOrNoError
ruleTypeTokenOrNoError 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeTokenOrNoErrorAccess().getAlternatives()); }
(rule__TypeTokenOrNoError__Alternatives)
{ after(grammarAccess.getTypeTokenOrNoErrorAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeTokenConstraint
entryRuleTypeTokenConstraint 
:
{ before(grammarAccess.getTypeTokenConstraintRule()); }
	 ruleTypeTokenConstraint
{ after(grammarAccess.getTypeTokenConstraintRule()); } 
	 EOF 
;

// Rule TypeTokenConstraint
ruleTypeTokenConstraint 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeTokenConstraintAccess().getTypeSetReferenceParserRuleCall()); }
	ruleTypeSetReference
{ after(grammarAccess.getTypeTokenConstraintAccess().getTypeSetReferenceParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeTokenConstraintNoError
entryRuleTypeTokenConstraintNoError 
:
{ before(grammarAccess.getTypeTokenConstraintNoErrorRule()); }
	 ruleTypeTokenConstraintNoError
{ after(grammarAccess.getTypeTokenConstraintNoErrorRule()); } 
	 EOF 
;

// Rule TypeTokenConstraintNoError
ruleTypeTokenConstraintNoError 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeTokenConstraintNoErrorAccess().getAlternatives()); }
(rule__TypeTokenConstraintNoError__Alternatives)
{ after(grammarAccess.getTypeTokenConstraintNoErrorAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeTransformationSet
entryRuleTypeTransformationSet 
:
{ before(grammarAccess.getTypeTransformationSetRule()); }
	 ruleTypeTransformationSet
{ after(grammarAccess.getTypeTransformationSetRule()); } 
	 EOF 
;

// Rule TypeTransformationSet
ruleTypeTransformationSet 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeTransformationSetAccess().getGroup()); }
(rule__TypeTransformationSet__Group__0)
{ after(grammarAccess.getTypeTransformationSetAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeTransformation
entryRuleTypeTransformation 
:
{ before(grammarAccess.getTypeTransformationRule()); }
	 ruleTypeTransformation
{ after(grammarAccess.getTypeTransformationRule()); } 
	 EOF 
;

// Rule TypeTransformation
ruleTypeTransformation 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeTransformationAccess().getGroup()); }
(rule__TypeTransformation__Group__0)
{ after(grammarAccess.getTypeTransformationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeMappingSet
entryRuleTypeMappingSet 
:
{ before(grammarAccess.getTypeMappingSetRule()); }
	 ruleTypeMappingSet
{ after(grammarAccess.getTypeMappingSetRule()); } 
	 EOF 
;

// Rule TypeMappingSet
ruleTypeMappingSet 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeMappingSetAccess().getGroup()); }
(rule__TypeMappingSet__Group__0)
{ after(grammarAccess.getTypeMappingSetAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeMapping
entryRuleTypeMapping 
:
{ before(grammarAccess.getTypeMappingRule()); }
	 ruleTypeMapping
{ after(grammarAccess.getTypeMappingRule()); } 
	 EOF 
;

// Rule TypeMapping
ruleTypeMapping 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeMappingAccess().getGroup()); }
(rule__TypeMapping__Group__0)
{ after(grammarAccess.getTypeMappingAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorPropagation
entryRuleErrorPropagation 
:
{ before(grammarAccess.getErrorPropagationRule()); }
	 ruleErrorPropagation
{ after(grammarAccess.getErrorPropagationRule()); } 
	 EOF 
;

// Rule ErrorPropagation
ruleErrorPropagation 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorPropagationAccess().getGroup()); }
(rule__ErrorPropagation__Group__0)
{ after(grammarAccess.getErrorPropagationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleFeatureorPPReference
entryRuleFeatureorPPReference 
:
{ before(grammarAccess.getFeatureorPPReferenceRule()); }
	 ruleFeatureorPPReference
{ after(grammarAccess.getFeatureorPPReferenceRule()); } 
	 EOF 
;

// Rule FeatureorPPReference
ruleFeatureorPPReference 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getFeatureorPPReferenceAccess().getGroup()); }
(rule__FeatureorPPReference__Group__0)
{ after(grammarAccess.getFeatureorPPReferenceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePropagationDirection
entryRulePropagationDirection 
:
{ before(grammarAccess.getPropagationDirectionRule()); }
	 rulePropagationDirection
{ after(grammarAccess.getPropagationDirectionRule()); } 
	 EOF 
;

// Rule PropagationDirection
rulePropagationDirection 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getPropagationDirectionAccess().getAlternatives()); }
(rule__PropagationDirection__Alternatives)
{ after(grammarAccess.getPropagationDirectionAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePropagationKind
entryRulePropagationKind 
:
{ before(grammarAccess.getPropagationKindRule()); }
	 rulePropagationKind
{ after(grammarAccess.getPropagationKindRule()); } 
	 EOF 
;

// Rule PropagationKind
rulePropagationKind 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getPropagationKindAccess().getAlternatives()); }
(rule__PropagationKind__Alternatives)
{ after(grammarAccess.getPropagationKindAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorFlow
entryRuleErrorFlow 
:
{ before(grammarAccess.getErrorFlowRule()); }
	 ruleErrorFlow
{ after(grammarAccess.getErrorFlowRule()); } 
	 EOF 
;

// Rule ErrorFlow
ruleErrorFlow 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorFlowAccess().getAlternatives()); }
(rule__ErrorFlow__Alternatives)
{ after(grammarAccess.getErrorFlowAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorSource
entryRuleErrorSource 
:
{ before(grammarAccess.getErrorSourceRule()); }
	 ruleErrorSource
{ after(grammarAccess.getErrorSourceRule()); } 
	 EOF 
;

// Rule ErrorSource
ruleErrorSource 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorSourceAccess().getGroup()); }
(rule__ErrorSource__Group__0)
{ after(grammarAccess.getErrorSourceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorSink
entryRuleErrorSink 
:
{ before(grammarAccess.getErrorSinkRule()); }
	 ruleErrorSink
{ after(grammarAccess.getErrorSinkRule()); } 
	 EOF 
;

// Rule ErrorSink
ruleErrorSink 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorSinkAccess().getGroup()); }
(rule__ErrorSink__Group__0)
{ after(grammarAccess.getErrorSinkAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorPath
entryRuleErrorPath 
:
{ before(grammarAccess.getErrorPathRule()); }
	 ruleErrorPath
{ after(grammarAccess.getErrorPathRule()); } 
	 EOF 
;

// Rule ErrorPath
ruleErrorPath 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorPathAccess().getGroup()); }
(rule__ErrorPath__Group__0)
{ after(grammarAccess.getErrorPathAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleIfCondition
entryRuleIfCondition 
:
{ before(grammarAccess.getIfConditionRule()); }
	 ruleIfCondition
{ after(grammarAccess.getIfConditionRule()); } 
	 EOF 
;

// Rule IfCondition
ruleIfCondition 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getIfConditionAccess().getAlternatives()); }
(rule__IfCondition__Alternatives)
{ after(grammarAccess.getIfConditionAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorPropagationPoint
entryRuleErrorPropagationPoint 
:
{ before(grammarAccess.getErrorPropagationPointRule()); }
	 ruleErrorPropagationPoint
{ after(grammarAccess.getErrorPropagationPointRule()); } 
	 EOF 
;

// Rule ErrorPropagationPoint
ruleErrorPropagationPoint 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorPropagationPointAccess().getGroup()); }
(rule__ErrorPropagationPoint__Group__0)
{ after(grammarAccess.getErrorPropagationPointAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePropagationPoint
entryRulePropagationPoint 
:
{ before(grammarAccess.getPropagationPointRule()); }
	 rulePropagationPoint
{ after(grammarAccess.getPropagationPointRule()); } 
	 EOF 
;

// Rule PropagationPoint
rulePropagationPoint 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getPropagationPointAccess().getGroup()); }
(rule__PropagationPoint__Group__0)
{ after(grammarAccess.getPropagationPointAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePropagationPath
entryRulePropagationPath 
:
{ before(grammarAccess.getPropagationPathRule()); }
	 rulePropagationPath
{ after(grammarAccess.getPropagationPathRule()); } 
	 EOF 
;

// Rule PropagationPath
rulePropagationPath 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getPropagationPathAccess().getGroup()); }
(rule__PropagationPath__Group__0)
{ after(grammarAccess.getPropagationPathAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleQualifiedPropagationPoint
entryRuleQualifiedPropagationPoint 
:
{ before(grammarAccess.getQualifiedPropagationPointRule()); }
	 ruleQualifiedPropagationPoint
{ after(grammarAccess.getQualifiedPropagationPointRule()); } 
	 EOF 
;

// Rule QualifiedPropagationPoint
ruleQualifiedPropagationPoint 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getQualifiedPropagationPointAccess().getAlternatives()); }
(rule__QualifiedPropagationPoint__Alternatives)
{ after(grammarAccess.getQualifiedPropagationPointAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorBehaviorStateMachine
entryRuleErrorBehaviorStateMachine 
:
{ before(grammarAccess.getErrorBehaviorStateMachineRule()); }
	 ruleErrorBehaviorStateMachine
{ after(grammarAccess.getErrorBehaviorStateMachineRule()); } 
	 EOF 
;

// Rule ErrorBehaviorStateMachine
ruleErrorBehaviorStateMachine 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup()); }
(rule__ErrorBehaviorStateMachine__Group__0)
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorBehaviorEvent
entryRuleErrorBehaviorEvent 
:
{ before(grammarAccess.getErrorBehaviorEventRule()); }
	 ruleErrorBehaviorEvent
{ after(grammarAccess.getErrorBehaviorEventRule()); } 
	 EOF 
;

// Rule ErrorBehaviorEvent
ruleErrorBehaviorEvent 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorBehaviorEventAccess().getAlternatives()); }
(rule__ErrorBehaviorEvent__Alternatives)
{ after(grammarAccess.getErrorBehaviorEventAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorEvent
entryRuleErrorEvent 
:
{ before(grammarAccess.getErrorEventRule()); }
	 ruleErrorEvent
{ after(grammarAccess.getErrorEventRule()); } 
	 EOF 
;

// Rule ErrorEvent
ruleErrorEvent 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorEventAccess().getGroup()); }
(rule__ErrorEvent__Group__0)
{ after(grammarAccess.getErrorEventAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRepairEvent
entryRuleRepairEvent 
:
{ before(grammarAccess.getRepairEventRule()); }
	 ruleRepairEvent
{ after(grammarAccess.getRepairEventRule()); } 
	 EOF 
;

// Rule RepairEvent
ruleRepairEvent 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getRepairEventAccess().getGroup()); }
(rule__RepairEvent__Group__0)
{ after(grammarAccess.getRepairEventAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRecoverEvent
entryRuleRecoverEvent 
:
{ before(grammarAccess.getRecoverEventRule()); }
	 ruleRecoverEvent
{ after(grammarAccess.getRecoverEventRule()); } 
	 EOF 
;

// Rule RecoverEvent
ruleRecoverEvent 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getRecoverEventAccess().getGroup()); }
(rule__RecoverEvent__Group__0)
{ after(grammarAccess.getRecoverEventAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorBehaviorState
entryRuleErrorBehaviorState 
:
{ before(grammarAccess.getErrorBehaviorStateRule()); }
	 ruleErrorBehaviorState
{ after(grammarAccess.getErrorBehaviorStateRule()); } 
	 EOF 
;

// Rule ErrorBehaviorState
ruleErrorBehaviorState 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorBehaviorStateAccess().getGroup()); }
(rule__ErrorBehaviorState__Group__0)
{ after(grammarAccess.getErrorBehaviorStateAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorBehaviorTransition
entryRuleErrorBehaviorTransition 
:
{ before(grammarAccess.getErrorBehaviorTransitionRule()); }
	 ruleErrorBehaviorTransition
{ after(grammarAccess.getErrorBehaviorTransitionRule()); } 
	 EOF 
;

// Rule ErrorBehaviorTransition
ruleErrorBehaviorTransition 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getGroup()); }
(rule__ErrorBehaviorTransition__Group__0)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTransitionBranch
entryRuleTransitionBranch 
:
{ before(grammarAccess.getTransitionBranchRule()); }
	 ruleTransitionBranch
{ after(grammarAccess.getTransitionBranchRule()); } 
	 EOF 
;

// Rule TransitionBranch
ruleTransitionBranch 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTransitionBranchAccess().getGroup()); }
(rule__TransitionBranch__Group__0)
{ after(grammarAccess.getTransitionBranchAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleBranchValue
entryRuleBranchValue 
:
{ before(grammarAccess.getBranchValueRule()); }
	 ruleBranchValue
{ after(grammarAccess.getBranchValueRule()); } 
	 EOF 
;

// Rule BranchValue
ruleBranchValue 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getBranchValueAccess().getGroup()); }
(rule__BranchValue__Group__0)
{ after(grammarAccess.getBranchValueAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleConditionExpression
entryRuleConditionExpression 
:
{ before(grammarAccess.getConditionExpressionRule()); }
	 ruleConditionExpression
{ after(grammarAccess.getConditionExpressionRule()); } 
	 EOF 
;

// Rule ConditionExpression
ruleConditionExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getConditionExpressionAccess().getGroup()); }
(rule__ConditionExpression__Group__0)
{ after(grammarAccess.getConditionExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAndExpression
entryRuleAndExpression 
:
{ before(grammarAccess.getAndExpressionRule()); }
	 ruleAndExpression
{ after(grammarAccess.getAndExpressionRule()); } 
	 EOF 
;

// Rule AndExpression
ruleAndExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAndExpressionAccess().getGroup()); }
(rule__AndExpression__Group__0)
{ after(grammarAccess.getAndExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAllExpression
entryRuleAllExpression 
:
{ before(grammarAccess.getAllExpressionRule()); }
	 ruleAllExpression
{ after(grammarAccess.getAllExpressionRule()); } 
	 EOF 
;

// Rule AllExpression
ruleAllExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getAllExpressionAccess().getGroup()); }
(rule__AllExpression__Group__0)
{ after(grammarAccess.getAllExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOrmoreExpression
entryRuleOrmoreExpression 
:
{ before(grammarAccess.getOrmoreExpressionRule()); }
	 ruleOrmoreExpression
{ after(grammarAccess.getOrmoreExpressionRule()); } 
	 EOF 
;

// Rule OrmoreExpression
ruleOrmoreExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getOrmoreExpressionAccess().getGroup()); }
(rule__OrmoreExpression__Group__0)
{ after(grammarAccess.getOrmoreExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOrlessExpression
entryRuleOrlessExpression 
:
{ before(grammarAccess.getOrlessExpressionRule()); }
	 ruleOrlessExpression
{ after(grammarAccess.getOrlessExpressionRule()); } 
	 EOF 
;

// Rule OrlessExpression
ruleOrlessExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getOrlessExpressionAccess().getGroup()); }
(rule__OrlessExpression__Group__0)
{ after(grammarAccess.getOrlessExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleConditionTerm
entryRuleConditionTerm 
:
{ before(grammarAccess.getConditionTermRule()); }
	 ruleConditionTerm
{ after(grammarAccess.getConditionTermRule()); } 
	 EOF 
;

// Rule ConditionTerm
ruleConditionTerm 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getConditionTermAccess().getAlternatives()); }
(rule__ConditionTerm__Alternatives)
{ after(grammarAccess.getConditionTermAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleConditionElement
entryRuleConditionElement 
:
{ before(grammarAccess.getConditionElementRule()); }
	 ruleConditionElement
{ after(grammarAccess.getConditionElementRule()); } 
	 EOF 
;

// Rule ConditionElement
ruleConditionElement 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getConditionElementAccess().getGroup()); }
(rule__ConditionElement__Group__0)
{ after(grammarAccess.getConditionElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleQualifiedErrorEventOrPropagation
entryRuleQualifiedErrorEventOrPropagation 
:
{ before(grammarAccess.getQualifiedErrorEventOrPropagationRule()); }
	 ruleQualifiedErrorEventOrPropagation
{ after(grammarAccess.getQualifiedErrorEventOrPropagationRule()); } 
	 EOF 
;

// Rule QualifiedErrorEventOrPropagation
ruleQualifiedErrorEventOrPropagation 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getQualifiedErrorEventOrPropagationAccess().getGroup()); }
(rule__QualifiedErrorEventOrPropagation__Group__0)
{ after(grammarAccess.getQualifiedErrorEventOrPropagationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEMV2ErrorPropagationPath
entryRuleEMV2ErrorPropagationPath 
:
{ before(grammarAccess.getEMV2ErrorPropagationPathRule()); }
	 ruleEMV2ErrorPropagationPath
{ after(grammarAccess.getEMV2ErrorPropagationPathRule()); } 
	 EOF 
;

// Rule EMV2ErrorPropagationPath
ruleEMV2ErrorPropagationPath 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEMV2ErrorPropagationPathAccess().getAlternatives()); }
(rule__EMV2ErrorPropagationPath__Alternatives)
{ after(grammarAccess.getEMV2ErrorPropagationPathAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEventOrPropagation
entryRuleEventOrPropagation 
:
{ before(grammarAccess.getEventOrPropagationRule()); }
	 ruleEventOrPropagation
{ after(grammarAccess.getEventOrPropagationRule()); } 
	 EOF 
;

// Rule EventOrPropagation
ruleEventOrPropagation 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEventOrPropagationAccess().getAlternatives()); }
(rule__EventOrPropagation__Alternatives)
{ after(grammarAccess.getEventOrPropagationAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOutgoingPropagationCondition
entryRuleOutgoingPropagationCondition 
:
{ before(grammarAccess.getOutgoingPropagationConditionRule()); }
	 ruleOutgoingPropagationCondition
{ after(grammarAccess.getOutgoingPropagationConditionRule()); } 
	 EOF 
;

// Rule OutgoingPropagationCondition
ruleOutgoingPropagationCondition 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getGroup()); }
(rule__OutgoingPropagationCondition__Group__0)
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorDetection
entryRuleErrorDetection 
:
{ before(grammarAccess.getErrorDetectionRule()); }
	 ruleErrorDetection
{ after(grammarAccess.getErrorDetectionRule()); } 
	 EOF 
;

// Rule ErrorDetection
ruleErrorDetection 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorDetectionAccess().getGroup()); }
(rule__ErrorDetection__Group__0)
{ after(grammarAccess.getErrorDetectionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorCodeValue
entryRuleErrorCodeValue 
:
{ before(grammarAccess.getErrorCodeValueRule()); }
	 ruleErrorCodeValue
{ after(grammarAccess.getErrorCodeValueRule()); } 
	 EOF 
;

// Rule ErrorCodeValue
ruleErrorCodeValue 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorCodeValueAccess().getAlternatives()); }
(rule__ErrorCodeValue__Alternatives)
{ after(grammarAccess.getErrorCodeValueAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorStateToModeMapping
entryRuleErrorStateToModeMapping 
:
{ before(grammarAccess.getErrorStateToModeMappingRule()); }
	 ruleErrorStateToModeMapping
{ after(grammarAccess.getErrorStateToModeMappingRule()); } 
	 EOF 
;

// Rule ErrorStateToModeMapping
ruleErrorStateToModeMapping 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getGroup()); }
(rule__ErrorStateToModeMapping__Group__0)
{ after(grammarAccess.getErrorStateToModeMappingAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCompositeState
entryRuleCompositeState 
:
{ before(grammarAccess.getCompositeStateRule()); }
	 ruleCompositeState
{ after(grammarAccess.getCompositeStateRule()); } 
	 EOF 
;

// Rule CompositeState
ruleCompositeState 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getCompositeStateAccess().getGroup()); }
(rule__CompositeState__Group__0)
{ after(grammarAccess.getCompositeStateAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSConditionExpression
entryRuleSConditionExpression 
:
{ before(grammarAccess.getSConditionExpressionRule()); }
	 ruleSConditionExpression
{ after(grammarAccess.getSConditionExpressionRule()); } 
	 EOF 
;

// Rule SConditionExpression
ruleSConditionExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getSConditionExpressionAccess().getGroup()); }
(rule__SConditionExpression__Group__0)
{ after(grammarAccess.getSConditionExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSAndExpression
entryRuleSAndExpression 
:
{ before(grammarAccess.getSAndExpressionRule()); }
	 ruleSAndExpression
{ after(grammarAccess.getSAndExpressionRule()); } 
	 EOF 
;

// Rule SAndExpression
ruleSAndExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getSAndExpressionAccess().getGroup()); }
(rule__SAndExpression__Group__0)
{ after(grammarAccess.getSAndExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSOrmoreExpression
entryRuleSOrmoreExpression 
:
{ before(grammarAccess.getSOrmoreExpressionRule()); }
	 ruleSOrmoreExpression
{ after(grammarAccess.getSOrmoreExpressionRule()); } 
	 EOF 
;

// Rule SOrmoreExpression
ruleSOrmoreExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getSOrmoreExpressionAccess().getGroup()); }
(rule__SOrmoreExpression__Group__0)
{ after(grammarAccess.getSOrmoreExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSOrlessExpression
entryRuleSOrlessExpression 
:
{ before(grammarAccess.getSOrlessExpressionRule()); }
	 ruleSOrlessExpression
{ after(grammarAccess.getSOrlessExpressionRule()); } 
	 EOF 
;

// Rule SOrlessExpression
ruleSOrlessExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getSOrlessExpressionAccess().getGroup()); }
(rule__SOrlessExpression__Group__0)
{ after(grammarAccess.getSOrlessExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSAllExpression
entryRuleSAllExpression 
:
{ before(grammarAccess.getSAllExpressionRule()); }
	 ruleSAllExpression
{ after(grammarAccess.getSAllExpressionRule()); } 
	 EOF 
;

// Rule SAllExpression
ruleSAllExpression 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getSAllExpressionAccess().getGroup()); }
(rule__SAllExpression__Group__0)
{ after(grammarAccess.getSAllExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSConditionTerm
entryRuleSConditionTerm 
:
{ before(grammarAccess.getSConditionTermRule()); }
	 ruleSConditionTerm
{ after(grammarAccess.getSConditionTermRule()); } 
	 EOF 
;

// Rule SConditionTerm
ruleSConditionTerm 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getSConditionTermAccess().getAlternatives()); }
(rule__SConditionTerm__Alternatives)
{ after(grammarAccess.getSConditionTermAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleQualifiedErrorPropagation
entryRuleQualifiedErrorPropagation 
:
{ before(grammarAccess.getQualifiedErrorPropagationRule()); }
	 ruleQualifiedErrorPropagation
{ after(grammarAccess.getQualifiedErrorPropagationRule()); } 
	 EOF 
;

// Rule QualifiedErrorPropagation
ruleQualifiedErrorPropagation 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getQualifiedErrorPropagationAccess().getGroup()); }
(rule__QualifiedErrorPropagation__Group__0)
{ after(grammarAccess.getQualifiedErrorPropagationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSConditionElement
entryRuleSConditionElement 
:
{ before(grammarAccess.getSConditionElementRule()); }
	 ruleSConditionElement
{ after(grammarAccess.getSConditionElementRule()); } 
	 EOF 
;

// Rule SConditionElement
ruleSConditionElement 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getSConditionElementAccess().getGroup()); }
(rule__SConditionElement__Group__0)
{ after(grammarAccess.getSConditionElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleQualifiedErrorBehaviorState
entryRuleQualifiedErrorBehaviorState 
:
{ before(grammarAccess.getQualifiedErrorBehaviorStateRule()); }
	 ruleQualifiedErrorBehaviorState
{ after(grammarAccess.getQualifiedErrorBehaviorStateRule()); } 
	 EOF 
;

// Rule QualifiedErrorBehaviorState
ruleQualifiedErrorBehaviorState 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getQualifiedErrorBehaviorStateAccess().getGroup()); }
(rule__QualifiedErrorBehaviorState__Group__0)
{ after(grammarAccess.getQualifiedErrorBehaviorStateAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSubcomponentElement
entryRuleSubcomponentElement 
:
{ before(grammarAccess.getSubcomponentElementRule()); }
	 ruleSubcomponentElement
{ after(grammarAccess.getSubcomponentElementRule()); } 
	 EOF 
;

// Rule SubcomponentElement
ruleSubcomponentElement 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getSubcomponentElementAccess().getSubcomponentAssignment()); }
(rule__SubcomponentElement__SubcomponentAssignment)
{ after(grammarAccess.getSubcomponentElementAccess().getSubcomponentAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleComponentErrorBehaviorKeywords
entryRuleComponentErrorBehaviorKeywords 
:
{ before(grammarAccess.getComponentErrorBehaviorKeywordsRule()); }
	 ruleComponentErrorBehaviorKeywords
{ after(grammarAccess.getComponentErrorBehaviorKeywordsRule()); } 
	 EOF 
;

// Rule ComponentErrorBehaviorKeywords
ruleComponentErrorBehaviorKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getComponentErrorBehaviorKeywordsAccess().getGroup()); }
(rule__ComponentErrorBehaviorKeywords__Group__0)
{ after(grammarAccess.getComponentErrorBehaviorKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCompositeErrorBehaviorKeywords
entryRuleCompositeErrorBehaviorKeywords 
:
{ before(grammarAccess.getCompositeErrorBehaviorKeywordsRule()); }
	 ruleCompositeErrorBehaviorKeywords
{ after(grammarAccess.getCompositeErrorBehaviorKeywordsRule()); } 
	 EOF 
;

// Rule CompositeErrorBehaviorKeywords
ruleCompositeErrorBehaviorKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getCompositeErrorBehaviorKeywordsAccess().getGroup()); }
(rule__CompositeErrorBehaviorKeywords__Group__0)
{ after(grammarAccess.getCompositeErrorBehaviorKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleConnectionErrorKeywords
entryRuleConnectionErrorKeywords 
:
{ before(grammarAccess.getConnectionErrorKeywordsRule()); }
	 ruleConnectionErrorKeywords
{ after(grammarAccess.getConnectionErrorKeywordsRule()); } 
	 EOF 
;

// Rule ConnectionErrorKeywords
ruleConnectionErrorKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getConnectionErrorKeywordsAccess().getGroup()); }
(rule__ConnectionErrorKeywords__Group__0)
{ after(grammarAccess.getConnectionErrorKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEndBehaviorKeywords
entryRuleEndBehaviorKeywords 
:
{ before(grammarAccess.getEndBehaviorKeywordsRule()); }
	 ruleEndBehaviorKeywords
{ after(grammarAccess.getEndBehaviorKeywordsRule()); } 
	 EOF 
;

// Rule EndBehaviorKeywords
ruleEndBehaviorKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEndBehaviorKeywordsAccess().getGroup()); }
(rule__EndBehaviorKeywords__Group__0)
{ after(grammarAccess.getEndBehaviorKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEndComponentKeywords
entryRuleEndComponentKeywords 
:
{ before(grammarAccess.getEndComponentKeywordsRule()); }
	 ruleEndComponentKeywords
{ after(grammarAccess.getEndComponentKeywordsRule()); } 
	 EOF 
;

// Rule EndComponentKeywords
ruleEndComponentKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEndComponentKeywordsAccess().getGroup()); }
(rule__EndComponentKeywords__Group__0)
{ after(grammarAccess.getEndComponentKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEndCompositeKeywords
entryRuleEndCompositeKeywords 
:
{ before(grammarAccess.getEndCompositeKeywordsRule()); }
	 ruleEndCompositeKeywords
{ after(grammarAccess.getEndCompositeKeywordsRule()); } 
	 EOF 
;

// Rule EndCompositeKeywords
ruleEndCompositeKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEndCompositeKeywordsAccess().getGroup()); }
(rule__EndCompositeKeywords__Group__0)
{ after(grammarAccess.getEndCompositeKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEndConnectionKeywords
entryRuleEndConnectionKeywords 
:
{ before(grammarAccess.getEndConnectionKeywordsRule()); }
	 ruleEndConnectionKeywords
{ after(grammarAccess.getEndConnectionKeywordsRule()); } 
	 EOF 
;

// Rule EndConnectionKeywords
ruleEndConnectionKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEndConnectionKeywordsAccess().getGroup()); }
(rule__EndConnectionKeywords__Group__0)
{ after(grammarAccess.getEndConnectionKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEndMappingsKeywords
entryRuleEndMappingsKeywords 
:
{ before(grammarAccess.getEndMappingsKeywordsRule()); }
	 ruleEndMappingsKeywords
{ after(grammarAccess.getEndMappingsKeywordsRule()); } 
	 EOF 
;

// Rule EndMappingsKeywords
ruleEndMappingsKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEndMappingsKeywordsAccess().getGroup()); }
(rule__EndMappingsKeywords__Group__0)
{ after(grammarAccess.getEndMappingsKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEndPathsKeywords
entryRuleEndPathsKeywords 
:
{ before(grammarAccess.getEndPathsKeywordsRule()); }
	 ruleEndPathsKeywords
{ after(grammarAccess.getEndPathsKeywordsRule()); } 
	 EOF 
;

// Rule EndPathsKeywords
ruleEndPathsKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEndPathsKeywordsAccess().getGroup()); }
(rule__EndPathsKeywords__Group__0)
{ after(grammarAccess.getEndPathsKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEndPropagationsKeywords
entryRuleEndPropagationsKeywords 
:
{ before(grammarAccess.getEndPropagationsKeywordsRule()); }
	 ruleEndPropagationsKeywords
{ after(grammarAccess.getEndPropagationsKeywordsRule()); } 
	 EOF 
;

// Rule EndPropagationsKeywords
ruleEndPropagationsKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEndPropagationsKeywordsAccess().getGroup()); }
(rule__EndPropagationsKeywords__Group__0)
{ after(grammarAccess.getEndPropagationsKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEndSubclauseKeywords
entryRuleEndSubclauseKeywords 
:
{ before(grammarAccess.getEndSubclauseKeywordsRule()); }
	 ruleEndSubclauseKeywords
{ after(grammarAccess.getEndSubclauseKeywordsRule()); } 
	 EOF 
;

// Rule EndSubclauseKeywords
ruleEndSubclauseKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEndSubclauseKeywordsAccess().getGroup()); }
(rule__EndSubclauseKeywords__Group__0)
{ after(grammarAccess.getEndSubclauseKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEndTransformationsKeywords
entryRuleEndTransformationsKeywords 
:
{ before(grammarAccess.getEndTransformationsKeywordsRule()); }
	 ruleEndTransformationsKeywords
{ after(grammarAccess.getEndTransformationsKeywordsRule()); } 
	 EOF 
;

// Rule EndTransformationsKeywords
ruleEndTransformationsKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEndTransformationsKeywordsAccess().getGroup()); }
(rule__EndTransformationsKeywords__Group__0)
{ after(grammarAccess.getEndTransformationsKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEndTypesKeywords
entryRuleEndTypesKeywords 
:
{ before(grammarAccess.getEndTypesKeywordsRule()); }
	 ruleEndTypesKeywords
{ after(grammarAccess.getEndTypesKeywordsRule()); } 
	 EOF 
;

// Rule EndTypesKeywords
ruleEndTypesKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getEndTypesKeywordsAccess().getGroup()); }
(rule__EndTypesKeywords__Group__0)
{ after(grammarAccess.getEndTypesKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorBehaviorKeywords
entryRuleErrorBehaviorKeywords 
:
{ before(grammarAccess.getErrorBehaviorKeywordsRule()); }
	 ruleErrorBehaviorKeywords
{ after(grammarAccess.getErrorBehaviorKeywordsRule()); } 
	 EOF 
;

// Rule ErrorBehaviorKeywords
ruleErrorBehaviorKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorBehaviorKeywordsAccess().getGroup()); }
(rule__ErrorBehaviorKeywords__Group__0)
{ after(grammarAccess.getErrorBehaviorKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorEventKeywords
entryRuleErrorEventKeywords 
:
{ before(grammarAccess.getErrorEventKeywordsRule()); }
	 ruleErrorEventKeywords
{ after(grammarAccess.getErrorEventKeywordsRule()); } 
	 EOF 
;

// Rule ErrorEventKeywords
ruleErrorEventKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorEventKeywordsAccess().getGroup()); }
(rule__ErrorEventKeywords__Group__0)
{ after(grammarAccess.getErrorEventKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorPathKeywords
entryRuleErrorPathKeywords 
:
{ before(grammarAccess.getErrorPathKeywordsRule()); }
	 ruleErrorPathKeywords
{ after(grammarAccess.getErrorPathKeywordsRule()); } 
	 EOF 
;

// Rule ErrorPathKeywords
ruleErrorPathKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorPathKeywordsAccess().getGroup()); }
(rule__ErrorPathKeywords__Group__0)
{ after(grammarAccess.getErrorPathKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorPropagationsKeywords
entryRuleErrorPropagationsKeywords 
:
{ before(grammarAccess.getErrorPropagationsKeywordsRule()); }
	 ruleErrorPropagationsKeywords
{ after(grammarAccess.getErrorPropagationsKeywordsRule()); } 
	 EOF 
;

// Rule ErrorPropagationsKeywords
ruleErrorPropagationsKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorPropagationsKeywordsAccess().getGroup()); }
(rule__ErrorPropagationsKeywords__Group__0)
{ after(grammarAccess.getErrorPropagationsKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorSinkKeywords
entryRuleErrorSinkKeywords 
:
{ before(grammarAccess.getErrorSinkKeywordsRule()); }
	 ruleErrorSinkKeywords
{ after(grammarAccess.getErrorSinkKeywordsRule()); } 
	 EOF 
;

// Rule ErrorSinkKeywords
ruleErrorSinkKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorSinkKeywordsAccess().getGroup()); }
(rule__ErrorSinkKeywords__Group__0)
{ after(grammarAccess.getErrorSinkKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorSourceKeywords
entryRuleErrorSourceKeywords 
:
{ before(grammarAccess.getErrorSourceKeywordsRule()); }
	 ruleErrorSourceKeywords
{ after(grammarAccess.getErrorSourceKeywordsRule()); } 
	 EOF 
;

// Rule ErrorSourceKeywords
ruleErrorSourceKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorSourceKeywordsAccess().getGroup()); }
(rule__ErrorSourceKeywords__Group__0)
{ after(grammarAccess.getErrorSourceKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleErrorTypesKeywords
entryRuleErrorTypesKeywords 
:
{ before(grammarAccess.getErrorTypesKeywordsRule()); }
	 ruleErrorTypesKeywords
{ after(grammarAccess.getErrorTypesKeywordsRule()); } 
	 EOF 
;

// Rule ErrorTypesKeywords
ruleErrorTypesKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getErrorTypesKeywordsAccess().getGroup()); }
(rule__ErrorTypesKeywords__Group__0)
{ after(grammarAccess.getErrorTypesKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleModeMappingsKeywords
entryRuleModeMappingsKeywords 
:
{ before(grammarAccess.getModeMappingsKeywordsRule()); }
	 ruleModeMappingsKeywords
{ after(grammarAccess.getModeMappingsKeywordsRule()); } 
	 EOF 
;

// Rule ModeMappingsKeywords
ruleModeMappingsKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getModeMappingsKeywordsAccess().getGroup()); }
(rule__ModeMappingsKeywords__Group__0)
{ after(grammarAccess.getModeMappingsKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePropagationPathsKeywords
entryRulePropagationPathsKeywords 
:
{ before(grammarAccess.getPropagationPathsKeywordsRule()); }
	 rulePropagationPathsKeywords
{ after(grammarAccess.getPropagationPathsKeywordsRule()); } 
	 EOF 
;

// Rule PropagationPathsKeywords
rulePropagationPathsKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getPropagationPathsKeywordsAccess().getGroup()); }
(rule__PropagationPathsKeywords__Group__0)
{ after(grammarAccess.getPropagationPathsKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePropagationPointKeywords
entryRulePropagationPointKeywords 
:
{ before(grammarAccess.getPropagationPointKeywordsRule()); }
	 rulePropagationPointKeywords
{ after(grammarAccess.getPropagationPointKeywordsRule()); } 
	 EOF 
;

// Rule PropagationPointKeywords
rulePropagationPointKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getPropagationPointKeywordsAccess().getGroup()); }
(rule__PropagationPointKeywords__Group__0)
{ after(grammarAccess.getPropagationPointKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRecoverEventKeywords
entryRuleRecoverEventKeywords 
:
{ before(grammarAccess.getRecoverEventKeywordsRule()); }
	 ruleRecoverEventKeywords
{ after(grammarAccess.getRecoverEventKeywordsRule()); } 
	 EOF 
;

// Rule RecoverEventKeywords
ruleRecoverEventKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getRecoverEventKeywordsAccess().getGroup()); }
(rule__RecoverEventKeywords__Group__0)
{ after(grammarAccess.getRecoverEventKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRepairEventKeywords
entryRuleRepairEventKeywords 
:
{ before(grammarAccess.getRepairEventKeywordsRule()); }
	 ruleRepairEventKeywords
{ after(grammarAccess.getRepairEventKeywordsRule()); } 
	 EOF 
;

// Rule RepairEventKeywords
ruleRepairEventKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getRepairEventKeywordsAccess().getGroup()); }
(rule__RepairEventKeywords__Group__0)
{ after(grammarAccess.getRepairEventKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSameStateKeywords
entryRuleSameStateKeywords 
:
{ before(grammarAccess.getSameStateKeywordsRule()); }
	 ruleSameStateKeywords
{ after(grammarAccess.getSameStateKeywordsRule()); } 
	 EOF 
;

// Rule SameStateKeywords
ruleSameStateKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getSameStateKeywordsAccess().getGroup()); }
(rule__SameStateKeywords__Group__0)
{ after(grammarAccess.getSameStateKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeMappingsKeywords
entryRuleTypeMappingsKeywords 
:
{ before(grammarAccess.getTypeMappingsKeywordsRule()); }
	 ruleTypeMappingsKeywords
{ after(grammarAccess.getTypeMappingsKeywordsRule()); } 
	 EOF 
;

// Rule TypeMappingsKeywords
ruleTypeMappingsKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeMappingsKeywordsAccess().getGroup()); }
(rule__TypeMappingsKeywords__Group__0)
{ after(grammarAccess.getTypeMappingsKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeSetKeywords
entryRuleTypeSetKeywords 
:
{ before(grammarAccess.getTypeSetKeywordsRule()); }
	 ruleTypeSetKeywords
{ after(grammarAccess.getTypeSetKeywordsRule()); } 
	 EOF 
;

// Rule TypeSetKeywords
ruleTypeSetKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeSetKeywordsAccess().getGroup()); }
(rule__TypeSetKeywords__Group__0)
{ after(grammarAccess.getTypeSetKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeTransformationsKeywords
entryRuleTypeTransformationsKeywords 
:
{ before(grammarAccess.getTypeTransformationsKeywordsRule()); }
	 ruleTypeTransformationsKeywords
{ after(grammarAccess.getTypeTransformationsKeywordsRule()); } 
	 EOF 
;

// Rule TypeTransformationsKeywords
ruleTypeTransformationsKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getTypeTransformationsKeywordsAccess().getGroup()); }
(rule__TypeTransformationsKeywords__Group__0)
{ after(grammarAccess.getTypeTransformationsKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUseBehaviorKeywords
entryRuleUseBehaviorKeywords 
:
{ before(grammarAccess.getUseBehaviorKeywordsRule()); }
	 ruleUseBehaviorKeywords
{ after(grammarAccess.getUseBehaviorKeywordsRule()); } 
	 EOF 
;

// Rule UseBehaviorKeywords
ruleUseBehaviorKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getUseBehaviorKeywordsAccess().getGroup()); }
(rule__UseBehaviorKeywords__Group__0)
{ after(grammarAccess.getUseBehaviorKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUseMappingsKeywords
entryRuleUseMappingsKeywords 
:
{ before(grammarAccess.getUseMappingsKeywordsRule()); }
	 ruleUseMappingsKeywords
{ after(grammarAccess.getUseMappingsKeywordsRule()); } 
	 EOF 
;

// Rule UseMappingsKeywords
ruleUseMappingsKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getUseMappingsKeywordsAccess().getGroup()); }
(rule__UseMappingsKeywords__Group__0)
{ after(grammarAccess.getUseMappingsKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUseTransformationsKeywords
entryRuleUseTransformationsKeywords 
:
{ before(grammarAccess.getUseTransformationsKeywordsRule()); }
	 ruleUseTransformationsKeywords
{ after(grammarAccess.getUseTransformationsKeywordsRule()); } 
	 EOF 
;

// Rule UseTransformationsKeywords
ruleUseTransformationsKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getUseTransformationsKeywordsAccess().getGroup()); }
(rule__UseTransformationsKeywords__Group__0)
{ after(grammarAccess.getUseTransformationsKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUseTypeEquivalenceKeywords
entryRuleUseTypeEquivalenceKeywords 
:
{ before(grammarAccess.getUseTypeEquivalenceKeywordsRule()); }
	 ruleUseTypeEquivalenceKeywords
{ after(grammarAccess.getUseTypeEquivalenceKeywordsRule()); } 
	 EOF 
;

// Rule UseTypeEquivalenceKeywords
ruleUseTypeEquivalenceKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getUseTypeEquivalenceKeywordsAccess().getGroup()); }
(rule__UseTypeEquivalenceKeywords__Group__0)
{ after(grammarAccess.getUseTypeEquivalenceKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUseTypesKeywords
entryRuleUseTypesKeywords 
:
{ before(grammarAccess.getUseTypesKeywordsRule()); }
	 ruleUseTypesKeywords
{ after(grammarAccess.getUseTypesKeywordsRule()); } 
	 EOF 
;

// Rule UseTypesKeywords
ruleUseTypesKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getUseTypesKeywordsAccess().getGroup()); }
(rule__UseTypesKeywords__Group__0)
{ after(grammarAccess.getUseTypesKeywordsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleQUALIFIEDNAME
entryRuleQUALIFIEDNAME 
:
{ before(grammarAccess.getQUALIFIEDNAMERule()); }
	 ruleQUALIFIEDNAME
{ after(grammarAccess.getQUALIFIEDNAMERule()); } 
	 EOF 
;

// Rule QUALIFIEDNAME
ruleQUALIFIEDNAME 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getQUALIFIEDNAMEAccess().getGroup()); }
(rule__QUALIFIEDNAME__Group__0)
{ after(grammarAccess.getQUALIFIEDNAMEAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleQEMREF
entryRuleQEMREF 
:
{ before(grammarAccess.getQEMREFRule()); }
	 ruleQEMREF
{ after(grammarAccess.getQEMREFRule()); } 
	 EOF 
;

// Rule QEMREF
ruleQEMREF 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getQEMREFAccess().getGroup()); }
(rule__QEMREF__Group__0)
{ after(grammarAccess.getQEMREFAccess().getGroup()); }
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

	Asterisk 

{ after(grammarAccess.getSTARAccess().getAsteriskKeyword()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__EMV2Root__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2RootAccess().getLibraryAssignment_1_0()); }
(rule__EMV2Root__LibraryAssignment_1_0)
{ after(grammarAccess.getEMV2RootAccess().getLibraryAssignment_1_0()); }
)

    |(
{ before(grammarAccess.getEMV2RootAccess().getSubclausesAssignment_1_1()); }
(rule__EMV2Root__SubclausesAssignment_1_1)*
{ after(grammarAccess.getEMV2RootAccess().getSubclausesAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__ErrorModelLibrary__Alternatives_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getTypesAssignment_1_3_0()); }
(rule__ErrorModelLibrary__TypesAssignment_1_3_0)
{ after(grammarAccess.getErrorModelLibraryAccess().getTypesAssignment_1_3_0()); }
)

    |(
{ before(grammarAccess.getErrorModelLibraryAccess().getTypesetsAssignment_1_3_1()); }
(rule__ErrorModelLibrary__TypesetsAssignment_1_3_1)
{ after(grammarAccess.getErrorModelLibraryAccess().getTypesetsAssignment_1_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getGroup_0()); }
(rule__EMV2Library__Group_0__0)
{ after(grammarAccess.getEMV2LibraryAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getEMV2LibraryAccess().getGroup_1()); }
(rule__EMV2Library__Group_1__0)
{ after(grammarAccess.getEMV2LibraryAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Alternatives_0_1_2_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getTypesAssignment_0_1_2_3_0()); }
(rule__EMV2Library__TypesAssignment_0_1_2_3_0)
{ after(grammarAccess.getEMV2LibraryAccess().getTypesAssignment_0_1_2_3_0()); }
)

    |(
{ before(grammarAccess.getEMV2LibraryAccess().getTypesetsAssignment_0_1_2_3_1()); }
(rule__EMV2Library__TypesetsAssignment_0_1_2_3_1)
{ after(grammarAccess.getEMV2LibraryAccess().getTypesetsAssignment_0_1_2_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Alternatives_1_6_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getTypesAssignment_1_6_3_0()); }
(rule__EMV2Library__TypesAssignment_1_6_3_0)
{ after(grammarAccess.getEMV2LibraryAccess().getTypesAssignment_1_6_3_0()); }
)

    |(
{ before(grammarAccess.getEMV2LibraryAccess().getTypesetsAssignment_1_6_3_1()); }
(rule__EMV2Library__TypesetsAssignment_1_6_3_1)
{ after(grammarAccess.getEMV2LibraryAccess().getTypesetsAssignment_1_6_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElementOrKind__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getGroup_0()); }
(rule__EMV2PathElementOrKind__Group_0__0)
{ after(grammarAccess.getEMV2PathElementOrKindAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getGroup_1()); }
(rule__EMV2PathElementOrKind__Group_1__0)
{ after(grammarAccess.getEMV2PathElementOrKindAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorTypes__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorTypesAccess().getTypeDefinitionParserRuleCall_0()); }
	ruleTypeDefinition
{ after(grammarAccess.getErrorTypesAccess().getTypeDefinitionParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getErrorTypesAccess().getTypeSetDefinitionParserRuleCall_1()); }
	ruleTypeSetDefinition
{ after(grammarAccess.getErrorTypesAccess().getTypeSetDefinitionParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getGroup_1_0()); }
(rule__TypeDefinition__Group_1_0__0)
{ after(grammarAccess.getTypeDefinitionAccess().getGroup_1_0()); }
)

    |(
{ before(grammarAccess.getTypeDefinitionAccess().getGroup_1_1()); }
(rule__TypeDefinition__Group_1_1__0)
{ after(grammarAccess.getTypeDefinitionAccess().getGroup_1_1()); }
)

    |(
{ before(grammarAccess.getTypeDefinitionAccess().getGroup_1_2()); }
(rule__TypeDefinition__Group_1_2__0)
{ after(grammarAccess.getTypeDefinitionAccess().getGroup_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getGroup_1_0()); }
(rule__TypeSetDefinition__Group_1_0__0)
{ after(grammarAccess.getTypeSetDefinitionAccess().getGroup_1_0()); }
)

    |(
{ before(grammarAccess.getTypeSetDefinitionAccess().getGroup_1_1()); }
(rule__TypeSetDefinition__Group_1_1__0)
{ after(grammarAccess.getTypeSetDefinitionAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTokenOrNoError__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTokenOrNoErrorAccess().getTypeSetReferenceParserRuleCall_0()); }
	ruleTypeSetReference
{ after(grammarAccess.getTypeTokenOrNoErrorAccess().getTypeSetReferenceParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getTypeTokenOrNoErrorAccess().getNoErrorTypeSetParserRuleCall_1()); }
	ruleNoErrorTypeSet
{ after(grammarAccess.getTypeTokenOrNoErrorAccess().getNoErrorTypeSetParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTokenConstraintNoError__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTokenConstraintNoErrorAccess().getTypeSetReferenceParserRuleCall_0()); }
	ruleTypeSetReference
{ after(grammarAccess.getTypeTokenConstraintNoErrorAccess().getTypeSetReferenceParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getTypeTokenConstraintNoErrorAccess().getNoErrorTypeSetParserRuleCall_1()); }
	ruleNoErrorTypeSet
{ after(grammarAccess.getTypeTokenConstraintNoErrorAccess().getNoErrorTypeSetParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformation__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationAccess().getSourceAssignment_0_0()); }
(rule__TypeTransformation__SourceAssignment_0_0)
{ after(grammarAccess.getTypeTransformationAccess().getSourceAssignment_0_0()); }
)

    |(
{ before(grammarAccess.getTypeTransformationAccess().getAllSourcesAssignment_0_1()); }
(rule__TypeTransformation__AllSourcesAssignment_0_1)
{ after(grammarAccess.getTypeTransformationAccess().getAllSourcesAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagation__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationAccess().getKindAssignment_1_0()); }
(rule__ErrorPropagation__KindAssignment_1_0)
{ after(grammarAccess.getErrorPropagationAccess().getKindAssignment_1_0()); }
)

    |(
{ before(grammarAccess.getErrorPropagationAccess().getFeatureorPPRefAssignment_1_1()); }
(rule__ErrorPropagation__FeatureorPPRefAssignment_1_1)
{ after(grammarAccess.getErrorPropagationAccess().getFeatureorPPRefAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationDirection__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationDirectionAccess().getInKeyword_0()); }

	In 

{ after(grammarAccess.getPropagationDirectionAccess().getInKeyword_0()); }
)

    |(
{ before(grammarAccess.getPropagationDirectionAccess().getOutKeyword_1()); }

	Out 

{ after(grammarAccess.getPropagationDirectionAccess().getOutKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationKind__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationKindAccess().getProcessorKeyword_0()); }

	Processor 

{ after(grammarAccess.getPropagationKindAccess().getProcessorKeyword_0()); }
)

    |(
{ before(grammarAccess.getPropagationKindAccess().getMemoryKeyword_1()); }

	Memory 

{ after(grammarAccess.getPropagationKindAccess().getMemoryKeyword_1()); }
)

    |(
{ before(grammarAccess.getPropagationKindAccess().getConnectionKeyword_2()); }

	Connection 

{ after(grammarAccess.getPropagationKindAccess().getConnectionKeyword_2()); }
)

    |(
{ before(grammarAccess.getPropagationKindAccess().getBindingKeyword_3()); }

	Binding 

{ after(grammarAccess.getPropagationKindAccess().getBindingKeyword_3()); }
)

    |(
{ before(grammarAccess.getPropagationKindAccess().getBindingsKeyword_4()); }

	Bindings 

{ after(grammarAccess.getPropagationKindAccess().getBindingsKeyword_4()); }
)

    |(
{ before(grammarAccess.getPropagationKindAccess().getAccessKeyword_5()); }

	Access 

{ after(grammarAccess.getPropagationKindAccess().getAccessKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorFlow__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorFlowAccess().getErrorSourceParserRuleCall_0()); }
	ruleErrorSource
{ after(grammarAccess.getErrorFlowAccess().getErrorSourceParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getErrorFlowAccess().getErrorSinkParserRuleCall_1()); }
	ruleErrorSink
{ after(grammarAccess.getErrorFlowAccess().getErrorSinkParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getErrorFlowAccess().getErrorPathParserRuleCall_2()); }
	ruleErrorPath
{ after(grammarAccess.getErrorFlowAccess().getErrorPathParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Alternatives_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getSourceModelElementAssignment_3_0()); }
(rule__ErrorSource__SourceModelElementAssignment_3_0)
{ after(grammarAccess.getErrorSourceAccess().getSourceModelElementAssignment_3_0()); }
)

    |(
{ before(grammarAccess.getErrorSourceAccess().getAllAssignment_3_1()); }
(rule__ErrorSource__AllAssignment_3_1)
{ after(grammarAccess.getErrorSourceAccess().getAllAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Alternatives_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getGroup_5_1_0()); }
(rule__ErrorSource__Group_5_1_0__0)
{ after(grammarAccess.getErrorSourceAccess().getGroup_5_1_0()); }
)

    |(
{ before(grammarAccess.getErrorSourceAccess().getFailureModeTypeAssignment_5_1_1()); }
(rule__ErrorSource__FailureModeTypeAssignment_5_1_1)
{ after(grammarAccess.getErrorSourceAccess().getFailureModeTypeAssignment_5_1_1()); }
)

    |(
{ before(grammarAccess.getErrorSourceAccess().getFailureModeDescriptionAssignment_5_1_2()); }
(rule__ErrorSource__FailureModeDescriptionAssignment_5_1_2)
{ after(grammarAccess.getErrorSourceAccess().getFailureModeDescriptionAssignment_5_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSink__Alternatives_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkAccess().getIncomingAssignment_3_0()); }
(rule__ErrorSink__IncomingAssignment_3_0)
{ after(grammarAccess.getErrorSinkAccess().getIncomingAssignment_3_0()); }
)

    |(
{ before(grammarAccess.getErrorSinkAccess().getAllIncomingAssignment_3_1()); }
(rule__ErrorSink__AllIncomingAssignment_3_1)
{ after(grammarAccess.getErrorSinkAccess().getAllIncomingAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Alternatives_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getIncomingAssignment_3_0()); }
(rule__ErrorPath__IncomingAssignment_3_0)
{ after(grammarAccess.getErrorPathAccess().getIncomingAssignment_3_0()); }
)

    |(
{ before(grammarAccess.getErrorPathAccess().getAllIncomingAssignment_3_1()); }
(rule__ErrorPath__AllIncomingAssignment_3_1)
{ after(grammarAccess.getErrorPathAccess().getAllIncomingAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Alternatives_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getOutgoingAssignment_6_0()); }
(rule__ErrorPath__OutgoingAssignment_6_0)
{ after(grammarAccess.getErrorPathAccess().getOutgoingAssignment_6_0()); }
)

    |(
{ before(grammarAccess.getErrorPathAccess().getAllOutgoingAssignment_6_1()); }
(rule__ErrorPath__AllOutgoingAssignment_6_1)
{ after(grammarAccess.getErrorPathAccess().getAllOutgoingAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Alternatives_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getTargetTokenAssignment_7_0()); }
(rule__ErrorPath__TargetTokenAssignment_7_0)
{ after(grammarAccess.getErrorPathAccess().getTargetTokenAssignment_7_0()); }
)

    |(
{ before(grammarAccess.getErrorPathAccess().getGroup_7_1()); }
(rule__ErrorPath__Group_7_1__0)
{ after(grammarAccess.getErrorPathAccess().getGroup_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IfCondition__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfConditionAccess().getDescriptionAssignment_0()); }
(rule__IfCondition__DescriptionAssignment_0)
{ after(grammarAccess.getIfConditionAccess().getDescriptionAssignment_0()); }
)

    |(
{ before(grammarAccess.getIfConditionAccess().getResoluteFunctionAssignment_1()); }
(rule__IfCondition__ResoluteFunctionAssignment_1)
{ after(grammarAccess.getIfConditionAccess().getResoluteFunctionAssignment_1()); }
)

    |(
{ before(grammarAccess.getIfConditionAccess().getJavaMethodAssignment_2()); }
(rule__IfCondition__JavaMethodAssignment_2)
{ after(grammarAccess.getIfConditionAccess().getJavaMethodAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagationPoint__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationPointAccess().getPropagationKindParserRuleCall_1_0()); }
	rulePropagationKind
{ after(grammarAccess.getErrorPropagationPointAccess().getPropagationKindParserRuleCall_1_0()); }
)

    |(
{ before(grammarAccess.getErrorPropagationPointAccess().getIDTerminalRuleCall_1_1()); }
	RULE_ID
{ after(grammarAccess.getErrorPropagationPointAccess().getIDTerminalRuleCall_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPropagationPoint__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPropagationPointAccess().getGroup_0()); }
(rule__QualifiedPropagationPoint__Group_0__0)
{ after(grammarAccess.getQualifiedPropagationPointAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getQualifiedPropagationPointAccess().getPropagationPointAssignment_1()); }
(rule__QualifiedPropagationPoint__PropagationPointAssignment_1)
{ after(grammarAccess.getQualifiedPropagationPointAccess().getPropagationPointAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorEvent__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorEventAccess().getErrorEventParserRuleCall_0()); }
	ruleErrorEvent
{ after(grammarAccess.getErrorBehaviorEventAccess().getErrorEventParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getErrorBehaviorEventAccess().getRepairEventParserRuleCall_1()); }
	ruleRepairEvent
{ after(grammarAccess.getErrorBehaviorEventAccess().getRepairEventParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getErrorBehaviorEventAccess().getRecoverEventParserRuleCall_2()); }
	ruleRecoverEvent
{ after(grammarAccess.getErrorBehaviorEventAccess().getRecoverEventParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_1_0()); }
(rule__ErrorBehaviorTransition__Group_1_0__0)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_1_0()); }
)

    |(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getAllStatesAssignment_1_1()); }
(rule__ErrorBehaviorTransition__AllStatesAssignment_1_1)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getAllStatesAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Alternatives_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_5_0()); }
(rule__ErrorBehaviorTransition__Group_5_0__0)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_5_0()); }
)

    |(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getSteadyStateAssignment_5_1()); }
(rule__ErrorBehaviorTransition__SteadyStateAssignment_5_1)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getSteadyStateAssignment_5_1()); }
)

    |(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_5_2()); }
(rule__ErrorBehaviorTransition__Group_5_2__0)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionBranch__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionBranchAccess().getGroup_0_0()); }
(rule__TransitionBranch__Group_0_0__0)
{ after(grammarAccess.getTransitionBranchAccess().getGroup_0_0()); }
)

    |(
{ before(grammarAccess.getTransitionBranchAccess().getSteadyStateAssignment_0_1()); }
(rule__TransitionBranch__SteadyStateAssignment_0_1)
{ after(grammarAccess.getTransitionBranchAccess().getSteadyStateAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BranchValue__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBranchValueAccess().getRealvalueAssignment_1_0()); }
(rule__BranchValue__RealvalueAssignment_1_0)
{ after(grammarAccess.getBranchValueAccess().getRealvalueAssignment_1_0()); }
)

    |(
{ before(grammarAccess.getBranchValueAccess().getSymboliclabelAssignment_1_1()); }
(rule__BranchValue__SymboliclabelAssignment_1_1)
{ after(grammarAccess.getBranchValueAccess().getSymboliclabelAssignment_1_1()); }
)

    |(
{ before(grammarAccess.getBranchValueAccess().getOthersAssignment_1_2()); }
(rule__BranchValue__OthersAssignment_1_2)
{ after(grammarAccess.getBranchValueAccess().getOthersAssignment_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionTerm__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConditionTermAccess().getConditionElementParserRuleCall_0()); }
	ruleConditionElement
{ after(grammarAccess.getConditionTermAccess().getConditionElementParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getConditionTermAccess().getOrmoreExpressionParserRuleCall_1()); }
	ruleOrmoreExpression
{ after(grammarAccess.getConditionTermAccess().getOrmoreExpressionParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getConditionTermAccess().getOrlessExpressionParserRuleCall_2()); }
	ruleOrlessExpression
{ after(grammarAccess.getConditionTermAccess().getOrlessExpressionParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getConditionTermAccess().getAllExpressionParserRuleCall_3()); }
	ruleAllExpression
{ after(grammarAccess.getConditionTermAccess().getAllExpressionParserRuleCall_3()); }
)

    |(
{ before(grammarAccess.getConditionTermAccess().getGroup_4()); }
(rule__ConditionTerm__Group_4__0)
{ after(grammarAccess.getConditionTermAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2ErrorPropagationPath__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2ErrorPropagationPathAccess().getEmv2PropagationKindAssignment_0()); }
(rule__EMV2ErrorPropagationPath__Emv2PropagationKindAssignment_0)
{ after(grammarAccess.getEMV2ErrorPropagationPathAccess().getEmv2PropagationKindAssignment_0()); }
)

    |(
{ before(grammarAccess.getEMV2ErrorPropagationPathAccess().getGroup_1()); }
(rule__EMV2ErrorPropagationPath__Group_1__0)
{ after(grammarAccess.getEMV2ErrorPropagationPathAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EventOrPropagation__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEventOrPropagationAccess().getErrorBehaviorEventParserRuleCall_0()); }
	ruleErrorBehaviorEvent
{ after(grammarAccess.getEventOrPropagationAccess().getErrorBehaviorEventParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getEventOrPropagationAccess().getErrorPropagationParserRuleCall_1()); }
	ruleErrorPropagation
{ after(grammarAccess.getEventOrPropagationAccess().getErrorPropagationParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getGroup_1_0()); }
(rule__OutgoingPropagationCondition__Group_1_0__0)
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getGroup_1_0()); }
)

    |(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getAllStatesAssignment_1_1()); }
(rule__OutgoingPropagationCondition__AllStatesAssignment_1_1)
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getAllStatesAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__Alternatives_5_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getOutgoingAssignment_5_0_0()); }
(rule__OutgoingPropagationCondition__OutgoingAssignment_5_0_0)
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getOutgoingAssignment_5_0_0()); }
)

    |(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getAllPropagationsAssignment_5_0_1()); }
(rule__OutgoingPropagationCondition__AllPropagationsAssignment_5_0_1)
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getAllPropagationsAssignment_5_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getGroup_1_0()); }
(rule__ErrorDetection__Group_1_0__0)
{ after(grammarAccess.getErrorDetectionAccess().getGroup_1_0()); }
)

    |(
{ before(grammarAccess.getErrorDetectionAccess().getAllStatesAssignment_1_1()); }
(rule__ErrorDetection__AllStatesAssignment_1_1)
{ after(grammarAccess.getErrorDetectionAccess().getAllStatesAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorCodeValue__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorCodeValueAccess().getIntValueAssignment_0()); }
(rule__ErrorCodeValue__IntValueAssignment_0)
{ after(grammarAccess.getErrorCodeValueAccess().getIntValueAssignment_0()); }
)

    |(
{ before(grammarAccess.getErrorCodeValueAccess().getConstantAssignment_1()); }
(rule__ErrorCodeValue__ConstantAssignment_1)
{ after(grammarAccess.getErrorCodeValueAccess().getConstantAssignment_1()); }
)

    |(
{ before(grammarAccess.getErrorCodeValueAccess().getEnumLiteralAssignment_2()); }
(rule__ErrorCodeValue__EnumLiteralAssignment_2)
{ after(grammarAccess.getErrorCodeValueAccess().getEnumLiteralAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeState__Alternatives_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeStateAccess().getConditionAssignment_2_0()); }
(rule__CompositeState__ConditionAssignment_2_0)
{ after(grammarAccess.getCompositeStateAccess().getConditionAssignment_2_0()); }
)

    |(
{ before(grammarAccess.getCompositeStateAccess().getOthersAssignment_2_1()); }
(rule__CompositeState__OthersAssignment_2_1)
{ after(grammarAccess.getCompositeStateAccess().getOthersAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionTerm__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionTermAccess().getSConditionElementParserRuleCall_0()); }
	ruleSConditionElement
{ after(grammarAccess.getSConditionTermAccess().getSConditionElementParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getSConditionTermAccess().getSOrmoreExpressionParserRuleCall_1()); }
	ruleSOrmoreExpression
{ after(grammarAccess.getSConditionTermAccess().getSOrmoreExpressionParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getSConditionTermAccess().getSOrlessExpressionParserRuleCall_2()); }
	ruleSOrlessExpression
{ after(grammarAccess.getSConditionTermAccess().getSOrlessExpressionParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getSConditionTermAccess().getSAllExpressionParserRuleCall_3()); }
	ruleSAllExpression
{ after(grammarAccess.getSConditionTermAccess().getSAllExpressionParserRuleCall_3()); }
)

    |(
{ before(grammarAccess.getSConditionTermAccess().getGroup_4()); }
(rule__SConditionTerm__Group_4__0)
{ after(grammarAccess.getSConditionTermAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionElement__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionElementAccess().getGroup_1_0()); }
(rule__SConditionElement__Group_1_0__0)
{ after(grammarAccess.getSConditionElementAccess().getGroup_1_0()); }
)

    |(
{ before(grammarAccess.getSConditionElementAccess().getGroup_1_1()); }
(rule__SConditionElement__Group_1_1__0)
{ after(grammarAccess.getSConditionElementAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedErrorBehaviorState__Alternatives_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedErrorBehaviorStateAccess().getNextAssignment_2_0()); }
(rule__QualifiedErrorBehaviorState__NextAssignment_2_0)
{ after(grammarAccess.getQualifiedErrorBehaviorStateAccess().getNextAssignment_2_0()); }
)

    |(
{ before(grammarAccess.getQualifiedErrorBehaviorStateAccess().getStateAssignment_2_1()); }
(rule__QualifiedErrorBehaviorState__StateAssignment_2_1)
{ after(grammarAccess.getQualifiedErrorBehaviorStateAccess().getStateAssignment_2_1()); }
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

	EqualsSignGreaterThanSign 

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
{ before(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_2()); }
	ruleComponentClassifierTerm
{ after(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_3()); }
	ruleComputedTerm
{ after(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_3()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_4()); }
	ruleStringTerm
{ after(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_4()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_5()); }
	ruleNumericRangeTerm
{ after(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_5()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_6()); }
	ruleRealTerm
{ after(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_6()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_7()); }
	ruleIntegerTerm
{ after(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_7()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_8()); }
	ruleListTerm
{ after(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_8()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_9()); }
	ruleBooleanLiteral
{ after(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_9()); }
)

    |(
{ before(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_10()); }
	ruleLiteralorReferenceTerm
{ after(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_10()); }
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

	False 

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

	PlusSign 

{ after(grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); }
)

    |(
{ before(grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1()); }

	HyphenMinus 

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

	PlusSign 

{ after(grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); }
)

    |(
{ before(grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1()); }

	HyphenMinus 

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

	PlusSign 

{ after(grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); }
)

    |(
{ before(grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1()); }

	HyphenMinus 

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



rule__EMV2Root__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Root__Group__0__Impl
	rule__EMV2Root__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Root__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2RootAccess().getEMV2RootAction_0()); }
(

)
{ after(grammarAccess.getEMV2RootAccess().getEMV2RootAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Root__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Root__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Root__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2RootAccess().getAlternatives_1()); }
(rule__EMV2Root__Alternatives_1)
{ after(grammarAccess.getEMV2RootAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorModelSubclause__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group__0__Impl
	rule__ErrorModelSubclause__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getErrorModelSubclauseAction_0()); }
(

)
{ after(grammarAccess.getErrorModelSubclauseAccess().getErrorModelSubclauseAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group__1__Impl
	rule__ErrorModelSubclause__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_1()); }
(rule__ErrorModelSubclause__Group_1__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group__2__Impl
	rule__ErrorModelSubclause__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_2()); }
(rule__ErrorModelSubclause__Group_2__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group__3__Impl
	rule__ErrorModelSubclause__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_3()); }
(rule__ErrorModelSubclause__Group_3__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group__4__Impl
	rule__ErrorModelSubclause__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_4()); }
(rule__ErrorModelSubclause__Group_4__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group__5__Impl
	rule__ErrorModelSubclause__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_5()); }
(rule__ErrorModelSubclause__Group_5__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group__6__Impl
	rule__ErrorModelSubclause__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_6()); }
(rule__ErrorModelSubclause__Group_6__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group__7__Impl
	rule__ErrorModelSubclause__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_7()); }
(rule__ErrorModelSubclause__Group_7__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group__8__Impl
	rule__ErrorModelSubclause__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_8()); }
(rule__ErrorModelSubclause__Group_8__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group__9__Impl
	rule__ErrorModelSubclause__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_9()); }
(rule__ErrorModelSubclause__Group_9__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group__10__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_10()); }
(rule__ErrorModelSubclause__Group_10__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}
























rule__ErrorModelSubclause__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_1__0__Impl
	rule__ErrorModelSubclause__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseTypesKeywordsParserRuleCall_1_0()); }
	ruleUseTypesKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getUseTypesKeywordsParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_1__1__Impl
	rule__ErrorModelSubclause__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseTypesAssignment_1_1()); }
(rule__ErrorModelSubclause__UseTypesAssignment_1_1)
{ after(grammarAccess.getErrorModelSubclauseAccess().getUseTypesAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_1__2__Impl
	rule__ErrorModelSubclause__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_1_2()); }
(rule__ErrorModelSubclause__Group_1_2__0)*
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_1_3()); }

	Semicolon 

{ after(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ErrorModelSubclause__Group_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_1_2__0__Impl
	rule__ErrorModelSubclause__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getCommaKeyword_1_2_0()); }

	Comma 

{ after(grammarAccess.getErrorModelSubclauseAccess().getCommaKeyword_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseTypesAssignment_1_2_1()); }
(rule__ErrorModelSubclause__UseTypesAssignment_1_2_1)
{ after(grammarAccess.getErrorModelSubclauseAccess().getUseTypesAssignment_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorModelSubclause__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_2__0__Impl
	rule__ErrorModelSubclause__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseTypeEquivalenceKeywordsParserRuleCall_2_0()); }
	ruleUseTypeEquivalenceKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getUseTypeEquivalenceKeywordsParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_2__1__Impl
	rule__ErrorModelSubclause__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getTypeEquivalenceAssignment_2_1()); }
(rule__ErrorModelSubclause__TypeEquivalenceAssignment_2_1)
{ after(grammarAccess.getErrorModelSubclauseAccess().getTypeEquivalenceAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_2_2()); }

	Semicolon 

{ after(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ErrorModelSubclause__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_3__0__Impl
	rule__ErrorModelSubclause__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseMappingsKeywordsParserRuleCall_3_0()); }
	ruleUseMappingsKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getUseMappingsKeywordsParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_3__1__Impl
	rule__ErrorModelSubclause__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getTypeMappingSetAssignment_3_1()); }
(rule__ErrorModelSubclause__TypeMappingSetAssignment_3_1)
{ after(grammarAccess.getErrorModelSubclauseAccess().getTypeMappingSetAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_3_2()); }

	Semicolon 

{ after(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ErrorModelSubclause__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_4__0__Impl
	rule__ErrorModelSubclause__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseBehaviorKeywordsParserRuleCall_4_0()); }
	ruleUseBehaviorKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getUseBehaviorKeywordsParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_4__1__Impl
	rule__ErrorModelSubclause__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseBehaviorAssignment_4_1()); }
(rule__ErrorModelSubclause__UseBehaviorAssignment_4_1)
{ after(grammarAccess.getErrorModelSubclauseAccess().getUseBehaviorAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_4_2()); }

	Semicolon 

{ after(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ErrorModelSubclause__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_5__0__Impl
	rule__ErrorModelSubclause__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getErrorPropagationsKeywordsParserRuleCall_5_0()); }
	ruleErrorPropagationsKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getErrorPropagationsKeywordsParserRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_5__1__Impl
	rule__ErrorModelSubclause__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getPropagationsAssignment_5_1()); }
(rule__ErrorModelSubclause__PropagationsAssignment_5_1)*
{ after(grammarAccess.getErrorModelSubclauseAccess().getPropagationsAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_5__2__Impl
	rule__ErrorModelSubclause__Group_5__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_5_2()); }
(rule__ErrorModelSubclause__Group_5_2__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_5__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_5__3__Impl
	rule__ErrorModelSubclause__Group_5__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_5__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getEndPropagationsKeywordsParserRuleCall_5_3()); }
	ruleEndPropagationsKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getEndPropagationsKeywordsParserRuleCall_5_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_5__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_5__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_5__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_5_4()); }

	Semicolon 

{ after(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_5_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__ErrorModelSubclause__Group_5_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_5_2__0__Impl
	rule__ErrorModelSubclause__Group_5_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_5_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getFlowsKeyword_5_2_0()); }

	Flows 

{ after(grammarAccess.getErrorModelSubclauseAccess().getFlowsKeyword_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_5_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_5_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_5_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getFlowsAssignment_5_2_1()); }
(rule__ErrorModelSubclause__FlowsAssignment_5_2_1)
{ after(grammarAccess.getErrorModelSubclauseAccess().getFlowsAssignment_5_2_1()); }
)
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getFlowsAssignment_5_2_1()); }
(rule__ErrorModelSubclause__FlowsAssignment_5_2_1)*
{ after(grammarAccess.getErrorModelSubclauseAccess().getFlowsAssignment_5_2_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorModelSubclause__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6__0__Impl
	rule__ErrorModelSubclause__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getComponentErrorBehaviorKeywordsParserRuleCall_6_0()); }
	ruleComponentErrorBehaviorKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getComponentErrorBehaviorKeywordsParserRuleCall_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6__1__Impl
	rule__ErrorModelSubclause__Group_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_1()); }
(rule__ErrorModelSubclause__Group_6_1__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_6__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6__2__Impl
	rule__ErrorModelSubclause__Group_6__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_2()); }
(rule__ErrorModelSubclause__Group_6_2__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_6__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6__3__Impl
	rule__ErrorModelSubclause__Group_6__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_3()); }
(rule__ErrorModelSubclause__Group_6_3__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_6__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6__4__Impl
	rule__ErrorModelSubclause__Group_6__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_4()); }
(rule__ErrorModelSubclause__Group_6_4__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_6__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6__5__Impl
	rule__ErrorModelSubclause__Group_6__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_5()); }
(rule__ErrorModelSubclause__Group_6_5__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_6__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6__6__Impl
	rule__ErrorModelSubclause__Group_6__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_6()); }
(rule__ErrorModelSubclause__Group_6_6__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_6__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6__7__Impl
	rule__ErrorModelSubclause__Group_6__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getEndComponentKeywordsParserRuleCall_6_7()); }
	ruleEndComponentKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getEndComponentKeywordsParserRuleCall_6_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_6__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_6_8()); }

	Semicolon 

{ after(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_6_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}




















rule__ErrorModelSubclause__Group_6_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6_1__0__Impl
	rule__ErrorModelSubclause__Group_6_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseTransformationsKeywordsParserRuleCall_6_1_0()); }
	ruleUseTransformationsKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getUseTransformationsKeywordsParserRuleCall_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_6_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6_1__1__Impl
	rule__ErrorModelSubclause__Group_6_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseTransformationAssignment_6_1_1()); }
(rule__ErrorModelSubclause__UseTransformationAssignment_6_1_1)
{ after(grammarAccess.getErrorModelSubclauseAccess().getUseTransformationAssignment_6_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_6_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_6_1_2()); }

	Semicolon 

{ after(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_6_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ErrorModelSubclause__Group_6_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6_2__0__Impl
	rule__ErrorModelSubclause__Group_6_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getEventsKeyword_6_2_0()); }

	Events 

{ after(grammarAccess.getErrorModelSubclauseAccess().getEventsKeyword_6_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_6_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getEventsAssignment_6_2_1()); }
(rule__ErrorModelSubclause__EventsAssignment_6_2_1)
{ after(grammarAccess.getErrorModelSubclauseAccess().getEventsAssignment_6_2_1()); }
)
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getEventsAssignment_6_2_1()); }
(rule__ErrorModelSubclause__EventsAssignment_6_2_1)*
{ after(grammarAccess.getErrorModelSubclauseAccess().getEventsAssignment_6_2_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorModelSubclause__Group_6_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6_3__0__Impl
	rule__ErrorModelSubclause__Group_6_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getTransitionsKeyword_6_3_0()); }

	Transitions 

{ after(grammarAccess.getErrorModelSubclauseAccess().getTransitionsKeyword_6_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_6_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getTransitionsAssignment_6_3_1()); }
(rule__ErrorModelSubclause__TransitionsAssignment_6_3_1)
{ after(grammarAccess.getErrorModelSubclauseAccess().getTransitionsAssignment_6_3_1()); }
)
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getTransitionsAssignment_6_3_1()); }
(rule__ErrorModelSubclause__TransitionsAssignment_6_3_1)*
{ after(grammarAccess.getErrorModelSubclauseAccess().getTransitionsAssignment_6_3_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorModelSubclause__Group_6_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6_4__0__Impl
	rule__ErrorModelSubclause__Group_6_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getPropagationsKeyword_6_4_0()); }

	Propagations 

{ after(grammarAccess.getErrorModelSubclauseAccess().getPropagationsKeyword_6_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_6_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getOutgoingPropagationConditionsAssignment_6_4_1()); }
(rule__ErrorModelSubclause__OutgoingPropagationConditionsAssignment_6_4_1)
{ after(grammarAccess.getErrorModelSubclauseAccess().getOutgoingPropagationConditionsAssignment_6_4_1()); }
)
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getOutgoingPropagationConditionsAssignment_6_4_1()); }
(rule__ErrorModelSubclause__OutgoingPropagationConditionsAssignment_6_4_1)*
{ after(grammarAccess.getErrorModelSubclauseAccess().getOutgoingPropagationConditionsAssignment_6_4_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorModelSubclause__Group_6_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6_5__0__Impl
	rule__ErrorModelSubclause__Group_6_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getDetectionsKeyword_6_5_0()); }

	Detections 

{ after(grammarAccess.getErrorModelSubclauseAccess().getDetectionsKeyword_6_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_6_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getErrorDetectionsAssignment_6_5_1()); }
(rule__ErrorModelSubclause__ErrorDetectionsAssignment_6_5_1)
{ after(grammarAccess.getErrorModelSubclauseAccess().getErrorDetectionsAssignment_6_5_1()); }
)
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getErrorDetectionsAssignment_6_5_1()); }
(rule__ErrorModelSubclause__ErrorDetectionsAssignment_6_5_1)*
{ after(grammarAccess.getErrorModelSubclauseAccess().getErrorDetectionsAssignment_6_5_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorModelSubclause__Group_6_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6_6__0__Impl
	rule__ErrorModelSubclause__Group_6_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getModeMappingsKeywordsParserRuleCall_6_6_0()); }
	ruleModeMappingsKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getModeMappingsKeywordsParserRuleCall_6_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_6_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_6_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_6_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getErrorStateToModeMappingsAssignment_6_6_1()); }
(rule__ErrorModelSubclause__ErrorStateToModeMappingsAssignment_6_6_1)
{ after(grammarAccess.getErrorModelSubclauseAccess().getErrorStateToModeMappingsAssignment_6_6_1()); }
)
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getErrorStateToModeMappingsAssignment_6_6_1()); }
(rule__ErrorModelSubclause__ErrorStateToModeMappingsAssignment_6_6_1)*
{ after(grammarAccess.getErrorModelSubclauseAccess().getErrorStateToModeMappingsAssignment_6_6_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorModelSubclause__Group_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_7__0__Impl
	rule__ErrorModelSubclause__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getCompositeErrorBehaviorKeywordsParserRuleCall_7_0()); }
	ruleCompositeErrorBehaviorKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getCompositeErrorBehaviorKeywordsParserRuleCall_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_7__1__Impl
	rule__ErrorModelSubclause__Group_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_7_1()); }
(rule__ErrorModelSubclause__Group_7_1__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_7__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_7__2__Impl
	rule__ErrorModelSubclause__Group_7__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_7__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getEndCompositeKeywordsParserRuleCall_7_2()); }
	ruleEndCompositeKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getEndCompositeKeywordsParserRuleCall_7_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_7__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_7__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_7__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_7_3()); }

	Semicolon 

{ after(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_7_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ErrorModelSubclause__Group_7_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_7_1__0__Impl
	rule__ErrorModelSubclause__Group_7_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_7_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getStatesKeyword_7_1_0()); }

	States 

{ after(grammarAccess.getErrorModelSubclauseAccess().getStatesKeyword_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_7_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_7_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_7_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getStatesAssignment_7_1_1()); }
(rule__ErrorModelSubclause__StatesAssignment_7_1_1)
{ after(grammarAccess.getErrorModelSubclauseAccess().getStatesAssignment_7_1_1()); }
)
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getStatesAssignment_7_1_1()); }
(rule__ErrorModelSubclause__StatesAssignment_7_1_1)*
{ after(grammarAccess.getErrorModelSubclauseAccess().getStatesAssignment_7_1_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorModelSubclause__Group_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_8__0__Impl
	rule__ErrorModelSubclause__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getConnectionErrorKeywordsParserRuleCall_8_0()); }
	ruleConnectionErrorKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getConnectionErrorKeywordsParserRuleCall_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_8__1__Impl
	rule__ErrorModelSubclause__Group_8__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getGroup_8_1()); }
(rule__ErrorModelSubclause__Group_8_1__0)?
{ after(grammarAccess.getErrorModelSubclauseAccess().getGroup_8_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_8__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_8__2__Impl
	rule__ErrorModelSubclause__Group_8__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_8__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getConnectionErrorSourcesAssignment_8_2()); }
(rule__ErrorModelSubclause__ConnectionErrorSourcesAssignment_8_2)*
{ after(grammarAccess.getErrorModelSubclauseAccess().getConnectionErrorSourcesAssignment_8_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_8__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_8__3__Impl
	rule__ErrorModelSubclause__Group_8__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_8__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getEndConnectionKeywordsParserRuleCall_8_3()); }
	ruleEndConnectionKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getEndConnectionKeywordsParserRuleCall_8_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_8__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_8__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_8__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_8_4()); }

	Semicolon 

{ after(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_8_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__ErrorModelSubclause__Group_8_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_8_1__0__Impl
	rule__ErrorModelSubclause__Group_8_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_8_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseTransformationsKeywordsParserRuleCall_8_1_0()); }
	ruleUseTransformationsKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getUseTransformationsKeywordsParserRuleCall_8_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_8_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_8_1__1__Impl
	rule__ErrorModelSubclause__Group_8_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_8_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getTypeTransformationSetAssignment_8_1_1()); }
(rule__ErrorModelSubclause__TypeTransformationSetAssignment_8_1_1)
{ after(grammarAccess.getErrorModelSubclauseAccess().getTypeTransformationSetAssignment_8_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_8_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_8_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_8_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_8_1_2()); }

	Semicolon 

{ after(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_8_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ErrorModelSubclause__Group_9__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_9__0__Impl
	rule__ErrorModelSubclause__Group_9__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_9__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getPropagationPathsKeywordsParserRuleCall_9_0()); }
	rulePropagationPathsKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getPropagationPathsKeywordsParserRuleCall_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_9__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_9__1__Impl
	rule__ErrorModelSubclause__Group_9__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_9__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getPointsAssignment_9_1()); }
(rule__ErrorModelSubclause__PointsAssignment_9_1)*
{ after(grammarAccess.getErrorModelSubclauseAccess().getPointsAssignment_9_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_9__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_9__2__Impl
	rule__ErrorModelSubclause__Group_9__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_9__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getPathsAssignment_9_2()); }
(rule__ErrorModelSubclause__PathsAssignment_9_2)*
{ after(grammarAccess.getErrorModelSubclauseAccess().getPathsAssignment_9_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_9__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_9__3__Impl
	rule__ErrorModelSubclause__Group_9__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_9__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getEndPathsKeywordsParserRuleCall_9_3()); }
	ruleEndPathsKeywords
{ after(grammarAccess.getErrorModelSubclauseAccess().getEndPathsKeywordsParserRuleCall_9_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_9__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_9__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_9__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_9_4()); }

	Semicolon 

{ after(grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_9_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__ErrorModelSubclause__Group_10__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_10__0__Impl
	rule__ErrorModelSubclause__Group_10__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_10__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getPropertiesKeyword_10_0()); }

	Properties 

{ after(grammarAccess.getErrorModelSubclauseAccess().getPropertiesKeyword_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelSubclause__Group_10__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelSubclause__Group_10__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__Group_10__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getPropertiesAssignment_10_1()); }
(rule__ErrorModelSubclause__PropertiesAssignment_10_1)
{ after(grammarAccess.getErrorModelSubclauseAccess().getPropertiesAssignment_10_1()); }
)
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getPropertiesAssignment_10_1()); }
(rule__ErrorModelSubclause__PropertiesAssignment_10_1)*
{ after(grammarAccess.getErrorModelSubclauseAccess().getPropertiesAssignment_10_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Subclause__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group__0__Impl
	rule__EMV2Subclause__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getErrorModelSubclauseAction_0()); }
(

)
{ after(grammarAccess.getEMV2SubclauseAccess().getErrorModelSubclauseAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group__1__Impl
	rule__EMV2Subclause__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getSubclauseKeyword_1()); }

	Subclause 

{ after(grammarAccess.getEMV2SubclauseAccess().getSubclauseKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group__2__Impl
	rule__EMV2Subclause__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getNameAssignment_2()); }
(rule__EMV2Subclause__NameAssignment_2)
{ after(grammarAccess.getEMV2SubclauseAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group__3__Impl
	rule__EMV2Subclause__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_3()); }
(rule__EMV2Subclause__Group_3__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group__4__Impl
	rule__EMV2Subclause__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_4()); }
(rule__EMV2Subclause__Group_4__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group__5__Impl
	rule__EMV2Subclause__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_5()); }
(rule__EMV2Subclause__Group_5__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group__6__Impl
	rule__EMV2Subclause__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_6()); }
(rule__EMV2Subclause__Group_6__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group__7__Impl
	rule__EMV2Subclause__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_7()); }
(rule__EMV2Subclause__Group_7__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group__8__Impl
	rule__EMV2Subclause__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_8()); }
(rule__EMV2Subclause__Group_8__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group__9__Impl
	rule__EMV2Subclause__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_9()); }
(rule__EMV2Subclause__Group_9__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group__10__Impl
	rule__EMV2Subclause__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_10()); }
(rule__EMV2Subclause__Group_10__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group__11
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group__11__Impl
	rule__EMV2Subclause__Group__12
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group__11__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_11()); }
(rule__EMV2Subclause__Group_11__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_11()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group__12
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group__12__Impl
	rule__EMV2Subclause__Group__13
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group__12__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_12()); }
(rule__EMV2Subclause__Group_12__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_12()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group__13
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group__13__Impl
	rule__EMV2Subclause__Group__14
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group__13__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getEndSubclauseKeywordsParserRuleCall_13()); }
	ruleEndSubclauseKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getEndSubclauseKeywordsParserRuleCall_13()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group__14
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group__14__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group__14__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_14()); }

	Semicolon 

{ after(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_14()); }
)

;
finally {
	restoreStackSize(stackSize);
}
































rule__EMV2Subclause__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_3__0__Impl
	rule__EMV2Subclause__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseTypesKeywordsParserRuleCall_3_0()); }
	ruleUseTypesKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getUseTypesKeywordsParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_3__1__Impl
	rule__EMV2Subclause__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseTypesAssignment_3_1()); }
(rule__EMV2Subclause__UseTypesAssignment_3_1)
{ after(grammarAccess.getEMV2SubclauseAccess().getUseTypesAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_3__2__Impl
	rule__EMV2Subclause__Group_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_3_2()); }
(rule__EMV2Subclause__Group_3_2__0)*
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_3__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_3__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_3__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_3_3()); }

	Semicolon 

{ after(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_3_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__EMV2Subclause__Group_3_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_3_2__0__Impl
	rule__EMV2Subclause__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_3_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getCommaKeyword_3_2_0()); }

	Comma 

{ after(grammarAccess.getEMV2SubclauseAccess().getCommaKeyword_3_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_3_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_3_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseTypesAssignment_3_2_1()); }
(rule__EMV2Subclause__UseTypesAssignment_3_2_1)
{ after(grammarAccess.getEMV2SubclauseAccess().getUseTypesAssignment_3_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Subclause__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_4__0__Impl
	rule__EMV2Subclause__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseTypeEquivalenceKeywordsParserRuleCall_4_0()); }
	ruleUseTypeEquivalenceKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getUseTypeEquivalenceKeywordsParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_4__1__Impl
	rule__EMV2Subclause__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getTypeEquivalenceAssignment_4_1()); }
(rule__EMV2Subclause__TypeEquivalenceAssignment_4_1)
{ after(grammarAccess.getEMV2SubclauseAccess().getTypeEquivalenceAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_4_2()); }

	Semicolon 

{ after(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__EMV2Subclause__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_5__0__Impl
	rule__EMV2Subclause__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseMappingsKeywordsParserRuleCall_5_0()); }
	ruleUseMappingsKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getUseMappingsKeywordsParserRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_5__1__Impl
	rule__EMV2Subclause__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getTypeMappingSetAssignment_5_1()); }
(rule__EMV2Subclause__TypeMappingSetAssignment_5_1)
{ after(grammarAccess.getEMV2SubclauseAccess().getTypeMappingSetAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_5_2()); }

	Semicolon 

{ after(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__EMV2Subclause__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_6__0__Impl
	rule__EMV2Subclause__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseBehaviorKeywordsParserRuleCall_6_0()); }
	ruleUseBehaviorKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getUseBehaviorKeywordsParserRuleCall_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_6__1__Impl
	rule__EMV2Subclause__Group_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseBehaviorAssignment_6_1()); }
(rule__EMV2Subclause__UseBehaviorAssignment_6_1)
{ after(grammarAccess.getEMV2SubclauseAccess().getUseBehaviorAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_6__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_6__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_6__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_6_2()); }

	Semicolon 

{ after(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_6_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__EMV2Subclause__Group_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_7__0__Impl
	rule__EMV2Subclause__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getErrorPropagationsKeywordsParserRuleCall_7_0()); }
	ruleErrorPropagationsKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getErrorPropagationsKeywordsParserRuleCall_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_7__1__Impl
	rule__EMV2Subclause__Group_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getPropagationsAssignment_7_1()); }
(rule__EMV2Subclause__PropagationsAssignment_7_1)*
{ after(grammarAccess.getEMV2SubclauseAccess().getPropagationsAssignment_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_7__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_7__2__Impl
	rule__EMV2Subclause__Group_7__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_7__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_7_2()); }
(rule__EMV2Subclause__Group_7_2__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_7_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_7__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_7__3__Impl
	rule__EMV2Subclause__Group_7__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_7__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getEndPropagationsKeywordsParserRuleCall_7_3()); }
	ruleEndPropagationsKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getEndPropagationsKeywordsParserRuleCall_7_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_7__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_7__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_7__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_7_4()); }

	Semicolon 

{ after(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_7_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__EMV2Subclause__Group_7_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_7_2__0__Impl
	rule__EMV2Subclause__Group_7_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_7_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getFlowsKeyword_7_2_0()); }

	Flows 

{ after(grammarAccess.getEMV2SubclauseAccess().getFlowsKeyword_7_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_7_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_7_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_7_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getEMV2SubclauseAccess().getFlowsAssignment_7_2_1()); }
(rule__EMV2Subclause__FlowsAssignment_7_2_1)
{ after(grammarAccess.getEMV2SubclauseAccess().getFlowsAssignment_7_2_1()); }
)
(
{ before(grammarAccess.getEMV2SubclauseAccess().getFlowsAssignment_7_2_1()); }
(rule__EMV2Subclause__FlowsAssignment_7_2_1)*
{ after(grammarAccess.getEMV2SubclauseAccess().getFlowsAssignment_7_2_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Subclause__Group_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8__0__Impl
	rule__EMV2Subclause__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getComponentErrorBehaviorKeywordsParserRuleCall_8_0()); }
	ruleComponentErrorBehaviorKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getComponentErrorBehaviorKeywordsParserRuleCall_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8__1__Impl
	rule__EMV2Subclause__Group_8__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_8_1()); }
(rule__EMV2Subclause__Group_8_1__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_8_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_8__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8__2__Impl
	rule__EMV2Subclause__Group_8__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_8_2()); }
(rule__EMV2Subclause__Group_8_2__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_8_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_8__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8__3__Impl
	rule__EMV2Subclause__Group_8__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_8_3()); }
(rule__EMV2Subclause__Group_8_3__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_8_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_8__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8__4__Impl
	rule__EMV2Subclause__Group_8__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_8_4()); }
(rule__EMV2Subclause__Group_8_4__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_8_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_8__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8__5__Impl
	rule__EMV2Subclause__Group_8__6
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_8_5()); }
(rule__EMV2Subclause__Group_8_5__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_8_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_8__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8__6__Impl
	rule__EMV2Subclause__Group_8__7
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_8_6()); }
(rule__EMV2Subclause__Group_8_6__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_8_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_8__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8__7__Impl
	rule__EMV2Subclause__Group_8__8
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getEndComponentKeywordsParserRuleCall_8_7()); }
	ruleEndComponentKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getEndComponentKeywordsParserRuleCall_8_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_8__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_8_8()); }

	Semicolon 

{ after(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_8_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}




















rule__EMV2Subclause__Group_8_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8_1__0__Impl
	rule__EMV2Subclause__Group_8_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseTransformationsKeywordsParserRuleCall_8_1_0()); }
	ruleUseTransformationsKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getUseTransformationsKeywordsParserRuleCall_8_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_8_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8_1__1__Impl
	rule__EMV2Subclause__Group_8_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseTransformationAssignment_8_1_1()); }
(rule__EMV2Subclause__UseTransformationAssignment_8_1_1)
{ after(grammarAccess.getEMV2SubclauseAccess().getUseTransformationAssignment_8_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_8_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_8_1_2()); }

	Semicolon 

{ after(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_8_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__EMV2Subclause__Group_8_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8_2__0__Impl
	rule__EMV2Subclause__Group_8_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getEventsKeyword_8_2_0()); }

	Events 

{ after(grammarAccess.getEMV2SubclauseAccess().getEventsKeyword_8_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_8_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getEMV2SubclauseAccess().getEventsAssignment_8_2_1()); }
(rule__EMV2Subclause__EventsAssignment_8_2_1)
{ after(grammarAccess.getEMV2SubclauseAccess().getEventsAssignment_8_2_1()); }
)
(
{ before(grammarAccess.getEMV2SubclauseAccess().getEventsAssignment_8_2_1()); }
(rule__EMV2Subclause__EventsAssignment_8_2_1)*
{ after(grammarAccess.getEMV2SubclauseAccess().getEventsAssignment_8_2_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Subclause__Group_8_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8_3__0__Impl
	rule__EMV2Subclause__Group_8_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getTransitionsKeyword_8_3_0()); }

	Transitions 

{ after(grammarAccess.getEMV2SubclauseAccess().getTransitionsKeyword_8_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_8_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getEMV2SubclauseAccess().getTransitionsAssignment_8_3_1()); }
(rule__EMV2Subclause__TransitionsAssignment_8_3_1)
{ after(grammarAccess.getEMV2SubclauseAccess().getTransitionsAssignment_8_3_1()); }
)
(
{ before(grammarAccess.getEMV2SubclauseAccess().getTransitionsAssignment_8_3_1()); }
(rule__EMV2Subclause__TransitionsAssignment_8_3_1)*
{ after(grammarAccess.getEMV2SubclauseAccess().getTransitionsAssignment_8_3_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Subclause__Group_8_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8_4__0__Impl
	rule__EMV2Subclause__Group_8_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getPropagationsKeyword_8_4_0()); }

	Propagations 

{ after(grammarAccess.getEMV2SubclauseAccess().getPropagationsKeyword_8_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_8_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getEMV2SubclauseAccess().getOutgoingPropagationConditionsAssignment_8_4_1()); }
(rule__EMV2Subclause__OutgoingPropagationConditionsAssignment_8_4_1)
{ after(grammarAccess.getEMV2SubclauseAccess().getOutgoingPropagationConditionsAssignment_8_4_1()); }
)
(
{ before(grammarAccess.getEMV2SubclauseAccess().getOutgoingPropagationConditionsAssignment_8_4_1()); }
(rule__EMV2Subclause__OutgoingPropagationConditionsAssignment_8_4_1)*
{ after(grammarAccess.getEMV2SubclauseAccess().getOutgoingPropagationConditionsAssignment_8_4_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Subclause__Group_8_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8_5__0__Impl
	rule__EMV2Subclause__Group_8_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getDetectionsKeyword_8_5_0()); }

	Detections 

{ after(grammarAccess.getEMV2SubclauseAccess().getDetectionsKeyword_8_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_8_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getEMV2SubclauseAccess().getErrorDetectionsAssignment_8_5_1()); }
(rule__EMV2Subclause__ErrorDetectionsAssignment_8_5_1)
{ after(grammarAccess.getEMV2SubclauseAccess().getErrorDetectionsAssignment_8_5_1()); }
)
(
{ before(grammarAccess.getEMV2SubclauseAccess().getErrorDetectionsAssignment_8_5_1()); }
(rule__EMV2Subclause__ErrorDetectionsAssignment_8_5_1)*
{ after(grammarAccess.getEMV2SubclauseAccess().getErrorDetectionsAssignment_8_5_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Subclause__Group_8_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8_6__0__Impl
	rule__EMV2Subclause__Group_8_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getModeMappingsKeywordsParserRuleCall_8_6_0()); }
	ruleModeMappingsKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getModeMappingsKeywordsParserRuleCall_8_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_8_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_8_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_8_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getEMV2SubclauseAccess().getErrorStateToModeMappingsAssignment_8_6_1()); }
(rule__EMV2Subclause__ErrorStateToModeMappingsAssignment_8_6_1)
{ after(grammarAccess.getEMV2SubclauseAccess().getErrorStateToModeMappingsAssignment_8_6_1()); }
)
(
{ before(grammarAccess.getEMV2SubclauseAccess().getErrorStateToModeMappingsAssignment_8_6_1()); }
(rule__EMV2Subclause__ErrorStateToModeMappingsAssignment_8_6_1)*
{ after(grammarAccess.getEMV2SubclauseAccess().getErrorStateToModeMappingsAssignment_8_6_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Subclause__Group_9__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_9__0__Impl
	rule__EMV2Subclause__Group_9__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_9__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getCompositeErrorBehaviorKeywordsParserRuleCall_9_0()); }
	ruleCompositeErrorBehaviorKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getCompositeErrorBehaviorKeywordsParserRuleCall_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_9__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_9__1__Impl
	rule__EMV2Subclause__Group_9__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_9__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_9_1()); }
(rule__EMV2Subclause__Group_9_1__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_9_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_9__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_9__2__Impl
	rule__EMV2Subclause__Group_9__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_9__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getEndCompositeKeywordsParserRuleCall_9_2()); }
	ruleEndCompositeKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getEndCompositeKeywordsParserRuleCall_9_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_9__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_9__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_9__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_9_3()); }

	Semicolon 

{ after(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_9_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__EMV2Subclause__Group_9_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_9_1__0__Impl
	rule__EMV2Subclause__Group_9_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_9_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getStatesKeyword_9_1_0()); }

	States 

{ after(grammarAccess.getEMV2SubclauseAccess().getStatesKeyword_9_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_9_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_9_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_9_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getEMV2SubclauseAccess().getStatesAssignment_9_1_1()); }
(rule__EMV2Subclause__StatesAssignment_9_1_1)
{ after(grammarAccess.getEMV2SubclauseAccess().getStatesAssignment_9_1_1()); }
)
(
{ before(grammarAccess.getEMV2SubclauseAccess().getStatesAssignment_9_1_1()); }
(rule__EMV2Subclause__StatesAssignment_9_1_1)*
{ after(grammarAccess.getEMV2SubclauseAccess().getStatesAssignment_9_1_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Subclause__Group_10__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_10__0__Impl
	rule__EMV2Subclause__Group_10__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_10__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getConnectionErrorKeywordsParserRuleCall_10_0()); }
	ruleConnectionErrorKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getConnectionErrorKeywordsParserRuleCall_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_10__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_10__1__Impl
	rule__EMV2Subclause__Group_10__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_10__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getGroup_10_1()); }
(rule__EMV2Subclause__Group_10_1__0)?
{ after(grammarAccess.getEMV2SubclauseAccess().getGroup_10_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_10__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_10__2__Impl
	rule__EMV2Subclause__Group_10__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_10__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getConnectionErrorSourcesAssignment_10_2()); }
(rule__EMV2Subclause__ConnectionErrorSourcesAssignment_10_2)*
{ after(grammarAccess.getEMV2SubclauseAccess().getConnectionErrorSourcesAssignment_10_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_10__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_10__3__Impl
	rule__EMV2Subclause__Group_10__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_10__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getEndConnectionKeywordsParserRuleCall_10_3()); }
	ruleEndConnectionKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getEndConnectionKeywordsParserRuleCall_10_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_10__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_10__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_10__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_10_4()); }

	Semicolon 

{ after(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_10_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__EMV2Subclause__Group_10_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_10_1__0__Impl
	rule__EMV2Subclause__Group_10_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_10_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseTransformationsKeywordsParserRuleCall_10_1_0()); }
	ruleUseTransformationsKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getUseTransformationsKeywordsParserRuleCall_10_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_10_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_10_1__1__Impl
	rule__EMV2Subclause__Group_10_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_10_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getTypeTransformationSetAssignment_10_1_1()); }
(rule__EMV2Subclause__TypeTransformationSetAssignment_10_1_1)
{ after(grammarAccess.getEMV2SubclauseAccess().getTypeTransformationSetAssignment_10_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_10_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_10_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_10_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_10_1_2()); }

	Semicolon 

{ after(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_10_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__EMV2Subclause__Group_11__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_11__0__Impl
	rule__EMV2Subclause__Group_11__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_11__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getPropagationPathsKeywordsParserRuleCall_11_0()); }
	rulePropagationPathsKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getPropagationPathsKeywordsParserRuleCall_11_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_11__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_11__1__Impl
	rule__EMV2Subclause__Group_11__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_11__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getPointsAssignment_11_1()); }
(rule__EMV2Subclause__PointsAssignment_11_1)*
{ after(grammarAccess.getEMV2SubclauseAccess().getPointsAssignment_11_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_11__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_11__2__Impl
	rule__EMV2Subclause__Group_11__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_11__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getPathsAssignment_11_2()); }
(rule__EMV2Subclause__PathsAssignment_11_2)*
{ after(grammarAccess.getEMV2SubclauseAccess().getPathsAssignment_11_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_11__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_11__3__Impl
	rule__EMV2Subclause__Group_11__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_11__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getEndPathsKeywordsParserRuleCall_11_3()); }
	ruleEndPathsKeywords
{ after(grammarAccess.getEMV2SubclauseAccess().getEndPathsKeywordsParserRuleCall_11_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_11__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_11__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_11__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_11_4()); }

	Semicolon 

{ after(grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_11_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__EMV2Subclause__Group_12__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_12__0__Impl
	rule__EMV2Subclause__Group_12__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_12__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getPropertiesKeyword_12_0()); }

	Properties 

{ after(grammarAccess.getEMV2SubclauseAccess().getPropertiesKeyword_12_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Subclause__Group_12__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Subclause__Group_12__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__Group_12__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getEMV2SubclauseAccess().getPropertiesAssignment_12_1()); }
(rule__EMV2Subclause__PropertiesAssignment_12_1)
{ after(grammarAccess.getEMV2SubclauseAccess().getPropertiesAssignment_12_1()); }
)
(
{ before(grammarAccess.getEMV2SubclauseAccess().getPropertiesAssignment_12_1()); }
(rule__EMV2Subclause__PropertiesAssignment_12_1)*
{ after(grammarAccess.getEMV2SubclauseAccess().getPropertiesAssignment_12_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorModelLibrary__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group__0__Impl
	rule__ErrorModelLibrary__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getErrorModelLibraryAction_0()); }
(

)
{ after(grammarAccess.getErrorModelLibraryAccess().getErrorModelLibraryAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group__1__Impl
	rule__ErrorModelLibrary__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getGroup_1()); }
(rule__ErrorModelLibrary__Group_1__0)?
{ after(grammarAccess.getErrorModelLibraryAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group__2__Impl
	rule__ErrorModelLibrary__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getBehaviorsAssignment_2()); }
(rule__ErrorModelLibrary__BehaviorsAssignment_2)*
{ after(grammarAccess.getErrorModelLibraryAccess().getBehaviorsAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group__3__Impl
	rule__ErrorModelLibrary__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getMappingsAssignment_3()); }
(rule__ErrorModelLibrary__MappingsAssignment_3)*
{ after(grammarAccess.getErrorModelLibraryAccess().getMappingsAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getTransformationsAssignment_4()); }
(rule__ErrorModelLibrary__TransformationsAssignment_4)*
{ after(grammarAccess.getErrorModelLibraryAccess().getTransformationsAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__ErrorModelLibrary__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1__0__Impl
	rule__ErrorModelLibrary__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getErrorTypesKeywordsParserRuleCall_1_0()); }
	ruleErrorTypesKeywords
{ after(grammarAccess.getErrorModelLibraryAccess().getErrorTypesKeywordsParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1__1__Impl
	rule__ErrorModelLibrary__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getGroup_1_1()); }
(rule__ErrorModelLibrary__Group_1_1__0)?
{ after(grammarAccess.getErrorModelLibraryAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1__2__Impl
	rule__ErrorModelLibrary__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getGroup_1_2()); }
(rule__ErrorModelLibrary__Group_1_2__0)?
{ after(grammarAccess.getErrorModelLibraryAccess().getGroup_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1__3__Impl
	rule__ErrorModelLibrary__Group_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getAlternatives_1_3()); }
(rule__ErrorModelLibrary__Alternatives_1_3)*
{ after(grammarAccess.getErrorModelLibraryAccess().getAlternatives_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group_1__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1__4__Impl
	rule__ErrorModelLibrary__Group_1__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getGroup_1_4()); }
(rule__ErrorModelLibrary__Group_1_4__0)?
{ after(grammarAccess.getErrorModelLibraryAccess().getGroup_1_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group_1__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1__5__Impl
	rule__ErrorModelLibrary__Group_1__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getEndTypesKeywordsParserRuleCall_1_5()); }
	ruleEndTypesKeywords
{ after(grammarAccess.getErrorModelLibraryAccess().getEndTypesKeywordsParserRuleCall_1_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group_1__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getSemicolonKeyword_1_6()); }

	Semicolon 

{ after(grammarAccess.getErrorModelLibraryAccess().getSemicolonKeyword_1_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__ErrorModelLibrary__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1_1__0__Impl
	rule__ErrorModelLibrary__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getUseTypesKeywordsParserRuleCall_1_1_0()); }
	ruleUseTypesKeywords
{ after(grammarAccess.getErrorModelLibraryAccess().getUseTypesKeywordsParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1_1__1__Impl
	rule__ErrorModelLibrary__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getUseTypesAssignment_1_1_1()); }
(rule__ErrorModelLibrary__UseTypesAssignment_1_1_1)
{ after(grammarAccess.getErrorModelLibraryAccess().getUseTypesAssignment_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1_1__2__Impl
	rule__ErrorModelLibrary__Group_1_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getGroup_1_1_2()); }
(rule__ErrorModelLibrary__Group_1_1_2__0)*
{ after(grammarAccess.getErrorModelLibraryAccess().getGroup_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group_1_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getSemicolonKeyword_1_1_3()); }

	Semicolon 

{ after(grammarAccess.getErrorModelLibraryAccess().getSemicolonKeyword_1_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ErrorModelLibrary__Group_1_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1_1_2__0__Impl
	rule__ErrorModelLibrary__Group_1_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getCommaKeyword_1_1_2_0()); }

	Comma 

{ after(grammarAccess.getErrorModelLibraryAccess().getCommaKeyword_1_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group_1_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getUseTypesAssignment_1_1_2_1()); }
(rule__ErrorModelLibrary__UseTypesAssignment_1_1_2_1)
{ after(grammarAccess.getErrorModelLibraryAccess().getUseTypesAssignment_1_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorModelLibrary__Group_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1_2__0__Impl
	rule__ErrorModelLibrary__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getExtendsKeyword_1_2_0()); }

	Extends 

{ after(grammarAccess.getErrorModelLibraryAccess().getExtendsKeyword_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1_2__1__Impl
	rule__ErrorModelLibrary__Group_1_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getExtendsAssignment_1_2_1()); }
(rule__ErrorModelLibrary__ExtendsAssignment_1_2_1)
{ after(grammarAccess.getErrorModelLibraryAccess().getExtendsAssignment_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group_1_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1_2__2__Impl
	rule__ErrorModelLibrary__Group_1_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getGroup_1_2_2()); }
(rule__ErrorModelLibrary__Group_1_2_2__0)*
{ after(grammarAccess.getErrorModelLibraryAccess().getGroup_1_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group_1_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getWithKeyword_1_2_3()); }

	With 

{ after(grammarAccess.getErrorModelLibraryAccess().getWithKeyword_1_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ErrorModelLibrary__Group_1_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1_2_2__0__Impl
	rule__ErrorModelLibrary__Group_1_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getCommaKeyword_1_2_2_0()); }

	Comma 

{ after(grammarAccess.getErrorModelLibraryAccess().getCommaKeyword_1_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group_1_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getExtendsAssignment_1_2_2_1()); }
(rule__ErrorModelLibrary__ExtendsAssignment_1_2_2_1)
{ after(grammarAccess.getErrorModelLibraryAccess().getExtendsAssignment_1_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorModelLibrary__Group_1_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1_4__0__Impl
	rule__ErrorModelLibrary__Group_1_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getPropertiesKeyword_1_4_0()); }

	Properties 

{ after(grammarAccess.getErrorModelLibraryAccess().getPropertiesKeyword_1_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorModelLibrary__Group_1_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorModelLibrary__Group_1_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__Group_1_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getErrorModelLibraryAccess().getPropertiesAssignment_1_4_1()); }
(rule__ErrorModelLibrary__PropertiesAssignment_1_4_1)
{ after(grammarAccess.getErrorModelLibraryAccess().getPropertiesAssignment_1_4_1()); }
)
(
{ before(grammarAccess.getErrorModelLibraryAccess().getPropertiesAssignment_1_4_1()); }
(rule__ErrorModelLibrary__PropertiesAssignment_1_4_1)*
{ after(grammarAccess.getErrorModelLibraryAccess().getPropertiesAssignment_1_4_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Library__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0__0__Impl
	rule__EMV2Library__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getErrorModelLibraryAction_0_0()); }
(

)
{ after(grammarAccess.getEMV2LibraryAccess().getErrorModelLibraryAction_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getGroup_0_1()); }
(rule__EMV2Library__Group_0_1__0)
{ after(grammarAccess.getEMV2LibraryAccess().getGroup_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Library__Group_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1__0__Impl
	rule__EMV2Library__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getLibraryKeyword_0_1_0()); }

	Library 

{ after(grammarAccess.getEMV2LibraryAccess().getLibraryKeyword_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1__1__Impl
	rule__EMV2Library__Group_0_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getNameAssignment_0_1_1()); }
(rule__EMV2Library__NameAssignment_0_1_1)
{ after(grammarAccess.getEMV2LibraryAccess().getNameAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1__2__Impl
	rule__EMV2Library__Group_0_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2()); }
(rule__EMV2Library__Group_0_1_2__0)?
{ after(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1__3__Impl
	rule__EMV2Library__Group_0_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getBehaviorsAssignment_0_1_3()); }
(rule__EMV2Library__BehaviorsAssignment_0_1_3)*
{ after(grammarAccess.getEMV2LibraryAccess().getBehaviorsAssignment_0_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1__4__Impl
	rule__EMV2Library__Group_0_1__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getMappingsAssignment_0_1_4()); }
(rule__EMV2Library__MappingsAssignment_0_1_4)*
{ after(grammarAccess.getEMV2LibraryAccess().getMappingsAssignment_0_1_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getTransformationsAssignment_0_1_5()); }
(rule__EMV2Library__TransformationsAssignment_0_1_5)*
{ after(grammarAccess.getEMV2LibraryAccess().getTransformationsAssignment_0_1_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__EMV2Library__Group_0_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2__0__Impl
	rule__EMV2Library__Group_0_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getErrorTypesKeywordsParserRuleCall_0_1_2_0()); }
	ruleErrorTypesKeywords
{ after(grammarAccess.getEMV2LibraryAccess().getErrorTypesKeywordsParserRuleCall_0_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2__1__Impl
	rule__EMV2Library__Group_0_1_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2_1()); }
(rule__EMV2Library__Group_0_1_2_1__0)?
{ after(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2__2__Impl
	rule__EMV2Library__Group_0_1_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2_2()); }
(rule__EMV2Library__Group_0_1_2_2__0)?
{ after(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2__3__Impl
	rule__EMV2Library__Group_0_1_2__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getAlternatives_0_1_2_3()); }
(rule__EMV2Library__Alternatives_0_1_2_3)*
{ after(grammarAccess.getEMV2LibraryAccess().getAlternatives_0_1_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1_2__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2__4__Impl
	rule__EMV2Library__Group_0_1_2__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2_4()); }
(rule__EMV2Library__Group_0_1_2_4__0)?
{ after(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1_2__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2__5__Impl
	rule__EMV2Library__Group_0_1_2__6
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getEndTypesKeywordsParserRuleCall_0_1_2_5()); }
	ruleEndTypesKeywords
{ after(grammarAccess.getEMV2LibraryAccess().getEndTypesKeywordsParserRuleCall_0_1_2_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1_2__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_0_1_2_6()); }

	Semicolon 

{ after(grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_0_1_2_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__EMV2Library__Group_0_1_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2_1__0__Impl
	rule__EMV2Library__Group_0_1_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getUseTypesKeywordsParserRuleCall_0_1_2_1_0()); }
	ruleUseTypesKeywords
{ after(grammarAccess.getEMV2LibraryAccess().getUseTypesKeywordsParserRuleCall_0_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2_1__1__Impl
	rule__EMV2Library__Group_0_1_2_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getUseTypesAssignment_0_1_2_1_1()); }
(rule__EMV2Library__UseTypesAssignment_0_1_2_1_1)
{ after(grammarAccess.getEMV2LibraryAccess().getUseTypesAssignment_0_1_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1_2_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2_1__2__Impl
	rule__EMV2Library__Group_0_1_2_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2_1_2()); }
(rule__EMV2Library__Group_0_1_2_1_2__0)*
{ after(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1_2_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_0_1_2_1_3()); }

	Semicolon 

{ after(grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_0_1_2_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__EMV2Library__Group_0_1_2_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2_1_2__0__Impl
	rule__EMV2Library__Group_0_1_2_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getCommaKeyword_0_1_2_1_2_0()); }

	Comma 

{ after(grammarAccess.getEMV2LibraryAccess().getCommaKeyword_0_1_2_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1_2_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getUseTypesAssignment_0_1_2_1_2_1()); }
(rule__EMV2Library__UseTypesAssignment_0_1_2_1_2_1)
{ after(grammarAccess.getEMV2LibraryAccess().getUseTypesAssignment_0_1_2_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Library__Group_0_1_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2_2__0__Impl
	rule__EMV2Library__Group_0_1_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getExtendsKeyword_0_1_2_2_0()); }

	Extends 

{ after(grammarAccess.getEMV2LibraryAccess().getExtendsKeyword_0_1_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2_2__1__Impl
	rule__EMV2Library__Group_0_1_2_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getExtendsAssignment_0_1_2_2_1()); }
(rule__EMV2Library__ExtendsAssignment_0_1_2_2_1)
{ after(grammarAccess.getEMV2LibraryAccess().getExtendsAssignment_0_1_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1_2_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2_2__2__Impl
	rule__EMV2Library__Group_0_1_2_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2_2_2()); }
(rule__EMV2Library__Group_0_1_2_2_2__0)*
{ after(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1_2_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getWithKeyword_0_1_2_2_3()); }

	With 

{ after(grammarAccess.getEMV2LibraryAccess().getWithKeyword_0_1_2_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__EMV2Library__Group_0_1_2_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2_2_2__0__Impl
	rule__EMV2Library__Group_0_1_2_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getCommaKeyword_0_1_2_2_2_0()); }

	Comma 

{ after(grammarAccess.getEMV2LibraryAccess().getCommaKeyword_0_1_2_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1_2_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getExtendsAssignment_0_1_2_2_2_1()); }
(rule__EMV2Library__ExtendsAssignment_0_1_2_2_2_1)
{ after(grammarAccess.getEMV2LibraryAccess().getExtendsAssignment_0_1_2_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Library__Group_0_1_2_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2_4__0__Impl
	rule__EMV2Library__Group_0_1_2_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getPropertiesKeyword_0_1_2_4_0()); }

	Properties 

{ after(grammarAccess.getEMV2LibraryAccess().getPropertiesKeyword_0_1_2_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_0_1_2_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_0_1_2_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_0_1_2_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getEMV2LibraryAccess().getPropertiesAssignment_0_1_2_4_1()); }
(rule__EMV2Library__PropertiesAssignment_0_1_2_4_1)
{ after(grammarAccess.getEMV2LibraryAccess().getPropertiesAssignment_0_1_2_4_1()); }
)
(
{ before(grammarAccess.getEMV2LibraryAccess().getPropertiesAssignment_0_1_2_4_1()); }
(rule__EMV2Library__PropertiesAssignment_0_1_2_4_1)*
{ after(grammarAccess.getEMV2LibraryAccess().getPropertiesAssignment_0_1_2_4_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Library__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1__0__Impl
	rule__EMV2Library__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getPackageKeyword_1_0()); }

	Package 

{ after(grammarAccess.getEMV2LibraryAccess().getPackageKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1__1__Impl
	rule__EMV2Library__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getNameAssignment_1_1()); }
(rule__EMV2Library__NameAssignment_1_1)
{ after(grammarAccess.getEMV2LibraryAccess().getNameAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1__2__Impl
	rule__EMV2Library__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getPublicKeyword_1_2()); }

	Public 

{ after(grammarAccess.getEMV2LibraryAccess().getPublicKeyword_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1__3__Impl
	rule__EMV2Library__Group_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getAnnexKeyword_1_3()); }

	Annex 

{ after(grammarAccess.getEMV2LibraryAccess().getAnnexKeyword_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1__4__Impl
	rule__EMV2Library__Group_1__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getIDTerminalRuleCall_1_4()); }
	RULE_ID
{ after(grammarAccess.getEMV2LibraryAccess().getIDTerminalRuleCall_1_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1__5__Impl
	rule__EMV2Library__Group_1__6
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getLeftCurlyBracketAsteriskAsteriskKeyword_1_5()); }

	LeftCurlyBracketAsteriskAsterisk 

{ after(grammarAccess.getEMV2LibraryAccess().getLeftCurlyBracketAsteriskAsteriskKeyword_1_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1__6__Impl
	rule__EMV2Library__Group_1__7
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getGroup_1_6()); }
(rule__EMV2Library__Group_1_6__0)?
{ after(grammarAccess.getEMV2LibraryAccess().getGroup_1_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1__7__Impl
	rule__EMV2Library__Group_1__8
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getBehaviorsAssignment_1_7()); }
(rule__EMV2Library__BehaviorsAssignment_1_7)*
{ after(grammarAccess.getEMV2LibraryAccess().getBehaviorsAssignment_1_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1__8__Impl
	rule__EMV2Library__Group_1__9
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getMappingsAssignment_1_8()); }
(rule__EMV2Library__MappingsAssignment_1_8)*
{ after(grammarAccess.getEMV2LibraryAccess().getMappingsAssignment_1_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1__9__Impl
	rule__EMV2Library__Group_1__10
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getTransformationsAssignment_1_9()); }
(rule__EMV2Library__TransformationsAssignment_1_9)*
{ after(grammarAccess.getEMV2LibraryAccess().getTransformationsAssignment_1_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1__10__Impl
	rule__EMV2Library__Group_1__11
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getAsteriskAsteriskRightCurlyBracketKeyword_1_10()); }

	AsteriskAsteriskRightCurlyBracket 

{ after(grammarAccess.getEMV2LibraryAccess().getAsteriskAsteriskRightCurlyBracketKeyword_1_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1__11
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1__11__Impl
	rule__EMV2Library__Group_1__12
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1__11__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_1_11()); }

	Semicolon 

{ after(grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_1_11()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1__12
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1__12__Impl
	rule__EMV2Library__Group_1__13
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1__12__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getEndKeyword_1_12()); }

	End 

{ after(grammarAccess.getEMV2LibraryAccess().getEndKeyword_1_12()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1__13
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1__13__Impl
	rule__EMV2Library__Group_1__14
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1__13__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getQEMREFParserRuleCall_1_13()); }
	ruleQEMREF
{ after(grammarAccess.getEMV2LibraryAccess().getQEMREFParserRuleCall_1_13()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1__14
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1__14__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1__14__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_1_14()); }

	Semicolon 

{ after(grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_1_14()); }
)

;
finally {
	restoreStackSize(stackSize);
}
































rule__EMV2Library__Group_1_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6__0__Impl
	rule__EMV2Library__Group_1_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getErrorTypesKeywordsParserRuleCall_1_6_0()); }
	ruleErrorTypesKeywords
{ after(grammarAccess.getEMV2LibraryAccess().getErrorTypesKeywordsParserRuleCall_1_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6__1__Impl
	rule__EMV2Library__Group_1_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getGroup_1_6_1()); }
(rule__EMV2Library__Group_1_6_1__0)?
{ after(grammarAccess.getEMV2LibraryAccess().getGroup_1_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1_6__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6__2__Impl
	rule__EMV2Library__Group_1_6__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getGroup_1_6_2()); }
(rule__EMV2Library__Group_1_6_2__0)?
{ after(grammarAccess.getEMV2LibraryAccess().getGroup_1_6_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1_6__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6__3__Impl
	rule__EMV2Library__Group_1_6__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getAlternatives_1_6_3()); }
(rule__EMV2Library__Alternatives_1_6_3)*
{ after(grammarAccess.getEMV2LibraryAccess().getAlternatives_1_6_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1_6__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6__4__Impl
	rule__EMV2Library__Group_1_6__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getGroup_1_6_4()); }
(rule__EMV2Library__Group_1_6_4__0)?
{ after(grammarAccess.getEMV2LibraryAccess().getGroup_1_6_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1_6__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6__5__Impl
	rule__EMV2Library__Group_1_6__6
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getEndTypesKeywordsParserRuleCall_1_6_5()); }
	ruleEndTypesKeywords
{ after(grammarAccess.getEMV2LibraryAccess().getEndTypesKeywordsParserRuleCall_1_6_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1_6__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_1_6_6()); }

	Semicolon 

{ after(grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_1_6_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__EMV2Library__Group_1_6_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6_1__0__Impl
	rule__EMV2Library__Group_1_6_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getUseTypesKeywordsParserRuleCall_1_6_1_0()); }
	ruleUseTypesKeywords
{ after(grammarAccess.getEMV2LibraryAccess().getUseTypesKeywordsParserRuleCall_1_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1_6_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6_1__1__Impl
	rule__EMV2Library__Group_1_6_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getUseTypesAssignment_1_6_1_1()); }
(rule__EMV2Library__UseTypesAssignment_1_6_1_1)
{ after(grammarAccess.getEMV2LibraryAccess().getUseTypesAssignment_1_6_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1_6_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6_1__2__Impl
	rule__EMV2Library__Group_1_6_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getGroup_1_6_1_2()); }
(rule__EMV2Library__Group_1_6_1_2__0)*
{ after(grammarAccess.getEMV2LibraryAccess().getGroup_1_6_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1_6_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_1_6_1_3()); }

	Semicolon 

{ after(grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_1_6_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__EMV2Library__Group_1_6_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6_1_2__0__Impl
	rule__EMV2Library__Group_1_6_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getCommaKeyword_1_6_1_2_0()); }

	Comma 

{ after(grammarAccess.getEMV2LibraryAccess().getCommaKeyword_1_6_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1_6_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getUseTypesAssignment_1_6_1_2_1()); }
(rule__EMV2Library__UseTypesAssignment_1_6_1_2_1)
{ after(grammarAccess.getEMV2LibraryAccess().getUseTypesAssignment_1_6_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Library__Group_1_6_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6_2__0__Impl
	rule__EMV2Library__Group_1_6_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getExtendsKeyword_1_6_2_0()); }

	Extends 

{ after(grammarAccess.getEMV2LibraryAccess().getExtendsKeyword_1_6_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1_6_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6_2__1__Impl
	rule__EMV2Library__Group_1_6_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getExtendsAssignment_1_6_2_1()); }
(rule__EMV2Library__ExtendsAssignment_1_6_2_1)
{ after(grammarAccess.getEMV2LibraryAccess().getExtendsAssignment_1_6_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1_6_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6_2__2__Impl
	rule__EMV2Library__Group_1_6_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getGroup_1_6_2_2()); }
(rule__EMV2Library__Group_1_6_2_2__0)*
{ after(grammarAccess.getEMV2LibraryAccess().getGroup_1_6_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1_6_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getWithKeyword_1_6_2_3()); }

	With 

{ after(grammarAccess.getEMV2LibraryAccess().getWithKeyword_1_6_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__EMV2Library__Group_1_6_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6_2_2__0__Impl
	rule__EMV2Library__Group_1_6_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getCommaKeyword_1_6_2_2_0()); }

	Comma 

{ after(grammarAccess.getEMV2LibraryAccess().getCommaKeyword_1_6_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1_6_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getExtendsAssignment_1_6_2_2_1()); }
(rule__EMV2Library__ExtendsAssignment_1_6_2_2_1)
{ after(grammarAccess.getEMV2LibraryAccess().getExtendsAssignment_1_6_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Library__Group_1_6_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6_4__0__Impl
	rule__EMV2Library__Group_1_6_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getPropertiesKeyword_1_6_4_0()); }

	Properties 

{ after(grammarAccess.getEMV2LibraryAccess().getPropertiesKeyword_1_6_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Library__Group_1_6_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Library__Group_1_6_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__Group_1_6_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getEMV2LibraryAccess().getPropertiesAssignment_1_6_4_1()); }
(rule__EMV2Library__PropertiesAssignment_1_6_4_1)
{ after(grammarAccess.getEMV2LibraryAccess().getPropertiesAssignment_1_6_4_1()); }
)
(
{ before(grammarAccess.getEMV2LibraryAccess().getPropertiesAssignment_1_6_4_1()); }
(rule__EMV2Library__PropertiesAssignment_1_6_4_1)*
{ after(grammarAccess.getEMV2LibraryAccess().getPropertiesAssignment_1_6_4_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2PropertyAssociation__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PropertyAssociation__Group__0__Impl
	rule__EMV2PropertyAssociation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getPropertyAssignment_0()); }
(rule__EMV2PropertyAssociation__PropertyAssignment_0)
{ after(grammarAccess.getEMV2PropertyAssociationAccess().getPropertyAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2PropertyAssociation__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PropertyAssociation__Group__1__Impl
	rule__EMV2PropertyAssociation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1()); }

	EqualsSignGreaterThanSign 

{ after(grammarAccess.getEMV2PropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2PropertyAssociation__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PropertyAssociation__Group__2__Impl
	rule__EMV2PropertyAssociation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getGroup_2()); }
(rule__EMV2PropertyAssociation__Group_2__0)
{ after(grammarAccess.getEMV2PropertyAssociationAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2PropertyAssociation__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PropertyAssociation__Group__3__Impl
	rule__EMV2PropertyAssociation__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getGroup_3()); }
(rule__EMV2PropertyAssociation__Group_3__0)?
{ after(grammarAccess.getEMV2PropertyAssociationAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2PropertyAssociation__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PropertyAssociation__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getSemicolonKeyword_4()); }

	Semicolon 

{ after(grammarAccess.getEMV2PropertyAssociationAccess().getSemicolonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__EMV2PropertyAssociation__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PropertyAssociation__Group_2__0__Impl
	rule__EMV2PropertyAssociation__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getOwnedValuesAssignment_2_0()); }
(rule__EMV2PropertyAssociation__OwnedValuesAssignment_2_0)
{ after(grammarAccess.getEMV2PropertyAssociationAccess().getOwnedValuesAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2PropertyAssociation__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PropertyAssociation__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getGroup_2_1()); }
(rule__EMV2PropertyAssociation__Group_2_1__0)*
{ after(grammarAccess.getEMV2PropertyAssociationAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2PropertyAssociation__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PropertyAssociation__Group_2_1__0__Impl
	rule__EMV2PropertyAssociation__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getCommaKeyword_2_1_0()); }

	Comma 

{ after(grammarAccess.getEMV2PropertyAssociationAccess().getCommaKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2PropertyAssociation__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PropertyAssociation__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getOwnedValuesAssignment_2_1_1()); }
(rule__EMV2PropertyAssociation__OwnedValuesAssignment_2_1_1)
{ after(grammarAccess.getEMV2PropertyAssociationAccess().getOwnedValuesAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2PropertyAssociation__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PropertyAssociation__Group_3__0__Impl
	rule__EMV2PropertyAssociation__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_3_0()); }
	ruleAppliesToKeywords
{ after(grammarAccess.getEMV2PropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2PropertyAssociation__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PropertyAssociation__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getGroup_3_1()); }
(rule__EMV2PropertyAssociation__Group_3_1__0)
{ after(grammarAccess.getEMV2PropertyAssociationAccess().getGroup_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2PropertyAssociation__Group_3_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PropertyAssociation__Group_3_1__0__Impl
	rule__EMV2PropertyAssociation__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Group_3_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getEmv2PathAssignment_3_1_0()); }
(rule__EMV2PropertyAssociation__Emv2PathAssignment_3_1_0)
{ after(grammarAccess.getEMV2PropertyAssociationAccess().getEmv2PathAssignment_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2PropertyAssociation__Group_3_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PropertyAssociation__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Group_3_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getGroup_3_1_1()); }
(rule__EMV2PropertyAssociation__Group_3_1_1__0)*
{ after(grammarAccess.getEMV2PropertyAssociationAccess().getGroup_3_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2PropertyAssociation__Group_3_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PropertyAssociation__Group_3_1_1__0__Impl
	rule__EMV2PropertyAssociation__Group_3_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Group_3_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getCommaKeyword_3_1_1_0()); }

	Comma 

{ after(grammarAccess.getEMV2PropertyAssociationAccess().getCommaKeyword_3_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2PropertyAssociation__Group_3_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PropertyAssociation__Group_3_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Group_3_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getEmv2PathAssignment_3_1_1_1()); }
(rule__EMV2PropertyAssociation__Emv2PathAssignment_3_1_1_1)
{ after(grammarAccess.getEMV2PropertyAssociationAccess().getEmv2PathAssignment_3_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__BasicEMV2PropertyAssociation__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BasicEMV2PropertyAssociation__Group__0__Impl
	rule__BasicEMV2PropertyAssociation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getPropertyAssignment_0()); }
(rule__BasicEMV2PropertyAssociation__PropertyAssignment_0)
{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getPropertyAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BasicEMV2PropertyAssociation__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BasicEMV2PropertyAssociation__Group__1__Impl
	rule__BasicEMV2PropertyAssociation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1()); }

	EqualsSignGreaterThanSign 

{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BasicEMV2PropertyAssociation__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BasicEMV2PropertyAssociation__Group__2__Impl
	rule__BasicEMV2PropertyAssociation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup_2()); }
(rule__BasicEMV2PropertyAssociation__Group_2__0)
{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BasicEMV2PropertyAssociation__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BasicEMV2PropertyAssociation__Group__3__Impl
	rule__BasicEMV2PropertyAssociation__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup_3()); }
(rule__BasicEMV2PropertyAssociation__Group_3__0)?
{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BasicEMV2PropertyAssociation__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BasicEMV2PropertyAssociation__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getSemicolonKeyword_4()); }

	Semicolon 

{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getSemicolonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__BasicEMV2PropertyAssociation__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BasicEMV2PropertyAssociation__Group_2__0__Impl
	rule__BasicEMV2PropertyAssociation__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getOwnedValuesAssignment_2_0()); }
(rule__BasicEMV2PropertyAssociation__OwnedValuesAssignment_2_0)
{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getOwnedValuesAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BasicEMV2PropertyAssociation__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BasicEMV2PropertyAssociation__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup_2_1()); }
(rule__BasicEMV2PropertyAssociation__Group_2_1__0)*
{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__BasicEMV2PropertyAssociation__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BasicEMV2PropertyAssociation__Group_2_1__0__Impl
	rule__BasicEMV2PropertyAssociation__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getCommaKeyword_2_1_0()); }

	Comma 

{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getCommaKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BasicEMV2PropertyAssociation__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BasicEMV2PropertyAssociation__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getOwnedValuesAssignment_2_1_1()); }
(rule__BasicEMV2PropertyAssociation__OwnedValuesAssignment_2_1_1)
{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getOwnedValuesAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__BasicEMV2PropertyAssociation__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BasicEMV2PropertyAssociation__Group_3__0__Impl
	rule__BasicEMV2PropertyAssociation__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_3_0()); }
	ruleAppliesToKeywords
{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BasicEMV2PropertyAssociation__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BasicEMV2PropertyAssociation__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup_3_1()); }
(rule__BasicEMV2PropertyAssociation__Group_3_1__0)
{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__BasicEMV2PropertyAssociation__Group_3_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BasicEMV2PropertyAssociation__Group_3_1__0__Impl
	rule__BasicEMV2PropertyAssociation__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Group_3_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getEmv2PathAssignment_3_1_0()); }
(rule__BasicEMV2PropertyAssociation__Emv2PathAssignment_3_1_0)
{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getEmv2PathAssignment_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BasicEMV2PropertyAssociation__Group_3_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BasicEMV2PropertyAssociation__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Group_3_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup_3_1_1()); }
(rule__BasicEMV2PropertyAssociation__Group_3_1_1__0)*
{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup_3_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__BasicEMV2PropertyAssociation__Group_3_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BasicEMV2PropertyAssociation__Group_3_1_1__0__Impl
	rule__BasicEMV2PropertyAssociation__Group_3_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Group_3_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getCommaKeyword_3_1_1_0()); }

	Comma 

{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getCommaKeyword_3_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BasicEMV2PropertyAssociation__Group_3_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BasicEMV2PropertyAssociation__Group_3_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Group_3_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getEmv2PathAssignment_3_1_1_1()); }
(rule__BasicEMV2PropertyAssociation__Emv2PathAssignment_3_1_1_1)
{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getEmv2PathAssignment_3_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Path__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Path__Group__0__Impl
	rule__EMV2Path__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Path__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathAccess().getGroup_0()); }
(rule__EMV2Path__Group_0__0)?
{ after(grammarAccess.getEMV2PathAccess().getGroup_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Path__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Path__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Path__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathAccess().getEmv2TargetAssignment_1()); }
(rule__EMV2Path__Emv2TargetAssignment_1)
{ after(grammarAccess.getEMV2PathAccess().getEmv2TargetAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2Path__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Path__Group_0__0__Impl
	rule__EMV2Path__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Path__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathAccess().getCircumflexAccentKeyword_0_0()); }

	CircumflexAccent 

{ after(grammarAccess.getEMV2PathAccess().getCircumflexAccentKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Path__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Path__Group_0__1__Impl
	rule__EMV2Path__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Path__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathAccess().getContainmentPathAssignment_0_1()); }
(rule__EMV2Path__ContainmentPathAssignment_0_1)
{ after(grammarAccess.getEMV2PathAccess().getContainmentPathAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2Path__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2Path__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Path__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathAccess().getCommercialAtKeyword_0_2()); }

	CommercialAt 

{ after(grammarAccess.getEMV2PathAccess().getCommercialAtKeyword_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__EMV2PathElementOrKind__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PathElementOrKind__Group_0__0__Impl
	rule__EMV2PathElementOrKind__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElementOrKind__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getEmv2PropagationKindAssignment_0_0()); }
(rule__EMV2PathElementOrKind__Emv2PropagationKindAssignment_0_0)
{ after(grammarAccess.getEMV2PathElementOrKindAccess().getEmv2PropagationKindAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2PathElementOrKind__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PathElementOrKind__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElementOrKind__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getGroup_0_1()); }
(rule__EMV2PathElementOrKind__Group_0_1__0)?
{ after(grammarAccess.getEMV2PathElementOrKindAccess().getGroup_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2PathElementOrKind__Group_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PathElementOrKind__Group_0_1__0__Impl
	rule__EMV2PathElementOrKind__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElementOrKind__Group_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getFullStopKeyword_0_1_0()); }

	FullStop 

{ after(grammarAccess.getEMV2PathElementOrKindAccess().getFullStopKeyword_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2PathElementOrKind__Group_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PathElementOrKind__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElementOrKind__Group_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getErrorTypeAssignment_0_1_1()); }
(rule__EMV2PathElementOrKind__ErrorTypeAssignment_0_1_1)
{ after(grammarAccess.getEMV2PathElementOrKindAccess().getErrorTypeAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2PathElementOrKind__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PathElementOrKind__Group_1__0__Impl
	rule__EMV2PathElementOrKind__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElementOrKind__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getNamedElementAssignment_1_0()); }
(rule__EMV2PathElementOrKind__NamedElementAssignment_1_0)
{ after(grammarAccess.getEMV2PathElementOrKindAccess().getNamedElementAssignment_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2PathElementOrKind__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PathElementOrKind__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElementOrKind__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getGroup_1_1()); }
(rule__EMV2PathElementOrKind__Group_1_1__0)?
{ after(grammarAccess.getEMV2PathElementOrKindAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2PathElementOrKind__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PathElementOrKind__Group_1_1__0__Impl
	rule__EMV2PathElementOrKind__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElementOrKind__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getFullStopKeyword_1_1_0()); }

	FullStop 

{ after(grammarAccess.getEMV2PathElementOrKindAccess().getFullStopKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2PathElementOrKind__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PathElementOrKind__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElementOrKind__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getPathAssignment_1_1_1()); }
(rule__EMV2PathElementOrKind__PathAssignment_1_1_1)
{ after(grammarAccess.getEMV2PathElementOrKindAccess().getPathAssignment_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2PathElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PathElement__Group__0__Impl
	rule__EMV2PathElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementAccess().getNamedElementAssignment_0()); }
(rule__EMV2PathElement__NamedElementAssignment_0)
{ after(grammarAccess.getEMV2PathElementAccess().getNamedElementAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2PathElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PathElement__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementAccess().getGroup_1()); }
(rule__EMV2PathElement__Group_1__0)?
{ after(grammarAccess.getEMV2PathElementAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2PathElement__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PathElement__Group_1__0__Impl
	rule__EMV2PathElement__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElement__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementAccess().getFullStopKeyword_1_0()); }

	FullStop 

{ after(grammarAccess.getEMV2PathElementAccess().getFullStopKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2PathElement__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2PathElement__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElement__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementAccess().getPathAssignment_1_1()); }
(rule__EMV2PathElement__PathAssignment_1_1)
{ after(grammarAccess.getEMV2PathElementAccess().getPathAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeDefinition__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeDefinition__Group__0__Impl
	rule__TypeDefinition__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getNameAssignment_0()); }
(rule__TypeDefinition__NameAssignment_0)
{ after(grammarAccess.getTypeDefinitionAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeDefinition__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeDefinition__Group__1__Impl
	rule__TypeDefinition__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getAlternatives_1()); }
(rule__TypeDefinition__Alternatives_1)
{ after(grammarAccess.getTypeDefinitionAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeDefinition__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeDefinition__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getSemicolonKeyword_2()); }

	Semicolon 

{ after(grammarAccess.getTypeDefinitionAccess().getSemicolonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypeDefinition__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeDefinition__Group_1_0__0__Impl
	rule__TypeDefinition__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getColonKeyword_1_0_0()); }

	Colon 

{ after(grammarAccess.getTypeDefinitionAccess().getColonKeyword_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeDefinition__Group_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeDefinition__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__Group_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getTypeKeyword_1_0_1()); }

	Type 

{ after(grammarAccess.getTypeDefinitionAccess().getTypeKeyword_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeDefinition__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeDefinition__Group_1_1__0__Impl
	rule__TypeDefinition__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getColonKeyword_1_1_0()); }

	Colon 

{ after(grammarAccess.getTypeDefinitionAccess().getColonKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeDefinition__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeDefinition__Group_1_1__1__Impl
	rule__TypeDefinition__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getTypeKeyword_1_1_1()); }

	Type 

{ after(grammarAccess.getTypeDefinitionAccess().getTypeKeyword_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeDefinition__Group_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeDefinition__Group_1_1__2__Impl
	rule__TypeDefinition__Group_1_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__Group_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getExtendsKeyword_1_1_2()); }

	Extends 

{ after(grammarAccess.getTypeDefinitionAccess().getExtendsKeyword_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeDefinition__Group_1_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeDefinition__Group_1_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__Group_1_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getSuperTypeAssignment_1_1_3()); }
(rule__TypeDefinition__SuperTypeAssignment_1_1_3)
{ after(grammarAccess.getTypeDefinitionAccess().getSuperTypeAssignment_1_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__TypeDefinition__Group_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeDefinition__Group_1_2__0__Impl
	rule__TypeDefinition__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__Group_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getRenamesKeyword_1_2_0()); }

	Renames 

{ after(grammarAccess.getTypeDefinitionAccess().getRenamesKeyword_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeDefinition__Group_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeDefinition__Group_1_2__1__Impl
	rule__TypeDefinition__Group_1_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__Group_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getTypeKeyword_1_2_1()); }

	Type 

{ after(grammarAccess.getTypeDefinitionAccess().getTypeKeyword_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeDefinition__Group_1_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeDefinition__Group_1_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__Group_1_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getAliasedTypeAssignment_1_2_2()); }
(rule__TypeDefinition__AliasedTypeAssignment_1_2_2)
{ after(grammarAccess.getTypeDefinitionAccess().getAliasedTypeAssignment_1_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypeSetDefinition__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetDefinition__Group__0__Impl
	rule__TypeSetDefinition__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getNameAssignment_0()); }
(rule__TypeSetDefinition__NameAssignment_0)
{ after(grammarAccess.getTypeSetDefinitionAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetDefinition__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetDefinition__Group__1__Impl
	rule__TypeSetDefinition__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getAlternatives_1()); }
(rule__TypeSetDefinition__Alternatives_1)
{ after(grammarAccess.getTypeSetDefinitionAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetDefinition__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetDefinition__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getSemicolonKeyword_2()); }

	Semicolon 

{ after(grammarAccess.getTypeSetDefinitionAccess().getSemicolonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypeSetDefinition__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetDefinition__Group_1_0__0__Impl
	rule__TypeSetDefinition__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getColonKeyword_1_0_0()); }

	Colon 

{ after(grammarAccess.getTypeSetDefinitionAccess().getColonKeyword_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetDefinition__Group_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetDefinition__Group_1_0__1__Impl
	rule__TypeSetDefinition__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__Group_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getTypeSetKeywordsParserRuleCall_1_0_1()); }
	ruleTypeSetKeywords
{ after(grammarAccess.getTypeSetDefinitionAccess().getTypeSetKeywordsParserRuleCall_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetDefinition__Group_1_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetDefinition__Group_1_0__2__Impl
	rule__TypeSetDefinition__Group_1_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__Group_1_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getLeftCurlyBracketKeyword_1_0_2()); }

	LeftCurlyBracket 

{ after(grammarAccess.getTypeSetDefinitionAccess().getLeftCurlyBracketKeyword_1_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetDefinition__Group_1_0__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetDefinition__Group_1_0__3__Impl
	rule__TypeSetDefinition__Group_1_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__Group_1_0__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getTypeTokensAssignment_1_0_3()); }
(rule__TypeSetDefinition__TypeTokensAssignment_1_0_3)
{ after(grammarAccess.getTypeSetDefinitionAccess().getTypeTokensAssignment_1_0_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetDefinition__Group_1_0__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetDefinition__Group_1_0__4__Impl
	rule__TypeSetDefinition__Group_1_0__5
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__Group_1_0__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getGroup_1_0_4()); }
(rule__TypeSetDefinition__Group_1_0_4__0)*
{ after(grammarAccess.getTypeSetDefinitionAccess().getGroup_1_0_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetDefinition__Group_1_0__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetDefinition__Group_1_0__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__Group_1_0__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getRightCurlyBracketKeyword_1_0_5()); }

	RightCurlyBracket 

{ after(grammarAccess.getTypeSetDefinitionAccess().getRightCurlyBracketKeyword_1_0_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__TypeSetDefinition__Group_1_0_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetDefinition__Group_1_0_4__0__Impl
	rule__TypeSetDefinition__Group_1_0_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__Group_1_0_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getCommaKeyword_1_0_4_0()); }

	Comma 

{ after(grammarAccess.getTypeSetDefinitionAccess().getCommaKeyword_1_0_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetDefinition__Group_1_0_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetDefinition__Group_1_0_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__Group_1_0_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getTypeTokensAssignment_1_0_4_1()); }
(rule__TypeSetDefinition__TypeTokensAssignment_1_0_4_1)
{ after(grammarAccess.getTypeSetDefinitionAccess().getTypeTokensAssignment_1_0_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeSetDefinition__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetDefinition__Group_1_1__0__Impl
	rule__TypeSetDefinition__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getRenamesKeyword_1_1_0()); }

	Renames 

{ after(grammarAccess.getTypeSetDefinitionAccess().getRenamesKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetDefinition__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetDefinition__Group_1_1__1__Impl
	rule__TypeSetDefinition__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getTypeSetKeywordsParserRuleCall_1_1_1()); }
	ruleTypeSetKeywords
{ after(grammarAccess.getTypeSetDefinitionAccess().getTypeSetKeywordsParserRuleCall_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetDefinition__Group_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetDefinition__Group_1_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__Group_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getAliasedTypeAssignment_1_1_2()); }
(rule__TypeSetDefinition__AliasedTypeAssignment_1_1_2)
{ after(grammarAccess.getTypeSetDefinitionAccess().getAliasedTypeAssignment_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypeSetConstructor__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetConstructor__Group__0__Impl
	rule__TypeSetConstructor__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetConstructor__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetConstructorAccess().getLeftCurlyBracketKeyword_0()); }

	LeftCurlyBracket 

{ after(grammarAccess.getTypeSetConstructorAccess().getLeftCurlyBracketKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetConstructor__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetConstructor__Group__1__Impl
	rule__TypeSetConstructor__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetConstructor__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetConstructorAccess().getTypeTokensAssignment_1()); }
(rule__TypeSetConstructor__TypeTokensAssignment_1)
{ after(grammarAccess.getTypeSetConstructorAccess().getTypeTokensAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetConstructor__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetConstructor__Group__2__Impl
	rule__TypeSetConstructor__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetConstructor__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetConstructorAccess().getGroup_2()); }
(rule__TypeSetConstructor__Group_2__0)*
{ after(grammarAccess.getTypeSetConstructorAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetConstructor__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetConstructor__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetConstructor__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetConstructorAccess().getRightCurlyBracketKeyword_3()); }

	RightCurlyBracket 

{ after(grammarAccess.getTypeSetConstructorAccess().getRightCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__TypeSetConstructor__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetConstructor__Group_2__0__Impl
	rule__TypeSetConstructor__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetConstructor__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetConstructorAccess().getCommaKeyword_2_0()); }

	Comma 

{ after(grammarAccess.getTypeSetConstructorAccess().getCommaKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetConstructor__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetConstructor__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetConstructor__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetConstructorAccess().getTypeTokensAssignment_2_1()); }
(rule__TypeSetConstructor__TypeTokensAssignment_2_1)
{ after(grammarAccess.getTypeSetConstructorAccess().getTypeTokensAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeSetElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetElement__Group__0__Impl
	rule__TypeSetElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetElementAccess().getTypeAssignment_0()); }
(rule__TypeSetElement__TypeAssignment_0)
{ after(grammarAccess.getTypeSetElementAccess().getTypeAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetElement__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetElementAccess().getGroup_1()); }
(rule__TypeSetElement__Group_1__0)*
{ after(grammarAccess.getTypeSetElementAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeSetElement__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetElement__Group_1__0__Impl
	rule__TypeSetElement__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetElement__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetElementAccess().getAsteriskKeyword_1_0()); }

	Asterisk 

{ after(grammarAccess.getTypeSetElementAccess().getAsteriskKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetElement__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetElement__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetElement__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetElementAccess().getTypeAssignment_1_1()); }
(rule__TypeSetElement__TypeAssignment_1_1)
{ after(grammarAccess.getTypeSetElementAccess().getTypeAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NoErrorTypeSet__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NoErrorTypeSet__Group__0__Impl
	rule__NoErrorTypeSet__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NoErrorTypeSet__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNoErrorTypeSetAccess().getTypeSetAction_0()); }
(

)
{ after(grammarAccess.getNoErrorTypeSetAccess().getTypeSetAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NoErrorTypeSet__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NoErrorTypeSet__Group__1__Impl
	rule__NoErrorTypeSet__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NoErrorTypeSet__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNoErrorTypeSetAccess().getLeftCurlyBracketKeyword_1()); }

	LeftCurlyBracket 

{ after(grammarAccess.getNoErrorTypeSetAccess().getLeftCurlyBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NoErrorTypeSet__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NoErrorTypeSet__Group__2__Impl
	rule__NoErrorTypeSet__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__NoErrorTypeSet__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNoErrorTypeSetAccess().getTypeTokensAssignment_2()); }
(rule__NoErrorTypeSet__TypeTokensAssignment_2)
{ after(grammarAccess.getNoErrorTypeSetAccess().getTypeTokensAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NoErrorTypeSet__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NoErrorTypeSet__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NoErrorTypeSet__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNoErrorTypeSetAccess().getRightCurlyBracketKeyword_3()); }

	RightCurlyBracket 

{ after(grammarAccess.getNoErrorTypeSetAccess().getRightCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__NoErrorTypeToken__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NoErrorTypeToken__Group__0__Impl
	rule__NoErrorTypeToken__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NoErrorTypeToken__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNoErrorTypeTokenAccess().getTypeTokenAction_0()); }
(

)
{ after(grammarAccess.getNoErrorTypeTokenAccess().getTypeTokenAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NoErrorTypeToken__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NoErrorTypeToken__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NoErrorTypeToken__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNoErrorTypeTokenAccess().getNoErrorAssignment_1()); }
(rule__NoErrorTypeToken__NoErrorAssignment_1)
{ after(grammarAccess.getNoErrorTypeTokenAccess().getNoErrorAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeTransformationSet__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformationSet__Group__0__Impl
	rule__TypeTransformationSet__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationSetAccess().getTypeTransformationsKeywordsParserRuleCall_0()); }
	ruleTypeTransformationsKeywords
{ after(grammarAccess.getTypeTransformationSetAccess().getTypeTransformationsKeywordsParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeTransformationSet__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformationSet__Group__1__Impl
	rule__TypeTransformationSet__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationSetAccess().getNameAssignment_1()); }
(rule__TypeTransformationSet__NameAssignment_1)
{ after(grammarAccess.getTypeTransformationSetAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeTransformationSet__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformationSet__Group__2__Impl
	rule__TypeTransformationSet__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationSetAccess().getGroup_2()); }
(rule__TypeTransformationSet__Group_2__0)?
{ after(grammarAccess.getTypeTransformationSetAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeTransformationSet__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformationSet__Group__3__Impl
	rule__TypeTransformationSet__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getTypeTransformationSetAccess().getTransformationAssignment_3()); }
(rule__TypeTransformationSet__TransformationAssignment_3)
{ after(grammarAccess.getTypeTransformationSetAccess().getTransformationAssignment_3()); }
)
(
{ before(grammarAccess.getTypeTransformationSetAccess().getTransformationAssignment_3()); }
(rule__TypeTransformationSet__TransformationAssignment_3)*
{ after(grammarAccess.getTypeTransformationSetAccess().getTransformationAssignment_3()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeTransformationSet__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformationSet__Group__4__Impl
	rule__TypeTransformationSet__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationSetAccess().getEndTransformationsKeywordsParserRuleCall_4()); }
	ruleEndTransformationsKeywords
{ after(grammarAccess.getTypeTransformationSetAccess().getEndTransformationsKeywordsParserRuleCall_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeTransformationSet__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformationSet__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationSetAccess().getSemicolonKeyword_5()); }

	Semicolon 

{ after(grammarAccess.getTypeTransformationSetAccess().getSemicolonKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__TypeTransformationSet__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformationSet__Group_2__0__Impl
	rule__TypeTransformationSet__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationSetAccess().getUseTypesKeywordsParserRuleCall_2_0()); }
	ruleUseTypesKeywords
{ after(grammarAccess.getTypeTransformationSetAccess().getUseTypesKeywordsParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeTransformationSet__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformationSet__Group_2__1__Impl
	rule__TypeTransformationSet__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationSetAccess().getUseTypesAssignment_2_1()); }
(rule__TypeTransformationSet__UseTypesAssignment_2_1)
{ after(grammarAccess.getTypeTransformationSetAccess().getUseTypesAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeTransformationSet__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformationSet__Group_2__2__Impl
	rule__TypeTransformationSet__Group_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationSetAccess().getGroup_2_2()); }
(rule__TypeTransformationSet__Group_2_2__0)*
{ after(grammarAccess.getTypeTransformationSetAccess().getGroup_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeTransformationSet__Group_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformationSet__Group_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__Group_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationSetAccess().getSemicolonKeyword_2_3()); }

	Semicolon 

{ after(grammarAccess.getTypeTransformationSetAccess().getSemicolonKeyword_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__TypeTransformationSet__Group_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformationSet__Group_2_2__0__Impl
	rule__TypeTransformationSet__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__Group_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationSetAccess().getCommaKeyword_2_2_0()); }

	Comma 

{ after(grammarAccess.getTypeTransformationSetAccess().getCommaKeyword_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeTransformationSet__Group_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformationSet__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__Group_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationSetAccess().getUseTypesAssignment_2_2_1()); }
(rule__TypeTransformationSet__UseTypesAssignment_2_2_1)
{ after(grammarAccess.getTypeTransformationSetAccess().getUseTypesAssignment_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeTransformation__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformation__Group__0__Impl
	rule__TypeTransformation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformation__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationAccess().getAlternatives_0()); }
(rule__TypeTransformation__Alternatives_0)
{ after(grammarAccess.getTypeTransformationAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeTransformation__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformation__Group__1__Impl
	rule__TypeTransformation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformation__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationAccess().getHyphenMinusLeftSquareBracketKeyword_1()); }

	HyphenMinusLeftSquareBracket 

{ after(grammarAccess.getTypeTransformationAccess().getHyphenMinusLeftSquareBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeTransformation__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformation__Group__2__Impl
	rule__TypeTransformation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformation__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationAccess().getContributorAssignment_2()); }
(rule__TypeTransformation__ContributorAssignment_2)?
{ after(grammarAccess.getTypeTransformationAccess().getContributorAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeTransformation__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformation__Group__3__Impl
	rule__TypeTransformation__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformation__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_3()); }

	RightSquareBracketHyphenMinusGreaterThanSign 

{ after(grammarAccess.getTypeTransformationAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeTransformation__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformation__Group__4__Impl
	rule__TypeTransformation__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformation__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationAccess().getTargetAssignment_4()); }
(rule__TypeTransformation__TargetAssignment_4)
{ after(grammarAccess.getTypeTransformationAccess().getTargetAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeTransformation__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformation__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformation__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationAccess().getSemicolonKeyword_5()); }

	Semicolon 

{ after(grammarAccess.getTypeTransformationAccess().getSemicolonKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__TypeMappingSet__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMappingSet__Group__0__Impl
	rule__TypeMappingSet__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingSetAccess().getTypeMappingsKeywordsParserRuleCall_0()); }
	ruleTypeMappingsKeywords
{ after(grammarAccess.getTypeMappingSetAccess().getTypeMappingsKeywordsParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeMappingSet__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMappingSet__Group__1__Impl
	rule__TypeMappingSet__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingSetAccess().getNameAssignment_1()); }
(rule__TypeMappingSet__NameAssignment_1)
{ after(grammarAccess.getTypeMappingSetAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeMappingSet__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMappingSet__Group__2__Impl
	rule__TypeMappingSet__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingSetAccess().getGroup_2()); }
(rule__TypeMappingSet__Group_2__0)?
{ after(grammarAccess.getTypeMappingSetAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeMappingSet__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMappingSet__Group__3__Impl
	rule__TypeMappingSet__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getTypeMappingSetAccess().getMappingAssignment_3()); }
(rule__TypeMappingSet__MappingAssignment_3)
{ after(grammarAccess.getTypeMappingSetAccess().getMappingAssignment_3()); }
)
(
{ before(grammarAccess.getTypeMappingSetAccess().getMappingAssignment_3()); }
(rule__TypeMappingSet__MappingAssignment_3)*
{ after(grammarAccess.getTypeMappingSetAccess().getMappingAssignment_3()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeMappingSet__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMappingSet__Group__4__Impl
	rule__TypeMappingSet__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingSetAccess().getEndMappingsKeywordsParserRuleCall_4()); }
	ruleEndMappingsKeywords
{ after(grammarAccess.getTypeMappingSetAccess().getEndMappingsKeywordsParserRuleCall_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeMappingSet__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMappingSet__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingSetAccess().getSemicolonKeyword_5()); }

	Semicolon 

{ after(grammarAccess.getTypeMappingSetAccess().getSemicolonKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__TypeMappingSet__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMappingSet__Group_2__0__Impl
	rule__TypeMappingSet__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingSetAccess().getUseTypesKeywordsParserRuleCall_2_0()); }
	ruleUseTypesKeywords
{ after(grammarAccess.getTypeMappingSetAccess().getUseTypesKeywordsParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeMappingSet__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMappingSet__Group_2__1__Impl
	rule__TypeMappingSet__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingSetAccess().getUseTypesAssignment_2_1()); }
(rule__TypeMappingSet__UseTypesAssignment_2_1)
{ after(grammarAccess.getTypeMappingSetAccess().getUseTypesAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeMappingSet__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMappingSet__Group_2__2__Impl
	rule__TypeMappingSet__Group_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingSetAccess().getGroup_2_2()); }
(rule__TypeMappingSet__Group_2_2__0)*
{ after(grammarAccess.getTypeMappingSetAccess().getGroup_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeMappingSet__Group_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMappingSet__Group_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__Group_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingSetAccess().getSemicolonKeyword_2_3()); }

	Semicolon 

{ after(grammarAccess.getTypeMappingSetAccess().getSemicolonKeyword_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__TypeMappingSet__Group_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMappingSet__Group_2_2__0__Impl
	rule__TypeMappingSet__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__Group_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingSetAccess().getCommaKeyword_2_2_0()); }

	Comma 

{ after(grammarAccess.getTypeMappingSetAccess().getCommaKeyword_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeMappingSet__Group_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMappingSet__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__Group_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingSetAccess().getUseTypesAssignment_2_2_1()); }
(rule__TypeMappingSet__UseTypesAssignment_2_2_1)
{ after(grammarAccess.getTypeMappingSetAccess().getUseTypesAssignment_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeMapping__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMapping__Group__0__Impl
	rule__TypeMapping__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMapping__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingAccess().getSourceAssignment_0()); }
(rule__TypeMapping__SourceAssignment_0)
{ after(grammarAccess.getTypeMappingAccess().getSourceAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeMapping__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMapping__Group__1__Impl
	rule__TypeMapping__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMapping__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingAccess().getHyphenMinusGreaterThanSignKeyword_1()); }

	HyphenMinusGreaterThanSign 

{ after(grammarAccess.getTypeMappingAccess().getHyphenMinusGreaterThanSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeMapping__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMapping__Group__2__Impl
	rule__TypeMapping__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMapping__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingAccess().getTargetAssignment_2()); }
(rule__TypeMapping__TargetAssignment_2)
{ after(grammarAccess.getTypeMappingAccess().getTargetAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeMapping__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMapping__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMapping__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingAccess().getSemicolonKeyword_3()); }

	Semicolon 

{ after(grammarAccess.getTypeMappingAccess().getSemicolonKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ErrorPropagation__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPropagation__Group__0__Impl
	rule__ErrorPropagation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagation__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationAccess().getErrorPropagationAction_0()); }
(

)
{ after(grammarAccess.getErrorPropagationAccess().getErrorPropagationAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPropagation__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPropagation__Group__1__Impl
	rule__ErrorPropagation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagation__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationAccess().getAlternatives_1()); }
(rule__ErrorPropagation__Alternatives_1)
{ after(grammarAccess.getErrorPropagationAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPropagation__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPropagation__Group__2__Impl
	rule__ErrorPropagation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagation__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationAccess().getColonKeyword_2()); }

	Colon 

{ after(grammarAccess.getErrorPropagationAccess().getColonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPropagation__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPropagation__Group__3__Impl
	rule__ErrorPropagation__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagation__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationAccess().getNotAssignment_3()); }
(rule__ErrorPropagation__NotAssignment_3)?
{ after(grammarAccess.getErrorPropagationAccess().getNotAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPropagation__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPropagation__Group__4__Impl
	rule__ErrorPropagation__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagation__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationAccess().getDirectionAssignment_4()); }
(rule__ErrorPropagation__DirectionAssignment_4)
{ after(grammarAccess.getErrorPropagationAccess().getDirectionAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPropagation__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPropagation__Group__5__Impl
	rule__ErrorPropagation__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagation__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationAccess().getPropagationKeyword_5()); }

	Propagation 

{ after(grammarAccess.getErrorPropagationAccess().getPropagationKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPropagation__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPropagation__Group__6__Impl
	rule__ErrorPropagation__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagation__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationAccess().getTypeSetAssignment_6()); }
(rule__ErrorPropagation__TypeSetAssignment_6)
{ after(grammarAccess.getErrorPropagationAccess().getTypeSetAssignment_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPropagation__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPropagation__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagation__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationAccess().getSemicolonKeyword_7()); }

	Semicolon 

{ after(grammarAccess.getErrorPropagationAccess().getSemicolonKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__FeatureorPPReference__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureorPPReference__Group__0__Impl
	rule__FeatureorPPReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureorPPReference__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureorPPReferenceAccess().getFeatureorPPAssignment_0()); }
(rule__FeatureorPPReference__FeatureorPPAssignment_0)
{ after(grammarAccess.getFeatureorPPReferenceAccess().getFeatureorPPAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureorPPReference__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureorPPReference__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureorPPReference__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureorPPReferenceAccess().getGroup_1()); }
(rule__FeatureorPPReference__Group_1__0)?
{ after(grammarAccess.getFeatureorPPReferenceAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__FeatureorPPReference__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureorPPReference__Group_1__0__Impl
	rule__FeatureorPPReference__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureorPPReference__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureorPPReferenceAccess().getFullStopKeyword_1_0()); }

	FullStop 

{ after(grammarAccess.getFeatureorPPReferenceAccess().getFullStopKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureorPPReference__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__FeatureorPPReference__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureorPPReference__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureorPPReferenceAccess().getNextAssignment_1_1()); }
(rule__FeatureorPPReference__NextAssignment_1_1)
{ after(grammarAccess.getFeatureorPPReferenceAccess().getNextAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorSource__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSource__Group__0__Impl
	rule__ErrorSource__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getNameAssignment_0()); }
(rule__ErrorSource__NameAssignment_0)
{ after(grammarAccess.getErrorSourceAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSource__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSource__Group__1__Impl
	rule__ErrorSource__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getColonKeyword_1()); }

	Colon 

{ after(grammarAccess.getErrorSourceAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSource__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSource__Group__2__Impl
	rule__ErrorSource__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getErrorSourceKeywordsParserRuleCall_2()); }
	ruleErrorSourceKeywords
{ after(grammarAccess.getErrorSourceAccess().getErrorSourceKeywordsParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSource__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSource__Group__3__Impl
	rule__ErrorSource__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getAlternatives_3()); }
(rule__ErrorSource__Alternatives_3)
{ after(grammarAccess.getErrorSourceAccess().getAlternatives_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSource__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSource__Group__4__Impl
	rule__ErrorSource__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getTypeTokenConstraintAssignment_4()); }
(rule__ErrorSource__TypeTokenConstraintAssignment_4)?
{ after(grammarAccess.getErrorSourceAccess().getTypeTokenConstraintAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSource__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSource__Group__5__Impl
	rule__ErrorSource__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getGroup_5()); }
(rule__ErrorSource__Group_5__0)?
{ after(grammarAccess.getErrorSourceAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSource__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSource__Group__6__Impl
	rule__ErrorSource__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getGroup_6()); }
(rule__ErrorSource__Group_6__0)?
{ after(grammarAccess.getErrorSourceAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSource__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSource__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getSemicolonKeyword_7()); }

	Semicolon 

{ after(grammarAccess.getErrorSourceAccess().getSemicolonKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__ErrorSource__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSource__Group_5__0__Impl
	rule__ErrorSource__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getWhenKeyword_5_0()); }

	When 

{ after(grammarAccess.getErrorSourceAccess().getWhenKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSource__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSource__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getAlternatives_5_1()); }
(rule__ErrorSource__Alternatives_5_1)
{ after(grammarAccess.getErrorSourceAccess().getAlternatives_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorSource__Group_5_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSource__Group_5_1_0__0__Impl
	rule__ErrorSource__Group_5_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Group_5_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getFailureModeReferenceAssignment_5_1_0_0()); }
(rule__ErrorSource__FailureModeReferenceAssignment_5_1_0_0)
{ after(grammarAccess.getErrorSourceAccess().getFailureModeReferenceAssignment_5_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSource__Group_5_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSource__Group_5_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Group_5_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getFailureModeTypeAssignment_5_1_0_1()); }
(rule__ErrorSource__FailureModeTypeAssignment_5_1_0_1)?
{ after(grammarAccess.getErrorSourceAccess().getFailureModeTypeAssignment_5_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorSource__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSource__Group_6__0__Impl
	rule__ErrorSource__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getIfKeyword_6_0()); }

	If 

{ after(grammarAccess.getErrorSourceAccess().getIfKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSource__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSource__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getFlowconditionAssignment_6_1()); }
(rule__ErrorSource__FlowconditionAssignment_6_1)
{ after(grammarAccess.getErrorSourceAccess().getFlowconditionAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorSink__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSink__Group__0__Impl
	rule__ErrorSink__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSink__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkAccess().getNameAssignment_0()); }
(rule__ErrorSink__NameAssignment_0)
{ after(grammarAccess.getErrorSinkAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSink__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSink__Group__1__Impl
	rule__ErrorSink__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSink__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkAccess().getColonKeyword_1()); }

	Colon 

{ after(grammarAccess.getErrorSinkAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSink__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSink__Group__2__Impl
	rule__ErrorSink__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSink__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkAccess().getErrorSinkKeywordsParserRuleCall_2()); }
	ruleErrorSinkKeywords
{ after(grammarAccess.getErrorSinkAccess().getErrorSinkKeywordsParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSink__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSink__Group__3__Impl
	rule__ErrorSink__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSink__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkAccess().getAlternatives_3()); }
(rule__ErrorSink__Alternatives_3)
{ after(grammarAccess.getErrorSinkAccess().getAlternatives_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSink__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSink__Group__4__Impl
	rule__ErrorSink__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSink__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkAccess().getTypeTokenConstraintAssignment_4()); }
(rule__ErrorSink__TypeTokenConstraintAssignment_4)?
{ after(grammarAccess.getErrorSinkAccess().getTypeTokenConstraintAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSink__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSink__Group__5__Impl
	rule__ErrorSink__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSink__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkAccess().getGroup_5()); }
(rule__ErrorSink__Group_5__0)?
{ after(grammarAccess.getErrorSinkAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSink__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSink__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSink__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkAccess().getSemicolonKeyword_6()); }

	Semicolon 

{ after(grammarAccess.getErrorSinkAccess().getSemicolonKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__ErrorSink__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSink__Group_5__0__Impl
	rule__ErrorSink__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSink__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkAccess().getIfKeyword_5_0()); }

	If 

{ after(grammarAccess.getErrorSinkAccess().getIfKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSink__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSink__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSink__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkAccess().getFlowconditionAssignment_5_1()); }
(rule__ErrorSink__FlowconditionAssignment_5_1)
{ after(grammarAccess.getErrorSinkAccess().getFlowconditionAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorPath__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPath__Group__0__Impl
	rule__ErrorPath__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getNameAssignment_0()); }
(rule__ErrorPath__NameAssignment_0)
{ after(grammarAccess.getErrorPathAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPath__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPath__Group__1__Impl
	rule__ErrorPath__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getColonKeyword_1()); }

	Colon 

{ after(grammarAccess.getErrorPathAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPath__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPath__Group__2__Impl
	rule__ErrorPath__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getErrorPathKeywordsParserRuleCall_2()); }
	ruleErrorPathKeywords
{ after(grammarAccess.getErrorPathAccess().getErrorPathKeywordsParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPath__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPath__Group__3__Impl
	rule__ErrorPath__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getAlternatives_3()); }
(rule__ErrorPath__Alternatives_3)
{ after(grammarAccess.getErrorPathAccess().getAlternatives_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPath__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPath__Group__4__Impl
	rule__ErrorPath__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getTypeTokenConstraintAssignment_4()); }
(rule__ErrorPath__TypeTokenConstraintAssignment_4)?
{ after(grammarAccess.getErrorPathAccess().getTypeTokenConstraintAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPath__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPath__Group__5__Impl
	rule__ErrorPath__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getHyphenMinusGreaterThanSignKeyword_5()); }

	HyphenMinusGreaterThanSign 

{ after(grammarAccess.getErrorPathAccess().getHyphenMinusGreaterThanSignKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPath__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPath__Group__6__Impl
	rule__ErrorPath__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getAlternatives_6()); }
(rule__ErrorPath__Alternatives_6)
{ after(grammarAccess.getErrorPathAccess().getAlternatives_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPath__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPath__Group__7__Impl
	rule__ErrorPath__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getAlternatives_7()); }
(rule__ErrorPath__Alternatives_7)?
{ after(grammarAccess.getErrorPathAccess().getAlternatives_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPath__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPath__Group__8__Impl
	rule__ErrorPath__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getGroup_8()); }
(rule__ErrorPath__Group_8__0)?
{ after(grammarAccess.getErrorPathAccess().getGroup_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPath__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPath__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getSemicolonKeyword_9()); }

	Semicolon 

{ after(grammarAccess.getErrorPathAccess().getSemicolonKeyword_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}






















rule__ErrorPath__Group_7_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPath__Group_7_1__0__Impl
	rule__ErrorPath__Group_7_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Group_7_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getUseMappingsKeywordsParserRuleCall_7_1_0()); }
	ruleUseMappingsKeywords
{ after(grammarAccess.getErrorPathAccess().getUseMappingsKeywordsParserRuleCall_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPath__Group_7_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPath__Group_7_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Group_7_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getTypeMappingSetAssignment_7_1_1()); }
(rule__ErrorPath__TypeMappingSetAssignment_7_1_1)
{ after(grammarAccess.getErrorPathAccess().getTypeMappingSetAssignment_7_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorPath__Group_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPath__Group_8__0__Impl
	rule__ErrorPath__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Group_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getIfKeyword_8_0()); }

	If 

{ after(grammarAccess.getErrorPathAccess().getIfKeyword_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPath__Group_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPath__Group_8__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__Group_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getFlowconditionAssignment_8_1()); }
(rule__ErrorPath__FlowconditionAssignment_8_1)
{ after(grammarAccess.getErrorPathAccess().getFlowconditionAssignment_8_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorPropagationPoint__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPropagationPoint__Group__0__Impl
	rule__ErrorPropagationPoint__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagationPoint__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationPointAccess().getGroup_0()); }
(rule__ErrorPropagationPoint__Group_0__0)*
{ after(grammarAccess.getErrorPropagationPointAccess().getGroup_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPropagationPoint__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPropagationPoint__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagationPoint__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationPointAccess().getAlternatives_1()); }
(rule__ErrorPropagationPoint__Alternatives_1)
{ after(grammarAccess.getErrorPropagationPointAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorPropagationPoint__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPropagationPoint__Group_0__0__Impl
	rule__ErrorPropagationPoint__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagationPoint__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationPointAccess().getIDTerminalRuleCall_0_0()); }
	RULE_ID
{ after(grammarAccess.getErrorPropagationPointAccess().getIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPropagationPoint__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPropagationPoint__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagationPoint__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationPointAccess().getFullStopKeyword_0_1()); }

	FullStop 

{ after(grammarAccess.getErrorPropagationPointAccess().getFullStopKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PropagationPoint__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropagationPoint__Group__0__Impl
	rule__PropagationPoint__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPoint__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPointAccess().getNameAssignment_0()); }
(rule__PropagationPoint__NameAssignment_0)
{ after(grammarAccess.getPropagationPointAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropagationPoint__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropagationPoint__Group__1__Impl
	rule__PropagationPoint__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPoint__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPointAccess().getColonKeyword_1()); }

	Colon 

{ after(grammarAccess.getPropagationPointAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropagationPoint__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropagationPoint__Group__2__Impl
	rule__PropagationPoint__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPoint__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPointAccess().getPropagationPointKeywordsParserRuleCall_2()); }
	rulePropagationPointKeywords
{ after(grammarAccess.getPropagationPointAccess().getPropagationPointKeywordsParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropagationPoint__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropagationPoint__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPoint__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPointAccess().getSemicolonKeyword_3()); }

	Semicolon 

{ after(grammarAccess.getPropagationPointAccess().getSemicolonKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__PropagationPath__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropagationPath__Group__0__Impl
	rule__PropagationPath__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPath__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPathAccess().getGroup_0()); }
(rule__PropagationPath__Group_0__0)?
{ after(grammarAccess.getPropagationPathAccess().getGroup_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropagationPath__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropagationPath__Group__1__Impl
	rule__PropagationPath__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPath__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPathAccess().getSourceAssignment_1()); }
(rule__PropagationPath__SourceAssignment_1)
{ after(grammarAccess.getPropagationPathAccess().getSourceAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropagationPath__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropagationPath__Group__2__Impl
	rule__PropagationPath__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPath__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPathAccess().getHyphenMinusGreaterThanSignKeyword_2()); }

	HyphenMinusGreaterThanSign 

{ after(grammarAccess.getPropagationPathAccess().getHyphenMinusGreaterThanSignKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropagationPath__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropagationPath__Group__3__Impl
	rule__PropagationPath__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPath__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPathAccess().getTargetAssignment_3()); }
(rule__PropagationPath__TargetAssignment_3)
{ after(grammarAccess.getPropagationPathAccess().getTargetAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropagationPath__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropagationPath__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPath__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPathAccess().getSemicolonKeyword_4()); }

	Semicolon 

{ after(grammarAccess.getPropagationPathAccess().getSemicolonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__PropagationPath__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropagationPath__Group_0__0__Impl
	rule__PropagationPath__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPath__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPathAccess().getNameAssignment_0_0()); }
(rule__PropagationPath__NameAssignment_0_0)
{ after(grammarAccess.getPropagationPathAccess().getNameAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropagationPath__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropagationPath__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPath__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPathAccess().getColonKeyword_0_1()); }

	Colon 

{ after(grammarAccess.getPropagationPathAccess().getColonKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QualifiedPropagationPoint__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPropagationPoint__Group_0__0__Impl
	rule__QualifiedPropagationPoint__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPropagationPoint__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPropagationPointAccess().getSubcomponentAssignment_0_0()); }
(rule__QualifiedPropagationPoint__SubcomponentAssignment_0_0)
{ after(grammarAccess.getQualifiedPropagationPointAccess().getSubcomponentAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedPropagationPoint__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPropagationPoint__Group_0__1__Impl
	rule__QualifiedPropagationPoint__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPropagationPoint__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPropagationPointAccess().getFullStopKeyword_0_1()); }

	FullStop 

{ after(grammarAccess.getQualifiedPropagationPointAccess().getFullStopKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedPropagationPoint__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPropagationPoint__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPropagationPoint__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPropagationPointAccess().getNextAssignment_0_2()); }
(rule__QualifiedPropagationPoint__NextAssignment_0_2)
{ after(grammarAccess.getQualifiedPropagationPointAccess().getNextAssignment_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ErrorBehaviorStateMachine__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group__0__Impl
	rule__ErrorBehaviorStateMachine__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getErrorBehaviorKeywordsParserRuleCall_0()); }
	ruleErrorBehaviorKeywords
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getErrorBehaviorKeywordsParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group__1__Impl
	rule__ErrorBehaviorStateMachine__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getNameAssignment_1()); }
(rule__ErrorBehaviorStateMachine__NameAssignment_1)
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group__2__Impl
	rule__ErrorBehaviorStateMachine__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_2()); }
(rule__ErrorBehaviorStateMachine__Group_2__0)?
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group__3__Impl
	rule__ErrorBehaviorStateMachine__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_3()); }
(rule__ErrorBehaviorStateMachine__Group_3__0)?
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group__4__Impl
	rule__ErrorBehaviorStateMachine__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_4()); }
(rule__ErrorBehaviorStateMachine__Group_4__0)?
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group__5__Impl
	rule__ErrorBehaviorStateMachine__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_5()); }
(rule__ErrorBehaviorStateMachine__Group_5__0)?
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group__6__Impl
	rule__ErrorBehaviorStateMachine__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_6()); }
(rule__ErrorBehaviorStateMachine__Group_6__0)?
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group__7__Impl
	rule__ErrorBehaviorStateMachine__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_7()); }
(rule__ErrorBehaviorStateMachine__Group_7__0)?
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group__8__Impl
	rule__ErrorBehaviorStateMachine__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getEndBehaviorKeywordsParserRuleCall_8()); }
	ruleEndBehaviorKeywords
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getEndBehaviorKeywordsParserRuleCall_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getSemicolonKeyword_9()); }

	Semicolon 

{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getSemicolonKeyword_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}






















rule__ErrorBehaviorStateMachine__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_2__0__Impl
	rule__ErrorBehaviorStateMachine__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesKeywordsParserRuleCall_2_0()); }
	ruleUseTypesKeywords
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesKeywordsParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_2__1__Impl
	rule__ErrorBehaviorStateMachine__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesAssignment_2_1()); }
(rule__ErrorBehaviorStateMachine__UseTypesAssignment_2_1)
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_2__2__Impl
	rule__ErrorBehaviorStateMachine__Group_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_2_2()); }
(rule__ErrorBehaviorStateMachine__Group_2_2__0)*
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getSemicolonKeyword_2_3()); }

	Semicolon 

{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getSemicolonKeyword_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ErrorBehaviorStateMachine__Group_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_2_2__0__Impl
	rule__ErrorBehaviorStateMachine__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getCommaKeyword_2_2_0()); }

	Comma 

{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getCommaKeyword_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesAssignment_2_2_1()); }
(rule__ErrorBehaviorStateMachine__UseTypesAssignment_2_2_1)
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesAssignment_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorBehaviorStateMachine__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_3__0__Impl
	rule__ErrorBehaviorStateMachine__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTransformationsKeywordsParserRuleCall_3_0()); }
	ruleUseTransformationsKeywords
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTransformationsKeywordsParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_3__1__Impl
	rule__ErrorBehaviorStateMachine__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTransformationAssignment_3_1()); }
(rule__ErrorBehaviorStateMachine__UseTransformationAssignment_3_1)
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTransformationAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getSemicolonKeyword_3_2()); }

	Semicolon 

{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getSemicolonKeyword_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ErrorBehaviorStateMachine__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_4__0__Impl
	rule__ErrorBehaviorStateMachine__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getEventsKeyword_4_0()); }

	Events 

{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getEventsKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getEventsAssignment_4_1()); }
(rule__ErrorBehaviorStateMachine__EventsAssignment_4_1)
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getEventsAssignment_4_1()); }
)
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getEventsAssignment_4_1()); }
(rule__ErrorBehaviorStateMachine__EventsAssignment_4_1)*
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getEventsAssignment_4_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorBehaviorStateMachine__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_5__0__Impl
	rule__ErrorBehaviorStateMachine__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getStatesKeyword_5_0()); }

	States 

{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getStatesKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getStatesAssignment_5_1()); }
(rule__ErrorBehaviorStateMachine__StatesAssignment_5_1)
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getStatesAssignment_5_1()); }
)
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getStatesAssignment_5_1()); }
(rule__ErrorBehaviorStateMachine__StatesAssignment_5_1)*
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getStatesAssignment_5_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorBehaviorStateMachine__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_6__0__Impl
	rule__ErrorBehaviorStateMachine__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getTransitionsKeyword_6_0()); }

	Transitions 

{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getTransitionsKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getTransitionsAssignment_6_1()); }
(rule__ErrorBehaviorStateMachine__TransitionsAssignment_6_1)
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getTransitionsAssignment_6_1()); }
)
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getTransitionsAssignment_6_1()); }
(rule__ErrorBehaviorStateMachine__TransitionsAssignment_6_1)*
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getTransitionsAssignment_6_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorBehaviorStateMachine__Group_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_7__0__Impl
	rule__ErrorBehaviorStateMachine__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getPropertiesKeyword_7_0()); }

	Properties 

{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getPropertiesKeyword_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorStateMachine__Group_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorStateMachine__Group_7__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__Group_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getPropertiesAssignment_7_1()); }
(rule__ErrorBehaviorStateMachine__PropertiesAssignment_7_1)
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getPropertiesAssignment_7_1()); }
)
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getPropertiesAssignment_7_1()); }
(rule__ErrorBehaviorStateMachine__PropertiesAssignment_7_1)*
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getPropertiesAssignment_7_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorEvent__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorEvent__Group__0__Impl
	rule__ErrorEvent__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorEvent__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorEventAccess().getNameAssignment_0()); }
(rule__ErrorEvent__NameAssignment_0)
{ after(grammarAccess.getErrorEventAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorEvent__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorEvent__Group__1__Impl
	rule__ErrorEvent__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorEvent__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorEventAccess().getColonKeyword_1()); }

	Colon 

{ after(grammarAccess.getErrorEventAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorEvent__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorEvent__Group__2__Impl
	rule__ErrorEvent__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorEvent__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorEventAccess().getErrorEventKeywordsParserRuleCall_2()); }
	ruleErrorEventKeywords
{ after(grammarAccess.getErrorEventAccess().getErrorEventKeywordsParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorEvent__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorEvent__Group__3__Impl
	rule__ErrorEvent__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorEvent__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorEventAccess().getTypeSetAssignment_3()); }
(rule__ErrorEvent__TypeSetAssignment_3)?
{ after(grammarAccess.getErrorEventAccess().getTypeSetAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorEvent__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorEvent__Group__4__Impl
	rule__ErrorEvent__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorEvent__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorEventAccess().getGroup_4()); }
(rule__ErrorEvent__Group_4__0)?
{ after(grammarAccess.getErrorEventAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorEvent__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorEvent__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorEvent__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorEventAccess().getSemicolonKeyword_5()); }

	Semicolon 

{ after(grammarAccess.getErrorEventAccess().getSemicolonKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__ErrorEvent__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorEvent__Group_4__0__Impl
	rule__ErrorEvent__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorEvent__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorEventAccess().getIfKeyword_4_0()); }

	If 

{ after(grammarAccess.getErrorEventAccess().getIfKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorEvent__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorEvent__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorEvent__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorEventAccess().getEventconditionAssignment_4_1()); }
(rule__ErrorEvent__EventconditionAssignment_4_1)
{ after(grammarAccess.getErrorEventAccess().getEventconditionAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__RepairEvent__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RepairEvent__Group__0__Impl
	rule__RepairEvent__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RepairEvent__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRepairEventAccess().getNameAssignment_0()); }
(rule__RepairEvent__NameAssignment_0)
{ after(grammarAccess.getRepairEventAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RepairEvent__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RepairEvent__Group__1__Impl
	rule__RepairEvent__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RepairEvent__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRepairEventAccess().getColonKeyword_1()); }

	Colon 

{ after(grammarAccess.getRepairEventAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RepairEvent__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RepairEvent__Group__2__Impl
	rule__RepairEvent__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RepairEvent__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRepairEventAccess().getRepairEventKeywordsParserRuleCall_2()); }
	ruleRepairEventKeywords
{ after(grammarAccess.getRepairEventAccess().getRepairEventKeywordsParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RepairEvent__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RepairEvent__Group__3__Impl
	rule__RepairEvent__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RepairEvent__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRepairEventAccess().getGroup_3()); }
(rule__RepairEvent__Group_3__0)?
{ after(grammarAccess.getRepairEventAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RepairEvent__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RepairEvent__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RepairEvent__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRepairEventAccess().getSemicolonKeyword_4()); }

	Semicolon 

{ after(grammarAccess.getRepairEventAccess().getSemicolonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__RepairEvent__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RepairEvent__Group_3__0__Impl
	rule__RepairEvent__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RepairEvent__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRepairEventAccess().getWhenKeyword_3_0()); }

	When 

{ after(grammarAccess.getRepairEventAccess().getWhenKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RepairEvent__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RepairEvent__Group_3__1__Impl
	rule__RepairEvent__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RepairEvent__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRepairEventAccess().getEventInitiatorAssignment_3_1()); }
(rule__RepairEvent__EventInitiatorAssignment_3_1)
{ after(grammarAccess.getRepairEventAccess().getEventInitiatorAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RepairEvent__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RepairEvent__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RepairEvent__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRepairEventAccess().getGroup_3_2()); }
(rule__RepairEvent__Group_3_2__0)*
{ after(grammarAccess.getRepairEventAccess().getGroup_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__RepairEvent__Group_3_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RepairEvent__Group_3_2__0__Impl
	rule__RepairEvent__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RepairEvent__Group_3_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRepairEventAccess().getCommaKeyword_3_2_0()); }

	Comma 

{ after(grammarAccess.getRepairEventAccess().getCommaKeyword_3_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RepairEvent__Group_3_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RepairEvent__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RepairEvent__Group_3_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRepairEventAccess().getEventInitiatorAssignment_3_2_1()); }
(rule__RepairEvent__EventInitiatorAssignment_3_2_1)
{ after(grammarAccess.getRepairEventAccess().getEventInitiatorAssignment_3_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__RecoverEvent__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecoverEvent__Group__0__Impl
	rule__RecoverEvent__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getNameAssignment_0()); }
(rule__RecoverEvent__NameAssignment_0)
{ after(grammarAccess.getRecoverEventAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RecoverEvent__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecoverEvent__Group__1__Impl
	rule__RecoverEvent__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getColonKeyword_1()); }

	Colon 

{ after(grammarAccess.getRecoverEventAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RecoverEvent__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecoverEvent__Group__2__Impl
	rule__RecoverEvent__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getRecoverEventKeywordsParserRuleCall_2()); }
	ruleRecoverEventKeywords
{ after(grammarAccess.getRecoverEventAccess().getRecoverEventKeywordsParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RecoverEvent__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecoverEvent__Group__3__Impl
	rule__RecoverEvent__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getGroup_3()); }
(rule__RecoverEvent__Group_3__0)?
{ after(grammarAccess.getRecoverEventAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RecoverEvent__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecoverEvent__Group__4__Impl
	rule__RecoverEvent__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getGroup_4()); }
(rule__RecoverEvent__Group_4__0)?
{ after(grammarAccess.getRecoverEventAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RecoverEvent__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecoverEvent__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getSemicolonKeyword_5()); }

	Semicolon 

{ after(grammarAccess.getRecoverEventAccess().getSemicolonKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__RecoverEvent__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecoverEvent__Group_3__0__Impl
	rule__RecoverEvent__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getWhenKeyword_3_0()); }

	When 

{ after(grammarAccess.getRecoverEventAccess().getWhenKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RecoverEvent__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecoverEvent__Group_3__1__Impl
	rule__RecoverEvent__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getEventInitiatorAssignment_3_1()); }
(rule__RecoverEvent__EventInitiatorAssignment_3_1)
{ after(grammarAccess.getRecoverEventAccess().getEventInitiatorAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RecoverEvent__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecoverEvent__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getGroup_3_2()); }
(rule__RecoverEvent__Group_3_2__0)*
{ after(grammarAccess.getRecoverEventAccess().getGroup_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__RecoverEvent__Group_3_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecoverEvent__Group_3_2__0__Impl
	rule__RecoverEvent__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__Group_3_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getCommaKeyword_3_2_0()); }

	Comma 

{ after(grammarAccess.getRecoverEventAccess().getCommaKeyword_3_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RecoverEvent__Group_3_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecoverEvent__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__Group_3_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getEventInitiatorAssignment_3_2_1()); }
(rule__RecoverEvent__EventInitiatorAssignment_3_2_1)
{ after(grammarAccess.getRecoverEventAccess().getEventInitiatorAssignment_3_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__RecoverEvent__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecoverEvent__Group_4__0__Impl
	rule__RecoverEvent__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getIfKeyword_4_0()); }

	If 

{ after(grammarAccess.getRecoverEventAccess().getIfKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RecoverEvent__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecoverEvent__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getConditionAssignment_4_1()); }
(rule__RecoverEvent__ConditionAssignment_4_1)
{ after(grammarAccess.getRecoverEventAccess().getConditionAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorBehaviorState__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorState__Group__0__Impl
	rule__ErrorBehaviorState__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorState__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateAccess().getNameAssignment_0()); }
(rule__ErrorBehaviorState__NameAssignment_0)
{ after(grammarAccess.getErrorBehaviorStateAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorState__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorState__Group__1__Impl
	rule__ErrorBehaviorState__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorState__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateAccess().getColonKeyword_1()); }

	Colon 

{ after(grammarAccess.getErrorBehaviorStateAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorState__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorState__Group__2__Impl
	rule__ErrorBehaviorState__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorState__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateAccess().getIntialAssignment_2()); }
(rule__ErrorBehaviorState__IntialAssignment_2)?
{ after(grammarAccess.getErrorBehaviorStateAccess().getIntialAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorState__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorState__Group__3__Impl
	rule__ErrorBehaviorState__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorState__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateAccess().getStateKeyword_3()); }

	State 

{ after(grammarAccess.getErrorBehaviorStateAccess().getStateKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorState__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorState__Group__4__Impl
	rule__ErrorBehaviorState__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorState__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateAccess().getTypeSetAssignment_4()); }
(rule__ErrorBehaviorState__TypeSetAssignment_4)?
{ after(grammarAccess.getErrorBehaviorStateAccess().getTypeSetAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorState__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorState__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorState__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateAccess().getSemicolonKeyword_5()); }

	Semicolon 

{ after(grammarAccess.getErrorBehaviorStateAccess().getSemicolonKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__ErrorBehaviorTransition__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group__0__Impl
	rule__ErrorBehaviorTransition__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_0()); }
(rule__ErrorBehaviorTransition__Group_0__0)?
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorTransition__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group__1__Impl
	rule__ErrorBehaviorTransition__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getAlternatives_1()); }
(rule__ErrorBehaviorTransition__Alternatives_1)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorTransition__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group__2__Impl
	rule__ErrorBehaviorTransition__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getHyphenMinusLeftSquareBracketKeyword_2()); }

	HyphenMinusLeftSquareBracket 

{ after(grammarAccess.getErrorBehaviorTransitionAccess().getHyphenMinusLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorTransition__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group__3__Impl
	rule__ErrorBehaviorTransition__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getConditionAssignment_3()); }
(rule__ErrorBehaviorTransition__ConditionAssignment_3)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getConditionAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorTransition__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group__4__Impl
	rule__ErrorBehaviorTransition__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_4()); }

	RightSquareBracketHyphenMinusGreaterThanSign 

{ after(grammarAccess.getErrorBehaviorTransitionAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorTransition__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group__5__Impl
	rule__ErrorBehaviorTransition__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getAlternatives_5()); }
(rule__ErrorBehaviorTransition__Alternatives_5)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getAlternatives_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorTransition__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getSemicolonKeyword_6()); }

	Semicolon 

{ after(grammarAccess.getErrorBehaviorTransitionAccess().getSemicolonKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__ErrorBehaviorTransition__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group_0__0__Impl
	rule__ErrorBehaviorTransition__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getNameAssignment_0_0()); }
(rule__ErrorBehaviorTransition__NameAssignment_0_0)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getNameAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorTransition__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getColonKeyword_0_1()); }

	Colon 

{ after(grammarAccess.getErrorBehaviorTransitionAccess().getColonKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorBehaviorTransition__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group_1_0__0__Impl
	rule__ErrorBehaviorTransition__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getSourceAssignment_1_0_0()); }
(rule__ErrorBehaviorTransition__SourceAssignment_1_0_0)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getSourceAssignment_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorTransition__Group_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getTypeTokenConstraintAssignment_1_0_1()); }
(rule__ErrorBehaviorTransition__TypeTokenConstraintAssignment_1_0_1)?
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getTypeTokenConstraintAssignment_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorBehaviorTransition__Group_5_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group_5_0__0__Impl
	rule__ErrorBehaviorTransition__Group_5_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group_5_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getTargetAssignment_5_0_0()); }
(rule__ErrorBehaviorTransition__TargetAssignment_5_0_0)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getTargetAssignment_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorTransition__Group_5_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group_5_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group_5_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getTargetTokenAssignment_5_0_1()); }
(rule__ErrorBehaviorTransition__TargetTokenAssignment_5_0_1)?
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getTargetTokenAssignment_5_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorBehaviorTransition__Group_5_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group_5_2__0__Impl
	rule__ErrorBehaviorTransition__Group_5_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group_5_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getLeftParenthesisKeyword_5_2_0()); }

	LeftParenthesis 

{ after(grammarAccess.getErrorBehaviorTransitionAccess().getLeftParenthesisKeyword_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorTransition__Group_5_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group_5_2__1__Impl
	rule__ErrorBehaviorTransition__Group_5_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group_5_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getDestinationBranchesAssignment_5_2_1()); }
(rule__ErrorBehaviorTransition__DestinationBranchesAssignment_5_2_1)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getDestinationBranchesAssignment_5_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorTransition__Group_5_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group_5_2__2__Impl
	rule__ErrorBehaviorTransition__Group_5_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group_5_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_5_2_2()); }
(rule__ErrorBehaviorTransition__Group_5_2_2__0)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_5_2_2()); }
)
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_5_2_2()); }
(rule__ErrorBehaviorTransition__Group_5_2_2__0)*
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_5_2_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorTransition__Group_5_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group_5_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group_5_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getRightParenthesisKeyword_5_2_3()); }

	RightParenthesis 

{ after(grammarAccess.getErrorBehaviorTransitionAccess().getRightParenthesisKeyword_5_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ErrorBehaviorTransition__Group_5_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group_5_2_2__0__Impl
	rule__ErrorBehaviorTransition__Group_5_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group_5_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getCommaKeyword_5_2_2_0()); }

	Comma 

{ after(grammarAccess.getErrorBehaviorTransitionAccess().getCommaKeyword_5_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorTransition__Group_5_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorTransition__Group_5_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__Group_5_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getDestinationBranchesAssignment_5_2_2_1()); }
(rule__ErrorBehaviorTransition__DestinationBranchesAssignment_5_2_2_1)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getDestinationBranchesAssignment_5_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TransitionBranch__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransitionBranch__Group__0__Impl
	rule__TransitionBranch__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionBranch__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionBranchAccess().getAlternatives_0()); }
(rule__TransitionBranch__Alternatives_0)
{ after(grammarAccess.getTransitionBranchAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransitionBranch__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransitionBranch__Group__1__Impl
	rule__TransitionBranch__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionBranch__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionBranchAccess().getWithKeyword_1()); }

	With 

{ after(grammarAccess.getTransitionBranchAccess().getWithKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransitionBranch__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransitionBranch__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionBranch__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionBranchAccess().getValueAssignment_2()); }
(rule__TransitionBranch__ValueAssignment_2)
{ after(grammarAccess.getTransitionBranchAccess().getValueAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TransitionBranch__Group_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransitionBranch__Group_0_0__0__Impl
	rule__TransitionBranch__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionBranch__Group_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionBranchAccess().getTargetAssignment_0_0_0()); }
(rule__TransitionBranch__TargetAssignment_0_0_0)
{ after(grammarAccess.getTransitionBranchAccess().getTargetAssignment_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransitionBranch__Group_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransitionBranch__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionBranch__Group_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionBranchAccess().getTargetTokenAssignment_0_0_1()); }
(rule__TransitionBranch__TargetTokenAssignment_0_0_1)?
{ after(grammarAccess.getTransitionBranchAccess().getTargetTokenAssignment_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__BranchValue__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BranchValue__Group__0__Impl
	rule__BranchValue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BranchValue__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBranchValueAccess().getBranchValueAction_0()); }
(

)
{ after(grammarAccess.getBranchValueAccess().getBranchValueAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BranchValue__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BranchValue__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BranchValue__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBranchValueAccess().getAlternatives_1()); }
(rule__BranchValue__Alternatives_1)
{ after(grammarAccess.getBranchValueAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ConditionExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConditionExpression__Group__0__Impl
	rule__ConditionExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConditionExpressionAccess().getAndExpressionParserRuleCall_0()); }
	ruleAndExpression
{ after(grammarAccess.getConditionExpressionAccess().getAndExpressionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConditionExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConditionExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConditionExpressionAccess().getGroup_1()); }
(rule__ConditionExpression__Group_1__0)*
{ after(grammarAccess.getConditionExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ConditionExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConditionExpression__Group_1__0__Impl
	rule__ConditionExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConditionExpressionAccess().getOrExpressionOperandsAction_1_0()); }
(

)
{ after(grammarAccess.getConditionExpressionAccess().getOrExpressionOperandsAction_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConditionExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConditionExpression__Group_1__1__Impl
	rule__ConditionExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConditionExpressionAccess().getOrKeyword_1_1()); }

	Or 

{ after(grammarAccess.getConditionExpressionAccess().getOrKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConditionExpression__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConditionExpression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionExpression__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConditionExpressionAccess().getOperandsAssignment_1_2()); }
(rule__ConditionExpression__OperandsAssignment_1_2)
{ after(grammarAccess.getConditionExpressionAccess().getOperandsAssignment_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AndExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AndExpression__Group__0__Impl
	rule__AndExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AndExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAndExpressionAccess().getConditionTermParserRuleCall_0()); }
	ruleConditionTerm
{ after(grammarAccess.getAndExpressionAccess().getConditionTermParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AndExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AndExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AndExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAndExpressionAccess().getGroup_1()); }
(rule__AndExpression__Group_1__0)*
{ after(grammarAccess.getAndExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AndExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AndExpression__Group_1__0__Impl
	rule__AndExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AndExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAndExpressionAccess().getAndExpressionOperandsAction_1_0()); }
(

)
{ after(grammarAccess.getAndExpressionAccess().getAndExpressionOperandsAction_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AndExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AndExpression__Group_1__1__Impl
	rule__AndExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AndExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAndExpressionAccess().getAndKeyword_1_1()); }

	And 

{ after(grammarAccess.getAndExpressionAccess().getAndKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AndExpression__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AndExpression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AndExpression__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAndExpressionAccess().getOperandsAssignment_1_2()); }
(rule__AndExpression__OperandsAssignment_1_2)
{ after(grammarAccess.getAndExpressionAccess().getOperandsAssignment_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AllExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AllExpression__Group__0__Impl
	rule__AllExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AllExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAllExpressionAccess().getAllExpressionAction_0()); }
(

)
{ after(grammarAccess.getAllExpressionAccess().getAllExpressionAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AllExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AllExpression__Group__1__Impl
	rule__AllExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AllExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAllExpressionAccess().getAllKeyword_1()); }

	All 

{ after(grammarAccess.getAllExpressionAccess().getAllKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AllExpression__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AllExpression__Group__2__Impl
	rule__AllExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AllExpression__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAllExpressionAccess().getGroup_2()); }
(rule__AllExpression__Group_2__0)?
{ after(grammarAccess.getAllExpressionAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AllExpression__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AllExpression__Group__3__Impl
	rule__AllExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AllExpression__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAllExpressionAccess().getLeftParenthesisKeyword_3()); }

	LeftParenthesis 

{ after(grammarAccess.getAllExpressionAccess().getLeftParenthesisKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AllExpression__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AllExpression__Group__4__Impl
	rule__AllExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__AllExpression__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAllExpressionAccess().getOperandsAssignment_4()); }
(rule__AllExpression__OperandsAssignment_4)
{ after(grammarAccess.getAllExpressionAccess().getOperandsAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AllExpression__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AllExpression__Group__5__Impl
	rule__AllExpression__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__AllExpression__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAllExpressionAccess().getGroup_5()); }
(rule__AllExpression__Group_5__0)*
{ after(grammarAccess.getAllExpressionAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AllExpression__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AllExpression__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AllExpression__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAllExpressionAccess().getRightParenthesisKeyword_6()); }

	RightParenthesis 

{ after(grammarAccess.getAllExpressionAccess().getRightParenthesisKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__AllExpression__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AllExpression__Group_2__0__Impl
	rule__AllExpression__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AllExpression__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAllExpressionAccess().getHyphenMinusKeyword_2_0()); }

	HyphenMinus 

{ after(grammarAccess.getAllExpressionAccess().getHyphenMinusKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AllExpression__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AllExpression__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AllExpression__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAllExpressionAccess().getCountAssignment_2_1()); }
(rule__AllExpression__CountAssignment_2_1)
{ after(grammarAccess.getAllExpressionAccess().getCountAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AllExpression__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AllExpression__Group_5__0__Impl
	rule__AllExpression__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AllExpression__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAllExpressionAccess().getCommaKeyword_5_0()); }

	Comma 

{ after(grammarAccess.getAllExpressionAccess().getCommaKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AllExpression__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AllExpression__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AllExpression__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAllExpressionAccess().getOperandsAssignment_5_1()); }
(rule__AllExpression__OperandsAssignment_5_1)
{ after(grammarAccess.getAllExpressionAccess().getOperandsAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OrmoreExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrmoreExpression__Group__0__Impl
	rule__OrmoreExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OrmoreExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrmoreExpressionAccess().getCountAssignment_0()); }
(rule__OrmoreExpression__CountAssignment_0)
{ after(grammarAccess.getOrmoreExpressionAccess().getCountAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OrmoreExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrmoreExpression__Group__1__Impl
	rule__OrmoreExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OrmoreExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrmoreExpressionAccess().getOrmoreKeyword_1()); }

	Ormore 

{ after(grammarAccess.getOrmoreExpressionAccess().getOrmoreKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OrmoreExpression__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrmoreExpression__Group__2__Impl
	rule__OrmoreExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__OrmoreExpression__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrmoreExpressionAccess().getLeftParenthesisKeyword_2()); }

	LeftParenthesis 

{ after(grammarAccess.getOrmoreExpressionAccess().getLeftParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OrmoreExpression__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrmoreExpression__Group__3__Impl
	rule__OrmoreExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__OrmoreExpression__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrmoreExpressionAccess().getOperandsAssignment_3()); }
(rule__OrmoreExpression__OperandsAssignment_3)
{ after(grammarAccess.getOrmoreExpressionAccess().getOperandsAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OrmoreExpression__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrmoreExpression__Group__4__Impl
	rule__OrmoreExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__OrmoreExpression__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrmoreExpressionAccess().getGroup_4()); }
(rule__OrmoreExpression__Group_4__0)*
{ after(grammarAccess.getOrmoreExpressionAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OrmoreExpression__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrmoreExpression__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OrmoreExpression__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrmoreExpressionAccess().getRightParenthesisKeyword_5()); }

	RightParenthesis 

{ after(grammarAccess.getOrmoreExpressionAccess().getRightParenthesisKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__OrmoreExpression__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrmoreExpression__Group_4__0__Impl
	rule__OrmoreExpression__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OrmoreExpression__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrmoreExpressionAccess().getCommaKeyword_4_0()); }

	Comma 

{ after(grammarAccess.getOrmoreExpressionAccess().getCommaKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OrmoreExpression__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrmoreExpression__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OrmoreExpression__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrmoreExpressionAccess().getOperandsAssignment_4_1()); }
(rule__OrmoreExpression__OperandsAssignment_4_1)
{ after(grammarAccess.getOrmoreExpressionAccess().getOperandsAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OrlessExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrlessExpression__Group__0__Impl
	rule__OrlessExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OrlessExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrlessExpressionAccess().getCountAssignment_0()); }
(rule__OrlessExpression__CountAssignment_0)
{ after(grammarAccess.getOrlessExpressionAccess().getCountAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OrlessExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrlessExpression__Group__1__Impl
	rule__OrlessExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OrlessExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrlessExpressionAccess().getOrlessKeyword_1()); }

	Orless 

{ after(grammarAccess.getOrlessExpressionAccess().getOrlessKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OrlessExpression__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrlessExpression__Group__2__Impl
	rule__OrlessExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__OrlessExpression__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrlessExpressionAccess().getLeftParenthesisKeyword_2()); }

	LeftParenthesis 

{ after(grammarAccess.getOrlessExpressionAccess().getLeftParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OrlessExpression__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrlessExpression__Group__3__Impl
	rule__OrlessExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__OrlessExpression__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrlessExpressionAccess().getOperandsAssignment_3()); }
(rule__OrlessExpression__OperandsAssignment_3)
{ after(grammarAccess.getOrlessExpressionAccess().getOperandsAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OrlessExpression__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrlessExpression__Group__4__Impl
	rule__OrlessExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__OrlessExpression__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrlessExpressionAccess().getGroup_4()); }
(rule__OrlessExpression__Group_4__0)*
{ after(grammarAccess.getOrlessExpressionAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OrlessExpression__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrlessExpression__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OrlessExpression__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrlessExpressionAccess().getRightParenthesisKeyword_5()); }

	RightParenthesis 

{ after(grammarAccess.getOrlessExpressionAccess().getRightParenthesisKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__OrlessExpression__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrlessExpression__Group_4__0__Impl
	rule__OrlessExpression__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OrlessExpression__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrlessExpressionAccess().getCommaKeyword_4_0()); }

	Comma 

{ after(grammarAccess.getOrlessExpressionAccess().getCommaKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OrlessExpression__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OrlessExpression__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OrlessExpression__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrlessExpressionAccess().getOperandsAssignment_4_1()); }
(rule__OrlessExpression__OperandsAssignment_4_1)
{ after(grammarAccess.getOrlessExpressionAccess().getOperandsAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ConditionTerm__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConditionTerm__Group_4__0__Impl
	rule__ConditionTerm__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionTerm__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConditionTermAccess().getLeftParenthesisKeyword_4_0()); }

	LeftParenthesis 

{ after(grammarAccess.getConditionTermAccess().getLeftParenthesisKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConditionTerm__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConditionTerm__Group_4__1__Impl
	rule__ConditionTerm__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionTerm__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConditionTermAccess().getConditionExpressionParserRuleCall_4_1()); }
	ruleConditionExpression
{ after(grammarAccess.getConditionTermAccess().getConditionExpressionParserRuleCall_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConditionTerm__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConditionTerm__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionTerm__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConditionTermAccess().getRightParenthesisKeyword_4_2()); }

	RightParenthesis 

{ after(grammarAccess.getConditionTermAccess().getRightParenthesisKeyword_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ConditionElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConditionElement__Group__0__Impl
	rule__ConditionElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConditionElementAccess().getQualifiedErrorPropagationReferenceAssignment_0()); }
(rule__ConditionElement__QualifiedErrorPropagationReferenceAssignment_0)
{ after(grammarAccess.getConditionElementAccess().getQualifiedErrorPropagationReferenceAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConditionElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConditionElement__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConditionElementAccess().getConstraintAssignment_1()); }
(rule__ConditionElement__ConstraintAssignment_1)?
{ after(grammarAccess.getConditionElementAccess().getConstraintAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QualifiedErrorEventOrPropagation__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedErrorEventOrPropagation__Group__0__Impl
	rule__QualifiedErrorEventOrPropagation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedErrorEventOrPropagation__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedErrorEventOrPropagationAccess().getQualifiedErrorEventOrPropagationAction_0()); }
(

)
{ after(grammarAccess.getQualifiedErrorEventOrPropagationAccess().getQualifiedErrorEventOrPropagationAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedErrorEventOrPropagation__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedErrorEventOrPropagation__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedErrorEventOrPropagation__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedErrorEventOrPropagationAccess().getEmv2TargetAssignment_1()); }
(rule__QualifiedErrorEventOrPropagation__Emv2TargetAssignment_1)
{ after(grammarAccess.getQualifiedErrorEventOrPropagationAccess().getEmv2TargetAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2ErrorPropagationPath__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2ErrorPropagationPath__Group_1__0__Impl
	rule__EMV2ErrorPropagationPath__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2ErrorPropagationPath__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2ErrorPropagationPathAccess().getNamedElementAssignment_1_0()); }
(rule__EMV2ErrorPropagationPath__NamedElementAssignment_1_0)
{ after(grammarAccess.getEMV2ErrorPropagationPathAccess().getNamedElementAssignment_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2ErrorPropagationPath__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2ErrorPropagationPath__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2ErrorPropagationPath__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2ErrorPropagationPathAccess().getGroup_1_1()); }
(rule__EMV2ErrorPropagationPath__Group_1_1__0)?
{ after(grammarAccess.getEMV2ErrorPropagationPathAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EMV2ErrorPropagationPath__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2ErrorPropagationPath__Group_1_1__0__Impl
	rule__EMV2ErrorPropagationPath__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2ErrorPropagationPath__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2ErrorPropagationPathAccess().getFullStopKeyword_1_1_0()); }

	FullStop 

{ after(grammarAccess.getEMV2ErrorPropagationPathAccess().getFullStopKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EMV2ErrorPropagationPath__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EMV2ErrorPropagationPath__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2ErrorPropagationPath__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2ErrorPropagationPathAccess().getPathAssignment_1_1_1()); }
(rule__EMV2ErrorPropagationPath__PathAssignment_1_1_1)
{ after(grammarAccess.getEMV2ErrorPropagationPathAccess().getPathAssignment_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OutgoingPropagationCondition__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutgoingPropagationCondition__Group__0__Impl
	rule__OutgoingPropagationCondition__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getGroup_0()); }
(rule__OutgoingPropagationCondition__Group_0__0)?
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getGroup_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutgoingPropagationCondition__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutgoingPropagationCondition__Group__1__Impl
	rule__OutgoingPropagationCondition__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getAlternatives_1()); }
(rule__OutgoingPropagationCondition__Alternatives_1)
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutgoingPropagationCondition__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutgoingPropagationCondition__Group__2__Impl
	rule__OutgoingPropagationCondition__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getHyphenMinusLeftSquareBracketKeyword_2()); }

	HyphenMinusLeftSquareBracket 

{ after(grammarAccess.getOutgoingPropagationConditionAccess().getHyphenMinusLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutgoingPropagationCondition__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutgoingPropagationCondition__Group__3__Impl
	rule__OutgoingPropagationCondition__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getConditionAssignment_3()); }
(rule__OutgoingPropagationCondition__ConditionAssignment_3)?
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getConditionAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutgoingPropagationCondition__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutgoingPropagationCondition__Group__4__Impl
	rule__OutgoingPropagationCondition__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_4()); }

	RightSquareBracketHyphenMinusGreaterThanSign 

{ after(grammarAccess.getOutgoingPropagationConditionAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutgoingPropagationCondition__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutgoingPropagationCondition__Group__5__Impl
	rule__OutgoingPropagationCondition__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getGroup_5()); }
(rule__OutgoingPropagationCondition__Group_5__0)
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutgoingPropagationCondition__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutgoingPropagationCondition__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getSemicolonKeyword_6()); }

	Semicolon 

{ after(grammarAccess.getOutgoingPropagationConditionAccess().getSemicolonKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__OutgoingPropagationCondition__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutgoingPropagationCondition__Group_0__0__Impl
	rule__OutgoingPropagationCondition__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getNameAssignment_0_0()); }
(rule__OutgoingPropagationCondition__NameAssignment_0_0)
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getNameAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutgoingPropagationCondition__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutgoingPropagationCondition__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getColonKeyword_0_1()); }

	Colon 

{ after(grammarAccess.getOutgoingPropagationConditionAccess().getColonKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OutgoingPropagationCondition__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutgoingPropagationCondition__Group_1_0__0__Impl
	rule__OutgoingPropagationCondition__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getStateAssignment_1_0_0()); }
(rule__OutgoingPropagationCondition__StateAssignment_1_0_0)
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getStateAssignment_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutgoingPropagationCondition__Group_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutgoingPropagationCondition__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__Group_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getTypeTokenConstraintAssignment_1_0_1()); }
(rule__OutgoingPropagationCondition__TypeTokenConstraintAssignment_1_0_1)?
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getTypeTokenConstraintAssignment_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OutgoingPropagationCondition__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutgoingPropagationCondition__Group_5__0__Impl
	rule__OutgoingPropagationCondition__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getAlternatives_5_0()); }
(rule__OutgoingPropagationCondition__Alternatives_5_0)
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getAlternatives_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OutgoingPropagationCondition__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OutgoingPropagationCondition__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getTypeTokenAssignment_5_1()); }
(rule__OutgoingPropagationCondition__TypeTokenAssignment_5_1)?
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getTypeTokenAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorDetection__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group__0__Impl
	rule__ErrorDetection__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getGroup_0()); }
(rule__ErrorDetection__Group_0__0)?
{ after(grammarAccess.getErrorDetectionAccess().getGroup_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorDetection__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group__1__Impl
	rule__ErrorDetection__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getAlternatives_1()); }
(rule__ErrorDetection__Alternatives_1)
{ after(grammarAccess.getErrorDetectionAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorDetection__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group__2__Impl
	rule__ErrorDetection__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getHyphenMinusLeftSquareBracketKeyword_2()); }

	HyphenMinusLeftSquareBracket 

{ after(grammarAccess.getErrorDetectionAccess().getHyphenMinusLeftSquareBracketKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorDetection__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group__3__Impl
	rule__ErrorDetection__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getConditionAssignment_3()); }
(rule__ErrorDetection__ConditionAssignment_3)?
{ after(grammarAccess.getErrorDetectionAccess().getConditionAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorDetection__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group__4__Impl
	rule__ErrorDetection__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_4()); }

	RightSquareBracketHyphenMinusGreaterThanSign 

{ after(grammarAccess.getErrorDetectionAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorDetection__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group__5__Impl
	rule__ErrorDetection__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getDetectionReportingPortAssignment_5()); }
(rule__ErrorDetection__DetectionReportingPortAssignment_5)
{ after(grammarAccess.getErrorDetectionAccess().getDetectionReportingPortAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorDetection__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group__6__Impl
	rule__ErrorDetection__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getExclamationMarkKeyword_6()); }

	ExclamationMark 

{ after(grammarAccess.getErrorDetectionAccess().getExclamationMarkKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorDetection__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group__7__Impl
	rule__ErrorDetection__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getGroup_7()); }
(rule__ErrorDetection__Group_7__0)?
{ after(grammarAccess.getErrorDetectionAccess().getGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorDetection__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getSemicolonKeyword_8()); }

	Semicolon 

{ after(grammarAccess.getErrorDetectionAccess().getSemicolonKeyword_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}




















rule__ErrorDetection__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group_0__0__Impl
	rule__ErrorDetection__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getNameAssignment_0_0()); }
(rule__ErrorDetection__NameAssignment_0_0)
{ after(grammarAccess.getErrorDetectionAccess().getNameAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorDetection__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getColonKeyword_0_1()); }

	Colon 

{ after(grammarAccess.getErrorDetectionAccess().getColonKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorDetection__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group_1_0__0__Impl
	rule__ErrorDetection__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getStateAssignment_1_0_0()); }
(rule__ErrorDetection__StateAssignment_1_0_0)
{ after(grammarAccess.getErrorDetectionAccess().getStateAssignment_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorDetection__Group_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getTypeTokenConstraintAssignment_1_0_1()); }
(rule__ErrorDetection__TypeTokenConstraintAssignment_1_0_1)?
{ after(grammarAccess.getErrorDetectionAccess().getTypeTokenConstraintAssignment_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorDetection__Group_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group_7__0__Impl
	rule__ErrorDetection__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getLeftParenthesisKeyword_7_0()); }

	LeftParenthesis 

{ after(grammarAccess.getErrorDetectionAccess().getLeftParenthesisKeyword_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorDetection__Group_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group_7__1__Impl
	rule__ErrorDetection__Group_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getErrorCodeAssignment_7_1()); }
(rule__ErrorDetection__ErrorCodeAssignment_7_1)
{ after(grammarAccess.getErrorDetectionAccess().getErrorCodeAssignment_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorDetection__Group_7__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorDetection__Group_7__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__Group_7__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getRightParenthesisKeyword_7_2()); }

	RightParenthesis 

{ after(grammarAccess.getErrorDetectionAccess().getRightParenthesisKeyword_7_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ErrorStateToModeMapping__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorStateToModeMapping__Group__0__Impl
	rule__ErrorStateToModeMapping__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorStateToModeMapping__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getErrorStateAssignment_0()); }
(rule__ErrorStateToModeMapping__ErrorStateAssignment_0)
{ after(grammarAccess.getErrorStateToModeMappingAccess().getErrorStateAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorStateToModeMapping__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorStateToModeMapping__Group__1__Impl
	rule__ErrorStateToModeMapping__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorStateToModeMapping__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getTypeTokenAssignment_1()); }
(rule__ErrorStateToModeMapping__TypeTokenAssignment_1)?
{ after(grammarAccess.getErrorStateToModeMappingAccess().getTypeTokenAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorStateToModeMapping__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorStateToModeMapping__Group__2__Impl
	rule__ErrorStateToModeMapping__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorStateToModeMapping__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getInModesKeywordsParserRuleCall_2()); }
	ruleInModesKeywords
{ after(grammarAccess.getErrorStateToModeMappingAccess().getInModesKeywordsParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorStateToModeMapping__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorStateToModeMapping__Group__3__Impl
	rule__ErrorStateToModeMapping__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorStateToModeMapping__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getLeftParenthesisKeyword_3()); }

	LeftParenthesis 

{ after(grammarAccess.getErrorStateToModeMappingAccess().getLeftParenthesisKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorStateToModeMapping__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorStateToModeMapping__Group__4__Impl
	rule__ErrorStateToModeMapping__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorStateToModeMapping__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getMappedModesAssignment_4()); }
(rule__ErrorStateToModeMapping__MappedModesAssignment_4)
{ after(grammarAccess.getErrorStateToModeMappingAccess().getMappedModesAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorStateToModeMapping__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorStateToModeMapping__Group__5__Impl
	rule__ErrorStateToModeMapping__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorStateToModeMapping__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getGroup_5()); }
(rule__ErrorStateToModeMapping__Group_5__0)*
{ after(grammarAccess.getErrorStateToModeMappingAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorStateToModeMapping__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorStateToModeMapping__Group__6__Impl
	rule__ErrorStateToModeMapping__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorStateToModeMapping__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getRightParenthesisKeyword_6()); }

	RightParenthesis 

{ after(grammarAccess.getErrorStateToModeMappingAccess().getRightParenthesisKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorStateToModeMapping__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorStateToModeMapping__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorStateToModeMapping__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getSemicolonKeyword_7()); }

	Semicolon 

{ after(grammarAccess.getErrorStateToModeMappingAccess().getSemicolonKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__ErrorStateToModeMapping__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorStateToModeMapping__Group_5__0__Impl
	rule__ErrorStateToModeMapping__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorStateToModeMapping__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getCommaKeyword_5_0()); }

	Comma 

{ after(grammarAccess.getErrorStateToModeMappingAccess().getCommaKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorStateToModeMapping__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorStateToModeMapping__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorStateToModeMapping__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getMappedModesAssignment_5_1()); }
(rule__ErrorStateToModeMapping__MappedModesAssignment_5_1)
{ after(grammarAccess.getErrorStateToModeMappingAccess().getMappedModesAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CompositeState__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CompositeState__Group__0__Impl
	rule__CompositeState__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeState__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeStateAccess().getGroup_0()); }
(rule__CompositeState__Group_0__0)?
{ after(grammarAccess.getCompositeStateAccess().getGroup_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CompositeState__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CompositeState__Group__1__Impl
	rule__CompositeState__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeState__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeStateAccess().getLeftSquareBracketKeyword_1()); }

	LeftSquareBracket 

{ after(grammarAccess.getCompositeStateAccess().getLeftSquareBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CompositeState__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CompositeState__Group__2__Impl
	rule__CompositeState__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeState__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeStateAccess().getAlternatives_2()); }
(rule__CompositeState__Alternatives_2)
{ after(grammarAccess.getCompositeStateAccess().getAlternatives_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CompositeState__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CompositeState__Group__3__Impl
	rule__CompositeState__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeState__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeStateAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_3()); }

	RightSquareBracketHyphenMinusGreaterThanSign 

{ after(grammarAccess.getCompositeStateAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CompositeState__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CompositeState__Group__4__Impl
	rule__CompositeState__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeState__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeStateAccess().getStateAssignment_4()); }
(rule__CompositeState__StateAssignment_4)
{ after(grammarAccess.getCompositeStateAccess().getStateAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CompositeState__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CompositeState__Group__5__Impl
	rule__CompositeState__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeState__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeStateAccess().getTypedTokenAssignment_5()); }
(rule__CompositeState__TypedTokenAssignment_5)?
{ after(grammarAccess.getCompositeStateAccess().getTypedTokenAssignment_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CompositeState__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CompositeState__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeState__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeStateAccess().getSemicolonKeyword_6()); }

	Semicolon 

{ after(grammarAccess.getCompositeStateAccess().getSemicolonKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__CompositeState__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CompositeState__Group_0__0__Impl
	rule__CompositeState__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeState__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeStateAccess().getNameAssignment_0_0()); }
(rule__CompositeState__NameAssignment_0_0)
{ after(grammarAccess.getCompositeStateAccess().getNameAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CompositeState__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CompositeState__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeState__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeStateAccess().getColonKeyword_0_1()); }

	Colon 

{ after(grammarAccess.getCompositeStateAccess().getColonKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SConditionExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionExpression__Group__0__Impl
	rule__SConditionExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionExpressionAccess().getSAndExpressionParserRuleCall_0()); }
	ruleSAndExpression
{ after(grammarAccess.getSConditionExpressionAccess().getSAndExpressionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SConditionExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionExpressionAccess().getGroup_1()); }
(rule__SConditionExpression__Group_1__0)*
{ after(grammarAccess.getSConditionExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SConditionExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionExpression__Group_1__0__Impl
	rule__SConditionExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionExpressionAccess().getOrExpressionOperandsAction_1_0()); }
(

)
{ after(grammarAccess.getSConditionExpressionAccess().getOrExpressionOperandsAction_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SConditionExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionExpression__Group_1__1__Impl
	rule__SConditionExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionExpressionAccess().getOrKeyword_1_1()); }

	Or 

{ after(grammarAccess.getSConditionExpressionAccess().getOrKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SConditionExpression__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionExpression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionExpression__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionExpressionAccess().getOperandsAssignment_1_2()); }
(rule__SConditionExpression__OperandsAssignment_1_2)
{ after(grammarAccess.getSConditionExpressionAccess().getOperandsAssignment_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SAndExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAndExpression__Group__0__Impl
	rule__SAndExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SAndExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAndExpressionAccess().getSConditionTermParserRuleCall_0()); }
	ruleSConditionTerm
{ after(grammarAccess.getSAndExpressionAccess().getSConditionTermParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SAndExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAndExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SAndExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAndExpressionAccess().getGroup_1()); }
(rule__SAndExpression__Group_1__0)*
{ after(grammarAccess.getSAndExpressionAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SAndExpression__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAndExpression__Group_1__0__Impl
	rule__SAndExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SAndExpression__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAndExpressionAccess().getAndExpressionOperandsAction_1_0()); }
(

)
{ after(grammarAccess.getSAndExpressionAccess().getAndExpressionOperandsAction_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SAndExpression__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAndExpression__Group_1__1__Impl
	rule__SAndExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SAndExpression__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAndExpressionAccess().getAndKeyword_1_1()); }

	And 

{ after(grammarAccess.getSAndExpressionAccess().getAndKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SAndExpression__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAndExpression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SAndExpression__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAndExpressionAccess().getOperandsAssignment_1_2()); }
(rule__SAndExpression__OperandsAssignment_1_2)
{ after(grammarAccess.getSAndExpressionAccess().getOperandsAssignment_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SOrmoreExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrmoreExpression__Group__0__Impl
	rule__SOrmoreExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrmoreExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrmoreExpressionAccess().getCountAssignment_0()); }
(rule__SOrmoreExpression__CountAssignment_0)
{ after(grammarAccess.getSOrmoreExpressionAccess().getCountAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SOrmoreExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrmoreExpression__Group__1__Impl
	rule__SOrmoreExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrmoreExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrmoreExpressionAccess().getOrmoreKeyword_1()); }

	Ormore 

{ after(grammarAccess.getSOrmoreExpressionAccess().getOrmoreKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SOrmoreExpression__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrmoreExpression__Group__2__Impl
	rule__SOrmoreExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrmoreExpression__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrmoreExpressionAccess().getLeftParenthesisKeyword_2()); }

	LeftParenthesis 

{ after(grammarAccess.getSOrmoreExpressionAccess().getLeftParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SOrmoreExpression__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrmoreExpression__Group__3__Impl
	rule__SOrmoreExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrmoreExpression__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrmoreExpressionAccess().getOperandsAssignment_3()); }
(rule__SOrmoreExpression__OperandsAssignment_3)
{ after(grammarAccess.getSOrmoreExpressionAccess().getOperandsAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SOrmoreExpression__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrmoreExpression__Group__4__Impl
	rule__SOrmoreExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrmoreExpression__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrmoreExpressionAccess().getGroup_4()); }
(rule__SOrmoreExpression__Group_4__0)*
{ after(grammarAccess.getSOrmoreExpressionAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SOrmoreExpression__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrmoreExpression__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrmoreExpression__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrmoreExpressionAccess().getRightParenthesisKeyword_5()); }

	RightParenthesis 

{ after(grammarAccess.getSOrmoreExpressionAccess().getRightParenthesisKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__SOrmoreExpression__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrmoreExpression__Group_4__0__Impl
	rule__SOrmoreExpression__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrmoreExpression__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrmoreExpressionAccess().getCommaKeyword_4_0()); }

	Comma 

{ after(grammarAccess.getSOrmoreExpressionAccess().getCommaKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SOrmoreExpression__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrmoreExpression__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrmoreExpression__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrmoreExpressionAccess().getOperandsAssignment_4_1()); }
(rule__SOrmoreExpression__OperandsAssignment_4_1)
{ after(grammarAccess.getSOrmoreExpressionAccess().getOperandsAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SOrlessExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrlessExpression__Group__0__Impl
	rule__SOrlessExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrlessExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrlessExpressionAccess().getCountAssignment_0()); }
(rule__SOrlessExpression__CountAssignment_0)
{ after(grammarAccess.getSOrlessExpressionAccess().getCountAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SOrlessExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrlessExpression__Group__1__Impl
	rule__SOrlessExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrlessExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrlessExpressionAccess().getOrlessKeyword_1()); }

	Orless 

{ after(grammarAccess.getSOrlessExpressionAccess().getOrlessKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SOrlessExpression__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrlessExpression__Group__2__Impl
	rule__SOrlessExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrlessExpression__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrlessExpressionAccess().getLeftParenthesisKeyword_2()); }

	LeftParenthesis 

{ after(grammarAccess.getSOrlessExpressionAccess().getLeftParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SOrlessExpression__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrlessExpression__Group__3__Impl
	rule__SOrlessExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrlessExpression__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrlessExpressionAccess().getOperandsAssignment_3()); }
(rule__SOrlessExpression__OperandsAssignment_3)
{ after(grammarAccess.getSOrlessExpressionAccess().getOperandsAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SOrlessExpression__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrlessExpression__Group__4__Impl
	rule__SOrlessExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrlessExpression__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrlessExpressionAccess().getGroup_4()); }
(rule__SOrlessExpression__Group_4__0)*
{ after(grammarAccess.getSOrlessExpressionAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SOrlessExpression__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrlessExpression__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrlessExpression__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrlessExpressionAccess().getRightParenthesisKeyword_5()); }

	RightParenthesis 

{ after(grammarAccess.getSOrlessExpressionAccess().getRightParenthesisKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__SOrlessExpression__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrlessExpression__Group_4__0__Impl
	rule__SOrlessExpression__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrlessExpression__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrlessExpressionAccess().getCommaKeyword_4_0()); }

	Comma 

{ after(grammarAccess.getSOrlessExpressionAccess().getCommaKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SOrlessExpression__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SOrlessExpression__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SOrlessExpression__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrlessExpressionAccess().getOperandsAssignment_4_1()); }
(rule__SOrlessExpression__OperandsAssignment_4_1)
{ after(grammarAccess.getSOrlessExpressionAccess().getOperandsAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SAllExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAllExpression__Group__0__Impl
	rule__SAllExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SAllExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAllExpressionAccess().getAllExpressionAction_0()); }
(

)
{ after(grammarAccess.getSAllExpressionAccess().getAllExpressionAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SAllExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAllExpression__Group__1__Impl
	rule__SAllExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SAllExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAllExpressionAccess().getAllKeyword_1()); }

	All 

{ after(grammarAccess.getSAllExpressionAccess().getAllKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SAllExpression__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAllExpression__Group__2__Impl
	rule__SAllExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SAllExpression__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAllExpressionAccess().getGroup_2()); }
(rule__SAllExpression__Group_2__0)?
{ after(grammarAccess.getSAllExpressionAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SAllExpression__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAllExpression__Group__3__Impl
	rule__SAllExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__SAllExpression__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAllExpressionAccess().getLeftParenthesisKeyword_3()); }

	LeftParenthesis 

{ after(grammarAccess.getSAllExpressionAccess().getLeftParenthesisKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SAllExpression__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAllExpression__Group__4__Impl
	rule__SAllExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__SAllExpression__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAllExpressionAccess().getOperandsAssignment_4()); }
(rule__SAllExpression__OperandsAssignment_4)
{ after(grammarAccess.getSAllExpressionAccess().getOperandsAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SAllExpression__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAllExpression__Group__5__Impl
	rule__SAllExpression__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__SAllExpression__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAllExpressionAccess().getGroup_5()); }
(rule__SAllExpression__Group_5__0)*
{ after(grammarAccess.getSAllExpressionAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SAllExpression__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAllExpression__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SAllExpression__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAllExpressionAccess().getRightParenthesisKeyword_6()); }

	RightParenthesis 

{ after(grammarAccess.getSAllExpressionAccess().getRightParenthesisKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__SAllExpression__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAllExpression__Group_2__0__Impl
	rule__SAllExpression__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SAllExpression__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAllExpressionAccess().getHyphenMinusKeyword_2_0()); }

	HyphenMinus 

{ after(grammarAccess.getSAllExpressionAccess().getHyphenMinusKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SAllExpression__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAllExpression__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SAllExpression__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAllExpressionAccess().getCountAssignment_2_1()); }
(rule__SAllExpression__CountAssignment_2_1)
{ after(grammarAccess.getSAllExpressionAccess().getCountAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SAllExpression__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAllExpression__Group_5__0__Impl
	rule__SAllExpression__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SAllExpression__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAllExpressionAccess().getCommaKeyword_5_0()); }

	Comma 

{ after(grammarAccess.getSAllExpressionAccess().getCommaKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SAllExpression__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SAllExpression__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SAllExpression__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAllExpressionAccess().getOperandsAssignment_5_1()); }
(rule__SAllExpression__OperandsAssignment_5_1)
{ after(grammarAccess.getSAllExpressionAccess().getOperandsAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SConditionTerm__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionTerm__Group_4__0__Impl
	rule__SConditionTerm__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionTerm__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionTermAccess().getLeftParenthesisKeyword_4_0()); }

	LeftParenthesis 

{ after(grammarAccess.getSConditionTermAccess().getLeftParenthesisKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SConditionTerm__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionTerm__Group_4__1__Impl
	rule__SConditionTerm__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionTerm__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionTermAccess().getSConditionExpressionParserRuleCall_4_1()); }
	ruleSConditionExpression
{ after(grammarAccess.getSConditionTermAccess().getSConditionExpressionParserRuleCall_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SConditionTerm__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionTerm__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionTerm__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionTermAccess().getRightParenthesisKeyword_4_2()); }

	RightParenthesis 

{ after(grammarAccess.getSConditionTermAccess().getRightParenthesisKeyword_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__QualifiedErrorPropagation__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedErrorPropagation__Group__0__Impl
	rule__QualifiedErrorPropagation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedErrorPropagation__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedErrorPropagationAccess().getQualifiedErrorPropagationAction_0()); }
(

)
{ after(grammarAccess.getQualifiedErrorPropagationAccess().getQualifiedErrorPropagationAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedErrorPropagation__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedErrorPropagation__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedErrorPropagation__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedErrorPropagationAccess().getEmv2TargetAssignment_1()); }
(rule__QualifiedErrorPropagation__Emv2TargetAssignment_1)
{ after(grammarAccess.getQualifiedErrorPropagationAccess().getEmv2TargetAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SConditionElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionElement__Group__0__Impl
	rule__SConditionElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionElementAccess().getSConditionElementAction_0()); }
(

)
{ after(grammarAccess.getSConditionElementAccess().getSConditionElementAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SConditionElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionElement__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionElementAccess().getAlternatives_1()); }
(rule__SConditionElement__Alternatives_1)
{ after(grammarAccess.getSConditionElementAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SConditionElement__Group_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionElement__Group_1_0__0__Impl
	rule__SConditionElement__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionElement__Group_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionElementAccess().getQualifiedStateAssignment_1_0_0()); }
(rule__SConditionElement__QualifiedStateAssignment_1_0_0)
{ after(grammarAccess.getSConditionElementAccess().getQualifiedStateAssignment_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SConditionElement__Group_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionElement__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionElement__Group_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionElementAccess().getConstraintAssignment_1_0_1()); }
(rule__SConditionElement__ConstraintAssignment_1_0_1)?
{ after(grammarAccess.getSConditionElementAccess().getConstraintAssignment_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SConditionElement__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionElement__Group_1_1__0__Impl
	rule__SConditionElement__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionElement__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionElementAccess().getInKeyword_1_1_0()); }

	In 

{ after(grammarAccess.getSConditionElementAccess().getInKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SConditionElement__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionElement__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionElement__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionElementAccess().getGroup_1_1_1()); }
(rule__SConditionElement__Group_1_1_1__0)
{ after(grammarAccess.getSConditionElementAccess().getGroup_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SConditionElement__Group_1_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionElement__Group_1_1_1__0__Impl
	rule__SConditionElement__Group_1_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionElement__Group_1_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionElementAccess().getQualifiedErrorPropagationReferenceAssignment_1_1_1_0()); }
(rule__SConditionElement__QualifiedErrorPropagationReferenceAssignment_1_1_1_0)
{ after(grammarAccess.getSConditionElementAccess().getQualifiedErrorPropagationReferenceAssignment_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SConditionElement__Group_1_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SConditionElement__Group_1_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionElement__Group_1_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionElementAccess().getConstraintAssignment_1_1_1_1()); }
(rule__SConditionElement__ConstraintAssignment_1_1_1_1)?
{ after(grammarAccess.getSConditionElementAccess().getConstraintAssignment_1_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QualifiedErrorBehaviorState__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedErrorBehaviorState__Group__0__Impl
	rule__QualifiedErrorBehaviorState__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedErrorBehaviorState__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedErrorBehaviorStateAccess().getSubcomponentAssignment_0()); }
(rule__QualifiedErrorBehaviorState__SubcomponentAssignment_0)
{ after(grammarAccess.getQualifiedErrorBehaviorStateAccess().getSubcomponentAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedErrorBehaviorState__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedErrorBehaviorState__Group__1__Impl
	rule__QualifiedErrorBehaviorState__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedErrorBehaviorState__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedErrorBehaviorStateAccess().getFullStopKeyword_1()); }

	FullStop 

{ after(grammarAccess.getQualifiedErrorBehaviorStateAccess().getFullStopKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedErrorBehaviorState__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedErrorBehaviorState__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedErrorBehaviorState__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedErrorBehaviorStateAccess().getAlternatives_2()); }
(rule__QualifiedErrorBehaviorState__Alternatives_2)
{ after(grammarAccess.getQualifiedErrorBehaviorStateAccess().getAlternatives_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ComponentErrorBehaviorKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentErrorBehaviorKeywords__Group__0__Impl
	rule__ComponentErrorBehaviorKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentErrorBehaviorKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentErrorBehaviorKeywordsAccess().getComponentKeyword_0()); }

	Component 

{ after(grammarAccess.getComponentErrorBehaviorKeywordsAccess().getComponentKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentErrorBehaviorKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentErrorBehaviorKeywords__Group__1__Impl
	rule__ComponentErrorBehaviorKeywords__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentErrorBehaviorKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentErrorBehaviorKeywordsAccess().getErrorKeyword_1()); }

	Error 

{ after(grammarAccess.getComponentErrorBehaviorKeywordsAccess().getErrorKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentErrorBehaviorKeywords__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ComponentErrorBehaviorKeywords__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentErrorBehaviorKeywords__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getComponentErrorBehaviorKeywordsAccess().getBehaviorKeyword_2()); }

	Behavior 

{ after(grammarAccess.getComponentErrorBehaviorKeywordsAccess().getBehaviorKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__CompositeErrorBehaviorKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CompositeErrorBehaviorKeywords__Group__0__Impl
	rule__CompositeErrorBehaviorKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeErrorBehaviorKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeErrorBehaviorKeywordsAccess().getCompositeKeyword_0()); }

	Composite 

{ after(grammarAccess.getCompositeErrorBehaviorKeywordsAccess().getCompositeKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CompositeErrorBehaviorKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CompositeErrorBehaviorKeywords__Group__1__Impl
	rule__CompositeErrorBehaviorKeywords__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeErrorBehaviorKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeErrorBehaviorKeywordsAccess().getErrorKeyword_1()); }

	Error 

{ after(grammarAccess.getCompositeErrorBehaviorKeywordsAccess().getErrorKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CompositeErrorBehaviorKeywords__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CompositeErrorBehaviorKeywords__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeErrorBehaviorKeywords__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeErrorBehaviorKeywordsAccess().getBehaviorKeyword_2()); }

	Behavior 

{ after(grammarAccess.getCompositeErrorBehaviorKeywordsAccess().getBehaviorKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ConnectionErrorKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionErrorKeywords__Group__0__Impl
	rule__ConnectionErrorKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionErrorKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionErrorKeywordsAccess().getConnectionKeyword_0()); }

	Connection 

{ after(grammarAccess.getConnectionErrorKeywordsAccess().getConnectionKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ConnectionErrorKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ConnectionErrorKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConnectionErrorKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConnectionErrorKeywordsAccess().getErrorKeyword_1()); }

	Error 

{ after(grammarAccess.getConnectionErrorKeywordsAccess().getErrorKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EndBehaviorKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndBehaviorKeywords__Group__0__Impl
	rule__EndBehaviorKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndBehaviorKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndBehaviorKeywordsAccess().getEndKeyword_0()); }

	End 

{ after(grammarAccess.getEndBehaviorKeywordsAccess().getEndKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndBehaviorKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndBehaviorKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndBehaviorKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndBehaviorKeywordsAccess().getBehaviorKeyword_1()); }

	Behavior 

{ after(grammarAccess.getEndBehaviorKeywordsAccess().getBehaviorKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EndComponentKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndComponentKeywords__Group__0__Impl
	rule__EndComponentKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndComponentKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndComponentKeywordsAccess().getEndKeyword_0()); }

	End 

{ after(grammarAccess.getEndComponentKeywordsAccess().getEndKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndComponentKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndComponentKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndComponentKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndComponentKeywordsAccess().getComponentKeyword_1()); }

	Component 

{ after(grammarAccess.getEndComponentKeywordsAccess().getComponentKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EndCompositeKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndCompositeKeywords__Group__0__Impl
	rule__EndCompositeKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndCompositeKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndCompositeKeywordsAccess().getEndKeyword_0()); }

	End 

{ after(grammarAccess.getEndCompositeKeywordsAccess().getEndKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndCompositeKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndCompositeKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndCompositeKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndCompositeKeywordsAccess().getCompositeKeyword_1()); }

	Composite 

{ after(grammarAccess.getEndCompositeKeywordsAccess().getCompositeKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EndConnectionKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndConnectionKeywords__Group__0__Impl
	rule__EndConnectionKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndConnectionKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndConnectionKeywordsAccess().getEndKeyword_0()); }

	End 

{ after(grammarAccess.getEndConnectionKeywordsAccess().getEndKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndConnectionKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndConnectionKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndConnectionKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndConnectionKeywordsAccess().getConnectionKeyword_1()); }

	Connection 

{ after(grammarAccess.getEndConnectionKeywordsAccess().getConnectionKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EndMappingsKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndMappingsKeywords__Group__0__Impl
	rule__EndMappingsKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndMappingsKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndMappingsKeywordsAccess().getEndKeyword_0()); }

	End 

{ after(grammarAccess.getEndMappingsKeywordsAccess().getEndKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndMappingsKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndMappingsKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndMappingsKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndMappingsKeywordsAccess().getMappingsKeyword_1()); }

	Mappings 

{ after(grammarAccess.getEndMappingsKeywordsAccess().getMappingsKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EndPathsKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndPathsKeywords__Group__0__Impl
	rule__EndPathsKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndPathsKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndPathsKeywordsAccess().getEndKeyword_0()); }

	End 

{ after(grammarAccess.getEndPathsKeywordsAccess().getEndKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndPathsKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndPathsKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndPathsKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndPathsKeywordsAccess().getPathsKeyword_1()); }

	Paths 

{ after(grammarAccess.getEndPathsKeywordsAccess().getPathsKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EndPropagationsKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndPropagationsKeywords__Group__0__Impl
	rule__EndPropagationsKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndPropagationsKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndPropagationsKeywordsAccess().getEndKeyword_0()); }

	End 

{ after(grammarAccess.getEndPropagationsKeywordsAccess().getEndKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndPropagationsKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndPropagationsKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndPropagationsKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndPropagationsKeywordsAccess().getPropagationsKeyword_1()); }

	Propagations 

{ after(grammarAccess.getEndPropagationsKeywordsAccess().getPropagationsKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EndSubclauseKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndSubclauseKeywords__Group__0__Impl
	rule__EndSubclauseKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndSubclauseKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndSubclauseKeywordsAccess().getEndKeyword_0()); }

	End 

{ after(grammarAccess.getEndSubclauseKeywordsAccess().getEndKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndSubclauseKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndSubclauseKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndSubclauseKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndSubclauseKeywordsAccess().getSubclauseKeyword_1()); }

	Subclause 

{ after(grammarAccess.getEndSubclauseKeywordsAccess().getSubclauseKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EndTransformationsKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndTransformationsKeywords__Group__0__Impl
	rule__EndTransformationsKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndTransformationsKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndTransformationsKeywordsAccess().getEndKeyword_0()); }

	End 

{ after(grammarAccess.getEndTransformationsKeywordsAccess().getEndKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndTransformationsKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndTransformationsKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndTransformationsKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndTransformationsKeywordsAccess().getTransformationsKeyword_1()); }

	Transformations 

{ after(grammarAccess.getEndTransformationsKeywordsAccess().getTransformationsKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EndTypesKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndTypesKeywords__Group__0__Impl
	rule__EndTypesKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EndTypesKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndTypesKeywordsAccess().getEndKeyword_0()); }

	End 

{ after(grammarAccess.getEndTypesKeywordsAccess().getEndKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EndTypesKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EndTypesKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EndTypesKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEndTypesKeywordsAccess().getTypesKeyword_1()); }

	Types 

{ after(grammarAccess.getEndTypesKeywordsAccess().getTypesKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorBehaviorKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorKeywords__Group__0__Impl
	rule__ErrorBehaviorKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorKeywordsAccess().getErrorKeyword_0()); }

	Error 

{ after(grammarAccess.getErrorBehaviorKeywordsAccess().getErrorKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorBehaviorKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorBehaviorKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorKeywordsAccess().getBehaviorKeyword_1()); }

	Behavior 

{ after(grammarAccess.getErrorBehaviorKeywordsAccess().getBehaviorKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorEventKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorEventKeywords__Group__0__Impl
	rule__ErrorEventKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorEventKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorEventKeywordsAccess().getErrorKeyword_0()); }

	Error 

{ after(grammarAccess.getErrorEventKeywordsAccess().getErrorKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorEventKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorEventKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorEventKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorEventKeywordsAccess().getEventKeyword_1()); }

	Event 

{ after(grammarAccess.getErrorEventKeywordsAccess().getEventKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorPathKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPathKeywords__Group__0__Impl
	rule__ErrorPathKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPathKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathKeywordsAccess().getErrorKeyword_0()); }

	Error 

{ after(grammarAccess.getErrorPathKeywordsAccess().getErrorKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPathKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPathKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPathKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathKeywordsAccess().getPathKeyword_1()); }

	Path 

{ after(grammarAccess.getErrorPathKeywordsAccess().getPathKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorPropagationsKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPropagationsKeywords__Group__0__Impl
	rule__ErrorPropagationsKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagationsKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationsKeywordsAccess().getErrorKeyword_0()); }

	Error 

{ after(grammarAccess.getErrorPropagationsKeywordsAccess().getErrorKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorPropagationsKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorPropagationsKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagationsKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationsKeywordsAccess().getPropagationsKeyword_1()); }

	Propagations 

{ after(grammarAccess.getErrorPropagationsKeywordsAccess().getPropagationsKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorSinkKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSinkKeywords__Group__0__Impl
	rule__ErrorSinkKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSinkKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkKeywordsAccess().getErrorKeyword_0()); }

	Error 

{ after(grammarAccess.getErrorSinkKeywordsAccess().getErrorKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSinkKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSinkKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSinkKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkKeywordsAccess().getSinkKeyword_1()); }

	Sink 

{ after(grammarAccess.getErrorSinkKeywordsAccess().getSinkKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorSourceKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSourceKeywords__Group__0__Impl
	rule__ErrorSourceKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSourceKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceKeywordsAccess().getErrorKeyword_0()); }

	Error 

{ after(grammarAccess.getErrorSourceKeywordsAccess().getErrorKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorSourceKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorSourceKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSourceKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceKeywordsAccess().getSourceKeyword_1()); }

	Source 

{ after(grammarAccess.getErrorSourceKeywordsAccess().getSourceKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ErrorTypesKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorTypesKeywords__Group__0__Impl
	rule__ErrorTypesKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorTypesKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorTypesKeywordsAccess().getErrorKeyword_0()); }

	Error 

{ after(grammarAccess.getErrorTypesKeywordsAccess().getErrorKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ErrorTypesKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ErrorTypesKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorTypesKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorTypesKeywordsAccess().getTypesKeyword_1()); }

	Types 

{ after(grammarAccess.getErrorTypesKeywordsAccess().getTypesKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ModeMappingsKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeMappingsKeywords__Group__0__Impl
	rule__ModeMappingsKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeMappingsKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeMappingsKeywordsAccess().getModeKeyword_0()); }

	Mode 

{ after(grammarAccess.getModeMappingsKeywordsAccess().getModeKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ModeMappingsKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ModeMappingsKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ModeMappingsKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getModeMappingsKeywordsAccess().getMappingsKeyword_1()); }

	Mappings 

{ after(grammarAccess.getModeMappingsKeywordsAccess().getMappingsKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PropagationPathsKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropagationPathsKeywords__Group__0__Impl
	rule__PropagationPathsKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPathsKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPathsKeywordsAccess().getPropagationKeyword_0()); }

	Propagation 

{ after(grammarAccess.getPropagationPathsKeywordsAccess().getPropagationKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropagationPathsKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropagationPathsKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPathsKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPathsKeywordsAccess().getPathsKeyword_1()); }

	Paths 

{ after(grammarAccess.getPropagationPathsKeywordsAccess().getPathsKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PropagationPointKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropagationPointKeywords__Group__0__Impl
	rule__PropagationPointKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPointKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPointKeywordsAccess().getPropagationKeyword_0()); }

	Propagation 

{ after(grammarAccess.getPropagationPointKeywordsAccess().getPropagationKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PropagationPointKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PropagationPointKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPointKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPointKeywordsAccess().getPointKeyword_1()); }

	Point 

{ after(grammarAccess.getPropagationPointKeywordsAccess().getPointKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__RecoverEventKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecoverEventKeywords__Group__0__Impl
	rule__RecoverEventKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEventKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventKeywordsAccess().getRecoverKeyword_0()); }

	Recover 

{ after(grammarAccess.getRecoverEventKeywordsAccess().getRecoverKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RecoverEventKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RecoverEventKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEventKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventKeywordsAccess().getEventKeyword_1()); }

	Event 

{ after(grammarAccess.getRecoverEventKeywordsAccess().getEventKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__RepairEventKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RepairEventKeywords__Group__0__Impl
	rule__RepairEventKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RepairEventKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRepairEventKeywordsAccess().getRepairKeyword_0()); }

	Repair 

{ after(grammarAccess.getRepairEventKeywordsAccess().getRepairKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RepairEventKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RepairEventKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RepairEventKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRepairEventKeywordsAccess().getEventKeyword_1()); }

	Event 

{ after(grammarAccess.getRepairEventKeywordsAccess().getEventKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SameStateKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SameStateKeywords__Group__0__Impl
	rule__SameStateKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SameStateKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSameStateKeywordsAccess().getSameKeyword_0()); }

	Same 

{ after(grammarAccess.getSameStateKeywordsAccess().getSameKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SameStateKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SameStateKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SameStateKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSameStateKeywordsAccess().getStateKeyword_1()); }

	State 

{ after(grammarAccess.getSameStateKeywordsAccess().getStateKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeMappingsKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMappingsKeywords__Group__0__Impl
	rule__TypeMappingsKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingsKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingsKeywordsAccess().getTypeKeyword_0()); }

	Type 

{ after(grammarAccess.getTypeMappingsKeywordsAccess().getTypeKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeMappingsKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeMappingsKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingsKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingsKeywordsAccess().getMappingsKeyword_1()); }

	Mappings 

{ after(grammarAccess.getTypeMappingsKeywordsAccess().getMappingsKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeSetKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetKeywords__Group__0__Impl
	rule__TypeSetKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetKeywordsAccess().getTypeKeyword_0()); }

	Type 

{ after(grammarAccess.getTypeSetKeywordsAccess().getTypeKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeSetKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeSetKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetKeywordsAccess().getSetKeyword_1()); }

	Set 

{ after(grammarAccess.getTypeSetKeywordsAccess().getSetKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeTransformationsKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformationsKeywords__Group__0__Impl
	rule__TypeTransformationsKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationsKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationsKeywordsAccess().getTypeKeyword_0()); }

	Type 

{ after(grammarAccess.getTypeTransformationsKeywordsAccess().getTypeKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeTransformationsKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeTransformationsKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationsKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationsKeywordsAccess().getTransformationsKeyword_1()); }

	Transformations 

{ after(grammarAccess.getTypeTransformationsKeywordsAccess().getTransformationsKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__UseBehaviorKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UseBehaviorKeywords__Group__0__Impl
	rule__UseBehaviorKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UseBehaviorKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUseBehaviorKeywordsAccess().getUseKeyword_0()); }

	Use 

{ after(grammarAccess.getUseBehaviorKeywordsAccess().getUseKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UseBehaviorKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UseBehaviorKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UseBehaviorKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUseBehaviorKeywordsAccess().getBehaviorKeyword_1()); }

	Behavior 

{ after(grammarAccess.getUseBehaviorKeywordsAccess().getBehaviorKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__UseMappingsKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UseMappingsKeywords__Group__0__Impl
	rule__UseMappingsKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UseMappingsKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUseMappingsKeywordsAccess().getUseKeyword_0()); }

	Use 

{ after(grammarAccess.getUseMappingsKeywordsAccess().getUseKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UseMappingsKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UseMappingsKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UseMappingsKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUseMappingsKeywordsAccess().getMappingsKeyword_1()); }

	Mappings 

{ after(grammarAccess.getUseMappingsKeywordsAccess().getMappingsKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__UseTransformationsKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UseTransformationsKeywords__Group__0__Impl
	rule__UseTransformationsKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UseTransformationsKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUseTransformationsKeywordsAccess().getUseKeyword_0()); }

	Use 

{ after(grammarAccess.getUseTransformationsKeywordsAccess().getUseKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UseTransformationsKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UseTransformationsKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UseTransformationsKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUseTransformationsKeywordsAccess().getTransformationsKeyword_1()); }

	Transformations 

{ after(grammarAccess.getUseTransformationsKeywordsAccess().getTransformationsKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__UseTypeEquivalenceKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UseTypeEquivalenceKeywords__Group__0__Impl
	rule__UseTypeEquivalenceKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UseTypeEquivalenceKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUseTypeEquivalenceKeywordsAccess().getUseKeyword_0()); }

	Use 

{ after(grammarAccess.getUseTypeEquivalenceKeywordsAccess().getUseKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UseTypeEquivalenceKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UseTypeEquivalenceKeywords__Group__1__Impl
	rule__UseTypeEquivalenceKeywords__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__UseTypeEquivalenceKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUseTypeEquivalenceKeywordsAccess().getTypeKeyword_1()); }

	Type 

{ after(grammarAccess.getUseTypeEquivalenceKeywordsAccess().getTypeKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UseTypeEquivalenceKeywords__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UseTypeEquivalenceKeywords__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UseTypeEquivalenceKeywords__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUseTypeEquivalenceKeywordsAccess().getEquivalenceKeyword_2()); }

	Equivalence 

{ after(grammarAccess.getUseTypeEquivalenceKeywordsAccess().getEquivalenceKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__UseTypesKeywords__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UseTypesKeywords__Group__0__Impl
	rule__UseTypesKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UseTypesKeywords__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUseTypesKeywordsAccess().getUseKeyword_0()); }

	Use 

{ after(grammarAccess.getUseTypesKeywordsAccess().getUseKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UseTypesKeywords__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UseTypesKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UseTypesKeywords__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUseTypesKeywordsAccess().getTypesKeyword_1()); }

	Types 

{ after(grammarAccess.getUseTypesKeywordsAccess().getTypesKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QUALIFIEDNAME__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QUALIFIEDNAME__Group__0__Impl
	rule__QUALIFIEDNAME__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QUALIFIEDNAME__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQUALIFIEDNAMEAccess().getIDTerminalRuleCall_0()); }
	RULE_ID
{ after(grammarAccess.getQUALIFIEDNAMEAccess().getIDTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QUALIFIEDNAME__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QUALIFIEDNAME__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QUALIFIEDNAME__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getQUALIFIEDNAMEAccess().getGroup_1()); }
(rule__QUALIFIEDNAME__Group_1__0)
{ after(grammarAccess.getQUALIFIEDNAMEAccess().getGroup_1()); }
)
(
{ before(grammarAccess.getQUALIFIEDNAMEAccess().getGroup_1()); }
(rule__QUALIFIEDNAME__Group_1__0)*
{ after(grammarAccess.getQUALIFIEDNAMEAccess().getGroup_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QUALIFIEDNAME__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QUALIFIEDNAME__Group_1__0__Impl
	rule__QUALIFIEDNAME__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QUALIFIEDNAME__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQUALIFIEDNAMEAccess().getFullStopKeyword_1_0()); }

	FullStop 

{ after(grammarAccess.getQUALIFIEDNAMEAccess().getFullStopKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QUALIFIEDNAME__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QUALIFIEDNAME__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QUALIFIEDNAME__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQUALIFIEDNAMEAccess().getIDTerminalRuleCall_1_1()); }
	RULE_ID
{ after(grammarAccess.getQUALIFIEDNAMEAccess().getIDTerminalRuleCall_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QEMREF__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QEMREF__Group__0__Impl
	rule__QEMREF__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QEMREF__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQEMREFAccess().getIDTerminalRuleCall_0()); }
	RULE_ID
{ after(grammarAccess.getQEMREFAccess().getIDTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QEMREF__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QEMREF__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QEMREF__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQEMREFAccess().getGroup_1()); }
(rule__QEMREF__Group_1__0)*
{ after(grammarAccess.getQEMREFAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QEMREF__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QEMREF__Group_1__0__Impl
	rule__QEMREF__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QEMREF__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQEMREFAccess().getColonColonKeyword_1_0()); }

	ColonColon 

{ after(grammarAccess.getQEMREFAccess().getColonColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QEMREF__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QEMREF__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QEMREF__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQEMREFAccess().getIDTerminalRuleCall_1_1()); }
	RULE_ID
{ after(grammarAccess.getQEMREFAccess().getIDTerminalRuleCall_1_1()); }
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

	Semicolon 

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

	Comma 

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

	Comma 

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

	LeftParenthesis 

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

	RightParenthesis 

{ after(grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_3()); }
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
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModesKeywordsParserRuleCall_1_0()); }
	ruleInModesKeywords
{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModesKeywordsParserRuleCall_1_0()); }
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
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_1()); }

	LeftParenthesis 

{ after(grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_1()); }
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
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_2()); }
(rule__OptionalModalPropertyValue__InModeAssignment_1_2)
{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_2()); }
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
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1_3()); }
(rule__OptionalModalPropertyValue__Group_1_3__0)*
{ after(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1_3()); }
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
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_4()); }

	RightParenthesis 

{ after(grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__OptionalModalPropertyValue__Group_1_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OptionalModalPropertyValue__Group_1_3__0__Impl
	rule__OptionalModalPropertyValue__Group_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_3_0()); }

	Comma 

{ after(grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OptionalModalPropertyValue__Group_1_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OptionalModalPropertyValue__Group_1_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_3_1()); }
(rule__OptionalModalPropertyValue__InModeAssignment_1_3_1)
{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_3_1()); }
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

	Reference 

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

	LeftParenthesis 

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

	RightParenthesis 

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

	LeftSquareBracket 

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

	RightSquareBracket 

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

	Compute 

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

	LeftParenthesis 

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

	RightParenthesis 

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

	Classifier 

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

	LeftParenthesis 

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

	RightParenthesis 

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

	LeftParenthesis 

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

	RightParenthesis 

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

	Comma 

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

	EqualsSignGreaterThanSign 

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

	Semicolon 

{ after(grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3()); }
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
{ before(grammarAccess.getContainmentPathElementAccess().getGroup_0()); }
(rule__ContainmentPathElement__Group_0__0)
{ after(grammarAccess.getContainmentPathElementAccess().getGroup_0()); }
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
{ before(grammarAccess.getContainmentPathElementAccess().getGroup_1()); }
(rule__ContainmentPathElement__Group_1__0)?
{ after(grammarAccess.getContainmentPathElementAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ContainmentPathElement__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainmentPathElement__Group_0__0__Impl
	rule__ContainmentPathElement__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathElementAccess().getNamedElementAssignment_0_0()); }
(rule__ContainmentPathElement__NamedElementAssignment_0_0)
{ after(grammarAccess.getContainmentPathElementAccess().getNamedElementAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainmentPathElement__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainmentPathElement__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathElementAccess().getArrayRangeAssignment_0_1()); }
(rule__ContainmentPathElement__ArrayRangeAssignment_0_1)*
{ after(grammarAccess.getContainmentPathElementAccess().getArrayRangeAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ContainmentPathElement__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainmentPathElement__Group_1__0__Impl
	rule__ContainmentPathElement__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0()); }

	FullStop 

{ after(grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ContainmentPathElement__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ContainmentPathElement__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathElementAccess().getPathAssignment_1_1()); }
(rule__ContainmentPathElement__PathAssignment_1_1)
{ after(grammarAccess.getContainmentPathElementAccess().getPathAssignment_1_1()); }
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

	LeftSquareBracket 

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

	RightSquareBracket 

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

	FullStopFullStop 

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

	FullStopFullStop 

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

	Delta 

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

	Applies 

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

	To 

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

	In 

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

	Binding 

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

	In 

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

	Modes 

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

	ColonColon 

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

	ColonColon 

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

	FullStop 

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







rule__EMV2Root__LibraryAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2RootAccess().getLibraryEMV2LibraryParserRuleCall_1_0_0()); }
	ruleEMV2Library{ after(grammarAccess.getEMV2RootAccess().getLibraryEMV2LibraryParserRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Root__SubclausesAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2RootAccess().getSubclausesEMV2SubclauseParserRuleCall_1_1_0()); }
	ruleEMV2Subclause{ after(grammarAccess.getEMV2RootAccess().getSubclausesEMV2SubclauseParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__UseTypesAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseTypesErrorModelLibraryCrossReference_1_1_0()); }
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getErrorModelSubclauseAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_1_0_1()); }
)
{ after(grammarAccess.getErrorModelSubclauseAccess().getUseTypesErrorModelLibraryCrossReference_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__UseTypesAssignment_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseTypesErrorModelLibraryCrossReference_1_2_1_0()); }
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getErrorModelSubclauseAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_2_1_0_1()); }
)
{ after(grammarAccess.getErrorModelSubclauseAccess().getUseTypesErrorModelLibraryCrossReference_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__TypeEquivalenceAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getTypeEquivalenceTypeMappingSetCrossReference_2_1_0()); }
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getTypeEquivalenceTypeMappingSetQEMREFParserRuleCall_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getErrorModelSubclauseAccess().getTypeEquivalenceTypeMappingSetQEMREFParserRuleCall_2_1_0_1()); }
)
{ after(grammarAccess.getErrorModelSubclauseAccess().getTypeEquivalenceTypeMappingSetCrossReference_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__TypeMappingSetAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getTypeMappingSetTypeMappingSetCrossReference_3_1_0()); }
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getTypeMappingSetTypeMappingSetQEMREFParserRuleCall_3_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getErrorModelSubclauseAccess().getTypeMappingSetTypeMappingSetQEMREFParserRuleCall_3_1_0_1()); }
)
{ after(grammarAccess.getErrorModelSubclauseAccess().getTypeMappingSetTypeMappingSetCrossReference_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__UseBehaviorAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseBehaviorErrorBehaviorStateMachineCrossReference_4_1_0()); }
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseBehaviorErrorBehaviorStateMachineQEMREFParserRuleCall_4_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getErrorModelSubclauseAccess().getUseBehaviorErrorBehaviorStateMachineQEMREFParserRuleCall_4_1_0_1()); }
)
{ after(grammarAccess.getErrorModelSubclauseAccess().getUseBehaviorErrorBehaviorStateMachineCrossReference_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__PropagationsAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getPropagationsErrorPropagationParserRuleCall_5_1_0()); }
	ruleErrorPropagation{ after(grammarAccess.getErrorModelSubclauseAccess().getPropagationsErrorPropagationParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__FlowsAssignment_5_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getFlowsErrorFlowParserRuleCall_5_2_1_0()); }
	ruleErrorFlow{ after(grammarAccess.getErrorModelSubclauseAccess().getFlowsErrorFlowParserRuleCall_5_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__UseTransformationAssignment_6_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseTransformationTypeTransformationSetCrossReference_6_1_1_0()); }
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getUseTransformationTypeTransformationSetQEMREFParserRuleCall_6_1_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getErrorModelSubclauseAccess().getUseTransformationTypeTransformationSetQEMREFParserRuleCall_6_1_1_0_1()); }
)
{ after(grammarAccess.getErrorModelSubclauseAccess().getUseTransformationTypeTransformationSetCrossReference_6_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__EventsAssignment_6_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getEventsErrorBehaviorEventParserRuleCall_6_2_1_0()); }
	ruleErrorBehaviorEvent{ after(grammarAccess.getErrorModelSubclauseAccess().getEventsErrorBehaviorEventParserRuleCall_6_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__TransitionsAssignment_6_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getTransitionsErrorBehaviorTransitionParserRuleCall_6_3_1_0()); }
	ruleErrorBehaviorTransition{ after(grammarAccess.getErrorModelSubclauseAccess().getTransitionsErrorBehaviorTransitionParserRuleCall_6_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__OutgoingPropagationConditionsAssignment_6_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getOutgoingPropagationConditionsOutgoingPropagationConditionParserRuleCall_6_4_1_0()); }
	ruleOutgoingPropagationCondition{ after(grammarAccess.getErrorModelSubclauseAccess().getOutgoingPropagationConditionsOutgoingPropagationConditionParserRuleCall_6_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__ErrorDetectionsAssignment_6_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getErrorDetectionsErrorDetectionParserRuleCall_6_5_1_0()); }
	ruleErrorDetection{ after(grammarAccess.getErrorModelSubclauseAccess().getErrorDetectionsErrorDetectionParserRuleCall_6_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__ErrorStateToModeMappingsAssignment_6_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getErrorStateToModeMappingsErrorStateToModeMappingParserRuleCall_6_6_1_0()); }
	ruleErrorStateToModeMapping{ after(grammarAccess.getErrorModelSubclauseAccess().getErrorStateToModeMappingsErrorStateToModeMappingParserRuleCall_6_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__StatesAssignment_7_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getStatesCompositeStateParserRuleCall_7_1_1_0()); }
	ruleCompositeState{ after(grammarAccess.getErrorModelSubclauseAccess().getStatesCompositeStateParserRuleCall_7_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__TypeTransformationSetAssignment_8_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getTypeTransformationSetTypeTransformationSetCrossReference_8_1_1_0()); }
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getTypeTransformationSetTypeTransformationSetQEMREFParserRuleCall_8_1_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getErrorModelSubclauseAccess().getTypeTransformationSetTypeTransformationSetQEMREFParserRuleCall_8_1_1_0_1()); }
)
{ after(grammarAccess.getErrorModelSubclauseAccess().getTypeTransformationSetTypeTransformationSetCrossReference_8_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__ConnectionErrorSourcesAssignment_8_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getConnectionErrorSourcesErrorSourceParserRuleCall_8_2_0()); }
	ruleErrorSource{ after(grammarAccess.getErrorModelSubclauseAccess().getConnectionErrorSourcesErrorSourceParserRuleCall_8_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__PointsAssignment_9_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getPointsPropagationPointParserRuleCall_9_1_0()); }
	rulePropagationPoint{ after(grammarAccess.getErrorModelSubclauseAccess().getPointsPropagationPointParserRuleCall_9_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__PathsAssignment_9_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getPathsPropagationPathParserRuleCall_9_2_0()); }
	rulePropagationPath{ after(grammarAccess.getErrorModelSubclauseAccess().getPathsPropagationPathParserRuleCall_9_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelSubclause__PropertiesAssignment_10_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelSubclauseAccess().getPropertiesEMV2PropertyAssociationParserRuleCall_10_1_0()); }
	ruleEMV2PropertyAssociation{ after(grammarAccess.getErrorModelSubclauseAccess().getPropertiesEMV2PropertyAssociationParserRuleCall_10_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getNameQCREFParserRuleCall_2_0()); }
	ruleQCREF{ after(grammarAccess.getEMV2SubclauseAccess().getNameQCREFParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__UseTypesAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseTypesErrorModelLibraryCrossReference_3_1_0()); }
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_3_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getEMV2SubclauseAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_3_1_0_1()); }
)
{ after(grammarAccess.getEMV2SubclauseAccess().getUseTypesErrorModelLibraryCrossReference_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__UseTypesAssignment_3_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseTypesErrorModelLibraryCrossReference_3_2_1_0()); }
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_3_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getEMV2SubclauseAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_3_2_1_0_1()); }
)
{ after(grammarAccess.getEMV2SubclauseAccess().getUseTypesErrorModelLibraryCrossReference_3_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__TypeEquivalenceAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getTypeEquivalenceTypeMappingSetCrossReference_4_1_0()); }
(
{ before(grammarAccess.getEMV2SubclauseAccess().getTypeEquivalenceTypeMappingSetQEMREFParserRuleCall_4_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getEMV2SubclauseAccess().getTypeEquivalenceTypeMappingSetQEMREFParserRuleCall_4_1_0_1()); }
)
{ after(grammarAccess.getEMV2SubclauseAccess().getTypeEquivalenceTypeMappingSetCrossReference_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__TypeMappingSetAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getTypeMappingSetTypeMappingSetCrossReference_5_1_0()); }
(
{ before(grammarAccess.getEMV2SubclauseAccess().getTypeMappingSetTypeMappingSetQEMREFParserRuleCall_5_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getEMV2SubclauseAccess().getTypeMappingSetTypeMappingSetQEMREFParserRuleCall_5_1_0_1()); }
)
{ after(grammarAccess.getEMV2SubclauseAccess().getTypeMappingSetTypeMappingSetCrossReference_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__UseBehaviorAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseBehaviorErrorBehaviorStateMachineCrossReference_6_1_0()); }
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseBehaviorErrorBehaviorStateMachineQEMREFParserRuleCall_6_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getEMV2SubclauseAccess().getUseBehaviorErrorBehaviorStateMachineQEMREFParserRuleCall_6_1_0_1()); }
)
{ after(grammarAccess.getEMV2SubclauseAccess().getUseBehaviorErrorBehaviorStateMachineCrossReference_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__PropagationsAssignment_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getPropagationsErrorPropagationParserRuleCall_7_1_0()); }
	ruleErrorPropagation{ after(grammarAccess.getEMV2SubclauseAccess().getPropagationsErrorPropagationParserRuleCall_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__FlowsAssignment_7_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getFlowsErrorFlowParserRuleCall_7_2_1_0()); }
	ruleErrorFlow{ after(grammarAccess.getEMV2SubclauseAccess().getFlowsErrorFlowParserRuleCall_7_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__UseTransformationAssignment_8_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseTransformationTypeTransformationSetCrossReference_8_1_1_0()); }
(
{ before(grammarAccess.getEMV2SubclauseAccess().getUseTransformationTypeTransformationSetQEMREFParserRuleCall_8_1_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getEMV2SubclauseAccess().getUseTransformationTypeTransformationSetQEMREFParserRuleCall_8_1_1_0_1()); }
)
{ after(grammarAccess.getEMV2SubclauseAccess().getUseTransformationTypeTransformationSetCrossReference_8_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__EventsAssignment_8_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getEventsErrorBehaviorEventParserRuleCall_8_2_1_0()); }
	ruleErrorBehaviorEvent{ after(grammarAccess.getEMV2SubclauseAccess().getEventsErrorBehaviorEventParserRuleCall_8_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__TransitionsAssignment_8_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getTransitionsErrorBehaviorTransitionParserRuleCall_8_3_1_0()); }
	ruleErrorBehaviorTransition{ after(grammarAccess.getEMV2SubclauseAccess().getTransitionsErrorBehaviorTransitionParserRuleCall_8_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__OutgoingPropagationConditionsAssignment_8_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getOutgoingPropagationConditionsOutgoingPropagationConditionParserRuleCall_8_4_1_0()); }
	ruleOutgoingPropagationCondition{ after(grammarAccess.getEMV2SubclauseAccess().getOutgoingPropagationConditionsOutgoingPropagationConditionParserRuleCall_8_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__ErrorDetectionsAssignment_8_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getErrorDetectionsErrorDetectionParserRuleCall_8_5_1_0()); }
	ruleErrorDetection{ after(grammarAccess.getEMV2SubclauseAccess().getErrorDetectionsErrorDetectionParserRuleCall_8_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__ErrorStateToModeMappingsAssignment_8_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getErrorStateToModeMappingsErrorStateToModeMappingParserRuleCall_8_6_1_0()); }
	ruleErrorStateToModeMapping{ after(grammarAccess.getEMV2SubclauseAccess().getErrorStateToModeMappingsErrorStateToModeMappingParserRuleCall_8_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__StatesAssignment_9_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getStatesCompositeStateParserRuleCall_9_1_1_0()); }
	ruleCompositeState{ after(grammarAccess.getEMV2SubclauseAccess().getStatesCompositeStateParserRuleCall_9_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__TypeTransformationSetAssignment_10_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getTypeTransformationSetTypeTransformationSetCrossReference_10_1_1_0()); }
(
{ before(grammarAccess.getEMV2SubclauseAccess().getTypeTransformationSetTypeTransformationSetQEMREFParserRuleCall_10_1_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getEMV2SubclauseAccess().getTypeTransformationSetTypeTransformationSetQEMREFParserRuleCall_10_1_1_0_1()); }
)
{ after(grammarAccess.getEMV2SubclauseAccess().getTypeTransformationSetTypeTransformationSetCrossReference_10_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__ConnectionErrorSourcesAssignment_10_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getConnectionErrorSourcesErrorSourceParserRuleCall_10_2_0()); }
	ruleErrorSource{ after(grammarAccess.getEMV2SubclauseAccess().getConnectionErrorSourcesErrorSourceParserRuleCall_10_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__PointsAssignment_11_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getPointsPropagationPointParserRuleCall_11_1_0()); }
	rulePropagationPoint{ after(grammarAccess.getEMV2SubclauseAccess().getPointsPropagationPointParserRuleCall_11_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__PathsAssignment_11_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getPathsPropagationPathParserRuleCall_11_2_0()); }
	rulePropagationPath{ after(grammarAccess.getEMV2SubclauseAccess().getPathsPropagationPathParserRuleCall_11_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Subclause__PropertiesAssignment_12_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2SubclauseAccess().getPropertiesEMV2PropertyAssociationParserRuleCall_12_1_0()); }
	ruleEMV2PropertyAssociation{ after(grammarAccess.getEMV2SubclauseAccess().getPropertiesEMV2PropertyAssociationParserRuleCall_12_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__UseTypesAssignment_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getUseTypesErrorModelLibraryCrossReference_1_1_1_0()); }
(
{ before(grammarAccess.getErrorModelLibraryAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_1_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getErrorModelLibraryAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_1_1_0_1()); }
)
{ after(grammarAccess.getErrorModelLibraryAccess().getUseTypesErrorModelLibraryCrossReference_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__UseTypesAssignment_1_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getUseTypesErrorModelLibraryCrossReference_1_1_2_1_0()); }
(
{ before(grammarAccess.getErrorModelLibraryAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_1_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getErrorModelLibraryAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_1_2_1_0_1()); }
)
{ after(grammarAccess.getErrorModelLibraryAccess().getUseTypesErrorModelLibraryCrossReference_1_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__ExtendsAssignment_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getExtendsErrorModelLibraryCrossReference_1_2_1_0()); }
(
{ before(grammarAccess.getErrorModelLibraryAccess().getExtendsErrorModelLibraryQEMREFParserRuleCall_1_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getErrorModelLibraryAccess().getExtendsErrorModelLibraryQEMREFParserRuleCall_1_2_1_0_1()); }
)
{ after(grammarAccess.getErrorModelLibraryAccess().getExtendsErrorModelLibraryCrossReference_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__ExtendsAssignment_1_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getExtendsErrorModelLibraryCrossReference_1_2_2_1_0()); }
(
{ before(grammarAccess.getErrorModelLibraryAccess().getExtendsErrorModelLibraryQEMREFParserRuleCall_1_2_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getErrorModelLibraryAccess().getExtendsErrorModelLibraryQEMREFParserRuleCall_1_2_2_1_0_1()); }
)
{ after(grammarAccess.getErrorModelLibraryAccess().getExtendsErrorModelLibraryCrossReference_1_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__TypesAssignment_1_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getTypesTypeDefinitionParserRuleCall_1_3_0_0()); }
	ruleTypeDefinition{ after(grammarAccess.getErrorModelLibraryAccess().getTypesTypeDefinitionParserRuleCall_1_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__TypesetsAssignment_1_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getTypesetsTypeSetDefinitionParserRuleCall_1_3_1_0()); }
	ruleTypeSetDefinition{ after(grammarAccess.getErrorModelLibraryAccess().getTypesetsTypeSetDefinitionParserRuleCall_1_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__PropertiesAssignment_1_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getPropertiesBasicEMV2PropertyAssociationParserRuleCall_1_4_1_0()); }
	ruleBasicEMV2PropertyAssociation{ after(grammarAccess.getErrorModelLibraryAccess().getPropertiesBasicEMV2PropertyAssociationParserRuleCall_1_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__BehaviorsAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getBehaviorsErrorBehaviorStateMachineParserRuleCall_2_0()); }
	ruleErrorBehaviorStateMachine{ after(grammarAccess.getErrorModelLibraryAccess().getBehaviorsErrorBehaviorStateMachineParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__MappingsAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getMappingsTypeMappingSetParserRuleCall_3_0()); }
	ruleTypeMappingSet{ after(grammarAccess.getErrorModelLibraryAccess().getMappingsTypeMappingSetParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorModelLibrary__TransformationsAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorModelLibraryAccess().getTransformationsTypeTransformationSetParserRuleCall_4_0()); }
	ruleTypeTransformationSet{ after(grammarAccess.getErrorModelLibraryAccess().getTransformationsTypeTransformationSetParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__NameAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getNameQEMREFParserRuleCall_0_1_1_0()); }
	ruleQEMREF{ after(grammarAccess.getEMV2LibraryAccess().getNameQEMREFParserRuleCall_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__UseTypesAssignment_0_1_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryCrossReference_0_1_2_1_1_0()); }
(
{ before(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_0_1_2_1_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_0_1_2_1_1_0_1()); }
)
{ after(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryCrossReference_0_1_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__UseTypesAssignment_0_1_2_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryCrossReference_0_1_2_1_2_1_0()); }
(
{ before(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_0_1_2_1_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_0_1_2_1_2_1_0_1()); }
)
{ after(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryCrossReference_0_1_2_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__ExtendsAssignment_0_1_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryCrossReference_0_1_2_2_1_0()); }
(
{ before(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryQEMREFParserRuleCall_0_1_2_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryQEMREFParserRuleCall_0_1_2_2_1_0_1()); }
)
{ after(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryCrossReference_0_1_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__ExtendsAssignment_0_1_2_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryCrossReference_0_1_2_2_2_1_0()); }
(
{ before(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryQEMREFParserRuleCall_0_1_2_2_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryQEMREFParserRuleCall_0_1_2_2_2_1_0_1()); }
)
{ after(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryCrossReference_0_1_2_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__TypesAssignment_0_1_2_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getTypesTypeDefinitionParserRuleCall_0_1_2_3_0_0()); }
	ruleTypeDefinition{ after(grammarAccess.getEMV2LibraryAccess().getTypesTypeDefinitionParserRuleCall_0_1_2_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__TypesetsAssignment_0_1_2_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getTypesetsTypeSetDefinitionParserRuleCall_0_1_2_3_1_0()); }
	ruleTypeSetDefinition{ after(grammarAccess.getEMV2LibraryAccess().getTypesetsTypeSetDefinitionParserRuleCall_0_1_2_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__PropertiesAssignment_0_1_2_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getPropertiesBasicEMV2PropertyAssociationParserRuleCall_0_1_2_4_1_0()); }
	ruleBasicEMV2PropertyAssociation{ after(grammarAccess.getEMV2LibraryAccess().getPropertiesBasicEMV2PropertyAssociationParserRuleCall_0_1_2_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__BehaviorsAssignment_0_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getBehaviorsErrorBehaviorStateMachineParserRuleCall_0_1_3_0()); }
	ruleErrorBehaviorStateMachine{ after(grammarAccess.getEMV2LibraryAccess().getBehaviorsErrorBehaviorStateMachineParserRuleCall_0_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__MappingsAssignment_0_1_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getMappingsTypeMappingSetParserRuleCall_0_1_4_0()); }
	ruleTypeMappingSet{ after(grammarAccess.getEMV2LibraryAccess().getMappingsTypeMappingSetParserRuleCall_0_1_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__TransformationsAssignment_0_1_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getTransformationsTypeTransformationSetParserRuleCall_0_1_5_0()); }
	ruleTypeTransformationSet{ after(grammarAccess.getEMV2LibraryAccess().getTransformationsTypeTransformationSetParserRuleCall_0_1_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__NameAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getNameQEMREFParserRuleCall_1_1_0()); }
	ruleQEMREF{ after(grammarAccess.getEMV2LibraryAccess().getNameQEMREFParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__UseTypesAssignment_1_6_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryCrossReference_1_6_1_1_0()); }
(
{ before(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_6_1_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_6_1_1_0_1()); }
)
{ after(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryCrossReference_1_6_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__UseTypesAssignment_1_6_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryCrossReference_1_6_1_2_1_0()); }
(
{ before(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_6_1_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_1_6_1_2_1_0_1()); }
)
{ after(grammarAccess.getEMV2LibraryAccess().getUseTypesErrorModelLibraryCrossReference_1_6_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__ExtendsAssignment_1_6_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryCrossReference_1_6_2_1_0()); }
(
{ before(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryQEMREFParserRuleCall_1_6_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryQEMREFParserRuleCall_1_6_2_1_0_1()); }
)
{ after(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryCrossReference_1_6_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__ExtendsAssignment_1_6_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryCrossReference_1_6_2_2_1_0()); }
(
{ before(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryQEMREFParserRuleCall_1_6_2_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryQEMREFParserRuleCall_1_6_2_2_1_0_1()); }
)
{ after(grammarAccess.getEMV2LibraryAccess().getExtendsErrorModelLibraryCrossReference_1_6_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__TypesAssignment_1_6_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getTypesTypeDefinitionParserRuleCall_1_6_3_0_0()); }
	ruleTypeDefinition{ after(grammarAccess.getEMV2LibraryAccess().getTypesTypeDefinitionParserRuleCall_1_6_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__TypesetsAssignment_1_6_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getTypesetsTypeSetDefinitionParserRuleCall_1_6_3_1_0()); }
	ruleTypeSetDefinition{ after(grammarAccess.getEMV2LibraryAccess().getTypesetsTypeSetDefinitionParserRuleCall_1_6_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__PropertiesAssignment_1_6_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getPropertiesBasicEMV2PropertyAssociationParserRuleCall_1_6_4_1_0()); }
	ruleBasicEMV2PropertyAssociation{ after(grammarAccess.getEMV2LibraryAccess().getPropertiesBasicEMV2PropertyAssociationParserRuleCall_1_6_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__BehaviorsAssignment_1_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getBehaviorsErrorBehaviorStateMachineParserRuleCall_1_7_0()); }
	ruleErrorBehaviorStateMachine{ after(grammarAccess.getEMV2LibraryAccess().getBehaviorsErrorBehaviorStateMachineParserRuleCall_1_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__MappingsAssignment_1_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getMappingsTypeMappingSetParserRuleCall_1_8_0()); }
	ruleTypeMappingSet{ after(grammarAccess.getEMV2LibraryAccess().getMappingsTypeMappingSetParserRuleCall_1_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Library__TransformationsAssignment_1_9
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2LibraryAccess().getTransformationsTypeTransformationSetParserRuleCall_1_9_0()); }
	ruleTypeTransformationSet{ after(grammarAccess.getEMV2LibraryAccess().getTransformationsTypeTransformationSetParserRuleCall_1_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__PropertyAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); }
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getPropertyPropertyQPREFParserRuleCall_0_0_1()); }
	ruleQPREF{ after(grammarAccess.getEMV2PropertyAssociationAccess().getPropertyPropertyQPREFParserRuleCall_0_0_1()); }
)
{ after(grammarAccess.getEMV2PropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__OwnedValuesAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_0_0()); }
	ruleOptionalModalPropertyValue{ after(grammarAccess.getEMV2PropertyAssociationAccess().getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__OwnedValuesAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_1_1_0()); }
	ruleOptionalModalPropertyValue{ after(grammarAccess.getEMV2PropertyAssociationAccess().getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Emv2PathAssignment_3_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getEmv2PathEMV2PathParserRuleCall_3_1_0_0()); }
	ruleEMV2Path{ after(grammarAccess.getEMV2PropertyAssociationAccess().getEmv2PathEMV2PathParserRuleCall_3_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PropertyAssociation__Emv2PathAssignment_3_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PropertyAssociationAccess().getEmv2PathEMV2PathParserRuleCall_3_1_1_1_0()); }
	ruleEMV2Path{ after(grammarAccess.getEMV2PropertyAssociationAccess().getEmv2PathEMV2PathParserRuleCall_3_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__PropertyAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); }
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getPropertyPropertyQPREFParserRuleCall_0_0_1()); }
	ruleQPREF{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getPropertyPropertyQPREFParserRuleCall_0_0_1()); }
)
{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__OwnedValuesAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_0_0()); }
	ruleOptionalModalPropertyValue{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__OwnedValuesAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_1_1_0()); }
	ruleOptionalModalPropertyValue{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getOwnedValuesOptionalModalPropertyValueParserRuleCall_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Emv2PathAssignment_3_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getEmv2PathBasicEMV2PathParserRuleCall_3_1_0_0()); }
	ruleBasicEMV2Path{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getEmv2PathBasicEMV2PathParserRuleCall_3_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2PropertyAssociation__Emv2PathAssignment_3_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PropertyAssociationAccess().getEmv2PathBasicEMV2PathParserRuleCall_3_1_1_1_0()); }
	ruleBasicEMV2Path{ after(grammarAccess.getBasicEMV2PropertyAssociationAccess().getEmv2PathBasicEMV2PathParserRuleCall_3_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Path__ContainmentPathAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathAccess().getContainmentPathContainmentPathElementParserRuleCall_0_1_0()); }
	ruleContainmentPathElement{ after(grammarAccess.getEMV2PathAccess().getContainmentPathContainmentPathElementParserRuleCall_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2Path__Emv2TargetAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathAccess().getEmv2TargetEMV2PathElementOrKindParserRuleCall_1_0()); }
	ruleEMV2PathElementOrKind{ after(grammarAccess.getEMV2PathAccess().getEmv2TargetEMV2PathElementOrKindParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BasicEMV2Path__Emv2TargetAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBasicEMV2PathAccess().getEmv2TargetEMV2PathElementOrKindParserRuleCall_0()); }
	ruleEMV2PathElementOrKind{ after(grammarAccess.getBasicEMV2PathAccess().getEmv2TargetEMV2PathElementOrKindParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElementOrKind__Emv2PropagationKindAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getEmv2PropagationKindPropagationKindParserRuleCall_0_0_0()); }
	rulePropagationKind{ after(grammarAccess.getEMV2PathElementOrKindAccess().getEmv2PropagationKindPropagationKindParserRuleCall_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElementOrKind__ErrorTypeAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getErrorTypeErrorTypesCrossReference_0_1_1_0()); }
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getErrorTypeErrorTypesIDTerminalRuleCall_0_1_1_0_1()); }
	RULE_ID{ after(grammarAccess.getEMV2PathElementOrKindAccess().getErrorTypeErrorTypesIDTerminalRuleCall_0_1_1_0_1()); }
)
{ after(grammarAccess.getEMV2PathElementOrKindAccess().getErrorTypeErrorTypesCrossReference_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElementOrKind__NamedElementAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getNamedElementNamedElementCrossReference_1_0_0()); }
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getNamedElementNamedElementIDTerminalRuleCall_1_0_0_1()); }
	RULE_ID{ after(grammarAccess.getEMV2PathElementOrKindAccess().getNamedElementNamedElementIDTerminalRuleCall_1_0_0_1()); }
)
{ after(grammarAccess.getEMV2PathElementOrKindAccess().getNamedElementNamedElementCrossReference_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElementOrKind__PathAssignment_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementOrKindAccess().getPathEMV2PathElementParserRuleCall_1_1_1_0()); }
	ruleEMV2PathElement{ after(grammarAccess.getEMV2PathElementOrKindAccess().getPathEMV2PathElementParserRuleCall_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElement__NamedElementAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementAccess().getNamedElementNamedElementCrossReference_0_0()); }
(
{ before(grammarAccess.getEMV2PathElementAccess().getNamedElementNamedElementIDTerminalRuleCall_0_0_1()); }
	RULE_ID{ after(grammarAccess.getEMV2PathElementAccess().getNamedElementNamedElementIDTerminalRuleCall_0_0_1()); }
)
{ after(grammarAccess.getEMV2PathElementAccess().getNamedElementNamedElementCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2PathElement__PathAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2PathElementAccess().getPathEMV2PathElementParserRuleCall_1_1_0()); }
	ruleEMV2PathElement{ after(grammarAccess.getEMV2PathElementAccess().getPathEMV2PathElementParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getTypeDefinitionAccess().getNameIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__SuperTypeAssignment_1_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getSuperTypeErrorTypeCrossReference_1_1_3_0()); }
(
{ before(grammarAccess.getTypeDefinitionAccess().getSuperTypeErrorTypeQEMREFParserRuleCall_1_1_3_0_1()); }
	ruleQEMREF{ after(grammarAccess.getTypeDefinitionAccess().getSuperTypeErrorTypeQEMREFParserRuleCall_1_1_3_0_1()); }
)
{ after(grammarAccess.getTypeDefinitionAccess().getSuperTypeErrorTypeCrossReference_1_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDefinition__AliasedTypeAssignment_1_2_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeDefinitionAccess().getAliasedTypeErrorTypeCrossReference_1_2_2_0()); }
(
{ before(grammarAccess.getTypeDefinitionAccess().getAliasedTypeErrorTypeQEMREFParserRuleCall_1_2_2_0_1()); }
	ruleQEMREF{ after(grammarAccess.getTypeDefinitionAccess().getAliasedTypeErrorTypeQEMREFParserRuleCall_1_2_2_0_1()); }
)
{ after(grammarAccess.getTypeDefinitionAccess().getAliasedTypeErrorTypeCrossReference_1_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getTypeSetDefinitionAccess().getNameIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__TypeTokensAssignment_1_0_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getTypeTokensTypeSetElementParserRuleCall_1_0_3_0()); }
	ruleTypeSetElement{ after(grammarAccess.getTypeSetDefinitionAccess().getTypeTokensTypeSetElementParserRuleCall_1_0_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__TypeTokensAssignment_1_0_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getTypeTokensTypeSetElementParserRuleCall_1_0_4_1_0()); }
	ruleTypeSetElement{ after(grammarAccess.getTypeSetDefinitionAccess().getTypeTokensTypeSetElementParserRuleCall_1_0_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetDefinition__AliasedTypeAssignment_1_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getAliasedTypeTypeSetCrossReference_1_1_2_0()); }
(
{ before(grammarAccess.getTypeSetDefinitionAccess().getAliasedTypeTypeSetQEMREFParserRuleCall_1_1_2_0_1()); }
	ruleQEMREF{ after(grammarAccess.getTypeSetDefinitionAccess().getAliasedTypeTypeSetQEMREFParserRuleCall_1_1_2_0_1()); }
)
{ after(grammarAccess.getTypeSetDefinitionAccess().getAliasedTypeTypeSetCrossReference_1_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetConstructor__TypeTokensAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetConstructorAccess().getTypeTokensTypeSetElementParserRuleCall_1_0()); }
	ruleTypeSetElement{ after(grammarAccess.getTypeSetConstructorAccess().getTypeTokensTypeSetElementParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetConstructor__TypeTokensAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetConstructorAccess().getTypeTokensTypeSetElementParserRuleCall_2_1_0()); }
	ruleTypeSetElement{ after(grammarAccess.getTypeSetConstructorAccess().getTypeTokensTypeSetElementParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetElement__TypeAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetElementAccess().getTypeErrorTypesCrossReference_0_0()); }
(
{ before(grammarAccess.getTypeSetElementAccess().getTypeErrorTypesQEMREFParserRuleCall_0_0_1()); }
	ruleQEMREF{ after(grammarAccess.getTypeSetElementAccess().getTypeErrorTypesQEMREFParserRuleCall_0_0_1()); }
)
{ after(grammarAccess.getTypeSetElementAccess().getTypeErrorTypesCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeSetElement__TypeAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeSetElementAccess().getTypeErrorTypesCrossReference_1_1_0()); }
(
{ before(grammarAccess.getTypeSetElementAccess().getTypeErrorTypesQEMREFParserRuleCall_1_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getTypeSetElementAccess().getTypeErrorTypesQEMREFParserRuleCall_1_1_0_1()); }
)
{ after(grammarAccess.getTypeSetElementAccess().getTypeErrorTypesCrossReference_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NoErrorTypeSet__TypeTokensAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNoErrorTypeSetAccess().getTypeTokensNoErrorTypeTokenParserRuleCall_2_0()); }
	ruleNoErrorTypeToken{ after(grammarAccess.getNoErrorTypeSetAccess().getTypeTokensNoErrorTypeTokenParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NoErrorTypeToken__NoErrorAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNoErrorTypeTokenAccess().getNoErrorNoerrorKeyword_1_0()); }
(
{ before(grammarAccess.getNoErrorTypeTokenAccess().getNoErrorNoerrorKeyword_1_0()); }

	Noerror 

{ after(grammarAccess.getNoErrorTypeTokenAccess().getNoErrorNoerrorKeyword_1_0()); }
)

{ after(grammarAccess.getNoErrorTypeTokenAccess().getNoErrorNoerrorKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationSetAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getTypeTransformationSetAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__UseTypesAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationSetAccess().getUseTypesErrorModelLibraryCrossReference_2_1_0()); }
(
{ before(grammarAccess.getTypeTransformationSetAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getTypeTransformationSetAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_2_1_0_1()); }
)
{ after(grammarAccess.getTypeTransformationSetAccess().getUseTypesErrorModelLibraryCrossReference_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__UseTypesAssignment_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationSetAccess().getUseTypesErrorModelLibraryCrossReference_2_2_1_0()); }
(
{ before(grammarAccess.getTypeTransformationSetAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_2_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getTypeTransformationSetAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_2_2_1_0_1()); }
)
{ after(grammarAccess.getTypeTransformationSetAccess().getUseTypesErrorModelLibraryCrossReference_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformationSet__TransformationAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationSetAccess().getTransformationTypeTransformationParserRuleCall_3_0()); }
	ruleTypeTransformation{ after(grammarAccess.getTypeTransformationSetAccess().getTransformationTypeTransformationParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformation__SourceAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationAccess().getSourceTypeTokenConstraintNoErrorParserRuleCall_0_0_0()); }
	ruleTypeTokenConstraintNoError{ after(grammarAccess.getTypeTransformationAccess().getSourceTypeTokenConstraintNoErrorParserRuleCall_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformation__AllSourcesAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationAccess().getAllSourcesAllKeyword_0_1_0()); }
(
{ before(grammarAccess.getTypeTransformationAccess().getAllSourcesAllKeyword_0_1_0()); }

	All 

{ after(grammarAccess.getTypeTransformationAccess().getAllSourcesAllKeyword_0_1_0()); }
)

{ after(grammarAccess.getTypeTransformationAccess().getAllSourcesAllKeyword_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformation__ContributorAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationAccess().getContributorTypeTokenConstraintNoErrorParserRuleCall_2_0()); }
	ruleTypeTokenConstraintNoError{ after(grammarAccess.getTypeTransformationAccess().getContributorTypeTokenConstraintNoErrorParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeTransformation__TargetAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeTransformationAccess().getTargetTypeTokenParserRuleCall_4_0()); }
	ruleTypeToken{ after(grammarAccess.getTypeTransformationAccess().getTargetTypeTokenParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingSetAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getTypeMappingSetAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__UseTypesAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingSetAccess().getUseTypesErrorModelLibraryCrossReference_2_1_0()); }
(
{ before(grammarAccess.getTypeMappingSetAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getTypeMappingSetAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_2_1_0_1()); }
)
{ after(grammarAccess.getTypeMappingSetAccess().getUseTypesErrorModelLibraryCrossReference_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__UseTypesAssignment_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingSetAccess().getUseTypesErrorModelLibraryCrossReference_2_2_1_0()); }
(
{ before(grammarAccess.getTypeMappingSetAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_2_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getTypeMappingSetAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_2_2_1_0_1()); }
)
{ after(grammarAccess.getTypeMappingSetAccess().getUseTypesErrorModelLibraryCrossReference_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMappingSet__MappingAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingSetAccess().getMappingTypeMappingParserRuleCall_3_0()); }
	ruleTypeMapping{ after(grammarAccess.getTypeMappingSetAccess().getMappingTypeMappingParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMapping__SourceAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingAccess().getSourceTypeTokenConstraintParserRuleCall_0_0()); }
	ruleTypeTokenConstraint{ after(grammarAccess.getTypeMappingAccess().getSourceTypeTokenConstraintParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeMapping__TargetAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeMappingAccess().getTargetTypeTokenParserRuleCall_2_0()); }
	ruleTypeToken{ after(grammarAccess.getTypeMappingAccess().getTargetTypeTokenParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagation__KindAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationAccess().getKindPropagationKindParserRuleCall_1_0_0()); }
	rulePropagationKind{ after(grammarAccess.getErrorPropagationAccess().getKindPropagationKindParserRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagation__FeatureorPPRefAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationAccess().getFeatureorPPRefFeatureorPPReferenceParserRuleCall_1_1_0()); }
	ruleFeatureorPPReference{ after(grammarAccess.getErrorPropagationAccess().getFeatureorPPRefFeatureorPPReferenceParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagation__NotAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationAccess().getNotNotKeyword_3_0()); }
(
{ before(grammarAccess.getErrorPropagationAccess().getNotNotKeyword_3_0()); }

	Not 

{ after(grammarAccess.getErrorPropagationAccess().getNotNotKeyword_3_0()); }
)

{ after(grammarAccess.getErrorPropagationAccess().getNotNotKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagation__DirectionAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationAccess().getDirectionPropagationDirectionParserRuleCall_4_0()); }
	rulePropagationDirection{ after(grammarAccess.getErrorPropagationAccess().getDirectionPropagationDirectionParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPropagation__TypeSetAssignment_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPropagationAccess().getTypeSetTypeSetReferenceParserRuleCall_6_0()); }
	ruleTypeSetReference{ after(grammarAccess.getErrorPropagationAccess().getTypeSetTypeSetReferenceParserRuleCall_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureorPPReference__FeatureorPPAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureorPPReferenceAccess().getFeatureorPPNamedElementCrossReference_0_0()); }
(
{ before(grammarAccess.getFeatureorPPReferenceAccess().getFeatureorPPNamedElementIDTerminalRuleCall_0_0_1()); }
	RULE_ID{ after(grammarAccess.getFeatureorPPReferenceAccess().getFeatureorPPNamedElementIDTerminalRuleCall_0_0_1()); }
)
{ after(grammarAccess.getFeatureorPPReferenceAccess().getFeatureorPPNamedElementCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureorPPReference__NextAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFeatureorPPReferenceAccess().getNextFeatureorPPReferenceParserRuleCall_1_1_0()); }
	ruleFeatureorPPReference{ after(grammarAccess.getFeatureorPPReferenceAccess().getNextFeatureorPPReferenceParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getErrorSourceAccess().getNameIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__SourceModelElementAssignment_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getSourceModelElementNamedElementCrossReference_3_0_0()); }
(
{ before(grammarAccess.getErrorSourceAccess().getSourceModelElementNamedElementErrorPropagationPointParserRuleCall_3_0_0_1()); }
	ruleErrorPropagationPoint{ after(grammarAccess.getErrorSourceAccess().getSourceModelElementNamedElementErrorPropagationPointParserRuleCall_3_0_0_1()); }
)
{ after(grammarAccess.getErrorSourceAccess().getSourceModelElementNamedElementCrossReference_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__AllAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getAllAllKeyword_3_1_0()); }
(
{ before(grammarAccess.getErrorSourceAccess().getAllAllKeyword_3_1_0()); }

	All 

{ after(grammarAccess.getErrorSourceAccess().getAllAllKeyword_3_1_0()); }
)

{ after(grammarAccess.getErrorSourceAccess().getAllAllKeyword_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__TypeTokenConstraintAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_4_0()); }
	ruleTypeTokenConstraint{ after(grammarAccess.getErrorSourceAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__FailureModeReferenceAssignment_5_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getFailureModeReferenceErrorBehaviorStateCrossReference_5_1_0_0_0()); }
(
{ before(grammarAccess.getErrorSourceAccess().getFailureModeReferenceErrorBehaviorStateIDTerminalRuleCall_5_1_0_0_0_1()); }
	RULE_ID{ after(grammarAccess.getErrorSourceAccess().getFailureModeReferenceErrorBehaviorStateIDTerminalRuleCall_5_1_0_0_0_1()); }
)
{ after(grammarAccess.getErrorSourceAccess().getFailureModeReferenceErrorBehaviorStateCrossReference_5_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__FailureModeTypeAssignment_5_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getFailureModeTypeTypeSetReferenceParserRuleCall_5_1_0_1_0()); }
	ruleTypeSetReference{ after(grammarAccess.getErrorSourceAccess().getFailureModeTypeTypeSetReferenceParserRuleCall_5_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__FailureModeTypeAssignment_5_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getFailureModeTypeTypeSetConstructorParserRuleCall_5_1_1_0()); }
	ruleTypeSetConstructor{ after(grammarAccess.getErrorSourceAccess().getFailureModeTypeTypeSetConstructorParserRuleCall_5_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__FailureModeDescriptionAssignment_5_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getFailureModeDescriptionSTRINGTerminalRuleCall_5_1_2_0()); }
	RULE_STRING{ after(grammarAccess.getErrorSourceAccess().getFailureModeDescriptionSTRINGTerminalRuleCall_5_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSource__FlowconditionAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSourceAccess().getFlowconditionIfConditionParserRuleCall_6_1_0()); }
	ruleIfCondition{ after(grammarAccess.getErrorSourceAccess().getFlowconditionIfConditionParserRuleCall_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSink__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getErrorSinkAccess().getNameIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSink__IncomingAssignment_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkAccess().getIncomingErrorPropagationCrossReference_3_0_0()); }
(
{ before(grammarAccess.getErrorSinkAccess().getIncomingErrorPropagationErrorPropagationPointParserRuleCall_3_0_0_1()); }
	ruleErrorPropagationPoint{ after(grammarAccess.getErrorSinkAccess().getIncomingErrorPropagationErrorPropagationPointParserRuleCall_3_0_0_1()); }
)
{ after(grammarAccess.getErrorSinkAccess().getIncomingErrorPropagationCrossReference_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSink__AllIncomingAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkAccess().getAllIncomingAllKeyword_3_1_0()); }
(
{ before(grammarAccess.getErrorSinkAccess().getAllIncomingAllKeyword_3_1_0()); }

	All 

{ after(grammarAccess.getErrorSinkAccess().getAllIncomingAllKeyword_3_1_0()); }
)

{ after(grammarAccess.getErrorSinkAccess().getAllIncomingAllKeyword_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSink__TypeTokenConstraintAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_4_0()); }
	ruleTypeTokenConstraint{ after(grammarAccess.getErrorSinkAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorSink__FlowconditionAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorSinkAccess().getFlowconditionIfConditionParserRuleCall_5_1_0()); }
	ruleIfCondition{ after(grammarAccess.getErrorSinkAccess().getFlowconditionIfConditionParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getErrorPathAccess().getNameIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__IncomingAssignment_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getIncomingErrorPropagationCrossReference_3_0_0()); }
(
{ before(grammarAccess.getErrorPathAccess().getIncomingErrorPropagationErrorPropagationPointParserRuleCall_3_0_0_1()); }
	ruleErrorPropagationPoint{ after(grammarAccess.getErrorPathAccess().getIncomingErrorPropagationErrorPropagationPointParserRuleCall_3_0_0_1()); }
)
{ after(grammarAccess.getErrorPathAccess().getIncomingErrorPropagationCrossReference_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__AllIncomingAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getAllIncomingAllKeyword_3_1_0()); }
(
{ before(grammarAccess.getErrorPathAccess().getAllIncomingAllKeyword_3_1_0()); }

	All 

{ after(grammarAccess.getErrorPathAccess().getAllIncomingAllKeyword_3_1_0()); }
)

{ after(grammarAccess.getErrorPathAccess().getAllIncomingAllKeyword_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__TypeTokenConstraintAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_4_0()); }
	ruleTypeTokenConstraint{ after(grammarAccess.getErrorPathAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__OutgoingAssignment_6_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getOutgoingErrorPropagationCrossReference_6_0_0()); }
(
{ before(grammarAccess.getErrorPathAccess().getOutgoingErrorPropagationErrorPropagationPointParserRuleCall_6_0_0_1()); }
	ruleErrorPropagationPoint{ after(grammarAccess.getErrorPathAccess().getOutgoingErrorPropagationErrorPropagationPointParserRuleCall_6_0_0_1()); }
)
{ after(grammarAccess.getErrorPathAccess().getOutgoingErrorPropagationCrossReference_6_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__AllOutgoingAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getAllOutgoingAllKeyword_6_1_0()); }
(
{ before(grammarAccess.getErrorPathAccess().getAllOutgoingAllKeyword_6_1_0()); }

	All 

{ after(grammarAccess.getErrorPathAccess().getAllOutgoingAllKeyword_6_1_0()); }
)

{ after(grammarAccess.getErrorPathAccess().getAllOutgoingAllKeyword_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__TargetTokenAssignment_7_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getTargetTokenTypeTokenParserRuleCall_7_0_0()); }
	ruleTypeToken{ after(grammarAccess.getErrorPathAccess().getTargetTokenTypeTokenParserRuleCall_7_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__TypeMappingSetAssignment_7_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getTypeMappingSetTypeMappingSetCrossReference_7_1_1_0()); }
(
{ before(grammarAccess.getErrorPathAccess().getTypeMappingSetTypeMappingSetQEMREFParserRuleCall_7_1_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getErrorPathAccess().getTypeMappingSetTypeMappingSetQEMREFParserRuleCall_7_1_1_0_1()); }
)
{ after(grammarAccess.getErrorPathAccess().getTypeMappingSetTypeMappingSetCrossReference_7_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorPath__FlowconditionAssignment_8_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorPathAccess().getFlowconditionIfConditionParserRuleCall_8_1_0()); }
	ruleIfCondition{ after(grammarAccess.getErrorPathAccess().getFlowconditionIfConditionParserRuleCall_8_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IfCondition__DescriptionAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfConditionAccess().getDescriptionSTRINGTerminalRuleCall_0_0()); }
	RULE_STRING{ after(grammarAccess.getIfConditionAccess().getDescriptionSTRINGTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IfCondition__ResoluteFunctionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfConditionAccess().getResoluteFunctionEObjectCrossReference_1_0()); }
(
{ before(grammarAccess.getIfConditionAccess().getResoluteFunctionEObjectQEMREFParserRuleCall_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getIfConditionAccess().getResoluteFunctionEObjectQEMREFParserRuleCall_1_0_1()); }
)
{ after(grammarAccess.getIfConditionAccess().getResoluteFunctionEObjectCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IfCondition__JavaMethodAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfConditionAccess().getJavaMethodQUALIFIEDNAMEParserRuleCall_2_0()); }
	ruleQUALIFIEDNAME{ after(grammarAccess.getIfConditionAccess().getJavaMethodQUALIFIEDNAMEParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPoint__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPointAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getPropagationPointAccess().getNameIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPath__NameAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPathAccess().getNameIDTerminalRuleCall_0_0_0()); }
	RULE_ID{ after(grammarAccess.getPropagationPathAccess().getNameIDTerminalRuleCall_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPath__SourceAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPathAccess().getSourceQualifiedPropagationPointParserRuleCall_1_0()); }
	ruleQualifiedPropagationPoint{ after(grammarAccess.getPropagationPathAccess().getSourceQualifiedPropagationPointParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PropagationPath__TargetAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropagationPathAccess().getTargetQualifiedPropagationPointParserRuleCall_3_0()); }
	ruleQualifiedPropagationPoint{ after(grammarAccess.getPropagationPathAccess().getTargetQualifiedPropagationPointParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPropagationPoint__SubcomponentAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPropagationPointAccess().getSubcomponentSubcomponentElementParserRuleCall_0_0_0()); }
	ruleSubcomponentElement{ after(grammarAccess.getQualifiedPropagationPointAccess().getSubcomponentSubcomponentElementParserRuleCall_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPropagationPoint__NextAssignment_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPropagationPointAccess().getNextQualifiedPropagationPointParserRuleCall_0_2_0()); }
	ruleQualifiedPropagationPoint{ after(grammarAccess.getQualifiedPropagationPointAccess().getNextQualifiedPropagationPointParserRuleCall_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPropagationPoint__PropagationPointAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPropagationPointAccess().getPropagationPointNamedElementCrossReference_1_0()); }
(
{ before(grammarAccess.getQualifiedPropagationPointAccess().getPropagationPointNamedElementIDTerminalRuleCall_1_0_1()); }
	RULE_ID{ after(grammarAccess.getQualifiedPropagationPointAccess().getPropagationPointNamedElementIDTerminalRuleCall_1_0_1()); }
)
{ after(grammarAccess.getQualifiedPropagationPointAccess().getPropagationPointNamedElementCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__UseTypesAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesErrorModelLibraryCrossReference_2_1_0()); }
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_2_1_0_1()); }
)
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesErrorModelLibraryCrossReference_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__UseTypesAssignment_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesErrorModelLibraryCrossReference_2_2_1_0()); }
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_2_2_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesErrorModelLibraryQEMREFParserRuleCall_2_2_1_0_1()); }
)
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesErrorModelLibraryCrossReference_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__UseTransformationAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTransformationTypeTransformationSetCrossReference_3_1_0()); }
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTransformationTypeTransformationSetQEMREFParserRuleCall_3_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTransformationTypeTransformationSetQEMREFParserRuleCall_3_1_0_1()); }
)
{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTransformationTypeTransformationSetCrossReference_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__EventsAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getEventsErrorBehaviorEventParserRuleCall_4_1_0()); }
	ruleErrorBehaviorEvent{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getEventsErrorBehaviorEventParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__StatesAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getStatesErrorBehaviorStateParserRuleCall_5_1_0()); }
	ruleErrorBehaviorState{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getStatesErrorBehaviorStateParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__TransitionsAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getTransitionsErrorBehaviorTransitionParserRuleCall_6_1_0()); }
	ruleErrorBehaviorTransition{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getTransitionsErrorBehaviorTransitionParserRuleCall_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorStateMachine__PropertiesAssignment_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateMachineAccess().getPropertiesBasicEMV2PropertyAssociationParserRuleCall_7_1_0()); }
	ruleBasicEMV2PropertyAssociation{ after(grammarAccess.getErrorBehaviorStateMachineAccess().getPropertiesBasicEMV2PropertyAssociationParserRuleCall_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorEvent__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorEventAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getErrorEventAccess().getNameIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorEvent__TypeSetAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorEventAccess().getTypeSetTypeSetReferenceParserRuleCall_3_0()); }
	ruleTypeSetReference{ after(grammarAccess.getErrorEventAccess().getTypeSetTypeSetReferenceParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorEvent__EventconditionAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorEventAccess().getEventconditionIfConditionParserRuleCall_4_1_0()); }
	ruleIfCondition{ after(grammarAccess.getErrorEventAccess().getEventconditionIfConditionParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RepairEvent__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRepairEventAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getRepairEventAccess().getNameIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RepairEvent__EventInitiatorAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRepairEventAccess().getEventInitiatorNamedElementCrossReference_3_1_0()); }
(
{ before(grammarAccess.getRepairEventAccess().getEventInitiatorNamedElementIDTerminalRuleCall_3_1_0_1()); }
	RULE_ID{ after(grammarAccess.getRepairEventAccess().getEventInitiatorNamedElementIDTerminalRuleCall_3_1_0_1()); }
)
{ after(grammarAccess.getRepairEventAccess().getEventInitiatorNamedElementCrossReference_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RepairEvent__EventInitiatorAssignment_3_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRepairEventAccess().getEventInitiatorNamedElementCrossReference_3_2_1_0()); }
(
{ before(grammarAccess.getRepairEventAccess().getEventInitiatorNamedElementIDTerminalRuleCall_3_2_1_0_1()); }
	RULE_ID{ after(grammarAccess.getRepairEventAccess().getEventInitiatorNamedElementIDTerminalRuleCall_3_2_1_0_1()); }
)
{ after(grammarAccess.getRepairEventAccess().getEventInitiatorNamedElementCrossReference_3_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getRecoverEventAccess().getNameIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__EventInitiatorAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getEventInitiatorNamedElementCrossReference_3_1_0()); }
(
{ before(grammarAccess.getRecoverEventAccess().getEventInitiatorNamedElementIDTerminalRuleCall_3_1_0_1()); }
	RULE_ID{ after(grammarAccess.getRecoverEventAccess().getEventInitiatorNamedElementIDTerminalRuleCall_3_1_0_1()); }
)
{ after(grammarAccess.getRecoverEventAccess().getEventInitiatorNamedElementCrossReference_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__EventInitiatorAssignment_3_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getEventInitiatorNamedElementCrossReference_3_2_1_0()); }
(
{ before(grammarAccess.getRecoverEventAccess().getEventInitiatorNamedElementIDTerminalRuleCall_3_2_1_0_1()); }
	RULE_ID{ after(grammarAccess.getRecoverEventAccess().getEventInitiatorNamedElementIDTerminalRuleCall_3_2_1_0_1()); }
)
{ after(grammarAccess.getRecoverEventAccess().getEventInitiatorNamedElementCrossReference_3_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RecoverEvent__ConditionAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRecoverEventAccess().getConditionIfConditionParserRuleCall_4_1_0()); }
	ruleIfCondition{ after(grammarAccess.getRecoverEventAccess().getConditionIfConditionParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorState__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getErrorBehaviorStateAccess().getNameIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorState__IntialAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateAccess().getIntialInitialKeyword_2_0()); }
(
{ before(grammarAccess.getErrorBehaviorStateAccess().getIntialInitialKeyword_2_0()); }

	Initial 

{ after(grammarAccess.getErrorBehaviorStateAccess().getIntialInitialKeyword_2_0()); }
)

{ after(grammarAccess.getErrorBehaviorStateAccess().getIntialInitialKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorState__TypeSetAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorStateAccess().getTypeSetTypeSetReferenceParserRuleCall_4_0()); }
	ruleTypeSetReference{ after(grammarAccess.getErrorBehaviorStateAccess().getTypeSetTypeSetReferenceParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__NameAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getNameIDTerminalRuleCall_0_0_0()); }
	RULE_ID{ after(grammarAccess.getErrorBehaviorTransitionAccess().getNameIDTerminalRuleCall_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__SourceAssignment_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getSourceErrorBehaviorStateCrossReference_1_0_0_0()); }
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getSourceErrorBehaviorStateIDTerminalRuleCall_1_0_0_0_1()); }
	RULE_ID{ after(grammarAccess.getErrorBehaviorTransitionAccess().getSourceErrorBehaviorStateIDTerminalRuleCall_1_0_0_0_1()); }
)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getSourceErrorBehaviorStateCrossReference_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__TypeTokenConstraintAssignment_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0()); }
	ruleTypeTokenConstraint{ after(grammarAccess.getErrorBehaviorTransitionAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__AllStatesAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getAllStatesAllKeyword_1_1_0()); }
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getAllStatesAllKeyword_1_1_0()); }

	All 

{ after(grammarAccess.getErrorBehaviorTransitionAccess().getAllStatesAllKeyword_1_1_0()); }
)

{ after(grammarAccess.getErrorBehaviorTransitionAccess().getAllStatesAllKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__ConditionAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getConditionConditionExpressionParserRuleCall_3_0()); }
	ruleConditionExpression{ after(grammarAccess.getErrorBehaviorTransitionAccess().getConditionConditionExpressionParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__TargetAssignment_5_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getTargetErrorBehaviorStateCrossReference_5_0_0_0()); }
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getTargetErrorBehaviorStateIDTerminalRuleCall_5_0_0_0_1()); }
	RULE_ID{ after(grammarAccess.getErrorBehaviorTransitionAccess().getTargetErrorBehaviorStateIDTerminalRuleCall_5_0_0_0_1()); }
)
{ after(grammarAccess.getErrorBehaviorTransitionAccess().getTargetErrorBehaviorStateCrossReference_5_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__TargetTokenAssignment_5_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getTargetTokenTypeTokenParserRuleCall_5_0_1_0()); }
	ruleTypeToken{ after(grammarAccess.getErrorBehaviorTransitionAccess().getTargetTokenTypeTokenParserRuleCall_5_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__SteadyStateAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getSteadyStateSameStateKeywordsParserRuleCall_5_1_0()); }
	ruleSameStateKeywords{ after(grammarAccess.getErrorBehaviorTransitionAccess().getSteadyStateSameStateKeywordsParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__DestinationBranchesAssignment_5_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getDestinationBranchesTransitionBranchParserRuleCall_5_2_1_0()); }
	ruleTransitionBranch{ after(grammarAccess.getErrorBehaviorTransitionAccess().getDestinationBranchesTransitionBranchParserRuleCall_5_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorBehaviorTransition__DestinationBranchesAssignment_5_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorBehaviorTransitionAccess().getDestinationBranchesTransitionBranchParserRuleCall_5_2_2_1_0()); }
	ruleTransitionBranch{ after(grammarAccess.getErrorBehaviorTransitionAccess().getDestinationBranchesTransitionBranchParserRuleCall_5_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionBranch__TargetAssignment_0_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionBranchAccess().getTargetErrorBehaviorStateCrossReference_0_0_0_0()); }
(
{ before(grammarAccess.getTransitionBranchAccess().getTargetErrorBehaviorStateIDTerminalRuleCall_0_0_0_0_1()); }
	RULE_ID{ after(grammarAccess.getTransitionBranchAccess().getTargetErrorBehaviorStateIDTerminalRuleCall_0_0_0_0_1()); }
)
{ after(grammarAccess.getTransitionBranchAccess().getTargetErrorBehaviorStateCrossReference_0_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionBranch__TargetTokenAssignment_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionBranchAccess().getTargetTokenTypeTokenParserRuleCall_0_0_1_0()); }
	ruleTypeToken{ after(grammarAccess.getTransitionBranchAccess().getTargetTokenTypeTokenParserRuleCall_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionBranch__SteadyStateAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionBranchAccess().getSteadyStateSameStateKeywordsParserRuleCall_0_1_0()); }
	ruleSameStateKeywords{ after(grammarAccess.getTransitionBranchAccess().getSteadyStateSameStateKeywordsParserRuleCall_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TransitionBranch__ValueAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionBranchAccess().getValueBranchValueParserRuleCall_2_0()); }
	ruleBranchValue{ after(grammarAccess.getTransitionBranchAccess().getValueBranchValueParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BranchValue__RealvalueAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBranchValueAccess().getRealvalueREAL_LITTerminalRuleCall_1_0_0()); }
	RULE_REAL_LIT{ after(grammarAccess.getBranchValueAccess().getRealvalueREAL_LITTerminalRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BranchValue__SymboliclabelAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBranchValueAccess().getSymboliclabelPropertyCrossReference_1_1_0()); }
(
{ before(grammarAccess.getBranchValueAccess().getSymboliclabelPropertyQEMREFParserRuleCall_1_1_0_1()); }
	ruleQEMREF{ after(grammarAccess.getBranchValueAccess().getSymboliclabelPropertyQEMREFParserRuleCall_1_1_0_1()); }
)
{ after(grammarAccess.getBranchValueAccess().getSymboliclabelPropertyCrossReference_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BranchValue__OthersAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBranchValueAccess().getOthersOthersKeyword_1_2_0()); }
(
{ before(grammarAccess.getBranchValueAccess().getOthersOthersKeyword_1_2_0()); }

	Others 

{ after(grammarAccess.getBranchValueAccess().getOthersOthersKeyword_1_2_0()); }
)

{ after(grammarAccess.getBranchValueAccess().getOthersOthersKeyword_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionExpression__OperandsAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConditionExpressionAccess().getOperandsAndExpressionParserRuleCall_1_2_0()); }
	ruleAndExpression{ after(grammarAccess.getConditionExpressionAccess().getOperandsAndExpressionParserRuleCall_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AndExpression__OperandsAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAndExpressionAccess().getOperandsConditionTermParserRuleCall_1_2_0()); }
	ruleConditionTerm{ after(grammarAccess.getAndExpressionAccess().getOperandsConditionTermParserRuleCall_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AllExpression__CountAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAllExpressionAccess().getCountINTVALUEParserRuleCall_2_1_0()); }
	ruleINTVALUE{ after(grammarAccess.getAllExpressionAccess().getCountINTVALUEParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AllExpression__OperandsAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAllExpressionAccess().getOperandsConditionElementParserRuleCall_4_0()); }
	ruleConditionElement{ after(grammarAccess.getAllExpressionAccess().getOperandsConditionElementParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AllExpression__OperandsAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAllExpressionAccess().getOperandsConditionElementParserRuleCall_5_1_0()); }
	ruleConditionElement{ after(grammarAccess.getAllExpressionAccess().getOperandsConditionElementParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OrmoreExpression__CountAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrmoreExpressionAccess().getCountINTVALUEParserRuleCall_0_0()); }
	ruleINTVALUE{ after(grammarAccess.getOrmoreExpressionAccess().getCountINTVALUEParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OrmoreExpression__OperandsAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrmoreExpressionAccess().getOperandsConditionExpressionParserRuleCall_3_0()); }
	ruleConditionExpression{ after(grammarAccess.getOrmoreExpressionAccess().getOperandsConditionExpressionParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OrmoreExpression__OperandsAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrmoreExpressionAccess().getOperandsConditionExpressionParserRuleCall_4_1_0()); }
	ruleConditionExpression{ after(grammarAccess.getOrmoreExpressionAccess().getOperandsConditionExpressionParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OrlessExpression__CountAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrlessExpressionAccess().getCountINTVALUEParserRuleCall_0_0()); }
	ruleINTVALUE{ after(grammarAccess.getOrlessExpressionAccess().getCountINTVALUEParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OrlessExpression__OperandsAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrlessExpressionAccess().getOperandsConditionExpressionParserRuleCall_3_0()); }
	ruleConditionExpression{ after(grammarAccess.getOrlessExpressionAccess().getOperandsConditionExpressionParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OrlessExpression__OperandsAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOrlessExpressionAccess().getOperandsConditionExpressionParserRuleCall_4_1_0()); }
	ruleConditionExpression{ after(grammarAccess.getOrlessExpressionAccess().getOperandsConditionExpressionParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionElement__QualifiedErrorPropagationReferenceAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConditionElementAccess().getQualifiedErrorPropagationReferenceQualifiedErrorEventOrPropagationParserRuleCall_0_0()); }
	ruleQualifiedErrorEventOrPropagation{ after(grammarAccess.getConditionElementAccess().getQualifiedErrorPropagationReferenceQualifiedErrorEventOrPropagationParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionElement__ConstraintAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConditionElementAccess().getConstraintTypeTokenConstraintNoErrorParserRuleCall_1_0()); }
	ruleTypeTokenConstraintNoError{ after(grammarAccess.getConditionElementAccess().getConstraintTypeTokenConstraintNoErrorParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedErrorEventOrPropagation__Emv2TargetAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedErrorEventOrPropagationAccess().getEmv2TargetEMV2ErrorPropagationPathParserRuleCall_1_0()); }
	ruleEMV2ErrorPropagationPath{ after(grammarAccess.getQualifiedErrorEventOrPropagationAccess().getEmv2TargetEMV2ErrorPropagationPathParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2ErrorPropagationPath__Emv2PropagationKindAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2ErrorPropagationPathAccess().getEmv2PropagationKindPropagationKindParserRuleCall_0_0()); }
	rulePropagationKind{ after(grammarAccess.getEMV2ErrorPropagationPathAccess().getEmv2PropagationKindPropagationKindParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2ErrorPropagationPath__NamedElementAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2ErrorPropagationPathAccess().getNamedElementNamedElementCrossReference_1_0_0()); }
(
{ before(grammarAccess.getEMV2ErrorPropagationPathAccess().getNamedElementNamedElementIDTerminalRuleCall_1_0_0_1()); }
	RULE_ID{ after(grammarAccess.getEMV2ErrorPropagationPathAccess().getNamedElementNamedElementIDTerminalRuleCall_1_0_0_1()); }
)
{ after(grammarAccess.getEMV2ErrorPropagationPathAccess().getNamedElementNamedElementCrossReference_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EMV2ErrorPropagationPath__PathAssignment_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEMV2ErrorPropagationPathAccess().getPathEMV2ErrorPropagationPathParserRuleCall_1_1_1_0()); }
	ruleEMV2ErrorPropagationPath{ after(grammarAccess.getEMV2ErrorPropagationPathAccess().getPathEMV2ErrorPropagationPathParserRuleCall_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__NameAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getNameIDTerminalRuleCall_0_0_0()); }
	RULE_ID{ after(grammarAccess.getOutgoingPropagationConditionAccess().getNameIDTerminalRuleCall_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__StateAssignment_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getStateErrorBehaviorStateCrossReference_1_0_0_0()); }
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getStateErrorBehaviorStateIDTerminalRuleCall_1_0_0_0_1()); }
	RULE_ID{ after(grammarAccess.getOutgoingPropagationConditionAccess().getStateErrorBehaviorStateIDTerminalRuleCall_1_0_0_0_1()); }
)
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getStateErrorBehaviorStateCrossReference_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__TypeTokenConstraintAssignment_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0()); }
	ruleTypeTokenConstraint{ after(grammarAccess.getOutgoingPropagationConditionAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__AllStatesAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getAllStatesAllKeyword_1_1_0()); }
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getAllStatesAllKeyword_1_1_0()); }

	All 

{ after(grammarAccess.getOutgoingPropagationConditionAccess().getAllStatesAllKeyword_1_1_0()); }
)

{ after(grammarAccess.getOutgoingPropagationConditionAccess().getAllStatesAllKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__ConditionAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getConditionConditionExpressionParserRuleCall_3_0()); }
	ruleConditionExpression{ after(grammarAccess.getOutgoingPropagationConditionAccess().getConditionConditionExpressionParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__OutgoingAssignment_5_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getOutgoingErrorPropagationCrossReference_5_0_0_0()); }
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getOutgoingErrorPropagationErrorPropagationPointParserRuleCall_5_0_0_0_1()); }
	ruleErrorPropagationPoint{ after(grammarAccess.getOutgoingPropagationConditionAccess().getOutgoingErrorPropagationErrorPropagationPointParserRuleCall_5_0_0_0_1()); }
)
{ after(grammarAccess.getOutgoingPropagationConditionAccess().getOutgoingErrorPropagationCrossReference_5_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__AllPropagationsAssignment_5_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getAllPropagationsAllKeyword_5_0_1_0()); }
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getAllPropagationsAllKeyword_5_0_1_0()); }

	All 

{ after(grammarAccess.getOutgoingPropagationConditionAccess().getAllPropagationsAllKeyword_5_0_1_0()); }
)

{ after(grammarAccess.getOutgoingPropagationConditionAccess().getAllPropagationsAllKeyword_5_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OutgoingPropagationCondition__TypeTokenAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOutgoingPropagationConditionAccess().getTypeTokenTypeTokenOrNoErrorParserRuleCall_5_1_0()); }
	ruleTypeTokenOrNoError{ after(grammarAccess.getOutgoingPropagationConditionAccess().getTypeTokenTypeTokenOrNoErrorParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__NameAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getNameIDTerminalRuleCall_0_0_0()); }
	RULE_ID{ after(grammarAccess.getErrorDetectionAccess().getNameIDTerminalRuleCall_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__StateAssignment_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getStateErrorBehaviorStateCrossReference_1_0_0_0()); }
(
{ before(grammarAccess.getErrorDetectionAccess().getStateErrorBehaviorStateIDTerminalRuleCall_1_0_0_0_1()); }
	RULE_ID{ after(grammarAccess.getErrorDetectionAccess().getStateErrorBehaviorStateIDTerminalRuleCall_1_0_0_0_1()); }
)
{ after(grammarAccess.getErrorDetectionAccess().getStateErrorBehaviorStateCrossReference_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__TypeTokenConstraintAssignment_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0()); }
	ruleTypeTokenConstraint{ after(grammarAccess.getErrorDetectionAccess().getTypeTokenConstraintTypeTokenConstraintParserRuleCall_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__AllStatesAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getAllStatesAllKeyword_1_1_0()); }
(
{ before(grammarAccess.getErrorDetectionAccess().getAllStatesAllKeyword_1_1_0()); }

	All 

{ after(grammarAccess.getErrorDetectionAccess().getAllStatesAllKeyword_1_1_0()); }
)

{ after(grammarAccess.getErrorDetectionAccess().getAllStatesAllKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__ConditionAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getConditionConditionExpressionParserRuleCall_3_0()); }
	ruleConditionExpression{ after(grammarAccess.getErrorDetectionAccess().getConditionConditionExpressionParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__DetectionReportingPortAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getDetectionReportingPortTriggerPortCrossReference_5_0()); }
(
{ before(grammarAccess.getErrorDetectionAccess().getDetectionReportingPortTriggerPortIDTerminalRuleCall_5_0_1()); }
	RULE_ID{ after(grammarAccess.getErrorDetectionAccess().getDetectionReportingPortTriggerPortIDTerminalRuleCall_5_0_1()); }
)
{ after(grammarAccess.getErrorDetectionAccess().getDetectionReportingPortTriggerPortCrossReference_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorDetection__ErrorCodeAssignment_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorDetectionAccess().getErrorCodeErrorCodeValueParserRuleCall_7_1_0()); }
	ruleErrorCodeValue{ after(grammarAccess.getErrorDetectionAccess().getErrorCodeErrorCodeValueParserRuleCall_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorCodeValue__IntValueAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorCodeValueAccess().getIntValueINTEGER_LITTerminalRuleCall_0_0()); }
	RULE_INTEGER_LIT{ after(grammarAccess.getErrorCodeValueAccess().getIntValueINTEGER_LITTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorCodeValue__ConstantAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorCodeValueAccess().getConstantPropertyConstantCrossReference_1_0()); }
(
{ before(grammarAccess.getErrorCodeValueAccess().getConstantPropertyConstantQPREFParserRuleCall_1_0_1()); }
	ruleQPREF{ after(grammarAccess.getErrorCodeValueAccess().getConstantPropertyConstantQPREFParserRuleCall_1_0_1()); }
)
{ after(grammarAccess.getErrorCodeValueAccess().getConstantPropertyConstantCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorCodeValue__EnumLiteralAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorCodeValueAccess().getEnumLiteralSTRINGTerminalRuleCall_2_0()); }
	RULE_STRING{ after(grammarAccess.getErrorCodeValueAccess().getEnumLiteralSTRINGTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorStateToModeMapping__ErrorStateAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getErrorStateErrorBehaviorStateCrossReference_0_0()); }
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getErrorStateErrorBehaviorStateIDTerminalRuleCall_0_0_1()); }
	RULE_ID{ after(grammarAccess.getErrorStateToModeMappingAccess().getErrorStateErrorBehaviorStateIDTerminalRuleCall_0_0_1()); }
)
{ after(grammarAccess.getErrorStateToModeMappingAccess().getErrorStateErrorBehaviorStateCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorStateToModeMapping__TypeTokenAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getTypeTokenTypeTokenParserRuleCall_1_0()); }
	ruleTypeToken{ after(grammarAccess.getErrorStateToModeMappingAccess().getTypeTokenTypeTokenParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorStateToModeMapping__MappedModesAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getMappedModesModeCrossReference_4_0()); }
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getMappedModesModeIDTerminalRuleCall_4_0_1()); }
	RULE_ID{ after(grammarAccess.getErrorStateToModeMappingAccess().getMappedModesModeIDTerminalRuleCall_4_0_1()); }
)
{ after(grammarAccess.getErrorStateToModeMappingAccess().getMappedModesModeCrossReference_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ErrorStateToModeMapping__MappedModesAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getMappedModesModeCrossReference_5_1_0()); }
(
{ before(grammarAccess.getErrorStateToModeMappingAccess().getMappedModesModeIDTerminalRuleCall_5_1_0_1()); }
	RULE_ID{ after(grammarAccess.getErrorStateToModeMappingAccess().getMappedModesModeIDTerminalRuleCall_5_1_0_1()); }
)
{ after(grammarAccess.getErrorStateToModeMappingAccess().getMappedModesModeCrossReference_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeState__NameAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeStateAccess().getNameIDTerminalRuleCall_0_0_0()); }
	RULE_ID{ after(grammarAccess.getCompositeStateAccess().getNameIDTerminalRuleCall_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeState__ConditionAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeStateAccess().getConditionSConditionExpressionParserRuleCall_2_0_0()); }
	ruleSConditionExpression{ after(grammarAccess.getCompositeStateAccess().getConditionSConditionExpressionParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeState__OthersAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeStateAccess().getOthersOthersKeyword_2_1_0()); }
(
{ before(grammarAccess.getCompositeStateAccess().getOthersOthersKeyword_2_1_0()); }

	Others 

{ after(grammarAccess.getCompositeStateAccess().getOthersOthersKeyword_2_1_0()); }
)

{ after(grammarAccess.getCompositeStateAccess().getOthersOthersKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeState__StateAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeStateAccess().getStateErrorBehaviorStateCrossReference_4_0()); }
(
{ before(grammarAccess.getCompositeStateAccess().getStateErrorBehaviorStateIDTerminalRuleCall_4_0_1()); }
	RULE_ID{ after(grammarAccess.getCompositeStateAccess().getStateErrorBehaviorStateIDTerminalRuleCall_4_0_1()); }
)
{ after(grammarAccess.getCompositeStateAccess().getStateErrorBehaviorStateCrossReference_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CompositeState__TypedTokenAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCompositeStateAccess().getTypedTokenTypeTokenParserRuleCall_5_0()); }
	ruleTypeToken{ after(grammarAccess.getCompositeStateAccess().getTypedTokenTypeTokenParserRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionExpression__OperandsAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionExpressionAccess().getOperandsSAndExpressionParserRuleCall_1_2_0()); }
	ruleSAndExpression{ after(grammarAccess.getSConditionExpressionAccess().getOperandsSAndExpressionParserRuleCall_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SAndExpression__OperandsAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAndExpressionAccess().getOperandsSConditionTermParserRuleCall_1_2_0()); }
	ruleSConditionTerm{ after(grammarAccess.getSAndExpressionAccess().getOperandsSConditionTermParserRuleCall_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SOrmoreExpression__CountAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrmoreExpressionAccess().getCountINTVALUEParserRuleCall_0_0()); }
	ruleINTVALUE{ after(grammarAccess.getSOrmoreExpressionAccess().getCountINTVALUEParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SOrmoreExpression__OperandsAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrmoreExpressionAccess().getOperandsSConditionExpressionParserRuleCall_3_0()); }
	ruleSConditionExpression{ after(grammarAccess.getSOrmoreExpressionAccess().getOperandsSConditionExpressionParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SOrmoreExpression__OperandsAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrmoreExpressionAccess().getOperandsSConditionExpressionParserRuleCall_4_1_0()); }
	ruleSConditionExpression{ after(grammarAccess.getSOrmoreExpressionAccess().getOperandsSConditionExpressionParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SOrlessExpression__CountAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrlessExpressionAccess().getCountINTVALUEParserRuleCall_0_0()); }
	ruleINTVALUE{ after(grammarAccess.getSOrlessExpressionAccess().getCountINTVALUEParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SOrlessExpression__OperandsAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrlessExpressionAccess().getOperandsSConditionExpressionParserRuleCall_3_0()); }
	ruleSConditionExpression{ after(grammarAccess.getSOrlessExpressionAccess().getOperandsSConditionExpressionParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SOrlessExpression__OperandsAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSOrlessExpressionAccess().getOperandsSConditionExpressionParserRuleCall_4_1_0()); }
	ruleSConditionExpression{ after(grammarAccess.getSOrlessExpressionAccess().getOperandsSConditionExpressionParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SAllExpression__CountAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAllExpressionAccess().getCountINTVALUEParserRuleCall_2_1_0()); }
	ruleINTVALUE{ after(grammarAccess.getSAllExpressionAccess().getCountINTVALUEParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SAllExpression__OperandsAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAllExpressionAccess().getOperandsSConditionElementParserRuleCall_4_0()); }
	ruleSConditionElement{ after(grammarAccess.getSAllExpressionAccess().getOperandsSConditionElementParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SAllExpression__OperandsAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSAllExpressionAccess().getOperandsSConditionElementParserRuleCall_5_1_0()); }
	ruleSConditionElement{ after(grammarAccess.getSAllExpressionAccess().getOperandsSConditionElementParserRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedErrorPropagation__Emv2TargetAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedErrorPropagationAccess().getEmv2TargetEMV2ErrorPropagationPathParserRuleCall_1_0()); }
	ruleEMV2ErrorPropagationPath{ after(grammarAccess.getQualifiedErrorPropagationAccess().getEmv2TargetEMV2ErrorPropagationPathParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionElement__QualifiedStateAssignment_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionElementAccess().getQualifiedStateQualifiedErrorBehaviorStateParserRuleCall_1_0_0_0()); }
	ruleQualifiedErrorBehaviorState{ after(grammarAccess.getSConditionElementAccess().getQualifiedStateQualifiedErrorBehaviorStateParserRuleCall_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionElement__ConstraintAssignment_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionElementAccess().getConstraintTypeTokenConstraintParserRuleCall_1_0_1_0()); }
	ruleTypeTokenConstraint{ after(grammarAccess.getSConditionElementAccess().getConstraintTypeTokenConstraintParserRuleCall_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionElement__QualifiedErrorPropagationReferenceAssignment_1_1_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionElementAccess().getQualifiedErrorPropagationReferenceQualifiedErrorPropagationParserRuleCall_1_1_1_0_0()); }
	ruleQualifiedErrorPropagation{ after(grammarAccess.getSConditionElementAccess().getQualifiedErrorPropagationReferenceQualifiedErrorPropagationParserRuleCall_1_1_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SConditionElement__ConstraintAssignment_1_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSConditionElementAccess().getConstraintTypeTokenConstraintNoErrorParserRuleCall_1_1_1_1_0()); }
	ruleTypeTokenConstraintNoError{ after(grammarAccess.getSConditionElementAccess().getConstraintTypeTokenConstraintNoErrorParserRuleCall_1_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedErrorBehaviorState__SubcomponentAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedErrorBehaviorStateAccess().getSubcomponentSubcomponentElementParserRuleCall_0_0()); }
	ruleSubcomponentElement{ after(grammarAccess.getQualifiedErrorBehaviorStateAccess().getSubcomponentSubcomponentElementParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedErrorBehaviorState__NextAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedErrorBehaviorStateAccess().getNextQualifiedErrorBehaviorStateParserRuleCall_2_0_0()); }
	ruleQualifiedErrorBehaviorState{ after(grammarAccess.getQualifiedErrorBehaviorStateAccess().getNextQualifiedErrorBehaviorStateParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedErrorBehaviorState__StateAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedErrorBehaviorStateAccess().getStateErrorBehaviorStateCrossReference_2_1_0()); }
(
{ before(grammarAccess.getQualifiedErrorBehaviorStateAccess().getStateErrorBehaviorStateIDTerminalRuleCall_2_1_0_1()); }
	RULE_ID{ after(grammarAccess.getQualifiedErrorBehaviorStateAccess().getStateErrorBehaviorStateIDTerminalRuleCall_2_1_0_1()); }
)
{ after(grammarAccess.getQualifiedErrorBehaviorStateAccess().getStateErrorBehaviorStateCrossReference_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SubcomponentElement__SubcomponentAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSubcomponentElementAccess().getSubcomponentSubcomponentCrossReference_0()); }
(
{ before(grammarAccess.getSubcomponentElementAccess().getSubcomponentSubcomponentIDTerminalRuleCall_0_1()); }
	RULE_ID{ after(grammarAccess.getSubcomponentElementAccess().getSubcomponentSubcomponentIDTerminalRuleCall_0_1()); }
)
{ after(grammarAccess.getSubcomponentElementAccess().getSubcomponentSubcomponentCrossReference_0()); }
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

	PlusSignEqualsSignGreaterThanSign 

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

	Constant 

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

rule__OptionalModalPropertyValue__InModeAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_2_0()); }
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeIDTerminalRuleCall_1_2_0_1()); }
	RULE_ID{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeIDTerminalRuleCall_1_2_0_1()); }
)
{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__InModeAssignment_1_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_1_0()); }
(
{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeIDTerminalRuleCall_1_3_1_0_1()); }
	RULE_ID{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeIDTerminalRuleCall_1_3_1_0_1()); }
)
{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_1_0()); }
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

	True 

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

rule__ContainmentPathElement__NamedElementAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0()); }
(
{ before(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementIDTerminalRuleCall_0_0_0_1()); }
	RULE_ID{ after(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementIDTerminalRuleCall_0_0_0_1()); }
)
{ after(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__ArrayRangeAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0()); }
	ruleArrayRange{ after(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__PathAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_1_1_0()); }
	ruleContainmentPathElement{ after(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_1_1_0()); }
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



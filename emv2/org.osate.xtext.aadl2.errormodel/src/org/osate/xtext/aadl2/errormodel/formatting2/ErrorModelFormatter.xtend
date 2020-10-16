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
package org.osate.xtext.aadl2.errormodel.formatting2;

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion
import org.osate.xtext.aadl2.errormodel.errorModel.AllExpression
import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Root
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression
import org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent
import org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMapping
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformation
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet
import org.osate.xtext.aadl2.errormodel.services.ErrorModelGrammarAccess
import org.osate.xtext.aadl2.properties.formatting2.PropertiesFormatter

/**
 * @since 5.0
 */
class ErrorModelFormatter extends PropertiesFormatter {
	@Inject extension ErrorModelGrammarAccess

	def dispatch void format(EMV2Root emv2Root, extension IFormattableDocument document) {
		emv2Root.library?.format(document)
		emv2Root.subclauses.forEach[it.format(document)]
	}

	// Grammar rules: ErrorModelSubclause and EMV2Subclause
	def dispatch void format(ErrorModelSubclause errorModelSubclause, extension IFormattableDocument document) {
		if (errorModelSubclause.regionForEObject === null) {
			return
		}

		// Before subclause
		if (errorModelSubclause.regionForEObject.previousSemanticRegion === null) {
			errorModelSubclause.prepend[noSpace]
		}

		// Subclause line
		val nameAssignment = errorModelSubclause.regionFor.assignment(EMV2SubclauseAccess.nameAssignment_2)
		nameAssignment.prepend[oneSpace].append[setNewLines(1, 1, 2)]

		// End subclause
		val endSubclauseKeyword = errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.endKeyword_13)
		endSubclauseKeyword.append[oneSpace]
		errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.semicolonKeyword_15).prepend[noSpace]

		// Indentation in subclause declaration
		interior(nameAssignment, endSubclauseKeyword, [indent])

		// Use types
		val typesKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.typesKeyword_1_1) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.typesKeyword_3_1)
		val useTypesSemicolon = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.semicolonKeyword_1_4) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.semicolonKeyword_3_4)
		interior(typesKeyword, useTypesSemicolon, [indent])
		typesKeyword.surround[oneSpace]
		val useTypesCommas = errorModelSubclause.regionFor.keywords(errorModelSubclauseAccess.commaKeyword_1_3_0) +
			errorModelSubclause.regionFor.keywords(EMV2SubclauseAccess.commaKeyword_3_3_0)
		useTypesCommas.forEach[prepend[noSpace].append[oneSpace; autowrap]]
		useTypesSemicolon.prepend[noSpace]
		switch nextSemantic : useTypesSemicolon?.nextSemanticRegion?.text?.toLowerCase {
			case "end",
			case "use": useTypesSemicolon.append[newLines = 1]
			case nextSemantic !== null: useTypesSemicolon.append[newLines = 2]
		}

		// Use type equivalence
		val typeKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.typeKeyword_2_1) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.typeKeyword_4_1)
		typeKeyword.surround[oneSpace]
		val equivalenceKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.equivalenceKeyword_2_2) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.equivalenceKeyword_4_2)
		equivalenceKeyword.append[oneSpace]
		val useTypeEquivalenceSemicolon = errorModelSubclause.regionFor.keyword(
			errorModelSubclauseAccess.semicolonKeyword_2_4) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.semicolonKeyword_4_4)
		useTypeEquivalenceSemicolon.prepend[noSpace]
		switch nextSemantic : useTypeEquivalenceSemicolon?.nextSemanticRegion?.text?.toLowerCase {
			case "end",
			case "use": useTypeEquivalenceSemicolon.append[newLines = 1]
			case nextSemantic !== null: useTypeEquivalenceSemicolon.append[newLines = 2]
		}

		// Use mappings
		val mappingsKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.mappingsKeyword_3_1) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.mappingsKeyword_5_1)
		mappingsKeyword.surround[oneSpace]
		val useMappingsSemicolon = errorModelSubclause.regionFor.keyword(
			errorModelSubclauseAccess.semicolonKeyword_3_3) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.semicolonKeyword_5_3)
		useMappingsSemicolon.prepend[noSpace]
		switch nextSemantic : useMappingsSemicolon?.nextSemanticRegion?.text?.toLowerCase {
			case "end",
			case "use": useMappingsSemicolon.append[newLines = 1]
			case nextSemantic !== null: useMappingsSemicolon.append[newLines = 2]
		}

		// Use behavior
		val behaviorKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.behaviorKeyword_4_1) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.behaviorKeyword_6_1)
		behaviorKeyword.surround[oneSpace]
		val useBehaviorSemicolon = errorModelSubclause.regionFor.keyword(
			errorModelSubclauseAccess.semicolonKeyword_4_3) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.semicolonKeyword_6_3)
		useBehaviorSemicolon.prepend[noSpace]
		switch nextSemantic : useBehaviorSemicolon?.nextSemanticRegion {
			case endSubclauseKeyword: useBehaviorSemicolon.append[newLines = 1]
			case nextSemantic !== null: useBehaviorSemicolon.append[newLines = 2]
		}

		formatErrorPropagations(errorModelSubclause, document, endSubclauseKeyword)
		formatComponentErrorBehavior(errorModelSubclause, document, endSubclauseKeyword)
		formatCompositeErrorBehavior(errorModelSubclause, document, endSubclauseKeyword)
		formatConnectionError(errorModelSubclause, document, endSubclauseKeyword)
		formatPropagationPaths(errorModelSubclause, document, endSubclauseKeyword)

		// Properties
		val propertiesKeyword = errorModelSubclause.regionFor.keyword(
			errorModelSubclauseAccess.propertiesKeyword_10_0) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.propertiesKeyword_12_0)
		propertiesKeyword.append[setNewLines(1, 1, 2)]
		interior(propertiesKeyword, errorModelSubclause.properties.last.semanticRegions.last, [indent])
		errorModelSubclause.properties.forEach [
			conditionalAppend(document, [setNewLines(1, 1, 2)])
			it.format(document)
		]

		// After subclause
		if (errorModelSubclause.regionForEObject.nextSemanticRegion === null) {
			errorModelSubclause.append[noSpace]
		} else {
			errorModelSubclause.append[newLines = 2]
		}
	}
	
	def private void formatErrorPropagations(
		ErrorModelSubclause errorModelSubclause,
		extension IFormattableDocument document,
		ISemanticRegion endSubclauseKeyword
	) {
		// Error propagations (begin line)
		val propagationsKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.propagationsKeyword_5_1) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.propagationsKeyword_7_1)
		propagationsKeyword.prepend[oneSpace].append[setNewLines(1, 1, 2)]
		val endKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.endKeyword_5_4) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.endKeyword_7_4)
		interior(propagationsKeyword, endKeyword, [indent])
		// Error propagations (propagations)
		errorModelSubclause.propagations.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		
		// Error propagations (flows)
		val flowsKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.flowsKeyword_5_3_0) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.flowsKeyword_7_3_0)
		flowsKeyword.append[setNewLines(1, 1, 2)]
		interior(flowsKeyword, endKeyword, [indent])
		errorModelSubclause.flows.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		
		// Error propagations (end line)
		val endPropagationsKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.propagationsKeyword_5_5) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.propagationsKeyword_7_5)
		endPropagationsKeyword.prepend[oneSpace].append[noSpace]
		val errorPropagationsSemicolon = errorModelSubclause.regionFor.keyword(
			errorModelSubclauseAccess.semicolonKeyword_5_6) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.semicolonKeyword_7_6)
		switch nextSemantic : errorPropagationsSemicolon?.nextSemanticRegion {
			case endSubclauseKeyword: errorPropagationsSemicolon.append[setNewLines(1, 1, 2)]
			case nextSemantic !== null: errorPropagationsSemicolon.append[newLines = 2]
		}
	}
	
	def private void formatComponentErrorBehavior(
		ErrorModelSubclause errorModelSubclause,
		extension IFormattableDocument document,
		ISemanticRegion endSubclauseKeyword
	) {
		// Component error behavior (begin line)
		val errorKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.errorKeyword_6_1) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.errorKeyword_8_1)
		errorKeyword.surround[oneSpace]
		val behaviorKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.behaviorKeyword_6_2) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.behaviorKeyword_8_2)
		behaviorKeyword.append[setNewLines(1, 1, 2)]
		val endKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.endKeyword_6_9) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.endKeyword_8_9)
		interior(behaviorKeyword, endKeyword, [indent])
		
		// Component error behavior (use transformations)
		val transformationsKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.transformationsKeyword_6_3_1) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.transformationsKeyword_8_3_1)
		transformationsKeyword.surround[oneSpace]
		val useTransformationsSemicolon = errorModelSubclause.regionFor.keyword(
			errorModelSubclauseAccess.semicolonKeyword_6_3_3) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.semicolonKeyword_8_3_3)
		useTransformationsSemicolon.prepend[noSpace].append[setNewLines(1, 1, 2)]
		
		val eventsKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.eventsKeyword_6_4_0) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.eventsKeyword_8_4_0)
		val transitionsKeyword = errorModelSubclause.regionFor.keyword(
			errorModelSubclauseAccess.transitionsKeyword_6_5_0) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.transitionsKeyword_8_5_0)
		val propagationsKeyword = errorModelSubclause.regionFor.keyword(
			errorModelSubclauseAccess.propagationsKeyword_6_6_0) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.propagationsKeyword_8_6_0)
		val detectionsKeyword = errorModelSubclause.regionFor.keyword(
			errorModelSubclauseAccess.detectionsKeyword_6_7_0) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.detectionsKeyword_8_7_0)
		val modeKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.modeKeyword_6_8_0) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.modeKeyword_8_8_0)
		
		// Component error behavior (events)
		if (eventsKeyword !== null) {
			eventsKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = transitionsKeyword ?: propagationsKeyword ?: detectionsKeyword ?: modeKeyword ?: endKeyword
			interior(eventsKeyword, endMarker, [indent])
		}
		errorModelSubclause.events.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		
		// Component error behavior (transitions)
		if (transitionsKeyword !== null) {
			transitionsKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = propagationsKeyword ?: detectionsKeyword ?: modeKeyword ?: endKeyword
			interior(transitionsKeyword, endMarker, [indent])
		}
		errorModelSubclause.transitions.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		
		// Component error behavior (propagations)
		if (propagationsKeyword !== null) {
			propagationsKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = detectionsKeyword ?: modeKeyword ?: endKeyword
			interior(propagationsKeyword, endMarker, [indent])
		}
		errorModelSubclause.outgoingPropagationConditions.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		
		// Component error behavior (detections)
		if (detectionsKeyword !== null) {
			detectionsKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = modeKeyword ?: endKeyword
			interior(detectionsKeyword, endMarker, [indent])
		}
		errorModelSubclause.errorDetections.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		
		// Component error behavior (mode mappings)
		val mappingsKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.mappingsKeyword_6_8_1) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.mappingsKeyword_8_8_1)
		if (mappingsKeyword !== null) {
			mappingsKeyword.prepend[oneSpace].append[setNewLines(1, 1, 2)]
			interior(mappingsKeyword, endKeyword, [indent])
		}
		errorModelSubclause.errorStateToModeMappings.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		
		// Component error behavior (end line)
		val componentKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.componentKeyword_6_10) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.componentKeyword_8_10)
		componentKeyword.prepend[oneSpace].append[noSpace]
		val componentErrorBehaviorSemicolon = errorModelSubclause.regionFor.keyword(
			errorModelSubclauseAccess.semicolonKeyword_6_11) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.semicolonKeyword_8_11)
		switch nextSemantic : componentErrorBehaviorSemicolon?.nextSemanticRegion {
			case endSubclauseKeyword: componentErrorBehaviorSemicolon.append[setNewLines(1, 1, 2)]
			case nextSemantic !== null: componentErrorBehaviorSemicolon.append[newLines = 2]
		}
	}
	
	def private void formatCompositeErrorBehavior(
		ErrorModelSubclause errorModelSubclause,
		extension IFormattableDocument document,
		ISemanticRegion endSubclauseKeyword
	) {
		// Composite error behavior (begin line)
		val errorKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.errorKeyword_7_1) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.errorKeyword_9_1)
		errorKeyword.surround[oneSpace]
		val behaviorKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.behaviorKeyword_7_2) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.behaviorKeyword_9_2)
		behaviorKeyword.append[setNewLines(1, 1, 2)]
		val endKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.endKeyword_7_4) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.endKeyword_9_4)
		interior(behaviorKeyword, endKeyword, [indent])
		
		// Composite error behavior (states)
		val statesKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.statesKeyword_7_3_0) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.statesKeyword_9_3_0)
		statesKeyword.append[setNewLines(1, 1, 2)]
		interior(statesKeyword, endKeyword, [indent])
		errorModelSubclause.states.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		
		// Composite error behavior (end line)
		val compositeKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.compositeKeyword_7_5) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.compositeKeyword_9_5)
		compositeKeyword.prepend[oneSpace].append[noSpace]
		val compositeErrorBehaviorSemicolon = errorModelSubclause.regionFor.keyword(
			errorModelSubclauseAccess.semicolonKeyword_7_6) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.semicolonKeyword_9_6)
		switch nextSemantic : compositeErrorBehaviorSemicolon?.nextSemanticRegion {
			case endSubclauseKeyword: compositeErrorBehaviorSemicolon.append[setNewLines(1, 1, 2)]
			case nextSemantic !== null: compositeErrorBehaviorSemicolon.append[newLines = 2]
		}
	}
	
	def private void formatConnectionError(
		ErrorModelSubclause errorModelSubclause,
		extension IFormattableDocument document,
		ISemanticRegion endSubclauseKeyword
	) {
		// Connection error (begin line)
		val errorKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.errorKeyword_8_1) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.errorKeyword_10_1)
		errorKeyword.prepend[oneSpace].append[setNewLines(1, 1, 2)]
		val endKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.endKeyword_8_4) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.endKeyword_10_4)
		interior(errorKeyword, endKeyword, [indent])
		
		// Connection error (use transformations)
		val transformationsKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.transformationsKeyword_8_2_1) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.transformationsKeyword_10_2_1)
		transformationsKeyword.surround[oneSpace]
		val connectionErrorUseTransformationsSemicolon = errorModelSubclause.regionFor.keyword(
			errorModelSubclauseAccess.semicolonKeyword_8_2_3) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.semicolonKeyword_10_2_3)
		connectionErrorUseTransformationsSemicolon.prepend[noSpace].append[setNewLines(1, 1, 2)]
		
		// Connection error (sources)
		errorModelSubclause.connectionErrorSources.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		
		// Connection error (end line)
		val connectionKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.connectionKeyword_8_5) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.connectionKeyword_10_5)
		connectionKeyword.prepend[oneSpace].append[noSpace]
		val connectionErrorSemicolon = errorModelSubclause.regionFor.keyword(
			errorModelSubclauseAccess.semicolonKeyword_8_6) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.semicolonKeyword_10_6)
		switch nextSemantic : connectionErrorSemicolon?.nextSemanticRegion {
			case endSubclauseKeyword: connectionErrorSemicolon.append[setNewLines(1, 1, 2)]
			case nextSemantic !== null: connectionErrorSemicolon.append[newLines = 2]
		}
	}
	
	def private void formatPropagationPaths(
		ErrorModelSubclause errorModelSubclause,
		extension IFormattableDocument document,
		ISemanticRegion endSubclauseKeyword
	) {
		// Propagation paths (begin line)
		val pathsKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.pathsKeyword_9_1) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.pathsKeyword_11_1)
		pathsKeyword.prepend[oneSpace].append[setNewLines(1, 1, 2)]
		val endKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.endKeyword_9_4) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.endKeyword_11_4)
		interior(pathsKeyword, endKeyword, [indent])
		
		// Propagation paths (points)
		errorModelSubclause.points.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		
		// Propagation paths (paths)
		errorModelSubclause.paths.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		
		// Propagation paths (end line)
		val endPathsKeyword = errorModelSubclause.regionFor.keyword(errorModelSubclauseAccess.pathsKeyword_9_5) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.pathsKeyword_11_5)
		endPathsKeyword.prepend[oneSpace].append[noSpace]
		val propagationPathsSemicolon = errorModelSubclause.regionFor.keyword(
			errorModelSubclauseAccess.semicolonKeyword_9_6) ?:
			errorModelSubclause.regionFor.keyword(EMV2SubclauseAccess.semicolonKeyword_11_6)
		switch nextSemantic : propagationPathsSemicolon?.nextSemanticRegion {
			case endSubclauseKeyword: propagationPathsSemicolon.append[setNewLines(1, 1, 2)]
			case nextSemantic !== null: propagationPathsSemicolon.append[newLines = 2]
		}
	}
	
	// Grammar rules: ErrorModelLibrary and EMV2Library
	def dispatch void format(ErrorModelLibrary errorModelLibrary, extension IFormattableDocument document) {
		if (errorModelLibrary.regionForEObject === null) {
			return
		}

		errorModelLibrary.surround[noSpace]

		// Library line
		errorModelLibrary.regionFor.assignment(EMV2LibraryAccess.nameAssignment_0_1_1).prepend[oneSpace].append [
			newLines = 2
		]

		// Package declaration
		errorModelLibrary.regionFor.assignment(EMV2LibraryAccess.nameAssignment_1_1).prepend[oneSpace].append [
			setNewLines(1, 1, 2)
		]
		val publicKeyword = errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.publicKeyword_1_2)
		publicKeyword.append[setNewLines(1, 1, 2)]
		errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.annexKeyword_1_3).append[oneSpace]
		val leftCurly = errorModelLibrary.regionFor.keyword(
			EMV2LibraryAccess.leftCurlyBracketAsteriskAsteriskKeyword_1_5)
		leftCurly.prepend[oneSpace].append[setNewLines(1, 1, 2)]

		// Begin error types
		val errorTypesKeyword = errorModelLibrary.regionFor.keyword(errorModelLibraryAccess.typesKeyword_1_1) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.typesKeyword_0_1_2_1) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.typesKeyword_1_6_1)
		errorTypesKeyword.prepend[oneSpace].append[setNewLines(1, 1, 2)]
		val endKeyword = errorModelLibrary.regionFor.keyword(errorModelLibraryAccess.endKeyword_1_6) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.endKeyword_0_1_2_6) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.endKeyword_1_6_6)
		interior(errorTypesKeyword, endKeyword, [indent])

		// Use types
		val typesKeyword = errorModelLibrary.regionFor.keyword(errorModelLibraryAccess.typesKeyword_1_2_1) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.typesKeyword_0_1_2_2_1) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.typesKeyword_1_6_2_1)
		val useTypesSemicolon = errorModelLibrary.regionFor.keyword(errorModelLibraryAccess.semicolonKeyword_1_2_4) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.semicolonKeyword_0_1_2_2_4) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.semicolonKeyword_1_6_2_4)
		interior(typesKeyword, useTypesSemicolon, [indent])
		typesKeyword.surround[oneSpace]
		val useTypesCommas = errorModelLibrary.regionFor.keywords(errorModelLibraryAccess.commaKeyword_1_2_3_0) +
			errorModelLibrary.regionFor.keywords(EMV2LibraryAccess.commaKeyword_0_1_2_2_3_0) +
			errorModelLibrary.regionFor.keywords(EMV2LibraryAccess.commaKeyword_1_6_2_3_0)
		useTypesCommas.forEach[prepend[noSpace].append[oneSpace; autowrap]]
		useTypesSemicolon.prepend[noSpace].append[setNewLines(1, 1, 2)]

		// Extends
		val extendsKeyword = errorModelLibrary.regionFor.keyword(errorModelLibraryAccess.extendsKeyword_1_3_0) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.extendsKeyword_0_1_2_3_0) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.extendsKeyword_1_6_3_0)
		val with = errorModelLibrary.regionFor.keyword(errorModelLibraryAccess.withKeyword_1_3_3) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.withKeyword_0_1_2_3_3) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.withKeyword_1_6_3_3)
		interior(extendsKeyword, with, [indent])
		extendsKeyword.append[oneSpace]
		val extendsCommas = errorModelLibrary.regionFor.keywords(errorModelLibraryAccess.commaKeyword_1_3_2_0) +
			errorModelLibrary.regionFor.keywords(EMV2LibraryAccess.commaKeyword_0_1_2_3_2_0) +
			errorModelLibrary.regionFor.keywords(EMV2LibraryAccess.commaKeyword_1_6_3_2_0)
		extendsCommas.forEach[prepend[noSpace].append[oneSpace; autowrap]]
		with.prepend[oneSpace].append[setNewLines(1, 1, 2)]

		// Types and type sets
		errorModelLibrary.types.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		errorModelLibrary.typesets.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]

		// Properties
		val propertiesKeyword = errorModelLibrary.regionFor.keyword(errorModelLibraryAccess.propertiesKeyword_1_5_0) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.propertiesKeyword_0_1_2_5_0) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.propertiesKeyword_1_6_5_0)
		propertiesKeyword.append[setNewLines(1, 1, 2)]
		interior(propertiesKeyword, endKeyword, [indent])
		errorModelLibrary.properties.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]

		// End error types
		val endTypesKeyword = errorModelLibrary.regionFor.keyword(errorModelLibraryAccess.typesKeyword_1_7) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.typesKeyword_0_1_2_7) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.typesKeyword_1_6_7)
		endTypesKeyword.prepend[oneSpace].append[noSpace]
		val rightCurly = errorModelLibrary.regionFor.keyword(
			EMV2LibraryAccess.asteriskAsteriskRightCurlyBracketKeyword_1_10)
		val endTypesSemicolon = errorModelLibrary.regionFor.keyword(errorModelLibraryAccess.semicolonKeyword_1_8) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.semicolonKeyword_0_1_2_8) ?:
			errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.semicolonKeyword_1_6_8)
		if (endTypesSemicolon !== null) {
			if (endTypesSemicolon.nextSemanticRegion == rightCurly && rightCurly !== null) {
				endTypesSemicolon.append[setNewLines(1, 1, 2)]
			} else {
				endTypesSemicolon.conditionalAppend(document, [newLines = 2])
			}
		}

		// Behaviors, mappings, and transformations
		errorModelLibrary.behaviors.forEach [
			if (it.regionForEObject.nextSemanticRegion == rightCurly && rightCurly !== null) {
				it.append[setNewLines(1, 1, 2)]
			} else {
				it.conditionalAppend(document, [newLines = 2])
			}
			it.format(document)
		]
		errorModelLibrary.mappings.forEach [
			if (it.regionForEObject.nextSemanticRegion == rightCurly && rightCurly !== null) {
				it.append[setNewLines(1, 1, 2)]
			} else {
				it.conditionalAppend(document, [newLines = 2])
			}
			it.format(document)
		]
		errorModelLibrary.transformations.forEach [
			if (it.regionForEObject.nextSemanticRegion == rightCurly && rightCurly !== null) {
				it.append[setNewLines(1, 1, 2)]
			} else {
				it.conditionalAppend(document, [newLines = 2])
			}
			it.format(document)
		]

		// End package declaration
		errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.semicolonKeyword_1_11).prepend[noSpace].append [
			setNewLines(1, 1, 2)
		]
		errorModelLibrary.regionFor.ruleCall(EMV2LibraryAccess.QEMREFParserRuleCall_1_13).prepend[oneSpace].append [
			noSpace
		]

		// Indentation in package
		interior(publicKeyword, errorModelLibrary.regionFor.keyword(EMV2LibraryAccess.endKeyword_1_12), [indent])
		interior(leftCurly, rightCurly, [indent])
	}

	// Grammar rules: EMV2PropertyAssociation and BasicEMV2PropertyAssociation
	def dispatch void format(EMV2PropertyAssociation emv2PropertyAssociation, extension IFormattableDocument document) {
		// Assign symbol
		val assign = emv2PropertyAssociation.regionFor.keyword(
			EMV2PropertyAssociationAccess.equalsSignGreaterThanSignKeyword_1) ?:
			emv2PropertyAssociation.regionFor.keyword(
				basicEMV2PropertyAssociationAccess.equalsSignGreaterThanSignKeyword_1)
		assign.surround[oneSpace]

		// Values
		emv2PropertyAssociation.ownedValues.forEach[it.format(document)]
		val valuesCommas = emv2PropertyAssociation.regionFor.keywords(
			EMV2PropertyAssociationAccess.commaKeyword_2_1_0) +
			emv2PropertyAssociation.regionFor.keywords(basicEMV2PropertyAssociationAccess.commaKeyword_2_1_0)
		valuesCommas.forEach[prepend[noSpace].append[oneSpace]]

		// Applies to
		val appliesKeyword = emv2PropertyAssociation.regionFor.keyword(EMV2PropertyAssociationAccess.appliesKeyword_3_0) ?:
			emv2PropertyAssociation.regionFor.keyword(basicEMV2PropertyAssociationAccess.appliesKeyword_3_0)
		appliesKeyword.surround[oneSpace]
		val toKeyword = emv2PropertyAssociation.regionFor.keyword(EMV2PropertyAssociationAccess.toKeyword_3_1) ?:
			emv2PropertyAssociation.regionFor.keyword(basicEMV2PropertyAssociationAccess.toKeyword_3_1)
		toKeyword.append[oneSpace]
		emv2PropertyAssociation.emv2Path.forEach[it.format(document)]
		val appliesToCommas = emv2PropertyAssociation.regionFor.keywords(
			EMV2PropertyAssociationAccess.commaKeyword_3_2_1_0) +
			emv2PropertyAssociation.regionFor.keywords(basicEMV2PropertyAssociationAccess.commaKeyword_3_2_1_0)
		appliesToCommas.forEach[prepend[noSpace].append[oneSpace]]

		// Semicolon
		val semicolon = emv2PropertyAssociation.regionFor.keyword(EMV2PropertyAssociationAccess.semicolonKeyword_4) ?:
			emv2PropertyAssociation.regionFor.keyword(basicEMV2PropertyAssociationAccess.semicolonKeyword_4)
		semicolon.prepend[noSpace]
	}

	// Grammar rules: EMV2Path, BasicEMV2Path, QualifiedErrorEventOrPropagation, QualifiedErrorPropagation
	def dispatch void format(EMV2Path emv2Path, extension IFormattableDocument document) {
		emv2Path.containmentPath.surround[noSpace]
		emv2Path.containmentPath.format(document)
		emv2Path.regionFor.keyword(EMV2PathAccess.commercialAtKeyword_0_2).append[noSpace]
		emv2Path.emv2Target.format(document)
	}

	// Grammar rules: EMV2PathElementOrKind, EMV2PathElement, EMV2ErrorPropagationPath
	def dispatch void format(EMV2PathElement emv2PathElement, extension IFormattableDocument document) {
		emv2PathElement.regionFor.keyword(EMV2PathElementOrKindAccess.fullStopKeyword_0_1_0).surround[noSpace]
		val pathDot = emv2PathElement.regionFor.keyword(EMV2PathElementOrKindAccess.fullStopKeyword_1_1_0) ?:
			emv2PathElement.regionFor.keyword(EMV2PathElementAccess.fullStopKeyword_1_0) ?:
			emv2PathElement.regionFor.keyword(EMV2ErrorPropagationPathAccess.fullStopKeyword_1_1_0)
		pathDot.surround[noSpace]
		emv2PathElement.path.format(document)
	}

	// Grammar rule: TypeDefinition
	def dispatch void format(ErrorType errorType, extension IFormattableDocument document) {
		// Simple type
		errorType.regionFor.keyword(typeDefinitionAccess.colonKeyword_1_0_0).prepend[noSpace].append[oneSpace]

		// Extends
		errorType.regionFor.keyword(typeDefinitionAccess.colonKeyword_1_1_0).prepend[noSpace].append[oneSpace]
		errorType.regionFor.keyword(typeDefinitionAccess.extendsKeyword_1_1_2).surround[oneSpace]

		// Renames
		errorType.regionFor.keyword(typeDefinitionAccess.renamesKeyword_1_2_0).surround[oneSpace]
		errorType.regionFor.keyword(typeDefinitionAccess.typeKeyword_1_2_1).append[oneSpace]

		// Semicolon
		errorType.regionFor.keyword(typeDefinitionAccess.semicolonKeyword_2).prepend[noSpace]
	}

	// Grammar rules: TypeSetDefinition, TypeSetConstructor, and NoErrorTypeSet
	def dispatch void format(TypeSet typeSet, extension IFormattableDocument document) {
		// Named and renames
		typeSet.regionFor.keyword(typeSetDefinitionAccess.colonKeyword_1_0_0).prepend[noSpace].append[oneSpace]
		typeSet.regionFor.keyword(typeSetDefinitionAccess.renamesKeyword_1_1_0).surround[oneSpace]
		val setKeyword = typeSet.regionFor.keyword(typeSetDefinitionAccess.setKeyword_1_0_2) ?:
			typeSet.regionFor.keyword(typeSetDefinitionAccess.setKeyword_1_1_2)
		setKeyword.surround[oneSpace]

		// Curly braces
		val leftCurly = typeSet.regionFor.keyword(typeSetDefinitionAccess.leftCurlyBracketKeyword_1_0_3) ?:
			typeSet.regionFor.keyword(typeSetConstructorAccess.leftCurlyBracketKeyword_0) ?:
			typeSet.regionFor.keyword(noErrorTypeSetAccess.leftCurlyBracketKeyword_1)
		val rightCurly = typeSet.regionFor.keyword(typeSetDefinitionAccess.rightCurlyBracketKeyword_1_0_6) ?:
			typeSet.regionFor.keyword(typeSetConstructorAccess.rightCurlyBracketKeyword_3) ?:
			typeSet.regionFor.keyword(noErrorTypeSetAccess.rightCurlyBracketKeyword_3)
		interior(leftCurly, rightCurly, [indent])
		leftCurly.append[noSpace]
		val commas = typeSet.regionFor.keywords(typeSetDefinitionAccess.commaKeyword_1_0_5_0) +
			typeSet.regionFor.keywords(typeSetConstructorAccess.commaKeyword_2_0)
		commas.forEach[prepend[noSpace].append[oneSpace; autowrap]]
		typeSet.typeTokens.forEach[it.format(document)]
		rightCurly.prepend[noSpace]

		// Semicolon in TypeSetDefinition
		typeSet.regionFor.keyword(typeSetDefinitionAccess.semicolonKeyword_2).prepend[noSpace]
	}

	// Grammar rules: TypeSetElement and NoErrorTypeToken
	def dispatch void format(TypeToken typeToken, extension IFormattableDocument document) {
		typeToken.regionFor.keywords(typeSetElementAccess.asteriskKeyword_1_0).forEach [
			surround[oneSpace].append[autowrap]
		]
	}

	def dispatch void format(TypeTransformationSet typeTransformationSet, extension IFormattableDocument document) {
		// Type transformations
		typeTransformationSet.regionFor.keyword(typeTransformationSetAccess.transformationsKeyword_1).surround[oneSpace]
		val nameAssignment = typeTransformationSet.regionFor.assignment(typeTransformationSetAccess.nameAssignment_2)
		nameAssignment.append[setNewLines(1, 1, 2)]
		interior(
			nameAssignment,
			typeTransformationSet.regionFor.keyword(typeTransformationSetAccess.endKeyword_5),
			[indent]
		)

		// Use types
		val typesKeyword = typeTransformationSet.regionFor.keyword(typeTransformationSetAccess.typesKeyword_3_1)
		val semicolon = typeTransformationSet.regionFor.keyword(typeTransformationSetAccess.semicolonKeyword_3_4)
		interior(typesKeyword, semicolon, [indent])
		typesKeyword.surround[oneSpace]
		typeTransformationSet.regionFor.keywords(typeTransformationSetAccess.commaKeyword_3_3_0).forEach [
			prepend[noSpace].append[oneSpace; autowrap]
		]
		semicolon.prepend[noSpace].append[setNewLines(1, 1, 2)]

		// Transformations
		typeTransformationSet.transformation.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]

		// End transformations
		typeTransformationSet.regionFor.keyword(typeTransformationSetAccess.transformationsKeyword_6).prepend[oneSpace].
			append[noSpace]
	}

	def dispatch void format(TypeTransformation typeTransformation, extension IFormattableDocument document) {
		typeTransformation.source.format(document)
		typeTransformation.regionFor.keyword(typeTransformationAccess.hyphenMinusLeftSquareBracketKeyword_1).prepend [
			oneSpace
		].append[noSpace]
		typeTransformation.contributor.format(document)
		typeTransformation.regionFor.keyword(
			typeTransformationAccess.rightSquareBracketHyphenMinusGreaterThanSignKeyword_3).prepend[noSpace].append [
			oneSpace
		]
		typeTransformation.target.format(document)
		typeTransformation.regionFor.keyword(typeTransformationAccess.semicolonKeyword_5).prepend[noSpace]
	}

	def dispatch void format(TypeMappingSet typeMappingSet, extension IFormattableDocument document) {
		// Type mappings
		typeMappingSet.regionFor.keyword(typeMappingSetAccess.mappingsKeyword_1).surround[oneSpace]
		val nameAssignment = typeMappingSet.regionFor.assignment(typeMappingSetAccess.nameAssignment_2)
		nameAssignment.append[setNewLines(1, 1, 2)]
		interior(nameAssignment, typeMappingSet.regionFor.keyword(typeMappingSetAccess.endKeyword_5), [indent])

		// Use types
		val typesKeyword = typeMappingSet.regionFor.keyword(typeMappingSetAccess.typesKeyword_3_1)
		val semicolon = typeMappingSet.regionFor.keyword(typeMappingSetAccess.semicolonKeyword_3_4)
		interior(typesKeyword, semicolon, [indent])
		typesKeyword.surround[oneSpace]
		typeMappingSet.regionFor.keywords(typeMappingSetAccess.commaKeyword_3_3_0).forEach [
			prepend[noSpace].append[oneSpace; autowrap]
		]
		semicolon.prepend[noSpace].append[setNewLines(1, 1, 2)]

		// Mappings
		typeMappingSet.mapping.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]

		// End mappings
		typeMappingSet.regionFor.keyword(typeMappingSetAccess.mappingsKeyword_6).prepend[oneSpace].append[noSpace]
	}

	def dispatch void format(TypeMapping typeMapping, extension IFormattableDocument document) {
		typeMapping.source.format(document)
		typeMapping.regionFor.keyword(typeMappingAccess.hyphenMinusGreaterThanSignKeyword_1).surround[oneSpace]
		typeMapping.target.format(document)
		typeMapping.regionFor.keyword(typeMappingAccess.semicolonKeyword_3).prepend[noSpace]
	}

	def dispatch void format(ErrorPropagation errorPropagation, extension IFormattableDocument document) {
		errorPropagation.featureorPPRef.format(document)
		errorPropagation.regionFor.keyword(errorPropagationAccess.colonKeyword_2).prepend[noSpace].append[oneSpace]
		errorPropagation.regionFor.keyword(errorPropagationAccess.notNotKeyword_3_0).append[oneSpace]
		errorPropagation.regionFor.keyword(errorPropagationAccess.propagationKeyword_5).surround[oneSpace]
		errorPropagation.typeSet.format(document)
		errorPropagation.typeSet.append[noSpace]
	}

	def dispatch void format(FeatureorPPReference featureorPPReference, extension IFormattableDocument document) {
		featureorPPReference.regionFor.keyword(featureorPPReferenceAccess.fullStopKeyword_1_0).surround[noSpace]
		featureorPPReference.next.format(document)
	}

	def dispatch void format(ErrorSource errorSource, extension IFormattableDocument document) {
		errorSource.regionFor.keyword(errorSourceAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		errorSource.regionFor.keyword(errorSourceAccess.sourceKeyword_3).surround[oneSpace]
		errorSource.typeTokenConstraint.prepend[oneSpace]
		errorSource.typeTokenConstraint.format(document)
		errorSource.regionFor.keyword(errorSourceAccess.whenKeyword_6_0).surround[oneSpace]
		errorSource.failureModeType.prepend[oneSpace]
		errorSource.failureModeType.format(document)
		errorSource.regionFor.keyword(errorSourceAccess.ifKeyword_7_0).surround[oneSpace]
		errorSource.regionFor.keyword(errorSourceAccess.semicolonKeyword_8).prepend[noSpace]
	}

	def dispatch void format(ErrorSink errorSink, extension IFormattableDocument document) {
		errorSink.regionFor.keyword(errorSinkAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		errorSink.regionFor.keyword(errorSinkAccess.sinkKeyword_3).surround[oneSpace]
		errorSink.typeTokenConstraint.prepend[oneSpace]
		errorSink.typeTokenConstraint.format(document)
		errorSink.regionFor.keyword(errorSinkAccess.ifKeyword_6_0).surround[oneSpace]
		errorSink.regionFor.keyword(errorSinkAccess.semicolonKeyword_7).prepend[noSpace]
	}

	def dispatch void format(ErrorPath errorPath, extension IFormattableDocument document) {
		errorPath.regionFor.keyword(errorPathAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		errorPath.regionFor.keyword(errorPathAccess.pathKeyword_3).surround[oneSpace]
		errorPath.typeTokenConstraint.prepend[oneSpace]
		errorPath.typeTokenConstraint.format(document)
		errorPath.regionFor.keyword(errorPathAccess.hyphenMinusGreaterThanSignKeyword_6).surround[oneSpace]
		errorPath.targetToken.prepend[oneSpace]
		errorPath.targetToken.format(document)
		errorPath.regionFor.keyword(errorPathAccess.useKeyword_8_1_0).surround[oneSpace]
		errorPath.regionFor.keyword(errorPathAccess.mappingsKeyword_8_1_1).append[oneSpace]
		errorPath.regionFor.keyword(errorPathAccess.ifKeyword_9_0).surround[oneSpace]
		errorPath.regionFor.keyword(errorPathAccess.semicolonKeyword_10).prepend[noSpace]
	}

	def dispatch void format(PropagationPoint propagationPoint, extension IFormattableDocument document) {
		propagationPoint.regionFor.keyword(propagationPointAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		propagationPoint.regionFor.keyword(propagationPointAccess.pointKeyword_3).prepend[oneSpace].append[noSpace]
	}

	def dispatch void format(PropagationPath propagationPath, extension IFormattableDocument document) {
		propagationPath.regionFor.keyword(propagationPathAccess.colonKeyword_0_1).prepend[noSpace].append[oneSpace]
		propagationPath.source.format(document)
		propagationPath.regionFor.keyword(propagationPathAccess.hyphenMinusGreaterThanSignKeyword_2).surround[oneSpace]
		propagationPath.target.format(document)
		propagationPath.target.append[noSpace]
	}

	def dispatch void format(QualifiedPropagationPoint qualifiedPropagationPoint,
		extension IFormattableDocument document) {
		qualifiedPropagationPoint.subcomponent.format(document)
		qualifiedPropagationPoint.regionFor.keyword(qualifiedPropagationPointAccess.fullStopKeyword_0_1).surround [
			noSpace
		]
		qualifiedPropagationPoint.next.format(document)
	}

	def dispatch void format(ErrorBehaviorStateMachine errorBehaviorStateMachine,
		extension IFormattableDocument document) {
		// Error behavior
		errorBehaviorStateMachine.regionFor.keyword(errorBehaviorStateMachineAccess.behaviorKeyword_1).surround[oneSpace]
		val nameAssignment = errorBehaviorStateMachine.regionFor.assignment(
			errorBehaviorStateMachineAccess.nameAssignment_2)
		nameAssignment.append[setNewLines(1, 1, 2)]
		val endKeyword = errorBehaviorStateMachine.regionFor.keyword(errorBehaviorStateMachineAccess.endKeyword_9)
		interior(nameAssignment, endKeyword, [indent])

		// Use types
		val typesKeyword = errorBehaviorStateMachine.regionFor.keyword(errorBehaviorStateMachineAccess.typesKeyword_3_1)
		val useTypesSemicolon = errorBehaviorStateMachine.regionFor.keyword(
			errorBehaviorStateMachineAccess.semicolonKeyword_3_4)
		interior(typesKeyword, useTypesSemicolon, [indent])
		typesKeyword.surround[oneSpace]
		errorBehaviorStateMachine.regionFor.keywords(errorBehaviorStateMachineAccess.commaKeyword_3_3_0).forEach [
			prepend[noSpace].append[oneSpace; autowrap]
		]
		useTypesSemicolon.prepend[noSpace].append[setNewLines(1, 1, 2)]

		// Use transformations
		errorBehaviorStateMachine.regionFor.keyword(errorBehaviorStateMachineAccess.transformationsKeyword_4_1).surround [
			oneSpace
		]
		errorBehaviorStateMachine.regionFor.keyword(errorBehaviorStateMachineAccess.semicolonKeyword_4_3).prepend [
			noSpace
		].append[setNewLines(1, 1, 2)]
		
		val eventsKeyword = errorBehaviorStateMachine.regionFor.keyword(
			errorBehaviorStateMachineAccess.eventsKeyword_5_0)
		val statesKeyword = errorBehaviorStateMachine.regionFor.keyword(
			errorBehaviorStateMachineAccess.statesKeyword_6_0)
		val transitionsKeyword = errorBehaviorStateMachine.regionFor.keyword(
			errorBehaviorStateMachineAccess.transitionsKeyword_7_0)
		val propertiesKeyword = errorBehaviorStateMachine.regionFor.keyword(
			errorBehaviorStateMachineAccess.propertiesKeyword_8_0)

		// Events
		if (eventsKeyword !== null) {
			eventsKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = statesKeyword ?: transitionsKeyword ?: propertiesKeyword ?: endKeyword
			interior(eventsKeyword, endMarker, [indent])
		}
		errorBehaviorStateMachine.events.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]

		// States
		if (statesKeyword !== null) {
			statesKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = transitionsKeyword ?: propertiesKeyword ?: endKeyword
			interior(statesKeyword, endMarker, [indent])
		}
		errorBehaviorStateMachine.states.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]

		// Transitions
		if (transitionsKeyword !== null) {
			transitionsKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = propertiesKeyword ?: endKeyword
			interior(transitionsKeyword, endMarker, [indent])
		}
		errorBehaviorStateMachine.transitions.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]

		// Properties
		if (propertiesKeyword !== null) {
			propertiesKeyword.append[setNewLines(1, 1, 2)]
			interior(propertiesKeyword, endKeyword, [indent])
		}
		errorBehaviorStateMachine.properties.forEach [
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]

		// End behavior
		errorBehaviorStateMachine.regionFor.keyword(errorBehaviorStateMachineAccess.behaviorKeyword_10).prepend [
			oneSpace
		].append[noSpace]
	}

	def dispatch void format(ErrorEvent errorEvent, extension IFormattableDocument document) {
		errorEvent.regionFor.keyword(errorEventAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		errorEvent.regionFor.keyword(errorEventAccess.eventKeyword_3).prepend[oneSpace]
		errorEvent.typeSet.prepend[oneSpace]
		errorEvent.typeSet.format(document)
		errorEvent.regionFor.keyword(errorEventAccess.ifKeyword_5_0).surround[oneSpace]
		errorEvent.regionFor.keyword(errorEventAccess.semicolonKeyword_6).prepend[noSpace]
	}

	def dispatch void format(RepairEvent repairEvent, extension IFormattableDocument document) {
		repairEvent.regionFor.keyword(repairEventAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		repairEvent.regionFor.keyword(repairEventAccess.eventKeyword_3).prepend[oneSpace]
		val whenKeyword = repairEvent.regionFor.keyword(repairEventAccess.whenKeyword_4_0)
		val semicolon = repairEvent.regionFor.keyword(repairEventAccess.semicolonKeyword_5)
		interior(whenKeyword, semicolon, [indent])
		whenKeyword.surround[oneSpace]
		repairEvent.regionFor.keywords(repairEventAccess.commaKeyword_4_2_0).forEach [
			prepend[noSpace].append[oneSpace; autowrap]
		]
		semicolon.prepend[noSpace]
	}

	def dispatch void format(RecoverEvent recoverEvent, extension IFormattableDocument document) {
		recoverEvent.regionFor.keyword(recoverEventAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		recoverEvent.regionFor.keyword(recoverEventAccess.eventKeyword_3).prepend[oneSpace]
		val whenKeyword = recoverEvent.regionFor.keyword(recoverEventAccess.whenKeyword_4_0)
		val semicolon = recoverEvent.regionFor.keyword(recoverEventAccess.semicolonKeyword_6)
		interior(whenKeyword, semicolon, [indent])
		whenKeyword.surround[oneSpace]
		recoverEvent.regionFor.keywords(recoverEventAccess.commaKeyword_4_2_0).forEach [
			prepend[noSpace].append[oneSpace; autowrap]
		]
		recoverEvent.regionFor.keyword(recoverEventAccess.ifKeyword_5_0).surround[oneSpace]
		semicolon.prepend[noSpace]
	}

	def dispatch void format(ErrorBehaviorState errorBehaviorState, extension IFormattableDocument document) {
		errorBehaviorState.regionFor.keyword(errorBehaviorStateAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		errorBehaviorState.regionFor.keyword(errorBehaviorStateAccess.intialInitialKeyword_2_0).append[oneSpace]
		errorBehaviorState.typeSet.prepend[oneSpace]
		errorBehaviorState.typeSet.format(document)
		errorBehaviorState.regionFor.keyword(errorBehaviorStateAccess.semicolonKeyword_5).prepend[noSpace]
	}

	def dispatch void format(ErrorBehaviorTransition errorBehaviorTransition, extension IFormattableDocument document) {
		// Name
		errorBehaviorTransition.regionFor.keyword(errorBehaviorTransitionAccess.colonKeyword_0_1).prepend[noSpace].
			append[oneSpace]

		// Source
		errorBehaviorTransition.typeTokenConstraint.prepend[oneSpace]
		errorBehaviorTransition.typeTokenConstraint.format(document)

		// Condition
		val leftSquare = errorBehaviorTransition.regionFor.keyword(
			errorBehaviorTransitionAccess.hyphenMinusLeftSquareBracketKeyword_2)
		val rightSquare = errorBehaviorTransition.regionFor.keyword(
			errorBehaviorTransitionAccess.rightSquareBracketHyphenMinusGreaterThanSignKeyword_4)
		interior(leftSquare, rightSquare, [indent])
		leftSquare.prepend[oneSpace].append[noSpace]
		errorBehaviorTransition.condition.format(document)
		rightSquare.prepend[noSpace].append[oneSpace]

		// Target
		errorBehaviorTransition.targetToken.prepend[oneSpace]
		errorBehaviorTransition.targetToken.format(document)
		errorBehaviorTransition.regionFor.keyword(errorBehaviorTransitionAccess.steadyStateSameKeyword_5_1_0_0).append [
			oneSpace
		]

		// Destination branches
		val leftParen = errorBehaviorTransition.regionFor.keyword(
			errorBehaviorTransitionAccess.leftParenthesisKeyword_5_2_0)
		val rightParen = errorBehaviorTransition.regionFor.keyword(
			errorBehaviorTransitionAccess.rightParenthesisKeyword_5_2_3)
		interior(leftParen, rightParen, [indent])
		leftParen.append[noSpace]
		errorBehaviorTransition.regionFor.keywords(errorBehaviorTransitionAccess.commaKeyword_5_2_2_0).forEach [
			prepend[noSpace].append[oneSpace; autowrap]
		]
		errorBehaviorTransition.destinationBranches.forEach[it.format(document)]
		rightParen.prepend[noSpace]

		// Closing semicolon
		errorBehaviorTransition.regionFor.keyword(errorBehaviorTransitionAccess.semicolonKeyword_6).prepend[noSpace]
	}

	def dispatch void format(TransitionBranch transitionBranch, extension IFormattableDocument document) {
		transitionBranch.targetToken.prepend[oneSpace]
		transitionBranch.targetToken.format(document)
		transitionBranch.regionFor.keyword(transitionBranchAccess.steadyStateSameKeyword_0_1_0_0).append[oneSpace]
		transitionBranch.regionFor.keyword(transitionBranchAccess.withKeyword_1).surround[oneSpace]
		transitionBranch.value.format(document)
	}

	// Grammar rules: ConditionExpression and SConditionExpression
	def dispatch void format(OrExpression orExpression, extension IFormattableDocument document) {
		formatExpressionParentheses(orExpression, document)
		orExpression.operands.forEach[it.format(document)]
		val orKeyword = orExpression.regionFor.keyword(conditionExpressionAccess.orKeyword_1_1) ?:
			orExpression.regionFor.keyword(SConditionExpressionAccess.orKeyword_1_1)
		orKeyword.surround[oneSpace].append[autowrap]
	}

	// Grammar rules: AndExpression and SAndExpression
	def dispatch void format(AndExpression andExpression, extension IFormattableDocument document) {
		formatExpressionParentheses(andExpression, document)
		andExpression.operands.forEach[it.format(document)]
		val andKeyword = andExpression.regionFor.keyword(andExpressionAccess.andKeyword_1_1) ?:
			andExpression.regionFor.keyword(SAndExpressionAccess.andKeyword_1_1)
		andKeyword.surround[oneSpace].append[autowrap]
	}

	// Grammar rules: AllExpression and SAllExpression
	def dispatch void format(AllExpression allExpression, extension IFormattableDocument document) {
		formatExpressionParentheses(allExpression, document)
		val hyphen = allExpression.regionFor.keyword(allExpressionAccess.hyphenMinusKeyword_2_0) ?:
			allExpression.regionFor.keyword(SAllExpressionAccess.hyphenMinusKeyword_2_0)
		hyphen.surround[oneSpace]
		val leftParen = allExpression.regionFor.keyword(allExpressionAccess.leftParenthesisKeyword_3) ?:
			allExpression.regionFor.keyword(SAllExpressionAccess.leftParenthesisKeyword_3)
		leftParen.prepend[oneSpace].append[noSpace]
		allExpression.operands.forEach[it.format(document)]
		val commas = allExpression.regionFor.keywords(allExpressionAccess.commaKeyword_5_0) +
			allExpression.regionFor.keywords(SAllExpressionAccess.commaKeyword_5_0)
		commas.forEach[prepend[noSpace].append[oneSpace; autowrap]]
		val rightParen = allExpression.regionFor.keyword(allExpressionAccess.rightParenthesisKeyword_6) ?:
			allExpression.regionFor.keyword(SAllExpressionAccess.rightParenthesisKeyword_6)
		rightParen.prepend[noSpace]
	}

	// Grammar rules: OrmoreExpression and SOrmoreExpression
	def dispatch void format(OrmoreExpression ormoreExpression, extension IFormattableDocument document) {
		formatExpressionParentheses(ormoreExpression, document)
		val ormoreKeyword = ormoreExpression.regionFor.keyword(ormoreExpressionAccess.ormoreKeyword_1) ?:
			ormoreExpression.regionFor.keyword(SOrmoreExpressionAccess.ormoreKeyword_1)
		ormoreKeyword.surround[oneSpace]
		val leftParen = ormoreExpression.regionFor.keyword(ormoreExpressionAccess.leftParenthesisKeyword_2) ?:
			ormoreExpression.regionFor.keyword(SOrmoreExpressionAccess.leftParenthesisKeyword_2)
		leftParen.append[noSpace]
		ormoreExpression.operands.forEach[it.format(document)]
		val commas = ormoreExpression.regionFor.keywords(ormoreExpressionAccess.commaKeyword_4_0) +
			ormoreExpression.regionFor.keywords(SOrmoreExpressionAccess.commaKeyword_4_0)
		commas.forEach[prepend[noSpace].append[oneSpace; autowrap]]
		val rightParen = ormoreExpression.regionFor.keyword(ormoreExpressionAccess.rightParenthesisKeyword_5) ?:
			ormoreExpression.regionFor.keyword(SOrmoreExpressionAccess.rightParenthesisKeyword_5)
		rightParen.prepend[noSpace]
	}

	// Grammar rules: OrlessExpression and SOrlessExpression
	def dispatch void format(OrlessExpression orlessExpression, extension IFormattableDocument document) {
		formatExpressionParentheses(orlessExpression, document)
		val orlessKeyword = orlessExpression.regionFor.keyword(orlessExpressionAccess.orlessKeyword_1) ?:
			orlessExpression.regionFor.keyword(SOrlessExpressionAccess.orlessKeyword_1)
		orlessKeyword.surround[oneSpace]
		val leftParen = orlessExpression.regionFor.keyword(orlessExpressionAccess.leftParenthesisKeyword_2) ?:
			orlessExpression.regionFor.keyword(SOrlessExpressionAccess.leftParenthesisKeyword_2)
		leftParen.append[noSpace]
		orlessExpression.operands.forEach[it.format(document)]
		val commas = orlessExpression.regionFor.keywords(orlessExpressionAccess.commaKeyword_4_0) +
			orlessExpression.regionFor.keywords(SOrlessExpressionAccess.commaKeyword_4_0)
		commas.forEach[prepend[noSpace].append[oneSpace; autowrap]]
		val rightParen = orlessExpression.regionFor.keyword(orlessExpressionAccess.rightParenthesisKeyword_5) ?:
			orlessExpression.regionFor.keyword(SOrlessExpressionAccess.rightParenthesisKeyword_5)
		rightParen.prepend[noSpace]
	}

	def dispatch void format(ConditionElement conditionElement, extension IFormattableDocument document) {
		formatExpressionParentheses(conditionElement, document)
		conditionElement.qualifiedErrorPropagationReference.format(document)
		conditionElement.constraint.prepend[oneSpace]
		conditionElement.constraint.format(document)
	}

	def dispatch void format(OutgoingPropagationCondition outgoingPropagationCondition,
		extension IFormattableDocument document) {
		outgoingPropagationCondition.regionFor.keyword(outgoingPropagationConditionAccess.colonKeyword_0_1).prepend [
			noSpace
		].append[oneSpace]
		outgoingPropagationCondition.typeTokenConstraint.prepend[oneSpace]
		outgoingPropagationCondition.typeTokenConstraint.format(document)
		val leftSquare = outgoingPropagationCondition.regionFor.keyword(
			outgoingPropagationConditionAccess.hyphenMinusLeftSquareBracketKeyword_2)
		val rightSquare = outgoingPropagationCondition.regionFor.keyword(
			outgoingPropagationConditionAccess.rightSquareBracketHyphenMinusGreaterThanSignKeyword_4)
		interior(leftSquare, rightSquare, [indent])
		leftSquare.prepend[oneSpace].append[noSpace]
		outgoingPropagationCondition.condition.format(document)
		rightSquare.prepend[noSpace].append[oneSpace]
		outgoingPropagationCondition.typeToken.prepend[oneSpace]
		outgoingPropagationCondition.typeToken.format(document)
		outgoingPropagationCondition.regionFor.keyword(outgoingPropagationConditionAccess.semicolonKeyword_6).prepend [
			noSpace
		]
	}

	def dispatch void format(ErrorDetection errorDetection, extension IFormattableDocument document) {
		errorDetection.regionFor.keyword(errorDetectionAccess.colonKeyword_0_1).prepend[noSpace].append[oneSpace]
		errorDetection.typeTokenConstraint.prepend[oneSpace]
		errorDetection.typeTokenConstraint.format(document)
		val leftSquare = errorDetection.regionFor.keyword(errorDetectionAccess.hyphenMinusLeftSquareBracketKeyword_2)
		val rightSquare = errorDetection.regionFor.keyword(
			errorDetectionAccess.rightSquareBracketHyphenMinusGreaterThanSignKeyword_4)
		interior(leftSquare, rightSquare, [indent])
		leftSquare.prepend[oneSpace].append[noSpace]
		errorDetection.condition.format(document)
		rightSquare.prepend[noSpace].append[oneSpace]
		errorDetection.regionFor.keyword(errorDetectionAccess.exclamationMarkKeyword_6).prepend[oneSpace]
		errorDetection.regionFor.keyword(errorDetectionAccess.leftParenthesisKeyword_7_0).prepend[oneSpace].append [
			noSpace
		]
		errorDetection.errorCode.format(document)
		errorDetection.regionFor.keyword(errorDetectionAccess.rightParenthesisKeyword_7_2).prepend[noSpace]
		errorDetection.regionFor.keyword(errorDetectionAccess.semicolonKeyword_8).prepend[noSpace]
	}

	def dispatch void format(ErrorStateToModeMapping errorStateToModeMapping, extension IFormattableDocument document) {
		errorStateToModeMapping.typeToken.prepend[oneSpace]
		errorStateToModeMapping.typeToken.format(document)
		errorStateToModeMapping.regionFor.keyword(errorStateToModeMappingAccess.inKeyword_2).surround[oneSpace]
		val leftParen = errorStateToModeMapping.regionFor.keyword(
			errorStateToModeMappingAccess.leftParenthesisKeyword_4)
		val rightParen = errorStateToModeMapping.regionFor.keyword(
			errorStateToModeMappingAccess.rightParenthesisKeyword_7)
		interior(leftParen, rightParen, [indent])
		leftParen.prepend[oneSpace].append[noSpace]
		errorStateToModeMapping.regionFor.keywords(errorStateToModeMappingAccess.commaKeyword_6_0).forEach [
			prepend[noSpace].append[oneSpace; autowrap]
		]
		rightParen.surround[noSpace]
	}

	def dispatch void format(CompositeState compositeState, extension IFormattableDocument document) {
		compositeState.regionFor.keyword(compositeStateAccess.colonKeyword_0_1).prepend[noSpace].append[oneSpace]
		val leftSquare = compositeState.regionFor.keyword(compositeStateAccess.leftSquareBracketKeyword_1)
		val rightSquare = compositeState.regionFor.keyword(
			compositeStateAccess.rightSquareBracketHyphenMinusGreaterThanSignKeyword_3)
		interior(leftSquare, rightSquare, [indent])
		leftSquare.append[noSpace]
		compositeState.condition.format(document)
		rightSquare.prepend[noSpace].append[oneSpace]
		compositeState.typedToken.prepend[oneSpace]
		compositeState.typedToken.format(document)
		compositeState.regionFor.keyword(compositeStateAccess.semicolonKeyword_6).prepend[noSpace]
	}

	def dispatch void format(SConditionElement sConditionElement, extension IFormattableDocument document) {
		formatExpressionParentheses(sConditionElement, document)
		sConditionElement.qualifiedState.format(document)
		sConditionElement.constraint.prepend[oneSpace]
		sConditionElement.constraint.format(document)
		sConditionElement.regionFor.keyword(SConditionElementAccess.inKeyword_1_1_0).append[oneSpace]
		sConditionElement.qualifiedErrorPropagationReference.format(document)
	}

	def dispatch void format(QualifiedErrorBehaviorState qualifiedErrorBehaviorState,
		extension IFormattableDocument document) {
		qualifiedErrorBehaviorState.subcomponent.format(document)
		qualifiedErrorBehaviorState.regionFor.keyword(qualifiedErrorBehaviorStateAccess.fullStopKeyword_1).surround [
			noSpace
		]
		qualifiedErrorBehaviorState.next.format(document)
	}

	/**
	 * Appends if there is another semantic region after {@code appendAfter}.
	 */
	def private ISemanticRegion conditionalAppend(
		ISemanticRegion appendAfter,
		extension IFormattableDocument document,
		(IHiddenRegionFormatter)=>void initializer
	) {
		if (appendAfter?.nextSemanticRegion !== null) {
			appendAfter.append(initializer)
		}
		appendAfter
	}

	/**
	 * Appends if there is another semantic region after {@code appendAfter}.
	 */
	def private <T extends EObject> T conditionalAppend(
		T appendAfter,
		extension IFormattableDocument document,
		(IHiddenRegionFormatter)=>void initializer
	) {
		if (appendAfter?.regionForEObject?.nextSemanticRegion !== null) {
			appendAfter.append(initializer)
		}
		appendAfter
	}

	def private void formatExpressionParentheses(EObject object, extension IFormattableDocument document) {
		val leftParen = object.regionFor.keyword(conditionTermAccess.leftParenthesisKeyword_4_0) ?:
			object.regionFor.keyword(SConditionTermAccess.leftParenthesisKeyword_4_0)
		leftParen.append[noSpace]
		val rightParen = object.regionFor.keyword(conditionTermAccess.rightParenthesisKeyword_4_2) ?:
			object.regionFor.keyword(SConditionTermAccess.rightParenthesisKeyword_4_2)
		rightParen.prepend[noSpace]
	}
}

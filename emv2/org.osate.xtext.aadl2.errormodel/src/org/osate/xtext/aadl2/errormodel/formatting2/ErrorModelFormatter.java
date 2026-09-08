/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.function.Consumer;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.XbaseGenerated;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Operation;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.xtext.aadl2.errormodel.errorModel.AllExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Root;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.services.ErrorModelGrammarAccess;
import org.osate.xtext.aadl2.properties.formatting2.PropertiesFormatter;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @since 5.0
 */
public class ErrorModelFormatter extends PropertiesFormatter {
	@Inject
	@Extension
	private ErrorModelGrammarAccess grammarAccess;

	protected void _format(final EMV2Root root, @Extension final IFormattableDocument document) {
		format(root.getLibrary(), document);
		root.getSubclauses().forEach(subclause -> format(subclause, document));
	}

	protected void _format(final ErrorModelSubclause subclause, @Extension final IFormattableDocument document) {
		var objectRegion = textRegionExtensions.regionForEObject(subclause);
		if (objectRegion == null) {
			return;
		}
		if (objectRegion.getPreviousSemanticRegion() == null) {
			document.prepend(subclause, IHiddenRegionFormatter::noSpace);
		}
		var regions = textRegionExtensions.regionFor(subclause);
		var access = grammarAccess.getEMV2SubclauseAccess();
		var name = regions.assignment(access.getNameAssignment_2());
		document.append(document.prepend(name, IHiddenRegionFormatter::oneSpace),
				formatter -> formatter.setNewLines(1, 1, 2));
		var end = regions.keyword(access.getEndKeyword_13());
		document.append(end, IHiddenRegionFormatter::oneSpace);
		document.prepend(regions.keyword(access.getSemicolonKeyword_15()), IHiddenRegionFormatter::noSpace);
		document.interior(name, end, IHiddenRegionFormatter::indent);

		var legacy = grammarAccess.getErrorModelSubclauseAccess();
		var types = firstNonNull(regions.keyword(legacy.getTypesKeyword_1_1()),
				regions.keyword(access.getTypesKeyword_3_1()));
		var typesSemicolon = firstNonNull(regions.keyword(legacy.getSemicolonKeyword_1_4()),
				regions.keyword(access.getSemicolonKeyword_3_4()));
		document.interior(types, typesSemicolon, IHiddenRegionFormatter::indent);
		document.surround(types, IHiddenRegionFormatter::oneSpace);
		Iterables
				.concat(regions.keywords(legacy.getCommaKeyword_1_3_0()),
						regions.keywords(access.getCommaKeyword_3_3_0()))
				.forEach(comma -> formatComma(comma, document));
		document.prepend(typesSemicolon, IHiddenRegionFormatter::noSpace);
		appendUseClauseTerminator(typesSemicolon, document);

		document.surround(firstNonNull(regions.keyword(legacy.getTypeKeyword_2_1()),
				regions.keyword(access.getTypeKeyword_4_1())), IHiddenRegionFormatter::oneSpace);
		var equivalence = firstNonNull(regions.keyword(legacy.getEquivalenceKeyword_2_2()),
				regions.keyword(access.getEquivalenceKeyword_4_2()));
		document.append(equivalence, IHiddenRegionFormatter::oneSpace);
		var equivalenceSemicolon = firstNonNull(regions.keyword(legacy.getSemicolonKeyword_2_4()),
				regions.keyword(access.getSemicolonKeyword_4_4()));
		document.prepend(equivalenceSemicolon, IHiddenRegionFormatter::noSpace);
		appendUseClauseTerminator(equivalenceSemicolon, document);

		var mappings = firstNonNull(regions.keyword(legacy.getMappingsKeyword_3_1()),
				regions.keyword(access.getMappingsKeyword_5_1()));
		document.surround(mappings, IHiddenRegionFormatter::oneSpace);
		var mappingsSemicolon = firstNonNull(regions.keyword(legacy.getSemicolonKeyword_3_3()),
				regions.keyword(access.getSemicolonKeyword_5_3()));
		document.prepend(mappingsSemicolon, IHiddenRegionFormatter::noSpace);
		appendUseClauseTerminator(mappingsSemicolon, document);

		var behavior = firstNonNull(regions.keyword(legacy.getBehaviorKeyword_4_1()),
				regions.keyword(access.getBehaviorKeyword_6_1()));
		document.surround(behavior, IHiddenRegionFormatter::oneSpace);
		var behaviorSemicolon = firstNonNull(regions.keyword(legacy.getSemicolonKeyword_4_3()),
				regions.keyword(access.getSemicolonKeyword_6_3()));
		document.prepend(behaviorSemicolon, IHiddenRegionFormatter::noSpace);
		appendSectionTerminator(behaviorSemicolon, end, document);

		formatErrorPropagations(subclause, document, end);
		formatComponentErrorBehavior(subclause, document, end);
		formatCompositeErrorBehavior(subclause, document, end);
		formatConnectionError(subclause, document, end);
		formatPropagationPaths(subclause, document, end);

		var properties = firstNonNull(regions.keyword(legacy.getPropertiesKeyword_10_0()),
				regions.keyword(access.getPropertiesKeyword_12_0()));
		document.append(properties, formatter -> formatter.setNewLines(1, 1, 2));
		var lastProperty = subclause.getProperties().isEmpty() ? null : subclause.getProperties().getLast();
		var lastRegion = lastProperty == null ? null
				: StreamSupport.stream(textRegionExtensions.semanticRegions(lastProperty).spliterator(), false)
						.reduce((previous, current) -> current)
						.orElse(null);
		document.interior(properties, lastRegion, IHiddenRegionFormatter::indent);
		subclause.getProperties().forEach(property -> {
			conditionalAppend(property, document, formatter -> formatter.setNewLines(1, 1, 2));
			format(property, document);
		});
		document.append(subclause, objectRegion.getNextSemanticRegion() == null ? IHiddenRegionFormatter::noSpace
				: formatter -> formatter.setNewLines(2));
	}

	private void formatErrorPropagations(final ErrorModelSubclause subclause,
			@Extension final IFormattableDocument document, final ISemanticRegion subclauseEnd) {
		var regions = textRegionExtensions.regionFor(subclause);
		var legacy = grammarAccess.getErrorModelSubclauseAccess();
		var access = grammarAccess.getEMV2SubclauseAccess();
		var propagations = firstNonNull(regions.keyword(legacy.getPropagationsKeyword_5_1()),
				regions.keyword(access.getPropagationsKeyword_7_1()));
		document.append(document.prepend(propagations, IHiddenRegionFormatter::oneSpace),
				formatter -> formatter.setNewLines(1, 1, 2));
		var end = firstNonNull(regions.keyword(legacy.getEndKeyword_5_4()),
				regions.keyword(access.getEndKeyword_7_4()));
		document.interior(propagations, end, IHiddenRegionFormatter::indent);
		formatLines(subclause.getPropagations(), document);
		var flows = firstNonNull(regions.keyword(legacy.getFlowsKeyword_5_3_0()),
				regions.keyword(access.getFlowsKeyword_7_3_0()));
		document.append(flows, formatter -> formatter.setNewLines(1, 1, 2));
		document.interior(flows, end, IHiddenRegionFormatter::indent);
		formatLines(subclause.getFlows(), document);
		var endPropagations = firstNonNull(regions.keyword(legacy.getPropagationsKeyword_5_5()),
				regions.keyword(access.getPropagationsKeyword_7_5()));
		document.append(document.prepend(endPropagations, IHiddenRegionFormatter::oneSpace),
				IHiddenRegionFormatter::noSpace);
		var semicolon = firstNonNull(regions.keyword(legacy.getSemicolonKeyword_5_6()),
				regions.keyword(access.getSemicolonKeyword_7_6()));
		appendSectionTerminator(semicolon, subclauseEnd, document);
	}

	private void formatComponentErrorBehavior(final ErrorModelSubclause subclause,
			@Extension final IFormattableDocument document, final ISemanticRegion subclauseEnd) {
		var regions = textRegionExtensions.regionFor(subclause);
		var legacy = grammarAccess.getErrorModelSubclauseAccess();
		var access = grammarAccess.getEMV2SubclauseAccess();
		var error = firstNonNull(regions.keyword(legacy.getErrorKeyword_6_1()),
				regions.keyword(access.getErrorKeyword_8_1()));
		document.surround(error, IHiddenRegionFormatter::oneSpace);
		var behavior = firstNonNull(regions.keyword(legacy.getBehaviorKeyword_6_2()),
				regions.keyword(access.getBehaviorKeyword_8_2()));
		document.append(behavior, formatter -> formatter.setNewLines(1, 1, 2));
		var end = firstNonNull(regions.keyword(legacy.getEndKeyword_6_9()),
				regions.keyword(access.getEndKeyword_8_9()));
		document.interior(behavior, end, IHiddenRegionFormatter::indent);

		var transformations = firstNonNull(regions.keyword(legacy.getTransformationsKeyword_6_3_1()),
				regions.keyword(access.getTransformationsKeyword_8_3_1()));
		document.surround(transformations, IHiddenRegionFormatter::oneSpace);
		var transformationSemicolon = firstNonNull(regions.keyword(legacy.getSemicolonKeyword_6_3_3()),
				regions.keyword(access.getSemicolonKeyword_8_3_3()));
		document.append(document.prepend(transformationSemicolon, IHiddenRegionFormatter::noSpace),
				formatter -> formatter.setNewLines(1, 1, 2));

		var events = firstNonNull(regions.keyword(legacy.getEventsKeyword_6_4_0()),
				regions.keyword(access.getEventsKeyword_8_4_0()));
		var transitions = firstNonNull(regions.keyword(legacy.getTransitionsKeyword_6_5_0()),
				regions.keyword(access.getTransitionsKeyword_8_5_0()));
		var propagations = firstNonNull(regions.keyword(legacy.getPropagationsKeyword_6_6_0()),
				regions.keyword(access.getPropagationsKeyword_8_6_0()));
		var detections = firstNonNull(regions.keyword(legacy.getDetectionsKeyword_6_7_0()),
				regions.keyword(access.getDetectionsKeyword_8_7_0()));
		var mode = firstNonNull(regions.keyword(legacy.getModeKeyword_6_8_0()),
				regions.keyword(access.getModeKeyword_8_8_0()));

		formatSection(events, firstNonNull(transitions, propagations, detections, mode, end), subclause.getEvents(),
				document);
		formatSection(transitions, firstNonNull(propagations, detections, mode, end), subclause.getTransitions(),
				document);
		formatSection(propagations, firstNonNull(detections, mode, end), subclause.getOutgoingPropagationConditions(),
				document);
		formatSection(detections, firstNonNull(mode, end), subclause.getErrorDetections(), document);

		var mappings = firstNonNull(regions.keyword(legacy.getMappingsKeyword_6_8_1()),
				regions.keyword(access.getMappingsKeyword_8_8_1()));
		if (mappings != null) {
			document.append(document.prepend(mappings, IHiddenRegionFormatter::oneSpace),
					formatter -> formatter.setNewLines(1, 1, 2));
			document.interior(mappings, end, IHiddenRegionFormatter::indent);
		}
		formatLines(subclause.getErrorStateToModeMappings(), document);

		var component = firstNonNull(regions.keyword(legacy.getComponentKeyword_6_10()),
				regions.keyword(access.getComponentKeyword_8_10()));
		document.append(document.prepend(component, IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
		appendSectionTerminator(firstNonNull(regions.keyword(legacy.getSemicolonKeyword_6_11()),
				regions.keyword(access.getSemicolonKeyword_8_11())), subclauseEnd, document);
	}

	private void formatCompositeErrorBehavior(final ErrorModelSubclause subclause,
			@Extension final IFormattableDocument document, final ISemanticRegion subclauseEnd) {
		var regions = textRegionExtensions.regionFor(subclause);
		var legacy = grammarAccess.getErrorModelSubclauseAccess();
		var access = grammarAccess.getEMV2SubclauseAccess();
		var error = firstNonNull(regions.keyword(legacy.getErrorKeyword_7_1()),
				regions.keyword(access.getErrorKeyword_9_1()));
		document.surround(error, IHiddenRegionFormatter::oneSpace);
		var behavior = firstNonNull(regions.keyword(legacy.getBehaviorKeyword_7_2()),
				regions.keyword(access.getBehaviorKeyword_9_2()));
		document.append(behavior, formatter -> formatter.setNewLines(1, 1, 2));
		var end = firstNonNull(regions.keyword(legacy.getEndKeyword_7_4()),
				regions.keyword(access.getEndKeyword_9_4()));
		document.interior(behavior, end, IHiddenRegionFormatter::indent);
		var states = firstNonNull(regions.keyword(legacy.getStatesKeyword_7_3_0()),
				regions.keyword(access.getStatesKeyword_9_3_0()));
		document.append(states, formatter -> formatter.setNewLines(1, 1, 2));
		document.interior(states, end, IHiddenRegionFormatter::indent);
		formatLines(subclause.getStates(), document);
		var composite = firstNonNull(regions.keyword(legacy.getCompositeKeyword_7_5()),
				regions.keyword(access.getCompositeKeyword_9_5()));
		document.append(document.prepend(composite, IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
		appendSectionTerminator(firstNonNull(regions.keyword(legacy.getSemicolonKeyword_7_6()),
				regions.keyword(access.getSemicolonKeyword_9_6())), subclauseEnd, document);
	}

	private void formatConnectionError(final ErrorModelSubclause subclause,
			@Extension final IFormattableDocument document, final ISemanticRegion subclauseEnd) {
		var regions = textRegionExtensions.regionFor(subclause);
		var legacy = grammarAccess.getErrorModelSubclauseAccess();
		var access = grammarAccess.getEMV2SubclauseAccess();
		var error = firstNonNull(regions.keyword(legacy.getErrorKeyword_8_1()),
				regions.keyword(access.getErrorKeyword_10_1()));
		document.append(document.prepend(error, IHiddenRegionFormatter::oneSpace),
				formatter -> formatter.setNewLines(1, 1, 2));
		var end = firstNonNull(regions.keyword(legacy.getEndKeyword_8_4()),
				regions.keyword(access.getEndKeyword_10_4()));
		document.interior(error, end, IHiddenRegionFormatter::indent);
		var transformations = firstNonNull(regions.keyword(legacy.getTransformationsKeyword_8_2_1()),
				regions.keyword(access.getTransformationsKeyword_10_2_1()));
		document.surround(transformations, IHiddenRegionFormatter::oneSpace);
		var useSemicolon = firstNonNull(regions.keyword(legacy.getSemicolonKeyword_8_2_3()),
				regions.keyword(access.getSemicolonKeyword_10_2_3()));
		document.append(document.prepend(useSemicolon, IHiddenRegionFormatter::noSpace),
				formatter -> formatter.setNewLines(1, 1, 2));
		formatLines(subclause.getConnectionErrorSources(), document);
		var connection = firstNonNull(regions.keyword(legacy.getConnectionKeyword_8_5()),
				regions.keyword(access.getConnectionKeyword_10_5()));
		document.append(document.prepend(connection, IHiddenRegionFormatter::oneSpace),
				IHiddenRegionFormatter::noSpace);
		appendSectionTerminator(firstNonNull(regions.keyword(legacy.getSemicolonKeyword_8_6()),
				regions.keyword(access.getSemicolonKeyword_10_6())), subclauseEnd, document);
	}

	private void formatPropagationPaths(final ErrorModelSubclause subclause,
			@Extension final IFormattableDocument document, final ISemanticRegion subclauseEnd) {
		var regions = textRegionExtensions.regionFor(subclause);
		var legacy = grammarAccess.getErrorModelSubclauseAccess();
		var access = grammarAccess.getEMV2SubclauseAccess();
		var paths = firstNonNull(regions.keyword(legacy.getPathsKeyword_9_1()),
				regions.keyword(access.getPathsKeyword_11_1()));
		document.append(document.prepend(paths, IHiddenRegionFormatter::oneSpace),
				formatter -> formatter.setNewLines(1, 1, 2));
		var end = firstNonNull(regions.keyword(legacy.getEndKeyword_9_4()),
				regions.keyword(access.getEndKeyword_11_4()));
		document.interior(paths, end, IHiddenRegionFormatter::indent);
		formatLines(subclause.getPoints(), document);
		formatLines(subclause.getPaths(), document);
		var endPaths = firstNonNull(regions.keyword(legacy.getPathsKeyword_9_5()),
				regions.keyword(access.getPathsKeyword_11_5()));
		document.append(document.prepend(endPaths, IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
		appendSectionTerminator(firstNonNull(regions.keyword(legacy.getSemicolonKeyword_9_6()),
				regions.keyword(access.getSemicolonKeyword_11_6())), subclauseEnd, document);
	}

	protected void _format(final ErrorModelLibrary library, @Extension final IFormattableDocument document) {
		if (textRegionExtensions.regionForEObject(library) == null) {
			return;
		}
		document.surround(library, IHiddenRegionFormatter::noSpace);
		var regions = textRegionExtensions.regionFor(library);
		var embedded = grammarAccess.getEMV2LibraryAccess();
		document.append(document.prepend(regions.assignment(embedded.getNameAssignment_0_1_1()),
				IHiddenRegionFormatter::oneSpace), formatter -> formatter.setNewLines(2));
		document.append(document.prepend(regions.assignment(embedded.getNameAssignment_1_1()),
				IHiddenRegionFormatter::oneSpace), formatter -> formatter.setNewLines(1, 1, 2));
		var publicKeyword = regions.keyword(embedded.getPublicKeyword_1_2());
		document.append(publicKeyword, formatter -> formatter.setNewLines(1, 1, 2));
		document.append(regions.keyword(embedded.getAnnexKeyword_1_3()), IHiddenRegionFormatter::oneSpace);
		var leftCurly = regions.keyword(embedded.getLeftCurlyBracketAsteriskAsteriskKeyword_1_5());
		document.append(document.prepend(leftCurly, IHiddenRegionFormatter::oneSpace),
				formatter -> formatter.setNewLines(1, 1, 2));

		var legacy = grammarAccess.getErrorModelLibraryAccess();
		var errorTypes = firstNonNull(regions.keyword(legacy.getTypesKeyword_1_1()),
				regions.keyword(embedded.getTypesKeyword_0_1_2_1()), regions.keyword(embedded.getTypesKeyword_1_6_1()));
		document.append(document.prepend(errorTypes, IHiddenRegionFormatter::oneSpace),
				formatter -> formatter.setNewLines(1, 1, 2));
		var end = firstNonNull(regions.keyword(legacy.getEndKeyword_1_6()),
				regions.keyword(embedded.getEndKeyword_0_1_2_6()), regions.keyword(embedded.getEndKeyword_1_6_6()));
		document.interior(errorTypes, end, IHiddenRegionFormatter::indent);

		var types = firstNonNull(regions.keyword(legacy.getTypesKeyword_1_2_1()),
				regions.keyword(embedded.getTypesKeyword_0_1_2_2_1()),
				regions.keyword(embedded.getTypesKeyword_1_6_2_1()));
		var typesSemicolon = firstNonNull(regions.keyword(legacy.getSemicolonKeyword_1_2_4()),
				regions.keyword(embedded.getSemicolonKeyword_0_1_2_2_4()),
				regions.keyword(embedded.getSemicolonKeyword_1_6_2_4()));
		document.interior(types, typesSemicolon, IHiddenRegionFormatter::indent);
		document.surround(types, IHiddenRegionFormatter::oneSpace);
		Iterables
				.concat(regions.keywords(legacy.getCommaKeyword_1_2_3_0()),
						regions.keywords(embedded.getCommaKeyword_0_1_2_2_3_0()),
						regions.keywords(embedded.getCommaKeyword_1_6_2_3_0()))
				.forEach(comma -> formatComma(comma, document));
		document.append(document.prepend(typesSemicolon, IHiddenRegionFormatter::noSpace),
				formatter -> formatter.setNewLines(1, 1, 2));

		var extendsKeyword = firstNonNull(regions.keyword(legacy.getExtendsKeyword_1_3_0()),
				regions.keyword(embedded.getExtendsKeyword_0_1_2_3_0()),
				regions.keyword(embedded.getExtendsKeyword_1_6_3_0()));
		var withKeyword = firstNonNull(regions.keyword(legacy.getWithKeyword_1_3_3()),
				regions.keyword(embedded.getWithKeyword_0_1_2_3_3()),
				regions.keyword(embedded.getWithKeyword_1_6_3_3()));
		document.interior(extendsKeyword, withKeyword, IHiddenRegionFormatter::indent);
		document.append(extendsKeyword, IHiddenRegionFormatter::oneSpace);
		Iterables
				.concat(regions.keywords(legacy.getCommaKeyword_1_3_2_0()),
						regions.keywords(embedded.getCommaKeyword_0_1_2_3_2_0()),
						regions.keywords(embedded.getCommaKeyword_1_6_3_2_0()))
				.forEach(comma -> formatComma(comma, document));
		document.append(document.prepend(withKeyword, IHiddenRegionFormatter::oneSpace),
				formatter -> formatter.setNewLines(1, 1, 2));

		formatLines(library.getTypes(), document);
		formatLines(library.getTypesets(), document);
		var properties = firstNonNull(regions.keyword(legacy.getPropertiesKeyword_1_5_0()),
				regions.keyword(embedded.getPropertiesKeyword_0_1_2_5_0()),
				regions.keyword(embedded.getPropertiesKeyword_1_6_5_0()));
		document.append(properties, formatter -> formatter.setNewLines(1, 1, 2));
		document.interior(properties, end, IHiddenRegionFormatter::indent);
		formatLines(library.getProperties(), document);

		var endTypes = firstNonNull(regions.keyword(legacy.getTypesKeyword_1_7()),
				regions.keyword(embedded.getTypesKeyword_0_1_2_7()), regions.keyword(embedded.getTypesKeyword_1_6_7()));
		document.append(document.prepend(endTypes, IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
		var rightCurly = regions.keyword(embedded.getAsteriskAsteriskRightCurlyBracketKeyword_1_10());
		var endTypesSemicolon = firstNonNull(regions.keyword(legacy.getSemicolonKeyword_1_8()),
				regions.keyword(embedded.getSemicolonKeyword_0_1_2_8()),
				regions.keyword(embedded.getSemicolonKeyword_1_6_8()));
		appendLibraryElementEnd(endTypesSemicolon, rightCurly, document);
		formatLibraryElements(library.getBehaviors(), rightCurly, document);
		formatLibraryElements(library.getMappings(), rightCurly, document);
		formatLibraryElements(library.getTransformations(), rightCurly, document);

		document.append(
				document.prepend(regions.keyword(embedded.getSemicolonKeyword_1_11()), IHiddenRegionFormatter::noSpace),
				formatter -> formatter.setNewLines(1, 1, 2));
		document.append(document.prepend(regions.ruleCall(embedded.getQEMREFParserRuleCall_1_13()),
				IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
		document.interior(publicKeyword, regions.keyword(embedded.getEndKeyword_1_12()),
				IHiddenRegionFormatter::indent);
		document.interior(leftCurly, rightCurly, IHiddenRegionFormatter::indent);
	}

	protected void _format(final EMV2PropertyAssociation association, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(association);
		var assign = firstNonNull(
				regions.keyword(
						grammarAccess.getEMV2PropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1()),
				regions.keyword(
						grammarAccess.getBasicEMV2PropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1()));
		document.surround(assign, IHiddenRegionFormatter::oneSpace);
		association.getOwnedValues().forEach(value -> format(value, document));
		Iterables
				.concat(regions.keywords(grammarAccess.getEMV2PropertyAssociationAccess().getCommaKeyword_2_1_0()),
						regions.keywords(grammarAccess.getBasicEMV2PropertyAssociationAccess().getCommaKeyword_2_1_0()))
				.forEach(comma -> document.append(document.prepend(comma, IHiddenRegionFormatter::noSpace),
						IHiddenRegionFormatter::oneSpace));
		var applies = firstNonNull(
				regions.keyword(grammarAccess.getEMV2PropertyAssociationAccess().getAppliesKeyword_3_0()),
				regions.keyword(grammarAccess.getBasicEMV2PropertyAssociationAccess().getAppliesKeyword_3_0()));
		document.surround(applies, IHiddenRegionFormatter::oneSpace);
		var to = firstNonNull(regions.keyword(grammarAccess.getEMV2PropertyAssociationAccess().getToKeyword_3_1()),
				regions.keyword(grammarAccess.getBasicEMV2PropertyAssociationAccess().getToKeyword_3_1()));
		document.append(to, IHiddenRegionFormatter::oneSpace);
		association.getEmv2Path().forEach(path -> format(path, document));
		Iterables
				.concat(regions.keywords(grammarAccess.getEMV2PropertyAssociationAccess().getCommaKeyword_3_2_1_0()),
						regions.keywords(
								grammarAccess.getBasicEMV2PropertyAssociationAccess().getCommaKeyword_3_2_1_0()))
				.forEach(comma -> document.append(document.prepend(comma, IHiddenRegionFormatter::noSpace),
						IHiddenRegionFormatter::oneSpace));
		document.prepend(
				firstNonNull(regions.keyword(grammarAccess.getEMV2PropertyAssociationAccess().getSemicolonKeyword_4()),
						regions.keyword(grammarAccess.getBasicEMV2PropertyAssociationAccess().getSemicolonKeyword_4())),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final EMV2Path path, @Extension final IFormattableDocument document) {
		document.surround(path.getContainmentPath(), IHiddenRegionFormatter::noSpace);
		format(path.getContainmentPath(), document);
		document.append(
				textRegionExtensions.regionFor(path)
						.keyword(grammarAccess.getEMV2PathAccess().getCommercialAtKeyword_0_2()),
				IHiddenRegionFormatter::noSpace);
		format(path.getEmv2Target(), document);
	}

	protected void _format(final EMV2PathElement element, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(element);
		document.surround(regions.keyword(grammarAccess.getEMV2PathElementOrKindAccess().getFullStopKeyword_0_1_0()),
				IHiddenRegionFormatter::noSpace);
		var dot = firstNonNull(
				regions.keyword(grammarAccess.getEMV2PathElementOrKindAccess().getFullStopKeyword_1_1_0()),
				regions.keyword(grammarAccess.getEMV2PathElementAccess().getFullStopKeyword_1_0()),
				regions.keyword(grammarAccess.getEMV2ErrorPropagationPathAccess().getFullStopKeyword_1_1_0()));
		document.surround(dot, IHiddenRegionFormatter::noSpace);
		format(element.getPath(), document);
	}

	protected void _format(final ErrorType type, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(type);
		document.append(
				document.prepend(regions.keyword(grammarAccess.getTypeDefinitionAccess().getColonKeyword_1_0_0()),
						IHiddenRegionFormatter::noSpace),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				document.prepend(regions.keyword(grammarAccess.getTypeDefinitionAccess().getColonKeyword_1_1_0()),
						IHiddenRegionFormatter::noSpace),
				IHiddenRegionFormatter::oneSpace);
		document.surround(regions.keyword(grammarAccess.getTypeDefinitionAccess().getExtendsKeyword_1_1_2()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(regions.keyword(grammarAccess.getTypeDefinitionAccess().getRenamesKeyword_1_2_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(regions.keyword(grammarAccess.getTypeDefinitionAccess().getTypeKeyword_1_2_1()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(regions.keyword(grammarAccess.getTypeDefinitionAccess().getSemicolonKeyword_2()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final TypeSet typeSet, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(typeSet);
		document.append(
				document.prepend(regions.keyword(grammarAccess.getTypeSetDefinitionAccess().getColonKeyword_1_0_0()),
						IHiddenRegionFormatter::noSpace),
				IHiddenRegionFormatter::oneSpace);
		document.surround(regions.keyword(grammarAccess.getTypeSetDefinitionAccess().getRenamesKeyword_1_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(
				firstNonNull(regions.keyword(grammarAccess.getTypeSetDefinitionAccess().getSetKeyword_1_0_2()),
						regions.keyword(grammarAccess.getTypeSetDefinitionAccess().getSetKeyword_1_1_2())),
				IHiddenRegionFormatter::oneSpace);
		var left = firstNonNull(
				regions.keyword(grammarAccess.getTypeSetDefinitionAccess().getLeftCurlyBracketKeyword_1_0_3()),
				regions.keyword(grammarAccess.getTypeSetConstructorAccess().getLeftCurlyBracketKeyword_0()),
				regions.keyword(grammarAccess.getNoErrorTypeSetAccess().getLeftCurlyBracketKeyword_1()));
		var right = firstNonNull(
				regions.keyword(grammarAccess.getTypeSetDefinitionAccess().getRightCurlyBracketKeyword_1_0_6()),
				regions.keyword(grammarAccess.getTypeSetConstructorAccess().getRightCurlyBracketKeyword_3()),
				regions.keyword(grammarAccess.getNoErrorTypeSetAccess().getRightCurlyBracketKeyword_3()));
		document.interior(left, right, IHiddenRegionFormatter::indent);
		document.append(left, IHiddenRegionFormatter::noSpace);
		Iterables
				.concat(regions.keywords(grammarAccess.getTypeSetDefinitionAccess().getCommaKeyword_1_0_5_0()),
						regions.keywords(grammarAccess.getTypeSetConstructorAccess().getCommaKeyword_2_0()))
				.forEach(comma -> document.append(document.prepend(comma, IHiddenRegionFormatter::noSpace),
						formatter -> {
							formatter.oneSpace();
							formatter.autowrap();
						}));
		typeSet.getTypeTokens().forEach(token -> format(token, document));
		document.prepend(right, IHiddenRegionFormatter::noSpace);
		document.prepend(regions.keyword(grammarAccess.getTypeSetDefinitionAccess().getSemicolonKeyword_2()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final TypeToken token, @Extension final IFormattableDocument document) {
		textRegionExtensions.regionFor(token).keywords(grammarAccess.getTypeSetElementAccess().getAsteriskKeyword_1_0())
				.forEach(asterisk -> document.append(document.surround(asterisk, IHiddenRegionFormatter::oneSpace),
						IHiddenRegionFormatter::autowrap));
	}

	protected void _format(final TypeTransformationSet set, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(set);
		document.surround(regions.keyword(grammarAccess.getTypeTransformationSetAccess().getTransformationsKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		var name = regions.assignment(grammarAccess.getTypeTransformationSetAccess().getNameAssignment_2());
		document.append(name, formatter -> formatter.setNewLines(1, 1, 2));
		document.interior(name, regions.keyword(grammarAccess.getTypeTransformationSetAccess().getEndKeyword_5()),
				IHiddenRegionFormatter::indent);
		formatUseTypes(regions.keyword(grammarAccess.getTypeTransformationSetAccess().getTypesKeyword_3_1()),
				regions.keyword(grammarAccess.getTypeTransformationSetAccess().getSemicolonKeyword_3_4()),
				regions.keywords(grammarAccess.getTypeTransformationSetAccess().getCommaKeyword_3_3_0()), document);
		set.getTransformation().forEach(value -> {
			document.append(value, formatter -> formatter.setNewLines(1, 1, 2));
			format(value, document);
		});
		document.append(document.prepend(
				regions.keyword(grammarAccess.getTypeTransformationSetAccess().getTransformationsKeyword_6()),
				IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final TypeTransformation transformation, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(transformation);
		format(transformation.getSource(), document);
		document.append(document.prepend(
				regions.keyword(grammarAccess.getTypeTransformationAccess().getHyphenMinusLeftSquareBracketKeyword_1()),
				IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
		format(transformation.getContributor(), document);
		document.append(
				document.prepend(
						regions.keyword(grammarAccess.getTypeTransformationAccess()
								.getRightSquareBracketHyphenMinusGreaterThanSignKeyword_3()),
						IHiddenRegionFormatter::noSpace),
				IHiddenRegionFormatter::oneSpace);
		format(transformation.getTarget(), document);
		document.prepend(regions.keyword(grammarAccess.getTypeTransformationAccess().getSemicolonKeyword_5()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final TypeMappingSet set, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(set);
		document.surround(regions.keyword(grammarAccess.getTypeMappingSetAccess().getMappingsKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		var name = regions.assignment(grammarAccess.getTypeMappingSetAccess().getNameAssignment_2());
		document.append(name, formatter -> formatter.setNewLines(1, 1, 2));
		document.interior(name, regions.keyword(grammarAccess.getTypeMappingSetAccess().getEndKeyword_5()),
				IHiddenRegionFormatter::indent);
		formatUseTypes(regions.keyword(grammarAccess.getTypeMappingSetAccess().getTypesKeyword_3_1()),
				regions.keyword(grammarAccess.getTypeMappingSetAccess().getSemicolonKeyword_3_4()),
				regions.keywords(grammarAccess.getTypeMappingSetAccess().getCommaKeyword_3_3_0()), document);
		set.getMapping().forEach(value -> {
			document.append(value, formatter -> formatter.setNewLines(1, 1, 2));
			format(value, document);
		});
		document.append(
				document.prepend(regions.keyword(grammarAccess.getTypeMappingSetAccess().getMappingsKeyword_6()),
						IHiddenRegionFormatter::oneSpace),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final TypeMapping mapping, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(mapping);
		format(mapping.getSource(), document);
		document.surround(
				regions.keyword(grammarAccess.getTypeMappingAccess().getHyphenMinusGreaterThanSignKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		format(mapping.getTarget(), document);
		document.prepend(regions.keyword(grammarAccess.getTypeMappingAccess().getSemicolonKeyword_3()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final ErrorPropagation propagation, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(propagation);
		format(propagation.getFeatureorPPRef(), document);
		document.append(document.prepend(regions.keyword(grammarAccess.getErrorPropagationAccess().getColonKeyword_2()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.append(regions.keyword(grammarAccess.getErrorPropagationAccess().getNotNotKeyword_3_0()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(regions.keyword(grammarAccess.getErrorPropagationAccess().getPropagationKeyword_5()),
				IHiddenRegionFormatter::oneSpace);
		format(propagation.getTypeSet(), document);
		document.append(propagation.getTypeSet(), IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final FeatureorPPReference reference, @Extension final IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(reference)
						.keyword(grammarAccess.getFeatureorPPReferenceAccess().getFullStopKeyword_1_0()),
				IHiddenRegionFormatter::noSpace);
		format(reference.getNext(), document);
	}

	protected void _format(final ErrorSource source, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(source);
		document.append(document.prepend(regions.keyword(grammarAccess.getErrorSourceAccess().getColonKeyword_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(regions.keyword(grammarAccess.getErrorSourceAccess().getSourceKeyword_3()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(source.getTypeTokenConstraint(), IHiddenRegionFormatter::oneSpace);
		format(source.getTypeTokenConstraint(), document);
		document.surround(regions.keyword(grammarAccess.getErrorSourceAccess().getWhenKeyword_6_0()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(source.getFailureModeType(), IHiddenRegionFormatter::oneSpace);
		format(source.getFailureModeType(), document);
		document.surround(regions.keyword(grammarAccess.getErrorSourceAccess().getIfKeyword_7_0()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(regions.keyword(grammarAccess.getErrorSourceAccess().getSemicolonKeyword_8()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final ErrorSink sink, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(sink);
		document.append(document.prepend(regions.keyword(grammarAccess.getErrorSinkAccess().getColonKeyword_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(regions.keyword(grammarAccess.getErrorSinkAccess().getSinkKeyword_3()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(sink.getTypeTokenConstraint(), IHiddenRegionFormatter::oneSpace);
		format(sink.getTypeTokenConstraint(), document);
		document.surround(regions.keyword(grammarAccess.getErrorSinkAccess().getIfKeyword_6_0()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(regions.keyword(grammarAccess.getErrorSinkAccess().getSemicolonKeyword_7()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final ErrorPath path, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(path);
		document.append(document.prepend(regions.keyword(grammarAccess.getErrorPathAccess().getColonKeyword_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(regions.keyword(grammarAccess.getErrorPathAccess().getPathKeyword_3()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(path.getTypeTokenConstraint(), IHiddenRegionFormatter::oneSpace);
		format(path.getTypeTokenConstraint(), document);
		document.surround(regions.keyword(grammarAccess.getErrorPathAccess().getHyphenMinusGreaterThanSignKeyword_6()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(path.getTargetToken(), IHiddenRegionFormatter::oneSpace);
		format(path.getTargetToken(), document);
		document.surround(regions.keyword(grammarAccess.getErrorPathAccess().getUseKeyword_8_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(regions.keyword(grammarAccess.getErrorPathAccess().getMappingsKeyword_8_1_1()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(regions.keyword(grammarAccess.getErrorPathAccess().getIfKeyword_9_0()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(regions.keyword(grammarAccess.getErrorPathAccess().getSemicolonKeyword_10()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final PropagationPoint value, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(value);
		document.append(document.prepend(regions.keyword(grammarAccess.getPropagationPointAccess().getColonKeyword_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.append(document.prepend(regions.keyword(grammarAccess.getPropagationPointAccess().getPointKeyword_3()),
				IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final PropagationPath value, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(value);
		document.append(
				document.prepend(regions.keyword(grammarAccess.getPropagationPathAccess().getColonKeyword_0_1()),
						IHiddenRegionFormatter::noSpace),
				IHiddenRegionFormatter::oneSpace);
		format(value.getSource(), document);
		document.surround(
				regions.keyword(grammarAccess.getPropagationPathAccess().getHyphenMinusGreaterThanSignKeyword_2()),
				IHiddenRegionFormatter::oneSpace);
		format(value.getTarget(), document);
		document.append(value.getTarget(), IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final QualifiedPropagationPoint value, @Extension final IFormattableDocument document) {
		format(value.getSubcomponent(), document);
		document.surround(
				textRegionExtensions.regionFor(value)
						.keyword(grammarAccess.getQualifiedPropagationPointAccess().getFullStopKeyword_0_1()),
				IHiddenRegionFormatter::noSpace);
		format(value.getNext(), document);
	}

	protected void _format(final ErrorBehaviorStateMachine machine, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(machine);
		var access = grammarAccess.getErrorBehaviorStateMachineAccess();
		document.surround(regions.keyword(access.getBehaviorKeyword_1()), IHiddenRegionFormatter::oneSpace);
		var name = regions.assignment(access.getNameAssignment_2());
		document.append(name, formatter -> formatter.setNewLines(1, 1, 2));
		var end = regions.keyword(access.getEndKeyword_9());
		document.interior(name, end, IHiddenRegionFormatter::indent);
		formatUseTypes(regions.keyword(access.getTypesKeyword_3_1()), regions.keyword(access.getSemicolonKeyword_3_4()),
				regions.keywords(access.getCommaKeyword_3_3_0()), document);
		document.surround(regions.keyword(access.getTransformationsKeyword_4_1()), IHiddenRegionFormatter::oneSpace);
		document.append(
				document.prepend(regions.keyword(access.getSemicolonKeyword_4_3()), IHiddenRegionFormatter::noSpace),
				formatter -> formatter.setNewLines(1, 1, 2));
		var events = regions.keyword(access.getEventsKeyword_5_0());
		var states = regions.keyword(access.getStatesKeyword_6_0());
		var transitions = regions.keyword(access.getTransitionsKeyword_7_0());
		var properties = regions.keyword(access.getPropertiesKeyword_8_0());
		formatSection(events, firstNonNull(states, transitions, properties, end), machine.getEvents(), document);
		formatSection(states, firstNonNull(transitions, properties, end), machine.getStates(), document);
		formatSection(transitions, firstNonNull(properties, end), machine.getTransitions(), document);
		formatSection(properties, end, machine.getProperties(), document);
		document.append(
				document.prepend(regions.keyword(access.getBehaviorKeyword_10()), IHiddenRegionFormatter::oneSpace),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final ErrorEvent value, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(value);
		spaceAfterNoSpaceBefore(regions.keyword(grammarAccess.getErrorEventAccess().getColonKeyword_1()), document);
		document.prepend(regions.keyword(grammarAccess.getErrorEventAccess().getEventKeyword_3()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(value.getTypeSet(), IHiddenRegionFormatter::oneSpace);
		format(value.getTypeSet(), document);
		document.surround(regions.keyword(grammarAccess.getErrorEventAccess().getIfKeyword_5_0()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(regions.keyword(grammarAccess.getErrorEventAccess().getSemicolonKeyword_6()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final RepairEvent value, @Extension final IFormattableDocument document) {
		formatRecoveryEvent(value,
				textRegionExtensions.regionFor(value).keyword(grammarAccess.getRepairEventAccess().getColonKeyword_1()),
				textRegionExtensions.regionFor(value).keyword(grammarAccess.getRepairEventAccess().getEventKeyword_3()),
				textRegionExtensions.regionFor(value)
						.keyword(grammarAccess.getRepairEventAccess().getWhenKeyword_4_0()),
				textRegionExtensions.regionFor(value)
						.keyword(grammarAccess.getRepairEventAccess().getSemicolonKeyword_5()),
				textRegionExtensions.regionFor(value)
						.keywords(grammarAccess.getRepairEventAccess().getCommaKeyword_4_2_0()),
				document);
	}

	protected void _format(final RecoverEvent value, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(value);
		formatRecoveryEvent(value, regions.keyword(grammarAccess.getRecoverEventAccess().getColonKeyword_1()),
				regions.keyword(grammarAccess.getRecoverEventAccess().getEventKeyword_3()),
				regions.keyword(grammarAccess.getRecoverEventAccess().getWhenKeyword_4_0()),
				regions.keyword(grammarAccess.getRecoverEventAccess().getSemicolonKeyword_6()),
				regions.keywords(grammarAccess.getRecoverEventAccess().getCommaKeyword_4_2_0()), document);
		document.surround(regions.keyword(grammarAccess.getRecoverEventAccess().getIfKeyword_5_0()),
				IHiddenRegionFormatter::oneSpace);
	}

	protected void _format(final ErrorBehaviorState value, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(value);
		spaceAfterNoSpaceBefore(regions.keyword(grammarAccess.getErrorBehaviorStateAccess().getColonKeyword_1()),
				document);
		document.append(regions.keyword(grammarAccess.getErrorBehaviorStateAccess().getIntialInitialKeyword_2_0()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(value.getTypeSet(), IHiddenRegionFormatter::oneSpace);
		format(value.getTypeSet(), document);
		document.prepend(regions.keyword(grammarAccess.getErrorBehaviorStateAccess().getSemicolonKeyword_5()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final ErrorBehaviorTransition value, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(value);
		spaceAfterNoSpaceBefore(regions.keyword(grammarAccess.getErrorBehaviorTransitionAccess().getColonKeyword_0_1()),
				document);
		document.prepend(value.getTypeTokenConstraint(), IHiddenRegionFormatter::oneSpace);
		format(value.getTypeTokenConstraint(), document);
		var leftSquare = regions
				.keyword(grammarAccess.getErrorBehaviorTransitionAccess().getHyphenMinusLeftSquareBracketKeyword_2());
		var rightSquare = regions.keyword(grammarAccess.getErrorBehaviorTransitionAccess()
				.getRightSquareBracketHyphenMinusGreaterThanSignKeyword_4());
		document.interior(leftSquare, rightSquare, IHiddenRegionFormatter::indent);
		document.append(document.prepend(leftSquare, IHiddenRegionFormatter::oneSpace),
				IHiddenRegionFormatter::noSpace);
		format(value.getCondition(), document);
		document.append(document.prepend(rightSquare, IHiddenRegionFormatter::noSpace),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(value.getTargetToken(), IHiddenRegionFormatter::oneSpace);
		format(value.getTargetToken(), document);
		document.append(
				regions.keyword(grammarAccess.getErrorBehaviorTransitionAccess().getSteadyStateSameKeyword_5_1_0_0()),
				IHiddenRegionFormatter::oneSpace);
		var leftParen = regions
				.keyword(grammarAccess.getErrorBehaviorTransitionAccess().getLeftParenthesisKeyword_5_2_0());
		var rightParen = regions
				.keyword(grammarAccess.getErrorBehaviorTransitionAccess().getRightParenthesisKeyword_5_2_3());
		document.interior(leftParen, rightParen, IHiddenRegionFormatter::indent);
		document.append(leftParen, IHiddenRegionFormatter::noSpace);
		regions.keywords(grammarAccess.getErrorBehaviorTransitionAccess().getCommaKeyword_5_2_2_0()).forEach(
				comma -> document.append(document.prepend(comma, IHiddenRegionFormatter::noSpace), formatter -> {
					formatter.oneSpace();
					formatter.autowrap();
				}));
		value.getDestinationBranches().forEach(branch -> format(branch, document));
		document.prepend(rightParen, IHiddenRegionFormatter::noSpace);
		document.prepend(regions.keyword(grammarAccess.getErrorBehaviorTransitionAccess().getSemicolonKeyword_6()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final TransitionBranch value, @Extension final IFormattableDocument document) {
		document.prepend(value.getTargetToken(), IHiddenRegionFormatter::oneSpace);
		format(value.getTargetToken(), document);
		var regions = textRegionExtensions.regionFor(value);
		document.append(regions.keyword(grammarAccess.getTransitionBranchAccess().getSteadyStateSameKeyword_0_1_0_0()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(regions.keyword(grammarAccess.getTransitionBranchAccess().getWithKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		format(value.getValue(), document);
	}

	protected void _format(final OrExpression value, @Extension final IFormattableDocument document) {
		formatExpressionParentheses(value, document);
		value.getOperands().forEach(operand -> format(operand, document));
		var keyword = firstNonNull(
				textRegionExtensions.regionFor(value)
						.keyword(grammarAccess.getConditionExpressionAccess().getOrKeyword_1_1()),
				textRegionExtensions.regionFor(value)
						.keyword(grammarAccess.getSConditionExpressionAccess().getOrKeyword_1_1()));
		document.append(document.surround(keyword, IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::autowrap);
	}

	protected void _format(final AndExpression value, @Extension final IFormattableDocument document) {
		formatExpressionParentheses(value, document);
		value.getOperands().forEach(operand -> format(operand, document));
		var keyword = firstNonNull(
				textRegionExtensions.regionFor(value)
						.keyword(grammarAccess.getAndExpressionAccess().getAndKeyword_1_1()),
				textRegionExtensions.regionFor(value)
						.keyword(grammarAccess.getSAndExpressionAccess().getAndKeyword_1_1()));
		document.append(document.surround(keyword, IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::autowrap);
	}

	protected void _format(final AllExpression value, @Extension final IFormattableDocument document) {
		formatExpressionParentheses(value, document);
		var regions = textRegionExtensions.regionFor(value);
		document.surround(
				firstNonNull(regions.keyword(grammarAccess.getAllExpressionAccess().getHyphenMinusKeyword_2_0()),
						regions.keyword(grammarAccess.getSAllExpressionAccess().getHyphenMinusKeyword_2_0())),
				IHiddenRegionFormatter::oneSpace);
		var left = firstNonNull(regions.keyword(grammarAccess.getAllExpressionAccess().getLeftParenthesisKeyword_3()),
				regions.keyword(grammarAccess.getSAllExpressionAccess().getLeftParenthesisKeyword_3()));
		document.append(document.prepend(left, IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
		value.getOperands().forEach(operand -> format(operand, document));
		Iterables
				.concat(regions.keywords(grammarAccess.getAllExpressionAccess().getCommaKeyword_5_0()),
						regions.keywords(grammarAccess.getSAllExpressionAccess().getCommaKeyword_5_0()))
				.forEach(comma -> document.append(document.prepend(comma, IHiddenRegionFormatter::noSpace),
						formatter -> {
							formatter.oneSpace();
							formatter.autowrap();
						}));
		document.prepend(
				firstNonNull(regions.keyword(grammarAccess.getAllExpressionAccess().getRightParenthesisKeyword_6()),
						regions.keyword(grammarAccess.getSAllExpressionAccess().getRightParenthesisKeyword_6())),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final OrmoreExpression value, @Extension final IFormattableDocument document) {
		formatExpressionParentheses(value, document);
		var regions = textRegionExtensions.regionFor(value);
		document.surround(
				firstNonNull(regions.keyword(grammarAccess.getOrmoreExpressionAccess().getOrmoreKeyword_1()),
						regions.keyword(grammarAccess.getSOrmoreExpressionAccess().getOrmoreKeyword_1())),
				IHiddenRegionFormatter::oneSpace);
		var left = firstNonNull(
				regions.keyword(grammarAccess.getOrmoreExpressionAccess().getLeftParenthesisKeyword_2()),
				regions.keyword(grammarAccess.getSOrmoreExpressionAccess().getLeftParenthesisKeyword_2()));
		document.append(left, IHiddenRegionFormatter::noSpace);
		value.getOperands().forEach(operand -> format(operand, document));
		Iterables
				.concat(regions.keywords(grammarAccess.getOrmoreExpressionAccess().getCommaKeyword_4_0()),
						regions.keywords(grammarAccess.getSOrmoreExpressionAccess().getCommaKeyword_4_0()))
				.forEach(comma -> document.append(document.prepend(comma, IHiddenRegionFormatter::noSpace),
						formatter -> {
							formatter.oneSpace();
							formatter.autowrap();
						}));
		document.prepend(
				firstNonNull(regions.keyword(grammarAccess.getOrmoreExpressionAccess().getRightParenthesisKeyword_5()),
						regions.keyword(grammarAccess.getSOrmoreExpressionAccess().getRightParenthesisKeyword_5())),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final OrlessExpression value, @Extension final IFormattableDocument document) {
		formatExpressionParentheses(value, document);
		var regions = textRegionExtensions.regionFor(value);
		document.surround(
				firstNonNull(regions.keyword(grammarAccess.getOrlessExpressionAccess().getOrlessKeyword_1()),
						regions.keyword(grammarAccess.getSOrlessExpressionAccess().getOrlessKeyword_1())),
				IHiddenRegionFormatter::oneSpace);
		var left = firstNonNull(
				regions.keyword(grammarAccess.getOrlessExpressionAccess().getLeftParenthesisKeyword_2()),
				regions.keyword(grammarAccess.getSOrlessExpressionAccess().getLeftParenthesisKeyword_2()));
		document.append(left, IHiddenRegionFormatter::noSpace);
		value.getOperands().forEach(operand -> format(operand, document));
		Iterables
				.concat(regions.keywords(grammarAccess.getOrlessExpressionAccess().getCommaKeyword_4_0()),
						regions.keywords(grammarAccess.getSOrlessExpressionAccess().getCommaKeyword_4_0()))
				.forEach(comma -> document.append(document.prepend(comma, IHiddenRegionFormatter::noSpace),
						formatter -> {
							formatter.oneSpace();
							formatter.autowrap();
						}));
		document.prepend(
				firstNonNull(regions.keyword(grammarAccess.getOrlessExpressionAccess().getRightParenthesisKeyword_5()),
						regions.keyword(grammarAccess.getSOrlessExpressionAccess().getRightParenthesisKeyword_5())),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final ConditionElement value, @Extension final IFormattableDocument document) {
		formatExpressionParentheses(value, document);
		format(value.getQualifiedErrorPropagationReference(), document);
		document.prepend(value.getConstraint(), IHiddenRegionFormatter::oneSpace);
		format(value.getConstraint(), document);
	}

	protected void _format(final OutgoingPropagationCondition value, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(value);
		spaceAfterNoSpaceBefore(
				regions.keyword(grammarAccess.getOutgoingPropagationConditionAccess().getColonKeyword_0_1()), document);
		document.prepend(value.getTypeTokenConstraint(), IHiddenRegionFormatter::oneSpace);
		format(value.getTypeTokenConstraint(), document);
		var left = regions.keyword(
				grammarAccess.getOutgoingPropagationConditionAccess().getHyphenMinusLeftSquareBracketKeyword_2());
		var right = regions.keyword(grammarAccess.getOutgoingPropagationConditionAccess()
				.getRightSquareBracketHyphenMinusGreaterThanSignKeyword_4());
		document.interior(left, right, IHiddenRegionFormatter::indent);
		document.append(document.prepend(left, IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
		format(value.getCondition(), document);
		document.append(document.prepend(right, IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.prepend(value.getTypeToken(), IHiddenRegionFormatter::oneSpace);
		format(value.getTypeToken(), document);
		document.prepend(regions.keyword(grammarAccess.getOutgoingPropagationConditionAccess().getSemicolonKeyword_6()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final ErrorDetection value, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(value);
		spaceAfterNoSpaceBefore(regions.keyword(grammarAccess.getErrorDetectionAccess().getColonKeyword_0_1()),
				document);
		document.prepend(value.getTypeTokenConstraint(), IHiddenRegionFormatter::oneSpace);
		format(value.getTypeTokenConstraint(), document);
		var left = regions.keyword(grammarAccess.getErrorDetectionAccess().getHyphenMinusLeftSquareBracketKeyword_2());
		var right = regions.keyword(
				grammarAccess.getErrorDetectionAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_4());
		document.interior(left, right, IHiddenRegionFormatter::indent);
		document.append(document.prepend(left, IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
		format(value.getCondition(), document);
		document.append(document.prepend(right, IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.prepend(regions.keyword(grammarAccess.getErrorDetectionAccess().getExclamationMarkKeyword_6()),
				IHiddenRegionFormatter::oneSpace);
		document.append(document.prepend(
				regions.keyword(grammarAccess.getErrorDetectionAccess().getLeftParenthesisKeyword_7_0()),
				IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
		format(value.getErrorCode(), document);
		document.prepend(regions.keyword(grammarAccess.getErrorDetectionAccess().getRightParenthesisKeyword_7_2()),
				IHiddenRegionFormatter::noSpace);
		document.prepend(regions.keyword(grammarAccess.getErrorDetectionAccess().getSemicolonKeyword_8()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final ErrorStateToModeMapping value, @Extension final IFormattableDocument document) {
		document.prepend(value.getTypeToken(), IHiddenRegionFormatter::oneSpace);
		format(value.getTypeToken(), document);
		var regions = textRegionExtensions.regionFor(value);
		document.surround(regions.keyword(grammarAccess.getErrorStateToModeMappingAccess().getInKeyword_2()),
				IHiddenRegionFormatter::oneSpace);
		var left = regions.keyword(grammarAccess.getErrorStateToModeMappingAccess().getLeftParenthesisKeyword_4());
		var right = regions.keyword(grammarAccess.getErrorStateToModeMappingAccess().getRightParenthesisKeyword_7());
		document.interior(left, right, IHiddenRegionFormatter::indent);
		document.append(document.prepend(left, IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
		regions.keywords(grammarAccess.getErrorStateToModeMappingAccess().getCommaKeyword_6_0()).forEach(
				comma -> document.append(document.prepend(comma, IHiddenRegionFormatter::noSpace), formatter -> {
					formatter.oneSpace();
					formatter.autowrap();
				}));
		document.surround(right, IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final CompositeState value, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(value);
		spaceAfterNoSpaceBefore(regions.keyword(grammarAccess.getCompositeStateAccess().getColonKeyword_0_1()),
				document);
		var left = regions.keyword(grammarAccess.getCompositeStateAccess().getLeftSquareBracketKeyword_1());
		var right = regions.keyword(
				grammarAccess.getCompositeStateAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_3());
		document.interior(left, right, IHiddenRegionFormatter::indent);
		document.append(left, IHiddenRegionFormatter::noSpace);
		format(value.getCondition(), document);
		document.append(document.prepend(right, IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.prepend(value.getTypedToken(), IHiddenRegionFormatter::oneSpace);
		format(value.getTypedToken(), document);
		document.prepend(regions.keyword(grammarAccess.getCompositeStateAccess().getSemicolonKeyword_6()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(final SConditionElement value, @Extension final IFormattableDocument document) {
		formatExpressionParentheses(value, document);
		format(value.getQualifiedState(), document);
		document.prepend(value.getConstraint(), IHiddenRegionFormatter::oneSpace);
		format(value.getConstraint(), document);
		document.append(
				textRegionExtensions.regionFor(value)
						.keyword(grammarAccess.getSConditionElementAccess().getInKeyword_1_1_0()),
				IHiddenRegionFormatter::oneSpace);
		format(value.getQualifiedErrorPropagationReference(), document);
	}

	protected void _format(final QualifiedErrorBehaviorState value, @Extension final IFormattableDocument document) {
		format(value.getSubcomponent(), document);
		document.surround(
				textRegionExtensions.regionFor(value)
						.keyword(grammarAccess.getQualifiedErrorBehaviorStateAccess().getFullStopKeyword_1()),
				IHiddenRegionFormatter::noSpace);
		format(value.getNext(), document);
	}

	/**
	 * Appends if there is another semantic region after {@code appendAfter}.
	 */
	private static ISemanticRegion conditionalAppend(final ISemanticRegion appendAfter,
			@Extension final IFormattableDocument document,
			final Consumer<? super IHiddenRegionFormatter> initializer) {
		if (appendAfter != null && appendAfter.getNextSemanticRegion() != null) {
			document.append(appendAfter, initializer::accept);
		}
		return appendAfter;
	}

	/**
	 * Appends if there is another semantic region after {@code appendAfter}.
	 */
	private <T extends EObject> T conditionalAppend(final T appendAfter, @Extension final IFormattableDocument document,
			final Consumer<? super IHiddenRegionFormatter> initializer) {
		var region = appendAfter == null ? null : textRegionExtensions.regionForEObject(appendAfter);
		if (region != null && region.getNextSemanticRegion() != null) {
			document.append(appendAfter, initializer::accept);
		}
		return appendAfter;
	}

	private void formatExpressionParentheses(final EObject object, @Extension final IFormattableDocument document) {
		var regions = textRegionExtensions.regionFor(object);
		var leftParen = firstNonNull(
				regions.keyword(grammarAccess.getConditionTermAccess().getLeftParenthesisKeyword_4_0()),
				regions.keyword(grammarAccess.getSConditionTermAccess().getLeftParenthesisKeyword_4_0()));
		document.append(leftParen, IHiddenRegionFormatter::noSpace);
		var rightParen = firstNonNull(
				regions.keyword(grammarAccess.getConditionTermAccess().getRightParenthesisKeyword_4_2()),
				regions.keyword(grammarAccess.getSConditionTermAccess().getRightParenthesisKeyword_4_2()));
		document.prepend(rightParen, IHiddenRegionFormatter::noSpace);
	}

	private static void formatUseTypes(final ISemanticRegion typesKeyword, final ISemanticRegion semicolon,
			final Iterable<ISemanticRegion> commas, final IFormattableDocument document) {
		document.interior(typesKeyword, semicolon, IHiddenRegionFormatter::indent);
		document.surround(typesKeyword, IHiddenRegionFormatter::oneSpace);
		commas.forEach(comma -> document.append(document.prepend(comma, IHiddenRegionFormatter::noSpace), formatter -> {
			formatter.oneSpace();
			formatter.autowrap();
		}));
		document.append(document.prepend(semicolon, IHiddenRegionFormatter::noSpace),
				formatter -> formatter.setNewLines(1, 1, 2));
	}

	private static void formatComma(final ISemanticRegion comma, final IFormattableDocument document) {
		document.append(document.prepend(comma, IHiddenRegionFormatter::noSpace), formatter -> {
			formatter.oneSpace();
			formatter.autowrap();
		});
	}

	private static void appendUseClauseTerminator(final ISemanticRegion semicolon,
			final IFormattableDocument document) {
		if (semicolon == null || semicolon.getNextSemanticRegion() == null) {
			return;
		}
		var next = semicolon.getNextSemanticRegion().getText().toLowerCase();
		document.append(semicolon,
				formatter -> formatter.setNewLines(next.equals("end") || next.equals("use") ? 1 : 2));
	}

	private static void appendSectionTerminator(final ISemanticRegion semicolon, final ISemanticRegion sectionEnd,
			final IFormattableDocument document) {
		if (semicolon == null || semicolon.getNextSemanticRegion() == null) {
			return;
		}
		if (semicolon.getNextSemanticRegion() == sectionEnd) {
			document.append(semicolon, formatter -> formatter.setNewLines(1, 1, 2));
		} else {
			document.append(semicolon, formatter -> formatter.setNewLines(2));
		}
	}

	private static void spaceAfterNoSpaceBefore(final ISemanticRegion region, final IFormattableDocument document) {
		document.append(document.prepend(region, IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
	}

	private static void formatRecoveryEvent(final EObject event, final ISemanticRegion colon,
			final ISemanticRegion eventKeyword, final ISemanticRegion whenKeyword, final ISemanticRegion semicolon,
			final Iterable<ISemanticRegion> commas, final IFormattableDocument document) {
		spaceAfterNoSpaceBefore(colon, document);
		document.prepend(eventKeyword, IHiddenRegionFormatter::oneSpace);
		document.interior(whenKeyword, semicolon, IHiddenRegionFormatter::indent);
		document.surround(whenKeyword, IHiddenRegionFormatter::oneSpace);
		commas.forEach(comma -> document.append(document.prepend(comma, IHiddenRegionFormatter::noSpace), formatter -> {
			formatter.oneSpace();
			formatter.autowrap();
		}));
		document.prepend(semicolon, IHiddenRegionFormatter::noSpace);
	}

	private void formatLines(final Iterable<? extends EObject> elements, final IFormattableDocument document) {
		elements.forEach(element -> {
			document.append(element, formatter -> formatter.setNewLines(1, 1, 2));
			format(element, document);
		});
	}

	private void formatSection(final ISemanticRegion keyword, final ISemanticRegion end,
			final Iterable<? extends EObject> elements, final IFormattableDocument document) {
		if (keyword != null) {
			document.append(keyword, formatter -> formatter.setNewLines(1, 1, 2));
			document.interior(keyword, end, IHiddenRegionFormatter::indent);
		}
		formatLines(elements, document);
	}

	private static void appendLibraryElementEnd(final ISemanticRegion region, final ISemanticRegion rightCurly,
			final IFormattableDocument document) {
		if (region == null) {
			return;
		}
		if (region.getNextSemanticRegion() == rightCurly && rightCurly != null) {
			document.append(region, formatter -> formatter.setNewLines(1, 1, 2));
		} else {
			conditionalAppend(region, document, formatter -> formatter.setNewLines(2));
		}
	}

	private void formatLibraryElements(final Iterable<? extends EObject> elements, final ISemanticRegion rightCurly,
			final IFormattableDocument document) {
		elements.forEach(element -> {
			var region = textRegionExtensions.regionForEObject(element);
			if (region != null && region.getNextSemanticRegion() == rightCurly && rightCurly != null) {
				document.append(element, formatter -> formatter.setNewLines(1, 1, 2));
			} else {
				conditionalAppend(element, document, formatter -> formatter.setNewLines(2));
			}
			format(element, document);
		});
	}

	@SafeVarargs
	private static <T> T firstNonNull(final T... values) {
		for (var value : values) {
			if (value != null) {
				return value;
			}
		}
		return null;
	}

	// Xtext excludes this dispatcher from reflective format-method discovery.
	@XbaseGenerated
	public void format(final Object object, final IFormattableDocument document) {
		switch (object) {
		case IntegerLiteral integerLiteral -> _format(integerLiteral, document);
		case RealLiteral realLiteral -> _format(realLiteral, document);
		case ErrorEvent errorEvent -> _format(errorEvent, document);
		case ErrorModelSubclause errorModelSubclause -> _format(errorModelSubclause, document);
		case RecoverEvent recoverEvent -> _format(recoverEvent, document);
		case RepairEvent repairEvent -> _format(repairEvent, document);
		case ClassifierValue classifierValue -> _format(classifierValue, document);
		case ComputedValue computedValue -> _format(computedValue, document);
		case ModalPropertyValue modalPropertyValue -> _format(modalPropertyValue, document);
		case RangeValue rangeValue -> _format(rangeValue, document);
		case RecordValue recordValue -> _format(recordValue, document);
		case ReferenceValue referenceValue -> _format(referenceValue, document);
		case ErrorModelLibrary errorModelLibrary -> _format(errorModelLibrary, document);
		case ErrorPath errorPath -> _format(errorPath, document);
		case ErrorPropagation errorPropagation -> _format(errorPropagation, document);
		case ErrorSink errorSink -> _format(errorSink, document);
		case ErrorSource errorSource -> _format(errorSource, document);
		case ErrorType errorType -> _format(errorType, document);
		case SConditionElement sConditionElement -> _format(sConditionElement, document);
		case TypeSet typeSet -> _format(typeSet, document);
		case ListValue listValue -> _format(listValue, document);
		case Operation operation -> _format(operation, document);
		case AllExpression allExpression -> _format(allExpression, document);
		case AndExpression andExpression -> _format(andExpression, document);
		case CompositeState compositeState -> _format(compositeState, document);
		case ConditionElement conditionElement -> _format(conditionElement, document);
		case EMV2PropertyAssociation eMV2PropertyAssociation -> _format(eMV2PropertyAssociation, document);
		case EMV2Root eMV2Root -> _format(eMV2Root, document);
		case ErrorBehaviorState errorBehaviorState -> _format(errorBehaviorState, document);
		case ErrorBehaviorStateMachine errorBehaviorStateMachine -> _format(errorBehaviorStateMachine, document);
		case ErrorBehaviorTransition errorBehaviorTransition -> _format(errorBehaviorTransition, document);
		case ErrorDetection errorDetection -> _format(errorDetection, document);
		case OrExpression orExpression -> _format(orExpression, document);
		case OrlessExpression orlessExpression -> _format(orlessExpression, document);
		case OrmoreExpression ormoreExpression -> _format(ormoreExpression, document);
		case OutgoingPropagationCondition outgoingPropagationCondition ->
			_format(outgoingPropagationCondition, document);
		case PropagationPath propagationPath -> _format(propagationPath, document);
		case PropagationPoint propagationPoint -> _format(propagationPoint, document);
		case TypeMappingSet typeMappingSet -> _format(typeMappingSet, document);
		case TypeTransformationSet typeTransformationSet -> _format(typeTransformationSet, document);
		case XtextResource xtextResource -> _format(xtextResource, document);
		case ArrayRange arrayRange -> _format(arrayRange, document);
		case BasicPropertyAssociation basicPropertyAssociation -> _format(basicPropertyAssociation, document);
		case ContainmentPathElement containmentPathElement -> _format(containmentPathElement, document);
		case EMV2Path eMV2Path -> _format(eMV2Path, document);
		case EMV2PathElement eMV2PathElement -> _format(eMV2PathElement, document);
		case ErrorStateToModeMapping errorStateToModeMapping -> _format(errorStateToModeMapping, document);
		case FeatureorPPReference featureorPPReference -> _format(featureorPPReference, document);
		case QualifiedErrorBehaviorState qualifiedErrorBehaviorState -> _format(qualifiedErrorBehaviorState, document);
		case QualifiedPropagationPoint qualifiedPropagationPoint -> _format(qualifiedPropagationPoint, document);
		case TransitionBranch transitionBranch -> _format(transitionBranch, document);
		case TypeMapping typeMapping -> _format(typeMapping, document);
		case TypeToken typeToken -> _format(typeToken, document);
		case TypeTransformation typeTransformation -> _format(typeTransformation, document);
		case EObject eObject -> _format(eObject, document);
		case null -> _format((Void) null, document);
		default -> _format(object, document);
		}
	}

}

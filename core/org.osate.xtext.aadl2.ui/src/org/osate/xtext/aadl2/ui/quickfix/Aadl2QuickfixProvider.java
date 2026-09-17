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
package org.osate.xtext.aadl2.ui.quickfix;

import java.util.Arrays;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.Connection;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.FeaturePrototypeReference;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumericRange;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.UnitLiteral;
import org.osate.xtext.aadl2.properties.ui.quickfix.PropertiesQuickfixProvider;
import org.osate.xtext.aadl2.validation.Aadl2Validator;

import com.google.inject.Inject;

public class Aadl2QuickfixProvider extends PropertiesQuickfixProvider {
	@Inject
	private IURIEditorOpener editorOpener;

	/**
	 * QuickFix for matching the defining and ending identifiers of classifiers, packages, and property sets.
	 * The issue data array is expected to have three elements:
	 *
	 * issue.getData()[0]: The defining identifier of the classifier or model unit.
	 * issue.getData()[1]: The ending identifier of the classifier or model unit.
	 * issue.getData()[2]: The offset of the ending identifier within the Xtext document.
	 */
	@Fix(Aadl2Validator.MISMATCHED_BEGINNING_AND_ENDING_IDENTIFIERS)
	public void fixMismatchedBeginningAndEndingIdentifiers(Issue issue, IssueResolutionAcceptor acceptor) {
		var beginningName = issue.getData()[0];
		var endingName = issue.getData()[1];
		var endingIdentifierOffset = Integer.parseInt(issue.getData()[2]);
		acceptor.accept(issue, "Change defining identifier to '" + endingName + "'", null, null,
				(element, context) -> ((NamedElement) element).setName(endingName));
		acceptor.accept(issue, "Change ending identifier to '" + beginningName + "'", null, null,
				context -> context.getXtextDocument()
						.replace(endingIdentifierOffset, endingName.length(), beginningName));
	}

	/**
	 * QuickFix for Non-unique ComponentType names, most likely "refined to" missing.
	 * The issue data array is expected to have three elements:
	 *
	 * issue.getData()[0]: The name of the element.
	 * issue.getData()[1]: The offset of the ":".
	 * issue.getData()[2]: replacement value.
	 */
	@Fix(Aadl2Validator.DUPLICATE_COMPONENT_TYPE_NAME)
	public void fixDuplicateComponentType(Issue issue, IssueResolutionAcceptor acceptor) {
		var componentTypeName = issue.getData()[0];
		var offset = Integer.parseInt(issue.getData()[1]);
		var replacementVal = issue.getData()[2];

		acceptor.accept(issue, "Add 'refined to' to '" + componentTypeName + "'", null, null,
				context -> context.getXtextDocument().replace(offset, 1, replacementVal));
	}

	/**
	 * QuickFix for duplicate literal in an enumeration
	 * issue.getData()[0]: The name of the EnumerationLiteral.
	 */
	@Fix(Aadl2Validator.DUPLICATE_LITERAL_IN_ENUMERATION)
	public void fixDuplicateLiteralInEnumeration(Issue issue, IssueResolutionAcceptor acceptor) {
		var dupeLiteralName = issue.getData()[0];
		acceptor.accept(issue, "Remove duplicate literal '" + dupeLiteralName + "'", null, null,
				(element, context) -> {
					var el = (EnumerationLiteral) element;
					var enumContainer = (EnumerationType) el.eContainer();
					enumContainer.getOwnedLiterals().remove(el);
				});
	}

	/**
	 * QuickFix for unit literal being out of sequence
	 * issue.getData(0) UnitLiteral.baseUnit.name
	 * issue.getData(1) ... issue.getData(n): Alternating strings of the UnitLiteral names and URI.
	 */
	@Fix(Aadl2Validator.UNIT_LITERAL_OUT_OF_ORDER)
	public void fixUnitLiteralOutOfOrder(Issue issue, IssueResolutionAcceptor acceptor) {
		var baseUnitName = issue.getData()[0];
		var data = Arrays.asList(issue.getData()).iterator();

		if (data.hasNext()) {
			data.next();
		}

		while (data.hasNext()) {
			var ulName = data.next();
			var nextUri = data.next();
			acceptor.accept(issue, "Change unit base type '" + baseUnitName + "' to '" + ulName + "'", null, null,
					(element, context) -> {
						var resourceSet = element.eResource().getResourceSet();
						var newBaseUnit = (UnitLiteral) resourceSet.getEObject(URI.createURI(nextUri), true);
						((UnitLiteral) element).setBaseUnit(newBaseUnit);
					});
		}
	}

	/**
	 * QuickFix for mode in modal property value not being defined for the container
	 * issue.getData(0) mode.name
	 * issue.getData(1) undefinedMode URI
	 * issue.getData(2) containerName
	 * issue.getData(3) containerURI
	 * issue.getData(4) ModalPropertyValue
	 * issue.getData(5) ... issue.getData(n): Alternating strings of proposed replacement mode names and URI.
	 */
	@Fix(Aadl2Validator.MODE_NOT_DEFINED_IN_CONTAINER)
	public void fixModeNotDefinedInContainer(Issue issue, IssueResolutionAcceptor acceptor) {
		var modeName = issue.getData()[0];
		var undefinedModeURI = issue.getData()[1];
		var containerName = issue.getData()[2];
		var containerURI = issue.getData()[3];
		var modalPropertyValueURI = issue.getData()[4];

		acceptor.accept(issue, "Add '" + modeName + "' to in modes of '" + containerName + "'", null, null,
				(element, context) -> {
					var resourceSet = element.eResource().getResourceSet();
					var container = (ModalElement) resourceSet.getEObject(URI.createURI(containerURI), true);
					var undefinedMode = (Mode) resourceSet.getEObject(URI.createURI(undefinedModeURI), true);

					if (container instanceof ModalPath modalPath) {
						modalPath.getInModeOrTransitions().add(undefinedMode);
					} else {
						container.getInModes().add(undefinedMode);
					}
				});

		var data = Arrays.asList(issue.getData()).iterator();
		for (var i = 0; i < 5; i++) {
			if (data.hasNext()) {
				data.next();
			}
		}

		while (data.hasNext()) {
			var replacementName = data.next();
			var nextUri = data.next();

			acceptor.accept(issue, "Replace '" + modeName + "' with '" + replacementName + "'", null, null,
					(element, context) -> {
						var resourceSet = element.eResource().getResourceSet();
						var replacementMode = (Mode) resourceSet.getEObject(URI.createURI(nextUri), true);
						var undefinedMode = (Mode) resourceSet.getEObject(URI.createURI(undefinedModeURI), true);
						var mpv = (ModalPropertyValue) resourceSet
								.getEObject(URI.createURI(modalPropertyValueURI), true);
						mpv.getInModes().remove(undefinedMode);
						mpv.getInModes().add(replacementMode);
					});
		}
	}

	/**
	 * QuickFix for using self keyword when not allowed
	 * issue.getData(0) offSet
	 * issue.getData(1) connectionEndURI
	 */
	@Fix(Aadl2Validator.SELF_NOT_ALLOWED)
	public void fixSelfNotAllowed(Issue issue, IssueResolutionAcceptor acceptor) {
		var offSet = Integer.parseInt(issue.getData()[0]);
		var alternateConnectionEndType = issue.getData()[1];
		acceptor.accept(issue, "Remove 'self'", null, null,
				context -> context.getXtextDocument().replace(offSet, 5, ""));
		if (alternateConnectionEndType.equals("processor")) {
			acceptor.accept(issue, "Replace 'self' with 'processor'", null, null,
					context -> context.getXtextDocument().replace(offSet, 4, "processor"));
		}
	}

	/**
	 * QuickFix for using processor keyword when not allowed
	 * issue.getData(0) offSet
	 * issue.getData(1) connectionEndURI
	 */
	@Fix(Aadl2Validator.PROCESSOR_NOT_ALLOWED)
	public void fixProcessorNotAllowed(Issue issue, IssueResolutionAcceptor acceptor) {
		var offSet = Integer.parseInt(issue.getData()[0]);
		var alternateConnectionEndType = issue.getData()[1];
		acceptor.accept(issue, "Remove 'processor'", null, null,
				context -> context.getXtextDocument().replace(offSet, 10, ""));
		if (alternateConnectionEndType.equals("self")) {
			acceptor.accept(issue, "Replace 'processor' with 'self'", null, null,
					context -> context.getXtextDocument().replace(offSet, 9, "self"));
		}
	}

	/**
	 * QuickFix for flow impl kind not matching flow spec kind
	 * issue.getData(0) impl kind name
	 * issue.getData(1) flow spec name
	 * issue,getData(2) offSet
	 */
	@Fix(Aadl2Validator.INCONSISTENT_FLOW_KIND)
	public void fixInconsistentFlowKind(Issue issue, IssueResolutionAcceptor acceptor) {
		var flowImplKindName = issue.getData()[0];
		var flowSpecKindName = issue.getData()[1];
		var offSet = Integer.parseInt(issue.getData()[2]);

		acceptor.accept(issue, "Change '" + flowImplKindName + "' to '" + flowSpecKindName + "'", null, null,
				context -> context.getXtextDocument().replace(offSet, flowImplKindName.length(), flowSpecKindName));
	}

	/**
	 * QuickFix for out flow feature identifier not matching the flow specification
	 * issue.getData(0) outImplName
	 * issue.getData(1) specName
	 * issue,getData(2) featureOffSet
	 * issue,getData(3) contextOffset
	 */
	@Fix(Aadl2Validator.OUT_FLOW_FEATURE_IDENTIFIER_NOT_SPEC)
	public void fixOutFlowIdentifierNotSpec(Issue issue, IssueResolutionAcceptor acceptor) {
		var outImplName = issue.getData()[0];
		var specName = issue.getData()[1];
		var featureOffSet = Integer.parseInt(issue.getData()[2]);
		var contextOffset = Integer.parseInt(issue.getData()[3]);

		acceptor.accept(issue, "Change '" + outImplName + "' to '" + specName + "'", null, null, context -> {
			var useOffSet = contextOffset > 0 ? contextOffset : featureOffSet;
			context.getXtextDocument().replace(useOffSet, outImplName.length(), specName);
		});
	}

	/**
	 * QuickFix for in flow feature identifier not matching the flow specification
	 * issue.getData(0) inImplName
	 * issue.getData(1) specName
	 * issue,getData(2) featureOffSet
	 * issue,getData(3) contextOffset
	 */
	@Fix(Aadl2Validator.IN_FLOW_FEATURE_IDENTIFIER_NOT_SPEC)
	public void fixInFlowIdentifierNotSpec(Issue issue, IssueResolutionAcceptor acceptor) {
		var inImplName = issue.getData()[0];
		var specName = issue.getData()[1];
		var featureOffSet = Integer.parseInt(issue.getData()[2]);
		acceptor.accept(issue, "Change '" + inImplName + "' to '" + specName + "'", null, null,
				context -> context.getXtextDocument().replace(featureOffSet, inImplName.length(), specName));
	}

	/**
	 * QuickFix for Subcomponent not in flow modes
	 * issue.getData(0) flowModeName
	 * issue.getData(1) flowModeURI
	 * issue,getData(2) subcomponentName
	 * issue,getData(3) subcomponentURI
	 */
	@Fix(Aadl2Validator.SUBCOMPONENT_NOT_IN_FLOW_MODE)
	public void fixSubcomponentNotInFlowMode(Issue issue, IssueResolutionAcceptor acceptor) {
		var flowModeName = issue.getData()[0];
		var flowModeURI = issue.getData()[1];
		var subcomponentName = issue.getData()[2];
		var subcomponentURI = issue.getData()[3];

		acceptor.accept(issue, "Add mode '" + flowModeName + "' to in modes of '" + subcomponentName + "'", null, null,
				(element, context) -> {
					var suburi = URI.createURI(subcomponentURI);
					// The following opens up file if subcomponent is defined in a different file
					var doc = context.getXtextDocument(suburi);
					doc.modify(new IUnitOfWork.Void<XtextResource>() {
						@Override
						public void process(XtextResource state) throws Exception {
							var flowMode = (Mode) state.getResourceSet().getEObject(URI.createURI(flowModeURI), true);
							var subcomponent = (Subcomponent) state.getResourceSet().getEObject(suburi, true);
							var modeBinding = subcomponent.createOwnedModeBinding();
							modeBinding.setParentMode(flowMode);
						}
					});
					editorOpener.open(suburi, true);
				});
	}

	/**
	 * QuickFix for Subcomponent not in flow modes
	 * issue.getData(0) flowModeName
	 * issue.getData(1) flowModeURI
	 * issue,getData(2) connectionName
	 * issue,getData(3) connectionURI
	 */
	@Fix(Aadl2Validator.CONNECTION_NOT_IN_FLOW_MODE)
	public void fixConnectionNotInFlowMode(Issue issue, IssueResolutionAcceptor acceptor) {
		var flowModeName = issue.getData()[0];
		var flowModeURI = issue.getData()[1];
		var connectionName = issue.getData()[2];
		var connectionURI = issue.getData()[3];

		acceptor.accept(issue, "Add mode '" + flowModeName + "' to in modes of '" + connectionName + "'", null, null,
				(element, context) -> {
					var connuri = URI.createURI(connectionURI);
					// The following opens up file if connection is defined in a different file
					var doc = context.getXtextDocument(connuri);
					doc.modify(new IUnitOfWork.Void<XtextResource>() {
						@Override
						public void process(XtextResource state) throws Exception {
							var flowMode = (Mode) state.getResourceSet().getEObject(URI.createURI(flowModeURI), true);
							var connection = (Connection) state.getResourceSet().getEObject(connuri, true);
							connection.getInModeOrTransitions().add(flowMode);
						}
					});
					editorOpener.open(connuri, true);
				});
	}

	/**
	 * QuickFix for Subcomponent not in flow modes
	 * issue.getData(0) targetName
	 * issue.getData(1) targetURI
	 * issue,getData(2) neededModeName
	 * issue,getData(3) neededModeURI
	 */
	@Fix(Aadl2Validator.END_TO_END_FLOW_SEGMENT_NOT_IN_MODE)
	public void fixEndToEndFlowSegmentNotInMode(Issue issue, IssueResolutionAcceptor acceptor) {
		var targetName = issue.getData()[0];
		var targetURI = issue.getData()[1];
		var neededModeName = issue.getData()[2];
		var neededModeURI = issue.getData()[3];

		acceptor.accept(issue, "Add mode '" + neededModeName + "' to in modes of '" + targetName + "'", null, null,
				(element, context) -> {
					var targeturi = URI.createURI(targetURI);
					// The following opens up file if connection is defined in a different file
					var doc = context.getXtextDocument(targeturi);
					doc.modify(new IUnitOfWork.Void<XtextResource>() {
						@Override
						public void process(XtextResource state) throws Exception {
							var neededMode = (Mode) state.getResourceSet()
									.getEObject(URI.createURI(neededModeURI), true);
							var targetObject = state.getResourceSet().getEObject(targeturi, true);
							if (targetObject instanceof Subcomponent subcomponent) {
								var modeBinding = subcomponent.createOwnedModeBinding();
								modeBinding.setParentMode(neededMode);
							} else if (targetObject instanceof ModalPath modalPath) {
								modalPath.getInModeOrTransitions().add(neededMode);
							}
						}
					});
					editorOpener.open(targeturi, true);
				});
	}

	/**
	 * QuickFix for generic text replacement
	 * issue.getData(0) changeFrom
	 * issue.getData(1) changeTo
	 * issue,getData(2) offSet
	 */
	@Fix(Aadl2Validator.GENERIC_TEXT_REPLACEMENT)
	public void fixByGenericTextReplacement(Issue issue, IssueResolutionAcceptor acceptor) {
		var changeFrom = issue.getData()[0];
		var changeTo = issue.getData()[1];
		var offSet = Integer.parseInt(issue.getData()[2]);

		acceptor.accept(issue, "Change '" + changeFrom + "' to '" + changeTo + "'", null, null,
				context -> context.getXtextDocument().replace(offSet, changeFrom.length(), changeTo));
	}

	/**
	 * QuickFix for Array size not same as reference list size
	 * issue.getData(0) arraySize
	 * issue.getData(1) referenceListSize
	 */
	@Fix(Aadl2Validator.ARRAY_SIZE_NOT_EQUAL_REFERENCE_LIST_SIZE)
	public void fixArraySizeNotEqualRefernceListSize(Issue issue, IssueResolutionAcceptor acceptor) {
		var arraySize = Integer.parseInt(issue.getData()[0]);
		var referenceListSize = Integer.parseInt(issue.getData()[1]);

		acceptor.accept(issue, "Change Array size from '" + arraySize + "' to '" + referenceListSize + "'", null, null,
				(element, context) -> ((Subcomponent) element).getArrayDimensions()
						.get(0)
						.getSize()
						.setSize(referenceListSize));
	}

	/**
	 * QuickFix for Prototype must be an array because the refined prototype is an array
	 */
	@Fix(Aadl2Validator.PROTOTYPE_NOT_ARRAY)
	public void fixPrototypeMusBeAnArray(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Change prototype to an array", null, null,
				(element, context) -> ((ComponentPrototype) element).setArray(true));
	}

	/**
	 * QuickFix for Prototype binding direction not consistent with formal
	 * issue.getData(0) = actualDirection.toString();
	 * issue.getData(1) = formalDirection.toString();
	 */
	@Fix(Aadl2Validator.PROTOTYPE_BINDING_DIRECTION_NOT_CONSISTENT_WITH_FORMAL)
	public void fixPrototypeBindingDirection(Issue issue, IssueResolutionAcceptor acceptor) {
		var changeFrom = issue.getData()[0];
		var changeTo = issue.getData()[1];

		acceptor.accept(issue, "Change '" + changeFrom + "' to '" + changeTo + "'", null, null,
				(element, context) -> {
					var binding = (FeaturePrototypeBinding) element;
					var formal = (FeaturePrototype) binding.getFormal();
					var actual = binding.getActual();
					if (actual instanceof FeaturePrototypeReference reference) {
						reference.setIn(formal.isIn());
						reference.setOut(formal.isOut());
					} else if (actual instanceof PortSpecification specification) {
						specification.setIn(formal.isIn());
						specification.setOut(formal.isOut());
					}
				});
	}

	/**
	 * QuickFix for incompatible direction for prototype refinement
	 * issue.getData(0) = changeFrom
	 * issue.getData(1) = changeTo;
	 */
	@Fix(Aadl2Validator.INCOMPATIBLE_DIRECTION_FOR_PROTOTYPE_REFINEMENT)
	public void fixIncompatibleDirectionForPrototypeRefinement(Issue issue, IssueResolutionAcceptor acceptor) {
		var changeFrom = issue.getData()[0];
		var changeTo = issue.getData()[1];

		acceptor.accept(issue, "Change '" + changeFrom + "' to '" + changeTo + "'", null, null,
				(element, context) -> {
					var prototype = (FeaturePrototype) element;
					var refined = (FeaturePrototype) prototype.getRefined();
					prototype.setIn(refined.isIn());
					prototype.setOut(refined.isOut());
				});
	}

	/**
	 * QuickFix for incompatible  feature direction in refinement
	 * issue.getData(0) = changeFrom
	 * issue.getData(1) = changeTo;
	 */
	@Fix(Aadl2Validator.INCOMPATIBLE_FEATURE_DIRECTION_IN_REFINEMENT)
	public void fixIncompatibleFeatureDirectionInRefinement(Issue issue, IssueResolutionAcceptor acceptor) {
		var changeFrom = issue.getData()[0];
		var changeTo = issue.getData()[1];

		acceptor.accept(issue, "Change '" + changeFrom + "' to '" + changeTo + "'", null, null,
				(element, context) -> {
					var feature = (DirectedFeature) element;
					var refined = (DirectedFeature) feature.getRefined();
					feature.setIn(refined.isIn());
					feature.setOut(refined.isOut());
				});
	}

	/**
	 * QuickFix for incompatible  feature direction in refinement
	 * issue.getData(0) = changeFrom
	 * issue.getData(1) = changeTo;
	 */
	@Fix(Aadl2Validator.ABSTRACT_FEATURE_DIRECTION_DOES_NOT_MATCH_PROTOTYPE)
	public void fixAbstractFeatureDirectionDoesNotMatchPrototype(Issue issue, IssueResolutionAcceptor acceptor) {
		var changeFrom = issue.getData()[0];
		var changeTo = issue.getData()[1];

		acceptor.accept(issue, "Change '" + changeFrom + "' to '" + changeTo + "'", null, null,
				(element, context) -> {
					var feature = (AbstractFeature) element;
					var prototype = feature.getFeaturePrototype();
					feature.setIn(prototype.isIn());
					feature.setOut(prototype.isOut());
				});
	}

	/**
	 * QuickFix for incompatible feature direction in refinement
	 * issue.getData(0) = changeFrom
	 */
	@Fix(Aadl2Validator.ABSTRACT_FEATURE_DIRECTION_NOT_IN_PROTOTYPE)
	public void fixAbstractFeatureDirectionNotInPrototype(Issue issue, IssueResolutionAcceptor acceptor) {
		var changeFrom = issue.getData()[0];

		acceptor.accept(issue, "Remove '" + changeFrom + "'", null, null, (element, context) -> {
			var feature = (AbstractFeature) element;
			feature.setIn(false);
			feature.setOut(false);
		});
	}

	/**
	 * QuickFix for added direction in abstract feature refinement
	 * issue.getData(0) = changeFrom
	 */
	@Fix(Aadl2Validator.ADDED_DIRECTION_IN_ABSTRACT_FEATURE_REFINEMENT)
	public void fixAddedDirectionInAbstractFeatureRefinement(Issue issue, IssueResolutionAcceptor acceptor) {
		var changeFrom = issue.getData()[0];

		acceptor.accept(issue, "Remove '" + changeFrom + "'", null, null, (element, context) -> {
			var feature = (AbstractFeature) element;
			feature.setIn(false);
			feature.setOut(false);
		});
	}

	/**
	 * QuickFix for added prototype or classifier in abstract feature refinement
	 * issue.getData(0) = changeFrom
	 */
	@Fix(Aadl2Validator.ADDED_PROTOTYPE_OR_CLASSIFIER_IN_ABSTRACT_FEATURE_REFINEMENT)
	public void fixAddedPrototypeOrClassifierInAbstractFeatureRefinement(Issue issue,
			IssueResolutionAcceptor acceptor) {
		var changeFrom = issue.getData()[0];
		acceptor.accept(issue, "Remove '" + changeFrom + "'", null, null,
				(element, context) -> ((AbstractFeature) element).setFeaturePrototype(null));
	}

	/**
	 * QuickFix for chained inverse feature group types
	 */
	@Fix(Aadl2Validator.CHAINED_INVERSE_FEATURE_GROUP_TYPES)
	public void fixChainedInverseFeatureGroupTypes(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove inverse", null, null,
				(element, context) -> ((FeatureGroupType) element).setInverse(null));
	}

	/**
	 * QuickFix for extending inverse feature group types
	 */
	@Fix(Aadl2Validator.EXTENDED_INVERSE_FEATURE_GROUP_TYPE)
	public void fixExtendedInverseFeatureGroupTypes(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove extends", null, null, (element, context) -> {
			var groupExtension = (GroupExtension) element;
			var featureGroup = (FeatureGroupType) groupExtension.eContainer();
			featureGroup.setOwnedExtension(null);
		});
	}

	/**
	 * QuickFix for extending inverse feature group types
	 */
	@Fix(Aadl2Validator.INVERSE_IN_FEATURE_GROUP_TYPE_EXTENSION)
	public void fixInverseInFeatureGroupTypeExtension(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove extends", null, null, (element, context) -> {
			var groupExtension = (GroupExtension) element;
			var featureGroup = (FeatureGroupType) groupExtension.eContainer();
			featureGroup.setOwnedExtension(null);
		});
		acceptor.accept(issue, "Remove inverse", null, null, (element, context) -> {
			var groupExtension = (GroupExtension) element;
			var featureGroup = (FeatureGroupType) groupExtension.eContainer();
			featureGroup.setInverse(null);
		});
	}

	/**
	 * QuickFix for inverse in feature group
	 */
	@Fix(Aadl2Validator.INVERSE_IN_FEATURE_GROUP)
	public void fixInverseInFeatureGroup(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove inverse", null, null,
				(element, context) -> ((FeatureGroup) element).setInverse(false));
	}

	/**
	 * QuickFix for extending inverse feature group types
	 * issue.getData(0) = valid direction if any or empty String
	 * issue.getData(1) = current direction
	 */
	@Fix(Aadl2Validator.DIRECTION_NOT_SAME_AS_FEATURE_GROUP_MEMBERS)
	public void fixDirectionNotTheSameAsFeatureGroupMembers(Issue issue, IssueResolutionAcceptor acceptor) {
		var validDirection = issue.getData()[0];
		var currentDirection = issue.getData()[1];

		acceptor.accept(issue, "Remove '" + currentDirection + "'", null, null, (element, context) -> {
			var featureGroup = (FeatureGroup) element;
			featureGroup.setIn(false);
			featureGroup.setOut(false);
		});
		if (!validDirection.isEmpty()) {
			acceptor.accept(issue, "Change direction from '" + currentDirection + "' to '" + validDirection + "'", null,
					null, (element, context) -> {
						var featureGroup = (FeatureGroup) element;
						switch (validDirection) {
						case "in" -> {
							featureGroup.setIn(true);
							featureGroup.setOut(false);
						}
						case "out" -> {
							featureGroup.setIn(false);
							featureGroup.setOut(true);
						}
						default -> {
							featureGroup.setIn(false);
							featureGroup.setOut(false);
						}
						}
					});
		}
	}

	/**
	 * QuickFix for reverse access kind
	 * issue.getData.get(0) changeFrom
	 * issue.getData.get(1) changeTo
	 */
	@Fix(Aadl2Validator.REVERSE_ACCESS_KIND)
	public void fixReverseAccessKind(Issue issue, IssueResolutionAcceptor acceptor) {
		var changeFrom = issue.getData()[0];
		var changeTo = issue.getData()[1];
		acceptor.accept(issue, "Change access from '" + changeFrom + "' to '" + changeTo + "'", null, null,
				(element, context) -> ((Access) element).setKind(AccessType.getByName(changeTo)));
	}

	/**
	 * QuickFix for swapping Upper and Lower bounds in a range value when the upper is less than the lower
	 * issue.getData.get(0) lowerURI
	 * issue.getData.get(1) upperURI
	 * issue.getData.get(2) keyword before the range
	 * issue.getData.get(3) offSet of keyword before the range
	 */
	@Fix(Aadl2Validator.NUMERIC_RANGE_UPPER_LESS_THAN_LOWER)
	public void fixNumericRangeUpperLessThanLower(Issue issue, IssueResolutionAcceptor acceptor) {
		var lowerURI = issue.getData()[0];
		var upperURI = issue.getData()[1];
		var changeFrom = issue.getData()[2];
		var offSet = Integer.parseInt(issue.getData()[3]);
		var changeTo = changeFrom + " ";
		/* Doing just a semantic modification here caused the new lowerbound of the range to butt up against the
		 * type keyword without any white space causing "aadlinteger 12 .. 5" to become "aadlinteger5 .. 12" after
		 * the change. The solution here was to make the semantic change and then a text change replacing
		 * "aadlinteger" with "aadlinteger "
		 */
		acceptor.accept(issue, "Switch upper and lower bounds of the range", null, null, context -> {
			context.getXtextDocument().modify(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource state) throws Exception {
					var resourceSet = state.getResourceSet();
					var element = resourceSet.getEObject(issue.getUriToProblem(), true);
					var oldLower = (PropertyExpression) resourceSet.getEObject(URI.createURI(lowerURI), true);
					var oldUpper = (PropertyExpression) resourceSet.getEObject(URI.createURI(upperURI), true);
					((NumericRange) element).setUpperBound(oldLower);
					((NumericRange) element).setLowerBound(oldUpper);
				}
			});
			context.getXtextDocument().replace(offSet, changeFrom.length(), changeTo);
		});
	}

	/**
	 * QuickFix by making a connection bidirectional
	 */
	@Fix(Aadl2Validator.MAKE_CONNECTION_BIDIRECTIONAL)
	public void fixMakeConnectionBiderctional(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Make connection bidirectional", null, null,
				(element, context) -> ((Connection) element).setBidirectional(true));
	}

	/**
	 * QuickFix for adding a removing unused propertySet in packageSection with clause
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The name of the package or property set
	 * issue.getData()[1]: The URI String of the referenced AadlPackage or PropertySet.
	 */
	@Fix(Aadl2Validator.WITH_NOT_USED)
	public void fixWithNotUsed(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove '" + issue.getData()[0] + "' from the with clause", null, null,
				(element, context) -> {
					var resourceSet = element.eResource().getResourceSet();
					var importedModelUnit = (ModelUnit) resourceSet.getEObject(URI.createURI(issue.getData()[1]), true);
					if (element instanceof PackageSection packageSection) {
						packageSection.getImportedUnits().remove(importedModelUnit);
					} else if (element instanceof PropertySet propertySet) {
						propertySet.getImportedUnits().remove(importedModelUnit);
					}
				});
	}
}

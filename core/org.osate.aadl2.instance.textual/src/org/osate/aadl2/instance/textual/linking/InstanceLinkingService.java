/**
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.instance.textual.linking;

import static org.eclipse.xtext.EcoreUtil2.getContainerOfType;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.util.AadlUtil;

import com.google.inject.Inject;

public class InstanceLinkingService extends DefaultLinkingService {
	private static final InstancePackage INSTANCE_PACKAGE = InstancePackage.eINSTANCE;
	private static final Aadl2Package AADL2_PACKAGE = Aadl2Package.eINSTANCE;

	private final ResourceDescriptionsProvider rdp;
	private final IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	public InstanceLinkingService(ResourceDescriptionsProvider rdp, IQualifiedNameConverter qualifiedNameConverter) {
		this.rdp = rdp;
		this.qualifiedNameConverter = qualifiedNameConverter;
	}

	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
		var crossRefString = getCrossRefNodeAsString(node).replaceAll("\\s", "");
		EObject result = null;
		if (crossRefString != null && !crossRefString.isEmpty()) {
			var qName = qualifiedNameConverter.toQualifiedName(crossRefString);
			if (INSTANCE_PACKAGE.getSystemInstance_ComponentImplementation().equals(ref)) {
				result = getExportedObject(context, AADL2_PACKAGE.getComponentImplementation(),
						qName.getFirstSegment());
			} else if (INSTANCE_PACKAGE.getFeatureInstance_Feature().equals(ref)) {
				result = getClassifierFeature(context, AADL2_PACKAGE.getClassifier(), qName, classifier -> {
					if (classifier instanceof ComponentType component) {
						return component.getOwnedFeatures();
					} else if (classifier instanceof FeatureGroupType featureGroup) {
						return featureGroup.getOwnedFeatures();
					} else {
						return Collections.emptyList();
					}
				});
			} else if (INSTANCE_PACKAGE.getComponentInstance_InMode().equals(ref)) {
				var container = getContainerOfType(context.eContainer(), ComponentInstance.class);
				if (container != null) {
					result = container.getModeInstances()
							.stream()
							.filter(mode -> mode.getName().equals(qName.getFirstSegment()))
							.findFirst()
							.orElse(null);
				}
			} else if (INSTANCE_PACKAGE.getComponentInstance_Classifier().equals(ref)) {
				result = getExportedObject(context, AADL2_PACKAGE.getClassifier(), qName.getFirstSegment());
			} else if (INSTANCE_PACKAGE.getComponentInstance_Subcomponent().equals(ref)) {
				result = getClassifierFeature(context, AADL2_PACKAGE.getComponentImplementation(), qName,
						ComponentImplementation::getOwnedSubcomponents);
			} else if (INSTANCE_PACKAGE.getConnectionInstance_Source().equals(ref)
					|| INSTANCE_PACKAGE.getConnectionInstance_Destination().equals(ref)
					|| INSTANCE_PACKAGE.getConnectionReference_Source().equals(ref)
					|| INSTANCE_PACKAGE.getConnectionReference_Destination().equals(ref)
					|| INSTANCE_PACKAGE.getFlowSpecificationInstance_Source().equals(ref)
					|| INSTANCE_PACKAGE.getFlowSpecificationInstance_Destination().equals(ref)
					|| INSTANCE_PACKAGE.getEndToEndFlowInstance_FlowElement().equals(ref)
					|| INSTANCE_PACKAGE.getSystemOperationMode_CurrentMode().equals(ref)
					|| INSTANCE_PACKAGE.getModeTransitionInstance_Trigger().equals(ref)) {
				result = getInstanceObject(context, qName, ref);
			} else if (INSTANCE_PACKAGE.getConnectionInstance_InSystemOperationMode().equals(ref)
					|| INSTANCE_PACKAGE.getEndToEndFlowInstance_InSystemOperationMode().equals(ref)
					|| AADL2_PACKAGE.getModalElement_InMode().equals(ref)) {
				result = getContainerOfType(context, SystemInstance.class).getSystemOperationModes()
						.stream()
						.filter(som -> som.getName().equals(qName.getFirstSegment()))
						.findFirst()
						.orElse(null);
			} else if (INSTANCE_PACKAGE.getConnectionInstance_InModeTransition().equals(ref)
					|| INSTANCE_PACKAGE.getFlowSpecificationInstance_InModeTransition().equals(ref)) {
				result = guardedGet(getContainerOfType(context, ComponentInstance.class).getModeTransitionInstances(),
						toIndex(qName.getFirstSegment()));
			} else if (INSTANCE_PACKAGE.getConnectionReference_Connection().equals(ref)) {
				result = this.<ComponentImplementation> getClassifierFeature(context,
						AADL2_PACKAGE.getComponentImplementation(), qName,
						ComponentImplementation::getOwnedConnections);
			} else if (INSTANCE_PACKAGE.getConnectionReference_Context().equals(ref)) {
				if (qName.getFirstSegment().equals("parent")) {
					result = getContainerOfType(context, ComponentInstance.class);
				} else {
					result = getInstanceObject(context, qName, ref);
				}
			} else if (INSTANCE_PACKAGE.getFlowSpecificationInstance_InMode().equals(ref)
					|| INSTANCE_PACKAGE.getModeTransitionInstance_Source().equals(ref)
					|| INSTANCE_PACKAGE.getModeTransitionInstance_Destination().equals(ref)) {
				result = getContainerOfType(context, ComponentInstance.class)
						.getModeInstances()
						.stream()
						.filter(mode -> mode.getName().equals(qName.getFirstSegment()))
						.findFirst()
						.orElse(null);
			} else if (INSTANCE_PACKAGE.getFlowSpecificationInstance_FlowSpecification().equals(ref)) {
				result = getClassifierFeature(context, AADL2_PACKAGE.getComponentType(), qName,
						ComponentType::getOwnedFlowSpecifications);
			} else if (INSTANCE_PACKAGE.getEndToEndFlowInstance_EndToEndFlow().equals(ref)) {
				result = getClassifierFeature(context, AADL2_PACKAGE.getComponentImplementation(), qName,
						ComponentImplementation::getOwnedEndToEndFlows);
			} else if (INSTANCE_PACKAGE.getModeInstance_Parent().equals(ref)) {
				var container = getContainerOfType(getContainerOfType(context, ComponentInstance.class).eContainer(),
						ComponentInstance.class);
				if (container != null) {
					result = container.getModeInstances()
							.stream()
							.filter(mode -> mode.getName().equals(qName.getFirstSegment()))
							.findFirst()
							.orElse(null);
				}
			} else if (INSTANCE_PACKAGE.getModeInstance_Mode().equals(ref)) {
				result = getClassifierFeature(context, AADL2_PACKAGE.getComponentClassifier(), qName,
						ComponentClassifier::getOwnedModes);
			} else if (INSTANCE_PACKAGE.getModeTransitionInstance_ModeTransition().equals(ref)) {
				var segments = splitDeclarative(qName.getFirstSegment());
				if (segments.size() == 2) {
					var classifier = getExportedObject(context, AADL2_PACKAGE.getComponentClassifier(),
							segments.get(0));
					if (classifier != null) {
						var resolved = (ComponentClassifier) EcoreUtil.resolve(classifier, context);
						if (segments.get(1).startsWith("transition#")) {
							result = getUnnamedTransition(resolved, qName.getLastSegment());
						} else {
							result = resolved.getOwnedModeTransitions()
									.stream()
									.filter(transition -> transition.getName().equals(segments.get(1)))
									.findFirst()
									.orElse(null);
						}
					}
				}
			} else if (AADL2_PACKAGE.getPropertyAssociation_Property().equals(ref)) {
				result = getExportedObject(context, AADL2_PACKAGE.getProperty(), qName.getFirstSegment());
			} else if (INSTANCE_PACKAGE.getPropertyAssociationInstance_PropertyAssociation().equals(ref)) {
				var segments = splitDeclarative(qName.getFirstSegment());
				if (segments.size() == 2) {
					var classifier = getExportedObject(context, AADL2_PACKAGE.getClassifier(), segments.get(0));
					if (classifier != null) {
						var resolved = (Classifier) EcoreUtil.resolve(classifier, context);
						result = guardedGet(resolved.getOwnedPropertyAssociations(), toIndex(segments.get(1)));
					}
				} else if (segments.size() == 3) {
					var classifier = getExportedObject(context, AADL2_PACKAGE.getClassifier(), segments.get(0));
					if (classifier != null) {
						var resolved = EcoreUtil.resolve(classifier, context);
						ClassifierFeature element = null;
						if (resolved instanceof FeatureGroupType featureGroup) {
							element = featureGroup.getOwnedFeatures()
									.stream()
									.filter(feature -> feature.getName().equals(segments.get(1)))
									.findFirst()
									.orElse(null);
						} else if (resolved instanceof ComponentClassifier component
								&& segments.get(1).startsWith("transition#")) {
							element = getUnnamedTransition(component, segments.get(1));
						} else if (resolved instanceof ComponentType type) {
							element = Stream
									.of(type.getOwnedFeatures(), type.getOwnedFlowSpecifications(),
											type.getOwnedModes(), type.getOwnedModeTransitions())
									.flatMap(Collection::stream)
									.filter(member -> member.getName().equals(segments.get(1)))
									.findFirst()
									.orElse(null);
						} else if (resolved instanceof ComponentImplementation impl) {
							element = Stream
									.of(impl.getOwnedModes(), impl.getOwnedSubcomponents(), impl.getOwnedConnections(),
											impl.getOwnedEndToEndFlows(), impl.getOwnedModeTransitions())
									.flatMap(Collection::stream)
									.filter(member -> member.getName().equals(segments.get(1)))
									.findFirst()
									.orElse(null);
						}
						if (element != null) {
							result = guardedGet(element.getOwnedPropertyAssociations(), toIndex(segments.get(2)));
						}
					}
				}
			} else if (AADL2_PACKAGE.getContainmentPathElement_NamedElement().equals(ref)) {
				result = getClassifierFeature(context, AADL2_PACKAGE.getClassifier(), qName, classifier -> {
					if (classifier instanceof FeatureGroupType featureGroup) {
						return Stream.of(featureGroup.getOwnedPrototypes(), featureGroup.getOwnedFeatureGroups())
								.flatMap(Collection::stream)
								.toList();
					} else if (classifier instanceof ComponentType type) {
						return Stream.of(getComponentClassifierReferenceElements(type), type.getOwnedFeatureGroups())
								.flatMap(Collection::stream)
								.toList();
					} else if (classifier instanceof BehavioredImplementation impl) {
						return Stream
								.of(getImplReferenceElements(impl), impl.getOwnedSubprogramCallSequences(),
										impl.getSubprogramCalls())
								.flatMap(Collection::stream)
								.toList();
					} else if (classifier instanceof ComponentImplementation impl) {
						return getImplReferenceElements(impl);
					} else {
						return Collections.emptyList();
					}
				});
			} else if (INSTANCE_PACKAGE.getInstanceReferenceValue_ReferencedInstanceObject().equals(ref)) {
				result = getInstanceObject(getContainerOfType(context, SystemInstance.class), qName, ref);
			} else if (AADL2_PACKAGE.getClassifierValue_Classifier().equals(ref)) {
				result = getExportedObject(context, AADL2_PACKAGE.getClassifier(), qName.getFirstSegment());
			} else if (AADL2_PACKAGE.getNamedValue_NamedValue().equals(ref)) {
				if (qName.getFirstSegment().contains("::")) {
					result = getExportedObject(context, AADL2_PACKAGE.getProperty(), qName.getFirstSegment());
					if (result == null) {
						result = getExportedObject(context, AADL2_PACKAGE.getPropertyConstant(),
								qName.getFirstSegment());
					}
				} else {
					var property = getProperty(context);
					if (property != null) {
						var type = AadlUtil.getBasePropertyType(property.getPropertyType());
						if (type instanceof EnumerationType enumType) {
							result = enumType.getOwnedLiterals()
									.stream()
									.filter(literal -> literal.getName().equals(qName.getFirstSegment()))
									.findFirst()
									.orElse(null);
						}
					}
				}
			} else if (AADL2_PACKAGE.getNumberValue_Unit().equals(ref)) {
				var property = getProperty(context);
				if (property != null) {
					var type = AadlUtil.getBasePropertyType(property.getPropertyType());
					UnitsType unitsType = null;
					if (type instanceof NumberType numberType) {
						unitsType = numberType.getUnitsType();
					} else if (type instanceof RangeType rangeType) {
						unitsType = rangeType.getNumberType().getUnitsType();
					}
					if (unitsType != null) {
						result = unitsType.getOwnedLiterals()
								.stream()
								.filter(unit -> unit.getName().equals(qName.getFirstSegment()))
								.findFirst()
								.orElse(null);
					}
				}
			} else if (AADL2_PACKAGE.getBasicPropertyAssociation_Property().equals(ref)) {
				var property = getProperty(getContainerOfType(context, RecordValue.class));
				if (property != null) {
					if (AadlUtil.getBasePropertyType(property.getPropertyType()) instanceof RecordType recordType) {
						result = recordType.getOwnedFields()
								.stream()
								.filter(field -> field.getName().equals(qName.getFirstSegment()))
								.findFirst()
								.orElse(null);
					}
				}
			}
		}
		if (result != null) {
			return List.of(result);
		} else {
			return Collections.emptyList();
		}
	}

	private EObject getExportedObject(EObject context, EClass type, String name) {
		var qName = QualifiedName.create(name.split("::"));
		var exported = rdp.getResourceDescriptions(context.eResource()).getExportedObjects(type, qName, false);
		for (var obj : exported) {
			return obj.getEObjectOrProxy();
		}
		return null;
	}

	private <T extends Classifier> ClassifierFeature getClassifierFeature(EObject context, EClass type,
			QualifiedName qName, Function<T, List<? extends ClassifierFeature>> featureGetter) {
		var segments = splitDeclarative(qName.getFirstSegment());
		if (segments.size() == 2) {
			var exported = getExportedObject(context, type, segments.get(0));
			if (exported != null) {
				@SuppressWarnings("unchecked")
				var classifier = (T) EcoreUtil.resolve(exported, context);
				for (var feature : featureGetter.apply(classifier)) {
					if (segments.get(1).equals(feature.getName())) {
						return feature;
					}
				}
			}
		}
		return null;
	}

	private static List<String> splitDeclarative(String s) {
		var firstColon = s.indexOf(':', s.lastIndexOf("::") + 2);
		if (firstColon == -1) {
			return List.of(s);
		} else if (firstColon == s.length() - 1) {
			return List.of(s.substring(0, firstColon));
		} else {
			var splitArray = s.substring(firstColon + 1).split(":");
			return Stream.concat(Stream.of(s.substring(0, firstColon)), Arrays.stream(splitArray)).toList();
		}
	}

	private static InstanceObject getInstanceObject(EObject context, QualifiedName qName, EReference ref) {
		InstanceObject element = getContainerOfType(context, ComponentInstance.class);
		for (var segment : qName.getFirstSegment().split("\\.")) {
			if (element != null) {
				element = getNextObject(element, segment);
			}
		}
		if (element != null && ref.getEReferenceType().isSuperTypeOf(element.eClass())) {
			return element;
		} else {
			return null;
		}
	}

	private static InstanceObject getNextObject(InstanceObject container, String segment) {
		var bracketIndex = segment.indexOf('[');
		if (bracketIndex != -1) {
			var requestedName = segment.substring(0, bracketIndex);
			var requestedIndices = Arrays
					.stream(segment.substring(bracketIndex + 1, segment.length() - 1).split("\\]\\["))
					.map(Long::parseLong)
					.toList();
			if (container instanceof FeatureInstance feature && requestedIndices.size() == 1) {
				return feature.getFeatureInstances()
						.stream()
						.filter(innerFeature -> innerFeature.getIndex() == requestedIndices.get(0)
								&& innerFeature.getName().equals(requestedName))
						.findFirst()
						.orElse(null);
			} else if (container instanceof ComponentInstance component) {
				var features = component.getFeatureInstances()
						.stream()
						.filter(feature -> feature.getIndex() == requestedIndices.get(0));
				var components = component.getComponentInstances()
						.stream()
						.filter(innerComponent -> innerComponent.getIndices().equals(requestedIndices));
				return Stream.of(features, components)
						.flatMap(Function.identity())
						.filter(member -> member.getName().equals(requestedName))
						.findFirst()
						.orElse(null);
			} else {
				return null;
			}
		} else if (container instanceof FeatureInstance feature) {
			return feature.getFeatureInstances()
					.stream()
					.filter(innerFeature -> innerFeature.getIndex() == 0 && innerFeature.getName().equals(segment))
					.findFirst()
					.orElse(null);
		} else if (container instanceof ComponentInstance component) {
			if (segment.startsWith("connection#")) {
				return guardedGet(component.getConnectionInstances(), toIndex(segment));
			} else {
				var features = component.getFeatureInstances().stream().filter(feature -> feature.getIndex() == 0);
				var components = component.getComponentInstances()
						.stream()
						.filter(innerComponent -> innerComponent.getIndices().isEmpty());
				return Stream
						.of(features, components, component.getFlowSpecifications().stream(),
								component.getEndToEndFlows().stream(), component.getModeInstances().stream(),
								component.getModeTransitionInstances().stream())
						.flatMap(Function.identity())
						.filter(member -> member.getName().equals(segment))
						.findFirst()
						.orElse(null);
			}
		} else {
			return null;
		}
	}

	private static <T> T guardedGet(List<T> list, int index) {
		if (index < list.size()) {
			return list.get(index);
		} else {
			return null;
		}
	}

	private static int toIndex(String s) {
		return Integer.parseInt(s.substring(s.indexOf('#') + 1));
	}

	private static ModeTransition getUnnamedTransition(ComponentClassifier classifier, String indexString) {
		var transition = guardedGet(classifier.getOwnedModeTransitions(), toIndex(indexString));
		if (transition != null && transition.getName() == null) {
			return transition;
		} else {
			return null;
		}
	}

	private static BasicProperty getProperty(EObject context) {
		var bpa = getContainerOfType(context, BasicPropertyAssociation.class);
		if (bpa != null) {
			return bpa.getProperty();
		} else {
			return getContainerOfType(context, PropertyAssociation.class).getProperty();
		}
	}

	private static List<? extends ClassifierFeature> getComponentClassifierReferenceElements(
			ComponentClassifier classifier) {
		return Stream.of(classifier.getOwnedPrototypes(), classifier.getOwnedModeTransitions())
				.flatMap(Collection::stream)
				.filter(element -> element.getName() != null)
				.toList();
	}

	private static List<? extends ClassifierFeature> getImplReferenceElements(ComponentImplementation impl) {
		return Stream
				.of(getComponentClassifierReferenceElements(impl), impl.getOwnedSubcomponents(),
						impl.getOwnedInternalFeatures(), impl.getOwnedProcessorFeatures())
				.flatMap(Collection::stream)
				.toList();
	}
}

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
package org.osate.aadl2.instance.textual.linking

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.linking.impl.DefaultLinkingService
import org.eclipse.xtext.linking.impl.IllegalNodeException
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.BasicPropertyAssociation
import org.osate.aadl2.BehavioredImplementation
import org.osate.aadl2.Classifier
import org.osate.aadl2.ClassifierFeature
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ComponentType
import org.osate.aadl2.EnumerationType
import org.osate.aadl2.FeatureGroupType
import org.osate.aadl2.NumberType
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.RangeType
import org.osate.aadl2.RecordType
import org.osate.aadl2.RecordValue
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.FeatureInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.InstancePackage
import org.osate.aadl2.instance.SystemInstance

import static extension java.lang.Integer.parseInt
import static extension java.lang.Long.parseLong
import static extension java.util.Collections.singletonList
import static extension org.eclipse.emf.ecore.util.EcoreUtil.resolve
import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.getBasePropertyType

class InstanceLinkingService extends DefaultLinkingService {
	val extension InstancePackage = InstancePackage.eINSTANCE
	val extension Aadl2Package = Aadl2Package.eINSTANCE
	val ResourceDescriptionsProvider rdp
	val IQualifiedNameConverter qualifiedNameConverter

	@Inject
	new(ResourceDescriptionsProvider rdp, IQualifiedNameConverter qualifiedNameConverter) {
		this.rdp = rdp
		this.qualifiedNameConverter = qualifiedNameConverter
	}

	override getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
		val crossRefString = node.crossRefNodeAsString.replaceAll("\\s", "")
		val result = if (!crossRefString.nullOrEmpty) {
			val qName = qualifiedNameConverter.toQualifiedName(crossRefString)
			switch ref {
				case systemInstance_ComponentImplementation: context.getExportedObject(componentImplementation, qName.firstSegment)
				case featureInstance_Feature: context.getClassifierFeature(classifier, qName, [switch it {
					ComponentType: ownedFeatures
					FeatureGroupType: ownedFeatures
					default: emptyList
				}])
				case componentInstance_InMode: context.eContainer.getContainerOfType(ComponentInstance)?.modeInstances?.findFirst[name == qName.firstSegment]
				case componentInstance_Classifier: context.getExportedObject(classifier, qName.firstSegment)
				case componentInstance_Subcomponent: context.<ComponentImplementation>getClassifierFeature(componentImplementation, qName, [ownedSubcomponents])
				case connectionInstance_Source,
				case connectionInstance_Destination,
				case connectionReference_Source,
				case connectionReference_Destination,
				case flowSpecificationInstance_Source,
				case flowSpecificationInstance_Destination,
				case endToEndFlowInstance_FlowElement,
				case systemOperationMode_CurrentMode,
				case modeTransitionInstance_Trigger: context.getInstanceObject(qName, ref)
				case connectionInstance_InSystemOperationMode,
				case endToEndFlowInstance_InSystemOperationMode,
				case modalElement_InMode: context.getContainerOfType(SystemInstance).systemOperationModes.findFirst[name == qName.firstSegment]
				case connectionInstance_InModeTransition,
				case flowSpecificationInstance_InModeTransition: context.getContainerOfType(ComponentInstance).modeTransitionInstances.guardedGet(qName.firstSegment.toIndex)
				case connectionReference_Connection: context.<ComponentImplementation>getClassifierFeature(componentImplementation, qName, [ownedConnections])
				case connectionReference_Context: if (qName.firstSegment == "parent") {
					context.getContainerOfType(ComponentInstance)
				} else {
					context.getInstanceObject(qName, ref)
				}
				case flowSpecificationInstance_InMode,
				case modeTransitionInstance_Source,
				case modeTransitionInstance_Destination: context.getContainerOfType(ComponentInstance).modeInstances.findFirst[name == qName.firstSegment]
				case flowSpecificationInstance_FlowSpecification: context.<ComponentType>getClassifierFeature(componentType, qName, [ownedFlowSpecifications])
				case endToEndFlowInstance_EndToEndFlow: context.<ComponentImplementation>getClassifierFeature(componentImplementation, qName, [ownedEndToEndFlows])
				case modeInstance_Parent: context.getContainerOfType(ComponentInstance).eContainer.getContainerOfType(ComponentInstance)?.modeInstances?.findFirst[name == qName.firstSegment]
				case modeInstance_Mode: context.<ComponentClassifier>getClassifierFeature(componentClassifier, qName, [ownedModes])
				case modeTransitionInstance_ModeTransition: switch segments : qName.firstSegment.splitDeclarative {
					case segments.length == 2: {
						val classifier = context.getExportedObject(componentClassifier, segments.head)?.resolve(context) as ComponentClassifier
						if (classifier !== null) {
							if (segments.last.startsWith("transition#")) {
								classifier.getUnnamedTransition(qName.lastSegment)
							} else {
								classifier.ownedModeTransitions.findFirst[name == segments.last]
							}
						}
					}
				}
				case propertyAssociation_Property: context.getExportedObject(property, qName.firstSegment)
				case propertyAssociationInstance_PropertyAssociation: switch segments : qName.firstSegment.splitDeclarative {
					case segments.length == 2: {
						val classifier = context.getExportedObject(classifier, segments.head)?.resolve(context) as Classifier
						classifier?.ownedPropertyAssociations?.guardedGet(segments.last.toIndex)
					}
					case segments.length == 3: {
						val element = switch classifier : context.getExportedObject(classifier, segments.head)?.resolve(context) {
							FeatureGroupType: classifier.ownedFeatures.findFirst[name == segments.get(1)]
							ComponentClassifier case segments.get(1).startsWith("transition#"): classifier.getUnnamedTransition(segments.get(1))
							ComponentType: (classifier.ownedFeatures + classifier.ownedFlowSpecifications + classifier.ownedModes +
								classifier.ownedModeTransitions
							).findFirst[name == segments.get(1)]
							ComponentImplementation: (classifier.ownedModes + classifier.ownedSubcomponents + classifier.ownedConnections +
								classifier.ownedEndToEndFlows + classifier.ownedModeTransitions
							).findFirst[name == segments.get(1)]
						}
						element?.ownedPropertyAssociations?.guardedGet(segments.last.toIndex)
					}
				}
				case containmentPathElement_NamedElement: context.getClassifierFeature(classifier, qName, [switch it {
					FeatureGroupType: ownedPrototypes + ownedFeatureGroups
					ComponentType: componentClassifierReferenceElements + ownedFeatureGroups
					BehavioredImplementation: implReferenceElements + ownedSubprogramCallSequences + subprogramCalls()
					ComponentImplementation: implReferenceElements
				}])
				case instanceReferenceValue_ReferencedInstanceObject: context.getContainerOfType(SystemInstance).getInstanceObject(qName, ref)
				case classifierValue_Classifier: context.getExportedObject(classifier, qName.firstSegment)
				case namedValue_NamedValue: if (qName.firstSegment.contains("::")) {
					context.getExportedObject(property, qName.firstSegment) ?: context.getExportedObject(propertyConstant, qName.firstSegment)
				} else {
					switch type : context.property?.propertyType?.basePropertyType {
						EnumerationType: type.ownedLiterals.findFirst[name == qName.firstSegment]
					}
				}
				case numberValue_Unit: switch type : context.property?.propertyType?.basePropertyType {
					NumberType: type.unitsType
					RangeType: type.numberType.unitsType
				}?.ownedLiterals?.findFirst[name == qName.firstSegment]
				case basicPropertyAssociation_Property: switch type : context.getContainerOfType(RecordValue).property?.propertyType?.basePropertyType {
					RecordType: type.ownedFields.findFirst[name == qName.firstSegment]
				}
				default: super.getLinkedObjects(context, ref, node).head
			}
		}
		result?.singletonList ?: emptyList
	}

	def private getExportedObject(EObject context, EClass type, String name) {
		rdp.getResourceDescriptions(context.eResource).getExportedObjects(type, QualifiedName.create(name.split("::")),
			false).head?.EObjectOrProxy
	}

	def private <T extends Classifier> getClassifierFeature(EObject context, EClass type, QualifiedName qName,
		(T)=>Iterable<? extends ClassifierFeature> featureGetter) {
		val segments = qName.firstSegment.splitDeclarative
		if (segments.length == 2) {
			val classifier = context.getExportedObject(type, segments.head)?.resolve(context) as T
			if (classifier !== null) {
				featureGetter.apply(classifier).findFirst[name == segments.last]
			}
		}
	}

	def private static String[] splitDeclarative(String s) {
		switch firstColon : s.indexOf(":", s.lastIndexOf("::") + 2) {
			case -1: #[s]
			case s.length - 1: #[s.substring(0, firstColon)]
			default: #[s.substring(0, firstColon)] + s.substring(firstColon + 1).split(":")
		}
	}

	def private static getInstanceObject(EObject context, QualifiedName qName, EReference ref) {
		val element = qName.firstSegment.split("\\.").fold(
			context.getContainerOfType(ComponentInstance), [ InstanceObject container, segment |
				if (container !== null) {
					val bracketIndex = segment.indexOf("[")
					if (bracketIndex != -1) {
						val requestedName = segment.substring(0, bracketIndex)
						val requestedIndices = segment.substring(bracketIndex + 1, segment.length - 1).split(
							"\\]\\[").map[parseLong]
						(switch container {
							FeatureInstance case requestedIndices.size == 1:
								container.featureInstances.filter [
									index == requestedIndices.head
								]
							ComponentInstance:
								container.featureInstances.filter[index == requestedIndices.head] +
									container.componentInstances.filter[indices == requestedIndices]
							default:
								emptyList
						} as Iterable<InstanceObject>).findFirst[name == requestedName]
					} else if (segment.startsWith("connection#")) {
						if (container instanceof ComponentInstance) {
							container.connectionInstances.guardedGet(segment.toIndex)
						}
					} else {
						(switch container {
							FeatureInstance:
								container.featureInstances.filter[index == 0]
							ComponentInstance:
								container.featureInstances.filter[index == 0] + container.componentInstances.filter [
									indices.empty
								] + container.flowSpecifications + container.endToEndFlows + container.modeInstances +
								container.modeTransitionInstances
							default:
								emptyList
						} as Iterable<InstanceObject>).findFirst[name == segment]
					}
				}
			])
		if (element !== null && ref.EReferenceType.isSuperTypeOf(element.eClass)) {
			element
		}
	}

	def private static <T> guardedGet(List<T> list, int index) {
		if (index < list.size) {
			list.get(index)
		}
	}

	def private static toIndex(String s) {
		s.substring(s.indexOf("#") + 1).parseInt
	}

	def private static getUnnamedTransition(ComponentClassifier classifier, String indexString) {
		val transition = classifier.ownedModeTransitions.guardedGet(indexString.toIndex)
		if (transition !== null && transition.name === null) {
			transition
		}
	}

	def private static getProperty(EObject context) {
		context.getContainerOfType(BasicPropertyAssociation)?.property ?:
			context.getContainerOfType(PropertyAssociation).property
	}

	def private static getComponentClassifierReferenceElements(ComponentClassifier classifier) {
		classifier.ownedPrototypes + classifier.ownedModeTransitions.filter[name !== null]
	}

	def private static getImplReferenceElements(ComponentImplementation impl) {
		impl.componentClassifierReferenceElements + impl.ownedSubcomponents + impl.ownedInternalFeatures +
			impl.ownedProcessorFeatures
	}
}

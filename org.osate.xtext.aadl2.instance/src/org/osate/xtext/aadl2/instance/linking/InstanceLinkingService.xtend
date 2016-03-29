package org.osate.xtext.aadl2.instance.linking

import com.google.inject.Inject
import java.util.Collections
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
import static extension org.eclipse.emf.ecore.util.EcoreUtil.resolve
import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.getBasePropertyType
import static extension org.osate.xtext.aadl2.instance.scoping.InstanceScopeProvider.getComponentClassifierReferenceElements
import static extension org.osate.xtext.aadl2.instance.scoping.InstanceScopeProvider.getImplReferenceElements

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
		val crossRefString = node.crossRefNodeAsString
		val result = if (!crossRefString.nullOrEmpty) {
			val qName = qualifiedNameConverter.toQualifiedName(crossRefString)
			switch ref {
				case systemInstance_ComponentImplementation: if (qName.segmentCount >= 2) {
					rdp.getResourceDescriptions(context.eResource).getExportedObjects(componentImplementation, qName, false).map[EObjectOrProxy].head
				}
				case featureInstance_Feature: if (qName.segmentCount >= 3) {
					switch classifier : rdp.getResourceDescriptions(context.eResource).getExportedObjects(classifier, QualifiedName.create(qName.segments.take(qName.segmentCount - 1)), false).map[EObjectOrProxy.resolve(context)].head {
						ComponentType: classifier.ownedFeatures.findFirst[name == qName.lastSegment]
						FeatureGroupType: classifier.ownedFeatures.findFirst[name == qName.lastSegment]
					}
				}
				case componentInstance_InMode: if (qName.segmentCount == 1) {
					context.eContainer.getContainerOfType(ComponentInstance)?.modeInstances?.findFirst[name == qName.firstSegment]
				}
				case componentInstance_Subcomponent: if (qName.segmentCount >= 3) {
					rdp.getResourceDescriptions(context.eResource).getExportedObjects(componentImplementation, QualifiedName.create(qName.segments.take(qName.segmentCount - 1)), false).map[EObjectOrProxy.resolve(context) as ComponentImplementation].head?.ownedSubcomponents.findFirst[name == qName.lastSegment]
				}
				case connectionInstance_Source: if (qName.segmentCount == 1) {
					qName.firstSegment.split("\\.").fold(context.getContainerOfType(ComponentInstance), [InstanceObject container, segment | if (container != null) {
						val request = switch bracketIndex : segment.indexOf("[") {
							case -1: segment -> emptyList
							default: segment.substring(0, bracketIndex) -> segment.substring(bracketIndex + 1, segment.length - 1).split("\\]\\[").map[parseLong]
						}
						val requestedName = request.key
						val requestedIndices = request.value
						switch container {
							FeatureInstance: container.featureInstances.findFirst[name == requestedName && if (index == 0) {
								requestedIndices.empty
							} else {
								requestedIndices.size == 1 && index == requestedIndices.head
							}]
							ComponentInstance: container.featureInstances.findFirst[name == requestedName && if (index == 0) {
								requestedIndices.empty
							} else {
								requestedIndices.size == 1 && index == requestedIndices.head
							}] ?: container.componentInstances.findFirst[name == requestedName && indices == requestedIndices]
						}
					}])
				}
				case connectionInstance_Destination: if (qName.segmentCount == 1) {
					qName.firstSegment.split("\\.").fold(context.getContainerOfType(ComponentInstance), [InstanceObject container, segment | if (container != null) {
						val request = switch bracketIndex : segment.indexOf("[") {
							case -1: segment -> emptyList
							default: segment.substring(0, bracketIndex) -> segment.substring(bracketIndex + 1, segment.length - 1).split("\\]\\[").map[parseLong]
						}
						val requestedName = request.key
						val requestedIndices = request.value
						switch container {
							FeatureInstance: container.featureInstances.findFirst[name == requestedName && if (index == 0) {
								requestedIndices.empty
							} else {
								requestedIndices.size == 1 && index == requestedIndices.head
							}]
							ComponentInstance: container.featureInstances.findFirst[name == requestedName && if (index == 0) {
								requestedIndices.empty
							} else {
								requestedIndices.size == 1 && index == requestedIndices.head
							}] ?: container.componentInstances.findFirst[name == requestedName && indices == requestedIndices]
						}
					}])
				}
				case connectionInstance_InSystemOperationMode: if (qName.segmentCount == 1 && qName.firstSegment.startsWith("som#")) {
					val somIndex = qName.firstSegment.substring(qName.firstSegment.indexOf("#") + 1).parseInt
					val soms = context.getContainerOfType(SystemInstance).systemOperationModes
					if (somIndex < soms.size) {
						soms.get(somIndex)
					}
				}
				case connectionInstance_InModeTransition: if (qName.segmentCount == 1 && qName.firstSegment.startsWith("transition#")) {
					val transitionIndex = qName.firstSegment.substring(qName.firstSegment.indexOf("#") + 1).parseInt
					val transitions = context.getContainerOfType(ComponentInstance).modeTransitionInstances
					if (transitionIndex < transitions.size) {
						transitions.get(transitionIndex)
					}
				}
				case connectionReference_Source: if (qName.segmentCount == 1) {
					qName.firstSegment.split("\\.").fold(context.getContainerOfType(ComponentInstance), [InstanceObject container, segment | if (container != null) {
						val request = switch bracketIndex : segment.indexOf("[") {
							case -1: segment -> emptyList
							default: segment.substring(0, bracketIndex) -> segment.substring(bracketIndex + 1, segment.length - 1).split("\\]\\[").map[parseLong]
						}
						val requestedName = request.key
						val requestedIndices = request.value
						switch container {
							FeatureInstance: container.featureInstances.findFirst[name == requestedName && if (index == 0) {
								requestedIndices.empty
							} else {
								requestedIndices.size == 1 && index == requestedIndices.head
							}]
							ComponentInstance: container.featureInstances.findFirst[name == requestedName && if (index == 0) {
								requestedIndices.empty
							} else {
								requestedIndices.size == 1 && index == requestedIndices.head
							}] ?: container.componentInstances.findFirst[name == requestedName && indices == requestedIndices]
						}
					}])
				}
				case connectionReference_Destination: if (qName.segmentCount == 1) {
					qName.firstSegment.split("\\.").fold(context.getContainerOfType(ComponentInstance), [InstanceObject container, segment | if (container != null) {
						val request = switch bracketIndex : segment.indexOf("[") {
							case -1: segment -> emptyList
							default: segment.substring(0, bracketIndex) -> segment.substring(bracketIndex + 1, segment.length - 1).split("\\]\\[").map[parseLong]
						}
						val requestedName = request.key
						val requestedIndices = request.value
						switch container {
							FeatureInstance: container.featureInstances.findFirst[name == requestedName && if (index == 0) {
								requestedIndices.empty
							} else {
								requestedIndices.size == 1 && index == requestedIndices.head
							}]
							ComponentInstance: container.featureInstances.findFirst[name == requestedName && if (index == 0) {
								requestedIndices.empty
							} else {
								requestedIndices.size == 1 && index == requestedIndices.head
							}] ?: container.componentInstances.findFirst[name == requestedName && indices == requestedIndices]
						}
					}])
				}
				case connectionReference_Connection: if (qName.segmentCount >= 3) {
					rdp.getResourceDescriptions(context.eResource).getExportedObjects(componentImplementation, QualifiedName.create(qName.segments.take(qName.segmentCount - 1)), false).map[EObjectOrProxy.resolve(context) as ComponentImplementation].head?.ownedConnections.findFirst[name == qName.lastSegment]
				}
				case connectionReference_Context: if (qName.segmentCount == 1) {
					if (qName.firstSegment == "parent") {
						context.getContainerOfType(ComponentInstance)
					} else {
						qName.firstSegment.split("\\.").fold(context.getContainerOfType(ComponentInstance), [container, segment | if (container != null) {
							val bracketIndex = segment.indexOf("[")
							if (bracketIndex != -1) {
								val requestedName = segment.substring(0, bracketIndex)
								val requestedIndices = segment.substring(bracketIndex + 1, segment.length - 1).split("\\]\\[").map[parseLong]
								container.componentInstances.findFirst[name == requestedName && indices == requestedIndices]
							} else {
								container.componentInstances.findFirst[indices.empty && name == segment]
							}
						}])
					}
				}
				case flowSpecificationInstance_Source: if (qName.segmentCount == 1) {
					qName.firstSegment.split("\\.").fold(context.getContainerOfType(ComponentInstance), [InstanceObject container, segment | if (container != null) {
						val request = switch bracketIndex : segment.indexOf("[") {
							case -1: segment -> emptyList
							default: segment.substring(0, bracketIndex) -> segment.substring(bracketIndex + 1, segment.length - 1).split("\\]\\[").map[parseLong]
						}
						val requestedName = request.key
						val requestedIndices = request.value
						switch container {
							FeatureInstance: container.featureInstances
							ComponentInstance: container.featureInstances
						}.findFirst[name == requestedName && if (index == 0) {
							requestedIndices.empty
						} else {
							requestedIndices.size == 1 && index == requestedIndices.head
						}]
					}])
				}
				case flowSpecificationInstance_Destination: if (qName.segmentCount == 1) {
					qName.firstSegment.split("\\.").fold(context.getContainerOfType(ComponentInstance), [InstanceObject container, segment | if (container != null) {
						val request = switch bracketIndex : segment.indexOf("[") {
							case -1: segment -> emptyList
							default: segment.substring(0, bracketIndex) -> segment.substring(bracketIndex + 1, segment.length - 1).split("\\]\\[").map[parseLong]
						}
						val requestedName = request.key
						val requestedIndices = request.value
						switch container {
							FeatureInstance: container.featureInstances
							ComponentInstance: container.featureInstances
						}.findFirst[name == requestedName && if (index == 0) {
							requestedIndices.empty
						} else {
							requestedIndices.size == 1 && index == requestedIndices.head
						}]
					}])
				}
				case flowSpecificationInstance_InMode: if (qName.segmentCount == 1) {
					context.getContainerOfType(ComponentInstance).modeInstances.findFirst[name == qName.firstSegment]
				}
				case flowSpecificationInstance_InModeTransition: if (qName.segmentCount == 1 && qName.firstSegment.startsWith("transition#")) {
					val transitionIndex = qName.firstSegment.substring(qName.firstSegment.indexOf("#") + 1).parseInt
					val transitions = context.getContainerOfType(ComponentInstance).modeTransitionInstances
					if (transitionIndex < transitions.size) {
						transitions.get(transitionIndex)
					}
				}
				case flowSpecificationInstance_FlowSpecification: if (qName.segmentCount >= 3) {
					rdp.getResourceDescriptions(context.eResource).getExportedObjects(componentType, QualifiedName.create(qName.segments.take(qName.segmentCount - 1)), false).map[EObjectOrProxy.resolve(context) as ComponentType].head?.ownedFlowSpecifications.findFirst[name == qName.lastSegment]
				}
				case endToEndFlowInstance_FlowElement: if (qName.segmentCount == 1) {
					qName.firstSegment.split("\\.").fold(context.getContainerOfType(ComponentInstance), [InstanceObject container, segment | if (container instanceof ComponentInstance) {
						val bracketIndex = segment.indexOf("[")
						if (bracketIndex != -1) {
							val requestedName = segment.substring(0, bracketIndex)
							val requestedIndices = segment.substring(bracketIndex + 1, segment.length - 1).split("\\]\\[").map[parseLong]
							container.componentInstances.findFirst[name == requestedName && indices == requestedIndices]
						} else if (segment.startsWith("connection#")) {
							val connectionIndex = segment.substring(segment.indexOf("#") + 1).parseInt
							if (connectionIndex < container.connectionInstances.size) {
								container.connectionInstances.get(connectionIndex)
							}
						} else {
							(container.componentInstances.filter[indices.empty] + container.endToEndFlows + container.flowSpecifications).findFirst[name == segment]
						}
					}])
				}
				case endToEndFlowInstance_InSystemOperationMode: if (qName.segmentCount == 1 && qName.firstSegment.startsWith("som#")) {
					val somIndex = qName.firstSegment.substring(qName.firstSegment.indexOf("#") + 1).parseInt
					val soms = context.getContainerOfType(SystemInstance).systemOperationModes
					if (somIndex < soms.size) {
						soms.get(somIndex)
					}
				}
				case endToEndFlowInstance_EndToEndFlow: if (qName.segmentCount >= 3) {
					rdp.getResourceDescriptions(context.eResource).getExportedObjects(componentImplementation, QualifiedName.create(qName.segments.take(qName.segmentCount - 1)), false).map[EObjectOrProxy.resolve(context) as ComponentImplementation].head?.ownedEndToEndFlows.findFirst[name == qName.lastSegment]
				}
				case modeInstance_Parent: if (qName.segmentCount == 1) {
					context.getContainerOfType(ComponentInstance).eContainer.getContainerOfType(ComponentInstance)?.modeInstances?.findFirst[name == qName.firstSegment]
				}
				case modeInstance_Mode: if (qName.segmentCount >= 3) {
					rdp.getResourceDescriptions(context.eResource).getExportedObjects(componentClassifier, QualifiedName.create(qName.segments.take(qName.segmentCount - 1)), false).map[EObjectOrProxy.resolve(context) as ComponentClassifier].head?.ownedModes.findFirst[name == qName.lastSegment]
				}
				case modeTransitionInstance_Source: if (qName.segmentCount == 1) {
					context.getContainerOfType(ComponentInstance).modeInstances.findFirst[name == qName.firstSegment]
				}
				case modeTransitionInstance_Destination: if (qName.segmentCount == 1) {
					context.getContainerOfType(ComponentInstance).modeInstances.findFirst[name == qName.firstSegment]
				}
				case modeTransitionInstance_ModeTransition: if (qName.segmentCount >= 3) {
					val classifier = rdp.getResourceDescriptions(context.eResource).getExportedObjects(componentClassifier, QualifiedName.create(qName.segments.take(qName.segmentCount - 1)), false).map[EObjectOrProxy.resolve(context) as ComponentClassifier].head
					if (classifier != null) {
						if (qName.lastSegment.startsWith("transition#")) {
							val transitionIndex = qName.lastSegment.substring(qName.lastSegment.indexOf("#") + 1).parseInt
							if (transitionIndex < classifier.ownedModeTransitions.size) {
								val transition = classifier.ownedModeTransitions.get(transitionIndex)
								if (transition.name == null) {
									transition
								}
							}
						} else {
							classifier.ownedModeTransitions.findFirst[name == qName.lastSegment]
						}
					}
				}
				case systemOperationMode_CurrentMode: if (qName.segmentCount == 1) {
					qName.firstSegment.split("\\.").fold(context.getContainerOfType(ComponentInstance), [InstanceObject container, segment | if (container instanceof ComponentInstance) {
						val bracketIndex = segment.indexOf("[")
						if (bracketIndex != -1) {
							val requestedName = segment.substring(0, bracketIndex)
							val requestedIndices = segment.substring(bracketIndex + 1, segment.length - 1).split("\\]\\[").map[parseLong]
							container.componentInstances.findFirst[name == requestedName && indices == requestedIndices]
						} else {
							(container.componentInstances.filter[indices.empty] + container.modeInstances).findFirst[name == segment]
						}
					}])
				}
				case propertyAssociation_Property: if (qName.segmentCount == 2) {
					rdp.getResourceDescriptions(context.eResource).getExportedObjects(property, qName, false).map[EObjectOrProxy].head
				}
				case propertyAssociationInstance_PropertyAssociation: if (qName.segmentCount >= 3 && qName.lastSegment.startsWith("classifierProperty#")) {
					val classifier = rdp.getResourceDescriptions(context.eResource).getExportedObjects(classifier, QualifiedName.create(qName.segments.take(qName.segmentCount - 1)), false).map[EObjectOrProxy.resolve(context) as Classifier].head
					val associationIndex = qName.lastSegment.substring(qName.lastSegment.indexOf("#") + 1).parseInt
					val associations = classifier?.ownedPropertyAssociations
					if (associations != null && associationIndex < associations.size) {
						associations.get(associationIndex)
					}
				} else if (qName.segmentCount >= 4 && qName.lastSegment.startsWith("curlyProperty#")) {
					val elementName = qName.getSegment(qName.segmentCount - 2)
					val element = switch classifier : rdp.getResourceDescriptions(context.eResource).getExportedObjects(classifier, QualifiedName.create(qName.segments.take(qName.segmentCount - 2)), false).map[EObjectOrProxy.resolve(context)].head {
						FeatureGroupType: classifier.ownedFeatures.findFirst[name == elementName]
						ComponentClassifier case elementName.startsWith("transition#"): {
							val transitionIndex = elementName.substring(elementName.indexOf("#") + 1).parseInt
							if (transitionIndex < classifier.ownedModeTransitions.size) {
								val transition = classifier.ownedModeTransitions.get(transitionIndex)
								if (transition.name == null) {
									transition
								}
							}
						}
						ComponentType: (classifier.ownedFeatures + classifier.ownedFlowSpecifications + classifier.ownedModes + classifier.ownedModeTransitions).findFirst[name == elementName]
						ComponentImplementation: (classifier.ownedModes + classifier.ownedSubcomponents + classifier.ownedConnections + classifier.ownedEndToEndFlows + classifier.ownedModeTransitions).findFirst[name == elementName]
					}
					val propertyIndex = qName.lastSegment.substring(qName.lastSegment.indexOf("#") + 1).parseInt
					val associations = element?.ownedPropertyAssociations
					if (associations != null && propertyIndex < associations.size) {
						associations.get(propertyIndex)
					}
				}
				case modalElement_InMode: if (qName.segmentCount == 1 && qName.firstSegment.startsWith("som#")) {
					val somIndex = qName.firstSegment.substring(qName.firstSegment.indexOf("#") + 1).parseInt
					val soms = context.getContainerOfType(SystemInstance).systemOperationModes
					if (somIndex < soms.size) {
						soms.get(somIndex)
					}
				}
				case containmentPathElement_NamedElement: if (qName.segmentCount >= 3) {
					switch classifier : rdp.getResourceDescriptions(context.eResource).getExportedObjects(classifier, QualifiedName.create(qName.segments.take(qName.segmentCount - 1)), false).map[EObjectOrProxy.resolve(context)].head {
						FeatureGroupType: classifier.ownedPrototypes + classifier.ownedFeatureGroups
						ComponentType: classifier.componentClassifierReferenceElements + classifier.ownedFeatureGroups
						BehavioredImplementation: classifier.implReferenceElements + classifier.ownedSubprogramCallSequences + classifier.subprogramCalls()
						ComponentImplementation: classifier.implReferenceElements
					}.findFirst[name == qName.lastSegment]
				}
				case instanceReferenceValue_ReferencedInstanceObject: if (qName.segmentCount == 1) {
					qName.firstSegment.split("\\.").fold(context.getContainerOfType(SystemInstance), [InstanceObject container, segment | if (container != null) {
						val bracketIndex = segment.indexOf("[")
						if (bracketIndex != -1) {
							val requestedName = segment.substring(0, bracketIndex)
							val requestedIndices = segment.substring(bracketIndex + 1, segment.length - 1).split("\\]\\[").map[parseLong]
							if (requestedIndices.size == 1) {
								switch container {
									FeatureInstance: container.featureInstances.findFirst[index != 0 && index == requestedIndices.head && name == requestedName]
									ComponentInstance: (container.featureInstances.filter[index != 0 && index == requestedIndices.head] + container.componentInstances.filter[indices == requestedIndices]).findFirst[name == requestedName]
								}
							} else if (container instanceof ComponentInstance) {
								container.componentInstances.findFirst[indices == requestedIndices && name == requestedName]
							}
						} else if (segment.startsWith("connection#")) {
							if (container instanceof ComponentInstance) {
								val connectionIndex = segment.substring(segment.indexOf("#") + 1).parseInt
								if (connectionIndex < container.connectionInstances.size) {
									container.connectionInstances.get(connectionIndex)
								}
							}
						} else if (container instanceof FeatureInstance) {
							container.featureInstances.findFirst[index == 0 && name == segment]
						} else if (container instanceof ComponentInstance) {
							(container.featureInstances.filter[index == 0] + container.flowSpecifications + container.modeInstances + container.componentInstances.filter[indices.empty] + container.endToEndFlows).findFirst[name == segment]
						}
					}])
				}
				case classifierValue_Classifier: if (qName.segmentCount >= 2) {
					rdp.getResourceDescriptions(context.eResource).getExportedObjects(classifier, qName, false).map[EObjectOrProxy].head
				}
				case namedValue_NamedValue: if (qName.segmentCount == 1) {
					val property = context.getContainerOfType(BasicPropertyAssociation)?.property ?: context.getContainerOfType(PropertyAssociation).property
					val type = property?.propertyType?.basePropertyType
					if (type instanceof EnumerationType) {
						type.ownedLiterals.findFirst[name == qName.firstSegment]
					}
				} else if (qName.segmentCount == 2) {
					val descriptions = rdp.getResourceDescriptions(context.eResource)
					(descriptions.getExportedObjects(property, qName, false) + descriptions.getExportedObjects(propertyConstant, qName, false)).map[EObjectOrProxy].head
				}
				case numberValue_Unit: if (qName.segmentCount == 1) {
					val property = context.getContainerOfType(BasicPropertyAssociation)?.property ?: context.getContainerOfType(PropertyAssociation).property
					switch type : property?.propertyType?.basePropertyType {
						NumberType: type.unitsType
						RangeType: type.numberType.unitsType
					}?.ownedLiterals?.findFirst[name == qName.firstSegment]
				}
				case basicPropertyAssociation_Property: if (qName.segmentCount == 1) {
					val recordValue = context.getContainerOfType(RecordValue)
					val property = recordValue.getContainerOfType(BasicPropertyAssociation)?.property ?: recordValue.getContainerOfType(PropertyAssociation).property
					switch type : property?.propertyType?.basePropertyType {
						RecordType: type.ownedFields.findFirst[name == qName.firstSegment]
					}
				}
//				default: super.getLinkedObjects(context, ref, node).head
				default: throw new AssertionError("Missed reference: " + ref)
			}
		}
		if (result == null) {
			emptyList
		} else {
			Collections.singletonList(result)
		}
	}
}
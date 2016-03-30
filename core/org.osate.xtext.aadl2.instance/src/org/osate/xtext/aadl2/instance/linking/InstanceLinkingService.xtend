package org.osate.xtext.aadl2.instance.linking

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
					context.getExportedObject(componentImplementation, qName)
				}
				case featureInstance_Feature: if (qName.segmentCount >= 3) {
					context.getClassifierFeature(classifier, qName, [switch it {
						ComponentType: ownedFeatures
						FeatureGroupType: ownedFeatures
						default: emptyList
					}])
				}
				case componentInstance_InMode: if (qName.segmentCount == 1) {
					context.eContainer.getContainerOfType(ComponentInstance)?.modeInstances?.findFirst[name == qName.firstSegment]
				}
				case componentInstance_Subcomponent: if (qName.segmentCount >= 3) {
					context.<ComponentImplementation>getClassifierFeature(componentImplementation, qName, [ownedSubcomponents])
				}
				case connectionInstance_Source,
				case connectionInstance_Destination,
				case connectionReference_Source,
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
				case connectionInstance_InSystemOperationMode,
				case endToEndFlowInstance_InSystemOperationMode,
				case modalElement_InMode: if (qName.segmentCount == 1 && qName.firstSegment.startsWith("som#")) {
					context.getContainerOfType(SystemInstance).systemOperationModes.guardedGet(qName.firstSegment.substring(qName.firstSegment.indexOf("#") + 1).parseInt)
				}
				case connectionInstance_InModeTransition,
				case flowSpecificationInstance_InModeTransition: if (qName.segmentCount == 1 && qName.firstSegment.startsWith("transition#")) {
					context.getContainerOfType(ComponentInstance).modeTransitionInstances.guardedGet(qName.firstSegment.substring(qName.firstSegment.indexOf("#") + 1).parseInt)
				}
				case connectionReference_Connection: if (qName.segmentCount >= 3) {
					context.<ComponentImplementation>getClassifierFeature(componentImplementation, qName, [ownedConnections])
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
				case flowSpecificationInstance_Source,
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
				case flowSpecificationInstance_InMode,
				case modeTransitionInstance_Source,
				case modeTransitionInstance_Destination: if (qName.segmentCount == 1) {
					context.getContainerOfType(ComponentInstance).modeInstances.findFirst[name == qName.firstSegment]
				}
				case flowSpecificationInstance_FlowSpecification: if (qName.segmentCount >= 3) {
					context.<ComponentType>getClassifierFeature(componentType, qName, [ownedFlowSpecifications])
				}
				case endToEndFlowInstance_FlowElement: if (qName.segmentCount == 1) {
					qName.firstSegment.split("\\.").fold(context.getContainerOfType(ComponentInstance), [InstanceObject container, segment | if (container instanceof ComponentInstance) {
						val bracketIndex = segment.indexOf("[")
						if (bracketIndex != -1) {
							val requestedName = segment.substring(0, bracketIndex)
							val requestedIndices = segment.substring(bracketIndex + 1, segment.length - 1).split("\\]\\[").map[parseLong]
							container.componentInstances.findFirst[name == requestedName && indices == requestedIndices]
						} else if (segment.startsWith("connection#")) {
							container.connectionInstances.guardedGet(segment.substring(segment.indexOf("#") + 1).parseInt)
						} else {
							(container.componentInstances.filter[indices.empty] + container.endToEndFlows + container.flowSpecifications).findFirst[name == segment]
						}
					}])
				}
				case endToEndFlowInstance_EndToEndFlow: if (qName.segmentCount >= 3) {
					context.<ComponentImplementation>getClassifierFeature(componentImplementation, qName, [ownedEndToEndFlows])
				}
				case modeInstance_Parent: if (qName.segmentCount == 1) {
					context.getContainerOfType(ComponentInstance).eContainer.getContainerOfType(ComponentInstance)?.modeInstances?.findFirst[name == qName.firstSegment]
				}
				case modeInstance_Mode: if (qName.segmentCount >= 3) {
					context.<ComponentClassifier>getClassifierFeature(componentClassifier, qName, [ownedModes])
				}
				case modeTransitionInstance_ModeTransition: if (qName.segmentCount >= 3) {
					val classifier = context.getExportedObject(componentClassifier, QualifiedName.create(qName.segments.take(qName.segmentCount - 1)))?.resolve(context) as ComponentClassifier
					if (classifier != null) {
						if (qName.lastSegment.startsWith("transition#")) {
							val transition = classifier.ownedModeTransitions.guardedGet(qName.lastSegment.substring(qName.lastSegment.indexOf("#") + 1).parseInt)
							if (transition != null && transition.name == null) {
								transition
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
					context.getExportedObject(property, qName)
				}
				case propertyAssociationInstance_PropertyAssociation: if (qName.segmentCount >= 3 && qName.lastSegment.startsWith("classifierProperty#")) {
					val classifier = context.getExportedObject(classifier, QualifiedName.create(qName.segments.take(qName.segmentCount - 1)))?.resolve(context) as Classifier
					classifier?.ownedPropertyAssociations?.guardedGet(qName.lastSegment.substring(qName.lastSegment.indexOf("#") + 1).parseInt)
				} else if (qName.segmentCount >= 4 && qName.lastSegment.startsWith("curlyProperty#")) {
					val elementName = qName.getSegment(qName.segmentCount - 2)
					val element = switch classifier : context.getExportedObject(classifier, QualifiedName.create(qName.segments.take(qName.segmentCount - 2)))?.resolve(context) {
						FeatureGroupType: classifier.ownedFeatures.findFirst[name == elementName]
						ComponentClassifier case elementName.startsWith("transition#"): {
							val transition = classifier.ownedModeTransitions.guardedGet(elementName.substring(elementName.indexOf("#") + 1).parseInt)
							if (transition != null && transition.name == null) {
								transition
							}
						}
						ComponentType: (classifier.ownedFeatures + classifier.ownedFlowSpecifications + classifier.ownedModes + classifier.ownedModeTransitions).findFirst[name == elementName]
						ComponentImplementation: (classifier.ownedModes + classifier.ownedSubcomponents + classifier.ownedConnections + classifier.ownedEndToEndFlows + classifier.ownedModeTransitions).findFirst[name == elementName]
					}
					element?.ownedPropertyAssociations?.guardedGet(qName.lastSegment.substring(qName.lastSegment.indexOf("#") + 1).parseInt)
				}
				case containmentPathElement_NamedElement: if (qName.segmentCount >= 3) {
					context.getClassifierFeature(classifier, qName, [switch it {
						FeatureGroupType: ownedPrototypes + ownedFeatureGroups
						ComponentType: componentClassifierReferenceElements + ownedFeatureGroups
						BehavioredImplementation: implReferenceElements + ownedSubprogramCallSequences + subprogramCalls()
						ComponentImplementation: implReferenceElements
					}])
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
								container.connectionInstances.guardedGet(segment.substring(segment.indexOf("#") + 1).parseInt)
							}
						} else if (container instanceof FeatureInstance) {
							container.featureInstances.findFirst[index == 0 && name == segment]
						} else if (container instanceof ComponentInstance) {
							(container.featureInstances.filter[index == 0] + container.flowSpecifications + container.modeInstances + container.componentInstances.filter[indices.empty] + container.endToEndFlows).findFirst[name == segment]
						}
					}])
				}
				case classifierValue_Classifier: if (qName.segmentCount >= 2) {
					context.getExportedObject(classifier, qName)
				}
				case namedValue_NamedValue: if (qName.segmentCount == 1) {
					val property = context.getContainerOfType(BasicPropertyAssociation)?.property ?: context.getContainerOfType(PropertyAssociation).property
					val type = property?.propertyType?.basePropertyType
					if (type instanceof EnumerationType) {
						type.ownedLiterals.findFirst[name == qName.firstSegment]
					}
				} else if (qName.segmentCount == 2) {
					context.getExportedObject(property, qName) ?: context.getExportedObject(propertyConstant, qName)
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
				default: super.getLinkedObjects(context, ref, node).head
			}
		}
		result?.singletonList ?: emptyList
	}
	
	def private getExportedObject(EObject context, EClass type, QualifiedName qName) {
		rdp.getResourceDescriptions(context.eResource).getExportedObjects(type, qName, false).map[EObjectOrProxy].head
	}
	
	def private <T extends Classifier> getClassifierFeature(EObject context, EClass type, QualifiedName qName, (T)=>Iterable<? extends ClassifierFeature> featureGetter) {
		val classifier = context.getExportedObject(type, QualifiedName.create(qName.segments.take(qName.segmentCount - 1)))?.resolve(context) as T
		if (classifier != null) {
			featureGetter.apply(classifier).findFirst[name == qName.lastSegment]
		}
	}
	
	def private static <T> guardedGet(List<T> list, int index) {
		if (index < list.size) {
			list.get(index)
		}
	}
}
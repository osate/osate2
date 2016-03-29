package org.osate.xtext.aadl2.instance.serializer

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.EnumerationLiteral
import org.osate.aadl2.ModeTransition
import org.osate.aadl2.NamedElement
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyConstant
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.instance.FeatureInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.InstancePackage
import org.osate.aadl2.instance.SystemInstance

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.eclipse.xtext.GrammarUtil.getReference

class InstanceCrossReferenceSerializer extends CrossReferenceSerializer {
	val extension InstancePackage = InstancePackage.eINSTANCE
	val extension Aadl2Package = Aadl2Package.eINSTANCE
	
	override isValid(EObject semanticObject, CrossReference crossref, EObject target, INode node, Acceptor errors) {
		super.isValid(semanticObject, crossref, target, node, errors)
	}
	
	override serializeCrossRef(EObject semanticObject, CrossReference crossref, EObject target, INode node, Acceptor errors) {
		switch crossref.getReference(semanticObject.eClass) {
			case systemInstance_ComponentImplementation,
			case propertyAssociation_Property,
			case classifierValue_Classifier: (target as NamedElement).getQualifiedName
			
			case featureInstance_Feature,
			case componentInstance_Subcomponent,
			case connectionReference_Connection,
			case flowSpecificationInstance_FlowSpecification,
			case endToEndFlowInstance_EndToEndFlow,
			case modeInstance_Mode,
			case containmentPathElement_NamedElement: target.getContainerOfType(Classifier).getQualifiedName + "::" + (target as NamedElement).name
			
			case componentInstance_InMode,
			case flowSpecificationInstance_InMode,
			case modeInstance_Parent,
			case modeTransitionInstance_Source,
			case modeTransitionInstance_Destination,
			case numberValue_Unit,
			case basicPropertyAssociation_Property: (target as NamedElement).name
			
			case connectionInstance_Source,
			case connectionInstance_Destination,
			case connectionReference_Source,
			case connectionReference_Destination,
			case flowSpecificationInstance_Source,
			case flowSpecificationInstance_Destination,
			case endToEndFlowInstance_FlowElement,
			case systemOperationMode_CurrentMode: target.serializeChainedInstanceReference(semanticObject.getContainerOfType(ComponentInstance))
			
			case connectionReference_Context: switch rootComponent : semanticObject.getContainerOfType(ComponentInstance) {
				case target: "parent"
				default: target.serializeChainedInstanceReference(rootComponent)
			}
			
			case instanceReferenceValue_ReferencedInstanceObject: target.serializeChainedInstanceReference(semanticObject.getContainerOfType(SystemInstance))
			
			case connectionInstance_InSystemOperationMode,
			case endToEndFlowInstance_InSystemOperationMode,
			case modalElement_InMode: "som#" + target.getContainerOfType(SystemInstance).systemOperationModes.indexOf(target)
			
			case connectionInstance_InModeTransition,
			case flowSpecificationInstance_InModeTransition: "transition#" + target.getContainerOfType(ComponentInstance).modeTransitionInstances.indexOf(target)
			
			case modeTransitionInstance_ModeTransition: {
				val classifier = target.getContainerOfType(ComponentClassifier)
				val transition = target as ModeTransition
				classifier.getQualifiedName + "::" + (transition.name ?: "transition#" + classifier.ownedModeTransitions.indexOf(transition))
			}
			
			case propertyAssociationInstance_PropertyAssociation: {
				val classifier = target.getContainerOfType(Classifier)
				classifier.getQualifiedName + "::" + if (target.eContainer == classifier) {
					"classifierProperty#" + classifier.ownedPropertyAssociations.indexOf(target)
				} else {
					val parent = target.eContainer as NamedElement
					switch parent {
						ModeTransition case parent.name == null: "transition#" + (classifier as ComponentClassifier).ownedModeTransitions.indexOf(parent)
						default: parent.name
					} + "::curlyProperty#" + parent.ownedPropertyAssociations.indexOf(target)
				}
			}
			
			case namedValue_NamedValue: switch target {
				EnumerationLiteral: target.name
				Property,
				PropertyConstant: target.getQualifiedName
			}
			default: super.serializeCrossRef(semanticObject, crossref, target, node, errors)
		}
	}
	
	def private static serializeChainedInstanceReference(EObject target, ComponentInstance rootComponent) {
		val result = new StringBuilder(target.serializeChainSegment)
		var currentContainer = target.eContainer
		while (currentContainer != rootComponent) {
			result.insert(0, ".")
			result.insert(0, currentContainer.serializeChainSegment)
			currentContainer = currentContainer.eContainer
		}
		result.toString
	}
	
	def private static serializeChainSegment(EObject segment) {
		switch segment {
			ComponentInstance: '''«segment.name»«FOR index : segment.indices»[«index»]«ENDFOR»'''
			FeatureInstance: '''«segment.name»«IF segment.index != 0»[«segment.index»]«ENDIF»'''
			ConnectionInstance: "connection#" + segment.getContainerOfType(ComponentInstance).connectionInstances.indexOf(segment)
			InstanceObject: segment.name
		}
	}
}
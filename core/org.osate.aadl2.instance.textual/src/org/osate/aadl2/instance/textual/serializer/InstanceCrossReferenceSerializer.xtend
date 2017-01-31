/*
 * <copyright>
 * Copyright  2016 by Carnegie Mellon University, all rights reserved.
 * 
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 * 
 * NO WARRANTY
 * 
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 * 
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 * 
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.aadl2.instance.textual.serializer

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

	override serializeCrossRef(EObject semanticObject, CrossReference crossref, EObject target, INode node,
		Acceptor errors) {
		switch crossref.getReference(semanticObject.eClass) {
			case systemInstance_ComponentImplementation,
			case componentInstance_Classifier,
			case propertyAssociation_Property,
			case classifierValue_Classifier:
				(target as NamedElement).getQualifiedName
			case featureInstance_Feature,
			case componentInstance_Subcomponent,
			case connectionReference_Connection,
			case flowSpecificationInstance_FlowSpecification,
			case endToEndFlowInstance_EndToEndFlow,
			case modeInstance_Mode,
			case containmentPathElement_NamedElement:
				target.getContainerOfType(Classifier).getQualifiedName + ":" + (target as NamedElement).name
			case componentInstance_InMode,
			case flowSpecificationInstance_InMode,
			case modeInstance_Parent,
			case modeTransitionInstance_Source,
			case modeTransitionInstance_Destination,
			case numberValue_Unit,
			case basicPropertyAssociation_Property:
				(target as NamedElement).name
			case connectionInstance_Source,
			case connectionInstance_Destination,
			case connectionReference_Source,
			case connectionReference_Destination,
			case flowSpecificationInstance_Source,
			case flowSpecificationInstance_Destination,
			case endToEndFlowInstance_FlowElement,
			case systemOperationMode_CurrentMode:
				target.serializeChainedInstanceReference(semanticObject.getContainerOfType(ComponentInstance))
			case connectionInstance_InSystemOperationMode,
			case endToEndFlowInstance_InSystemOperationMode,
			case modalElement_InMode:
				"som#" + target.getContainerOfType(SystemInstance).systemOperationModes.indexOf(target)
			case connectionInstance_InModeTransition,
			case flowSpecificationInstance_InModeTransition:
				"transition#" + target.getContainerOfType(ComponentInstance).modeTransitionInstances.indexOf(target)
			case connectionReference_Context:
				switch rootComponent : semanticObject.getContainerOfType(ComponentInstance) {
					case target: "parent"
					default: target.serializeChainedInstanceReference(rootComponent)
				}
			case modeTransitionInstance_ModeTransition: {
				val classifier = target.getContainerOfType(ComponentClassifier)
				val transition = target as ModeTransition
				classifier.getQualifiedName + ":" +
					(transition.name ?: "transition#" + classifier.ownedModeTransitions.indexOf(transition))
			}
			case propertyAssociationInstance_PropertyAssociation: {
				val classifier = target.getContainerOfType(Classifier)
				classifier.getQualifiedName + ":" +
					if (target.eContainer == classifier) {
						"property#" + classifier.ownedPropertyAssociations.indexOf(target)
					} else {
						val parent = target.eContainer as NamedElement
						switch parent {
							ModeTransition case parent.name == null: "transition#" +
								(classifier as ComponentClassifier).ownedModeTransitions.indexOf(parent)
							default: parent.name
						} + ":property#" + parent.ownedPropertyAssociations.indexOf(target)
					}
			}
			case instanceReferenceValue_ReferencedInstanceObject:
				target.serializeChainedInstanceReference(semanticObject.getContainerOfType(SystemInstance))
			case namedValue_NamedValue:
				switch target {
					EnumerationLiteral: target.name
					Property,
					PropertyConstant: target.getQualifiedName
				}
			default:
				super.serializeCrossRef(semanticObject, crossref, target, node, errors)
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
			ConnectionInstance:
				"connection#" + segment.getContainerOfType(ComponentInstance).connectionInstances.indexOf(segment)
			InstanceObject:
				segment.name
		}
	}
}
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

	override serializeCrossRef(EObject semanticObject, CrossReference crossref, EObject target, INode node, Acceptor errors) {
		switch crossref.getReference(semanticObject.eClass) {
			case systemInstance_ComponentImplementation,
			case componentInstance_Classifier,
			case propertyAssociation_Property,
			case classifierValue_Classifier: (target as NamedElement).getQualifiedName
			
			case featureInstance_Feature,
			case componentInstance_Subcomponent,
			case connectionReference_Connection,
			case flowSpecificationInstance_FlowSpecification,
			case endToEndFlowInstance_EndToEndFlow,
			case modeInstance_Mode,
			case containmentPathElement_NamedElement: target.getContainerOfType(Classifier).getQualifiedName + ":" + (target as NamedElement).name
			
			case componentInstance_InMode,
			case connectionInstance_InSystemOperationMode,
			case flowSpecificationInstance_InMode,
			case endToEndFlowInstance_InSystemOperationMode,
			case modeInstance_Parent,
			case modeTransitionInstance_Source,
			case modeTransitionInstance_Destination,
			case numberValue_Unit,
			case basicPropertyAssociation_Property,
			case modalElement_InMode: (target as NamedElement).name
			
			case connectionInstance_Source,
			case connectionInstance_Destination,
			case connectionReference_Source,
			case connectionReference_Destination,
			case flowSpecificationInstance_Source,
			case flowSpecificationInstance_Destination,
			case endToEndFlowInstance_FlowElement,
			case systemOperationMode_CurrentMode,
			case modeTransitionInstance_Trigger: target.serializeChainedInstanceReference(semanticObject.getContainerOfType(ComponentInstance))
			
			case connectionInstance_InModeTransition,
			case flowSpecificationInstance_InModeTransition: "transition#" + target.getContainerOfType(ComponentInstance).modeTransitionInstances.indexOf(target)
			
			case connectionReference_Context: switch rootComponent : semanticObject.getContainerOfType(ComponentInstance) {
				case target: "parent"
				default: target.serializeChainedInstanceReference(rootComponent)
			}
			
			case modeTransitionInstance_ModeTransition: {
				val classifier = target.getContainerOfType(ComponentClassifier)
				val transition = target as ModeTransition
				classifier.getQualifiedName + ":" + (transition.name ?: "transition#" + classifier.ownedModeTransitions.indexOf(transition))
			}
			
			case propertyAssociationInstance_PropertyAssociation: {
				val classifier = target.getContainerOfType(Classifier)
				classifier.getQualifiedName + ":" + if (target.eContainer == classifier) {
					"property#" + classifier.ownedPropertyAssociations.indexOf(target)
				} else {
					val parent = target.eContainer as NamedElement
					switch parent {
						ModeTransition case parent.name === null: "transition#" + (classifier as ComponentClassifier).ownedModeTransitions.indexOf(parent)
						default: parent.name
					} + ":property#" + parent.ownedPropertyAssociations.indexOf(target)
				}
			}
			
			case instanceReferenceValue_ReferencedInstanceObject: target.serializeChainedInstanceReference(semanticObject.getContainerOfType(SystemInstance))
			
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

	def private static String serializeChainSegment(EObject segment) {
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

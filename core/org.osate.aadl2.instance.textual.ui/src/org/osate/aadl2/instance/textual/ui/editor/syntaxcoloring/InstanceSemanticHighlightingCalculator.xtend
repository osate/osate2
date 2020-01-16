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
package org.osate.aadl2.instance.textual.ui.editor.syntaxcoloring

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.ClassifierValue
import org.osate.aadl2.ContainmentPathElement
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.instance.ConnectionReference
import org.osate.aadl2.instance.EndToEndFlowInstance
import org.osate.aadl2.instance.FeatureInstance
import org.osate.aadl2.instance.FlowSpecificationInstance
import org.osate.aadl2.instance.InstancePackage
import org.osate.aadl2.instance.ModeInstance
import org.osate.aadl2.instance.ModeTransitionInstance
import org.osate.aadl2.instance.PropertyAssociationInstance
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.instance.SystemOperationMode

class InstanceSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
	override protected highlightElement(EObject object, IHighlightedPositionAcceptor acceptor) {
		switch object {
			SystemInstance: {
				highlightFeature(acceptor, object, Aadl2Package.eINSTANCE.namedElement_Name, InstanceHighlightingConfiguration.NAME_ID)
				highlightFeature(acceptor, object, InstancePackage.eINSTANCE.systemInstance_ComponentImplementation, InstanceHighlightingConfiguration.DECLARATIVE_ID)
				false
			}
			FeatureInstance: {
				highlightFeature(acceptor, object, Aadl2Package.eINSTANCE.namedElement_Name, InstanceHighlightingConfiguration.NAME_ID)
				highlightFeature(acceptor, object, InstancePackage.eINSTANCE.featureInstance_Feature, InstanceHighlightingConfiguration.DECLARATIVE_ID)
				false
			}
			ComponentInstance: {
				highlightFeature(acceptor, object, Aadl2Package.eINSTANCE.namedElement_Name, InstanceHighlightingConfiguration.NAME_ID)
				highlightFeature(acceptor, object, InstancePackage.eINSTANCE.componentInstance_Subcomponent, InstanceHighlightingConfiguration.DECLARATIVE_ID)
				false
			}
			ConnectionInstance: {
				highlightFeature(acceptor, object, Aadl2Package.eINSTANCE.namedElement_Name, InstanceHighlightingConfiguration.NAME_ID)
				false
			}
			ConnectionReference: {
				highlightFeature(acceptor, object, InstancePackage.eINSTANCE.connectionReference_Connection, InstanceHighlightingConfiguration.DECLARATIVE_ID)
				true
			}
			FlowSpecificationInstance: {
				highlightFeature(acceptor, object, Aadl2Package.eINSTANCE.namedElement_Name, InstanceHighlightingConfiguration.NAME_ID)
				highlightFeature(acceptor, object, InstancePackage.eINSTANCE.flowSpecificationInstance_FlowSpecification, InstanceHighlightingConfiguration.DECLARATIVE_ID)
				false
			}
			EndToEndFlowInstance: {
				highlightFeature(acceptor, object, Aadl2Package.eINSTANCE.namedElement_Name, InstanceHighlightingConfiguration.NAME_ID)
				highlightFeature(acceptor, object, InstancePackage.eINSTANCE.endToEndFlowInstance_EndToEndFlow, InstanceHighlightingConfiguration.DECLARATIVE_ID)
				false
			}
			ModeInstance: {
				highlightFeature(acceptor, object, Aadl2Package.eINSTANCE.namedElement_Name, InstanceHighlightingConfiguration.NAME_ID)
				highlightFeature(acceptor, object, InstancePackage.eINSTANCE.modeInstance_Mode, InstanceHighlightingConfiguration.DECLARATIVE_ID)
				false
			}
			ModeTransitionInstance: {
				highlightFeature(acceptor, object, Aadl2Package.eINSTANCE.namedElement_Name, InstanceHighlightingConfiguration.NAME_ID)
				highlightFeature(acceptor, object, InstancePackage.eINSTANCE.modeTransitionInstance_ModeTransition, InstanceHighlightingConfiguration.DECLARATIVE_ID)
				false
			}
			SystemOperationMode: {
				highlightFeature(acceptor, object, Aadl2Package.eINSTANCE.namedElement_Name, InstanceHighlightingConfiguration.NAME_ID)
				true
			}
			PropertyAssociationInstance: {
				highlightFeature(acceptor, object, Aadl2Package.eINSTANCE.propertyAssociation_Property, InstanceHighlightingConfiguration.NAME_ID)
				highlightFeature(acceptor, object, InstancePackage.eINSTANCE.propertyAssociationInstance_PropertyAssociation, InstanceHighlightingConfiguration.DECLARATIVE_ID)
				false
			}
			ContainmentPathElement: {
				highlightFeature(acceptor, object, Aadl2Package.eINSTANCE.containmentPathElement_NamedElement, InstanceHighlightingConfiguration.DECLARATIVE_ID)
				false
			}
			ClassifierValue: {
				highlightFeature(acceptor, object, Aadl2Package.eINSTANCE.classifierValue_Classifier, InstanceHighlightingConfiguration.DECLARATIVE_ID)
				true
			}
			default: false
		}
	}
}
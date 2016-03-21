package org.osate.xtext.aadl2.instance.ui.editor.syntaxcoloring

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
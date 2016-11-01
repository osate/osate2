package org.osate.xtext.aadl2.errormodel.scoping

import org.eclipse.emf.ecore.EReference
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.Element
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

class ErrorModelSerializerScopeProvider extends ErrorModelScopeProvider {
//	override scope_FeatureorPPReference_featureorPP(FeatureorPPReference context, EReference reference) {
//		switch container : context.owner {
//			FeatureorPPReference: super.scope_FeatureorPPReference_featureorPP(container, reference)
//			default: scope_FeatureorPPReference_featureorPP(container.getContainerOfType(Classifier), reference)
//		}
//	}
	
	override scope_BasicPropertyAssociation_property(Element context, EReference reference) {
		super.scope_BasicPropertyAssociation_property(context.owner, reference)
	}
	
//	override scope_EMV2PathElement_namedElement(EMV2PathElement context, EReference reference) {
//		val parent = context.eContainer
//		if (parent instanceof EMV2PathElement) {
//			super.scope_EMV2PathElement_namedElement(parent, reference)
//		} else {
//			scope_EMV2PathElement_namedElement(parent.getContainerOfType(EMV2PropertyAssociation), reference)
//		}
//	}
	
	override scope_SubcomponentElement_subcomponent(QualifiedErrorBehaviorState context, EReference reference) {
		val parent = context.eContainer
		if (parent instanceof QualifiedErrorBehaviorState) {
			super.scope_SubcomponentElement_subcomponent(parent, reference)
		} else {
			val containingImplementation = parent.getContainerOfType(ComponentImplementation)
			if (containingImplementation != null) {
				scope_SubcomponentElement_subcomponent(containingImplementation, reference)
			}
		}
	}
}
package org.osate.xtext.aadl2.errormodel.scoping

import org.eclipse.emf.ecore.EReference
import org.osate.aadl2.Classifier
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

class ErrorModelSerializerScopeProvider extends ErrorModelScopeProvider {
	override scope_FeatureorPPReference_featureorPP(FeatureorPPReference context, EReference reference) {
		switch container : context.owner {
			FeatureorPPReference: super.scope_FeatureorPPReference_featureorPP(container, reference)
			default: scope_FeatureorPPReference_featureorPP(container.getContainerOfType(Classifier), reference)
		}
	}
}
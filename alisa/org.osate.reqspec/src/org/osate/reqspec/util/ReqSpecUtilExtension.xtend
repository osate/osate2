package org.osate.reqspec.util

import org.eclipse.emf.ecore.EObject
import org.osate.reqspec.reqSpec.ContractualElement
import org.osate.reqspec.reqSpec.ReqSpecs
import org.osate.reqspec.reqSpec.StakeholderGoals
import org.osate.reqspec.reqSpec.Requirement
import static extension org.eclipse.xtext.EcoreUtil2.*

class ReqSpecUtilExtension {
	
	def static contextClassifier(ContractualElement context) {
		var EObject container = context
		while (container.eContainer != null) {
			container =container.eContainer
			if (container instanceof ReqSpecs){
				val rs = container as ReqSpecs
				if (rs.target != null) return rs.target
			} else
			if (container instanceof StakeholderGoals){
				val rs = container as StakeholderGoals
				if (rs.target != null) return rs.target
			} 
		}
		return null;
	}
	
	def static requirementTarget(Requirement req){
	req.target?:
		req.contextClassifier
	}

	def static containingRequirement(EObject sh){
		sh.getContainerOfType(Requirement)
	}

	def static containingReqSpecs(EObject sh){
		sh.getContainerOfType(ReqSpecs)
	}
	
}
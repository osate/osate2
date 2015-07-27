package org.osate.reqspec.util

import org.eclipse.emf.ecore.EObject
import org.osate.reqspec.reqSpec.ContractualElement
import org.osate.reqspec.reqSpec.StakeholderGoals
import org.osate.reqspec.reqSpec.Requirement
import static extension org.eclipse.xtext.EcoreUtil2.*
import org.osate.reqspec.reqSpec.SystemRequirements
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.ComponentClassifier
import org.osate.alisa.common.scoping.CommonGlobalScopeProvider
import com.google.inject.Inject
import org.eclipse.xtext.scoping.IGlobalScopeProvider

class ReqSpecUtilExtension {
	
	
	def static contextClassifier(ContractualElement context) {
		var EObject container = context
		while (container.eContainer != null) {
			container =container.eContainer
			if (container instanceof SystemRequirements){
				val rs = container as SystemRequirements
				if (rs.target != null) return rs.target
			} else
			if (container instanceof StakeholderGoals){
				val rs = container as StakeholderGoals
				if (rs.target != null) return rs.target
			} 
		}
		return null;
	}
	
	def static targetClassifier(ContractualElement req){
	req.target?:
		req.contextClassifier
	}

	def static containingRequirement(EObject sh){
		sh.getContainerOfType(Requirement)
	}

	def static containingSystemRequirements(EObject sh){
		sh.getContainerOfType(SystemRequirements)
	}
	
}
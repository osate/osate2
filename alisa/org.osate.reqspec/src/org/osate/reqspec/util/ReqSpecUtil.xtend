package org.osate.reqspec.util

import org.eclipse.emf.ecore.EObject
import org.osate.reqspec.reqSpec.ContractualElement
import org.osate.reqspec.reqSpec.ReqSpecs
import org.osate.reqspec.reqSpec.StakeholderGoals

class ReqSpecUtil {
	
	def contextClassifier(ContractualElement context) {
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

	
}
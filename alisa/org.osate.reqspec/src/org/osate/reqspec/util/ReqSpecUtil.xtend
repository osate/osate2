package org.osate.reqspec.util

import org.eclipse.emf.ecore.EObject
import org.osate.reqspec.reqSpec.ReqSpecContainer
import org.osate.reqspec.reqSpec.ContractualElement

class ReqSpecUtil {
	
	def contextClassifier(ContractualElement context) {
			val ce = context as ContractualElement
			if (ce.targetContext != null) return ce.targetContext
		var EObject container = context
		while (container.eContainer != null) {
			container =container.eContainer
			if (container instanceof ReqSpecContainer){
				val rs = container as ReqSpecContainer
				if (rs.target != null) return rs.target
			} 
		}
		return null;
	}

	
}
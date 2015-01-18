package org.osate.reqspec.util

import org.eclipse.emf.ecore.EObject
import org.osate.reqspec.reqSpec.ContractualElement
import org.osate.reqspec.reqSpec.ReqSpecLibrary

class ReqSpecUtil {
	
	def contextClassifier(ContractualElement context) {
			val ce = context as ContractualElement
//			if (ce.targetContext != null) return ce.targetContext
		var EObject container = context
		while (container.eContainer != null) {
			container =container.eContainer
			if (container instanceof ReqSpecLibrary){
				val rs = container as ReqSpecLibrary
				if (rs.target != null) return rs.target
			} 
		}
		return null;
	}

	
}
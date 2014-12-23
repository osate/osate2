package org.osate.reqspec.util

import org.eclipse.emf.ecore.EObject
import org.osate.reqspec.reqSpec.ReqSpecContainer

class ReqSpecUtil {
	
	def static contextClassifier(EObject context) {
		var container = context
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
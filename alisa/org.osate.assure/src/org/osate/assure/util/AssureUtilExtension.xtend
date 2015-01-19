package org.osate.assure.util

import org.eclipse.emf.ecore.EObject
import org.osate.assure.assure.CaseResult

class AssureUtilExtension {
	
	def static getEnclosingCaseResult(EObject assureObject){
		var result = assureObject
		while (!(result instanceof CaseResult))
		{ 
			result = result.eContainer
		}
		if (result==null) return null
		return result as CaseResult
	}
}
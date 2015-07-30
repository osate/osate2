package org.osate.alisa.workbench.util

import org.eclipse.emf.ecore.EObject
import org.osate.alisa.workbench.alisa.AssurancePlan

class AlisaWorkbenchUtilExtension {
		
def static AssurancePlan getEnclosingAssurancePlan(EObject eo){
	var result = eo
	while (result != null){
		if (result instanceof AssurancePlan) return result
		result = result.eContainer
	}
}
	
}
package org.osate.alisa.workbench.util

import org.eclipse.emf.ecore.EObject
import org.osate.alisa.workbench.alisa.AssurancePlan
import org.osate.verify.verify.VerificationPlan
import org.osate.aadl2.ComponentClassifier

class AlisaWorkbenchUtilExtension {
		
def static AssurancePlan getEnclosingAssurancePlan(EObject eo){
	var result = eo
	while (result != null){
		if (result instanceof AssurancePlan) return result
		result = result.eContainer
	}
	return null
}

def static ComponentClassifier getTargetComponentClassifier(VerificationPlan vp){
	vp.systemRequirements?.target
}
	
}
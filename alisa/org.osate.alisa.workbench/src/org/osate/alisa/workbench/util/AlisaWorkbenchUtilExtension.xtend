package org.osate.alisa.workbench.util

import org.eclipse.emf.ecore.EObject
import org.osate.alisa.workbench.alisa.AssurancePlan
import org.osate.verify.verify.VerificationPlan
import org.osate.aadl2.ComponentClassifier
import java.util.List
import org.osate.categories.categories.SelectionCategory
import org.osate.categories.util.CategoriesUtil
import org.osate.aadl2.NamedElement
import org.osate.alisa.common.common.Description
import org.osate.alisa.common.common.DescriptionElement

class AlisaWorkbenchUtilExtension {
		
def static AssurancePlan getEnclosingAssurancePlan(EObject eo){
	var result = eo
	while (result != null){
		if (result instanceof AssurancePlan) return result
		result = result.eContainer
	}
	return null
}
	
}
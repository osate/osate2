package org.osate.alisa.workbench.util

import org.osate.aadl2.instance.ComponentInstance
import org.osate.alisa.workbench.alisa.AssuranceCasePlan
import org.osate.verify.verify.VerificationPlan
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentType
import org.osate.aadl2.NamedElement
import org.osate.aadl2.ComponentImplementation
import org.osate.reqspec.reqSpec.Requirement
import org.osate.aadl2.instance.InstanceObject

class AlisaWorkbenchUtilsExtension {
		
	def static getVerificationPlans(ComponentInstance io, AssuranceCasePlan acp) {
		val myplans = acp.plans.filter [ VerificationPlan vp |
			vp.target.isSame(io.componentClassifier)
		]
		myplans
	}
	
	def static isSame(ComponentClassifier cl1, ComponentClassifier cl2){
		var lcl1 = cl1
		var lcl2 = cl2
		if (cl1 instanceof ComponentType && cl2 instanceof ComponentImplementation)
		lcl2 = (cl2 as ComponentImplementation).type
		if (cl2 instanceof ComponentType && cl1 instanceof ComponentImplementation)
		lcl1 = (cl1 as ComponentImplementation).type
		cl1.name.equalsIgnoreCase(cl2.name)
	}
	def static getRequirementTarget(Requirement req, ComponentInstance io) {
		io.findElementInstance(req.target)
	}

	def static findElementInstance(ComponentInstance io, NamedElement element) {
		switch io {
			ComponentInstance: io.allOwnedElements.findFirst[ei|
				(ei as InstanceObject).name.equalsIgnoreCase(element.name)] as NamedElement
			default: io
		}
	}

	
}
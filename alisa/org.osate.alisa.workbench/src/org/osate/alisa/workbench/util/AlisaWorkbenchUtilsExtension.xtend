package org.osate.alisa.workbench.util

import org.osate.aadl2.instance.ComponentInstance
import org.osate.alisa.workbench.alisa.AssurancePlan
import org.osate.reqspec.reqSpec.Requirement
import org.osate.verify.verify.VerificationPlan

import static extension org.osate.alisa.common.util.CommonUtilExtension.*

class AlisaWorkbenchUtilsExtension {
		
	def static getVerificationPlans(ComponentInstance io, AssurancePlan acp) {
		val myplans = acp.plans.filter [ VerificationPlan vp |
			io.componentClassifier.isSameorExtends(vp.systemRequirements?.target)
		]
		myplans
	}
	
	def static getRequirementTargetInstance(Requirement req, ComponentInstance io) {
		if (req.target == null) return io
		io.findElementInstance(req.target)
	}

	
}
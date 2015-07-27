package org.osate.alisa.workbench.util

import org.osate.aadl2.instance.ComponentInstance

import org.osate.verify.verify.VerificationPlan
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentType
import org.osate.aadl2.NamedElement
import org.osate.aadl2.ComponentImplementation
import org.osate.reqspec.reqSpec.Requirement
import org.osate.aadl2.instance.InstanceObject
import org.osate.alisa.workbench.alisa.AssurancePlan
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

	def static findElementInstance(ComponentInstance io, NamedElement element) {
		switch io {
			ComponentInstance: io.allOwnedElements.findFirst[ei|
				(ei as InstanceObject).name.equalsIgnoreCase(element.name)] as InstanceObject
			default: io
		}
	}

	def static findElementInstance(ComponentInstance io, String elementName) {
		switch io {
			ComponentInstance: io.allOwnedElements.findFirst[ei|
				(ei as InstanceObject).name.equalsIgnoreCase(elementName)] as InstanceObject
			default: io
		}
	}

	
}
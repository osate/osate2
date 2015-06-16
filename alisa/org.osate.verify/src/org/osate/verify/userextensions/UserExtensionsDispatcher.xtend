package org.osate.verify.userextensions

import org.osate.aadl2.instance.InstanceObject
import org.osate.verify.verify.VerificationMethod
import org.osate.verify.analysisplugins.DefaultVerificationMethodDispatcher
import org.osate.aadl2.instance.ComponentInstance
import static extension org.osate.verify.userextensions.CompositionalWeightAnalysis.*

class UserExtensionsDispatcher extends DefaultVerificationMethodDispatcher {
	override Object dispatchVerificationMethod(VerificationMethod vm, InstanceObject target,Class[] classesToLoad) {
			switch (vm.methodPath) {
				case "org.osate.verify.userextensions.UserExtensionsDispatcher.assumeWithWeightLimit" : {
					if ( target instanceof ComponentInstance) return target.assumeWithWeightLimit
				}
//				case "org.osate.assure.analysis.PlatformResourceBudgets.sumSubBudgets": {
//					if ( target instanceof ComponentInstance) return target.sumSubBudgets
//				}
			}
		return super.dispatchVerificationMethod(vm,target,classesToLoad)
	}
	
}
package org.osate.verify.userextensions

import org.osate.aadl2.instance.InstanceObject
import org.osate.verify.verify.VerificationMethod
import org.osate.verify.analysisplugins.DefaultVerificationMethodDispatcher

class UserExtensionsDispatcher extends DefaultVerificationMethodDispatcher {
	override Object dispatchVerificationMethod(VerificationMethod vm, InstanceObject target) {
			switch (vm.methodPath) {
//				case "org.osate.assure.analysis.PlatformResourceBudgets.assertSumSubBudgets" : {
//					if ( target instanceof ComponentInstance) return target.assertSumSubBudgets
//				}
//				case "org.osate.assure.analysis.PlatformResourceBudgets.sumSubBudgets": {
//					if ( target instanceof ComponentInstance) return target.sumSubBudgets
//				}
			}
		return super.dispatchVerificationMethod(vm,target)
	}
	
}
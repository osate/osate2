package org.osate.verify.analysisplugins

import org.osate.aadl2.instance.InstanceObject
import org.osate.verify.verify.VerificationMethod

import org.osate.verify.util.IVerificationMethodDispatcher
import static extension org.osate.verify.analysisplugins.AnalysisPluginInterface.*

class DefaultVerificationMethodDispatcher implements IVerificationMethodDispatcher {

	override Object dispatchVerificationMethod(VerificationMethod vm, InstanceObject target) {
			switch (vm.methodPath) {
//				case "org.osate.assure.analysis.PlatformResourceBudgets.assertSumSubBudgets" : {
//					if ( target instanceof ComponentInstance) return target.assertSumSubBudgets
//				}
//				case "org.osate.assure.analysis.PlatformResourceBudgets.sumSubBudgets": {
//					if ( target instanceof ComponentInstance) return target.sumSubBudgets
//				}
				case "org.osate.assure.analysis.PlatformResourceBudgets.flowLatencyAnalysis": {
					return target.flowLatencyAnalysis
				}
				case "org.osate.assure.analysis.PlatformResourceBudgets.A429Consistency": {
					return target.A429Consistency
				}
				case "org.osate.assure.analysis.PlatformResourceBudgets.ConnectionBindingConsistency": {
					return target.ConnectionBindingConsistency
				}
				case "org.osate.assure.analysis.PlatformResourceBudgets.PowerAnalysis": {
					return target.PowerAnalysis
				}
				case "org.osate.assure.analysis.PlatformResourceBudgets.PortDataConsistency": {
					return target.PortDataConsistency
				}
				case "org.osate.assure.analysis.PlatformResourceBudgets.MassAnalysis": {
					return target.MassAnalysis
				}
			}
		return null
	}


}

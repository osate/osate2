package org.osate.verify.analysisplugins

import org.osate.aadl2.instance.InstanceObject
import org.osate.verify.verify.VerificationMethod

import org.osate.verify.util.IVerificationMethodDispatcher
import static extension org.osate.verify.analysisplugins.AnalysisPluginInterface.*

class DefaultVerificationMethodDispatcher implements IVerificationMethodDispatcher {

	override Object dispatchVerificationMethod(VerificationMethod vm, InstanceObject target) {
			switch (vm.methodPath) {
//				case "org.osate.verify.analysisplugins.AnalysisPluginInterface.assertSumSubBudgets" : {
//					if ( target instanceof ComponentInstance) return target.assertSumSubBudgets
//				}
//				case "org.osate.verify.analysisplugins.AnalysisPluginInterface.sumSubBudgets": {
//					if ( target instanceof ComponentInstance) return target.sumSubBudgets
//				}
				case "org.osate.verify.analysisplugins.AnalysisPluginInterface.flowLatencyAnalysis": {
					return target.flowLatencyAnalysis
				}
				case "org.osate.verify.analysisplugins.AnalysisPluginInterface.A429Consistency": {
					return target.A429Consistency
				}
				case "org.osate.verify.analysisplugins.AnalysisPluginInterface.ConnectionBindingConsistency": {
					return target.ConnectionBindingConsistency
				}
				case "org.osate.verify.analysisplugins.AnalysisPluginInterface.PowerAnalysis": {
					return target.PowerAnalysis
				}
				case "org.osate.verify.analysisplugins.AnalysisPluginInterface.PortDataConsistency": {
					return target.PortDataConsistency
				}
				case "org.osate.verify.analysisplugins.AnalysisPluginInterface.MassAnalysis": {
					return target.MassAnalysis
				}
			}
		return null
	}


}

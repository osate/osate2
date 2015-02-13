package org.osate.assure.analysis

import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.util.DefaultVerificationMethodDispatcher
import org.osate.assure.util.IVerificationMethodDispatcher

import static extension org.osate.assure.analysis.AnalysisPluginInterface.*
import static extension org.osate.assure.util.AssureUtilExtension.*
import org.osate.assure.assure.VerificationResult
import org.osate.verify.verify.VerificationMethod

class AnalysisPluginDispatcher extends DefaultVerificationMethodDispatcher implements IVerificationMethodDispatcher {

	/**
	 * normal constructor
	 */
	public new() {
		super()
	}


	override Object dispatchVerificationMethod(VerificationMethod vm, VerificationResult vr) {
		val target = vr.claimSubject
			switch (vm.methodPath) {
//				case "org.osate.assure.util.PlatformResourceBudgets.assertSumSubBudgets" : {
//					if ( target instanceof ComponentInstance) return target.assertSumSubBudgets
//				}
//				case "org.osate.assure.util.PlatformResourceBudgets.sumSubBudgets": {
//					if ( target instanceof ComponentInstance) return target.sumSubBudgets
//				}
				case "org.osate.assure.util.PlatformResourceBudgets.flowLatencyAnalysis": {
					return target.flowLatencyAnalysis
				}
				case "org.osate.assure.util.PlatformResourceBudgets.A429Consistency": {
					return target.A429Consistency
				}
				case "org.osate.assure.util.PlatformResourceBudgets.ConnectionBindingConsistency": {
					return target.ConnectionBindingConsistency
				}
				case "org.osate.assure.util.PlatformResourceBudgets.PowerAnalysis": {
					return target.PowerAnalysis
				}
				case "org.osate.assure.util.PlatformResourceBudgets.PortDataConsistency": {
					return target.PortDataConsistency
				}
				case "org.osate.assure.util.PlatformResourceBudgets.MassAnalysis": {
					return target.MassAnalysis
				}
			}
		return null
	}

}

package org.osate.assure.evaluator

import org.osate.assure.util.IVerificationMethodDispatcher
import com.google.inject.Inject
import org.osate.assure.assure.CaseResult
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.HazardResult
import org.osate.assure.assure.AssumptionResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.FailThenResult
import org.osate.assure.assure.AndThenResult
import org.osate.assure.assure.AssureResult
import com.google.inject.ImplementedBy
import org.osate.assure.util.AssureUtilExtension

@ImplementedBy(AssureProcessor)
interface IAssureProcessor {
	def AssureResult process(AssureResult assureResult);
}

/**
 * performs the processing of verification activities
 * records the result accordingly
 */
class AssureProcessor implements IAssureProcessor {
	@Inject IVerificationMethodDispatcher dispatcher
	extension AssureUtilExtension aue = new AssureUtilExtension()

	def AssureResult doProcess(CaseResult caseResult) {
		caseResult.initialize
		val x = caseResult.claimResult.map[claimResult|claimResult.process]
		val y= x.addAllTo(caseResult)
		caseResult.hazardResult.map[hazardResult|hazardResult.process].addAllTo(caseResult)
		caseResult.subCaseResult.map[subcaseResult|subcaseResult.process].addAllTo(caseResult)
	}

	def AssureResult doProcess(ClaimResult claimResult) {
		claimResult.initialize
		claimResult.verificationActivityResult.map[vaResult|vaResult.process].addAllTo(claimResult)
		claimResult.subClaimResult.map[subclaimResult|subclaimResult.process].addAllTo(claimResult)
	}

	def AssureResult doProcess(VerificationActivityResult vaResult) {
		vaResult.initialize
		val xx = vaResult.assumptionResult.map[assumptionResult|assumptionResult.process]
		xx.addAllTo(vaResult)
		vaResult.preconditionResult.map[preconditionResult|preconditionResult.process].addAllTo(vaResult)
		val path = vaResult.target?.method?.methodPath
		dispatcher.dispatchVerificationMethod(path, vaResult.caseSubject)
		vaResult.addOwnResult
	}

	def AssureResult doProcess(FailThenResult vaResult) {
		vaResult.initialize
		vaResult.first.map[expr|expr.process].addAllTo(vaResult)
		if (vaResult.hasFailedOrError) {
			vaResult.initialize
			vaResult.recordFailThen
			vaResult.second.map[expr|expr.process].addAllTo(vaResult)
		}
	}

	def AssureResult doProcess(AndThenResult vaResult) {
		vaResult.initialize
		vaResult.first.map[expr|expr.process].addAllTo(vaResult)
		if (vaResult.isSuccessFul) {
			vaResult.second.map[expr|expr.process].addAllTo(vaResult)
		} else {
			vaResult.recordSkip
		}
	}

	def AssureResult doProcess(HazardResult hazardResult) {
		hazardResult.initialize
		hazardResult.claimResult.map[subclaimResult|subclaimResult.process].addAllTo(hazardResult)
	}

	def AssureResult doProcess(AssumptionResult assumptionResult) {
		assumptionResult.initialize
		assumptionResult.verificationActivityResult.map[vaResult|vaResult.process].addAllTo(assumptionResult)
	}

	def AssureResult doProcess(PreconditionResult preconditionResult) {
		preconditionResult.initialize
		preconditionResult.verificationActivityResult.map[vaResult|vaResult.process].addAllTo(preconditionResult)
	}

	override AssureResult process(AssureResult assureResult) {
		switch (assureResult) {
			CaseResult: assureResult.doProcess
			ClaimResult: assureResult.doProcess
			VerificationActivityResult: assureResult.doProcess
			FailThenResult: assureResult.doProcess
			AndThenResult: assureResult.doProcess
			HazardResult: assureResult.doProcess
			AssumptionResult: assureResult.doProcess
			PreconditionResult: assureResult.doProcess
		}

	}

}

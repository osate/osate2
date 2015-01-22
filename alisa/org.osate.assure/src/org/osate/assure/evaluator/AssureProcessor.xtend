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
import static extension org.osate.assure.util.AssureUtilExtension.*

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

	def AssureResult doProcess(CaseResult caseResult) {
		caseResult.resetCounts
		caseResult.claimResult.forEach[claimResult|claimResult.process.addTo(caseResult)]
		caseResult.hazardResult.forEach[hazardResult|hazardResult.process.addTo(caseResult)]
		caseResult.subCaseResult.forEach[subcaseResult|subcaseResult.process.addTo(caseResult)]
		caseResult
	}

	def AssureResult doProcess(ClaimResult claimResult) {
		claimResult.resetCounts
		claimResult.verificationActivityResult.forEach[vaResult|vaResult.process.addTo(claimResult)]
		claimResult.subClaimResult.forEach[subclaimResult|subclaimResult.process.addTo(claimResult)]
		claimResult
	}

	def AssureResult doProcess(VerificationActivityResult vaResult) {
		vaResult.resetCounts
		vaResult.assumptionResult.forEach[assumptionResult|assumptionResult.process.addTo(vaResult)]
		vaResult.preconditionResult.forEach[preconditionResult|preconditionResult.process.addTo(vaResult)]
		dispatcher.runVerificationMethod( vaResult)
		vaResult.addOwnResult
		vaResult
	}

	def AssureResult doProcess(FailThenResult vaResult) {
		vaResult.resetCounts
		vaResult.first.forEach[expr|expr.process.addTo(vaResult)]
		if (vaResult.hasFailedOrError) {
			vaResult.resetCounts
			vaResult.recordFailThen
			vaResult.second.forEach[expr|expr.process.addTo(vaResult)]
		}
		vaResult
	}

	def AssureResult doProcess(AndThenResult vaResult) {
		vaResult.resetCounts
		vaResult.first.forEach[expr|expr.process.addTo(vaResult)]
		if (vaResult.isSuccessFul) {
			vaResult.second.forEach[expr|expr.process.addTo(vaResult)]
		} else {
			vaResult.recordSkip
		}
		vaResult
	}

	def AssureResult doProcess(HazardResult hazardResult) {
		hazardResult.resetCounts
		hazardResult.claimResult.forEach[subclaimResult|subclaimResult.process.addTo(hazardResult)]
		hazardResult
	}

	def AssureResult doProcess(AssumptionResult assumptionResult) {
		assumptionResult.resetCounts
		assumptionResult.verificationActivityResult.forEach[vaResult|vaResult.process.addTo(assumptionResult)]
		assumptionResult
	}

	def AssureResult doProcess(PreconditionResult preconditionResult) {
		preconditionResult.resetCounts
		preconditionResult.verificationActivityResult.forEach[vaResult|vaResult.process.addTo(preconditionResult)]
		preconditionResult
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

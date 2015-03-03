package org.osate.assure.evaluator

import org.osate.assure.evaluator.IVerificationMethodDispatcher
import com.google.inject.Inject
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.FailThenResult
import org.osate.assure.assure.AndThenResult
import org.osate.assure.assure.AssureResult
import com.google.inject.ImplementedBy
import static extension org.osate.assure.util.AssureUtilExtension.*
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.AssuranceEvidence

@ImplementedBy(AssureProcessor)
interface IAssureProcessor {
	def void process(AssureResult assureResult);
}

/**
 * performs the processing of verification activities
 * records the result propagating up the counts
 * Will process only those that are TBD
 * It assumes the counts are ok
 */
class AssureProcessor implements IAssureProcessor {
	@Inject IVerificationMethodDispatcher dispatcher

	def void doProcess(AssuranceEvidence caseResult) {
		caseResult.claimResult.forEach[claimResult|claimResult.process]
		caseResult.subAssuranceEvidence.forEach[subcaseResult|subcaseResult.process]
	}

	def void doProcess(ClaimResult claimResult) {
		claimResult.verificationActivityResult.forEach[vaResult|vaResult.process]
		claimResult.subClaimResult.forEach[subclaimResult|subclaimResult.process]
	}

	def void doProcess(VerificationActivityResult vaResult) {
		vaResult.validationResult.forEach[assumptionResult|assumptionResult.process]
		vaResult.preconditionResult.forEach[preconditionResult|preconditionResult.process]
		if (vaResult.preconditionResult.success) {
			dispatcher.runVerificationMethod(vaResult)
		}
	}

	def void doProcess(FailThenResult vaResult) {
		vaResult.first.forEach[expr|expr.process]
		if (vaResult.unknownThen && vaResult.first.hasUnknown) {
			vaResult.recordFailThen
			vaResult.second.forEach[expr|expr.process]
		} else if (vaResult.failThen && vaResult.first.hasFailed) {
			vaResult.recordFailThen
			vaResult.second.forEach[expr|expr.process]
		} else if (vaResult.first.hasFailedOrUnknown) {
			vaResult.recordFailThen
			vaResult.second.forEach[expr|expr.process]
		} else {
			vaResult.recordNoFailThen
		}
	}

	def void doProcess(AndThenResult vaResult) {
		vaResult.first.forEach[expr|expr.process]
		if (vaResult.first.isSuccessFul) {
			vaResult.second.forEach[expr|expr.process]
			vaResult.recordNoSkip
		} else {
			vaResult.recordSkip
		}
	}

	def void doProcess(ValidationResult assumptionResult) {
			dispatcher.runVerificationMethod(assumptionResult)
	}

	def void doProcess(PreconditionResult preconditionResult) {
			dispatcher.runVerificationMethod(preconditionResult)
	}

	override void process(AssureResult assureResult) {
		switch (assureResult) {
			AssuranceEvidence: assureResult.doProcess
			ClaimResult: assureResult.doProcess
			VerificationActivityResult: assureResult.doProcess
			FailThenResult: assureResult.doProcess
			AndThenResult: assureResult.doProcess
			ValidationResult: assureResult.doProcess
			PreconditionResult: assureResult.doProcess
		}
	}

}

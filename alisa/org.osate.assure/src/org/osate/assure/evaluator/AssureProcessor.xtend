package org.osate.assure.evaluator

import org.osate.assure.util.IVerificationMethodDispatcher
import com.google.inject.Inject
import org.osate.assure.assure.CaseResult
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.AssumptionResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.FailThenResult
import org.osate.assure.assure.AndThenResult
import org.osate.assure.assure.AssureResult
import com.google.inject.ImplementedBy
import static extension org.osate.assure.util.AssureUtilExtension.*
import org.osate.assure.assure.VerificationResult
import org.osate.assure.assure.VerificationResultState
import java.util.List

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

	def void doProcess(CaseResult caseResult) {
		caseResult.claimResult.forEach[claimResult|claimResult.process]
		caseResult.subCaseResult.forEach[subcaseResult|subcaseResult.process]
	}

	def void doProcess(ClaimResult claimResult) {
		claimResult.verificationActivityResult.forEach[vaResult|vaResult.process]
		claimResult.subClaimResult.forEach[subclaimResult|subclaimResult.process]
	}

	def void doProcess(VerificationActivityResult vaResult) {
		vaResult.assumptionResult.forEach[assumptionResult|assumptionResult.process]
		vaResult.preconditionResult.forEach[preconditionResult|preconditionResult.process]
		dispatcher.runVerificationMethod( vaResult)
	}

	def void doProcess(FailThenResult vaResult) {
		vaResult.first.forEach[expr|expr.process]
		if (vaResult.first.hasFailedOrError) { 
			if (vaResult.recordFailThen) vaResult.propagateCountChangeUp
			vaResult.second.forEach[expr|expr.process]
		} else {
			if (vaResult.recordNoFailThen) vaResult.propagateCountChangeUp
		}
	}

	def void doProcess(AndThenResult vaResult) {
		vaResult.first.forEach[expr|expr.process]
		if (vaResult.first.isSuccessFul) {
			vaResult.second.forEach[expr|expr.process]
			if (vaResult.recordNoSkip) vaResult.propagateCountChangeUp
		} else {
			if(vaResult.recordSkip) vaResult.propagateCountChangeUp
		}
	}


	def void doProcess(AssumptionResult assumptionResult) {
		assumptionResult.verificationActivityResult.forEach[vaResult|vaResult.process]
	}

	def void doProcess(PreconditionResult preconditionResult) {
		preconditionResult.verificationActivityResult.forEach[vaResult|vaResult.process]
	}

	override void process(AssureResult assureResult) {
		switch (assureResult) {
			CaseResult: assureResult.doProcess
			ClaimResult: assureResult.doProcess
			VerificationActivityResult: assureResult.doProcess
			FailThenResult: assureResult.doProcess
			AndThenResult: assureResult.doProcess
			AssumptionResult: assureResult.doProcess
			PreconditionResult: assureResult.doProcess
		}
	}
	

}

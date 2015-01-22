package org.osate.assure.evaluator

import org.eclipse.emf.common.util.EList
import org.osate.assure.assure.AndThenResult
import org.osate.assure.assure.AssumptionResult
import org.osate.assure.assure.AssureResult
import org.osate.assure.assure.CaseResult
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.FailThenResult
import org.osate.assure.assure.HazardResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.VerificationActivityResult
import static extension org.osate.assure.util.AssureUtilExtension.*

class AssureEvaluator {

	def AssureResult evaluate(CaseResult caseResult) {
		caseResult.resetCounts
		caseResult.addAllEvaluate(caseResult.claimResult)
		caseResult.addAllEvaluate(caseResult.hazardResult)
		caseResult.addAllEvaluate(caseResult.subCaseResult)
	}

	def AssureResult evaluate(ClaimResult claimResult) {
		claimResult.resetCounts
		claimResult.addAllEvaluate(claimResult.verificationActivityResult)
		claimResult.addAllEvaluate(claimResult.subClaimResult)
	}

	def AssureResult evaluate(VerificationActivityResult vaResult) {
		vaResult.resetCounts
		vaResult.addAllEvaluate(vaResult.assumptionResult)
		vaResult.addAllEvaluate(vaResult.preconditionResult)
		vaResult.addOwnResult()
		vaResult
	}

	def AssureResult evaluate(FailThenResult vaResult) {
		vaResult.resetCounts
		vaResult.addAllEvaluate(vaResult.first)
		if (vaResult.hasFailedOrError){
			vaResult.resetCounts
			vaResult.addAllEvaluate(vaResult.second)
		}
	}

	def AssureResult evaluate(AndThenResult vaResult) {
		vaResult.resetCounts
		vaResult.addAllEvaluate(vaResult.first)
		vaResult.addAllEvaluate(vaResult.second)
	}

	def AssureResult evaluate(HazardResult hazardResult) {
		hazardResult.resetCounts
		hazardResult.addAllEvaluate(hazardResult.claimResult)
	}

	def AssureResult evaluate(AssumptionResult assumptionResult) {
		assumptionResult.resetCounts
		assumptionResult.addAllEvaluate(assumptionResult.verificationActivityResult)
	}

	def AssureResult evaluate(PreconditionResult preconditionResult) {
		preconditionResult.resetCounts
		preconditionResult.addAllEvaluate(preconditionResult.verificationActivityResult)
	}

	def AssureResult evaluate(AssureResult assureResult) {
		switch (assureResult) {
			CaseResult: assureResult.evaluate
			ClaimResult: assureResult.evaluate
			VerificationActivityResult: assureResult.evaluate
			FailThenResult: assureResult.evaluate
			AndThenResult: assureResult.evaluate
			HazardResult: assureResult.evaluate
			AssumptionResult: assureResult.evaluate
			PreconditionResult: assureResult.evaluate
		}
	}

	/*
	 * recursively evaluate and then add all sub element counts
	 */
	def AssureResult addAllEvaluate(AssureResult result, EList<? extends AssureResult> parts) {
		result.failCount = result.failCount + parts.map[evaluate.failCount].sum
		result.successCount = result.successCount + parts.map[evaluate.successCount].sum
		result.errorCount = result.errorCount + parts.map[evaluate.errorCount].sum
		result.failthenCount = result.failthenCount + parts.map[evaluate.failthenCount].sum
		result.skippedCount = result.skippedCount + parts.map[evaluate.skippedCount].sum
		return result
	}
	
}

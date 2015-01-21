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
import org.osate.assure.util.AssureUtilExtension

class AssureEvaluator {
	extension AssureUtilExtension aue  = new AssureUtilExtension

	def AssureResult evaluate(CaseResult caseResult) {
		caseResult.initialize
		caseResult.addAllEvaluate(caseResult.claimResult)
		caseResult.addAllEvaluate(caseResult.hazardResult)
		caseResult.addAllEvaluate(caseResult.subCaseResult)
	}

	def AssureResult evaluate(ClaimResult claimResult) {
		claimResult.initialize
		claimResult.addAllEvaluate(claimResult.verificationActivityResult)
		claimResult.addAllEvaluate(claimResult.subClaimResult)
	}

	def AssureResult evaluate(VerificationActivityResult vaResult) {
		vaResult.initialize
		vaResult.addAllEvaluate(vaResult.assumptionResult)
		vaResult.addAllEvaluate(vaResult.preconditionResult)
		vaResult.addOwnResult()
		vaResult
	}

	def AssureResult evaluate(FailThenResult vaResult) {
		vaResult.initialize
		vaResult.addAllEvaluate(vaResult.first)
		if (vaResult.hasFailedOrError){
			vaResult.initialize
			vaResult.addAllEvaluate(vaResult.second)
		}
	}

	def AssureResult evaluate(AndThenResult vaResult) {
		vaResult.initialize
		vaResult.addAllEvaluate(vaResult.first)
		vaResult.addAllEvaluate(vaResult.second)
	}

	def AssureResult evaluate(HazardResult hazardResult) {
		hazardResult.initialize
		hazardResult.addAllEvaluate(hazardResult.claimResult)
	}

	def AssureResult evaluate(AssumptionResult assumptionResult) {
		assumptionResult.initialize
		assumptionResult.addAllEvaluate(assumptionResult.verificationActivityResult)
	}

	def AssureResult evaluate(PreconditionResult preconditionResult) {
		preconditionResult.initialize
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
		result.failCount = result.failCount + parts.map[evaluate.failCount].reduce[a, b|a + b]
		result.successCount = result.successCount + parts.map[evaluate.successCount].reduce[a, b|a + b]
		result.errorCount = result.errorCount + parts.map[evaluate.errorCount].reduce[a, b|a + b]
		result.failthenCount = result.failthenCount + parts.map[evaluate.failthenCount].reduce[a, b|a + b]
		result.skippedCount = result.skippedCount + parts.map[evaluate.skippedCount].reduce[a, b|a + b]
		return result
	}
	
}

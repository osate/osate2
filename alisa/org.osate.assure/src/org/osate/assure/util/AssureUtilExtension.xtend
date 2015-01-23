package org.osate.assure.util

import java.util.Collections
import java.util.List
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.modelsupport.AadlConstants
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil
import org.osate.assure.assure.AssureResult
import org.osate.assure.assure.CaseResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.VerificationResult
import org.osate.assure.assure.VerificationResultState
import org.osate.verify.verify.RefExpr
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.HazardResult
import org.osate.assure.assure.AssumptionResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.FailThenResult
import org.osate.assure.assure.AndThenResult
import org.eclipse.emf.common.util.EList

class AssureUtilExtension {

	def static CaseResult getEnclosingCaseResult(EObject assureObject) {
		var result = assureObject
		while (!(result instanceof CaseResult)) {
			result = result.eContainer
		}
		if(result == null) return null
		return result as CaseResult
	}

	def static CaseResult getEnclosingClaimResult(EObject assureObject) {
		var result = assureObject
		while (!(result instanceof ClaimResult)) {
			result = result.eContainer
		}
		if(result == null) return null
		return result as CaseResult
	}

	def static InstanceObject getClaimSubject(EObject assureObject) {
		assureObject.enclosingClaimResult.instance ?: assureObject.claimSubject
	}

	def static InstanceObject getCaseSubject(EObject assureObject) {
		assureObject.enclosingCaseResult?.instance
	}

	def static void addErrorMarkers(VerificationActivityResult verificationActivityResult, InstanceObject instance,
		String markertype) {
		val res = instance.eResource
		val err = res.errors
		val mt = "org.osate.analysis.flows.FlowLatencyObjectMarker"
		val IResource irsrc = OsateResourceUtil.convertToIResource(res);
		val markersforanalysis = irsrc.findMarkers(mt, true, IResource.DEPTH_INFINITE) // analysisMarkerType
		val markers = markersforanalysis.filter [ IMarker m |
			m.getAttribute(AadlConstants.AADLURI) == EcoreUtil.getURI(instance).toString() &&
				m.getAttribute(IMarker.SEVERITY) == IMarker.SEVERITY_ERROR
		]

		//		markers.forEach[m|
		// first one only
		val m = markers.head
		val VerificationResult vr = verificationActivityResult.result //AssureFactory.eINSTANCE.createVerificationResult();
		vr.setResultState(VerificationResultState.FAIL);
		vr.setFailMsg(m.getAttribute(IMarker.MESSAGE) as String);
		vr.setType(markertype);
		verificationActivityResult.setResult(vr);

	//		]
	}

	def static void addSuccess(VerificationActivityResult verificationActivityResult) {
		verificationActivityResult.result.setResultState(VerificationResultState.SUCCESS);
	}

	def static void addFailure(VerificationActivityResult verificationActivityResult, Throwable e) {
		val VerificationResult res = verificationActivityResult.result //AssureFactory.eINSTANCE.createVerificationResult();
		res.setResultState(VerificationResultState.FAIL);
		res.setFailMsg(e.getMessage());
		res.setType(e.getClass().getName());
		verificationActivityResult.setResult(res);
	}

	def static void addError(VerificationActivityResult verificationActivityResult, Throwable e) {
		val VerificationResult res = verificationActivityResult.result

		//verificationActivityResult.setResult(AssureFactory.eINSTANCE.createVerificationResult());
		res.setResultState(VerificationResultState.ERROR);
		res.setFailMsg(e.getMessage());
		res.setType(e.getClass().getName());
	}

	def static int sum(List<Integer> l) {
		l.fold(0)[a, b|a + b] 
	}

	
	def static AssureResult addTo(AssureResult subresult, AssureResult result) {
		result.failCount = result.failCount + subresult.failCount
		result.successCount = result.successCount + subresult.successCount
		result.errorCount = result.errorCount + subresult.errorCount
		result.skippedCount = result.skippedCount + subresult.skippedCount
		result.failthenCount = result.failthenCount + subresult.failthenCount
		return result
	}

	def static void resetCounts(AssureResult result) {
		result.failCount = 0
		result.successCount = 0
		result.errorCount = 0
		result.skippedCount = 0
		result.failthenCount = 0
	}

	/**
	 * the total counts are (re)calculated with this method. 
	 * The other counts are not touched and can be updated 
	 * using process from Processor or evaluate from Evaluator
	 */
	def static AssureResult computeAndSetTotals(CaseResult caseResult) {
		caseResult.totalCount = 0
		caseResult.addAllTotals(caseResult.claimResult)
		caseResult.addAllTotals(caseResult.hazardResult)
		caseResult.addAllTotals(caseResult.subCaseResult)
	}

	def static AssureResult computeAndSetTotals(ClaimResult claimResult) {
		claimResult.totalCount = 0
		claimResult.addAllTotals(claimResult.verificationActivityResult)
		claimResult.addAllTotals(claimResult.subClaimResult)
	}

	def static AssureResult computeAndSetTotals(VerificationActivityResult vaResult) {
		vaResult.totalCount = 1 // count self 
		vaResult.addAllTotals(vaResult.assumptionResult)
		vaResult.addAllTotals(vaResult.preconditionResult)
		vaResult
	}

	def static AssureResult computeAndSetTotals(FailThenResult vaResult) {
		vaResult.totalCount = 0
		vaResult.addAllTotals(vaResult.first)
		vaResult.addAllTotals(vaResult.second)
	}

	def static AssureResult computeAndSetTotals(AndThenResult vaResult) {
		vaResult.totalCount = 0
		vaResult.addAllTotals(vaResult.first)
		vaResult.addAllTotals(vaResult.second)
	}

	def static AssureResult computeAndSetTotals(HazardResult hazardResult) {
		hazardResult.totalCount = 0
		hazardResult.addAllTotals(hazardResult.claimResult)
	}

	def static AssureResult computeAndSetTotals(AssumptionResult assumptionResult) {
		assumptionResult.totalCount = 0
		assumptionResult.addAllTotals(assumptionResult.verificationActivityResult)
	}

	def static AssureResult computeAndSetTotals(PreconditionResult preconditionResult) {
		preconditionResult.totalCount = 0
		preconditionResult.addAllTotals(preconditionResult.verificationActivityResult)
	}

	def static AssureResult computeAndSetTotals(AssureResult assureResult) {
		switch (assureResult) {
			CaseResult: assureResult.computeAndSetTotals
			ClaimResult: assureResult.computeAndSetTotals
			VerificationActivityResult: assureResult.computeAndSetTotals
			FailThenResult: assureResult.computeAndSetTotals
			AndThenResult: assureResult.computeAndSetTotals
			HazardResult: assureResult.computeAndSetTotals
			AssumptionResult: assureResult.computeAndSetTotals
			PreconditionResult: assureResult.computeAndSetTotals
		}
	}

	def static AssureResult addAllTotals(AssureResult result, EList<? extends AssureResult> parts) {
		parts.forEach[e|result.addToTotal(e.computeAndSetTotals.totalCount)]
		return result
	}
	def static void addToTotal (AssureResult result, int count){
		result.totalCount = result.totalCount + count
	}
/**
 * the next set of methods update the counts other than total count
 */
 
 
	def AssureResult computeAndSetCounts(CaseResult caseResult) {
		caseResult.resetCounts
		caseResult.computeAndAddAllCounts(caseResult.claimResult)
		caseResult.computeAndAddAllCounts(caseResult.hazardResult)
		caseResult.computeAndAddAllCounts(caseResult.subCaseResult)
	}

	def AssureResult computeAndSetCounts(ClaimResult claimResult) {
		claimResult.resetCounts
		claimResult.computeAndAddAllCounts(claimResult.verificationActivityResult)
		claimResult.computeAndAddAllCounts(claimResult.subClaimResult)
	}

	def AssureResult computeAndSetCounts(VerificationActivityResult vaResult) {
		vaResult.resetCounts
		vaResult.computeAndAddAllCounts(vaResult.assumptionResult)
		vaResult.computeAndAddAllCounts(vaResult.preconditionResult)
		vaResult.addOwnResult()
		vaResult
	}

	def AssureResult computeAndSetCounts(FailThenResult vaResult) {
		vaResult.resetCounts
		vaResult.computeAndAddAllCounts(vaResult.first)
		if (vaResult.hasFailedOrError){
			vaResult.resetCounts
			vaResult.computeAndAddAllCounts(vaResult.second)
		}
	}

	def AssureResult computeAndSetCounts(AndThenResult vaResult) {
		vaResult.resetCounts
		vaResult.computeAndAddAllCounts(vaResult.first)
		vaResult.computeAndAddAllCounts(vaResult.second)
	}

	def AssureResult computeAndSetCounts(HazardResult hazardResult) {
		hazardResult.resetCounts
		hazardResult.computeAndAddAllCounts(hazardResult.claimResult)
	}

	def AssureResult computeAndSetCounts(AssumptionResult assumptionResult) {
		assumptionResult.resetCounts
		assumptionResult.computeAndAddAllCounts(assumptionResult.verificationActivityResult)
	}

	def AssureResult computeAndSetCounts(PreconditionResult preconditionResult) {
		preconditionResult.resetCounts
		preconditionResult.computeAndAddAllCounts(preconditionResult.verificationActivityResult)
	}

	def AssureResult computeAndSetCounts(AssureResult assureResult) {
		switch (assureResult) {
			CaseResult: assureResult.computeAndSetCounts
			ClaimResult: assureResult.computeAndSetCounts
			VerificationActivityResult: assureResult.computeAndSetCounts
			FailThenResult: assureResult.computeAndSetCounts
			AndThenResult: assureResult.computeAndSetCounts
			HazardResult: assureResult.computeAndSetCounts
			AssumptionResult: assureResult.computeAndSetCounts
			PreconditionResult: assureResult.computeAndSetCounts
		}
	}

	/*
	 * recursively compute and then add all sub element counts but total count
	 */
	def AssureResult computeAndAddAllCounts(AssureResult result, EList<? extends AssureResult> parts) {
		parts.forEach[e|e.computeAndSetCounts.addTo(result)]
		return result
	}
 
 /**
  * the next methods update the counts for FailThen and AndThen
  */
	def static FailThenResult recordFailThen(FailThenResult result) {
		result.failthenCount = result.failCount + result.errorCount
		result.failCount = 0
		result.errorCount = 0
		result
	}

	def static AndThenResult recordSkip(AndThenResult result) {
		result.skippedCount = result.second.map[exp|exp.totalCount].sum
		result
	}

	def static VerificationActivityResult addOwnResult(VerificationActivityResult ar) {
		switch (ar.result.resultState) {
			case VerificationResultState.SUCCESS:
				ar.successCount = ar.successCount + 1
			case VerificationResultState.FAIL:
				ar.failCount = ar.failCount + 1
			case VerificationResultState.ERROR:
				ar.errorCount = ar.errorCount + 1
			case VerificationResultState.TBD: {
			} // calculated from the others
		}
		ar
	}

	def static AssureResult addAllCounts(AssureResult result,List<? extends AssureResult> parts) {
		parts.forEach[e|e.addTo(result)]
		return result
	}
 
	def static AssureResult addAllCounts(CaseResult caseResult) {
		caseResult.resetCounts
		caseResult.addAllCounts(caseResult.claimResult)
		caseResult.addAllCounts(caseResult.hazardResult)
		caseResult.addAllCounts(caseResult.subCaseResult)
	}

	def static AssureResult addAllCounts(ClaimResult claimResult) {
		claimResult.resetCounts
		claimResult.addAllCounts(claimResult.verificationActivityResult)
		claimResult.addAllCounts(claimResult.subClaimResult)
	}

	def static AssureResult addAllCounts(VerificationActivityResult vaResult) {
		vaResult.resetCounts
		vaResult.addAllCounts(vaResult.assumptionResult)
		vaResult.addAllCounts(vaResult.preconditionResult)
		vaResult.addOwnResult()
		vaResult
	}

	def static AssureResult addAllCounts(FailThenResult vaResult) {
		vaResult.resetCounts
		vaResult.addAllCounts(vaResult.first)
		if (vaResult.hasFailedOrError){
			vaResult.resetCounts
			vaResult.addAllCounts(vaResult.second)
		}
	}

	def static AssureResult addAllCounts(AndThenResult vaResult) {
		vaResult.resetCounts
		vaResult.addAllCounts(vaResult.first)
		vaResult.addAllCounts(vaResult.second)
	}

	def static AssureResult addAllCounts(HazardResult hazardResult) {
		hazardResult.resetCounts
		hazardResult.addAllCounts(hazardResult.claimResult)
	}

	def static AssureResult addAllCounts(AssumptionResult assumptionResult) {
		assumptionResult.resetCounts
		assumptionResult.addAllCounts(assumptionResult.verificationActivityResult)
	}

	def static AssureResult addAllCounts(PreconditionResult preconditionResult) {
		preconditionResult.resetCounts
		preconditionResult.addAllCounts(preconditionResult.verificationActivityResult)
	}

	def static AssureResult addAllCounts(AssureResult assureResult) {
		switch (assureResult) {
			CaseResult: assureResult.addAllCounts
			ClaimResult: assureResult.addAllCounts
			VerificationActivityResult: assureResult.addAllCounts
			FailThenResult: assureResult.addAllCounts
			AndThenResult: assureResult.addAllCounts
			HazardResult: assureResult.addAllCounts
			AssumptionResult: assureResult.addAllCounts
			PreconditionResult: assureResult.addAllCounts
		}
	}

	
	def static VerificationActivityResult addOwnResultAndRecomputeUp(VerificationActivityResult ar) {
		ar.addOwnResult
		var parent = ar.eContainer 
		while (parent != null && parent instanceof AssureResult){
			 val parentResult = (parent as AssureResult)
			 parentResult.addAllCounts
		}
		null
	}

	def static int countElements(AssureResult ar) {
		switch (ar) {
			CaseResult: ar.subCaseResult.length + ar.claimResult.length + ar.hazardResult.length
			ClaimResult: ar.subClaimResult.length + ar.verificationActivityResult.length
			HazardResult: ar.claimResult.length
			AssumptionResult: ar.verificationActivityResult.length
			PreconditionResult: ar.verificationActivityResult.length
			VerificationActivityResult: 1 + ar.assumptionResult.length + ar.preconditionResult.length
			FailThenResult: ar.first.length + ar.second.length
			AndThenResult: ar.first.length + ar.second.length
		}
		0
	}

	def static int getTBDCount(AssureResult ar) {
		ar.totalCount - ar.successCount - ar.failCount - ar.errorCount - ar.failthenCount - ar.skippedCount
	}

	def static boolean isSuccessFul(AssureResult ar) {
		ar.failCount == 0 && ar.errorCount == 0
	}

	def static boolean hasFailedOrError(AssureResult ar) {
		ar.failCount > 0 || ar.errorCount > 0
	}

	def static getTheWeight(RefExpr expr) {
		switch expr {
			case expr.weight == 0: 1
			default: expr.weight
		}
	}

	def static String getNamePath(AssureResult ar) {
		if (ar.eContainer == null) {
			return ar.printableName
		} else {
			return (ar.eContainer as AssureResult).namePath + "." + ar.printableName
		}
	}

	def static getPrintableName(AssureResult ar) {
		switch (ar) {
			CaseResult: return ar.name
			ClaimResult: return ar.name
			VerificationActivityResult: return ar.name
			AssumptionResult: return ar.name
			PreconditionResult: return ar.name
			HazardResult: return ar.name
			FailThenResult: return "FailThen"
			AndThenResult: return "AndThen"
		}
	}

	static val hasRunRecord = Collections.synchronizedMap(newHashMap)

	def static boolean hasRun(String analysisID, EObject target) {
		try {
			hasRunRecord.put(analysisID, target) ?: runme(analysisID, target)
		} catch (Exception e) {
			hasRunRecord.remove(analysisID)
			return false
		}
		return true
	}

	def static void clearHasRunRecords() {
		hasRunRecord.clear
	}

	def static EObject runme(String analysisID, EObject eo) {
		return eo
	}

}

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
import org.osate.assure.assure.AssumptionResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.FailThenResult
import org.osate.assure.assure.AndThenResult
import org.eclipse.emf.common.util.EList
import org.osate.assure.assure.VerificationExpr

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
	

	
	def static getTotalCount(AssureResult ar){
		ar.errorCount + ar.failCount + ar.successCount + ar.tbdCount + ar.failthenCount + ar.andthenCount
	}

	/**
	 * true iff none of the elements have a fail or error
	 */
	def static boolean isSuccessFul(EList<VerificationExpr> vel) {
		for ( ar : vel) if (ar.failCount != 0 || ar.errorCount != 0) return false
		return true
	}

	/**
	 * true iff at least one has a non-zero fail or error count
	 */
	def static boolean hasFailedOrError(EList<VerificationExpr> vel) {
		for ( ar : vel) if (ar.failCount != 0 || ar.errorCount != 0) return true
		return false
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
	
	/************************
	 * methods to deal with assurance case instance
	 */
	
		/**
	 * this next set of methods recomputes all the counts from the VerificationActivityResult states bottom up for the whole hierarchy 
	 * Only the top method should be called
	 * This method is useful when counts are messed up but the state is ok.
	 */
	 
	 	/** Helper methods */

	private def static void resetCounts(AssureResult result) {
		result.failCount = 0
		result.successCount = 0
		result.errorCount = 0
		result.andthenCount = 0
		result.failthenCount = 0
		result.tbdCount = 0
	}

	/**
	 * update the counts to reflect existing own status
	 * Used by complete process and set result
	 */
	private def static addOwnResultStateToCount(VerificationActivityResult ar) {
		switch (ar.result.resultState) {
			case VerificationResultState.SUCCESS: ar.successCount = ar.successCount + 1
			case VerificationResultState.FAIL:
				ar.failCount = ar.failCount + 1
			case VerificationResultState.ERROR:
				ar.errorCount = ar.errorCount + 1
			case VerificationResultState.TBD: 
				ar.tbdCount = ar.tbdCount + 1
		}
		ar
	}
	/**
	 * add all but the total count to the result object
	 * This method is used in the process and set result methods
	 */
	private def static void addTo(AssureResult subresult, AssureResult result) {
		result.failCount = result.failCount + subresult.failCount
		result.successCount = result.successCount + subresult.successCount
		result.errorCount = result.errorCount + subresult.errorCount
		result.andthenCount = result.andthenCount + subresult.andthenCount
		result.failthenCount = result.failthenCount + subresult.failthenCount
		result.tbdCount = result.tbdCount + subresult.tbdCount
	}
	
	/**
	 * recompute and add the counts of the parts list to the result
	 */
	private def static void recomputeAllCounts(AssureResult result, List<? extends AssureResult> parts) {
		parts.forEach[e|e.recomputeAllCounts.addTo(result)]
	}

	 
	 
	def static CaseResult recomputeAllCounts(CaseResult caseResult) {
		caseResult.resetCounts
		caseResult.recomputeAllCounts(caseResult.claimResult)
		caseResult.recomputeAllCounts(caseResult.subCaseResult)
		caseResult
	}
	private def static ClaimResult recomputeAllCounts(ClaimResult claimResult) {
		claimResult.resetCounts
		claimResult.recomputeAllCounts(claimResult.verificationActivityResult)
		claimResult.recomputeAllCounts(claimResult.subClaimResult)
		claimResult
	}

	private def static VerificationActivityResult recomputeAllCounts(VerificationActivityResult vaResult) {
		vaResult.resetCounts
		vaResult.recomputeAllCounts(vaResult.assumptionResult)
		vaResult.recomputeAllCounts(vaResult.preconditionResult)
		vaResult.addOwnResultStateToCount()
		vaResult
	}

	private def static FailThenResult recomputeAllCounts(FailThenResult vaResult) {
		vaResult.resetCounts
		vaResult.recomputeAllCounts(vaResult.first)
		if (vaResult.first.hasFailedOrError) {
			vaResult.recordFailThen
			vaResult.recomputeAllCounts(vaResult.second)
		} else {
			vaResult.recordNoFailThen
		}
		vaResult
	}
	

	private def static AndThenResult recomputeAllCounts(AndThenResult vaResult) {
		vaResult.resetCounts
		vaResult.recomputeAllCounts(vaResult.first)
		if (vaResult.first.isSuccessFul) {
			vaResult.recordSkip
			vaResult.recomputeAllCounts(vaResult.second)
		} else {
			vaResult.recordNoSkip
		}
		vaResult
	}

	private def static AssumptionResult recomputeAllCounts(AssumptionResult assumptionResult) {
		assumptionResult.resetCounts
		assumptionResult.recomputeAllCounts(assumptionResult.verificationActivityResult)
		assumptionResult
	}

	private def static PreconditionResult recomputeAllCounts(PreconditionResult preconditionResult) {
		preconditionResult.resetCounts
		preconditionResult.recomputeAllCounts(preconditionResult.verificationActivityResult)
		preconditionResult
	}

	private def static AssureResult recomputeAllCounts(AssureResult assureResult) {
		switch (assureResult) {
			CaseResult: assureResult.recomputeAllCounts
			ClaimResult: assureResult.recomputeAllCounts
			VerificationActivityResult: assureResult.recomputeAllCounts
			FailThenResult: assureResult.recomputeAllCounts
			AndThenResult: assureResult.recomputeAllCounts
			AssumptionResult: assureResult.recomputeAllCounts
			PreconditionResult: assureResult.recomputeAllCounts
		}
	}
	
	
	/**
	 * methods to incrementally set the state of a verification activity and propagate the state change
	 * up the hierarchy
	 */
	 
	def static void setToSuccess(VerificationActivityResult verificationActivityResult) {
		verificationActivityResult.updateOwnResultState(VerificationResultState.SUCCESS).propagateCountChangeUp
	}

	def static void setToTBD(VerificationActivityResult verificationActivityResult) {
		verificationActivityResult.updateOwnResultState(VerificationResultState.TBD).propagateCountChangeUp
	}

	def static void setToFail(VerificationActivityResult verificationActivityResult, Throwable e) {
		verificationActivityResult.result.setFailMsg(e.getMessage());
		verificationActivityResult.result.setType(e.getClass().getName());
		verificationActivityResult.updateOwnResultState(VerificationResultState.FAIL).propagateCountChangeUp
	}

	def static void setToError(VerificationActivityResult verificationActivityResult, Throwable e) {
		verificationActivityResult.result.setFailMsg(e.getMessage());
		verificationActivityResult.result.setType(e.getClass().getName());
		verificationActivityResult.updateOwnResultState(VerificationResultState.FAIL).propagateCountChangeUp
	}

	/**
  * the next methods update the counts for FailThen and AndThen
  * returns true if change of state
  */
	def static boolean recordFailThen(FailThenResult result) {
		if (result.didFailThenFail){
			// was didthen from previous time
			return false
		} else {
			result.didFailThenFail = true
			result.failthenCount = result.failthenCount + 1
			return true
		}
	}

	/**
  * the next methods update the counts for FailThen and AndThen
  * returns true if change of state
  */
	def static boolean recordNoFailThen(FailThenResult result) {
		if (result.didFailThenFail){
			result.didFailThenFail = false
			result.failthenCount = result.failthenCount - 1
			return true
		} else {
			// was already no didThen
			return false
		}
	}

	/**
  * the next methods update the counts for FailThen and AndThen
  * returns true if change of state
  */
	def static boolean recordSkip(AndThenResult result) {
		if (result.didAndThenFail){
			// was didAndThenFail from previous time
			return false
		} else {
			result.didAndThenFail = true
			result.andthenCount = result.andthenCount + 1
			return true
		}
	}

	/**
  * the next methods update the counts for FailThen and AndThen
  * returns true if change of state
  */
	def static boolean recordNoSkip(AndThenResult result) {
		if (result.didAndThenFail){
			result.didAndThenFail = false
			result.andthenCount = result.andthenCount - 1
			return true
		} else {
			// was already no didThen
			return false
		}
	}
	
		/**
	 * set the status and update the counts
	 */
	def private static VerificationActivityResult updateOwnResultState(VerificationActivityResult ar,
		VerificationResultState newState) {
		if (ar.result.resultState == VerificationResultState.TBD){
			ar.tbdCount = ar.tbdCount - 1
			switch (newState) {
			case VerificationResultState.SUCCESS: 
				ar.successCount = ar.successCount + 1
			case VerificationResultState.FAIL:
				ar.failCount = ar.failCount + 1
			case VerificationResultState.ERROR:
				ar.errorCount = ar.errorCount + 1
			case VerificationResultState.TBD: {}
			}
		} else if (newState == VerificationResultState.TBD){
			ar.tbdCount = ar.tbdCount + 1
		  	switch (ar.result.resultState) {
			case VerificationResultState.SUCCESS: 
				ar.successCount = ar.successCount - 1
			case VerificationResultState.FAIL:
				ar.failCount = ar.failCount - 1
			case VerificationResultState.ERROR:
				ar.errorCount = ar.errorCount - 1
			case VerificationResultState.TBD: 
				ar.tbdCount = ar.tbdCount - 1
		    }
		} else {
				// should not occur or only when setting multiple error or fail messages
		}
		ar.result.resultState = newState
		ar
	}
	
	/**
	 * Given the state (and count) change to ar, propagate the counts up the hierarchy
	 */
	def static void propagateCountChangeUp(AssureResult ar) {
		var parent = ar.eContainer
		while (parent != null && parent instanceof AssureResult) {
			val parentResult = (parent as AssureResult)
			parentResult.addAllSubCounts() 
			parent = parent.eContainer
		}
	}
	
	/**
	 * recompute the result count from the part list counts without recursing
	 */
	private def static void addAllSubCounts(AssureResult result, List<? extends AssureResult> parts) {
		parts.forEach[e|e.addTo(result)]
	}

	 
	 
	private def static CaseResult addAllSubCounts(CaseResult caseResult) {
		caseResult.resetCounts
		caseResult.addAllSubCounts(caseResult.claimResult)
		caseResult.addAllSubCounts(caseResult.subCaseResult)
		caseResult
	}
	private def static ClaimResult addAllSubCounts(ClaimResult claimResult) {
		claimResult.resetCounts
		claimResult.addAllSubCounts(claimResult.verificationActivityResult)
		claimResult.addAllSubCounts(claimResult.subClaimResult)
		claimResult
	}

	private def static VerificationActivityResult addAllSubCounts(VerificationActivityResult vaResult) {
		vaResult.resetCounts
		vaResult.addAllSubCounts(vaResult.assumptionResult)
		vaResult.addAllSubCounts(vaResult.preconditionResult)
		vaResult.addOwnResultStateToCount()
		vaResult
	}

	private def static FailThenResult addAllSubCounts(FailThenResult vaResult) {
		vaResult.resetCounts
		vaResult.addAllSubCounts(vaResult.first)
		if (vaResult.first.hasFailedOrError) {
			vaResult.recordFailThen
			vaResult.addAllSubCounts(vaResult.second)
		} else {
			vaResult.recordNoFailThen
		}
		vaResult
	}

	private def static AndThenResult addAllSubCounts(AndThenResult vaResult) {
		vaResult.resetCounts
		vaResult.addAllSubCounts(vaResult.first)
		if (vaResult.first.isSuccessFul) {
			vaResult.recordSkip
			vaResult.addAllSubCounts(vaResult.second)
		} else {
			vaResult.recordNoSkip
		}
		vaResult
	}

	private def static AssumptionResult addAllSubCounts(AssumptionResult assumptionResult) {
		assumptionResult.resetCounts
		assumptionResult.addAllSubCounts(assumptionResult.verificationActivityResult)
		assumptionResult
	}

	private def static PreconditionResult addAllSubCounts(PreconditionResult preconditionResult) {
		preconditionResult.resetCounts
		preconditionResult.addAllSubCounts(preconditionResult.verificationActivityResult)
		preconditionResult
	}

	private def static AssureResult addAllSubCounts(AssureResult assureResult) {
		switch (assureResult) {
			CaseResult: assureResult.addAllSubCounts
			ClaimResult: assureResult.addAllSubCounts
			VerificationActivityResult: assureResult.addAllSubCounts
			FailThenResult: assureResult.addAllSubCounts
			AndThenResult: assureResult.addAllSubCounts
			AssumptionResult: assureResult.addAllSubCounts
			PreconditionResult: assureResult.addAllSubCounts
		}
	}
	 

}

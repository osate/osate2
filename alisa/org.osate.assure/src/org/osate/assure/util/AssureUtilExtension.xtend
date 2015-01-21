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
import org.osate.assure.assure.VerificationExpr
import org.osate.assure.assure.FailThenResult
import org.osate.assure.assure.AndThenResult

class AssureUtilExtension {

	def CaseResult getEnclosingCaseResult(EObject assureObject) {
		var result = assureObject
		while (!(result instanceof CaseResult)) {
			result = result.eContainer
		}
		if(result == null) return null
		return result as CaseResult
	}
	
	def InstanceObject getCaseSubject(EObject assureObject) {
		val context = assureObject.enclosingCaseResult
		if(context == null) return null
		return context.instance
	}

	def void addErrorMarkers(VerificationActivityResult verificationActivityResult,InstanceObject instance, String markertype) {
		val res = instance.eResource
		val err = res.errors
		val mt = "org.osate.analysis.flows.FlowLatencyObjectMarker"
		val IResource irsrc = OsateResourceUtil.convertToIResource(res);
		val markersforanalysis = irsrc.findMarkers(mt, true, IResource.DEPTH_INFINITE) // analysisMarkerType
		val markers = markersforanalysis.filter[IMarker m|
			m.getAttribute(AadlConstants.AADLURI) == EcoreUtil.getURI(instance).toString() &&
			m.getAttribute(IMarker.SEVERITY) == IMarker.SEVERITY_ERROR
		]
//		markers.forEach[m|
// first one only
		val m = markers.head
		val VerificationResult vr = verificationActivityResult.result//AssureFactory.eINSTANCE.createVerificationResult();
		vr.setResultState(VerificationResultState.FAIL);
		vr.setFailMsg(m.getAttribute(IMarker.MESSAGE) as String);
		vr.setType(markertype);
		verificationActivityResult.setResult(vr);
//		]
	}

	def void addFailure(VerificationActivityResult verificationActivityResult, Throwable e) {
		val VerificationResult res = verificationActivityResult.result //AssureFactory.eINSTANCE.createVerificationResult();
		res.setResultState(VerificationResultState.FAIL);
		res.setFailMsg(e.getMessage());
		res.setType(e.getClass().getName());
		verificationActivityResult.setResult(res);
	}

	def void addError(VerificationActivityResult verificationActivityResult, Throwable e) {
		val VerificationResult res = verificationActivityResult.result
		//verificationActivityResult.setResult(AssureFactory.eINSTANCE.createVerificationResult());
		res.setResultState(VerificationResultState.ERROR);
		res.setFailMsg(e.getMessage());
		res.setType(e.getClass().getName());
	}
	
	def int sum(List<Integer> l){
		l.reduce[a,b|a + b]?:0
	}

	/**
	 * add all subelement counts without reevaluating them
	 */
	def AssureResult addAllTo(List<? extends AssureResult> parts,AssureResult result) {
		result.failCount = result.failCount + parts.map[failCount].sum
		result.successCount = result.successCount + parts.map[successCount].sum
		result.errorCount = result.errorCount + parts.map[errorCount].sum
		result.skippedCount = result.skippedCount + parts.map[skippedCount].sum
		result.failthenCount = result.failthenCount + parts.map[failthenCount].sum
		result.totalCount = result.totalCount + parts.map[totalCount].sum
		return result
	}


	def void initialize(AssureResult result) {
		result.failCount = 0
		result.successCount = 0
		result.errorCount = 0
		result.skippedCount = 0
		result.failthenCount = 0
		result.totalCount = result.countElements
	}
	
	def FailThenResult recordFailThen(FailThenResult result){
		result.failthenCount = result.failCount + result.errorCount
		result.failCount = 0
		result.errorCount = 0
		result
	}
	
	def AndThenResult recordSkip(AndThenResult result){
		result.skippedCount = result.second.map[exp| exp.totalCount].reduce[a,b|a+b]
		result
	}

	def VerificationActivityResult addOwnResult(VerificationActivityResult ar) {
		switch (ar.result.resultState) {
			case VerificationResultState.SUCCESS: ar.successCount = ar.successCount + 1
			case VerificationResultState.FAIL: ar.failCount = ar.failCount + 1
			case VerificationResultState.ERROR: ar.errorCount = ar.errorCount + 1
			case VerificationResultState.TBD: {}
		}
		ar
	}
	
	def int countElements(AssureResult ar){
		switch (ar){
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
	
	def int getTBDCount(AssureResult ar){
		ar.totalCount - ar.successCount - ar.failCount - ar.errorCount - ar.failthenCount - ar.skippedCount 
	}
	
	def boolean isSuccessFul(AssureResult ar){
		ar.failCount == 0 && ar.errorCount == 0 
	}
	
	def boolean hasFailedOrError(AssureResult ar){
		ar.failCount > 0 || ar.errorCount > 0
	}

	def getTheWeight(RefExpr expr) {
		switch expr {
			case expr.weight == 0: 1
			default: expr.weight
		}
	}
	
	static val hasRunRecord = Collections.synchronizedMap(newHashMap)
	
	def static boolean hasRun(String analysisID, EObject target){
		try {
			hasRunRecord.put(analysisID, target)?:runme(analysisID,target)
			} catch (Exception e) {
				hasRunRecord.remove(analysisID)
				return false
			}
		return true
	}
	
	def static void clearHasRunRecords(){
		hasRunRecord.clear
	}
	
	def static EObject runme(String analysisID,EObject eo){
		return eo
	}

}

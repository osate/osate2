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
import org.osate.assure.assure.VerificationResultState
import org.osate.verify.verify.RefExpr
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.AssumptionResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.FailThenResult
import org.osate.assure.assure.AndThenResult
import org.eclipse.emf.common.util.EList
import org.osate.assure.assure.VerificationExpr
import org.osate.assure.assure.ResultIssue
import org.osate.assure.assure.AssureFactory
import org.osate.assure.assure.ResultIssueType
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.EcoreUtil2
import java.util.Map
import java.util.SortedSet
import org.osate.aadl2.NamedElement
import java.util.HashMap
import com.rockwellcollins.atc.resolute.analysis.execution.FeatureToConnectionsMap
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.ComponentCategory
import java.util.TreeSet
import com.rockwellcollins.atc.resolute.analysis.execution.NamedElementComparator
import org.osate.aadl2.instance.ConnectionInstance
import com.rockwellcollins.atc.resolute.validation.BaseType;

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
	
	def static getMethodName(VerificationActivityResult vr){
		val methodpath = vr.target.method.methodPath
		val methodName = methodpath.substring(methodpath.lastIndexOf("."))   
		methodName
	}
	
	/**
	 * methods to process results from verificaiton methods
	 */

	def static boolean addErrorMarkers(VerificationActivityResult verificationActivityResult, InstanceObject instance,
		String markertype) {
		val res = instance.eResource
		val IResource irsrc = OsateResourceUtil.convertToIResource(res);
		val markersforanalysis = irsrc.findMarkers(markertype, true, IResource.DEPTH_INFINITE) // analysisMarkerType
		val markers = markersforanalysis.filter [ IMarker m |
			m.getAttribute(AadlConstants.AADLURI) == EcoreUtil.getURI(instance).toString() &&
				m.getAttribute(IMarker.SEVERITY) == IMarker.SEVERITY_ERROR
		]
		if (markers.isEmpty) return false
		markers.forEach[em|verificationActivityResult.addErrorIssue(instance, em.getAttribute(IMarker.MESSAGE) as String)]
		return true
	}

	def static boolean addAllErrorMarkers(VerificationActivityResult verificationActivityResult,InstanceObject instance,String markertype) {
		val res = instance.eResource
		val IResource irsrc = OsateResourceUtil.convertToIResource(res);
		val markersforanalysis = irsrc.findMarkers(markertype, true, IResource.DEPTH_INFINITE) // analysisMarkerType
		val markers = markersforanalysis.filter [ IMarker m |
				m.getAttribute(IMarker.SEVERITY) == IMarker.SEVERITY_ERROR
		]
		if (markers.isEmpty) return false
		markers.forEach[em|verificationActivityResult.addErrorIssue(instance, em.getAttribute(IMarker.MESSAGE) as String)]
		return true
	}

	def static void addErrorDiagnostics(VerificationActivityResult verificationActivityResult, InstanceObject instance,
		String markertype) {
		val res = instance.eResource
		val diagnosticErrors = res.errors 
		val mt = "org.osate.analysis.flows.FlowLatencyObjectMarker"
//		val filtered = diagnosticErrors.map[diag| diag.message]
//		val Diagnostic de = diagnosticErrors.head
//		val x = de
	}
  def void handleXtextIssues(){
  	// Xtext issues. Collected as FluentIssueCollection which also allows messages to be included.
//  	assertConstraints(
//  issues.errorsOnly()
//        .inLine(1)
//        .under(Modul.class, "person")
//        .named("name")
//        .oneOfThemContains("missing display name")
	}
	
	
	
	def static ResultIssue addErrorIssue(VerificationActivityResult vr, EObject target, String message){
		val issue = AssureFactory.eINSTANCE.createResultIssue
		vr.updateOwnResultState(VerificationResultState.FAIL);
		issue.message = message
		issue.issueType = ResultIssueType.ERROR;
		issue.target = target
		vr.issues.add(issue)
		issue
	}
	
	
	def static ResultIssue addErrorIssue(VerificationActivityResult vr, EObject target, String message, String exceptionType){
		val issue = vr.addErrorIssue(target, message)
		issue.exceptionType = exceptionType
		issue
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
	
	
	static var Map<String, SortedSet<NamedElement>> sets 
	static var FeatureToConnectionsMap featToConnsMap 
	
	def static FeatureToConnectionsMap getFeatToConnsMap(){
		return featToConnsMap
	}
	
	def static Map<String, SortedSet<NamedElement>> getSets(){
		return sets
	}

	def static void initializeResolute(SystemInstance si){
		sets = new HashMap<String, SortedSet<NamedElement>>()
		si.initializeSets(sets);
		featToConnsMap = new FeatureToConnectionsMap(si);
	}

	def private static void initializeSets(ComponentInstance ci, Map<String, SortedSet<NamedElement>> sets) {
		if (ci == null) {
			return;
		}

		addToSet(sets, getCategoryName(ci.getCategory()), ci);
		addToSet(sets, "component", ci);

		for (ComponentInstance sub : ci.getComponentInstances()) {
			initializeSets(sub, sets);
		}

		for (ConnectionInstance conn : ci.getConnectionInstances()) {
			addToSet(sets, "connection", conn);
		}
	}

	def private static String getCategoryName(ComponentCategory category) {
		return new BaseType(category).toString();
	}

	def private static void addToSet(Map<String, SortedSet<NamedElement>> sets, String name, NamedElement ne) {
		var SortedSet<NamedElement> set = sets.get(name);
		if (set == null) {
			set = new TreeSet<NamedElement>(new NamedElementComparator());
			sets.put(name, set);
		}
		set.add(ne);
	}
	
	/************************
	 * methods to deal with assurance case instance
	 */
	 
	 /**
	  * this method resets the execution state of all verification activities to TBD
	  */
	  def static void resetToTBD(CaseResult root){
	  	val vrlist = EcoreUtil2.eAllOfType(root,VerificationActivityResult)
	  	vrlist.forEach[vr | vr.resultState = VerificationResultState.TBD]
	  }
	
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
		switch (ar.resultState) {
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
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.SUCCESS)) verificationActivityResult.propagateCountChangeUp
	}

	def static void setToTBD(VerificationActivityResult verificationActivityResult) {
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.TBD))verificationActivityResult.propagateCountChangeUp
	}

	def static void setToFail(VerificationActivityResult verificationActivityResult, String message) {
		verificationActivityResult.addErrorIssue(null,message,null);
		if(verificationActivityResult.updateOwnResultState(VerificationResultState.FAIL)) verificationActivityResult.propagateCountChangeUp
	}

	def static void setToFail(VerificationActivityResult verificationActivityResult, EObject target, String message) {
		verificationActivityResult.addErrorIssue(target,message,null);
		if(verificationActivityResult.updateOwnResultState(VerificationResultState.FAIL)) verificationActivityResult.propagateCountChangeUp
	}

	def static void setToFail(VerificationActivityResult verificationActivityResult, Throwable e) {
		verificationActivityResult.addErrorIssue(null,e.getMessage(),e.getClass().getName());
		if(verificationActivityResult.updateOwnResultState(VerificationResultState.FAIL)) verificationActivityResult.propagateCountChangeUp
	}

	def static void setToError(VerificationActivityResult verificationActivityResult, Throwable e) {
		verificationActivityResult.addErrorIssue(null,e.getMessage(),e.getClass().getName());
		if(verificationActivityResult.updateOwnResultState(VerificationResultState.FAIL))verificationActivityResult.propagateCountChangeUp
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
	 * true if state changed
	 */
	def private static boolean updateOwnResultState(VerificationActivityResult ar,
		VerificationResultState newState) {
		if (ar.resultState == newState)return false
		if (ar.resultState == VerificationResultState.TBD){
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
		  	switch (ar.resultState) {
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
		ar.resultState = newState
		true
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

package org.osate.assure.util

import com.rockwellcollins.atc.resolute.analysis.execution.FeatureToConnectionsMap
import com.rockwellcollins.atc.resolute.analysis.execution.NamedElementComparator
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult
import com.rockwellcollins.atc.resolute.analysis.views.ResoluteResultContentProvider
import com.rockwellcollins.atc.resolute.resolute.FailExpr
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition
import com.rockwellcollins.atc.resolute.validation.BaseType
import java.util.Collections
import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.SortedSet
import java.util.TreeSet
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.osate.aadl2.ComponentCategory
import org.osate.aadl2.NamedElement
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.modelsupport.AadlConstants
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil
import org.osate.assure.assure.AndThenResult
import org.osate.assure.assure.AssureFactory
import org.osate.assure.assure.AssureResult
import org.osate.assure.assure.AssuranceEvidence
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.FailThenResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.ResultIssue
import org.osate.assure.assure.ResultIssueType
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.VerificationExecutionState
import org.osate.assure.assure.VerificationExpr
import org.osate.assure.assure.VerificationResultState
import org.osate.verify.verify.RefExpr

import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import org.osate.assure.assure.VerificationResult
import org.osate.verify.verify.VerificationMethod
import org.osate.verify.verify.SupportedScopes
import org.osate.verify.verify.SupportedReporting

class AssureUtilExtension {

	def static AssuranceEvidence getEnclosingAssuranceEvidence(EObject assureObject) {
		var result = assureObject
		while (!(result instanceof AssuranceEvidence)) {
			result = result.eContainer
		}
		if(result == null) return null
		return result as AssuranceEvidence
	}

	def static ClaimResult getEnclosingClaimResult(EObject assureObject) {
		var result = assureObject
		while (!(result instanceof ClaimResult)) {
			result = result.eContainer
		}
		if(result == null) return null
		return result as ClaimResult
	}

	def static InstanceObject getClaimSubject(EObject assureObject) {
		assureObject.enclosingClaimResult.instance ?: assureObject.caseSubject
	}

	def static InstanceObject getCaseSubject(EObject assureObject) {
		assureObject.enclosingAssuranceEvidence?.instance
	}
	
	def static VerificationMethod getMethod(VerificationResult vr){
		switch(vr){
			VerificationActivityResult: return vr.target.method
			PreconditionResult: return vr.target.method
			ValidationResult: return vr.target.method
		}
	}


	/**
	 * methods to process results from verification methods
	 */
	def static boolean addMarkers(VerificationResult verificationActivityResult, InstanceObject instance,
		String markertype, VerificationMethod vm) {
		val scope = vm.scope 
		val reporting = vm.reporting
		val res = instance.eResource
		val IResource irsrc = OsateResourceUtil.convertToIResource(res);
		val markersforanalysis = irsrc.findMarkers(markertype, true, IResource.DEPTH_INFINITE) // analysisMarkerType
		val markers = markersforanalysis.filter [ IMarker m |
			// filter on Error
				(reporting == null || reporting == SupportedReporting.MARKER || m.getAttribute(IMarker.SEVERITY) == IMarker.SEVERITY_ERROR)
		]
		if(markers.isEmpty) return false
		var Iterable<IMarker> finalmarkers = null
		if (scope == SupportedScopes.SELF){
			finalmarkers = markers.filter [ IMarker m |
			m.getAttribute(AadlConstants.AADLURI) == EcoreUtil.getURI(instance).toString()]
		} else if (scope == SupportedScopes.PARTS){
			finalmarkers = markers.filter [ IMarker m |
			val URI targetURI = URI.createURI(m.getAttribute(AadlConstants.AADLURI) as String)
			val target = res.resourceSet.getEObject(targetURI, false)
			val parent = target.getContainerOfType(ComponentInstance)
			(EcoreUtil.getURI(parent).toString() == EcoreUtil.getURI(instance).toString())
			]
		} else {
			finalmarkers = markers
		}
		if(finalmarkers.isEmpty) return false
		markers.forEach[em|verificationActivityResult.addMarkerIssue(instance, em)]
		return verificationActivityResult.issues.exists[ri|ri.issueType == ResultIssueType.ERROR]
	}


	def static void addErrorDiagnostics(VerificationResult verificationActivityResult, InstanceObject instance,
		String markertype) {
		val res = instance.eResource
		val diagnosticErrors = res.errors
		val mt = "org.osate.analysis.flows.FlowLatencyObjectMarker"

	//		val filtered = diagnosticErrors.map[diag| diag.message]
	//		val Diagnostic de = diagnosticErrors.head
	//		val x = de
	}

	def void handleXtextIssues() {
		// Xtext issues. Collected as FluentIssueCollection which also allows messages to be included.
		//  	assertConstraints(
		//  issues.errorsOnly()
		//        .inLine(1)
		//        .under(Modul.class, "person")
		//        .named("name")
		//        .oneOfThemContains("missing display name")
	}

	def static ResultIssue addMarkerIssue(VerificationResult vr, EObject target, IMarker marker) {
		val msg = marker.getAttribute(IMarker.MESSAGE) as String
		switch (marker.getAttribute(IMarker.SEVERITY)) {
			case IMarker.SEVERITY_ERROR: addErrorIssue(vr, target, msg)
			case IMarker.SEVERITY_WARNING: addWarningIssue(vr, target, msg)
			case IMarker.SEVERITY_INFO: addInfoIssue(vr, target, msg)
		}
	}

	def static ResultIssue addErrorIssue(VerificationResult vr, EObject target, String message) {
		addErrorIssue(vr, target, message, null)
	}

	def static ResultIssue addErrorIssue(VerificationResult vr, EObject target, String message,
		String issueSource) {
		val issue = AssureFactory.eINSTANCE.createResultIssue
		issue.message = message
		issue.issueType = ResultIssueType.ERROR;
		issue.exceptionType = issueSource
		issue.target = target
		vr.issues.add(issue)
		issue
	}

	def static ResultIssue addInfoIssue(VerificationResult vr, EObject target, String message) {
		addInfoIssue(vr, target, message, null)
	}

	def static ResultIssue addInfoIssue(VerificationResult vr, EObject target, String message,
		String issueSource) {
		val issue = AssureFactory.eINSTANCE.createResultIssue
		issue.message = message
		issue.issueType = ResultIssueType.INFO;
		issue.exceptionType = issueSource
		issue.target = target
		vr.issues.add(issue)
		issue
	}

	def static ResultIssue addWarningIssue(VerificationResult vr, EObject target, String message) {
		addWarningIssue(vr, target, message, null)
	}

	def static ResultIssue addWarningIssue(VerificationResult vr, EObject target, String message,
		String issueSource) {
		val issue = AssureFactory.eINSTANCE.createResultIssue
		issue.message = message
		issue.issueType = ResultIssueType.WARNING;
		issue.exceptionType = issueSource
		issue.target = target
		vr.issues.add(issue)
		issue
	}

	static val resoluteContent = new ResoluteResultContentProvider

	def static void doResoluteResults(ResoluteResult rr, ResultIssue ri) {
		val subrrs = resoluteContent.getChildren(rr)
		subrrs.forEach [ subrr |
			val subclaim = subrr as com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
			val subri = if (subclaim.isValid)
					ri.addSuccessIssue(subclaim.location, subclaim.text)
				else
					ri.addErrorIssue(subclaim.location, subclaim.text)
			subclaim.doResoluteResults(subri)
		]
	}

	def static ResultIssue addErrorIssue(ResultIssue ri, EObject target, String message) {
		addErrorIssue(ri, target, message, null)
	}

	def static ResultIssue addErrorIssue(ResultIssue ri, EObject target, String message, String issueSource) {
		val issue = AssureFactory.eINSTANCE.createResultIssue
		issue.message = message
		issue.issueType = ResultIssueType.ERROR;
		issue.exceptionType = issueSource
		if (target instanceof FunctionDefinition) {
			issue.name = target.name
		} else if (!(target instanceof FailExpr)) {
			issue.target = target
		} else if (target instanceof FailExpr) {
			if (message.length > 14) {
				issue.message = message.substring(15)
			}
		}
		ri.issues.add(issue)
		issue
	}

	def static ResultIssue addSuccessIssue(ResultIssue ri, EObject target, String message) {
		addSuccessIssue(ri, target, message, null)
	}

	def static ResultIssue addSuccessIssue(ResultIssue ri, EObject target, String message, String issueSource) {
		val issue = AssureFactory.eINSTANCE.createResultIssue
		issue.message = message
		issue.issueType = ResultIssueType.SUCCESS;
		issue.exceptionType = issueSource
		if (target instanceof FunctionDefinition) {
			issue.name = target.name
		} else if (!(target instanceof FailExpr)) {
			issue.target = target
		} else if (target instanceof FailExpr) {
			ri.name = "Fail"
			if (message.length > 14) {
				ri.message = message.substring(15)
			} else {
				ri.message = message
			}
		}
		ri.issues.add(issue)
		issue
	}

	def static getTotalCount(AssureResult ar) {
		ar.unknownCount + ar.failCount + ar.successCount + ar.tbdCount + ar.failthenCount + ar.andthenCount
	}

	def static isSuccessful(AssureResult ar) {
		ar.failCount == 0 && ar.unknownCount == 0 && ar.tbdCount == 0
	}

	def static hasFailedorUnknown(AssureResult ar) {
		ar.failCount != 0 || ar.unknownCount != 0
	}

	def static isTBD(AssureResult ar) {
		ar.failCount == 0 && ar.unknownCount == 0 && ar.tbdCount > 0
	}

	/**
	 * true iff none of the elements have a fail or error
	 */
	def static boolean success(EList<VerificationResult> vel) {
		for (ar : vel) {
			if(ar.failCount != 0 || ar.unknownCount != 0) return false
			}
		return true
	}


	def static boolean isSuccessFul(EList<VerificationExpr> vel) {
		for (ar : vel) {
			if(ar.failCount != 0 || ar.unknownCount != 0) return false
			}
		return true
	}

	/**
	 * true iff at least one has a non-zero fail or unknown count
	 */
	
	def static boolean hasFailedOrUnknown(EList<VerificationExpr> vel) {
		for (ar : vel) {
			if(ar.failCount != 0 || ar.unknownCount != 0) return true
		}
		return false
	}

	def static boolean hasUnknown(EList<VerificationExpr> vel) {
		for (ar : vel) {
			if(ar.unknownCount != 0) return true
		}
	}

	def static boolean hasFailed(EList<VerificationExpr> vel) {
		for (ar : vel) {
			if(ar.failCount != 0 ) return true
		}
	}

	def static getTheWeight(RefExpr expr) {
		switch expr {
			case expr.weight == 0: 1
			default: expr.weight
		}
	}

	def static String constructLabel(EObject obj) {
		switch (obj) {
			SystemInstance: return "top " + obj.componentImplementation.name + ": "
			ComponentInstance: return obj.category.getName + " " + obj.name + ": "
			NamedElement: obj.name + ": "
		}
		""
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
			AssuranceEvidence: return ar.name
			ClaimResult: return ar.name
			VerificationResult: return ar.name
			FailThenResult: return "FailThen"
			AndThenResult: return "AndThen"
		}
	}

	static val hasRunRecord = Collections.synchronizedMap(newHashMap)

	def static boolean getHasRun(String analysisID, EObject target) {
		val value = hasRunRecord.get(analysisID)
		return value == target
	}

	def static void setHasRun(String analysisID, EObject target) {
		val x = hasRunRecord.put(analysisID, target)
	}

	def static void unsetHasRun(String analysisID, EObject target) {
		hasRunRecord.remove(analysisID)
	}

	def static void clearAllHasRunRecords() {
		hasRunRecord.clear
	}

	/**
 * interface with Resolute
 * we initialize the sets on demand. See populate function.
 * We reset the sets and maps on an evelaution run.
 */
	static var SystemInstance systemroot

	static var Map<String, SortedSet<NamedElement>> sets
	static var FeatureToConnectionsMap featToConnsMap

	def static FeatureToConnectionsMap getFeatToConnsMap() {
		if (featToConnsMap == null) {
			populateResoluteContext
		}
		return featToConnsMap
	}

	def static Map<String, SortedSet<NamedElement>> getSets() {
		if (sets == null) {
			populateResoluteContext
		}
		return sets
	}

	def static initializeResoluteContext(SystemInstance si) {
		sets = null
		featToConnsMap = null
		systemroot = si
	}

	def private static void populateResoluteContext() {
		sets = new HashMap<String, SortedSet<NamedElement>>()
		systemroot.initializeSets(sets);
		featToConnsMap = new FeatureToConnectionsMap(systemroot);
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
	def static void resetToTBD(AssuranceEvidence root) {
		val vrlist = EcoreUtil2.eAllOfType(root, VerificationResult)
		vrlist.forEach [ vr |
			vr.resultState = VerificationResultState.TBD
			vr.executionState = VerificationExecutionState.TODO
			vr.issues.clear
		]
	}

	/**
	 * this next set of methods recomputes all the counts from the VerificationResult states bottom up for the whole hierarchy 
	 * Only the top method should be called
	 * This method is useful when counts are messed up but the state is ok.
	 */
	/** Helper methods */
	private def static void resetCounts(AssureResult result) {
		result.failCount = 0
		result.successCount = 0
		result.unknownCount = 0
		result.andthenCount = 0
		result.failthenCount = 0
		result.tbdCount = 0
	}

	/**
	 * update the counts to reflect existing own status
	 * Used by complete process and set result
	 */
	private def static addOwnResultStateToCount(AssureResult ar) {
		if (ar instanceof VerificationResult){
		switch (ar.resultState) {
			case VerificationResultState.SUCCESS:
				ar.successCount = ar.successCount + 1
			case VerificationResultState.FAIL:
				ar.failCount = ar.failCount + 1
			case VerificationResultState.UNKNOWN:
				ar.unknownCount = ar.unknownCount + 1
			case VerificationResultState.TBD:
				ar.tbdCount = ar.tbdCount + 1
		}
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
		result.unknownCount = result.unknownCount + subresult.unknownCount
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

	def static AssuranceEvidence recomputeAllCounts(AssuranceEvidence caseResult) {
		caseResult.resetCounts
		caseResult.recomputeAllCounts(caseResult.claimResult)
		caseResult.recomputeAllCounts(caseResult.subAssuranceEvidence)
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
		vaResult.recomputeAllCounts(vaResult.validationResult)
		vaResult.recomputeAllCounts(vaResult.preconditionResult)
		vaResult.addOwnResultStateToCount()
		vaResult
	}

	private def static FailThenResult recomputeAllCounts(FailThenResult vaResult) {
		vaResult.resetCounts
		vaResult.didFail = false
		vaResult.recomputeAllCounts(vaResult.first)
		if (vaResult.first.isSuccessFul) {
			vaResult.recordNoFailThen
		} else {
			vaResult.recordFailThen
			vaResult.recomputeAllCounts(vaResult.second)
		}
		vaResult
	}

	private def static AndThenResult recomputeAllCounts(AndThenResult vaResult) {
		vaResult.resetCounts
		vaResult.didAndThenFail = false
		vaResult.recomputeAllCounts(vaResult.first)
		if (vaResult.first.isSuccessFul) {
			vaResult.recordSkip
			vaResult.recomputeAllCounts(vaResult.second)
		} else {
			vaResult.recordNoSkip
		}
		vaResult
	}

	private def static ValidationResult recomputeAllCounts(ValidationResult validationResult) {
		validationResult.resetCounts
		validationResult.addOwnResultStateToCount()
		validationResult
	}

	private def static PreconditionResult recomputeAllCounts(PreconditionResult preconditionResult) {
		preconditionResult.resetCounts
		preconditionResult.addOwnResultStateToCount()
		preconditionResult
	}

	private def static AssureResult recomputeAllCounts(AssureResult assureResult) {
		switch (assureResult) {
			AssuranceEvidence: assureResult.recomputeAllCounts
			ClaimResult: assureResult.recomputeAllCounts
			ValidationResult: assureResult.recomputeAllCounts
			PreconditionResult: assureResult.recomputeAllCounts
			VerificationActivityResult: assureResult.recomputeAllCounts
			FailThenResult: assureResult.recomputeAllCounts
			AndThenResult: assureResult.recomputeAllCounts
		}
	}

	/**
	 * methods to incrementally set the state of a verification activity and propagate the state change
	 * up the hierarchy
	 */
	def static void setToSuccess(VerificationResult verificationActivityResult) {
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.SUCCESS))
			verificationActivityResult.propagateCountChangeUp
	}
	

	def static void setToSuccess(VerificationResult verificationActivityResult, List<ResultIssue> rl) {
		verificationActivityResult.issues.addAll(rl);
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.SUCCESS))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToTBD(VerificationResult verificationActivityResult) {
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.TBD))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToFail(VerificationResult verificationActivityResult) {
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.FAIL))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToFail(VerificationResult verificationActivityResult, String message) {
		if (message != null && !message.isEmpty) verificationActivityResult.addErrorIssue(null, message, null);
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.FAIL))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToFail(VerificationResult verificationActivityResult, List<ResultIssue> rl) {
		verificationActivityResult.issues.addAll(rl);
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.FAIL))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToFail(VerificationResult verificationActivityResult, EObject target, String message) {
		verificationActivityResult.addErrorIssue(target, message, null);
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.FAIL))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToFail(VerificationResult verificationActivityResult, Throwable e) {
		verificationActivityResult.addErrorIssue(null, e.getMessage(), e.getClass().getName());
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.FAIL))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToError(VerificationResult verificationActivityResult, Throwable e) {
		verificationActivityResult.addErrorIssue(null, e.getMessage(), e.getClass().getName());
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.FAIL))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToError(VerificationResult verificationActivityResult, String message) {
		verificationActivityResult.addErrorIssue(null, message, null);
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.FAIL))
			verificationActivityResult.propagateCountChangeUp
	}

	/**
  * the next methods update the counts for FailThen and AndThen
  */
	def static void recordFailThen(FailThenResult result) {
		if (result.didFail) {
			// was didthen from previous time
		} else {
			result.didFail = true
			result.failthenCount = result.failthenCount + 1
			result.propagateCountChangeUp
		}
	}

	/**
  * the next methods update the counts for FailThen and AndThen
  * Initial didFail is false
  */
	def static void recordNoFailThen(FailThenResult result) {
		if (result.didFail) {
			result.didFail = false
			result.failthenCount = result.failthenCount - 1
			result.propagateCountChangeUp
		} else {
			// was already no didThen
		}
	}

	/**
  * the next methods update the counts for FailThen and AndThen
  * returns true if change of state
  */
	def static void recordSkip(AndThenResult result) {
		if (result.didAndThenFail) {
			// was didAndThenFail from previous time
		} else {
			result.didAndThenFail = true
			result.andthenCount = result.andthenCount + 1
			result.propagateCountChangeUp
		}
	}

	/**
  * the next methods update the counts for FailThen and AndThen
  * returns true if change of state
  */
	def static void recordNoSkip(AndThenResult result) {
		if (result.didAndThenFail) {
			result.didAndThenFail = false
			result.andthenCount = result.andthenCount - 1
			result.propagateCountChangeUp
		} else {
			// was already no didThen
		}
	}

	/**
	 * set the status and update the counts
	 * true if state changed
	 */
	def private static boolean updateOwnResultState(VerificationResult ar, VerificationResultState newState) {
		if(ar.resultState == newState) return false
		if (ar.resultState == VerificationResultState.TBD) {
			ar.tbdCount = ar.tbdCount - 1
			ar.executionState = VerificationExecutionState.COMPLETED
			switch (newState) {
				case VerificationResultState.SUCCESS:
					ar.successCount = ar.successCount + 1
				case VerificationResultState.FAIL:
					ar.failCount = ar.failCount + 1
				case VerificationResultState.UNKNOWN:
					ar.unknownCount = ar.unknownCount + 1
				case VerificationResultState.TBD: {
				}
			}
		} else if (newState == VerificationResultState.TBD) {
			ar.tbdCount = ar.tbdCount + 1
			ar.executionState = VerificationExecutionState.TODO
			switch (ar.resultState) {
				case VerificationResultState.SUCCESS:
					ar.successCount = ar.successCount - 1
				case VerificationResultState.FAIL:
					ar.failCount = ar.failCount - 1
				case VerificationResultState.UNKNOWN:
					ar.unknownCount = ar.unknownCount - 1
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
	private def static void propagateCountChangeUp(AssureResult ar) {
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

	private def static AssuranceEvidence addAllSubCounts(AssuranceEvidence caseResult) {
		caseResult.resetCounts
		caseResult.claimResult.forEach[e|e.addTo(caseResult)]
		caseResult.subAssuranceEvidence.forEach[e|e.addTo(caseResult)]
		caseResult
	}

	private def static ClaimResult addAllSubCounts(ClaimResult claimResult) {
		claimResult.resetCounts
		claimResult.verificationActivityResult.forEach[e|e.addTo(claimResult)]
		claimResult.subClaimResult.forEach[e|e.addTo(claimResult)]
		claimResult
	}

	private def static VerificationActivityResult addAllSubCounts(VerificationActivityResult vaResult) {
		vaResult.resetCounts
		vaResult.validationResult.forEach[e|e.addTo(vaResult)]
		vaResult.preconditionResult.forEach[e|e.addTo(vaResult)]
		vaResult.addOwnResultStateToCount()
		vaResult
	}

	private def static FailThenResult addAllSubCounts(FailThenResult vaResult) {
		vaResult.resetCounts
		vaResult.didFail = false
		vaResult.first.forEach[e|e.addTo(vaResult)]
		if (vaResult.first.isSuccessFul) {
			vaResult.recordNoFailThen
		} else {
			vaResult.recordFailThen
			vaResult.second.forEach[e|e.addTo(vaResult)]
		}
		vaResult
	}

	private def static AndThenResult addAllSubCounts(AndThenResult vaResult) {
		vaResult.resetCounts
		vaResult.didAndThenFail = false
		vaResult.first.forEach[e|e.addTo(vaResult)]
		if (vaResult.first.isSuccessFul) {
			vaResult.recordSkip
			vaResult.second.forEach[e|e.addTo(vaResult)]
		} else {
			vaResult.recordNoSkip
		}
		vaResult
	}

	private def static ValidationResult addAllSubCounts(ValidationResult validationResult) {
		validationResult.resetCounts
		validationResult.addOwnResultStateToCount()
		validationResult
	}

	private def static PreconditionResult addAllSubCounts(PreconditionResult preconditionResult) {
		preconditionResult.resetCounts
		preconditionResult.addOwnResultStateToCount()
		preconditionResult
	}

	private def static AssureResult addAllSubCounts(AssureResult assureResult) {
		switch (assureResult) {
			AssuranceEvidence: assureResult.addAllSubCounts
			ClaimResult: assureResult.addAllSubCounts
			ValidationResult: assureResult.addAllSubCounts
			PreconditionResult: assureResult.addAllSubCounts
			VerificationActivityResult: assureResult.addAllSubCounts
			FailThenResult: assureResult.addAllSubCounts
			AndThenResult: assureResult.addAllSubCounts
		}
	}

	/**
	 * methods to retrieve messages and status 
	 * Note that the message could be in the Result object or if not present we want to get it from the 
	 * object the result object is derived from.
	 */
	def static String toTextLabel(VerificationResultState vs) {
		switch (vs) {
			case VerificationResultState.SUCCESS: return "[S]"
			case VerificationResultState.FAIL: return "[F]"
			case VerificationResultState.UNKNOWN: return "[U]"
			case VerificationResultState.TBD: return "[T]"
		}
	}

	def static constructLabel(AssureResult ar) {

		// has to be a string without space (ID) 
		switch (ar) {
			AssuranceEvidence:
				return ar.name
			ClaimResult:
				return ar.target?.title ?: ar.name
			ValidationResult:
				return ar.target?.title ?: ar.name
			PreconditionResult:
				return ar.target?.title ?: ar.name
			VerificationActivityResult: {
				val vatitle = ar.target?.title
				return ar.name + ":" + (vatitle ?: "")
			}
		}
		""
	}

	def static String constructMessage(VerificationActivityResult vr) {
		if(vr.message != null) return vr.message
		val va = vr.target
		if(va.description != null) return va.description.toText(vr.claimSubject)
		""
	}

	def static String constructMessage(AssuranceEvidence ce) {
		if(ce.message != null) return ce.message
		return "for " + ce.target.name
	}

	def static String constructMessage(ClaimResult cr) {
		if(cr.message != null) return cr.message
		val r = cr.target
		if(r.description != null) return r.description.toText(cr.claimSubject)
		""
	}

	def static String constructMessage(ValidationResult cr) {
		if(cr.message != null) return cr.message
		val r = cr.target
		if(r.description != null) return r.description.toText(cr.claimSubject)
		""
	}

	def static String constructMessage(PreconditionResult cr) {
		if(cr.message != null) return cr.message
		val r = cr.target
		if(r.description != null) return r.description.toText(cr.claimSubject)
		""
	}

	def static String constructMessage(ResultIssue ri) {
		if(ri.message != null) return ri.message + if(ri.exceptionType != null) (" [" + ri.exceptionType + "]") else ""
		if(ri.exceptionType != null) return ri.exceptionType
		""
	}

	def static String assureResultCounts(AssureResult ele) {
		"(S" + ele.successCount + " F" + ele.failCount + " U" + ele.unknownCount + " T" + ele.tbdCount 
		+ " FU" + ele.failthenCount + " AS" + ele.andthenCount+ ")"
	}

}

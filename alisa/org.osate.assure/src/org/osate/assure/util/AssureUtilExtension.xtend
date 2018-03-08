/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */

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
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.junit.runner.Result
import org.osate.aadl2.ComponentCategory
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.NamedElement
import org.osate.aadl2.NumberValue
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.modelsupport.AadlConstants
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil
import org.osate.aadl2.util.Aadl2Util
import org.osate.result.Issue
import org.osate.result.IssueType
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.AssureResult
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.ElseResult
import org.osate.assure.assure.ElseType
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.NestedClaimReference
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.PredicateResult
import org.osate.assure.assure.QualifiedClaimReference
import org.osate.assure.assure.QualifiedVAReference
import org.osate.assure.assure.QualifiedVerificationPlanElementReference
import org.osate.assure.assure.SubsystemResult
import org.osate.assure.assure.ThenResult
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.VerificationExecutionState
import org.osate.assure.assure.VerificationExpr
import org.osate.assure.assure.VerificationResult
import org.osate.assure.assure.VerificationResultState
import org.osate.categories.categories.CategoryFilter
import org.osate.reqspec.reqSpec.ValuePredicate
import org.osate.verify.verify.Claim
import org.osate.verify.verify.VerificationActivity
import org.osate.verify.verify.VerificationMethod
import org.osate.verify.verify.VerificationPlan

import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile
import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import static extension org.osate.reqspec.util.ReqSpecUtilExtension.*
import static extension org.osate.verify.util.VerifyUtilExtension.*
import org.eclipse.xtext.resource.XtextResource
import org.osate.reqspec.reqSpec.InformalPredicate
import org.osate.result.ResultFactory
import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter
import com.rockwellcollins.atc.resolute.resolute.ProveStatement
import org.osate.aadl2.PropertyExpression
import com.rockwellcollins.atc.resolute.resolute.ResoluteFactory
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr
import org.osate.aadl2.StringLiteral
import com.rockwellcollins.atc.resolute.resolute.ThisExpr
import com.rockwellcollins.atc.resolute.resolute.NestedDotID
import org.osate.aadl2.BooleanLiteral

class AssureUtilExtension {

	def static SubsystemResult getEnclosingSubsystemResult(EObject assureObject) {
		if(assureObject.eContainer === null) return null;
		var result = assureObject.eContainer
		while (result !== null && !(result instanceof SubsystemResult)) {
			result = result.eContainer
		}
		if(result === null) return null
		return result as SubsystemResult
	}

	def static AssuranceCaseResult getAssuranceCaseResult(EObject assureObject) {
		var result = assureObject
		while (result.eContainer !== null) {
			result = result.eContainer
		}
		return result as AssuranceCaseResult
	}

	def static ModelResult getModelResult(EObject assureObject) {
		var result = assureObject
		while (result !== null) {
			if(result instanceof ModelResult) return result
			result = result.eContainer
		}
		return null
	}

	/*
	 * return the component classifier associated with the ModelResult target, i.e., the AADL instance model being verified
	 */
	def static ComponentClassifier getCaseTargetClassifier(EObject assureObject) {
		var ac = assureObject
		while (ac !== null) {
			ac = ac.eContainer
			if (ac instanceof ModelResult) {
				if (ac.target !== null) {
					return ac.target
				}
			} else if (ac instanceof SubsystemResult) {
				if (ac.targetSystem !== null) {
					return ac.targetSystem.allClassifier
				}
			}
		}
		return null
	}

	def static ClaimResult getClaimResult(EObject assureObject) {
		var result = assureObject
		while (!(result instanceof ClaimResult)) {
			result = result.eContainer
		}
		if(result === null) return null
		return result as ClaimResult
	}

// Deal with qualified verification activity references	
// reference string constructor is in VerifyUtilExtension
	def static VerificationPlan findVerificationPlan(NestedClaimReference refObject) {
		var EObject result = refObject
		while (!(result instanceof QualifiedVerificationPlanElementReference)) {
			result = result.eContainer
		}
		return (result as QualifiedVerificationPlanElementReference).verificationPlan
	}

	def static findClaim(QualifiedVAReference qva) {
		return getReferencedClaim(qva.requirement, qva.verificationPlan.claim)
	}

	def static Claim getReferencedClaim(NestedClaimReference cref, Iterable<Claim> claims) {
		for (cl : claims) {
			if (cl.requirement.name.equalsIgnoreCase(cref.requirement.name)) {
				if (cref.sub !== null && !cl.subclaim.empty) {
					return getReferencedClaim(cref.sub, cl.subclaim)
				}
				return cl
			}
		}
		return null
	}

	def static findClaim(QualifiedClaimReference qc) {
		return getReferencedClaim(qc.requirement, qc.verificationPlan.claim)
	}

	def static getTarget(ClaimResult cr) {
		var qualreqref = cr.targetReference.requirement
		while (qualreqref.sub !== null)
			qualreqref = qualreqref.sub
		return qualreqref.requirement
	}

	def static getPredicate(PredicateResult pr) {
		var qualreqref = pr.targetReference.requirement
		while (qualreqref.sub !== null)
			qualreqref = qualreqref.sub
		return qualreqref.requirement.predicate as ValuePredicate
	}

	/*
	 * return the model element that is the target of verification
	 */
	def static NamedElement getCaseTargetModelElement(EObject assureObject) {
		val cr = assureObject.claimResult
		val res = cr.modelElement
		if(!Aadl2Util.isNull(res)) return res
		val req = cr.target
		req?.targetElement ?: req.targetClassifier ?: cr.caseTargetClassifier
	}

	def static boolean isConnections(EObject assureObject) {
		assureObject.claimResult.target?.connections
	}

	def static SystemInstance getAssuranceCaseInstanceModel(VerificationResult assureObject) {
		val rac = assureObject.modelResult?.target
		if(rac === null) return null
		rac.instanceModel
	}

	def static ComponentInstance findTargetSystemComponentInstance(SystemInstance si, SubsystemResult ac) {
		if (ac !== null && ac.targetSystem !== null) {
			val ci = findTargetSystemComponentInstance(si, ac.enclosingSubsystemResult)
			findElementInstance(ci, ac.targetSystem) as ComponentInstance
		} else {
			si
		}
	}

	def static VerificationActivity getTarget(VerificationActivityResult vares) {
		val vaqref = vares.targetReference
		return vaqref.verificationActivity
	}

	def static VerificationMethod getMethod(VerificationResult vr) {
		switch (vr) {
			VerificationActivityResult: return vr.target.method
			PreconditionResult: return vr.target
			ValidationResult: return vr.target
		}
	}

	/**
	 * methods to process results from verification methods
	 */

	def static void addMarkersAsResult(VerificationResult verificationActivityResult, InstanceObject instance,
		String markertype, VerificationMethod vm) {
		val res = instance.eResource
		val IResource irsrc = OsateResourceUtil.convertToIResource(res);
		val markers = irsrc.findMarkers(markertype, true, IResource.DEPTH_INFINITE) // analysisMarkerType
		val targetURI = EcoreUtil.getURI(instance).toString()
		var targetmarkers = markers.filter [ IMarker m |
			matchURI(m.getAttribute(AadlConstants.AADLURI) as String, targetURI)
		]
//	enable if we want to default to all messages.	if (targetmarkers.empty) targetmarkers = markers
		val matchstr = matchMessage(vm)
		if (!matchstr.empty) {
			targetmarkers = targetmarkers.filter [ IMarker m |
				val msg = m.getAttribute(IMarker.MESSAGE) as String;
				msg.contains(matchstr)
			]
		}
		targetmarkers.forEach[em|verificationActivityResult.addMarkerIssue(null /*instance*/ , em)]
		if (verificationActivityResult.issues.exists[ri|ri.issueType == IssueType.FAIL]) {
			verificationActivityResult.setToFail
		} else if (verificationActivityResult.issues.exists[ri|ri.issueType == IssueType.ERROR]) {
			verificationActivityResult.setToError
		} else {
			verificationActivityResult.setToSuccess
		}
	}

	def private static boolean matchURI(String uri1, String uri2) {
		return uri1 == uri2;
	}

	def private static String matchMessage(VerificationMethod vm) {
		switch (vm.name) {
			case "MaxFlowLatencyAnalysis": return "Maximum actual latency"
			case "MinFlowLatencyAnalysis": return "Minimum actual latency"
			case "FlowLatencyJitterAnalysis": return "Jitter"
		}
		return ""
	}

	def static Issue addMarkerIssue(VerificationResult vr, EObject target, IMarker marker) {
		val msg = marker.getAttribute(IMarker.MESSAGE) as String
		switch (marker.getAttribute(IMarker.SEVERITY)) {
			case IMarker.SEVERITY_ERROR: addFailIssue(vr, target, msg)
			case IMarker.SEVERITY_WARNING: addWarningIssue(vr, target, msg)
			case IMarker.SEVERITY_INFO: addSuccessIssue(vr, target, msg)
		}
	}

	def static Issue addErrorIssue(VerificationResult vr, EObject target, String message) {
		addIssue(vr,IssueType.ERROR, target, message)
	}

	def static Issue addIssue(VerificationResult vr, IssueType type, EObject target, String message) {
		val issue = ResultFactory.eINSTANCE.createIssue
		issue.message = message ?: "no message"
		issue.issueType = type;
		issue.sourceReference = target
		vr.issues.add(issue)
		issue
	}

	def static Issue addFailIssue(VerificationResult vr, EObject target, String message) {
		addIssue(vr, IssueType.FAIL,target, message)
	}

	def static Issue addInfoIssue(VerificationResult vr, EObject target, String message) {
		addIssue(vr, IssueType.INFO,target, message)
	}

	def static Issue addSuccessIssue(VerificationResult vr, EObject target, String message) {
		addIssue(vr, IssueType.SUCCESS,target, message)
	}

	def static Issue addWarningIssue(VerificationResult vr, EObject target, String message) {
		addIssue(vr, IssueType.WARNING,target, message)
	}


	def static void doJUnitResults(Result rr, Issue ri) {
		val failist = rr.failures
		failist.forEach [ failed |
			ri.addFailIssue(null, failed.message)
		]
	}


	def static Issue addIssue(Issue ri, IssueType type, EObject target, String message) {
		val issue = ResultFactory.eINSTANCE.createIssue
		issue.message = message
		issue.issueType = type;
		if (target instanceof FunctionDefinition) {
			issue.sourceReference = target
		} else if (!(target instanceof FailExpr)) {
			issue.sourceReference = target
		} else if (target instanceof FailExpr) {
			if (message.length > 14) {
				issue.message = message.substring(15)
			}
		}
		ri.issues.add(issue)
		issue
	}

	def static Issue addFailIssue(Issue ri, EObject target, String message) {
		addIssue(ri, IssueType.FAIL, target, message)
	}

	def static Issue addSuccessIssue(Issue ri, EObject target, String message) {
		addIssue(ri, IssueType.SUCCESS, target, message)
	}

	def static getTotalCount(AssureResult ar) {
		val counts = ar.metrics
		counts.timeoutCount + counts.errorCount + counts.failCount + counts.successCount + counts.tbdCount +
			counts.didelseCount + counts.thenskipCount
	}

	def static isSuccessful(AssureResult ar) {
		val counts = ar.metrics
		counts.failCount == 0 && counts.errorCount == 0 && counts.timeoutCount == 0 && counts.tbdCount == 0 &&
			counts.successCount > 0
	}

	def static isNoSuccess(AssureResult ar) {
		val counts = ar.metrics
		counts.failCount != 0 || counts.errorCount != 0 || counts.timeoutCount != 0
	}

	def static isFail(AssureResult ar) {
		val counts = ar.metrics
		counts.failCount != 0
	}

	def static isErrorTimeOut(AssureResult ar) {
		val counts = ar.metrics
		counts.errorCount != 0 || counts.timeoutCount != 0
	}

	def static isTBD(AssureResult ar) {
		val counts = ar.metrics
		counts.failCount == 0 && counts.errorCount == 0 && counts.timeoutCount == 0 && counts.tbdCount > 0
	}

	def static isZeroCount(AssureResult ar) {
		val counts = ar.metrics
		counts.failCount == 0 && counts.errorCount == 0 && counts.timeoutCount == 0 && counts.tbdCount == 0
	}

	def static isZeroTotalCount(AssureResult ar) {
		val counts = ar.metrics
		counts.failCount == 0 && counts.errorCount == 0 && counts.timeoutCount == 0 && counts.tbdCount == 0 &&
			counts.successCount == 0
	}

	/** 
	 * state of VerificationResult 
	 */
	def static boolean isSuccess(VerificationResult vr) {
		vr.resultState == VerificationResultState.SUCCESS
	}

	def static boolean isError(VerificationResult vr) {
		vr.resultState == VerificationResultState.ERROR
	}

	def static boolean isFailed(VerificationResult vr) {
		vr.resultState == VerificationResultState.FAIL
	}

	def static boolean isTimeout(VerificationResult vr) {
		vr.resultState == VerificationResultState.TIMEOUT
	}

	/**
	 * true at least one element is TBD
	 */
	def static boolean isTBD(EList<VerificationExpr> vel) {
		for (ar : vel) {
			if(ar.isTBD) return true
		}
		return false
	}

	/**
	 * true iff none of the elements have a fail or error
	 */
	def static boolean isSuccess(EList<VerificationExpr> vel) {
		for (ar : vel) {
			if(ar.noSuccess) return false
		}
		return true
	}

	/**
	 * true iff none of the elements have a fail or error
	 */
	def static boolean isSuccessFul(EList<VerificationResult> vel) {
		for (ar : vel) {
			if(ar.noSuccess) return false
		}
		return true
	}

	/**
	 * true iff at least one has a non-zero fail or unknown count
	 */
	def static boolean isNoSuccess(EList<VerificationExpr> vel) {
		for (ar : vel) {
			if(ar.isNoSuccess) return true
		}
		return false
	}

	def static boolean hasError(EList<VerificationExpr> vel) {
		if (vel.size == 1 && vel.head instanceof VerificationActivityResult) {
			return (vel.head as VerificationActivityResult).isError
		} else {
			return isNoSuccess(vel)
		}
	}

	def static boolean isTimeout(EList<VerificationExpr> vel) {
		if (vel.size == 1 && vel.head instanceof VerificationActivityResult) {
			return (vel.head as VerificationActivityResult).isTimeout
		} else {
			return false
		}
	}

	def static boolean isFailed(EList<VerificationExpr> vel) {
		if (vel.size == 1 && vel.head instanceof VerificationActivityResult) {
			return (vel.head as VerificationActivityResult).isFailed
		} else {
			return false
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
		if (ar.eContainer === null) {
			return ar.printableName
		} else {
			return (ar.eContainer as AssureResult).namePath + "." + ar.printableName
		}
	}

	def static getPrintableName(AssureResult ar) {
		switch (ar) {
			AssuranceCaseResult: return "case " + ar.name
			ModelResult: return "plan " + ar.name
			SubsystemResult: return "subsystem " + ar.name
			ClaimResult: return "claim " + ar.name
			ValidationResult: return "validation " + ar.name
			PreconditionResult: return "precondition " + ar.name
			VerificationActivityResult: return "evidence " + ar.name
			ElseResult: return "Else"
			ThenResult: return "Then"
			PredicateResult: return "Predicate"
		}
		return ""
	}

	def static getName(AssureResult ar) {
		switch (ar) {
			AssuranceCaseResult: return ar.name
			ModelResult: return ar.name
			SubsystemResult: return ar.name
			ClaimResult: return ar.name
			ValidationResult: return ar.name
			PreconditionResult: return ar.name
			VerificationActivityResult: return ar.name
		}
		return ""
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
		if (featToConnsMap === null) {
			populateResoluteContext
		}
		return featToConnsMap
	}

	def static Map<String, SortedSet<NamedElement>> getSets() {
		if (sets === null) {
			populateResoluteContext
		}
		return sets
	}

	def static initializeResoluteContext(SystemInstance si) {
		if (systemroot != si) {
			sets = null
			featToConnsMap = null
			systemroot = si
		}
	}

	def private static void populateResoluteContext() {
		sets = new HashMap<String, SortedSet<NamedElement>>()
		systemroot.initializeSets(sets);
		featToConnsMap = new FeatureToConnectionsMap(systemroot);
	}

	def private static void initializeSets(ComponentInstance ci, Map<String, SortedSet<NamedElement>> sets) {
		if (ci === null) {
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
		if (set === null) {
			set = new TreeSet<NamedElement>(new NamedElementComparator());
			sets.put(name, set);
		}
		set.add(ne);
	}

	/**
	 * invokes Resolute call function on target component instance. instanceroot is used to initialize the Resolute evaluation context.
	 * parameterObjects can be null or an empty list.
	 * The return value is an Issue object with subissues for the list of issues returned in the Resolute ClaimResult.
	 * If the proof fails then the top Issue is set to FAIL, if successful it is set to SUCCESS
	 */
	def static Issue executeResoluteFunction(FunctionDefinition fd,SystemInstance instanceroot,ComponentInstance targetComponent,List<PropertyExpression> parameterObjects) {
		AssureUtilExtension.initializeResoluteContext(instanceroot);
		val EvaluationContext context = new EvaluationContext(instanceroot, sets, featToConnsMap);
		// check for claim function or compute function
		val ResoluteInterpreter interpreter = new ResoluteInterpreter(context);
		val proveri = ResultFactory.eINSTANCE.createIssue
		val provecall = createWrapperProveCall(fd, targetComponent, parameterObjects)
		if (provecall !== null) {
			// using com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
			val ResoluteResult proof = interpreter.evaluateProveStatement(provecall) as ResoluteResult
			doResoluteResults(proof,proveri)
		} else {
			proveri.issueType = IssueType.FAIL
			proveri.addFailIssue(targetComponent, "Could not find Resolute Function " + fd.name)
		}
		return proveri
	}

	def static ProveStatement createWrapperProveCall(FunctionDefinition fd, ComponentInstance ci,
		List<PropertyExpression> params) {
		val factory = ResoluteFactory.eINSTANCE
		val call = factory.createFnCallExpr
		call.fn = fd
		call.args.add(createComponentinstanceReference(ci))
		if (params !== null){
			addParams(call, params)
		}
		val prove = factory.createProveStatement
		prove.expr = call
		prove
	}

	def static ThisExpr createComponentinstanceReference(ComponentInstance ci) {
		val factory = ResoluteFactory.eINSTANCE
		var NestedDotID nid = null
		var nci = ci
		while (!(nci instanceof SystemInstance)) {
			val x = factory.createNestedDotID
			x.base = nci.subcomponent
			x.sub = nid
			nid = x
			nci = nci.eContainer as ComponentInstance
		}
		val te = factory.createThisExpr
		te.sub = nid
		te
	}

	def static addParams(FnCallExpr call, List<PropertyExpression> params) {
		for (p : params) {
			if (p instanceof RealLiteral) {
				val realval = ResoluteFactory.eINSTANCE.createRealExpr
				realval.^val = p
				call.args.add(realval)
			} else if (p instanceof IntegerLiteral) {
				val intval = ResoluteFactory.eINSTANCE.createIntExpr
				intval.^val = p
				call.args.add(intval)
			} else if (p instanceof StringLiteral) {
				val stringval = ResoluteFactory.eINSTANCE.createStringExpr
				stringval.^val = p
				call.args.add(stringval)
			} else if (p instanceof BooleanLiteral) {
				val stringval = ResoluteFactory.eINSTANCE.createBoolExpr
				stringval.^val = p
				call.args.add(stringval)
			}
		}
	}
	
	static val resoluteContent = new ResoluteResultContentProvider


	def static void doResoluteResults(ResoluteResult rr, Issue ri) {
		if (rr.valid){
			ri.issueType = IssueType.SUCCESS
		} else {
			ri.issueType = IssueType.FAIL
		}
		val subrrs = resoluteContent.getChildren(rr)
		subrrs.forEach [ subrr |
			val subclaim = subrr as com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
			val subri = if (subclaim.isValid)
					ri.addSuccessIssue(subclaim.location, subclaim.text)
				else
					ri.addFailIssue(subclaim.location, subclaim.text)
			subclaim.doResoluteResults(subri)
		]
	}

	/************************
	 * methods to deal with assurance case instance
	 */
	/**
	 * this method resets the execution state of all verification activities to TBD
	 */
	def static void resetToTBD(AssuranceCaseResult root, CategoryFilter filter) {
		val vrlist = EcoreUtil2.eAllOfType(root, VerificationResult)
		vrlist.forEach [ vr |
			// If there is no filter reset all.
			if (filter === null) {
				vr.resultState = VerificationResultState.TBD
				vr.executionState = VerificationExecutionState.TODO
				vr.issues.clear

			// reset only the ones that we will be redoing
			} else {
				switch vr {
					VerificationActivityResult: {
						val verificationActivity = vr.targetReference.verificationActivity
						if (verificationActivity.evaluateVerificationMethodFilter(filter) &&
							verificationActivity.evaluateVerificationActivityFilter(filter)) {
							vr.resultState = VerificationResultState.TBD
							vr.executionState = VerificationExecutionState.TODO
							vr.issues.clear
						}
					}
				// default:
				}
			}
		]
	}

	/**
	 * this next set of methods recomputes all the counts from the VerificationResult states bottom up for the whole hierarchy 
	 * Only the top method should be called
	 * This method is useful when counts are messed up but the state is ok.
	 */
	/** Helper methods */
	private def static void resetCounts(AssureResult result) {
		val counts = result.metrics
		counts.failCount = 0
		counts.successCount = 0
		counts.errorCount = 0
		counts.timeoutCount = 0
		counts.thenskipCount = 0
		counts.didelseCount = 0
		counts.tbdCount = 0
		counts.preconditionfailCount = 0
		counts.validationfailCount = 0
		counts.featuresCount = 0
		counts.featuresRequirementsCount = 0
		counts.executionTime = 0
	}

	/**
	 * update the counts to reflect existing own status
	 * Used by complete process and set result
	 */
	private def static addOwnResultStateToCount(VerificationActivityResult ar) {
		val counts = ar.metrics
		switch (ar.resultState) {
			case VerificationResultState.SUCCESS:
				counts.successCount = counts.successCount + 1
			case VerificationResultState.FAIL:
				counts.failCount = counts.failCount + 1
			case VerificationResultState.ERROR:
				counts.errorCount = counts.errorCount + 1
			case VerificationResultState.TIMEOUT:
				counts.timeoutCount = counts.timeoutCount + 1
			case VerificationResultState.TBD:
				counts.tbdCount = counts.tbdCount + 1
		}
		ar
	}

	private def static addOwnResultStateToCount(PreconditionResult ar) {
		val counts = ar.metrics
		switch (ar.resultState) {
			case VerificationResultState.SUCCESS:
				counts.successCount = counts.successCount + 1
			case VerificationResultState.FAIL:
				counts.failCount = counts.failCount + 1
			case VerificationResultState.ERROR:
				counts.errorCount = counts.errorCount + 1
			case VerificationResultState.TIMEOUT:
				counts.timeoutCount = counts.timeoutCount + 1
			case VerificationResultState.TBD:
				counts.tbdCount = counts.tbdCount + 1
		}
		ar
	}

	private def static addOwnResultStateToCount(ValidationResult ar) {
		val counts = ar.metrics
		switch (ar.resultState) {
			case VerificationResultState.SUCCESS:
				counts.successCount = counts.successCount + 1
			case VerificationResultState.FAIL:
				counts.failCount = counts.failCount + 1
			case VerificationResultState.ERROR:
				counts.errorCount = counts.errorCount + 1
			case VerificationResultState.TIMEOUT:
				counts.timeoutCount = counts.timeoutCount + 1
			case VerificationResultState.TBD:
				counts.tbdCount = counts.tbdCount + 1
		}
		ar
	}

	private def static addOwnResultStateToCount(PredicateResult ar) {
		val counts = ar.metrics
		switch (ar.resultState) {
			case VerificationResultState.SUCCESS:
				counts.successCount = counts.successCount + 1
			case VerificationResultState.FAIL:
				counts.failCount = counts.failCount + 1
			case VerificationResultState.ERROR:
				counts.errorCount = counts.errorCount + 1
			case VerificationResultState.TIMEOUT:
				counts.timeoutCount = counts.timeoutCount + 1
			case VerificationResultState.TBD:
				counts.tbdCount = counts.tbdCount + 1
		}
		ar
	}

	/**
	 * add all but the total count to the result object
	 * This method is used in the process and set result methods
	 */
	private def static void addTo(AssureResult subresult, AssureResult result) {
		if(subresult === null) return
		val counts = result.metrics
		val subcounts = subresult.metrics
		counts.failCount = counts.failCount + subcounts.failCount
		counts.successCount = counts.successCount + subcounts.successCount
		counts.errorCount = counts.errorCount + subcounts.errorCount
		counts.timeoutCount = counts.timeoutCount + subcounts.timeoutCount
		counts.thenskipCount = counts.thenskipCount + subcounts.thenskipCount
		counts.didelseCount = counts.didelseCount + subcounts.didelseCount
		counts.tbdCount = counts.tbdCount + subcounts.tbdCount
		counts.preconditionfailCount = counts.preconditionfailCount + subcounts.preconditionfailCount
		counts.validationfailCount = counts.validationfailCount + subcounts.validationfailCount
		counts.featuresCount = counts.featuresCount + subcounts.featuresCount
		counts.featuresRequirementsCount = counts.featuresRequirementsCount + subcounts.featuresRequirementsCount
	}

	/**
	 * recompute and add the counts of the parts list to the result
	 */
	private def static void recomputeAllCounts(AssureResult result, List<? extends AssureResult> parts,
		CategoryFilter filter) {
		parts.forEach [ e |
			switch e {
				ClaimResult: {
					if (e.targetReference.findClaim.evaluateRequirementFilter(filter))
						e.recomputeAllCounts(filter).addTo(result)
				}
				VerificationActivityResult: {
					val verificationActivity = e.targetReference.verificationActivity
					if (verificationActivity.evaluateVerificationMethodFilter(filter) &&
						verificationActivity.evaluateVerificationActivityFilter(filter))
						e.recomputeAllCounts(filter).addTo(result)
				}
				default:
					e.recomputeAllCounts(filter).addTo(result)
			}
		]
	}

	private def static void setAllCountstoZero(AssuranceCaseResult caseResult) {
		EcoreUtil2.eAllOfType(caseResult, AssureResult).forEach[ao|ao.resetCounts]
	}

	def static AssuranceCaseResult recomputeAllCounts(AssuranceCaseResult caseResult, CategoryFilter filter) {
		caseResult.setAllCountstoZero
		caseResult.recomputeAllCounts(caseResult.modelResult, filter)
		caseResult
	}

	private def static ModelResult recomputeAllCounts(ModelResult modelResult, CategoryFilter filter) {
		modelResult.recomputeAllCounts(modelResult.claimResult, filter)
		modelResult.recomputeAllCounts(modelResult.subsystemResult, filter)
		modelResult.recomputeAllCounts(modelResult.subAssuranceCase, filter)
		modelResult
	}

	private def static SubsystemResult recomputeAllCounts(SubsystemResult subsystemResult, CategoryFilter filter) {
		subsystemResult.recomputeAllCounts(subsystemResult.claimResult, filter)
		subsystemResult.recomputeAllCounts(subsystemResult.subsystemResult, filter)
		subsystemResult
	}

	private def static ClaimResult recomputeAllCounts(ClaimResult claimResult, CategoryFilter filter) {
		claimResult.recomputeAllCounts(claimResult.verificationActivityResult, filter)
		claimResult.recomputeAllCounts(claimResult.subClaimResult, filter)
		claimResult.recomputeAllCounts(#[claimResult.predicateResult], filter)
		claimResult
	}

	private def static VerificationActivityResult recomputeAllCounts(VerificationActivityResult vaResult,
		CategoryFilter filter) {
		if(vaResult.preconditionResult !== null) vaResult.preconditionResult.recomputeAllCounts(filter).addTo(vaResult)
		vaResult.addOwnResultStateToCount()
		if(vaResult.validationResult !== null) vaResult.validationResult.recomputeAllCounts(filter).addTo(vaResult)
		vaResult
	}

	private def static ElseResult recomputeAllCounts(ElseResult vaResult, CategoryFilter filter) {
		vaResult.didFail = ElseType.OK
		vaResult.recomputeAllCounts(vaResult.first, filter)
		if (! vaResult.first.isTBD) {
			if (vaResult.first.isSuccess) {
				vaResult.recordNoElse
			} else {
				if (vaResult.first.isFailed) {
					vaResult.recordElse(ElseType.FAIL)
					vaResult.recomputeAllCounts(vaResult.fail, filter)
				} else if (vaResult.first.isTimeout) {
					vaResult.recordElse(ElseType.TIMEOUT)
				} else if (vaResult.first.isEmpty) {
					vaResult.recordElse(ElseType.ERROR)
					vaResult.recomputeAllCounts(vaResult.error, filter)
				}
			}
		} else {
			// if ELSE first is TBD only count it since it is the only one that needs to be successful
//			vaResult.recomputeAllCounts(vaResult.error, filter)
//			vaResult.recomputeAllCounts(vaResult.fail, filter)
//			vaResult.recomputeAllCounts(vaResult.timeout, filter)
		}
		vaResult
	}

	private def static ThenResult recomputeAllCounts(ThenResult vaResult, CategoryFilter filter) {
		vaResult.didThenFail = false
		vaResult.recomputeAllCounts(vaResult.first, filter)
		if (! vaResult.first.isTBD) {
			if (vaResult.first.isSuccess) {
				vaResult.recordNoSkip
				vaResult.recomputeAllCounts(vaResult.second, filter)
			} else {
				vaResult.recordSkip
			}
		} else {
			vaResult.recomputeAllCounts(vaResult.second, filter)
		}
		vaResult
	}

	private def static ValidationResult recomputeAllCounts(ValidationResult validationResult, CategoryFilter filter) {
		validationResult.addOwnResultStateToCount()
		validationResult
	}

	private def static PreconditionResult recomputeAllCounts(PreconditionResult preconditionResult,
		CategoryFilter filter) {
		preconditionResult.addOwnResultStateToCount()
		preconditionResult
	}

	private def static PredicateResult recomputeAllCounts(PredicateResult predicateResult, CategoryFilter filter) {
		predicateResult.resetCounts
		predicateResult.addOwnResultStateToCount()
		predicateResult
	}

	private def static AssureResult recomputeAllCounts(AssureResult assureResult, CategoryFilter filter) {
		switch (assureResult) {
			AssuranceCaseResult: assureResult.recomputeAllCounts(filter)
			ModelResult: assureResult.recomputeAllCounts(filter)
			SubsystemResult: assureResult.recomputeAllCounts(filter)
			ClaimResult: assureResult.recomputeAllCounts(filter)
			PredicateResult: assureResult.recomputeAllCounts(filter)
			ValidationResult: assureResult.recomputeAllCounts(filter)
			PreconditionResult: assureResult.recomputeAllCounts(filter)
			VerificationActivityResult: assureResult.recomputeAllCounts(filter)
			ElseResult: assureResult.recomputeAllCounts(filter)
			ThenResult: assureResult.recomputeAllCounts(filter)
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

	def static void setToSuccess(VerificationResult verificationActivityResult, String message, EObject target) {
		if (message !== null && !message.isEmpty)
			verificationActivityResult.addSuccessIssue(target, message);
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.SUCCESS))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToSuccess(VerificationResult verificationActivityResult, List<Issue> rl) {
		verificationActivityResult.issues.addAll(rl);
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.SUCCESS))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToTBD(VerificationResult verificationActivityResult) {
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.TBD))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToTimeout(VerificationResult verificationActivityResult) {
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.TIMEOUT))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToError(VerificationResult verificationActivityResult) {
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.ERROR))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToError(VerificationResult verificationActivityResult, String message, EObject target) {
		verificationActivityResult.addErrorIssue(target, message);
		verificationActivityResult.setToError
	}

	def static void setToFail(VerificationResult verificationActivityResult) {
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.FAIL))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToFail(VerificationResult verificationActivityResult, String message, EObject target) {
		verificationActivityResult.addFailIssue(target, message);
		verificationActivityResult.setToFail
	}

	def static void setToFail(VerificationResult verificationActivityResult, List<Issue> rl) {
		verificationActivityResult.issues.addAll(rl);
		verificationActivityResult.setToFail
	}

	def static void setToFail(VerificationResult verificationActivityResult, Throwable e) {
		verificationActivityResult.addFailIssue(null, e.message ?: e.toString); // e.getClass().getName());
		verificationActivityResult.setToFail
	}

	def static void setToError(VerificationResult verificationActivityResult, Throwable e) {
		verificationActivityResult.addErrorIssue(null, e.message ?: e.toString); // e.getClass().getName());
		verificationActivityResult.setToError
	}

	def static void setToError(VerificationResult verificationActivityResult, String message) {
		verificationActivityResult.addErrorIssue(null, message);
		verificationActivityResult.setToError
	}

	/**
	 * the next methods update the counts for FailThen and AndThen
	 */
	def static void recordElse(ElseResult result, ElseType et) {
		if (result.didFail != ElseType.OK) {
			// was didthen from previous time
		} else {
			result.didFail = et
			result.metrics.didelseCount = result.metrics.didelseCount + 1
//			result.propagateCountChangeUp
		}
	}

	/**
	 * the next methods update the counts for FailThen and AndThen
	 * Initial didFail is false
	 */
	def static void recordNoElse(ElseResult result) {
		if (result.didFail != ElseType.OK) {
			result.didFail = ElseType.OK
			result.metrics.didelseCount = result.metrics.didelseCount - 1
//			result.propagateCountChangeUp
		} else {
			// was already no didThen
		}
	}

	/**
	 * the next methods update the counts for FailThen and AndThen
	 * returns true if change of state
	 */
	def static void recordSkip(ThenResult result) {
		if (result.didThenFail) {
			// was didAndThenFail from previous time
		} else {
			result.didThenFail = true
			result.metrics.thenskipCount = result.metrics.thenskipCount + 1
//			result.propagateCountChangeUp
		}
	}

	/**
	 * the next methods update the counts for FailThen and AndThen
	 */
	def static void recordNoSkip(ThenResult result) {
		if (result.didThenFail) {
			result.didThenFail = false
			result.metrics.thenskipCount = result.metrics.thenskipCount - 1
//			result.propagateCountChangeUp
		} else {
			// was already no didThen
		}
	}

	/**
	 * set the status and update the counts
	 * true if state changed
	 */
	def private static boolean updateOwnResultState(VerificationResult ar, VerificationResultState newState) {
		val counts = ar.metrics

		if(ar.resultState == newState) return false

		if(ar.resultState == VerificationResultState.FAIL && newState != VerificationResultState.TBD) return true
		if(ar.resultState == VerificationResultState.ERROR &&
			(newState == VerificationResultState.SUCCESS || newState == VerificationResultState.TIMEOUT)) return true
		if(ar.resultState == VerificationResultState.TIMEOUT && newState == VerificationResultState.SUCCESS) return true
		// undo old state count
		switch (ar.resultState) {
			case VerificationResultState.SUCCESS:
				counts.successCount = counts.successCount - 1
			case VerificationResultState.FAIL:
				counts.failCount = counts.failCount - 1
			case VerificationResultState.ERROR:
				counts.errorCount = counts.errorCount - 1
			case VerificationResultState.TIMEOUT:
				counts.timeoutCount = counts.timeoutCount - 1
			case VerificationResultState.TBD:
				counts.tbdCount = counts.tbdCount - 1
		}
		// do new state count
		switch (newState) {
			case VerificationResultState.SUCCESS: {
				counts.successCount = counts.successCount + 1
				ar.executionState = VerificationExecutionState.COMPLETED
			}
			case VerificationResultState.FAIL: {
				counts.failCount = counts.failCount + 1
				ar.executionState = VerificationExecutionState.COMPLETED
			}
			case VerificationResultState.ERROR: {
				counts.errorCount = counts.errorCount + 1
				ar.executionState = VerificationExecutionState.COMPLETED
			}
			case VerificationResultState.TIMEOUT: {
				counts.timeoutCount = counts.timeoutCount + 1
				ar.executionState = VerificationExecutionState.COMPLETED
			}
			case VerificationResultState.TBD: {
				counts.tbdCount = counts.tbdCount + 1
				ar.executionState = VerificationExecutionState.TODO
			}
		}

		ar.resultState = newState
		true
	}

	/**
	 * Given the state (and count) change to ar, propagate the counts up the hierarchy
	 */
	private def static void propagateCountChangeUp(AssureResult ar) {
		var parent = ar.eContainer
		while (parent !== null && parent instanceof AssureResult) {
			val parentResult = (parent as AssureResult)
			parentResult.addAllSubCounts()
			parent = parent.eContainer
		}
	}

	/**
	 * recompute the result count from the part list counts without recursing
	 */
	private def static AssuranceCaseResult addAllSubCounts(AssuranceCaseResult caseResult) {
		caseResult.resetCounts
		caseResult.modelResult.forEach[e|e.addTo(caseResult)]
		caseResult
	}

	private def static ModelResult addAllSubCounts(ModelResult modelResult) {
		modelResult.resetCounts
		modelResult.claimResult.forEach[e|e.addTo(modelResult)]
		modelResult.subsystemResult.forEach[e|e.addTo(modelResult)]
		modelResult.subAssuranceCase.forEach[e|e.addTo(modelResult)]
		modelResult
	}

	private def static SubsystemResult addAllSubCounts(SubsystemResult subsystemResult) {
		subsystemResult.resetCounts
		subsystemResult.claimResult.forEach[e|e.addTo(subsystemResult)]
		subsystemResult.subsystemResult.forEach[e|e.addTo(subsystemResult)]
		subsystemResult
	}

	private def static ClaimResult addAllSubCounts(ClaimResult claimResult) {
		claimResult.resetCounts
		claimResult.verificationActivityResult.forEach[e|e.addTo(claimResult)]
		claimResult.subClaimResult.forEach[e|e.addTo(claimResult)]
		claimResult.predicateResult.addTo(claimResult)
		claimResult
	}

	private def static VerificationActivityResult addAllSubCounts(VerificationActivityResult vaResult) {
		vaResult.resetCounts
		vaResult.preconditionResult.addTo(vaResult)
		vaResult.addPreFailCount(vaResult.preconditionResult)
		vaResult.addOwnResultStateToCount()
		vaResult.validationResult.addTo(vaResult)
		vaResult.addValidationFailCount(vaResult.validationResult)
		vaResult
	}

	private def static addPreFailCount(VerificationActivityResult ar, VerificationResult pre) {
		if(pre === null) return ar
		val counts = ar.metrics
		switch (pre.resultState) {
			case VerificationResultState.FAIL:
				counts.preconditionfailCount = counts.preconditionfailCount + 1
			case VerificationResultState.ERROR:
				counts.preconditionfailCount = counts.preconditionfailCount + 1
			case VerificationResultState.TIMEOUT:
				counts.preconditionfailCount = counts.preconditionfailCount + 1
			default: {
			}
		}
		ar
	}

	private def static addValidationFailCount(VerificationActivityResult ar, VerificationResult pre) {
		if(pre === null) return ar
		val counts = ar.metrics
		switch (pre.resultState) {
			case VerificationResultState.FAIL:
				counts.validationfailCount = counts.validationfailCount + 1
			case VerificationResultState.ERROR:
				counts.validationfailCount = counts.validationfailCount + 1
			case VerificationResultState.TIMEOUT:
				counts.validationfailCount = counts.validationfailCount + 1
			default: {
			}
		}
		ar
	}

	private def static ElseResult addAllSubCounts(ElseResult vaResult) {
		vaResult.resetCounts
		vaResult.didFail = ElseType.OK
		vaResult.first.forEach[e|e.addTo(vaResult)]
		if (! vaResult.first.isTBD) {
			if (vaResult.first.isSuccess) {
				vaResult.recordNoElse
			} else {
				if (vaResult.first.isFailed)
					vaResult.recordElse(ElseType.FAIL)
				else if (vaResult.first.isTimeout)
					vaResult.recordElse(ElseType.TIMEOUT)
				else
					vaResult.recordElse(ElseType.ERROR)
				vaResult.error.forEach[e|e.addTo(vaResult)]
				vaResult.fail.forEach[e|e.addTo(vaResult)]
				vaResult.timeout.forEach[e|e.addTo(vaResult)]
			}

		}
		vaResult
	}

	private def static ThenResult addAllSubCounts(ThenResult vaResult) {
		vaResult.resetCounts
		vaResult.didThenFail = false
		vaResult.first.forEach[e|e.addTo(vaResult)]
		if (! vaResult.first.isTBD) {
			if (vaResult.first.isSuccess) {
				vaResult.recordSkip
				vaResult.second.forEach[e|e.addTo(vaResult)]
			} else {
				vaResult.recordNoSkip
			}

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

	private def static PredicateResult addAllSubCounts(PredicateResult predicateResult) {
		predicateResult.resetCounts
		predicateResult.addOwnResultStateToCount()
		predicateResult
	}

	private def static AssureResult addAllSubCounts(AssureResult assureResult) {
		switch (assureResult) {
			AssuranceCaseResult: assureResult.addAllSubCounts
			ModelResult: assureResult.addAllSubCounts
			SubsystemResult: assureResult.addAllSubCounts
			ClaimResult: assureResult.addAllSubCounts
			ValidationResult: assureResult.addAllSubCounts
			PreconditionResult: assureResult.addAllSubCounts
			PredicateResult: assureResult.addAllSubCounts
			VerificationActivityResult: assureResult.addAllSubCounts
			ElseResult: assureResult.addAllSubCounts
			ThenResult: assureResult.addAllSubCounts
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
			case VerificationResultState.ERROR: return "[E]"
			case VerificationResultState.TIMEOUT: return "[T]"
			case VerificationResultState.TBD: return "[tbd]"
		}
	}

	def static constructLabel(AssureResult ar) {

		// has to be a string without space (ID) 
		switch (ar) {
			AssuranceCaseResult:
				return ar.name
			ModelResult:
				return ar.name
			SubsystemResult:
				return ar.name
			ClaimResult:
				return ar.target?.title ?: ar.target.name
			ValidationResult:
				return ar.target?.title ?: ar.target.name
			PreconditionResult:
				return ar.target?.title ?: ar.target.name
			VerificationActivityResult: {
				return ar.target.name
			}
		}
		return "unknown assure result type"
	}

	def static String constructMessage(VerificationActivityResult vr) {
		if(vr.message !== null) return vr.message
		return vr.constructDescription
	}

	def static String constructDescription(VerificationActivityResult vr) {
		val va = vr.target
		if(va.title !== null) return va.title
		val vm = va.method
		if(vm.description !== null) return vm.description.toText(null) // va.target)
		if(vm.title !== null) return vm.title
		return ""
	}

	def static String constructMessage(AssuranceCaseResult ce) {
		if(ce.message !== null) return ce.message
		return ""
	}

	def static String constructMessage(ModelResult ce) {
		if(ce.message !== null) return ce.message
		return ""
	}

	def static String constructMessage(SubsystemResult ce) {
		if(ce.message !== null) return ce.message
		return ""
	}

	def static String constructDescription(ModelResult ar) {
		val plan = ar.plan
		if(plan?.description !== null) return plan.description.toText(plan.target)
		if(plan.title !== null) return plan.title
		"Verified system implementation " + plan.target.getQualifiedName()
	}

	def static String successToString(AssureResult ar) {
		val cnt = ar.metrics.successCount
		if(cnt == 0) return ""
		return cnt.toString
	}

	def static String failToString(AssureResult ar) {
		val cnt = ar.metrics.failCount
		if(cnt == 0) return ""
		return cnt.toString
	}

	def static String errorToString(AssureResult ar) {
		val cnt = ar.metrics.errorCount
		if(cnt == 0) return ""
		return cnt.toString
	}

	def static String tbdToString(AssureResult ar) {
		val cnt = ar.metrics.tbdCount
		if(cnt == 0) return ""
		return cnt.toString
	}

	def static String getName(VerificationActivityResult cr) {
		if (!Aadl2Util.isNull(cr.target)) {
			return cr.target?.name
		}
		return "[unresolved:" + cr.target.toString + "]"
	}

	def static String getName(ValidationResult cr) {
		if (!Aadl2Util.isNull(cr.target)) {
			return cr.target?.name
		}
		return "[unresolved:" + cr.target.toString + "]"
	}

	def static String getName(PreconditionResult cr) {
		if (!Aadl2Util.isNull(cr.target)) {
			return cr.target?.name
		}
		return "[unresolved:" + cr.target.toString + "]"
	}

	def static String getName(AssuranceCaseResult ce) {
		return ce.name
	}

	def static String getName(ModelResult ce) {
		return ce.assuranceCaseResult.name + '.' + ce.plan.getName + "(" + ce.target.name + ")"
	}

	def static String getName(SubsystemResult ce) {
		return ce.targetSystem.name
	}

	def static String getName(ClaimResult cr) {
		val me = cr.caseTargetModelElement
		val targetElementLabel = if(me !== null) "(" + me.name + ")" else ""
		if (!Aadl2Util.isNull(cr.target)) {
			return cr.target?.name + targetElementLabel
		}
		return "[unresolved:" + cr.target.toString + "]" + targetElementLabel
	}

	def static String constructDescription(ClaimResult cr) {
		val r = cr.target
		if(r.description !== null) return r.description.toText(cr.caseTargetModelElement)
		if(r.title !== null) return r.title
		""
	}

	def static String constructMessage(ClaimResult cr) {
		if(cr.message !== null) return cr.message
		constructDescription(cr)
	}

	def static String constructMessage(ValidationResult cr) {
		if(cr.message !== null) return cr.message
		""
	}

	def static String constructMessage(PreconditionResult cr) {
		if(cr.message !== null) return cr.message
		""
	}

	def static String constructMessage(Issue ri) {
		if (ri.message !== null)
			return ri.message + if(ri.exceptionType !== null) ( " [" + ri.exceptionType + "]" ) else ""
		if(ri.exceptionType !== null) return ri.exceptionType
		""
	}

	def static String constructMessage(PredicateResult pr) {
		val pred = AssureUtilExtension.getPredicate(pr)
		if (pred instanceof ValuePredicate) {
			return (pred.eResource as XtextResource).getSerializer().serialize(pred.xpression)
		} else if (pred instanceof InformalPredicate) {
			return pred.description
		}
		return ""
	}

	def static String assureResultCounts(AssureResult ele) {
		val elec = ele.metrics
//		if (ele instanceof AssuranceCaseResult && ele.isZeroCount && ele.eContainer === null) {
//			ele.resetCounts
//			ele.recomputeAllCounts(null)
//		}
		" (S" + elec.successCount + " F" + elec.failCount + " T" + elec.timeoutCount + " E" + elec.errorCount + " tbd" +
			elec.tbdCount + " EL" + elec.didelseCount + " TS" + elec.thenskipCount + ")"
	}

	def static String assureExecutionTime(AssureResult ele) {
		val elec = ele.metrics
		"(" + elec.executionTime + " ms)"
	}

	def static String buildCaseModelElementPath(AssureResult ar) {
		switch (ar) {
			SubsystemResult:
				buildCaseModelElementPath(ar.eContainer as AssureResult) + "." + ar.targetSystem?.name
			ModelResult:
				ar.target.getQualifiedName()
			ClaimResult: {
				val res = buildCaseModelElementPath(ar.eContainer as AssureResult)
				if (ar.eContainer instanceof ClaimResult)
					res
				else if(ar.modelElement !== null) res + "." + ar.modelElement.name else res
			}
			VerificationResult:
				buildCaseModelElementPath(ar.claimResult)
			AssuranceCaseResult:
				""
		}
	}

	// manage instance model generation
	static val instanceModelRecord = Collections.synchronizedMap(newHashMap)

	def static void setInstanceModel(ComponentImplementation key, SystemInstance target) {
		instanceModelRecord.put(key.name, target)
	}

	def static void clearAllInstanceModels() {
		instanceModelRecord.clear
	}

	def static SystemInstance getInstanceModel(ComponentImplementation cimpl) {
		if(Aadl2Util.isNull(cimpl)) return null
		var si = instanceModelRecord.get(cimpl.name) as SystemInstance
		if (si === null) {

			System.out.println("\tInstantiating " + cimpl.getQualifiedName())

			// ------------Tried Method1
			si = cimpl.buildInstanceModelFile
			setInstanceModel(cimpl, si)
			System.out.println("\tFinished Instantiating " + cimpl.getQualifiedName())
		}

		si = instanceModelRecord.get(cimpl.name) as SystemInstance

		return si
	}

	def static int numberVerificationResults(AssuranceCaseResult ac) {
		return EcoreUtil2.eAllOfType(ac, typeof(VerificationActivityResult)).size();
	}

	/**
	 * convert to target unit. If target unit is null or number value has no unit return the original
	 */
	def static NumberValue convertValueToUnit(NumberValue numberValue, UnitLiteral target) {
		val unit = numberValue.unit
		if(unit === null || target === null) return numberValue
		val value = getValue(numberValue)
		val factor = unit.getAbsoluteFactor(target)
		val result = value * factor
		val resultValue = numberValue.cloneNumber
		resultValue.setUnit(target);
		setValue(resultValue, result);
		return resultValue;
	}

	def static void setValue(NumberValue numberValue, double value) {
		switch (numberValue) {
			RealLiteral: numberValue.setValue(value)
			IntegerLiteral: numberValue.setValue((value as long))
		}
	}

	def static getValue(NumberValue numberValue) {
		switch (numberValue) {
			RealLiteral: numberValue.getValue()
			IntegerLiteral: numberValue.getValue()
		}
	}

}

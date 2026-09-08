/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.assure.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.alisa.common.common.AVariableReference;
import org.osate.alisa.common.common.ComputeDeclaration;
import org.osate.alisa.common.util.CommonUtilExtension;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.ElseResult;
import org.osate.assure.assure.ModelResult;
import org.osate.assure.assure.NestedClaimReference;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.PredicateResult;
import org.osate.assure.assure.QualifiedClaimReference;
import org.osate.assure.assure.QualifiedVAReference;
import org.osate.assure.assure.QualifiedVerificationPlanElementReference;
import org.osate.assure.assure.SubsystemResult;
import org.osate.assure.assure.ThenResult;
import org.osate.assure.assure.ValidationResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationExpr;
import org.osate.assure.assure.VerificationResult;
import org.osate.categories.categories.CategoryFilter;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.ValuePredicate;
import org.osate.result.AnalysisResult;
import org.osate.result.Diagnostic;
import org.osate.result.DiagnosticType;
import org.osate.result.Result;
import org.osate.result.ResultFactory;
import org.osate.result.ResultType;
import org.osate.result.util.ResultUtil;
import org.osate.verify.internal.util.VerifyUtilExtension;
import org.osate.verify.verify.Claim;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerificationPlan;

public class AssureUtilExtension {
	private static final Map<String, SystemInstance> instanceModelRecord = Collections.synchronizedMap(new HashMap<>());

	public static SubsystemResult getEnclosingSubsystemResult(EObject assureObject) {
		if (assureObject.eContainer() == null) {
			return null;
		}
		var result = assureObject.eContainer();
		while (result != null && !(result instanceof SubsystemResult)) {
			result = result.eContainer();
		}
		return (SubsystemResult) result;
	}

	public static AssuranceCaseResult getAssuranceCaseResult(EObject assureObject) {
		var result = assureObject;
		while (result.eContainer() != null) {
			result = result.eContainer();
		}
		return (AssuranceCaseResult) result;
	}

	public static ModelResult getModelResult(EObject assureObject) {
		var result = assureObject;
		while (result != null) {
			if (result instanceof ModelResult modelResult) {
				return modelResult;
			}
			result = result.eContainer();
		}
		return null;
	}

	/*
	 * Return the component classifier associated with the ModelResult target, i.e., the AADL instance model being
	 * verified.
	 */
	public static ComponentClassifier getCaseTargetClassifier(EObject assureObject) {
		var result = assureObject;
		while (result != null) {
			result = result.eContainer();
			switch (result) {
			case ModelResult modelResult when modelResult.getTarget() != null:
				return modelResult.getTarget();
			case SubsystemResult subsystemResult when subsystemResult.getTargetSystem() != null:
				return subsystemResult.getTargetSystem().getAllClassifier();
			default:
				break;
			}
		}
		return null;
	}

	public static ClaimResult getClaimResult(EObject assureObject) {
		var result = assureObject;
		while (!(result instanceof ClaimResult)) {
			result = result.eContainer();
		}
		return (ClaimResult) result;
	}

	// Deal with qualified verification activity references.
	// The reference string constructor is in VerifyUtilExtension.
	public static VerificationPlan findVerificationPlan(NestedClaimReference reference) {
		EObject result = reference;
		while (!(result instanceof QualifiedVerificationPlanElementReference)) {
			result = result.eContainer();
		}
		return ((QualifiedVerificationPlanElementReference) result).getVerificationPlan();
	}

	public static Claim findClaim(QualifiedVAReference reference) {
		return getReferencedClaim(reference.getRequirement(), reference.getVerificationPlan().getClaim());
	}

	public static Claim getReferencedClaim(NestedClaimReference reference, Iterable<Claim> claims) {
		var referenceName = reference.getRequirement().getName();
		for (var claim : claims) {
			if (claim.getRequirement() != null && claim.getRequirement().getName() != null
					&& claim.getRequirement().getName().equalsIgnoreCase(referenceName)) {
				if (reference.getSub() != null && !claim.getSubclaim().isEmpty()) {
					return getReferencedClaim(reference.getSub(), claim.getSubclaim());
				}
				return claim;
			}
		}
		return null;
	}

	public static Claim findClaim(QualifiedClaimReference reference) {
		return getReferencedClaim(reference.getRequirement(), reference.getVerificationPlan().getClaim());
	}

	public static Requirement getTarget(ClaimResult claimResult) {
		var reference = claimResult.getTargetReference().getRequirement();
		while (reference.getSub() != null) {
			reference = reference.getSub();
		}
		return reference.getRequirement();
	}

	public static ValuePredicate getPredicate(PredicateResult predicateResult) {
		var reference = predicateResult.getTargetReference().getRequirement();
		while (reference.getSub() != null) {
			reference = reference.getSub();
		}
		return (ValuePredicate) reference.getRequirement().getPredicate();
	}

	/*
	 * Return the model element that is the target of verification.
	 */
	public static NamedElement getCaseTargetModelElement(EObject assureObject) {
		var claimResult = getClaimResult(assureObject);
		var modelElement = claimResult.getModelElement();
		if (!Aadl2Util.isNull(modelElement)) {
			return modelElement;
		}
		var requirement = getTarget(claimResult);
		return requirement == null ? null : requirement.getTargetElement();
	}

	public static SystemInstance getAssuranceCaseInstanceModel(AssureResult assureObject, boolean save) {
		var modelResult = getModelResult(assureObject);
		var classifier = modelResult == null ? null : modelResult.getTarget();
		return classifier == null ? null : getInstanceModel(classifier, save);
	}

	public static SystemInstance getExistingAssuranceCaseInstanceModel(AssureResult assureObject) {
		var modelResult = getModelResult(assureObject);
		var classifier = modelResult == null ? null : modelResult.getTarget();
		return classifier == null ? null : getExistingInstanceModel(classifier);
	}

	public static ComponentInstance findTargetSystemComponentInstance(SystemInstance systemInstance,
			SubsystemResult subsystemResult) {
		if (subsystemResult != null && subsystemResult.getTargetSystem() != null) {
			var componentInstance = findTargetSystemComponentInstance(systemInstance,
					getEnclosingSubsystemResult(subsystemResult));
			return (ComponentInstance) CommonUtilExtension.findElementInstance(componentInstance,
					subsystemResult.getTargetSystem());
		}
		return systemInstance;
	}

	public static VerificationActivity getTarget(VerificationActivityResult activityResult) {
		return activityResult.getTargetReference().getVerificationActivity();
	}

	public static VerificationMethod getMethod(VerificationResult verificationResult) {
		return switch (verificationResult) {
		case VerificationActivityResult activityResult -> getTarget(activityResult).getMethod();
		case PreconditionResult preconditionResult -> preconditionResult.getTarget();
		case ValidationResult validationResult -> validationResult.getTarget();
		case null, default -> null;
		};
	}

	/**
	 * Methods to process results from verification methods.
	 */
	public static void addMarkersAsResult(VerificationResult verificationResult, InstanceObject instance,
			String markerType, VerificationMethod verificationMethod) {
		var resource = instance.eResource();
		var file = OsateResourceUtil.toIFile(resource.getURI());

		IMarker[] markers;
		try {
			markers = file.findMarkers(markerType, true, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			setToError(verificationResult, "Could not find Markers. Instance model was not saved.", instance);
			return;
		}

		var targetUri = EcoreUtil.getURI(instance).toString();
		// Enable this to default to all messages when matchingMarkers is empty.
		var messageMatch = matchMessage(verificationMethod);
		for (var marker : markers) {
			if (matchURI((String) getMarkerAttribute(marker, AadlConstants.AADLURI), targetUri)
					&& (messageMatch.isEmpty()
							|| ((String) getMarkerAttribute(marker, IMarker.MESSAGE)).contains(messageMatch))) {
				addMarkerIssue(verificationResult, null, marker);
			}
		}

		if (verificationResult.getResults().stream().anyMatch(result -> result.getResultType() == ResultType.FAILURE)) {
			setToFail(verificationResult);
		} else if (verificationResult.getResults()
				.stream()
				.anyMatch(result -> result.getResultType() == ResultType.ERROR)) {
			setToError(verificationResult);
		} else {
			setToSuccess(verificationResult);
		}
	}

	private static Object getMarkerAttribute(IMarker marker, String attribute) {
		try {
			return marker.getAttribute(attribute);
		} catch (CoreException e) {
			return sneakyThrow(e);
		}
	}

	private static boolean matchURI(String firstUri, String secondUri) {
		return Objects.equals(firstUri, secondUri);
	}

	private static String matchMessage(VerificationMethod verificationMethod) {
		var name = verificationMethod.getName();
		if (name == null) {
			return "";
		}
		return switch (name) {
		case "MaxFlowLatencyAnalysis" -> "Maximum actual latency";
		case "MinFlowLatencyAnalysis" -> "Minimum actual latency";
		case "FlowLatencyJitterAnalysis" -> "Jitter";
		default -> "";
		};
	}

	public static Diagnostic addMarkerIssue(VerificationResult verificationResult, EObject target, IMarker marker) {
		var message = (String) getMarkerAttribute(marker, IMarker.MESSAGE);
		var severity = getMarkerAttribute(marker, IMarker.SEVERITY);
		if (Objects.equals(severity, IMarker.SEVERITY_ERROR)) {
			return addErrorIssue(verificationResult, target, message);
		} else if (Objects.equals(severity, IMarker.SEVERITY_WARNING)) {
			return addWarningIssue(verificationResult, target, message);
		} else if (Objects.equals(severity, IMarker.SEVERITY_INFO)) {
			return addInfoIssue(verificationResult, target, message);
		}
		return null;
	}

	public static Diagnostic addErrorIssue(VerificationResult verificationResult, EObject target, String message) {
		return addIssue(verificationResult, DiagnosticType.ERROR, target, message);
	}

	public static Diagnostic addIssue(VerificationResult verificationResult, DiagnosticType type, EObject target,
			String message) {
		var issue = ResultFactory.eINSTANCE.createDiagnostic();
		issue.setMessage(message == null ? "no message" : message);
		issue.setDiagnosticType(type);
		issue.setModelElement(target);
		verificationResult.getIssues().add(issue);
		return issue;
	}

	public static Diagnostic addInfoIssue(VerificationResult verificationResult, EObject target, String message) {
		return addIssue(verificationResult, DiagnosticType.INFO, target, message);
	}

	public static Diagnostic addWarningIssue(VerificationResult verificationResult, EObject target, String message) {
		return addIssue(verificationResult, DiagnosticType.WARNING, target, message);
	}

	public static void doJUnitResults(org.junit.runner.Result junitResult, Result result) {
		for (var failure : junitResult.getFailures()) {
			var issue = ResultUtil.createFailureResult(failure.getMessage(), null);
			result.getSubResults().add(issue);
		}
	}

	public static int getTotalCount(AssureResult assureResult) {
		var counts = assureResult.getMetrics();
		return counts.getErrorCount() + counts.getFailCount() + counts.getSuccessCount() + counts.getTbdCount()
				+ counts.getDidelseCount() + counts.getThenskipCount();
	}

	public static boolean isSuccessful(AssureResult assureResult) {
		var counts = assureResult.getMetrics();
		return counts.getFailCount() == 0 && counts.getErrorCount() == 0 && counts.getTbdCount() == 0
				&& counts.getSuccessCount() > 0;
	}

	public static boolean isNoSuccess(AssureResult assureResult) {
		var counts = assureResult.getMetrics();
		return counts.getFailCount() != 0 || counts.getErrorCount() != 0;
	}

	public static boolean isFail(AssureResult assureResult) {
		return assureResult.getMetrics().getFailCount() != 0;
	}

	public static boolean isError(AssureResult assureResult) {
		return assureResult.getMetrics().getErrorCount() != 0;
	}

	public static boolean isTBD(AssureResult assureResult) {
		var counts = assureResult.getMetrics();
		return counts.getFailCount() == 0 && counts.getErrorCount() == 0 && counts.getTbdCount() > 0;
	}

	public static boolean isZeroCount(AssureResult assureResult) {
		var counts = assureResult.getMetrics();
		return counts.getFailCount() == 0 && counts.getErrorCount() == 0 && counts.getTbdCount() == 0;
	}

	public static boolean isZeroTotalCount(AssureResult assureResult) {
		var counts = assureResult.getMetrics();
		return counts.getFailCount() == 0 && counts.getErrorCount() == 0 && counts.getTbdCount() == 0
				&& counts.getSuccessCount() == 0;
	}

	/**
	 * State of a VerificationResult.
	 */
	public static boolean isSuccess(VerificationResult verificationResult) {
		return verificationResult.getType() == ResultType.SUCCESS;
	}

	public static boolean isError(VerificationResult verificationResult) {
		return verificationResult.getType() == ResultType.ERROR;
	}

	public static boolean isFailed(VerificationResult verificationResult) {
		return verificationResult.getType() == ResultType.FAILURE;
	}

	/**
	 * Returns true if at least one element is TBD.
	 */
	public static boolean isTBD(EList<VerificationExpr> results) {
		for (var result : results) {
			if (isTBD(result)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if none of the elements have a failure or error.
	 */
	public static boolean isSuccess(EList<VerificationExpr> results) {
		for (var result : results) {
			if (isNoSuccess(result)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns true if none of the elements have a failure or error.
	 */
	public static boolean isSuccessFul(EList<VerificationResult> results) {
		for (var result : results) {
			if (isNoSuccess(result)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns true if at least one element has a non-zero failure or error count.
	 */
	public static boolean isNoSuccess(EList<VerificationExpr> results) {
		for (var result : results) {
			if (isNoSuccess(result)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasError(EList<VerificationExpr> results) {
		if (results.size() == 1 && results.getFirst() instanceof VerificationActivityResult activityResult) {
			return isError(activityResult);
		}
		return isNoSuccess(results);
	}

	public static boolean isFailed(EList<VerificationExpr> results) {
		return results.size() == 1 && results.getFirst() instanceof VerificationActivityResult activityResult
				&& isFailed(activityResult);
	}

	public static String constructLabel(EObject object) {
		return switch (object) {
		case SystemInstance systemInstance -> "top " + systemInstance.getComponentImplementation().getName();
		case ComponentInstance componentInstance ->
			componentInstance.getCategory().getName() + " " + componentInstance.getName();
		case ConnectionInstance connectionInstance -> connectionInstance.getName();
		case NamedElement namedElement -> namedElement.getName();
		case null, default -> "";
		};
	}

	public static String getNamePath(AssureResult assureResult) {
		if (assureResult.eContainer() == null) {
			return getPrintableName(assureResult);
		}
		return getNamePath((AssureResult) assureResult.eContainer()) + "." + getPrintableName(assureResult);
	}

	public static String getPrintableName(AssureResult assureResult) {
		return switch (assureResult) {
		case AssuranceCaseResult caseResult -> "case " + caseResult.getName();
		case ModelResult modelResult -> "plan " + getName(modelResult);
		case SubsystemResult subsystemResult -> "subsystem " + getName(subsystemResult);
		case ClaimResult claimResult -> "claim " + getName(claimResult);
		case ValidationResult validationResult -> "validation " + getName(validationResult);
		case PreconditionResult preconditionResult -> "precondition " + getName(preconditionResult);
		case VerificationActivityResult activityResult -> "evidence " + getName(activityResult);
		case ElseResult ignored -> "Else";
		case ThenResult ignored -> "Then";
		case PredicateResult ignored -> "Predicate";
		case null, default -> "";
		};
	}

	public static String getName(AssureResult assureResult) {
		return switch (assureResult) {
		case AssuranceCaseResult caseResult -> caseResult.getName();
		case ModelResult modelResult -> getName(modelResult);
		case SubsystemResult subsystemResult -> getName(subsystemResult);
		case ClaimResult claimResult -> getName(claimResult);
		case ValidationResult validationResult -> getName(validationResult);
		case PreconditionResult preconditionResult -> getName(preconditionResult);
		case VerificationActivityResult activityResult -> getName(activityResult);
		case null, default -> "";
		};
	}

	/************************
	 * Methods to deal with an assurance case instance.
	 */

	/**
	 * Resets the execution state of verification activities to TBD.
	 */
	public static void resetToTBD(AssuranceCaseResult root, CategoryFilter filter) {
		for (var verificationResult : EcoreUtil2.eAllOfType(root, VerificationResult.class)) {
			if (filter == null) {
				verificationResult.setType(ResultType.TBD);
				verificationResult.getIssues().clear();
			} else if (verificationResult instanceof VerificationActivityResult activityResult) {
				var activity = activityResult.getTargetReference().getVerificationActivity();
				if (VerifyUtilExtension.evaluateVerificationMethodFilter(activity, filter)
						&& VerifyUtilExtension.evaluateVerificationActivityFilter(activity, filter)) {
					activityResult.setType(ResultType.TBD);
					activityResult.getIssues().clear();
				}
			}
		}
	}

	/**
	 * Resets a result's accumulated counts.
	 */
	private static void resetCounts(AssureResult result) {
		var counts = result.getMetrics();
		counts.setFailCount(0);
		counts.setSuccessCount(0);
		counts.setErrorCount(0);
		counts.setThenskipCount(0);
		counts.setDidelseCount(0);
		counts.setTbdCount(0);
		counts.setPreconditionfailCount(0);
		counts.setValidationfailCount(0);
		counts.setFeaturesCount(0);
		counts.setFeaturesRequirementsCount(0);
		counts.setExecutionTime(0);
	}

	/**
	 * Updates the counts to reflect the result's own status.
	 */
	private static VerificationResult addOwnResultStateToCount(VerificationResult result) {
		var counts = result.getMetrics();
		if (result.getType() != null) {
			switch (result.getType()) {
			case SUCCESS -> counts.setSuccessCount(counts.getSuccessCount() + 1);
			case FAILURE -> counts.setFailCount(counts.getFailCount() + 1);
			case ERROR -> counts.setErrorCount(counts.getErrorCount() + 1);
			case TBD -> counts.setTbdCount(counts.getTbdCount() + 1);
			default -> {
			}
			}
		}
		return result;
	}

	/**
	 * Adds all but the total count from a subresult to its containing result.
	 */
	private static void addTo(AssureResult subresult, AssureResult result) {
		if (subresult == null) {
			return;
		}
		var counts = result.getMetrics();
		var subcounts = subresult.getMetrics();
		counts.setFailCount(counts.getFailCount() + subcounts.getFailCount());
		counts.setSuccessCount(counts.getSuccessCount() + subcounts.getSuccessCount());
		counts.setErrorCount(counts.getErrorCount() + subcounts.getErrorCount());
		counts.setThenskipCount(counts.getThenskipCount() + subcounts.getThenskipCount());
		counts.setDidelseCount(counts.getDidelseCount() + subcounts.getDidelseCount());
		counts.setTbdCount(counts.getTbdCount() + subcounts.getTbdCount());
		counts.setPreconditionfailCount(counts.getPreconditionfailCount() + subcounts.getPreconditionfailCount());
		counts.setValidationfailCount(counts.getValidationfailCount() + subcounts.getValidationfailCount());
		counts.setFeaturesCount(counts.getFeaturesCount() + subcounts.getFeaturesCount());
		counts.setFeaturesRequirementsCount(
				counts.getFeaturesRequirementsCount() + subcounts.getFeaturesRequirementsCount());
	}

	/**
	 * Recomputes and adds the counts of the parts list to the result.
	 */
	private static void recomputeAllCounts(AssureResult result, List<? extends AssureResult> parts,
			CategoryFilter filter) {
		for (var part : parts) {
			switch (part) {
			case ClaimResult claimResult -> {
				if (VerifyUtilExtension.evaluateRequirementFilter(findClaim(claimResult.getTargetReference()),
						filter)) {
					addTo(recomputeAllCounts(claimResult, filter), result);
				}
			}
			case VerificationActivityResult activityResult -> {
				var activity = activityResult.getTargetReference().getVerificationActivity();
				if (VerifyUtilExtension.evaluateVerificationMethodFilter(activity, filter)
						&& VerifyUtilExtension.evaluateVerificationActivityFilter(activity, filter)) {
					addTo(recomputeAllCounts(activityResult, filter), result);
				}
			}
			case null, default -> addTo(recomputeAllCounts(part, filter), result);
			}
		}
	}

	private static void setAllCountstoZero(AssuranceCaseResult caseResult) {
		for (var result : EcoreUtil2.eAllOfType(caseResult, AssureResult.class)) {
			resetCounts(result);
		}
	}

	public static AssuranceCaseResult recomputeAllCounts(AssuranceCaseResult caseResult, CategoryFilter filter) {
		setAllCountstoZero(caseResult);
		recomputeAllCounts(caseResult, caseResult.getModelResult(), filter);
		return caseResult;
	}

	private static ModelResult recomputeAllCounts(ModelResult modelResult, CategoryFilter filter) {
		recomputeAllCounts(modelResult, modelResult.getClaimResult(), filter);
		recomputeAllCounts(modelResult, modelResult.getSubsystemResult(), filter);
		return modelResult;
	}

	private static SubsystemResult recomputeAllCounts(SubsystemResult subsystemResult, CategoryFilter filter) {
		recomputeAllCounts(subsystemResult, subsystemResult.getClaimResult(), filter);
		recomputeAllCounts(subsystemResult, subsystemResult.getSubsystemResult(), filter);
		return subsystemResult;
	}

	private static ClaimResult recomputeAllCounts(ClaimResult claimResult, CategoryFilter filter) {
		recomputeAllCounts(claimResult, claimResult.getVerificationActivityResult(), filter);
		recomputeAllCounts(claimResult, claimResult.getSubClaimResult(), filter);
		recomputeAllCounts(claimResult, Collections.singletonList(claimResult.getPredicateResult()), filter);
		return claimResult;
	}

	private static VerificationActivityResult recomputeAllCounts(VerificationActivityResult activityResult,
			CategoryFilter filter) {
		if (activityResult.getPreconditionResult() != null) {
			addTo(recomputeAllCounts(activityResult.getPreconditionResult(), filter), activityResult);
		}
		addOwnResultStateToCount(activityResult);
		if (activityResult.getValidationResult() != null) {
			addTo(recomputeAllCounts(activityResult.getValidationResult(), filter), activityResult);
		}
		return activityResult;
	}

	private static ElseResult recomputeAllCounts(ElseResult elseResult, CategoryFilter filter) {
		elseResult.setDidFail(ResultType.SUCCESS);
		recomputeAllCounts(elseResult, elseResult.getFirst(), filter);
		if (!isTBD(elseResult.getFirst())) {
			if (isSuccess(elseResult.getFirst())) {
				recordNoElse(elseResult);
			} else if (isFailed(elseResult.getFirst())) {
				recordElse(elseResult, ResultType.FAILURE);
				recomputeAllCounts(elseResult, elseResult.getFail(), filter);
			} else if (elseResult.getFirst().isEmpty()) {
				recordElse(elseResult, ResultType.ERROR);
				recomputeAllCounts(elseResult, elseResult.getError(), filter);
			}
		}
		return elseResult;
	}

	private static ThenResult recomputeAllCounts(ThenResult thenResult, CategoryFilter filter) {
		thenResult.setDidThenFail(false);
		recomputeAllCounts(thenResult, thenResult.getFirst(), filter);
		if (!isTBD(thenResult.getFirst())) {
			if (isSuccess(thenResult.getFirst())) {
				recordNoSkip(thenResult);
				recomputeAllCounts(thenResult, thenResult.getSecond(), filter);
			} else {
				recordSkip(thenResult);
			}
		} else {
			recomputeAllCounts(thenResult, thenResult.getSecond(), filter);
		}
		return thenResult;
	}

	private static ValidationResult recomputeAllCounts(ValidationResult validationResult, CategoryFilter filter) {
		addOwnResultStateToCount(validationResult);
		return validationResult;
	}

	private static PreconditionResult recomputeAllCounts(PreconditionResult preconditionResult, CategoryFilter filter) {
		addOwnResultStateToCount(preconditionResult);
		return preconditionResult;
	}

	private static PredicateResult recomputeAllCounts(PredicateResult predicateResult, CategoryFilter filter) {
		resetCounts(predicateResult);
		addOwnResultStateToCount(predicateResult);
		return predicateResult;
	}

	private static AssureResult recomputeAllCounts(AssureResult assureResult, CategoryFilter filter) {
		return switch (assureResult) {
		case AssuranceCaseResult caseResult -> recomputeAllCounts(caseResult, filter);
		case ModelResult modelResult -> recomputeAllCounts(modelResult, filter);
		case SubsystemResult subsystemResult -> recomputeAllCounts(subsystemResult, filter);
		case ClaimResult claimResult -> recomputeAllCounts(claimResult, filter);
		case PredicateResult predicateResult -> recomputeAllCounts(predicateResult, filter);
		case ValidationResult validationResult -> recomputeAllCounts(validationResult, filter);
		case PreconditionResult preconditionResult -> recomputeAllCounts(preconditionResult, filter);
		case VerificationActivityResult activityResult -> recomputeAllCounts(activityResult, filter);
		case ElseResult elseResult -> recomputeAllCounts(elseResult, filter);
		case ThenResult thenResult -> recomputeAllCounts(thenResult, filter);
		case null, default -> null;
		};
	}

	/**
	 * Methods to incrementally set the state of a verification activity and propagate the state change up the hierarchy.
	 */
	public static void setToSuccess(VerificationResult verificationResult) {
		if (updateOwnResultState(verificationResult, ResultType.SUCCESS)) {
			propagateCountChangeUp(verificationResult);
		}
	}

	public static void setToSuccess(VerificationResult verificationResult, List<Diagnostic> issues) {
		verificationResult.getIssues().addAll(issues);
		if (updateOwnResultState(verificationResult, ResultType.SUCCESS)) {
			propagateCountChangeUp(verificationResult);
		}
	}

	public static void setToTBD(VerificationResult verificationResult) {
		if (updateOwnResultState(verificationResult, ResultType.TBD)) {
			propagateCountChangeUp(verificationResult);
		}
	}

	public static void setToError(VerificationResult verificationResult) {
		if (updateOwnResultState(verificationResult, ResultType.ERROR)) {
			propagateCountChangeUp(verificationResult);
		}
	}

	public static void setToError(VerificationResult verificationResult, String message, EObject target) {
		addErrorIssue(verificationResult, target, message);
		setToError(verificationResult);
	}

	public static void setToFail(VerificationResult verificationResult) {
		if (updateOwnResultState(verificationResult, ResultType.FAILURE)) {
			propagateCountChangeUp(verificationResult);
		}
	}

	public static void setToFail(VerificationResult verificationResult, List<Diagnostic> issues) {
		verificationResult.getIssues().addAll(issues);
		setToFail(verificationResult);
	}

	public static void setToFail(VerificationResult verificationResult, Throwable throwable) {
		addErrorIssue(verificationResult, null,
				throwable.getMessage() == null ? throwable.toString() : throwable.getMessage());
		setToFail(verificationResult);
	}

	public static void setToError(VerificationResult verificationResult, Throwable throwable) {
		addErrorIssue(verificationResult, null,
				throwable.getMessage() == null ? throwable.toString() : throwable.getMessage());
		setToError(verificationResult);
	}

	public static void setToError(VerificationResult verificationResult, String message) {
		addErrorIssue(verificationResult, null, message);
		setToError(verificationResult);
	}

	/**
	 * Updates the counts for ElseResult.
	 */
	public static void recordElse(ElseResult result, ResultType failureType) {
		if (result.getDidFail() == ResultType.SUCCESS) {
			result.setDidFail(failureType);
			result.getMetrics().setDidelseCount(result.getMetrics().getDidelseCount() + 1);
		}
	}

	/**
	 * Updates the counts for ElseResult when the alternate branch is not used.
	 */
	public static void recordNoElse(ElseResult result) {
		if (result.getDidFail() != ResultType.SUCCESS) {
			result.setDidFail(ResultType.SUCCESS);
			result.getMetrics().setDidelseCount(result.getMetrics().getDidelseCount() - 1);
		}
	}

	/**
	 * Updates the counts for a skipped ThenResult successor.
	 */
	public static void recordSkip(ThenResult result) {
		if (!result.isDidThenFail()) {
			result.setDidThenFail(true);
			result.getMetrics().setThenskipCount(result.getMetrics().getThenskipCount() + 1);
		}
	}

	/**
	 * Updates the counts when a ThenResult successor is not skipped.
	 */
	public static void recordNoSkip(ThenResult result) {
		if (result.isDidThenFail()) {
			result.setDidThenFail(false);
			result.getMetrics().setThenskipCount(result.getMetrics().getThenskipCount() - 1);
		}
	}

	/**
	 * Sets the status and updates the counts.
	 *
	 * @return true if the state changed
	 */
	private static boolean updateOwnResultState(VerificationResult result, ResultType newState) {
		var counts = result.getMetrics();
		if (result.getType() == newState) {
			return false;
		}
		if (result.getType() == ResultType.FAILURE && newState != ResultType.TBD) {
			return true;
		}
		if (result.getType() == ResultType.ERROR && newState == ResultType.SUCCESS) {
			return true;
		}

		if (result.getType() != null) {
			switch (result.getType()) {
			case SUCCESS -> counts.setSuccessCount(counts.getSuccessCount() - 1);
			case FAILURE -> counts.setFailCount(counts.getFailCount() - 1);
			case ERROR -> counts.setErrorCount(counts.getErrorCount() - 1);
			case TBD -> counts.setTbdCount(counts.getTbdCount() - 1);
			default -> {
			}
			}
		}
		if (newState != null) {
			switch (newState) {
			case SUCCESS -> counts.setSuccessCount(counts.getSuccessCount() + 1);
			case FAILURE -> counts.setFailCount(counts.getFailCount() + 1);
			case ERROR -> counts.setErrorCount(counts.getErrorCount() + 1);
			case TBD -> counts.setTbdCount(counts.getTbdCount() + 1);
			default -> {
			}
			}
		}
		result.setType(newState);
		return true;
	}

	/**
	 * Propagates a result's count change up the hierarchy.
	 */
	private static void propagateCountChangeUp(AssureResult assureResult) {
		var parent = assureResult.eContainer();
		while (parent instanceof AssureResult parentResult) {
			addAllSubCounts(parentResult);
			parent = parent.eContainer();
		}
	}

	/**
	 * Recomputes a result's count from its immediate parts without recursing.
	 */
	private static AssuranceCaseResult addAllSubCounts(AssuranceCaseResult caseResult) {
		resetCounts(caseResult);
		for (var modelResult : caseResult.getModelResult()) {
			addTo(modelResult, caseResult);
		}
		return caseResult;
	}

	private static ModelResult addAllSubCounts(ModelResult modelResult) {
		resetCounts(modelResult);
		for (var claimResult : modelResult.getClaimResult()) {
			addTo(claimResult, modelResult);
		}
		for (var subsystemResult : modelResult.getSubsystemResult()) {
			addTo(subsystemResult, modelResult);
		}
		return modelResult;
	}

	private static SubsystemResult addAllSubCounts(SubsystemResult subsystemResult) {
		resetCounts(subsystemResult);
		for (var claimResult : subsystemResult.getClaimResult()) {
			addTo(claimResult, subsystemResult);
		}
		for (var nestedSubsystemResult : subsystemResult.getSubsystemResult()) {
			addTo(nestedSubsystemResult, subsystemResult);
		}
		return subsystemResult;
	}

	private static ClaimResult addAllSubCounts(ClaimResult claimResult) {
		resetCounts(claimResult);
		for (var activityResult : claimResult.getVerificationActivityResult()) {
			addTo(activityResult, claimResult);
		}
		for (var subclaimResult : claimResult.getSubClaimResult()) {
			addTo(subclaimResult, claimResult);
		}
		addTo(claimResult.getPredicateResult(), claimResult);
		return claimResult;
	}

	private static VerificationActivityResult addAllSubCounts(VerificationActivityResult activityResult) {
		resetCounts(activityResult);
		addTo(activityResult.getPreconditionResult(), activityResult);
		addPreFailCount(activityResult, activityResult.getPreconditionResult());
		addOwnResultStateToCount(activityResult);
		addTo(activityResult.getValidationResult(), activityResult);
		addValidationFailCount(activityResult, activityResult.getValidationResult());
		return activityResult;
	}

	private static VerificationActivityResult addPreFailCount(VerificationActivityResult activityResult,
			VerificationResult preconditionResult) {
		if (preconditionResult == null) {
			return activityResult;
		}
		if (preconditionResult.getType() == ResultType.FAILURE || preconditionResult.getType() == ResultType.ERROR) {
			var counts = activityResult.getMetrics();
			counts.setPreconditionfailCount(counts.getPreconditionfailCount() + 1);
		}
		return activityResult;
	}

	private static VerificationActivityResult addValidationFailCount(VerificationActivityResult activityResult,
			VerificationResult validationResult) {
		if (validationResult == null) {
			return activityResult;
		}
		if (validationResult.getType() == ResultType.FAILURE || validationResult.getType() == ResultType.ERROR) {
			var counts = activityResult.getMetrics();
			counts.setValidationfailCount(counts.getValidationfailCount() + 1);
		}
		return activityResult;
	}

	private static ElseResult addAllSubCounts(ElseResult elseResult) {
		resetCounts(elseResult);
		elseResult.setDidFail(ResultType.SUCCESS);
		for (var result : elseResult.getFirst()) {
			addTo(result, elseResult);
		}
		if (!isTBD(elseResult.getFirst())) {
			if (isSuccess(elseResult.getFirst())) {
				recordNoElse(elseResult);
			} else {
				recordElse(elseResult, isFailed(elseResult.getFirst()) ? ResultType.FAILURE : ResultType.ERROR);
				for (var result : elseResult.getError()) {
					addTo(result, elseResult);
				}
				for (var result : elseResult.getFail()) {
					addTo(result, elseResult);
				}
				for (var result : elseResult.getTimeout()) {
					addTo(result, elseResult);
				}
			}
		}
		return elseResult;
	}

	private static ThenResult addAllSubCounts(ThenResult thenResult) {
		resetCounts(thenResult);
		thenResult.setDidThenFail(false);
		for (var result : thenResult.getFirst()) {
			addTo(result, thenResult);
		}
		if (!isTBD(thenResult.getFirst())) {
			if (isSuccess(thenResult.getFirst())) {
				recordSkip(thenResult);
				for (var result : thenResult.getSecond()) {
					addTo(result, thenResult);
				}
			} else {
				recordNoSkip(thenResult);
			}
		}
		return thenResult;
	}

	private static ValidationResult addAllSubCounts(ValidationResult validationResult) {
		resetCounts(validationResult);
		addOwnResultStateToCount(validationResult);
		return validationResult;
	}

	private static PreconditionResult addAllSubCounts(PreconditionResult preconditionResult) {
		resetCounts(preconditionResult);
		addOwnResultStateToCount(preconditionResult);
		return preconditionResult;
	}

	private static PredicateResult addAllSubCounts(PredicateResult predicateResult) {
		resetCounts(predicateResult);
		addOwnResultStateToCount(predicateResult);
		return predicateResult;
	}

	private static AssureResult addAllSubCounts(AssureResult assureResult) {
		return switch (assureResult) {
		case AssuranceCaseResult caseResult -> addAllSubCounts(caseResult);
		case ModelResult modelResult -> addAllSubCounts(modelResult);
		case SubsystemResult subsystemResult -> addAllSubCounts(subsystemResult);
		case ClaimResult claimResult -> addAllSubCounts(claimResult);
		case ValidationResult validationResult -> addAllSubCounts(validationResult);
		case PreconditionResult preconditionResult -> addAllSubCounts(preconditionResult);
		case PredicateResult predicateResult -> addAllSubCounts(predicateResult);
		case VerificationActivityResult activityResult -> addAllSubCounts(activityResult);
		case ElseResult elseResult -> addAllSubCounts(elseResult);
		case ThenResult thenResult -> addAllSubCounts(thenResult);
		case null, default -> null;
		};
	}

	public static String constructLabel(AssureResult assureResult) {
		// The result must be a string without spaces because it is used as an ID.
		return switch (assureResult) {
		case AssuranceCaseResult caseResult -> caseResult.getName();
		case ModelResult modelResult -> getName(modelResult);
		case SubsystemResult subsystemResult -> getName(subsystemResult);
		case ClaimResult claimResult -> {
			var target = getTarget(claimResult);
			yield target.getTitle() != null ? target.getTitle() : target.getName();
		}
		case ValidationResult validationResult -> {
			var target = validationResult.getTarget();
			yield target.getTitle() != null ? target.getTitle() : target.getName();
		}
		case PreconditionResult preconditionResult -> {
			var target = preconditionResult.getTarget();
			yield target.getTitle() != null ? target.getTitle() : target.getName();
		}
		case VerificationActivityResult activityResult -> getTarget(activityResult).getName();
		case null, default -> "unknown assure result type";
		};
	}

	public static String constructMessage(VerificationActivityResult activityResult) {
		return activityResult.getMessage() != null ? activityResult.getMessage() : constructDescription(activityResult);
	}

	public static String constructDescription(VerificationActivityResult activityResult) {
		var activity = getTarget(activityResult);
		if (activity == null) {
			return "";
		}
		if (activity.getTitle() != null) {
			return activity.getTitle();
		}
		var method = activity.getMethod();
		if (method == null) {
			return "";
		}
		if (method.getDescription() != null) {
			return CommonUtilExtension.toText(method.getDescription(), getCaseTargetModelElement(activityResult));
		}
		return method.getTitle() == null ? "" : method.getTitle();
	}

	public static String constructMessage(AssuranceCaseResult caseResult) {
		return caseResult.getMessage() == null ? "" : caseResult.getMessage();
	}

	public static String constructMessage(ModelResult modelResult) {
		return modelResult.getMessage() == null ? "" : modelResult.getMessage();
	}

	public static String constructMessage(SubsystemResult subsystemResult) {
		return subsystemResult.getMessage() == null ? "" : subsystemResult.getMessage();
	}

	public static String constructDescription(ModelResult modelResult) {
		var plan = modelResult.getPlan();
		if (plan == null) {
			return "";
		}
		if (plan.getDescription() != null) {
			return CommonUtilExtension.toText(plan.getDescription(), plan.getTarget());
		}
		if (plan.getTitle() != null) {
			return plan.getTitle();
		}
		if (plan.getTarget() == null) {
			return "";
		}
		return "Verified component implementation " + plan.getTarget().getQualifiedName();
	}

	public static String successToString(AssureResult assureResult) {
		var count = assureResult.getMetrics().getSuccessCount();
		return count == 0 ? "" : Integer.toString(count);
	}

	public static String failToString(AssureResult assureResult) {
		var count = assureResult.getMetrics().getFailCount();
		return count == 0 ? "" : Integer.toString(count);
	}

	public static String errorToString(AssureResult assureResult) {
		var count = assureResult.getMetrics().getErrorCount();
		return count == 0 ? "" : Integer.toString(count);
	}

	public static String tbdToString(AssureResult assureResult) {
		var count = assureResult.getMetrics().getTbdCount();
		return count == 0 ? "" : Integer.toString(count);
	}

	public static String getName(VerificationActivityResult activityResult) {
		if (!Aadl2Util.isNull(getTarget(activityResult))) {
			return getTarget(activityResult).getName();
		}
		return "[unresolved:" + getTarget(activityResult).toString() + "]";
	}

	public static String getName(ValidationResult validationResult) {
		if (!Aadl2Util.isNull(validationResult.getTarget())) {
			return validationResult.getTarget().getName();
		}
		return "[unresolved:" + validationResult.getTarget().toString() + "]";
	}

	public static String getName(PreconditionResult preconditionResult) {
		if (!Aadl2Util.isNull(preconditionResult.getTarget())) {
			return preconditionResult.getTarget().getName();
		}
		return "[unresolved:" + preconditionResult.getTarget().toString() + "]";
	}

	public static String getName(AssuranceCaseResult caseResult) {
		return caseResult.getName();
	}

	public static String getName(ModelResult modelResult) {
		return getAssuranceCaseResult(modelResult).getName() + "." + modelResult.getPlan().getName() + "("
				+ modelResult.getTarget().getName() + ")";
	}

	public static String getName(SubsystemResult subsystemResult) {
		return subsystemResult.getTargetSystem().getName();
	}

	public static String getName(ClaimResult claimResult) {
		var modelElement = getCaseTargetModelElement(claimResult);
		var targetElementLabel = modelElement == null ? "" : "(" + modelElement.getName() + ")";
		if (!Aadl2Util.isNull(getTarget(claimResult))) {
			return getTarget(claimResult).getName() + targetElementLabel;
		}
		return "[unresolved:" + getTarget(claimResult).toString() + "]" + targetElementLabel;
	}

	public static String constructDescription(ClaimResult claimResult) {
		var requirement = getTarget(claimResult);
		if (requirement == null) {
			return "";
		}

		var instanceRoot = getExistingAssuranceCaseInstanceModel(claimResult);
		var targetElement = getCaseTargetModelElement(claimResult);
		NamedElement target = targetElement;
		if (instanceRoot != null) {
			var targetComponent = findTargetSystemComponentInstance(instanceRoot,
					getEnclosingSubsystemResult(claimResult));
			if (targetComponent != null) {
				if (targetElement != null && targetElement.getName() != null) {
					target = CommonUtilExtension.findElementInstance(targetComponent, targetElement);
				} else {
					target = targetComponent;
				}
			}
		} else if (targetElement != null && targetElement.getName() != null) {
			target = targetElement;
		} else {
			var modelResult = getModelResult(claimResult);
			target = modelResult == null ? null : modelResult.getTarget();
		}

		if (requirement.getDescription() != null && target != null) {
			return CommonUtilExtension.toText(requirement.getDescription(), target);
		}
		return requirement.getTitle() == null ? "" : requirement.getTitle();
	}

	public static String constructMessage(ClaimResult claimResult) {
		return claimResult.getMessage() == null ? constructDescription(claimResult) : claimResult.getMessage();
	}

	public static String constructMessage(ValidationResult validationResult) {
		return validationResult.getMessage() == null ? "" : validationResult.getMessage();
	}

	public static String constructMessage(PreconditionResult preconditionResult) {
		return preconditionResult.getMessage() == null ? "" : preconditionResult.getMessage();
	}

	public static String constructMessage(Diagnostic diagnostic) {
		return diagnostic.getMessage() == null ? "" : diagnostic.getMessage();
	}

	public static String constructMessage(Result result) {
		return result.getMessage() == null ? "" : result.getMessage();
	}

	/**
	 * @since 2.0
	 */
	public static String constructMessage(AnalysisResult result) {
		var message = result.getMessage() == null ? "" : result.getMessage();
		return result.getAnalysis() + ": " + message + " for " + ((NamedElement) result.getModelElement()).getName();
	}

	public static String constructMessage(PredicateResult predicateResult) {
		var predicate = getPredicate(predicateResult);
		if (predicate != null) {
			try {
				return ((XtextResource) predicate.eResource()).getSerializer().serialize(predicate.getXpression());
			} catch (NullPointerException e) {
				return "<none>";
			}
		}
		return "";
	}

	public static String assureExecutionTime(AssureResult assureResult) {
		return "(" + assureResult.getMetrics().getExecutionTime() + " ms)";
	}

	public static String buildCaseModelElementPath(AssureResult assureResult) {
		return switch (assureResult) {
		case SubsystemResult subsystemResult ->
			buildCaseModelElementPath((AssureResult) subsystemResult.eContainer()) + "."
					+ (subsystemResult.getTargetSystem() == null ? null : subsystemResult.getTargetSystem().getName());
		case ModelResult modelResult -> modelResult.getTarget().getQualifiedName();
		case ClaimResult claimResult -> {
			var result = buildCaseModelElementPath((AssureResult) claimResult.eContainer());
			if (claimResult.eContainer() instanceof ClaimResult) {
				yield result;
			}
			yield claimResult.getModelElement() == null ? result
					: result + "." + claimResult.getModelElement().getName();
		}
		case VerificationResult verificationResult -> buildCaseModelElementPath(getClaimResult(verificationResult));
		case AssuranceCaseResult ignored -> "";
		case null, default -> null;
		};
	}

	// Manage instance model generation.
	public static void setInstanceModel(ComponentImplementation key, SystemInstance target) {
		instanceModelRecord.put(key.getName(), target);
	}

	public static void clearAllInstanceModels() {
		instanceModelRecord.clear();
	}

	public static SystemInstance getInstanceModel(ComponentImplementation componentImplementation, boolean save) {
		if (Aadl2Util.isNull(componentImplementation)) {
			return null;
		}
		var systemInstance = instanceModelRecord.get(componentImplementation.getName());
		if (systemInstance == null) {
			try {
				systemInstance = InstantiateModel.instantiate(componentImplementation);
				if (save && systemInstance.eResource() != null) {
					systemInstance.eResource().save(null);
				}
			} catch (Exception e) {
				return sneakyThrow(e);
			}
			setInstanceModel(componentImplementation, systemInstance);
		}
		return systemInstance;
	}

	public static SystemInstance getExistingInstanceModel(ComponentImplementation componentImplementation) {
		if (Aadl2Util.isNull(componentImplementation)) {
			return null;
		}
		return instanceModelRecord.get(componentImplementation.getName());
	}

	public static int numberVerificationResults(AssuranceCaseResult caseResult) {
		return EcoreUtil2.eAllOfType(caseResult, VerificationActivityResult.class).size();
	}

	/**
	 * Converts a number to the target unit. If the target unit is null or the number has no unit, returns the original.
	 */
	public static NumberValue convertValueToUnit(NumberValue numberValue, UnitLiteral target) {
		var unit = numberValue.getUnit();
		if (unit == null || target == null) {
			return numberValue;
		}
		var resultValue = numberValue.cloneNumber();
		resultValue.setUnit(target);
		setValue(resultValue, getValue(numberValue) * unit.getAbsoluteFactor(target));
		return resultValue;
	}

	public static void setValue(NumberValue numberValue, double value) {
		switch (numberValue) {
		case RealLiteral realLiteral -> realLiteral.setValue(value);
		case IntegerLiteral integerLiteral -> integerLiteral.setValue((long) value);
		case null, default -> {
		}
		}
	}

	public static double getValue(NumberValue numberValue) {
		return switch (numberValue) {
		case RealLiteral realLiteral -> realLiteral.getValue();
		case IntegerLiteral integerLiteral -> integerLiteral.getValue();
		case null, default -> 0.0;
		};
	}

	public static boolean containsComputeVariables(ValuePredicate predicate) {
		for (AVariableReference variableReference : EcoreUtil2.getAllContentsOfType(predicate,
				AVariableReference.class)) {
			if (variableReference.getVariable() instanceof ComputeDeclaration) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private static <E extends Throwable, T> T sneakyThrow(Throwable throwable) throws E {
		throw (E) throwable;
	}
}

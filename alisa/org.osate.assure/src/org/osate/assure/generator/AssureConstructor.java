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
package org.osate.assure.generator;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.alisa.common.common.TargetType;
import org.osate.alisa.common.util.CommonUtilExtension;
import org.osate.alisa.workbench.alisa.AssuranceCase;
import org.osate.alisa.workbench.alisa.AssurancePlan;
import org.osate.alisa.workbench.util.IAlisaGlobalReferenceFinder;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.assure.AssureFactory;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.ModelResult;
import org.osate.assure.assure.NestedClaimReference;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.PredicateResult;
import org.osate.assure.assure.QualifiedClaimReference;
import org.osate.assure.assure.QualifiedVAReference;
import org.osate.assure.assure.SubsystemResult;
import org.osate.assure.assure.ValidationResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationExpr;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.pluginsupport.ExecuteJavaUtil;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.RequirementSet;
import org.osate.reqspec.reqSpec.ValuePredicate;
import org.osate.reqspec.util.IReqspecGlobalReferenceFinder;
import org.osate.reqspec.util.ReqSpecUtilExtension;
import org.osate.result.ResultType;
import org.osate.verify.internal.util.IVerifyGlobalReferenceFinder;
import org.osate.verify.internal.util.VerifyUtilExtension;
import org.osate.verify.verify.AllExpr;
import org.osate.verify.verify.ArgumentExpr;
import org.osate.verify.verify.Claim;
import org.osate.verify.verify.ElseExpr;
import org.osate.verify.verify.RefExpr;
import org.osate.verify.verify.ThenExpr;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationCondition;
import org.osate.verify.verify.VerificationPlan;
import org.osate.verify.verify.VerificationPrecondition;
import org.osate.verify.verify.VerificationValidation;

import com.google.inject.Inject;

/**
 * Constructs assurance-case result models from ALISA assurance and verification plans.
 */
public class AssureConstructor implements IAssureConstructor {
	private final AssureFactory factory = AssureFactory.eINSTANCE;

	private EList<VerificationPlan> globalPlans;
	private EList<Claim> globalClaims;
	private boolean isRoot = true;

	@Inject
	private IAlisaGlobalReferenceFinder arefFinder;

	@Inject
	private IReqspecGlobalReferenceFinder rRreferenceFinder;

	@Inject
	private IVerifyGlobalReferenceFinder vReferenceFinder;

	@Override
	public AssuranceCaseResult generateFullAssuranceCase(AssuranceCase acs) {
		globalPlans = new UniqueEList<>();
		globalClaims = new UniqueEList<>();
		isRoot = true;
		return constructAssuranceCaseResult(acs, null);
	}

	public AssuranceCaseResult constructAssuranceCaseResult(AssuranceCase acs, ComponentClassifier classifier) {
		var caseResult = factory.createAssuranceCaseResult();
		caseResult.setName(acs.getName());
		caseResult.setMetrics(factory.createMetrics());
		caseResult.getMetrics().setTbdCount(0);

		for (var assurancePlan : acs.getAssurancePlans()) {
			if (CommonUtilExtension.isSameorExtends(assurancePlan.getTarget(), acs.getSystem()) && (classifier == null
					|| CommonUtilExtension.isSameorExtends(classifier, assurancePlan.getTarget()))) {
				// Only plans that relate to the assurance case directly.
				var modelResult = constructModelResult(assurancePlan);
				if (modelResult != null) {
					caseResult.getModelResult().add(modelResult);
				}
			}
		}
		return caseResult;
	}

	public ModelResult constructModelResult(AssurancePlan assurancePlan) {
		// Deal with assurance-wide global plans.
		Iterable<VerificationPlan> plans = List.of();
		ComponentClassifier classifier = null;
		if (assurancePlan != null) {
			plans = assurancePlan.getAssure();
			classifier = assurancePlan.getTarget();
			if (!plans.iterator().hasNext() && !Aadl2Util.isNull(classifier)) {
				plans = vReferenceFinder.getVerificationPlans(classifier, assurancePlan);
			}
			globalPlans.addAll(assurancePlan.getAssureGlobal());
		}

		var modelResult = factory.createModelResult();
		modelResult.setPlan(assurancePlan);
		modelResult.setTarget(assurancePlan.getTarget());
		modelResult.setMetrics(factory.createMetrics());
		modelResult.getMetrics().setTbdCount(0);

		doAssurancePlanClaimResultsParts(assurancePlan, plans, classifier, modelResult.getClaimResult(),
				modelResult.getSubsystemResult(), modelResult.getSubAssuranceCase(), false);

		if (modelResult.getClaimResult().isEmpty() && modelResult.getSubsystemResult().isEmpty()) {
			return null;
		}
		return modelResult;
	}

	// Need to collect all ClaimResults and add them to claimResultList.
	public void doAssurancePlanClaimResultsParts(AssurancePlan assurancePlan,
			Iterable<VerificationPlan> verificationPlans, ComponentClassifier classifier,
			EList<ClaimResult> claimResultList, EList<SubsystemResult> subsystemResultList,
			EList<AssuranceCaseResult> subAssuranceCaseList, boolean globalOnly) {
		// Remember the top so items added for this level can be removed at the end.
		var globalPlansTop = globalPlans.size();
		var globalClaimsTop = globalClaims.size();
		var systemRequirementSets = rRreferenceFinder.getSystemRequirementSets(classifier);

		// First add claims from the directly applicable verification plans.
		for (var verificationPlan : verificationPlans) {
			for (var claim : verificationPlan.getClaim()) {
				generateClaimResult(claim, claimResultList);
			}
		}

		// Next handle included requirements. Process target-specific inclusions here and retain global inclusions.
		for (var requirementSet : systemRequirementSets) {
			for (var inclusion : requirementSet.getInclude()) {
				var includedRequirement = inclusion.getInclude();
				switch (includedRequirement) {
				case RequirementSet includedSet -> {
					var plans = vReferenceFinder.getAllVerificationPlansForRequirements(includedSet, requirementSet);
					if (inclusion.isLocal()) {
						for (var verificationPlan : plans) {
							for (var claim : verificationPlan.getClaim()) {
								var requirement = claim.getRequirement();
								var categories = requirement == null ? null : requirement.getComponentCategory();
								if (ReqSpecUtilExtension.matchingCategory(categories, classifier.getCategory())) {
									generateAllClaimResult(claim, classifier, claimResultList);
								}
							}
						}
					} else {
						for (var plan : plans) {
							globalPlans.add(plan);
						}
					}
				}
				case Requirement globalRequirement -> {
					var containingSet = ReqSpecUtilExtension.containingRequirementSet(globalRequirement);
					var plans = vReferenceFinder.getAllVerificationPlansForRequirements(containingSet, requirementSet);
					for (var verificationPlan : plans) {
						for (var claim : verificationPlan.getClaim()) {
							if (claim.getRequirement().getName().equals(globalRequirement.getName())) {
								var requirement = claim.getRequirement();
								var categories = requirement == null ? null : requirement.getComponentCategory();
								if (ReqSpecUtilExtension.matchingCategory(categories, classifier.getCategory())) {
									if (inclusion.isLocal()) {
										generateAllClaimResult(claim, classifier, claimResultList);
									} else if (inclusion.getTargetElement() != null) {
										if (whenHolds(claim, classifier)) {
											generateClaimResult(claim, claimResultList, inclusion.getTargetElement());
										}
									} else {
										globalClaims.add(claim);
									}
								}
							}
						}
					}
				}
				case null, default -> {
				}
				}
			}
		}

		for (var verificationPlan : globalPlans) {
			for (var claim : verificationPlan.getClaim()) {
				var requirement = claim.getRequirement();
				var categories = requirement == null ? null : requirement.getComponentCategory();
				if (ReqSpecUtilExtension.matchingCategory(categories, classifier.getCategory())) {
					generateAllClaimResult(claim, classifier, claimResultList);
				}
			}
		}

		for (var claim : globalClaims) {
			var requirement = claim.getRequirement();
			var categories = requirement == null ? null : requirement.getComponentCategory();
			if (ReqSpecUtilExtension.matchingCategory(categories, classifier.getCategory())) {
				generateAllClaimResult(claim, classifier, claimResultList);
			}
		}

		if (classifier instanceof ComponentImplementation implementation) {
			for (var subcomponent : implementation.getAllSubcomponents()) {
				generateSubsystemPlans(subcomponent, assurancePlan, subsystemResultList, subAssuranceCaseList,
						globalOnly);
			}
		}

		while (globalPlans.size() > globalPlansTop) {
			globalPlans.remove(globalPlans.size() - 1);
		}
		while (globalClaims.size() > globalClaimsTop) {
			globalClaims.remove(globalClaims.size() - 1);
		}
	}

	public boolean whenHolds(Claim claim, ComponentClassifier classifier) {
		var requirement = claim.getRequirement();
		var whenCondition = requirement.getWhencondition();
		if (whenCondition != null) {
			var function = whenCondition.getCondition();
			if (function != null) {
				var target = requirement.getTargetElement() != null ? requirement.getTargetElement() : classifier;
				var result = ExecuteJavaUtil.invokeJavaMethod(function, target);
				if (result instanceof Boolean booleanResult) {
					return booleanResult;
				}
			}
		}
		return true;
	}

	public void generateAllClaimResult(Claim claim, ComponentClassifier classifier,
			EList<ClaimResult> claimResultList) {
		if (!whenHolds(claim, classifier)) {
			return;
		}

		var targetType = claim.getRequirement().getTargetType();
		if (targetType == TargetType.CONNECTION) {
			if (classifier instanceof ComponentImplementation implementation) {
				for (var connection : CommonUtilExtension.getCrossConnections(implementation)) {
					generateClaimResult(claim, claimResultList, connection);
				}
			}
		} else if (targetType == TargetType.FLOW) {
			if (classifier instanceof ComponentImplementation implementation) {
				for (var flow : implementation.getAllEndToEndFlows()) {
					generateClaimResult(claim, claimResultList, flow);
				}
			}
		} else if (targetType == TargetType.FEATURE) {
			for (var feature : classifier.getAllFeatures()) {
				generateClaimResult(claim, claimResultList, feature);
			}
		} else {
			generateClaimResult(claim, claimResultList);
		}
	}

	public void generateClaimResult(Claim claim, EList<ClaimResult> claimResultList) {
		generateClaimResult(claim, claimResultList, claim.getRequirement().getTargetElement());
	}

	// Add a result for the claim to claimResultList.
	public void generateClaimResult(Claim claim, EList<ClaimResult> claimResultList, NamedElement targetElement) {
		var activityResults = doGenerateVA(claim);
		if (activityResults.isEmpty() && claim.getSubclaim() == null && claim.getAssert() == null) {
			return;
		}

		var claimResult = factory.createClaimResult();
		var claimReference = factory.createQualifiedClaimReference();
		claimReference.setVerificationPlan(VerifyUtilExtension.containingVerificationPlan(claim));
		var nestedReference = factory.createNestedClaimReference();
		nestedReference.setRequirement(claim.getRequirement());
		claimReference.setRequirement(constructClaimReferencePath(claim, nestedReference));
		claimResult.setTargetReference(claimReference);
		claimResult.setMetrics(factory.createMetrics());
		claimResult.getMetrics().setTbdCount(0);
		claimResult.setModelElement(targetElement);

		if (claim.getSubclaim() != null) {
			for (var subclaim : claim.getSubclaim()) {
				generateClaimResult(subclaim, claimResult.getSubClaimResult(),
						claim.getRequirement().getTargetElement());
			}
		}

		if (claim.getAssert() != null) {
			construct(claimResult.getVerificationActivityResult(), claim.getAssert());
		} else {
			claimResult.getVerificationActivityResult().addAll(activityResults);
		}

		if (claim.getRequirement().getPredicate() instanceof ValuePredicate valuePredicate
				&& !AssureUtilExtension.containsComputeVariables(valuePredicate)) {
			claimResult.setPredicateResult(generatePredicateResult(claim));
		}

		claimResultList.add(claimResult);
	}

	public PredicateResult generatePredicateResult(Claim claim) {
		var predicateResult = factory.createPredicateResult();
		var claimReference = factory.createQualifiedClaimReference();
		claimReference.setVerificationPlan(VerifyUtilExtension.containingVerificationPlan(claim));
		var nestedReference = factory.createNestedClaimReference();
		nestedReference.setRequirement(claim.getRequirement());
		claimReference.setRequirement(constructClaimReferencePath(claim, nestedReference));
		predicateResult.setTargetReference(claimReference);
		predicateResult.setMetrics(factory.createMetrics());
		predicateResult.getMetrics().setTbdCount(0);
		return predicateResult;
	}

	// subAssuranceCaseList can be null because SubsystemResult does not have subAssuranceCase.
	public void generateSubsystemPlans(Subcomponent subcomponent, AssurancePlan parentPlan,
			EList<SubsystemResult> subsystemResultList, EList<AssuranceCaseResult> subAssuranceCaseList,
			boolean globalOnly) {
		var classifier = subcomponent.getAllClassifier();
		if (classifier == null) {
			return;
		}

		var previousIsRoot = isRoot;
		isRoot = false;
		if (globalOnly || isAssumeSubsystem(subcomponent, parentPlan)) {
			generateSubsystemGlobalOnly(subcomponent, parentPlan, subsystemResultList);
		} else if (classifier instanceof ComponentType) {
			// Process plans for the component type.
			generateSubsystemVerificationPlansGlobals(subcomponent, parentPlan, subsystemResultList);
		} else {
			// Process assurance cases for the subsystem.
			var subsystemCases = arefFinder.getAssuranceCases(classifier);
			if (!subsystemCases.iterator().hasNext()) {
				generateSubsystemVerificationPlansGlobals(subcomponent, parentPlan, subsystemResultList);
			} else {
				for (var subsystemCase : subsystemCases) {
					subAssuranceCaseList.add(constructAssuranceCaseResult(subsystemCase, classifier));
				}
			}
		}
		isRoot = previousIsRoot;
	}

	/**
	 * @param subcomponent
	 *            system of interest as a subcomponent of another system
	 */
	public void generateSubsystemVerificationPlansGlobals(Subcomponent subcomponent, AssurancePlan parentPlan,
			EList<SubsystemResult> subsystemResultList) {
		Iterable<VerificationPlan> plans = List.of();
		ComponentClassifier classifier = null;
		if (!Aadl2Util.isNull(subcomponent)) {
			classifier = subcomponent.getAllClassifier();
			if (!Aadl2Util.isNull(classifier)) {
				plans = vReferenceFinder.getVerificationPlans(classifier, parentPlan);
			}
		}

		var subsystemResult = factory.createSubsystemResult();
		subsystemResult.setTargetSystem(subcomponent);
		subsystemResult.setMetrics(factory.createMetrics());
		subsystemResult.getMetrics().setTbdCount(0);
		doAssurancePlanClaimResultsParts(parentPlan, plans, classifier, subsystemResult.getClaimResult(),
				subsystemResult.getSubsystemResult(), null, false);
		subsystemResultList.add(subsystemResult);
	}

	/**
	 * Processes only global requirements from the enclosing case for a subsystem marked as assumed.
	 */
	public void generateSubsystemGlobalOnly(Subcomponent subcomponent, AssurancePlan parentPlan,
			EList<SubsystemResult> subsystemResultList) {
		var subsystemResult = factory.createSubsystemResult();
		subsystemResult.setTargetSystem(subcomponent);
		subsystemResult.setMetrics(factory.createMetrics());
		subsystemResult.getMetrics().setTbdCount(0);
		doAssurancePlanClaimResultsParts(parentPlan, List.of(), subcomponent.getAllClassifier(),
				subsystemResult.getClaimResult(), subsystemResult.getSubsystemResult(), null, true);
		subsystemResultList.add(subsystemResult);
	}

	public boolean isAssumeSubsystem(Subcomponent subcomponent, AssurancePlan parentPlan) {
		if (parentPlan == null) {
			return false;
		}
		if (parentPlan.isAssumeAll()) {
			return true;
		}
		for (var assumedSubsystem : parentPlan.getAssumeSubsystems()) {
			if (assumedSubsystem.getName().equalsIgnoreCase(subcomponent.getName())) {
				return true;
			}
		}
		return false;
	}

	public EList<VerificationActivityResult> doGenerateVA(Claim claim) {
		var result = new BasicEList<VerificationActivityResult>();
		for (var activity : claim.getActivities()) {
			addVAR(activity, result);
		}
		return result;
	}

	public void addVAR(VerificationActivity activity, EList<VerificationActivityResult> activityResults) {
		var claim = VerifyUtilExtension.getContainingClaim(activity);
		if (activity.getMethod().getTargetType() == TargetType.ROOT && !isRoot) {
			return;
		}

		var activityResult = factory.createVerificationActivityResult();
		var activityReference = factory.createQualifiedVAReference();
		activityReference.setVerificationPlan(VerifyUtilExtension.containingVerificationPlan(activity));
		var nestedReference = factory.createNestedClaimReference();
		nestedReference.setRequirement(claim.getRequirement());
		activityReference.setRequirement(constructClaimReferencePath(claim, nestedReference));
		activityReference.setVerificationActivity(activity);
		activityResult.setTargetReference(activityReference);
		activityResult.setType(ResultType.TBD);
		activityResult.setMetrics(factory.createMetrics());
		activityResult.getMetrics().setTbdCount(0);

		var method = activity.getMethod();
		if (method != null && method.getPrecondition() != null) {
			activityResult.setPreconditionResult(doConstruct(method.getPrecondition(), activity));
		}
		if (method != null && method.getValidation() != null) {
			activityResult.setValidationResult(doConstruct(method.getValidation(), activity));
		}
		activityResults.add(activityResult);
	}

	public NestedClaimReference constructClaimReferencePath(Claim claim, NestedClaimReference nestedReference) {
		if (claim.eContainer() instanceof Claim parentClaim) {
			var parentReference = factory.createNestedClaimReference();
			parentReference.setRequirement(parentClaim.getRequirement());
			parentReference.setSub(nestedReference);
			return constructClaimReferencePath(parentClaim, parentReference);
		}
		return nestedReference;
	}

	public void construct(List<VerificationExpr> results, ArgumentExpr expression) {
		switch (expression) {
		case AllExpr allExpression -> doConstruct(results, allExpression);
		case ThenExpr thenExpression -> doConstruct(results, thenExpression);
		case ElseExpr elseExpression -> doConstruct(results, elseExpression);
		case RefExpr referenceExpression -> doConstruct(results, referenceExpression);
		case null, default -> {
		}
		}
	}

	public void doConstruct(List<VerificationExpr> results, AllExpr expression) {
		for (var subexpression : expression.getElements()) {
			construct(results, subexpression);
		}
	}

	public void doConstruct(List<VerificationExpr> results, ThenExpr expression) {
		var thenResult = factory.createThenResult();
		thenResult.setMetrics(factory.createMetrics());
		thenResult.getMetrics().setTbdCount(0);
		construct(thenResult.getFirst(), expression.getLeft());
		construct(thenResult.getSecond(), expression.getSuccessor());
		if (thenResult.getFirst().isEmpty()) {
			return;
		}
		if (thenResult.getSecond().isEmpty()) {
			results.addAll(thenResult.getFirst());
		} else {
			results.add(thenResult);
		}
	}

	public void doConstruct(List<VerificationExpr> results, ElseExpr expression) {
		var elseResult = factory.createElseResult();
		elseResult.setMetrics(factory.createMetrics());
		elseResult.getMetrics().setTbdCount(0);
		construct(elseResult.getFirst(), expression.getLeft());
		construct(elseResult.getError(), expression.getError());
		if (expression.getFail() != null) {
			construct(elseResult.getFail(), expression.getFail());
		}
		if (expression.getTimeout() != null) {
			construct(elseResult.getTimeout(), expression.getTimeout());
		}

		if (elseResult.getFirst().isEmpty()) {
			return;
		}
		if (elseResult.getError().isEmpty() && elseResult.getFail().isEmpty() && elseResult.getTimeout().isEmpty()) {
			results.addAll(elseResult.getFirst());
		} else {
			results.add(elseResult);
		}
	}

	// This is almost the same as addVAR and could be consolidated separately.
	public void doConstruct(List<VerificationExpr> results, RefExpr expression) {
		var activity = expression.getVerification();
		if (activity == null) {
			return;
		}

		var activityResult = factory.createVerificationActivityResult();
		activityResult.setType(ResultType.TBD);
		var activityReference = factory.createQualifiedVAReference();
		activityReference.setVerificationPlan(VerifyUtilExtension.containingVerificationPlan(activity));
		var claim = VerifyUtilExtension.getContainingClaim(activity);
		var nestedReference = factory.createNestedClaimReference();
		nestedReference.setRequirement(claim.getRequirement());
		activityReference.setRequirement(constructClaimReferencePath(claim, nestedReference));
		activityReference.setVerificationActivity(activity);
		activityResult.setTargetReference(activityReference);
		activityResult.setMetrics(factory.createMetrics());
		activityResult.getMetrics().setTbdCount(0);
		results.add(activityResult);

		var method = activity.getMethod();
		if (method != null && method.getPrecondition() != null) {
			activityResult.setPreconditionResult(doConstruct(method.getPrecondition(), activity));
		}
		if (method != null && method.getValidation() != null) {
			activityResult.setValidationResult(doConstruct(method.getValidation(), activity));
		}
	}

	public VerificationResult doConstruct(VerificationCondition condition, VerificationActivity activity) {
		var conditionResult = switch (condition) {
		case VerificationValidation ignored -> {
			var validationResult = factory.createValidationResult();
			validationResult.setTarget(activity.getMethod());
			yield validationResult;
		}
		case VerificationPrecondition ignored -> {
			var preconditionResult = factory.createPreconditionResult();
			preconditionResult.setTarget(activity.getMethod());
			yield preconditionResult;
		}
		case null, default -> (VerificationResult) null;
		};
		conditionResult.setType(ResultType.TBD);
		conditionResult.setMetrics(factory.createMetrics());
		conditionResult.getMetrics().setTbdCount(0);
		return conditionResult;
	}
}

/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file). 
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

/*
 * generated by Xtext
 */
package org.osate.assure.generator

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import java.util.Collections
import java.util.List
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.UniqueEList
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ComponentType
import org.osate.aadl2.NamedElement
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.util.Aadl2Util
import org.osate.alisa.common.common.TargetType
import org.osate.alisa.workbench.alisa.AssuranceCase
import org.osate.alisa.workbench.alisa.AssurancePlan
import org.osate.alisa.workbench.util.IAlisaGlobalReferenceFinder
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.AssureFactory
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.NestedClaimReference
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.QualifiedClaimReference
import org.osate.assure.assure.QualifiedVAReference
import org.osate.assure.assure.SubsystemResult
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.VerificationExpr
import org.osate.assure.assure.VerificationResult
import org.osate.pluginsupport.ExecuteJavaUtil
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.RequirementSet
import org.osate.reqspec.reqSpec.ValuePredicate
import org.osate.reqspec.util.IReqspecGlobalReferenceFinder
import org.osate.result.ResultType
import org.osate.verify.internal.util.IVerifyGlobalReferenceFinder
import org.osate.verify.verify.AllExpr
import org.osate.verify.verify.ArgumentExpr
import org.osate.verify.verify.Claim
import org.osate.verify.verify.ElseExpr
import org.osate.verify.verify.RefExpr
import org.osate.verify.verify.ThenExpr
import org.osate.verify.verify.VerificationActivity
import org.osate.verify.verify.VerificationCondition
import org.osate.verify.verify.VerificationPlan
import org.osate.verify.verify.VerificationPrecondition
import org.osate.verify.verify.VerificationValidation

import static org.osate.assure.util.AssureUtilExtension.*

import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import static extension org.osate.reqspec.util.ReqSpecUtilExtension.*
import static extension org.osate.verify.internal.util.VerifyUtilExtension.*

@ImplementedBy(AssureConstructor)
interface IAssureConstructor {
	def AssuranceCaseResult generateFullAssuranceCase(AssuranceCase acs);
}

/**
 * Generates code from your model files on save.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#TutorialCodeGeneration
 */
class AssureConstructor implements IAssureConstructor {

	val factory = AssureFactory.eINSTANCE

	var EList<VerificationPlan> globalPlans

	var EList<Claim> globalClaims

	var isRoot = true;

	override generateFullAssuranceCase(AssuranceCase acs) {
		globalPlans = new UniqueEList()
		globalClaims = new UniqueEList()
		isRoot = true
		acs.constructAssuranceCaseResult(null)
	}

	def constructAssuranceCaseResult(AssuranceCase acs, ComponentClassifier cl) {
		var AssuranceCaseResult acr = factory.createAssuranceCaseResult
		acr.name = acs.name
		acr.metrics = factory.createMetrics
		acr.metrics.tbdCount = 0

		val mrs = acr.modelResult

		for (acp : acs.assurancePlans) {
			if (acp.target.isSameorExtends(acs.system) && (cl === null || cl.isSameorExtends(acp.target))) {
				// only plans that relate to the assurance case directly
				val modelResultInstance = acp.constructModelResult
				if (modelResultInstance !== null) {
					mrs.add(modelResultInstance)
				}
			}
		}
		acr
	}

	def constructModelResult(AssurancePlan acp) {
//		deal with assure global plans
		var Iterable<VerificationPlan> myplans = Collections.EMPTY_LIST

		var ComponentClassifier cc
		if (acp !== null) {
			myplans = acp.assure
			cc = acp.target
			if (myplans.empty && !Aadl2Util.isNull(cc)) {
				myplans = cc.getVerificationPlans(acp)
			}
			globalPlans.addAll(acp.assureGlobal)
		}
		var ModelResult mr = factory.createModelResult
		mr.plan = acp
		mr.target = acp.target
		mr.metrics = factory.createMetrics
		mr.metrics.tbdCount = 0

		doAssurancePlanClaimResultsParts(acp, myplans, cc, mr.claimResult, mr.subsystemResult, mr.subAssuranceCase,
			false)

		if(mr.claimResult.length == 0 && mr.subsystemResult.length == 0) return null

		mr
	}

	// Need to collect all ClaimResults and add to claimResultList
	def void doAssurancePlanClaimResultsParts(
		AssurancePlan assurancePlan,
		Iterable<VerificationPlan> vplans,
		ComponentClassifier cc,
		EList<ClaimResult> claimResultList,
		EList<SubsystemResult> subsystemResultList,
		EList<AssuranceCaseResult> subAssuranceCaseList,
		boolean globalOnly
	) {
		// remember top so we can remove any added items at the end
		val globalPlansTop = globalPlans.size
		val globalClaimsTop = globalClaims.size
		val sysreqs = rRreferenceFinder.getSystemRequirementSets(cc)
		// first add claims from vplans
		for (vplan : vplans) {
			for (claim : vplan.claim) {
				claim.generateClaimResult(claimResultList)
			}
		}
		// next handle included requirements
		// handle 'self' or target specific ones and add global ones to globalPlans and globalClaims
		for (reqs : sysreqs) {
			val includes = reqs.include
			for (incl : includes) {
				if (incl.include instanceof RequirementSet) {
					val plans = vReferenceFinder.
						getAllVerificationPlansForRequirements(incl.include as RequirementSet, reqs)
					if (incl.local) {
						for (vplan : plans) {
							for (claim : vplan.claim.filter [ cl |
								cl.requirement?.componentCategory.matchingCategory(cc.category)
							]) {
								claim.generateAllClaimResult(cc, claimResultList)
							}
						}
					} else {
						globalPlans.addAll(plans)
					}
				} else if (incl.include instanceof Requirement) {
					val greq = incl.include as Requirement
					val greqs = greq.containingRequirementSet
					val plans = vReferenceFinder.getAllVerificationPlansForRequirements(greqs, reqs)
					// find claim for requirement and handle it
					for (vp : plans) {
						for (claim : vp.claim) {
							if (claim.requirement.name.equals(greq.name)) {
								if (claim.requirement?.componentCategory.matchingCategory(cc.category)) {
									if (incl.local) {
										claim.generateAllClaimResult(cc, claimResultList)
									} else if (incl.targetElement !== null) {
										if (whenHolds(claim, cc)) {
											claim.generateClaimResult(claimResultList, incl.targetElement)
										}
									} else {
										globalClaims.add(claim)
									}
								}
							}
						}
					}
				}
			}
		}
		// now process global plans and claims
		for (vplan : globalPlans) {
			for (claim : vplan.claim.filter[cl|cl.requirement?.componentCategory.matchingCategory(cc.category)]) {
				claim.generateAllClaimResult(cc, claimResultList)
			}
		}

		for (claim : globalClaims.filter[cl|cl.requirement?.componentCategory.matchingCategory(cc.category)]) {
			claim.generateAllClaimResult(cc, claimResultList)
		}

		if (cc instanceof ComponentImplementation) {
			for (subc : cc.allSubcomponents) {
				subc.generateSubsystemPlans(assurancePlan, subsystemResultList, subAssuranceCaseList, globalOnly)
			}
		}

		var plansize = globalPlans.size
		while (plansize > globalPlansTop) {
			globalPlans.remove(plansize - 1)
			plansize = plansize - 1
		}
		var claimsize = globalClaims.size
		while (claimsize > globalClaimsTop) {
			globalClaims.remove(claimsize - 1)
			claimsize = claimsize - 1
		}
	}

	def boolean whenHolds(Claim claim, ComponentClassifier cc) {
		val req = claim.requirement
		val when = req.whencondition
		if (when !== null) {
			val function = when.condition
			if (function !== null) {
				val ne = req.targetElement ?: cc
				val res = ExecuteJavaUtil.invokeJavaMethod(function, ne)
				if (res instanceof Boolean) {
					return res;
				}
			}
		}
		true
	}

	def void generateAllClaimResult(Claim claim, ComponentClassifier cc, EList<ClaimResult> claimResultlist) {
		if (!whenHolds(claim, cc)) {
			return
		}
		if (claim.requirement.targetType === TargetType.CONNECTION) {
			if (cc instanceof ComponentImplementation) {
				for (conn : cc.crossConnections) {
					claim.generateClaimResult(claimResultlist, conn)
				}
			}
			return
		} else if (claim.requirement.targetType === TargetType.FLOW) {
			if (cc instanceof ComponentImplementation) {
				for (etef : cc.allEndToEndFlows) {
					claim.generateClaimResult(claimResultlist, etef)
				}
			}
			return
		} else if (claim.requirement.targetType === TargetType.FEATURE) {
			for (feature : cc.allFeatures) {
				claim.generateClaimResult(claimResultlist, feature)
			}
			return
		} else {
			claim.generateClaimResult(claimResultlist)
		}

	}

	def void generateClaimResult(Claim claim, EList<ClaimResult> claimResultlist) {
		claim.generateClaimResult(claimResultlist, claim.requirement.targetElement)
	}

	// Add to claimResultlist for claim
	def void generateClaimResult(Claim claim, EList<ClaimResult> claimResultlist, NamedElement forTargetElement) {

		val claimvas = doGenerateVA(claim)
		if(claimvas.length == 0 && claim.subclaim === null && claim.assert === null) return
		val ClaimResult claimResult = factory.createClaimResult

		// QualifiedClaimReference
		val QualifiedClaimReference qcr = factory.createQualifiedClaimReference
		qcr.verificationPlan = claim.containingVerificationPlan
		val NestedClaimReference ncr = factory.createNestedClaimReference
		ncr.requirement = claim.requirement
		qcr.requirement = constructClaimReferencePath(claim, ncr)
		claimResult.targetReference = qcr
		// ------------//QualifiedClaimReference
		claimResult.metrics = factory.createMetrics
		claimResult.metrics.tbdCount = 0
		claimResult.modelElement = forTargetElement

		if (claim.subclaim !== null) {
			for (subclaim : claim?.subclaim) {
				generateClaimResult(subclaim, claimResult.subClaimResult, claim.requirement.targetElement)
			}
		}

		if (claim.assert !== null) {
			claimResult.verificationActivityResult.construct(claim.assert)
		} else {
			for (claimva : claimvas) {
				claimResult.verificationActivityResult.add(claimva)
			}
		}
		val predicate = claim.requirement.predicate
		if (predicate instanceof ValuePredicate) {
			if (!containsComputeVariables(predicate)) {
				claimResult.predicateResult = generatePredicateResult(claim)
			}
		}

		claimResultlist.add(claimResult)
	}

	def generatePredicateResult(Claim claim) {
		val predicate = factory.createPredicateResult
		val QualifiedClaimReference ref = factory.createQualifiedClaimReference
		ref.verificationPlan = claim.containingVerificationPlan
		val NestedClaimReference nested = factory.createNestedClaimReference
		nested.requirement = claim.requirement
		ref.requirement = constructClaimReferencePath(claim, nested)
		predicate.targetReference = ref
		predicate.metrics = factory.createMetrics
		predicate.metrics.tbdCount = 0
		predicate
	}

	@Inject IAlisaGlobalReferenceFinder arefFinder

	// subAssuranceCaseList could be null because SubsystemResult doesn't have subAssuranceCase. 
	// Let's see if it is used when null
	def void generateSubsystemPlans(
		Subcomponent subc,
		AssurancePlan parentap,
		EList<SubsystemResult> subsystemResultList,
		EList<AssuranceCaseResult> subAssuranceCaseList,
		boolean globalOnly
	) {
		val cc = subc.allClassifier
		if (cc === null) {
			return
		}
		val prevIsRoot = isRoot
		isRoot = false
		if (globalOnly || subc.isAssumeSubsystem(parentap)) {
			subc.generateSubsystemGlobalOnly(parentap, subsystemResultList)
		} else if (cc instanceof ComponentType) {
			// plans for type
			subc.generateSubsystemVerificationPlansGlobals(parentap, subsystemResultList)
		} else {
			// do cases for subsystem 
			val subacs = arefFinder.getAssuranceCases(cc)
			if (subacs.empty) {
				subc.generateSubsystemVerificationPlansGlobals(parentap, subsystemResultList)
			} else {
				for (subac : subacs) {
					subAssuranceCaseList.add(subac.constructAssuranceCaseResult(cc))
				}
			}
		}
		isRoot = prevIsRoot
	}

	/**
	 * sub: system of interest as subcomponent of another system
	 */
	def void generateSubsystemVerificationPlansGlobals(Subcomponent sub, AssurancePlan mp,
		EList<SubsystemResult> subsystemResultList) {
		var Iterable<VerificationPlan> myplans = Collections.EMPTY_LIST
		var ComponentClassifier cc
		if (!Aadl2Util.isNull(sub)) {
			cc = sub.allClassifier
			if (!Aadl2Util.isNull(cc)) {
				myplans = cc.getVerificationPlans(mp);
			}
		}

		val SubsystemResult ssr = factory.createSubsystemResult
		ssr.targetSystem = sub
		ssr.metrics = factory.createMetrics
		ssr.metrics.tbdCount = 0

		doAssurancePlanClaimResultsParts(mp, myplans, cc, ssr.claimResult, ssr.subsystemResult, null, false)
		subsystemResultList.add(ssr)

	}

	/**
	 * sub: system of interest as subcomponent of another system only for global requirements from enclosing case
	 * Otherwiase it was marked as assume, i.e., local assurance case/verification plans are not executed
	 */
	def void generateSubsystemGlobalOnly(Subcomponent sub, AssurancePlan mp,
		EList<SubsystemResult> subsystemResultList) {
		var Iterable<VerificationPlan> myplans = Collections.EMPTY_LIST
		val SubsystemResult ssr = factory.createSubsystemResult
		ssr.targetSystem = sub
		ssr.metrics = factory.createMetrics
		ssr.metrics.tbdCount = 0

		doAssurancePlanClaimResultsParts(mp, myplans, sub.allClassifier, ssr.claimResult, ssr.subsystemResult, null,
			true)
		subsystemResultList.add(ssr)
	}

	def boolean isAssumeSubsystem(Subcomponent subc, AssurancePlan parentacp) {
		if(parentacp === null) return false
		if(parentacp.assumeAll) return true
		val assumes = parentacp.assumeSubsystems
		for (sub : assumes) {
			if(sub.name.equalsIgnoreCase(subc.name)) return true;
		}
		return false
	}

	def doGenerateVA(Claim claim) {
		val EList<VerificationActivityResult> returnList = new BasicEList()
		for (va : claim.activities) {
			addVAR(va, returnList);
		}

		returnList
	}

	def void addVAR(VerificationActivity va, EList<VerificationActivityResult> vaList) {
		val claim = va.containingClaim
		if (va.method.targetType === TargetType.ROOT && !isRoot) {
			return
		}
		val vaResult = factory.createVerificationActivityResult

		// QualifiedVAReference
		val QualifiedVAReference qvr = factory.createQualifiedVAReference
		qvr.verificationPlan = va.containingVerificationPlan

		val NestedClaimReference ncr = factory.createNestedClaimReference
		ncr.requirement = claim.requirement

		qvr.requirement = constructClaimReferencePath(claim, ncr)

		qvr.verificationActivity = va
		vaResult.targetReference = qvr
		// -----------QualifiedVAReference END
		vaResult.type = ResultType.TBD
		vaResult.metrics = factory.createMetrics
		vaResult.metrics.tbdCount = 0

		if (va.method?.precondition !== null) {
			vaResult.preconditionResult = doConstruct(va.method.precondition, va)
		}

		if (va.method?.validation !== null) {
			vaResult.validationResult = doConstruct(va.method.validation, va)
		}

		vaList.add(vaResult)
	}

	def NestedClaimReference constructClaimReferencePath(Claim claim, NestedClaimReference ncr) {
		val parent = claim.eContainer
		if (parent instanceof Claim) {
			val NestedClaimReference parentNcr = factory.createNestedClaimReference
			parentNcr.requirement = parent.requirement
			parentNcr.sub = ncr
			return constructClaimReferencePath(parent, parentNcr)
		}
		return ncr
	}

	@Inject extension IReqspecGlobalReferenceFinder rRreferenceFinder

	@Inject extension IVerifyGlobalReferenceFinder vReferenceFinder

	def void construct(List<VerificationExpr> arl, ArgumentExpr expr) {
		switch expr {
			AllExpr: arl.doConstruct(expr)
			ThenExpr: arl.doConstruct(expr)
			ElseExpr: arl.doConstruct(expr)
			RefExpr: arl.doConstruct(expr)
		}
	}

	def void doConstruct(List<VerificationExpr> arl, AllExpr expr) {
		for (subexpr : expr.elements) {
			arl.construct(subexpr)
		}
	}

	def void doConstruct(List<VerificationExpr> arl, ThenExpr expr) {
		val thenres = factory.createThenResult
		thenres.metrics = factory.createMetrics
		thenres.metrics.tbdCount = 0
		thenres.first.construct(expr.left)
		thenres.second.construct(expr.successor)
		if(thenres.first.empty) return;
		if (thenres.second.empty) {
			arl += thenres.first
		} else {
			arl += thenres
		}
	}

	def void doConstruct(List<VerificationExpr> arl, ElseExpr expr) {
		val elseres = factory.createElseResult
		elseres.metrics = factory.createMetrics
		elseres.metrics.tbdCount = 0
		elseres.first.construct(expr.left)
		elseres.error.construct(expr.error)
		if(expr.fail !== null) elseres.fail.construct(expr.fail)
		if(expr.timeout !== null) elseres.timeout.construct(expr.timeout)

		if(elseres.first.empty) return;
		if (elseres.error.empty && elseres.fail.empty && elseres.timeout.empty) {
			arl += elseres.first
		} else {
			arl += elseres
		}
	}

	// Seems almost the same as addVA refactor later
	def void doConstruct(List<VerificationExpr> arl, RefExpr expr) {
		val va = expr.verification

		if(va === null) return;

		// if (va.evaluateSelectionFilter(selectionFilter) && va.evaluateVerificationFilter(verificationFilter)) {
		val vr = factory.createVerificationActivityResult
		vr.type = ResultType.TBD

		// vr.target = expr.verification
		// QualifiedVAReference
		val QualifiedVAReference qvr = factory.createQualifiedVAReference
		qvr.verificationPlan = va.containingVerificationPlan

		val NestedClaimReference ncr = factory.createNestedClaimReference
		val claim = va.containingClaim
		ncr.requirement = claim.requirement

		qvr.requirement = constructClaimReferencePath(claim, ncr)

		qvr.verificationActivity = va
		vr.targetReference = qvr
		// -----------QualifiedVAReference END
		vr.metrics = factory.createMetrics
		vr.metrics.tbdCount = 0
		arl += vr

		if (va.method?.precondition !== null) {
			vr.preconditionResult = doConstruct(va.method.precondition, va)
		}

		if (va.method?.validation !== null) {
			vr.validationResult = doConstruct(va.method.validation, va)
		}

	// }
	}

	def VerificationResult doConstruct(VerificationCondition vc, VerificationActivity va) {
		var VerificationResult vcr
		switch (vc) {
			VerificationValidation: {
				vcr = factory.createValidationResult()
				(vcr as ValidationResult).target = va.method
			}
			VerificationPrecondition: {
				vcr = factory.createPreconditionResult()
				(vcr as PreconditionResult).target = va.method
			}
		}
		vcr.type = ResultType.TBD
		vcr.metrics = factory.createMetrics
		vcr.metrics.tbdCount = 0
		return vcr
	}

}

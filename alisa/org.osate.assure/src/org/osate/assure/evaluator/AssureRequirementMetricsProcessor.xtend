package org.osate.assure.evaluator;

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.aadl2.ClassifierFeature
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.SubsystemResult
import org.osate.reqspec.util.IReqspecGlobalReferenceFinder

@ImplementedBy(AssureRequirementMetricsProcessor)
interface IAssureRequirementMetricsProcessor {
	def void processCase(AssuranceCaseResult assureResult, IProgressMonitor monitor)
}

class AssureRequirementMetricsProcessor implements IAssureRequirementMetricsProcessor{
	@Inject IReqspecGlobalReferenceFinder reqSpecrefFinder

	override processCase(AssuranceCaseResult assureResult, IProgressMonitor monitor) {
		assureResult.process
	}

	def dispatch void process(AssuranceCaseResult caseResult) {
		caseResult.modelResult.forEach[modelResult|modelResult.process]
	}

	def dispatch void process(ModelResult modelResult) {
		val targetComponent = modelResult.target
		modelResult.metrics.featuresCount = targetComponent.getAllFeatures.size
		val plan = modelResult.plan
		EcoreUtil.resolveAll(plan)
		val verificationPlans = plan.assure
		val claimReqs = verificationPlans.map[claim.map[requirement]].flatten.toSet
		val targetReqs = reqSpecrefFinder.getSystemRequirementSets(targetComponent)

		modelResult.metrics.requirementsCount = targetReqs.map[requirements].flatten.toSet.size
		modelResult.metrics.requirementsWithoutPlanClaimCount = targetReqs.map[requirements].flatten.toSet.filter[sysReq | !claimReqs.contains(sysReq)].size
		
		modelResult.metrics.qualityCategoryRequirementsCount = targetReqs.map[requirements.filter[!(targetElement instanceof ClassifierFeature)]].flatten.map[category].flatten.toSet.size
		
		// filter categorytype.name = quality
		
		modelResult.metrics.featuresRequirementsCount = targetReqs.map[requirements].flatten.map[targetElement].filter(ClassifierFeature).toSet.size		
		modelResult.metrics.noVerificationPlansCount = verificationPlans.filter[vp | vp.claim.nullOrEmpty].size
		modelResult.subsystemResult.forEach[subsystemResult|subsystemResult.process]
		modelResult.subAssuranceCase.forEach[subAssuranceCase|subAssuranceCase.process]
	}

	def dispatch void process(SubsystemResult caseResult) {
		val targetSystem = caseResult.targetSystem
		caseResult.metrics.featuresCount = targetSystem.allFeatures.size
		val claimResults = caseResult.claimResult
		val verificationPlans = claimResults.map[targetReference.verificationPlan] 
		val claimReqs = claimResults.map[targetReference.verificationPlan.claim].flatten.map[requirement].toSet
		val sysReqs = reqSpecrefFinder.getSystemRequirementSets(targetSystem.componentType)
		
		caseResult.metrics.requirementsCount = sysReqs.map[requirements].flatten.toSet.size
		caseResult.metrics.requirementsWithoutPlanClaimCount = sysReqs.map[requirements].flatten.toSet.filter[sysReq | !claimReqs.contains(sysReq)].size
		caseResult.metrics.qualityCategoryRequirementsCount = sysReqs.map[requirements.filter[!(targetElement instanceof ClassifierFeature)]].flatten.map[category].flatten.toSet.size
		caseResult.metrics.featuresRequirementsCount = sysReqs.map[requirements].flatten.map[targetElement].filter(ClassifierFeature).toSet.size	
		caseResult.metrics.noVerificationPlansCount = verificationPlans.filter[vp | vp.claim.nullOrEmpty].size
		caseResult.subsystemResult.forEach[subcaseResult|subcaseResult.process]
	}

}

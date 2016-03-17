package org.osate.assure.evaluator;

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import org.eclipse.core.runtime.IProgressMonitor
import org.osate.aadl2.ClassifierFeature
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.SubsystemResult
import org.osate.categories.categories.Categories
import org.osate.reqspec.util.IReqspecGlobalReferenceFinder

import static extension org.eclipse.emf.ecore.util.EcoreUtil.resolve
import static extension org.eclipse.emf.ecore.util.EcoreUtil.resolveAll
import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.osate.categories.categories.CategoriesPackage
import org.eclipse.emf.ecore.EObject

@ImplementedBy(AssureRequirementMetricsProcessor)
interface IAssureRequirementMetricsProcessor {
	def void processCase(AssuranceCaseResult assureResult, IProgressMonitor monitor)
}

class AssureRequirementMetricsProcessor implements IAssureRequirementMetricsProcessor{

	val ResourceDescriptionsProvider rdp

	@Inject IReqspecGlobalReferenceFinder reqSpecrefFinder
	@Inject
	new(ResourceDescriptionsProvider rdp) {
		this.rdp = rdp
	}
	
	override processCase(AssuranceCaseResult assureResult, IProgressMonitor monitor) {
		assureResult.process
	}

	def dispatch void process(AssuranceCaseResult caseResult) {
		caseResult.modelResult.forEach[modelResult|modelResult.process]
	}

	def int getTotalQualityCategoriesCount(EObject ele){
		val rds = rdp.getResourceDescriptions(ele.eResource)
		val categoriesDescriptions = rds.getExportedObjectsByType(CategoriesPackage.eINSTANCE.categories)
		val categories = categoriesDescriptions.map[EObjectOrProxy.resolve(ele) as Categories]
		categories.filter[name.equalsIgnoreCase("quality")].map[category].flatten.toSet.size
	}

	def dispatch void process(ModelResult modelResult) {
		val targetComponent = modelResult.target
		modelResult.metrics.featuresCount = targetComponent.getAllFeatures.size
		val plan = modelResult.plan
		plan.resolveAll
		val verificationPlans = plan.assure
		val claimReqs = verificationPlans.map[claim.map[requirement]].flatten.toSet
		val targetReqs = reqSpecrefFinder.getSystemRequirementSets(targetComponent)

		modelResult.metrics.totalQualityCategoryCount = modelResult.totalQualityCategoriesCount
		modelResult.metrics.requirementsCount = targetReqs.map[requirements].flatten.toSet.size
		modelResult.metrics.requirementsWithoutPlanClaimCount = targetReqs.map[requirements].flatten.toSet.filter[sysReq | !claimReqs.contains(sysReq)].size
		modelResult.metrics.qualityCategoryRequirementsCount = targetReqs.map[requirements.filter[!(targetElement instanceof ClassifierFeature)]].flatten.map[category].flatten.filter[it.getContainerOfType(Categories).name.equalsIgnoreCase("quality")].toSet.size
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

		caseResult.metrics.totalQualityCategoryCount = caseResult.totalQualityCategoriesCount
		caseResult.metrics.requirementsCount = sysReqs.map[requirements].flatten.toSet.size
		caseResult.metrics.requirementsWithoutPlanClaimCount = sysReqs.map[requirements].flatten.toSet.filter[sysReq | !claimReqs.contains(sysReq)].size
		caseResult.metrics.qualityCategoryRequirementsCount = sysReqs.map[requirements.filter[!(targetElement instanceof ClassifierFeature)]].flatten.map[category].flatten.toSet.size
		caseResult.metrics.featuresRequirementsCount = sysReqs.map[requirements].flatten.map[targetElement].filter(ClassifierFeature).toSet.size	
		caseResult.metrics.noVerificationPlansCount = verificationPlans.filter[vp | vp.claim.nullOrEmpty].size
		caseResult.subsystemResult.forEach[subcaseResult|subcaseResult.process]
	}

}

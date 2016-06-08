package org.osate.assure.evaluator;

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.osate.aadl2.BusAccess
import org.osate.aadl2.ClassifierFeature
import org.osate.aadl2.DataAccess
import org.osate.aadl2.DataPort
import org.osate.aadl2.EventDataPort
import org.osate.alisa.common.scoping.ICommonGlobalReferenceFinder
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.AssureResult
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.SubsystemResult
import org.osate.categories.categories.Categories
import org.osate.categories.categories.CategoriesPackage
import org.osate.categories.categories.CategoryFilter
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.util.IReqspecGlobalReferenceFinder

import static extension java.util.Collections.disjoint
import static extension org.eclipse.emf.ecore.util.EcoreUtil.resolve
import static extension org.eclipse.emf.ecore.util.EcoreUtil.resolveAll
import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.osate.xtext.aadl2.errormodel.util.EMV2Util.hasEMV2Subclause

@ImplementedBy(AssureRequirementMetricsProcessor)
interface IAssureRequirementMetricsProcessor {
	def void processCase(AssuranceCaseResult assureResult, IProgressMonitor monitor)
}

class AssureRequirementMetricsProcessor implements IAssureRequirementMetricsProcessor{

	val ResourceDescriptionsProvider rdp

	@Inject IReqspecGlobalReferenceFinder reqSpecrefFinder
	@Inject ICommonGlobalReferenceFinder commonRefFinder
	@Inject
	new(ResourceDescriptionsProvider rdp) {
		this.rdp = rdp
	}
	
	@Inject
	protected IResourceDescriptions rds;
	
	
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
		val categoryFilters = modelResult.categoryFilters
		//println('categoryFilters = ' + categoryFilters)

		modelResult.metrics.featuresCount = targetComponent.getAllFeatures.size
		val plan = modelResult.plan
		plan.resolveAll
		val verificationPlans = plan.assure
		val claimReqs = verificationPlans.map[claim.map[requirement]].flatten.filter[filterRequirement(categoryFilters)].toSet
		val targetReqs = reqSpecrefFinder.getSystemRequirementSets(targetComponent)
		val exceptionReqCount = targetReqs.map[requirements].flatten.filter[filterRequirement(categoryFilters)].map[category].flatten.filter[it.getContainerOfType(Categories).name.equalsIgnoreCase("exception")].toSet.size
		val mitigatesReqCount = targetReqs.map[requirements.filter[exception != null]].flatten.filter[filterRequirement(categoryFilters)].size 

		val featuresRequiringClassifiers = targetReqs.map[requirements].flatten.filter[filterRequirement(categoryFilters)].map[targetElement].filter(ClassifierFeature).filter[
			switch it {
				BusAccess : true
				DataPort : true
				EventDataPort : true 
				DataAccess : true
				default : false
			}
		]
		featuresRequiringClassifiers.forEach[resolveAll]
		val featuresWithRequiredClassifier = featuresRequiringClassifiers.filter[
			switch it {
				BusAccess : busFeatureClassifier != null
				DataPort : dataFeatureClassifier != null
				EventDataPort : dataFeatureClassifier != null
				DataAccess : dataFeatureClassifier != null
				default: false
			}
		]

		modelResult.metrics.featuresRequiringClassifierCount = featuresRequiringClassifiers.size
		modelResult.metrics.featuresWithRequiredClassifierCount = featuresWithRequiredClassifier.size
		modelResult.metrics.totalQualityCategoryCount = modelResult.totalQualityCategoriesCount
		modelResult.metrics.requirementsCount = targetReqs.map[requirements].flatten.toSet.filter[filterRequirement(categoryFilters)].size
		modelResult.metrics.requirementsWithoutPlanClaimCount = targetReqs.map[requirements].flatten.toSet.filter[filterRequirement(categoryFilters)].filter[sysReq | !claimReqs.contains(sysReq)].size
		modelResult.metrics.qualityCategoryRequirementsCount = targetReqs.map[requirements.filter[!(targetElement instanceof ClassifierFeature)]].flatten.filter[filterRequirement(categoryFilters)].map[category].flatten.filter[it.getContainerOfType(Categories).name.equalsIgnoreCase("quality")].toSet.size
		modelResult.metrics.featuresRequirementsCount = targetReqs.map[requirements].flatten.map[targetElement].filter(ClassifierFeature).toSet.size		
		modelResult.metrics.noVerificationPlansCount = verificationPlans.filter[vp | vp.claim.nullOrEmpty].size
		modelResult.metrics.exceptionsCount = exceptionReqCount + mitigatesReqCount
		modelResult.metrics.reqTargetHasEMV2SubclauseCount = targetReqs.map[requirements.filter[target.hasEMV2Subclause]].flatten.filter[filterRequirement(categoryFilters)].size

		modelResult.subsystemResult.forEach[subsystemResult|subsystemResult.process]	
		modelResult.subAssuranceCase.forEach[subAssuranceCase|subAssuranceCase.process]
	}

	def getCategoryFilters(AssureResult assureResult){
		val descs = commonRefFinder.getEObjectDescriptions(assureResult, CategoriesPackage.Literals.CATEGORY_FILTER, 'cat')
		val filter = descs.map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, assureResult) as CategoryFilter].filter[name=='testFilterBehaviorAny']
		filter	
	}

	def dispatch void process(SubsystemResult caseResult) {
		
		val targetSystem = caseResult.targetSystem
		val categoryFilters = caseResult.categoryFilters
		//println('categoryFilters = ' + categoryFilters)
		
		caseResult.metrics.featuresCount = targetSystem.allFeatures.size
		val claimResults = caseResult.claimResult
		val verificationPlans = claimResults.map[targetReference.verificationPlan] 
		val claimReqs = claimResults.map[targetReference.verificationPlan.claim].flatten.map[requirement].filter[filterRequirement(categoryFilters)].toSet
		val sysReqs = reqSpecrefFinder.getSystemRequirementSets(targetSystem.componentType)
		val exceptionReqCount = sysReqs.map[requirements].flatten.filter[filterRequirement(categoryFilters)].map[category].flatten.filter[getContainerOfType(Categories).name.equalsIgnoreCase("exception")].toSet.size
		val mitigatesReqCount = sysReqs.map[requirements.filter[exception != null]].flatten.filter[filterRequirement(categoryFilters)].size 

		val featuresRequiringClassifiers = sysReqs.map[requirements].flatten.filter[filterRequirement(categoryFilters)].map[targetElement].filter(ClassifierFeature).filter[
			switch it {
				BusAccess : true
				DataPort : true
				EventDataPort : true 
				DataAccess : true
				default : false
			}
		]
		featuresRequiringClassifiers.forEach[resolveAll]
		val featuresWithRequiredClassifier = featuresRequiringClassifiers.filter[
			switch it {
				BusAccess : busFeatureClassifier != null
				DataPort : dataFeatureClassifier != null
				EventDataPort : dataFeatureClassifier != null
				DataAccess : dataFeatureClassifier != null
				default: false
			}
		]
		
		caseResult.metrics.featuresRequiringClassifierCount = featuresRequiringClassifiers.size
		caseResult.metrics.featuresWithRequiredClassifierCount = featuresWithRequiredClassifier.size
		caseResult.metrics.totalQualityCategoryCount = caseResult.totalQualityCategoriesCount
		caseResult.metrics.requirementsCount = sysReqs.map[requirements].flatten.toSet.filter[filterRequirement(categoryFilters)].size
		caseResult.metrics.requirementsWithoutPlanClaimCount = sysReqs.map[requirements].flatten.toSet.filter[sysReq | !claimReqs.contains(sysReq)].filter[filterRequirement(categoryFilters)].size
		caseResult.metrics.qualityCategoryRequirementsCount = sysReqs.map[requirements.filter[!(targetElement instanceof ClassifierFeature)]].flatten.filter[filterRequirement(categoryFilters)].map[category].flatten.toSet.size
		caseResult.metrics.featuresRequirementsCount = sysReqs.map[requirements].flatten.filter[filterRequirement(categoryFilters)].map[targetElement].filter(ClassifierFeature).toSet.size	
		caseResult.metrics.noVerificationPlansCount = verificationPlans.filter[vp | vp.claim.nullOrEmpty].size
		caseResult.metrics.exceptionsCount = exceptionReqCount + mitigatesReqCount
		caseResult.metrics.reqTargetHasEMV2SubclauseCount = sysReqs.map[requirements.filter[target.hasEMV2Subclause]].flatten.filter[filterRequirement(categoryFilters)].size

		caseResult.subsystemResult.forEach[subcaseResult|subcaseResult.process]
	}

	def filterRequirement(Requirement requirement, Iterable<CategoryFilter> filters){
		filters.forall[filter |
			filter.category.empty || 
			if (filter.anyCategory){
				!requirement.category.disjoint(filter.category)
			} else {
				requirement.category.containsAll(filter.category)
			}
		]
	} 


}

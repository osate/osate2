package org.osate.assure.evaluator;

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import org.eclipse.core.runtime.IProgressMonitor
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
		val sysReqs = reqSpecrefFinder.getSystemRequirements(targetComponent)
		modelResult.metrics.qualityCategoryRequirementsCount = sysReqs.map[content.filter[!(targetElement instanceof ClassifierFeature)]].flatten.map[category].flatten.toSet.size
		modelResult.metrics.featuresRequirementsCount = sysReqs.map[content].flatten.map[targetElement].filter(ClassifierFeature).toSet.size		
		modelResult.subsystemResult.forEach[subsystemResult|subsystemResult.process]
		modelResult.subAssuranceCase.forEach[subAssuranceCase|subAssuranceCase.process]
	}

	def dispatch void process(SubsystemResult caseResult) {
		val targetSystem = caseResult.targetSystem
		caseResult.metrics.featuresCount = targetSystem.allFeatures.size
		val sysReqs = reqSpecrefFinder.getSystemRequirements(targetSystem.componentType)
		caseResult.metrics.qualityCategoryRequirementsCount = sysReqs.map[content.filter[!(targetElement instanceof ClassifierFeature)]].flatten.map[category].flatten.toSet.size
		caseResult.metrics.featuresRequirementsCount = sysReqs.map[content].flatten.map[targetElement].filter(ClassifierFeature).toSet.size	
		caseResult.subsystemResult.forEach[subcaseResult|subcaseResult.process]
	}

}

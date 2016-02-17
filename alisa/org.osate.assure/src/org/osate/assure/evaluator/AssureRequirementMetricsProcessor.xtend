package org.osate.assure.evaluator;

import com.google.inject.ImplementedBy
import org.eclipse.core.runtime.IProgressMonitor
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.Metrics
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.SubsystemResult
import org.osate.assure.assure.AssureFactory
import com.google.inject.Inject
import org.osate.reqspec.util.IReqspecGlobalReferenceFinder

@ImplementedBy(AssureRequirementMetricsProcessor)
interface IAssureRequirementMetricsProcessor {
	def void processCase(AssuranceCaseResult assureResult, IProgressMonitor monitor)
}

class AssureRequirementMetricsProcessor implements IAssureRequirementMetricsProcessor{
//	var IProgressMonitor progressmonitor
	@Inject IReqspecGlobalReferenceFinder reqSpecrefFinder
	val assureFactory = AssureFactory.eINSTANCE

	override processCase(AssuranceCaseResult assureResult, IProgressMonitor monitor) {
//		progressmonitor = monitor
//		val count = AssureUtilExtension.numberVerificationResults(assureResult)
//		progressmonitor.beginTask(assureResult.name, count)
		assureResult.process
	}


	def dispatch void process(AssuranceCaseResult caseResult) {
		caseResult.modelResult.forEach[modelResult|modelResult.process]
	}

	def dispatch void process(ModelResult modelResult) {
		println("process(ModelResult modelResult)")
		val targetComponent = modelResult.target
		if(modelResult.metrics == null) modelResult.metrics = assureFactory.createMetrics
		modelResult.metrics.featuresCount = targetComponent.getAllFeatures.size
		val sysReqs = reqSpecrefFinder.getSystemRequirements(targetComponent)
		modelResult.metrics.featuresRequirementsCount = sysReqs.map[it.content].flatten.size	
		println("modelResult.metrics.featuresCount = " + modelResult.metrics.featuresCount)
		println("modelResult.metrics.featuresRequirementsCount = " + modelResult.metrics.featuresRequirementsCount)
		modelResult.subsystemResult.forEach[subsystemResult|subsystemResult.process]
		modelResult.subAssuranceCase.forEach[subAssuranceCase|subAssuranceCase.process]
	}

	def dispatch void process(SubsystemResult caseResult) {
		println("process(SubsystemResult caseResult)")
//		if(caseResult.metrics == null) caseResult.metrics = assureFactory.createMetrics
		val targetSystem = caseResult.targetSystem
		caseResult.metrics.featuresCount = targetSystem.allFeatures.size
		val sysReqs = reqSpecrefFinder.getSystemRequirements(targetSystem.componentType)
		caseResult.metrics.featuresRequirementsCount = sysReqs.map[it.content].flatten.size	
		println("caseResult.metrics.featuresCount = " + caseResult.metrics.featuresCount)
		println("caseResult.metrics.featuresRequirementsCount = " + caseResult.metrics.featuresRequirementsCount)
		caseResult.subsystemResult.forEach[subcaseResult|subcaseResult.process]
	}

}

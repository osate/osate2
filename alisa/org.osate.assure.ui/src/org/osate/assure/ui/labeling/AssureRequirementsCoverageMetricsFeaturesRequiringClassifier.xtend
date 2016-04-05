package org.osate.assure.ui.labeling;

import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.SubsystemResult

class AssureRequirementsCoverageMetricsFeaturesRequiringClassifierLabelProvider extends AssureMetricsColumnLabelProvider {

	def int getCumulativeFeaturesWithRequiredClassifierCount(Object ele){
		switch ele {
			AssuranceCaseResult : {
				ele.metrics.featuresWithRequiredClassifierCount +
				 ele.modelResult.fold(0, [sum, modelRes | sum + modelRes.cumulativeFeaturesWithRequiredClassifierCount])
			}
			ModelResult : {
				ele.metrics.featuresWithRequiredClassifierCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeFeaturesWithRequiredClassifierCount])
			}
			SubsystemResult : {
				ele.metrics.featuresWithRequiredClassifierCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeFeaturesWithRequiredClassifierCount])
			}
			default : 0
		}
	}

	def int getCumulativeFeaturesRequiringClassifierCount(Object ele){
		switch ele {
			AssuranceCaseResult : {
				ele.metrics.featuresRequiringClassifierCount +
				 ele.modelResult.fold(0, [sum, modelRes | sum + modelRes.cumulativeFeaturesRequiringClassifierCount])
			}
			ModelResult : {
				ele.metrics.featuresRequiringClassifierCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeFeaturesRequiringClassifierCount])
			}
			SubsystemResult : {
				ele.metrics.featuresRequiringClassifierCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeFeaturesRequiringClassifierCount])
			}
			default : 0
		}
	}

	override getText(Object ele) {
		switch ele {
			AssuranceCaseResult : {
//				ele.metrics.exceptionsCount.toString + " of " +
//					ele.metrics.requirementsCount + 
//					" | Cumulative: " + 
					"" + 
					ele.cumulativeFeaturesWithRequiredClassifierCount + 
						" of "  + ele.cumulativeFeaturesRequiringClassifierCount 
			}
			ModelResult : {
				ele.metrics.featuresWithRequiredClassifierCount.toString + " of " +
					ele.metrics.featuresRequiringClassifierCount + 
						" | Cume: " + ele.cumulativeFeaturesWithRequiredClassifierCount + 
							" of " + ele.cumulativeFeaturesRequiringClassifierCount
			}
			SubsystemResult : {
				ele.metrics.featuresWithRequiredClassifierCount.toString + " of " +
					ele.metrics.featuresRequiringClassifierCount + 
						" | Cume: " + ele.cumulativeFeaturesWithRequiredClassifierCount + 
							" of " + ele.cumulativeFeaturesRequiringClassifierCount
			}
//			ResultIssue : {
//					ele.target?.constructLabel?:""+ ele.constructMessage
//			}
//			ElseResult : 'else'
//			ThenResult : 'then'
			default : '?'
		}
	}

}

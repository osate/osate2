package org.osate.assure.ui.labeling;

import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.SubsystemResult

class AssureRequirementsCoverageMetricsExceptionColumnLabelProvider
		extends AssureRequirementsCoverageMetricsColumnLabelProvider {

	def int getCumulativeExceptionsCount(Object ele){
		switch ele {
			AssuranceCaseResult : {
				ele.metrics.exceptionsCount +
				 ele.modelResult.fold(0, [sum, modelRes | sum + modelRes.cumulativeExceptionsCount])
			}
			ModelResult : {
				ele.metrics.exceptionsCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeExceptionsCount])
			}
			SubsystemResult : {
				ele.metrics.exceptionsCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeExceptionsCount])
			}
			default : 0
		}
	}

	def int getCumulativeRequirementsCount(Object ele){
		switch ele {
			AssuranceCaseResult : {
				ele.metrics.requirementsCount +
				 ele.modelResult.fold(0, [sum, modelRes | sum + modelRes.cumulativeRequirementsCount])
			}
			ModelResult : {
				ele.metrics.requirementsCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeRequirementsCount])
			}
			SubsystemResult : {
				ele.metrics.requirementsCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeRequirementsCount])
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
					ele.cumulativeExceptionsCount + 
						" of "  + ele.cumulativeRequirementsCount 
			}
			ModelResult : {
				ele.metrics.exceptionsCount.toString + " of " +
					ele.metrics.requirementsCount + 
						" | Cume: " + ele.cumulativeExceptionsCount + 
							" of " + ele.cumulativeRequirementsCount
			}
			SubsystemResult : {
				ele.metrics.exceptionsCount.toString + " of " +
					ele.metrics.requirementsCount + 
						" | Cume: " + ele.cumulativeExceptionsCount + 
							" of " + ele.cumulativeRequirementsCount
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

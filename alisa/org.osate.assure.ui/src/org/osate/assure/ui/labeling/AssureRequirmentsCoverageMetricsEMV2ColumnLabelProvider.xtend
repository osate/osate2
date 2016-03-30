package org.osate.assure.ui.labeling;

import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.SubsystemResult

class AssureRequirmentsCoverageMetricsEMV2ColumnLabelProvider extends AssureMetricsColumnLabelProvider {

	def int getCumulativeReqTargetHasEMV2SubclauseCount(Object ele){
		switch ele {
			AssuranceCaseResult : {
				ele.metrics.reqTargetHasEMV2SubclauseCount +
				 ele.modelResult.fold(0, [sum, modelRes | sum + modelRes.cumulativeReqTargetHasEMV2SubclauseCount])
			}
			ModelResult : {
				ele.metrics.reqTargetHasEMV2SubclauseCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeReqTargetHasEMV2SubclauseCount])
			}
			SubsystemResult : {
				ele.metrics.reqTargetHasEMV2SubclauseCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeReqTargetHasEMV2SubclauseCount])
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
					"Cumulative: " + 
					ele.cumulativeReqTargetHasEMV2SubclauseCount + 
						" of "  + ele.cumulativeRequirementsCount 
			}
			ModelResult : {
				ele.metrics.cumulativeReqTargetHasEMV2SubclauseCount.toString + " of " +
					ele.metrics.requirementsCount + 
						" | Cumulative: " + ele.cumulativeReqTargetHasEMV2SubclauseCount + 
							" of " + ele.cumulativeRequirementsCount
			}
			SubsystemResult : {
				ele.metrics.cumulativeReqTargetHasEMV2SubclauseCount.toString + " of " +
					ele.metrics.requirementsCount + 
						" | Cumulative: " + ele.cumulativeReqTargetHasEMV2SubclauseCount + 
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

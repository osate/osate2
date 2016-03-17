package org.osate.assure.ui.labeling;

import org.osate.alisa.common.common.ResultIssue
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.ElseResult
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.SubsystemResult
import org.osate.assure.assure.ThenResult

import static extension org.osate.assure.util.AssureUtilExtension.*

class AssureRequirementsWithNoPlanClaimColumnLabelProvider extends AssureRequirementsCoverageMetricsColumnLabelProvider {

	def int getCumulativeRequirementsWithoutPlanClaimCount(Object ele){
		switch ele {
			AssuranceCaseResult : {
				ele.metrics.requirementsWithoutPlanClaimCount +
				 ele.modelResult.fold(0, [sum, modelRes | sum + modelRes.cumulativeRequirementsWithoutPlanClaimCount])
			}
			ModelResult : {
				ele.metrics.requirementsWithoutPlanClaimCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeRequirementsWithoutPlanClaimCount])
			}
			SubsystemResult : {
				ele.metrics.requirementsWithoutPlanClaimCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeRequirementsWithoutPlanClaimCount])
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
//				ele.metrics.requirementsWithoutPlanClaimCount.toString + " of " +
//					ele.metrics.requirementsCount + 
//					" | Cumulative: " + 
					"Cumulative: " + 
					ele.cumulativeRequirementsWithoutPlanClaimCount + 
						" of "  + ele.cumulativeRequirementsCount 
			}
			ModelResult : {
				ele.metrics.requirementsWithoutPlanClaimCount.toString + " of " +
					ele.metrics.requirementsCount + 
						" | Cumulative: " + ele.cumulativeRequirementsWithoutPlanClaimCount + 
							" of " + ele.cumulativeRequirementsCount
			}
			SubsystemResult : {
				ele.metrics.requirementsWithoutPlanClaimCount.toString + " of " +
					ele.metrics.requirementsCount + 
						" | Cumulative: " + ele.cumulativeRequirementsWithoutPlanClaimCount + 
							" of " + ele.cumulativeRequirementsCount
			}
			ResultIssue : {
					ele.target?.constructLabel?:""+ ele.constructMessage
			}
			ElseResult : 'else'
			ThenResult : 'then'
			default : '?'
		}
	}

//	override getImage(Object ele){
//		null
//		ImageDescriptor.createFromFile(this.class,"/icons/" + getImageName(ele)).createImage
//	}
//	def getImageName(Object ele) {
//		switch ele {
//			ResultIssue : {
//				switch(ele.issueType){
//					case ResultIssueType.ERROR: 'error.png'
//					case ResultIssueType.SUCCESS: 'valid.png'
//					case ResultIssueType.WARNING: 'warning.png'
//					case ResultIssueType.INFO: 'info.png'
//					case FAIL: 'invalid.png'
//					case TBD: 'questionmark.png'
//				}
//			}
//			ClaimResult : {
//				if (ele.isSuccessful) return 'valid.png'
//				if (ele.isFail) return 'invalid.png'
//				if (ele.isErrorTimeOut) return 'error.png'
//				if (ele.isZeroCount) return 'info.png'
//				'questionmark.png'
//			}
//			ModelResult : {
//				if (ele.isSuccessful) return 'valid.png'
//				if (ele.isFail) return 'invalid.png'
//				if (ele.isErrorTimeOut) return 'error.png'
//				if (ele.isZeroCount) return 'info.png'
//				'questionmark.png'
//			}
//			SubsystemResult : {
//				if (ele.isSuccessful) return 'valid.png'
//				if (ele.isFail) return 'invalid.png'
//				if (ele.isErrorTimeOut) return 'error.png'
//				if (ele.isZeroCount) return 'info.png'
//				'questionmark.png'
//			}
//			AssuranceCaseResult : {
//				if (ele.isSuccessful) return 'valid.png'
//				if (ele.isFail) return 'invalid.png'
//				if (ele.isErrorTimeOut) return 'error.png'
//				if (ele.isZeroCount) return 'info.png'
//				'questionmark.png'
//			}
//			VerificationActivityResult : {
//				if (ele.isSuccessful) return 'valid.png'
//				if (ele.isFail) return 'invalid.png'
//				if (ele.isErrorTimeOut) return 'error.png'
//				if (ele.isZeroCount) return 'info.png'
//				'questionmark.png'
//			}
//			ValidationResult : {
//				if (ele.isSuccessful) return 'valid.png'
//				if (ele.isFail) return 'invalid.png'
//				if (ele.isErrorTimeOut) return 'error.png'
//				if (ele.isZeroCount) return 'info.png'
//				'questionmark.png'
//			}
//			ThenResult : {
//				if (ele.isSuccessful) return 'valid.png'
//				if (ele.isFail) return 'invalid.png'
//				if (ele.isErrorTimeOut) return 'error.png'
//				if (ele.isZeroCount) return 'info.png'
//				'questionmark.png'
//			}
//			ElseResult : {
//				if (ele.isSuccessful) return 'valid.png'
//				if (ele.isFail) return 'invalid.png'
//				if (ele.isErrorTimeOut) return 'error.png'
//				if (ele.isZeroCount) return 'info.png'
//				'questionmark.png'
//			}
//		}
//	}
}

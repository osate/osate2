package org.osate.assure.ui.labeling;

import java.text.NumberFormat
import org.osate.alisa.common.common.ResultIssue
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.ElseResult
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.SubsystemResult
import org.osate.assure.assure.ThenResult

import static extension org.osate.assure.util.AssureUtilExtension.*

class AssureQualityCategoryRequirementsColumnLabelProvider extends AssureRequirementsCoverageMetricsColumnLabelProvider {


	def int getCumulativeQualityCategoryRequirementsCount(Object ele){
		switch ele {
			AssuranceCaseResult : {
				ele.metrics.qualityCategoryRequirementsCount +
				 ele.modelResult.fold(0, [sum, modelRes | sum + modelRes.cumulativeQualityCategoryRequirementsCount])
			}
			ModelResult : {
				ele.metrics.qualityCategoryRequirementsCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeQualityCategoryRequirementsCount])
			}
			SubsystemResult : {
				ele.metrics.qualityCategoryRequirementsCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeQualityCategoryRequirementsCount])
			}
			default : 0
		}
	}
	def int getCumulativeTotalQualityCategorysCount(Object ele){
		switch ele {
			AssuranceCaseResult : {
				ele.metrics.totalQualityCategoryCount +
				 ele.modelResult.fold(0, [sum, modelRes | sum + modelRes.cumulativeTotalQualityCategorysCount])
			}
			ModelResult : {
				ele.metrics.totalQualityCategoryCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeTotalQualityCategorysCount])
			}
			SubsystemResult : {
				ele.metrics.totalQualityCategoryCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeTotalQualityCategorysCount])
			}
			default : 0
		}
	}

	def percentOfNumber(double x, double y) {
		val format = NumberFormat.getPercentInstance()
		format.setMinimumFractionDigits(2)
		format.format(x / y)
	}

	override getText(Object ele) {
		switch ele {
			AssuranceCaseResult : {
//				ele.metrics.qualityCategoryRequirementsCount.toString + " of " +
//					ele.metrics.totalQualityCategoryCount +  
//						" | Cumulative Coverage: " + 
						"" + 
						ele.cumulativeQualityCategoryRequirementsCount.percentOfNumber(ele.cumulativeTotalQualityCategorysCount)
			}
			ModelResult : {
				ele.metrics.qualityCategoryRequirementsCount.toString + " of " +
					ele.metrics.totalQualityCategoryCount +  
						" | Cume: " + 
						ele.cumulativeQualityCategoryRequirementsCount.percentOfNumber(ele.cumulativeTotalQualityCategorysCount)
			}
			SubsystemResult : {
				ele.metrics.qualityCategoryRequirementsCount.toString + " of " +
					ele.metrics.totalQualityCategoryCount +  
						" | Cume: " + 
						ele.cumulativeQualityCategoryRequirementsCount.percentOfNumber(ele.cumulativeTotalQualityCategorysCount)
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

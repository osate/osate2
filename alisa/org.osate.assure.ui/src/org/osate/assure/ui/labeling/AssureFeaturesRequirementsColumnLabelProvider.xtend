package org.osate.assure.ui.labeling;

import org.osate.alisa.common.common.ResultIssue
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.ElseResult
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.SubsystemResult
import org.osate.assure.assure.ThenResult

import static extension org.osate.assure.util.AssureUtilExtension.*

class  AssureFeaturesRequirementsColumnLabelProvider extends AssureRequirementsCoverageMetricsColumnLabelProvider {

	def int getCumulativeFeaturesRequirementsCount(Object ele){
		switch ele {
			AssuranceCaseResult : {
				ele.metrics.featuresRequirementsCount +
				 ele.modelResult.fold(0, [sum, modelRes | sum + modelRes.cumulativeFeaturesRequirementsCount])
			}
			ModelResult : {
				ele.metrics.featuresRequirementsCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeFeaturesRequirementsCount])
			}
			SubsystemResult : {
				ele.metrics.featuresRequirementsCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeFeaturesRequirementsCount])
			}
			default : 0
		}
	}

	def int getCumulativeFeaturesCount(Object ele){
		switch ele {
			AssuranceCaseResult : {
				ele.metrics.featuresCount +
				 ele.modelResult.fold(0, [sum, modelRes | sum + modelRes.cumulativeFeaturesCount])
			}
			ModelResult : {
				ele.metrics.featuresCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeFeaturesCount])
			}
			SubsystemResult : {
				ele.metrics.featuresCount +
					 ele.subsystemResult.fold(0, [sum, subRes | sum + subRes.cumulativeFeaturesCount])
			}
			default : 0
		}
	}

	override getText(Object ele) {
		switch ele {
			AssuranceCaseResult : {
//				ele.metrics.featuresRequirementsCount.toString + " for " +
//					ele.metrics.featuresCount +  
//						" | Cumulative: " + 
						"Cumulative: " + 
						ele.cumulativeFeaturesRequirementsCount + 
							 " for " + ele.cumulativeFeaturesCount
			}
			ModelResult : {
				ele.metrics.featuresRequirementsCount.toString + " for " +
					ele.metrics.featuresCount +  
						" | Cumulative: " + ele.cumulativeFeaturesRequirementsCount + 
							 " for " + ele.cumulativeFeaturesCount
			}
			SubsystemResult : {
				ele.metrics.featuresRequirementsCount.toString + " for " +
					ele.metrics.featuresCount +  
						" | Cumulative: " + ele.cumulativeFeaturesRequirementsCount + 
							 " for " + ele.cumulativeFeaturesCount
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

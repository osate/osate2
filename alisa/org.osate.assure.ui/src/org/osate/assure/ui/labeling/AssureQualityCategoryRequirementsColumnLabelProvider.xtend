package org.osate.assure.ui.labeling;

import org.osate.alisa.common.common.ResultIssue
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.ElseResult
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.SubsystemResult
import org.osate.assure.assure.ThenResult

import static extension org.osate.assure.util.AssureUtilExtension.*

class AssureQualityCategoryRequirementsColumnLabelProvider extends AssureRequirementsCoverageMetricsColumnLabelProvider {

	override getText(Object ele) {
		switch ele {
//		modelResult.metrics.requirementsWithoutPlanClaimCount = targetReqs.map[requirements].flatten.toSet.filter[sysReq | !claimReqs.contains(sysReq)].size
//		modelResult.metrics.qualityCategoryRequirementsCount = targetReqs.map[requirements.filter[!(targetElement instanceof ClassifierFeature)]].flatten.map[category].flatten.toSet.size
//		modelResult.metrics.featuresRequirementsCount = targetReqs.map[requirements].flatten.map[targetElement].filter(ClassifierFeature).toSet.size		
//		modelResult.metrics.noVerificationPlansCount = verificationPlans.filter[vp | vp.claim.nullOrEmpty].size

			AssuranceCaseResult : "" + ele.metrics.qualityCategoryRequirementsCount
			ModelResult : "" +  ele.metrics.qualityCategoryRequirementsCount
			SubsystemResult : "" +  ele.metrics.qualityCategoryRequirementsCount
//			ClaimResult : ele.assureResultCounts
//			VerificationActivityResult : ele.assureResultCounts
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

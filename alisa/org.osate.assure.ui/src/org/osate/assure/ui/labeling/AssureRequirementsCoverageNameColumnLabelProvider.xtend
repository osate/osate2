package org.osate.assure.ui.labeling;

import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.ElseResult
import org.osate.assure.assure.ThenResult
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.VerificationActivityResult

import static extension org.osate.assure.util.AssureUtilExtension.*
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.alisa.common.common.ResultIssue
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.SubsystemResult
import org.osate.alisa.common.common.ResultIssueType
import org.osate.assure.assure.PreconditionResult

class AssureRequirementsCoverageNameColumnLabelProvider extends ColumnLabelProvider {

	override getText(Object ele) {
		switch ele {
			AssuranceCaseResult : "Assurance case "+ele.name 
			ModelResult : "Assurance plan "+ele.name 
			SubsystemResult : "Subsystem verification "+ele.name 
			ClaimResult : "Claim "+ele.name
			VerificationActivityResult : "Evidence "+ele.name
			ValidationResult : "Validation "+ele.name
			PreconditionResult : "Precondition "+ele.name
			ResultIssue : {
					"Issue "+ele.target?.constructLabel?:""+ ele.constructMessage
			}
			ElseResult : 'else'
			ThenResult : 'then'
			default : '?'
		}
	}

	override getImage(Object ele){
		ImageDescriptor.createFromFile(this.class,"/icons/" + getImageName(ele)).createImage
	}
	def getImageName(Object ele) {
		switch ele {
			ResultIssue : {
				switch(ele.issueType){
					case ResultIssueType.ERROR: 'error.png'
					case ResultIssueType.SUCCESS: 'valid.png'
					case ResultIssueType.WARNING: 'warning.png'
					case ResultIssueType.INFO: 'info.png'
					case FAIL: 'invalid.png'
					case TBD: 'questionmark.png'
				}
			}
//			ClaimResult : {
//				if (ele.isSuccessful) return 'valid.png'
//				if (ele.isFail) return 'invalid.png'
//				if (ele.isErrorTimeOut) return 'error.png'
//				if (ele.isZeroCount) return 'info.png'
//				'questionmark.png'
//			}
			AssuranceCaseResult : {
				'assure.png'
//				if (ele.isSuccessful) return 'valid.png'
//				if (ele.isFail) return 'invalid.png'
//				if (ele.isErrorTimeOut) return 'error.png'
//				if (ele.isZeroCount) return 'info.png'
//				'questionmark.png'
			}
			ModelResult : {
				if (ele.isSuccessful) return 'valid.png'
				if (ele.isFail) return 'invalid.png'
				if (ele.isErrorTimeOut) return 'error.png'
				if (ele.isZeroCount) return 'info.png'
				'questionmark.png'
			}
			SubsystemResult : {
				if (ele.isSuccessful) return 'valid.png'
				if (ele.isFail) return 'invalid.png'
				if (ele.isErrorTimeOut) return 'error.png'
				if (ele.isZeroCount) return 'info.png'
				'questionmark.png'
			}
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
//			PreconditionResult : {
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
		}
	}
}

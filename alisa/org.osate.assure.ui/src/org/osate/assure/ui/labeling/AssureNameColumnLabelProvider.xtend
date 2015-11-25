package org.osate.assure.ui.labeling;

import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.osate.assure.assure.AssuranceCase
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.ElseResult
import org.osate.assure.assure.ResultIssue
import org.osate.assure.assure.ResultIssueType
import org.osate.assure.assure.ThenResult
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.VerificationActivityResult

import static extension org.osate.assure.util.AssureUtilExtension.*

class AssureNameColumnLabelProvider extends ColumnLabelProvider {

	override getText(Object ele) {
		switch ele {
			AssuranceCase : "System "+ele.name 
			ClaimResult : "Claim"+ele.name
			VerificationActivityResult : "Evidence "+ele.name
			ResultIssue : {
					if (ele.name == null) ele.target?.constructLabel?:""+ ele.constructMessage
					else ele.name //+ ": " + ele.constructMessage
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
					case ResultIssueType.ERROR: 'invalid.png'
					case ResultIssueType.SUCCESS: 'valid.png'
					case ResultIssueType.WARNING: 'warning.png'
					case ResultIssueType.INFO: 'info.png'
				}
			}
			ClaimResult : {
				if (ele.isSuccessful) return 'valid.png'
				if (ele.isFail) return 'invalid.png'
				if (ele.isErrorTimeOut) return 'error.png'
				if (ele.isZeroCount) return 'info.png'
				'questionmark.png'
			}
			AssuranceCase : {
				if (ele.isSuccessful) return 'valid.png'
				if (ele.isFail) return 'invalid.png'
				if (ele.isErrorTimeOut) return 'error.png'
				if (ele.isZeroCount) return 'info.png'
				'questionmark.png'
			}
			VerificationActivityResult : {
				if (ele.isSuccessful) return 'valid.png'
				if (ele.isFail) return 'invalid.png'
				if (ele.isErrorTimeOut) return 'error.png'
				if (ele.isZeroCount) return 'info.png'
				'questionmark.png'
			}
			ValidationResult : {
				if (ele.isSuccessful) return 'valid.png'
				if (ele.isFail) return 'invalid.png'
				if (ele.isErrorTimeOut) return 'error.png'
				if (ele.isZeroCount) return 'info.png'
				'questionmark.png'
			}
			ThenResult : {
				if (ele.isSuccessful) return 'valid.png'
				if (ele.isFail) return 'invalid.png'
				if (ele.isErrorTimeOut) return 'error.png'
				if (ele.isZeroCount) return 'info.png'
				'questionmark.png'
			}
			ElseResult : {
				if (ele.isSuccessful) return 'valid.png'
				if (ele.isFail) return 'invalid.png'
				if (ele.isErrorTimeOut) return 'error.png'
				if (ele.isZeroCount) return 'info.png'
				'questionmark.png'
			}
		}
	}
}

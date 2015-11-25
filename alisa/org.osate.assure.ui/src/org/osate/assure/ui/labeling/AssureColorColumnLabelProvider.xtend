package org.osate.assure.ui.labeling;

import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Display
import org.osate.assure.assure.AssuranceCase
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.ElseResult
import org.osate.assure.assure.ResultIssue
import org.osate.assure.assure.ResultIssueType
import org.osate.assure.assure.ThenResult
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.VerificationActivityResult
import static extension org.osate.assure.util.AssureUtilExtension.*
import org.osate.assure.assure.Metrics

class AssureColorColumnLabelProvider extends ColumnLabelProvider {
	
	private var indicatorColumnNumber = -1
	new(int colNumber) {
		super()
		indicatorColumnNumber = colNumber
	}
		
	override getBackground(Object element) {
		Display.getCurrent().getSystemColor(getColorValue(element))
	}
	 
	override getText(Object obj){
		""
	}

	def getIndicatorColumnNumber(){
		indicatorColumnNumber
	}


	def getColorValue(Object ele){
		switch ele {
			ResultIssue : {
				switch(ele.issueType){
					case ResultIssueType.ERROR: SWT.COLOR_DARK_GRAY
					case ResultIssueType.SUCCESS: SWT.COLOR_GREEN
					case ResultIssueType.WARNING: SWT.COLOR_YELLOW
					case ResultIssueType.INFO: SWT.COLOR_DARK_BLUE
					default : SWT.COLOR_BLUE
				}
			}
			ClaimResult : {
				if (ele.isSuccessful) return SWT.COLOR_GREEN
				if (ele.isZeroCount) return SWT.COLOR_DARK_BLUE
				var colorBlockCountHolder = AssureColorBlockCountHolder.createAssureColorBlockCountHolder(ele)
				colorBlockCountHolder.colorValues.get(indicatorColumnNumber)
			}
			AssuranceCase : {
				if (ele.isSuccessful) return SWT.COLOR_GREEN
				if (ele.isZeroCount) return SWT.COLOR_DARK_BLUE
				var colorBlockCountHolder = AssureColorBlockCountHolder.createAssureColorBlockCountHolder(ele)
				colorBlockCountHolder.colorValues.get(indicatorColumnNumber)
			}
			VerificationActivityResult : {
				if (ele.isSuccessful) return SWT.COLOR_GREEN
				if (ele.isFail) return  SWT.COLOR_RED
				if (ele.isErrorTimeOut) return SWT.COLOR_DARK_GRAY
				if (ele.isZeroCount) return SWT.COLOR_DARK_BLUE
				SWT.COLOR_BLUE
			}
			ValidationResult : {
				if (ele.isSuccessful) return SWT.COLOR_GREEN
				if (ele.isFail) return SWT.COLOR_RED
				if (ele.isErrorTimeOut) return  SWT.COLOR_DARK_GRAY
				if (ele.isZeroCount) return SWT.COLOR_DARK_BLUE
				SWT.COLOR_BLUE
			}
			ThenResult : {
				if (ele.isSuccessful) return SWT.COLOR_GREEN
				if (ele.isFail) return SWT.COLOR_RED
				if (ele.isErrorTimeOut) return SWT.COLOR_DARK_GRAY
				if (ele.isZeroCount) return SWT.COLOR_DARK_BLUE
				SWT.COLOR_BLUE
			}
			ElseResult : {
				if (ele.isSuccessful) return SWT.COLOR_GREEN
				if (ele.isFail) return SWT.COLOR_RED
				if (ele.isErrorTimeOut) return SWT.COLOR_DARK_GRAY
				if (ele.isZeroCount) return SWT.COLOR_DARK_BLUE
				SWT.COLOR_BLUE
			}
		}
	}
}

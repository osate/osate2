package org.osate.results.util

import org.osate.results.results.ResultReport

class ResultsUtilExtension {
	def static String getResultValue(ResultReport report, String resultName){
		for (pair : report.resultData.data){
			if (pair.name == resultName) return pair.value
		}
		""
	}
}
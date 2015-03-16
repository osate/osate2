package org.osate.results.util

import org.osate.results.results.ResultReport
import org.eclipse.emf.ecore.EObject
import org.osate.results.results.ResultsFactory

import org.osate.results.results.ReportIssueType

class ResultsUtilExtension {
	def static String getResultValue(ResultReport report, String resultName){
		for (pair : report.resultData.data){
			if (pair.name == resultName) return pair.value
		}
		""
	}
	
	def static void addError(ResultReport report, String msg, EObject target){
		val issue = ResultsFactory.eINSTANCE.createReportIssue
		issue.target = target
		issue.title = msg
		issue.issueType = ReportIssueType.ERROR
		report.issue.add(issue)
	} 
	
	def static void addWarning(ResultReport report, String msg, EObject target){
		val issue = ResultsFactory.eINSTANCE.createReportIssue
		issue.target = target
		issue.title = msg
		issue.issueType = ReportIssueType.WARNING
		report.issue.add(issue)
	} 
	
	def static void addSuccess(ResultReport report, String msg, EObject target){
		val issue = ResultsFactory.eINSTANCE.createReportIssue
		issue.target = target
		issue.title = msg
		issue.issueType = ReportIssueType.SUCCESS
		report.issue.add(issue)
	} 
	
	def static ResultReport createReport(String name, EObject target){
		val res = ResultsFactory.eINSTANCE.createResultReport()
		res.name = name
		res.root = target
		res
	}
}
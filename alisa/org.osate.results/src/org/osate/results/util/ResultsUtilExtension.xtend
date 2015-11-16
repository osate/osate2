/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.results.util

import org.eclipse.emf.ecore.EObject
import org.osate.results.results.ReportIssueType
import org.osate.results.results.ResultContributor
import org.osate.results.results.ResultReport
import org.osate.results.results.ResultReportCollection
import org.osate.results.results.ResultsFactory
import org.osate.results.results.ResultIssueHolder

class ResultsUtilExtension {
	def static String getResultValue(ResultReport report, String resultName){
		for (pair : report.resultData){
			if (pair.name == resultName) return pair.value
		}
		""
	} 
	
	def static void addError(ResultIssueHolder holder, String msg, EObject target){
		holder.addIssue(msg, target,  ReportIssueType.ERROR)
	} 
	
	def static void addWarning(ResultIssueHolder holder, String msg, EObject target){
		holder.addIssue(msg, target,  ReportIssueType.WARNING)
	} 
	
	def static void addInfo(ResultIssueHolder holder, String msg, EObject target){
		holder.addIssue(msg, target,  ReportIssueType.INFO)
	} 
	
	def static void addSuccess(ResultIssueHolder holder, String msg, EObject target){
		holder.addIssue(msg, target,  ReportIssueType.SUCCESS)
	} 
	
	def static void addFail(ResultIssueHolder holder, String msg, EObject target){
		holder.addIssue(msg, target,  ReportIssueType.FAIL)
	} 
	
	def static void addUnknown(ResultIssueHolder holder, String msg, EObject target){
		holder.addIssue(msg, target,  ReportIssueType.UNKNOWN)
	} 
	
	def static void addIssue (ResultIssueHolder holder, String msg, EObject target,  ReportIssueType rit){
		val issue = ResultsFactory.eINSTANCE.createReportIssue
		issue.target = target
		issue.title = msg
		issue.issueType = rit
		holder.issues.add(issue)
	} 
	
	def static ResultReportCollection createReportCollection(String name, EObject target){
		val res = ResultsFactory.eINSTANCE.createResultReportCollection()
		res.name = name
		res.target = target
		res
	}
	
	def static ResultReport createReport(String name, EObject target){
		val res = ResultsFactory.eINSTANCE.createResultReport()
		res.name = name
		res.target = target
		res
	}
	
	def static ResultReport addReport(ResultReportCollection rrc, String name, EObject target){
		val res = createReport(name, target)
		rrc.content += res
		res
	}
	
	def static ResultContributor addReportContributor(ResultReport report, EObject target){
		val res = ResultsFactory.eINSTANCE.createResultContributor => [ contributor = target]
		report.content += res
		res
	}
	
	def static void addResultValue(ResultReport report, String myname, String myvalue){
			val resData = ResultsFactory.eINSTANCE.createResultData
				=> [ name = myname
					value = myvalue]
		report.resultData += resData
	}
}
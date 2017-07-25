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
import org.osate.results.results.ResultContributor
import org.osate.results.results.ResultReport
import org.osate.results.results.ResultReportCollection
import org.osate.results.results.ResultsFactory
import org.osate.results.results.ResultDataReport
import org.osate.alisa.common.common.ResultIssue
import org.osate.alisa.common.common.ResultIssueType
import org.osate.alisa.common.common.CommonFactory
import org.eclipse.emf.common.util.EList

class ResultsUtilExtension {
	// addition as subissue to an issue
	def static void addError(ResultIssue holder, String msg, EObject target, String diagnosticId){
		holder.addIssue(msg, target,  ResultIssueType.ERROR, diagnosticId)
	} 
	
	def static void addWarning(ResultIssue holder, String msg, EObject target, String diagnosticId){
		holder.addIssue(msg, target,  ResultIssueType.WARNING, diagnosticId)
	} 
	
	def static void addInfo(ResultIssue holder, String msg, EObject target, String diagnosticId){
		holder.addIssue(msg, target,  ResultIssueType.INFO, diagnosticId)
	} 
	
	def static void addSuccess(ResultIssue holder, String msg, EObject target, String diagnosticId){
		holder.addIssue(msg, target,  ResultIssueType.SUCCESS, diagnosticId)
	} 
	
	def static void addFail(ResultIssue holder, String msg, EObject target, String diagnosticId){
		holder.addIssue(msg, target,  ResultIssueType.FAIL, diagnosticId)
	} 
	
	def static void addTBD(ResultIssue holder, String msg, EObject target, String diagnosticId){
		holder.addIssue(msg, target,  ResultIssueType.TBD, diagnosticId)
	} 
	
	def static void addIssue (ResultIssue holder, String msg, EObject target,  ResultIssueType rit, String diagnosticId){
		holder.issues.add(createIssue(msg,target,rit,diagnosticId))
	} 
	
	// addition to issues list
	def static void addError(EList<ResultIssue> holder, String msg, EObject target, String diagnosticId){
		holder.addIssue(msg, target,  ResultIssueType.ERROR, diagnosticId)
	} 
	
	def static void addWarning(EList<ResultIssue> holder, String msg, EObject target, String diagnosticId){
		holder.addIssue(msg, target,  ResultIssueType.WARNING, diagnosticId)
	} 
	
	def static void addInfo(EList<ResultIssue> holder, String msg, EObject target, String diagnosticId){
		holder.addIssue(msg, target,  ResultIssueType.INFO, diagnosticId)
	} 
	
	def static void addSuccess(EList<ResultIssue> holder, String msg, EObject target, String diagnosticId){
		holder.addIssue(msg, target,  ResultIssueType.SUCCESS, diagnosticId)
	} 
	
	def static void addFail(EList<ResultIssue> holder, String msg, EObject target, String diagnosticId){
		holder.addIssue(msg, target,  ResultIssueType.FAIL, diagnosticId)
	} 
	
	def static void addTBD(EList<ResultIssue> holder, String msg, EObject target, String diagnosticId){
		holder.addIssue(msg, target,  ResultIssueType.TBD, diagnosticId)
	} 
	
	def static void addIssue (EList<ResultIssue> holder, String msg, EObject target,  ResultIssueType rit, String diagnosticId){
		holder.add(createIssue(msg,target,rit,diagnosticId))
	} 
	
	def static ResultIssue createIssue (String msg, EObject target,  ResultIssueType rit, String diagnosticId){
		val issue = CommonFactory.eINSTANCE.createResultIssue
		issue.target = target
		issue.message = msg
		issue.issueType = rit
		issue.diagnosticId = diagnosticId
		issue
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
	
	def static ResultContributor addReportContributor(ResultDataReport report, EObject target){
		val res = ResultsFactory.eINSTANCE.createResultContributor => [ it.target = target]
		report.content += res
		res
	}
}
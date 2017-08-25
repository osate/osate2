package org.osate.results.util;

import org.eclipse.emf.ecore.EObject;
import org.osate.results.ResultIssue;
import org.osate.results.ResultIssueType;
import org.osate.results.Results;
import org.osate.results.ResultsFactory;

public class ResultsUtil {

	public static ResultIssue createError(String msg, EObject target, String diagnosticId) {
		return createIssue(msg, target, ResultIssueType.ERROR, diagnosticId);
	}

	public static ResultIssue createWarning(String msg, EObject target, String diagnosticId) {
		return createIssue(msg, target, ResultIssueType.WARNING, diagnosticId);
	}

	public static ResultIssue createInfo(String msg, EObject target, String diagnosticId) {
		return createIssue(msg, target, ResultIssueType.INFO, diagnosticId);
	}

	public static ResultIssue createSuccess(String msg, EObject target, String diagnosticId) {
		return createIssue(msg, target, ResultIssueType.SUCCESS, diagnosticId);
	}

	public static ResultIssue createFail(String msg, EObject target, String diagnosticId) {
		return createIssue(msg, target, ResultIssueType.FAIL, diagnosticId);
	}

	public static ResultIssue createTBD(String msg, EObject target, String diagnosticId) {
		return createIssue(msg, target, ResultIssueType.TBD, diagnosticId);
	}

	public static ResultIssue createIssue(String msg, EObject target, ResultIssueType rit, String diagnosticId) {
		ResultIssue issue = ResultsFactory.eINSTANCE.createResultIssue();
		issue.setTarget(target);
		issue.setMessage(msg);
		issue.setIssueType(rit);
		issue.setDiagnosticId(diagnosticId);
		return issue;
	}

	public static Results createResults(String name, EObject target) {
		Results results = ResultsFactory.eINSTANCE.createResults();
		results.setTarget(target);
		results.setName(name);
		return results;
	}

}

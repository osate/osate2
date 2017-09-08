package org.osate.result.util;

import org.eclipse.emf.ecore.EObject;
import org.osate.result.Issue;
import org.osate.result.IssueType;
import org.osate.result.Result;
import org.osate.result.ResultFactory;

public class ResultsUtil {

	public static Issue createError(String msg, EObject target, String diagnosticId) {
		return createIssue(msg, target, IssueType.ERROR, diagnosticId);
	}

	public static Issue createWarning(String msg, EObject target, String diagnosticId) {
		return createIssue(msg, target, IssueType.WARNING, diagnosticId);
	}

	public static Issue createInfo(String msg, EObject target, String diagnosticId) {
		return createIssue(msg, target, IssueType.INFO, diagnosticId);
	}

	public static Issue createSuccess(String msg, EObject target, String diagnosticId) {
		return createIssue(msg, target, IssueType.SUCCESS, diagnosticId);
	}

	public static Issue createFail(String msg, EObject target, String diagnosticId) {
		return createIssue(msg, target, IssueType.FAIL, diagnosticId);
	}

	public static Issue createNone(String msg, EObject target, String diagnosticId) {
		return createIssue(msg, target, IssueType.NONE, diagnosticId);
	}

	public static Issue createIssue(String msg, EObject target, IssueType rit, String diagnosticId) {
		Issue issue = ResultFactory.eINSTANCE.createIssue();
		issue.setSourceReference(target);
		issue.setMessage(msg);
		issue.setIssueType(rit);
		issue.setDiagnostic(diagnosticId);
		return issue;
	}

	public static Result createResult(String name, EObject target) {
		Result result = ResultFactory.eINSTANCE.createResult();
		result.setSourceReference(target);
		result.setAnalysis(name);
		return result;
	}

}

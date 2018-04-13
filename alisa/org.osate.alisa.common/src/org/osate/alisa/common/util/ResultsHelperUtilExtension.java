package org.osate.alisa.common.util;

import org.eclipse.emf.ecore.EObject;
import org.osate.result.AnalysisResult;
import org.osate.result.Diagnostic;
import org.osate.result.DiagnosticType;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;

public class ResultsHelperUtilExtension {

	public static Diagnostic addFailureIssue(Result ri, EObject target, String message) {
		Diagnostic issue = ResultUtil.createFailure(message, target);
		ri.getDiagnostics().add(issue);
		return issue;
	}

	public static Diagnostic addSuccessIssue(Result ri, EObject target, String message) {
		Diagnostic issue = ResultUtil.createSuccess(message, target);
		ri.getDiagnostics().add(issue);
		return issue;
	}

	/**
	 * true if there are any diagnostics with FAILURE type
	 * @param res
	 * @return
	 */
	public static boolean hasFailures(Result res) {
		for (Diagnostic d : res.getDiagnostics()) {
			if (hasFailures(d)) {
				return true;
			}
		}
		for (Result subres : res.getSubResults()) {
			if (hasFailures(subres)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasFailures(AnalysisResult res) {
		for (Result r : res.getResults()) {
			if (hasFailures(r)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasFailures(Diagnostic res) {
		if (res.getType() == DiagnosticType.FAILURE) {
			return true;
		}
		for (Diagnostic r : res.getIssues()) {
			if (hasFailures(r)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasErrors(Diagnostic res) {
		if (res.getType() == DiagnosticType.ERROR) {
			return true;
		}
		for (Diagnostic r : res.getIssues()) {
			if (hasFailures(r)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasErrors(Result res) {
		for (Diagnostic d : res.getDiagnostics()) {
			if (hasErrors(d)) {
				return true;
			}
		}
		for (Result subres : res.getSubResults()) {
			if (hasErrors(subres)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasErrors(AnalysisResult res) {
		for (Result r : res.getResults()) {
			if (hasErrors(r)) {
				return true;
			}
		}
		return false;
	}

}

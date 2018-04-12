package org.osate.assure.util;

import org.eclipse.emf.ecore.EObject;
import org.osate.result.Diagnostic;
import org.osate.result.DiagnosticType;
import org.osate.result.Result;
import org.osate.result.ResultFactory;

public class ResultsHelperUtilExtension {

	public static void addFailureIssue(Result ri, EObject target, String message) {
		Diagnostic issue = ResultFactory.eINSTANCE.createDiagnostic();
		issue.setMessage(message);
		issue.setType(DiagnosticType.FAILURE);
		issue.setSourceReference(target);
		ri.getDiagnostics().add(issue);
	}

	public static void addSuccessIssue(Result ri, EObject target, String message) {
		Diagnostic issue = ResultFactory.eINSTANCE.createDiagnostic();
		issue.setMessage(message);
		issue.setType(DiagnosticType.SUCCESS);
		issue.setSourceReference(target);
		ri.getDiagnostics().add(issue);
	}

	public static boolean hasFailures(Result res) {
		for (Diagnostic d : res.getDiagnostics()) {
			if (d.getType() == DiagnosticType.FAILURE) {
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

}

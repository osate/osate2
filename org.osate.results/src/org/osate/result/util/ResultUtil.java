package org.osate.result.util;

import org.eclipse.emf.ecore.EObject;
import org.osate.result.BooleanValue;
import org.osate.result.Contributor;
import org.osate.result.Diagnostic;
import org.osate.result.DiagnosticType;
import org.osate.result.IntegerValue;
import org.osate.result.RealValue;
import org.osate.result.Result;
import org.osate.result.ResultFactory;
import org.osate.result.StringValue;

public class ResultUtil {

	public static Diagnostic createError(String msg, EObject target) {
		return createIssue(msg, target, DiagnosticType.ERROR);
	}

	public static Diagnostic createWarning(String msg, EObject target) {
		return createIssue(msg, target, DiagnosticType.WARNING);
	}

	public static Diagnostic createInfo(String msg, EObject target) {
		return createIssue(msg, target, DiagnosticType.INFO);
	}

	public static Diagnostic createSuccess(String msg, EObject target) {
		return createIssue(msg, target, DiagnosticType.SUCCESS);
	}

	public static Diagnostic createFailure(String msg, EObject target) {
		return createIssue(msg, target, DiagnosticType.FAILURE);
	}

	public static Diagnostic createNone(String msg, EObject target) {
		return createIssue(msg, target, DiagnosticType.NONE);
	}

	public static Diagnostic createIssue(String msg, EObject target, DiagnosticType rit) {
		Diagnostic issue = ResultFactory.eINSTANCE.createDiagnostic();
		issue.setSourceReference(target);
		issue.setMessage(msg);
		issue.setType(rit);
		return issue;
	}

	public static Result createResult(String name, EObject target) {
		Result result = ResultFactory.eINSTANCE.createResult();
		result.setSourceReference(target);
		result.setAnalysis(name);
		return result;
	}

	public static void addIntegerValue(Result result, long value) {
		IntegerValue res = ResultFactory.eINSTANCE.createIntegerValue();
		res.setValue(value);
		result.getValues().add(res);
	}

	public static void addIntegerValue(Contributor contributor, long value) {
		IntegerValue res = ResultFactory.eINSTANCE.createIntegerValue();
		res.setValue(value);
		contributor.getValues().add(res);
	}

	public static void addIntegerValue(Result result, long value, String unit) {
		IntegerValue res = ResultFactory.eINSTANCE.createIntegerValue();
		res.setValue(value);
		res.setUnit(unit);
		result.getValues().add(res);
	}

	public static void addIntegerValue(Contributor contributor, long value, String unit) {
		IntegerValue res = ResultFactory.eINSTANCE.createIntegerValue();
		res.setValue(value);
		res.setUnit(unit);
		contributor.getValues().add(res);
	}

	public static void addRealValue(Result result, double value) {
		RealValue res = ResultFactory.eINSTANCE.createRealValue();
		res.setValue(value);
		result.getValues().add(res);
	}

	public static void addRealValue(Contributor contributor, double value) {
		RealValue res = ResultFactory.eINSTANCE.createRealValue();
		res.setValue(value);
		contributor.getValues().add(res);
	}

	public static void addRealValue(Result result, double value, String unit) {
		RealValue res = ResultFactory.eINSTANCE.createRealValue();
		res.setValue(value);
		res.setUnit(unit);
		result.getValues().add(res);
	}

	public static void addRealValue(Contributor contributor, double value, String unit) {
		RealValue res = ResultFactory.eINSTANCE.createRealValue();
		res.setValue(value);
		res.setUnit(unit);
		contributor.getValues().add(res);
	}

	public static void addStringValue(Result result, String value) {
		StringValue res = ResultFactory.eINSTANCE.createStringValue();
		res.setValue(value);
		result.getValues().add(res);
	}

	public static void addStringValue(Contributor contributor, String value) {
		StringValue res = ResultFactory.eINSTANCE.createStringValue();
		res.setValue(value);
		contributor.getValues().add(res);
	}

	public static void addBooleanValue(Result result, boolean value) {
		BooleanValue res = ResultFactory.eINSTANCE.createBooleanValue();
		res.setValue(value);
		result.getValues().add(res);
	}

	public static void addBooleanValue(Contributor contributor, boolean value) {
		BooleanValue res = ResultFactory.eINSTANCE.createBooleanValue();
		res.setValue(value);
		contributor.getValues().add(res);
	}

}

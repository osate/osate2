package org.osate.result.util;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.result.AnalysisResult;
import org.osate.result.BooleanValue;
import org.osate.result.Diagnostic;
import org.osate.result.DiagnosticType;
import org.osate.result.EObjectValue;
import org.osate.result.IntegerValue;
import org.osate.result.ObjectValue;
import org.osate.result.RealValue;
import org.osate.result.Result;
import org.osate.result.ResultFactory;
import org.osate.result.StringValue;
import org.osate.result.Value;

public class ResultUtil {

	public static Diagnostic createError(String msg, EObject target) {
		return createDiagnostic(msg, target, DiagnosticType.ERROR);
	}

	public static Diagnostic createWarning(String msg, EObject target) {
		return createDiagnostic(msg, target, DiagnosticType.WARNING);
	}

	public static Diagnostic createInfo(String msg, EObject target) {
		return createDiagnostic(msg, target, DiagnosticType.INFO);
	}

	public static Diagnostic createSuccess(String msg, EObject target) {
		return createDiagnostic(msg, target, DiagnosticType.SUCCESS);
	}

	public static Diagnostic createFailure(String msg, EObject target) {
		return createDiagnostic(msg, target, DiagnosticType.FAILURE);
	}

	public static Diagnostic createNone(String msg, EObject target) {
		return createDiagnostic(msg, target, DiagnosticType.NONE);
	}

	public static Diagnostic createDiagnostic(String msg, EObject target, DiagnosticType rit) {
		Diagnostic issue = ResultFactory.eINSTANCE.createDiagnostic();
		issue.setSourceReference(target);
		issue.setMessage(msg);
		issue.setType(rit);
		return issue;
	}

	public static Result createErrorResult(String msg, EObject target) {
		return createResult(msg, target, DiagnosticType.ERROR);
	}

	public static Result createWarningResult(String msg, EObject target) {
		return createResult(msg, target, DiagnosticType.WARNING);
	}

	public static Result createInfoResult(String msg, EObject target) {
		return createResult(msg, target, DiagnosticType.INFO);
	}

	public static Result createSuccessResult(String msg, EObject target) {
		return createResult(msg, target, DiagnosticType.SUCCESS);
	}

	public static Result createFailureResult(String msg, EObject target) {
		return createResult(msg, target, DiagnosticType.FAILURE);
	}

	public static Result createResult(String msg, EObject target) {
		return createResult(msg, target, DiagnosticType.NONE);
	}

	public static Result createResult(String msg, EObject target, DiagnosticType type) {
		Result result = ResultFactory.eINSTANCE.createResult();
		result.setSourceReference(target);
		result.setMessage(msg);
		result.setType(type);
		return result;
	}

	public static AnalysisResult createAnalysisResult(String name, EObject target) {
		AnalysisResult result = ResultFactory.eINSTANCE.createAnalysisResult();
		result.setSourceReference(target);
		result.setAnalysis(name);
		return result;
	}

	public static void addIntegerValue(Result contributor, long value) {
		IntegerValue res = ResultFactory.eINSTANCE.createIntegerValue();
		res.setValue(value);
		contributor.getValues().add(res);
	}

	public static void addIntegerValue(Result contributor, long value, String unit) {
		IntegerValue res = ResultFactory.eINSTANCE.createIntegerValue();
		res.setValue(value);
		res.setUnit(unit);
		contributor.getValues().add(res);
	}

	public static void addRealValue(Result contributor, double value) {
		RealValue res = ResultFactory.eINSTANCE.createRealValue();
		res.setValue(value);
		contributor.getValues().add(res);
	}

	public static void addRealValue(Result contributor, double value, String unit) {
		RealValue res = ResultFactory.eINSTANCE.createRealValue();
		res.setValue(value);
		res.setUnit(unit);
		contributor.getValues().add(res);
	}

	public static void addStringValue(Result contributor, String value) {
		StringValue res = ResultFactory.eINSTANCE.createStringValue();
		res.setValue(value);
		contributor.getValues().add(res);
	}

	public static void addBooleanValue(Result contributor, boolean value) {
		BooleanValue res = ResultFactory.eINSTANCE.createBooleanValue();
		res.setValue(value);
		contributor.getValues().add(res);
	}

	public static void addEObjectValue(Result contributor, EObject value) {
		EObjectValue res = ResultFactory.eINSTANCE.createEObjectValue();
		res.setValue(value);
		contributor.getValues().add(res);
	}

	public static void addObjectValue(Result contributor, Object value) {
		ObjectValue res = ResultFactory.eINSTANCE.createObjectValue();
		res.setValue(value);
		contributor.getValues().add(res);
	}

	// get values from the Result object

	public static String getString(Result result, int idx) {
		EList<Value> vals = result.getValues();
		if (idx < vals.size()) {
			Value val = vals.get(idx);
			if (val instanceof StringValue) {
				return ((StringValue) val).getValue();
			}
		}
		return "";
	}

	public static boolean getBoolean(Result result, int idx) {
		EList<Value> vals = result.getValues();
		if (idx < vals.size()) {
			Value val = vals.get(idx);
			if (val instanceof BooleanValue) {
				return ((BooleanValue) val).isValue();
			}
		}
		return true;
	}

	public static long getInteger(Result result, int idx) {
		EList<Value> vals = result.getValues();
		if (idx < vals.size()) {
			Value val = vals.get(idx);
			if (val instanceof IntegerValue) {
				return ((IntegerValue) val).getValue();
			}
		}
		return 0;
	}

	public static double getReal(Result result, int idx) {
		EList<Value> vals = result.getValues();
		if (idx < vals.size()) {
			Value val = vals.get(idx);
			if (val instanceof RealValue) {
				return ((RealValue) val).getValue();
			}
		}
		return 0;
	}

	public static EObject getEObject(Result result, int idx) {
		EList<Value> vals = result.getValues();
		if (idx < vals.size()) {
			Value val = vals.get(idx);
			if (val instanceof EObjectValue) {
				return ((EObjectValue) val).getValue();
			}
		}
		return null;
	}

	public static Object getObject(Result result, int idx) {
		EList<Value> vals = result.getValues();
		if (idx < vals.size()) {
			Value val = vals.get(idx);
			if (val instanceof ObjectValue) {
				return ((ObjectValue) val).getValue();
			}
		}
		return null;
	}

	public static Value getValue(Result result, int idx) {
		EList<Value> vals = result.getValues();
		if (idx < vals.size()) {
			return vals.get(idx);
		}
		return null;
	}

	// -------------------
	// analysis parameters
	// -------------------

	public static void addParameter(AnalysisResult ar, Object value) {
		ObjectValue res = ResultFactory.eINSTANCE.createObjectValue();
		res.setValue(value);
		ar.getParameters().add(res);
	}

	public static Object getParameter(AnalysisResult ar, int idx) {
		EList<ObjectValue> vals = ar.getParameters();
		if (idx < vals.size()) {
			Value val = vals.get(idx);
			if (val instanceof ObjectValue) {
				return ((ObjectValue) val).getValue();
			}
		}
		return null;
	}

	/**
	 * true if there are any diagnostics with FAILURE type or with ERROR type
	 * @param res
	 * @return
	 */
	public static boolean hasFailures(Result res) {
		if (res.getType() == DiagnosticType.FAILURE) {
			return true;
		}
		if (hasFailures(res.getDiagnostics())) {
			return true;
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
		return false;
	}

	public static boolean hasFailures(Collection<? extends Diagnostic> res) {
		for (Diagnostic r : res) {
			if (hasFailures(r)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasErrors(Collection<? extends Diagnostic> res) {
		for (Diagnostic r : res) {
			if (hasErrors(r)) {
				return true;
			}
		}
		return false;
	}


	public static boolean hasErrors(Diagnostic res) {
		if (res.getType() == DiagnosticType.ERROR) {
			return true;
		}
		return false;
	}

	public static boolean hasErrors(Result res) {
		if (res.getType() == DiagnosticType.ERROR) {
			return true;
		}
		if (hasErrors(res.getDiagnostics())) {
			return true;
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

	public static URI getAnalysisResultURI(AnalysisResult results) {
		EObject root = results.getSourceReference();
		URI rootURI = EcoreUtil.getURI(root).trimFragment().trimFileExtension();
		String rootname = rootURI.lastSegment();
		String postfix = "";
		if (results.getInfo() != null) {
			String res = results.getInfo().replaceAll(" ", "");
			if (!res.isEmpty()) {
				postfix = "_" + results.getInfo().replaceAll(" ", "");
			}
		}
		return rootURI.trimFragment().trimSegments(1).appendSegment("reports").appendSegment(results.getAnalysis())
				.appendSegment(rootname + "__" + results.getAnalysis() + postfix + ".result");
	}

}

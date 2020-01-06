/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.result.util;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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
import org.osate.result.ResultType;
import org.osate.result.StringValue;
import org.osate.result.Value;

public class ResultUtil {

	public static Diagnostic createErrorDiagnostic(String msg, EObject target) {
		return createDiagnostic(msg, target, DiagnosticType.ERROR);
	}

	public static Diagnostic createWarningDiagnostic(String msg, EObject target) {
		return createDiagnostic(msg, target, DiagnosticType.WARNING);
	}

	public static Diagnostic createInfoDiagnostic(String msg, EObject target) {
		return createDiagnostic(msg, target, DiagnosticType.INFO);
	}

	public static Diagnostic createDiagnostic(String msg, EObject target, DiagnosticType rit) {
		Diagnostic issue = ResultFactory.eINSTANCE.createDiagnostic();
		issue.setModelElement(target);
		issue.setMessage(msg);
		issue.setDiagnosticType(rit);
		return issue;
	}

	public static Result createSuccessResult(String msg, EObject target) {
		return createResult(msg, target, ResultType.SUCCESS);
	}

	public static Result createFailureResult(String msg, EObject target) {
		return createResult(msg, target, ResultType.FAILURE);
	}

	public static Result createErrorResult(String msg, EObject target) {
		return createResult(msg, target, ResultType.ERROR);
	}

	public static Result createResult(String msg, EObject target) {
		return createResult(msg, target, ResultType.TBD);
	}

	public static Result createResult(String msg, EObject target, ResultType type) {
		Result result = ResultFactory.eINSTANCE.createResult();
		result.setModelElement(target);
		result.setMessage(msg);
		result.setResultType(type);
		return result;
	}

	public static AnalysisResult createAnalysisResult(String name, EObject target) {
		AnalysisResult result = ResultFactory.eINSTANCE.createAnalysisResult();
		result.setModelElement(target);
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
	 * true if there are Diagnostic objects with ERROR type
	 * @param res
	 * @return
	 */
	public static boolean hasDiagnosticErrors(Collection<? extends Diagnostic> diags) {
		for (Diagnostic d : diags) {
			if (isDiagnosticError(d)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * true if there are Result objects with ERROR type
	 * @param res
	 * @return
	 */
	public static boolean hasResultErrors(Collection<? extends Result> results) {
		for (Result d : results) {
			if (isResultError(d)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * true if there are Result objects with FAILURE type
	 * @param res
	 * @return
	 */
	public static boolean hasResultFailures(Collection<? extends Result> results) {
		for (Result d : results) {
			if (isResultFailure(d)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * true if there are Result objects with SUCCESS type
	 * @param res
	 * @return
	 */
	public static boolean hasResultSuccesses(Collection<? extends Result> results) {
		for (Result d : results) {
			if (isResultSuccess(d)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * true if there are Result objects with NONE type
	 * @param res
	 * @return
	 */
	public static boolean hasResultTBDs(Collection<? extends Result> results) {
		for (Result d : results) {
			if (isResultTBD(d)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * true if Diagnostic objects has ERROR type
	 * @param res
	 * @return
	 */
	public static boolean isDiagnosticError(Diagnostic res) {
		return (res.getDiagnosticType() == DiagnosticType.ERROR);
	}

	/**
	 * true if Result object has Diagnostics with ERROR type
	 * @param res
	 * @return
	 */
	public static boolean hasDiagnosticErrors(Result res) {
		return hasDiagnosticErrors(res.getDiagnostics());
	}

	/**
	 * True if any of the sub results have the type ERROR
	 * @param res
	 * @return
	 */
	public static boolean hasResultErrors(Result res) {
		return hasResultErrors(res.getSubResults());
	}

	/**
	 * True if any of the sub results have the type FAILURE
	 * @param res
	 * @return
	 */
	public static boolean hasResultFailures(Result res) {
		return hasResultFailures(res.getSubResults());
	}

	/**
	 * true if Result is of type SUCCESS
	 * @param res
	 * @return
	 */
	public static boolean isResultSuccess(Result res) {
		return res.getResultType() == ResultType.SUCCESS;
	}

	/**
	 * true if Result is of type ERROR
	 * @param res
	 * @return
	 */
	public static boolean isResultError(Result res) {
		return res.getResultType() == ResultType.ERROR;
	}

	/**
	 * true if Result is of type FAILURE
	 * @param res
	 * @return
	 */
	public static boolean isResultFailure(Result res) {
		return res.getResultType() == ResultType.FAILURE;
	}

	/**
	 * true if Result is of type NONE, i.e., has not been set
	 * @param res
	 * @return
	 */
	public static boolean isResultTBD(Result res) {
		return res.getResultType() == ResultType.TBD;
	}

	/**
	 * true if any top-level Result object has ERROR type
	 * @param res
	 * @return
	 */
	public static boolean hasResultErrors(AnalysisResult res) {
		return hasResultErrors(res.getResults());
	}

	/**
	 * true if there are top-level Result objects with FAILURE type
	 * @param res
	 * @return
	 */
	public static boolean hasResultFailures(AnalysisResult res) {
		return hasResultFailures(res.getResults());
	}

	/**
	 * true if there are top-level Result objects with SUCCESS type
	 * @param res
	 * @return
	 */
	public static boolean hasResultSuccesses(AnalysisResult res) {
		return hasResultSuccesses(res.getResults());
	}

	/**
	 * true if there are top-level Result objects with NONE type
	 * @param res
	 * @return
	 */
	public static boolean hasResultTBDs(AnalysisResult res) {
		return hasResultTBDs(res.getResults());
	}

	/**
	 * true if AnalysisResult has Diagnostics with ERROR type
	 * @param res
	 * @return
	 */
	public static boolean hasDiagnosticErrors(AnalysisResult res) {
		return hasDiagnosticErrors(res.getDiagnostics());
	}

	/**
	 * true if AnalysisResult is of type ERROR
	 * @param res
	 * @return
	 */
	public static boolean isAnalysisResultError(AnalysisResult res) {
		return res.getResultType() == ResultType.ERROR;
	}

	/**
	 * set Result type to ERROR and add Daignsotic with specified message and target object
	 * @param result
	 * @param message
	 * @param target
	 */
	public static void setToError(Result result, String message) {
		result.getDiagnostics().add(createErrorDiagnostic(message, result.getModelElement()));
		result.setResultType(ResultType.ERROR);
	}


}

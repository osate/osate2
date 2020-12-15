package org.osate.analysis.resource.budgets.logic;

import org.osate.aadl2.instance.InstanceObject;
import org.osate.result.DiagnosticType;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;

/**
 * @since 4.1
 */
public class GenericAnalysis {
	// ==== Error reporting methods for the visitor ===

	public static void error(final Result result, final InstanceObject io, final String msg) {
		result.getDiagnostics().add(ResultUtil.createDiagnostic(msg, io, DiagnosticType.ERROR));
	}

	public static void warning(final Result result, final InstanceObject io, final String msg) {
		result.getDiagnostics().add(ResultUtil.createDiagnostic(msg, io, DiagnosticType.WARNING));
	}
}
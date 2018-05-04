package org.osate.analysis.resource.management.handlers;

import org.osate.aadl2.util.OsateDebug;

import EAnalysis.BinPacking.AssignmentProblem;
import EAnalysis.BinPacking.BPErrorReporter;

public class BinPackErrorReporter implements BPErrorReporter {

	public void reportError(int errorCode, AssignmentProblem problem) {
		OsateDebug.osateDebug("error" + errorCode);
	}

}

package org.osate.analysis.resource.management.actions;

import EAnalysis.BinPacking.AssignmentProblem;
import EAnalysis.BinPacking.BPErrorReporter;

public class BinPackErrorReporter implements BPErrorReporter {

	@Override
	public void reportError(int errorCode, AssignmentProblem problem) {
		System.out.println("error"+errorCode);

	}

}

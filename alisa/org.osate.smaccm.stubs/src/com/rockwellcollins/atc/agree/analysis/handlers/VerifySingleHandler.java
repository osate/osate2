package com.rockwellcollins.atc.agree.analysis.handlers;

public class VerifySingleHandler {

	protected boolean isRecursive() {
		return false;
	}

	protected String getJobName() {
		return null;
	}

	protected boolean isMonolithic() {
		return false;
	}

	protected boolean isRealizability() {
		return false;
	}

	protected String getNestedMessages(Throwable e) {
		return null;
	}

}

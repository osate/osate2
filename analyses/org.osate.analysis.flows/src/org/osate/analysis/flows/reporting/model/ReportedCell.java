package org.osate.analysis.flows.reporting.model;

import org.osate.result.DiagnosticType;

public class ReportedCell {

	private String msg;
	private DiagnosticType severity;

	public ReportedCell(DiagnosticType sev, String msg) {
		this.msg = msg;
		this.severity = sev;
	}

	public ReportedCell(String msg) {
		this.msg = msg;
		this.severity = DiagnosticType.INFO;
	}

	public String getMessage() {
		return this.msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}

	public DiagnosticType getSeverity() {
		return this.severity;
	}

	public boolean isError() {
		return this.severity.equals(DiagnosticType.ERROR);
	}

	public boolean isWarning() {
		return this.severity.equals(DiagnosticType.WARNING);
	}

	public boolean isSuccess() {
		return this.severity.equals(DiagnosticType.SUCCESS);
	}

	public boolean isInfo() {
		return this.severity.equals(DiagnosticType.INFO);
	}

}

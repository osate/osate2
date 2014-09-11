package org.osate.analysis.flows.reporting.model;

public class ReportedCell {

	private String msg;
	private ReportSeverity severity;

	public ReportedCell(ReportSeverity sev, String msg) {
		this.msg = msg;
		this.severity = sev;
	}

	public ReportedCell(String msg) {
		this.msg = msg;
		this.severity = ReportSeverity.INFO;
	}

	public String getMessage() {
		return this.msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}

	public ReportSeverity getSeverity() {
		return this.severity;
	}

	public boolean isError() {
		return this.severity.equals(ReportSeverity.ERROR);
	}

	public boolean isWarning() {
		return this.severity.equals(ReportSeverity.WARNING);
	}

	public boolean isSuccess() {
		return this.severity.equals(ReportSeverity.SUCCESS);
	}

	public boolean isInfo() {
		return this.severity.equals(ReportSeverity.INFO);
	}

}

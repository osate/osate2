package org.osate.analysis.flows.reporting.model;

import org.osate.result.IssueType;

public class ReportedCell {

	private String msg;
	private IssueType severity;

	public ReportedCell(IssueType sev, String msg) {
		this.msg = msg;
		this.severity = sev;
	}

	public ReportedCell(String msg) {
		this.msg = msg;
		this.severity = IssueType.INFO;
	}

	public String getMessage() {
		return this.msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}

	public IssueType getSeverity() {
		return this.severity;
	}

	public boolean isError() {
		return this.severity.equals(IssueType.ERROR);
	}

	public boolean isWarning() {
		return this.severity.equals(IssueType.WARNING);
	}

	public boolean isSuccess() {
		return this.severity.equals(IssueType.SUCCESS);
	}

	public boolean isInfo() {
		return this.severity.equals(IssueType.INFO);
	}

}

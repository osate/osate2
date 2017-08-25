package org.osate.analysis.flows.reporting.model;

import org.osate.results.ResultIssueType;

public class ReportedCell {

	private String msg;
	private ResultIssueType severity;

	public ReportedCell(ResultIssueType sev, String msg) {
		this.msg = msg;
		this.severity = sev;
	}

	public ReportedCell(String msg) {
		this.msg = msg;
		this.severity = ResultIssueType.INFO;
	}

	public String getMessage() {
		return this.msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}

	public ResultIssueType getSeverity() {
		return this.severity;
	}

	public boolean isError() {
		return this.severity.equals(ResultIssueType.ERROR);
	}

	public boolean isWarning() {
		return this.severity.equals(ResultIssueType.WARNING);
	}

	public boolean isSuccess() {
		return this.severity.equals(ResultIssueType.SUCCESS);
	}

	public boolean isInfo() {
		return this.severity.equals(ResultIssueType.INFO);
	}

}

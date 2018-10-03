package org.osate.analysis.flows.reporting.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.result.Diagnostic;
import org.osate.result.DiagnosticType;

public class Line {
	private List<ReportedCell> content;
	private ReportSeverity type;

	public Line() {
		this.content = new ArrayList<ReportedCell>();
		this.type = ReportSeverity.INFO;
	}

	public void setSeverity(ReportSeverity t) {
		this.type = t;
	}

	public ReportSeverity getSeverity() {
		return this.type;
	}

	public void addContent(String s) {
		this.content.add(new ReportedCell(s));
	}

	public void addInfo(String s) {
		this.content.add(new ReportedCell(DiagnosticType.INFO, s));
	}

	public void addWarning(String s) {
		this.content.add(new ReportedCell(DiagnosticType.WARNING, s));
	}

	public void addError(String s) {
		this.content.add(new ReportedCell(DiagnosticType.ERROR, s));
	}

	public void addHeaderContent(String s) {
		this.content.add(new ReportedCell(DiagnosticType.TBD, s));
	}

	public void addCell(ReportedCell cell) {
		this.content.add(cell);
	}

	public void addCells(List<Diagnostic> cells) {
		for (Diagnostic resultIssue : cells) {
			this.content.add(new ReportedCell(resultIssue.getDiagnosticType(), resultIssue.getMessage()));
		}
	}

	public List<ReportedCell> getContent() {
		return this.content;
	}

}

package org.osate.analysis.flows.reporting.model;

import java.util.ArrayList;
import java.util.List;

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

	public void addError(String s) {
		this.content.add(new ReportedCell(ReportSeverity.ERROR, s));
	}

	public void addSuccess(String s) {
		this.content.add(new ReportedCell(ReportSeverity.SUCCESS, s));
	}

	public void addHeaderContent(String s) {
		this.content.add(new ReportedCell(ReportSeverity.HEADER, s));
	}

	public void addCell(ReportedCell cell) {
		this.content.add(cell);
	}

	public void addCells(List<ReportedCell> cells) {
		this.content.addAll(cells);
	}

	public List<ReportedCell> getContent() {
		return this.content;
	}

}

package org.osate.analysis.flows.reporting.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private List<String> content;
	private ReportSeverity type;

	public Line() {
		this.content = new ArrayList<String>();
		this.type = ReportSeverity.UNKNOWN;
	}

	public void setSeverity(ReportSeverity t) {
		this.type = t;
	}

	public ReportSeverity getSeverity() {
		return this.type;
	}

	public void addContent(String s) {
		this.content.add(s);
	}

	public List<String> getContent() {
		return this.content;
	}

}

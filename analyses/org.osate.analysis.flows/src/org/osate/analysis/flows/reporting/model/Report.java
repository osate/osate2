package org.osate.analysis.flows.reporting.model;

import java.util.List;

public class Report {
	private List<Section> sections;
	private StringBuffer textContent;
	private ReportType type;

	public enum ReportType {
		TABLE, TEXT
	}

	public Report(String name, ReportType rt) {
		this.type = rt;
		this.textContent = new StringBuffer();
	}

	public void addSection(Section s) {
		this.sections.add(s);
	}

	public List<Section> getSections() {
		return this.sections;
	}

	public void setTextContent(String s) {
		this.textContent = new StringBuffer(s);
	}

	public void appendTextContent(String s) {
		this.textContent.append(s);
	}

	public String getTextContent() {
		return this.textContent.toString();
	}

}

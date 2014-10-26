package org.osate.analysis.flows.reporting.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.NamedElement;

/**
 * The Report class represent a generic Report. It
 * can be a text report or a table report.
 * A table report contains several sections
 * with several lines, each one representing
 * a section of the table.
 * A text report contains raw text, such as a text
 * file.
 * 
 * @author julien
 *
 */
public class Report {
	private List<Section> sections;
	private StringBuffer textContent;
	private ReportType type;
	private NamedElement relatedObject;
	private String reportFolder;
	private String reportPostfix;

	public enum ReportType {
		TABLE, TEXT
	}

	public Report(NamedElement ne, String reportFolder, String reportPostfix, ReportType rt) {
		this.type = rt;
		this.relatedObject = ne;
		this.textContent = new StringBuffer();
		this.sections = new ArrayList<Section>();
		this.reportFolder = reportFolder;
		this.reportPostfix = reportPostfix;
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

	public NamedElement getRelatedObject() {
		return this.relatedObject;
	}

	public String getReportFolder() {
		return this.reportFolder;
	}

	public String getReportPostfix() {
		return this.reportPostfix;
	}

}

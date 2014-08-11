package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.analysis.flows.reporting.model.Report;
import org.osate.analysis.flows.reporting.model.Report.ReportType;

public class LatencyReport {
	private List<ReportEntry> entries;
	private String name;

	public LatencyReport() {
		this.entries = new ArrayList<ReportEntry>();
		this.name = "latencyreport";
	}

	public String getName() {
		return this.name;
	}

	public void setName(String n) {
		this.name = n;
	}

	public List<ReportEntry> getEntries() {
		return this.entries;
	}

	public void addEntry(ReportEntry entry) {
		this.entries.add(entry);
	}

	public Report export() {
		Report genericReport;

		genericReport = new Report("latency", ReportType.TABLE);

		for (ReportEntry re : entries) {
			genericReport.addSection(re.export());
		}

		return genericReport;
	}
}

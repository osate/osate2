package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.analysis.flows.reporting.model.Report;
import org.osate.analysis.flows.reporting.model.Report.ReportType;

/**
 * The LatencyReport class represents the generic class
 * produced by the latency analysis. It contains several
 * LatencyReportEntry, each one representing
 * an end to end flow latency.
 * 
 * @author julien
 *
 */
public class LatencyReport {
	private List<LatencyReportEntry> entries;
	private String name;

	public LatencyReport() {
		this.entries = new ArrayList<LatencyReportEntry>();
		this.name = "latencyreport";
	}

	public String getName() {
		return this.name;
	}

	public void setName(String n) {
		this.name = n;
	}

	public List<LatencyReportEntry> getEntries() {
		return this.entries;
	}

	public void addEntry(LatencyReportEntry entry) {
		this.entries.add(entry);
	}

	public Report export() {
		Report genericReport;

		genericReport = new Report("latency", ReportType.TABLE);

		for (LatencyReportEntry re : entries) {
			genericReport.addSection(re.export());
		}

		return genericReport;
	}
}

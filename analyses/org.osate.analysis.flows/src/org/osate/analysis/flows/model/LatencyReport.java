package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.SystemInstance;
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
	private SystemInstance relatedInstance;

	public LatencyReport(SystemInstance si) {
		this.relatedInstance = si;
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

		genericReport = new Report(this.relatedInstance, "latency", ReportType.TABLE);

		for (LatencyReportEntry re : entries) {
			genericReport.addSection(re.export());
			re.generateMarkers();
		}

		return genericReport;
	}
}

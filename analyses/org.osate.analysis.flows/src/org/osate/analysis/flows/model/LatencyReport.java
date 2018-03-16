package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.SystemInstance;
import org.osate.analysis.flows.preferences.Values;
import org.osate.analysis.flows.reporting.model.Report;
import org.osate.analysis.flows.reporting.model.Report.ReportType;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;

/**
 * The LatencyReport class represents the generic class
 * produced by the latency analysis. It contains several
 * LatencyReportEntry, each one representing
 * an end to end flow latency.
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

	public SystemInstance getRootinstance() {
		return this.relatedInstance;
	}

	public List<LatencyReportEntry> getEntries() {
		return this.entries;
	}

	public void addEntry(LatencyReportEntry entry) {
		this.entries.add(entry);
	}

	public String getPreferencesSuffix() {
		return Values.getSynchronousSystemLabel() + "-" + Values.getMajorFrameDelayLabel() + "-"
				+ Values.getWorstCaseDeadlineLabel() + "-" + Values.getBestcaseEmptyQueueLabel();
	}

	public String getPreferencesDescription() {
		return "with preference settings: " + Values.getSynchronousSystemDescription() + "/"
				+ Values.getMajorFrameDelayDescription() + "/" + Values.getWorstCaseDeadlineDescription() + "/"
				+ Values.getBestcaseEmptyQueueDescription();
	}

	public Report export() {
		Report genericReport;

		genericReport = new Report(this.relatedInstance, "latency", "latency_" + getPreferencesSuffix(),
				ReportType.TABLE);
		genericReport.setTextContent("Latency analysis " + getPreferencesDescription());
		for (LatencyReportEntry re : entries) {
			genericReport.addSection(re.export());
		}

		return genericReport;
	}

	public Result genResult() {

		Result latencyReports = ResultUtil.createResult(this.name,
				this.relatedInstance);
		latencyReports.setAnalysis("Latency analysis");
		latencyReports.setInfo(getPreferencesDescription());
		for (LatencyReportEntry re : entries) {
			latencyReports.getSubResults().add(re.genResult());
		}
		return latencyReports;
	}
}

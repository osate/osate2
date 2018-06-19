package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.SystemInstance;
import org.osate.analysis.flows.FlowLatencyUtil;
import org.osate.analysis.flows.reporting.model.Report;
import org.osate.analysis.flows.reporting.model.Report.ReportType;
import org.osate.result.AnalysisResult;
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

	private boolean synchronousSystem = false; // AS default
	private boolean majorFrameDelay = true; // MF default
	private boolean worstCaseDeadline = true; // DL default
	private boolean bestCaseEmptyQueue = true; // EQ default

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

	public void setLatencyAnalysisParameters(boolean asynchronousSystem, boolean majorFrameDelay,
			boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		this.synchronousSystem = !asynchronousSystem; // note switch from async to sync
		this.majorFrameDelay = majorFrameDelay;
		this.worstCaseDeadline = worstCaseDeadline;
		this.bestCaseEmptyQueue = bestCaseEmptyQueue;
	}

	public boolean isSynchronousSystem() {
		return this.synchronousSystem;
	}

	public boolean isMajorFrameDelay() {
		return this.majorFrameDelay;
	}

	public boolean isWorstCaseDeadline() {
		return this.worstCaseDeadline;
	}

	public boolean isBestcaseEmptyQueue() {
		return this.bestCaseEmptyQueue;
	}

	public String getParametersAsDescriptions() {
		return "with preference settings: "
				+ FlowLatencyUtil.getParametersAsDescriptions(FlowLatencyUtil.getParametersAsLabels(this));
	}

	public AnalysisResult genResult() {

		AnalysisResult latencyReports = ResultUtil.createAnalysisResult(this.name,
				this.relatedInstance);
		latencyReports.setAnalysis("Latency analysis");
		latencyReports.setInfo(FlowLatencyUtil.getParametersAsLabels(this));
		latencyReports.setSourceReference(getRootinstance());
		for (LatencyReportEntry re : entries) {
			latencyReports.getResults().add(re.genResult());
		}
		return latencyReports;
	}

	public Report export() {
		Report genericReport;

		genericReport = new Report(this.relatedInstance, "latency",
				"latency_" + FlowLatencyUtil.getParametersAsLabels(this), ReportType.TABLE);
		genericReport.setTextContent("Latency analysis " + getParametersAsDescriptions());
		for (LatencyReportEntry re : entries) {
			genericReport.addSection(re.export());
		}

		return genericReport;
	}

}

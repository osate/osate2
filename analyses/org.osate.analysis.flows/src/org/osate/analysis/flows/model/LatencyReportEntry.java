package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch;
import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.ReportSeverity;
import org.osate.analysis.flows.reporting.model.Section;
import org.osate.xtext.aadl2.properties.util.GetProperties;

/*
 * A report entry corresponds to the entry within the report.
 * It just contains all the contributors for a flow latency.
 * We should have one report entry for each end to end flow
 */

public class LatencyReportEntry {

	List<LatencyContributor> contributors;
	EndToEndFlowInstance relatedEndToEndFlow;

	public LatencyReportEntry() {
		this.contributors = new ArrayList<LatencyContributor>();
	}

	public LatencyReportEntry(EndToEndFlowInstance etef) {
		this();
		this.relatedEndToEndFlow = etef;
	}

	public void addContributor(LatencyContributor lc) {
		this.contributors.add(lc);
	}

	public List<LatencyContributor> getContributors() {
		return this.contributors;
	}

	public double getMinimumLatency() {
		double res = 0.0;
		for (LatencyContributor lc : contributors) {
			res = res + lc.getTotalMinimum();
		}

		return res;
	}

	public double getMaximumLatency() {
		double res = 0.0;
		for (LatencyContributor lc : contributors) {
			res = res + lc.getTotalMaximum();
		}

		return res;
	}

	public Section export() {
		Section section;
		Line line;
		double minValue;
		double maxValue;
		double minSpecifiedValue;
		double maxSpecifiedValue;
		double expectedMaxLatency;
		double expectedMinLatency;
		String sectionName;
		String reportComment;
		String otherComment;

		reportComment = "";

		minValue = 0.0;
		maxValue = 0.0;
		minSpecifiedValue = 0.0;
		maxSpecifiedValue = 0.0;

		expectedMaxLatency = GetProperties.getMaximumLatencyinMilliSec(this.relatedEndToEndFlow);
		expectedMinLatency = GetProperties.getMinimumLatencyinMilliSec(this.relatedEndToEndFlow);

		if (relatedEndToEndFlow != null) {
			sectionName = relatedEndToEndFlow.getName();
		} else {
			sectionName = "unamed flow";
		}

		section = new Section(sectionName);

		line = new Line();
		line.addContent("Contributor");
		line.addContent("Min Specified");
		line.addContent("Min Value");
		line.addContent("Min Method");
		line.addContent("Max Specified");
		line.addContent("Max Value");
		line.addContent("Max Method");
		line.addContent("Comments");
		section.addLine(line);

		for (LatencyContributor lc : this.contributors) {
			for (Line l : lc.export()) {
				section.addLine(l);
			}
			minValue = minValue + lc.getTotalMinimum();
			maxValue = maxValue + lc.getTotalMaximum();
			minSpecifiedValue = minSpecifiedValue + lc.getTotalMinimumSpecified();
			maxSpecifiedValue = maxSpecifiedValue + lc.getTotalMaximumSpecified();
		}

		line = new Line();
		line.addContent("Total");
		line.addContent(minSpecifiedValue + "ms");
		line.addContent(minValue + "ms");
		line.addContent("");
		line.addContent(maxSpecifiedValue + "ms");
		line.addContent(maxValue + "ms");
		line.addContent("");
		section.addLine(line);

		line = new Line();
		reportComment = "";
		line.setSeverity(ReportSeverity.SUCCESS);

		line.addContent("Flow Specification");
		line.addContent("");
		line.addContent(expectedMinLatency + "ms");
		line.addContent("");
		line.addContent("");
		line.addContent(expectedMinLatency + "ms");
		line.addContent("");

		if (expectedMinLatency < minSpecifiedValue) {
			otherComment = "minimum expected latency (" + expectedMinLatency
					+ ") on the end to end flow does not match latency specification (" + minSpecifiedValue + "); ";
			reportComment += otherComment;
			FlowLatencyAnalysisSwitch.getInstance().error(relatedEndToEndFlow, otherComment);
		}

		if (expectedMaxLatency < maxSpecifiedValue) {
			otherComment = "maximum expected latency (" + expectedMaxLatency
					+ ") on the end to end flow does not match latency specification (" + maxSpecifiedValue + "); ";
			reportComment += otherComment;
			FlowLatencyAnalysisSwitch.getInstance().error(relatedEndToEndFlow, otherComment);
		}

		if (expectedMinLatency < minValue) {
			otherComment = "minimum expected latency (" + expectedMinLatency
					+ ") on the end to end flow does not match latency computation (" + minValue + "); ";
			reportComment += otherComment;
			FlowLatencyAnalysisSwitch.getInstance().error(relatedEndToEndFlow, otherComment);

		}

		if (expectedMaxLatency < maxValue) {
			otherComment = "maximum expected latency (" + expectedMaxLatency
					+ ") on the end to end flow does not match latency computation (" + maxValue + "); ";
			reportComment += otherComment;
			FlowLatencyAnalysisSwitch.getInstance().error(relatedEndToEndFlow, otherComment);

		}

		if ((expectedMinLatency > minValue) && (expectedMaxLatency > maxValue)) {
			line.setSeverity(ReportSeverity.SUCCESS);
		}

		if ((minValue == 0) && (maxValue == 0) && (expectedMinLatency > minSpecifiedValue)
				&& (expectedMaxLatency > maxSpecifiedValue)) {
			line.setSeverity(ReportSeverity.SUCCESS);
			FlowLatencyAnalysisSwitch.getInstance().info(relatedEndToEndFlow,
					"End to end latency specification is validated");

		}

		if ((minValue == 0) && (maxValue == 0) && (expectedMinLatency < minSpecifiedValue)
				&& (expectedMaxLatency < maxSpecifiedValue)) {
			otherComment = " specified latency is not correct ; ";
			FlowLatencyAnalysisSwitch.getInstance().info(relatedEndToEndFlow,
					"End to end latency specification is validated by computing latency on sub-components");
			line.setSeverity(ReportSeverity.ERROR);
		}

		if ((minValue == 0) && (maxValue == 0)
				&& ((expectedMinLatency < minSpecifiedValue) || (expectedMaxLatency < maxSpecifiedValue))) {
			line.setSeverity(ReportSeverity.WARNING);
			otherComment = " please check each boundary of the latency specification ; ";
			reportComment += otherComment;
		}

		if ((expectedMinLatency < minValue) && (expectedMaxLatency < maxValue)) {
			line.setSeverity(ReportSeverity.ERROR);
			reportComment += " latency requirements are not met";
		}
		line.addContent(reportComment);
		section.addLine(line);

		return section;
	}
}

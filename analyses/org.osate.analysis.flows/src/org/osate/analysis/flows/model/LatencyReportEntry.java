package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.analysis.flows.actions.CheckFlowLatency;
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
		String otherComment;
		List<String> issues;

		minValue = 0.0;
		maxValue = 0.0;
		minSpecifiedValue = 0.0;
		maxSpecifiedValue = 0.0;

		issues = new ArrayList<String>();

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
					+ "ms) on the end to end flow does not match latency specification (" + minSpecifiedValue + "ms); ";
			issues.add(otherComment);
			CheckFlowLatency.getInstance().error(relatedEndToEndFlow, otherComment);
		}

		if (expectedMaxLatency < maxSpecifiedValue) {
			otherComment = "maximum expected latency (" + expectedMaxLatency
					+ "ms) on the end to end flow does not match latency specification (" + maxSpecifiedValue + "ms); ";
			issues.add(otherComment);
			CheckFlowLatency.getInstance().error(relatedEndToEndFlow, otherComment);
		}

		if (expectedMinLatency < minValue) {
			otherComment = "minimum expected latency (" + expectedMinLatency
					+ "ms) on the end to end flow does not match latency computation (" + minValue + "ms); ";
			issues.add(otherComment);
			CheckFlowLatency.getInstance().error(relatedEndToEndFlow, otherComment);

		}

		if (expectedMaxLatency < maxValue) {
			otherComment = "maximum expected latency (" + expectedMaxLatency
					+ "ms) on the end to end flow does not match latency computation (" + maxValue + "ms); ";
			issues.add(otherComment);
			CheckFlowLatency.getInstance().error(relatedEndToEndFlow, otherComment);

		}

		if ((expectedMinLatency > minValue) && (expectedMaxLatency > maxValue)) {
			line.setSeverity(ReportSeverity.SUCCESS);
		}

		if ((minValue == 0) && (maxValue == 0) && (expectedMinLatency > minSpecifiedValue)
				&& (expectedMaxLatency > maxSpecifiedValue)) {
			line.setSeverity(ReportSeverity.SUCCESS);
			CheckFlowLatency.getInstance().info(relatedEndToEndFlow, "End to end latency specification is validated");

		}

		if ((minValue == 0) && (maxValue == 0) && (expectedMinLatency < minSpecifiedValue)
				&& (expectedMaxLatency < maxSpecifiedValue)) {
			otherComment = " specified latency is not correct ; ";
			CheckFlowLatency.getInstance().info(relatedEndToEndFlow,
					"End to end latency specification is validated by computing latency on sub-components");
			line.setSeverity(ReportSeverity.ERROR);
		}

		if ((minValue == 0) && (maxValue == 0)
				&& ((expectedMinLatency < minSpecifiedValue) || (expectedMaxLatency < maxSpecifiedValue))) {
			line.setSeverity(ReportSeverity.WARNING);
			otherComment = " please check each boundary of the latency specification ; ";

		}

		if ((expectedMinLatency < minValue) && (expectedMaxLatency < maxValue)) {
			line.setSeverity(ReportSeverity.ERROR);
		}
		section.addLine(line);

		if (issues.size() > 0) {
			for (int n = 0; n < issues.size(); n++) {
				line = new Line();
				if (n == 0) {
					line.addContent("Issues");
				} else {
					line.addContent("");
				}
				line.addContent(issues.get(n));
				section.addLine(line);
			}
		} else {
			line = new Line();
			line.addContent("No issue found");
			section.addLine(line);
		}

		return section;
	}
}

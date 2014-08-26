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
	List<String> issues;

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

	private void reportError(String str) {
		if (issues != null) {
			issues.add(str);
		}
		CheckFlowLatency.getInstance().error(relatedEndToEndFlow, str);
	}

	private void reportInfo(String str) {
		if (issues != null) {
			issues.add(str);
		}
		CheckFlowLatency.getInstance().info(relatedEndToEndFlow, str);
	}

	private void reportWarning(String str) {
		if (issues != null) {
			issues.add(str);
		}
		CheckFlowLatency.getInstance().warning(relatedEndToEndFlow, str);
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

		minValue = 0.0;
		maxValue = 0.0;
		minSpecifiedValue = 0.0;
		maxSpecifiedValue = 0.0;

		issues = new ArrayList<String>();

		expectedMaxLatency = GetProperties.getMaximumLatencyinMilliSec(this.relatedEndToEndFlow);
		expectedMinLatency = GetProperties.getMinimumLatencyinMilliSec(this.relatedEndToEndFlow);

		if (relatedEndToEndFlow != null) {
			sectionName = relatedEndToEndFlow.getFullName();
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

		line.addContent("End to End Flow");
		line.addContent("");
		line.addContent(expectedMinLatency + "ms");
		line.addContent("");
		line.addContent("");
		line.addContent(expectedMinLatency + "ms");
		line.addContent("");

		/*
		 * In that case, the end to end flow has a minimum latency
		 */
		if (expectedMinLatency > 0) {
			if (expectedMinLatency < minSpecifiedValue) {
				reportError("sum of specified minimum latencies (" + minSpecifiedValue
						+ " ms) does not match latency specifications (" + expectedMinLatency + "ms)");
				line.setSeverity(ReportSeverity.ERROR);

			}

			if (expectedMinLatency < minValue) {
				reportError("sum of minimum latencies (" + minSpecifiedValue
						+ " ms) does not match latency specifications (" + expectedMinLatency + "ms)");
				line.setSeverity(ReportSeverity.ERROR);

			}
		} else {
			reportWarning("the minimal latency is not specified");
			line.setSeverity(ReportSeverity.WARNING);
		}

		/**
		 * Here, the max latency value has been defined
		 */
		if (expectedMaxLatency > 0) {
			if (expectedMaxLatency < maxSpecifiedValue) {
				reportError("maximum expected latency (" + expectedMaxLatency
						+ "ms) on the end to end flow does not match latency specification (" + maxSpecifiedValue
						+ "ms); ");
				line.setSeverity(ReportSeverity.ERROR);
			}

			if (expectedMaxLatency < maxValue) {
				reportError("sun of maximum latencies (" + maxValue + "ms) does not match latency specification ("
						+ expectedMaxLatency + "ms)");
				line.setSeverity(ReportSeverity.ERROR);
			}
		} else {
			reportWarning("the maximal latency is not specified");
			line.setSeverity(ReportSeverity.WARNING);
		}

		/**
		 * If the expected latency is defined and consistent with the max value, everything should be ok
		 * It means that the number calculated from the component is correct and less important
		 * with the latency specifications
		 *
		 */
		if ((minValue > 0) && (maxValue > 0) && (expectedMaxLatency > 0) && (expectedMinLatency > 0)
				&& (expectedMinLatency > minValue) && (expectedMaxLatency > maxValue)) {
			line.setSeverity(ReportSeverity.SUCCESS);
			reportInfo("end-to-end flow latency for " + this.relatedEndToEndFlow.getName()
					+ " calculated from the components is correct with the expected latency specifications");
		}

		if ((expectedMinLatency < minValue) && (expectedMaxLatency < maxValue)) {
			line.setSeverity(ReportSeverity.ERROR);
		}
		section.addLine(line);

		if (issues.size() > 0) {
			for (int n = 0; n < issues.size(); n++) {
				line = new Line();
				if (n == 0) {
					line.addContent("Informations");
				} else {
					line.addContent("");
				}
				line.addContent(issues.get(n));
				section.addLine(line);
			}
		} else {
			line = new Line();
			line.addContent("Nothing to report");
			section.addLine(line);
		}

		return section;
	}
}

package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.EndToEndFlowInstance;
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
			res = res + lc.getMinimum();
		}

		return res;
	}

	public double getMaximumLatency() {
		double res = 0.0;
		for (LatencyContributor lc : contributors) {
			res = res + lc.getMaximum();
		}

		return res;
	}

	public Section export() {
		Section section;
		Line line;
		double minValue;
		double maxValue;
		double expectedMaxLatency;
		double expectedMinLatency;
		String sectionName;
		String reportComment;

		reportComment = "";

		minValue = 0.0;
		maxValue = 0.0;

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
		line.addContent("Min Expected");
		line.addContent("Min Value");
		line.addContent("Min Method");
		line.addContent("Max Expected");
		line.addContent("Max Value");
		line.addContent("Max Method");
		line.addContent("Comments");
		section.addLine(line);

		for (LatencyContributor lc : this.contributors) {
			for (Line l : lc.export()) {
				section.addLine(l);
			}
			minValue = minValue + lc.getMinimum();
			maxValue = maxValue + lc.getMaximum();
		}

		line = new Line();
		line.addContent("Total");

		line.setSeverity(ReportSeverity.WARNING);

		if ((expectedMinLatency > minValue) && (expectedMaxLatency > maxValue)) {
			line.setSeverity(ReportSeverity.SUCCESS);
		}

		if ((expectedMinLatency < minValue) && (expectedMaxLatency < maxValue)) {
			line.setSeverity(ReportSeverity.ERROR);
			reportComment += " latency requirements are not met";
		}

		if (expectedMinLatency == 0.0) {
			line.addContent("unspecified");
			reportComment += " minimum latency requirements not specified";
		} else {
			line.addContent(expectedMinLatency + "ms");
		}

		line.addContent(minValue + "ms");
		line.addContent("");
		if (expectedMaxLatency == 0.0) {
			line.addContent("unspecified");
			reportComment += " maximum latency requirements not specified";
		} else {
			line.addContent(expectedMaxLatency + "ms");
		}

		line.addContent(maxValue + "ms");
		line.addContent("");
		section.addLine(line);

		return section;
	}
}

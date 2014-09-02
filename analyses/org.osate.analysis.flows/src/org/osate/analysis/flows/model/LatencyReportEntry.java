package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.analysis.flows.FlowLatencyUtil;
import org.osate.analysis.flows.actions.CheckFlowLatency;
import org.osate.analysis.flows.model.LatencyContributor.LatencyContributorMethod;
import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.ReportSeverity;
import org.osate.analysis.flows.reporting.model.ReportedCell;
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
	List<ReportedCell> issues;
	boolean doSynchronous = false;
	LatencyContributor lastSampled = null;

	public LatencyReportEntry() {
		this.contributors = new ArrayList<LatencyContributor>();
	}

	public LatencyReportEntry(EndToEndFlowInstance etef) {
		this();
		this.relatedEndToEndFlow = etef;
	}

	public void resetSynchronous() {
		doSynchronous = true;
		lastSampled = null;
	}

	public void resetAsynchronous() {
		doSynchronous = false;
		lastSampled = null;
	}

	public boolean doSynchronous() {
		return doSynchronous;
	}

	public void addContributor(LatencyContributor lc) {
		this.contributors.add(lc);
		if (lc.getWorstcaseLatencyContributorMethod().equals(LatencyContributorMethod.SAMPLED)
				|| lc.getWorstcaseLatencyContributorMethod().equals(LatencyContributorMethod.DELAYED)) {
			lastSampled = lc;
		}
	}

	public void setLastSampled(LatencyContributor lc) {
		lastSampled = lc;
	}

	public boolean wasSampled() {
		return lastSampled != null;
	}

	public double getMinimumCumLatency(LatencyContributor current) {
		double result = 0;
		if (lastSampled == null) {
			return 0;
		}
		int idx = this.contributors.indexOf(lastSampled);
		if (idx < 0)
			return 0;
		for (int i = idx + 1; i < this.contributors.size(); i++) {
			LatencyContributor lc = this.contributors.get(i);
			if (!(lc.getWorstcaseLatencyContributorMethod().equals(LatencyContributorMethod.SAMPLED) || lc
					.getWorstcaseLatencyContributorMethod().equals(LatencyContributorMethod.DELAYED))) {
				result = result + lc.getTotalMinimum();
			}
			if (lc == current) {
				break;
			}
		}
		return result;
	}

	public double getMaximumCumLatency(LatencyContributor current) {
		double result = 0;
		if (lastSampled == null) {
			return 0;
		}
		int idx = this.contributors.indexOf(lastSampled);
		if (idx < 0)
			return 0;
		for (int i = idx; i < this.contributors.size(); i++) {
			LatencyContributor lc = this.contributors.get(i);
			if (!(lc.getWorstcaseLatencyContributorMethod().equals(LatencyContributorMethod.SAMPLED) || lc
					.getWorstcaseLatencyContributorMethod().equals(LatencyContributorMethod.DELAYED))) {
				result = result + lc.getTotalMaximum();
			}
			if (lc == current) {
				break;
			}
		}
		return result;
	}

	public List<LatencyContributor> getContributors() {
		return this.contributors;
	}

	public double getMinimumActualLatency() {
		double res = 0.0;
		for (LatencyContributor lc : contributors) {
			if (lc.getBestcaseLatencyContributorMethod().equals(LatencyContributorMethod.FIRST_SAMPLED)) {
				// skip the first sampled if it is the first element in the contributor list
				// and remember initial sample
				// XXX: if we sample external events by sensor this might have to be added as sampling latency
				lastSampled = lc;
			} else if (lc.getBestcaseLatencyContributorMethod().equals(LatencyContributorMethod.SAMPLED)) {
				// lets deal with the sampling case
				if (doSynchronous() && wasSampled()) {
					// there was a previous sampling component. We can to the roundup game.
					double diff = FlowLatencyUtil.roundUpDiff(getMinimumCumLatency(lc), lc.getSamplingPeriod());
					res = res + diff;
					lc.setComments("Added " + diff + "ms");
				} else {
					res = res + lc.getSamplingPeriod();
				}
				lastSampled = lc;
			} else if (lc.getBestcaseLatencyContributorMethod().equals(LatencyContributorMethod.DELAYED)) {
				if (doSynchronous() && wasSampled()) {
					// there was a previous sampling component. We can to the roundup game.
//					double framediff = FlowLatencyUtil.roundUp(cummax, period) - FlowLatencyUtil.roundUp(cummin, period);
//					latencyContributor.setMinimum(FlowLatencyUtil.roundUpDiff(cummin, period) + framediff);
//					latencyContributor
//							.setComments("Recipient period difference as sampling latency. Min frames aligned with max frames.");
					double cumMin = getMinimumCumLatency(lc);
					double framediff = FlowLatencyUtil.roundUp(getMaximumCumLatency(lc), lc.getSamplingPeriod())
							- FlowLatencyUtil.roundUp(cumMin, lc.getSamplingPeriod());
					double diff = FlowLatencyUtil.roundUpDiff(cumMin, lc.getSamplingPeriod()) + framediff;
					res = res + diff;
					lc.setComments("Added " + diff + "ms");
					if (framediff > 0) {
						lc.reportWarning("Aligned min latency with max by adding " + diff + "ms");
					}
				} else {
					res = res + lc.getSamplingPeriod();
				}
				lastSampled = lc;
			} else if (lc.getBestcaseLatencyContributorMethod().equals(LatencyContributorMethod.IMMEDIATE)) {
				// no sampling. We are part of an immediate connection sequence
			} else if (lc.getBestcaseLatencyContributorMethod().equals(LatencyContributorMethod.LAST_IMMEDIATE)) {
				// No sampling. we are the last of an immediate connection sequence.
				// XXX: However, the cumulative values should not exceed the deadline of the last.

			} else {
				res = res + lc.getTotalMinimum();
			}
		}

		return res;
	}

	// TODO for downsampling we can distinguish between most recent data sample (sender Period) and event (Receiver period)

	public double getMaximumActualLatency() {
		double res = 0.0;
		for (LatencyContributor lc : contributors) {
			if (lc.getWorstcaseLatencyContributorMethod().equals(LatencyContributorMethod.FIRST_SAMPLED)) {
				// skip the first sampled if it is the first element in the contributor list
				// and remember initial sample
				// XXX: if we sample external events by sensor this might have to be added as sampling latency
				lastSampled = lc;
			} else if (lc.getWorstcaseLatencyContributorMethod().equals(LatencyContributorMethod.SAMPLED)) {
				// lets deal with the sampling case
				if ((doSynchronous() || lc.isSynchronous()) && wasSampled()) {
					// there was a previous sampling component. We can to the roundup game.
					double diff = FlowLatencyUtil.roundUpDiff(getMaximumCumLatency(lc), lc.getSamplingPeriod());
					res = res + diff;
					lc.setComments("Added " + diff + "ms");
				} else {
					res = res + lc.getSamplingPeriod();
				}
				lastSampled = lc;
			} else if (lc.getWorstcaseLatencyContributorMethod().equals(LatencyContributorMethod.DELAYED)) {
				if (doSynchronous() && wasSampled()) {
					// there was a previous sampling component. We can to the roundup game.
					double diff = FlowLatencyUtil.roundUpDiff(getMaximumCumLatency(lc), lc.getSamplingPeriod());
					res = res + diff;
					lc.setComments("Added " + diff + "ms");
				} else {
					res = res + lc.getSamplingPeriod();
				}
				lastSampled = lc;
			} else if (lc.getWorstcaseLatencyContributorMethod().equals(LatencyContributorMethod.IMMEDIATE)) {
				// no sampling. We are part of an immediate connection sequence
			} else if (lc.getWorstcaseLatencyContributorMethod().equals(LatencyContributorMethod.LAST_IMMEDIATE)) {
				// No sampling. we are the last of an immediate connection sequence.
				if (lc.getDeadline() > 0.0 && getMaximumCumLatency(lc) > lc.getDeadline()) {
					lc.reportError("Max immediate latency sequence exceeds deadline " + lc.getDeadline() + "ms");
				}
			} else {
				res = res + lc.getTotalMaximum();
			}
		}

		return res;
	}

	public double getMaximumSpecifiedLatency() {
		double res = 0.0;
		for (LatencyContributor lc : contributors) {
			res = res + lc.getTotalMaximumSpecified();
		}

		return res;
	}

	public double getMinimumSpecifiedLatency() {
		double res = 0.0;
		for (LatencyContributor lc : contributors) {
			res = res + lc.getTotalMinimumSpecified();
		}

		return res;
	}

	private void reportSummaryError(String str) {
		issues.add(new ReportedCell(ReportSeverity.ERROR, str));
		CheckFlowLatency.getInstance().error(relatedEndToEndFlow, str);
	}

	private void reportSummaryInfo(String str) {
		issues.add(new ReportedCell(ReportSeverity.SUCCESS, str));
		CheckFlowLatency.getInstance().info(relatedEndToEndFlow, str);
	}

	private void reportSummaryWarning(String str) {
		issues.add(new ReportedCell(ReportSeverity.WARNING, str));
		CheckFlowLatency.getInstance().warning(relatedEndToEndFlow, str);
	}

	private String getSyncLabel() {
		if (doSynchronous) {
			return " (Sync)";
		} else {
			return " (Async)";
		}
	}

	// skip the contributor as sampled contributor because it just marks an incoming immediate
	private boolean skipMeInReport(LatencyContributor lc) {
		return lc.getWorstcaseLatencyContributorMethod().equals(LatencyContributorMethod.IMMEDIATE)
				|| lc.getWorstcaseLatencyContributorMethod().equals(LatencyContributorMethod.LAST_IMMEDIATE);
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

		minValue = 0.0;
		maxValue = 0.0;
		minSpecifiedValue = 0.0;
		maxSpecifiedValue = 0.0;

		issues = new ArrayList<ReportedCell>();

		expectedMaxLatency = GetProperties.getMaximumLatencyinMilliSec(this.relatedEndToEndFlow);
		expectedMinLatency = GetProperties.getMinimumLatencyinMilliSec(this.relatedEndToEndFlow);

		if (relatedEndToEndFlow != null) {
			sectionName = relatedEndToEndFlow.getComponentInstancePath();
		} else {
			sectionName = "Unnamed flow";
		}

		section = new Section(sectionName + getSyncLabel());

		line = new Line();
		line.addHeaderContent("Contributor");
		line.addHeaderContent("Min Specified");
		line.addHeaderContent("Min Value");
		line.addHeaderContent("Min Method");
		line.addHeaderContent("Max Specified");
		line.addHeaderContent("Max Value");
		line.addHeaderContent("Max Method");
		line.addHeaderContent("Comments");
		line.addHeaderContent("Issues");
		section.addLine(line);

		// will populate the comments section
		minValue = getMinimumActualLatency();
		maxValue = getMaximumActualLatency();
		minSpecifiedValue = getMinimumSpecifiedLatency();
		maxSpecifiedValue = getMaximumSpecifiedLatency();

		// reporting each entry
		for (LatencyContributor lc : this.contributors) {
			if (!skipMeInReport(lc)) {
				for (Line l : lc.export()) {
					section.addLine(l);
				}
			}
		}

		line = new Line();
		line.addContent("Latency Total");
		line.addContent(minSpecifiedValue + "ms");
		line.addContent(minValue + "ms");
		line.addContent("");
		line.addContent(maxSpecifiedValue + "ms");
		line.addContent(maxValue + "ms");
		line.addContent("");
		section.addLine(line);

		line = new Line();
		line.setSeverity(ReportSeverity.SUCCESS);

		line.addContent("End to End Latency");
		line.addContent("");
		line.addContent(expectedMinLatency + "ms");
		line.addContent("");
		line.addContent("");
		line.addContent(expectedMaxLatency + "ms");
		line.addContent("");

		/*
		 * In that case, the end to end flow has a minimum latency
		 */
		if (expectedMinLatency > 0) {
			if (expectedMinLatency > minSpecifiedValue) {
				reportSummaryWarning("Sum of minimum specified latencies (" + minSpecifiedValue
						+ " ms) is less than minimum end to end latency (" + expectedMinLatency + "ms)");
			}

			if (expectedMinLatency > minValue) {
				reportSummaryError("Sum of minimum actual latencies (" + minValue
						+ " ms) is less than minimum end to end latency (" + expectedMinLatency + "ms)");
			}
		} else {
			reportSummaryWarning("Minimum end to end latency is not pecified or zero");
		}

		/**
		 * Here, the max latency value has been defined
		 */
		if (expectedMaxLatency > 0) {
			if (expectedMaxLatency < maxSpecifiedValue) {
				reportSummaryError("Sum of maximum specified latency (" + maxSpecifiedValue
						+ "ms) exceeds end to end latency (" + expectedMaxLatency + "ms)");
			}

			if (expectedMaxLatency < maxValue) {
				reportSummaryError("Sum of maximum actual latencies (" + maxValue + "ms) exceeds end to end latency ("
						+ expectedMaxLatency + "ms)");
			}
		} else {
			reportSummaryWarning("End to end latency is not specified");
		}

		/**
		 * If the expected latency is defined and consistent with the max value, everything should be ok
		 * It means that the number calculated from the component is correct and less important
		 * with the latency specifications
		 *
		 */
		if ((minValue > 0) && (maxValue > 0) && (expectedMaxLatency > 0) && (expectedMinLatency > 0)
				&& (expectedMinLatency > minValue) && (expectedMaxLatency > maxValue)) {
			reportSummaryInfo("end-to-end flow latency for " + this.relatedEndToEndFlow.getName()
					+ " calculated from the components is correct with the expected latency specifications");
		}

		if ((expectedMinLatency < minValue) && (expectedMaxLatency < maxValue)) {
			// XXX a message?
			line.setSeverity(ReportSeverity.ERROR);
		}
		section.addLine(line);

		if (issues.size() > 0) {
			line = new Line();
			line.addHeaderContent("End to end Latency Summary");
			section.addLine(line);
			for (ReportedCell issue : issues) {
				line = new Line();
				String msg = issue.getMessage();
				issue.setMessage(issue.getSeverity().toString());
				line.addCell(issue);
				line.addContent(msg);
				section.addLine(line);
			}
		}

		return section;
	}
}

package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.NamedElement;
import org.osate.analysis.flows.actions.CheckFlowLatency;
import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.ReportSeverity;

/**
 * A latency Contributor represents something in the flow
 * that can contribute to increase/decrease the latency.
 * 
 * This class contains the result for a latency contributor
 * with min/max latency.
 * 
 * @author julien
 *
 */
public abstract class LatencyContributor {
	// UNKNOWN: method not set (default)
	// Deadline: worst-case (assumes schedulability)
	// Period: sampling latency of devices, threads, process, system, abstract (AADL by default equates Deadline to be
// the Period).
	// WCET: maximum processing (compute execution) time
	// BCET: minimum processing (compute execution) time
	// WCXT: maximum communication (transfer time) time
	// BCXT: minimum communication (transfer time) time
	// Immediate: immediate connection enforces mid-frame communication, i.e., cumulative latency of processing elements
// (similar to message driven processing)
	// Delayed: enforces frame-delayed communication
	// Sampled: sampling latency by periodic recipient or transfer mechanism
	// Specified: latency specified with flow specification
	// Queued: latency contribution due to queuing on bus or on recipient queuing ports
	// Transmission time: actual transmission latency
	// Partition frame: Major frame rate of partition
	// Partition schedule: frame offset?

	public enum LatencyContributorMethod {
		UNKNOWN, DEADLINE, PERIOD, PROCESSING_TIME, IMMEDIATE, DELAYED, SAMPLED, SPECIFIED, QUEUED, TRANSMISSION_TIME, PARTITION_FRAME, PARTITION_SCHEDULE
	};

	/**
	 * The relatedElement represents the AADL element that
	 * is related to this latency contributor. Mostly, it is
	 * a component or a connection.
	 */
	protected NamedElement relatedElement;

	/**
	 * This represents the max and min value of the latency
	 * for this contributor.
	 */
	private double minValue;
	private double maxValue;

	/**
	 * The expected minimum and maximum latency values.
	 */
	private double expectedMin;
	private double expectedMax;

	/**
	 * Some comments we would like to add in the report.
	 */
	private String comments;

	/**
	 * methods represent what is the model elements used
	 * to compute the min or max value
	 */
	private LatencyContributorMethod worstCaseMethod;
	private LatencyContributorMethod bestCaseMethod;

	/**
	 * The sub contributors are basically what are the other
	 * elements that can incur a latency in addition to the
	 * related element. A good example is a bus for a 
	 * connection. The connection is the latency contributor
	 * and the bus is a sub-contributor (it adds potentially
	 * some latency).
	 */
	private List<LatencyContributor> subContributors;

	public LatencyContributor() {
		this.worstCaseMethod = LatencyContributorMethod.UNKNOWN;
		this.bestCaseMethod = LatencyContributorMethod.UNKNOWN;
		this.minValue = 0.0;
		this.maxValue = 0.0;
		this.expectedMax = 0.0;
		this.expectedMin = 0.0;
		this.subContributors = new ArrayList<LatencyContributor>();
		this.comments = "";
	}

	public String getComments() {
		return this.comments;
	}

	public void addComment(String c) {
		this.comments = this.comments + " - " + c;
	}

	public void setComments(String c) {
		this.comments = c;
	}

	public void setExpectedMaximum(double d) {
		this.expectedMax = d;
	}

	public void setExpectedMinimum(double d) {
		this.expectedMin = d;
	}

	public static String mapMethodToString(LatencyContributorMethod method) {
		switch (method) {
		case DEADLINE:
			return "deadline";
		case PROCESSING_TIME:
			return "processing time";
		case PERIOD:
			return "period";
		case DELAYED:
			return "delayed connection";
		case IMMEDIATE:
			return "immediate connection";
		case SPECIFIED:
			return "specified";
		case SAMPLED:
			return "sampling";
		case QUEUED:
			return "queued";
		case PARTITION_FRAME:
			return "partition major frame";
		case PARTITION_SCHEDULE:
			return "partition schedule";
		case TRANSMISSION_TIME:
			return "transmission time";
		}
		return "no latency";
	}

	public void setWorstCaseMethod(LatencyContributorMethod m) {
		this.worstCaseMethod = m;
	}

	public void setBestCaseMethod(LatencyContributorMethod m) {
		this.bestCaseMethod = m;
	}

	public List<LatencyContributor> getSubContributors() {
		return this.subContributors;
	}

	public void addSubContributor(LatencyContributor lc) {
		this.subContributors.add(lc);
	}

	public void setMinimum(double d) {
		this.minValue = d;
	}

	public void setMaximum(double d) {
		this.maxValue = d;
	}

	public double getLocalMinimum() {
		return this.minValue;
	}

	public double getLocalMaximum() {
		return this.maxValue;
	}

	public double getTotalMinimum() {
		double res = this.minValue;
		for (LatencyContributor lc : subContributors) {
			res = lc.getTotalMinimum();
		}

		return res;
	}

	public double getTotalMaximum() {
		double res = this.maxValue;
		for (LatencyContributor lc : subContributors) {
			res = lc.getTotalMaximum();
		}

		return res;
	}

	public double getTotalMinimumSpecified() {
		double res = this.expectedMin;
		for (LatencyContributor lc : subContributors) {
			res = lc.getTotalMinimumSpecified();
		}

		return res;
	}

	public double getTotalMaximumSpecified() {
		double res = this.expectedMax;
		for (LatencyContributor lc : subContributors) {
			res = lc.getTotalMaximumSpecified();
		}

		return res;
	}

	protected abstract String getContributorName();

	protected abstract String getContributorType();

	public List<Line> export() {
		List<Line> lines;
		Line myLine;

		lines = new ArrayList<Line>();

		myLine = new Line();
		myLine.setSeverity(ReportSeverity.UNKNOWN);

		myLine.addContent(this.getContributorType() + " " + this.getContributorName());
		if (this.expectedMin != 0.0) {
			myLine.addContent(this.expectedMin + "ms");
		} else {
			myLine.addContent(""); // the min expected value
		}
		myLine.addContent(this.getLocalMinimum() + "ms");
		myLine.addContent(mapMethodToString(bestCaseMethod));
		if (this.expectedMax != 0.0) {
			myLine.addContent(this.expectedMax + "ms");
		} else {
			myLine.addContent(""); // the min expected value
		}
		myLine.addContent(this.getLocalMaximum() + "ms");
		myLine.addContent(mapMethodToString(worstCaseMethod));

		if ((this.expectedMax != 0.0) && (this.maxValue > this.expectedMax)) {
			CheckFlowLatency.getInstance().warning(this.relatedElement,
					"max latency calculation exceed latency specified");
			myLine.setSeverity(ReportSeverity.WARNING);
		}

		if ((this.expectedMin != 0.0) && (this.minValue > this.expectedMin)) {

			CheckFlowLatency.getInstance().warning(this.relatedElement,
					"min latency calculation exceed latency specified");
			myLine.setSeverity(ReportSeverity.WARNING);
		}

		myLine.addContent(this.getComments());

		lines.add(myLine);

		/**
		 * We also add the lines of all the sub-contributors.
		 */
		for (LatencyContributor lc : this.subContributors) {
			lines.addAll(lc.export());
		}
		return lines;
	}
}

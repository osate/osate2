package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.NamedElement;
import org.osate.analysis.flows.actions.CheckFlowLatency;
import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.ReportSeverity;
import org.osate.analysis.flows.reporting.model.ReportedCell;

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
	// used for processing/communication latency
	// UNKNOWN: method not set (default)
	// Processing_Time: processing (compute execution) time
	// Deadline: worst-case (assumes schedulability) if no processing time
	// Transmission time: actual transmission latency
	// Specified: latency specified with flow specification if no processing/transmission time

	// Sampling latency contributions when recipient operates periodically
	// Sampled: sampling latency of period by periodic recipient or transfer mechanism
	// Delayed: frame-delay latency due to incoming delayed connection
	// Immediate: incoming immediate connection and outgoing immediate connection (acts like an aperiodic event/msg
// driven task).
	// Last_Immediate: last of incoming immediate connection: Its deadline determines the deadline of the sequence.
	// Queued: latency contribution due to queuing on bus or on recipient queuing ports
	// Partition frame: Major frame rate of partition
	// Partition schedule: frame offset

	public enum LatencyContributorMethod {
		UNKNOWN, DEADLINE, PROCESSING_TIME, IMMEDIATE, LAST_IMMEDIATE, DELAYED, SAMPLED, FIRST_SAMPLED, SPECIFIED, QUEUED, TRANSMISSION_TIME, PARTITION_FRAME, PARTITION_SCHEDULE
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
	 * Hold on to deadline for LAST_IMMEDIATE
	 */
	private double deadline;

	/**
	 * Sampling offset for partition frame
	 */
	private double samplingOffset;

	/**
	 * Sampling period for SAMPLED, DELAYED, or partition related
	 */
	private double samplingPeriod;

	List<ReportedCell> issues;

	/**
	 * Sampling of incoming communication is synchronous
	 * Set if model indicates so. The doSynchronous value is examined if this is not set.
	 */
	public enum SynchronizeType {
		Asynchronous, Synchronous, Unknown
	};

	private SynchronizeType isSynchronized = SynchronizeType.Unknown;

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

	private double maxSubtotal;
	private double minSubtotal;

	public LatencyContributor() {
		this.worstCaseMethod = LatencyContributorMethod.UNKNOWN;
		this.bestCaseMethod = LatencyContributorMethod.UNKNOWN;
		this.isSynchronized = SynchronizeType.Unknown;
		this.minValue = 0.0;
		this.maxValue = 0.0;
		this.expectedMax = 0.0;
		this.expectedMin = 0.0;
		this.deadline = 0.0;
		this.samplingPeriod = 0.0;
		this.samplingOffset = 0.0;
		this.subContributors = new ArrayList<LatencyContributor>();
		this.issues = new ArrayList<ReportedCell>();
		this.maxSubtotal = 0.0;
		this.minSubtotal = 0.0;
	}

	protected List<ReportedCell> getReportedIssues() {
		return this.issues;
	}

	public void reportError(String str) {
		CheckFlowLatency.getInstance().error(this.relatedElement, str);
		issues.add(new ReportedCell(ReportSeverity.ERROR, str));
	}

	public void reportSuccess(String str) {
		CheckFlowLatency.getInstance().info(this.relatedElement, str);
		issues.add(new ReportedCell(ReportSeverity.SUCCESS, str));
	}

	public void reportInfo(String str) {
		CheckFlowLatency.getInstance().info(this.relatedElement, str);
		issues.add(new ReportedCell(ReportSeverity.UNKNOWN, str));
	}

	public void reportWarning(String str) {
		CheckFlowLatency.getInstance().warning(this.relatedElement, str);
		issues.add(new ReportedCell(ReportSeverity.WARNING, str));
	}

	protected String getContributorName() {
		return relatedElement.getName();
	}

	protected NamedElement getContributor() {
		return relatedElement;
	}

	protected String getFullContributorName() {
		return relatedElement.getFullName();
	}

	protected abstract String getContributorType();

	public void setSynchronous() {
		this.isSynchronized = SynchronizeType.Synchronous;
	}

	public void setAsynchronous() {
		this.isSynchronized = SynchronizeType.Asynchronous;
	}

	public boolean isSynchronous() {
		return this.isSynchronized.equals(SynchronizeType.Synchronous);
	}

	public boolean isAsynchronous() {
		return this.isSynchronized.equals(SynchronizeType.Asynchronous);
	}

	public boolean isUnknown() {
		return this.isSynchronized.equals(SynchronizeType.Unknown);
	}

	public double getSamplingPeriod() {
		return this.samplingPeriod;
	}

	public void setSamplingPeriod(double val) {
		this.samplingPeriod = val;
	}

	public double getSamplingOffset() {
		return this.samplingOffset;
	}

	public void setSamplingOffset(double val) {
		this.samplingOffset = val;
	}

	public double getMaxSubtotal() {
		return this.maxSubtotal;
	}

	public void setMaxSubtotal(double val) {
		this.maxSubtotal = val;
	}

	public double getMinSubtotal() {
		return this.minSubtotal;
	}

	public void setMinSubtotal(double val) {
		this.minSubtotal = val;
	}

	public double getDeadline() {
		return this.deadline;
	}

	public void setDeadline(double val) {
		this.deadline = val;
	}

	public void setExpectedMaximum(double d) {
		this.expectedMax = d;
	}

	public void setExpectedMinimum(double d) {
		this.expectedMin = d;
	}

	public LatencyContributorMethod getWorstcaseLatencyContributorMethod() {
		return this.worstCaseMethod;
	}

	public LatencyContributorMethod getBestcaseLatencyContributorMethod() {
		return this.bestCaseMethod;
	}

	public static String mapMethodToString(LatencyContributorMethod method) {
		switch (method) {
		case DEADLINE:
			return "deadline";
		case PROCESSING_TIME:
			return "processing time";
		case DELAYED:
			return "delayed sampling";
		case IMMEDIATE:
			return "incoming immediate connection";
		case LAST_IMMEDIATE:
			return "last immediate connection";
		case SPECIFIED:
			return "specified";
		case SAMPLED:
			return "sampling";
		case FIRST_SAMPLED:
			return "first sampling";
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

	public boolean isPartition() {
		return worstCaseMethod.equals(LatencyContributorMethod.PARTITION_FRAME)
				|| worstCaseMethod.equals(LatencyContributorMethod.PARTITION_SCHEDULE);
	}

	public boolean isPartitionFrame() {
		return worstCaseMethod.equals(LatencyContributorMethod.PARTITION_FRAME);
	}

	public boolean isPartitionOffset() {
		return worstCaseMethod.equals(LatencyContributorMethod.PARTITION_SCHEDULE);
	}

	public boolean isSamplingContributor() {
		return isPartition() || isSamplingTask();
	}

	public boolean isSamplingTask() {
		return worstCaseMethod.equals(LatencyContributorMethod.SAMPLED)
				|| worstCaseMethod.equals(LatencyContributorMethod.FIRST_SAMPLED)
				|| worstCaseMethod.equals(LatencyContributorMethod.DELAYED);
	}

	public void checkConsistency() {

		if ((this.expectedMax != 0.0) && (this.maxValue > this.expectedMax)) {
			reportWarning("max actual latency exceeds max flow latency");
		}

		if ((this.expectedMin != 0.0) && (this.minValue > this.expectedMin)) {

			reportWarning("min actual latency exceeds min flow latency");
		}

	}

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
		if (this.getSamplingPeriod() > 0.0
				&& !this.getBestcaseLatencyContributorMethod().equals(LatencyContributorMethod.FIRST_SAMPLED)) {
			myLine.addContent("0 ms");
		} else {
			myLine.addContent(this.getLocalMinimum() + "ms");
		}
		myLine.addContent(mapMethodToString(bestCaseMethod));
		if (this.expectedMax != 0.0) {
			myLine.addContent(this.expectedMax + "ms");
		} else {
			myLine.addContent(""); // the min expected value
		}
		if (this.getSamplingPeriod() > 0.0
				&& !this.getWorstcaseLatencyContributorMethod().equals(LatencyContributorMethod.FIRST_SAMPLED)) {
			myLine.addContent(this.getSamplingPeriod() + "ms");
		} else {
			myLine.addContent(this.getLocalMaximum() + "ms");
		}
		myLine.addContent(mapMethodToString(worstCaseMethod));
		myLine.addCells(this.getReportedIssues());
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

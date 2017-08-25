package org.osate.analysis.flows.model;


import static org.osate.results.util.ResultsUtil.createIssue;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.analysis.flows.FlowLatencyUtil;
import org.osate.analysis.flows.preferences.Values;
import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.ReportSeverity;
import org.osate.results.ResultContributor;
import org.osate.results.ResultIssue;
import org.osate.results.ResultIssueType;
import org.osate.results.ResultsFactory;

/**
 * A latency Contributor represents something in the flow
 * that can contribute to increase/decrease the latency.
 *
 * This class contains the result for a latency contributor
 * with min/max latency.
 *
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
	// Partition IO: I/O delay to partition window end or major frame

	public enum LatencyContributorMethod {
		UNKNOWN, DEADLINE, PROCESSING_TIME, DELAYED, SAMPLED, FIRST_SAMPLED, SPECIFIED, QUEUED, TRANSMISSION_TIME, PARTITION_FRAME, PARTITION_SCHEDULE, PARTITION_OUTPUT, SAMPLED_PROTOCOL
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
	private double immediateDeadline;

	/**
	 * Sampling offset for partition frame
	 */
	private double partitionOffset;

	/**
	 * Partition window length
	 */
	private double partitionDuration;

	/**
	 * Sampling period for SAMPLED, DELAYED, or partition related
	 */
	private double samplingPeriod;

	List<ResultIssue> issues;

	/**
	 * Sampling of incoming communication is synchronous
	 * Set if model indicates so. The doSynchronous value is examined if this is not set.
	 */
	public enum SynchronizeType {
		ASYNCHRONOUS, SYNCHRONOUS, SYNCUNKNOWN
	};

	private SynchronizeType isSynchronized = SynchronizeType.SYNCUNKNOWN;

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
		this.isSynchronized = SynchronizeType.SYNCUNKNOWN;
		this.minValue = 0.0;
		this.maxValue = 0.0;
		this.expectedMax = 0.0;
		this.expectedMin = 0.0;
		this.immediateDeadline = 0.0;
		this.samplingPeriod = 0.0;
		this.partitionOffset = 0.0;
		this.partitionDuration = 0.0;
		this.subContributors = new ArrayList<LatencyContributor>();
		this.issues = new ArrayList<ResultIssue>();
		this.maxSubtotal = 0.0;
		this.minSubtotal = 0.0;
	}

	protected List<ResultIssue> getReportedIssues() {
		return this.issues;
	}

	public void reportError(String str) {
		issues.add(createIssue(str, this.relatedElement, ResultIssueType.ERROR, ""));
	}

	public void reportSuccess(String str) {
		issues.add(createIssue(str, this.relatedElement, ResultIssueType.SUCCESS, ""));
	}

	public void reportInfo(String str) {
		issues.add(createIssue(str, this.relatedElement, ResultIssueType.INFO, ""));
	}

	public void reportWarning(String str) {
		issues.add(createIssue(str, this.relatedElement, ResultIssueType.WARNING, ""));
	}

	public void reportError(boolean doMaximum, String str) {
		issues.add(createIssue(FlowLatencyUtil.getMinMaxLabel(doMaximum) + str,
				this.relatedElement, ResultIssueType.ERROR, ""));
	}

	public void reportSuccess(boolean doMaximum, String str) {
		issues.add(createIssue(FlowLatencyUtil.getMinMaxLabel(doMaximum) + str,
				this.relatedElement, ResultIssueType.SUCCESS, ""));
	}

	public void reportInfo(boolean doMaximum, String str) {
		issues.add(createIssue(FlowLatencyUtil.getMinMaxLabel(doMaximum) + str,
				this.relatedElement, ResultIssueType.INFO, ""));
	}

	public void reportWarning(boolean doMaximum, String str) {
		issues.add(createIssue(FlowLatencyUtil.getMinMaxLabel(doMaximum) + str,
				this.relatedElement, ResultIssueType.WARNING, ""));
	}

	public void reportErrorOnce(boolean doMaximum, String str) {
		if (doMaximum) {
			return;
		}
		reportError(str);
	}

	public void reportSuccessOnce(boolean doMaximum, String str) {
		if (doMaximum) {
			return;
		}
		reportSuccess(str);
	}

	public void reportInfoOnce(boolean doMaximum, String str) {
		if (doMaximum) {
			return;
		}
		reportInfo(str);
	}

	public void reportWarningOnce(boolean doMaximum, String str) {
		if (doMaximum) {
			return;
		}
		reportWarning(str);
	}

	protected String getContributorName() {
		return relatedElement.getName();
	}

	protected NamedElement getContributor() {
		return relatedElement;
	}

	protected String getFullComponentContributorName() {
		if (this instanceof LatencyContributorComponent) {
			if (relatedElement instanceof InstanceObject) {
				return ((InstanceObject) relatedElement).getComponentInstancePath();
			}
			return relatedElement.getQualifiedName();
		}
		return "";
	}

	protected abstract String getContributorType();

	public void setSynchronous() {
		this.isSynchronized = SynchronizeType.SYNCHRONOUS;
	}

	public void setAsynchronous() {
		this.isSynchronized = SynchronizeType.ASYNCHRONOUS;
	}

	public void setSyncUnknown() {
		this.isSynchronized = SynchronizeType.SYNCUNKNOWN;
	}

	public boolean isSynchronous() {
		return this.isSynchronized.equals(SynchronizeType.SYNCHRONOUS);
	}

	public boolean isAsynchronous() {
		return this.isSynchronized.equals(SynchronizeType.ASYNCHRONOUS);
	}

	public boolean isSyncUnknown() {
		return this.isSynchronized.equals(SynchronizeType.SYNCUNKNOWN);
	}

	public double getSamplingPeriod() {
		return this.samplingPeriod;
	}

	public void setSamplingPeriod(double val) {
		this.samplingPeriod = val;
	}

	public double getPartitionOffset() {
		return this.partitionOffset;
	}

	public void setPartitionOffset(double val) {
		this.partitionOffset = val;
	}

	public double getPartitionDuration() {
		return this.partitionDuration;
	}

	public void setPartitionDuration(double val) {
		this.partitionDuration = val;
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

	public void reportSubtotal(double val, boolean doMax) {
		if (doMax) {
			this.setMaxSubtotal(val);
		} else {
			this.setMinSubtotal(val);
		}
	}

	public double getImmediateDeadline() {
		return this.immediateDeadline;
	}

	public void setImmediateDeadline(double val) {
		this.immediateDeadline = val;
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

	public LatencyContributorMethod getLatencyContributorMethod(boolean doWorstcase) {
		if (doWorstcase) {
			return this.worstCaseMethod;
		} else {
			return this.bestCaseMethod;
		}
	}

//	UNKNOWN, DEADLINE, PROCESSING_TIME, DELAYED, SAMPLED, FIRST_SAMPLED, SPECIFIED, QUEUED, TRANSMISSION_TIME, PARTITION_FRAME, PARTITION_SCHEDULE, PARTITION_IO
	public static String mapMethodToString(LatencyContributorMethod method) {
		switch (method) {
		case DEADLINE:
			return "deadline";
		case PROCESSING_TIME:
			return "processing time";
		case DELAYED:
			return "delayed sampling";
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
			return "partition offset";
		case TRANSMISSION_TIME:
			return "transmission time";
		case PARTITION_OUTPUT:
			return "partition output" + (Values.doMajorFrameDelay() ? " (MF)" : " (PE)");
		case SAMPLED_PROTOCOL:
			return "sampling protocol/bus";
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

	public void setActualValue(double d, boolean doMaximum) {
		if (doMaximum) {
			this.setMaximum(d);
		} else {
			this.setMinimum(d);
		}

	}

	public double getLocalMinimum() {
		return this.minValue;
	}

	public double getLocalMaximum() {
		return this.maxValue;
	}

	public double getTotal(boolean doMaximum) {
		if (doMaximum) {
			return getTotalMaximum();
		} else {
			return getTotalMinimum();
		}
	}

	public double getTotalMinimum() {
		double res = this.minValue;
		for (LatencyContributor lc : subContributors) {
			res = res + lc.getTotalMinimum();
		}
		return res;
	}

	public double getTotalMaximum() {
		double res = this.maxValue;
		for (LatencyContributor lc : subContributors) {
			res = res + lc.getTotalMaximum();
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

	public boolean isPartitionOutputDelay() {
		return worstCaseMethod.equals(LatencyContributorMethod.PARTITION_OUTPUT);
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
			reportWarning(true, "actual latency exceeds max flow latency");
		}

		if ((this.expectedMin != 0.0) && (this.minValue > this.expectedMin)) {

			reportWarning(false, "actual latency exceeds min flow latency");
		}

	}

	/**
	 * If the sender is on a partitioned architecture, then, we might need to add
	 * We do that only if the preferences selected an major frame delayed flush policy.
	 */

	public List<Line> export() {
		return export(0);
	}

	private String levelOpenLabel(int level) {
		if (level > 0) {
			return "(";
		}
		return "";
	}

	private String levelCloseLabel(int level) {
		if (level > 0) {
			return ")";
		}
		return "";
	}

	public List<Line> export(int level) {
		List<Line> lines;
		Line myLine;

		lines = new ArrayList<Line>();

		/**
		 * We also add the lines of all the sub-contributors.
		 */
		for (LatencyContributor lc : this.subContributors) {
			lines.addAll(lc.export(level + 1));
		}

		myLine = new Line();
		myLine.setSeverity(ReportSeverity.INFO);

		myLine.addContent(levelOpenLabel(level) + this.getContributorType() + " "
				+ this.getFullComponentContributorName() + levelCloseLabel(level));
		if (this.expectedMin != 0.0) {
			myLine.addContent(this.expectedMin + "ms");
		} else {
			myLine.addContent(""); // the min expected value
		}
		myLine.addContent(this.getTotalMinimum() + "ms");
		if (Values.doReportSubtotals()) {
			// don't report subtotals for subcontributors
			if (level > 0) {
				myLine.addContent("");
			} else {
				myLine.addContent(levelOpenLabel(level) + this.minSubtotal + "ms" + levelCloseLabel(level));
			}
		}
		myLine.addContent(mapMethodToString(bestCaseMethod));
		if (this.expectedMax != 0.0) {
			myLine.addContent(this.expectedMax + "ms");
		} else {
			myLine.addContent(""); // the min expected value
		}
		myLine.addContent(this.getTotalMaximum() + "ms");
		if (Values.doReportSubtotals()) {
			// don't report subtotals for subcontributors
			if (level > 0) {
				myLine.addContent("");
			} else {
				myLine.addContent(levelOpenLabel(level) + this.maxSubtotal + "ms" + levelCloseLabel(level));
			}
		}
		myLine.addContent(mapMethodToString(worstCaseMethod));
		myLine.addCells(this.getReportedIssues());
		lines.add(myLine);
		return lines;
	}

	private String getRelatedObjectLabel() {
		if (this.relatedElement instanceof InstanceObject) {
			return ((InstanceObject) this.relatedElement).getComponentInstancePath() + ": ";
		} else {
			return this.relatedElement.getQualifiedName();
		}
	}

	public void generateMarkers(AnalysisErrorReporterManager errManager) {
		List<ResultIssue> doIssues = this.getReportedIssues();
		for (ResultIssue reportedCell : doIssues) {
			if (reportedCell.getIssueType() == ResultIssueType.INFO) {
				errManager.info(this.relatedElement, reportedCell.getMessage());
			} else if (reportedCell.getIssueType() == ResultIssueType.SUCCESS) {
				errManager.info(this.relatedElement, getRelatedObjectLabel() + reportedCell.getMessage());
			} else if (reportedCell.getIssueType() == ResultIssueType.WARNING) {
				errManager.warning(this.relatedElement, getRelatedObjectLabel() + reportedCell.getMessage());
			} else if (reportedCell.getIssueType() == ResultIssueType.ERROR) {
				errManager.error(this.relatedElement, getRelatedObjectLabel() + reportedCell.getMessage());
			}
		}
	}

	public ResultContributor genResults() {
		return genResults(0);
	}

	public ResultContributor genResults(int level) {

		ResultContributor result = ResultsFactory.eINSTANCE.createResultContributor();
		result.setTarget(relatedElement);
		result.getIssues().addAll(issues);
		result.getValues().add(minValue);
		result.getValues().add(maxValue);
		result.getValues().add(expectedMin);
		result.getValues().add(expectedMax);
		result.getValues().add(immediateDeadline);
		result.getValues().add(partitionOffset);
		result.getValues().add(partitionDuration);
		result.getValues().add(samplingPeriod);
		result.getValues().add(minSubtotal);
		result.getValues().add(maxSubtotal);
		result.getValues().add(worstCaseMethod.name());
		result.getValues().add(bestCaseMethod.name());
		result.getValues().add(isSynchronized.name());
//		UnitLiteral msliteral = GetProperties.getMSUnitLiteral(relatedElement);
//		addDataValue(result, "minValue", minValue, msliteral);
//		addDataValue(result, "maxValue", maxValue, msliteral);
//		addDataValue(result, "expectedMin", expectedMin, msliteral);
//		addDataValue(result, "expectedMax", expectedMax, msliteral);
//		addDataValue(result, "immediateDeadline", immediateDeadline, msliteral);
//		addDataValue(result, "partitionOffset", partitionOffset, msliteral);
//		addDataValue(result, "partitionDuration", partitionDuration, msliteral);
//		addDataValue(result, "samplingPeriod", samplingPeriod, msliteral);
//		addDataValue(result, "minSubtotal", minSubtotal, msliteral);
//		addDataValue(result, "maxSubtotal", maxSubtotal, msliteral);
//		addStringValue(result, "worstCaseMethod", worstCaseMethod.name());
//		addStringValue(result, "bestCaseMethod", bestCaseMethod.name());
//		addStringValue(result, "isSynchronized", isSynchronized.name());
		/**
		 * We also add the lines of all the sub-contributors.
		 */
		for (LatencyContributor lc : this.subContributors) {
			result.getSubcontributor().add(lc.genResults(level + 1));
		}
		return result;
	}

}

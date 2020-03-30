/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.analysis.flows.model;


import static org.osate.result.util.ResultUtil.addRealValue;
import static org.osate.result.util.ResultUtil.addStringValue;
import static org.osate.result.util.ResultUtil.createDiagnostic;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.analysis.flows.FlowLatencyUtil;
import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.ReportSeverity;
import org.osate.result.Diagnostic;
import org.osate.result.DiagnosticType;
import org.osate.result.Result;
import org.osate.result.ResultFactory;

/**
 * A latency Result represents something in the flow
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
		UNKNOWN, DEADLINE,
		/**
		* @since 3.0
		*/
		RESPONSE_TIME, PROCESSING_TIME, DELAYED, SAMPLED, FIRST_PERIODIC, SPECIFIED, QUEUED, TRANSMISSION_TIME, PARTITION_FRAME, PARTITION_SCHEDULE, PARTITION_OUTPUT, SAMPLED_PROTOCOL
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

	List<Diagnostic> issues;

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

	private final boolean majorFrameDelay;

	public LatencyContributor(boolean majorFrameDelay) {
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
		this.issues = new ArrayList<Diagnostic>();
		this.majorFrameDelay = majorFrameDelay;
	}

	protected List<Diagnostic> getReportedIssues() {
		return this.issues;
	}

	public void reportError(String str) {
		issues.add(createDiagnostic(str, this.relatedElement, DiagnosticType.ERROR));
	}

	public void reportInfo(String str) {
		issues.add(createDiagnostic(str, this.relatedElement, DiagnosticType.INFO));
	}

	public void reportWarning(String str) {
		issues.add(createDiagnostic(str, this.relatedElement, DiagnosticType.WARNING));
	}

	public void reportError(boolean doMaximum, String str) {
		issues.add(createDiagnostic(FlowLatencyUtil.getMinMaxLabel(doMaximum) + str,
				this.relatedElement, DiagnosticType.ERROR));
	}

	public void reportInfo(boolean doMaximum, String str) {
		issues.add(createDiagnostic(FlowLatencyUtil.getMinMaxLabel(doMaximum) + str,
				this.relatedElement, DiagnosticType.INFO));
	}

	public void reportWarning(boolean doMaximum, String str) {
		issues.add(createDiagnostic(FlowLatencyUtil.getMinMaxLabel(doMaximum) + str,
				this.relatedElement, DiagnosticType.WARNING));
	}

	public void reportErrorOnce(boolean doMaximum, String str) {
		if (doMaximum) {
			return;
		}
		reportError(str);
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
		} else if (this instanceof LatencyContributorConnection) {
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
	public String mapMethodToString(LatencyContributorMethod method) {
		switch (method) {
		case DEADLINE:
			return "deadline";
		case RESPONSE_TIME:
			return "response time";
		case PROCESSING_TIME:
			return "processing time";
		case DELAYED:
			return "delayed sampling";
		case SPECIFIED:
			return "specified";
		case SAMPLED:
			return "sampling";
		case FIRST_PERIODIC:
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
			return "partition output" + (majorFrameDelay ? " (MF)" : " (PE)");
		case SAMPLED_PROTOCOL:
			return "sampling protocol/bus";
		case UNKNOWN:
			return "no sampling/queuing latency";
		default:
			return "no latency";
		}
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
		double spec = this.expectedMin;
		double res = 0;
		for (LatencyContributor lc : subContributors) {
			res = res + lc.getTotalMinimumSpecified();
		}
		if (this.relatedElement instanceof ConnectionInstance) {
			// we compare the subtotals against own
			if (spec > 0 && res > spec) {
				reportWarning("specified min protocol latency subtotal " + res + " exceeds connection latency " + spec);
			} else {
				if (spec > 0) {
					reportInfo("Using specified min protocol latency subtotal " + res
							+ " although specified connection latency " + spec + " is greater");
				}
			}
		} else {
			// we add own to subtotals
			res = res + spec;
		}
		return res;
	}

	public double getTotalMaximumSpecified() {
		double spec = this.expectedMax;
		double res = 0;
		for (LatencyContributor lc : subContributors) {
			res = res + lc.getTotalMaximumSpecified();
		}
		if (this.relatedElement instanceof ConnectionInstance) {
			// we compare the subtotals against own
			if (spec > 0 && res > spec) {
				reportWarning("specified max protocol latency subtotal " + res + " exceeds connection latency " + spec);
			} else {
				if (spec > 0) {
					reportInfo("Using max specified protocol latency subtotal " + res
							+ " although specified connection latency " + spec + " is greater");
				}
			}
		} else {
			// we add own to subtotals
			res = res + spec;
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
				|| worstCaseMethod.equals(LatencyContributorMethod.FIRST_PERIODIC)
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


	public Result genResult() {
		Result result = ResultFactory.eINSTANCE.createResult();
		result.setModelElement(relatedElement);
		result.getDiagnostics().addAll(issues);
		addRealValue(result, minValue);
		addRealValue(result, maxValue);
		addRealValue(result, expectedMin);
		addRealValue(result, expectedMax);
		addStringValue(result, mapMethodToString(bestCaseMethod));
		addStringValue(result, mapMethodToString(worstCaseMethod));
		/**
		 * We also add the lines of all the sub-contributors.
		 */
		for (LatencyContributor lc : this.subContributors) {
			result.getSubResults().add(lc.genResult());
		}
		return result;
	}
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
		myLine.addContent(mapMethodToString(bestCaseMethod));
		if (this.expectedMax != 0.0) {
			myLine.addContent(this.expectedMax + "ms");
		} else {
			myLine.addContent(""); // the min expected value
		}
		myLine.addContent(this.getTotalMaximum() + "ms");
		myLine.addContent(mapMethodToString(worstCaseMethod));
		myLine.addCells(this.getReportedIssues());
		lines.add(myLine);
		return lines;
	}

}

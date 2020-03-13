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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.analysis.flows.FlowLatencyUtil;
import org.osate.analysis.flows.reporting.model.Report;
import org.osate.analysis.flows.reporting.model.Report.ReportType;
import org.osate.result.Result;

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

	private boolean asynchronousSystem = true; // AS default
	private boolean majorFrameDelay = true; // MF default
	private boolean worstCaseDeadline = true; // DL default
	private boolean bestCaseEmptyQueue = true; // EQ default
	private boolean disableQueuingLatency = false;

	public LatencyReport() {
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

	public void setRootinstance(SystemInstance si) {
		this.relatedInstance = si;
	}

	public List<LatencyReportEntry> getEntries() {
		return this.entries;
	}

	public void addEntry(LatencyReportEntry entry) {
		this.entries.add(entry);
	}

	/**
	 * @since org.osate.analhysis.flows 3.0
	 */
	public List<Result> finalizeAllEntries() {
		final List<Result> results = new ArrayList<>();
		entries.forEach(entry -> {
			entry.finalizeReportEntry();
			results.add(entry.genResult());
		});
		return results;
	}

	@Deprecated
	public void setLatencyAnalysisParameters(boolean asynchronousSystem, boolean majorFrameDelay,
			boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		setLatencyAnalysisParameters(asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue, false);
	}

	/**
	 * @since org.osate.analhysis.flows 3.0
	 */
	public void setLatencyAnalysisParameters(boolean asynchronousSystem, boolean majorFrameDelay,
			boolean worstCaseDeadline, boolean bestCaseEmptyQueue, boolean disableQueuingLatency) {
		this.asynchronousSystem = asynchronousSystem;
		this.majorFrameDelay = majorFrameDelay;
		this.worstCaseDeadline = worstCaseDeadline;
		this.bestCaseEmptyQueue = bestCaseEmptyQueue;
		this.disableQueuingLatency = disableQueuingLatency;
	}

	public boolean isAsynchronousSystem() {
		return this.asynchronousSystem;
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

	/**
	 * @since org.osate.analhysis.flows 3.0
	 */
	public final boolean isDisableQueuingLatency() {
		return this.disableQueuingLatency;
	}

	public String getParametersAsDescriptions() {
		return "with preference settings: "
				+ FlowLatencyUtil.getParametersAsDescriptions(asynchronousSystem, majorFrameDelay, worstCaseDeadline,
						bestCaseEmptyQueue, disableQueuingLatency);
	}

	public EList<Result> genResult() {

		EList<Result> latencyResults = new BasicEList<Result>();
		for (LatencyReportEntry re : entries) {
			latencyResults.add(re.genResult());
		}
		return latencyResults;
	}

	public Report export() {
		Report genericReport;

		genericReport = new Report(this.relatedInstance, "latency",
				"latency_" + FlowLatencyUtil.getParametersAsLabels(asynchronousSystem, majorFrameDelay,
						worstCaseDeadline, bestCaseEmptyQueue, disableQueuingLatency),
				ReportType.TABLE);
		genericReport.setTextContent("Latency analysis " + getParametersAsDescriptions());
		for (LatencyReportEntry re : entries) {
			genericReport.addSection(re.export());
		}

		return genericReport;
	}

}

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
package org.osate.analysis.flows.handlers;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch;
import org.osate.analysis.flows.FlowLatencyUtil;
import org.osate.analysis.flows.FlowanalysisPlugin;
import org.osate.analysis.flows.dialogs.FlowLatencyDialog;
import org.osate.analysis.flows.model.LatencyCSVReport;
import org.osate.analysis.flows.model.LatencyExcelReport;
import org.osate.analysis.flows.preferences.Constants;
import org.osate.result.AnalysisResult;
import org.osate.result.Diagnostic;
import org.osate.result.DiagnosticType;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;
import org.osate.ui.handlers.AbstractInstanceOrDeclarativeModelModifyHandler;

public final class CheckFlowLatency extends AbstractInstanceOrDeclarativeModelModifyHandler {
	protected static AnalysisResult latResult = null;
	protected static boolean isAsynchronousSystem = true;
	protected static boolean isMajorFrameDelay = true;
	protected static boolean isWorstCaseDeadline = true;
	protected static boolean isBestCaseEmptyQueue = true;
	protected static boolean isDisableQueuingLatency = false;

	@Override
	protected String getActionName() {
		return "Check flow latency";
	}

	@Override
	public String getMarkerType() {
		return "org.osate.analysis.flows.FlowLatencyObjectMarker";
	}

	@Override
	protected boolean canAnalyzeDeclarativeModels() {
		return false;
	}

	@Override
	protected void analyzeDeclarativeModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			Element declarativeObject) {
	}

	@Override
	protected boolean initializeAnalysis(final NamedElement object) {
		final IPreferenceStore store = FlowanalysisPlugin.getDefault().getPreferenceStore();
		final FlowLatencyDialog d = new FlowLatencyDialog(getShell(), store);

		final boolean doIt;
		if (d.dontShowDialog()) {
			// Don't show the dialog, just run the analysis
			doIt = true;
		} else {
			Display.getDefault().syncExec(() -> d.open());
			doIt = d.getReturnCode() == Window.OK;
		}

		if (doIt) {
			isAsynchronousSystem = d.localValues.get(Constants.ASYNCHRONOUS_SYSTEM_LAST_USED)
					.equalsIgnoreCase(Constants.ASYNCHRONOUS_SYSTEM_YES);
			isMajorFrameDelay = d.localValues.get(Constants.PARTITONING_POLICY_LAST_USED)
					.equalsIgnoreCase(Constants.PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR);
			isWorstCaseDeadline = d.localValues.get(Constants.WORST_CASE_DEADLINE_LAST_USED)
					.equalsIgnoreCase(Constants.WORST_CASE_DEADLINE_YES);
			isBestCaseEmptyQueue = d.localValues.get(Constants.BESTCASE_EMPTY_QUEUE_LAST_USED)
					.equalsIgnoreCase(Constants.BESTCASE_EMPTY_QUEUE_YES);
			isDisableQueuingLatency = d.localValues.get(Constants.DISABLE_QUEUING_LATENCY_LAST_USED)
					.equals(Constants.DISABLE_QUEUING_LATENCY_YES);
			latResult = FlowLatencyUtil.createLatencyAnalysisResult(object, isAsynchronousSystem, isMajorFrameDelay,
					isWorstCaseDeadline, isBestCaseEmptyQueue, isDisableQueuingLatency);
		}

		return doIt;
	};

	@Override
	protected boolean finalizeAnalysis() {
		FlowLatencyUtil.saveAnalysisResult(latResult);
		LatencyCSVReport.generateCSVReport(latResult);
		LatencyExcelReport.generateExcelReport(latResult);
		generateMarkers(latResult, new AnalysisErrorReporterManager(getAnalysisErrorReporterFactory()));
		if (latResult.getResults().isEmpty()) {
			getShell().getDisplay().asyncExec(() -> MessageDialog.openInformation(getShell(), "Flow Latency Analysis",
					"No active flows were found to analyze."));
		}
		return true;
	};

	private void generateMarkers(AnalysisResult results, AnalysisErrorReporterManager errMgr) {
		for (Result res : results.getResults()) {
			generateMarkers(errMgr, res.getDiagnostics(), ResultUtil.getString(res, 0),
					(EndToEndFlowInstance) res.getModelElement());
		}
	}

	private void generateMarkers(AnalysisErrorReporterManager errManager, List<Diagnostic> issues, String som,
			EndToEndFlowInstance target) {
		String inMode = som.isEmpty() ? "" : " in mode " + som;
		for (Diagnostic issue : issues) {
			if (issue.getDiagnosticType() == DiagnosticType.INFO) {
				errManager.info(target, issue.getMessage() + inMode);
			} else if (issue.getDiagnosticType() == DiagnosticType.WARNING) {
				errManager.warning(target, getRelatedObjectLabel(target) + issue.getMessage() + inMode);
			} else if (issue.getDiagnosticType() == DiagnosticType.ERROR) {
				errManager.error(target, getRelatedObjectLabel(target) + issue.getMessage() + inMode);
			}
		}
	}

	private String getRelatedObjectLabel(InstanceObject obj) {
		return obj.getComponentInstancePath() + ": ";
	}

	@Override
	protected void analyzeInstanceModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			SystemInstance root, SystemOperationMode som) {
		monitor.beginTask(getActionName(), 1);
		// Note: analyzeInstanceModel is called for each mode. We add the results to the same 'latreport'
		FlowLatencyAnalysisSwitch flas = new FlowLatencyAnalysisSwitch(monitor, root);
		flas.invokeOnSOM(root, som, isAsynchronousSystem, isMajorFrameDelay, isWorstCaseDeadline,
				isBestCaseEmptyQueue, isDisableQueuingLatency);
		latResult.getResults().addAll(flas.finalizeResults());
		monitor.done();
	}

}
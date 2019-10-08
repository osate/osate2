/*
 *
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 *
 * %W%
 * @version %I% %H%
 */
package org.osate.analysis.flows.handlers;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
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
import org.osate.ui.handlers.AbstractInstanceOrDeclarativeModelReadOnlyHandler;

public final class CheckFlowLatency extends AbstractInstanceOrDeclarativeModelReadOnlyHandler {
	protected static AnalysisResult latResult = null;
	protected static boolean isAsynchronousSystem = true;
	protected static boolean isMajorFrameDelay = true;
	protected static boolean isWorstCaseDeadline = true;
	protected static boolean isBestCaseEmptyQueue = true;

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
	protected boolean initializeAnalysis(NamedElement object) {
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
			latResult = FlowLatencyUtil.createLatencyAnalysisResult(object, isAsynchronousSystem, isMajorFrameDelay,
					isWorstCaseDeadline, isBestCaseEmptyQueue);
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
		EList<Result> res = flas.invokeOnSOM(root, som, isAsynchronousSystem, isMajorFrameDelay, isWorstCaseDeadline,
				isBestCaseEmptyQueue);
		latResult.getResults().addAll(res);
		monitor.done();
	}

}
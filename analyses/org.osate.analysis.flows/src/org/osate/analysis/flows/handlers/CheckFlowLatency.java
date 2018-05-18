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
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch;
import org.osate.analysis.flows.FlowLatencyUtil;
import org.osate.analysis.flows.model.LatencyReport;
import org.osate.analysis.flows.preferences.Values;
import org.osate.result.AnalysisResult;
import org.osate.result.Diagnostic;
import org.osate.result.DiagnosticType;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;
import org.osate.ui.dialogs.Dialog;
import org.osate.ui.handlers.AbstractInstanceOrDeclarativeModelReadOnlyHandler;

public final class CheckFlowLatency extends AbstractInstanceOrDeclarativeModelReadOnlyHandler {
	protected static LatencyReport latreport = null;

	@Override
	protected String getActionName() {
		return "Check flow latency";
	}

	@Override
	public String getMarkerType() {
		return "org.osate.analysis.flows.FlowLatencyObjectMarker";
	}

	@Override
	protected void analyzeDeclarativeModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			Element declarativeObject) {
		Dialog.showError("Flow Latency Error", "Please select an instance model");
	}

	@Override
	protected boolean initializeAnalysis(NamedElement object) {
		if (object instanceof SystemInstance) {
			latreport = new LatencyReport((SystemInstance) object);
			latreport.setLatencyAnalysisParameters(Values.doSynchronousSystem(), Values.doMajorFrameDelay(),
					Values.doWorstCaseDeadline(), Values.doMajorFrameDelay());
			return true;
		}
		return false;
	};

	@Override
	protected boolean finalizeAnalysis() {
		if (latreport != null && !latreport.getEntries().isEmpty()) {
			// do cvs and xsl reports
			FlowLatencyUtil.saveAsSpreadSheets(latreport);
			AnalysisResult results = latreport.genResult();
			FlowLatencyUtil.saveAnalysisResult(results, FlowLatencyUtil.getPreferencesSuffix(latreport));
			generateMarkers(results, new AnalysisErrorReporterManager(getAnalysisErrorReporterFactory()));
		}
		return true;
	};

	private void generateMarkers(AnalysisResult results, AnalysisErrorReporterManager errMgr) {
		for (Result res : results.getResults()) {
			generateMarkers(errMgr, res.getDiagnostics(), ResultUtil.getString(res, 0),
					(EndToEndFlowInstance) res.getSourceReference());
		}
	}

	private void generateMarkers(AnalysisErrorReporterManager errManager, List<Diagnostic> issues,
			String som, EndToEndFlowInstance target) {
		String inMode = som.isEmpty() ? "" : " in mode " + som;
		for (Diagnostic issue : issues) {
			if (issue.getType() == DiagnosticType.INFO) {
				errManager.info(target, issue.getMessage() + inMode);
			} else if (issue.getType() == DiagnosticType.SUCCESS) {
				errManager.info(target, getRelatedObjectLabel(target) + issue.getMessage() + inMode);
			} else if (issue.getType() == DiagnosticType.WARNING) {
				errManager.warning(target, getRelatedObjectLabel(target) + issue.getMessage() + inMode);
			} else if (issue.getType() == DiagnosticType.ERROR) {
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
		FlowLatencyAnalysisSwitch flas = new FlowLatencyAnalysisSwitch(monitor, root, latreport);
		flas.processPreOrderAll(root);
		monitor.done();
	}

	public void invoke(IProgressMonitor monitor, SystemInstance root, SystemOperationMode som) {
		initializeAnalysis(root);
		analyzeInstanceModel(monitor, null, root, som);
		finalizeAnalysis(); // uses error report manager to generate markers
	}


}
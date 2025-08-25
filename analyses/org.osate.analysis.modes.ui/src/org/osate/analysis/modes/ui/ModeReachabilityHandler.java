/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.analysis.modes.ui;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.analysis.modes.reachability.ReachabilityAnalyzer;
import org.osate.analysis.modes.reachability.ReachabilityConfiguration;
import org.osate.analysis.modes.ui.internal.ModeAnalysisPlugin;
import org.osate.analysis.modes.ui.preferences.Constants;
import org.osate.result.AnalysisResult;
import org.osate.result.DiagnosticType;
import org.osate.result.ResultType;
import org.osate.ui.handlers.AaxlModifyHandlerAsJob;

public final class ModeReachabilityHandler extends AaxlModifyHandlerAsJob {

	private final IDialogSettings settings = ModeAnalysisPlugin.getDefault().getDialogSettings();
	private final IPreferenceStore prefStore = ModeAnalysisPlugin.getDefault().getPreferenceStore();

	private ReachabilityConfiguration cfg;

	@Override
	public String getMarkerType() {
		return "org.osate.analysis.modes.ui.SOMReachabilityMarker";
	}

	@Override
	protected String getActionName() {
		return "Analyze SOM reachability";
	}

	public void invoke(IProgressMonitor monitor, SystemInstance root) {
		cfg = new ReachabilityConfiguration().withDot().withHTML().withSMV();
		invoke(monitor, null, root);
	}

	public void invoke(final IProgressMonitor monitor, final AnalysisErrorReporterManager errManager,
			final SystemInstance root) {
		this.errManager = errManager != null ? errManager
				: new AnalysisErrorReporterManager(getAnalysisErrorReporterFactory());
		analyzeInstanceModel(monitor, root);
	}

	@Override
	protected boolean initializeAction(NamedElement object) {
		final var dlg = new ModeReachabilitySettings(getShell(), settings, prefStore);
		final boolean doIt;

		if (dlg.hideDialog()) {
			// Don't show the dialog, just run the analysis
			doIt = true;
		} else {
			Display.getDefault().syncExec(() -> dlg.open());
			doIt = dlg.getReturnCode() == Window.OK;
		}

		if (doIt) {
			cfg = new ReachabilityConfiguration();
			if (dlg.getBoolean(Constants.GENERATE_HTML)) {
				cfg = cfg.withHTML();
			}
			if (dlg.getBoolean(Constants.GENERATE_DOT)) {
				cfg = cfg.withDot();
			}
			if (dlg.getBoolean(Constants.GENERATE_SMV)) {
				cfg = cfg.withSMV();
			}
		}

		return doIt;
	}

	@Override
	protected void doAaxlAction(IProgressMonitor monitor, Element root) {
		analyzeInstanceModel(monitor, root);
	}

	protected void analyzeInstanceModel(IProgressMonitor monitor, Element root) {
		SystemInstance ci = ((ComponentInstance) root).getSystemInstance();
		var ra = new ReachabilityAnalyzer(cfg, ci);
		var result = ra.analyzeModel(monitor);
		createMarkers(result, root.eResource());
		if (result.getResultType() != ResultType.SUCCESS) {
			IStatus status = null;
			switch (result.getResultType().getValue()) {
			case ResultType.TBD_VALUE:
				status = new Status(IStatus.CANCEL, ModeAnalysisPlugin.PLUGIN_ID, result.getMessage());
				StatusManager.getManager().handle(status, StatusManager.SHOW);
				break;
			case ResultType.ERROR_VALUE:
				status = new Status(IStatus.ERROR, ModeAnalysisPlugin.PLUGIN_ID,
						result.getMessage());
				StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.SHOW);
				break;
			case ResultType.FAILURE_VALUE:
				status = new Status(IStatus.ERROR, ModeAnalysisPlugin.PLUGIN_ID, result.getMessage());
				StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.SHOW);
				break;
			default:
				break;
			}
		} else {
			var status = ra.writeReports();
			if (!status.isOK()) {
				StatusManager.getManager().handle(status, StatusManager.SHOW);
			}
		}
	}

	private void createMarkers(AnalysisResult result, Resource resource) {
		result.getDiagnostics().stream().forEach(diag -> {
			if (diag.getModelElement() instanceof Element e && e.eResource() == resource) {
				if (diag.getDiagnosticType() == DiagnosticType.ERROR) {
					errManager.error(e, diag.getMessage());
				} else if (diag.getDiagnosticType() == DiagnosticType.WARNING) {
					errManager.warning(e, diag.getMessage());
				} else if (diag.getDiagnosticType() == DiagnosticType.INFO) {
					errManager.info(e, diag.getMessage());
				}
			}
		});
	}

}
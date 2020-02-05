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
package org.osate.analysis.resource.budgets.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.analysis.resource.budgets.logic.NotBoundResourceAnalysis;
import org.osate.ui.handlers.AaxlReadOnlyHandlerAsJob;

/**
 * @since 2.0
 */
public class NotBoundResourceAnalysisHandler extends AaxlReadOnlyHandlerAsJob {
	@Override
	protected String getActionName() {
		return "Not Bound Resource Budget Analysis";
	}

	@Override
	public String getMarkerType() {
		return "org.osate.analysis.resource.budgets.NotBoundResourceAnalysisMarker";
	}

	@Override
	public boolean initializeAction(NamedElement obj) {
		setCSVLog("NotBoundResourceBudgets", obj);
		return true;
	}

	public void setErrManager() {
		this.errManager = new AnalysisErrorReporterManager(this.getAnalysisErrorReporterFactory());
	}

	public void setSummaryReport() {
		this.summaryReport = new StringBuffer();
	}

	public void saveReport() {
		this.getCSVLog().saveToFile();
	}

	@Override
	public void doAaxlAction(IProgressMonitor monitor, Element obj) {

		// Get the system instance (if any)
		final SystemInstance si = (obj instanceof InstanceObject) ? ((InstanceObject) obj).getSystemInstance() : null;

		if (si != null) {
			monitor.beginTask(getActionName(), IProgressMonitor.UNKNOWN);
			NotBoundResourceAnalysis logic = null;

			logic = new NotBoundResourceAnalysis(this);
			final SOMIterator soms = new SOMIterator(si);
			while (soms.hasNext()) {
				logic.analyzeResourceBudget(si, soms.next());
			}
			monitor.done();
		}
	}

	public void invoke(IProgressMonitor monitor, SystemInstance root) {
		actionBody(monitor, root);
	}
}
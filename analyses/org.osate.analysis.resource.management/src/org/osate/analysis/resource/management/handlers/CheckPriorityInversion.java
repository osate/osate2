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
package org.osate.analysis.resource.management.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.analysis.scheduling.inversion.PriorityInversion;
import org.osate.ui.handlers.AbstractInstanceOrDeclarativeModelModifyHandler;

public final class CheckPriorityInversion extends AbstractInstanceOrDeclarativeModelModifyHandler {
	@Override
	protected String getActionName() {
		return "Check priority inversion";
	}

	@Override
	public String getMarkerType() {
		return "org.osate.analysis.resource.management.InversionObjectMarker";
	}

	@Override
	protected boolean canAnalyzeDeclarativeModels() {
		return false;
	}

	@Override
	protected void analyzeDeclarativeModel(final IProgressMonitor monitor,
			final AnalysisErrorReporterManager errManager, final Element declarativeObject) {
	}

	@Override
	protected void analyzeInstanceModel(final IProgressMonitor monitor, final AnalysisErrorReporterManager errManager,
			final SystemInstance root, final SystemOperationMode som) {
		monitor.beginTask(getActionName(), IProgressMonitor.UNKNOWN);
		try {
			final PriorityInversion pi = new PriorityInversion(errManager);
			pi.checkSystemPriorityInversion(root);
		} catch (InvalidModelException e) {
			error(e.getElement(), e.getMessage());
		}
		monitor.done();
	}

	public void invoke(IProgressMonitor monitor, SystemInstance root) {
		actionBody(monitor, root);
	}
}
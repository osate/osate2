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
package org.osate.aadl2.errormodel.analysis.handlers;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.errormodel.analysis.PropagateErrorSources;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ui.handlers.AaxlReadOnlyHandlerAsJob;

public final class FaultImpactHandler extends AaxlReadOnlyHandlerAsJob {
	@Override
	protected String getMarkerType() {
		return "org.osate.analysis.errormodel.FaultImpactMarker";
	}

	@Override
	protected String getActionName() {
		return "Fault impact analysis";
	}

	@Override
	public void doAaxlAction(IProgressMonitor monitor, Element obj) {
		monitor.beginTask("Fault impact analysis", IProgressMonitor.UNKNOWN);

		// Get the system instance (if any)
		SystemInstance si;
		if (obj instanceof InstanceObject) {
			si = ((InstanceObject) obj).getSystemInstance();
		} else {
			return;
		}

		/*
		 * Create a new model statistics analysis object and run it over the
		 * declarative model. If an instance model exists, run it over that too.
		 */
		PropagateErrorSources faultimpact = new PropagateErrorSources("FaultImpact", si); // optional third parameter maxLevel
		faultimpact.reportImpactHeading();
		faultimpact.reportTableHeading();
		Collection<ComponentInstance> cilist = faultimpact.getSubcomponents();
		for (ComponentInstance componentInstance : cilist) {
			if (componentInstance != null && !(componentInstance instanceof SystemInstance)) {
				// OsateDebug.osateDebug("start flow for ci="+componentInstance.getName());
				faultimpact.startErrorFlows(componentInstance);
			}
		}
		for (ComponentInstance componentInstance : cilist) {
			if (componentInstance != null) {
				// OsateDebug.osateDebug("start flow for ci="+componentInstance.getName());
				faultimpact.startConnectionSourceFlows(componentInstance);
			}
		}
		faultimpact.startExternalFlows(si);
		faultimpact.saveReport();

		monitor.done();
	}
}
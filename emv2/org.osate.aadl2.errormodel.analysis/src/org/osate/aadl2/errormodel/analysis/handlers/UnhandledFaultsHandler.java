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
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath;
import org.osate.aadl2.errormodel.PropagationGraph.util.Util;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ui.handlers.AaxlReadOnlyHandlerAsJob;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class UnhandledFaultsHandler extends AaxlReadOnlyHandlerAsJob {

	@Override
	protected String getMarkerType() {
		return "org.osate.aadl2.errormodel.analysis.UnhandledFaultsMarker";
	}

	@Override
	protected String getActionName() {
		return "UnhandledFaults";
	}

	@Override
	public void doAaxlAction(IProgressMonitor monitor, Element obj) {
		monitor.beginTask("UnhandledFaults", IProgressMonitor.UNKNOWN);

		// Get the system instance (if any)
		SystemInstance si;
		if (obj instanceof InstanceObject) {
			si = ((InstanceObject) obj).getSystemInstance();
		} else {
			return;
		}

		setCSVLog("UnhandledFaults", si);
		PropagationGraph currentPropagationGraph = Util.generatePropagationGraph(si, false);
		Collection<PropagationGraphPath> pathlist = currentPropagationGraph.getPropagationGraphPaths();
		for (PropagationGraphPath path : pathlist) {
			checkPropagationPathErrorTypes(path);
		}

		monitor.done();
	}

	/**
	 * @since 1.1
	 */
	public void checkUnhandledFaults(SystemInstance si) {
		PropagationGraph currentPropagationGraph = Util.generatePropagationGraph(si, false);
		Collection<PropagationGraphPath> pathlist = currentPropagationGraph.getPropagationGraphPaths();
		for (PropagationGraphPath path : pathlist) {
			checkPropagationPathErrorTypes(path);
		}
	}

	protected void checkPropagationPathErrorTypes(PropagationGraphPath path) {
		ErrorPropagation srcprop = path.getPathSrc().getErrorPropagation();
		ErrorPropagation dstprop = path.getPathDst().getErrorPropagation();
		if (srcprop != null && dstprop != null) {
			if (!EMV2TypeSetUtil.contains(dstprop.getTypeSet(), srcprop.getTypeSet())) {
				error(path.getConnection() != null ? path.getConnection() : path.getPathSrc().getComponentInstance(),
						"Outgoing propagation  " + EMV2Util.getPrintName(srcprop)
						+ EMV2Util.getPrintName(srcprop.getTypeSet())
						+ " has error types not handled by incoming propagation "
						+ EMV2Util.getPrintName(dstprop) + EMV2Util.getPrintName(dstprop.getTypeSet()));
			}
		}
		if (dstprop == null && srcprop != null) {
			// has an EMV2 subclause but no propagation specification for the feature
			ComponentInstance dstci = path.getPathDst().getComponentInstance();
			if (dstci != null) {
				// filter out path involving connection instance (binding of connection)
				error(dstci,
						"Connection target " + dstci.getComponentInstancePath()
								+ " has no error propagation/containment but source does: "
						+ EMV2Util.getPrintName(srcprop)  + EMV2Util.getPrintName(srcprop.getTypeSet()));
			}
		}
		if (dstprop != null && srcprop == null) {
			// has an EMV2 subclause but no propagation specification for the feature
			ComponentInstance srcci = path.getPathSrc().getComponentInstance();
			if (srcci != null) {
				// filter out path involving connection instance (binding of connection)
			error(srcci,
						"Connection source " + srcci.getComponentInstancePath()
								+ " has no error propagation/containment but target does: "
								+ EMV2Util.getPrintName(dstprop) + EMV2Util.getPrintName(dstprop.getTypeSet()));
			}
		}
	}
}
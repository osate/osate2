/*
 * <copyright>
 * Copyright  2012-2013 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
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
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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
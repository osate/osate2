/*
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
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

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.errormodel.analysis.cma.CMAReport;
import org.osate.aadl2.errormodel.analysis.cma.CMAUtils;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.ui.dialogs.Dialog;
import org.osate.ui.handlers.AaxlReadOnlyHandlerAsJob;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.util.AnalysisModel;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public final class CMAHandler extends AaxlReadOnlyHandlerAsJob {
	@Override
	protected String getMarkerType() {
		return "org.osate.analysis.errormodel.FaultImpactMarker";
	}

	@Override
	protected String getActionName() {
		return "CMA";
	}

	@Override
	public void doAaxlAction(IProgressMonitor monitor, Element obj) {

		SystemInstance si;

		if (obj instanceof InstanceObject) {
			si = ((InstanceObject) obj).getSystemInstance();
		} else {
			Dialog.showInfo("Common Mode Assessment", "Please choose an instance system");
			return;
		}

		monitor.beginTask("Common Mode Assessment", IProgressMonitor.UNKNOWN);

		AnalysisModel analysisModel = new AnalysisModel(si.getComponentInstance());

		CMAReport report = new CMAReport();

		/**
		 * We try to see what is the severity for each state. Then, if a state
		 * is classified at least as the selected severity, we add all its common
		 * cause of failures reported by the processState method.
		 */
		for (ErrorBehaviorState state : EMV2Util.getAllErrorBehaviorStates(si)) {

			List<EMV2PropertyAssociation> severityPAList = EMV2Properties.getSeverityProperty(si, state,
					state.getTypeSet());
			EMV2PropertyAssociation severityPA = severityPAList.isEmpty() ? null : severityPAList.get(0);
			PropertyExpression severityValue = EMV2Properties.getPropertyValue(severityPA);
			String sev = EMV2Properties.getEnumerationOrIntegerPropertyConstantPropertyValue(severityValue);
			CMAUtils.setCurrentSeverity(sev);
			report.addEntries(CMAUtils.processState(analysisModel, analysisModel.getRoot().getComponentInstance(),
					state, state.getTypeSet()));

		}

		WriteToFile csvReport = new WriteToFile("CMA", si);
		report.write(csvReport);
		csvReport.saveToFile();

		monitor.done();
	}
}
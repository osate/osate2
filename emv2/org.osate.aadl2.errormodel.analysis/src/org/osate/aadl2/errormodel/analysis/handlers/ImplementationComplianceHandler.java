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

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.ui.dialogs.Dialog;
import org.osate.ui.handlers.AaxlReadOnlyHandlerAsJob;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.util.EM2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

/**
 * Also, this class implement the following consistency rule from
 * the official documentation:
 * C1, C5, C7, C11, C12
 *
 */
public final class ImplementationComplianceHandler extends AaxlReadOnlyHandlerAsJob {
	@Override
	protected String getMarkerType() {
		return "org.osate.aadl2.errormodel.analysis.FaultImpactMarker";
	}

	@Override
	protected String getActionName() {
		return "ImplementationCompliance";
	}

	@Override
	public void doAaxlAction(IProgressMonitor monitor, Element obj) {
		ComponentInstance instance = null;
		ComponentType componentType = null;
		ComponentImplementation componentImplementation = null;

		monitor.beginTask("Checking Compliance", IProgressMonitor.UNKNOWN);

		if (obj instanceof ComponentInstance) {
			instance = ((ComponentInstance) obj);
		} else {
			Dialog.showError("Integration Compliance", "You must select a component instance");
			return;
		}

		if (!(instance.getComponentClassifier() instanceof ComponentImplementation)) {
			Dialog.showError("Integration Compliance",
					"You must select a component that is a component implementation");
			return;
		}

		componentImplementation = (ComponentImplementation) instance.getComponentClassifier();
		componentType = componentImplementation.getType();

		/**
		 * Here, we check that the outgoing error propagations
		 * between the type and the implementation uses
		 * the same types.
		 */
		for (ErrorPropagation epi : EMV2Util.getAllOutgoingErrorPropagations(componentImplementation)) {
			boolean found = false;

			for (ErrorPropagation epc : EMV2Util.getAllOutgoingErrorPropagations(componentType)) {
				if (EMV2Util.getPropagationName(epi).equalsIgnoreCase(EMV2Util.getPropagationName(epc))) {
					found = true;

					if (!EMV2Util.areEquivalent(epi, epc)) {
						error(obj, "Implementation does not match all errors types on outgoing error propagations");
					}

					/**
					 * In the following piece of code, we checked the failure
					 * rate occurrence of the classifier against the implementation.
					 * We make sure than the implementation does not exceed the
					 * budget defined in the classifier.
					 */
					double probImplementation = 0;
					double probClassifier = 0;
					probImplementation = EMV2Properties.getProbability(componentImplementation, epi, epi.getTypeSet());
					probClassifier = EMV2Properties.getProbability(componentImplementation, epc, epc.getTypeSet());

					if (probImplementation > probClassifier) {
						error(obj, "Failure rate on the implementation is higher than on the classifier ("
								+ probImplementation + " vs " + probClassifier + ")");
					}
				}
			}

			if (found == false) {
				error(obj, "Object does not have matching error propagations");
			}
		}

		/**
		 * Here, we check that the incoming error propagations
		 * between the type and the implementation uses
		 * the same types.
		 */
		for (ErrorPropagation epi : EMV2Util.getAllIncomingErrorPropagations(componentImplementation)) {
			boolean found = false;

			for (ErrorPropagation epc : EMV2Util.getAllIncomingErrorPropagations(componentType)) {
				if (EMV2Util.getPropagationName(epi).equalsIgnoreCase(EMV2Util.getPropagationName(epc))) {
					found = true;

					if (!EMV2Util.areEquivalent(epi, epc)) {
						error(obj, "Implementation does not match all type errors in its incoming error propagations");
					}

				}
			}

			if (found == false) {
				error(obj, "Object does not have matching error propagations");
			}
		}

		/**
		 * Finally, we check the compliance of the components error behavior.
		 * Check the states of the states and that the states also
		 * exists.
		 */
		for (ErrorBehaviorState typeState : EMV2Util.getAllErrorBehaviorStates(componentType)) {

			boolean found = false;
			for (ErrorBehaviorState implementationState : EMV2Util.getAllErrorBehaviorStates(componentImplementation)) {
				if (typeState.getName().equalsIgnoreCase(implementationState.getName())) {

					found = true;
					if ((typeState.getTypeSet() != null) && (implementationState.getTypeSet() != null)
							&& (!EM2TypeSetUtil.contains(typeState.getTypeSet(), implementationState.getTypeSet()))) {
						error(obj,
								"State " + typeState.getName() + " does not have the same types between type and impl");
					}
				}
			}

			if (found == false) {
				error(obj, "Did not find the error state");
			}
		}

		/**
		 * Check the error events now
		 */
		for (ErrorBehaviorEvent typeBehaviorEvent : EMV2Util.getAllErrorBehaviorEvents(componentType)) {

			boolean found = false;
			ErrorEvent typeEvent = null;
			ErrorEvent implementationEvent = null;

			for (ErrorBehaviorEvent implementationBehaviorEvent : EMV2Util
					.getAllErrorBehaviorEvents(componentImplementation)) {
				if (implementationBehaviorEvent instanceof ErrorEvent) {
					implementationEvent = (ErrorEvent) implementationBehaviorEvent;
				}

				if (typeBehaviorEvent instanceof ErrorEvent) {
					typeEvent = (ErrorEvent) typeBehaviorEvent;
				}

				if (typeEvent.getName().equalsIgnoreCase(implementationEvent.getName())) {

					found = true;
					if ((typeEvent.getTypeSet() != null) && (implementationEvent.getTypeSet() != null)
							&& (!EM2TypeSetUtil.contains(typeEvent.getTypeSet(), implementationEvent.getTypeSet()))) {
						error(obj,
								"Event " + typeEvent.getName() + " does not have the same types between type and impl");
					}
				}
			}

			if (found == false) {
				error(obj, "Did not find the error state");
			}
		}

		monitor.done();
	}
}
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
package org.osate.aadl2.errormodel.analysis.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.ui.dialogs.Dialog;
import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public final class RBDAction extends AaxlReadOnlyActionAsJob {

	private double finalResult;
	private List<ComponentInstance> componentsNames;
	private static String ERROR_STATE_NAME = null;

	@Override
	protected String getMarkerType() {
		return "org.osate.analysis.errormodel.FaultImpactMarker";
	}

	@Override
	protected String getActionName() {
		return "RBD";
	}

	private double handleElement(final SConditionElement conditionElement, final ComponentInstance root) {
		double result = 0;

		ErrorBehaviorState behaviorState = EMV2Util.getState(conditionElement);

		ComponentInstance relatedInstance = EMV2Util.getLastComponentInstance(conditionElement.getQualifiedState(),
				root);
//		OsateDebug.osateDebug("         instance " + relatedInstance);

		if (relatedInstance != null) {
			if (!componentsNames.contains(relatedInstance)) {
				componentsNames.add(relatedInstance);
			}

			if (behaviorState != null) {
				double resultSubcomponents;
				double resultProperty;

				resultProperty = 0;
				resultSubcomponents = 0;

				/*
				 * Let's try to recursively compute the value
				 */
				resultSubcomponents = processComponent(relatedInstance, behaviorState.getName());

				/**
				 * If it does not work, try the property mechanism.
				 */
				resultProperty = EMV2Properties.getProbability(relatedInstance, behaviorState, null);

				/**
				 * We take the result that is the worst case occurrence.
				 */
				if (resultSubcomponents == 0) {
					result = resultProperty;
				} else {
					result = resultSubcomponents;
				}

			}
		}

		return result;
	}

	private double handleCondition(final ConditionExpression cond, final ComponentInstance root) {
		double result = 0;
		double tmp;
		// OsateDebug.osateDebug("cond="+cond);

		if (cond instanceof SConditionElement) {
			return handleElement((SConditionElement) cond, root);
		}

		if (cond instanceof OrExpression) {
			OrExpression sor = (OrExpression) cond;
			for (ConditionExpression conditionExpression : sor.getOperands()) {
				// OsateDebug.osateDebug(" operand=" + conditionExpression);
				result += handleCondition(conditionExpression, root);
			}
		}

		if (cond instanceof AndExpression) {
			AndExpression sae = (AndExpression) cond;
			for (ConditionExpression conditionExpression : sae.getOperands()) {
				tmp = handleCondition(conditionExpression, root);
				if (result == 0) {
					result = tmp;
				} else {
					result = result * tmp;
				}
			}
		}
		return result;
	}

	public double processComponent(ComponentInstance component, String errorStateName) {
		double probabilityTemp;
		double toRemove;
		double result;
		double inverseProb = 1; // Probability fix attempt - DD 06/23/15

		EList<CompositeState> states = EMV2Util.getAllCompositeStates(component);
		result = 0;
		probabilityTemp = 0;
		toRemove = 0;
		for (CompositeState state : states) {
			if (state.getState().getName().equalsIgnoreCase(errorStateName)) {
				probabilityTemp = handleCondition(state.getCondition(), component);
				// OsateDebug.osateDebug("temp=" + probabilityTemp);

				/*
				 * result = result + probabilityTemp; //Probability fix attempt - DD 06/23/15
				 * if (toRemove == 0) {
				 * toRemove = probabilityTemp;
				 * } else {
				 * toRemove = toRemove * probabilityTemp;
				 * result = result - toRemove;
				 * toRemove = result;
				 * }
				 */
				inverseProb *= (1 - probabilityTemp);

			}
		}
		// seems to reset the fa
		/*
		 * if (result > toRemove) {
		 * result = result - toRemove;
		 * }
		 */
		result = 1 - inverseProb; // End Probability fix attempt - DD 06/23/15
		return result;
	}

	@Override
	public void doAaxlAction(IProgressMonitor monitor, Element obj) {
		SystemInstance si;
		String message;

		monitor.beginTask("RBD", IProgressMonitor.UNKNOWN);

		si = null;
		componentsNames = new ArrayList<ComponentInstance>();
		finalResult = 0;

		if (obj instanceof InstanceObject) {
			si = ((InstanceObject) obj).getSystemInstance();
		}

		if (si == null) {
			Dialog.showInfo("RDB", "Please choose an instance model");
			monitor.done();
		}

		if (!EMV2Util.hasCompositeErrorBehavior(si)) {
			Dialog.showInfo("RDB", "Your system instance does not have a composite error behavior");
			monitor.done();
		}

		final Display d = PlatformUI.getWorkbench().getDisplay();
		d.syncExec(new Runnable() {

			@Override
			public void run() {
				IWorkbenchWindow window;
				Shell sh;

				window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				sh = window.getShell();

				InputDialog fd = new InputDialog(sh, "Error State name",
						"Please specify the name of the error state name", "failed", null);
				if (fd.open() == Window.OK) {
					ERROR_STATE_NAME = fd.getValue();
				} else {
					ERROR_STATE_NAME = null;
				}

			}
		});

		if (ERROR_STATE_NAME != null) {
			finalResult = processComponent(si, ERROR_STATE_NAME);
			message = "Failure probability: " + finalResult + "\n";
			message += "Components involved:\n";
			for (ComponentInstance ci : componentsNames) {
				message += "   * " + ci.getName() + " (" + ci.getCategory().toString() + ")\n";
			}
			Dialog.showInfo("Reliability Block Diagram", message);
		}

		monitor.done();
	}

}

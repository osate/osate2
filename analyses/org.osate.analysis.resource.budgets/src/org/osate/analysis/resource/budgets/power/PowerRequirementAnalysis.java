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
package org.osate.analysis.resource.budgets.power;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.analysis.resource.budgets.internal.busload.model.ConnectionEnd;
import org.osate.analysis.resource.budgets.internal.busload.model.Feature;
import org.osate.analysis.resource.budgets.internal.busload.model.PowerRequirementModel;
import org.osate.analysis.resource.budgets.internal.busload.model.Visitor;
import org.osate.analysis.resource.budgets.logic.GenericAnalysis;
import org.osate.result.AnalysisResult;
import org.osate.result.Result;
import org.osate.result.ResultType;
import org.osate.result.util.ResultUtil;
import org.osate.ui.dialogs.Dialog;

/**
 * Class for performing "power requirements" analysis on a system.  Basically it makes sure the selected system
 * has enough actual capacity to fulfill the power demand.
 *
 * <p>The format for the returned {@code AnalysisResult} object is as follows:
 *
 * <p>For the {@code AnalysisResult} object itself:
 * <ul>
 *   <li>analysis = "Power  Requirements"
 *   <li>modelElement = {@code SystemInstance} being analyzed
 *   <li>resultType = SUCCESS
 *   <li>message = "Power requirements analysis of ..."
 *   <li>diagnostics = empty list
 *   <li>parameters = empty list
 *   <li>results = one {@code Result} for each system operation mode
 *     <ul>
 *       <li>modelElement = {@code SystemOperationMode} instance object
 *       <li>resultType = SUCCESS
 *       <li>message = empty string
 *       <li>values = empty list
 *       <li>diagnostics = empty list
 *       <li>subResults = one {@code Result} for each {@code ComponentInstance} with category of {@code Feature} or {@code ConnectionEnd}
 *         <ul>
 *           <li>modelElement = {@code Feature} or {@code ConnectionEnd} instance object
 *           <li>resultType = SUCCESS
 *           <li>message = The component's name from {@link ComponentInstance#getName()}
 *           <li>values[0] = The budget of {@code Feature} or {@code ConnectionEnd} instance object (power provided by this component) (RealValue)
 *           <li>values[1] = The supply in form of power budget drawn from other supply. This could be a requires bus access, or an incoming abstract feature. There must be a connection on this feature (RealValue)
 *           <li>values[2] = The capacity of the power supplier system in W as specified by SEI::PowerCapacity property (RealValue)
 *           <li>values[3] = Total Budget across the whole system (RealValue)
 *           <li>values[4] = Total Supply across the whole system (RealValue)
 *           <li>values[5] = components that represent a power system with capacity (StringValue)
 *           <li>values[6] = "System name ..." (StringValue)
 *           <li>values[7] = {@code Feature} or {@code ConnectionEnd} instance's name (StringValue)
 *           <li>values[8] = "Budget ... for ... out of total ..." (StringValue)
 *           <li>values[9] = "Supply ... for ... out of total ..." (StringValue)
 *           <li>values[10] = "Total capacity: ..." (StringValue)
 *           <li>diagnostics = Diagnostics associated with this {@code Feature} or {@code ConnectionEnd} instance object
 *           <li>subResults is empty
 *           </ul>
 *         </ul>
 *     </ul>
 * </ul>
 * @since 4.1
 */

public class PowerRequirementAnalysis extends GenericAnalysis {
	private static final String INITIAL_MODE_LABEL = "Initial Mode";
	private static final String CHOOSE_MODE_LABEL = "Choose Mode...";
	private static final String ALL_MODES_LABEL = "All Modes";

	private static final String[] ALL_MODE_CHOICE_LABELS = { INITIAL_MODE_LABEL, CHOOSE_MODE_LABEL, ALL_MODES_LABEL };

	private static final int INITIAL_MODE = 0;
	private static final int CHOOSE_MODE = 1;

	private static final int DEFAULT_MODE_CHOICE = INITIAL_MODE;

	private int lastDefaultModeChoice = DEFAULT_MODE_CHOICE;

	public PowerRequirementAnalysis() {
		super();
	}

	public AnalysisResult invoke(final IProgressMonitor monitor, final SystemInstance systemInstance) {
		final IProgressMonitor pm = monitor == null ? new NullProgressMonitor() : monitor;
		return analyzeBody(pm, systemInstance);
	}

	private AnalysisResult analyzeBody(final IProgressMonitor monitor, final Element obj) {
		if (obj instanceof InstanceObject) {
			final SystemInstance root = ((InstanceObject) obj).getSystemInstance();

			final AnalysisResult analysisResult = ResultUtil.createAnalysisResult("Power  Requirements", root);
			analysisResult.setResultType(ResultType.SUCCESS);
			analysisResult.setMessage("Power requirements analysis of " + root.getFullName());

			final SystemInstance si = root;
			final int whichMode;

			if (si.getSystemOperationModes().size() > 1) {
				whichMode = Dialog.askQuestion("Choose Mode",
						"Please choose in which mode(s) the model should be analyzed.", ALL_MODE_CHOICE_LABELS,
						lastDefaultModeChoice);
			} else {
				// A system with no modes still has at least one SOM named NORMAL_SOM_NAME aka "no modes"
				whichMode = INITIAL_MODE;
			}

			if (whichMode != -1) {
				lastDefaultModeChoice = whichMode;

				SystemOperationMode chosenSOM = null;
				if (!si.getSystemOperationModes().isEmpty()) {
					// the SOM list should not be empty
					if (whichMode == INITIAL_MODE) {
						// this may also be "No Modes" aka NORMAL_SOM_NAME
						chosenSOM = si.getInitialSystemOperationMode();
					} else if (whichMode == CHOOSE_MODE) {
						List<String> ar = new ArrayList<String>();
						si.getSystemOperationModes().forEach((som) -> ar.add(som.getFullName()));
						int choosen = Dialog.askQuestion("Choose Mode",
								"Please choose in which mode(s) the model should be analyzed.",
								ar.toArray(new String[ar.size()]),
								lastDefaultModeChoice);

						chosenSOM = si.getSystemOperationModes().get(choosen);
					}
				}

				final AnalysisErrorReporterManager errManager = new AnalysisErrorReporterManager(
						new MarkerAnalysisErrorReporter.Factory(AadlConstants.AADLOBJECTMARKER));
				if (chosenSOM != null) {
					final Result somResult = ResultUtil.createResult(
							Aadl2Util.isPrintableSOMName(chosenSOM) ? Aadl2Util.getPrintableSOMMembers(chosenSOM) : "",
							chosenSOM, ResultType.SUCCESS);
					analysisResult.getResults().add(somResult);

					final PowerRequirementModel model = PowerRequirementModel.buildModel(root, chosenSOM);

					// Analyze the model
					model.visit(new PowerRequirementAnalysisVisitor(somResult, model.getTotalCapacity(),
							model.getTotalBudget(), model.getTotalSupply(), model.getSystemSOMname(),
							model.getComponentName()));
				} else {
					final SOMIterator soms = new SOMIterator(si);
					while (soms.hasNext()) {
						final SystemOperationMode som = soms.nextSOM();
						final Result somResult = ResultUtil.createResult(
								Aadl2Util.isPrintableSOMName(som) ? Aadl2Util.getPrintableSOMMembers(som) : "", som,
								ResultType.SUCCESS);
						analysisResult.getResults().add(somResult);

						final PowerRequirementModel model = PowerRequirementModel.buildModel(root, som);

						// Analyze the model
						model.visit(new PowerRequirementAnalysisVisitor(somResult, model.getTotalCapacity(),
								model.getTotalBudget(), model.getTotalSupply(), model.getSystemSOMname(),
								model.getComponentName()));
					}
				}
			}

			monitor.done();

			return analysisResult;
		} else {
			Dialog.showError("Power Requirements Analysis Error", "Can only check system instances");
			return null;
		}
	}

	// ==== Analysis Visitor ====

	private class PowerRequirementAnalysisVisitor implements Visitor {
		private Result currentResult;

		private final double capacity, tBudget, tSupply;
		private final String systemSOMname, componentName;

		public PowerRequirementAnalysisVisitor(final Result rootResult, double capacity, double budget, double supply,
				String systemSOMname, String componentName) {
			this.currentResult = rootResult;
			this.capacity = capacity;
			this.tBudget = budget;
			this.tSupply = supply;
			this.systemSOMname = systemSOMname;
			this.componentName = componentName;
		}

		@Override
		public void visitConnectionEndPrefix(final ConnectionEnd connEnd) {
			final ConnectionInstanceEnd connInstanceEnd = connEnd.getConnectionInstanceEnd();

			// Create a new result object for the connection end
			final Result connEndResult = ResultUtil.createResult(connInstanceEnd.getName() + connEnd.getID().toString(),
					connInstanceEnd,
					ResultType.SUCCESS);

			currentResult.getSubResults().add(connEndResult);
		}

		@Override
		public void visitConnectionEndPostfix(final ConnectionEnd connEnd) {
			// unroll the result stack

			EList<Result> results = currentResult.getSubResults();
			String visitConnEndID = connEnd.getID().toString();

			results.forEach(result -> {
				String msg = result.getMessage();

				if (msg.contains(visitConnEndID)) {
					result.setMessage(msg.replaceAll(visitConnEndID, ""));

					double budget = connEnd.getBudget();
					double supply = connEnd.getSupply();
					String name = connEnd.getConnectionInstanceEnd().getContainingComponentInstance().getName();

					ResultUtil.addRealValue(result, budget);
					ResultUtil.addRealValue(result, supply);
					ResultUtil.addRealValue(result, capacity);
					ResultUtil.addRealValue(result, tBudget);
					ResultUtil.addRealValue(result, tSupply);

					ResultUtil.addStringValue(result, this.componentName);
					ResultUtil.addStringValue(result, "System name " + this.systemSOMname);
					ResultUtil.addStringValue(result, name);

					String stBudget = PowerRequirementAnalysis.toString(tBudget);

					ResultUtil.addStringValue(result,
							"Budget " + PowerRequirementAnalysis.toString(budget) + " for " + name
									+ " out of total " + stBudget);

					ResultUtil.addStringValue(result,
							"Supply " + PowerRequirementAnalysis.toString(supply) + " from " + name
									+ " out of total " + PowerRequirementAnalysis.toString(tSupply));

					String stCapacity = PowerRequirementAnalysis.toString(capacity);

					ResultUtil.addStringValue(result, "Total capacity: " + stCapacity);

					// diagnostics -> markers
					final ConnectionInstanceEnd connEndInstance = connEnd.getConnectionInstanceEnd();

					if (capacity > 0.0 && tBudget > 0.0 && tBudget > capacity) {
						error(result, connEndInstance,
								this.componentName + " budget total " + stBudget + " exceeds capacity " + stCapacity);
					}

					double available = 0.0;
					String suppliedmsg = "";
					if (tSupply == 0.0) {
						available = capacity;
						suppliedmsg = "capacity ";
					} else {
						available = tSupply;
						suppliedmsg = "supply ";
					}

					if (tBudget > available) {
						error(result, connEndInstance, "budget total " + stBudget + " exceeds " + suppliedmsg
								+ PowerRequirementAnalysis.toString(available));
					}
				}
			});
		}

		@Override
		public void visitFeaturePrefix(final Feature feature) {
			final FeatureInstance featureInstance = feature.getFeatureInstance();

			// Create a new result object for the connection end
			final Result featureResult = ResultUtil.createResult(featureInstance.getName() + feature.getID(),
					featureInstance,
					ResultType.SUCCESS);

			currentResult.getSubResults().add(featureResult);
		}

		@Override
		public void visitFeaturePostfix(final Feature feature) {
			// unroll the result stack
			String visitFeatureID = feature.getID().toString();

			currentResult.getSubResults().forEach(result -> {
				String msg = result.getMessage();

				if (msg.contains(visitFeatureID)) {
					result.setMessage(msg.replaceAll(visitFeatureID, ""));

					double budget = feature.getBudget();
					double supply = feature.getSupply();
					String name = feature.getFeatureInstance().getContainingComponentInstance().getName();

					ResultUtil.addRealValue(result, budget); // 0
					ResultUtil.addRealValue(result, supply); // 1
					ResultUtil.addRealValue(result, capacity);// 2
					ResultUtil.addRealValue(result, tBudget); // 3
					ResultUtil.addRealValue(result, tSupply); // 4

					ResultUtil.addStringValue(result, this.componentName); // 5
					ResultUtil.addStringValue(result, "System name " + this.systemSOMname); // 6
					ResultUtil.addStringValue(result, name); // 7

					String stBudget = PowerRequirementAnalysis.toString(tBudget);

					ResultUtil.addStringValue(result,
							"Budget " + PowerRequirementAnalysis.toString(budget) + " for " + name
									+ " out of total " + stBudget);

					ResultUtil.addStringValue(result,
							"Supply " + PowerRequirementAnalysis.toString(supply) + " from " + name
									+ " out of total " + PowerRequirementAnalysis.toString(tSupply));

					String stCapacity = PowerRequirementAnalysis.toString(capacity);

					ResultUtil.addStringValue(result, "Total capacity: " + stCapacity);

					// diagnostics -> markers
					final FeatureInstance featureInstance = feature.getFeatureInstance();

					if (capacity > 0.0 && tBudget > 0.0 && tBudget > capacity) {
						error(result, featureInstance,
								this.componentName + " budget total " + stBudget + " exceeds capacity " + stCapacity);
					}

					double available = 0.0;
					String suppliedmsg = "";
					if (tSupply == 0.0) {
						available = capacity;
						suppliedmsg = "capacity ";
					} else {
						available = tSupply;
						suppliedmsg = "supply ";
					}

					if (tBudget > available) {
						error(result, featureInstance, "budget total " + stBudget + " exceeds " + suppliedmsg
								+ PowerRequirementAnalysis.toString(available));
					}
				}
			});
		}
	}

	public static String toString(double value) {
		return value > 2000.0 ? value / 1000 + " W" : value + " mW";
	}
}
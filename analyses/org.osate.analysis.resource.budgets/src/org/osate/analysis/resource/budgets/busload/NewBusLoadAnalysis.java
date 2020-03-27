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
package org.osate.analysis.resource.budgets.busload;

import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.analysis.resource.budgets.busload.model.Bus;
import org.osate.analysis.resource.budgets.busload.model.BusLoadModel;
import org.osate.analysis.resource.budgets.busload.model.BusLoadModel.PrintVisitor;
import org.osate.analysis.resource.budgets.busload.model.BusOrVirtualBus;
import org.osate.analysis.resource.budgets.busload.model.Connection;
import org.osate.analysis.resource.budgets.busload.model.Visitor;
import org.osate.ui.dialogs.Dialog;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public final class NewBusLoadAnalysis {
	private static final String MARKER_TYPE = "org.osate.analysis.resource.budgets.BusLoadAnalysisMarker";

	private final AnalysisErrorReporterManager errManager;
	private final String actionName;

	public NewBusLoadAnalysis(final String actionName) {
		this.errManager = new AnalysisErrorReporterManager(new MarkerAnalysisErrorReporter.Factory(MARKER_TYPE));
		this.actionName = actionName;
	}

	public void analysisBody(final IProgressMonitor monitor, final Element obj) {
		if (obj instanceof InstanceObject) {
			final PrintWriter pw = new PrintWriter(System.out, true);
			final SystemInstance root = ((InstanceObject) obj).getSystemInstance();
			monitor.beginTask(actionName, IProgressMonitor.UNKNOWN);
			final SOMIterator soms = new SOMIterator(root);
			while (soms.hasNext()) {
				final SystemOperationMode som = soms.nextSOM();
				final BusLoadModel model = BusLoadModel.buildModel(root, som);

				// analyse the model
				model.visit(new BusLoadAnalysisVisitor());

				pw.println("Model for system operation mode " + som);
				pw.println();
				final PrintVisitor pv = new PrintVisitor() {
					@Override
					public void visitBusOrVirtualBusPrefix(final BusOrVirtualBus b) {
						println("Capacity = " + b.getCapacity() + " KB/s");
						println("Budget = " + b.getBudget() + " KB/s");
						println("Required budget = " + b.getTotalBudget() + " KB/s");
						println("Actual usage = " + b.getActual() + " KB/s");
					}

					@Override
					public void visitConnection(final Connection c) {
						println("Budget = " + c.getBudget() + " KB/s");
						println("Actual usage = " + c.getActual() + " KB/s");
					}
				};
				model.print(pw, pv);
				pw.println();
				pw.println("===============================================");
				pw.println();
			}
			monitor.done();
		} else {
			Dialog.showError("Bound Bus Bandwidth Analysis Error", "Can only check system instances");
		}
	}

	// ==== Analysis Visitor ====

	private class BusLoadAnalysisVisitor implements Visitor {
		private Deque<Double> previousOverhead = new LinkedList<>();
		private double dataOverheadKBytesps = 0.0;

		@Override
		public void visitBusOrVirtualBusPrefix(final BusOrVirtualBus bus) {
			final ComponentInstance ci = bus.getBusInstance();
			// Increment the data overhead
			final double newOverheadKBytesps = GetProperties.getDataSize(ci, GetProperties.getKBUnitLiteral(ci));
			previousOverhead.push(dataOverheadKBytesps);
			dataOverheadKBytesps += newOverheadKBytesps;
		}

		@Override
		public void visitBusOrVirtualBusPostfix(final BusOrVirtualBus bus) {
			// Unroll the overhead calculation
			dataOverheadKBytesps = previousOverhead.pop();

			// Compute the actual usage and budget requirements
			double actual = 0.0;
			double totalBudget = 0.0;

			for (final BusOrVirtualBus b : bus.getBoundBuses()) {
				actual += b.getActual();
				totalBudget += b.getBudget();
			}
			for (final Connection c : bus.getBoundConnections()) {
				actual += c.getActual();
				totalBudget += c.getBudget();
			}
			bus.setActual(actual);
			bus.setTotalBudget(totalBudget);

			final ComponentInstance busInstance = bus.getBusInstance();
			final double capacity = GetProperties.getBandWidthCapacityInKBytesps(busInstance, 0.0);
			final double budget = GetProperties.getBandWidthBudgetInKBytesps(busInstance, 0.0);
			bus.setCapacity(capacity);
			bus.setBudget(budget);

			if (capacity == 0.0) {
				warning(busInstance, (bus instanceof Bus ? "Bus " : "Virtual bus ") +
						busInstance.getName() + " has no capacity");
			} else {
				if (actual > capacity) {
					error(busInstance, (bus instanceof Bus ? "Bus " : "Virtual bus ") + busInstance.getName()
							+ " -- Actual bandwidth > capacity: " + actual + " KB/s > "
							+ capacity + " KB/s");
				}
			}

			if (budget == 0.0) {
				warning(busInstance, (bus instanceof Bus ? "Bus " : "Virtual bus ") +
						busInstance.getName() + " has no bandwidth budget");
			} else {
				if (budget > capacity) {
					error(busInstance, (bus instanceof Bus ? "Bus " : "Virtual bus ") + busInstance.getName()
									+ " -- budget > capacity: " + budget + " KB/s > " + capacity + " KB/s");
				}
				if (totalBudget > budget) {
					error(busInstance, (bus instanceof Bus ? "Bus " : "Virtual bus ") + busInstance.getName()
							+ " -- Required budget > budget: " + totalBudget + " KB/s > " + budget
							+ " KB/s");
				}
			}
		}

		@Override
		public void visitConnection(final Connection connection) {
			final ConnectionInstance connectionInstance = connection.getConnectionInstance();
			final double actual = getConnectionActualKBytesps(connectionInstance, dataOverheadKBytesps);
			connection.setActual(actual);

			final double budget = GetProperties.getBandWidthBudgetInKBytesps(connectionInstance, 0.0);
			if (budget > 0.0) {
				connection.setBudget(budget);
				if (actual > budget) {
					error(connectionInstance, "Connection " + connectionInstance.getName() + " -- Actual bandwidth > budget: " + actual + " KB/s > "
							+ budget + " KB/s");
				}
			} else {
				warning(connectionInstance, "Connection " + connectionInstance.getName() + " has no bandwidth budget");
			}
		}
	}

	// ==== Helper methods for the visitor ===

	/**
	 * Calculate bandwidth demand from rate & data size
	 * @param ci The connection instance to calculate for
	 * @param dataOverheadKBytesps The current data overhead from bound buses expressed in KB/s.  This is applied to
	 * the connections message size.
	 */
	private static double getConnectionActualKBytesps(final ConnectionInstance ci, final double dataOverheadKBytesps) {
		double actualDataRate = 0;
		final ConnectionInstanceEnd cie = ci.getSource();
		if (cie instanceof FeatureInstance) {
			final FeatureInstance fi = (FeatureInstance) cie;
			final double datasize = dataOverheadKBytesps
					+ GetProperties.getSourceDataSize(fi, GetProperties.getKBUnitLiteral(fi));
			final double srcRate = GetProperties.getOutgoingMessageRatePerSecond(fi);
			actualDataRate = datasize * srcRate;
		}
		return actualDataRate;
	}

	// ==== Error reporting methods for the visitor ===

	private void error(final InstanceObject io, final String msg) {
		errManager.error(io, msg);
		System.out.println("ERROR: " + msg);
	}

	private void warning(final InstanceObject io, final String msg) {
		errManager.warning(io, msg);
		System.out.println("WARNING: " + msg);
	}
}
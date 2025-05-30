/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.contrib.aadlproject.DataRateUnits;
import org.osate.aadl2.contrib.aadlproject.SizeUnits;
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.contrib.communication.CommunicationProperties;
import org.osate.aadl2.contrib.communication.RateSpec.RateUnit_FieldType;
import org.osate.aadl2.contrib.memory.MemoryProperties;
import org.osate.aadl2.contrib.timing.TimingProperties;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.analysis.model.AnalysisElement;
import org.osate.analysis.model.util.AnalysisModelTraversal;
import org.osate.analysis.model.util.AnalysisModelTraversal.Nothing;
import org.osate.analysis.resource.budgets.internal.models.busload.Broadcast;
import org.osate.analysis.resource.budgets.internal.models.busload.Bus;
import org.osate.analysis.resource.budgets.internal.models.busload.BusLoadModel;
import org.osate.analysis.resource.budgets.internal.models.busload.BusOrVirtualBus;
import org.osate.analysis.resource.budgets.internal.models.busload.Connection;
import org.osate.analysis.resource.budgets.internal.models.busload.VirtualBus;
import org.osate.analysis.resource.budgets.internal.models.busload.util.BusloadSwitch;
import org.osate.contribution.sei.sei.DataRate;
import org.osate.contribution.sei.sei.MessageRate;
import org.osate.contribution.sei.sei.Sei;
import org.osate.pluginsupport.properties.PropertyUtils;
import org.osate.result.AnalysisResult;
import org.osate.result.Result;
import org.osate.result.ResultType;
import org.osate.result.util.ResultUtil;
import org.osate.ui.dialogs.Dialog;

/**
 * Class for performing "bus load" analysis on a system.  Basically it makes sure all the connections and buses
 * have enough actual capacity to carry the data loads bound to them.
 *
 * <p>The format for the returned {@code AnalysisResult} object is as follows:
 *
 * <p>For the {@code AnalysisResult} object itself:
 * <ul>
 *   <li>analysis = "Bus Load"
 *   <li>modelElement = {@code SystemInstance} being analyzed
 *   <li>resultType = SUCCESS
 *   <li>message = "Bus load analysis of ..."
 *   <li>diagnostics = empty list
 *   <li>parameters = empty list
 *   <li>results = one {@code Result} for each system operation mode
 *     <ul>
 *       <li>modelElement = {@code SystemOperationMode} instance object
 *       <li>resultType = SUCCESS
 *       <li>message = "" if the SOM is {@code null} or the empty SOM, otherwise "(xxx, ..., yyy)"
 *       <li>values = empty list
 *       <li>diagnostics = empty list
 *       <li>subResults = one {@code Result} for each {@code ComponentInstance} with category of {@code Bus}
 *         <ul>
 *           <li>modelElement = {@code ComponentInstance} instance object
 *           <li>resultType = SUCCESS
 *           <li>message = The component's name from {@link ComponentInstance#getName()}
 *           <li>values[0] = The capacity of the bus in KB/s as specified by the SEI::BandwidthCapacity property (RealValue)
 *           <li>values[1] = The budget of the bus in KB/s as specified by the SEI::BandwidthBudget property (RealValue)
 *           <li>values[2] = The required budget of the bus in KB/s (the sum of the budgets of all the bound buses and connections) (RealValue)
 *           <li>values[3] = The actual usage of the bus in KB/s (the sum of the actual usages of all the bound buses and connections) (RealValue)
 *           <li>values[4] = The number of virtual buses bound to this bus (IntegerValue)
 *           <li>values[5] = The number of connections bound to this bus (IntegerValue)
 *           <li>values[6] = The number of broadcast sources bound to this bus (IntegerValue)
 *           <li>values[7] = The overhead of the bus in bytes as computed by analysis (IntegerValue)
 *           <li>diagnostics = Diagnostics associated with this bus.
 *           <li>subResults indexes 0 through (values[4] -1) refer to {@code Result} objects for virtual buses.
 *             <ul>
 *               <li>subResults objects for virtual buses are the same as for buses
 *             </ul>
 *           <li>subResults indexes values[4] through values[4] + values[5] - 1) refer to {@code Result} objects for connections.
 *             <ul>
 *               <li>modelElement = {@code ConnectionInstance} instance object
 *               <li>resultType = SUCCESS
 *               <li>message = The connection's name from {@link ConnectionInstance#geName()}
 *               <li>values[0] = The budget of the connection in KB/s as specified by the SEI::BandwidthBudget property (RealValue)
 *               <li>values[1] = The actual usage of the bus in KB/s as computed by the multiplying the connection's data size by the connection's message rate. This takes into
 *                           account any messaging overhead by the bus hierarchy the connection is bound to. (RealValue)
 *               <li>diagnostics = Diagnostics associated with this connection
 *               <li>subResults = empty list
 *           </ul>
 *           <li>subResults indexes values[4] + values[5] through values[4] + values[5] + values[6] - 1 refer to {@code Result} objects for broadcast sources.
 *             <ul>
 *               <li>modelElement = {@code ConnectionInstanceEnd} instance object of the feature that is the source of the broadcast
 *               <li>resultType = SUCCESS
 *               <li>message = "Broadcast from " + the feature's path in the model as returned by {@link ConnectionInstanceEnd#getInstanceObjectPath()}
 *               <li>values[0] = The budget of the broadcast source in KB/s (RealValue)
 *               <li>values[1] = The actual usage of the bus in KB/s (RealValue)
 *               <li>diagnostics = Diagnostics associated with this broadcast source
 *               <li>subResults = The {@code Result} objects for the connections that are part of the broadcast (share the same source)
 *                   <ul>
 *                       <li>Same as above
 *                   </ul>
 *           </ul>
 *         </ul>
 *     </ul>
 * </ul>
 *
 * @since 4.0
 */
public final class NewBusLoadAnalysis {
	public NewBusLoadAnalysis() {
		super();
	}

	/*
	 * For now we just have an invoke() method that runs over all the SOMs in the model.
	 * That is all I need for the JUnit tests.
	 * Add more methods as they are needed rather than try to guess and just leave
	 * a bunch of useless junky methods in there.
	 */

	/**
	 * Analyze the given system instance, taking all the system operation modes into account.
	 *
	 * @param monitor The progress monitor to use, or {@code null} if one is not needed.
	 * @param systemInstance The system instance to analyze.
	 * @return The results in a {@code AnalysisResult} object.
	 */
	public AnalysisResult invoke(final IProgressMonitor monitor, final SystemInstance systemInstance) {
		final IProgressMonitor pm = monitor == null ? new NullProgressMonitor() : monitor;
		return analyzeBody(pm, systemInstance);
	}

	private AnalysisResult analyzeBody(final IProgressMonitor monitor, final Element obj) {
		if (obj instanceof InstanceObject) {
			final SystemInstance root = ((InstanceObject) obj).getSystemInstance();
			final AnalysisResult analysisResult = ResultUtil.createAnalysisResult("Bus  Load", root);
			analysisResult.setResultType(ResultType.SUCCESS);
			analysisResult.setMessage("Bus load analysis of " + root.getFullName());

			final SOMIterator soms = new SOMIterator(root);
			while (soms.hasNext()) {
				final SystemOperationMode som = soms.nextSOM();
				final Result somResult = ResultUtil.createResult(
						Aadl2Util.isPrintableSOMName(som) ? Aadl2Util.getPrintableSOMMembers(som) : "", som,
						ResultType.SUCCESS);
				analysisResult.getResults().add(somResult);

				final BusLoadModel busLoadModel = BusLoadModelBuilder.buildModel(root, som);
				analyzeBusLoadModel(busLoadModel, somResult, monitor);
			}
			monitor.done();

			return analysisResult;
		} else {
			Dialog.showError("Bound Bus Bandwidth Analysis Error", "Can only check system instances");
			return null;
		}
	}

	private void analyzeBusLoadModel(final BusLoadModel busLoadModel, final Result somResult,
			final IProgressMonitor monitor) {
		final Map<AnalysisElement, Result> results = new HashMap<>();
		AnalysisModelTraversal.preOrder(busLoadModel, new BandwidthAndResultPreOrderSwitch(results, somResult),
				monitor);
		if (!monitor.isCanceled()) {
			AnalysisModelTraversal.postOrder(busLoadModel, new CapacityAndBudgetPostOrderSwitch(results), monitor);
		}
	}

	private static final class BandwidthAndResultPreOrderSwitch extends BusloadSwitch<Nothing> {
		private final Result somResult;
		private final Map<AnalysisElement, Result> results;

		public BandwidthAndResultPreOrderSwitch(final Map<AnalysisElement, Result> results, final Result somResult) {
			this.results = results;
			this.somResult = somResult;
		}

		private void attachResult(final AnalysisElement analysisElement, final String label, final InstanceObject instanceObject) {
			final Result newResult = ResultUtil.createResult(label, instanceObject, ResultType.SUCCESS);
			results.get(analysisElement.eContainer()).getSubResults().add(newResult);
			results.put(analysisElement, newResult);
		}

		@Override
		public Nothing caseConnection(final Connection connection) {
			final ConnectionInstance connectionInstance = connection.getConnectionInstance();
			attachResult(connection, connectionInstance.getName(), connectionInstance);

			return Nothing.NONE;
		}

		@Override
		public Nothing caseBroadcast(final Broadcast broadcast) {
			final ConnectionInstanceEnd cie = broadcast.getSource();
			attachResult(broadcast, "Broadcast from " + cie.getInstanceObjectPath(), cie);

			return Nothing.NONE;
		}

		@Override
		public Nothing caseBusOrVirtualBus(final BusOrVirtualBus bus) {
			final ComponentInstance busInstance = bus.getBusInstance();
			attachResult(bus, busInstance.getName(), busInstance);

			// Increment the data overhead
			final EObject parent = bus.eContainer();
			final double parentOverhead = parent instanceof BusLoadModel ? 0.0
					: ((BusOrVirtualBus) parent).getDataOverhead();
			final double localOverheadKBytesps = PropertyUtils
					.getScaled(MemoryProperties::getDataSize, busInstance, SizeUnits.KBYTE).orElse(0.0);
			bus.setDataOverhead(parentOverhead + localOverheadKBytesps);

			return Nothing.NONE;
		}

		@Override
		public Nothing caseBusLoadModel(final BusLoadModel busLoadModel) {
			results.put(busLoadModel, somResult);
			return Nothing.NONE;
		}
	}

	private static final class CapacityAndBudgetPostOrderSwitch extends BusloadSwitch<Nothing> {
		private final Map<AnalysisElement, Result> results;

		public CapacityAndBudgetPostOrderSwitch(final Map<AnalysisElement, Result> results) {
			this.results = results;
		}

		private double getOverhead(final EObject analysisElement) {
			if (analysisElement instanceof BusOrVirtualBus) {
				return ((BusOrVirtualBus) analysisElement).getDataOverhead();
			} else {
				return getOverhead(analysisElement.eContainer());
			}
		}

		private Result getResult(final AnalysisElement analysisElement) {
			return results.get(analysisElement);
		}

		@Override
		public Nothing caseConnection(final Connection connection) {
			final ConnectionInstance connectionInstance = connection.getConnectionInstance();
			final double dataOverheadKBytes = getOverhead(connection);
			final Result connectionResult = getResult(connection);

			final double actual = getConnectionActualKBytesps(connectionInstance.getSource(), dataOverheadKBytes);
			connection.setActual(actual);

			final double budget = PropertyUtils
					.getScaled(Sei::getBandwidthbudget, connectionInstance, DataRateUnits.KBYTESPS)
					.orElse(0.0);
			connection.setBudget(budget);

			ResultUtil.addRealValue(connectionResult, budget);
			ResultUtil.addRealValue(connectionResult, actual);

			if (budget > 0.0) {
				if (actual > budget) {
					ResultUtil.addError(connectionResult, connectionInstance, "Connection " + connectionInstance.getName()
					+ " -- Actual bandwidth > budget: " + actual + " KB/s > " + budget + " KB/s");
				}
			} else {
				ResultUtil.addWarning(connectionResult, connectionInstance, "Connection " + connectionInstance.getName() + " has no bandwidth budget");
			}

			return Nothing.NONE;
		}

		@Override
		public Nothing caseBroadcast(final Broadcast broadcast) {
			final double dataOverheadKBytes = getOverhead(broadcast);
			final Result broadcastResult = getResult(broadcast);

			// Compute the actual usage and budget requirements
			final double actual = getConnectionActualKBytesps(broadcast.getSource(), dataOverheadKBytes);
			broadcast.setActual(actual);

			// Use the maximum budget from the connections, warn if they are not equal
			double maxBudget = 0.0;
			boolean unequal = false;
			Connection last = null;
			for (final Connection c : broadcast.getConnections()) {
				final double current = c.getBudget();
				maxBudget = Math.max(maxBudget, current);
				if (last != null) {
					unequal = last.getBudget() != current;
				}
				last = c;
			}
			broadcast.setBudget(maxBudget);

			ResultUtil.addRealValue(broadcastResult, maxBudget);
			ResultUtil.addRealValue(broadcastResult, actual);

			if (unequal) {
				for (final Connection c : broadcast.getConnections()) {
					ResultUtil.addWarning(broadcastResult, c.getConnectionInstance(), "Connection " + c.getConnectionInstance().getName() + " sharing broadcast source "
					+ broadcast.getSource().getInstanceObjectPath() + " has budget " + c.getBudget()
					+ " KB/s; using maximum");
				}
			}

			return Nothing.NONE;
		}

		@Override
		public Nothing caseBusOrVirtualBus(final BusOrVirtualBus bus) {
			final long myDataOverheadInBytes = (long) (1000.0 * bus.getDataOverhead());
			final Result busResult = getResult(bus);

			// Compute the actual usage and budget requirements
			double actual = 0.0;
			double totalBudget = 0.0;

			for (final VirtualBus vb : bus.getBoundVirtualBuses()) {
				actual += vb.getActual();
				totalBudget += vb.getBudget();
			}
			for (final Connection c : bus.getBoundConnections()) {
				actual += c.getActual();
				totalBudget += c.getBudget();
			}
			for (final Broadcast b : bus.getBoundBroadcasts()) {
				actual += b.getActual();
				totalBudget += b.getBudget();
			}
			bus.setActual(actual);

			final ComponentInstance busInstance = bus.getBusInstance();
			final double capacity = PropertyUtils
					.getScaled(Sei::getBandwidthcapacity, busInstance, DataRateUnits.KBYTESPS)
					.orElse(0.0);
			final double budget = PropertyUtils.getScaled(Sei::getBandwidthbudget, busInstance, DataRateUnits.KBYTESPS)
					.orElse(0.0);
			bus.setBudget(budget);

			ResultUtil.addRealValue(busResult, capacity);
			ResultUtil.addRealValue(busResult, budget);
			ResultUtil.addRealValue(busResult, totalBudget);
			ResultUtil.addRealValue(busResult, actual);
			ResultUtil.addIntegerValue(busResult, bus.getBoundVirtualBuses().size());
			ResultUtil.addIntegerValue(busResult, bus.getBoundConnections().size());
			ResultUtil.addIntegerValue(busResult, bus.getBoundBroadcasts().size());
			ResultUtil.addIntegerValue(busResult, myDataOverheadInBytes);

			if (capacity == 0.0) {
				ResultUtil.addWarning(busResult, busInstance, getLabel(bus) + busInstance.getName() + " has no capacity");
			} else {
				if (actual > capacity) {
					ResultUtil.addError(busResult, busInstance, getLabel(bus) + busInstance.getName()
					+ " -- Actual bandwidth > capacity: " + actual + " KB/s > " + capacity + " KB/s");
				}
			}

			if (budget == 0.0) {
				ResultUtil.addWarning(busResult, busInstance, getLabel(bus) + busInstance.getName()
				+ " has no bandwidth budget");
			} else {
				if (budget > capacity) {
					ResultUtil.addError(busResult, busInstance, getLabel(bus) + busInstance.getName()
					+ " -- budget > capacity: " + budget + " KB/s > " + capacity + " KB/s");
				}
				if (totalBudget > budget) {
					ResultUtil.addError(busResult, busInstance, getLabel(bus) + busInstance.getName()
					+ " -- Required budget > budget: " + totalBudget + " KB/s > " + budget + " KB/s");
				}
			}

			return Nothing.NONE;
		}

		private static String getLabel(final BusOrVirtualBus bus) {
			return bus instanceof Bus ? "Bus " : "Virtual bus ";
		}
	}

	// ==== Adapter classes ===


	// ==== Helper methods for the visitor ===

	/**
	 * Calculate bandwidth demand from rate & data size
	 * @param ci The connection instance to calculate for
	 * @param dataOverheadKBytes The current data overhead from bound buses expressed in KB/s.  This is applied to
	 * the connections message size.
	 */
	private static double getConnectionActualKBytesps(final ConnectionInstanceEnd cie,
			final double dataOverheadKBytes) {
		double actualDataRate = 0;
		if (cie instanceof FeatureInstance) {
			final FeatureInstance fi = (FeatureInstance) cie;
			final double datasize = dataOverheadKBytes
					+ PropertyUtils.getScaled(MemoryProperties::getDataSize, fi, SizeUnits.KBYTE).orElseGet(
							() -> PropertyUtils.getScaled(MemoryProperties::getSourceDataSize, fi, SizeUnits.KBYTE)
									.orElse(0.0));
			final double srcRate = getOutgoingMessageRatePerSecond(fi);
			actualDataRate = datasize * srcRate;
		}
		return actualDataRate;
	}

	private static double getOutgoingMessageRatePerSecond(final FeatureInstance fi) {
		return PropertyUtils.getScaled(Sei::getDataRate, fi, DataRate.PERSECOND)
				.orElseGet(
						() -> PropertyUtils.getScaled(Sei::getMessageRate, fi, MessageRate.PERSECOND).orElseGet(() -> {
					// Try to get rate from the OUTPUT_RATE record
					final Classifier containingClassifier = fi.getContainingClassifier();
					return CommunicationProperties.getOutputRate(fi).map(rateSpec -> {
						final double maxDataRate = rateSpec.getValueRange().map(rr -> rr.getMaximum()).orElse(0.0);
						return rateSpec.getRateUnit().filter(x -> x == RateUnit_FieldType.PERDISPATCH).map(ignore -> {
							final double period = getPeriodInSeconds(
									((InstanceObject) fi).getContainingComponentInstance());
							return period == 0.0 ? 0.0 : maxDataRate / period;
						}).orElseGet(() -> {
							if (maxDataRate > 0.0) {
								return maxDataRate;
							} else {
								// unit is PERSECOND, but the max data rate is missing, so try the period from the containing classifier
								double period = getPeriodInSeconds(containingClassifier);
								return period == 0.0 ? 0.0 : 1.0 / period;
							}
						});
					}).orElseGet(
							// Cannot get rate from the FeatureInstance, try the period of the containing classifier
							() -> {
								double period = getPeriodInSeconds(containingClassifier);
								return period == 0.0 ? 0.0 : 1.0 / period;
							});
				}));
	}

	private static double getPeriodInSeconds(final NamedElement containingClassifier) {
		return PropertyUtils.getScaled(TimingProperties::getPeriod, containingClassifier,
				TimeUnits.SEC).orElse(0.0);
	}

	@SuppressWarnings("unused")
	private static void print(final PrintWriter pw, final BusLoadModel busLoadModel) {
		final Map<AnalysisElement, String> indents = new HashMap<>();
		AnalysisModelTraversal.preOrder(busLoadModel, new BusloadSwitch<Nothing>() {
			private String getIndent(final AnalysisElement analysisElement) {
				return indents.get(analysisElement.eContainer());
			}

			@Override
			public Nothing caseConnection(final Connection c) {
				String prefix = getIndent(c);
				pw.println(prefix + "Connection " + c.getConnectionInstance().getName());
				prefix = prefix + "  ";
				pw.println(prefix + "Budget = " + c.getBudget() + " KB/s");
				pw.println(prefix + "Actual usage = " + c.getActual() + " KB/s");
				indents.put(c, prefix);
				return Nothing.NONE;
			}

			@Override
			public Nothing caseBroadcast(final Broadcast b) {
				String prefix = getIndent(b);
				pw.println(prefix + "Broadcast from " + b.getSource().getName());
				prefix = prefix + "  ";
				pw.println(prefix + "Budget = " + b.getBudget() + " KB/s");
				pw.println(prefix + "Actual usage = " + b.getActual() + " KB/s");
				indents.put(b, prefix);
				return Nothing.NONE;
			}

			@Override
			public Nothing caseBus(final Bus b) {
				String prefix = getIndent(b);
				pw.println(prefix + "Bus " + b.getBusInstance().getName());
				prefix = prefix + "  ";
				pw.println(prefix + "Budget = " + b.getBudget() + " KB/s");
				pw.println(prefix + "Actual usage = " + b.getActual() + " KB/s");
				pw.println(prefix + "Data overhead = " + (int) (b.getDataOverhead() * 1000.0) + " bytes");
				indents.put(b, prefix);
				return Nothing.NONE;
			}

			@Override
			public Nothing caseVirtualBus(final VirtualBus b) {
				String prefix = getIndent(b);
				pw.println(prefix + "Virtual Bus " + b.getBusInstance().getName());
				prefix = prefix + "  ";
				pw.println(prefix + "Budget = " + b.getBudget() + " KB/s");
				pw.println(prefix + "Actual usage = " + b.getActual() + " KB/s");
				pw.println(prefix + "Data overhead = " + (int) (b.getDataOverhead() * 1000.0) + " bytes");
				indents.put(b, prefix);
				return Nothing.NONE;
			}

			@Override
			public Nothing caseBusLoadModel(final BusLoadModel m) {
				indents.put(m, "");
				return Nothing.NONE;
			}
		}, null);
		pw.flush();
	}
}

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
package org.osate.analysis.resource.budgets.logic;

import java.util.Iterator;
import java.util.function.Function;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.analysis.resource.budgets.busload.NewBusLoadAnalysis;
import org.osate.ui.dialogs.Dialog;
import org.osate.ui.handlers.AbstractAaxlHandler;
import org.osate.xtext.aadl2.properties.util.AadlProject;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

/**
 * @since 2.0
 * @deprecated Use {@link NewBusLoadAnalysis} instead. Will be removed in 2.8.
 */
@Deprecated
public class BusLoadAnalysis extends AbstractLoggingAnalysis {
	private final String actionName;

	public BusLoadAnalysis(final String actionName, final AbstractAaxlHandler errManager) {
		super(errManager);
		this.actionName = actionName;
	}

	public void analysisBody(final IProgressMonitor monitor, final Element obj) {
		if (obj instanceof InstanceObject) {
			SystemInstance root = ((InstanceObject) obj).getSystemInstance();
			monitor.beginTask(actionName, IProgressMonitor.UNKNOWN);
			final SOMIterator soms = new SOMIterator(root);
			while (soms.hasNext()) {
				final SystemOperationMode som = soms.nextSOM();
				checkBusLoads(root, som);
			}
			monitor.done();
		} else {
			Dialog.showError("Bound Bus Bandwidth Analysis Error", "Can only check system instances");
		}
	}

	private void checkBusLoads(SystemInstance si, final SystemOperationMode som) {
		errManager.infoSummaryReportOnly(si, null, "\nBus Summary Report: " + Aadl2Util.getPrintableSOMName(som));
		ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(final Element obj) {
				final ComponentInstance ci = (ComponentInstance) obj;
				final ComponentCategory cat = ci.getCategory();
				if (cat == ComponentCategory.BUS) {
					checkBusBandWidthLoad(ci, som);
				} else if (cat == ComponentCategory.VIRTUAL_BUS) {
					checkVirtualBusBandWidthLoad(ci, som);
				}
			}
		};
		mal.processPreOrderComponentInstance(si);
	}

	private void checkBusBandWidthLoad(final ComponentInstance curBus, SystemOperationMode som) {
		checkBandWidthLoad(curBus, som, b -> GetProperties.getBandWidthCapacityInKBytesps(b, 0.0), "bus", "capacity");
	}

	private void checkVirtualBusBandWidthLoad(final ComponentInstance curBus, SystemOperationMode som) {
		checkBandWidthLoad(curBus, som, b -> GetProperties.getBandWidthBudgetInKBytesps(b, 0.0), "virtual bus",
				"budget");
	}

	/**
	 * check the load from connections bound to the given bus
	 *
	 * @param curBus Component Instance of bus
	 * @param doBindings if true do bindings to all buses, if false do them only
	 *            for EtherSwitch
	 * @param somName String somName to be used in messages
	 */
	private void checkBandWidthLoad(final ComponentInstance curBus, SystemOperationMode som,
			Function<ComponentInstance, Double> getCapacityOrBudget, String busLabel, String capacityOrBudgetLabel) {
		UnitLiteral kbspsliteral = GetProperties.getKBytespsUnitLiteral(curBus);
		double busCapacityOrBudget = getCapacityOrBudget.apply(curBus);
		boolean doBroadcast = GetProperties.isBroadcastProtocol(curBus);
		double totalBandWidth = 0.0;
		EList<ConnectionInstance> budgetedConnections = InstanceModelUtil.getBoundConnections(curBus);
		EList<ComponentInstance> budgetedVBs = InstanceModelUtil.getBoundVirtualBuses(curBus);

		// filters out to use only Port connections or feature group connections
		// it also tries to be smart about not double accounting for budgets on FG that now show for every port instance inside.
		budgetedConnections = filterInMode(budgetedConnections, som);
		if (doBroadcast) {
			budgetedConnections = filterSameSourceConnections(budgetedConnections);
		}
		budgetedVBs = filterInMode(budgetedVBs, som);

		if (busCapacityOrBudget == 0) {
			if (!budgetedConnections.isEmpty() || !budgetedVBs.isEmpty()) {
				errManager.errorSummary(curBus, null,
						"  " + curBus.getComponentInstancePath() + " has no " + capacityOrBudgetLabel
								+ " but has bound connections or virtual buses");
			} else {
				errManager.warningSummary(curBus, null,
						"  " + curBus.getComponentInstancePath() + " has no " + capacityOrBudgetLabel
								+ " and no demand");
			}
			return;
		}
		if (budgetedConnections.isEmpty() && budgetedVBs.isEmpty()) {
			errManager.infoSummary(curBus, null,
					"  " + curBus.getComponentInstancePath() + " with bandwidth " + capacityOrBudgetLabel + " "
					+ busCapacityOrBudget + " " + kbspsliteral.getName() + " has no bound connections");
			return;
		}
		if (Aadl2Util.isNoModes(som)) {
			errManager.logInfo("\n\nBudget Details for " + busLabel + " " + curBus.getFullName() + " with "
					+ capacityOrBudgetLabel + " "
					+ busCapacityOrBudget + " " + kbspsliteral.getName());
		} else {
			errManager.logInfo(
					"\n\nBudget Details for " + busLabel + " " + curBus.getFullName()
							+ Aadl2Util.getPrintableSOMName(som)
							+ " with " + capacityOrBudgetLabel + " " + busCapacityOrBudget + " "
							+ kbspsliteral.getName());
		}

		if (budgetedConnections.size() > 0) {
			errManager.logInfo("\nConnection,Budget,Actual (Data Size * Sender Rate),Note");
			for (ConnectionInstance connectionInstance : budgetedConnections) {
				double budget = 0.0;
				double actual = 0.0;

				if ((!connectionInstance.getSource().isActive(som))
						|| (!connectionInstance.getDestination().isActive(som))) {
					continue;
				}

				// we have a binding, is it to the current bus
				budget = GetProperties.getBandWidthBudgetInKBytesps(connectionInstance, 0.0);
				actual = calcBandwidthKBytesps(connectionInstance.getSource());
				String note = "";
				if (budget > 0) {
					if ((actual > 0) && (actual > budget)) {
						totalBandWidth += actual;
						note = "Actual bandwidth exceeds bandwidth budget. Using actual";
					} else {
						totalBandWidth += budget;
						note = "Using budget bandwidth";
					}
				} else {
					if (actual > 0) {
						totalBandWidth += actual;
						note = "No bandwidth budget. Using actual";
					} else {
						note = "No bandwidth budget or actual bandwidth from port data size&rate";
					}
				}
				detailedLog(connectionInstance, budget, actual, note);
			}
		}

		if (budgetedVBs.size() > 0) {
			errManager.logInfo("\nVirtual Bus,Budget,Note");
			for (ComponentInstance componentInstance : budgetedVBs) {
				double budget = 0.0;

				// we have a binding, is it to the current bus
				budget = GetProperties.getBandWidthBudgetInKBytesps(componentInstance, 0.0);
				if (budget > 0) {
					totalBandWidth += budget;
				}
				detailedLog(componentInstance, budget, "See separate virtual bus entry");
			}
		}

		detailedLogTotal2(null, totalBandWidth, kbspsliteral);
		if (totalBandWidth > busCapacityOrBudget) {
			errManager.errorSummary(curBus, null,
					curBus.getComponentInstancePath() + " bandwidth capacity " + busCapacityOrBudget + " "
							+ kbspsliteral.getName() + " exceeded by connection bandwidth budget totals "
							+ totalBandWidth + " " + kbspsliteral.getName());
		} else if (totalBandWidth > 0.0) {
			errManager.infoSummary(curBus, null,
					curBus.getComponentInstancePath() + " bandwidth capacity " + busCapacityOrBudget + " "
							+ kbspsliteral.getName() + " sufficient for connection bandwidth budget totals "
							+ totalBandWidth + " " + kbspsliteral.getName());
		} else {
			errManager.warningSummary(curBus, null, curBus.getComponentInstancePath() + " bandwidth capacity "
					+ busCapacityOrBudget + " " + kbspsliteral.getName() + " and bound connections without bandwidth budget");
		}
	}

	private <E extends InstanceObject> EList<E> filterInMode(EList<E> instanceObjects,
			SystemOperationMode som) {
		EList<E> result = new BasicEList<E>();
		for (E io : instanceObjects) {
			if (io.isActive(som)) {
				result.add(io);
			}
		}
		return result;
	}

	private EList<ConnectionInstance> filterSameSourceConnections(EList<ConnectionInstance> connections) {
		EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();
		for (ConnectionInstance conni : connections) {
			if (!hasConnectionSource(result, conni)) {
				result.add(conni);
			}
		}
		return result;
	}

	/**
	 * Calculate bandwidth demand from rate & data size
	 *
	 * @param pci Port connection instance
	 * @return
	 */
	private double calcBandwidthKBytesps(ConnectionInstanceEnd cie) {
		double res = 0;

		// TODO-LW add other cases
		if (cie instanceof FeatureInstance) {
			FeatureInstance fi = (FeatureInstance) cie;
			double datasize = GetProperties.getSourceDataSize(fi, GetProperties.getKBUnitLiteral(fi));
			double srcRate = GetProperties.getOutgoingMessageRatePerSecond(fi);
			res = datasize * srcRate;
			EList<FeatureInstance> fil = fi.getFeatureInstances();
			if (fil.size() > 0) {
				double subres = 0;
				for (Iterator<FeatureInstance> it = fil.iterator(); it.hasNext();) {
					FeatureInstance sfi = it.next();
					subres = subres + calcBandwidthKBytesps(sfi);
				}
				if (subres > res) {
					if (res > 0) {
						errManager.warningSummary(fi, null, "Bandwidth of feature group ports " + subres
								+ " exceeds feature group bandwidth " + res);
					}
					res = subres;
				}
			}
		}
		return res;
	}

	private boolean hasConnectionSource(EList<ConnectionInstance> connections, ConnectionInstance conni) {
		ConnectionInstanceEnd src = conni.getSource();
		for (ConnectionInstance connectionInstance : connections) {
			if (connectionInstance.getSource() == src) {
				return true;
			}
		}
		return false;

	}

	/**
	 * @since 3.0
	 */
	protected void detailedLog(InstanceObject obj, double budget, String msg) {
		String budgetmsg = budget + " " + AadlProject.KBYTESPS_LITERAL + ",";
		String objname = (obj instanceof ConnectionInstance) ? obj.getFullName()
				: ((ComponentInstance) obj).getComponentInstancePath();
		errManager.logInfo(objname + ", " + budgetmsg + msg);
	}
}
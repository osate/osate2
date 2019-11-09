/*
 * <copyright>
 * Copyright  2006 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
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
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.analysis.resource.budgets.logic;

import java.util.Iterator;

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
import org.osate.ui.dialogs.Dialog;
import org.osate.ui.handlers.AbstractAaxlHandler;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

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
			protected void process(Element obj) {
				checkBandWidthLoad((ComponentInstance) obj, som);
			}
		};
		mal.processPreOrderComponentInstance(si, ComponentCategory.BUS);
	}
	
	/**
	 * check the load from connections bound to the given bus
	 * 
	 * @param curBus Component Instance of bus
	 * @param doBindings if true do bindings to all buses, if false do them only
	 *            for EtherSwitch
	 * @param somName String somName to be used in messages
	 */
	private void checkBandWidthLoad(final ComponentInstance curBus, SystemOperationMode som) {
		UnitLiteral kbspsliteral = GetProperties.getKBytespsUnitLiteral(curBus);
		double Buscapacity = GetProperties.getBandWidthCapacityInKBytesps(curBus, 0.0);
		boolean doBroadcast = GetProperties.isBroadcastProtocol(curBus);
		double totalBandWidth = 0.0;
		EList<ConnectionInstance> budgetedConnections = InstanceModelUtil.getBoundConnections(curBus);

		// filters out to use only Port connections or feature group connections
		// it also tries to be smart about not double accounting for budgets on FG that now show for every port instance inside.

		budgetedConnections = filterInModeConnections(budgetedConnections, som);
		if (doBroadcast) {
			budgetedConnections = filterSameSourceConnections(budgetedConnections);
		}
		if (Buscapacity == 0) {
			if (!budgetedConnections.isEmpty()) {
				errManager.errorSummary(curBus, null,
						"  " + curBus.getComponentInstancePath() + " has no capacity but bound connections");
			} else {
				errManager.warningSummary(curBus, null,
						"  " + curBus.getComponentInstancePath() + " has no capacity and no demand");
			}
			return;
		}
		if (budgetedConnections.isEmpty()) {
			errManager.infoSummary(curBus, null, "  " + curBus.getComponentInstancePath() + " with bandwidth capacity "
					+ Buscapacity + " " + kbspsliteral.getName() + " has no bound connections");
			return;
		}
		if (Aadl2Util.isNoModes(som)) {
			errManager.logInfo("\n\nConnection Budget Details for bus " + curBus.getFullName() + " with capacity "
					+ Buscapacity + " " + kbspsliteral.getName() + "\n");
		} else {
			errManager.logInfo(
					"\n\nConnection Budget Details for bus " + curBus.getFullName() + Aadl2Util.getPrintableSOMName(som)
							+ " with capacity " + Buscapacity + " " + kbspsliteral.getName() + "\n");
		}

		errManager.logInfo("Connection,Budget,Actual (Data Size * Sender Rate),Note");
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
		detailedLogTotal2(null, totalBandWidth, kbspsliteral);
		if (totalBandWidth > Buscapacity) {
			errManager.errorSummary(curBus, null,
					curBus.getComponentInstancePath() + " bandwidth capacity " + Buscapacity + " "
							+ kbspsliteral.getName() + " exceeded by connection bandwidth budget totals "
							+ totalBandWidth + " " + kbspsliteral.getName());
		} else if (totalBandWidth > 0.0) {
			errManager.infoSummary(curBus, null,
					curBus.getComponentInstancePath() + " bandwidth capacity " + Buscapacity + " "
							+ kbspsliteral.getName() + " sufficient for connection bandwidth  budget totals "
							+ totalBandWidth + " " + kbspsliteral.getName());
		} else {
			errManager.warningSummary(curBus, null, curBus.getComponentInstancePath() + " bandwidth capacity "
					+ Buscapacity + " " + kbspsliteral.getName() + " and bound connections without bandwidth budget");
		}
	}
	
	private EList<ConnectionInstance> filterInModeConnections(EList<ConnectionInstance> connections,
			SystemOperationMode som) {
		EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();
		for (ConnectionInstance conni : connections) {
			if (conni.isActive(som)) {
				result.add(conni);
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
}
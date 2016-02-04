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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
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
import org.osate.aadl2.modelsupport.util.ConnectionGroupIterator;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.aadl2.util.OsateDebug;
import org.osate.ui.actions.AbstractAaxlAction;
import org.osate.ui.dialogs.Dialog;
import org.osate.xtext.aadl2.properties.util.AadlProject;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

//TODO-LW: assumes connection ends are features
public class DoBoundResourceAnalysisLogic extends DoResourceBudgetLogic {
	protected final String actionName;
	/**
	 * The string buffer that is used to record error messages.
	 */
	private boolean doDetailedLog = true;

	public DoBoundResourceAnalysisLogic(final String actionName, final AbstractAaxlAction errManager) {
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
				OsateDebug.osateDebug("[DoBoundResourceAnalysisLogic] Analyze mode " + som.getName());

//				final String somName = Aadl2Util.getPrintableSOMName(som);

				OsateDebug.osateDebug("[DoBoundResourceAnalysisLogic] Check Processor");
				errManager.infoSummaryReportOnly(root, som, "Processor Report");
				checkProcessorLoads(root, som);

				OsateDebug.osateDebug("[DoBoundResourceAnalysisLogic] Check Virtual Processor");
				errManager.infoSummaryReportOnly(root, som, "\nVirtual Processor Report");
				checkVirtualProcessorLoads(root, som);

				OsateDebug.osateDebug("[DoBoundResourceAnalysisLogic] Check RAM/ROM");
				errManager.infoSummaryReportOnly(root, som, "\nRAM/ROM Report");
				checkMemoryLoads(root, som);
			}
			monitor.done();

//			if (root.getSystemOperationModes().size() == 1) {
//				// Also report the results using a message dialog
//				Dialog.showInfo("Resource Budget Statistics", errManager.getResultsMessages());
//			}
		} else
			Dialog.showError("Bound Resource Analysis Error", "Can only check system instances");
	}

	protected void checkProcessorLoads(SystemInstance si, final SystemOperationMode som) {
		ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(Element obj) {
				checkProcessorLoad((ComponentInstance) obj, som);
			}
		};
		mal.processPreOrderComponentInstance(si, ComponentCategory.PROCESSOR);
	}

	protected void checkVirtualProcessorLoads(SystemInstance si, final SystemOperationMode som) {
		ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(Element obj) {
				checkProcessorLoad((ComponentInstance) obj, som);
			}
		};
		mal.processPreOrderComponentInstance(si, ComponentCategory.VIRTUAL_PROCESSOR);
	}

	/**
	 * check the load from components bound to the given processor The
	 * components can be threads or higher level components.
	 * 
	 * @param curProcessor Component Instance of processor
	 */
	protected void checkProcessorLoad(ComponentInstance curProcessor, final SystemOperationMode som) {
		boolean isCPUActive;

		if (curProcessor.getSubcomponent().getAllInModes().size() == 0) {
			isCPUActive = true;
		} else {
			isCPUActive = false;

			for (Mode mi : curProcessor.getSubcomponent().getAllInModes()) {
				// OsateDebug.osateDebug("somName=" + somName + " mi=" + mi);
				if (som.getName().equalsIgnoreCase(mi.getName())) {
					// OsateDebug.osateDebug("cpu " + curProcessor.getName() + "is active for mode" + somName);
					isCPUActive = true;
				}
			}
		}

		if (isCPUActive == false) {
			return;
		}

		UnitLiteral mipsliteral = GetProperties.getMIPSUnitLiteral(curProcessor);
		double MIPScapacity = GetProperties.getMIPSCapacityInMIPS(curProcessor, 0.0);
		if (MIPScapacity == 0 && InstanceModelUtil.isVirtualProcessor(curProcessor)) {
			MIPScapacity = GetProperties.getMIPSBudgetInMIPS(curProcessor);
		}
		long timeBefore = System.currentTimeMillis();
		OsateDebug.osateDebug("[CPU] before get sw comps (CPU=" + curProcessor.getName() + ",cat="
				+ curProcessor.getComponentClassifier().getCategory().getName() + ")");
		EList<ComponentInstance> boundComponents = InstanceModelUtil.getBoundSWComponents(curProcessor);
		long timeAfter = System.currentTimeMillis();
		long period = timeAfter - timeBefore;
		OsateDebug.osateDebug("[CPU] after get sw comps, time taken=" + period + "ms");

		if (boundComponents.size() == 0 && MIPScapacity > 0) {
			errManager.infoSummary(curProcessor, som.getName(),
					"No application components bound to " + curProcessor.getComponentInstancePath()
							+ " with MIPS capacity " + GetProperties.toStringScaled(MIPScapacity, mipsliteral));
			return;
		}
		if (MIPScapacity == 0 && InstanceModelUtil.isVirtualProcessor(curProcessor)) {
			errManager
					.warningSummary(curProcessor, som.getName(),
							"Virtual processor " + curProcessor.getComponentInstancePath()
									+ " has no MIPS capacity or budget.");
			return;
		}
		if (MIPScapacity == 0 && InstanceModelUtil.isProcessor(curProcessor)) {
			errManager.errorSummary(curProcessor, som.getName(), "Processor " + curProcessor.getComponentInstancePath()
					+ " has no MIPS capacity but has bound components.");
		}
		if (InstanceModelUtil.isVirtualProcessor(curProcessor)) {
			logHeader("\n\nDetailed Workload Report for Virtual Processor " + curProcessor.getComponentInstancePath()
					+ " with Capacity " + GetProperties.toStringScaled(MIPScapacity, mipsliteral)
					+ "\n\nComponent,Budget,Actual");
		} else {
			logHeader("\n\nDetailed Workload Report for Processor " + curProcessor.getComponentInstancePath()
					+ " with Capacity " + GetProperties.toStringScaled(MIPScapacity, mipsliteral)
					+ "\n\nComponent,Budget,Actual");
		}
		double totalMIPS = 0.0;
		for (Iterator<ComponentInstance> it = boundComponents.iterator(); it.hasNext();) {
			ComponentInstance bci = (ComponentInstance) it.next();
			boolean isComponentActive;

			if ((som == null) || (bci.getSubcomponent().getAllInModes().size() == 0)) {
				isComponentActive = true;
			} else {
				isComponentActive = false;
				for (Mode mi : bci.getSubcomponent().getAllInModes()) {
					// OsateDebug.osateDebug("somName=" + somName + " mi=" + mi);
					if (som.getName().equalsIgnoreCase(mi.getName())) {
						// OsateDebug.osateDebug("cpu " + curProcessor.getName() + "is active for mode" + somName);
						isComponentActive = true;
					}
				}
			}

			if (isComponentActive == true) {
				double actualmips = sumBudgets(bci, ResourceKind.MIPS, mipsliteral, som, "");
				if (actualmips > 0) {
					totalMIPS += actualmips;
				}
			}

		}
		logHeader("Total,," + GetProperties.toStringScaled(totalMIPS, mipsliteral));
		if (totalMIPS > MIPScapacity) {
			errManager.errorSummary(
					curProcessor,
					som.getName(),
					"Total MIPS " + GetProperties.toStringScaled(totalMIPS, mipsliteral)
							+ " of bound tasks exceeds MIPS capacity "
							+ GetProperties.toStringScaled(MIPScapacity, mipsliteral) + " of "
							+ curProcessor.getComponentInstancePath());
		} else if (totalMIPS == 0.0) {
			errManager.warningSummary(curProcessor, som.getName(), "Bound app's have no MIPS budget.");
		} else {
			errManager.infoSummary(curProcessor, som.getName(),
					"Total MIPS " + GetProperties.toStringScaled(totalMIPS, mipsliteral) + " of bound tasks within "
							+ "MIPS capacity " + GetProperties.toStringScaled(MIPScapacity, mipsliteral) + " of "
							+ curProcessor.getComponentInstancePath());
		}
	}

	protected void checkMemoryLoads(SystemInstance si, final SystemOperationMode som) {
		ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(Element obj) {
				checkMemoryLoad((ComponentInstance) obj, som);
			}
		};
		mal.processPreOrderComponentInstance(si, ComponentCategory.MEMORY);
	}

	/**
	 * check the load from components bound to the given memory The components
	 * can be threads or higher level components.
	 * 
	 * @param curMemory Component Instance of memory
	 */
	protected void checkMemoryLoad(ComponentInstance curMemory, final SystemOperationMode som) {
		SystemInstance root = curMemory.getSystemInstance();
		final ComponentInstance currentMemory = curMemory;
		final String somName = som.getName();

		long timeBefore = System.currentTimeMillis();
		OsateDebug.osateDebug("[Memory] before get sw comps (memory=" + curMemory.getName() + ")");
		EList<ComponentInstance> boundComponents = InstanceModelUtil.getBoundSWComponents(curMemory);
		long timeAfter = System.currentTimeMillis();
		long period = timeAfter - timeBefore;
		OsateDebug.osateDebug("[CPU] after get sw comps, time taken=" + period + "ms");

		if (GetProperties.getROMCapacityInKB(curMemory, 0.0) > 0.0) {
			doMemoryLoad(curMemory, somName, boundComponents, true); // ROM
		}
		if (GetProperties.getRAMCapacityInKB(curMemory, 0.0) > 0.0) {
			doMemoryLoad(curMemory, somName, boundComponents, false); // RAM
		}
	}

	/**
	 * check the load from components bound to the given memory The components
	 * can be threads or higher level components.
	 * 
	 * @param curMemory Component Instance of memory
	 */
	protected void doMemoryLoad(ComponentInstance curMemory, String somName, EList boundComponents, boolean isROM) {
		double totalMemory = 0.0;
		UnitLiteral kbliteral = GetProperties.getKBUnitLiteral(curMemory);
		String resourceName = isROM ? "ROM" : "RAM";
		double Memorycapacity = isROM ? GetProperties.getROMCapacityInKB(curMemory, 0.0) : GetProperties
				.getRAMCapacityInKB(curMemory, 0.0);
		if (boundComponents.size() == 0 && Memorycapacity > 0) {
			errManager.infoSummary(curMemory, somName,
					"No application components bound to " + curMemory.getComponentInstancePath() + " with "
							+ resourceName + " capacity " + GetProperties.toStringScaled(Memorycapacity, kbliteral));
			return;
		}
		if (Memorycapacity == 0) {
			errManager.errorSummary(curMemory, somName, "Memory " + curMemory.getComponentInstancePath() + " has no "
					+ resourceName + " capacity but has bound components.");
		}
		logHeader("\n\nDetailed Workload Report for memory " + curMemory.getComponentInstancePath() + " with Capacity "
				+ GetProperties.toStringScaled(Memorycapacity, kbliteral) + "\n\nComponent,Budget,Actual");
		Set budgeted = new HashSet();
		for (Iterator it = boundComponents.iterator(); it.hasNext();) {
			String notes = "";
			ComponentInstance bci = (ComponentInstance) it.next();
			double totalactual = sumMemoryActuals(bci, isROM);
			double budget = isROM ? GetProperties.getROMBudgetInKB(bci, 0.0) : GetProperties.getRAMBudgetInKB(bci, 0.0);
			if (totalactual > 0) {
				// only compare if there were actuals
				if (totalactual > budget) {
					notes = notes + ",Error: " + resourceName + " subtotal exceeds budget by " + (totalactual - budget)
							+ " KB";
				} else if (totalactual < budget) {
					notes = notes + ",Warning: " + resourceName + " Subtotal under budget by " + (budget - totalactual)
							+ " KB";
				}
			}
			if (totalactual == 0.0) {
				// we use a budget number as there are no actuals
				if (budget > 0 && !budgeted.contains(bci)) {
					// only add it if no children budget numbers have been added
					totalMemory += budget;
					detailedLog(bci, budget, kbliteral);
					// add ancestors to budgeted list so their budget does not get added later
					while ((bci = bci.getContainingComponentInstance()) != null) {
						budgeted.add(bci);
					}
				}
			} else {
				// add only the current actual; the children actual have been added before
				double currentActual = isROM ? GetProperties.getROMActualInKB(bci, 0.0) : GetProperties
						.getRAMActualInKB(bci, 0.0);
				detailedLog(bci, budget, kbliteral);
				totalMemory += currentActual;
			}
		}
		if (Memorycapacity == 0)
			errManager.errorSummary(curMemory, somName,
					"" + (isROM ? "ROM" : "RAM") + " memory " + curMemory.getComponentInstancePath()
							+ " has no memory capacity specified");
		if (totalMemory > Memorycapacity) {
			errManager.errorSummary(curMemory, somName,
					"Total Memory " + totalMemory + " KB of bounds tasks exceeds Memory capacity " + Memorycapacity
							+ " KB of " + curMemory.getComponentInstancePath());
		} else if (totalMemory == 0.0 && Memorycapacity == 0.0) {
			errManager.warningSummary(curMemory, somName,
					"" + (isROM ? "ROM" : "RAM") + " memory " + curMemory.getComponentInstancePath()
							+ " has no capacity. Bound app's have no memory budget.");
		} else {
			errManager.infoSummary(
					curMemory,
					somName,
					"Total " + (isROM ? "ROM" : "RAM") + " memory " + totalMemory
							+ " KB of bound tasks within Memory capacity " + Memorycapacity + " KB of "
							+ curMemory.getComponentInstancePath());
		}
	}

	protected void reportBusLoadTotals(SystemInstance si, final SystemOperationMode som) {
		if (som != null) {
			errManager.logInfo("\n\nConnection Budget Details for mode " + som.getName() + "\n");
		} else {
			errManager.logInfo("\n\nConnection Budget Details \n");
		}
		errManager.logInfo("Connection,Budget,Actual (Data Size * Sender Rate),Note");
		double budget = calcBandWidthLoad(si, som);
		errManager.logInfo("");
		errManager.infoSummary(si, Aadl2Util.getPrintableSOMName(som), "Connection bandwidth budget total: " + budget
				+ " KBytesps");
		ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(Element obj) {
				double buscapacity = GetProperties.getBandWidthCapacityInKbps((ComponentInstance) obj, 0.0);
				errManager
						.infoSummary((NamedElement) obj, Aadl2Util.getPrintableSOMName(som), "Bus "
								+ ((ComponentInstance) obj).getFullName() + " bandwidth capacity: " + buscapacity
								+ " KBytesps");
			}
		};
		mal.processPreOrderComponentInstance(si, ComponentCategory.BUS);
	}

	protected void checkBusLoads(SystemInstance si, final SystemOperationMode som) {
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
	protected double calcBandWidthLoad(SystemInstance root, final SystemOperationMode som) {
		double totalBandWidth = 0.0;
		EList<ConnectionInstance> connections = root.getAllConnectionInstances();
		EList<ConnectionInstance> budgetedConnections = new BasicEList<ConnectionInstance>();
		// filters out to use only Port connections or feature group connections
		// it also tries to be smart about not double accounting for budgets on FG that now show for every port instance inside.
		ConnectionGroupIterator cgi = new ConnectionGroupIterator(connections);
		while (cgi.hasNext()) {
			ConnectionInstance obj = cgi.next();
			if (obj != null)
				budgetedConnections.add(obj);
		}
		for (ConnectionInstance connectionInstance : budgetedConnections) {
			if ((connectionInstance.getSource().getContainingComponentInstance() != null)
					&& (!connectionInstance.getSource().getContainingComponentInstance().isActive(som))) {

				OsateDebug.osateDebug("[DoBoundResourceAnalysis] source not active in mode=" + som);
				continue;
			}

			if ((connectionInstance.getDestination().getContainingComponentInstance() != null)
					&& (!connectionInstance.getDestination().getContainingComponentInstance().isActive(som))) {
				OsateDebug.osateDebug("[DoBoundResourceAnalysis] destination not active in mode=" + som);

				continue;
			}

			OsateDebug.osateDebug("[DoBoundResourceAnalysis] source="
					+ connectionInstance.getSource().getContainingComponentInstance());

			double budget = GetProperties.getBandWidthBudgetInKbps(connectionInstance, 0.0);
			double actual = calcBandwidthKBytesps(connectionInstance.getSource());
			String note = "";
			OsateDebug.osateDebug("[DoBoundResourceAnalysis] total=" + totalBandWidth);
			OsateDebug.osateDebug("[DoBoundResourceAnalysis] actual=" + actual);
			OsateDebug.osateDebug("[DoBoundResourceAnalysis] budget=" + budget);
			if (budget > 0) {
				if ((actual > 0) && (actual > budget)) {
					totalBandWidth += actual;
					note = "Actual bandwidth exceeds bandwidth budget. Using actual";

				} else {
					note = "Using budget bandwidth";
					totalBandWidth += budget;
				}
			} else {
				if (actual > 0) {
					totalBandWidth = totalBandWidth + actual;
					note = "No bandwidth budget. Using actual";
				} else {
					note = "No bandwidth budget or actual";
				}
			}
			detailedLog(connectionInstance, budget, actual, note);

		}
		OsateDebug.osateDebug("[DoBoundResourceAnalysis] res=" + totalBandWidth);
		return totalBandWidth;
	}

	/**
	 * check the load from connections bound to the given bus
	 * 
	 * @param curBus Component Instance of bus
	 * @param doBindings if true do bindings to all buses, if false do them only
	 *            for EtherSwitch
	 * @param somName String somName to be used in messages
	 */
	protected void checkBandWidthLoad(final ComponentInstance curBus, SystemOperationMode som) {
		UnitLiteral kbspsliteral = GetProperties.getKBytespsUnitLiteral(curBus);
		double Buscapacity = GetProperties.getBandWidthCapacityInKbps(curBus, 0.0);
		boolean doBroadcast = GetProperties.isBroadcastProtocol(curBus);
		SystemInstance root = curBus.getSystemInstance();
		double totalBandWidth = 0.0;
		EList<ConnectionInstance> budgetedConnections = InstanceModelUtil.getBoundConnections(curBus);

		// filters out to use only Port connections or feature group connections
		// it also tries to be smart about not double accounting for budgets on FG that now show for every port instance inside.

		/*
		 * ConnectionGroupIterator cgi = new ConnectionGroupIterator(connections);
		 * while (cgi.hasNext())
		 * {
		 * ConnectionInstance obj = cgi.next();
		 * if (obj != null)
		 * {
		 * if (InstanceModelUtil.isBoundToBus(obj, curBus)||
		 * // we derived a bus connection from the connection end bindings
		 * (!InstanceModelUtil.hasBusBinding(obj)&&InstanceModelUtil.connectedByBus(obj, curBus)) )
		 * {
		 * if ((obj.getSource().isActive(som)) && (obj.getDestination().isActive(som)))
		 * {
		 * budgetedConnections.add(obj);
		 * }
		 * }
		 * }
		 * }
		 */
		if (doBroadcast) {
			budgetedConnections = filterSameSourceConnections(budgetedConnections);
		}
		if (Buscapacity == 0) {
			if (!budgetedConnections.isEmpty()) {
				errManager.errorSummary(curBus, som.getName(), curBus.getComponentInstancePath()
						+ " has no capacity but bound connections");
			} else {
				errManager.warningSummary(curBus, som.getName(), curBus.getComponentInstancePath()
						+ " has no capacity and no demand");
			}
			return;
		}
		if (budgetedConnections.isEmpty()) {
			errManager.infoSummary(curBus, som.getName(), curBus.getComponentInstancePath()
					+ " with bandwidth capacity " + Buscapacity + "KBytesps has no bound connections");
			return;
		}
		if (Aadl2Util.isNoModes(som)) {
			errManager.logInfo("\n\nConnection Budget Details for bus " + curBus.getFullName() + " with capacity "
					+ Buscapacity + "KBytesps\n");
		} else {
			errManager.logInfo("\n\nConnection Budget Details for bus " + curBus.getFullName() + " in mode "
					+ som.getName() + " with capacity " + Buscapacity + "KBytesps\n");
		}

		errManager.logInfo("Connection,Budget,Actual (Data Size * Sender Rate),Note");
		for (ConnectionInstance connectionInstance : budgetedConnections) {
			double budget = 0.0;
			double actual = 0.0;

			if ((!connectionInstance.getSource().isActive(som)) || (!connectionInstance.getDestination().isActive(som))) {
				continue;
			}

			// we have a binding, is it to the current bus
			budget = GetProperties.getBandWidthBudgetInKbps(connectionInstance, 0.0);
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
		detailedLog(null, totalBandWidth, kbspsliteral);
		if (totalBandWidth > Buscapacity) {
			errManager.errorSummary(curBus, som.getName(), curBus.getComponentInstancePath() + " bandwidth capacity "
					+ Buscapacity + " KBytesps exceeded by connection bandwidth budget totals " + totalBandWidth
					+ " Kbps");
		} else if (totalBandWidth > 0.0) {
			errManager.infoSummary(curBus, som.getName(), curBus.getComponentInstancePath() + " bandwidth capacity "
					+ Buscapacity + " KBytesps sufficient for connection bandwidth  budget totals " + totalBandWidth
					+ " Kbps");
		} else {
			errManager.warningSummary(curBus, som.getName(), curBus.getComponentInstancePath() + " bandwidth capacity "
					+ Buscapacity + " KBytesps and bound connections without bandwidth budget");
		}
	}

	/**
	 * Calculate bandwidth demand from rate & data size
	 * 
	 * @param pci Port connection instance
	 * @return
	 */

	protected double calcBandwidthKBytesps(ConnectionInstanceEnd cie) {
		double res = 0;

		// TODO-LW add other cases
		if (cie instanceof FeatureInstance) {
			FeatureInstance fi = (FeatureInstance) cie;
			double datasize = GetProperties.getSourceDataSize(fi, GetProperties.getKBUnitLiteral(fi));
			double srcRate = GetProperties.getOutgoingMessageRatePerSecond(fi);
			res = datasize * srcRate;
			EList fil = fi.getFeatureInstances();
			if (fil.size() > 0) {
				double subres = 0;
				for (Iterator it = fil.iterator(); it.hasNext();) {
					FeatureInstance sfi = (FeatureInstance) it.next();
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

	/*
	 * are processors of connection endpoints the same and are connected to the
	 * current bus
	 */
	protected boolean hasSwitchLoopback(ConnectionInstance pci, ComponentInstance curBus) {
		ComponentInstance srcHW = InstanceModelUtil.getHardwareComponent(pci.getSource());
		ComponentInstance dstHW = InstanceModelUtil.getHardwareComponent(pci.getDestination());
		if (srcHW == null || dstHW == null)
			return false;
		if (srcHW == dstHW && InstanceModelUtil.connectedToBus(srcHW, curBus)) {
			return true;
		}
		return false;
	}

	protected double sumMemoryActuals(ComponentInstance ci, boolean isROM) {
		try {
			double total = isROM ? GetProperties.getROMActualInKB(ci, 0.0) : GetProperties.getRAMActualInKB(ci, 0.0);
			EList subcis = ci.getComponentInstances();
			for (Iterator it = subcis.iterator(); it.hasNext();) {
				ComponentInstance subci = (ComponentInstance) it.next();
				total += sumMemoryActuals(subci, isROM);
			}
			return total;
		} catch (PropertyDoesNotApplyToHolderException e) {
			/*
			 * Callers are allowed to be sloppy and not care if the property
			 * actually applies to the category of the component instance 'ci'
			 */
			return 0.0;
		}
	}

	protected void detailedLog(InstanceObject obj, double budget, double actual, String msg) {
		if (doDetailedLog) {
			String budgetmsg = budget + " " + AadlProject.KBYTESPS_LITERAL + ",";
			String actualmsg = actual + " " + AadlProject.KBYTESPS_LITERAL + ",";
			String objname = (obj instanceof ConnectionInstance) ? obj.getFullName() : ((ComponentInstance) obj)
					.getComponentInstancePath();
			errManager.logInfo(obj.getFullName() + ", " + budgetmsg + actualmsg + msg);
		}

	}

	protected EList<ConnectionInstance> filterSameSourceConnections(EList<ConnectionInstance> connections) {
		EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();
		for (ConnectionInstance conni : connections) {
			if (!hasConnectionSource(result, conni)) {
				result.add(conni);
			}
		}
		return result;
	}

	protected boolean hasConnectionSource(EList<ConnectionInstance> connections, ConnectionInstance conni) {
		ConnectionInstanceEnd src = conni.getSource();
		for (ConnectionInstance connectionInstance : connections) {
			if (connectionInstance.getSource() == src) {
				return true;
			}
		}
		return false;

	}
}
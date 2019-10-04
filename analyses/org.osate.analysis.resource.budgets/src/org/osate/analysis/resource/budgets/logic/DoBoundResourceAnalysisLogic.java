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
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.ui.dialogs.Dialog;
import org.osate.ui.handlers.AbstractAaxlHandler;
import org.osate.xtext.aadl2.properties.util.AadlProject;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

//TODO-LW: assumes connection ends are features
public class DoBoundResourceAnalysisLogic {
	private int components = 0;
	private int budgetedComponents = 0;
	private final AbstractAaxlHandler errManager;
	private final boolean doDetailedLog = true;
	private final String prefixSymbol = "  ";
	
	private final String actionName;

	private int count = 0;

	public DoBoundResourceAnalysisLogic(final String actionName, final AbstractAaxlHandler errManager) {
		this.errManager = errManager;
		this.actionName = actionName;
	}

	public void analysisBody(final IProgressMonitor monitor, final Element obj) {
		if (obj instanceof InstanceObject) {
			SystemInstance root = ((InstanceObject) obj).getSystemInstance();
			monitor.beginTask(actionName, IProgressMonitor.UNKNOWN);
			final SOMIterator soms = new SOMIterator(root);
			while (soms.hasNext()) {
				final SystemOperationMode som = soms.nextSOM();

				checkProcessorLoads(root, som);

				checkVirtualProcessorLoads(root, som);

				checkMemoryLoads(root, som);
			}
			monitor.done();

		} else
			Dialog.showError("Bound Resource Analysis Error", "Can only check system instances");
	}

	private void checkProcessorLoads(SystemInstance si, final SystemOperationMode som) {
		count = 0;
		ForAllElement countme = new ForAllElement() {
			@Override
			protected void process(Element obj) {
				count = count + 1;
			}
		};
		countme.processPreOrderComponentInstance(si, ComponentCategory.PROCESSOR);
		if (count > 0) {
			errManager.infoSummaryReportOnly(si, null,
					"\nProcessor Summary Report: " + Aadl2Util.getPrintableSOMName(som));
		} else {
			errManager.infoSummaryReportOnly(si, null,
					"\nProcessor Summary Report: " + Aadl2Util.getPrintableSOMName(som) + "\n  ** No processors");
		}
		ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(Element obj) {
				checkProcessorLoad((ComponentInstance) obj, som);
			}
		};
		mal.processPreOrderComponentInstance(si, ComponentCategory.PROCESSOR);
	}

	private void checkVirtualProcessorLoads(SystemInstance si, final SystemOperationMode som) {
		count = 0;
		ForAllElement countme = new ForAllElement() {
			@Override
			protected void process(Element obj) {
				count = count + 1;
			}
		};
		countme.processPreOrderComponentInstance(si, ComponentCategory.VIRTUAL_PROCESSOR);
		if (count > 0) {
			errManager.infoSummaryReportOnly(si, null,
					"\nVirtual Processor Summary Report: " + Aadl2Util.getPrintableSOMName(som));
		}
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
	private void checkProcessorLoad(ComponentInstance curProcessor, final SystemOperationMode som) {

		if (!curProcessor.isActive(som)) {
			return;
		}

		UnitLiteral mipsliteral = GetProperties.getMIPSUnitLiteral(curProcessor);
		double MIPScapacity = GetProperties.getMIPSCapacityInMIPS(curProcessor, 0.0);
		if (MIPScapacity == 0 && InstanceModelUtil.isVirtualProcessor(curProcessor)) {
			MIPScapacity = GetProperties.getMIPSBudgetInMIPS(curProcessor);
		}
		EList<ComponentInstance> boundComponents = InstanceModelUtil.getBoundSWComponents(curProcessor);

		if (boundComponents.size() == 0 && MIPScapacity > 0) {
			errManager.infoSummary(curProcessor, som.getName(),
					"No application components bound to " + curProcessor.getComponentInstancePath()
							+ " with MIPS capacity " + GetProperties.toStringScaled(MIPScapacity, mipsliteral));
			return;
		}
		if (MIPScapacity == 0 && InstanceModelUtil.isVirtualProcessor(curProcessor)) {
			errManager.warningSummary(curProcessor, som.getName(), "Virtual processor "
					+ curProcessor.getComponentInstancePath() + " has no MIPS capacity or budget.");
			return;
		}
		if (MIPScapacity == 0 && InstanceModelUtil.isProcessor(curProcessor)) {
			errManager.errorSummary(curProcessor, som.getName(), "Processor " + curProcessor.getComponentInstancePath()
					+ " has no MIPS capacity but has bound components.");
		}
		if (InstanceModelUtil.isVirtualProcessor(curProcessor)) {
			logHeader("\n\nDetailed Workload Report: " + Aadl2Util.getPrintableSOMName(som) + " for Virtual Processor "
					+ curProcessor.getComponentInstancePath() + " with Capacity "
					+ GetProperties.toStringScaled(MIPScapacity, mipsliteral) + "\n\nComponent,Budget,Actual");
		} else {
			logHeader("\n\nDetailed Workload Report: " + Aadl2Util.getPrintableSOMName(som) + " for Processor "
					+ curProcessor.getComponentInstancePath() + " with Capacity "
					+ GetProperties.toStringScaled(MIPScapacity, mipsliteral) + "\n\nComponent,Budget,Actual");
		}
		double totalMIPS = 0.0;
		for (Iterator<ComponentInstance> it = boundComponents.iterator(); it.hasNext();) {
			ComponentInstance bci = it.next();

			double actualmips = sumBudgets(bci, ResourceKind.MIPS, mipsliteral, som, "");
			if (actualmips > 0) {
				totalMIPS += actualmips;
			}
		}
		logHeader("Total,," + GetProperties.toStringScaled(totalMIPS, mipsliteral));
		if (totalMIPS > MIPScapacity) {
			errManager.errorSummary(curProcessor, null,
					"  Processor " + curProcessor.getComponentInstancePath() + ": Total MIPS "
							+ GetProperties.toStringScaled(totalMIPS, mipsliteral)
							+ " of bound tasks exceeds MIPS capacity "
							+ GetProperties.toStringScaled(MIPScapacity, mipsliteral));
		} else if (totalMIPS == 0.0) {
			errManager.warningSummary(curProcessor, null,
					"  Processor " + curProcessor.getComponentInstancePath() + ": Bound app's have no MIPS budget.");
		} else {
			errManager.infoSummary(curProcessor, null,
					"  Processor " + curProcessor.getComponentInstancePath() + ": Total MIPS "
							+ GetProperties.toStringScaled(totalMIPS, mipsliteral) + " of bound tasks within "
							+ "MIPS capacity " + GetProperties.toStringScaled(MIPScapacity, mipsliteral) + " of "
							+ curProcessor.getComponentInstancePath());
		}
	}

	private void checkMemoryLoads(SystemInstance si, final SystemOperationMode som) {
		count = 0;
		ForAllElement countme = new ForAllElement() {
			@Override
			protected void process(Element obj) {
				if (GetProperties.getROMCapacityInKB((InstanceObject) obj, 0.0) > 0.0
						|| GetProperties.getRAMCapacityInKB((InstanceObject) obj, 0.0) > 0.0
						|| GetProperties.getMemorySizeInKB((InstanceObject) obj) > 0.0) {
					count = count + 1;
				}
			}
		};
		countme.processPreOrderComponentInstance(si, ComponentCategory.MEMORY);
		if (count > 0) {
			errManager.infoSummaryReportOnly(si, null,
					"\nMemory Summary Report: " + Aadl2Util.getPrintableSOMName(som));
		} else {
			errManager.infoSummaryReportOnly(si, null, "\nMemory Summary Report: " + Aadl2Util.getPrintableSOMName(som)
					+ "\n  No Memory with Memory_Size or RAMCapacity or ROMCapacity");
		}
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
	private void checkMemoryLoad(ComponentInstance curMemory, final SystemOperationMode som) {
		UnitLiteral kbliteral = GetProperties.getKBUnitLiteral(curMemory);
		EList<ComponentInstance> boundComponents = InstanceModelUtil.getBoundSWComponents(curMemory);
		double MemoryCapacity = GetProperties.getMemorySize(curMemory, kbliteral);
		double ROMCapacity = GetProperties.getROMCapacityInKB(curMemory, 0.0);
		double RAMCapacity = GetProperties.getRAMCapacityInKB(curMemory, 0.0);

		if (MemoryCapacity > 0.0) {
			doMemoryLoad(curMemory, som, MemoryCapacity, boundComponents, ResourceKind.Memory); // Memory
		}
		if (RAMCapacity > 0.0) {
			doMemoryLoad(curMemory, som, RAMCapacity, boundComponents, ResourceKind.RAM); // RAM
		}
		if (ROMCapacity > 0.0) {
			doMemoryLoad(curMemory, som, ROMCapacity, boundComponents, ResourceKind.ROM); // ROM
		}
	}

	/**
	 * check the load from components bound to the given memory The components
	 * can be threads or higher level components.
	 * 
	 * @param curMemory Component Instance of memory
	 */
	private void doMemoryLoad(ComponentInstance curMemory, final SystemOperationMode som, double Memorycapacity,
			EList<ComponentInstance> boundComponents, ResourceKind rk) {
		double totalMemory = 0.0;
		String somName = null;
		String resourceName = rk.name();
		boolean isROM = rk.equals(ResourceKind.ROM);
		UnitLiteral kbliteral = GetProperties.getKBUnitLiteral(curMemory);
		if (boundComponents.size() == 0 && Memorycapacity > 0) {
			errManager.infoSummary(curMemory, somName,
					"  No application components bound to " + curMemory.getComponentInstancePath() + " with "
							+ resourceName + " capacity " + GetProperties.toStringScaled(Memorycapacity, kbliteral));
			return;
		}
		if (Memorycapacity == 0) {
			errManager.errorSummary(curMemory, somName, "  Memory " + curMemory.getComponentInstancePath() + " has no "
					+ resourceName + " capacity but has bound components.");
		}
		logHeader("\n\nDetailed Workload Report: " + Aadl2Util.getPrintableSOMName(som) + " for memory "
				+ curMemory.getComponentInstancePath() + " with Capacity "
				+ GetProperties.toStringScaled(Memorycapacity, kbliteral) + "\n\nComponent,Budget,Actual");
		Set<ComponentInstance> budgeted = new HashSet<>();
		for (ComponentInstance bci : boundComponents) {
			String notes = "";
			double totalactual = sumMemoryActualPropertyValue(bci, isROM);
			double budget = isROM ? GetProperties.getROMBudgetInKB(bci, 0.0) : GetProperties.getRAMBudgetInKB(bci, 0.0);
			double actualsize = getMemoryUseActual(bci, resourceName, kbliteral);

			if (actualsize > 0) {
				// only compare if there were actuals
				if (budget > 0 && actualsize > budget) {
					notes = ",Error: " + resourceName + " subtotal exceeds budget by " + (actualsize - budget) + " KB";
				} else if (actualsize < budget) {
					notes = ",Warning: " + resourceName + " Subtotal under budget by " + (budget - actualsize) + " KB";
				}
				if (totalactual > 0 && totalactual != actualsize) {
					notes = notes + ",Warning: " + resourceName + " Data_Size differs from RAM/ROMActual";
				}
			}
			if (totalactual > 0) {
				// only compare if there were actuals
				if (budget > 0 && totalactual > budget) {
					notes = notes + ",Error: " + resourceName + " subtotal exceeds budget by " + (totalactual - budget)
							+ " KB";
				} else if (totalactual < budget) {
					notes = notes + ",Warning: " + resourceName + " Subtotal under budget by " + (budget - totalactual)
							+ " KB";
				}
			}
			if (totalactual == 0.0 && actualsize == 0.0) {
				// we use a budget number as there are no actuals
				if (budget > 0 && !budgeted.contains(bci)) {
					// only add it if no children budget numbers have been added
					totalMemory += budget;
					detailedLog(bci, budget, budget, "No actual. Added budget to total.");
					// add ancestors to budgeted list so their budget does not get added later
					while ((bci = bci.getContainingComponentInstance()) != null) {
						budgeted.add(bci);
					}
				}
			} else {
				if (actualsize > 0) {
					detailedLog(bci, budget, actualsize, notes);
					totalMemory += actualsize;
				} else {
					// add only the current actual; the children actual have been added before
					double currentActual = isROM ? GetProperties.getROMActualInKB(bci, 0.0)
							: GetProperties.getRAMActualInKB(bci, 0.0);
					detailedLog(bci, budget, currentActual, notes);
					totalMemory += currentActual;
				}
			}
		}
		detailedLogTotal2(null, totalMemory, kbliteral);
		if (Memorycapacity == 0)
			errManager.errorSummary(curMemory, somName,
					"  " + resourceName + curMemory.getComponentInstancePath() + " has no memory capacity specified");
		if (totalMemory > Memorycapacity) {
			errManager.errorSummary(curMemory, somName,
					"  Total Memory " + totalMemory + " KB of bounds tasks exceeds Memory capacity " + Memorycapacity
							+ " KB of " + curMemory.getComponentInstancePath());
		} else if (totalMemory == 0.0 && Memorycapacity == 0.0) {
			errManager.warningSummary(curMemory, somName, "  " + resourceName + curMemory.getComponentInstancePath()
					+ " has no capacity. Bound app's have no memory budget.");
		} else {
			errManager.infoSummary(curMemory, somName,
					"  Total " + resourceName + " " + totalMemory + " KB of bound tasks within Memory capacity "
							+ Memorycapacity + " KB of " + curMemory.getComponentInstancePath());
		}
	}

	private double sumMemoryActualPropertyValue(ComponentInstance ci, boolean isROM) {
		try {
			double total = isROM ? GetProperties.getROMActualInKB(ci, 0.0) : GetProperties.getRAMActualInKB(ci, 0.0);
			EList<ComponentInstance> subcis = ci.getComponentInstances();
			for (Iterator<ComponentInstance> it = subcis.iterator(); it.hasNext();) {
				ComponentInstance subci = it.next();
				total += sumMemoryActualPropertyValue(subci, isROM);
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

	private void detailedLog(InstanceObject obj, double budget, double actual, String msg) {
		if (doDetailedLog) {
			String budgetmsg = budget + " " + AadlProject.KBYTESPS_LITERAL + ",";
			String actualmsg = actual + " " + AadlProject.KBYTESPS_LITERAL + ",";
			String objname = (obj instanceof ConnectionInstance) ? obj.getFullName()
					: ((ComponentInstance) obj).getComponentInstancePath();
			errManager.logInfo(objname + ", " + budgetmsg + actualmsg + msg);
		}

	}

	private void logHeader(String msg) {
		errManager.logInfo(msg);
	}
	
	private enum ResourceKind {
		MIPS, RAM, ROM, Memory
	}
	
	/**
	 * calculate the budget of components with budgets, i.e., application
	 * components and devices For application components they are required,
	 * while for devices they are optional
	 * 
	 * @param ci component instance whose subtree is to be added up
	 * @param rk Property Definition of property to be added
	 * @param unit Unit in which the property value should be retrieved
	 * @param somName String name of SOM (used in reporting)
	 * @return double total, zero, if no budget, -1 if hardware only in
	 *         substructure
	 */
	private double sumBudgets(ComponentInstance ci, ResourceKind rk, UnitLiteral unit, final SystemOperationMode som,
			String prefix) {
		if (!ci.isActive(som)) {
			return 0.0;
		}
		double subtotal = 0.0;
		EList<ComponentInstance> subcis = ci.getComponentInstances();
		boolean HWOnly = false;
		boolean isSystemInstance = ci instanceof SystemInstance;
		int subbudgetcount = 0;
		int subcount = 0;
		if (subcis.size() == 0) {
			if (isHardware(ci)) {
				return -1;
			}
		} else {
			// track HWonly if subcomponents
			HWOnly = true;
		}
		for (Iterator<ComponentInstance> it = subcis.iterator(); it.hasNext();) {
			ComponentInstance subci = it.next();
			double subresult = sumBudgets(subci, rk, unit, som, isSystemInstance ? "" : prefix + prefixSymbol);
			if (subresult >= 0) {
				HWOnly = false;
				subtotal += subresult;
				if (subci.getCategory() == ComponentCategory.DEVICE) {
					if (subresult > 0) {
						// only count device if it has a budget
						subcount++;
						subbudgetcount++;
					}
				} else {
					// track how many non-devices and whether they have a budget
					subcount++;
					if (subresult > 0) {
						subbudgetcount++;
					}
				}
			}
		}
		if (HWOnly)
			return -1;
		double budget = getBudget(ci, rk);
		if (rk.equals(ResourceKind.RAM) || rk.equals(ResourceKind.ROM) || rk.equals(ResourceKind.Memory)) {
			double actualsize = getMemoryUseActual(ci, rk.name(), unit);
			subtotal += actualsize;
		}
		String resourceName = ci.getCategory().getName();
		String notes = "";
		if (rk == ResourceKind.MIPS && ci.getCategory() == ComponentCategory.THREAD) {
			subtotal = GetProperties.getThreadExecutioninMIPS(ci);
		}
		components = components + subcount;
		budgetedComponents = budgetedComponents + subbudgetcount;
		if (budget > 0 && subtotal > budget) {
			notes = String.format("Error: subtotal/actual exceeds budget %.3f by %.3f " + unit.getName(), budget,
					(subtotal - budget));
		} else if (subtotal > 0 && subtotal < budget) {
			notes = String.format(
					resourceName + " " + ci.getInstanceObjectPath() + " total %.3f " + unit.getName()
							+ " below budget %.3f " + unit.getName() + " (%.1f %% slack)",
					subtotal, budget, (budget - subtotal) / budget * 100);
		}
		if (!isSystemInstance)
			detailedLog(prefix, ci, budget, subtotal, resourceName, unit, notes);
		return subtotal == 0 ? budget : subtotal;
	}
	
	private double getMemoryUseActual(ComponentInstance bci, String resourceName, UnitLiteral unit) {
		double actualsize = 0.0;
		if (resourceName.equals("ROM")) {
			actualsize = GetProperties.getCodeSize(bci, unit);
		} else if (resourceName.equals("RAM")) {
			actualsize = GetProperties.getDataSize(bci, unit);
			actualsize += GetProperties.getHeapSize(bci, unit);
			actualsize += GetProperties.getStackSize(bci, unit);
		} else {
			actualsize = GetProperties.getDataSize(bci, unit);
			actualsize += GetProperties.getHeapSize(bci, unit);
			actualsize += GetProperties.getStackSize(bci, unit);
			actualsize += GetProperties.getCodeSize(bci, unit);
		}
		return actualsize;
	}
	
	private void detailedLogTotal2(ComponentInstance ci, double budget, UnitLiteral unit) {
		if (doDetailedLog) {
			String budgetmsg = String.format("%.3f " + unit.getName() + ",", budget);// GetProperties.toStringScaled(budget, unit) + ",";
			String front = ci == null ? "Total" : ci.getCategory().getName() + " " + ci.getComponentInstancePath();
			errManager.logInfo(front + ", ," + budgetmsg);
		}
	}
	
	private boolean isHardware(ComponentInstance ci) {
		ComponentCategory cat = ci.getCategory();
		if (cat == ComponentCategory.BUS || cat == ComponentCategory.PROCESSOR
				|| cat == ComponentCategory.VIRTUAL_PROCESSOR || cat == ComponentCategory.MEMORY)
			return true;
		if (cat == ComponentCategory.SYSTEM || cat == ComponentCategory.DEVICE) {
			EList<FeatureInstance> el = ci.getFeatureInstances();
			for (Iterator<FeatureInstance> it = el.iterator(); it.hasNext();) {
				FeatureInstance fi = it.next();
				if (fi.getCategory() != FeatureCategory.BUS_ACCESS) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	private double getBudget(NamedElement ne, ResourceKind kind) {
		switch (kind) {
		case MIPS:
			return GetProperties.getMIPSBudgetInMIPS(ne, 0.0);
		case RAM:
			return GetProperties.getRAMBudgetInKB(ne, 0.0);
		case ROM:
			return GetProperties.getROMBudgetInKB(ne, 0.0);
		case Memory:
			return GetProperties.getRAMBudgetInKB(ne, 0.0) + GetProperties.getROMBudgetInKB(ne, 0.0);
		}
		return 0.0;
	}
	
	private void detailedLog(String prefix, ComponentInstance ci, double budget, double actual, String resourceName,
			UnitLiteral unit, String msg) {
		if (doDetailedLog) {
			String budgetmsg = prefix + GetProperties.toStringScaled(budget, unit) + ",";
			String actualmsg = prefix + GetProperties.toStringScaled(actual, unit) + ",";
			errManager.logInfo(prefix + ci.getCategory().getName() + " " + ci.getComponentInstancePath() + ", "
					+ budgetmsg + actualmsg + msg);
		}
	}
}
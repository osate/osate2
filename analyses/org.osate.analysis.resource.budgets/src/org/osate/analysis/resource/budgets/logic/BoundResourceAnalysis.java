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
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.ui.dialogs.Dialog;
import org.osate.ui.handlers.AbstractAaxlHandler;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

//TODO-LW: assumes connection ends are features
public class BoundResourceAnalysis extends AbstractResourceAnalysis {
	private final String actionName;
	
	private int count = 0;

	public BoundResourceAnalysis(final String actionName, final AbstractAaxlHandler errManager) {
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
}
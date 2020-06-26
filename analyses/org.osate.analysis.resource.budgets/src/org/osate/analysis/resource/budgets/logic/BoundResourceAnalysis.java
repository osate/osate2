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

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
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
/**
 * @since 2.0
 */
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

		} else {
			Dialog.showError("Bound Resource Analysis Error", "Can only check system instances");
		}
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

	private static boolean canHaveMemory(Element e) {
		if (e instanceof ComponentInstance) {
			final ComponentInstance ci = (ComponentInstance) e;
			final ComponentCategory cc = ci.getCategory();
			// memory, system, processor, virtual processor, abstract
			return cc == ComponentCategory.MEMORY || cc == ComponentCategory.SYSTEM || cc == ComponentCategory.PROCESSOR
					|| cc == ComponentCategory.VIRTUAL_PROCESSOR || cc == ComponentCategory.ABSTRACT;
		} else {
			return false;
		}
	}

	private void checkMemoryLoads(SystemInstance si, final SystemOperationMode som) {
		count = 0;
		ForAllElement countme = new ForAllElement() {
			@Override
			protected void process(Element obj) {
				if (canHaveMemory(obj)) {
					if (GetProperties.getROMCapacityInKB((InstanceObject) obj, 0.0) > 0.0
							|| GetProperties.getRAMCapacityInKB((InstanceObject) obj, 0.0) > 0.0
							|| GetProperties.getMemorySizeInKB((InstanceObject) obj) > 0.0) {
						count = count + 1;
					}
				}
			}
		};
		countme.processPreOrderComponentInstance(si);
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
				if (canHaveMemory(obj)) {
					checkMemoryLoad((ComponentInstance) obj, som);
				}
			}
		};
		mal.processPreOrderComponentInstance(si);
	}

	/**
	 * check the load from components bound to the given memory The components
	 * can be threads or higher level components.
	 *
	 * @param curMemory Component Instance of memory
	 */
	private void checkMemoryLoad(ComponentInstance curMemory, final SystemOperationMode som) {
		UnitLiteral kbliteral = GetProperties.getKBUnitLiteral(curMemory);
		EList<ComponentInstance> boundComponents = getMemoryBindings(curMemory);
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
		if (Memorycapacity == 0) {
			errManager.errorSummary(curMemory, somName,
					"  " + resourceName + curMemory.getComponentInstancePath() + " has no memory capacity specified");
		}
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

	/*
	 * Issue 2169: This is copied from InstanceModelUtil.getBoundSWComponents, but we had
	 * to specialize it because now processor/virtual processors are treated as things
	 * that have memory and the original method gets the wrong things from the processors.
	 *
	 * associatedObject is of category memory, system, processor, virtual processor, abstract
	 */
	private static EList<ComponentInstance> getMemoryBindings(final ComponentInstance associatedObject) {
		EList<Element> boundComponents = null;

		final SystemInstance root = associatedObject.getSystemInstance();
		final ComponentCategory cc = associatedObject.getCategory();
		if (cc == ComponentCategory.MEMORY || cc == ComponentCategory.SYSTEM || cc == ComponentCategory.PROCESSOR
				|| cc == ComponentCategory.VIRTUAL_PROCESSOR || cc == ComponentCategory.ABSTRACT) {
			boundComponents = new ForAllElement() {
				@Override
				protected boolean suchThat(Element obj) {
					List<ComponentInstance> boundMemoryList = GetProperties
							.getActualMemoryBinding((ComponentInstance) obj);
					if (boundMemoryList.isEmpty()) {
						return false;
					}
					return boundMemoryList.contains(associatedObject);
				}
				// process bottom up so we can check whether children had budgets
			}.processPostOrderComponentInstance(root);
		} else {
			return new BasicEList<ComponentInstance>();
		}

		EList<ComponentInstance> topobjects = new BasicEList<ComponentInstance>();
		for (Object componentInstance : boundComponents) {
			InstanceModelUtil.addAsRoot(topobjects, (ComponentInstance) componentInstance);
		}
		return topobjects;
	}
}
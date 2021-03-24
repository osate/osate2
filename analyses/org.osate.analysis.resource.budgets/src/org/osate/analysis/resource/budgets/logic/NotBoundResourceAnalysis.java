/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.contrib.aadlproject.SizeUnits;
import org.osate.aadl2.contrib.memory.MemoryProperties;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.contribution.sei.sei.ProcessorSpeedUnits;
import org.osate.contribution.sei.sei.Sei;
import org.osate.pluginsupport.properties.PropertyUtils;
import org.osate.ui.handlers.AbstractAaxlHandler;

/**
 * @since 2.0
 */
public class NotBoundResourceAnalysis extends AbstractResourceAnalysis {
	private double capacity = 0;
	private double vcapacity = 0;
	private double budgetTotal = 0;
	private int resources = 0;
	private int capacityResources = 0;

	public NotBoundResourceAnalysis(AbstractAaxlHandler handler) {
		super(handler);
	}

	public void analyzeResourceBudget(final SystemInstance si, final SystemOperationMode som) {
		init();
		@SuppressWarnings("unchecked")
		EList<ComponentInstance> proclist = (EList<ComponentInstance>) (EList<?>) new ForAllElement()
				.processPreOrderComponentInstance(si, ComponentCategory.PROCESSOR);
		logHeader("\n\nDetailed Processor MIPS Capacity Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
		logHeader("Component,Capacity");
		capacity = sumCapacity(proclist, ResourceKind.MIPS, "processor", ProcessorSpeedUnits.MIPS);
		detailedLogTotal1(null, capacity, ProcessorSpeedUnits.MIPS);
		@SuppressWarnings("unchecked")
		EList<ComponentInstance> vproclist = (EList<ComponentInstance>) (EList<?>) new ForAllElement()
				.processPreOrderComponentInstance(si, ComponentCategory.VIRTUAL_PROCESSOR);
		if (!vproclist.isEmpty()) {
			logHeader(
					"\n\nDetailed Virtual Processor MIPS Capacity Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
			logHeader("Component,Capacity");
			vcapacity = sumVPMIPSBudget(vproclist);
			detailedLogTotal1(null, vcapacity, ProcessorSpeedUnits.MIPS);
		}
		logHeader("\n\nDetailed MIPS Budget Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
		logHeader("Component,Budget,Actual,Notes");
		budgetTotal = sumBudgets(si, ResourceKind.MIPS, som, "");
		if (budgetTotal >= 0) {
			detailedLogTotal2(null, budgetTotal, ProcessorSpeedUnits.MIPS);
			errManager.infoSummaryReportOnly(si, null, "Resource Summary: " + Aadl2Util.getPrintableSOMName(som));
			report(si, "MIPS", ProcessorSpeedUnits.MIPS, som);
		}

		init();
		@SuppressWarnings("unchecked")
		EList<ComponentInstance> memlist = (EList<ComponentInstance>) (EList<?>) new ForAllElement()
				.processPreOrderComponentInstance(si, ComponentCategory.MEMORY);
		capacity = capacityTotal(memlist, ResourceKind.Memory, "Memory");
		if (capacity > 0) {
			logHeader("\n\nDetailed Memory Capacity Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
			logHeader("Component,Capacity");
			capacity = sumCapacity(memlist, ResourceKind.Memory, "Memory", SizeUnits.KBYTE);
			detailedLogTotal1(null, capacity, SizeUnits.KBYTE);
			logHeader("\n\nDetailed Memory Budget Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
			logHeader("Component,Budget,Actual,Notes");
			budgetTotal = sumBudgets(si, ResourceKind.Memory, som, "");
			if (budgetTotal >= 0) {
				detailedLogTotal2(null, budgetTotal, SizeUnits.KBYTE);
				report(si, "Memory", SizeUnits.KBYTE, som);
			}
		}

		init();
		capacity = capacityTotal(memlist, ResourceKind.RAM, "RAM");
		if (capacity > 0) {
			logHeader("\n\nDetailed RAM Capacity Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
			logHeader("Component,Capacity");
			capacity = sumCapacity(memlist, ResourceKind.RAM, "RAM", SizeUnits.KBYTE);
			detailedLogTotal1(null, capacity, SizeUnits.KBYTE);
			logHeader("\n\nDetailed RAM Budget Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
			logHeader("Component,Budget,Actual,Notes");
			budgetTotal = sumBudgets(si, ResourceKind.RAM, som, "");
			if (budgetTotal >= 0) {
				detailedLogTotal2(null, budgetTotal, SizeUnits.KBYTE);
				report(si, "RAM", SizeUnits.KBYTE, som);
			}
		}

		init();
		capacity = capacityTotal(memlist, ResourceKind.ROM, "ROM");
		if (capacity > 0) {
			logHeader("\n\nDetailed ROM Capacity Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
			logHeader("Component,Capacity");
			capacity = sumCapacity(memlist, ResourceKind.ROM, "ROM", SizeUnits.KBYTE);
			detailedLogTotal1(null, capacity, SizeUnits.KBYTE);
			logHeader("\n\nDetailed ROM Budget Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
			logHeader("Component,Budget,Actual,Notes");
			budgetTotal = sumBudgets(si, ResourceKind.ROM, som, "");
			if (budgetTotal >= 0) {
				detailedLogTotal2(null, budgetTotal, SizeUnits.KBYTE);
				report(si, "ROM", SizeUnits.KBYTE, som);
			}
		}
	}

	private void init() {
		capacity = 0;
		components = 0;
		budgetedComponents = 0;
		resources = 0;
		capacityResources = 0;
		budgetTotal = 0;
	}

	private double getCapacity(ComponentInstance ne, ResourceKind kind) {
		switch (kind) {
		case MIPS:
			if (ne.getCategory().equals(ComponentCategory.PROCESSOR)) {
				return getProcessorMIPS(ne);
			}
			if (ne.getCategory().equals(ComponentCategory.VIRTUAL_PROCESSOR)) {
				return PropertyUtils.getScaled(Sei::getMipsbudget, ne, ProcessorSpeedUnits.MIPS).orElse(0.0);
			}
		case RAM:
			return PropertyUtils.getScaled(Sei::getRamcapacity, ne, SizeUnits.KBYTE).orElse(0.0);
		case ROM:
			return PropertyUtils.getScaled(Sei::getRomcapacity, ne, SizeUnits.KBYTE).orElse(0.0);
		case Memory:
			return PropertyUtils.getScaled(MemoryProperties::getMemorySize, ne, SizeUnits.KBYTE).orElse(0.0);
		}
		return 0.0;
	}

	private double sumVPMIPSBudget(EList<ComponentInstance> ilist) {
		double total = 0.0;
		for (Iterator<ComponentInstance> it = ilist.iterator(); it.hasNext();) {
			ComponentInstance io = it.next();
			double budget = PropertyUtils.getScaled(Sei::getMipsbudget, io, ProcessorSpeedUnits.MIPS).orElse(0.0);
			total += budget;
			detailedLogTotal2(io, budget, ProcessorSpeedUnits.MIPS);
		}
		return total;
	}

	private double sumCapacity(EList<ComponentInstance> ilist, ResourceKind rk, String resourceName, Enum<?> unit) {
		double total = 0.0;
		for (ComponentInstance io : ilist) {
			double capacity = getCapacity(io, rk);
			total += capacity;
			detailedLogTotal1(io, capacity, unit);
			resources++;
			if (capacity > 0) {
				capacityResources++;
			}
		}
		return total;
	}

	private double capacityTotal(EList<ComponentInstance> ilist, ResourceKind rk, String resourceName) {
		double total = 0.0;
		for (ComponentInstance io : ilist) {
			double capacity = getCapacity(io, rk);
			total += capacity;
			resources++;
			if (capacity > 0) {
				capacityResources++;
			}
		}
		return total;
	}

	private void report(SystemInstance si, String resourceName, Enum<?> unit, final SystemOperationMode som) {
		String somName = Aadl2Util.getPrintableSOMName(som);
		if (budgetTotal < 0) {
			budgetTotal = 0;
		}

		String modelStats = resourceName + " capacity " + String.format("%.3f " + unit.name(), capacity) + " : "
				+ resourceName + " budget " + String.format("%.3f " + unit.name(), budgetTotal);
		if (budgetTotal > capacity) {
			modelStats = "System " + si.getName() + " budgets over capacity: " + modelStats;
			errManager.errorSummary(si, somName, "  " + modelStats);
		} else {
			errManager.infoSummary(si, somName, "  " + modelStats);
		}
		modelStats = "  " + capacityResources + " out of " + resources + " with " + resourceName + " capacity";
		if (capacityResources < resources) {
			errManager.warningSummary(si, somName, modelStats);
		} else {
			errManager.infoSummary(si, somName, modelStats);
		}
		modelStats = "  " + budgetedComponents + " out of " + components + " with " + resourceName + " budget\n";
		if (budgetedComponents < components) {
			errManager.warningSummary(si, somName, modelStats);
		} else {
			errManager.infoSummary(si, somName, modelStats);
		}
	}

	private static double getProcessorMIPS(final NamedElement ne) {
		return PropertyUtils.getScaled(Sei::getMipscapacity, ne, ProcessorSpeedUnits.MIPS).orElseGet(
				() -> PropertyUtils.getScaled(org.osate.aadl2.contrib.timing.TimingProperties::getProcessorCapacity, ne,
						org.osate.aadl2.contrib.aadlproject.ProcessorSpeedUnits.MIPS).orElse(0.0));
	}
}
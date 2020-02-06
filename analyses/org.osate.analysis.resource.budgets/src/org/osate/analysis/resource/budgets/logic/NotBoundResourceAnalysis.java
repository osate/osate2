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

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.ui.handlers.AbstractAaxlHandler;
import org.osate.xtext.aadl2.properties.util.GetProperties;

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
		UnitLiteral kbliteral = GetProperties.getKBUnitLiteral(si);
		UnitLiteral mipsliteral = GetProperties.getMIPSUnitLiteral(si);
		@SuppressWarnings("unchecked")
		EList<ComponentInstance> proclist = (EList<ComponentInstance>) (EList<?>) new ForAllElement()
				.processPreOrderComponentInstance(si, ComponentCategory.PROCESSOR);
		logHeader("\n\nDetailed Processor MIPS Capacity Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
		logHeader("Component,Capacity");
		capacity = sumCapacity(proclist, ResourceKind.MIPS, "processor", mipsliteral);
		detailedLogTotal1(null, capacity, mipsliteral);
		@SuppressWarnings("unchecked")
		EList<ComponentInstance> vproclist = (EList<ComponentInstance>) (EList<?>) new ForAllElement()
				.processPreOrderComponentInstance(si, ComponentCategory.VIRTUAL_PROCESSOR);
		if (!vproclist.isEmpty()) {
			logHeader(
					"\n\nDetailed Virtual Processor MIPS Capacity Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
			logHeader("Component,Capacity");
			vcapacity = sumVPMIPSBudget(vproclist, mipsliteral);
			detailedLogTotal1(null, vcapacity, mipsliteral);
		}
		logHeader("\n\nDetailed MIPS Budget Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
		logHeader("Component,Budget,Actual,Notes");
		budgetTotal = sumBudgets(si, ResourceKind.MIPS, mipsliteral, som, "");
		if (budgetTotal >= 0) {
			detailedLogTotal2(null, budgetTotal, mipsliteral);
			errManager.infoSummaryReportOnly(si, null, "Resource Summary: " + Aadl2Util.getPrintableSOMName(som));
			report(si, "MIPS", mipsliteral, som);
		}

		init();
		@SuppressWarnings("unchecked")
		EList<ComponentInstance> memlist = (EList<ComponentInstance>) (EList<?>) new ForAllElement()
				.processPreOrderComponentInstance(si, ComponentCategory.MEMORY);
		capacity = capacityTotal(memlist, ResourceKind.Memory, "Memory", kbliteral);
		if (capacity > 0) {
			logHeader("\n\nDetailed Memory Capacity Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
			logHeader("Component,Capacity");
			capacity = sumCapacity(memlist, ResourceKind.Memory, "Memory", kbliteral);
			detailedLogTotal1(null, capacity, kbliteral);
			logHeader("\n\nDetailed Memory Budget Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
			logHeader("Component,Budget,Actual,Notes");
			budgetTotal = sumBudgets(si, ResourceKind.Memory, kbliteral, som, "");
			if (budgetTotal >= 0) {
				detailedLogTotal2(null, budgetTotal, kbliteral);
				report(si, "Memory", kbliteral, som);
			}
		}

		init();
		capacity = capacityTotal(memlist, ResourceKind.RAM, "RAM", kbliteral);
		if (capacity > 0) {
			logHeader("\n\nDetailed RAM Capacity Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
			logHeader("Component,Capacity");
			capacity = sumCapacity(memlist, ResourceKind.RAM, "RAM", kbliteral);
			detailedLogTotal1(null, capacity, kbliteral);
			logHeader("\n\nDetailed RAM Budget Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
			logHeader("Component,Budget,Actual,Notes");
			budgetTotal = sumBudgets(si, ResourceKind.RAM, kbliteral, som, "");
			if (budgetTotal >= 0) {
				detailedLogTotal2(null, budgetTotal, kbliteral);
				report(si, "RAM", kbliteral, som);
			}
		}

		init();
		capacity = capacityTotal(memlist, ResourceKind.ROM, "ROM", kbliteral);
		if (capacity > 0) {
			logHeader("\n\nDetailed ROM Capacity Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
			logHeader("Component,Capacity");
			capacity = sumCapacity(memlist, ResourceKind.ROM, "ROM", kbliteral);
			detailedLogTotal1(null, capacity, kbliteral);
			logHeader("\n\nDetailed ROM Budget Report " + Aadl2Util.getPrintableSOMName(som) + "\n");
			logHeader("Component,Budget,Actual,Notes");
			budgetTotal = sumBudgets(si, ResourceKind.ROM, kbliteral, som, "");
			if (budgetTotal >= 0) {
				detailedLogTotal2(null, budgetTotal, kbliteral);
				report(si, "ROM", kbliteral, som);
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

	private double getCapacity(ComponentInstance ne, ResourceKind kind, UnitLiteral unit) {
		switch (kind) {
		case MIPS:
			if (ne.getCategory().equals(ComponentCategory.PROCESSOR)) {
				return GetProperties.getProcessorMIPS(ne);
			}
			if (ne.getCategory().equals(ComponentCategory.VIRTUAL_PROCESSOR)) {
				return GetProperties.getMIPSBudgetInMIPS(ne);
			}
		case RAM:
			return GetProperties.getRAMCapacityInKB(ne, 0.0);
		case ROM:
			return GetProperties.getROMCapacityInKB(ne, 0.0);
		case Memory:
			return GetProperties.getMemorySize(ne, unit);
		}
		return 0.0;
	}

	private double sumVPMIPSBudget(EList<ComponentInstance> ilist, UnitLiteral unit) {
		double total = 0.0;
		for (Iterator<ComponentInstance> it = ilist.iterator(); it.hasNext();) {
			ComponentInstance io = it.next();
			double budget = GetProperties.getMIPSBudgetInMIPS(io);
			total += budget;
			detailedLogTotal2(io, budget, unit);
		}
		return total;
	}

	private double sumCapacity(EList<ComponentInstance> ilist, ResourceKind rk, String resourceName, UnitLiteral unit) {
		double total = 0.0;
		for (ComponentInstance io : ilist) {
			double capacity = getCapacity(io, rk, unit);
			total += capacity;
			detailedLogTotal1(io, capacity, unit);
			resources++;
			if (capacity > 0) {
				capacityResources++;
			}
		}
		return total;
	}

	private double capacityTotal(EList<ComponentInstance> ilist, ResourceKind rk, String resourceName,
			UnitLiteral unit) {
		double total = 0.0;
		for (ComponentInstance io : ilist) {
			double capacity = getCapacity(io, rk, unit);
			total += capacity;
			resources++;
			if (capacity > 0) {
				capacityResources++;
			}
		}
		return total;
	}

	private void report(SystemInstance si, String resourceName, UnitLiteral unit, final SystemOperationMode som) {
		String somName = Aadl2Util.getPrintableSOMName(som);
		if (budgetTotal < 0) {
			budgetTotal = 0;
		}

		String modelStats = resourceName + " capacity " + GetProperties.toStringScaled(capacity, unit) + " : "
				+ resourceName + " budget " + GetProperties.toStringScaled(budgetTotal, unit);
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
}
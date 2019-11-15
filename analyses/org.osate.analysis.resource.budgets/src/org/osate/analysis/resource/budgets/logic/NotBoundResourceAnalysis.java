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
			if (ne.getCategory().equals(ComponentCategory.PROCESSOR))
				return GetProperties.getProcessorMIPS(ne);
			if (ne.getCategory().equals(ComponentCategory.VIRTUAL_PROCESSOR))
				return GetProperties.getMIPSBudgetInMIPS(ne);
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
			if (capacity > 0)
				capacityResources++;
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
			if (capacity > 0)
				capacityResources++;
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
		} else
			errManager.infoSummary(si, somName, "  " + modelStats);
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
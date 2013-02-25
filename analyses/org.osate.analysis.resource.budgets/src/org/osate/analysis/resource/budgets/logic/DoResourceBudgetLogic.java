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
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class DoResourceBudgetLogic {
	private final StringBuffer reportMessage;
	private final AnalysisErrorReporterManager loggingErrManager;
	private final AnalysisErrorReporterManager errManager;

	private double capacity = 0;
	private double budgetTotal = 0;

	private int components = 0;
	private int budgetedComponents = 0;
	private int resources = 0;
	private int capacityResources = 0;

	public DoResourceBudgetLogic(final StringBuffer reportMessage,
			final AnalysisErrorReporterManager loggingErrManager, final AnalysisErrorReporterManager errManager) {
		this.reportMessage = reportMessage;
		this.loggingErrManager = loggingErrManager;
		this.errManager = errManager;
	}

	public void analyzeResourceBudget(final SystemInstance si, String somName) {
		init();
		UnitLiteral kbliteral = GetProperties.getKBUnitLiteral(si);
		EList proclist = new ForAllElement().processPreOrderComponentInstance(si, ComponentCategory.PROCESSOR);
		checkProcessorMIPS(proclist);
		capacity = sumCapacity(proclist, ResourceKind.MIPS, "processor",  true);
		budgetTotal = sumBudgets(si, ResourceKind.MIPS, GetProperties.getMIPSUnitLiteral(si), true, somName);
		report(si, "MIPS", GetProperties.getMIPSUnitLiteral(si), somName);

		init();
		EList memlist = new ForAllElement().processPreOrderComponentInstance(si, ComponentCategory.MEMORY);
		capacity = sumCapacity(memlist, ResourceKind.RAM, "Memory", true);
		budgetTotal = sumBudgets(si, ResourceKind.RAM, GetProperties.getKBUnitLiteral(si), true, somName);
		report(si, "RAM", GetProperties.getKBUnitLiteral(si), somName);

		init();
		memlist = new ForAllElement().processPreOrderComponentInstance(si, ComponentCategory.MEMORY);
		capacity = sumCapacity(memlist, ResourceKind.ROM, "ROM", false);
		budgetTotal = sumBudgets(si, ResourceKind.ROM, GetProperties.getKBUnitLiteral(si), false, somName);
		report(si, "ROM", GetProperties.getKBUnitLiteral(si), somName);
	}

	private void init() {
		capacity = 0;
		components = 0;
		budgetedComponents = 0;
		resources = 0;
		capacityResources = 0;
		budgetTotal = 0;
	}

	private void checkProcessorMIPS(EList ilist) {
		for (Iterator it = ilist.iterator(); it.hasNext();) {
			ComponentInstance curProcessor = (ComponentInstance) it.next();
			double MIPScapacity = GetProperties.getActualProcessorMIPS(curProcessor);
			// get cycle time and compare with MIPS capacity
			double cycleMIPS = GetProperties.getCycletimeasMIPS(curProcessor);

			if (cycleMIPS > 0.0) {
				if (MIPScapacity > 0.0) {
					if (Math.abs(MIPScapacity - cycleMIPS) > 1) {
						errorSummary(curProcessor, null, "MIPS capacity " + MIPScapacity + " and cycle time in MIPS "
								+ cycleMIPS + " specified inconsistently. Please remove one.");
					}
				}
			}
		}
	}
	
	private enum ResourceKind {MIPS, RAM, ROM};
	
	private double getCapacity(ComponentInstance ne,ResourceKind kind){
		switch(kind){
		case MIPS: 
			return GetProperties.getActualProcessorMIPS(ne);
		case RAM: 
			return GetProperties.getRAMCapacityInKB(ne, 0.0);
		case ROM: 
			return GetProperties.getROMCapacityInKB(ne, 0.0);
		}
		return 0.0;
	}
	
	private double getBudget(NamedElement ne,ResourceKind kind){
		switch(kind){
		case MIPS: 
			return GetProperties.getMIPSBudgetInMIPS(ne, 0.0);
		case RAM: 
			return GetProperties.getRAMBudgetInKB(ne, 0.0);
		case ROM: 
			return GetProperties.getROMBudgetInKB(ne, 0.0);
		}
		return 0.0;
	}
	

	private double sumCapacity(EList ilist, ResourceKind rk, String resourceName, boolean required) {
		double total = 0.0;
		for (Iterator it = ilist.iterator(); it.hasNext();) {
			ComponentInstance io = (ComponentInstance) it.next();
			double capacity = getCapacity(io, rk);
			total += capacity;
			resources++;
			if (capacity > 0)
				capacityResources++;
			else  {
					errManager.warning(io, resourceName + " " + io.getInstanceObjectPath() + " without capacity");
			}
		}
		return total;
	}

	/**
	 * calculate the budget of components with budgets, i.e., application
	 * components and devices For application components they are required,
	 * while for devices they are optional
	 * 
	 * @param ci component instance whose subtree is to be added up
	 * @param rk Property Definition of property to be added
	 * @param unit Unit in which the property value should be retrieved
	 * @param required Is the property required or optional (ROM is optional)
	 * @param somName String name of SOM (used in reporting)
	 * @return double total, zero, if no budget, -1 if hardware only in
	 *         substructure
	 */
	private double sumBudgets(ComponentInstance ci, ResourceKind rk, UnitLiteral unit, boolean required, String somName) {
		double total = 0.0;
		EList subcis = ci.getComponentInstances();
		boolean HWOnly = false;
		int subbudget = 0;
		int subsize = 0;
		if (subcis.size() > 0) {
			HWOnly = true;
		} else {
			if (isHardware(ci)) {
				return -1;
			}

		}
		for (Iterator it = subcis.iterator(); it.hasNext();) {
			ComponentInstance subci = (ComponentInstance) it.next();
			double res = sumBudgets(subci, rk, unit, required, somName);
			if (res >= 0) {
				HWOnly = false;
				total += res;
				if (subci.getCategory() == ComponentCategory.DEVICE) {
					if (res > 0) {
						// only count device if it has a budget
						subsize++;
						subbudget++;
					}
				} else {
					// track how many non-devices and whether they have a budget
					subsize++;
					if (res > 0) {
						subbudget++;
					}
				}
			}
		}
		double budget = getBudget(ci, rk);
		String resourceName = ci.getCategory().getName();
		if (rk == ResourceKind.MIPS && ci.getCategory() == ComponentCategory.THREAD) {
			double actualmips = GetProperties.getThreadExecutioninMIPS(ci);
			if (actualmips == 0.0) {
				total = budget;
			} else {
				total = actualmips;
				if (actualmips > budget && budget > 0){
					errManager.info(ci, resourceName + " " + ci.getInstanceObjectPath() + " thread execution time (in MIPS) " + actualmips +" greater than budget "+budget);
				}
			}
		}
		if (budget == 0 && total == 0 && required) {
			if (!(ci.getCategory() == ComponentCategory.DEVICE)) {
				errManager.warning(ci, resourceName + " " + ci.getInstanceObjectPath() + " without " + rk.name());
			} else {
				errManager.info(ci, resourceName + " " + ci.getInstanceObjectPath() + " without " + rk.name());
				return -1;
			}
		}
		if (subbudget < subsize) {
			// count leaf nodes only
			components = components + subsize;
			budgetedComponents = budgetedComponents + subbudget;
		}
		if (total == 0.0) {
			return budget;
		}
		if (budget > 0 && total > budget) {
			errorSummary(ci, somName, resourceName + " " + ci.getInstanceObjectPath() + " total exceeds budget "
					+ budget + " by " + (total - budget) + " " + unit.getName());
		} else {
			if (total < budget) {
				warningSummary(ci, somName, String.format(
						resourceName + " " + ci.getInstanceObjectPath() + " total %.1f " + unit.getName()
								+ " below budget %.1f " + unit.getName()
								+ " (%.1f %% slack)", total, budget,
						(budget - total) / budget * 100));
			}
		}
		return total;
	}

	protected boolean isHardware(ComponentInstance ci) {
		ComponentCategory cat = ci.getCategory();
		if (cat == ComponentCategory.BUS || cat == ComponentCategory.PROCESSOR || cat == ComponentCategory.MEMORY)
			return true;
		if (cat == ComponentCategory.SYSTEM || cat == ComponentCategory.DEVICE) {
			EList el = ci.getFeatureInstances();
			for (Iterator it = el.iterator(); it.hasNext();) {
				FeatureInstance fi = (FeatureInstance) it.next();
				if (fi.getCategory() != FeatureCategory.BUS_ACCESS) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private void report(SystemInstance si, String resourceName, UnitLiteral unit, String somName) {
		if (budgetTotal < 0)
			budgetTotal = 0;

		String modelStats = resourceName + " capacity " + GetProperties.toStringScaled(capacity, unit) + " : "
				+ resourceName + " budget " + GetProperties.toStringScaled(budgetTotal, unit);
		if (budgetTotal > capacity) {
			modelStats = "System " + si.getName() + " over capacity: " + modelStats;
			errorSummary(si, somName, modelStats);
		} else
			infoSummary(si, somName, modelStats);
		if (capacityResources < resources) {
			modelStats = capacityResources + " out of " + resources + " with " + resourceName + " capacity";
			warningSummary(si, somName, modelStats);
		}
		if (budgetedComponents < components) {
			modelStats = budgetedComponents + " out of " + components + " with " + resourceName + " budget";
			warningSummary(si, somName, modelStats);
		}
		reportMessage.append("\n");
	}

	private void errorSummary(final Element obj, String somName, String msg) {
		if (somName != null && !somName.equalsIgnoreCase("No Modes")) {
			msg = "In SystemMode " + somName + ": " + msg;
		}
		errManager.error(obj, msg);
		loggingErrManager.error(obj, msg);
	}

	private void warningSummary(final Element obj, String somName, String msg) {
		if (somName != null && !somName.equalsIgnoreCase("No Modes")) {
			msg = "In SystemMode " + somName + ": " + msg;
		}
		errManager.warning(obj, msg);
		loggingErrManager.warning(obj, msg);
	}

	private void infoSummary(final Element obj, String somName, String msg) {
		if (somName != null && !somName.equalsIgnoreCase("No Modes")) {
			msg = "In SystemMode " + somName + ": " + msg;
		}
		errManager.info(obj, msg);
		loggingErrManager.info(obj, msg);
	}

	public String getResultsMessages() {
		synchronized (reportMessage) {
			return reportMessage.toString();
		}
	}
}
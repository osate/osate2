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
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.contrib.timing.TimingProperties;
import org.osate.aadl2.contrib.util.AadlContribUtils;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.contribution.sei.sei.Instructionvolumeunits;
import org.osate.contribution.sei.sei.ProcessorSpeedUnits;
import org.osate.contribution.sei.sei.Sei;
import org.osate.pluginsupport.properties.PropertyUtils;
import org.osate.pluginsupport.properties.RealRange;
import org.osate.ui.handlers.AbstractAaxlHandler;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

abstract class AbstractResourceAnalysis extends AbstractLoggingAnalysis {
	private final String prefixSymbol = "  ";

	protected int components = 0;
	protected int budgetedComponents = 0;

	protected AbstractResourceAnalysis(AbstractAaxlHandler handler) {
		super(handler);
	}

	protected enum ResourceKind {
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
	protected double sumBudgets(ComponentInstance ci, ResourceKind rk, final SystemOperationMode som,
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
			double subresult = sumBudgets(subci, rk, som, isSystemInstance ? "" : prefix + prefixSymbol);
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
		if (HWOnly) {
			return -1;
		}

		final Enum<?> budgetUnit = rk == ResourceKind.MIPS ? ProcessorSpeedUnits.MIPS : SizeUnits.KBYTE;
		double budget = getBudget(ci, rk);
		if (rk.equals(ResourceKind.RAM) || rk.equals(ResourceKind.ROM) || rk.equals(ResourceKind.Memory)) {
			double actualsize = getMemoryUseActual(ci, rk.name(), SizeUnits.KBYTE);
			subtotal += actualsize;
		}
		String resourceName = ci.getCategory().getName();
		String notes = "";
		if (rk == ResourceKind.MIPS && ci.getCategory() == ComponentCategory.THREAD) {
			subtotal = getThreadExecutioninMIPS(ci);
		}
		components = components + subcount;
		budgetedComponents = budgetedComponents + subbudgetcount;
		if (budget > 0 && subtotal > budget) {
			notes = String.format("Error: subtotal/actual exceeds budget %.3f by %.3f " + budgetUnit.name(), budget,
					(subtotal - budget));
		} else if (budget > 0 && subtotal < budget) {
			notes = String.format(
					resourceName + " " + ci.getInstanceObjectPath() + " total %.3f " + budgetUnit.name()
							+ " below budget %.3f " + budgetUnit.name() + " (%.1f %% slack)",
					subtotal, budget, (budget - subtotal) / budget * 100);
		}
		if (!isSystemInstance) {
			detailedLog(prefix, ci, budget, subtotal, resourceName, budgetUnit, notes);
		}
		return subtotal == 0 ? budget : subtotal;
	}

	protected double getMemoryUseActual(final ComponentInstance bci, final String resourceName, final SizeUnits unit) {
		double actualsize = 0.0;
		if (resourceName.equals("ROM")) {
			actualsize = getCodeSize(bci, unit);
		} else if (resourceName.equals("RAM")) {
			actualsize = AadlContribUtils.getDataSize(bci, unit);
			actualsize += getHeapSize(bci, unit);
			actualsize += getStackSize(bci, unit);
		} else {
			actualsize = AadlContribUtils.getDataSize(bci, unit);
			actualsize += getHeapSize(bci, unit);
			actualsize += getStackSize(bci, unit);
			actualsize += getCodeSize(bci, unit);
		}
		return actualsize;
	}

	private double getBudget(NamedElement ne, ResourceKind kind) {
		switch (kind) {
		case MIPS:
			return PropertyUtils.getScaled(Sei::getMipsbudget, ne, ProcessorSpeedUnits.MIPS).orElse(0.0);
		case RAM:
			return PropertyUtils.getScaled(Sei::getRambudget, ne, SizeUnits.KBYTE).orElse(0.0);
		case ROM:
			return PropertyUtils.getScaled(Sei::getRombudget, ne, SizeUnits.KBYTE).orElse(0.0);
		case Memory:
			return PropertyUtils.getScaled(Sei::getRambudget, ne, SizeUnits.KBYTE).orElse(0.0)
					+ PropertyUtils.getScaled(Sei::getRombudget, ne, SizeUnits.KBYTE).orElse(0.0);
		}
		return 0.0;
	}

	private boolean isHardware(ComponentInstance ci) {
		ComponentCategory cat = ci.getCategory();
		if (cat == ComponentCategory.BUS || cat == ComponentCategory.PROCESSOR
				|| cat == ComponentCategory.VIRTUAL_PROCESSOR || cat == ComponentCategory.MEMORY) {
			return true;
		}
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

	protected static double getHeapSize(final NamedElement ne, final SizeUnits unit) {
		return org.osate.pluginsupport.properties.PropertyUtils
				.getScaled(org.osate.aadl2.contrib.memory.MemoryProperties::getHeapSize, ne, unit)
				.orElseGet(() -> org.osate.pluginsupport.properties.PropertyUtils
						.getScaled(org.osate.aadl2.contrib.memory.MemoryProperties::getSourceHeapSize, ne, unit)
						.orElse(0.0));
	}

	protected static double getStackSize(final NamedElement ne, final SizeUnits unit) {
		return org.osate.pluginsupport.properties.PropertyUtils
				.getScaled(org.osate.aadl2.contrib.memory.MemoryProperties::getStackSize, ne, unit)
				.orElseGet(() -> org.osate.pluginsupport.properties.PropertyUtils
						.getScaled(org.osate.aadl2.contrib.memory.MemoryProperties::getSourceStackSize, ne, unit)
						.orElse(0.0));
	}

	protected static double getCodeSize(final NamedElement ne, final SizeUnits unit) {
		return org.osate.pluginsupport.properties.PropertyUtils
				.getScaled(org.osate.aadl2.contrib.memory.MemoryProperties::getCodeSize, ne, unit)
				.orElseGet(() -> org.osate.pluginsupport.properties.PropertyUtils
						.getScaled(org.osate.aadl2.contrib.memory.MemoryProperties::getSourceCodeSize, ne, unit)
						.orElse(0.0));
	}

	protected static double getThreadExecutioninMIPS(ComponentInstance threadinstance) {
		if (!InstanceModelUtil.isThread(threadinstance)) {
			return 0;
		}
		double mips = getThreadExecutionIPDinMIPS(threadinstance);
		if (mips == 0) {
			double period = PropertyUtils.getScaled(TimingProperties::getPeriod, threadinstance, TimeUnits.SEC)
					.orElse(0.0);
			double exectimeval = PropertyUtils
					.getScaledRange(TimingProperties::getComputeExecutionTime, threadinstance, TimeUnits.SEC)
					.orElse(RealRange.ZEROED).getMaximum();
			if (exectimeval > 0 && period > 0) {
				final ComponentInstance thread = threadinstance;
				double mipspersec = TimingProperties.getReferenceProcessor(thread).map(pci -> getMIPSCapacityInMIPS(pci, 0.0)).orElse(0.0);
				if (mipspersec == 0) {
					mipspersec = getBoundPhysicalProcessorMIPS(threadinstance);
				}
				double time = exectimeval / period;
				mips = time * mipspersec;
			}
		}
		return mips;
	}

	protected static double getThreadExecutionIPDinMIPS(final ComponentInstance threadinstance) {
		final double period = PropertyUtils.getScaled(TimingProperties::getPeriod, threadinstance, TimeUnits.SEC)
				.orElse(0.0);
		final double mipd = PropertyUtils
				.getScaledRange(Sei::getInstructionsperdispatch, threadinstance, Instructionvolumeunits.MIPD)
				.orElse(RealRange.ZEROED).getMaximum();
		return (mipd > 0 && period > 0) ? mipd / period : 0.0;
	}

	protected static double getBoundPhysicalProcessorMIPS(final ComponentInstance thread) {
		final Iterator<ComponentInstance> pcis = InstanceModelUtil.getBoundPhysicalProcessors(thread).iterator();
		return pcis.hasNext() ? getMIPSCapacityInMIPS(pcis.next(), 0.0) : 0.0;
	}

	protected static double getMIPSCapacityInMIPS(final NamedElement ne, final double defaultValue) {
		return PropertyUtils.getScaled(Sei::getMipscapacity, ne, ProcessorSpeedUnits.MIPS).orElseGet(
				() -> PropertyUtils.getScaled(
						TimingProperties::getProcessorCapacity, ne,
						org.osate.aadl2.contrib.aadlproject.ProcessorSpeedUnits.MIPS).
						orElse(defaultValue));
	}

}
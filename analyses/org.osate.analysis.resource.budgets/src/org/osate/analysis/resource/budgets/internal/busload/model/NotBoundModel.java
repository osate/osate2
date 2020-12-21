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
package org.osate.analysis.resource.budgets.internal.busload.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class NotBoundModel extends ModelElement {
	private final List<ProcessorOrVirtualProcessor> rootProcessors = new ArrayList<>();
	private final Map<SystemInstance, ProcessorOrVirtualProcessor> processors = new HashMap<>();

	private final List<ProcessorOrVirtualProcessor> rootVirtProcessors = new ArrayList<>();
	private final Map<SystemInstance, ProcessorOrVirtualProcessor> virtProcessors = new HashMap<>();

	private final List<Memory> rootMemories = new ArrayList<>();
	private final Map<SystemInstance, Memory> memories = new HashMap<>();

	private final List<MIPS> rootMIPS = new ArrayList<>();
	private final Map<SystemInstance, MIPS> mips = new HashMap<>();

	/*
	 * Use {@link #buildModel(SystemInstance, SystemOperationMode)} to get an instance of the
	 * model.
	 */
	public NotBoundModel() {
		super();
	}

	private MIPS getMIPS(final SystemInstance si, final ComponentInstance ci, String somName) {
		MIPS mip = mips.get(si);
		if (mip == null) {
			mip = new MIPS(si, ci, somName);

			mips.put(si, mip);
		}
		return mip;
	}

	private Memory getMemory(final SystemInstance si, final ComponentInstance ci, String somName) {
		Memory mem = memories.get(si);
		if (mem == null) {
			mem = new Memory(si, ci);
			mem.setSomName(somName);
			mem.setCategory("Memory");

			memories.put(si, mem);
		}
		return mem;
	}

	private ProcessorOrVirtualProcessor getProcessor(final SystemInstance si, String somName) {
		ProcessorOrVirtualProcessor proc = processors.get(si);
		if (proc == null) {
			proc = new ProcessorOrVirtualProcessor(si, "Processor");
			proc.setSomName(somName);
			proc.setCategory("Processor");
			processors.put(si, proc);
		}
		return proc;
	}

	private ProcessorOrVirtualProcessor getVirtProcessor(final SystemInstance si, String somName) {
		ProcessorOrVirtualProcessor proc = virtProcessors.get(si);
		if (proc == null) {
			proc = new ProcessorOrVirtualProcessor(si, "VirtualProcessor");
			proc.setSomName(somName);
			proc.setCategory("VirtualProcessor");
			virtProcessors.put(si, proc);
		}
		return proc;
	}

	@Override
	void visitSelfPrefix(final Visitor visitor) {
		visitor.visitModelPrefix(this);
	}

	@Override
	void visitChildren(final Visitor visitor) {
		visit(rootMemories, visitor);
		visit(rootProcessors, visitor);
		visit(rootVirtProcessors, visitor);
		visit(rootMIPS, visitor);
	}

	@Override
	void visitSelfPostfix(final Visitor visitor) {
		visitor.visitModelPostfix(this);
	}

	// ==== Methods to build the model ====

	public static NotBoundModel buildModel(final SystemInstance root, final SystemOperationMode som) {
		final NotBoundModel model = new NotBoundModel();
		final ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(final Element obj) {
				final ComponentInstance ci = (ComponentInstance) obj;
				final ComponentCategory cat = ci.getCategory();
				if (cat == ComponentCategory.PROCESSOR) {
					addProcessor(model, root, ci, som);
				} else if (cat == ComponentCategory.VIRTUAL_PROCESSOR) {
					addVirtualProcessor(model, root, ci, som);
				} else if (cat == ComponentCategory.MEMORY) {
					addMemory(model, root, ci, som);
				}

				addMIPS(model, root, ci, som);
			}
		};
		mal.processPreOrderComponentInstance(root);

		// total capacity from processor -> mips
		double capacity = 0;
		int resources = 0, capacityResources = 0;
		for (final ProcessorOrVirtualProcessor p : model.getProcessors()) {
			double c = p.getCapacity();
			if (c > 0) {
				capacity += c;
				capacityResources++;
			}

			resources++;
		}

		for (final MIPS m : model.getMIPS()) {
			m.setTotalCapacity(capacity);

		}

		return model;
	}

	private static void addMemory(final NotBoundModel model, final SystemInstance si, final ComponentInstance ci,
			final SystemOperationMode som) {
		final Memory theMemory = model.getMemory(si, ci, Aadl2Util.getPrintableSOMName(som));

		UnitLiteral kbliteral = GetProperties.getKBUnitLiteral(si);

		Component comp = new Component(ci.getName());

		// Memory
		SubComponent subMem = new SubComponent("Memory");
		subMem.setCapacity(getCapacity(ci, ResourceKind.Memory, kbliteral));

		int components = 0;
		int budgetedComponents = 0;

		subMem.setBudgetSub(getBudget(ci, ResourceKind.Memory));
		subMem.setBudgetSubtotal(
				sumBudgets(ci, ResourceKind.Memory, kbliteral, som, "", components, budgetedComponents));
		subMem.setComponentsCount(components);
		subMem.setBudgetedComponentsCount(budgetedComponents);

		comp.addMemory(subMem);

		// RAM
		SubComponent subRAM = new SubComponent("RAM");
		subRAM.setCapacity(getCapacity(ci, ResourceKind.RAM, kbliteral));

		components = 0;
		budgetedComponents = 0;

		subRAM.setBudgetSub(getBudget(ci, ResourceKind.Memory));
		subRAM.setBudgetSubtotal(
				sumBudgets(ci, ResourceKind.RAM, kbliteral, som, "", components, budgetedComponents));
		subRAM.setComponentsCount(components);
		subRAM.setBudgetedComponentsCount(budgetedComponents);

		comp.addRAM(subRAM);

		// ROM
		SubComponent subROM = new SubComponent("ROM");
		subROM.setCapacity(getCapacity(ci, ResourceKind.ROM, kbliteral));

		components = 0;
		budgetedComponents = 0;

		subROM.setBudgetSub(getBudget(ci, ResourceKind.Memory));
		subROM.setBudgetSubtotal(
				sumBudgets(ci, ResourceKind.ROM, kbliteral, som, "", components, budgetedComponents));
		subROM.setComponentsCount(components);
		subROM.setBudgetedComponentsCount(budgetedComponents);

		comp.addROM(subROM);

		theMemory.addComponent(comp);
		model.addMemory(theMemory);
	}

	private static void addMIPS(final NotBoundModel model, final SystemInstance si, final ComponentInstance ci,
			final SystemOperationMode som) {
		MIPS theMIPS = model.getMIPS(si, ci, Aadl2Util.getPrintableSOMName(som));

		Component comp = new Component(ci.getName());
		SubComponent subMIPS = new SubComponent("MIPS");

		int components = 0, budgetedComponents = 0;
		UnitLiteral mipsliteral = GetProperties.getMIPSUnitLiteral(si);

		subMIPS.setBudgetSub(getBudget(ci, ResourceKind.MIPS));
		subMIPS.setBudgetSubtotal(
				sumBudgets(ci, ResourceKind.MIPS, mipsliteral, som, "", components, budgetedComponents));
		subMIPS.setComponentsCount(components);
		subMIPS.setBudgetedComponentsCount(budgetedComponents);

		comp.addMemory(subMIPS);
		theMIPS.addComponent(comp);
		model.addMIPS(theMIPS);
	}

	private static void addVirtualProcessor(final NotBoundModel model, final SystemInstance si,
			final ComponentInstance ci, final SystemOperationMode som) {
		final ProcessorOrVirtualProcessor theProcessor = model.getVirtProcessor(si, Aadl2Util.getPrintableSOMName(som));

		UnitLiteral mipsliteral = GetProperties.getMIPSUnitLiteral(si);
		double budget = GetProperties.getMIPSBudgetInMIPS(ci);

		Component comp = new Component(ci.getName());
		comp.setBudget(budget);
		comp.setBudgetWithUnit(String.format("%.3f " + mipsliteral.getName() + ",", budget));
		comp.setCategoryName(ci.getCategory().getName());
		comp.setComponentPath(ci.getComponentInstancePath());

		theProcessor.addComponent(comp);
		model.addVirtProcessor(theProcessor);
	}

	private static void addProcessor(final NotBoundModel model, final SystemInstance si, final ComponentInstance ci,
			final SystemOperationMode som) {
		final ProcessorOrVirtualProcessor theProcessor = model.getProcessor(si, Aadl2Util.getPrintableSOMName(som));

		UnitLiteral mipsliteral = GetProperties.getMIPSUnitLiteral(si);

		double capacity = getCapacity(ci, ResourceKind.MIPS, mipsliteral);

		Component comp = new Component(ci.getName());
		comp.setBudget(capacity);
		comp.setBudgetWithUnit(GetProperties.toStringScaled(capacity, mipsliteral));
		comp.setCategoryName(ci.getCategory().getName());
		comp.setComponentPath(ci.getComponentInstancePath());

		theProcessor.addComponent(comp);
		model.addProcessor(theProcessor);
	}

	void addMIPS(final MIPS mip) {
		rootMIPS.add(mip);
	}

	void addMemory(final Memory mem) {
		rootMemories.add(mem);
	}

	void addProcessor(final ProcessorOrVirtualProcessor proc) {
		rootProcessors.add(proc);
	}

	void addVirtProcessor(final ProcessorOrVirtualProcessor proc) {
		rootVirtProcessors.add(proc);
	}

	public Iterable<Memory> getMemories() {
		return rootMemories;
	}

	public Iterable<ProcessorOrVirtualProcessor> getProcessors() {
		return rootProcessors;
	}

	public Iterable<ProcessorOrVirtualProcessor> getVirtProcessors() {
		return rootVirtProcessors;
	}

	public Iterable<MIPS> getMIPS() {
		return rootMIPS;
	}

	protected enum ResourceKind {
		MIPS, RAM, ROM, Memory
	}

	protected static String detailedLogTotal1(ComponentInstance ci, double budget, UnitLiteral unit) {
		String budgetmsg = GetProperties.toStringScaled(budget, unit) + ",";
		String front = ci == null ? "Total" : ci.getCategory().getName() + " " + ci.getComponentInstancePath();
		return front + ", " + budgetmsg;
		// this is add to excel file errManager.logInfo(front + ", " + budgetmsg);
	}

	private static double getCapacity(ComponentInstance ne, ResourceKind kind, UnitLiteral unit) {
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
	protected static double sumBudgets(ComponentInstance ci, ResourceKind rk, UnitLiteral unit,
			final SystemOperationMode som, String prefix, int components, int budgetedComponents) {
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
			double subresult = sumBudgets(subci, rk, unit, som, isSystemInstance ? "" : (prefix + "  "),
					components, budgetedComponents);
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
		double budget = getBudget(ci, rk);
		if (rk.equals(ResourceKind.RAM) || rk.equals(ResourceKind.ROM) || rk.equals(ResourceKind.Memory)) {
			double actualsize = getMemoryUseActual(ci, rk.name(), unit);
			subtotal += actualsize;
		}
		String resourceName = ci.getCategory().getName();

		if (rk == ResourceKind.MIPS && ci.getCategory() == ComponentCategory.THREAD) {
			subtotal = GetProperties.getThreadExecutioninMIPS(ci);
		}
		components = components + subcount;
		budgetedComponents = budgetedComponents + subbudgetcount;

		return subtotal;
	}

	private static boolean isHardware(ComponentInstance ci) {
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

	private static double getBudget(NamedElement ne, ResourceKind kind) {
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

	protected static double getMemoryUseActual(ComponentInstance bci, String resourceName, UnitLiteral unit) {
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
}
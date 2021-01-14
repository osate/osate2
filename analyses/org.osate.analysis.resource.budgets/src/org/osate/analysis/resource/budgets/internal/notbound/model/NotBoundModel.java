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
package org.osate.analysis.resource.budgets.internal.notbound.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import org.osate.analysis.resource.budgets.internal.shared.model.ModelElement;
import org.osate.analysis.resource.budgets.internal.shared.model.Visitor;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class NotBoundModel extends ModelElement {
	private final List<ProcessorOrVirtualProcessor> rootProcessors = new ArrayList<>();
	private final List<ProcessorOrVirtualProcessor> rootVirtProcessors = new ArrayList<>();
	private final List<Memory> rootMemories = new ArrayList<>();
	private final List<MIPS> rootMIPS = new ArrayList<>();

	/*
	 * Use {@link #buildModel(SystemInstance, SystemOperationMode)} to get an instance of the
	 * model.
	 */
	public NotBoundModel() {
		super();
	}

	@Override
	protected void visitSelfPrefix(final Visitor visitor) {
		visitor.visitModelPrefix(this);
	}

	@Override
	protected void visitChildren(final Visitor visitor) {
		visit(rootMemories, visitor);
		visit(rootProcessors, visitor);
		visit(rootVirtProcessors, visitor);
		visit(rootMIPS, visitor);
	}

	@Override
	protected void visitSelfPostfix(final Visitor visitor) {
		visitor.visitModelPostfix(this);
	}

	// ==== Methods to build the model ====

	public static NotBoundModel buildModel(final SystemInstance root, final SystemOperationMode som) {
		final NotBoundModel model = new NotBoundModel();
		final ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(final Element obj) {
				final ComponentInstance ci = (ComponentInstance) obj;
				final SystemInstance si = ci.getSystemInstance();

				EList<ComponentInstance> proclist = (EList<ComponentInstance>) (EList<?>) new ForAllElement()
						.processPreOrderComponentInstance(ci, ComponentCategory.PROCESSOR);
				proclist.forEach(elem -> addProcessor(model, si, elem, som));

				EList<ComponentInstance> vproclist = (EList<ComponentInstance>) (EList<?>) new ForAllElement()
						.processPreOrderComponentInstance(ci, ComponentCategory.VIRTUAL_PROCESSOR);
				vproclist.forEach(elem -> addVirtualProcessor(model, si, elem, som));

				EList<ComponentInstance> memlist = (EList<ComponentInstance>) (EList<?>) new ForAllElement()
						.processPreOrderComponentInstance(ci, ComponentCategory.MEMORY);

				memlist.forEach(elem -> addMemory(model, si, elem, som));

				addMIPS(model, si, ci, som);
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
			// carry over resources counts from processor to mips object -- to be used later for error diagnosis
			m.setResources(resources);
			m.setCapacityResources(capacityResources);
		}

		return model;
	}

	private static void addMemory(final NotBoundModel model, final SystemInstance si, final ComponentInstance ci,
			final SystemOperationMode som) {
		final Memory theMemory = (model.rootMemories.size() > 0) ? model.rootMemories.get(0) : new Memory(si, ci);

		for (Component comp : theMemory.getComponents()) {
			if (comp.getComponentInstance().equals(ci))
			{
				return; // this component has already been processed
			}
		}

		UnitLiteral kbliteral = GetProperties.getKBUnitLiteral(si);

		Component comp = new Component(ci.getName());
		comp.setComponentInstance(ci);

		// Memory
		SubComponent subMem = new SubComponent("Memory");
		subMem.setCapacity(getCapacity(ci, ResourceKind.Memory, kbliteral));

		sumBudgets(subMem, ci, ResourceKind.Memory, kbliteral, som, "");
		comp.addMemory(subMem);

		// RAM
		SubComponent subRAM = new SubComponent("RAM");
		subRAM.setCapacity(getCapacity(ci, ResourceKind.RAM, kbliteral));

		sumBudgets(subRAM, ci, ResourceKind.RAM, kbliteral, som, "");
		comp.addRAM(subRAM);

		// ROM
		SubComponent subROM = new SubComponent("ROM");
		subROM.setCapacity(getCapacity(ci, ResourceKind.ROM, kbliteral));

		sumBudgets(subROM, ci, ResourceKind.ROM, kbliteral, som, "");
		comp.addROM(subROM);

		theMemory.addComponent(comp);

		if (model.rootMemories.size() < 1) { // only 1 root Memory is needed - this is more of a category
			model.addMemory(theMemory); // components (Memory children) will have actual Memory info
		}
	}

	private static void addMIPS(final NotBoundModel model, final SystemInstance si, final ComponentInstance ci,
			final SystemOperationMode som) {
		final MIPS theMIPS = (model.rootMIPS.size() > 0) ? model.rootMIPS.get(0)
				: new MIPS(si, ci, Aadl2Util.getPrintableSOMName(som));

		for (Component comp : theMIPS.getComponents()) {
			if (comp.getComponentInstance().equals(ci)) {
				return; // this component has already been processed
			}
		}

		SubComponent subMIPS = new SubComponent("MIPS");
		UnitLiteral mipsliteral = GetProperties.getMIPSUnitLiteral(si);

		sumBudgets(subMIPS, ci, ResourceKind.MIPS, mipsliteral, som, "");

		Component comp = new Component(ci.getName());
		comp.setComponentPath(ci.getInstanceObjectPath());
		comp.setComponentInstance(ci);
		comp.addMIPS(subMIPS);
		theMIPS.addComponent(comp);

		if (model.rootMIPS.size() < 1) { // only 1 root MIPS is needed - this is more of a category
			model.addMIPS(theMIPS); // components (MIPS children) will have actual MIPS info
		}
	}

	private static void addVirtualProcessor(final NotBoundModel model, final SystemInstance si,
			final ComponentInstance ci, final SystemOperationMode som) {
		final ProcessorOrVirtualProcessor theProcessor = (model.rootProcessors.size() > 0) ? model.rootProcessors.get(0)
				: new ProcessorOrVirtualProcessor(si, ci, "VirtualProcessor");

		for (Component comp : theProcessor.getComponents()) {
			if (comp.getComponentInstance().equals(ci)) {
				return; // this component has already been processed
			}
		}

		UnitLiteral mipsliteral = GetProperties.getMIPSUnitLiteral(si);
		double budget = GetProperties.getMIPSBudgetInMIPS(ci);

		Component comp = new Component(ci.getName());
		comp.setComponentInstance(ci);
		comp.setCapacity(budget);
		comp.setCapacityWithUnit(String.format("%.3f " + mipsliteral.getName() + ",", budget));
		comp.setCategoryName(ci.getCategory().getName());
		comp.setComponentPath(ci.getComponentInstancePath());

		theProcessor.addComponent(comp);

		if (model.rootVirtProcessors.size() < 1) { // only 1 root processor is needed - this is more of a category
			model.addVirtProcessor(theProcessor); // components (processor children) will have actual processor info
		}
	}

	private static void addProcessor(final NotBoundModel model, final SystemInstance si, final ComponentInstance ci,
			final SystemOperationMode som) {
		final ProcessorOrVirtualProcessor theProcessor = (model.rootProcessors.size() > 0) ? model.rootProcessors.get(0)
				: new ProcessorOrVirtualProcessor(si, ci, "Processor");

		for (Component comp : theProcessor.getComponents()) {
			if (comp.getComponentInstance().equals(ci)) {
				return; // this component has already been processed
			}
		}

		UnitLiteral mipsliteral = GetProperties.getMIPSUnitLiteral(si);

		double capacity = getCapacity(ci, ResourceKind.MIPS, mipsliteral);

		Component comp = new Component(ci.getName());
		comp.setComponentInstance(ci);
		comp.setCapacity(capacity);
		comp.setCapacityWithUnit(GetProperties.toStringScaled(capacity, mipsliteral));
		comp.setCategoryName(ci.getCategory().getName());
		comp.setComponentPath(ci.getComponentInstancePath());

		theProcessor.addComponent(comp);

		if (model.rootProcessors.size() < 1) { // only 1 root processor is needed - this is more of a category
			model.addProcessor(theProcessor); // components (processor children) will have actual processor info
		}
	}

	void addMIPS(final MIPS mip) {
		rootMIPS.add(mip);
	}

	void addMemory(final Memory mem) {
		rootMemories.add(mem);
	}

	void addProcessor(final ProcessorOrVirtualProcessor proc) {
		if (rootProcessors.size() < 1) {
			rootProcessors.add(proc);
		}
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
	 * @param subComp is a component to which budget stats should be appended to as children nodes
	 * @param ci component instance whose subtree is to be added up
	 * @param rk Property Definition of property to be added
	 * @param unit Unit in which the property value should be retrieved
	 * @param somName String name of SOM (used in reporting)
	 * @return double total, zero, if no budget, -1 if hardware only in
	 *         substructure
	 */
	protected static double sumBudgets(SubComponent subComp, ComponentInstance ci,
			ResourceKind rk, UnitLiteral unit, final SystemOperationMode som, String prefix) {
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
			double subresult = sumBudgets(subComp, subci, rk, unit, som, isSystemInstance ? "" : (prefix + "  "));
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

		if (rk.equals(ResourceKind.RAM) || rk.equals(ResourceKind.ROM) || rk.equals(ResourceKind.Memory)) {
			double actualsize = getMemoryUseActual(ci, rk.name(), unit);
			subtotal += actualsize;
		}

		if (rk == ResourceKind.MIPS && ci.getCategory() == ComponentCategory.THREAD) {
			subtotal = GetProperties.getThreadExecutioninMIPS(ci);
		}

		Budget budgetComp = new Budget(ci.getCategory().getName()); // resourceName
		budgetComp.setBudgetSub(getBudget(ci, rk));
		budgetComp.setBudgetSubtotal(subtotal);
		budgetComp.setComponentsCount(subcount);
		budgetComp.setBudgetedComponentsCount(subbudgetcount);

		subComp.addToBudgetList(budgetComp);

		return 1;
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
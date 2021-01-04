package org.osate.analysis.resource.budgets.internal.notbound.model;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.analysis.resource.budgets.internal.shared.model.AnalysisElement;
import org.osate.analysis.resource.budgets.internal.shared.model.Visitor;

public class Memory extends AnalysisElement {
	private SystemInstance si;

	private double totalCapacityMemory;
	private double totalCapacityRAM;
	private double totalCapacityROM;

	private double totalBudgetMemory; // Kb
	private double totalBudgetRAM; // Kb
	private double totalBudgetROM; // Kb

	private int resourcesMemory = 0;
	private int resourcesRAM = 0;
	private int resourcesROM = 0;

	private int capacityResourcesMemory = 0;
	private int capacityResourcesRAM = 0;
	private int capacityResourcesROM = 0;

	private int componentsMemory = 0;
	private int componentsRAM = 0;
	private int componentsROM = 0;

	private int budgetedComponentsMemory = 0;
	private int budgetedComponentsRAM = 0;
	private int budgetedComponentsROM = 0;

	public Memory(final SystemInstance si, ComponentInstance componentInstance) {
		super("Memory");
		this.si = si;
		this.setComponentInstance(componentInstance);
	}

	public final SystemInstance getSystemInstance() {
		return si;
	}

	public final int getBudgetedComponentsROM() {
		return budgetedComponentsROM;
	}

	public final void setBudgetedComponentsROM(final int budgetedComponentsROM) {
		this.budgetedComponentsROM = budgetedComponentsROM;
	}

	public final int getBudgetedComponentsRAM() {
		return budgetedComponentsRAM;
	}

	public final void setBudgetedComponentsRAM(final int budgetedComponentsRAM) {
		this.budgetedComponentsRAM = budgetedComponentsRAM;
	}

	public final int getBudgetedComponentsMemory() {
		return budgetedComponentsMemory;
	}

	public final void setBudgetedComponentsMemory(final int budgetedComponentsMemory) {
		this.budgetedComponentsMemory = budgetedComponentsMemory;
	}

	public final int getComponentsROM() {
		return componentsROM;
	}

	public final void setComponentsROM(final int componentsROM) {
		this.componentsROM = componentsROM;
	}

	public final int getComponentsRAM() {
		return componentsRAM;
	}

	public final void setComponentsRAM(final int componentsRAM) {
		this.componentsRAM = componentsRAM;
	}

	public final int getComponentsMemory() {
		return componentsMemory;
	}

	public final void setComponentsMemory(final int componentsMemory) {
		this.componentsMemory = componentsMemory;
	}

	public final int getCapacityResourcesROM() {
		return capacityResourcesROM;
	}

	public final void setCapacityResourcesROM(final int capacityResourcesROM) {
		this.capacityResourcesROM = capacityResourcesROM;
	}

	public final int getCapacityResourcesRAM() {
		return capacityResourcesRAM;
	}

	public final void setCapacityResourcesRAM(final int capacityResourcesRAM) {
		this.capacityResourcesRAM = capacityResourcesRAM;
	}

	public final int getCapacityResourcesMemory() {
		return capacityResourcesMemory;
	}

	public final void setCapacityResourcesMemory(final int capacityResourcesMemory) {
		this.capacityResourcesMemory = capacityResourcesMemory;
	}

	public final int getResourcesROM() {
		return resourcesROM;
	}

	public final void setResourcesROM(final int resourcesROM) {
		this.resourcesROM = resourcesROM;
	}

	public final int getResourcesRAM() {
		return resourcesRAM;
	}

	public final void setResourcesRAM(final int resourcesRAM) {
		this.resourcesRAM = resourcesRAM;
	}

	public final int getResourcesMemory() {
		return resourcesMemory;
	}

	public final void setResourcesMemory(final int resourcesMemory) {
		this.resourcesMemory = resourcesMemory;
	}

	public final double getTotalCapacityMemory() {
		return totalCapacityMemory;
	}

	public final void setTotalCapacityMemory(final double totalCapacityMemory) {
		this.totalCapacityMemory = totalCapacityMemory;
	}

	public final double getTotalCapacityRAM() {
		return totalCapacityRAM;
	}

	public final void setTotalCapacityRAM(final double totalCapacityRAM) {
		this.totalCapacityRAM = totalCapacityRAM;
	}

	public final double getTotalCapacityROM() {
		return totalCapacityROM;
	}

	public final void setTotalCapacityROM(final double totalCapacityROM) {
		this.totalCapacityROM = totalCapacityROM;
	}

	public final double getTotalBudgetMemory() {
		return totalBudgetMemory;
	}

	public final void setTotalBudgetMemory(final double totalBudgetMemory) {
		this.totalBudgetMemory = totalBudgetMemory;
	}

	public final double getTotalBudgetRAM() {
		return totalBudgetRAM;
	}

	public final void setTotalBudgetRAM(final double totalBudgetRAM) {
		this.totalBudgetRAM = totalBudgetRAM;
	}

	public final double getTotalBudgetROM() {
		return totalBudgetROM;
	}

	public final void setTotalBudgetROM(final double totalBudgetROM) {
		this.totalBudgetROM = totalBudgetROM;
	}

	@Override
	protected void visitSelfPrefix(final Visitor visitor) {
		visitor.visitMemoryPrefix(this);
	}

	@Override
	protected void visitSelfPostfix(final Visitor visitor) {
		visitor.visitMemoryPostfix(this);
	}

	@Override
	protected final void visitChildren(final Visitor visitor) {
		visit(components, visitor);
	}
}
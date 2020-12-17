package org.osate.analysis.resource.budgets.internal.busload.model;

public class Component extends AnalysisElement {

	public Component(String label) {
		super(label);
	}

	private int componentsCount, budgetedComponentsCount;
	private int componentsCountRAM, budgetedComponentsCountRAM;
	private int componentsCountROM, budgetedComponentsCountROM;

	private double capacity, capacityRAM, capacityROM;
	private double budgetRAM, budgetROM;
	private String budgetWithUnit, categoryName, componentPath;

	public final int getComponentsCount() {
		return componentsCount;
	}

	public final void setComponentsCount(final int componentsCount) {
		this.componentsCount = componentsCount;
	}

	public final int getComponentsCountRAM() {
		return componentsCountRAM;
	}

	public final void setComponentsCountRAM(final int componentsCountRAM) {
		this.componentsCountRAM = componentsCountRAM;
	}

	public final int getComponentsCountROM() {
		return componentsCountROM;
	}

	public final void setComponentsCountROM(final int componentsCountROM) {
		this.componentsCountROM = componentsCountROM;
	}

	public final int getBudgetedComponentsCount() {
		return budgetedComponentsCount;
	}

	public final void setBudgetedComponentsCount(final int budgetedComponentsCount) {
		this.budgetedComponentsCount = budgetedComponentsCount;
	}

	public final int getBudgetedComponentsCountRAM() {
		return budgetedComponentsCountRAM;
	}

	public final void setBudgetedComponentsCountRAM(final int budgetedComponentsCountRAM) {
		this.budgetedComponentsCountRAM = budgetedComponentsCountRAM;
	}

	public final int getBudgetedComponentsCountROM() {
		return budgetedComponentsCountROM;
	}

	public final void setBudgetedComponentsCountROM(final int budgetedComponentsCountROM) {
		this.budgetedComponentsCountROM = budgetedComponentsCountROM;
	}

	public final double getCapacity() {
		return capacity;
	}

	public final void setCapacity(final double capacity) {
		this.capacity = capacity;
	}

	public final double getCapacityRAM() {
		return capacityRAM;
	}

	public final void setCapacityRAM(final double capacityRAM) {
		this.capacityRAM = capacityRAM;
	}

	public final double getCapacityROM() {
		return capacityROM;
	}

	public final void setCapacityROM(final double capacityROM) {
		this.capacityROM = capacityROM;
	}

	public final double getBudgetRAM() {
		return budgetRAM;
	}

	public final void setBudgetRAM(final double budgetRAM) {
		this.budgetRAM = budgetRAM;
	}

	public final double getBudgetROM() {
		return budgetROM;
	}

	public final void setBudgetROM(final double budgetROM) {
		this.budgetROM = budgetROM;
	}

	public final String getComponentPath() {
		return componentPath;
	}

	public final void setComponentPath(final String componentPath) {
		this.componentPath = componentPath;
	}

	public final String getCategoryName() {
		return categoryName;
	}

	public final void setCategoryName(final String categoryName) {
		this.categoryName = categoryName;
	}

	public final String getBudgetWithUnit() {
		return budgetWithUnit;
	}

	public final void setBudgetWithUnit(final String budgetWithUnit) {
		this.budgetWithUnit = budgetWithUnit;
	}

	@Override
	void visitChildren(final Visitor visitor) {
		// no children
	}

	@Override
	void visitSelfPrefix(final Visitor visitor) {
		visitor.visitComponent(this);
	}

	@Override
	void visitSelfPostfix(final Visitor visitor) {
		// leaf node, already visited with prefix
	}
}
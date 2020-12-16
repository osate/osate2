package org.osate.analysis.resource.budgets.internal.busload.model;

public class Component extends AnalysisElement {

	public Component(String label) {
		super(label);
	}

	private double capacity;
	private String budgetWithUnit, categoryName, componentPath;

	public final double getCapacity() {
		return capacity;
	}

	public final void setCapacity(final double capacity) {
		this.capacity = capacity;
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
	void visitSelfPrefix(Visitor visitor) {
		// TODO Auto-generated method stub

	}

	@Override
	void visitChildren(Visitor visitor) {
		// TODO Auto-generated method stub

	}

	@Override
	void visitSelfPostfix(Visitor visitor) {
		// TODO Auto-generated method stub

	}
}
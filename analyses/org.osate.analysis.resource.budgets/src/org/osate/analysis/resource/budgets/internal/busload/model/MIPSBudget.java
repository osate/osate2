package org.osate.analysis.resource.budgets.internal.busload.model;

public class MIPSBudget extends AnalysisElement {
	private String budgetWithUnit, actualBudgetWithUnit, categoryName, componentPath;

	public MIPSBudget(String label) {
		super(label);
	}

	public final String getBudgetWithUnit() {
		return budgetWithUnit;
	}

	public final void setBudgetWithUnit(final String budgetWithUnit) {
		this.budgetWithUnit = budgetWithUnit;
	}

	public final String getActualBudgetWithUnit() {
		return actualBudgetWithUnit;
	}

	public final void setActualBudgetWithUnit(final String actualBudgetWithUnit) {
		this.actualBudgetWithUnit = actualBudgetWithUnit;
	}

	public final String getCategoryName() {
		return categoryName;
	}

	public final void setCategoryName(final String categoryName) {
		this.categoryName = categoryName;
	}

	public final String getComponentPath() {
		return componentPath;
	}

	public final void setComponentPath(final String componentPath) {
		this.componentPath = componentPath;
	}

	@Override
	void visitChildren(final Visitor visitor) {
		// no children
	}

	@Override
	void visitSelfPrefix(final Visitor visitor) {
		visitor.visitMIPSBudget(this);
	}

	@Override
	void visitSelfPostfix(final Visitor visitor) {
		// leaf node, already visited with prefix
	}
}
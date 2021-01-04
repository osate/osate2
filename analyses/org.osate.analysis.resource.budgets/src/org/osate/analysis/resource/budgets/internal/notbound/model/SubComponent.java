package org.osate.analysis.resource.budgets.internal.notbound.model;

import org.osate.analysis.resource.budgets.internal.shared.model.AnalysisElement;
import org.osate.analysis.resource.budgets.internal.shared.model.Visitor;

public class SubComponent extends AnalysisElement {
	public SubComponent(String category) {
		super(category);
	}

	private double capacity;
	private int componentsCount, budgetedComponentsCount;

	private double budgetSubtotal;
	private double budgetSub;

	@Override
	public double getBudget() {
		return budgetSubtotal == 0 ? budgetSub : budgetSubtotal;
	}

	public final double getBudgetSubtotal() {
		return budgetSubtotal;
	}

	public final void setBudgetSubtotal(final double budgetSubtotal) {
		this.budgetSubtotal = budgetSubtotal;
	}

	public final double getBudgetSub() {
		return budgetSub;
	}

	public final void setBudgetSub(final double budgetSub) {
		this.budgetSub = budgetSub;
	}

	public final double getCapacity() {
		return capacity;
	}

	public final void setCapacity(final double capacity) {
		this.capacity = capacity;
	}

	public final int getComponentsCount() {
		return componentsCount;
	}

	public final void setComponentsCount(final int componentsCount) {
		this.componentsCount = componentsCount;
	}

	public final int getBudgetedComponentsCount() {
		return budgetedComponentsCount;
	}

	public final void setBudgetedComponentsCount(final int budgetedComponentsCount) {
		this.budgetedComponentsCount = budgetedComponentsCount;
	}

	@Override
	protected void visitChildren(final Visitor visitor) {
		// no children
	}

	@Override
	protected void visitSelfPrefix(final Visitor visitor) {
		visitor.visitSubComponent(this);
	}

	@Override
	protected void visitSelfPostfix(final Visitor visitor) {
		// leaf node, already visited with prefix
	}
}
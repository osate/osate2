package org.osate.analysis.resource.budgets.internal.notbound.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.analysis.resource.budgets.internal.shared.model.AnalysisElement;
import org.osate.analysis.resource.budgets.internal.shared.model.Visitor;

public class SubComponent extends AnalysisElement {
	public SubComponent(String category) {
		super(category);
	}

	private double capacity;
	private List<Budget> budgetList = new ArrayList();

	public final double getCapacity() {
		return capacity;
	}

	public final void setCapacity(final double capacity) {
		this.capacity = capacity;
	}

	public void setBudgetList(List<Budget> budgetList) {
		this.budgetList = budgetList;
	}

	public void addToBudgetList(Budget budget) {
		this.budgetList.add(budget);
	}

	public List<Budget> getBudgetList() {
		return this.budgetList;
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
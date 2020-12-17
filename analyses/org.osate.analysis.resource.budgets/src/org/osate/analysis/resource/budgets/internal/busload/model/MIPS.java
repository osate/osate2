package org.osate.analysis.resource.budgets.internal.busload.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.SystemInstance;

public class MIPS extends AnalysisElement {
	private SystemInstance si;
	private int totalComponents, totalBudgetedComponents;

	private List<MIPSBudget> budgets = new ArrayList();

	public MIPS(String label, final SystemInstance si) {
		super(label);
		this.si = si;
	}

	public SystemInstance getSystemInstance() {
		return si;
	}

	public int getTotalComponents() {
		return totalComponents;
	}

	public void setTotalComponents(int totalComponents) {
		this.totalComponents = totalComponents;
	}

	public int getTotalBudgetedComponents() {
		return totalBudgetedComponents;
	}

	public void setTotalBudgetedComponents(int totalBudgetedComponents) {
		this.totalBudgetedComponents = totalBudgetedComponents;
	}

	public List<MIPSBudget> getBudgets() {
		return budgets;
	}

	public void setBudgets(List<MIPSBudget> budgets) {
		this.budgets = budgets;
	}

	public void addBudget(MIPSBudget budget) {
		this.budgets.add(budget);
	}

	@Override
	void visitSelfPrefix(final Visitor visitor) {
		visitor.visitMIPSPrefix(this);
	}

	@Override
	void visitSelfPostfix(final Visitor visitor) {
		visitor.visitMIPSPostfix(this);
	}

	@Override
	protected final void visitChildren(final Visitor visitor) {
		visit(budgets, visitor);
	}
}
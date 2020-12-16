package org.osate.analysis.resource.budgets.internal.busload.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.SystemInstance;

public class MIPS extends AnalysisElement {
	private SystemInstance si;

	private List<MIPSBudget> budgets = new ArrayList();
	private double totalBudget;
	private String totalBudgetWithUnit;

	public MIPS(String label, final SystemInstance si) {
		super(label);
		this.si = si;
	}

	public SystemInstance getSystemInstance() {
		return si;
	}

	public String getTotalBudgetWithUnit() {
		return totalBudgetWithUnit;
	}

	public void setTotalBudgetWithUnit(String totalBudgetWithUnit) {
		this.totalBudgetWithUnit = totalBudgetWithUnit;
	}

	public double getTotalBudget() {
		return totalBudget;
	}

	public void setTotalBudget(double totalBudget) {
		this.totalBudget = totalBudget;
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
package org.osate.analysis.resource.budgets.internal.busload.model;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;

public class MIPS extends AnalysisElement {
	private SystemInstance si;
	private final ComponentInstance ci;
	private int totalComponents, totalBudgetedComponents, totalResources, totalCapacityResources;
	private double totalBudget, totalCapacity;

	public MIPS(final SystemInstance si, final ComponentInstance ci, String somName) {
		super("MIPS");
		this.si = si;
		this.ci = ci;
		this.setSomName(somName);
	}

	public final ComponentInstance getComponentInstance() {
		return ci;
	}

	public SystemInstance getSystemInstance() {
		return si;
	}

	public final int getResources() {
		return totalResources;
	}

	public final void setResources(final int totalResources) {
		this.totalResources = totalResources;
	}

	public final int getCapacityResources() {
		return totalCapacityResources;
	}

	public final void setCapacityResources(final int totalCapacityResources) {
		this.totalCapacityResources = totalCapacityResources;
	}

	public final double getTotalCapacity() {
		return totalCapacity;
	}

	public final void setTotalCapacity(final double totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	@Override
	public final double getTotalBudget() {
		return totalBudget;
	}

	@Override
	public final void setTotalBudget(final double totalBudget) {
		this.totalBudget = totalBudget;
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
		visit(components, visitor);
	}
}
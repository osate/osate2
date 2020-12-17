package org.osate.analysis.resource.budgets.internal.busload.model;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;

public class Memory extends AnalysisElement {
	private SystemInstance si;
	private final ComponentInstance memoryInstance;

	private double totalCapacityMemory;
	private double totalCapacityRAM;
	private double totalCapacityROM;

	private double totalBudgetMemory;
	private double totalBudgetRAM;
	private double totalBudgetROM;

	public Memory(final SystemInstance si, ComponentInstance memoryInstance) {
		super("Memory");
		this.si = si;
		this.memoryInstance = memoryInstance;
	}

	public final ComponentInstance getMemoryInstance() {
		return memoryInstance;
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
	void visitSelfPrefix(final Visitor visitor) {
		visitor.visitMemoryPrefix(this);
	}

	@Override
	void visitSelfPostfix(final Visitor visitor) {
		visitor.visitMemoryPostfix(this);
	}

	@Override
	protected final void visitChildren(final Visitor visitor) {
		visit(components, visitor);
	}
}
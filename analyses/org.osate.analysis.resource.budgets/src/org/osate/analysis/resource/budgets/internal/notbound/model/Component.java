package org.osate.analysis.resource.budgets.internal.notbound.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.analysis.resource.budgets.internal.shared.model.AnalysisElement;
import org.osate.analysis.resource.budgets.internal.shared.model.Visitor;

public class Component extends AnalysisElement {

	public Component(String label) {
		super(label);
	}

	private String budgetWithUnit, categoryName, componentPath, capacityWithUnit;
	private double capacity;

	private List<SubComponent> memories = new ArrayList();
	private List<SubComponent> rams = new ArrayList();
	private List<SubComponent> roms = new ArrayList();
	private List<SubComponent> mips = new ArrayList();

	public List<SubComponent> getMIPS() {
		return mips;
	}

	public void setMIPS(List<SubComponent> subComps) {
		this.mips = subComps;
	}

	public List<SubComponent> getMemories() {
		return memories;
	}

	public void setMemories(List<SubComponent> subComps) {
		this.memories = subComps;
	}

	public void addMemory(SubComponent subComp) {
		this.memories.add(subComp);
	}

	public List<SubComponent> getRAMs() {
		return rams;
	}

	public void setRAMs(List<SubComponent> subComps) {
		this.rams = subComps;
	}

	public void addRAM(SubComponent subComp) {
		this.rams.add(subComp);
	}

	public List<SubComponent> getROMs() {
		return roms;
	}

	public void setROMs(List<SubComponent> subComps) {
		this.roms = subComps;
	}

	public void addROM(SubComponent subComp) {
		this.roms.add(subComp);
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

	public final String getCapacityWithUnit() {
		return capacityWithUnit;
	}

	public final void setCapacityWithUnit(final String capacityWithUnit) {
		this.capacityWithUnit = capacityWithUnit;
	}

	public final double getCapacity() {
		return capacity;
	}

	public final void setCapacity(final double capacity) {
		this.capacity = capacity;
	}

	@Override
	protected void visitChildren(final Visitor visitor) {
		visit(memories, visitor);
		visit(rams, visitor);
		visit(roms, visitor);
	}

	@Override
	protected void visitSelfPrefix(final Visitor visitor) {
		visitor.visitComponentPrefix(this);
	}

	@Override
	protected void visitSelfPostfix(final Visitor visitor) {
		visitor.visitComponentPostfix(this);
	}
}
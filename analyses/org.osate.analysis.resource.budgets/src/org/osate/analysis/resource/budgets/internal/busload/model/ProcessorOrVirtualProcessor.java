package org.osate.analysis.resource.budgets.internal.busload.model;

import org.osate.aadl2.instance.SystemInstance;


public class ProcessorOrVirtualProcessor extends AnalysisElement {
	private final SystemInstance procInstance;
	private double capacity;
	private String totalCapacityUnit;
	private int resources, capacityResources;

	public final String getTotalCapacityUnit() {
		return totalCapacityUnit;
	}

	public final void setTotalCapacityUnit(final String totalCapacityUnit) {
		this.totalCapacityUnit = totalCapacityUnit;
	}

	public final int getCapacityResources() {
		return capacityResources;
	}

	public final void setCapacityResources(final int capacityResources) {
		this.capacityResources = capacityResources;
	}

	public final int getResources() {
		return resources;
	}

	public final void setResources(final int resources) {
		this.resources = resources;
	}

	public final double getCapacity() {
		return capacity;
	}

	public final void setCapacity(final double capacity) {
		this.capacity = capacity;
	}

	public ProcessorOrVirtualProcessor(final SystemInstance procInstance, String category) {
		super(category);
		this.procInstance = procInstance;
	}

	public final SystemInstance getProcessorInstance() {
		return procInstance;
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

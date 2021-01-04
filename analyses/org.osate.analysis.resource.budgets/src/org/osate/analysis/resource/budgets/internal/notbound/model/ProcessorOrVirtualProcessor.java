package org.osate.analysis.resource.budgets.internal.notbound.model;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.analysis.resource.budgets.internal.shared.model.AnalysisElement;
import org.osate.analysis.resource.budgets.internal.shared.model.Visitor;


public class ProcessorOrVirtualProcessor extends AnalysisElement {
	private final SystemInstance si;
	private double capacity, virtualCapacity;
	private String totalCapacityUnit;
	private int resources, capacityResources, virtualResources, virtualCapacityResources;

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

	public final int getVirtualCapacityResources() {
		return virtualCapacityResources;
	}

	public final void setVirtualCapacityResources(final int virtualCapacityResources) {
		this.virtualCapacityResources = virtualCapacityResources;
	}

	public final int getVirtualResources() {
		return virtualResources;
	}

	public final void setVirtualResources(final int virtualResources) {
		this.virtualResources = virtualResources;
	}

	public final double getCapacity() {
		return capacity;
	}

	public final void setCapacity(final double capacity) {
		this.capacity = capacity;
	}

	public final double getVirtualCapacity() {
		return virtualCapacity;
	}

	public final void setVirtualCapacity(final double virtualCapacity) {
		this.virtualCapacity = virtualCapacity;
	}

	public ProcessorOrVirtualProcessor(final SystemInstance si, final ComponentInstance ci, String category) {
		super(category);
		this.si = si;
		this.setComponentInstance(ci);
	}

	public SystemInstance getSystemInstance() {
		return si;
	}

	@Override
	protected void visitSelfPrefix(final Visitor visitor) {
		visitor.visitProcessorOrVirtualProcessorPrefix(this);
	}

	@Override
	protected void visitSelfPostfix(final Visitor visitor) {
		visitor.visitProcessorOrVirtualProcessorPostfix(this);
	}

	@Override
	protected final void visitChildren(final Visitor visitor) {
		visit(components, visitor);
	}
}

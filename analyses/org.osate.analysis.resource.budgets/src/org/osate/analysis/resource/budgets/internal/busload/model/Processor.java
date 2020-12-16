package org.osate.analysis.resource.budgets.internal.busload.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.ComponentInstance;


public class Processor extends AnalysisElement {
	private final ComponentInstance procInstance;
	private double capacity;
	private String somName, totalCapacityUnit;
	private int resources, capacityResources;
	private List<String> capacityUnits = new ArrayList();

	public final String getTotalCapacityUnit() {
		return totalCapacityUnit;
	}

	public final void setTotalCapacityUnit(final String totalCapacityUnit) {
		this.totalCapacityUnit = totalCapacityUnit;
	}

	public final List<String> getCapacityUnit() {
		return capacityUnits;
	}

	public final void addCapacityUnit(final String capacityUnit) {
		this.capacityUnits.add(capacityUnit);
	}

	public final void setCapacityUnit(final List<String> capacityUnits) {
		this.capacityUnits = capacityUnits;
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

	public final String getSomName() {
		return somName;
	}

	public final void setSomName(final String somName) {
		this.somName = somName;
	}

	public Processor(final ComponentInstance procInstance, final String somName) {
		super("processor");
		this.procInstance = procInstance;
		this.somName = somName;
	}

	public final ComponentInstance getProcessorInstance() {
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

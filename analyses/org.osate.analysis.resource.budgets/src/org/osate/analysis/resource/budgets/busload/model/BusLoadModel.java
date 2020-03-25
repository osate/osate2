package org.osate.analysis.resource.budgets.busload.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;

public final class BusLoadModel extends ModelElement {
	private final Map<ComponentInstance, Bus> buses = new HashMap<>();
	private final Map<ComponentInstance, VirtualBus> virtualBuses = new HashMap<>();

	private final List<Bus> rootBuses = new ArrayList<>();

	public BusLoadModel() {
		super();
	}

	public Bus getBus(final ComponentInstance ci) {
		if (ci.getCategory() != ComponentCategory.BUS) {
			throw new IllegalArgumentException("Component instance is not a bus");
		}
		Bus bus = buses.get(ci);
		if (bus == null) {
			bus = new Bus(ci);
			buses.put(ci, bus);
		}
		return bus;
	}

	public VirtualBus getVirtualBus(final ComponentInstance ci) {
		if (ci.getCategory() != ComponentCategory.VIRTUAL_BUS) {
			throw new IllegalArgumentException("Component instance is not a virtual bus");
		}
		VirtualBus vb = virtualBuses.get(ci);
		if (vb == null) {
			vb = new VirtualBus(ci);
			virtualBuses.put(ci, vb);
		}
		return vb;
	}

	public void addBus(final Bus bus) {
		rootBuses.add(bus);
	}

	// may not need this?
	public Iterable<Bus> getRootBuses() {
		return rootBuses;
	}

	@Override
	void visitSelfPrefix(final Visitor visitor) {
		visitor.visitModelPrefix(this);
	}

	@Override
	void visitChildren(final Visitor visitor) {
		visit(rootBuses, visitor);
	}

	@Override
	void visitSelfPostfix(final Visitor visitor) {
		visitor.visitModelPostfix(this);
	}
}

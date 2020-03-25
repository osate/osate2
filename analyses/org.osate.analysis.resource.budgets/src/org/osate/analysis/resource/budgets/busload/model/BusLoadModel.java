package org.osate.analysis.resource.budgets.busload.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;

public final class BusLoadModel extends ModelElement {
	private final List<Bus> rootBuses = new ArrayList<>();

	public BusLoadModel() {
		super();
	}

	public Bus addBus(final ComponentInstance bus) {
		if (bus.getCategory() != ComponentCategory.BUS) {
			throw new IllegalArgumentException("Component instance is not a bus");
		}
		final Bus theBus = new Bus(bus);
		rootBuses.add(theBus);
		return theBus;
	}

	// may not need this?
	public Iterable<Bus> getRootBuses() {
		return rootBuses;
	}

	@Override
	protected void visitChildren(final Visitor visitor, final Traversal traversal) {
		visit(rootBuses, visitor, traversal);
	}

	@Override
	protected void visitSelf(final Visitor visitor) {
		visitor.visitModel(this);
	}
}

package org.osate.analysis.resource.budgets.busload.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;

abstract class AbstractBus extends ModelElement {
	private final ComponentInstance busInstance;
	private final List<VirtualBus> boundBuses = new ArrayList<>();
	private final List<Connection> boundConnections = new ArrayList<>();

	public AbstractBus(final ComponentInstance busInstance) {
		this.busInstance = busInstance;
	}

	public final ComponentInstance getBusInstance() {
		return busInstance;
	}

	public VirtualBus addBoundBus(final ComponentInstance virtualBus) {
		if (virtualBus.getCategory() != ComponentCategory.VIRTUAL_BUS) {
			throw new IllegalArgumentException("Component instance is not a virtual bus");
		}
		final VirtualBus theVirtualBus = new VirtualBus(virtualBus);
		boundBuses.add(theVirtualBus);
		return theVirtualBus;
	}

	public final Iterable<VirtualBus> getBoundBuses() {
		return boundBuses;
	}

	public Connection addBoundConnection(final ConnectionInstance connection) {
		final Connection theConnection = new Connection(connection);
		boundConnections.add(theConnection);
		return theConnection;
	}

	public final Iterable<Connection> getBoundConnections() {
		return boundConnections;
	}

	@Override
	protected final void visitChildren(final Visitor visitor) {
		visit(boundBuses, visitor);
		visit(boundConnections, visitor);
	}
}

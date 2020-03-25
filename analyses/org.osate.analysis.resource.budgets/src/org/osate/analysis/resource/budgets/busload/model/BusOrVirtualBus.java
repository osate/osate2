package org.osate.analysis.resource.budgets.busload.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;

public abstract class BusOrVirtualBus extends ModelElement {
	private final ComponentInstance busInstance;
	private final List<VirtualBus> boundBuses = new ArrayList<>();
	private final List<Connection> boundConnections = new ArrayList<>();

	public BusOrVirtualBus(final ComponentInstance busInstance) {
		this.busInstance = busInstance;
	}

	public final ComponentInstance getBusInstance() {
		return busInstance;
	}

	public void addBoundBus(final VirtualBus virtualBus) {
		boundBuses.add(virtualBus);
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

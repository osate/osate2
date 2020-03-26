package org.osate.analysis.resource.budgets.busload.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;

public abstract class BusOrVirtualBus extends AnalysisElement {
	private final ComponentInstance busInstance;
	private final List<VirtualBus> boundBuses = new ArrayList<>();
	private final List<Connection> boundConnections = new ArrayList<>();

	/** Capacity in KB/s. */
	private double capacity;

	/** Total budget of all the virtual buses and connections in KB/s. */
	private double totalBudget;

	public BusOrVirtualBus(final String label, final ComponentInstance busInstance) {
		super(label);
		this.busInstance = busInstance;
	}

	public final ComponentInstance getBusInstance() {
		return busInstance;
	}

	public final double getCapacity() {
		return capacity;
	}

	public final void setCapacity(final double capacity) {
		this.capacity = capacity;
	}

	public final double getTotalBudget() {
		return totalBudget;
	}

	public final void setTotalBudget(final double totalBudget) {
		this.totalBudget = totalBudget;
	}

	void addBoundBus(final VirtualBus virtualBus) {
		boundBuses.add(virtualBus);
	}

	public final Iterable<VirtualBus> getBoundBuses() {
		return boundBuses;
	}

	Connection addBoundConnection(final ConnectionInstance connection) {
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

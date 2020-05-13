package org.osate.analysis.resource.budgets.busload.model;

/**
 * @since 3.0
 */
public interface Visitor {
	public default void visitModelPrefix(BusLoadModel model) {
	}

	public default void visitModelPostfix(BusLoadModel model) {
	}

	public default void visitBusOrVirtualBusPrefix(BusOrVirtualBus bus) {
	}

	public default void visitBusOrVirtualBusPostfix(BusOrVirtualBus bus) {
	}

	public default void visitBusPrefix(final Bus bus) {
		visitBusOrVirtualBusPrefix(bus);
	}

	public default void visitBusPostfix(final Bus bus) {
		visitBusOrVirtualBusPostfix(bus);
	}

	public default void visitVirtualBusPrefix(final VirtualBus virtualBus) {
		visitBusOrVirtualBusPrefix(virtualBus);
	}

	public default void visitVirtualBusPostfix(final VirtualBus virtualBus) {
		visitBusOrVirtualBusPostfix(virtualBus);
	}

	public default void visitBroadcastPrefix(final Broadcast broadcast) {
	}

	public default void visitBroadcastPostfix(final Broadcast broadcast) {
	}

	// N.B. Leaf node
	public default void visitConnection(Connection connection) {
	}
}

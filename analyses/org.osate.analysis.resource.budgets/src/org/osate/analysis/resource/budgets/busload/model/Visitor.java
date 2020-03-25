package org.osate.analysis.resource.budgets.busload.model;

public interface Visitor {
	public default void visitModelPrefix(BusLoadModel model) {
	}

	public default void visitModelPostfix(BusLoadModel model) {
	}

	public default void visitBusPrefix(Bus bus) {
	}

	public default void visitBusPostfix(Bus bus) {
	}

	public default void visitVirtualBusPrefix(VirtualBus virtualBus) {
	}

	public default void visitVirtualBusPostfix(VirtualBus virtualBus) {
	}

	// N.B. Leaf node
	public default void visitConnection(Connection connection) {
	}
}

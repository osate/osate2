package org.osate.analysis.resource.budgets.busload.model;

import org.osate.aadl2.instance.ComponentInstance;

/**
 * @since 3.0
 */
public final class VirtualBus extends BusOrVirtualBus {
	public VirtualBus(final ComponentInstance busInstance) {
		super("virtual bus", busInstance);
	}

	@Override
	void visitSelfPrefix(final Visitor visitor) {
		visitor.visitVirtualBusPrefix(this);
	}

	@Override
	void visitSelfPostfix(final Visitor visitor) {
		visitor.visitVirtualBusPostfix(this);
	}
}

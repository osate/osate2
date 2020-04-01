package org.osate.analysis.resource.budgets.busload.model;

import org.osate.aadl2.instance.ComponentInstance;

/**
 * @since 3.0
 */
public final class Bus extends BusOrVirtualBus {
	public Bus(final ComponentInstance busInstance) {
		super("bus", busInstance);
	}

	@Override
	void visitSelfPrefix(final Visitor visitor) {
		visitor.visitBusPrefix(this);
	}

	@Override
	void visitSelfPostfix(final Visitor visitor) {
		visitor.visitBusPostfix(this);
	}
}

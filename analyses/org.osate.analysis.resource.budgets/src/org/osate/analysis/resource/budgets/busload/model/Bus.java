package org.osate.analysis.resource.budgets.busload.model;

import org.osate.aadl2.instance.ComponentInstance;

public final class Bus extends AbstractBus {
	public Bus(final ComponentInstance busInstance) {
		super(busInstance);
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

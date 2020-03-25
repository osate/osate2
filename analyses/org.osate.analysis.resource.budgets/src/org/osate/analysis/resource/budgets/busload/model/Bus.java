package org.osate.analysis.resource.budgets.busload.model;

import org.osate.aadl2.instance.ComponentInstance;

public final class Bus extends AbstractBus {
	public Bus(final ComponentInstance busInstance) {
		super(busInstance);
	}

	@Override
	protected void visitSelf(final Visitor visitor) {
		visitor.visitBus(this);
	}
}

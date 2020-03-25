package org.osate.analysis.resource.budgets.busload.model;

import org.osate.aadl2.instance.ComponentInstance;

public final class VirtualBus extends AbstractBus {
	public VirtualBus(final ComponentInstance busInstance) {
		super(busInstance);
	}

	@Override
	protected void visitSelf(final Visitor visitor) {
		visitor.visitVirtualBus(this);
	}
}

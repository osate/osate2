package org.osate.analysis.resource.budgets.busload.model;

import org.osate.aadl2.instance.ConnectionInstance;

public final class Connection extends ModelElement {
	private final ConnectionInstance connInstance;

	public Connection(final ConnectionInstance connInstance) {
		this.connInstance = connInstance;
	}

	public final ConnectionInstance getConnectionInstance() {
		return connInstance;
	}

	@Override
	protected void visitChildren(final Visitor visitor, final Traversal traversal) {
		// no children
	}

	@Override
	protected void visitSelf(final Visitor visitor) {
		visitor.visitConnection(this);
	}
}

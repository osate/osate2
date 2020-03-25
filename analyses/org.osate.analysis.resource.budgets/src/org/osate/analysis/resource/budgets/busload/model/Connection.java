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
	void visitChildren(final Visitor visitor) {
		// no children
	}

	@Override
	void visitSelfPrefix(final Visitor visitor) {
		visitor.visitConnection(this);
	}

	@Override
	void visitSelfPostfix(final Visitor visitor) {
		// leaf node, already visited with prefix
	}
}

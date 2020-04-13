package org.osate.analysis.resource.budgets.busload.model;

import org.osate.aadl2.instance.ConnectionInstance;

/**
 * @since 3.0
 */
public final class Connection extends AnalysisElement {
	/** The connection instance represented. */
	private final ConnectionInstance connInstance;

	public Connection(final ConnectionInstance connInstance) {
		super("connection");
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

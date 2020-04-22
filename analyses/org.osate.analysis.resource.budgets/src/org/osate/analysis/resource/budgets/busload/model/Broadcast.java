package org.osate.analysis.resource.budgets.busload.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;

/**
 * @since 3.0
 */
public final class Broadcast extends AnalysisElement {
	/** The feature that is the source of the broadcast */
	private final ConnectionInstanceEnd source;

	/** The connections that share the broadcast. */
	private final List<Connection> connections = new ArrayList<>();

	public Broadcast(final ConnectionInstanceEnd source) {
		super("broadcast");
		this.source = source;
	}

	public final ConnectionInstanceEnd getSource() {
		return source;
	}

	// Non-public, only used for building the model
	Connection addConnection(final ConnectionInstance connection) {
		final Connection theConnection = new Connection(connection);
		connections.add(theConnection);
		return theConnection;
	}

	public final List<Connection> getConnections() {
		return connections;
	}

	@Override
	void visitChildren(final Visitor visitor) {
		visit(connections, visitor);
	}

	@Override
	void visitSelfPrefix(final Visitor visitor) {
		visitor.visitBroadcastPrefix(this);
	}

	@Override
	void visitSelfPostfix(final Visitor visitor) {
		visitor.visitBroadcastPostfix(this);
	}
}

package org.osate.ge.internal.diagram.runtime.filtering;

import java.util.Objects;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.ge.ContentFilter;

public abstract class ConnectionTypeFilter implements ContentFilter {
	public static final String ID = "connections";

	private final Class<? extends Connection> connectionClass;

	public ConnectionTypeFilter(final Class<? extends Connection> connectionClass) {
		this.connectionClass = Objects.requireNonNull(connectionClass,
				"connectionClass must not be null");
	}

	@Override
	public String getParentId() {
		return ConnectionFilter.ID;
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ComponentImplementation || bo instanceof Subcomponent || bo instanceof ComponentInstance;
	}

	@Override
	public boolean test(Object bo) {
		final Connection connection;
		if (bo instanceof Connection) {
			connection = (Connection) bo;
		} else if (bo instanceof ConnectionReference) {
			connection = ((ConnectionReference) bo).getConnection();
		} else {
			return false;
		}

		return connectionClass.isInstance(connection);
	}
}

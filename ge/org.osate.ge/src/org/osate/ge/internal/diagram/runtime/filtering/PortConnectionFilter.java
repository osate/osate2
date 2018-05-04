package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.PortConnection;

public class PortConnectionFilter extends ConnectionTypeFilter {
	public static final String ID = "portConnections";

	public PortConnectionFilter() {
		super(PortConnection.class);
	}

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Port Connections";
	}
}

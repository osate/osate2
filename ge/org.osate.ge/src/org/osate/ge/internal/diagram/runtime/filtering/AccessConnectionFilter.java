package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.AccessConnection;

public class AccessConnectionFilter extends ConnectionTypeFilter {
	public static final String ID = "accessConnections";

	public AccessConnectionFilter() {
		super(AccessConnection.class);
	}

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Access Connections";
	}
}

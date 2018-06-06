package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.ParameterConnection;

public class ParameterConnectionFilter extends ConnectionTypeFilter {
	public static final String ID = "parameterConnections";

	public ParameterConnectionFilter() {
		super(ParameterConnection.class);
	}

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Parameter Connections";
	}
}

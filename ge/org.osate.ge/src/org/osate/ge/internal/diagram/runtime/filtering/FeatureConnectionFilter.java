package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.FeatureConnection;

public class FeatureConnectionFilter extends ConnectionTypeFilter {
	public static final String ID = "featureConnections";

	public FeatureConnectionFilter() {
		super(FeatureConnection.class);
	}

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Feature Connections";
	}
}

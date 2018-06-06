package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.FeatureGroupConnection;

public class FeatureGroupConnectionFilter extends ConnectionTypeFilter {
	public static final String ID = "featureGroupConnections";

	public FeatureGroupConnectionFilter() {
		super(FeatureGroupConnection.class);
	}

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Feature Group Connections";
	}
}

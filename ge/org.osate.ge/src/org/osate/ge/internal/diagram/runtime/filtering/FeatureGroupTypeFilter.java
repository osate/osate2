package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.FeatureGroupType;

public class FeatureGroupTypeFilter extends ClassifierClassFilter {
	public static final String ID = "featureGroupTypes";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Feature Group Types";
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof FeatureGroupType;
	}
}

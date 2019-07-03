package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.ge.ContentFilter;

// Filter for features. Does not include processor or internal features
public class FeatureFilter implements ContentFilter {
	public static final String ID = "features";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Features";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof Classifier || bo instanceof Subcomponent
				|| bo instanceof FeatureGroup || bo instanceof ComponentInstance || bo instanceof SubprogramCall
				|| (bo instanceof FeatureInstance
						&& ((FeatureInstance) bo).getCategory() == FeatureCategory.FEATURE_GROUP);
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof Feature || bo instanceof FeatureInstance;
	}
}

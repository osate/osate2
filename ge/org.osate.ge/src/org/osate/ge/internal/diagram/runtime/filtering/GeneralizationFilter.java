package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.Generalization;
import org.osate.ge.ContentFilter;

public class GeneralizationFilter implements ContentFilter {
	public static final String ID = "generalizations";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Generalizations";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof Classifier;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof Generalization;
	}
}

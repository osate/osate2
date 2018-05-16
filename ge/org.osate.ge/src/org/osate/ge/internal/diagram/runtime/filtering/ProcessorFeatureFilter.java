package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.ContentFilter;

public class ProcessorFeatureFilter implements ContentFilter {
	public static final String ID = "processorFeatures";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Processor Features";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ComponentImplementation || bo instanceof Subcomponent;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof ProcessorFeature;
	}
}

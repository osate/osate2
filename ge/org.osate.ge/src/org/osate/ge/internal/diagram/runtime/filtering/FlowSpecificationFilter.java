package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.ContentFilter;

public class FlowSpecificationFilter implements ContentFilter {
	public static final String ID = "flowSpecifications";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Flow Specifications";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ComponentClassifier || bo instanceof Subcomponent;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof FlowSpecification;
	}
}

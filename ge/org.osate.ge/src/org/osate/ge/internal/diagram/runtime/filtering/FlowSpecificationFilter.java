package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
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
		return bo instanceof ComponentClassifier || bo instanceof Subcomponent || bo instanceof ComponentInstance
				|| bo instanceof SubprogramCall;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof FlowSpecification || bo instanceof FlowSpecificationInstance;
	}
}

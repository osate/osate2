package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.ge.ContentFilter;

public class SubcomponentFilter implements ContentFilter {
	public static final String ID = "subcomponents";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Subcomponents";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ComponentImplementation || bo instanceof Subcomponent || bo instanceof ComponentInstance;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof Subcomponent || bo instanceof ComponentInstance;
	}
}

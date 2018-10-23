package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.ge.ContentFilter;

public class ModeTransitionFilter implements ContentFilter {
	public static final String ID = "modeTransitions";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Mode Transitions";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ComponentClassifier || bo instanceof Subcomponent || bo instanceof ComponentInstance;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof ModeTransition || bo instanceof ModeTransitionInstance;
	}
}

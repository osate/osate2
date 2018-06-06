package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.ModeTransition;
import org.osate.ge.ContentFilter;
import org.osate.ge.internal.model.Tag;

public class ModeTransitionTriggerNameFilter implements ContentFilter {
	public static final String ID = "modeTransitionTriggerNames";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Mode Transition Trigger Names";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ModeTransition;
	}

	@Override
	public boolean test(Object bo) {
		if (bo instanceof Tag) {
			final Tag tag = (Tag) bo;
			if (tag.key.equals(Tag.KEY_MODE_TRANSITION_TRIGGERS)) {
				return true;
			}
		}

		return false;
	}
}
package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.SubprogramCall;
import org.osate.ge.ContentFilter;
import org.osate.ge.internal.model.Tag;

public class CalledSubprogramFilter implements ContentFilter {
	public final static String ID = "calledSubprogram";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Called Subprogram";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof SubprogramCall;
	}

	@Override
	public boolean test(Object bo) {
		if (bo instanceof Tag) {
			final Tag tag = (Tag) bo;
			if (tag.key.equals(Tag.KEY_SUBPROGRAM_CALL_CALLED_SUBPROGRAM)) {
				return true;
			}
		}

		return false;
	}
}

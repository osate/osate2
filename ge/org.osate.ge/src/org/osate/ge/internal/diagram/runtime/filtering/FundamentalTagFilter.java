package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.ge.FundamentalContentFilter;
import org.osate.ge.internal.model.Tag;

public class FundamentalTagFilter implements FundamentalContentFilter {

	@Override
	public boolean test(Object bo) {
		if (bo instanceof Tag) {
			final Tag tag = (Tag) bo;
			if (tag.key.equals(Tag.KEY_UNIDIRECTIONAL)) {
				return true;
			}
		}

		return false;
	}

}

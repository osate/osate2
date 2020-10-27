package org.osate.ge.ba;

import org.eclipse.core.expressions.PropertyTester;
import org.osate.ge.ba.util.BehaviorAnnexSelectionUtil;

public class BehaviorAnnexPropertyTester extends PropertyTester {
	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		if ("isDiagramContext".equals(property)) {
			return BehaviorAnnexSelectionUtil.getDiagramContext().isPresent();
		}

		return false;
	}
}
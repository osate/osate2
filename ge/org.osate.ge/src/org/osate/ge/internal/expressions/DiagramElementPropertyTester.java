package org.osate.ge.internal.expressions;

import org.eclipse.core.expressions.PropertyTester;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;

/**
 * Property tester for runtime DiagramElement objects.
 *
 */
public class DiagramElementPropertyTester extends PropertyTester {
	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		final DiagramElement de = (DiagramElement) receiver;
		if (property.equals("isUndocked")) {
			return DiagramElementPredicates.isUndocked(de);
		} else if (property.equals("isMoveable")) {
			return DiagramElementPredicates.isMoveable(de);
		} else if (property.equals("isResizable")) {
			return DiagramElementPredicates.isResizeable(de);
		}
		return false;
	}

}

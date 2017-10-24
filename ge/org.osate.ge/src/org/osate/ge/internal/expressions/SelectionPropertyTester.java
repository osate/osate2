package org.osate.ge.internal.expressions;

import java.util.List;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.jface.viewers.ISelection;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.ui.tools.ToolUtil;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.internal.util.DiagamElementUtil;

/**
 * Property testers for use with objects implementing ISelection
 *
 */
public class SelectionPropertyTester extends PropertyTester {
	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		final ISelection selection = (ISelection) receiver;
		if (property.equals("allAreDiagramElementsWithSameParent")) {
			return DiagamElementUtil.allHaveSameParent(SelectionUtil.getSelectedDiagramElements(selection));
		} else if (property.equals("singleNamedElementInComponentImplementation")) { // Returns false if any element in the hierarchy up to the component
																						// implementation is not a named element.
			final List<DiagramElement> diagramElements = SelectionUtil.getSelectedDiagramElements(selection);
			return diagramElements.size() == 1
					&& ToolUtil.findComponentImplementationBoc(diagramElements.get(0)) != null;
		}
		return false;
	}
}

package org.osate.ge.internal.expressions;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.jface.viewers.ISelection;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.ui.tools.ToolUtil;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.internal.util.DiagramElementUtil;

/**
 * Property testers for use with objects implementing ISelection
 *
 */
public class SelectionPropertyTester extends PropertyTester {
	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		final ISelection selection = (ISelection) receiver;
		if (property.equals("allAreDiagramElementsWithSameParent")) {
			return DiagramElementUtil.allHaveSameParent(SelectionUtil.getSelectedDiagramElements(selection, false));
		} else if (property.equals("singleNamedElementInComponentImplementation")) { // Returns false if there is more than one element or if the element is not
			// a descendant of a component implementation or if the diagram element's BO is not a named element.
			final List<DiagramElement> diagramElements = SelectionUtil.getSelectedDiagramElements(selection, false);
			return diagramElements.size() == 1
					&& ToolUtil.findComponentImplementationBoc(diagramElements.get(0)) != null;
		} else if (property.contentEquals("namedElementsInSameComponentImplementation")) { // Returns false if all selected elements are not descendants of the
			// same component implementation or if any diagram element's BO is not a named element.
			final List<DiagramElement> diagramElements = SelectionUtil.getSelectedDiagramElements(selection, false);

			// Get component implementation ancestor for each named element
			final List<BusinessObjectContext> ciBocs = diagramElements
					.stream().map(de -> ToolUtil.findComponentImplementationBoc(de)).collect(Collectors.toList());

			// Require at least one component implement BOC and the first must be non-null.
			if (ciBocs.size() == 0 || ciBocs.get(0) == null) {
				return false;
			}

			// Require all component implementation BOCs to be equal
			final BusinessObjectContext firstBoc = ciBocs.get(0);
			return ciBocs.stream().allMatch(tmpBoc -> tmpBoc == firstBoc);
		}
		return false;
	}
}

package org.osate.mylyn.aadl.ui;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.mylyn.monitor.ui.AbstractUserInteractionMonitor;
import org.eclipse.ui.IWorkbenchPart;
import org.osate.aadl2.Element;
import org.osate.ui.utils.SelectionHelper;

public class AadlEditingMonitor extends AbstractUserInteractionMonitor {
	protected StructuredSelection currentSelection = null;

	@Override
	protected void handleWorkbenchPartSelection(final IWorkbenchPart part, final ISelection selection,
			final boolean contributeToContext) {
		EObject selectedElement = null;
		if (selection instanceof StructuredSelection) {
			final StructuredSelection structuredSelection = (StructuredSelection) selection;
			if (structuredSelection.equals(currentSelection)) {
				return;
			}
			currentSelection = structuredSelection;

			for (final Iterator<?> iterator = structuredSelection.iterator(); iterator.hasNext();) {
				final Object selectedObject = iterator.next();
				if (selectedObject instanceof Element) {
					selectedElement = (Element) selectedObject;
				}
				if (selectedElement != null) {
					super.handleElementSelection(part, selectedElement, contributeToContext);
				}
			}
		} else if (selection instanceof TextSelection) {
			selectedElement = SelectionHelper.getEObjectFromSelection(selection);
			if (selectedElement != null) {
				super.handleElementSelection(part, selectedElement, contributeToContext);
			}
		}
	}

}

package org.osate.ge.internal.ui.editor.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.services.ClipboardService;
import org.osate.ge.internal.ui.handlers.AgeHandlerUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.common.collect.ImmutableList;

public class CopyAction extends ActionStackAction {
	private final ClipboardService.Clipboard clipboard;

	public CopyAction(final IWorkbenchPart part) {
		super(part);
		setId(ActionFactory.COPY.getId());
		setText("Copy");

		// Get clipboard
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
		this.clipboard = Objects.requireNonNull(context.get(ClipboardService.class), "Unable to get clipboard service")
				.getClipboard();
	}

	@Override
	public void run() {
		final List<CopiedDiagramElement> copiedElements = new ArrayList<>();

		for (final DiagramElement de : getElementsToCopy()) {
			final DiagramElement copiedElement = de.cloneWithoutIdsAndBusinessObjects(null, de.getRelativeReference());
			final EObject bo = (EObject) de.getBusinessObject();
			final Point position = CopyAndPasteUtil.getPositionToCopy(de);
			copiedElements.add(
					new CopiedDiagramElement(copiedElement, de.getBusinessObject(), EcoreUtil.copy(bo),
							bo.eContainingFeature(), position));
		}

		clipboard.setContents(new CopiedDiagramElements(ImmutableList.copyOf(copiedElements)));
	}

	@Override
	protected boolean calculateEnabled() {
		return !getElementsToCopy().isEmpty();
	}

	/**
	 *
	 * @return the diagram elements to copy. An empty list of one or more of the selected elements is invalid.
	 */
	private static List<DiagramElement> getElementsToCopy() {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		return isValid(selectedDiagramElements) ? selectedDiagramElements : Collections.emptyList();
	}

	private static boolean isValid(final Collection<DiagramElement> diagramElements) {
		// Verify that all objects are EMF objects which are owned by a containing feature which may contain many values.
		if (!allBusinessObjectsAreEmfObjectsWithIsManyContainingFeature(diagramElements)) {
			return false;
		}

		// None of the selected diagram elements are descendants of any others.
		if (anyAreAncestors(diagramElements)) {
			return false;
		}

		return true;
	}

	private static boolean allBusinessObjectsAreEmfObjectsWithIsManyContainingFeature(final Collection<DiagramElement> diagramElements) {
		return diagramElements.stream().map(DiagramElement::getBusinessObject).allMatch(bo -> {
			if (!(bo instanceof EObject)) {
				return false;
			}

			final EObject eObj = (EObject) bo;
			final EStructuralFeature containgFeature = eObj.eContainingFeature();
			return containgFeature != null && containgFeature.isMany();
		});
	}

	/**
	 * Returns true if any of the specified elements are ancestors/descendants of any other element in the specified collection;
	 * @param diagramElements
	 * @return
	 */
	private static boolean anyAreAncestors(final Collection<DiagramElement> diagramElements) {
		for (final DiagramElement tmp : diagramElements) {
			for (DiagramNode ancestor = tmp.getParent(); ancestor != null; ancestor = ancestor.getParent()) {
				if (diagramElements.contains(ancestor)) {
					return true;
				}
			}
		}

		return false;
	}
}

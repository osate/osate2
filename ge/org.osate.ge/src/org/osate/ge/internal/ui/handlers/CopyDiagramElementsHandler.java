package org.osate.ge.internal.ui.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.services.ClipboardService;
import org.osate.ge.internal.services.ClipboardService.Clipboard;
import org.osate.ge.internal.ui.editor.actions.CopiedDiagramElement;
import org.osate.ge.internal.ui.editor.actions.CopiedDiagramElements;
import org.osate.ge.internal.ui.editor.actions.CopyAndPasteUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.common.collect.ImmutableList;

public class CopyDiagramElementsHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		boolean enabled = false;
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();

		// Require that at least one element be selected
		if (!selectedDiagramElements.isEmpty()) {
			// Require that they all have the same parent.
			final DiagramNode searchParent = selectedDiagramElements.get(0).getParent();
			enabled = selectedDiagramElements.stream().allMatch(de -> de.getParent() == searchParent);
		}

		setBaseEnabled(enabled);
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// Get clipboard. The clipboard service stores the clipboard weakly but this handler does not need to
		// because the paste action stores a strong reference to the clipboard. This isn't stored in a field by
		// the constructor because the handler is not instantiated for each editor.
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
		final Clipboard clipboard = Objects
				.requireNonNull(context.get(ClipboardService.class), "Unable to get clipboard service")
				.getClipboard();

		final List<CopiedDiagramElement> copiedElements = new ArrayList<>();

		for (final DiagramElement de : AgeHandlerUtil.getSelectedDiagramElements()) {
			final DiagramElement copiedElement = de.cloneWithoutIdsAndBusinessObjects(null, de.getRelativeReference());
			final Point position = CopyAndPasteUtil.getPositionToCopy(de);
			copiedElements.add(
					new CopiedDiagramElement(copiedElement, de.getBusinessObject(), position));
		}

		clipboard.setContents(new CopiedDiagramElements(ImmutableList.copyOf(copiedElements)));

		return null;
	}

}

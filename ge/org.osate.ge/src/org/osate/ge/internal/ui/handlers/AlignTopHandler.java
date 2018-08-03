package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.ui.handlers.AlignmentHelper.AlignmentElement;
import org.osate.ge.internal.ui.handlers.AlignmentHelper.VerticalAxis;
import org.osate.ge.internal.ui.util.UiUtil;

public class AlignTopHandler extends AbstractHandler {
	private static final AlignmentHelper alignmentHelper = AlignmentHelper.create(new VerticalAxis());

	// This handler allows for alignment of selected diagram elements that are not docked top or bottom.
	// Any selected element must not an ancestor of another selected element.
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		final List<AlignmentElement> alignmentElements = selectedDiagramElements.stream()
				.map(de -> new AlignmentElement(de, alignmentHelper.getAxisLocation()))
				.collect(Collectors.toList());

		diagram.modify("Align Top", m -> {
			final AlignmentElement primaryAlignmentElement = AlignmentHelper
					.getPrimaryAlignmentElement(alignmentElements);

			for (final AlignmentElement alignmentElement : alignmentElements) {
				alignmentHelper.alignElement(m, alignmentElement, primaryAlignmentElement.getAbsoluteLocation(),
						0);
			}
		});

		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(alignmentHelper.getEnabled());
	}
}

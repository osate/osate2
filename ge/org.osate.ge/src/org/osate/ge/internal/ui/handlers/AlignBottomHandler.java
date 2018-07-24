package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.ui.handlers.AlignmentUtil.AlignmentElement;
import org.osate.ge.internal.ui.handlers.AlignmentUtil.VerticalAlignmentUtil;
import org.osate.ge.internal.ui.util.UiUtil;

public class AlignBottomHandler extends AbstractHandler {

	// This handler allows for alignment of selected diagram elements that are not docked top or bottom.
	// Any selected element must not an ancestor of another selected element.
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		final VerticalAlignmentUtil alignmentUtil = new VerticalAlignmentUtil();
		final List<AlignmentElement> alignmentElements = selectedDiagramElements.stream()
				.map(de -> new AlignmentElement(de, alignmentUtil.getAxisLocation()))
				.collect(Collectors.toList());

		diagram.modify("Align Bottom", m -> {
			final AlignmentElement primaryAlignmentElement = AlignmentUtil
					.getPrimaryAlignmentElement(alignmentElements);

			// Location that elements will be aligned at
			final double alignLocation = primaryAlignmentElement.getDiagramRelativeLocation()
					+ primaryAlignmentElement.getDiagramElement().getHeight();

			for (int i = alignmentElements.size() - 2; i >= 0; i--) {
				final AlignmentElement alignmentElement = alignmentElements.get(i);
				alignmentUtil.alignElement(m, alignmentElement, alignLocation,
						alignmentElement.getDiagramElement().getHeight());
			}
		});

		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(AlignmentUtil.getEnabled(VerticalAlignmentUtil.isValidDockArea));
	}
}

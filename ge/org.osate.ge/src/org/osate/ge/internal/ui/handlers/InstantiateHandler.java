package org.osate.ge.internal.ui.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public class InstantiateHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		boolean enabled = false;
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil
				.getSelectedDiagramElementsFromContext(evaluationContext);
		if (selectedDiagramElements.size() == 1) {
			final Object selectedBo = selectedDiagramElements.get(0).getBusinessObject();
			enabled = selectedBo instanceof ComponentImplementation;
		}

		setBaseEnabled(enabled);
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get diagram and selected elements
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements(event);
		if (selectedDiagramElements.size() == 0) {
			throw new RuntimeException("No element selected");
		}

		final DiagramElement selectedElement = selectedDiagramElements.get(0);
		final Object bo = selectedElement.getBusinessObject();
		if(!(bo instanceof ComponentImplementation)) {
			throw new RuntimeException("BO is not a component implementation");
		}

		try {
			InstantiateModel.buildInstanceModelFile((ComponentImplementation) bo);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return null;
	}
}

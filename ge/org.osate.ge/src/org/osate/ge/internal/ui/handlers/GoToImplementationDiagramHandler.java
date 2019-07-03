package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.util.ProjectUtil;

public class GoToImplementationDiagramHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		boolean enabled = false;
		final List<BusinessObjectContext> selectedBusinessObjectContexts = AgeHandlerUtil
				.getSelectedBusinessObjectContexts();
		if (selectedBusinessObjectContexts.size() == 1) {
			final Object bo = getComponentImplementation(selectedBusinessObjectContexts.get(0).getBusinessObject());
			enabled = bo != null && ProjectUtil.getProjectForBo(bo).isPresent();
		}

		setBaseEnabled(enabled);
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get diagram and selected BOCs
		final List<BusinessObjectContext> selectedBusinessObjectContexts = AgeHandlerUtil
				.getSelectedBusinessObjectContexts();
		if (selectedBusinessObjectContexts.size() == 0) {
			throw new RuntimeException("No element selected");
		}

		final Object bo = selectedBusinessObjectContexts.get(0).getBusinessObject();

		final DiagramService diagramService = Objects.requireNonNull(Adapters.adapt(activeEditor, DiagramService.class),
				"Unable to retrieve diagram service");

		final ComponentImplementation ci = Objects.requireNonNull(getComponentImplementation(bo),
				"Unable to retrieve component implementation");
		diagramService.openOrCreateDiagramForBusinessObject(ci);

		return null;
	}

	private ComponentImplementation getComponentImplementation(final Object bo) {
		if(bo instanceof ComponentImplementation) {
			return (ComponentImplementation) bo;
		} else if(bo instanceof Subcomponent) {
			return ((Subcomponent) bo).getComponentImplementation();
		} else if (bo instanceof ComponentInstance) {
			return getComponentImplementation(((ComponentInstance) bo).getComponentClassifier());
		} else {
			return null;
		}
	}
}

package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.util.AadlSubcomponentUtil;
import org.osate.ge.internal.util.ProjectUtil;

public class OpenAssociatedDiagramHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		boolean enabled = false;
		final List<BusinessObjectContext> selectedBusinessObjectContexts = AgeHandlerUtil
				.getSelectedBusinessObjectContexts();
		if (selectedBusinessObjectContexts.size() == 1) {
			final BusinessObjectContext selectedBusinessObjectContext = selectedBusinessObjectContexts.get(0);
			final Object bo = selectedBusinessObjectContext.getBusinessObject();
			enabled = (bo instanceof AadlPackage || bo instanceof Classifier || (bo instanceof Subcomponent
					&& AadlSubcomponentUtil.getComponentClassifier(selectedBusinessObjectContext,
							(Subcomponent) bo) != null))
					&& ProjectUtil.getProjectForBo(bo).isPresent();
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

		final BusinessObjectContext selectedBusinessObjectContext = selectedBusinessObjectContexts.get(0);
		final Object bo = selectedBusinessObjectContext.getBusinessObject();

		final DiagramService diagramService = Objects.requireNonNull(Adapters.adapt(activeEditor, DiagramService.class),
				"Unable to retrieve diagram service");

		if (bo instanceof AadlPackage || bo instanceof Classifier) {
			diagramService.openOrCreateDiagramForBusinessObject(bo);
		} else if (bo instanceof Subcomponent) {
			final ComponentClassifier cc = AadlSubcomponentUtil.getComponentClassifier(selectedBusinessObjectContext,
					(Subcomponent) bo);
			if (cc != null) {
				diagramService.openOrCreateDiagramForBusinessObject(cc);
			}
		}

		return null;
	}
}

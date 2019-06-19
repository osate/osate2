package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.filtering.Filtering;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class HideElementHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get diagram and selected elements
		final AgeDiagramEditor diagramEditor = (AgeDiagramEditor) activeEditor;
		final AgeFeatureProvider featureProvider = (AgeFeatureProvider) diagramEditor.getDiagramTypeProvider()
				.getFeatureProvider();
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		final List<DiagramElement> elementsToHide = getElementsToHide(selectedDiagramElements);

		diagram.modify("Hide", m -> {
			// Hide selected elements
			for (final DiagramElement e : elementsToHide) {
				m.removeElement(e);
			}
		});

		// Update the diagram
		final IUpdateContext updateCtx = new UpdateContext(diagramEditor.getGraphitiAgeDiagram().getGraphitiDiagram());
		diagramEditor.getDiagramBehavior().executeFeature(featureProvider.getUpdateFeature(updateCtx), updateCtx);

		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(!getElementsToHide(AgeHandlerUtil.getSelectedDiagramElements()).isEmpty());
	}

	/**
	 * Gets the elements to hide. Elements are hideable if they are configurable and they are not at the root of a diagram which has a context.
	 * @param selectedDiagramElements
	 * @return
	 */
	private List<DiagramElement> getElementsToHide(final List<DiagramElement> selectedDiagramElements) {
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		final boolean diagramHasContext = diagram != null && diagram.getConfiguration().getContextBoReference() != null;

		// Get the extension registry
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final ExtensionRegistryService extService = Objects.requireNonNull(
				EclipseContextFactory.getServiceContext(bundle.getBundleContext()).get(ExtensionRegistryService.class),
				"Unable to retrieve extension registry");

		return selectedDiagramElements.stream().filter(de -> (!diagramHasContext || de.getContainer() != diagram)
				&& Filtering.isConfigurable(extService, de.getBusinessObject())).collect(Collectors.toList());
	}
}

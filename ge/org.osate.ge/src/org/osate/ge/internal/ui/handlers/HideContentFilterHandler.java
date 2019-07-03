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
import org.osate.ge.ContentFilter;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.filtering.ContentFilterProvider;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class HideContentFilterHandler extends AbstractHandler {
	public static final String PARAM_CONTENTS_FILTER_ID = "contentsFilterId";

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get diagram and selected elements
		final AgeDiagramEditor diagramEditor = (AgeDiagramEditor) activeEditor;

		final AgeFeatureProvider featureProvider = Objects.requireNonNull(
				(AgeFeatureProvider) diagramEditor.getDiagramTypeProvider().getFeatureProvider(),
				"Unable to retrieve feature provider");

		final String contentFilterId = (String) event.getParameters().get(PARAM_CONTENTS_FILTER_ID);
		if (contentFilterId == null) {
			throw new RuntimeException("Unable to get content filter");
		}

		final ContentFilterProvider contentFilterProvider = getContentFilterProvider();
		final ContentFilter filter = contentFilterProvider.getContentFilterById(contentFilterId)
				.orElseThrow(() -> new RuntimeException("Unable to get content filter"));

		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		final List<DiagramElement> elementsToRemove = selectedDiagramElements.stream()
				.filter(s -> filter.isApplicable(s.getBusinessObject()))
				.flatMap(
						s -> s.getDiagramElements().stream().filter(child -> filter.test(child.getBusinessObject())))
				.collect(Collectors.toList());

		if(!elementsToRemove.isEmpty()) {
			diagram.modify("Hide", m -> {
				for (final DiagramElement selectedDiagramElement : selectedDiagramElements) {
					if (filter.isApplicable(selectedDiagramElement.getBusinessObject())) {
						for (final DiagramElement child : selectedDiagramElement.getDiagramElements()) {
							if (filter.test(child.getBusinessObject())) {
								m.removeElement(child);
							}
						}
					}
				}
			});

			// Update the diagram
			final IUpdateContext updateCtx = new UpdateContext(diagramEditor.getGraphitiAgeDiagram().getGraphitiDiagram());
			diagramEditor.getDiagramBehavior().executeFeature(featureProvider.getUpdateFeature(updateCtx), updateCtx);
		}



		return null;
	}

	private ContentFilterProvider getContentFilterProvider() {
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final ExtensionRegistryService extService = Objects.requireNonNull(
				EclipseContextFactory.getServiceContext(bundle.getBundleContext()).get(ExtensionRegistryService.class),
				"Unable to retrieve extension registry");
		return extService;
	}
}

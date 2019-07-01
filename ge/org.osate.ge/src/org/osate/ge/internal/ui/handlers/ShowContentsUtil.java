package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.diagram.runtime.updating.FutureElementInfo;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.util.BusinessObjectProviderHelper;
import org.osate.ge.services.ReferenceBuilderService;

class ShowContentsUtil {
	/**
	 * Adds contents to the selected diagram elements. Adds all children which pass the specified filter.
	 * @param event is the ExecutionEvent of the handler which provides the active editor.
	 * @param filter is passed the parent diagram element and the business object of the potential child. If the filter returns true, then an element will be added for the business object.
	 */
	public static void addContentsToSelectedElements(final ExecutionEvent event,
			final BiFunction<DiagramElement, Object, Boolean> filter) {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		final AgeDiagramEditor diagramEditor = (AgeDiagramEditor) activeEditor;

		final ExtensionService extService = Objects.requireNonNull(
				Adapters.adapt(diagramEditor, ExtensionService.class), "Unable to retrieve extension service");
		final AgeFeatureProvider featureProvider = Objects.requireNonNull(
				(AgeFeatureProvider) diagramEditor.getDiagramTypeProvider().getFeatureProvider(),
				"Unable to retrieve feature provider");
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = diagramEditor.getAgeDiagram();
		if (diagram == null) {
			throw new RuntimeException("Unable to retrieve diagram");
		}

		final DiagramUpdater diagramUpdater = Objects.requireNonNull(featureProvider.getDiagramUpdater(),
				"Unable to retrieve diagram updater");

		final ReferenceBuilderService referenceBuilder = Objects.requireNonNull(
				Adapters.adapt(diagramEditor, ReferenceBuilderService.class),
				"Unable to retrieve reference builder service");

		if (addChildrenDuringNextUpdate(selectedDiagramElements, diagramUpdater, extService, referenceBuilder,
				filter)) {
			// Update the diagram
			final IUpdateContext updateCtx = new UpdateContext(
					diagramEditor.getGraphitiAgeDiagram().getGraphitiDiagram());
			diagramEditor.getDiagramBehavior().executeFeature(featureProvider.getUpdateFeature(updateCtx), updateCtx);
		}

	}

	/**
	 * Adds children of the specified diagram elements to the list of elements which will be added during the next diagram update.
	 * @return whether children were added to the diagram.
	 */
	private static boolean addChildrenDuringNextUpdate(final List<DiagramElement> diagramElements, final DiagramUpdater diagramUpdater,
			final ExtensionService extService, final ReferenceBuilderService referenceBuilder,
			final BiFunction<DiagramElement, Object, Boolean> filter) {
		boolean childrenAdded = false;
		try (BusinessObjectProviderHelper bopHelper = new BusinessObjectProviderHelper(extService)) {
			for (final DiagramElement selectedElement : diagramElements) {
				for (final Object childBo : bopHelper.getChildBusinessObjects(selectedElement)) {
					final RelativeBusinessObjectReference relativeReference = referenceBuilder
							.getRelativeReference(childBo);

					if (relativeReference != null
							&& selectedElement.getByRelativeReference(relativeReference) == null) {
						if (filter.apply(selectedElement, childBo)) {
							diagramUpdater.addToNextUpdate(selectedElement, relativeReference, new FutureElementInfo());
							childrenAdded = true;
						}
					}
				}
			}
		}

		return childrenAdded;
	}
}

package org.osate.ge.internal.ui.handlers;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.diagram.runtime.boTree.DiagramToBusinessObjectTreeConverter;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.services.ReferenceBuilderService;

public class ShowElementHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(AgeHandlerUtil.getSelectedBusinessObjectContexts().stream()
				.filter(boc -> !(boc instanceof DiagramNode)).findAny().isPresent());
	}

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
		final List<BusinessObjectContext> bocsToAdd = AgeHandlerUtil.getSelectedBusinessObjectContexts().stream()
				.filter(boc -> !(boc instanceof DiagramNode)).collect(Collectors.toList());
		final AgeDiagram diagram = diagramEditor.getAgeDiagram();
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		// Get services
		final DiagramUpdater diagramUpdater = featureProvider.getDiagramUpdater();
		final GraphitiService graphitiService = Objects.requireNonNull(
				Adapters.adapt(diagramEditor, GraphitiService.class), "Unable to retrieve graphiti service");
		final ReferenceBuilderService refBuilder = Objects.requireNonNull(
				Adapters.adapt(diagramEditor, ReferenceBuilderService.class), "Unable to retrieve reference builder");
		final ActionService actionService = Objects.requireNonNull(Adapters.adapt(diagramEditor, ActionService.class),
				"Unable to retrieve action service");

		final BusinessObjectNode boTree = DiagramToBusinessObjectTreeConverter.createBusinessObjectNode(diagram);

		// Add the selected elements to the business object tree
		for (final BusinessObjectContext bocToAdd : bocsToAdd) {
			// Get list of nodes that represents the path from the root to the business object context we need to add
			final LinkedList<BusinessObjectContext> bocPath = new LinkedList<>();
			for (BusinessObjectContext tmp = bocToAdd; !(tmp instanceof AgeDiagram); tmp = tmp.getParent()) {
				bocPath.addFirst(tmp);
			}

			// For each element in that path. Create BusinessObjectNode if it doesn't exist
			BusinessObjectNode parentNode = boTree;
			for (final BusinessObjectContext tmpBoc : bocPath) {
				// Get relative reference of the business object
				final RelativeBusinessObjectReference ref;
				if (tmpBoc instanceof DiagramElement) {
					ref = ((DiagramElement) tmpBoc).getRelativeReference();
				} else {
					ref = refBuilder.getRelativeReference(tmpBoc.getBusinessObject());
				}

				// Look for a matching node
				BusinessObjectNode childNode = parentNode.getChild(ref);

				// If it doesn't exist, create it
				if (childNode == null) {
					childNode = new BusinessObjectNode(parentNode, UUID.randomUUID(), ref, tmpBoc.getBusinessObject(),
							Completeness.UNKNOWN, false);
				}

				// Continue to the next element in the path using the child node as the new parent
				parentNode = childNode;
			}
		}

		// Update the diagram
		actionService.execute("Show", ExecutionMode.NORMAL, () -> {
			// Update the diagram
			diagramUpdater.updateDiagram(diagram, boTree);

			// Update layout
			diagram.modify("Layout Incrementally",
					m -> DiagramElementLayoutUtil.layoutIncrementally(diagram, m, graphitiService));

			return null;
		});

		return null;
	}
}

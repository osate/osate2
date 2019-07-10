package org.osate.ge.internal.ui.handlers;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.boTree.DiagramToBusinessObjectTreeConverter;
import org.osate.ge.internal.diagram.runtime.boTree.TreeUpdater;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.ui.dialogs.DefaultDiagramConfigurationDialogModel;
import org.osate.ge.internal.ui.dialogs.DiagramConfigurationDialog;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public class ConfigureDiagramHandler extends AbstractHandler {
	public static String COMMAND_ID = "org.osate.ge.configureDiagram";

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(!AgeHandlerUtil.getSelectedDiagramNodes().isEmpty());
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
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = diagramEditor.getAgeDiagram();
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		// Get services
		final TreeUpdater boTreeExpander = featureProvider.getBoTreeUpdater();
		final DiagramUpdater diagramUpdater = featureProvider.getDiagramUpdater();
		final GraphitiService graphitiService = Objects.requireNonNull(
				Adapters.adapt(diagramEditor, GraphitiService.class),
				"Unable to retrieve graphiti service");
		final ExtensionService extService = Objects.requireNonNull(
				Adapters.adapt(diagramEditor, ExtensionService.class),
				"Unable to retrieve extension service");
		final ProjectReferenceService referenceService = Objects
				.requireNonNull(Adapters.adapt(diagramEditor, ProjectReferenceService.class),
						"Unable to retrieve reference service");

		BusinessObjectNode boTree = DiagramToBusinessObjectTreeConverter.createBusinessObjectNode(diagram);


		// Update the tree so that it's business objects are refreshed
		boTree = boTreeExpander.expandTree(diagram.getConfiguration(), boTree);

		try (final DefaultDiagramConfigurationDialogModel model = new DefaultDiagramConfigurationDialogModel(
				referenceService, extService, graphitiService, diagram.getConfiguration().getDiagramType())) {
			// Create a BO path for the initial selection. The initial selection will be the first diagram element which will be included in the BO tree.
			Object[] initialSelectionBoPath = null;
			for (final DiagramElement selectedDiagramElement : selectedDiagramElements) {
				if (model.shouldShowBusinessObject(selectedDiagramElement.getBusinessObject())) { // Only build a selection path if the BO will be shown
					DiagramNode tmp = selectedDiagramElement;
					final LinkedList<Object> boList = new LinkedList<>();
					while (tmp instanceof DiagramElement) {
						boList.addFirst(tmp.getBusinessObject());
						tmp = tmp.getParent();
					}

					initialSelectionBoPath = boList.toArray();
					break;
				}
			}

			// Show the dialog
			final DiagramConfigurationDialog.Result result = DiagramConfigurationDialog.show(null, model,
					diagram.getConfiguration(), boTree, initialSelectionBoPath);
			if (result != null) {
				diagram.modify("Set Diagram Configuration", m -> {
					m.setDiagramConfiguration(result.getDiagramConfiguration());
					diagramUpdater.updateDiagram(diagram, result.getBusinessObjectTree());
				});
				// Clear ghosts triggered by this update to prevent them from being unghosted during the next update.
				diagramUpdater.clearGhosts();

				diagram.modify("Layout",
						m -> DiagramElementLayoutUtil.layoutIncrementally(diagram, m, graphitiService));
			}
		}

		return null;
	}
}

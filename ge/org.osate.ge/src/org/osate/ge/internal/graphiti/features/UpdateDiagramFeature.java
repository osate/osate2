package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.widgets.Display;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.diagram.runtime.layout.LayoutInfoProvider;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.SystemInstanceLoadingService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.editor.DiagramContextChecker;

public class UpdateDiagramFeature extends AbstractUpdateFeature {
	private static final String promptToRelinkMissingContextProperty = "promptToRelinkMissingContext";

	private final ActionService actionService;
	private final GraphitiService graphitiService;
	private final DiagramUpdater diagramUpdater;
	private final LayoutInfoProvider layoutInfoProvider;
	private final ProjectReferenceService projectReferenceService;
	private final SystemInstanceLoadingService systemInstanceLoader;

	private boolean wasContextValid = true;

	@Inject
	public UpdateDiagramFeature(final IFeatureProvider fp,
			final ActionService actionService,
			final GraphitiService graphitiService,
			final DiagramUpdater diagramUpdater, final LayoutInfoProvider layoutInfoProvider,
			final ProjectReferenceService projectReferenceService,
			final SystemInstanceLoadingService systemInstanceLoader) {
		super(fp);
		this.actionService = Objects.requireNonNull(actionService, "actionService must not be null");
		this.graphitiService = Objects.requireNonNull(graphitiService, "graphitiService must not be null");
		this.diagramUpdater = Objects.requireNonNull(diagramUpdater, "diagramUpdater must not be null");
		this.layoutInfoProvider = Objects.requireNonNull(layoutInfoProvider, "layoutInfoProvider must not be null");
		this.projectReferenceService = Objects.requireNonNull(projectReferenceService,
				"projectReferenceService must not be null");
		this.systemInstanceLoader = Objects.requireNonNull(systemInstanceLoader,
				"systemInstanceLoader must not be null");
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		return context.getPictogramElement() instanceof Diagram;
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		return Reason.createTrueReason();
	}

	@Override
	public boolean update(final IUpdateContext context) {
		final AgeDiagram ageDiagram = graphitiService.getGraphitiAgeDiagram().getAgeDiagram();

		// Get the editor
		final AgeDiagramEditor editor = graphitiService.getEditor();
		if (editor != null) {
			// Check the context
			Display.getCurrent().syncExec(() -> {
				final boolean promptToRelink = editor.getGraphicalViewer().getControl() != null
						&& editor.getGraphicalViewer().getControl().isVisible() && (wasContextValid
								|| Boolean.TRUE.equals(context.getProperty(promptToRelinkMissingContextProperty)));
				final DiagramContextChecker contextChecker = new DiagramContextChecker(graphitiService.getProject(),
						projectReferenceService, systemInstanceLoader);
				final DiagramContextChecker.Result result = contextChecker.checkContextIncrementalBuild(ageDiagram,
						promptToRelink);
				wasContextValid = result.isContextValid(); // Store for next execution
				editor.setDiagramContextIsValid(result.isContextValid()); // Update editor with new state
			});

			if (!wasContextValid) {
				return false;
			}
		}

		// Updating the diagram should not be part of the undo stack. The layout portion is not included in the action because
		// layout needs to be undoable.
		actionService.execute("Update Diagram", ExecutionMode.APPEND_ELSE_HIDE, () -> {
			// Update the diagram
			diagramUpdater.updateDiagram(ageDiagram);

			// Perform the layout as a separate operation because the sizes for the shapes are assigned by the Graphiti modification listener.
			ageDiagram.modify("Layout Incrementally",
					m -> DiagramElementLayoutUtil.layoutIncrementally(ageDiagram, m, layoutInfoProvider));

			return null;
		});

		return true;
	}

	/**
	 *
	 * @param pe
	 * @param promptToRelinkMissingContext if true, then the user will be prompted to relink a missing context even if the user has been previously prompted. Prompts only occur if editor is visible.
	 * @return
	 */
	public static IUpdateContext createUpdateContext(final PictogramElement pe,
			final boolean promptToRelinkMissingContext) {
		final UpdateContext updateContext = new UpdateContext(pe);
		updateContext.putProperty(promptToRelinkMissingContextProperty, promptToRelinkMissingContext);
		return updateContext;
	}
}

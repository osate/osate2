package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IContext;
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
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.editor.DiagramContextChecker;

public class UpdateDiagramFeature extends AbstractUpdateFeature implements ICustomUndoRedoFeature {
	private static final String promptToRelinkMissingContextProperty = "promptToRelinkMissingContext";

	private final GraphitiService graphitiService;
	private final DiagramUpdater diagramUpdater;
	private final LayoutInfoProvider layoutInfoProvider;
	private final ProjectReferenceService projectReferenceService;

	private boolean wasContextValid = true;

	@Inject
	public UpdateDiagramFeature(final IFeatureProvider fp,
			final GraphitiService graphitiService,
			final DiagramUpdater diagramUpdater, final LayoutInfoProvider layoutInfoProvider,
			final ProjectReferenceService projectReferenceService) {
		super(fp);
		this.graphitiService = Objects.requireNonNull(graphitiService, "graphitiService must not be null");
		this.diagramUpdater = Objects.requireNonNull(diagramUpdater, "diagramUpdater must not be null");
		this.layoutInfoProvider = Objects.requireNonNull(layoutInfoProvider, "layoutInfoProvider must not be null");
		this.projectReferenceService = Objects.requireNonNull(projectReferenceService,
				"projectReferenceService must not be null");
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
						projectReferenceService);
				final DiagramContextChecker.Result result = contextChecker.checkContextIncrementalBuild(ageDiagram,
						promptToRelink);
				wasContextValid = result.isContextValid(); // Store for next execution
				editor.setDiagramContextIsValid(result.isContextValid()); // Update editor with new state
			});

			if (!wasContextValid) {
				return false;
			}
		}

		// Update the diagram
		diagramUpdater.updateDiagram(ageDiagram);

		// Perform the layout as a separate operation because the sizes for the shapes are assigned by the Graphiti modification listener.
		ageDiagram.modify("Update Diagram",
				m -> DiagramElementLayoutUtil.layoutIncrementally(ageDiagram, m, layoutInfoProvider));

		return true;
	}

	// ICustomUndoRedoFeature
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}

	@Override
	public void preUndo(final IContext context) {
	}

	@Override
	public void postUndo(final IContext context) {
	}

	@Override
	public boolean canRedo(final IContext context) {
		return false;
	}

	@Override
	public void preRedo(final IContext context) {
	}

	@Override
	public void postRedo(final IContext context) {
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

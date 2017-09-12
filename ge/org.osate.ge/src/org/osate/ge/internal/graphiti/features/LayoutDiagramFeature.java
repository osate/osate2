package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DiagramModifier;
import org.osate.ge.internal.diagram.runtime.layout.DiagramLayoutUtil;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;

public class LayoutDiagramFeature extends AbstractCustomFeature implements ICustomUndoRedoFeature {
	private final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider;
	
	@Inject
	public LayoutDiagramFeature(final IFeatureProvider fp, final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider) {
		super(fp);
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
	}
	
	@Override
	public String getName() {
		return "Layout Diagram";
	}

	@Override
	public String getDescription() {
		return "Reposition all shapes and connections in the diagram.";
	}
	
	@Override
	public boolean canExecute(final ICustomContext context) {
		return true;
	}
	
	@Override
	public void execute(final ICustomContext context) {
		final AgeDiagram ageDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getAgeDiagram();
		ageDiagram.modify("Layout Diagram", new DiagramModifier() {
			@Override
			public void modify(final DiagramModification m) {
				DiagramLayoutUtil.layout(ageDiagram, m, true);	
				AgeFeatureUtil.storeModificationInContext(context, m);
			}						
		});
	}
	
	// ICustomUndoRedoFeature
	@Override
	public boolean canUndo(final IContext context) {
		return AgeFeatureUtil.canUndo(context);
	}
	
	@Override
	public void preUndo(final IContext context) {
	}

	@Override
	public void postUndo(final IContext context) {
		AgeFeatureUtil.undoModification(graphitiAgeDiagramProvider.getGraphitiAgeDiagram(), context);
	}

	@Override
	public boolean canRedo(final IContext context) {
		return AgeFeatureUtil.canRedo(context);
	}

	@Override
	public void preRedo(final IContext context) {
	}

	@Override
	public void postRedo(final IContext context) {
		AgeFeatureUtil.redoModification(graphitiAgeDiagramProvider.getGraphitiAgeDiagram(), context);
	}
}

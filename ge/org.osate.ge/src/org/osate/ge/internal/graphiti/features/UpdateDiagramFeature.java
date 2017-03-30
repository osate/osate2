package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.DiagramLayoutUtil;
import org.osate.ge.internal.diagram.DiagramModification;
import org.osate.ge.internal.diagram.DiagramModifier;
import org.osate.ge.internal.diagram.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;

public class UpdateDiagramFeature extends AbstractUpdateFeature implements ICustomUndoRedoFeature {
	private final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider;
	private final DiagramUpdater diagramUpdater;
	
	@Inject
	public UpdateDiagramFeature(final IFeatureProvider fp, 
			final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider,
			final DiagramUpdater diagramUpdater) {
		super(fp);
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
		this.diagramUpdater = Objects.requireNonNull(diagramUpdater, "diagramUpdater must not be null");
	}
		
	@Override
	public boolean canUpdate(IUpdateContext context) {
		return context.getPictogramElement() instanceof Diagram;
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		return null;
	}

	@Override
	public boolean update(final IUpdateContext context) {
		final AgeDiagram ageDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getAgeDiagram();
		
		// Update the diagram
		diagramUpdater.updateDiagram(ageDiagram);		
		
		// Perform the layout as a separate operation because the sizes for the shapes are assigned by the Graphiti modification listener.
		ageDiagram.modify(new DiagramModifier() {
			@Override
			public void modify(final DiagramModification m) {
				DiagramLayoutUtil.layout(ageDiagram, m, false);
			}
		});
		
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
}

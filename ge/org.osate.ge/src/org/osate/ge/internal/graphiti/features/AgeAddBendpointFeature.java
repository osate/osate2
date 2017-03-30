package org.osate.ge.internal.graphiti.features;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddBendpointContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.impl.DefaultAddBendpointFeature;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.diagram.DiagramModification;
import org.osate.ge.internal.diagram.DiagramModifier;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;

public class AgeAddBendpointFeature extends DefaultAddBendpointFeature implements ICustomUndoRedoFeature {
	private final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider;
	
	@Inject
	public AgeAddBendpointFeature(final IFeatureProvider fp, final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider) {
		super(fp);
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
	}

	@Override
	public void addBendpoint(final IAddBendpointContext ctx) {
		final GraphitiAgeDiagram graphitiAgeDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram();
		final DiagramElement connectionElement = (DiagramElement)graphitiAgeDiagram.getDiagramNode(ctx.getConnection());
		if(connectionElement != null) {
			graphitiAgeDiagram.modify(new DiagramModifier() {					
				@Override
				public void modify(final DiagramModification m) {
					// Update the bendpoints
					final List<org.osate.ge.internal.diagram.Point> newBendpoints = new ArrayList<>(connectionElement.getBendpoints());
					newBendpoints.add(ctx.getBendpointIndex(), new org.osate.ge.internal.diagram.Point(ctx.getX(), ctx.getY()));
					m.setBendpoints(connectionElement, newBendpoints);
					AgeFeatureUtil.storeModificationInContext(ctx, m);
				}
			});
		}		
	}
	
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

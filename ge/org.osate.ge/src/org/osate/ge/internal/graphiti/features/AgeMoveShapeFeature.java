package org.osate.ge.internal.graphiti.features;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.AbstractMoveShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DiagramModifier;
import org.osate.ge.internal.diagram.runtime.Point;
import org.osate.ge.internal.graphics.AgeConnection;
import org.osate.ge.internal.graphics.AgeShape;
import org.osate.ge.internal.graphics.Label;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.graphiti.graphics.AgeGraphitiGraphicsUtil;

public class AgeMoveShapeFeature extends AbstractMoveShapeFeature implements ICustomUndoRedoFeature {
	private final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider;
	
	@Inject
	public AgeMoveShapeFeature(
			final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider,
			final IFeatureProvider fp) {
		super(fp);
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
	}
	
	@Override
	public boolean canMoveShape(final IMoveShapeContext ctx) {
		// Don't allow changing the container
		if(ctx.getSourceContainer() == null || ctx.getSourceContainer() != ctx.getTargetContainer()) {
			return false;
		}
		
		final DiagramElement element = graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getDiagramElement(ctx.getShape());
		if(element == null) {
			return false;
		}

		if(!(element.getGraphic() instanceof AgeShape)) {
			return false;
		}
		
		// Don't allow moving label decorations
		if(element.getGraphic() instanceof Label) {
			return false;
		}
		
		final Shape container = ctx.getShape().getContainer();
		if(!(container instanceof Diagram)) {
			if(container != null) {
				if(element.getDockArea() == null) {
					final GraphicsAlgorithm containerInnerGa = AgeGraphitiGraphicsUtil.getInnerGraphicsAlgorithm(container.getGraphicsAlgorithm());
					if(ctx.getX() < containerInnerGa.getX() || 
							ctx.getY() < containerInnerGa.getY() ||
							ctx.getX() >= containerInnerGa.getX() + containerInnerGa.getWidth() ||
							ctx.getY() >= containerInnerGa.getY() + containerInnerGa.getHeight()) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	@Override
	public void moveShape(final IMoveShapeContext context) {
		final GraphitiAgeDiagram graphitiAgeDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram();

		final DiagramElement diagramElement = graphitiAgeDiagram.getDiagramElement(context.getShape());
		graphitiAgeDiagram.modify(new DiagramModifier() {
			@Override
			public void modify(final DiagramModification m) {
				final int dx = context.getX() - diagramElement.getX();
				final int dy = context.getY() - diagramElement.getY();
				
				m.setPosition(diagramElement, new Point(context.getX(), context.getY()));
				updateBendpointsForContainedConnections(m, diagramElement, dx, dy);
				AgeFeatureUtil.storeModificationInContext(context, m);
			}				
		});	
	}

	void updateBendpointsForContainedConnections(final DiagramModification m, 
			final DiagramElement shapeDiagramElement, 
			final int dx, 
			final int dy) {
		for(final DiagramElement child : shapeDiagramElement.getDiagramElements()) {
			if(child.getGraphic() instanceof AgeConnection) {
				final List<Point> bendpoints = child.getBendpoints();
				if(bendpoints.size() > 0) {
					final List<Point> newBendpoints = bendpoints.stream().map((p) -> new Point(p.x+dx, p.y+dy)).collect(Collectors.toList());
					m.setBendpoints(child, newBendpoints);
				}
			}
			
			updateBendpointsForContainedConnections(m, child, dx, dy);
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

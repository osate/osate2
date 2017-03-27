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
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.internal.DockArea;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.diagram.DiagramModification;
import org.osate.ge.internal.diagram.DiagramModifier;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.diagram.Point;
import org.osate.ge.internal.graphics.AgeConnection;
import org.osate.ge.internal.graphics.AgeShape;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.graphiti.graphics.AgeGraphitiGraphicsUtil;
import org.osate.ge.internal.services.PropertyService;

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
		
		final DiagramNode diagramNode = graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getDiagramNode(ctx.getShape());
		if(!(diagramNode instanceof AgeDiagramElement)) {
			return false;
		}
		
		final AgeDiagramElement element = (AgeDiagramElement)diagramNode;
		if(!(element.getGraphic() instanceof AgeShape)) {
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
		moveShape(context.getShape(), context.getX(), context.getY(), true);
	}

	private void moveShape(final Shape shape, final int x, final int y, final boolean updateGraphitiDiagram) {
		final GraphitiAgeDiagram graphitiAgeDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram();
		final AgeDiagramElement diagramElement = (AgeDiagramElement)graphitiAgeDiagram.getDiagramNode(shape);
		graphitiAgeDiagram.modify(new DiagramModifier() {
			@Override
			public void modify(final DiagramModification m) {
				final int dx = x - diagramElement.getPosition().x;
				final int dy = y - diagramElement.getPosition().y;
				
				m.setPosition(diagramElement, new Point(x, y));
				updateBendpointsForContainedConnections(m, diagramElement, dx, dy);			
			}				
		}, updateGraphitiDiagram);		
	}
	
	void updateBendpointsForContainedConnections(final DiagramModification m, 
			final AgeDiagramElement shapeDiagramElement, 
			final int dx, 
			final int dy) {
		for(final AgeDiagramElement child : shapeDiagramElement.getDiagramElements()) {
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
	public void preUndo(final IContext context) {
	}

	@Override
	public void postUndo(final IContext ctx) {
		final IMoveShapeContext context = (IMoveShapeContext)ctx;
		final Shape shape = context.getShape();
		final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		moveShape(shape, ga.getX(), ga.getY(), false);
	}

	@Override
	public boolean canRedo(final IContext context) {
		return true;
	}

	@Override
	public void preRedo(final IContext context) {
	}

	@Override
	public void postRedo(final IContext ctx) {
		final IMoveShapeContext context = (IMoveShapeContext)ctx;
		moveShape(context.getShape(), context.getX(), context.getY(), false);
	}
}

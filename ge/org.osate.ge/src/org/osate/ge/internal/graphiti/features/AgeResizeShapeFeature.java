package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.diagram.DiagramModification;
import org.osate.ge.internal.diagram.DiagramModifier;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.diagram.Dimension;
import org.osate.ge.internal.diagram.Point;
import org.osate.ge.internal.graphics.AgeShape;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;

/**
 * A resize shape feature that is used by default for the AADL Graphical Editor
 *
 */
public class AgeResizeShapeFeature extends DefaultResizeShapeFeature {
	private final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider;
	
	@Inject
	public AgeResizeShapeFeature(
			final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider,
			final IFeatureProvider fp) {
		super(fp);
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
	}
	
	@Override
	public boolean canResizeShape(final IResizeShapeContext ctx) {
		final DiagramNode diagramNode = graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getDiagramNode(ctx.getShape());
		if(!(diagramNode instanceof AgeDiagramElement)) {
			return false;
		}
		
		final AgeDiagramElement element = (AgeDiagramElement)diagramNode;
		if(!(element.getGraphic() instanceof AgeShape)) {
			return false;
		}
		
		if(!((AgeShape)element.getGraphic()).isResizeable()) {
			return false;
		}
		
		// Ensure that the resize won't move the shape outside of its container
		final Shape shape = ctx.getShape();
		final Shape container = shape.getContainer();
		if(!(container instanceof Diagram) && ctx.getDirection() != IResizeShapeContext.DIRECTION_UNSPECIFIED) {
			final GraphicsAlgorithm containerInnerGa = container.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0);
			if((ctx.getX() != shape.getGraphicsAlgorithm().getX() &&
					(ctx.getX() < containerInnerGa.getX() || 
					ctx.getX() > containerInnerGa.getX() + containerInnerGa.getWidth())) ||
				(ctx.getY() != shape.getGraphicsAlgorithm().getY() &&
					(ctx.getY() < containerInnerGa.getY() ||
					ctx.getY() > containerInnerGa.getY() + containerInnerGa.getHeight()))) {
				return false;
			}
		}
		
		return super.canResizeShape(ctx);
	}
	
	@Override
	public void resizeShape(final IResizeShapeContext context) {
		final GraphitiAgeDiagram graphitiAgeDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram();
		final AgeDiagramElement diagramElement = (AgeDiagramElement)graphitiAgeDiagram.getDiagramNode(context.getShape());
		graphitiAgeDiagram.modify(new DiagramModifier() {
			@Override
			public void modify(DiagramModification m) {
				m.setPosition(diagramElement, new Point(context.getX(), context.getY()));
				m.setSize(diagramElement, new Dimension(context.getWidth(), context.getHeight()));
			}				
		});
	}
}

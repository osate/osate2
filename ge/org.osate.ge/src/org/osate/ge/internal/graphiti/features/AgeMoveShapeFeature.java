package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.AbstractMoveShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.internal.AgeShape;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.graphiti.graphics.AgeGraphitiGraphicsUtil;

public class AgeMoveShapeFeature extends AbstractMoveShapeFeature {
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

		if(!DiagramElementPredicates.isMoveable(element)) {
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
		graphitiAgeDiagram.modify("Move Shape", m -> {
			m.setPosition(diagramElement, new Point(context.getX(), context.getY()), true, false);
		});
	}
}

package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveConnectionDecoratorContext;
import org.eclipse.graphiti.features.impl.DefaultMoveConnectionDecoratorFeature;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.ShapeNames;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.graphiti.diagram.PropertyUtil;

public class AgeMoveConnectionDecoratorFeature extends DefaultMoveConnectionDecoratorFeature {
	private final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider;

	@Inject
	public AgeMoveConnectionDecoratorFeature(final IFeatureProvider fp, final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider) {
		super(fp);
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
	}

	@Override
	public boolean canMoveConnectionDecorator(final IMoveConnectionDecoratorContext context) {
		final GraphitiAgeDiagram graphitiAgeDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram();

		// Allow moving the decorator if we can retrieve the diagram element for it.
		if(graphitiAgeDiagram.getDiagramElement(context.getConnectionDecorator()) != null) {
			return true;
		}

		// Otherwise, only support moving connection decorators for connection name labels for which we can find the diagram element
		if(ShapeNames.primaryLabelShapeName.equals(PropertyUtil.getName(context.getConnectionDecorator())) &&
				graphitiAgeDiagram.getDiagramElement(context.getConnectionDecorator().getConnection()) != null) {
			return true;
		}

		return false;
	}

	@Override
	public void moveConnectionDecorator(final IMoveConnectionDecoratorContext context) {
		final GraphitiAgeDiagram graphitiAgeDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram();
		final DiagramElement decoratorDiagramElement = graphitiAgeDiagram.getDiagramElement(context.getConnectionDecorator());
		if(decoratorDiagramElement == null) {
			final DiagramElement connectionElement = graphitiAgeDiagram.getDiagramElement(context.getConnectionDecorator().getConnection());
			graphitiAgeDiagram.modify("Move Connection Decorator", m -> {
				m.setConnectionPrimaryLabelPosition(connectionElement, new Point(context.getX(), context.getY()));
			});
		} else {
			graphitiAgeDiagram.modify("Move Connection Decorator", m -> {
				m.setPosition(decoratorDiagramElement, new Point(context.getX(), context.getY()));
			});
		}
	}
}

package org.osate.ge.internal.graphiti.features;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveBendpointContext;
import org.eclipse.graphiti.features.impl.DefaultMoveBendpointFeature;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;

public class AgeMoveBendpointFeature extends DefaultMoveBendpointFeature {
	private final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider;

	@Inject
	public AgeMoveBendpointFeature(final IFeatureProvider fp, final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider) {
		super(fp);
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
	}

	@Override
	public boolean moveBendpoint(final IMoveBendpointContext ctx) {
		final GraphitiAgeDiagram graphitiAgeDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram();
		final DiagramElement connectionElement = graphitiAgeDiagram.getDiagramElement(ctx.getConnection());
		if(connectionElement != null) {
			graphitiAgeDiagram.modify("Move Bendpoint", m -> {
				// Update the bendpoint
				final List<org.osate.ge.graphics.Point> newBendpoints = new ArrayList<>(connectionElement.getBendpoints());
				newBendpoints.set(ctx.getBendpointIndex(), new org.osate.ge.graphics.Point(ctx.getX(), ctx.getY()));
				m.setBendpoints(connectionElement, newBendpoints);
			});
		}

		return true;
	}
}

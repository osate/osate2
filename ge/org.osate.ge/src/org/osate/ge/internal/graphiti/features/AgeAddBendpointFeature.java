package org.osate.ge.internal.graphiti.features;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddBendpointContext;
import org.eclipse.graphiti.features.impl.DefaultAddBendpointFeature;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;

public class AgeAddBendpointFeature extends DefaultAddBendpointFeature {
	private final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider;

	@Inject
	public AgeAddBendpointFeature(final IFeatureProvider fp, final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider) {
		super(fp);
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
	}

	@Override
	public void addBendpoint(final IAddBendpointContext ctx) {
		final GraphitiAgeDiagram graphitiAgeDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram();
		final DiagramElement connectionElement = graphitiAgeDiagram.getDiagramElement(ctx.getConnection());
		if(connectionElement != null) {
			graphitiAgeDiagram.modify("Add Bendpoint", m -> {
				// Update the bendpoints
				final List<org.osate.ge.graphics.Point> newBendpoints = new ArrayList<>(connectionElement.getBendpoints());
				newBendpoints.add(ctx.getBendpointIndex(), new org.osate.ge.graphics.Point(ctx.getX(), ctx.getY()));
				m.setBendpoints(connectionElement, newBendpoints);
			});
		}
	}
}

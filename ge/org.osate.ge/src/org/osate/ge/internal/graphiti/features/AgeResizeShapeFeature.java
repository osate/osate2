/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.graphiti.features;

import java.util.Objects;
import java.util.stream.Stream;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.internal.AgeShape;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
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
		final DiagramElement element = graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getDiagramElement(ctx.getShape());
		if(element == null) {
			return false;
		}

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
		final DiagramElement diagramElement = graphitiAgeDiagram.getDiagramElement(context.getShape());
		graphitiAgeDiagram.modify("Resize Shape", m -> {
			DiagramElementLayoutUtil.moveElement(m, diagramElement,
					new Point(context.getX(), context.getY()));

			if (diagramElement.hasSize() && diagramElement.getDockArea() != null) {
				// Find amount to shift bendpoints and flow indicator positions
				final Point delta = new Point((context.getWidth() - diagramElement.getWidth()) / 2.0,
						(context.getHeight() - diagramElement.getHeight()) / 2.0);

				// Only want to shift those related to this exact element
				DiagramElementLayoutUtil.shiftRelatedConnections(Stream.of(diagramElement), delta, m, true,
						true, false);

			}
			m.setSize(diagramElement, new Dimension(context.getWidth(), context.getHeight()));


		});
	}
}

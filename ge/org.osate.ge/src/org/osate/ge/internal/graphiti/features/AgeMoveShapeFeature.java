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
import org.osate.ge.internal.diagram.runtime.DockArea;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.graphiti.graphics.AgeGraphitiGraphicsUtil;

public class AgeMoveShapeFeature extends AbstractMoveShapeFeature {
	public static final String DOCK_AREA_CHANGED = "org.osate.ge.dock_area_changed";

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

		// Move shape doesn't adjust the bendpoints and flow indicators because those are updated as a group after the shapes are moved.
		// This is important in cases where multiple shapes are moved.
		final DiagramElement diagramElement = graphitiAgeDiagram.getDiagramElement(context.getShape());
		graphitiAgeDiagram.modify("Move Shape", m -> {
			final DockArea originalDockArea = diagramElement.getDockArea();
			DiagramElementLayoutUtil.moveElement(m, diagramElement, new Point(context.getX(), context.getY()), true,
					false, false);

			context.putProperty(DOCK_AREA_CHANGED, originalDockArea != diagramElement.getDockArea());
		});
	}
}

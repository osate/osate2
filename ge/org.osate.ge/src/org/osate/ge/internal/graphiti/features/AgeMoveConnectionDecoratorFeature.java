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

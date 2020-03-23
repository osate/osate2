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
package org.osate.ge.internal.graphiti.services.impl;

import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.internal.FeatureGraphic;
import org.osate.ge.graphics.internal.FeatureGraphicType;
import org.osate.ge.graphics.internal.Label;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphiti.ShapeNames;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.graphiti.diagram.LayoutUtil;
import org.osate.ge.internal.graphiti.diagram.ShapeUtil;
import org.osate.ge.internal.graphiti.graphics.AgeGraphitiGraphicsUtil;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.internal.ui.editor.AgeDiagramBehavior;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public class DefaultGraphitiService implements GraphitiService {
	private final IDiagramTypeProvider dtp;
	private final IFeatureProvider fp;

	public DefaultGraphitiService(final IDiagramTypeProvider dtp, final IFeatureProvider fp) {
		this.dtp = Objects.requireNonNull(dtp, "dtp must not be null");
		this.fp = Objects.requireNonNull(fp, "fp must not be null");
	}

	@Override
	public Diagram getDiagram() {
		return dtp.getDiagram();
	}

	@Override
	public IDiagramTypeProvider getDiagramTypeProvider() {
		return dtp;
	}

	@Override
	public IFeatureProvider getFeatureProvider() {
		return fp;
	}

	@Override
	public IProject getProject() {
		return ((AgeDiagramBehavior)dtp.getDiagramBehavior()).getProject();
	}

	@Override
	public GraphitiAgeDiagram getGraphitiAgeDiagram() {
		return ((AgeDiagramBehavior)dtp.getDiagramBehavior()).getGraphitiAgeDiagram();
	}

	@Override
	public EditingDomain getEditingDomain() {
		return ((AgeDiagramBehavior)dtp.getDiagramBehavior()).getEditingDomain();
	}

	@Override
	public AgeDiagram getAgeDiagram() {
		return ((AgeDiagramBehavior)dtp.getDiagramBehavior()).getAgeDiagram();
	}

	@Override
	public AgeDiagramEditor getEditor() {
		return (AgeDiagramEditor)((AgeDiagramBehavior)dtp.getDiagramBehavior()).getDiagramContainer();
	}

	@Override
	public Dimension getPrimaryLabelSize(final DiagramElement de) {
		return getChildShapeSize(de, ShapeNames.primaryLabelShapeName);
	}

	@Override
	public Dimension getAnnotationLabelSize(final DiagramElement de) {
		return getChildShapeSize(de, ShapeNames.annotationShapeName);
	}

	@Override
	public Dimension getPortGraphicSize(final DiagramElement dockedElement) {
		final Graphic g = dockedElement.getGraphic();
		if (g instanceof FeatureGraphic) {
			final FeatureGraphic fg = (FeatureGraphic) g;
			if (fg.featureType == FeatureGraphicType.FEATURE_GROUP) {
				return AgeGraphitiGraphicsUtil.featureGroupCircleSize;
			}
		}

		// Return the default feature size regardless of the type of graphic
		return AgeGraphitiGraphicsUtil.defaultFeatureSize;
	}

	@Override
	public Dimension getLabelsSize(final DiagramElement dockedElement) {
		double width = 0;
		double height = 0;

		// Primary Label
		final GraphicsAlgorithm primaryLabelGa = getChildShapeGraphicsAlgorithm(dockedElement,
				ShapeNames.primaryLabelShapeName);
		if (primaryLabelGa != null) {
			width = Math.max(width, primaryLabelGa.getWidth());
			height += primaryLabelGa.getHeight();
		}

		// Annotation
		final GraphicsAlgorithm annotationGa = getChildShapeGraphicsAlgorithm(dockedElement,
				ShapeNames.annotationShapeName);
		if (annotationGa != null) {
			width = Math.max(width, annotationGa.getWidth());
			height += annotationGa.getHeight();
		}

		// Secondary shapes
		for (final DiagramElement child : dockedElement.getDiagramElements()) {
			if (child.getGraphic() instanceof Label) {
				final Dimension secondaryLabelSize = getPrimaryLabelSize(child);
				if (secondaryLabelSize != null) {
					width = Math.max(width, secondaryLabelSize.width);
					height += secondaryLabelSize.height;
				}
			}
		}

		return new Dimension(width + LayoutUtil.labelPadding, height + LayoutUtil.labelPadding);
	}

	private Dimension getChildShapeSize(final DiagramElement de, final String shapeName) {
		final GraphicsAlgorithm ga = getChildShapeGraphicsAlgorithm(de, shapeName);
		return ga == null ? new Dimension(0, 0) : new Dimension(ga.getWidth(), ga.getHeight());
	}

	private GraphicsAlgorithm getChildShapeGraphicsAlgorithm(final DiagramElement de, final String shapeName) {
		final GraphitiAgeDiagram graphitiAgeDiagram = getGraphitiAgeDiagram();
		if (graphitiAgeDiagram == null) {
			return null;
		}

		final PictogramElement pe = graphitiAgeDiagram.getPictogramElement(de);
		if (pe == null) {
			return null;
		}

		final Shape targetShape = getChildShapeByName(pe, shapeName);
		if (targetShape == null) {
			return null;

		}
		return targetShape.getGraphicsAlgorithm();
	}

	private static Shape getChildShapeByName(final PictogramElement pe, final String name) {
		if (pe instanceof Connection) {
			return ShapeUtil.getShapeByName(((Connection) pe).getConnectionDecorators(), name);
		} else if (pe instanceof ContainerShape) {
			return ShapeUtil.getShapeByName(((ContainerShape) pe).getChildren(), name);
		} else {
			throw new RuntimeException("Unexpected pictogram element: " + pe);
		}
	}

	@Override
	public boolean execute(final String label, final ExecutionMode mode, final AgeAction action) {
		return ((AgeDiagramBehavior) dtp.getDiagramBehavior()).getActionExecutor().execute(label, mode, action);
	}
}

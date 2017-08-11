/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IWorkbenchPart;
import org.osate.ge.internal.Activator;

public class RadialLayoutAction extends SelectionAction {
	private AgeDiagramEditor editor;
	public static final String RADIAL_LAYOUT = "org.osate.ge.ui.editor.items.radial_layout";
	public static final ImageDescriptor radialImageDescriptor = Activator.getImageDescriptor("icons/RadialLayout.gif");
	public static final ImageDescriptor radialDisabledImageDescriptor = Activator.getImageDescriptor("icons/RadialLayout_Disabled.gif");

	public RadialLayoutAction(final IWorkbenchPart part) {
		super(part); 
		editor = Objects.requireNonNull((AgeDiagramEditor)part, "part must be a AgeDiagramEditor");
		setHoverImageDescriptor(radialImageDescriptor);
		setDisabledImageDescriptor(radialDisabledImageDescriptor);
		setId(RADIAL_LAYOUT);
	}

	/**
	 * Lays out selected shapes in a radial pattern
	 */
	@Override
	public void run(){
		editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain(), "Radial Layout") {
			@Override
			protected void doExecute() {
				final Collection<MoveShapeContext> ctxs = getMoveShapeContextsFromEditorSelection();
				if(ctxs != null) {
					for (final MoveShapeContext ctx : ctxs) {
						final IFeatureProvider fp = editor.getDiagramTypeProvider().getFeatureProvider();
						final IMoveShapeFeature feature = fp.getMoveShapeFeature(ctx);
						feature.execute(ctx);
					}	
				}
			}
		});
	}

	/**
	 * Updates whether action is available based on if shapes selected are valid
	 */
	@Override
	protected boolean calculateEnabled() {
		return getMoveShapeContextsFromEditorSelection() != null;
	}

	/**
	 * Performs validation, builds, and returns a collection of contexts
	 * @return the contexts. Returns null if validation fails.
	 */
	private Collection<MoveShapeContext> getMoveShapeContextsFromEditorSelection() {
		final PictogramElement[] pes = editor.getSelectedPictogramElements();
		if(pes.length < 2) {
			return null;
		}

		if(!LayoutUtil.areAllUndockedMoveableShapes(pes, editor.getGraphitiAgeDiagram())) {
			return null;
		}

		final Shape[] shapes = Arrays.copyOf(editor.getSelectedPictogramElements(), pes.length, Shape[].class);
		if(!LayoutUtil.haveSameContainerShapes(shapes)) {
			return null;
		}

		final Collection<MoveShapeContext> moveShapeCtxs = getMoveShapeContexts(shapes);
		return moveShapeCtxs;
	}

	/**
	 * Calculate the selected shapes new radial layout location information
	 * @param shapes the selected shapes
	 * @return the list contexts that contain the shapes new locations
	 */
	private static Collection<MoveShapeContext> getMoveShapeContexts(final Shape[] shapes) {
		final Collection<MoveShapeContext> results = new ArrayList<MoveShapeContext>();
		final List<Double> angles = new ArrayList<>();
		final ContainerShape container = shapes[0].getContainer();
		final double padding = 25;
		double radius = 0;
		double sizeOfShapes = 0;
		double circumference = -1;
		
		// Find appropriate radius for shapes
		while((sizeOfShapes > circumference) || (Double.isNaN(sizeOfShapes))) {
			sizeOfShapes = 0;
			angles.clear();
			radius++;
			circumference = 2*Math.PI*radius;
			
			for(final Shape shape : shapes) {
				final GraphicsAlgorithm shapeGA = shape.getGraphicsAlgorithm();
				// Get largest dimension of shape
				final double shapeDimension = ((shapeGA.getWidth() > shapeGA.getHeight() ? shapeGA.getWidth() : shapeGA.getHeight()) + padding) / 2;

				// Calculate diagonal of shape
				final double shapeSize = Math.sqrt((Math.pow(shapeDimension, 2) + Math.pow(shapeDimension, 2)));

				// Calculate angle for shape diagonal using Law of Cosines and double it
				final double angle = Math.acos((Math.pow(radius, 2) + Math.pow(radius, 2) - Math.pow(shapeSize, 2)) / (2*radius*radius)) * 2;

				angles.add(angle);
				sizeOfShapes += (circumference * (angle/(2*Math.PI)));
			}
		}

		final Point center = getCenter(shapes, radius);
		double placementAngle = 0;
		int i = 0;
		for(final Shape shape : shapes) {
			final GraphicsAlgorithm shapeGA = shape.getGraphicsAlgorithm();
			double spacingAngle = angles.get(i++);

			// Center of placement
			placementAngle += spacingAngle/2;

			// Calculate where to place shape
			long x = Math.round(center.x + radius * Math.cos(placementAngle) - shapeGA.getWidth()/2);
			long y = Math.round(center.y + radius * Math.sin(placementAngle) - shapeGA.getHeight()/2);

			// End of placement
			placementAngle += spacingAngle/2;

			results.add(LayoutUtil.getDistributeMoveShapeContext(shape, new BigDecimal(x).intValue(), new BigDecimal(y).intValue(), container));
		}

		return results;
	}

	private static Point getCenter(final Shape[] shapes, final double radius) {
		final int boarderPadding = 10;
		int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE, yMin = Integer.MAX_VALUE, yMax = Integer.MIN_VALUE;
		int maxWidth = Integer.MIN_VALUE, maxHeight = Integer.MIN_VALUE;

		// Get min and max values for x and y axis.
		// Get max dimension of shapes
		for(final Shape shape : shapes) {
			final GraphicsAlgorithm shapeGA = shape.getGraphicsAlgorithm();

			final int width = shapeGA.getWidth()/2;
			final int height = shapeGA.getHeight()/2;
			
			final int x = shapeGA.getX() + width;
			final int y = shapeGA.getY() + height;
			
			if(x < xMin) {
				xMin = x;
			}

			if(x > xMax) {
				xMax = x;
			}

			if(y < yMin) {
				yMin = y;
			}

			if(y > yMax) {
				yMax = y;
			}

			if(maxWidth < width) {
				maxWidth = width;
			}

			if(maxHeight < height) {
				maxHeight = height;
			}
		}

		// Calculate center point
		int xCenter = (xMin + xMax) / 2;
		int yCenter = (yMax + yMin) / 2;
		
		// Move center point to appropriate location if necessary
		if(xCenter - radius - maxWidth < 0) {
			xCenter += Math.abs(xCenter - radius - maxWidth) + boarderPadding;
		}

		if(yCenter - radius - maxHeight < 0) {
			yCenter += Math.abs(yCenter - radius - maxHeight) + boarderPadding;
		}

		return new Point(xCenter, yCenter);
	}
}
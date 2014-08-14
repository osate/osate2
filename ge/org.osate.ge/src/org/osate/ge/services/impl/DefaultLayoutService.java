/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.services.impl;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Feature;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.LayoutService;
import org.osate.ge.services.VisibilityService;

public class DefaultLayoutService implements LayoutService {
	private final VisibilityService visibilityService;
	private final BusinessObjectResolutionService bor;
	private final IFeatureProvider fp;
	
	public DefaultLayoutService(final VisibilityService visibilityHelper, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		this.visibilityService = visibilityHelper;
		this.bor = bor;
		this.fp = fp;
	}	
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ResizeService#checkContainerSize(org.eclipse.graphiti.mm.pictograms.ContainerShape)
	 */
	@Override
	public void checkContainerSize(final ContainerShape shape) {
		// Check if the shape is entirely in the container
		final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		final int endX = ga.getX() + ga.getWidth();
		final int endY = ga.getY() + ga.getHeight();
		final ContainerShape container = shape.getContainer();
		final GraphicsAlgorithm containerGa = container.getGraphicsAlgorithm();
		if(ga.getX() < 0 || ga.getY() < 0 || containerGa.getWidth() < endX || containerGa.getHeight() < endY) {
			// Call the update feature on the container to adjust the size
			final UpdateContext context = new UpdateContext(container);
			final IUpdateFeature feature = fp.getUpdateFeature(context);
			if(feature != null) {
				if(feature.canUpdate(context)) {
					feature.update(context);
					
					// Refresh the diagram visualization
					fp.getDiagramTypeProvider().getDiagramBehavior().refresh();
				}
			}
		}		
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ResizeService#checkSize(org.eclipse.graphiti.mm.pictograms.ContainerShape)
	 */
	@Override
	public boolean checkSize(final ContainerShape container) {
		boolean updateShape = false;
		
		// Check if the shape is entirely in the container
		final GraphicsAlgorithm containerGa = container.getGraphicsAlgorithm();
		for(final Shape child : container.getChildren()) {
			final GraphicsAlgorithm childGa = child.getGraphicsAlgorithm();
			final int endX = childGa.getX() + childGa.getWidth();
			final int endY = childGa.getY() + childGa.getHeight();
			if(childGa.getX() < 0 || childGa.getY() < 0 || containerGa.getWidth() < endX || containerGa.getHeight() < endY) {
				updateShape = true;
				break;
			}	
		}
		
		if(updateShape) {
			// Call the update feature on the shape to adjust the size
			final UpdateContext context = new UpdateContext(container);
			final IUpdateFeature feature = fp.getUpdateFeature(context);
			if(feature != null) {
				if(feature.canUpdate(context)) {
					feature.update(context);
					return true;
				}
			}
		}
		
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.UpdateService#layoutChildren(org.eclipse.graphiti.mm.pictograms.ContainerShape)
	 */
	@Override
	public void layoutChildren(final ContainerShape shape) {
		// Layout the children first
		for(final Shape child : visibilityService.getNonGhostChildren(shape)) {
			final LayoutContext ctx = new LayoutContext(child);
			final ILayoutFeature feature = fp.getLayoutFeature(ctx);
			if(feature != null && feature.canLayout(ctx)) {
				feature.layout(ctx);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ClassifierService#adjustChildShapePositions(org.eclipse.graphiti.mm.pictograms.ContainerShape)
	 */
	@Override
	public int[] adjustChildShapePositions(final ContainerShape shape) {
		// Determine the extra width needed to hold AADL features
		int featureWidth = 80;
		for(final Shape childShape : shape.getChildren()) {
			if(bor.getBusinessObjectForPictogramElement(childShape) instanceof Feature) {
				featureWidth = Math.max(featureWidth, childShape.getGraphicsAlgorithm().getWidth() + 30);
			}
		}		
		
		// Determine how much to shift the X and Y of the children by based on the position of children shapes that are not tied to features
		// Start at 0 and track the first valid child rather than a large initial value because even though features are not used to determine how much to shift, they
		// are shifted.
		boolean firstRelevantChild = true;
		int shiftX = 0;
		int shiftY = 0;
		for(final Shape childShape : shape.getChildren()) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			final Object childBo = bor.getBusinessObjectForPictogramElement(childShape);
			if(childBo != null && !(childBo instanceof Feature)) {
				if(firstRelevantChild) {
					shiftX = childGa.getX()-featureWidth;
					shiftY = childGa.getY()-30;
					firstRelevantChild = false;
				} else {
					shiftX = Math.min(shiftX, childGa.getX()-featureWidth);
					shiftY = Math.min(shiftY, childGa.getY()-30);				
				}
			}
		}
		
		// Calculate max width and height
		int maxWidth = 300;
		int maxHeight = 300;
		for(final Shape childShape : shape.getChildren()) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			
			// Determine the needed width and height of the classifier shape
			// Do not consider features when calculating needed width. Otherwise, features on the right side of the shape would prevent the width from shrinking
			final Object childBo = bor.getBusinessObjectForPictogramElement(childShape);
			if(childBo != null && !(childBo instanceof Feature)) {				
				maxWidth = Math.max(maxWidth, childGa.getX() + childGa.getWidth() - shiftX + featureWidth);
			}			
			maxHeight = Math.max(maxHeight, childGa.getY() + childGa.getHeight() - shiftY);
			
			// Update the position of the child
			childGa.setX(childGa.getX()-shiftX);
			childGa.setY(childGa.getY()-shiftY);
		}

		return new int[] { maxWidth, maxHeight+25};
	}
}

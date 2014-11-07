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
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Feature;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.ProcessorFeature;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.LayoutService;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.VisibilityService;

public class DefaultLayoutService implements LayoutService {
	private final PropertyService propertyService;
	private final VisibilityService visibilityService;
	private final BusinessObjectResolutionService bor;
	private final IFeatureProvider fp;
	
	public DefaultLayoutService(final PropertyService propertyService, final VisibilityService visibilityHelper, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		this.propertyService = propertyService;
		this.visibilityService = visibilityHelper;
		this.bor = bor;
		this.fp = fp;
	}	
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ResizeService#checkContainerSize(org.eclipse.graphiti.mm.pictograms.ContainerShape)
	 */
	@Override
	public boolean checkContainerSize(final ContainerShape shape) {
		final ContainerShape container = shape.getContainer();		
		if(checkSize(container)) {
			checkContainerSize(container);			
			return true;
		}		
		
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ResizeService#checkSize(org.eclipse.graphiti.mm.pictograms.ContainerShape)
	 */
	@Override
	public boolean checkSize(final ContainerShape container) {
		if(container instanceof Diagram) {
			return false;
		}
		
		boolean layoutShape = false;
		
		// Check if the shape is entirely in the container
		final GraphicsAlgorithm containerGa = container.getGraphicsAlgorithm();
		for(final Shape child : container.getChildren()) {
			final GraphicsAlgorithm childGa = child.getGraphicsAlgorithm();
			final int endX = childGa.getX() + childGa.getWidth();
			final int endY = childGa.getY() + childGa.getHeight();
			if(childGa.getX() < 0 || childGa.getY() < 0 || containerGa.getWidth() < endX || containerGa.getHeight() < endY) {
				layoutShape = true;
				break;
			}	
		}
		
		if(layoutShape) {
			final LayoutContext context = new LayoutContext(container);
			final ILayoutFeature feature = fp.getLayoutFeature(context);
			if(feature != null && feature.canLayout(context)) {
				feature.layout(context);
				return true;
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
			if(isFeature(bor.getBusinessObjectForPictogramElement(childShape))) {
				featureWidth = Math.max(featureWidth, childShape.getGraphicsAlgorithm().getWidth() + 30);
			}
		}		
		
		// Determine how much to shift the X and Y of the children by based on the position of children shapes that are not tied to features. Shift values must always be greater than or equal to 0
		int shiftX = 0;
		int shiftY = 0;
		//for(final Shape childShape : shape.getChildren()) {
		for(final Shape childShape :  visibilityService.getNonGhostChildren(shape)) {
			final Object childBo = bor.getBusinessObjectForPictogramElement(childShape);
			final boolean childIsFeature = isFeature(childBo);
			
			if(!propertyService.isManuallyPositioned(childShape) || propertyService.isLayedOut(childShape) || childIsFeature) {
				final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
				if(childBo != null) {
					// Currently features are only allowed to be on the left and right edges so don't take them into account when deciding to shift left or right
					// TODO: When features are allowed to be snapped to the top and bottom, need to take into account feature position
					if(!childIsFeature) {
						shiftX = Math.max(shiftX, featureWidth - childGa.getX());		
					}
					
					shiftY = Math.max(shiftY, 30-childGa.getY());				
				}
			}
		}
		
		// Calculate max width and height
		final GraphicsAlgorithm shapeGa = shape.getGraphicsAlgorithm();
		int maxWidth = Math.max(150, shapeGa == null ? 0 : (shapeGa.getWidth() + shiftX));
		int maxHeight = Math.max(50, shapeGa == null ? 0 : (shapeGa.getHeight() + shiftY));

		//for(final Shape childShape : shape.getChildren()) {
		for(final Shape childShape :  visibilityService.getNonGhostChildren(shape)) {
			final Object childBo = bor.getBusinessObjectForPictogramElement(childShape);
			final boolean childIsFeature = isFeature(childBo);
			if(propertyService.isManuallyPositioned(childShape) || propertyService.isLayedOut(childShape) || childIsFeature) {
				final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
				
				// TODO: Will need to consider with instead of height of features if features are snapped to top or bottom
				// Determine the needed width and height of the classifier shape
				// Do not consider features when calculating needed width. Otherwise, features on the right side of the shape would prevent the width from shrinking
				if(!childIsFeature) {	
					maxWidth = Math.max(maxWidth, childGa.getX() + childGa.getWidth() + shiftX + featureWidth);
				}			
				maxHeight = Math.max(maxHeight, childGa.getY() + childGa.getHeight() + shiftY + 25);
				
				// Update the position of the child
				childGa.setX(childGa.getX()+shiftX);
				childGa.setY(childGa.getY()+shiftY);
			}
		}

		return new int[] { maxWidth, maxHeight };
	}
	
	/**
	 * Returns whether an element is any type of feature. That includes internal and processor features.
	 * @param bo
	 * @return
	 */
	private boolean isFeature(final Object bo) {
		return bo instanceof Feature || bo instanceof InternalFeature || bo instanceof ProcessorFeature;
	}
}

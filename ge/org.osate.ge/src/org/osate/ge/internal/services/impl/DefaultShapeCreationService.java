/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.util.List;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.aadl2.Element;
import org.osate.aadl2.Mode;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.LayoutService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ShapeCreationService;
import org.osate.ge.internal.services.ShapeService;

public class DefaultShapeCreationService implements ShapeCreationService {
	private final ShapeService shapeService;
	private final PropertyService propertyService;
	private final LayoutService layoutService;
	private IFeatureProvider fp;
	
	public DefaultShapeCreationService(final ShapeService shapeService, final PropertyService propertyService, final LayoutService layoutService, final IFeatureProvider fp) {
		this.shapeService = shapeService;
		this.propertyService = propertyService;
		this.layoutService = layoutService;
		this.fp = fp;
	}

	@Override
	public void createUpdateFeatureShapes(final ContainerShape shape, final List<? extends Object> features) {	
		createUpdateShapes(shape, features, 0, false, 25, 45, true, 5);
	}

	@Override
	public void createUpdateModeShapes(final ContainerShape shape, final List<Mode> modes) {
		createUpdateShapes(shape, modes, 80, false, 25, 25, true, 5);
	}
	
	@Override
	public void createUpdateShapes(final ContainerShape shape, final List<? extends Object> bos, final int startX, final boolean incX, final int xPadding, final int startY, final boolean incY, final int yPadding) {
		int childX = startX;
		int childY = startY;

		for(final Object bo : bos) {
			PictogramElement pictogramElement = shapeService.getChildShapeByReference(shape, bo);
			if(pictogramElement == null) {
				final AddContext addContext = new AddContext();
				addContext.setNewObject(bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);
				addContext.setTargetContainer(shape);
				addContext.setX(childX);
				addContext.setY(childY);
				final IAddFeature feature = fp.getAddFeature(addContext);
				if(feature != null && feature.canAdd(addContext)) {
					pictogramElement = feature.add(addContext);
					if(incX) {
						childX += pictogramElement.getGraphicsAlgorithm().getWidth() + xPadding;
					}
					
					if(incY) {
						childY += pictogramElement.getGraphicsAlgorithm().getHeight() + yPadding;
					}
				}
			} else {
				final UpdateContext updateContext = new UpdateContext(pictogramElement);
				final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
				
				// Update the shape regardless of whether it is "needed" or not.
				if(updateFeature != null && updateFeature.canUpdate(updateContext)) {
					updateFeature.update(updateContext);
				}
			}
		}
	}
	
	@Override
	public boolean createUpdateShape(final ContainerShape container, final Object bo) {
		final PictogramElement pictogramElement = shapeService.getChildShapeByReference(container, bo);
		if(pictogramElement == null) {					
			final AddContext addContext = new AddContext();
			addContext.setNewObject(bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);
			addContext.setTargetContainer(container);
			addContext.setX(0);
			addContext.setY(0);
			
			final IAddFeature addFeature = fp.getAddFeature(addContext);
			if(addFeature != null && addFeature.canAdd(addContext)) {
				addFeature.add(addContext);
				return true;
			}
		} else {				
			final UpdateContext updateContext = new UpdateContext(pictogramElement);
			final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
			
			// Update the classifier regardless of whether it is "needed" or not.
			if(updateFeature != null && updateFeature.canUpdate(updateContext)) {
				updateFeature.update(updateContext);
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public Shape createShape(final ContainerShape container, final Object bo, final int x, final int y) {
		if(bo == null) {
			return null;
		}
			
		Shape newShape = (ContainerShape)shapeService.getDescendantShapeByReference(container, bo);

		// If the update feature hasn't been called, add the shape to the diagram. This is preferred rather than waiting because otherwise the container
		// will be resized based on the original location for the shape.
		if(newShape == null) {
			final AddContext addContext = new AddContext();
			addContext.setTargetContainer(container);
			addContext.setNewObject(bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);				
			
			// Execute the add feature
			final IAddFeature addFeature = fp.getAddFeature(addContext);
			if(addFeature != null && addFeature.canAdd(addContext)) {
				addFeature.execute(addContext);
			}

			// Try to find the shape again
			newShape = shapeService.getDescendantShapeByReference(container, bo);			
		}
			
		if(newShape != null) {
			Graphiti.getGaService().setLocation(newShape.getGraphicsAlgorithm(), x, y);
			propertyService.setIsLayedOut(newShape, true);
			layoutService.checkShapeBoundsWithAncestors((ContainerShape)newShape);
		}

		return newShape;
	}
}

/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.services.impl;

import java.util.Collection;
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
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.services.LayoutService;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.ShapeCreationService;
import org.osate.ge.services.ShapeService;

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
	public void createUpdateFeatureShapes(final ContainerShape shape, final List<? extends NamedElement> features, final Collection<Shape> touchedShapes) {	
		createUpdateShapesForElements(shape, features, 0, false, 25, 45, true, 5, touchedShapes);
	}

	@Override
	public void createUpdateModeShapes(final ContainerShape shape, final List<Mode> modes, final Collection<Shape> touchedShapes) {
		createUpdateShapesForElements(shape, modes, 80, false, 25, 25, true, 5, touchedShapes);
	}
	
	@Override
	public void createUpdateShapesForElements(final ContainerShape shape, final List<? extends NamedElement> elements, final int startX, final boolean incX, final int xPadding, final int startY, final boolean incY, final int yPadding, final Collection<Shape> touchedShapes) {
		int childX = startX;
		int childY = startY;

		for(final NamedElement element : elements) {
			PictogramElement pictogramElement = shapeService.getChildShapeByReference(shape, element);
			if(pictogramElement == null) {
				final AddContext addContext = new AddContext();
				addContext.setNewObject(new AadlElementWrapper(element));
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

			if(touchedShapes != null && pictogramElement instanceof Shape) {
				touchedShapes.add((Shape)pictogramElement);
			}
		}
	}
	
	@Override
	public PictogramElement createUpdateShapeForElement(final ContainerShape container, final NamedElement element) {
		PictogramElement pictogramElement = shapeService.getChildShapeByReference(container, element);
		if(pictogramElement == null) {					
			final AddContext addContext = new AddContext();
			addContext.setNewObject(new AadlElementWrapper(element));
			addContext.setTargetContainer(container);
			addContext.setX(0);
			addContext.setY(0);
			
			final IAddFeature addFeature = fp.getAddFeature(addContext);
			if(addFeature != null && addFeature.canAdd(addContext)) {			
				pictogramElement = addFeature.add(addContext);
			}
		} else {				
			final UpdateContext updateContext = new UpdateContext(pictogramElement);
			final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
			
			// Update the classifier regardless of whether it is "needed" or not.
			if(updateFeature != null && updateFeature.canUpdate(updateContext)) {
				updateFeature.update(updateContext);
			}
		}
		
		return pictogramElement;
	}
	
	@Override
	public Shape createShape(final ContainerShape container, final NamedElement el, final int x, final int y) {
		if(el == null) {
			return null;
		}
			
		Shape newShape = (ContainerShape)shapeService.getDescendantShapeByReference(container, el);

		// If the update feature hasn't been called, add the shape to the diagram. This is preferred rather than waiting because otherwise the container
		// will be resized based on the original location for the shape.
		if(newShape == null) {
			final AddContext addContext = new AddContext();
			addContext.setTargetContainer(container);
			addContext.setNewObject(new AadlElementWrapper(el));				
			
			// Execute the add feature
			final IAddFeature addFeature = fp.getAddFeature(addContext);
			if(addFeature != null && addFeature.canAdd(addContext)) {
				addFeature.execute(addContext);
			}

			// Try to find the shape again
			newShape = shapeService.getDescendantShapeByReference(container, el);			
		}
			
		if(newShape != null) {
			Graphiti.getGaService().setLocation(newShape.getGraphicsAlgorithm(), x, y);
			propertyService.setIsLayedOut(newShape, true);
			layoutService.checkShapeBoundsWithAncestors((ContainerShape)newShape);
		}

		return newShape;
	}
}

/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.services.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.services.LayoutService;
import edu.uah.rsesc.aadl.age.services.PropertyService;
import edu.uah.rsesc.aadl.age.services.ShapeCreationService;
import edu.uah.rsesc.aadl.age.services.ShapeService;

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
	public void createUpdateFeatureShapes(final ContainerShape shape, final List<Feature> features, final Collection<Shape> touchedShapes) {	
		createUpdateShapesForElements(shape, features, 0, false, 25, 45, true, 5, true, touchedShapes);
	}
	
	@Override
	public void createUpdateModeShapes(final ContainerShape shape, final List<Mode> modes) {
		createUpdateShapesForElements(shape, modes, 80, false, 25, 25, true, 5);
	}
	
	@Override
	public void createUpdateShapesForElements(final ContainerShape shape, final List<? extends NamedElement> elements, final int startX, final boolean incX, final int xPadding, final int startY, final boolean incY, final int yPadding) {
		createUpdateShapesForElements(shape, elements, startX, incX, xPadding, startY, incY, yPadding, false, null);
	}
	
	/**
	 * 
	 * @param shape
	 * @param elements
	 * @param fp
	 * @param startX
	 * @param incX
	 * @param xPadding
	 * @param startY
	 * @param incY
	 * @param yPadding
	 * @param touchedShapes a list to populate with the shapes that were created/updated. Can be null.
	 */
	private void createUpdateShapesForElements(final ContainerShape shape, final List<? extends NamedElement> elements, final int startX, final boolean incX, final int xPadding, final int startY, final boolean incY, final int yPadding, final boolean checkForOverlapOnCreate, final Collection<Shape> touchedShapes) {
		// TODO: Could find an X and Y that doens't overlap existing one. Or wait until layout algorithm is implemented.
		int childX = startX;
		int childY = startY;
		for(final NamedElement element : elements) {
			PictogramElement pictogramElement = shapeService.getChildShapeByElementQualifiedName(shape, element);
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
					
					if(checkForOverlapOnCreate) {
						final GraphicsAlgorithm newGa = pictogramElement.getGraphicsAlgorithm();
						
						boolean intersects;
						// TODO: Need to call move feature?
						// TODO: Loop cap?
						do	{
							final int minX1 = newGa.getX();
							final int minY1 = newGa.getY();
							final int maxX1 = newGa.getX() + newGa.getWidth();
							final int maxY1 = newGa.getY() + newGa.getHeight();
							
							intersects = false;
							for(final Shape child : shape.getChildren()) {
								if(child != pictogramElement) {
									final GraphicsAlgorithm childGa = child.getGraphicsAlgorithm();
									final int minX2 = childGa.getX();
									final int minY2 = childGa.getY();
									final int maxX2 = childGa.getX() + childGa.getWidth();
									final int maxY2 = childGa.getY() + childGa.getHeight();
									
									if(minX1 < maxX2 && maxX1 > minX2 && minY1 < maxY2 && maxY1 > minY2) {
										if(incX) {
											newGa.setX(maxX2 + xPadding);
										}
		
										if(incY) {
											newGa.setY(maxY2 + yPadding);
										}
	
										intersects = true;
										break;
									}
								}
							}
						} while(intersects);
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
	public Shape createShape(final ContainerShape container, final NamedElement el, final int x, final int y) {
		if(el == null) {
			return null;
		}
			
		Shape newShape = (ContainerShape)shapeService.getDescendantShapeByElementQualifiedName(container, el);

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
			newShape = shapeService.getDescendantShapeByElementQualifiedName(container, el);			
		}
			
		if(newShape != null) {
			Graphiti.getGaService().setLocation(newShape.getGraphicsAlgorithm(), x, y);
			propertyService.setIsLayedOut(newShape, true);
			
			// Update the size of the container
			layoutService.checkContainerSize((ContainerShape)newShape);
		}

		return newShape;
	}
}

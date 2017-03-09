/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.Element;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.ShapeCreationService;
import org.osate.ge.internal.services.ShapeService;

public class DefaultShapeCreationService implements ShapeCreationService {
	private final ShapeService shapeService;
	private IFeatureProvider fp;
	
	public DefaultShapeCreationService(final ShapeService shapeService, final IFeatureProvider fp) {
		this.shapeService = shapeService;
		this.fp = fp;
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
}

/*******************************************************************************
 * Copyright (C) 2015 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.osate.aadl2.Element;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.GraphicsAlgorithmCreationService;
import org.osate.ge.internal.services.LabelService;
import org.osate.ge.internal.services.PropertyService;

public class DefaultLabelService implements LabelService {
	private final PropertyService propertyService;
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreationService;
	private final IFeatureProvider featureProvider;
	
	public DefaultLabelService(final PropertyService propertyService, final GraphicsAlgorithmCreationService graphicsAlgorithmCreationService, final IFeatureProvider featureProvider) {
		this.propertyService = propertyService;
		this.graphicsAlgorithmCreationService = graphicsAlgorithmCreationService;
		this.featureProvider = featureProvider;
	}
	
	@Override
	public Shape createLabelShape(final ContainerShape container, final String shapeName, final Object bo, final String labelValue) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
        final Shape labelShape = peCreateService.createShape(container, true);
        propertyService.setName(labelShape, shapeName);
        propertyService.setIsManuallyPositioned(labelShape, true);
        propertyService.setIsTransient(labelShape, true);
        
        if(bo != null) {
        	featureProvider.link(labelShape, bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);
        }
        
        final GraphicsAlgorithm labelBackground = graphicsAlgorithmCreationService.createTextBackground(labelShape);		
        final Text labelText = graphicsAlgorithmCreationService.createLabelGraphicsAlgorithm(labelBackground, labelValue);
        
        // Get sizes of text graphics algorithms
        final IDimension labelTextSize = GraphitiUi.getUiLayoutService().calculateTextSize(labelText.getValue(), labelText.getStyle().getFont());
        final IGaService gaService = Graphiti.getGaService();
		gaService.setSize(labelBackground, labelTextSize.getWidth(), labelTextSize.getHeight());
		gaService.setSize(labelText, labelTextSize.getWidth(), labelTextSize.getHeight());
		
        return labelShape;
	}

}

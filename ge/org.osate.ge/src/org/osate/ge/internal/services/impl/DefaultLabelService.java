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
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Element;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.LabelService;
import org.osate.ge.internal.services.PropertyService;

public class DefaultLabelService implements LabelService {
	private final PropertyService propertyService;
	private final IFeatureProvider featureProvider;
	
	public DefaultLabelService(final PropertyService propertyService, final IFeatureProvider featureProvider) {
		this.propertyService = propertyService;
		this.featureProvider = featureProvider;
	}
	
	@Override
	public Shape createLabelShape(final ContainerShape container, final String shapeName, final Object bo, final String labelValue) {
		return createLabelShape(container, shapeName, bo, labelValue, true);
	}
	
	@Override
	public Shape createLabelShape(final ContainerShape container, final String shapeName, final Object bo, final String labelValue, final boolean includeBackground) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
        final Shape labelShape = peCreateService.createShape(container, true);
        propertyService.setName(labelShape, shapeName);
        propertyService.setIsManuallyPositioned(labelShape, true);
        propertyService.setIsTransient(labelShape, true);
        
        if(bo != null) {
        	featureProvider.link(labelShape, bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);
        }
        
        final GraphicsAlgorithm labelBackground;
        final Text labelText;
        final Diagram diagram = featureProvider.getDiagramTypeProvider().getDiagram();
        if(includeBackground) {
        	labelBackground = createTextBackground(diagram, labelShape);		
        	labelText = createLabelGraphicsAlgorithm(diagram, labelBackground, labelValue);
        } else {
        	labelBackground = null;
        	labelText = createLabelGraphicsAlgorithm(diagram, labelShape, labelValue);
        }
        
        // Get sizes of text graphics algorithms
        final IDimension labelTextSize = GraphitiUi.getUiLayoutService().calculateTextSize(labelText.getValue(), labelText.getFont());
        
        // Add padding to the text size to account for rounding issues in GEF3/Graphiti
        final int paddedLabelTextWidth = labelTextSize.getWidth() + Math.max(15, labelText.getValue().length());
        final int paddedLabelTextHeight = labelTextSize.getHeight() + 5;
        final IGaService gaService = Graphiti.getGaService();
        if(labelBackground != null) {
        	gaService.setSize(labelBackground, paddedLabelTextWidth, paddedLabelTextHeight);
        }
		gaService.setSize(labelText, paddedLabelTextWidth, paddedLabelTextHeight);
		
        return labelShape;
	}
	
	@Override
	public void setStyle(final Text text) {
		final Diagram diagram = featureProvider.getDiagramTypeProvider().getDiagram();
		setStyle(diagram, text);
	}

	private static GraphicsAlgorithm createTextBackground(final Diagram diagram, final GraphicsAlgorithmContainer container) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm background = gaService.createPlainRectangle(container);
		background.setBackground(gaService.manageColor(diagram, IColorConstant.WHITE));
		background.setLineVisible(false);
		background.setFilled(true);
		background.setTransparency(0.2);
	
		return background;
	}
	
	private static Text createLabelGraphicsAlgorithm(final Diagram diagram, final GraphicsAlgorithmContainer container, final String labelTxt) {
		final IGaService gaService = Graphiti.getGaService();
		final Text text = gaService.createPlainText(container, labelTxt);
		setStyle(diagram, text);
        
        return text;
	}
	
	public static void setStyle(final Diagram diagram, final Text text) {
		final IGaService gaService = Graphiti.getGaService();
		text.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
		text.setFilled(false);
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setFont(gaService.manageFont(diagram, "Arial", getScaledFontPointSize(10.0), false, true));
	}
	
	private static int getScaledFontPointSize(final double unscaledFontSize) {
		final Device device = Display.getCurrent();
		// Round to 1 decimal point before casting to int. 
		// This ensures that the value is rounded up only in cases where the value is within .1 of a whole number
		final int fontSizeInPoints = (int)(Math.round(unscaledFontSize*96.0/device.getDPI().y*10.0)/10.0);
		return fontSizeInPoints;
	}
}

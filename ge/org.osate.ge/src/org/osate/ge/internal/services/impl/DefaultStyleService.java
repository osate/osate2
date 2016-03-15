/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.StyleService;

public class DefaultStyleService implements StyleService {
	private final IFeatureProvider fp;
	private final ExtensionService extensionService;
	
	public DefaultStyleService(final IFeatureProvider fp, final ExtensionService extensionService) {
		this.fp = fp;
		this.extensionService = extensionService;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.StyleService#getStyle(org.eclipse.graphiti.mm.pictograms.Diagram, java.lang.String)
	 */
	@Override
	public Style getStyle(final String styleId) {
		final IGaService gaService = Graphiti.getGaService();
		final Diagram diagram  = getDiagram();
        final Style style = gaService.findStyle(diagram, styleId);
    	
        // If it does not exist, create it
        if(style == null) {
        	final Object styleFactory = extensionService.getStyleFactory(styleId);
        	final IEclipseContext context = Objects.requireNonNull(extensionService, "extensionService must not be null").createChildContext();
        	try {
	        	context.set(Names.STYLE_ID, styleId);
	        	return (Style)ContextInjectionFactory.invoke(styleFactory, Activate.class, context);
        	} finally {
        		context.dispose();
        	}
        }
		
		return style;
	}

	@Override
	public void refreshStyles() {
		// Remove all styles. Styles will be recreated as needed
		getDiagram().getStyles().clear();	
				
		// Refresh shape styles
		refreshStyles(getDiagram());
		
		// Refresh connection styles
		for(final Connection connection : getDiagram().getConnections()) {
			refreshStyles(connection);
		}
	}
	
	private void refreshStyles(final Shape shape) {
		refreshStyles(shape.getGraphicsAlgorithm());
		
		// Refresh the style of child shapes
		if(shape instanceof ContainerShape) {
			for(final Shape child : ((ContainerShape)shape).getChildren()) {
				refreshStyles(child);
			}	
		}
		
		// Refresh the styles for the anchors
		for(final Anchor anchor : shape.getAnchors()) {
			refreshStyles(anchor.getGraphicsAlgorithm());
		}
	}
	
	private void refreshStyles(final Connection connection) {
		refreshStyles(connection.getGraphicsAlgorithm());
		
		// Refresh the style for the decorators
		for(final ConnectionDecorator cd : connection.getConnectionDecorators()) {
			refreshStyles(cd);
		}
	}
	
	private void refreshStyles(final GraphicsAlgorithm ga) {
		// Get an updated version of the current style
		if(ga != null) {
			final Style oldStyle = ga.getStyle();
			if(oldStyle != null) {
				final String styleId = ga.getStyle().getId();
				final Style style = getStyle(styleId);

				// Set the style
				ga.setStyle(style);
			}
			
			// Handle children
			for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
				refreshStyles(childGa);
			}
		}
	}
	
	private Diagram getDiagram() {
		return fp.getDiagramTypeProvider().getDiagram();
	}
}

/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
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
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.styles.StyleConstants;

public class DefaultStyleService implements StyleService {
	private static final Map<String, Object> styleIdToFactoryMap = new HashMap<>();
	private final IFeatureProvider fp;
	private final IEclipseContext context;
	
	static void createStyleFactory(final Class<?> factoryClass, final String styleId) {
		try {
			styleIdToFactoryMap.put(styleId, factoryClass.newInstance());
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	static {
		createStyleFactory(org.osate.ge.internal.styles.ClassifierStyleFactory.class, "classifier");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "system");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "system-implementation");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "process");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "process-implementation");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "subprogram");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "subprogram-implementation"); 	
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "data");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "data-implementation");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "bus");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "bus-implementation");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "processor");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "processor-implementation");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "device");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "device-implementation");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "memory");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "memory-implementation"); 	
	 	createStyleFactory(org.osate.ge.internal.styles.DashedComponentTypeStyleFactory.class, "thread-group");
	 	createStyleFactory(org.osate.ge.internal.styles.DashedComponentTypeStyleFactory.class, "thread-group-implementation");
	 	createStyleFactory(org.osate.ge.internal.styles.DashedComponentTypeStyleFactory.class, "thread");
	 	createStyleFactory(org.osate.ge.internal.styles.DashedComponentTypeStyleFactory.class, "thread-implementation");
	 	createStyleFactory(org.osate.ge.internal.styles.DashedComponentTypeStyleFactory.class, "subprogram-group");
	 	createStyleFactory(org.osate.ge.internal.styles.DashedComponentTypeStyleFactory.class, "subprogram-group-implementation"); 	
	 	createStyleFactory(org.osate.ge.internal.styles.DashedComponentTypeStyleFactory.class, "abstract");
	 	createStyleFactory(org.osate.ge.internal.styles.DashedComponentTypeStyleFactory.class, "abstract-implementation");
	 	createStyleFactory(org.osate.ge.internal.styles.DashedComponentTypeStyleFactory.class, "virtual-bus");
	 	createStyleFactory(org.osate.ge.internal.styles.DashedComponentTypeStyleFactory.class, "virtual-bus-implementation");
	 	createStyleFactory(org.osate.ge.internal.styles.DashedComponentTypeStyleFactory.class, "virtual-processor");
	 	createStyleFactory(org.osate.ge.internal.styles.DashedComponentTypeStyleFactory.class, "virtual-processor-implementation"); 	
	 	createStyleFactory(org.osate.ge.internal.styles.FeatureGroupStyleFactory.class, "feature-group");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "feature-group-type-edit");
	 	createStyleFactory(org.osate.ge.internal.styles.ShadedStyleFactory.class, "shaded");
	 	createStyleFactory(org.osate.ge.internal.styles.ImplementsStyleFactory.class, "implements");
	 	createStyleFactory(org.osate.ge.internal.styles.SolidLineStyleFactory.class, "decorator");
	 	createStyleFactory(org.osate.ge.internal.styles.SolidLineStyleFactory.class, "feature");
	 	createStyleFactory(org.osate.ge.internal.styles.LabelStyleFactory.class, "label");
	 	createStyleFactory(org.osate.ge.internal.styles.AnnotationStyleFactory.class, "annotation");
	 	createStyleFactory(org.osate.ge.internal.styles.TextBackgroundStyleFactory.class, "text-background");
	 	createStyleFactory(org.osate.ge.internal.styles.SubprogramAccessStyleFactory.class, "subprogram_access");
	 	createStyleFactory(org.osate.ge.internal.styles.SubprogramGroupAccessStyleFactory.class, "subprogram_group_access");
	 	createStyleFactory(org.osate.ge.internal.styles.BackgroundStyleFactory.class, "background");
	 	createStyleFactory(org.osate.ge.internal.styles.BasicComponentTypeStyleFactory.class, "mode");
	 	createStyleFactory(org.osate.ge.internal.styles.SolidLineStyleFactory.class, "mode-initial");
	 	createStyleFactory(org.osate.ge.internal.styles.DashedLineStyleFactory.class, "mode_transition_trigger");
	 	createStyleFactory(org.osate.ge.internal.styles.SubprogramCallSequenceStyleFactory.class, "subprogram_call_sequence");
	 	createStyleFactory(org.osate.ge.internal.styles.SubprogramCallStyleFactory.class, "subprogram_call"); 	
	 	createStyleFactory(org.osate.ge.internal.styles.DefaultAnnexStyleFactory.class, "default_annex");	 	
	 	createStyleFactory(org.osate.ge.internal.styles.SolidLineStyleFactory.class, StyleConstants.SOLID_CONNECTION_STYLE);
	 	createStyleFactory(org.osate.ge.internal.styles.DashedLineStyleFactory.class, StyleConstants.DASHED_CONNECTION_STYLE);
	}
	
	public DefaultStyleService(final IFeatureProvider fp) {
		this.fp = fp;
		context = EclipseContextFactory.create();
		context.set(StyleService.class, this);
	}
	
	public void dispose() {
		context.dispose();
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
        	final Object styleFactory = styleIdToFactoryMap.get(styleId);
        	context.set(Diagram.class, fp.getDiagramTypeProvider().getDiagram());
        	context.set(InternalNames.STYLE_ID, styleId);
        	return (Style)ContextInjectionFactory.invoke(styleFactory, Activate.class, context);
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

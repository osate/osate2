/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.services.impl;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import edu.uah.rsesc.aadl.age.services.StyleProviderService;
import edu.uah.rsesc.aadl.age.services.StyleService;

public class DefaultStyleService implements StyleService {
	private final IFeatureProvider fp;
	private final StyleProviderService styleProviderService;
	
	public DefaultStyleService(final IFeatureProvider fp, final StyleProviderService styleProviderService) {
		this.fp = fp;
		this.styleProviderService = styleProviderService;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getStyle(org.eclipse.graphiti.mm.pictograms.Diagram, java.lang.String)
	 */
	@Override
	public Style getStyle(final String styleId) {
		return styleProviderService.getStyle(getDiagram(), styleId);
	}
	
	private Style getImplementationStyleConditionally(final String styleId, final boolean getImplementation) {
		final String finalStyleId = getImplementation ? (styleId + "-implementation") : styleId;
		return getStyle(finalStyleId);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getSystemStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getSystemStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("system", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getProcessStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getProcessStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("process", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getThreadGroupStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getThreadGroupStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("thread-group", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getThreadStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getThreadStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("thread", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getSubprogramStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getSubprogramStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("subprogram", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getSubprogramGroupStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getSubprogramGroupStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("subprogram-group", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getDataStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getDataStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("data", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getAbstractStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getAbstractStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("abstract", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getVirtualBusStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getVirtualBusStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("virtual-bus", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getVirtualProcessorStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getVirtualProcessorStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("virtual-processor", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getBusStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getBusStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("bus", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getProcessorStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getProcessorStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("processor", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getDeviceStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getDeviceStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("device", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getMemoryStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getMemoryStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("memory", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getFeatureGroupStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getFeatureGroupStyle() {
		return getImplementationStyleConditionally("feature-group", false);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getShadedStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getShadedStyle() {
		return getStyle("shaded");
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getImplementsStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getImplementsStyle() {
		return getStyle("implements");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getFlowSpecificationStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getFlowSpecificationStyle() {
		return getStyle("flow_specification");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getExtendsStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getExtendsStyle() {
		return getStyle("extends");
    }	
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getGeneralizationArrowHeadStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getGeneralizationArrowHeadStyle() {
		return getStyle("generalization-arrowhead");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getDecoratorStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getDecoratorStyle() {
		return getStyle("decorator");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getModeTransitionTrigger(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getModeTransitionTrigger() {
		return getStyle("mode_transition_trigger");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getLabelStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getLabelStyle() {
		return getStyle("label");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getFeatureStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getFeatureStyle() {
		return getStyle("feature");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getSubprogramAccessStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getSubprogramAccessStyle() {
		return getStyle("subprogram_access");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getSubprogramGroupAccessStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getSubprogramGroupAccessStyle() {
		return getStyle("subprogram_group_access");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getBackgroundStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getBackgroundStyle() {
		return getStyle("background");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getFeatureGroupLargeCircleStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getFeatureGroupLargeCircleStyle() {
		return getStyle("feature_group_large_circle");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getFeatureGroupSmallCircleStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getFeatureGroupSmallCircleStyle() {
		return getStyle("feature_group_small_circle");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getModeStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getModeStyle() {
		return getStyle("mode");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getInitialModeStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getInitialModeStyle() {
		return getStyle("mode-initial");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getInSelectedModeColor()
	 */
	@Override
	public IColorConstant getInSelectedModeColor() {
		return ColorConstant.BLUE;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getInSelectedFlowColor()
	 */
	@Override
	public IColorConstant getInSelectedFlowColor() {
		return ColorConstant.GREEN;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.getInSelectedModeAndFlowColor()
	 */
	@Override
	public IColorConstant getInSelectedModeAndFlowColor() {
		return ColorConstant.CYAN;
	};
	
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

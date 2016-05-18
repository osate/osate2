/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.MultiText;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EventDataSource;
import org.osate.aadl2.EventSource;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortCategory;
import org.osate.aadl2.PortProxy;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramProxy;
import org.osate.ge.internal.services.AadlFeatureService;
import org.osate.ge.internal.services.GraphicsAlgorithmCreationService;
import org.osate.ge.internal.services.GraphicsAlgorithmManipulationService;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.services.SubcomponentService;
import org.osate.ge.internal.styles.StyleConstants;

public class DefaultGraphicsAlgorithmCreationService implements GraphicsAlgorithmCreationService {
	private final StyleService styleService;
	private final AadlFeatureService featureService;
	private final SubcomponentService subcomponentService;
	private final GraphicsAlgorithmManipulationService graphicsAlgorithmUtil;
	
	public DefaultGraphicsAlgorithmCreationService(final StyleService styleUtil, final AadlFeatureService featureService, final SubcomponentService subcomponentService, final GraphicsAlgorithmManipulationService graphicsAlgorithmUtil) {
		this.styleService = styleUtil;
		this.featureService = featureService;
		this.subcomponentService = subcomponentService;
		this.graphicsAlgorithmUtil = graphicsAlgorithmUtil;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.GraphicsAlgorithmCreationService#createLabelGraphicsAlgorithm(org.eclipse.graphiti.mm.GraphicsAlgorithmContainer, org.eclipse.graphiti.mm.pictograms.Diagram, java.lang.String)
	 */
	@Override
	public Text createLabelGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final String labelTxt) {
		final IGaService gaService = Graphiti.getGaService();
		final Text text = gaService.createPlainText(container, labelTxt);
        text.setStyle(styleService.getStyle(StyleConstants.LABEL_STYLE));
        return text;
	}
	
	@Override
	public MultiText createMultiLineLabelGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final String labelTxt) {
		final IGaService gaService = Graphiti.getGaService();
		final MultiText text = gaService.createPlainMultiText(container, labelTxt);
        text.setStyle(styleService.getStyle(StyleConstants.LABEL_STYLE));
        return text;
	}
	
	@Override
	public Text createAnnotationGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final String annotationTxt) {
		final IGaService gaService = Graphiti.getGaService();
		final Text text = gaService.createPlainText(container, annotationTxt);
        text.setStyle(getAnnotationStyle());
        return text;
	}
	
	private Style getAnnotationStyle() {
		return styleService.getStyle("annotation");
    }
		
	@Override
	public GraphicsAlgorithm createTextBackground(final GraphicsAlgorithmContainer container) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm background = gaService.createPlainRectangle(container);	
		background.setStyle(getTextBackgroundStyle());		
		return background;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.GraphicsAlgorithmCreationService#createClassifierGraphicsAlgorithm(org.eclipse.graphiti.mm.pictograms.Shape, org.eclipse.graphiti.mm.pictograms.Diagram, org.osate.aadl2.Element, int, int)
	 */
	@Override
	public GraphicsAlgorithm createClassifierGraphicsAlgorithm(final Shape shape, final Element element, final int width, final int height) {
		final GraphicsAlgorithm ga;
		
		if(element instanceof FeatureGroupType) {
        	ga = createFeatureGroupTypeGraphicsAlgorithm(shape, width, height);
        	ga.setWidth(width);
		} else {
			final boolean isImplementation;
			final ComponentCategory category;
			if(element instanceof Subcomponent) {
				final Subcomponent sc = (Subcomponent)element;
				category = subcomponentService.getComponentCategory(shape, sc);
				isImplementation = subcomponentService.isImplementation(shape, sc);
			} else if(element instanceof ComponentClassifier) {
				final ComponentClassifier cc = (ComponentClassifier)element;
				category = cc.getCategory();
				isImplementation = cc instanceof ComponentImplementation;
			} else {
				throw new RuntimeException("Unexpected element type: " + element.getClass());			
			}
			     
	        if(category == ComponentCategory.SYSTEM) {
	        	ga = createSystemGraphicsAlgorithm(shape, getSystemStyle(isImplementation), width, height);
	        } else if(category == ComponentCategory.PROCESS) {
	        	ga = createProcessGraphicsAlgorithm(shape, getProcessStyle(isImplementation), width, height);
	        } else if(category == ComponentCategory.THREAD_GROUP) {
	        	ga = createThreadGroupGraphicsAlgorithm(shape, getThreadGroupStyle(isImplementation), width, height);
	        } else if(category == ComponentCategory.THREAD) {
	        	ga = createThreadGraphicsAlgorithm(shape, getThreadStyle(isImplementation), width, height);
	        } else if(category == ComponentCategory.SUBPROGRAM) {
	        	ga = createSubprogramGraphicsAlgorithm(shape, getSubprogramStyle(isImplementation), width, height);
	        } else if(category == ComponentCategory.SUBPROGRAM_GROUP) {
	        	ga = createSubprogramGroupGraphicsAlgorithm(shape, getSubprogramGroupStyle(isImplementation), width, height);
	        } else if(category == ComponentCategory.DATA) {
	        	ga = createDataGraphicsAlgorithm(shape, getDataStyle(isImplementation), width, height);
	        } else if(category == ComponentCategory.ABSTRACT) {
	        	ga = createAbstractGraphicsAlgorithm(shape, getAbstractStyle(isImplementation), width, height);
	        } else if(category == ComponentCategory.VIRTUAL_BUS) {
	        	ga = createBusGraphicsAlgorithm(shape, getVirtualBusStyle(isImplementation), width, height);
	        } else if(category == ComponentCategory.VIRTUAL_PROCESSOR) {
	        	ga = createProcessorGraphicsAlgorithm(shape, getVirtualProcessorStyle(isImplementation), width, height);
	        } else if(category == ComponentCategory.BUS) {
	        	ga = createBusGraphicsAlgorithm(shape, getBusStyle(isImplementation), width, height);
	        } else if(category == ComponentCategory.PROCESSOR) {
	        	ga = createProcessorGraphicsAlgorithm(shape, getProcessorStyle(isImplementation), width, height);
	        } else if(category == ComponentCategory.DEVICE) {     	
	        	ga = createDeviceGraphicsAlgorithm(shape, getDeviceStyle(isImplementation), getShadedStyle(), width, height);
	        } else if(category == ComponentCategory.MEMORY) {
	        	ga = createMemoryGraphicsAlgorithm(shape, getMemoryStyle(isImplementation), width, height);
	        } else {
	        	// Create a generic shape
	        	ga = createDummyGraphicsAlgorithm(shape, width, height);
	        }
		}

		return ga;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.GraphicsAlgorithmCreationService#createFeatureGraphicsAlgorithm(org.eclipse.graphiti.mm.pictograms.Shape, org.eclipse.graphiti.mm.pictograms.Diagram, org.osate.aadl2.Feature)
	 */
	@Override
	public GraphicsAlgorithm createFeatureGraphicsAlgorithm(final Shape shape, final NamedElement feature) {
		final IGaService gaService = Graphiti.getGaService();
		
        // Abstract Feature
		final GraphicsAlgorithm ga;			
		if(feature instanceof Port) {
			ga = createPortGraphicsAlgorithm(shape, ((Port)feature).getCategory(), ((Port) feature).getDirection());
		} else if(feature instanceof AbstractFeature) { // Abstract Feature
			ga = createAbstractFeatureGraphicsAlgorithm(shape, ((AbstractFeature) feature).getDirection());
        } else if(feature instanceof Access) {
        	ga = createAccessGraphicsAlgorithm(shape, ((Access)feature).getCategory(), ((Access)feature).getKind());
        } else if(feature instanceof FeatureGroup) {
        	throw new RuntimeException("Unhandled case. Feature Group");   		
        } else if(feature instanceof EventSource) {
			ga = createPortGraphicsAlgorithm(shape, PortCategory.EVENT, DirectionType.IN);    
		} else if(feature instanceof EventDataSource) {
			ga = createPortGraphicsAlgorithm(shape, PortCategory.EVENT_DATA, DirectionType.IN);
		} else if(feature instanceof SubprogramProxy) {
			ga = createAccessGraphicsAlgorithm(shape, AccessCategory.SUBPROGRAM, AccessType.REQUIRES);
		} else if(feature instanceof PortProxy) {
			ga = createAbstractFeatureGraphicsAlgorithm(shape, DirectionType.IN_OUT);
		} else if(feature instanceof Parameter) {
			ga = createPortGraphicsAlgorithm(shape, PortCategory.DATA, ((Parameter) feature).getDirection());
		} else {
        	ga = gaService.createPlainRectangle(shape);
            gaService.setSize(ga, 10, 10);
        }

		return ga;
	}

	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.GraphicsAlgorithmCreationService#createPortGraphicsAlgorithm(org.eclipse.graphiti.mm.pictograms.Shape, org.eclipse.graphiti.mm.pictograms.Diagram, org.osate.aadl2.PortCategory, org.osate.aadl2.DirectionType)
	 */
	@Override
	public GraphicsAlgorithm createPortGraphicsAlgorithm(final Shape shape, final PortCategory category, DirectionType direction) {
		final IGaService gaService = Graphiti.getGaService();
		final Style style = getFeatureStyle();
		final boolean hasData = category == PortCategory.DATA || category == PortCategory.EVENT_DATA;
		final boolean hasEvent = category == PortCategory.EVENT || category == PortCategory.EVENT_DATA;
		
		final GraphicsAlgorithm ga = gaService.createInvisibleRectangle(shape);
    	
		// Invert the direction as needed
		if(direction == DirectionType.IN || direction == DirectionType.OUT) {
			if(featureService.isFeatureInverted(shape)) {
				direction = (direction == DirectionType.IN) ? DirectionType.OUT : DirectionType.IN;
			}
		}				
		
    	int width = 25;
    	final int height = 20;
    	final int dataSymbolXPadding = 10;
    	final int dataSymbolYPadding = 5;

    	GraphicsAlgorithm dataGa = null;
    	GraphicsAlgorithm eventGa = null;        	
    	
    	switch(direction) {
    	// In Port
    	case IN:
    		if(hasData) {
        		dataGa = gaService.createPlainPolygon(ga, new int[] {
            			0, dataSymbolYPadding, 
            			width-dataSymbolXPadding, height/2,
            			0, height-dataSymbolYPadding});
    		}
    		
    		if(hasEvent) {
        		eventGa = gaService.createPlainPolyline(ga, new int[] {
            			0, 0, 
            			width, height/2,
            			0, height});
    		}
    		break;
    		
   		// Out Port
    	case OUT:
    		if(hasData) {
    			dataGa = gaService.createPlainPolygon(ga, new int[] {
            			width, dataSymbolYPadding, 
            			dataSymbolXPadding, height/2,
            			width, height-dataSymbolYPadding});
    		}
    		
    		if(hasEvent) {
				eventGa = gaService.createPlainPolyline(ga, new int[] {
        			width, 0, 
        			0, height/2,
        			width, height});
    		}
    		break;
    		
    	// In Out Port
    	case IN_OUT:
    		width *= 2;
    		if(hasData) {
        		dataGa = gaService.createPlainPolygon(ga, new int[] {
            			width/2, dataSymbolYPadding, 
            			width-dataSymbolXPadding, height/2,
            			width/2, height-dataSymbolYPadding,
            			dataSymbolXPadding, height/2});
    		}
    		
    		if(hasEvent) {
        		eventGa = gaService.createPlainPolyline(ga, new int[] {
            			width/2, 0, 
            			width, height/2,
            			width/2, height,
            			0, height/2,
            			width/2, 0});
    		}
    		break;
    	}
    	
    	if(dataGa != null) {
    		dataGa.setStyle(style);
    	}
    	
    	if(eventGa != null) {
    		eventGa.setStyle(style);
    	}
    	
        ga.setStyle(style);
        gaService.setSize(ga,  width, height);
        graphicsAlgorithmUtil.shrink(ga);

        return ga;
	}
	
	private GraphicsAlgorithm createAbstractFeatureGraphicsAlgorithm(final Shape shape, DirectionType direction) {
		final IGaService gaService = Graphiti.getGaService();
		final Style style = getFeatureStyle();
		final GraphicsAlgorithm ga = gaService.createInvisibleRectangle(shape);
    	gaService.setSize(ga,  25,  20);
    	
    	final GraphicsAlgorithm circleGa = gaService.createPlainEllipse(ga);
    	circleGa.setStyle(style);
    	gaService.setLocation(circleGa, 0, 5);
        gaService.setSize(circleGa, 10, 10);

        // Invert the direction as needed
 		if(direction == DirectionType.IN || direction == DirectionType.OUT) {
 			if(featureService.isFeatureInverted(shape)) {
 				direction = (direction == DirectionType.IN) ? DirectionType.OUT : DirectionType.IN;
 			}
 		}	
 			
        // In Abstract Feature
        if(direction == DirectionType.IN) {
        	final GraphicsAlgorithm directionGa = gaService.createPlainPolyline(ga, new int[] {
        			0, 0, 
        			25, 10,
        			0, 20});
            directionGa.setStyle(style);            	
        } else if(direction == DirectionType.OUT) { // Out Abstract Feature
        	final GraphicsAlgorithm directionGa = gaService.createPlainPolyline(ga, new int[] {
        			25, 0, 
        			0, 10,
        			25, 20});
        	gaService.setLocation(circleGa, ga.getWidth()-circleGa.getWidth(), 5);
            directionGa.setStyle(style);   	
        }
        
        graphicsAlgorithmUtil.shrink(ga);
        return ga;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.GraphicsAlgorithmCreationService#createAccessGraphicsAlgorithm(org.eclipse.graphiti.mm.pictograms.Shape, org.eclipse.graphiti.mm.pictograms.Diagram, org.osate.aadl2.AccessCategory, org.osate.aadl2.AccessType)
	 */
	@Override
	public GraphicsAlgorithm createAccessGraphicsAlgorithm(final Shape shape, final AccessCategory category, AccessType accessType) {
		final IGaService gaService = Graphiti.getGaService();
    	if(featureService.isFeatureInverted(shape)) {
    		accessType = (accessType == AccessType.PROVIDES) ? AccessType.REQUIRES : AccessType.PROVIDES;
    	}
    	int width = 0;
    	int height = 0;
    	
    	final GraphicsAlgorithm ga = gaService.createInvisibleRectangle(shape);
    	 
    	if(category == AccessCategory.BUS || category == AccessCategory.DATA) {
    		final Style style = getFeatureStyle();
    		width = 20;
    		height = 20;        		
    		final int slopeWidth = 5;
    		
    		if(accessType == AccessType.PROVIDES) {
    			final GraphicsAlgorithm symbolGa = gaService.createPlainPolyline(ga, new int[] {
            			width, 0, 
            			slopeWidth, 0,
            			0, height/2,
            			slopeWidth, height,
            			width, height,
            			width, 0});
        		symbolGa.setStyle(style); 
    		} else if(accessType == AccessType.REQUIRES) {
    			final GraphicsAlgorithm symbolGa = gaService.createPlainPolyline(ga, new int[] {
            			0, 0, 
            			width-slopeWidth, 0,
            			width, height/2,
            			width-slopeWidth, height,
            			0, height,
            			0, 0});
        		symbolGa.setStyle(style); 
    		}        		
    		graphicsAlgorithmUtil.shrink(ga);
    	} else if(category == AccessCategory.SUBPROGRAM || category == AccessCategory.SUBPROGRAM_GROUP) {
    		final Style style = category == AccessCategory.SUBPROGRAM ? getSubprogramAccessStyle() : getSubprogramGroupAccessStyle();
    		width = 35;
    		height = 20;
    		final int vPadding = 5;
    		
    		final GraphicsAlgorithm symbolGa = gaService.createPlainEllipse(ga);
    		gaService.setSize(symbolGa, width, height);
    		symbolGa.setStyle(style); 
    		
    		final int arrowWidth = 10;
    		final int left = width/2 - arrowWidth/2;
    		final int right = width/2 + arrowWidth/2;
    		if(accessType == AccessType.PROVIDES) {
    			final GraphicsAlgorithm arrowGa = gaService.createPlainPolyline(ga, new int[] {
            			left, vPadding, 
            			right, height/2,
            			left, height-vPadding});
        		arrowGa.setStyle(style);
    		} else if(accessType == AccessType.REQUIRES) {
    			final GraphicsAlgorithm arrowGa = gaService.createPlainPolyline(ga, new int[] {
    					right, vPadding, 
    					left, height/2,
    					right, height-vPadding});
        		arrowGa.setStyle(style);
    		}
    	}
    	
    	gaService.setSize(ga,  width, height);
    	graphicsAlgorithmUtil.shrink(ga);
		return ga;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.GraphicsAlgorithmCreationService#createModeGraphicsAlgorithm(org.eclipse.graphiti.mm.GraphicsAlgorithmContainer, org.eclipse.graphiti.mm.pictograms.Diagram, int, int)
	 */
	@Override
	public GraphicsAlgorithm createModeGraphicsAlgorithm(final GraphicsAlgorithmContainer container, int width, int height) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainPolygon(container, 
    			new int[] {
    			0, height/2,
    			width/4, 0,
    			width*3/4, 0,
    			width, height/2,
    			width*3/4, height,
    			width/4, height,
    			0, height/2});
		ga.setStyle(getModeStyle());
		gaService.setSize(ga, width, height);
		
		return ga;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.GraphicsAlgorithmCreationService#createInitialModeGraphicsAlgorithm(org.eclipse.graphiti.mm.GraphicsAlgorithmContainer, org.eclipse.graphiti.mm.pictograms.Diagram, int)
	 */
	@Override
	public GraphicsAlgorithm createInitialModeGraphicsAlgorithm(final GraphicsAlgorithmContainer container, int size) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createEllipse(container);
		ga.setStyle(getInitialModeStyle());
		gaService.setSize(ga, size, size);
		return ga;
	}
	
	private Style getInitialModeStyle() {
		return styleService.getStyle("mode-initial");
	}
	
	private Style getModeStyle() {
		return styleService.getStyle("mode");
    }
	
	private static GraphicsAlgorithm createDummyGraphicsAlgorithm(final GraphicsAlgorithmContainer containerShape, int width, int height) {
		final RoundedRectangle roundedRectangle = Graphiti.getGaService().createPlainRoundedRectangle(containerShape, 5, 5);
        Graphiti.getGaService().setSize(roundedRectangle, width, height);
        return roundedRectangle;
	}
	
	private static GraphicsAlgorithm createSystemGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Style style, final int width, final int height) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainRoundedRectangle(container, 25, 25);
    	gaService.setSize(ga, width, height);
    	ga.setStyle(style);
    	return ga;
	}
	
	private static GraphicsAlgorithm createProcessGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Style style, final int width, final int height) {
		final GraphicsAlgorithm ga = createParallelogram(container, width, height, 20);
		ga.setStyle(style);
		return ga;
	}
	
	private static GraphicsAlgorithm createThreadGroupGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Style style, final int width, final int height) {
		return createSystemGraphicsAlgorithm(container, style, width, height);
	}
	
	private static GraphicsAlgorithm createThreadGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Style style, final int width, final int height) {
		return createProcessGraphicsAlgorithm(container, style, width, height);
	}
	
	private static GraphicsAlgorithm createSubprogramGraphicsAlgorithm(final Shape container, final Style style, final int width, final int height) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createInvisibleRectangle(container);
		gaService.setSize(ga, width, height);
		
		final GraphicsAlgorithm ellipseGa = gaService.createPlainEllipse(ga);
		gaService.setSize(ellipseGa, width, height);
		ellipseGa.setStyle(style);
		ellipseGa.setFilled(false);
		
    	return ga;
	}
	
	private static GraphicsAlgorithm createSubprogramGroupGraphicsAlgorithm(final Shape container, final Style style, final int width, final int height) {
		return createSubprogramGraphicsAlgorithm(container, style, width, height);
	}
	
	private static GraphicsAlgorithm createDataGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Style style, final int width, final int height) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(container);
    	gaService.setSize(ga, width, height);
        ga.setStyle(style);
    	return ga;
	}
	
	private static GraphicsAlgorithm createAbstractGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Style style, final int width, final int height) {
		return createDataGraphicsAlgorithm(container, style, width, height);
	}
	
	private static GraphicsAlgorithm createBusGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Style style, final int width, final int height) {
		final int arrowHeadWidth = Math.max(Math.min(width, height)/4, 20);
		final int arrowHeadVerticalExtensionSize = height/4;
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainPolygon(container, 
    			new int[] {
    			0, height/2,
    			arrowHeadWidth, 0,
    			arrowHeadWidth, arrowHeadVerticalExtensionSize,
    			width-arrowHeadWidth, arrowHeadVerticalExtensionSize,
    			width-arrowHeadWidth, 0,
    			width, height/2,
    			width-arrowHeadWidth, height,
    			width-arrowHeadWidth, height-arrowHeadVerticalExtensionSize,
    			arrowHeadWidth, height-arrowHeadVerticalExtensionSize,
    			arrowHeadWidth, height});
		ga.setStyle(style);
		gaService.setSize(ga, width, height);
		return ga;
	}
	
	private static GraphicsAlgorithm createProcessorGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Style style, final int width, final int height) {
		final int horizontalOffset = 10;
		final int depth = 12;
		final IGaService gaService = Graphiti.getGaService();
		
		// Create polygon for outline
		final Polygon outlinePolygon = gaService.createPlainPolygon(container, 
    			new int[] {
    			0, height,
    			0, depth,
    			horizontalOffset, 0,
    			width, 0,
    			width, height-depth,
    			width-horizontalOffset, height});
		outlinePolygon.setStyle(style);
		
		// Create child shapes for extra lines and shading
		gaService.createPlainPolyline(outlinePolygon, new int[] {
    			0, depth,
    			width-horizontalOffset, depth,
    			width, 0}).setStyle(style);
		
		gaService.createPlainPolyline(outlinePolygon, new int[] {
    			width-horizontalOffset, depth,
    			width-horizontalOffset, height}).setStyle(style);

		gaService.setSize(outlinePolygon, width, height);
		
		return outlinePolygon;
	}
	
	private static GraphicsAlgorithm createDeviceGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Style style, final Style shadedStyle, final int width, final int height) {
		final int padding = 4;
		final IGaService gaService = Graphiti.getGaService();
		
		// Create outer outline
		final GraphicsAlgorithm outline = gaService.createPlainRectangle(container);
		gaService.setSize(outline, width, height);
		outline.setStyle(style);
		
		// Create shading
		GraphicsAlgorithm ga;
		ga = gaService.createPlainPolygon(outline, new int[] {
    			width, 0,
    			width, height,
    			width-padding, height-padding,
    			width-padding, padding});
		ga.setStyle(shadedStyle);
		ga.setLineVisible(false);
		
		ga = gaService.createPlainPolygon(outline, new int[] {
    			width, height,
    			0, height,
    			padding, height-padding,
    			width-padding, height-padding});
		ga.setStyle(shadedStyle);
		ga.setLineVisible(false);
				
		// Create inner rectangle
		final GraphicsAlgorithm inner = gaService.createPlainRectangle(outline);
		gaService.setLocation(inner, padding, padding);
		gaService.setSize(inner, width-padding*2, height-padding*2);
		inner.setStyle(style);
		inner.setFilled(false);
		
		// Create additional line segments
		gaService.createPlainPolyline(outline, new int[] {
    			0, 0,
    			padding+1, padding+1}).setStyle(style);
		
		gaService.createPlainPolyline(outline, new int[] {
    			width, 0,
    			width-padding-1, padding+1}).setStyle(style);
		
		gaService.createPlainPolyline(outline, new int[] {
    			width-padding-1, height-padding-1,
    			width, height}).setStyle(style);
		
		gaService.createPlainPolyline(outline, new int[] {
    			0, height,
    			padding+1, height-padding-1}).setStyle(style);
		
		return outline;
	}
	
	private static GraphicsAlgorithm createMemoryGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Style style, final int width, final int height) {
		final int ellipseHeight = 20;
		final double halfEllipseHeight = ellipseHeight / 2.0;
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(container);
		gaService.setSize(ga, width, height);
		ga.setLineVisible(false);
		ga.setStyle(style);
		
		// Top ellipse
		final GraphicsAlgorithm topEllipse = gaService.createPlainEllipse(ga);
		gaService.setLocationAndSize(topEllipse, 0, 0, width, ellipseHeight);
		topEllipse.setStyle(style);
		topEllipse.setFilled(false);

		// Draw a half ellipse for the bottom
		int halfEllipsePointCount = 8;
		int[] points = new int[halfEllipsePointCount*2 + 8];
		int j = 0;
		
		// Right Side
		points[j++] = width; points[j++] = ellipseHeight/2;
		points[j++] = width; points[j++] = (int)Math.round(height-halfEllipseHeight);
		
		// Bottom Half Ellipse
		double t = -Math.PI/2.0;
		final double halfWidth = width / 2.0;
		for(int i = 0; i < halfEllipsePointCount; i++) {
			final int x = (int)Math.round(halfWidth + (-Math.sin(t) * halfWidth));
			final int y = (int)Math.round(height-halfEllipseHeight + (Math.cos(t) * halfEllipseHeight));
			points[j++] = x;
			points[j++] = y;
			t += Math.PI/(halfEllipsePointCount-1);
		}
		
		// Left Side
		points[j++] = 0; points[j++] = (int)Math.round(height-halfEllipseHeight);
		points[j++] = 0; points[j++] = ellipseHeight/2;
		
		final Polyline linesGa = gaService.createPlainPolyline(ga, points);
		gaService.setLocationAndSize(linesGa, 0, 0, width, height);
		linesGa.setStyle(style);
		return ga;
	}

	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.GraphicsAlgorithmCreationService#createFeatureGroupGraphicsAlgorithm(org.eclipse.graphiti.mm.GraphicsAlgorithmContainer, org.eclipse.graphiti.mm.pictograms.Diagram, int, int)
	 */
	@Override
	public GraphicsAlgorithm createFeatureGroupGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final int width, final int height) {
		final Style style = getFeatureGroupStyle();
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(container);
		final int circleSize = width*2/3;
		final int barWidth = width - circleSize;
		gaService.setSize(ga, width, height);
		ga.setLineVisible(false);
		ga.setFilled(false);		
		
		// Circle
		final GraphicsAlgorithm circle = gaService.createPlainEllipse(ga);
		gaService.setLocationAndSize(circle, width-circleSize, height/2-circleSize/2, circleSize, circleSize);
		circle.setStyle(style);
		
		// Bar
		final GraphicsAlgorithm bar = gaService.createPlainRectangle(ga);
		gaService.setLocationAndSize(bar, circle.getX()-barWidth, 0, barWidth, height);
		bar.setStyle(style);
		
		return ga;
	}
	
	private GraphicsAlgorithm createFeatureGroupTypeGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final int width, final int height) {
		final Style style = getFeatureGroupStyle();
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(container);
		final int size = Math.min(width, height);
		final double halfSize = (size)/2.0;
		final int paddingCircleSize = (int)(halfSize + 1 + halfSize *.2);
		final int innerCircleSize = size/2;
		gaService.setSize(ga, size, size);
		ga.setLineVisible(false);
		ga.setFilled(false);	

		// Draw a half circle
		int pointCount = 16;
		int[] points = new int[pointCount*2];
		int j = 0;
		double t = 0;
		for(int i = 0; i < pointCount; i++) {
			final int x = (int)Math.round(halfSize + (-Math.sin(t) * halfSize));
			final int y = (int)Math.round(height/2.0 + (Math.cos(t) * halfSize));
			points[j++] = x;
			points[j++] = y;
			t += Math.PI/(pointCount-1);
		}
		final Polygon halfCircle = gaService.createPlainPolygon(ga, points);
		gaService.setLocationAndSize(halfCircle, 0, 0, size, size);
		halfCircle.setStyle(style);
		
		// White circle for padding
		final GraphicsAlgorithm paddingCircle = gaService.createPlainEllipse(ga);
		gaService.setLocationAndSize(paddingCircle, (int)Math.round(size/2.0 - paddingCircleSize/2.0), (int)Math.round(height/2.0-paddingCircleSize/2.0), paddingCircleSize, paddingCircleSize);
		paddingCircle.setStyle(getBackgroundStyle());
		
		// Inner Circle
		final GraphicsAlgorithm innerCircle = gaService.createPlainEllipse(ga);
		gaService.setLocationAndSize(innerCircle, (int)Math.round(innerCircleSize/2), (int)Math.round(height/2.0-innerCircleSize/2.0), innerCircleSize, innerCircleSize);
		innerCircle.setStyle(style);

		return ga;
	}
	
	private Style getBackgroundStyle() {
		return styleService.getStyle("background");
    }
	
	private static GraphicsAlgorithm createParallelogram(final GraphicsAlgorithmContainer container, final int width, final int height, int horizontalOffset) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainPolygon(container, 
    			new int[] {
    			horizontalOffset, 0,
    			width, 0,
    			width-horizontalOffset, height,
    			0, height});
		gaService.setSize(ga, width, height);
		return ga;
	}
	
	private Style getImplementationStyleConditionally(final String styleId, final boolean getImplementation) {
		final String finalStyleId = getImplementation ? (styleId + "-implementation") : styleId;
		return styleService.getStyle(finalStyleId);
	}
	
	private Style getSystemStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("system", isImplementation);
	}
	
	private Style getSubprogramAccessStyle() {
		return styleService.getStyle("subprogram_access");
    }
	
	private Style getSubprogramGroupAccessStyle() {
		return styleService.getStyle("subprogram_group_access");
    }
	
	private Style getFeatureStyle() {
		return styleService.getStyle("feature");
    }
	
	private Style getTextBackgroundStyle() {
		return styleService.getStyle("text-background");
	}
	
	private Style getShadedStyle() {
		return styleService.getStyle("shaded");
	}
	
	private Style getFeatureGroupStyle() {
		return getImplementationStyleConditionally("feature-group", false);
	}
	
	private Style getMemoryStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("memory", isImplementation);
	}
	
	private Style getDeviceStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("device", isImplementation);
	}
	
	private Style getProcessorStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("processor", isImplementation);
	}
	
	private Style getBusStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("bus", isImplementation);
	}
	
	private Style getVirtualProcessorStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("virtual-processor", isImplementation);
	}
	
	private Style getVirtualBusStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("virtual-bus", isImplementation);
	}
	
	private Style getAbstractStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("abstract", isImplementation);
	}
	
	private Style getDataStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("data", isImplementation);
	}
	
	private Style getThreadGroupStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("thread-group", isImplementation);
	}
	
	private Style getThreadStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("thread", isImplementation);
	}
	
	private Style getSubprogramStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("subprogram", isImplementation);
	}

	private Style getSubprogramGroupStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("subprogram-group", isImplementation);
	}

	private Style getProcessStyle(final boolean isImplementation) {
		return getImplementationStyleConditionally("process", isImplementation);
	}
	
}

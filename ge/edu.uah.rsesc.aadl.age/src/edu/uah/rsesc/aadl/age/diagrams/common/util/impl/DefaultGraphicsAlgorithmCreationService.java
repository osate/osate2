package edu.uah.rsesc.aadl.age.diagrams.common.util.impl;

import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
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
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortCategory;
import org.osate.aadl2.Subcomponent;

import edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreationService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService;

// TODO: Eventually replace with an extension mechanism similar to the ones for styles. Goal would be to allow sharing of graphics algorithms, sharing symbols, and 
// allowing flexibility such as allowing the user to override symbols for particular shapes. In that case may move out of common package.
// Some methods may not be included in such a system(such as createLabel*) but that is TBD
public class DefaultGraphicsAlgorithmCreationService implements GraphicsAlgorithmCreationService {
	private final StyleService styleUtil;
	private final ClassifierService classifierHelper;
	private final GraphicsAlgorithmService graphicsAlgorithmUtil;
	
	public DefaultGraphicsAlgorithmCreationService(final StyleService styleUtil, final ClassifierService classifierHelper, final GraphicsAlgorithmService graphicsAlgorithmUtil) {
		this.styleUtil = styleUtil;
		this.classifierHelper = classifierHelper;
		this.graphicsAlgorithmUtil = graphicsAlgorithmUtil;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreationService#createLabelGraphicsAlgorithm(org.eclipse.graphiti.mm.GraphicsAlgorithmContainer, org.eclipse.graphiti.mm.pictograms.Diagram, java.lang.String)
	 */
	@Override
	public Text createLabelGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Diagram diagram, final String labelTxt) {
		final IGaService gaService = Graphiti.getGaService();
		final Text text = gaService.createPlainText(container, labelTxt);
        text.setStyle(styleUtil.getLabelStyle(diagram));
        return text;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreationService#createClassifierGraphicsAlgorithm(org.eclipse.graphiti.mm.pictograms.Shape, org.eclipse.graphiti.mm.pictograms.Diagram, org.osate.aadl2.Element, int, int)
	 */
	@Override
	public GraphicsAlgorithm createClassifierGraphicsAlgorithm(final Shape shape, final Diagram diagram, final Element element, final int width, final int height) {
		final GraphicsAlgorithm ga;
		
		if(element instanceof FeatureGroupType) {
        	ga = createFeatureGroupGraphicsAlgorithm(shape, diagram, Math.min(width/3, height/3), height);
        	ga.setWidth(width);
		} else {
			final boolean isImplementation;
			final ComponentCategory category;
			if(element instanceof Subcomponent) {
				final Subcomponent sc = (Subcomponent)element;
				category = classifierHelper.getComponentCategory(shape, sc);
				isImplementation = classifierHelper.isImplementation(shape, sc);
			} else if(element instanceof ComponentClassifier) {
				final ComponentClassifier cc = (ComponentClassifier)element;
				category = cc.getCategory();
				isImplementation = cc instanceof ComponentImplementation;
			} else {
				throw new RuntimeException("Unexpected element type: " + element.getClass());			
			}
			     
	        if(category == ComponentCategory.SYSTEM) {
	        	ga = createSystemGraphicsAlgorithm(shape, styleUtil.getSystemStyle(diagram, isImplementation), width, height);
	        } else if(category == ComponentCategory.PROCESS) {
	        	ga = createProcessGraphicsAlgorithm(shape, styleUtil.getProcessStyle(diagram, isImplementation), width, height);
	        } else if(category == ComponentCategory.THREAD_GROUP) {
	        	ga = createThreadGroupGraphicsAlgorithm(shape, styleUtil.getThreadGroupStyle(diagram, isImplementation), width, height);
	        } else if(category == ComponentCategory.THREAD) {
	        	ga = createThreadGraphicsAlgorithm(shape, styleUtil.getThreadStyle(diagram, isImplementation), width, height);
	        } else if(category == ComponentCategory.SUBPROGRAM) {
	        	ga = createSubprogramGraphicsAlgorithm(shape, styleUtil.getSubprogramStyle(diagram, isImplementation), width, height);
	        } else if(category == ComponentCategory.SUBPROGRAM_GROUP) {
	        	ga = createSubprogramGroupGraphicsAlgorithm(shape, styleUtil.getSubprogramGroupStyle(diagram, isImplementation), width, height);
	        } else if(category == ComponentCategory.DATA) {
	        	ga = createDataGraphicsAlgorithm(shape, styleUtil.getDataStyle(diagram, isImplementation), width, height);
	        } else if(category == ComponentCategory.ABSTRACT) {
	        	ga = createAbstractGraphicsAlgorithm(shape, styleUtil.getAbstractStyle(diagram, isImplementation), width, height);
	        } else if(category == ComponentCategory.VIRTUAL_BUS) {
	        	ga = createBusGraphicsAlgorithm(shape, styleUtil.getVirtualBusStyle(diagram, isImplementation), width, height);
	        } else if(category == ComponentCategory.VIRTUAL_PROCESSOR) {
	        	ga = createProcessorGraphicsAlgorithm(shape, styleUtil.getVirtualProcessorStyle(diagram, isImplementation), width, height);
	        } else if(category == ComponentCategory.BUS) {
	        	ga = createBusGraphicsAlgorithm(shape, styleUtil.getBusStyle(diagram, isImplementation), width, height);
	        } else if(category == ComponentCategory.PROCESSOR) {
	        	ga = createProcessorGraphicsAlgorithm(shape, styleUtil.getProcessorStyle(diagram, isImplementation), width, height);
	        } else if(category == ComponentCategory.DEVICE) {     	
	        	ga = createDeviceGraphicsAlgorithm(shape, styleUtil.getDeviceStyle(diagram, isImplementation), styleUtil.getShadedStyle(diagram), width, height);
	        } else if(category == ComponentCategory.MEMORY) {
	        	ga = createMemoryGraphicsAlgorithm(shape, styleUtil.getMemoryStyle(diagram, isImplementation), width, height);
	        } else {
	        	// Create a generic shape
	        	ga = createDummyGraphicsAlgorithm(shape, width, height);
	        }
		}

		return ga;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreationService#createFeatureGraphicsAlgorithm(org.eclipse.graphiti.mm.pictograms.Shape, org.eclipse.graphiti.mm.pictograms.Diagram, org.osate.aadl2.Feature)
	 */
	@Override
	public GraphicsAlgorithm createFeatureGraphicsAlgorithm(final Shape shape, final Diagram diagram, final Feature feature) {
		final IGaService gaService = Graphiti.getGaService();
		
        // Abstract Feature
		final GraphicsAlgorithm ga;			
		if(feature instanceof Port) {
			ga = createPortGraphicsAlgorithm(shape, diagram, ((Port)feature).getCategory(), ((Port) feature).getDirection());
		} else if(feature instanceof AbstractFeature) { // Abstract Feature
			ga = createAbstractFeatureGraphicsAlgorithm(shape, diagram, ((AbstractFeature) feature).getDirection());
        } else if(feature instanceof Access) {
        	ga = createAccessGraphicsAlgorithm(shape, diagram, ((Access)feature).getCategory(), ((Access)feature).getKind());
        } else if(feature instanceof FeatureGroup) {
        	throw new RuntimeException("Unhandled case. Feature Group");   		
        } else {
        	ga = gaService.createPlainRectangle(shape);
            gaService.setSize(ga, 10, 10);
        }
		
		return ga;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreationService#createPortGraphicsAlgorithm(org.eclipse.graphiti.mm.pictograms.Shape, org.eclipse.graphiti.mm.pictograms.Diagram, org.osate.aadl2.PortCategory, org.osate.aadl2.DirectionType)
	 */
	@Override
	public GraphicsAlgorithm createPortGraphicsAlgorithm(final Shape shape, final Diagram diagram, final PortCategory category, DirectionType direction) {
		final IGaService gaService = Graphiti.getGaService();
		final Style style = styleUtil.getFeatureStyle(diagram);
		final boolean hasData = category == PortCategory.DATA || category == PortCategory.EVENT_DATA;
		final boolean hasEvent = category == PortCategory.EVENT || category == PortCategory.EVENT_DATA;
		
		final GraphicsAlgorithm ga = gaService.createInvisibleRectangle(shape);
    	
		// Invert the direction as needed
		if(direction == DirectionType.IN || direction == DirectionType.OUT) {
			if(classifierHelper.isFeatureInverted(shape)) {
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
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreationService#createAbstractFeatureGraphicsAlgorithm(org.eclipse.graphiti.mm.pictograms.Shape, org.eclipse.graphiti.mm.pictograms.Diagram, org.osate.aadl2.DirectionType)
	 */
	@Override
	public GraphicsAlgorithm createAbstractFeatureGraphicsAlgorithm(final Shape shape, final Diagram diagram, DirectionType direction) {
		final IGaService gaService = Graphiti.getGaService();
		final Style style = styleUtil.getFeatureStyle(diagram);
		final GraphicsAlgorithm ga = gaService.createInvisibleRectangle(shape);
    	gaService.setSize(ga,  25,  20);
    	
    	final GraphicsAlgorithm circleGa = gaService.createPlainEllipse(ga);
    	circleGa.setStyle(style);
    	gaService.setLocation(circleGa, 0, 5);
        gaService.setSize(circleGa, 10, 10);

        // Invert the direction as needed
 		if(direction == DirectionType.IN || direction == DirectionType.OUT) {
 			if(classifierHelper.isFeatureInverted(shape)) {
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
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreationService#createAccessGraphicsAlgorithm(org.eclipse.graphiti.mm.pictograms.Shape, org.eclipse.graphiti.mm.pictograms.Diagram, org.osate.aadl2.AccessCategory, org.osate.aadl2.AccessType)
	 */
	@Override
	public GraphicsAlgorithm createAccessGraphicsAlgorithm(final Shape shape, final Diagram diagram, final AccessCategory category, AccessType accessType) {
		final IGaService gaService = Graphiti.getGaService();
    	if(classifierHelper.isFeatureInverted(shape)) {
    		accessType = (accessType == AccessType.PROVIDES) ? AccessType.REQUIRES : AccessType.PROVIDES;
    	}
    	int width = 0;
    	int height = 0;
    	
    	final GraphicsAlgorithm ga = gaService.createInvisibleRectangle(shape);
    	 
    	if(category == AccessCategory.BUS || category == AccessCategory.DATA) {
    		final Style style = styleUtil.getFeatureStyle(diagram);
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
    		final Style style = category == AccessCategory.SUBPROGRAM ? styleUtil.getSubprogramAccessStyle(diagram) : styleUtil.getSubprogramGroupAccessStyle(diagram);
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
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreationService#createModeGraphicsAlgorithm(org.eclipse.graphiti.mm.GraphicsAlgorithmContainer, org.eclipse.graphiti.mm.pictograms.Diagram, int, int)
	 */
	@Override
	public GraphicsAlgorithm createModeGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Diagram diagram, int width, int height) {
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
		ga.setStyle(styleUtil.getModeStyle(diagram));
		gaService.setSize(ga, width, height);
		
		return ga;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreationService#createInitialModeGraphicsAlgorithm(org.eclipse.graphiti.mm.GraphicsAlgorithmContainer, org.eclipse.graphiti.mm.pictograms.Diagram, int)
	 */
	@Override
	public GraphicsAlgorithm createInitialModeGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Diagram diagram, int size) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createEllipse(container);
		ga.setStyle(styleUtil.getInitialModeStyle(diagram));
		gaService.setSize(ga, size, size);
		return ga;
	}
	
	private static GraphicsAlgorithm createDummyGraphicsAlgorithm(final GraphicsAlgorithmContainer containerShape, int width, int height) {
		final RoundedRectangle roundedRectangle = Graphiti.getGaService().createPlainRoundedRectangle(containerShape, 5, 5);
        Graphiti.getGaService().setSize(roundedRectangle, width, height);
        return roundedRectangle;
	}
	
	private static GraphicsAlgorithm createSystemGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Style style, final int width, final int height) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainRoundedRectangle(container, 5, 5);
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
	
	private static GraphicsAlgorithm createSubprogramGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Style style, final int width, final int height) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainEllipse(container);
    	gaService.setSize(ga, width, height);
        ga.setStyle(style);
    	return ga;
	}
	
	private static GraphicsAlgorithm createSubprogramGroupGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Style style, final int width, final int height) {
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
	
	// TODO: Avoid hardcoded numbers. Especially repeated	
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
    			width-padding-3, height-padding-3,
    			width-padding-3, padding+3});
		ga.setStyle(shadedStyle);
		ga.setLineVisible(false);
		
		ga = gaService.createPlainPolygon(outline, new int[] {
    			width, height,
    			0, height,
    			padding+3, height-padding-3,
    			width-padding-3, height-padding-3});
		ga.setStyle(shadedStyle);
		ga.setLineVisible(false);
		
		// Create inner rectangle
		final GraphicsAlgorithm inner = gaService.createPlainRectangle(outline);
		gaService.setLocation(inner, padding, padding);
		gaService.setSize(inner, width-padding*2, height-padding*2);
		inner.setStyle(style);
		
		// Create additional line segments
		gaService.createPlainPolyline(outline, new int[] {
    			0, 0,
    			padding+3, padding+3}).setStyle(style);
		
		gaService.createPlainPolyline(outline, new int[] {
    			width, 0,
    			width-padding-3, padding+3}).setStyle(style);
		
		gaService.createPlainPolyline(outline, new int[] {
    			width-padding-3, height-padding-3,
    			width, height}).setStyle(style);
		
		gaService.createPlainPolyline(outline, new int[] {
    			0, height,
    			padding+3, height-padding-3}).setStyle(style);
		
		return outline;
	}
	
	private static GraphicsAlgorithm createMemoryGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Style style, final int width, final int height) {
		final  int ellipseHeight = 20;
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(container);
		gaService.setSize(ga, width, height);
		ga.setLineVisible(false);
		ga.setFilled(false);
		
		final GraphicsAlgorithm bottomEllipse = gaService.createPlainEllipse(ga);
		gaService.setLocationAndSize(bottomEllipse, 0, height-ellipseHeight, width, ellipseHeight);
		bottomEllipse.setStyle(style);
		
		final GraphicsAlgorithm topEllipse = gaService.createPlainEllipse(ga);
		gaService.setLocationAndSize(topEllipse, 0, 0, width, ellipseHeight);
		topEllipse.setStyle(style);
		
		final GraphicsAlgorithm maskRect = gaService.createPlainRectangle(ga);
		gaService.setLocationAndSize(maskRect, 0, ellipseHeight, width, height-ellipseHeight-ellipseHeight/2);
		maskRect.setStyle(style);
		maskRect.setLineVisible(false);
		
		// Create vertical lines
		gaService.createPlainPolyline(ga, new int[] {
    			0, ellipseHeight/2,
    			0, height-ellipseHeight/2}).setStyle(style);
		
		gaService.createPlainPolyline(ga, new int[] {
    			width-2, ellipseHeight/2,
    			width-2, height-ellipseHeight/2}).setStyle(style);
		
		return ga;
	}

	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreationService#createFeatureGroupGraphicsAlgorithm(org.eclipse.graphiti.mm.GraphicsAlgorithmContainer, org.eclipse.graphiti.mm.pictograms.Diagram, int, int)
	 */
	@Override
	public GraphicsAlgorithm createFeatureGroupGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Diagram diagram, final int width, final int height) {
		final Style style = styleUtil.getFeatureGroupStyle(diagram);
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
}

package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.features.IFeatureProvider;
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
import org.osate.aadl2.AbstractClassifier;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.BusClassifier;
import org.osate.aadl2.BusSubcomponent;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DeviceClassifier;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.MemoryClassifier;
import org.osate.aadl2.MemorySubcomponent;
import org.osate.aadl2.Port;
import org.osate.aadl2.ProcessClassifier;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorClassifier;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramGroupClassifier;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SystemClassifier;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.ThreadClassifier;
import org.osate.aadl2.ThreadGroupClassifier;
import org.osate.aadl2.ThreadGroupSubcomponent;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.VirtualBusClassifier;
import org.osate.aadl2.VirtualBusSubcomponent;
import org.osate.aadl2.VirtualProcessorClassifier;
import org.osate.aadl2.VirtualProcessorSubcomponent;

import edu.uah.rsesc.aadl.age.util.StyleUtil;

// TODO: Eventually replace with an extension mechanism similar to the ones for styles. Goal would be to allow sharing of graphics algorithms, sharing symbols, and 
// allowing flexibility such as allowing the user to override symbols for particular shapes. In that case may move out of common package.
// Some methods may not be included in such a system(such as createLabel*) but that is TBD
public class GraphicsAlgorithmCreator {
	public static Text createLabelGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Diagram diagram, final String labelTxt) {
		final IGaService gaService = Graphiti.getGaService();
		final Text text = gaService.createPlainText(container, labelTxt);
        text.setStyle(StyleUtil.getLabelStyle(diagram));
        return text;
	}
	
	/**
	 * Creates a graphics algorithm representing a specified classifer or subcomponent. 
	 * @param container
	 * @param diagram
	 * @param element the classifier or subcomponent for which to create the graphics algorithm. If the classifier is null then a generic representation is returned.
	 * @param width
	 * @param height
	 * @return
	 */
	public static GraphicsAlgorithm createClassifierGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Diagram diagram, final Element element, final int width, final int height) {
		final boolean isImplementation = element instanceof ComponentImplementation;
        
		// TODO: Replace with a map?
        GraphicsAlgorithm ga = null;
        if(element instanceof SystemClassifier || element instanceof SystemSubcomponent) {
        	ga = createSystemGraphicsAlgorithm(container, StyleUtil.getSystemStyle(diagram, isImplementation), width, height);
        } else if(element instanceof ProcessClassifier || element instanceof ProcessSubcomponent) {
        	ga = createProcessGraphicsAlgorithm(container, StyleUtil.getProcessStyle(diagram, isImplementation), width, height);
        } else if(element instanceof ThreadGroupClassifier || element instanceof ThreadGroupSubcomponent) {
        	ga = createThreadGroupGraphicsAlgorithm(container, StyleUtil.getThreadGroupStyle(diagram, isImplementation), width, height);
        } else if(element instanceof ThreadClassifier || element instanceof ThreadSubcomponent) {
        	ga = createThreadGraphicsAlgorithm(container, StyleUtil.getThreadStyle(diagram, isImplementation), width, height);
        } else if(element instanceof SubprogramClassifier || element instanceof SubprogramSubcomponent) {
        	ga = createSubprogramGraphicsAlgorithm(container, StyleUtil.getSubprogramStyle(diagram, isImplementation), width, height);
        } else if(element instanceof SubprogramGroupClassifier || element instanceof SubprogramGroupSubcomponent) {
        	ga = createSubprogramGroupGraphicsAlgorithm(container, StyleUtil.getSubprogramGroupStyle(diagram, isImplementation), width, height);
        } else if(element instanceof DataClassifier || element instanceof DataSubcomponent) {
        	ga = createDataGraphicsAlgorithm(container, StyleUtil.getDataStyle(diagram, isImplementation), width, height);
        } else if(element instanceof AbstractClassifier || element instanceof AbstractSubcomponent) {
        	ga = createAbstractGraphicsAlgorithm(container, StyleUtil.getAbstractStyle(diagram, isImplementation), width, height);
        } else if(element instanceof VirtualBusClassifier || element instanceof VirtualBusSubcomponent ) {
        	ga = createBusGraphicsAlgorithm(container, StyleUtil.getVirtualBusStyle(diagram, isImplementation), width, height);
        } else if(element instanceof VirtualProcessorClassifier || element instanceof VirtualProcessorSubcomponent) {
        	ga = createProcessorGraphicsAlgorithm(container, StyleUtil.getVirtualProcessorStyle(diagram, isImplementation), width, height);
        } else if(element instanceof BusClassifier || element instanceof BusSubcomponent) {
        	ga = createBusGraphicsAlgorithm(container, StyleUtil.getBusStyle(diagram, isImplementation), width, height);
        } else if(element instanceof ProcessorClassifier || element instanceof ProcessorSubcomponent) {
        	ga = createProcessorGraphicsAlgorithm(container, StyleUtil.getProcessorStyle(diagram, isImplementation), width, height);
        } else if(element instanceof DeviceClassifier || element instanceof DeviceSubcomponent) {     	
        	ga = createDeviceGraphicsAlgorithm(container, StyleUtil.getDeviceStyle(diagram, isImplementation), StyleUtil.getShadedStyle(diagram), width, height);
        } else if(element instanceof MemoryClassifier || element instanceof MemorySubcomponent) {
        	ga = createMemoryGraphicsAlgorithm(container, StyleUtil.getMemoryStyle(diagram, isImplementation), width, height);
        } else if(element instanceof FeatureGroupType) {
        	ga = createFeatureGroupGraphicsAlgorithm(container, diagram, Math.min(width/3, height/3), height);
        	ga.setWidth(width);
        } else {
        	// Create a generic shape
        	ga = createDummyGraphicsAlgorithm(container, width, height);
        }
        
        return ga;
	}
	
	public static GraphicsAlgorithm createFeatureGraphicsAlgorithm(final Shape shape, final Diagram diagram, final Feature feature, final IFeatureProvider fp) {
		final IGaService gaService = Graphiti.getGaService();
        
		// TODO: The direction is affected by inverse of in the feature and in containing feature group and feature group types....
		// must figure out by walking shapes since the container of some features may be a feature group type that isn't appropriate.
		// for example getting the features of an implicitly defined inverse feature group type will return the non-inverse feature group
		DirectionType direction = null;
		if(feature instanceof DirectedFeature) {
			direction = ((DirectedFeature)feature).getDirection();
			if(direction == DirectionType.IN || direction == DirectionType.OUT) {
				if(ClassifierHelper.isFeatureInverted(shape, fp)) {
					direction = (direction == DirectionType.IN) ? DirectionType.OUT : DirectionType.IN;
				}				
			}
		}
		
		// TODO: Do similar for access type
		
        // Abstract Feature
		GraphicsAlgorithm ga;	
		
		if(feature instanceof Port) {
			final Style style = StyleUtil.getFeatureStyle(diagram);
			final boolean hasData = feature instanceof DataPort || feature instanceof EventDataPort;
			final boolean hasEvent = feature instanceof EventPort || feature instanceof EventDataPort;
			
			ga = gaService.createInvisibleRectangle(shape);
        	
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
            GraphicsAlgorithmUtil.shrink(ga);
		}
		else if(feature instanceof AbstractFeature) { // Abstract Feature
			final Style style = StyleUtil.getFeatureStyle(diagram);
        	ga = gaService.createInvisibleRectangle(shape);
        	gaService.setSize(ga,  25,  20);
        	
        	final GraphicsAlgorithm circleGa = gaService.createPlainEllipse(ga);
        	circleGa.setStyle(style);
        	gaService.setLocation(circleGa, 0, 5);
            gaService.setSize(circleGa, 10, 10);

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
            GraphicsAlgorithmUtil.shrink(ga);
        } else if(feature instanceof Access) {
        	final Access access = (Access)feature;
        	AccessType accessType = access.getKind();
        	if(ClassifierHelper.isFeatureInverted(shape, fp)) {
        		accessType = (accessType == AccessType.PROVIDES) ? AccessType.REQUIRES : AccessType.PROVIDES;
        	}
        	int width = 0;
        	int height = 0;
        	
        	ga = gaService.createInvisibleRectangle(shape);
        	
        	if(access instanceof BusAccess || access instanceof DataAccess) {
        		final Style style = StyleUtil.getFeatureStyle(diagram);
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
        		GraphicsAlgorithmUtil.shrink(ga);
        	} else if(access instanceof SubprogramAccess || access instanceof SubprogramGroupAccess) {
        		final Style style = access instanceof SubprogramAccess ? StyleUtil.getSubprogramAccessStyle(diagram) : StyleUtil.getSubprogramGroupAccessStyle(diagram);
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
        	GraphicsAlgorithmUtil.shrink(ga);
        } else if(feature instanceof FeatureGroup) {
        	// TODO: Remove or merge with work in Type Feature Pattern
        	// Issue: The current method of rendering the compact feature group symbol relies on writing a color that matches this background. This can effectively erase lines drawn,
        	// by the parent shape.
        	// TODO: Eventually implement semi-circle rendering, render from SVG, or use an alternative shape.
        	
        	final int bigCircleSize = 25;
        	final int gaWidthReduction = 5;
        	final int bigCircleVisibleWidth = 10;
        	ga = gaService.createInvisibleRectangle(shape);
        	gaService.setSize(ga, bigCircleSize-gaWidthReduction, bigCircleSize);
        	
        	final GraphicsAlgorithm bigCircleGa = gaService.createPlainEllipse(ga);
        	gaService.setLocation(bigCircleGa, ga.getWidth()-bigCircleSize, 0);
    		gaService.setSize(bigCircleGa, bigCircleSize, bigCircleSize);
    		bigCircleGa.setStyle(StyleUtil.getFeatureGroupLargeCircleStyle(diagram));
    		
    		final GraphicsAlgorithm blockGa = gaService.createPlainRectangle(ga);
    		gaService.setLocation(blockGa, 0, 0);
    		gaService.setSize(blockGa, ga.getWidth()-bigCircleVisibleWidth, ga.getHeight());
    		blockGa.setStyle(StyleUtil.getBackgroundStyle(diagram));
    		
    		final int smallCircleSize = bigCircleSize/2;
    		final GraphicsAlgorithm smallCircleGa = gaService.createPlainEllipse(ga);
    		gaService.setLocation(smallCircleGa, 0, (ga.getHeight()-smallCircleSize)/2);
    		gaService.setSize(smallCircleGa, smallCircleSize, smallCircleSize);
    		smallCircleGa.setStyle(StyleUtil.getFeatureGroupSmallCircleStyle(diagram));    		
        } else {
        	ga = gaService.createPlainRectangle(shape);
            gaService.setSize(ga, 10, 10);
        }
		
		// TODO: Consider adjusting things so that the width and height are always such that the feature can be centered appropriately...
		// TODO: Consider selection will be based off the outer Ga size so that may be a bad idea
	
		
		
		return ga;
	}
	
	public static GraphicsAlgorithm createModeGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Diagram diagram, int width, int height) {
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
		ga.setStyle(StyleUtil.getModeStyle(diagram));
		gaService.setSize(ga, width, height);
		
		return ga;
	}
	
	public static GraphicsAlgorithm createInitialModeGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Diagram diagram, int size) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createEllipse(container);
		ga.setStyle(StyleUtil.getInitialModeStyle(diagram));
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

	public static GraphicsAlgorithm createFeatureGroupGraphicsAlgorithm(final GraphicsAlgorithmContainer container, final Diagram diagram, final int width, final int height) {
		final Style style = StyleUtil.getFeatureGroupStyle(diagram);
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

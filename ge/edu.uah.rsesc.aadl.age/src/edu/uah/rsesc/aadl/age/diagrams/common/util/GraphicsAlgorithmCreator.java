package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.osate.aadl2.AbstractClassifier;
import org.osate.aadl2.BusClassifier;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DeviceClassifier;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.MemoryClassifier;
import org.osate.aadl2.ProcessClassifier;
import org.osate.aadl2.ProcessorClassifier;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramGroupClassifier;
import org.osate.aadl2.SystemClassifier;
import org.osate.aadl2.ThreadClassifier;
import org.osate.aadl2.ThreadGroupClassifier;
import org.osate.aadl2.VirtualBusClassifier;
import org.osate.aadl2.VirtualProcessorClassifier;

import edu.uah.rsesc.aadl.age.util.StyleUtil;

// TODO: Eventually replace with an extension mechanism similar to the ones for styles. Goal would be to allow sharing of graphics algorithms, sharing symbols, and 
// allowing flexibility such as allowing the user to override symbols for particular shapes. In that case may move out of common package.
public class GraphicsAlgorithmCreator {
	public static GraphicsAlgorithm createGraphicsAlgorithm(final ContainerShape container, final Diagram diagram, final Classifier classifier, final int width, final int height) {
		final boolean isImplementation = classifier instanceof ComponentImplementation;
        
		// TODO: Replace with a map?
        GraphicsAlgorithm ga = null;
        if(classifier instanceof SystemClassifier) {
        	ga = createSystemGraphicsAlgorithm(container, StyleUtil.getSystemStyle(diagram, isImplementation), width, height);
        } else if(classifier instanceof ProcessClassifier) {
        	ga = createProcessGraphicsAlgorithm(container, StyleUtil.getProcessStyle(diagram, isImplementation), width, height);
        } else if(classifier instanceof ThreadGroupClassifier) {
        	ga = createThreadGroupGraphicsAlgorithm(container, StyleUtil.getThreadGroupStyle(diagram, isImplementation), width, height);
        } else if(classifier instanceof ThreadClassifier) {
        	ga = createThreadGraphicsAlgorithm(container, StyleUtil.getThreadStyle(diagram, isImplementation), width, height);
        } else if(classifier instanceof SubprogramClassifier) {
        	ga = createSubprogramGraphicsAlgorithm(container, StyleUtil.getSubprogramStyle(diagram, isImplementation), width, height);
        } else if(classifier instanceof SubprogramGroupClassifier) {
        	ga = createSubprogramGroupGraphicsAlgorithm(container, StyleUtil.getSubprogramGroupStyle(diagram, isImplementation), width, height);
        } else if(classifier instanceof DataClassifier) {
        	ga = createDataGraphicsAlgorithm(container, StyleUtil.getDataStyle(diagram, isImplementation), width, height);
        } else if(classifier instanceof AbstractClassifier) {
        	ga = createAbstractGraphicsAlgorithm(container, StyleUtil.getAbstractStyle(diagram, isImplementation), width, height);
        } else if(classifier instanceof VirtualBusClassifier) {
        	ga = createBusGraphicsAlgorithm(container, StyleUtil.getVirtualBusStyle(diagram, isImplementation), width, height);
        } else if(classifier instanceof VirtualProcessorClassifier) {
        	ga = createProcessorGraphicsAlgorithm(container, StyleUtil.getVirtualProcessorStyle(diagram, isImplementation), width, height);
        } else if(classifier instanceof BusClassifier) {
        	ga = createBusGraphicsAlgorithm(container, StyleUtil.getBusStyle(diagram, isImplementation), width, height);
        } else if(classifier instanceof ProcessorClassifier) {
        	ga = createProcessorGraphicsAlgorithm(container, StyleUtil.getProcessorStyle(diagram, isImplementation), width, height);
        } else if(classifier instanceof DeviceClassifier) {     	
        	ga = createDeviceGraphicsAlgorithm(container, StyleUtil.getDeviceStyle(diagram, isImplementation), StyleUtil.getShadedStyle(diagram), width, height);
        } else if(classifier instanceof MemoryClassifier) {
        	ga = createMemoryGraphicsAlgorithm(container, StyleUtil.getMemoryStyle(diagram, isImplementation), width, height);
        } else if(classifier instanceof FeatureGroupType) {
        	ga = createFeatureGroupGraphicsAlgorithm(container, StyleUtil.getFeatureGroupTypeStyle(diagram), width, height);
        } else {
        	// TODO: Decide how to handle? Don't create shape? Create a generic shape?
        	ga = createDummyGraphicsAlgorithm(container, width, height);
        }
        
        return ga;
	}
	
	public static GraphicsAlgorithm createGraphicsAlgorithm(final Shape container, final Diagram diagram, final Feature feature) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(container);
        gaService.setSize(ga, 10, 10);
        
		return ga;
	}
	
	private static GraphicsAlgorithm createDummyGraphicsAlgorithm(final ContainerShape containerShape, int width, int height) {
		final RoundedRectangle roundedRectangle = Graphiti.getGaService().createPlainRoundedRectangle(containerShape, 5, 5);
        Graphiti.getGaService().setSize(roundedRectangle, width, height);
        return roundedRectangle;
	}
	
	private static GraphicsAlgorithm createSystemGraphicsAlgorithm(final Shape container, final Style style, final int width, final int height) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainRoundedRectangle(container, 5, 5);
    	gaService.setSize(ga, width, height);
    	ga.setStyle(style);
    	return ga;
	}
	
	private static GraphicsAlgorithm createProcessGraphicsAlgorithm(final Shape container, final Style style, final int width, final int height) {
		final GraphicsAlgorithm ga = createParallelogram(container, width, height, 20);
		ga.setStyle(style);
		return ga;
	}
	
	private static GraphicsAlgorithm createThreadGroupGraphicsAlgorithm(final Shape container, final Style style, final int width, final int height) {
		return createSystemGraphicsAlgorithm(container, style, width, height);
	}
	
	private static GraphicsAlgorithm createThreadGraphicsAlgorithm(final Shape container, final Style style, final int width, final int height) {
		return createProcessGraphicsAlgorithm(container, style, width, height);
	}
	
	private static GraphicsAlgorithm createSubprogramGraphicsAlgorithm(final Shape container, final Style style, final int width, final int height) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainEllipse(container);
    	gaService.setSize(ga, width, height);
        ga.setStyle(style);
    	return ga;
	}
	
	private static GraphicsAlgorithm createSubprogramGroupGraphicsAlgorithm(final Shape container, final Style style, final int width, final int height) {
		return createSubprogramGraphicsAlgorithm(container, style, width, height);
	}
	
	private static GraphicsAlgorithm createDataGraphicsAlgorithm(final Shape container, final Style style, final int width, final int height) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(container);
    	gaService.setSize(ga, width, height);
        ga.setStyle(style);
    	return ga;
	}
	
	private static GraphicsAlgorithm createAbstractGraphicsAlgorithm(final Shape container, final Style style, final int width, final int height) {
		return createDataGraphicsAlgorithm(container, style, width, height);
	}
	
	private static GraphicsAlgorithm createBusGraphicsAlgorithm(final Shape container, final Style style, final int width, final int height) {
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
	
	private static GraphicsAlgorithm createProcessorGraphicsAlgorithm(final ContainerShape container, final Style style, final int width, final int height) {
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
	private static GraphicsAlgorithm createDeviceGraphicsAlgorithm(final ContainerShape container, final Style style, final Style shadedStyle, final int width, final int height) {
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
	
	private static GraphicsAlgorithm createMemoryGraphicsAlgorithm(final Shape container, final Style style, final int width, final int height) {
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
	
	private static GraphicsAlgorithm createFeatureGroupGraphicsAlgorithm(final Shape container, final Style style, final int width, final int height) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(container);
		final int circleSize = Math.min(width/4, height/4);
		final int barWidth = circleSize/2;
		gaService.setSize(ga, width, height);
		ga.setLineVisible(false);
		ga.setFilled(false);		
		
		// Circle
		final GraphicsAlgorithm circle = gaService.createPlainEllipse(ga);
		gaService.setLocationAndSize(circle, width-circleSize, height/2-circleSize/2, circleSize, circleSize);
		circle.setStyle(style);
		
		// Bar
		final GraphicsAlgorithm bar = gaService.createPlainRectangle(ga);
		gaService.setLocationAndSize(bar, circle.getX()-barWidth+1, 0, barWidth, height);
		bar.setStyle(style);
		
		return ga;
	}
	
	private static GraphicsAlgorithm createParallelogram(final Shape container, final int width, final int height, int horizontalOffset) {
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

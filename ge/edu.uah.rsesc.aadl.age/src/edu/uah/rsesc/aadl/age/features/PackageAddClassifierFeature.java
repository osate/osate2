package edu.uah.rsesc.aadl.age.features;

import java.awt.Color;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.osate.aadl2.AbstractClassifier;
import org.osate.aadl2.BusClassifier;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DeviceClassifier;
import org.osate.aadl2.FeatureGroup;
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

import edu.uah.rsesc.aadl.age.util.Log;
import edu.uah.rsesc.aadl.age.util.StyleUtil;

public class PackageAddClassifierFeature extends AbstractAddShapeFeature {
	public PackageAddClassifierFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		if(context.getNewObject() instanceof Classifier) {
			if(context.getTargetContainer() instanceof Diagram) {
				return true;
			}
		}
		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		final Classifier classifier = (Classifier)context.getNewObject();
		final Diagram diagram = getDiagram();
		
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final IGaService gaService = Graphiti.getGaService();
		
		int width = 100;
        int height = 50; 
        
        // Create the container shape
        final ContainerShape containerShape = peCreateService.createContainerShape(diagram, true);
        link(containerShape, classifier);
        
        // TODO: set size calls should be handled by creator of GA's? (both not location?)
        
        final boolean isImplementation = classifier instanceof ComponentImplementation;
        
        // TODO: Determine need for setLocationAndSize calls. What about for processors which have child shapes?
        // TODO: Adjust shape depending on type of classifier
        GraphicsAlgorithm ga = null;
        if(classifier instanceof SystemClassifier) {
        	ga = gaService.createPlainRoundedRectangle(containerShape, 5, 5);
            gaService.setLocationAndSize(ga, context.getX(), context.getY(), width, height);
            ga.setStyle(StyleUtil.getSystemStyle(diagram, isImplementation));
        } else if(classifier instanceof ProcessClassifier) {
        	ga = createParallelogram(containerShape, width, height, 20);
        	ga.setStyle(StyleUtil.getProcessStyle(diagram, isImplementation));
        	gaService.setLocationAndSize(ga, context.getX(), context.getY(), width, height);        	
        } else if(classifier instanceof ThreadGroupClassifier) {
        	ga = gaService.createPlainRoundedRectangle(containerShape, 5, 5);
            gaService.setLocationAndSize(ga, context.getX(), context.getY(), width, height);
            ga.setStyle(StyleUtil.getThreadGroupStyle(diagram, isImplementation));
        } else if(classifier instanceof ThreadClassifier) {
        	ga = createParallelogram(containerShape, width, height, 20);
        	gaService.setLocationAndSize(ga, context.getX(), context.getY(), width, height);
            ga.setStyle(StyleUtil.getThreadStyle(diagram, isImplementation));
        } else if(classifier instanceof SubprogramClassifier) {
        	ga = gaService.createPlainEllipse(containerShape);
            gaService.setLocationAndSize(ga, context.getX(), context.getY(), width, height);
            ga.setStyle(StyleUtil.getSubprogramStyle(diagram, isImplementation));
        } else if(classifier instanceof SubprogramGroupClassifier) {
        	ga = gaService.createPlainEllipse(containerShape);
            gaService.setLocationAndSize(ga, context.getX(), context.getY(), width, height);
            ga.setStyle(StyleUtil.getSubprogramGroupStyle(diagram, isImplementation));
        } else if(classifier instanceof DataClassifier) {
        	ga = gaService.createPlainRectangle(containerShape);
            gaService.setLocationAndSize(ga, context.getX(), context.getY(), width, height);
            ga.setStyle(StyleUtil.getDataStyle(diagram, isImplementation));
        } else if(classifier instanceof AbstractClassifier) {
        	ga = gaService.createPlainRectangle(containerShape);
            gaService.setLocationAndSize(ga, context.getX(), context.getY(), width, height);
            ga.setStyle(StyleUtil.getAbstractStyle(diagram, isImplementation));
        } else if(classifier instanceof VirtualBusClassifier) {
        	ga = createBusShape(containerShape, width, height, 20, 12);
            gaService.setLocationAndSize(ga, context.getX(), context.getY(), width, height);
            ga.setStyle(StyleUtil.getVirtualBusStyle(diagram, isImplementation));
        } else if(classifier instanceof VirtualProcessorClassifier) {
        	ga = createProcessorShape(containerShape, StyleUtil.getVirtualProcessorStyle(diagram, isImplementation), width, height, 10, 12);
            gaService.setLocationAndSize(ga, context.getX(), context.getY(), width, height);
        } else if(classifier instanceof BusClassifier) {
        	ga = createBusShape(containerShape, width, height, 20, 12);
            gaService.setLocationAndSize(ga, context.getX(), context.getY(), width, height);
            ga.setStyle(StyleUtil.getBusStyle(diagram, isImplementation));
        } else if(classifier instanceof ProcessorClassifier) {
        	ga = createProcessorShape(containerShape, StyleUtil.getProcessorStyle(diagram, isImplementation), width, height, 10, 12);
            gaService.setLocationAndSize(ga, context.getX(), context.getY(), width, height);
        } else if(classifier instanceof DeviceClassifier) {     	
        	ga = createDeviceShape(containerShape, StyleUtil.getDeviceStyle(diagram, isImplementation), StyleUtil.getShadedStyle(diagram), width, height, 4);
            gaService.setLocationAndSize(ga, context.getX(), context.getY(), width, height);
        } else if(classifier instanceof MemoryClassifier) {
        	ga = createMemoryShape(containerShape, StyleUtil.getMemoryStyle(diagram, isImplementation), width, height, 20);
            gaService.setLocation(ga, context.getX(), context.getY());
        } else if(classifier instanceof FeatureGroupType) {
        	ga = createFeatureGroupShape(containerShape, StyleUtil.getFeatureGroupStyle(diagram, isImplementation), width, height);
        	gaService.setLocation(ga, context.getX(), context.getY());
        } else {
        	// TODO: Decide how to handle? Don't create shape? Create a genertic shape?
        	ga = createDummyShape(containerShape, context, width, height);
        }
        
        // Create anchor
        final Anchor anchor = peCreateService.createChopboxAnchor(containerShape);
        anchor.setReferencedGraphicsAlgorithm(ga);
        
        // Create label
        Shape shape = peCreateService.createShape(containerShape, false);
        
        final String label = (this.getBusinessObjectForPictogramElement(diagram) == classifier.getNamespace().getOwner()) ? classifier.getName() : classifier.getQualifiedName(); 
        final Text text = gaService.createPlainText(shape, label);
        text.setStyle(StyleUtil.getClassifierLabelStyle(diagram));
        gaService.setLocationAndSize(text, 0, 0, width, 20);

        return containerShape;
	}
	
	// TODO: Naming. doesn't create shapes. Creates graphics algorithms
	
	private GraphicsAlgorithm createDummyShape(final ContainerShape containerShape, final IAddContext context, int width, int height) {
		final RoundedRectangle roundedRectangle = Graphiti.getGaService().createPlainRoundedRectangle(containerShape, 5, 5);
        Graphiti.getGaService().setLocationAndSize(roundedRectangle, context.getX(), context.getY(), width, height);
        return roundedRectangle;
	}
	
	private Polygon createParallelogram(final Shape container, final int width, final int height, int horizontalOffset) {
		final IGaService gaService = Graphiti.getGaService();
		return gaService.createPlainPolygon(container, 
    			new int[] {
    			horizontalOffset, 0,
    			width, 0,
    			width-horizontalOffset, height,
    			0, height});
	}
	
	private Polygon createBusShape(final Shape container, final int width, final int height, final int arrowHeadWidth, final int arrowHeadVerticalExtensionSize) {
		final IGaService gaService = Graphiti.getGaService();
		return gaService.createPlainPolygon(container, 
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
	}
	
	private Polygon createProcessorShape(final ContainerShape container, final Style style, final int width, final int height, int horizontalOffset, int depth) {
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

		// TODO: Shaded portion
		
		return outlinePolygon;
	}
	
	// TODO: Need to take line size into account when making things connect? Update processor
	
	// TODO: Avoid hardcoded numbers. Especially repeated	
	private GraphicsAlgorithm createDeviceShape(final ContainerShape container, final Style style, final Style shadedStyle, final int width, final int height, int padding) {
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
	
	private GraphicsAlgorithm createMemoryShape(final Shape container, final Style style, final int width, final int height, int ellipseHeight) {
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
	
	private GraphicsAlgorithm createFeatureGroupShape(final Shape container, final Style style, final int width, final int height) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(container);
		gaService.setSize(ga, width, height);
		ga.setLineVisible(false);
		ga.setFilled(false);
		
		// TODO: Sizing. Take into account dimensions, features, etc
		
		// Circle
		final GraphicsAlgorithm circle = gaService.createPlainEllipse(ga);
		// TODO: Cap circle size?
		// TODO: Take into account width\height ratio?		
		final int circleSize = width/6;
		gaService.setLocationAndSize(circle, width-circleSize, height/2-circleSize/2, circleSize, circleSize);
		circle.setStyle(style);
		
		// Bar
		final GraphicsAlgorithm bar = gaService.createPlainRectangle(ga);
		final int barWidth = 10;
		gaService.setLocationAndSize(bar, circle.getX()-barWidth+1, 0, barWidth, height);
		bar.setStyle(style);
		
		// TODO: Feature Indicators
		
		return ga;
	}
	
	// TODO: Resizing of polygon shape
}

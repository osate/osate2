package org.osate.ge.internal.graphiti.graphics;

import java.awt.geom.Point2D;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;
import org.osate.ge.internal.DockArea;
import org.osate.ge.internal.graphics.BusGraphic;
import org.osate.ge.internal.graphics.DeviceGraphic;
import org.osate.ge.internal.graphics.Direction;
import org.osate.ge.internal.graphics.Ellipse;
import org.osate.ge.internal.graphics.FeatureGraphic;
import org.osate.ge.internal.graphics.FeatureGroupTypeGraphic;
import org.osate.ge.internal.graphics.FolderGraphic;
import org.osate.ge.internal.graphics.LineStyle;
import org.osate.ge.internal.graphics.MemoryGraphic;
import org.osate.ge.internal.graphics.Parallelogram;
import org.osate.ge.internal.graphics.Polygon;
import org.osate.ge.internal.graphics.ProcessorGraphic;
import org.osate.ge.internal.graphics.Rectangle;

public class AgeGraphitiGraphicsUtil {
	private final static int folderTabHeight = 9;
	private final static int folderMaxTabWidth = 100;
	private final static double folderTabOffsetAngle = 30.0;
	private final static double folderTopOfTabOffset = 0.3;
	private final static int featureLineWidth = 2;
	public static final int featureGroupDefaultSymbolWidth = 30;
	private static final Map<Object, GraphicsAlgorithmCreator<?>> graphicToCreatorMap;
	
	@FunctionalInterface
	static interface GraphicsAlgorithmCreator<G> {
		GraphicsAlgorithm createGraphicsAlgorithm(Diagram diagram, GraphicsAlgorithm containerGa, G graphic, int width, int height, boolean fillBackground);
	}
		
	static <G> void addGraphicsAlgorithmCreator(final Map<Object, GraphicsAlgorithmCreator<?>> map, Class<G> c, final GraphicsAlgorithmCreator<G> a) {
		map.put(c, a);
	}
	
	static {
		final Map<Object, GraphicsAlgorithmCreator<?>> map = new HashMap<>();
		addGraphicsAlgorithmCreator(map, Rectangle.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForRectangle);		
		addGraphicsAlgorithmCreator(map, Ellipse.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForEllipse);
		addGraphicsAlgorithmCreator(map, Polygon.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForPolygon);
		addGraphicsAlgorithmCreator(map, Parallelogram.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForParallelogram);
		addGraphicsAlgorithmCreator(map, DeviceGraphic.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForDevice);
		addGraphicsAlgorithmCreator(map, BusGraphic.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForBus);
		addGraphicsAlgorithmCreator(map, ProcessorGraphic.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForProcessor);
		addGraphicsAlgorithmCreator(map, MemoryGraphic.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForMemory);
		addGraphicsAlgorithmCreator(map, FeatureGroupTypeGraphic.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForFeatureGroupType);
		addGraphicsAlgorithmCreator(map, FolderGraphic.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForFolder);
		addGraphicsAlgorithmCreator(map, FeatureGraphic.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForFeature);
		graphicToCreatorMap = Collections.unmodifiableMap(map);
	}	
	
	public static org.eclipse.graphiti.mm.algorithms.styles.LineStyle toGraphitiLineStyle(final LineStyle lineStyle) {
	    switch(lineStyle) {
		case DASHED:
			return org.eclipse.graphiti.mm.algorithms.styles.LineStyle.DASH;
			
		case SOLID:
			return org.eclipse.graphiti.mm.algorithms.styles.LineStyle.SOLID;
			
		default:
			return  org.eclipse.graphiti.mm.algorithms.styles.LineStyle.SOLID;	        
	    }
	}
	
	// Returns the new graphics algorithm
	public static GraphicsAlgorithm createGraphicsAlgorithm(final Diagram diagram, final GraphicsAlgorithm shapeGa, final Object graphic, final int width, final int height, boolean fillBackground) {
		// TODO: Rename
		@SuppressWarnings("unchecked")
		final GraphicsAlgorithmCreator<Object> c = (GraphicsAlgorithmCreator<Object>) graphicToCreatorMap.get(graphic.getClass());
		if(c == null) {
			throw new RuntimeException("Unsupported object: " + graphic);
		}
		
		return c.createGraphicsAlgorithm(diagram, shapeGa, graphic, width, height, fillBackground);
	}	
	
	/**
	 * Helper method for returning the inner graphics algorithm for a top level graphics algorithm. The inner graphics algorithm contains the actual
	 * symbol for the shape.
	 */
	public static GraphicsAlgorithm getInnerGraphicsAlgorithm(final GraphicsAlgorithm ga) {
		return ga.getGraphicsAlgorithmChildren().get(0);
	}
	
	private static GraphicsAlgorithm createGraphicsAlgorithmForRectangle(final Diagram diagram, final GraphicsAlgorithm containerGa, final Rectangle r, final int width, final int height, boolean fillBackground) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga;
		if(r.rounded) {
			ga = gaService.createPlainRoundedRectangle(containerGa, 25, 25);
		} else {
			ga = gaService.createPlainRectangle(containerGa);
		}
		ga.setLineWidth(r.lineWidth);
		ga.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(r.lineStyle));
		ga.setForeground(gaService.manageColor(diagram, ColorConstant.BLACK));			
		ga.setBackground(gaService.manageColor(diagram, ColorConstant.WHITE));
		ga.setFilled(fillBackground);
        gaService.setSize(ga, width, height);
        
        return ga;
	}
	
	private static GraphicsAlgorithm createGraphicsAlgorithmForEllipse(final Diagram diagram, final GraphicsAlgorithm containerGa, final Ellipse ellipse, final int width, final int height, boolean fillBackground) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainEllipse(containerGa);
        ga.setLineWidth(ellipse.lineWidth);
        ga.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(ellipse.lineStyle));
		ga.setForeground(gaService.manageColor(diagram, ColorConstant.BLACK));
		ga.setBackground(gaService.manageColor(diagram, ColorConstant.WHITE));
		ga.setFilled(fillBackground);
        gaService.setSize(ga, width, height);
        
        return ga;
	}
	
	private static GraphicsAlgorithm createGraphicsAlgorithmForPolygon(final Diagram diagram, final GraphicsAlgorithm containerGa, final Polygon poly, final int width, final int height, boolean fillBackground) {
		final int[] coords = new int[poly.getPoints().length * 2];
		int i = 0;

		// Build points based on the specified size
		for(final Point2D.Double p : poly.getPoints()) {
			coords[i++] = (int)(p.x * width);
			coords[i++] = (int)(p.y * height);
		}
		
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainPolygon(containerGa, coords);
		ga.setForeground(gaService.manageColor(diagram, ColorConstant.BLACK));
        ga.setBackground(gaService.manageColor(diagram, ColorConstant.WHITE));
        ga.setFilled(fillBackground);
        gaService.setSize(ga, width, height);
		return ga;
	}
	
	private static GraphicsAlgorithm createGraphicsAlgorithmForParallelogram(final Diagram diagram, final GraphicsAlgorithm containerGa, final Parallelogram parallelogram, final int width, final int height, boolean fillBackground) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainPolygon(containerGa, 
    			new int[] {
    					parallelogram.horizontalOffset, 0,
    			width, 0,
    			width-parallelogram.horizontalOffset, height,
    			0, height});
		
		ga.setLineWidth(parallelogram.lineWidth);
		ga.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(parallelogram.lineStyle));
		ga.setForeground(gaService.manageColor(diagram, ColorConstant.BLACK));
        ga.setBackground(gaService.manageColor(diagram, ColorConstant.WHITE));
        ga.setFilled(fillBackground);
        gaService.setSize(ga, width, height);
        
		return ga;
	}
	
	private static GraphicsAlgorithm createGraphicsAlgorithmForDevice(final Diagram diagram, final GraphicsAlgorithm containerGa, final DeviceGraphic dg, final int width, final int height, boolean fillBackground) {
		final IGaService gaService = Graphiti.getGaService();

		final int padding = 4;

		final Color black = gaService.manageColor(diagram, ColorConstant.BLACK);
		final Color white = gaService.manageColor(diagram, ColorConstant.WHITE);
		final Color gray = gaService.manageColor(diagram, ColorConstant.LIGHT_GRAY);
        
		// Create outer outline
		final GraphicsAlgorithm outline = gaService.createPlainRectangle(containerGa);
		outline.setLineWidth(dg.lineWidth);
		outline.setBackground(white);
		outline.setForeground(black);
		outline.setFilled(fillBackground);

		// Create shading
		GraphicsAlgorithm ga;
		ga = gaService.createPlainPolygon(outline, new int[] {
    			width, 0,
    			width, height,
    			width-padding, height-padding,
    			width-padding, padding});
		ga.setBackground(gray);
		ga.setTransparency(0.5);
		ga.setLineVisible(false);
		
		ga = gaService.createPlainPolygon(outline, new int[] {
    			width, height,
    			0, height,
    			padding, height-padding,
    			width-padding, height-padding});
		ga.setBackground(gray);
		ga.setTransparency(0.5);
		ga.setLineVisible(false);
				
		// Create inner rectangle
		final GraphicsAlgorithm inner = gaService.createPlainRectangle(outline);
		gaService.setLocation(inner, padding, padding);
		gaService.setSize(inner, width-padding*2, height-padding*2);
		inner.setLineWidth(dg.lineWidth);
		inner.setForeground(black);
		inner.setFilled(false);
		
		// Create additional line segments
		ga = gaService.createPlainPolyline(outline, new int[] {
    			0, 0,
    			padding+1, padding+1});
		ga.setLineWidth(dg.lineWidth);
		ga.setForeground(black);
		
		ga = gaService.createPlainPolyline(outline, new int[] {
    			width, 0,
    			width-padding-1, padding+1});
		ga.setLineWidth(dg.lineWidth);
		ga.setForeground(black);
		
		ga = gaService.createPlainPolyline(outline, new int[] {
    			width-padding-1, height-padding-1,
    			width, height});
		ga.setLineWidth(dg.lineWidth);
		ga.setForeground(black);
		
		ga = gaService.createPlainPolyline(outline, new int[] {
    			0, height,
    			padding+1, height-padding-1});
		ga.setLineWidth(dg.lineWidth);
		ga.setForeground(black);
		gaService.setSize(outline, width, height);
		
		return outline;
	}
	
	private static GraphicsAlgorithm createGraphicsAlgorithmForBus(final Diagram diagram, final GraphicsAlgorithm containerGa, final BusGraphic bg, final int width, final int height, boolean fillBackground) {		
		final IGaService gaService = Graphiti.getGaService();
		
		final int arrowHeadWidth = Math.max(Math.min(width, height)/4, 20);
		final int arrowHeadVerticalExtensionSize = height/4;
		final GraphicsAlgorithm ga = gaService.createPlainPolygon(containerGa, 
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

		ga.setLineWidth(bg.lineWidth);
		ga.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(bg.lineStyle));
		ga.setForeground(gaService.manageColor(diagram, ColorConstant.BLACK));
        ga.setBackground(gaService.manageColor(diagram, ColorConstant.WHITE));
        ga.setFilled(fillBackground);
        gaService.setSize(ga, width, height);
		return ga;
	}
	
	private static GraphicsAlgorithm createGraphicsAlgorithmForProcessor(final Diagram diagram, final GraphicsAlgorithm containerGa, final ProcessorGraphic pg, final int width, final int height, boolean fillBackground) {
		final IGaService gaService = Graphiti.getGaService();
		
		final Color black = gaService.manageColor(diagram, ColorConstant.BLACK);
		final Color white = gaService.manageColor(diagram, ColorConstant.WHITE);
		final org.eclipse.graphiti.mm.algorithms.styles.LineStyle lineStyle = toGraphitiLineStyle(pg.lineStyle);
		
		final int horizontalOffset = 10;
		final int depth = 12;

		// Create polygon for outline
		final org.eclipse.graphiti.mm.algorithms.Polygon outlinePolygon = gaService.createPlainPolygon(containerGa, 
    			new int[] {
    			0, height,
    			0, depth,
    			horizontalOffset, 0,
    			width, 0,
    			width, height-depth,
    			width-horizontalOffset, height});
		outlinePolygon.setLineWidth(pg.lineWidth);
		outlinePolygon.setLineStyle(lineStyle);
		outlinePolygon.setBackground(white);
		outlinePolygon.setForeground(black);
		outlinePolygon.setFilled(fillBackground);
		
		// Create child shapes for extra lines and shading
		GraphicsAlgorithm ga;
		ga = gaService.createPlainPolyline(outlinePolygon, new int[] {
    			0, depth,
    			width-horizontalOffset, depth,
    			width, 0});
		ga.setLineWidth(pg.lineWidth);
		ga.setLineStyle(lineStyle);
		ga.setForeground(black);
		
		ga = gaService.createPlainPolyline(outlinePolygon, new int[] {
    			width-horizontalOffset-1, depth-2,
    			width-horizontalOffset-1, height});
		ga.setLineWidth(pg.lineWidth);
		ga.setLineStyle(lineStyle);
		ga.setForeground(black);
		
		gaService.setSize(outlinePolygon, width, height);
		
		return outlinePolygon;
	}
	
	private static GraphicsAlgorithm createGraphicsAlgorithmForMemory(final Diagram diagram, final GraphicsAlgorithm containerGa, final MemoryGraphic mg, final int width, final int height, boolean fillBackground) {
		final IGaService gaService = Graphiti.getGaService();
		
		final Color black = gaService.manageColor(diagram, ColorConstant.BLACK);
		final Color white = gaService.manageColor(diagram, ColorConstant.WHITE);
		
		final int ellipseHeight = 20;
		final double halfEllipseHeight = ellipseHeight / 2.0;
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(containerGa);
		ga.setLineVisible(false);
		ga.setBackground(white);
		ga.setFilled(fillBackground);
		
		// Top ellipse
		final GraphicsAlgorithm topEllipse = gaService.createPlainEllipse(ga);
		gaService.setLocationAndSize(topEllipse, 0, 0, width, ellipseHeight);
		topEllipse.setForeground(black);
		topEllipse.setLineWidth(mg.lineWidth);
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
		linesGa.setLineWidth(mg.lineWidth);
		linesGa.setForeground(black);
				
		gaService.setSize(ga, width, height);
		
		return ga;
	}
	
	private static GraphicsAlgorithm createGraphicsAlgorithmForFeatureGroupType(final Diagram diagram, final GraphicsAlgorithm containerGa, final FeatureGroupTypeGraphic fgtg, final int width, final int height, boolean fillBackground) {
		final IGaService gaService = Graphiti.getGaService();

		final Color black = gaService.manageColor(diagram, ColorConstant.BLACK);
		final Color white = gaService.manageColor(diagram, ColorConstant.WHITE);
		
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(containerGa);
		final int size = Math.min(width, height);
		final double halfSize = (size)/2.0;
		final int paddingCircleSize = (int)(halfSize + 1 + halfSize *.2);
		final int innerCircleSize = size/2;
		ga.setLineVisible(false);
		ga.setFilled(fillBackground);

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
		
		final org.eclipse.graphiti.mm.algorithms.Polygon halfCircle = gaService.createPlainPolygon(ga, points);
		gaService.setLocationAndSize(halfCircle, 0, 0, size, size);
		halfCircle.setBackground(black);
		halfCircle.setForeground(black);
		
		// White circle for padding
		final GraphicsAlgorithm paddingCircle = gaService.createPlainEllipse(ga);
		gaService.setLocationAndSize(paddingCircle, (int)Math.round(size/2.0 - paddingCircleSize/2.0), (int)Math.round(height/2.0-paddingCircleSize/2.0), paddingCircleSize, paddingCircleSize);
		paddingCircle.setBackground(white);
		paddingCircle.setForeground(white);
		
		// Inner Circle
		final GraphicsAlgorithm innerCircle = gaService.createPlainEllipse(ga);
		gaService.setLocationAndSize(innerCircle, (int)Math.round(innerCircleSize/2), (int)Math.round(height/2.0-innerCircleSize/2.0), innerCircleSize, innerCircleSize);
		innerCircle.setBackground(black);
		innerCircle.setForeground(black);
		
		gaService.setSize(ga, innerCircle.getX() + innerCircle.getWidth(), size);
		return ga;
	}
	
	private static GraphicsAlgorithm createGraphicsAlgorithmForFolder(final Diagram diagram, final GraphicsAlgorithm containerGa, final FolderGraphic folderGraphic, final int width, final int height, boolean fillBackground) {
		final IGaService gaService = Graphiti.getGaService();

		//Width of tab
		int widthOfTab = Math.min(folderMaxTabWidth, (int)(width*folderTopOfTabOffset));
		//The tab start and end slope 
		int tabOffset = (int)(Math.ceil(Math.tan(Math.toRadians(folderTabOffsetAngle))*folderTabHeight));
		final GraphicsAlgorithm ga = gaService.createPlainPolygon(containerGa, 
				new int[] {
				0, height,
				0, folderTabHeight,
				tabOffset, 0,
				widthOfTab, 0,
				widthOfTab+tabOffset, folderTabHeight,
				width, folderTabHeight,
				width, height});
		
		ga.setForeground(gaService.manageColor(diagram, ColorConstant.BLACK));
        ga.setBackground(gaService.manageColor(diagram, ColorConstant.WHITE));
        ga.setLineWidth(folderGraphic.lineWidth);
        ga.setFilled(fillBackground);
        gaService.setSize(ga, width, height);
        
		return ga;
	}
	
	// width and fillBackground are ignored for feature
	private static GraphicsAlgorithm createGraphicsAlgorithmForFeature(final Diagram diagram, final GraphicsAlgorithm containerGa, final FeatureGraphic featureGraphic, final int width, final int height, boolean fillBackground) {
		final IGaService gaService = Graphiti.getGaService();

		switch(featureGraphic.featureType) {
		case ABSTRACT:
			return createAbstractFeatureGraphicsAlgorithm(diagram, containerGa, featureGraphic.direction);

		case BUS_ACCESS:
		case DATA_ACCESS:
			return createDataOrBusAccessGraphicsAlgorithm(diagram, containerGa, featureGraphic.direction);
			
		case DATA_PORT:
			return createPortGraphicsAlgorithm(diagram,  containerGa, true, false, featureGraphic.direction);
			
		case EVENT_DATA_PORT:
			return createPortGraphicsAlgorithm(diagram,  containerGa, true, true, featureGraphic.direction);

		case EVENT_PORT:
			return createPortGraphicsAlgorithm(diagram,  containerGa, false, true, featureGraphic.direction);			

		case SUBPROGRAM_ACCESS:
			return createSubprogramAccessGraphicsAlgorithm(diagram, containerGa, featureGraphic.direction, false);
			
		case SUBPROGRAM_GROUP_ACCESS:
			return createSubprogramAccessGraphicsAlgorithm(diagram, containerGa, featureGraphic.direction, true);
			
		case FEATURE_GROUP:
			return createFeatureGroupGraphicsAlgorithm(diagram, containerGa, featureGraphic.direction, height);
			
		default:
			return gaService.createRectangle(containerGa);		
		}
	}
	
	private static GraphicsAlgorithm createAbstractFeatureGraphicsAlgorithm(final Diagram diagram, final GraphicsAlgorithm containerGa, final Direction direction) {
		final IGaService gaService = Graphiti.getGaService();
		final Color black = gaService.manageColor(diagram, ColorConstant.BLACK);
		
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(containerGa);
		ga.setFilled(false);
		ga.setLineVisible(false);
    	gaService.setSize(ga,  25,  20);
    	
    	final GraphicsAlgorithm circleGa = gaService.createPlainEllipse(ga);
    	circleGa.setBackground(black);
    	circleGa.setForeground(black);
    	circleGa.setLineWidth(featureLineWidth);
    	gaService.setLocation(circleGa, 0, 5);
        gaService.setSize(circleGa, 10, 10);
 			
        // In Abstract Feature
        if(direction == Direction.IN) {
        	final GraphicsAlgorithm directionGa = gaService.createPlainPolyline(ga, new int[] {
        			0, 0, 
        			25, 10,
        			0, 20});
        	directionGa.setBackground(black);
        	directionGa.setForeground(black);
        	directionGa.setLineWidth(featureLineWidth);	
        } else if(direction == Direction.OUT) { // Out Abstract Feature
        	final GraphicsAlgorithm directionGa = gaService.createPlainPolyline(ga, new int[] {
        			25, 0, 
        			0, 10,
        			25, 20});
        	gaService.setLocation(circleGa, ga.getWidth()-circleGa.getWidth(), 5);
        	directionGa.setForeground(black);
        	directionGa.setLineWidth(featureLineWidth);
        }
        
        shrink(ga);
        return ga;
	}
	
	private static GraphicsAlgorithm createPortGraphicsAlgorithm(final Diagram diagram, final GraphicsAlgorithm containerGa, final boolean hasData, final boolean hasEvent, final Direction direction) {
		final IGaService gaService = Graphiti.getGaService();
		final Color black = gaService.manageColor(diagram, ColorConstant.BLACK);
		
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(containerGa);
		ga.setFilled(false);
		ga.setLineVisible(false);
		
    	int width = 25;
    	final int height = 20;
    	final int dataSymbolXPadding = 10;
    	final int dataSymbolYPadding = 5;

    	GraphicsAlgorithm dataGa = null;
    	GraphicsAlgorithm eventGa = null;        	
    	
    	switch(direction) {
    	// In Port
    	case IN:
    		if(hasEvent) {
        		eventGa = gaService.createPlainPolyline(ga, new int[] {
            			0, 0, 
            			width, height/2,
            			0, height});
    		}
    		
    		if(hasData) {
        		dataGa = gaService.createPlainPolygon(ga, new int[] {
            			0, dataSymbolYPadding, 
            			width-dataSymbolXPadding, height/2,
            			0, height-dataSymbolYPadding});
    		}
    		
    		break;
    		
   		// Out Port
    	case OUT:
    		if(hasEvent) {
				eventGa = gaService.createPlainPolyline(ga, new int[] {
        			width, 0, 
        			0, height/2,
        			width, height});
    		}
    		
    		if(hasData) {
    			dataGa = gaService.createPlainPolygon(ga, new int[] {
            			width, dataSymbolYPadding, 
            			dataSymbolXPadding, height/2,
            			width, height-dataSymbolYPadding});
    		}
    		
    		break;
    		
    	// In Out Port
    	case IN_OUT:
    		width *= 2;
    		if(hasEvent) {
        		eventGa = gaService.createPlainPolyline(ga, new int[] {
            			width/2, 0, 
            			width, height/2,
            			width/2, height,
            			0, height/2,
            			width/2, 0});
    		}
    		
    		if(hasData) {
        		dataGa = gaService.createPlainPolygon(ga, new int[] {
            			width/2, dataSymbolYPadding, 
            			width-dataSymbolXPadding, height/2,
            			width/2, height-dataSymbolYPadding,
            			dataSymbolXPadding, height/2});
    		}
    		
    		break;
    	}
    	
    	if(dataGa != null) {
    		dataGa.setBackground(black);
        	dataGa.setForeground(black);
        	dataGa.setLineWidth(featureLineWidth);
    	}
    	
    	if(eventGa != null) {
    		eventGa.setBackground(black);
        	eventGa.setForeground(black);
        	eventGa.setLineWidth(featureLineWidth);
    	}

        gaService.setSize(ga,  width, height);
        shrink(ga);

        return ga;
	}
		
	private static GraphicsAlgorithm createDataOrBusAccessGraphicsAlgorithm(final Diagram diagram, final GraphicsAlgorithm containerGa, final Direction direction) {
		final IGaService gaService = Graphiti.getGaService();
		final Color black = gaService.manageColor(diagram, ColorConstant.BLACK);
		final Color white = gaService.manageColor(diagram, ColorConstant.WHITE);
		
    	final int width = 20;
		final int height = 20;        		
		final int slopeWidth = 5;

		final GraphicsAlgorithm ga;
		if(direction == Direction.OUT) {
			ga = gaService.createPlainPolyline(containerGa, new int[] {
        			width, 0, 
        			slopeWidth, 0,
        			0, height/2,
        			slopeWidth, height,
        			width, height,
        			width, 0});
		} else if(direction == Direction.IN) {
			ga = gaService.createPlainPolyline(containerGa, new int[] {
        			0, 0, 
        			width-slopeWidth, 0,
        			width, height/2,
        			width-slopeWidth, height,
        			0, height,
        			0, 0});
		} else {
			throw new RuntimeException("Access graphic is not an input or an output.");
		}
		
		ga.setBackground(white);
		ga.setForeground(black);
		ga.setLineWidth(featureLineWidth);
		
    	gaService.setSize(ga, width, height);
		return ga;
	}
	
	private static GraphicsAlgorithm createSubprogramAccessGraphicsAlgorithm(final Diagram diagram, final GraphicsAlgorithm containerGa, final Direction direction, final boolean blackBackground) {
		final IGaService gaService = Graphiti.getGaService();
		final Color black = gaService.manageColor(diagram, ColorConstant.BLACK);
		final Color white = gaService.manageColor(diagram, ColorConstant.WHITE);
		final Color background = blackBackground ? black : white;
		final Color foreground = blackBackground ? white : black;
		    	 
		final int width = 35;
		final int height = 20;
		final int vPadding = 5;
		
		final GraphicsAlgorithm ga = gaService.createPlainEllipse(containerGa);
		gaService.setSize(ga, width, height);
		ga.setBackground(background);
		ga.setForeground(foreground);
		ga.setLineWidth(featureLineWidth);
		
		final int arrowWidth = 10;
		final int arrowHeight = height - 2*vPadding;
		final int left = width/2 - arrowWidth/2;
		if(direction == Direction.OUT) {
			final GraphicsAlgorithm arrowGa = gaService.createPlainPolyline(ga, new int[] {
        			0, 0, 
        			arrowWidth, arrowHeight/2,
        			0, arrowHeight});
			arrowGa.setBackground(background);
			arrowGa.setForeground(foreground);
			arrowGa.setLineWidth(featureLineWidth);
			arrowGa.setX(left);
			arrowGa.setY(vPadding);
			arrowGa.setWidth(arrowWidth);
			arrowGa.setHeight(arrowHeight);
		} else if(direction == Direction.IN) {
			final GraphicsAlgorithm arrowGa = gaService.createPlainPolyline(ga, new int[] {
					arrowWidth, 0, 
					0, arrowHeight/2,
					arrowWidth, arrowHeight});
			arrowGa.setBackground(background);
			arrowGa.setForeground(foreground);
			arrowGa.setLineWidth(featureLineWidth);
			arrowGa.setX(left);
			arrowGa.setY(vPadding);
			arrowGa.setWidth(arrowWidth);
			arrowGa.setHeight(arrowHeight);
		} else {
			throw new RuntimeException("Access graphic is not an input or an output.");
		}

		return ga;
	}
	
	private static GraphicsAlgorithm createFeatureGroupGraphicsAlgorithm(final Diagram diagram, final GraphicsAlgorithm containerGa, final Direction direction, int height) {
		final IGaService gaService = Graphiti.getGaService();
		final Color black = gaService.manageColor(diagram, ColorConstant.BLACK);
		
		final GraphicsAlgorithm ga = gaService.createRectangle(containerGa);
		final int width = featureGroupDefaultSymbolWidth;
		final int circleSize = width*2/3;
		final int barWidth = width - circleSize;
		height = Math.max(height, circleSize);
		gaService.setSize(ga, width, height);
		ga.setLineVisible(false);
		ga.setFilled(false);		
		
		// Circle
		final GraphicsAlgorithm circle = gaService.createPlainEllipse(ga);
		gaService.setLocationAndSize(circle, 0, height/2-circleSize/2, circleSize, circleSize);
		circle.setBackground(black);
		circle.setForeground(black);
		
		// Bar
		final GraphicsAlgorithm bar = gaService.createPlainRectangle(ga);
		gaService.setLocationAndSize(bar, circleSize, 0, barWidth, height);
		bar.setBackground(black);
		bar.setForeground(black);

		return ga;
	}
		
	public static void rotate(final GraphicsAlgorithm ga, final DockArea dockArea) {
		switch(dockArea) {	
		case GROUP:
			throw new RuntimeException("Unsupported dock area: " + dockArea);
		case LEFT:
			break;
		case RIGHT:
			mirrorX(ga, ga);
			break;
		case TOP:
			rotate90(ga, ga);
			break;
		case BOTTOM:
			rotate270(ga, ga);			
			break;
		default:
			break;	
		}
	}

	// Clockwise 90
	private static void rotate90(final GraphicsAlgorithm rootGa, final GraphicsAlgorithm ga) {
		if(rootGa != ga) {
			final int newY = ga.getX();
			ga.setX(ga.getParentGraphicsAlgorithm().getHeight() - (ga.getY() + ga.getHeight()));
			ga.setY(newY);
		}
		
		if(ga instanceof Polyline) {
			// Rotate every point in the polyline
			final Polyline polyline = (Polyline)ga;
			for(final Point p : polyline.getPoints()) {
				final int newX = p.getY();
				final int newY = p.getX();
				p.setX(newX);
				p.setY(newY);
			}
		}
		
		for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
			rotate90(rootGa, childGa);
		}
		
		// Adjust size
		final int newWidth = ga.getHeight();
		final int newHeight = ga.getWidth();
		ga.setWidth(newWidth);
		ga.setHeight(newHeight);
	}
	
	// Clockwise 270
	private static void rotate270(final GraphicsAlgorithm rootGa, final GraphicsAlgorithm ga) {
		if(rootGa != ga) {
			final int newY = ga.getParentGraphicsAlgorithm().getWidth() - (ga.getX() + ga.getWidth());
			ga.setX(ga.getParentGraphicsAlgorithm().getHeight() - (ga.getY() + ga.getHeight()));
			ga.setY(newY);
		}
		
		if(ga instanceof Polyline) {
			// Mirror every point in the polyline
			final Polyline polyline = (Polyline)ga;
			for(final Point p : polyline.getPoints()) {
				final int newX = p.getY();
				final int newY = -p.getX() + ga.getWidth();

				p.setX(newX);
				p.setY(newY);
			}
		}
		
		for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
			rotate270(rootGa, childGa);
		}
		
		// Adjust size
		final int newWidth = ga.getHeight();
		final int newHeight = ga.getWidth();
		ga.setWidth(newWidth);
		ga.setHeight(newHeight);
	}
		
	/**
	 * Mirrors graphics algorithm in the x axis
	 * @param rootGa the graphics algorithm that will be treated at the top level graphics algorithm. The top level graphics algorithm will not be moved.
	 * @param ga the graphics algorithm to mirror
	 */
	private static void mirrorX(final GraphicsAlgorithm rootGa, final GraphicsAlgorithm ga) {
		if(rootGa != ga) {
			ga.setX(ga.getParentGraphicsAlgorithm().getWidth() - ga.getX() - ga.getWidth());
		}
		
		if(ga instanceof Polyline) {
			// Mirror every point in the polyline
			final Polyline polyline = (Polyline)ga;
			for(final Point p : polyline.getPoints()) {
				p.setX(ga.getWidth()-p.getX());
			}
		}
		
		for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
			mirrorX(rootGa, childGa);
		}
	}
	
	public static void mirror(final GraphicsAlgorithm ga) {
		mirrorX(ga, ga);
	}
	
	public static void shrink(final GraphicsAlgorithm ga) {
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
	
		// Determine the min/max x/y of all children.
		for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
			if(childGa instanceof Polyline) {
				shrinkPolyline((Polyline)childGa);
			}
			
			minX = Math.min(minX, childGa.getX());
			maxX = Math.max(maxX, childGa.getX()+childGa.getWidth());
			minY = Math.min(minY, childGa.getY());
			maxY = Math.max(maxY, childGa.getY()+childGa.getHeight());
		}
		
		for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
			childGa.setX(childGa.getX() - minX);
			childGa.setY(childGa.getY() - minY);
		}
		
		ga.setX(ga.getX() + minX);
		ga.setY(ga.getY() + minY);
		ga.setWidth(maxX - minX);
		ga.setHeight(maxY - minY);
	}

	private static void shrinkPolyline(final Polyline polyline) {
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		for(final Point p : polyline.getPoints()) {
			minX = Math.min(minX, p.getX());
			maxX = Math.max(maxX, p.getX());
			minY = Math.min(minY, p.getY());
			maxY = Math.max(maxY, p.getY());
		}
		
		for(final Point p : polyline.getPoints()) {
			p.setX(p.getX()-minX);
			p.setY(p.getY()-minY);
		}
		
		polyline.setX(polyline.getX() + minX);
		polyline.setY(polyline.getY() + minY);
		polyline.setWidth(maxX-minX);
		polyline.setHeight(maxY-minY);
	}
}

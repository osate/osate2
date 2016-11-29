package org.osate.ge.internal.graphiti.graphics;

import java.awt.geom.Point2D;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;
import org.osate.ge.internal.graphics.BusGraphic;
import org.osate.ge.internal.graphics.DeviceGraphic;
import org.osate.ge.internal.graphics.Ellipse;
import org.osate.ge.internal.graphics.FeatureGroupTypeGraphic;
import org.osate.ge.internal.graphics.LineStyle;
import org.osate.ge.internal.graphics.MemoryGraphic;
import org.osate.ge.internal.graphics.Parallelogram;
import org.osate.ge.internal.graphics.Polygon;
import org.osate.ge.internal.graphics.ProcessorGraphic;
import org.osate.ge.internal.graphics.Rectangle;

public class AgeGraphitiGraphicsUtil {
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
	
	public static GraphicsAlgorithm createGraphicsAlgorithm(final Diagram diagram, final Shape shape, final Object graphic, final int width, final int height) {
		final IGaService gaService = Graphiti.getGaService();

		if(graphic == null) {
			return null;
		}
		
		final GraphicsAlgorithm shapeGa = gaService.createInvisibleRectangle(shape);	
		
		final GraphicsAlgorithm innerGa;		
		final Class<?> graphicClass = graphic.getClass();
		if(graphicClass == Rectangle.class) {
			final Rectangle r = (Rectangle)graphic;
			if(r.rounded) {
				innerGa = gaService.createPlainRoundedRectangle(shapeGa, 25, 25);
			} else {
				innerGa = gaService.createPlainRectangle(shapeGa);
			}
			innerGa.setLineWidth(((Rectangle)graphic).lineWidth);
			innerGa.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(((Rectangle)graphic).lineStyle));
			innerGa.setForeground(gaService.manageColor(diagram, ColorConstant.BLACK));
	        innerGa.setBackground(gaService.manageColor(diagram, ColorConstant.WHITE));
	        gaService.setSize(innerGa, width, height);
		} else if(graphicClass == Ellipse.class) {
	        innerGa = gaService.createPlainEllipse(shapeGa);
	        innerGa.setLineWidth(((Ellipse)graphic).lineWidth);
	        innerGa.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(((Ellipse)graphic).lineStyle));
			innerGa.setForeground(gaService.manageColor(diagram, ColorConstant.BLACK));
	        innerGa.setBackground(gaService.manageColor(diagram, ColorConstant.WHITE));
	        gaService.setSize(innerGa, width, height);
		} else if(graphicClass == Polygon.class) {
			innerGa = createGraphicsAlgorithm(diagram, shapeGa, (Polygon)graphic, width, height);
		} else if(graphicClass == Parallelogram.class) {
			innerGa = createGraphicsAlgorithm(diagram, shapeGa, (Parallelogram)graphic, width, height);
		} else if(graphicClass == DeviceGraphic.class) {
			innerGa = createGraphicsAlgorithm(diagram, shapeGa, (DeviceGraphic)graphic, width, height);
		} else if(graphicClass == BusGraphic.class) {
			innerGa = createGraphicsAlgorithm(diagram, shapeGa, (BusGraphic)graphic, width, height);
		} else if(graphicClass == ProcessorGraphic.class) {
			innerGa = createGraphicsAlgorithm(diagram, shapeGa, (ProcessorGraphic)graphic, width, height);
		} else if(graphicClass == MemoryGraphic.class) {
			innerGa = createGraphicsAlgorithm(diagram, shapeGa, (MemoryGraphic)graphic, width, height);
		} else if(graphicClass == FeatureGroupTypeGraphic.class) {
			innerGa = createGraphicsAlgorithm(diagram, shapeGa, (FeatureGroupTypeGraphic)graphic, width, height);
		} else {
			throw new RuntimeException("Unsupported object: " + graphic);
		}
		
		// TODO: Sort out what the size should be...
		shapeGa.setWidth(innerGa.getWidth());
		shapeGa.setHeight(innerGa.getHeight());
		//shapeGa.setWidth(width);
		//shapeGa.setHeight(height);
        
		return shapeGa;
	}
	
	public static void resizeGraphicsAlgorithm(final Diagram diagram, final Shape shape, final Object graphic, final int width, final int height) {
		// TODO: Problem 
		if(shape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().size() == 0) {
			return;
		}
		
		final GraphicsAlgorithm topGraphicsAlgorithm = shape.getGraphicsAlgorithm();
		final GraphicsAlgorithm wrapperGraphicsAlgorithm = topGraphicsAlgorithm;//topGraphicsAlgorithm.getGraphicsAlgorithmChildren().get(0);

		// TODO: Problem 
		// TODO: Remove if top = wrapper
		if(wrapperGraphicsAlgorithm.getGraphicsAlgorithmChildren().size() == 0) {
			return;
		}
		
		// Remove child graphics algorithms 
		if(graphic != null) {
			final Class<?> graphicClass = graphic.getClass();
			boolean createdNewGraphicsAlgorithm = true;
			// TODO: Cleanup
			if(graphicClass == org.osate.ge.internal.graphics.Polygon.class) {
				wrapperGraphicsAlgorithm.getGraphicsAlgorithmChildren().remove(0);
				createGraphicsAlgorithm(diagram, wrapperGraphicsAlgorithm, (org.osate.ge.internal.graphics.Polygon)graphic, width, height);
			} else if(graphicClass == Parallelogram.class) {
				wrapperGraphicsAlgorithm.getGraphicsAlgorithmChildren().remove(0);
				createGraphicsAlgorithm(diagram, wrapperGraphicsAlgorithm, (Parallelogram)graphic, width, height);
			} else if(graphicClass == BusGraphic.class) {
				wrapperGraphicsAlgorithm.getGraphicsAlgorithmChildren().remove(0);
				createGraphicsAlgorithm(diagram, wrapperGraphicsAlgorithm, (BusGraphic)graphic, width, height);
			} else if(graphicClass == DeviceGraphic.class) {
				wrapperGraphicsAlgorithm.getGraphicsAlgorithmChildren().remove(0);
				createGraphicsAlgorithm(diagram, wrapperGraphicsAlgorithm, (DeviceGraphic)graphic, width, height);
			} else if(graphicClass == ProcessorGraphic.class) {
				wrapperGraphicsAlgorithm.getGraphicsAlgorithmChildren().remove(0);
				createGraphicsAlgorithm(diagram, wrapperGraphicsAlgorithm, (ProcessorGraphic)graphic, width, height);
			} else if(graphicClass == MemoryGraphic.class) {
				wrapperGraphicsAlgorithm.getGraphicsAlgorithmChildren().remove(0);
				createGraphicsAlgorithm(diagram, wrapperGraphicsAlgorithm, (MemoryGraphic)graphic, width, height);
			} else if(graphicClass == FeatureGroupTypeGraphic.class) {
				wrapperGraphicsAlgorithm.getGraphicsAlgorithmChildren().remove(0);
				createGraphicsAlgorithm(diagram, wrapperGraphicsAlgorithm, (FeatureGroupTypeGraphic)graphic, width, height);
			} else {
				Graphiti.getGaService().setSize(wrapperGraphicsAlgorithm.getGraphicsAlgorithmChildren().get(0), width, height);
				createdNewGraphicsAlgorithm = false;
			}
			
			if(createdNewGraphicsAlgorithm) {
				wrapperGraphicsAlgorithm.getGraphicsAlgorithmChildren().move(wrapperGraphicsAlgorithm.getGraphicsAlgorithmChildren().size()-1, 0);
			}
			
			final GraphicsAlgorithm innerGa = wrapperGraphicsAlgorithm.getGraphicsAlgorithmChildren().get(0);
			Graphiti.getGaService().setSize(wrapperGraphicsAlgorithm, innerGa.getWidth(), innerGa.getHeight());
		}
		
		Graphiti.getGaService().setSize(wrapperGraphicsAlgorithm, wrapperGraphicsAlgorithm.getWidth(), wrapperGraphicsAlgorithm.getHeight());
	}
	
	private static GraphicsAlgorithm createGraphicsAlgorithm(final Diagram diagram, final GraphicsAlgorithm containerGa, final Polygon poly, final int width, final int height) {
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
        gaService.setSize(ga, width, height);
		return ga;
	}
	
	private static GraphicsAlgorithm createGraphicsAlgorithm(final Diagram diagram, final GraphicsAlgorithm containerGa, final Parallelogram parallelogram, final int width, final int height) {
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
        gaService.setSize(ga, width, height);
        
		return ga;
	}
	
	private static GraphicsAlgorithm createGraphicsAlgorithm(final Diagram diagram, final GraphicsAlgorithm containerGa, final DeviceGraphic dg, final int width, final int height) {
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
	
	private static GraphicsAlgorithm createGraphicsAlgorithm(final Diagram diagram, final GraphicsAlgorithm containerGa, final BusGraphic bg, final int width, final int height) {		
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
        gaService.setSize(ga, width, height);
		return ga;
	}
	
	private static GraphicsAlgorithm createGraphicsAlgorithm(final Diagram diagram, final GraphicsAlgorithm containerGa, final ProcessorGraphic pg, final int width, final int height) {
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
	
	private static GraphicsAlgorithm createGraphicsAlgorithm(final Diagram diagram, final GraphicsAlgorithm containerGa, final MemoryGraphic mg, final int width, final int height) {
		final IGaService gaService = Graphiti.getGaService();
		
		final Color black = gaService.manageColor(diagram, ColorConstant.BLACK);
		final Color white = gaService.manageColor(diagram, ColorConstant.WHITE);
		
		final int ellipseHeight = 20;
		final double halfEllipseHeight = ellipseHeight / 2.0;
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(containerGa);
		ga.setLineVisible(false);
		ga.setBackground(white);
		
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
	
	private static GraphicsAlgorithm createGraphicsAlgorithm(final Diagram diagram, final GraphicsAlgorithm containerGa, final FeatureGroupTypeGraphic fgtg, final int width, final int height) {
		final IGaService gaService = Graphiti.getGaService();

		final Color black = gaService.manageColor(diagram, ColorConstant.BLACK);
		final Color white = gaService.manageColor(diagram, ColorConstant.WHITE);
		
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(containerGa);
		final int size = Math.min(width, height);
		final double halfSize = (size)/2.0;
		final int paddingCircleSize = (int)(halfSize + 1 + halfSize *.2);
		final int innerCircleSize = size/2;
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
	
	public static GraphicsAlgorithm getInnerGraphicsAlgorithm(final Shape shape) {
		GraphicsAlgorithm innerGa = shape.getGraphicsAlgorithm();
		// TODO: Check that it is invisible, etc..
		if(innerGa != null && innerGa.getGraphicsAlgorithmChildren().size() == 1) {
			innerGa = innerGa.getGraphicsAlgorithmChildren().get(0);
		}
		
		return innerGa;
	}
}

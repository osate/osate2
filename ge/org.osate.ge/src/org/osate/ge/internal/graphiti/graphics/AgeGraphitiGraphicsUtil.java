package org.osate.ge.internal.graphiti.graphics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.IColorConstant;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.internal.BusGraphic;
import org.osate.ge.graphics.internal.DeviceGraphic;
import org.osate.ge.graphics.internal.Direction;
import org.osate.ge.graphics.internal.Ellipse;
import org.osate.ge.graphics.internal.FeatureGraphic;
import org.osate.ge.graphics.internal.FeatureGroupTypeGraphic;
import org.osate.ge.graphics.internal.FolderGraphic;
import org.osate.ge.graphics.internal.Label;
import org.osate.ge.graphics.internal.LineStyle;
import org.osate.ge.graphics.internal.MemoryGraphic;
import org.osate.ge.graphics.internal.ModeGraphic;
import org.osate.ge.graphics.internal.NoteGraphic;
import org.osate.ge.graphics.internal.Parallelogram;
import org.osate.ge.graphics.internal.Poly;
import org.osate.ge.graphics.internal.ProcessorGraphic;
import org.osate.ge.graphics.internal.Rectangle;
import org.osate.ge.internal.diagram.runtime.DockArea;
import org.osate.ge.internal.graphiti.diagram.PropertyUtil;

// This class does not fully support the passed in styles. The class was transitioned to use the Style class to ease the transition to GEF.
public class AgeGraphitiGraphicsUtil {
	private final static int folderTabHeight = 9;
	private final static int folderMaxTabWidth = 100;
	private final static int noteOffset = 20;
	private final static double folderTabOffsetAngle = 30.0;
	private final static double folderTopOfTabOffset = 0.3;
	private final static int featureLineWidth = 2;
	public static final int featureGroupDefaultSymbolWidth = 30;
	private static final Map<Class<? extends Graphic>, GraphicsAlgorithmCreator<?>> graphicToCreatorMap;

	// Standard size of features other than feature groups
	public static final Dimension defaultFeatureSize = new Dimension(20, 16);
	private static final int featureGroupCircleWidth = featureGroupDefaultSymbolWidth * 2 / 3;
	public static final Dimension featureGroupCircleSize = new Dimension(featureGroupCircleWidth,
			featureGroupCircleWidth);

	private static final double featureBgTransparency = 0.0; // Transparency for features which have a background. Directional features and event ports.

	@FunctionalInterface
	static interface GraphicsAlgorithmCreator<G> {
		GraphicsAlgorithm createGraphicsAlgorithm(Diagram diagram, GraphicsAlgorithmContainer containerGa, G graphic,
				int width, int height, boolean fillBackground, int lineWidth, LineStyle lineStyle);
	}

	static <G extends Graphic> void addGraphicsAlgorithmCreator(
			final Map<Class<? extends Graphic>, GraphicsAlgorithmCreator<?>> map, Class<G> graphicClass,
			final GraphicsAlgorithmCreator<G> creator) {
		map.put(graphicClass, creator);
	}

	static {
		final Map<Class<? extends Graphic>, GraphicsAlgorithmCreator<?>> map = new HashMap<>();
		addGraphicsAlgorithmCreator(map, Rectangle.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForRectangle);
		addGraphicsAlgorithmCreator(map, Ellipse.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForEllipse);
		addGraphicsAlgorithmCreator(map, Poly.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForPolygon);
		addGraphicsAlgorithmCreator(map, Parallelogram.class,
				AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForParallelogram);
		addGraphicsAlgorithmCreator(map, Label.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForLabel);
		addGraphicsAlgorithmCreator(map, DeviceGraphic.class,
				AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForDevice);
		addGraphicsAlgorithmCreator(map, BusGraphic.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForBus);
		addGraphicsAlgorithmCreator(map, ProcessorGraphic.class,
				AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForProcessor);
		addGraphicsAlgorithmCreator(map, MemoryGraphic.class,
				AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForMemory);
		addGraphicsAlgorithmCreator(map, FeatureGroupTypeGraphic.class,
				AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForFeatureGroupType);
		addGraphicsAlgorithmCreator(map, FolderGraphic.class,
				AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForFolder);
		addGraphicsAlgorithmCreator(map, ModeGraphic.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForMode);
		addGraphicsAlgorithmCreator(map, FeatureGraphic.class,
				AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForFeature);
		addGraphicsAlgorithmCreator(map, NoteGraphic.class, AgeGraphitiGraphicsUtil::createGraphicsAlgorithmForNote);
		graphicToCreatorMap = Collections.unmodifiableMap(map);
	}

	public static org.eclipse.graphiti.mm.algorithms.styles.LineStyle toGraphitiLineStyle(final LineStyle lineStyle) {
		if (lineStyle == null) {
			return org.eclipse.graphiti.mm.algorithms.styles.LineStyle.SOLID;
		}

		switch (lineStyle) {
		case DASHED:
			return org.eclipse.graphiti.mm.algorithms.styles.LineStyle.DASH;

		case SOLID:
			return org.eclipse.graphiti.mm.algorithms.styles.LineStyle.SOLID;

		case DOTTED:
			return org.eclipse.graphiti.mm.algorithms.styles.LineStyle.DOT;

		default:
			return org.eclipse.graphiti.mm.algorithms.styles.LineStyle.SOLID;
		}
	}

// Returns the new graphics algorithm
	public static GraphicsAlgorithm createGraphicsAlgorithm(final Diagram diagram,
			final GraphicsAlgorithmContainer gaContainer, final Object graphic, final int width, final int height,
			boolean fillBackground, final Style style) {
		@SuppressWarnings("unchecked")
		final GraphicsAlgorithmCreator<Object> c = (GraphicsAlgorithmCreator<Object>) graphicToCreatorMap
		.get(graphic.getClass());
		if (c == null) {
			throw new RuntimeException("Unsupported object: " + graphic);
		}

		final int lineWidth = (int) Math
				.round(style.getLineWidth() == null ? Style.DEFAULT.getLineWidth() : style.getLineWidth());
		final LineStyle lineStyle = style.getLineStyle() == null ? Style.DEFAULT.getLineStyle() : style.getLineStyle();
		return c.createGraphicsAlgorithm(diagram, gaContainer, graphic, width, height, fillBackground, lineWidth,
				lineStyle);
	}

	/**
	 * Helper method for returning the inner graphics algorithm for a top level graphics algorithm. The inner graphics algorithm contains the actual
	 * symbol for the shape.
	 */
	public static GraphicsAlgorithm getInnerGraphicsAlgorithm(final GraphicsAlgorithm ga) {
		return ga.getGraphicsAlgorithmChildren().get(0);
	}

	private static GraphicsAlgorithm createGraphicsAlgorithmForRectangle(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final Rectangle r, final int width, final int height,
			boolean fillBackground, final int lineWidth, final LineStyle lineStyle) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga;
		if (r.rounded) {
			ga = gaService.createPlainRoundedRectangle(containerGa, 25, 25);
		} else {
			ga = gaService.createPlainRectangle(containerGa);
		}

		PropertyUtil.setIsStylingChild(ga, true);
		ga.setLineWidth(lineWidth);
		ga.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(lineStyle));
		ga.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
		ga.setBackground(gaService.manageColor(diagram, IColorConstant.WHITE));
		ga.setFilled(fillBackground);
		gaService.setSize(ga, width, height);

		return ga;
	}

	private static GraphicsAlgorithm createGraphicsAlgorithmForEllipse(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final Ellipse ellipse, final int width, final int height,
			boolean fillBackground, final int lineWidth, final LineStyle lineStyle) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainEllipse(containerGa);

		PropertyUtil.setIsStylingChild(ga, true);
		ga.setLineWidth(lineWidth);
		ga.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(lineStyle));
		ga.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
		ga.setBackground(gaService.manageColor(diagram, IColorConstant.WHITE));
		ga.setFilled(fillBackground);
		final Optional<Dimension> fixedSize = ellipse.getFixedSize();
		gaService.setSize(ga, fixedSize.map(d -> (int) d.width).orElse(width),
				fixedSize.map(d -> (int) d.height).orElse(height));

		return ga;
	}

	private static GraphicsAlgorithm createGraphicsAlgorithmForPolygon(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final Poly poly, final int width, final int height,
			boolean fillBackground, final int lineWidth, final LineStyle lineStyle) {
		final int[] coords = new int[poly.getPoints().length * 2];
		int i = 0;

		// Build points based on the specified size
		for (final org.osate.ge.graphics.Point p : poly.getPoints()) {
			coords[i++] = (int) (p.x * width);
			coords[i++] = (int) (p.y * height);
		}

		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga;
		switch (poly.type) {
		case POLYGON:
			ga = gaService.createPlainPolygon(containerGa, coords);
			break;

		case POLYLINE:
			ga = gaService.createPlainPolyline(containerGa, coords);
			break;

		default:
			throw new RuntimeException("Unexpected type: " + poly.type);
		}

		PropertyUtil.setIsStylingChild(ga, true);
		ga.setLineWidth(lineWidth);
		ga.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(lineStyle));
		ga.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
		ga.setBackground(gaService.manageColor(diagram, IColorConstant.WHITE));
		ga.setFilled(fillBackground);
		gaService.setSize(ga, width, height);
		return ga;
	}

	private static GraphicsAlgorithm createGraphicsAlgorithmForParallelogram(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final Parallelogram parallelogram, final int width,
			final int height, boolean fillBackground, final int lineWidth, final LineStyle lineStyle) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createPlainPolygon(containerGa,
				new int[] { parallelogram.horizontalOffset, 0, width, 0, width - parallelogram.horizontalOffset, height,
						0, height });

		PropertyUtil.setIsStylingChild(ga, true);
		ga.setLineWidth(lineWidth);
		ga.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(lineStyle));
		ga.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
		ga.setBackground(gaService.manageColor(diagram, IColorConstant.WHITE));
		ga.setFilled(fillBackground);
		gaService.setSize(ga, width, height);

		return ga;
	}

	private static GraphicsAlgorithm createGraphicsAlgorithmForLabel(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final Label label, final int width, final int height,
			boolean fillBackground, final int lineWidth, final LineStyle lineStyle) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga = gaService.createRectangle(containerGa);
		gaService.setSize(ga, width, height);
		ga.setLineVisible(false);
		ga.setFilled(false);
		PropertyUtil.setIsStylingContainer(ga, true);

		return ga;
	}

	private static GraphicsAlgorithm createGraphicsAlgorithmForDevice(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final DeviceGraphic dg, final int width, final int height,
			boolean fillBackground, final int lineWidth, final LineStyle lineStyle) {
		final IGaService gaService = Graphiti.getGaService();

		final int padding = 4;

		final Color black = gaService.manageColor(diagram, IColorConstant.BLACK);
		final Color white = gaService.manageColor(diagram, IColorConstant.WHITE);
		final Color gray = gaService.manageColor(diagram, IColorConstant.LIGHT_GRAY);

		// Create outer outline
		final GraphicsAlgorithm outline = gaService.createPlainRectangle(containerGa);
		PropertyUtil.setIsStylingContainer(outline, true);
		PropertyUtil.setIsStylingChild(outline, true);
		outline.setLineWidth(lineWidth);
		outline.setBackground(white);
		outline.setForeground(black);
		outline.setFilled(fillBackground);

		// Create shading
		GraphicsAlgorithm ga;
		ga = gaService.createPlainPolygon(outline,
				new int[] { width, 0, width, height, width - padding, height - padding, width - padding, padding });
		ga.setBackground(gray);
		ga.setTransparency(0.5);
		ga.setLineVisible(false);

		ga = gaService.createPlainPolygon(outline,
				new int[] { width, height, 0, height, padding, height - padding, width - padding, height - padding });
		ga.setBackground(gray);
		ga.setTransparency(0.5);
		ga.setLineVisible(false);

		// Create inner rectangle
		final GraphicsAlgorithm inner = gaService.createPlainRectangle(outline);
		gaService.setLocation(inner, padding, padding);
		gaService.setSize(inner, width - padding * 2, height - padding * 2);
		inner.setLineWidth(lineWidth);
		inner.setForeground(black);
		inner.setFilled(false);
		PropertyUtil.setIsStylingChild(inner, true);

		// Create additional line segments
		ga = gaService.createPlainPolyline(outline, new int[] { 0, 0, padding + 1, padding + 1 });
		ga.setLineWidth(lineWidth);
		ga.setForeground(black);
		PropertyUtil.setIsStylingChild(ga, true);

		ga = gaService.createPlainPolyline(outline, new int[] { width, 0, width - padding - 1, padding + 1 });
		ga.setLineWidth(lineWidth);
		ga.setForeground(black);
		PropertyUtil.setIsStylingChild(ga, true);

		ga = gaService.createPlainPolyline(outline,
				new int[] { width - padding - 1, height - padding - 1, width, height });
		ga.setLineWidth(lineWidth);
		ga.setForeground(black);
		PropertyUtil.setIsStylingChild(ga, true);

		ga = gaService.createPlainPolyline(outline, new int[] { 0, height, padding + 1, height - padding - 1 });
		ga.setLineWidth(lineWidth);
		ga.setForeground(black);
		PropertyUtil.setIsStylingChild(ga, true);

		gaService.setSize(outline, width, height);
		return outline;
	}

	private static GraphicsAlgorithm createGraphicsAlgorithmForBus(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final BusGraphic bg, final int width, final int height,
			boolean fillBackground, final int lineWidth, final LineStyle lineStyle) {
		final IGaService gaService = Graphiti.getGaService();

		final int arrowHeadWidth = Math.max(Math.min(width, height) / 4, 20);
		final int arrowHeadVerticalExtensionSize = height / 4;
		final GraphicsAlgorithm ga = gaService.createPlainPolygon(containerGa,
				new int[] { 0, height / 2, arrowHeadWidth, 0, arrowHeadWidth, arrowHeadVerticalExtensionSize,
						width - arrowHeadWidth, arrowHeadVerticalExtensionSize, width - arrowHeadWidth, 0, width,
						height / 2, width - arrowHeadWidth, height, width - arrowHeadWidth,
						height - arrowHeadVerticalExtensionSize, arrowHeadWidth,
						height - arrowHeadVerticalExtensionSize, arrowHeadWidth, height });

		PropertyUtil.setIsStylingChild(ga, true);
		ga.setLineWidth(lineWidth);
		ga.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(lineStyle));
		ga.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
		ga.setBackground(gaService.manageColor(diagram, IColorConstant.WHITE));
		ga.setFilled(fillBackground);
		gaService.setSize(ga, width, height);
		return ga;
	}

	private static GraphicsAlgorithm createGraphicsAlgorithmForProcessor(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final ProcessorGraphic pg, final int width, final int height,
			boolean fillBackground, final int lineWidth, final LineStyle ls) {
		final IGaService gaService = Graphiti.getGaService();

		final Color black = gaService.manageColor(diagram, IColorConstant.BLACK);
		final Color white = gaService.manageColor(diagram, IColorConstant.WHITE);
		final org.eclipse.graphiti.mm.algorithms.styles.LineStyle lineStyle = toGraphitiLineStyle(ls);

		final int horizontalOffset = 10;
		final int depth = 12;

		// Create polygon for outline
		final org.eclipse.graphiti.mm.algorithms.Polygon outlinePolygon = gaService.createPlainPolygon(containerGa,
				new int[] { 0, height, 0, depth, horizontalOffset, 0, width, 0, width, height - depth,
						width - horizontalOffset, height });
		PropertyUtil.setIsStylingContainer(outlinePolygon, true);
		PropertyUtil.setIsStylingChild(outlinePolygon, true);
		outlinePolygon.setLineWidth(lineWidth);
		outlinePolygon.setLineStyle(lineStyle);
		outlinePolygon.setBackground(white);
		outlinePolygon.setForeground(black);
		outlinePolygon.setFilled(fillBackground);

		// Create child shapes for extra lines and shading
		GraphicsAlgorithm ga;
		ga = gaService.createPlainPolyline(outlinePolygon,
				new int[] { 0, depth, width - horizontalOffset, depth, width, 0 });
		PropertyUtil.setIsStylingChild(ga, true);
		ga.setLineWidth(lineWidth);
		ga.setLineStyle(lineStyle);
		ga.setForeground(black);

		ga = gaService.createPlainPolyline(outlinePolygon,
				new int[] { width - horizontalOffset - 1, depth - 2, width - horizontalOffset - 1, height });
		PropertyUtil.setIsStylingChild(ga, true);
		ga.setLineWidth(lineWidth);
		ga.setLineStyle(lineStyle);
		ga.setForeground(black);

		gaService.setSize(outlinePolygon, width, height);

		return outlinePolygon;
	}

	private static GraphicsAlgorithm createGraphicsAlgorithmForMemory(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final MemoryGraphic mg, final int width, final int height,
			boolean fillBackground, final int lineWidth, final LineStyle lineStyle) {
		final IGaService gaService = Graphiti.getGaService();

		final Color black = gaService.manageColor(diagram, IColorConstant.BLACK);
		final Color white = gaService.manageColor(diagram, IColorConstant.WHITE);

		final int ellipseHeight = 20;
		final double halfEllipseHeight = ellipseHeight / 2.0;
		final GraphicsAlgorithm ga = gaService.createPlainRectangle(containerGa);
		PropertyUtil.setIsStylingContainer(ga, true);
		PropertyUtil.setIsStylingChild(ga, true);
		ga.setLineVisible(false);
		ga.setBackground(white);
		ga.setFilled(fillBackground);

		// Top ellipse
		final GraphicsAlgorithm topEllipse = gaService.createPlainEllipse(ga);
		PropertyUtil.setIsStylingChild(topEllipse, true);
		gaService.setLocationAndSize(topEllipse, 0, 0, width, ellipseHeight);
		topEllipse.setForeground(black);
		topEllipse.setLineWidth(lineWidth);
		topEllipse.setFilled(false);

		// Draw a half ellipse for the bottom
		int halfEllipsePointCount = 8;
		int[] points = new int[halfEllipsePointCount * 2 + 8];
		int j = 0;

		// Right Side
		points[j++] = width;
		points[j++] = ellipseHeight / 2;
		points[j++] = width;
		points[j++] = (int) Math.round(height - halfEllipseHeight);

		// Bottom Half Ellipse
		double t = -Math.PI / 2.0;
		final double halfWidth = width / 2.0;
		for (int i = 0; i < halfEllipsePointCount; i++) {
			final int x = (int) Math.round(halfWidth + (-Math.sin(t) * halfWidth));
			final int y = (int) Math.round(height - halfEllipseHeight + (Math.cos(t) * halfEllipseHeight));
			points[j++] = x;
			points[j++] = y;
			t += Math.PI / (halfEllipsePointCount - 1);
		}

		// Left Side
		points[j++] = 0;
		points[j++] = (int) Math.round(height - halfEllipseHeight);
		points[j++] = 0;
		points[j++] = ellipseHeight / 2;

		final org.eclipse.graphiti.mm.algorithms.Polyline linesGa = gaService.createPlainPolyline(ga, points);
		PropertyUtil.setIsStylingChild(linesGa, true);
		gaService.setLocationAndSize(linesGa, 0, 0, width, height);
		linesGa.setLineWidth(lineWidth);
		linesGa.setForeground(black);

		gaService.setSize(ga, width, height);

		return ga;
	}

	private static GraphicsAlgorithm createGraphicsAlgorithmForFeatureGroupType(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final FeatureGroupTypeGraphic fgtg, final int requestedWidth,
			final int requestedHeight, boolean fillBackground, final int lineWidth, final LineStyle lineStyle) {
		final IGaService gaService = Graphiti.getGaService();

		final Color black = gaService.manageColor(diagram, IColorConstant.BLACK);
		final Color white = gaService.manageColor(diagram, IColorConstant.WHITE);

		final GraphicsAlgorithm ga = gaService.createPlainRectangle(containerGa);
		final int halfCircleOuterWidth = (int) (2.0 * requestedWidth / 3.0);
		final int halfCircleOuterHeight = (int) (requestedHeight / 2.0);
		final int halfCircleInnerWidth = (int) ((halfCircleOuterWidth + halfCircleOuterWidth * .2) / 2.0);
		final int halfCircleInnerHeight = (int) ((halfCircleOuterHeight + halfCircleOuterHeight * .2) / 2.0);

		final int innerCircleWidth = (int) (2.0 * requestedWidth / 3.0);
		final int innerCircleHeight = halfCircleOuterHeight;

		final int innerCircleX = (int) Math.round(halfCircleOuterWidth - innerCircleWidth / 2.0);
		final int innerCircleY = (int) Math.round(halfCircleOuterHeight - innerCircleHeight / 2.0);

		PropertyUtil.setIsStylingContainer(ga, true);

		PropertyUtil.setIsStylingChild(ga, true);
		ga.setBackground(white);
		ga.setForeground(black);
		ga.setLineWidth(2);
		ga.setLineVisible(true);
		ga.setFilled(true);

		// Draw a half ellipse
		int pointPerSemiCircle = 16;
		int[] points = new int[pointPerSemiCircle * 4];
		int j = 0;
		double t = 0;
		for (int i = 0; i < pointPerSemiCircle; i++) {
			final int x = (int) Math.round(halfCircleOuterWidth + (-Math.sin(t) * halfCircleOuterWidth));
			final int y = (int) Math.round(halfCircleOuterHeight + (Math.cos(t) * halfCircleOuterHeight));
			points[j++] = x;
			points[j++] = y;
			t += Math.PI / (pointPerSemiCircle - 1);
		}

		t = Math.PI;
		for (int i = 0; i < pointPerSemiCircle; i++) {
			final int x = (int) Math.round(halfCircleOuterWidth + (-Math.sin(t) * halfCircleInnerWidth));
			final int y = (int) Math.round(halfCircleOuterHeight + (Math.cos(t) * halfCircleInnerHeight));
			points[j++] = x;
			points[j++] = y;
			t -= Math.PI / (pointPerSemiCircle - 1);
		}

		final org.eclipse.graphiti.mm.algorithms.Polygon halfCircle = gaService.createPlainPolygon(ga, points);
		gaService.setLocationAndSize(halfCircle, 0, 0, requestedWidth, requestedHeight);
		halfCircle.setBackground(white);
		halfCircle.setForeground(black);
		halfCircle.setLineWidth(2);
		halfCircle.setFilled(fillBackground);
		PropertyUtil.setIsStylingChild(halfCircle, true);

		// Inner Circle
		final GraphicsAlgorithm innerCircle = gaService.createPlainEllipse(ga);
		gaService.setLocationAndSize(innerCircle, innerCircleX, innerCircleY, innerCircleWidth, innerCircleHeight);
		innerCircle.setBackground(white);
		innerCircle.setForeground(black);
		innerCircle.setLineWidth(2);
		innerCircle.setFilled(fillBackground);
		PropertyUtil.setIsStylingChild(innerCircle, true);

		gaService.setSize(ga, requestedWidth, requestedHeight);
		return ga;
	}

	private static GraphicsAlgorithm createGraphicsAlgorithmForFolder(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final FolderGraphic folderGraphic, final int width,
			final int height, boolean fillBackground, final int lineWidth, final LineStyle lineStyle) {
		final IGaService gaService = Graphiti.getGaService();

		// Width of tab
		int widthOfTab = Math.min(folderMaxTabWidth, (int) (width * folderTopOfTabOffset));
		// The tab start and end slope
		int tabOffset = (int) (Math.ceil(Math.tan(Math.toRadians(folderTabOffsetAngle)) * folderTabHeight));
		final GraphicsAlgorithm ga = gaService.createPlainPolygon(containerGa,
				new int[] { 0, height, 0, folderTabHeight, tabOffset, 0, widthOfTab, 0, widthOfTab + tabOffset,
						folderTabHeight, width, folderTabHeight, width, height });

		PropertyUtil.setIsStylingChild(ga, true);
		ga.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
		ga.setBackground(gaService.manageColor(diagram, IColorConstant.WHITE));
		ga.setLineWidth(lineWidth);
		ga.setFilled(fillBackground);
		gaService.setSize(ga, width, height);

		return ga;
	}

	private static GraphicsAlgorithm createGraphicsAlgorithmForNote(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final NoteGraphic noteGraphic, final int width,
			final int height, boolean fillBackground, final int lineWidth, final LineStyle lineStyle) {
		final IGaService gaService = Graphiti.getGaService();

		final GraphicsAlgorithm ga = gaService.createPlainPolygon(containerGa,
				new int[] { 0, 0,
						width - noteOffset, 0,
						width, noteOffset,
						width, height,
						0, height });

		final GraphicsAlgorithm ga2 = gaService.createPlainPolygon(ga,
				new int[] { width - noteOffset, 0, width, noteOffset, width - noteOffset, noteOffset });

		PropertyUtil.setIsStylingContainer(ga, true);
		PropertyUtil.setIsStylingChild(ga, true);
		ga.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
		ga.setBackground(gaService.manageColor(diagram, IColorConstant.WHITE));
		ga.setLineWidth(lineWidth);
		ga.setFilled(fillBackground);
		gaService.setSize(ga, width, height);

		PropertyUtil.setIsStylingChild(ga2, true);
		ga2.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
		ga2.setBackground(gaService.manageColor(diagram, IColorConstant.WHITE));
		ga2.setLineWidth(lineWidth);
		ga2.setFilled(fillBackground);
		gaService.setSize(ga2, noteOffset, noteOffset);

		return ga;
	}

	private static GraphicsAlgorithm createGraphicsAlgorithmForMode(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final ModeGraphic mg, final int requestedWidth,
			final int requestedHeight, boolean fillBackground, final int lineWidth, final LineStyle lineStyle) {
		final IGaService gaService = Graphiti.getGaService();

		final Color black = gaService.manageColor(diagram, IColorConstant.BLACK);
		final Color white = gaService.manageColor(diagram, IColorConstant.WHITE);

		final GraphicsAlgorithm ga = gaService.createPlainRectangle(containerGa);
		PropertyUtil.setIsStylingContainer(ga, true);
		ga.setLineVisible(false);
		ga.setFilled(false);

		// Determine the size of the overall shape
		int width = requestedWidth;
		int height = requestedHeight;
		int modeHeight = height;
		if (mg.isInitialMode) {
			// Reduce the size of the mode symbol to accommodate the initial mode indicator.
			modeHeight -= ModeGraphic.initialModeAreaHeight;
			width = Math.max(width, ModeGraphic.initialModeEllipseSize);
		}
		gaService.setSize(ga, width, height);

		// Create mode graphics algorithm.
		// Create the mode graphics algorithms first because it should be used for the chopbox anchor.
		final GraphicsAlgorithm modeGa = gaService.createPlainPolygon(ga,
				new int[] { (int) (requestedWidth * 0.0), (int) (modeHeight * 0.5), (int) (requestedWidth * 0.25),
						(int) (modeHeight * 0.0), (int) (requestedWidth * 0.75), (int) (modeHeight * 0.0),
						(int) (requestedWidth * 1.0), (int) (modeHeight * 0.5), (int) (requestedWidth * 0.75),
						(int) (modeHeight * 1.0), (int) (requestedWidth * 0.25), (int) (modeHeight * 1.0) });
		PropertyUtil.setIsStylingChild(modeGa, true);
		modeGa.setLineWidth(lineWidth);
		modeGa.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(lineStyle));
		modeGa.setBackground(white);
		modeGa.setForeground(black);
		modeGa.setFilled(fillBackground);

		// Set size and position
		modeGa.setY(mg.isInitialMode ? ModeGraphic.initialModeAreaHeight : 0);
		modeGa.setWidth(requestedWidth);
		modeGa.setHeight(requestedHeight);

		if (mg.isInitialMode) {
			// Create ellipse for the initial mode indicator
			final GraphicsAlgorithm initialModeEllipse = gaService.createEllipse(ga);
			initialModeEllipse.setWidth(ModeGraphic.initialModeEllipseSize);
			initialModeEllipse.setHeight(ModeGraphic.initialModeEllipseSize);
			initialModeEllipse.setBackground(black);
			initialModeEllipse.setForeground(black);
			initialModeEllipse.setX(Math.max(0, requestedWidth / 2 - ModeGraphic.initialModeEllipseSize * 3));
			initialModeEllipse.setY(0);

			// Create polyline which connects the initial mode indicator and the mode
			final int lineStartX = initialModeEllipse.getX() + ModeGraphic.initialModeEllipseSize / 2;
			final int lineStartY = ModeGraphic.initialModeEllipseSize / 2;
			final int lineEndX = requestedWidth / 2;
			final int lineEndY = ModeGraphic.initialModeAreaHeight;
			final int lineDx = lineEndX - lineStartX;
			final int lineDy = lineEndY - lineStartY;
			final org.eclipse.graphiti.mm.algorithms.Polyline polyline = gaService.createPolyline(ga,
					new int[] { lineStartX, lineStartY, (int) (lineStartX + lineDx * 0.5),
							(int) (lineStartY + lineDy * 0.1), (int) (lineStartX + lineDx * 0.8),
							(int) (lineStartY + lineDy * 0.2), (int) (lineStartX + lineDx * 0.9),
							(int) (lineStartY + lineDy * 0.3), lineStartX + lineDx, (int) (lineStartY + lineDy * 0.5),
							lineEndX, (int) (lineEndY * 0.9) });

			polyline.setBackground(black);
			polyline.setForeground(black);
			polyline.setLineWidth(lineWidth);

			final int arrowWidth = 6;
			final org.eclipse.graphiti.mm.algorithms.Polyline arrow = gaService.createPolygon(ga,
					new int[] { lineEndX - arrowWidth / 2, lineEndY - arrowWidth, lineEndX + arrowWidth / 2,
							lineEndY - arrowWidth, lineEndX, lineEndY });
			arrow.setBackground(black);
			arrow.setForeground(black);
			arrow.setLineWidth(0);
		}
		return ga;
	}

	/**
	 * Returns the amount of top padding that should be ignored when centering labels, etc in the shape
	 * @param graphic
	 * @return
	 */
	public static int getCenteringOffsetY(final Graphic graphic) {
		if (graphic instanceof ModeGraphic && ((ModeGraphic) graphic).isInitialMode) {
			return ModeGraphic.initialModeAreaHeight;
		}

		return 0;
	}

// width and fillBackground are ignored for feature
	private static GraphicsAlgorithm createGraphicsAlgorithmForFeature(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final FeatureGraphic featureGraphic, final int width,
			final int height, boolean fillBackground, final int lineWidth, final LineStyle lineStyle) {
		final IGaService gaService = Graphiti.getGaService();

		switch (featureGraphic.featureType) {
		case ABSTRACT:
			return createAbstractFeatureGraphicsAlgorithm(diagram, containerGa, featureGraphic.direction);

		case BUS_OR_DATA_ACCESS:
			return createDataOrBusAccessGraphicsAlgorithm(diagram, containerGa, featureGraphic.direction);

		case DATA_PORT:
			return createPortGraphicsAlgorithm(diagram, containerGa, true, false, featureGraphic.direction);

		case EVENT_DATA_PORT:
			return createPortGraphicsAlgorithm(diagram, containerGa, true, true, featureGraphic.direction);

		case EVENT_PORT:
			return createPortGraphicsAlgorithm(diagram, containerGa, false, true, featureGraphic.direction);

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

	private static GraphicsAlgorithm createAbstractFeatureGraphicsAlgorithm(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final Direction direction) {
		final IGaService gaService = Graphiti.getGaService();
		final Color black = gaService.manageColor(diagram, IColorConstant.BLACK);

		final int width = (int) defaultFeatureSize.width;
		final int height = (int) defaultFeatureSize.height;

		final GraphicsAlgorithm ga = gaService.createPlainRectangle(containerGa);
		PropertyUtil.setIsStylingContainer(ga, true);
		ga.setFilled(false);
		ga.setLineVisible(false);
		gaService.setSize(ga, width, height);

		final int circlePadding;
		if (direction == Direction.IN_OUT) {
			circlePadding = 0;
		} else {
			circlePadding = 3;
		}

		// In Abstract Feature
		final int[] directionPoints;
		if (direction == Direction.IN) {
			directionPoints = new int[] { 0, 0, width, height / 2, 0, height };
		} else if (direction == Direction.OUT) { // Out Abstract Feature
			directionPoints = new int[] { width, 0, 0, height / 2, width, height };
		} else {
			directionPoints = null;
		}

		if(directionPoints != null) {
			final Color white = gaService.manageColor(diagram, IColorConstant.WHITE);
			final GraphicsAlgorithm directionBgGa = gaService.createPlainPolygon(ga, directionPoints);
			directionBgGa.setFilled(true);
			directionBgGa.setBackground(white);
			directionBgGa.setForeground(white);
			directionBgGa.setLineWidth(featureLineWidth);
			directionBgGa.setTransparency(featureBgTransparency);
			directionBgGa.setLineVisible(false);

			final GraphicsAlgorithm directionGa = gaService.createPlainPolyline(ga, directionPoints);
			PropertyUtil.setIsStylingChild(directionGa, true);
			directionGa.setBackground(black);
			directionGa.setForeground(black);
			directionGa.setLineWidth(featureLineWidth);
		}

		// Create the circle last. Created last so that the first graphical algorithm created if it is directional will be the obscuring outline.
		final GraphicsAlgorithm circleGa = gaService.createPlainEllipse(ga);
		PropertyUtil.setIsStylingChild(circleGa, true);
		circleGa.setBackground(black);
		circleGa.setForeground(black);
		gaService.setLocation(circleGa, 0, circlePadding);
		final int minDim = Math.min(width, height);
		gaService.setSize(circleGa, minDim - 2 * circlePadding, minDim - 2 * circlePadding);

		if (direction == Direction.OUT) {
			gaService.setLocation(circleGa, ga.getWidth() - circleGa.getWidth(), circlePadding);
		}

		shrink(ga);
		return ga;
	}

	private static GraphicsAlgorithm createPortGraphicsAlgorithm(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final boolean hasData, final boolean hasEvent,
			final Direction direction) {
		final IGaService gaService = Graphiti.getGaService();
		final Color black = gaService.manageColor(diagram, IColorConstant.BLACK);

		final GraphicsAlgorithm ga = gaService.createPlainRectangle(containerGa);
		PropertyUtil.setIsStylingContainer(ga, true);
		ga.setFilled(false);
		ga.setLineVisible(false);

		final int dataSymbolXPadding;
		final int dataSymbolYPadding;

		// Data width and height should be evenly divisible in all cases. Check other match
		if (hasEvent) {
			if (direction == Direction.IN_OUT) {
				dataSymbolXPadding = 10;
				dataSymbolYPadding = 4;
			} else {
				dataSymbolXPadding = 8;
				dataSymbolYPadding = 4;
			}
		} else {
			dataSymbolXPadding = 0;
			dataSymbolYPadding = 0;
		}

		int[] eventPoints = null;
		int[] dataPoints = null;

		final int width = (int) defaultFeatureSize.width;
		final int height = (int) defaultFeatureSize.height;

		switch (direction) {
		// In Port
		case IN:
			if (hasEvent) {
				eventPoints = new int[] { 0, 0, width, height / 2, 0, height };
			}

			if (hasData) {
				dataPoints = new int[] { 0, dataSymbolYPadding, width - dataSymbolXPadding, height / 2, 0,
						height - dataSymbolYPadding };
			}

			break;

			// Out Port
		case OUT:
			if (hasEvent) {
				eventPoints = new int[] { width, 0, 0, height / 2, width, height };
			}

			if (hasData) {
				dataPoints = new int[] { width, dataSymbolYPadding, dataSymbolXPadding, height / 2, width,
						height - dataSymbolYPadding };
			}

			break;

			// In Out Port
		case IN_OUT:
			if (hasEvent) {
				eventPoints = new int[] { width / 2, 0, width, height / 2, width / 2, height, 0, height / 2, width / 2,
						0 };
			}

			if (hasData) {
				dataPoints = new int[] { width / 2, dataSymbolYPadding, width - dataSymbolXPadding / 2, height / 2,
						width / 2, height - dataSymbolYPadding, dataSymbolXPadding / 2, height / 2 };
			}

			break;
		}

		if (eventPoints != null) {
			final Color white = gaService.manageColor(diagram, IColorConstant.WHITE);
			final GraphicsAlgorithm eventBgGa = gaService.createPlainPolygon(ga, eventPoints);
			eventBgGa.setFilled(true);
			eventBgGa.setBackground(white);
			eventBgGa.setForeground(white);
			eventBgGa.setLineWidth(featureLineWidth);
			eventBgGa.setTransparency(featureBgTransparency);
			eventBgGa.setLineVisible(false);

			final GraphicsAlgorithm eventGa = gaService.createPlainPolyline(ga, eventPoints);
			PropertyUtil.setIsStylingChild(eventGa, true);
			eventGa.setBackground(black);
			eventGa.setForeground(black);
			eventGa.setLineWidth(featureLineWidth);
		}

		if (dataPoints != null) {
			final GraphicsAlgorithm dataGa = gaService.createPlainPolygon(ga, dataPoints);
			PropertyUtil.setIsStylingChild(dataGa, true);
			dataGa.setBackground(black);
			dataGa.setForeground(black);
			dataGa.setLineWidth(featureLineWidth);
		}

		gaService.setSize(ga, width, height);
		shrink(ga);

		return ga;
	}

	private static GraphicsAlgorithm createDataOrBusAccessGraphicsAlgorithm(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final Direction direction) {
		final IGaService gaService = Graphiti.getGaService();
		final Color black = gaService.manageColor(diagram, IColorConstant.BLACK);
		final Color white = gaService.manageColor(diagram, IColorConstant.WHITE);

		final int width = (int) defaultFeatureSize.width;
		final int height = (int) defaultFeatureSize.height;
		final int slopeWidth = 5;

		final GraphicsAlgorithm ga;
		if (direction == Direction.OUT) {
			ga = gaService.createPlainPolygon(containerGa,
					new int[] { width, 0, slopeWidth, 0, 0, height / 2, slopeWidth, height, width, height, width, 0 });
		} else if (direction == Direction.IN) {
			ga = gaService.createPlainPolygon(containerGa, new int[] { 0, 0, width - slopeWidth, 0, width, height / 2,
					width - slopeWidth, height, 0, height, 0, 0 });
		} else {
			throw new RuntimeException("Access graphic is not an input or an output.");
		}

		PropertyUtil.setIsStylingChild(ga, true);
		ga.setBackground(white);
		ga.setForeground(black);
		ga.setLineWidth(featureLineWidth);

		gaService.setSize(ga, width, height);
		return ga;
	}

	private static GraphicsAlgorithm createSubprogramAccessGraphicsAlgorithm(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final Direction direction, final boolean blackBackground) {
		final IGaService gaService = Graphiti.getGaService();
		final Color black = gaService.manageColor(diagram, IColorConstant.BLACK);
		final Color white = gaService.manageColor(diagram, IColorConstant.WHITE);
		final Color background = blackBackground ? black : white;
		final Color foreground = blackBackground ? white : black;

		final int width = (int) defaultFeatureSize.width;
		final int height = (int) defaultFeatureSize.height;

		final int vPadding = 5;

		final GraphicsAlgorithm ga = gaService.createPlainEllipse(containerGa);
		gaService.setSize(ga, width, height);
		ga.setBackground(background);
		ga.setForeground(black);
		ga.setLineWidth(featureLineWidth);
		PropertyUtil.setIsStylingChild(ga, true);

		final int arrowWidth = 10;
		final int arrowHeight = height - 2 * vPadding;
		final int left = width / 2 - arrowWidth / 2;
		if (direction == Direction.OUT) {
			final GraphicsAlgorithm arrowGa = gaService.createPlainPolyline(ga,
					new int[] { 0, 0, arrowWidth, arrowHeight / 2, 0, arrowHeight });
			arrowGa.setBackground(background);
			arrowGa.setForeground(foreground);
			arrowGa.setLineWidth(featureLineWidth);
			arrowGa.setX(left);
			arrowGa.setY(vPadding);
			arrowGa.setWidth(arrowWidth);
			arrowGa.setHeight(arrowHeight);
		} else if (direction == Direction.IN) {
			final GraphicsAlgorithm arrowGa = gaService.createPlainPolyline(ga,
					new int[] { arrowWidth, 0, 0, arrowHeight / 2, arrowWidth, arrowHeight });
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

	private static GraphicsAlgorithm createFeatureGroupGraphicsAlgorithm(final Diagram diagram,
			final GraphicsAlgorithmContainer containerGa, final Direction direction, int height) {
		final IGaService gaService = Graphiti.getGaService();
		final Color black = gaService.manageColor(diagram, IColorConstant.BLACK);

		final GraphicsAlgorithm ga = gaService.createRectangle(containerGa);
		final int width = featureGroupDefaultSymbolWidth;
		final int barWidth = width - featureGroupCircleWidth;
		height = Math.max(height, featureGroupCircleWidth);
		gaService.setSize(ga, width, height);
		ga.setLineVisible(false);
		ga.setFilled(false);
		PropertyUtil.setIsStylingContainer(ga, true);

		// Circle
		final GraphicsAlgorithm circle = gaService.createPlainEllipse(ga);
		gaService.setLocationAndSize(circle, 0, height / 2 - featureGroupCircleWidth / 2, featureGroupCircleWidth, featureGroupCircleWidth);
		circle.setBackground(black);
		circle.setForeground(black);
		PropertyUtil.setIsStylingChild(circle, true);

		// Bar
		final GraphicsAlgorithm bar = gaService.createPlainRectangle(ga);
		gaService.setLocationAndSize(bar, featureGroupCircleWidth, 0, barWidth, height);
		bar.setBackground(black);
		bar.setForeground(black);
		PropertyUtil.setIsStylingChild(bar, true);

		return ga;
	}

	public static void rotate(final GraphicsAlgorithm ga, final DockArea dockArea) {
		switch (dockArea) {
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
		if (rootGa != ga) {
			final int newY = ga.getX();
			ga.setX(ga.getParentGraphicsAlgorithm().getHeight() - (ga.getY() + ga.getHeight()));
			ga.setY(newY);
		}

		if (ga instanceof org.eclipse.graphiti.mm.algorithms.Polyline) {
			// Rotate every point in the polyline
			final org.eclipse.graphiti.mm.algorithms.Polyline polyline = (org.eclipse.graphiti.mm.algorithms.Polyline) ga;
			for (final Point p : polyline.getPoints()) {
				final int newX = p.getY();
				final int newY = p.getX();
				p.setX(newX);
				p.setY(newY);
			}
		}

		for (final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
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
		if (rootGa != ga) {
			final int newY = ga.getParentGraphicsAlgorithm().getWidth() - (ga.getX() + ga.getWidth());
			ga.setX(ga.getParentGraphicsAlgorithm().getHeight() - (ga.getY() + ga.getHeight()));
			ga.setY(newY);
		}

		if (ga instanceof org.eclipse.graphiti.mm.algorithms.Polyline) {
			// Mirror every point in the polyline
			final org.eclipse.graphiti.mm.algorithms.Polyline polyline = (org.eclipse.graphiti.mm.algorithms.Polyline) ga;
			for (final Point p : polyline.getPoints()) {
				final int newX = p.getY();
				final int newY = -p.getX() + ga.getWidth();

				p.setX(newX);
				p.setY(newY);
			}
		}

		for (final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
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
		if (rootGa != ga) {
			ga.setX(ga.getParentGraphicsAlgorithm().getWidth() - ga.getX() - ga.getWidth());
		}

		if (ga instanceof org.eclipse.graphiti.mm.algorithms.Polyline) {
			// Mirror every point in the polyline
			final org.eclipse.graphiti.mm.algorithms.Polyline polyline = (org.eclipse.graphiti.mm.algorithms.Polyline) ga;
			for (final Point p : polyline.getPoints()) {
				p.setX(ga.getWidth() - p.getX());
			}
		}

		for (final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
			mirrorX(rootGa, childGa);
		}
	}

	public static void mirrorX(final GraphicsAlgorithm ga) {
		mirrorX(ga, ga);
	}

	public static void shrink(final GraphicsAlgorithm ga) {
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;

		// Determine the min/max x/y of all children.
		for (final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
			if (childGa instanceof org.eclipse.graphiti.mm.algorithms.Polyline) {
				shrinkPolyline((org.eclipse.graphiti.mm.algorithms.Polyline) childGa);
			}

			minX = Math.min(minX, childGa.getX());
			maxX = Math.max(maxX, childGa.getX() + childGa.getWidth());
			minY = Math.min(minY, childGa.getY());
			maxY = Math.max(maxY, childGa.getY() + childGa.getHeight());
		}

		for (final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
			childGa.setX(childGa.getX() - minX);
			childGa.setY(childGa.getY() - minY);
		}

		ga.setX(ga.getX() + minX);
		ga.setY(ga.getY() + minY);
		ga.setWidth(maxX - minX);
		ga.setHeight(maxY - minY);
	}

	public static void shrinkPolyline(final org.eclipse.graphiti.mm.algorithms.Polyline polyline) {
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		for (final Point p : polyline.getPoints()) {
			minX = Math.min(minX, p.getX());
			maxX = Math.max(maxX, p.getX());
			minY = Math.min(minY, p.getY());
			maxY = Math.max(maxY, p.getY());
		}

		for (final Point p : polyline.getPoints()) {
			p.setX(p.getX() - minX);
			p.setY(p.getY() - minY);
		}

		polyline.setX(polyline.getX() + minX);
		polyline.setY(polyline.getY() + minY);
		polyline.setWidth(maxX - minX);
		polyline.setHeight(maxY - minY);
	}
}

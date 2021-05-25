/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.gef.ui.services;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.JTextArea;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.fx.anchors.IAnchor;
import org.eclipse.gef.fx.nodes.Connection;
import org.osate.ge.GraphicalEditor;
import org.osate.ge.ProjectUtil;
import org.osate.ge.gef.AgeGefRuntimeException;
import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.gef.ui.diagram.GefAgeDiagram;
import org.osate.ge.gef.ui.editor.AgeEditor;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.DiagramSerialization;
import org.osate.ge.internal.diagram.runtime.botree.DefaultBusinessObjectNodeFactory;
import org.osate.ge.internal.diagram.runtime.botree.DefaultTreeUpdater;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.diagram.runtime.updating.DefaultDiagramElementGraphicalConfigurationProvider;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.InternalDiagramExportService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.services.impl.DefaultColoringService;
import org.osate.ge.internal.services.impl.ProjectReferenceServiceProxy;
import org.osate.ge.internal.services.impl.SimpleServiceContextFunction;
import org.osate.ge.services.DiagramExportService;
import org.osate.ge.services.QueryService;
import org.osate.ge.services.impl.DefaultQueryService;
import org.osgi.framework.FrameworkUtil;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Region;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Text;
import javafx.scene.transform.Transform;

/**
 * Diagram export service implementation for the GEF implementation of the graphical editor.
 * Generates an image based on the JavaFX scene graph. Only a subset of JavaFX scene graph nodes are supported.
 * To properly export diagrams, this class must be updated to support any JavaFX shapes used in the scene graph.
 * See {@link #isExportNode(Node)}.
 *
 */
public class GefDiagramExportService implements InternalDiagramExportService {
	private static final java.awt.Color TRANSPARENT = new java.awt.Color(0, 0, 0, 0);

	public static class ContextFunction extends SimpleServiceContextFunction<DiagramExportService> {
		@Override
		public DiagramExportService createService(final IEclipseContext context) {
			return new GefDiagramExportService();
		}
	}

	@Override
	public void export(final IFile diagramFile, final OutputStream outputStream, final String format, double scaling)
			throws IOException {
		try (GefAgeDiagram diagram = loadDiagram(diagramFile)) {
			export(diagram, diagram.getDiagram(), diagram.getSceneNode().getSceneToLocalTransform(), scaling,
					outputStream, format);
		}
	}

	@Override
	public void export(final GraphicalEditor editor, final OutputStream outputStream, final String format,
			final DiagramNode exportNode, final double scaling) throws IOException {
		if (!(editor instanceof AgeEditor)) {
			throw new AgeGefRuntimeException("Unexpected editor type. Editor must be of type " + AgeEditor.class);
		}

		Objects.requireNonNull(exportNode, "exportNode must not be null");

		final GefAgeDiagram diagram = ((AgeEditor) editor).getGefDiagram();
		export(diagram, exportNode, diagram.getSceneNode().getSceneToLocalTransform(), scaling, outputStream, format);
	}

	@Override
	public BufferedImage export(final GraphicalEditor editor, final DiagramNode exportNode, final double scaling) {
		if (!(editor instanceof AgeEditor)) {
			throw new AgeGefRuntimeException("Unexpected editor type. Editor must be of type " + AgeEditor.class);
		}

		Objects.requireNonNull(exportNode, "exportNode must not be null");
		final GefAgeDiagram diagram = ((AgeEditor) editor).getGefDiagram();
		return exportToRasterImage(diagram, exportNode, diagram.getSceneNode().getSceneToLocalTransform(), scaling);
	}

	private static void export(final GefAgeDiagram diagram, final DiagramNode exportRootDiagramNode,
			final Transform sceneToDiagramTransform, final double scaling, final OutputStream output,
			final String format) throws IOException {
		if ("svg".equalsIgnoreCase(format)) {
			final Writer outWriter = new OutputStreamWriter(output, "UTF-8");
			exportToSvg(diagram, exportRootDiagramNode, sceneToDiagramTransform, scaling).stream(outWriter, false);
		} else {
			final BufferedImage image = exportToRasterImage(diagram, exportRootDiagramNode, sceneToDiagramTransform,
					scaling);
			ImageIO.write(image, format, output);
		}
	}

	private static SVGGraphics2D exportToSvg(final GefAgeDiagram diagram, final DiagramNode exportRootDiagramNode,
			final Transform sceneToDiagramTransform, final double scaling) {
		final List<Node> exportNodes = getExportNodes(diagram, exportRootDiagramNode);
		final Bounds bounds = getBounds(exportNodes, sceneToDiagramTransform);
		final Transform sceneToExportTransform = sceneToDiagramTransform
				.createConcatenation(Transform.translate(-bounds.getMinX(), -bounds.getMinY()));

		// Generate the SVG
		DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
		String svgNS = "http://www.w3.org/2000/svg";
		Document doc = domImpl.createDocument(svgNS, "svg", null);
		final SVGGraphics2D svgGenerator = new SVGGraphics2D(doc);
		svgGenerator.setSVGCanvasSize(new java.awt.Dimension((int) Math.ceil(bounds.getWidth() * scaling),
				(int) Math.ceil(bounds.getHeight() * scaling)));
		draw(exportNodes, sceneToExportTransform, scaling, svgGenerator);

		return svgGenerator;
	}

	private static BufferedImage exportToRasterImage(final GefAgeDiagram diagram,
			final DiagramNode exportRootDiagramNode, final Transform sceneToDiagramTransform, final double scaling) {
		final List<Node> exportNodes = getExportNodes(diagram, exportRootDiagramNode);
		final Bounds bounds = getBounds(exportNodes, sceneToDiagramTransform);
		final Transform sceneToExportTransform = sceneToDiagramTransform
				.createConcatenation(Transform.translate(-bounds.getMinX(), -bounds.getMinY()));

		final BufferedImage image = new BufferedImage((int) Math.ceil(bounds.getWidth() * scaling),
				(int) Math.ceil(bounds.getHeight() * scaling), BufferedImage.TYPE_INT_RGB);
		final Graphics2D graphics = image.createGraphics();
		graphics.setColor(new Color(255, 255, 255, 255));
		graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
		draw(exportNodes, sceneToExportTransform, scaling, graphics);
		return image;
	}

	/**
	 * Returns the bounds of the specified nodes in diagram coordinates.
	 * @param nodes the nodes for which to get the bounds.
	 * @param sceneToDiagramTransform the transformation from scene to diagram coordinates.
	 * @return the bounds in diagram coordinates.
	 */
	private static Bounds getBounds(final List<Node> nodes, final Transform sceneToDiagramTransform) {
		double minX = Double.POSITIVE_INFINITY;
		double minY = Double.POSITIVE_INFINITY;
		double maxX = Double.NEGATIVE_INFINITY;
		double maxY = Double.NEGATIVE_INFINITY;

		for (final Node node : nodes) {
			final Bounds nodeBoundsInDiagram = sceneToDiagramTransform
					.transform(node.getLocalToSceneTransform().transform(node.getBoundsInLocal()));
			minX = Math.min(minX, nodeBoundsInDiagram.getMinX());
			minY = Math.min(minY, nodeBoundsInDiagram.getMinY());
			maxX = Math.max(maxX, nodeBoundsInDiagram.getMaxX());
			maxY = Math.max(maxY, nodeBoundsInDiagram.getMaxY());
		}

		return new BoundingBox(minX, minY, maxX - minX, maxY - minY);
	}

	@Override
	public Dimension getDimensions(final GraphicalEditor editor, final DiagramNode exportNode) {
		if (!(editor instanceof AgeEditor)) {
			throw new AgeGefRuntimeException("Unexpected editor type. Editor must be of type " + AgeEditor.class);
		}
		Objects.requireNonNull(exportNode, "exportNode must not be null");

		final GefAgeDiagram diagram = ((AgeEditor) editor).getGefDiagram();
		final Bounds bounds = getBounds(getExportNodes(diagram, exportNode),
				diagram.getSceneNode().getSceneToLocalTransform());
		return new Dimension(bounds.getWidth(), bounds.getHeight());
	}

	private GefAgeDiagram loadDiagram(final IFile diagramFile) {
		final URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
		final IProject project = ProjectUtil.getProjectOrNull(uri);
		final org.osate.ge.diagram.Diagram mmDiagram = DiagramSerialization.readMetaModelDiagram(uri);
		final IEclipseContext eclipseContext = EclipseContextFactory
				.getServiceContext(FrameworkUtil.getBundle(GefDiagramExportService.class).getBundleContext());
		final ExtensionRegistryService extensionRegistry = Objects.requireNonNull(
				eclipseContext.get(ExtensionRegistryService.class), "Unable to retrieve extension registry");
		final ReferenceService referenceService = Objects.requireNonNull(eclipseContext.get(ReferenceService.class),
				"unable to retrieve reference service");
		final ActionService actionService = Objects.requireNonNull(eclipseContext.get(ActionService.class),
				"unable to retrieve action service");

		final AgeDiagram diagram = DiagramSerialization.createAgeDiagram(project, mmDiagram, extensionRegistry);

		// Update the diagram
		final QueryService queryService = new DefaultQueryService(referenceService);
		final ProjectProvider projectProvider = () -> diagramFile.getProject();
		final ProjectReferenceService projectReferenceService = new ProjectReferenceServiceProxy(referenceService,
				projectProvider);
		final DefaultBusinessObjectNodeFactory nodeFactory = new DefaultBusinessObjectNodeFactory(
				projectReferenceService);
		final DefaultTreeUpdater boTreeUpdater = new DefaultTreeUpdater(projectProvider, extensionRegistry,
				projectReferenceService, queryService, nodeFactory);
		final DefaultDiagramElementGraphicalConfigurationProvider deInfoProvider = new DefaultDiagramElementGraphicalConfigurationProvider(
				projectReferenceService, queryService, () -> diagram, extensionRegistry);
		final DiagramUpdater diagramUpdater = new DiagramUpdater(boTreeUpdater, deInfoProvider, actionService,
				projectReferenceService, projectReferenceService);
		diagramUpdater.updateDiagram(diagram);

		// Create the GEF Diagram
		final GefAgeDiagram gefDiagram = new GefAgeDiagram(diagram, new DefaultColoringService(
				new org.osate.ge.internal.services.impl.DefaultColoringService.StyleRefresher() {
					@Override
					public void refreshDiagramColoring() {
					}

					@Override
					public void refreshColoring(final Collection<DiagramElement> diagramElements) {
					}
				}));

		// Add to scene. This is required for text rendering
		new Scene(gefDiagram.getSceneNode());

		// Update the diagram to reflect the scene graph and perform incremental layout
		gefDiagram.updateDiagramFromSceneGraph(false);
		diagram.modify("Incremental Layout", m -> DiagramElementLayoutUtil.layoutIncrementally(diagram, m, gefDiagram));

		return gefDiagram;
	}

	/**
	 * Returns true if the node is an export node. An export node is a node which results in drawing while exporting.
	 * @param node the node to check.
	 * @return true if the node is an export node.
	 */
	private static boolean isExportNode(final Node node) {
		return node instanceof Path || node instanceof CubicCurve || node instanceof Polyline || node instanceof Polygon
				|| node instanceof javafx.scene.shape.Rectangle || node instanceof Circle || node instanceof Ellipse
				|| node instanceof Text || node instanceof ImageView
				|| (node instanceof Region && ((Region) node).getBackground() != null);
	}

	/**
	 * Returns a list of nodes to export. The nodes will be in draw order.
	 * @param diagram the diagram being export
	 * @param exportRootDiagramNode the root node being exported.
	 * @return the list of nodes to export.
	 */
	private static List<Node> getExportNodes(final GefAgeDiagram diagram, final DiagramNode exportRootDiagramNode) {
		// final GefAgeDiagram diagram,
		final Node exportRootSceneNode = diagram.getSceneNode(exportRootDiagramNode);
		if (exportRootSceneNode == null) {
			throw new AgeGefRuntimeException("Unable to find scene node for specified diagram node");
		}

		final List<Node> exportNodes = new ArrayList<>();
		addNonConnectionExportNodes(exportRootSceneNode, exportNodes);
		addConnectionExportNodes(diagram.getSceneNode(), exportRootSceneNode, exportNodes);

		return exportNodes;
	}

	/**
	 * Adds export nodes which are not descendants of a connection.
	 * @param node is the node being traversed.
	 * @param nodes the list to which to add the export nodes
	 */
	private static void addNonConnectionExportNodes(final Node node, List<Node> nodes) {
		// Don't export connections
		if (node.isVisible()) {
			if (node instanceof Connection) {
				return;
			}

			if (isExportNode(node)) {
				nodes.add(node);
			}

			if (node instanceof Parent) {
				for (final Node child : ((Parent) node).getChildrenUnmodifiable()) {
					addNonConnectionExportNodes(child, nodes);
				}
			}
		}
	}

	/**
	 * Adds export nodes which are descendants of a connection.
	 * @param node is the node being traversed.
	 * @param exportRoot is the root node being exported. Connections will not be added unless both ends of the
	 * connection are within this node.
	 * @param nodes the list to which to add the export nodes
	 */
	private static void addConnectionExportNodes(final Node node, final Node exportRoot, List<Node> nodes) {
		// Don't export connections
		if (node.isVisible()) {
			// Add the connection
			if (node instanceof Connection) {
				final Connection cn = (Connection) node;

				// Check if both end points are being exported
				if (!isExported(cn.getStartAnchor(), exportRoot) || !isExported(cn.getEndAnchor(), exportRoot)) {
					return;
				}

				for (final Node child : ((Parent) node).getChildrenUnmodifiable()) {
					// Add non-connection descendants
					addNonConnectionExportNodes(child, nodes);
				}
			} else if (node instanceof Parent) {
				// Continue looking for children
				for (final Node child : ((Parent) node).getChildrenUnmodifiable()) {
					addConnectionExportNodes(child, exportRoot, nodes);
				}
			}
		}
	}

	/**
	 * Returns true if the specified anchor will be exported.
	 * @param anchor the anchor to check
	 * @param exportRoot the root of the export
	 * @return true if the anchor is n the export
	 */
	private static boolean isExported(final IAnchor anchor, final Node exportRoot) {
		if (anchor == null) {
			return false;
		}

		// Check if the anchor is not owned by any node or is owned by a connection. If it is owned by a connection,
		// we assume it will be exported.
		if (anchor.getAnchorage() == null || anchor.getAnchorage() instanceof BaseConnectionNode) {
			return true;
		}

		for (Node tmp = anchor.getAnchorage(); tmp != null; tmp = tmp.getParent()) {
			if (tmp == exportRoot) {
				return true;
			}
		}

		return false;
	}

	private static void draw(final List<Node> exportNodes, final Transform sceneToExportTransform, final double scaling,
			final Graphics2D g2d) {
		// Set rendering options
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

		// Scale all drawing
		g2d.scale(scaling, scaling);

		for (final Node node : exportNodes) {
			// Create a new graphics object which uses the node's coordinate system
			final Graphics2D tg = (Graphics2D) g2d.create();
			{
				final Transform nodeToDiagramTransform = sceneToExportTransform
						.createConcatenation(node.getLocalToSceneTransform());
				tg.transform(new AffineTransform(nodeToDiagramTransform.getMxx(), nodeToDiagramTransform.getMyx(),
						nodeToDiagramTransform.getMxy(), nodeToDiagramTransform.getMyy(),
						nodeToDiagramTransform.getTx(), nodeToDiagramTransform.getTy()));
			}

			// Draw the node
			if (node instanceof Path) {
				final Path n = (Path) node;
				draw(toAwt(n), tg, toAwt(n.getFill()), toAwt(n.getStroke()), (float) n.getStrokeWidth(),
						n.getStrokeDashArray());
			} else if (node instanceof javafx.scene.shape.Rectangle) {
				final javafx.scene.shape.Rectangle n = (javafx.scene.shape.Rectangle) node;
				draw(toAwt(n), tg, toAwt(n.getFill()), toAwt(n.getStroke()), (float) n.getStrokeWidth(),
						n.getStrokeDashArray());
			} else if (node instanceof javafx.scene.shape.Circle) {
				final javafx.scene.shape.Circle n = (javafx.scene.shape.Circle) node;
				draw(toAwt(n), tg, toAwt(n.getFill()), toAwt(n.getStroke()), (float) n.getStrokeWidth(),
						n.getStrokeDashArray());
			} else if (node instanceof javafx.scene.shape.Ellipse) {
				final javafx.scene.shape.Ellipse n = (javafx.scene.shape.Ellipse) node;
				draw(toAwt(n), tg, toAwt(n.getFill()), toAwt(n.getStroke()), (float) n.getStrokeWidth(),
						n.getStrokeDashArray());
			} else if (node instanceof CubicCurve) {
				// Draw unfilled curve
				final CubicCurve n = (CubicCurve) node;
				draw(toAwt(n), tg, null, toAwt(n.getStroke()), (float) n.getStrokeWidth(), n.getStrokeDashArray());
			} else if (node instanceof Polygon) {
				final javafx.scene.shape.Polygon n = (javafx.scene.shape.Polygon) node;
				draw(toAwtPath(n.getPoints(), true), tg, toAwt(n.getFill()), toAwt(n.getStroke()),
						(float) n.getStrokeWidth(), n.getStrokeDashArray());
			} else if (node instanceof Polyline) {
				final javafx.scene.shape.Polyline n = (javafx.scene.shape.Polyline) node;
				// Draw unfilled polyline
				draw(toAwtPath(n.getPoints(), false), tg, null, toAwt(n.getStroke()), (float) n.getStrokeWidth(),
						n.getStrokeDashArray());
			} else if (node instanceof Text) {
				final Text text = (Text) node;

				// Draw the text using a JTextArea so that line wrapping will be supported.
				final Bounds layoutBounds = node.getLayoutBounds();
				final JTextArea ta = new JTextArea(text.getText());
				ta.setLineWrap(text.getWrappingWidth() > 0);
				ta.setWrapStyleWord(true);
				ta.setBackground(TRANSPARENT);
				ta.setBounds(0, 0,
						(int) (text.getWrappingWidth() > 0 ? text.getWrappingWidth() : layoutBounds.getWidth()),
						(int) layoutBounds.getHeight());
				ta.setForeground(toAwt(text.getFill()));
				ta.setFont(toAwt(text.getFont()));
				tg.translate((int) layoutBounds.getMinX(), (int) layoutBounds.getMinY());
				ta.paint(tg);
			} else if (node instanceof ImageView) {
				final Bounds layoutBounds = node.getLayoutBounds();
				final ImageView n = (ImageView) node;
				final BufferedImage image = SwingFXUtils.fromFXImage(n.getImage(), null);
				tg.drawImage(image, (int) layoutBounds.getMinX(), (int) layoutBounds.getMinY(),
						(int) layoutBounds.getMaxX(), (int) layoutBounds.getMaxY(), 0, 0, image.getWidth(),
						image.getHeight(), null, null);
			} else if (node instanceof Region) {
				// For regions, only drawing background is supported
				final Region n = (Region) node;
				if (n.getBackground() != null) {
					final Bounds layoutBounds = node.getLayoutBounds();
					for (final BackgroundFill f : n.getBackground().getFills()) {
						final Insets insets = f.getInsets();
						final Shape shape = new Rectangle.Double(layoutBounds.getMinX() + insets.getLeft(),
								layoutBounds.getMinY() + insets.getTop(),
								layoutBounds.getWidth() - insets.getLeft() - insets.getRight(),
								layoutBounds.getHeight() - insets.getTop() - insets.getBottom());
						draw(shape, tg, toAwt(f.getFill()), null, 1.0f, Collections.emptyList());
					}
				}
			} else {
				throw new AgeGefRuntimeException("Unexpected export node: " + node);
			}
		}
	}

	/**
	 * Draws a shape.
	 * This method attempts to draw shapes consistent with the usage of JavaFX in the graphical editor. However, when
	 * rendering non-SVG graphics, the stroke will be drawn along the shape's outline rather than inside of it. This is due
	 * to quality issues when attempting to draw the stroke inside by clipping along the outline.
	 * @param shape the shape to draw
	 * @param g2d the {@link Graphics2D} instance to use to draw the shape
	 * @param fill the paint for filling the shape. If null, the shape will not be filled.
	 * @param stroke the paint for stroking the shape. If null, the shape will not be stroked.
	 * @param strokeWidth the stroke width
	 * @param strokeDashArray the dash array that determines dash sizes. An empty list indicates a solid stroke.
	 */
	private static void draw(final Shape shape, final Graphics2D g2d, final java.awt.Paint fill,
			final java.awt.Paint stroke, final float strokeWidth, final List<Double> strokeDashArray) {

		// Clipping is used to draw the stroke along the inside. This only works properly for SVG graphics.
		// We assume non-filled shapes are likely connections or similar graphics and that they should not be clipped.
		// Clipping such graphics may result in them not visible.
		final boolean clip = g2d instanceof SVGGraphics2D && fill != null;
		if (clip) {
			g2d.setClip(shape);
		}

		if (fill != null) {
			g2d.setPaint(fill);
			g2d.fill(shape);
		}

		if (stroke != null) {
			// Convert stroke dash array list to a float array
			final float[] dashArray;
			if (strokeDashArray.isEmpty()) {
				dashArray = null;
			} else {
				dashArray = new float[strokeDashArray.size()];
				int i = 0;
				for (final Double value : strokeDashArray) {
					dashArray[i++] = value.floatValue();
				}
			}

			g2d.setStroke(new BasicStroke(g2d.getClip() == null ? strokeWidth : strokeWidth * 2.0f,
					BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashArray, 0.0f));
			g2d.setPaint(stroke);
			g2d.draw(shape);
		}

		if (clip) {
			g2d.setClip(null);
		}
	}

	private static Path2D.Double toAwt(final Path p) {
		final Path2D.Double result = new Path2D.Double(
				p.getFillRule() == FillRule.EVEN_ODD ? Path2D.WIND_EVEN_ODD : Path2D.WIND_NON_ZERO,
				p.getElements().size());

		double lastX = 0;
		double lastY = 0;
		for (final PathElement e : p.getElements()) {
			if (e instanceof ClosePath) {
				result.closePath();
			} else if (e instanceof HLineTo) {
				final HLineTo el = (HLineTo) e;
				lastX = el.getX();
				result.lineTo(lastX, lastY);
			} else if (e instanceof VLineTo) {
				final VLineTo el = (VLineTo) e;
				lastY = el.getY();
				result.lineTo(lastX, lastY);
			} else if (e instanceof LineTo) {
				final LineTo el = (LineTo) e;
				lastX = el.getX();
				lastY = el.getY();
				result.lineTo(lastX, lastY);
			} else if (e instanceof MoveTo) {
				final MoveTo el = (MoveTo) e;
				lastX = el.getX();
				lastY = el.getY();
				result.moveTo(lastX, lastY);
			} else if (e instanceof CubicCurveTo) {
				final CubicCurveTo el = (CubicCurveTo) e;
				lastX = el.getX();
				lastY = el.getY();
				result.curveTo(el.getControlX1(), el.getControlY1(), el.getControlX2(), el.getControlY2(), lastX,
						lastY);
			} else if (e instanceof QuadCurveTo) {
				final QuadCurveTo el = (QuadCurveTo) e;
				lastX = el.getX();
				lastY = el.getY();
				result.quadTo(el.getControlX(), el.getControlY(), lastX, lastY);
			} else if (e instanceof ArcTo) {
				// Path2D does not have an equivalent to ArcTo. However, it is not used the graphical editor.
				// If ArcTo is used it will need to be implemented.
				throw new AgeGefRuntimeException("Exporting ArcTo path segments is not supported.");
			} else {
				throw new AgeGefRuntimeException("Unexpected path element: " + e);
			}
		}

		return result;
	}

	private static CubicCurve2D.Double toAwt(final CubicCurve c) {
		return new CubicCurve2D.Double(c.getStartX(), c.getStartY(), c.getControlX1(), c.getControlY1(),
				c.getControlX2(), c.getControlY2(), c.getEndX(), c.getEndY());
	}

	private static Path2D.Double toAwtPath(final List<Double> points, final boolean polygon) {
		final Path2D.Double result = new Path2D.Double(Path2D.WIND_NON_ZERO, points.size());
		if (points.size() >= 4) {
			result.moveTo(points.get(0), points.get(1));
			for (int i = 2; i < (points.size() - 1); i += 2) {
				result.lineTo(points.get(i), points.get(i + 1));
			}

			if (polygon) {
				result.closePath();
			}
		}
		return result;
	}

	private static Shape toAwt(final javafx.scene.shape.Rectangle r) {
		final Bounds b = r.getLayoutBounds();
		return new RoundRectangle2D.Double(b.getMinX(), b.getMinY(), b.getWidth(), b.getHeight(), r.getArcWidth(),
				r.getArcHeight());
	}

	private static Shape toAwt(final Circle c) {
		final Bounds b = c.getLayoutBounds();
		return new Ellipse2D.Double(b.getMinX(), b.getMinY(), b.getWidth(), b.getHeight());
	}

	private static Shape toAwt(final javafx.scene.shape.Ellipse e) {
		final Bounds b = e.getLayoutBounds();
		return new Ellipse2D.Double(b.getMinX(), b.getMinY(), b.getWidth(), b.getHeight());
	}

	private static java.awt.Color toAwt(final javafx.scene.paint.Paint p) {
		if (p == null) {
			return null;
		} else if (p instanceof javafx.scene.paint.Color) {
			return toAwt((javafx.scene.paint.Color) p);
		} else {
			throw new AgeGefRuntimeException("Unsupported paint: " + p);
		}

	}

	private static java.awt.Color toAwt(final javafx.scene.paint.Color c) {
		if (c == null) {
			return null;
		} else {
			if (c.getOpacity() == 0.0) {
				return null;
			}

			return new java.awt.Color((float) c.getRed(), (float) c.getGreen(), (float) c.getBlue(),
					(float) c.getOpacity());
		}
	}

	private static java.awt.Font toAwt(final javafx.scene.text.Font font) {
		int style = 0;
		if (font.getStyle().contains("Bold")) {
			style |= Font.BOLD;
		}

		if (font.getStyle().contains("Italic")) {
			style |= Font.ITALIC;
		}

		return new java.awt.Font(font.getName(), style, (int) font.getSize()).deriveFont((float) font.getSize());
	}
}

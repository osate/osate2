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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
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
import javafx.geometry.Point2D;
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

// TODO: Document
// TODO: Only supports a subset of JavaFX nodes.. should be updated to match what is used. Shoudl document
public class GefDiagramExportService implements InternalDiagramExportService {
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

		// TODO; Selection only flag
		// TODO: Scaling flag
		/// TODO; Pass in selection as root in some cases
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
		return exportToImage(diagram, exportNode, diagram.getSceneNode().getSceneToLocalTransform(), scaling);
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

	// TODO: Rename
	// nodes is a flattened and ordered list of nodes.
	private static void paint(final List<Node> nodes, final Transform sceneToExportTransform, final double scaling,
			final Graphics2D g2d) {
		// Set rendering options
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

		// TODO
		g2d.scale(scaling, scaling);

		// TODO; Reference: https://www.codejava.net/java-se/graphics/drawing-lines-examples-with-graphics2d
		for (final Node node : nodes) {
			// final Graphics2D g2d = (Graphics2D) g2da.create();
			// TODO: Draw inside lines

			final Transform nodeToDiagramTransform = sceneToExportTransform
					.createConcatenation(node.getLocalToSceneTransform());

			final Bounds layoutBoundsInDiagram = nodeToDiagramTransform.transform(node.getLayoutBounds());
			// TODO: Not all shapes can be used as clipping

			// TODO: Rename
			// final Shape oldClip = g2d.getClip();
			// TODO; Problem with clipping is it is only guaranteed to work for rectangles
			// TODO; Use Area for clipping?
			// TODO; Just because it isn't guarantteed to work doesn't mean if doesn't work.. Try it...

			// TODO; Debugging bounds
			{
//				final Shape shape = new Rectangle.Double(layoutBoundsInDiagram.getMinX(),
//						layoutBoundsInDiagram.getMinY(), layoutBoundsInDiagram.getWidth(),
//						layoutBoundsInDiagram.getHeight());
//				draw(shape, g2d);
			}
			// TODO Circle didn't get called

			// TODO: Share code path for all basic shapes?
			if (node instanceof Path) {
				final Path n = (Path) node;
				draw(toAwt(n, nodeToDiagramTransform), g2d, toAwt(n.getFill()), toAwt(n.getStroke()),
						(float) n.getStrokeWidth(), n.getStrokeDashArray());
			} else if (node instanceof javafx.scene.shape.Rectangle) {
				final javafx.scene.shape.Rectangle n = (javafx.scene.shape.Rectangle) node;
				draw(toAwt(n, nodeToDiagramTransform), g2d, toAwt(n.getFill()), toAwt(n.getStroke()),
						(float) n.getStrokeWidth(), n.getStrokeDashArray());
			} else if (node instanceof javafx.scene.shape.Circle) {
				final javafx.scene.shape.Circle n = (javafx.scene.shape.Circle) node;
				draw(toAwt(n, nodeToDiagramTransform), g2d, toAwt(n.getFill()), toAwt(n.getStroke()),
						(float) n.getStrokeWidth(), n.getStrokeDashArray());
			} else if (node instanceof javafx.scene.shape.Ellipse) {
				final javafx.scene.shape.Ellipse n = (javafx.scene.shape.Ellipse) node;
				draw(toAwt(n, nodeToDiagramTransform), g2d, toAwt(n.getFill()), toAwt(n.getStroke()),
						(float) n.getStrokeWidth(), n.getStrokeDashArray());
			} else if (node instanceof CubicCurve) {
				// TODO; Note.. fill is hard coded to null here
				final CubicCurve n = (CubicCurve) node;
				draw(toAwt(n, nodeToDiagramTransform), g2d, null, toAwt(n.getStroke()), (float) n.getStrokeWidth(),
						n.getStrokeDashArray());
			} else if (node instanceof Polygon) {
				final javafx.scene.shape.Polygon n = (javafx.scene.shape.Polygon) node;
				draw(toAwtPath(n.getPoints(), true, nodeToDiagramTransform), g2d, toAwt(n.getFill()),
						toAwt(n.getStroke()), (float) n.getStrokeWidth(), n.getStrokeDashArray());
			} else if (node instanceof Polyline) {
				final javafx.scene.shape.Polyline n = (javafx.scene.shape.Polyline) node;
				// TODO; Note.. fill is hard coded to null here
				draw(toAwtPath(n.getPoints(), false, nodeToDiagramTransform), g2d, null, toAwt(n.getStroke()),
						(float) n.getStrokeWidth(), n.getStrokeDashArray());
			} else if (node instanceof Text) {
				// TODO; No clipping for text?
				final Text text = (Text) node;

				// TODO; Single code path..

				if (text.getWrappingWidth() > 0) {
					// TODO: Check if this is going to work
					final JTextArea ta = new JTextArea(text.getText());
					ta.setLineWrap(true);
					ta.setWrapStyleWord(true);
					// TODO.. alignment, etc
					// TODO: Needed?
					// TODO: Remove background?
					ta.setBackground(new java.awt.Color(0, 0, 0, 0)); // TODO: Should be constant
					ta.setBounds((int) layoutBoundsInDiagram.getMinX(), (int) layoutBoundsInDiagram.getMinY(),
							(int) layoutBoundsInDiagram.getWidth(), (int) text.getWrappingWidth()); // TODO: Correct?
					ta.setForeground(toAwt(text.getFill()));
					ta.setFont(toAwt(text.getFont()));
					// TODO: Don't use hard coded width and height
					Graphics g2 = g2d.create((int) layoutBoundsInDiagram.getMinX(),
							(int) layoutBoundsInDiagram.getMinY(), 1000, 1000);
					ta.paint(g2);
				} else {
					g2d.setFont(toAwt(text.getFont()));

					// TODO: WRAPPING

					g2d.setPaint(toAwt(text.getFill()));
					g2d.drawString(text.getText(), (int) layoutBoundsInDiagram.getMinX(),
							(int) (layoutBoundsInDiagram.getMinY() + text.getBaselineOffset()));
				}
			} else if (node instanceof ImageView) {
				final ImageView n = (ImageView) node;

				// TODO: Other options set on ImageVIew?
				// TODO: Draw in a way that scales to region
				// TODO: Does image view do centering... need to handle that
				final BufferedImage image = SwingFXUtils.fromFXImage(n.getImage(), null);
				// TODO: Centering.. avoid stretching, etc.. Is that alreayd handled?
				// TODO: need SwingFXUtils... no class... Part of target?
				g2d.drawImage(image, (int) layoutBoundsInDiagram.getMinX(), (int) layoutBoundsInDiagram.getMinY(),
						(int) layoutBoundsInDiagram.getMaxX(), (int) layoutBoundsInDiagram.getMaxY(), 0, 0,
						image.getWidth(), image.getHeight(), null, null); // TODO: Can other values be null?
				// n.getImage()
				// TODO: Draw image
				// g2d.drawi
			} else if (node instanceof Region) {
				// For regions, only drawing background is supported
				final Region n = (Region) node;
				if (n.getBackground() != null) {
					for (final BackgroundFill f : n.getBackground().getFills()) {
						final Insets insets = f.getInsets();
						final Shape shape = new Rectangle.Double(layoutBoundsInDiagram.getMinX() + insets.getLeft(),
								layoutBoundsInDiagram.getMinY() + insets.getTop(),
								layoutBoundsInDiagram.getWidth() - insets.getLeft() - insets.getRight(),
								layoutBoundsInDiagram.getHeight() - insets.getTop() - insets.getBottom());
						draw(shape, g2d, toAwt(f.getFill()), null, 1.0f, Collections.emptyList());
					}
				}
			} else {
				System.err.println("TODO: " + node); // TODO
				final Shape shape = new Rectangle.Double(layoutBoundsInDiagram.getMinX(),
						layoutBoundsInDiagram.getMinY(), layoutBoundsInDiagram.getWidth(),
						layoutBoundsInDiagram.getHeight());
				draw(shape, g2d, java.awt.Color.RED, java.awt.Color.BLUE, 1.0f, Collections.emptyList());
				// TODO: Unsupported
			}
		}
	}

	// TODO: Need arguments for style, etc
	private static void draw(final Shape shape, final Graphics2D g2d, final java.awt.Paint fill,
			final java.awt.Paint stroke, final float strokeWidth, final List<Double> strokeDashArray) { // TODO; Dash array

		// TODO: Clipping can cause problems with some paths.. is this a good solution?
		final boolean clip = fill != null && !(shape instanceof Ellipse2D.Double);

		// TODO: Clipping breaks connections! Decide how to handle... Clipping is needed to control line sizes
		// TODO Clipping doesn't work well for ellipses
		if (clip) {
			g2d.setClip(shape);
		}

		if (fill != null) {
			g2d.setPaint(fill);
			g2d.fill(shape);
		}

		if (stroke != null) {
			// TODO: Review behavior and compare with JavaFX. Document reasoning(clipping will cut half off)

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

	private static Path2D.Double toAwt(final Path p, final Transform nodeToDiagramTransform) {
		// TODO: Would it be better to use local coordinates and set the transform for rendering?

		final Path2D.Double result = new Path2D.Double(
				p.getFillRule() == FillRule.EVEN_ODD ? Path2D.WIND_EVEN_ODD : Path2D.WIND_NON_ZERO,
				p.getElements().size());

		// TODO: Need to be in scene coordinates
		double lastX = 0;
		double lastY = 0;
		for (final PathElement e : p.getElements()) {
			if (e instanceof ClosePath) {
				result.closePath();
			} else if (e instanceof HLineTo) {
				final HLineTo el = (HLineTo) e;
				lastX = el.getX();
				final Point2D tranformed = nodeToDiagramTransform.transform(lastX, lastY);
				result.lineTo(tranformed.getX(), tranformed.getY());
			} else if (e instanceof VLineTo) {
				final VLineTo el = (VLineTo) e;
				lastY = el.getY();
				final Point2D tranformed = nodeToDiagramTransform.transform(lastX, lastY);
				result.lineTo(tranformed.getX(), tranformed.getY());
			} else if (e instanceof LineTo) {
				final LineTo el = (LineTo) e;
				lastX = el.getX();
				lastY = el.getY();
				final Point2D tranformed = nodeToDiagramTransform.transform(lastX, lastY);
				result.lineTo(tranformed.getX(), tranformed.getY());
			} else if (e instanceof MoveTo) {
				final MoveTo el = (MoveTo) e;
				lastX = el.getX();
				lastY = el.getY();
				final Point2D tranformed = nodeToDiagramTransform.transform(lastX, lastY);
				result.moveTo(tranformed.getX(), tranformed.getY());
			} else if (e instanceof CubicCurveTo) {
				// TODO: Actually used...
				final CubicCurveTo el = (CubicCurveTo) e;
				lastX = el.getX();
				lastY = el.getY();
				final Point2D control1 = nodeToDiagramTransform.transform(el.getControlX1(), el.getControlY1());
				final Point2D control2 = nodeToDiagramTransform.transform(el.getControlX2(), el.getControlY2());
				final Point2D end = nodeToDiagramTransform.transform(lastX, lastY);
				result.curveTo(control1.getX(), control1.getY(), control2.getX(), control2.getY(), end.getX(),
						end.getY());
			} else if (e instanceof QuadCurveTo) {
				final QuadCurveTo el = (QuadCurveTo) e;
				lastX = el.getX();
				lastY = el.getY();
				final Point2D control = nodeToDiagramTransform.transform(el.getControlX(), el.getControlY());
				final Point2D end = nodeToDiagramTransform.transform(lastX, lastY);
				result.quadTo(control.getX(), control.getY(), end.getX(), end.getY());
			} else if (e instanceof ArcTo) {
				final ArcTo el = (ArcTo) e;
				// TODO
				System.err.println("NOT IMPLEMENTED: " + el);
			} else {
				// TODO
				System.err.println("NOT IMPLEMENTED: " + e);
			}
		}

		return result;
	}

	private static CubicCurve2D.Double toAwt(final CubicCurve c, final Transform nodeToDiagramTransform) {
		final Point2D p1 = nodeToDiagramTransform.transform(c.getStartX(), c.getStartY());
		final Point2D ctrl1 = nodeToDiagramTransform.transform(c.getControlX1(), c.getControlY1());
		final Point2D ctrl2 = nodeToDiagramTransform.transform(c.getControlX2(), c.getControlY2());
		final Point2D p2 = nodeToDiagramTransform.transform(c.getEndX(), c.getEndY());
		return new CubicCurve2D.Double(p1.getX(), p1.getY(), ctrl1.getX(), ctrl1.getY(), ctrl2.getX(), ctrl2.getY(),
				p2.getX(), p2.getY());
	}

	private static Path2D.Double toAwtPath(final List<Double> points, final boolean polygon,
			final Transform nodeToDiagramTransform) {
		final Path2D.Double result = new Path2D.Double(Path2D.WIND_NON_ZERO, points.size());
		if (points.size() >= 4) {
			final Point2D startPoint = nodeToDiagramTransform.transform(points.get(0), points.get(1));
			result.moveTo(startPoint.getX(), startPoint.getY());
			for (int i = 2; i < (points.size() - 1); i += 2) {
				final Point2D point = nodeToDiagramTransform.transform(points.get(i), points.get(i + 1));
				result.lineTo(point.getX(), point.getY());
			}

			if (polygon) {
				result.closePath();
			}
		}
		return result;
	}

	private static Shape toAwt(final javafx.scene.shape.Rectangle r, final Transform nodeToDiagramTransform) {
		final Bounds b = nodeToDiagramTransform.transform(r.getLayoutBounds());
		return new RoundRectangle2D.Double(b.getMinX(), b.getMinY(), b.getWidth(), b.getHeight(), r.getArcWidth(),
				r.getArcHeight());
	}

	private static Shape toAwt(final Circle c, final Transform nodeToDiagramTransform) {
		final Bounds b = nodeToDiagramTransform.transform(c.getLayoutBounds());
		return new Ellipse2D.Double(b.getMinX(), b.getMinY(), b.getWidth(), b.getHeight()); // TODO: Are others needed?
	}

	private static Shape toAwt(final javafx.scene.shape.Ellipse e, final Transform nodeToDiagramTransform) {
		final Bounds b = nodeToDiagramTransform.transform(e.getLayoutBounds());
		return new Ellipse2D.Double(b.getMinX(), b.getMinY(), b.getWidth(), b.getHeight()); // TODO: Are others needed?
	}

	private static java.awt.Color toAwt(final javafx.scene.paint.Paint p) {
		if (p == null) {
			return null;
		} else if (p instanceof javafx.scene.paint.Color) {
			return toAwt((javafx.scene.paint.Color) p);
		} else {
			// TODO
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

	// TODO: Need to cache? Avoid static? Check documentation for AWT font
	private static java.awt.Font toAwt(final javafx.scene.text.Font font) {
		int style = 0;
		if (font.getStyle().contains("Bold")) {
			style |= Font.BOLD;
		}

		if (font.getStyle().contains("Italic")) {
			style |= Font.ITALIC;
		}

		return new java.awt.Font(font.getName(), style, (int) font.getSize())
				.deriveFont((float) font.getSize());
	}

	// TODO; Rename?
	private static boolean isExportNode(final Node node) {
		// TODO: Check and add others as needed
		// TODO; Is there something inside the image view?
		return node instanceof Path || node instanceof CubicCurve || node instanceof Polyline || node instanceof Polygon
				|| node instanceof javafx.scene.shape.Rectangle || node instanceof Circle || node instanceof Ellipse
				|| node instanceof Text || node instanceof ImageView
				|| (node instanceof Region && ((Region) node).getBackground() != null);
	}

	// TODO: Rename
	private static List<Node> getExportNodes(final GefAgeDiagram diagram, final DiagramNode exportRootDiagramNode) {
		// final GefAgeDiagram diagram,
		final Node exportRootSceneNode = diagram.getSceneNode(exportRootDiagramNode);
		// TODO: Check for null
		final List<Node> exportNodes = new ArrayList<>();
		addNonConnectionExportNodes(exportRootSceneNode, exportRootSceneNode, exportNodes);
		addConnectionExportNodes(diagram.getSceneNode(), exportRootSceneNode, exportNodes);

		return exportNodes;
	}

	private static void addNonConnectionExportNodes(final Node node, final Node exportRoot, List<Node> nodes) {
		// Don't export connections
		if (node.isVisible()) {
			if (node instanceof Connection) {
				return;
			}

			// TODO; Consider ordering and connections.. want to be consistent with rendering behavior
			// TODO:
			if (isExportNode(node)) {
				nodes.add(node);
			}

			if (node instanceof Parent) {
				for (final Node child : ((Parent) node).getChildrenUnmodifiable()) {
					addNonConnectionExportNodes(child, exportRoot, nodes);
				}
			}
		}
	}

	private static void addConnectionExportNodes(final Node node, final Node exportRoot, List<Node> nodes) {
		// Don't export connections
		if (node.isVisible()) {
			// TODO: Check descendants
			if (node instanceof Connection) {
				final Connection cn = (Connection) node;

				// TODO; Check if both end points are contained in the export root
				if (!isExported(cn.getStartAnchor(), exportRoot) || !isExported(cn.getEndAnchor(), exportRoot)) {
					return;
				}

				for (final Node child : ((Parent) node).getChildrenUnmodifiable()) {
					addNonConnectionExportNodes(child, exportRoot, nodes);
				}
			} else if (node instanceof Parent) {
				for (final Node child : ((Parent) node).getChildrenUnmodifiable()) {
					addConnectionExportNodes(child, exportRoot, nodes);
				}
			}
		}
	}

	private static boolean isExported(final IAnchor anchor, final Node exportRoot) {
		if (anchor == null) {
			return false;
		}

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

	private static Bounds getBounds(final List<Node> nodes, final Transform sceneToDiagramTransform) {
		// TODO: Need to transform all these into diagram coordinates to avoid scaling affect when using live diagram....
		// TODO: Will need to shift at some point.. someone else can do that...

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

	private static void export(final GefAgeDiagram diagram, final DiagramNode exportRootDiagramNode,
			final Transform sceneToDiagramTransform, final double scaling, final OutputStream output,
			final String format) throws IOException {
		// Scaling is applied on the rendering side because otherwise font sizes are incorrect


		// TODO; Add a shift to the transform so that the left is 0,0... Sanity check

		// TODO: Build a list of scene graph nodes to export in order?

		// TODO; Need a way of getting dimension and also only exporting isnlge object..
		// TODO: Determine dimensions.. Walk whatever will be exported and get the entire bounds.. need to consider connections... can't just take top level

		// TODO: Scaling, etc

		if ("svg".equalsIgnoreCase(format)) {
			final List<Node> exportNodes = getExportNodes(diagram, exportRootDiagramNode);
			final Bounds bounds = getBounds(exportNodes, sceneToDiagramTransform);
			final Transform sceneToExportTransform = sceneToDiagramTransform
					.createConcatenation(Transform.translate(-bounds.getMinX(), -bounds.getMinY()));
			final Writer outWriter = new OutputStreamWriter(output, "UTF-8");
			generateSvg(exportNodes, sceneToExportTransform, scaling).stream(outWriter, false); // TODO
		} else {
			final BufferedImage image = exportToImage(diagram, exportRootDiagramNode, sceneToDiagramTransform, scaling);
			ImageIO.write(image, format, output);
		}
	}

	// TODO: Rename
	private static BufferedImage exportToImage(final GefAgeDiagram diagram, final DiagramNode exportRootDiagramNode,
			final Transform sceneToDiagramTransform, final double scaling) {
		final List<Node> exportNodes = getExportNodes(diagram, exportRootDiagramNode);
		final Bounds bounds = getBounds(exportNodes, sceneToDiagramTransform);
		final Transform sceneToExportTransform = sceneToDiagramTransform
				.createConcatenation(Transform.translate(-bounds.getMinX(), -bounds.getMinY()));

		final BufferedImage image = new BufferedImage((int) Math.ceil(bounds.getWidth() * scaling),
				(int) Math.ceil(bounds.getHeight() * scaling),
				BufferedImage.TYPE_INT_RGB);
		final Graphics2D graphics = image.createGraphics();
		graphics.setColor(new Color(255, 255, 255, 255));
		graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
		paint(exportNodes, sceneToExportTransform, scaling, graphics);
		return image;
	}


	// TODO; Add argument/variant to only export selection or some sort of filter from current diagram.
	private static SVGGraphics2D generateSvg(final List<Node> nodes, final Transform sceneToDiagramTransform,
			final double scaling) {
		// Get a DOMImplementation.
		DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();

		// Create an instance of org.w3c.dom.Document.
		String svgNS = "http://www.w3.org/2000/svg";
		Document doc = domImpl.createDocument(svgNS, "svg", null);

		// TODO; Context as imagehandler.. what is that?
		// TODO; https://svn.apache.org/repos/asf/xmlgraphics/site/deploy/batik/old/svggen.html

		// Create an instance of the SVG Generator.
		SVGGraphics2D svgGenerator = new SVGGraphics2D(doc);
		paint(nodes, sceneToDiagramTransform, scaling, svgGenerator);

		return svgGenerator;
	}

}

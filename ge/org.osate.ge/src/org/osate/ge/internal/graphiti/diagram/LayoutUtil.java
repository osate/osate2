package org.osate.ge.internal.graphiti.diagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IPath;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.util.IColorConstant;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.LabelPosition;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.internal.Label;
import org.osate.ge.graphics.internal.Poly;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.DockArea;
import org.osate.ge.internal.graphiti.AgeGraphicsAlgorithmRendererFactory;
import org.osate.ge.internal.graphiti.AnchorNames;
import org.osate.ge.internal.graphiti.ShapeNames;
import org.osate.ge.internal.graphiti.graphics.AgeGraphitiGraphicsUtil;

import com.google.common.base.Strings;

/**
 * Helper class for performing layout. Layout includes positioning child shapes and updating the graphics algorithm.
 *
 */
public class LayoutUtil {
	// All items are static
	private LayoutUtil() {
	}

	public final static int labelPadding = 3;

	private static class LayoutMetrics {
		int innerWidth = 30;
		int innerHeight = 10;
		int leftOuterPadding = 0;
		int rightOuterPadding = 0;
		int topOuterPadding = 0;
		int bottomOuterPadding = 0;

		// The minimum inner width and height are the minimum size for the graphics algorithm for the inner area.
		// In the case of fixed size graphics algorithms such as features, the actual size of the inner graphics algorithm's symbol will be less than
		// the minimum after creation. In that case, these values are used to adjust the bounds of the inner graphics algorithm after creation.
		int minInnerWidth = 0;
		int minInnerHeight = 0;

		// Returns the X coordinate for the right side of the inner region.
		int getInnerRight() {
			return leftOuterPadding + innerWidth;
		}

		// Returns the Y coordinate for the bottom side of the inner region.
		int getInnerBottom() {
			return topOuterPadding + innerHeight;
		}
	}

	public static void layoutDepthFirst(final Diagram graphitiDiagram, final DiagramModification mod,
			final AgeDiagram ageDiagram, final NodePictogramBiMap mapping) {
		for (final DiagramElement child : ageDiagram.getDiagramElements()) {
			layoutDepthFirst(graphitiDiagram, mod, child, mapping);
		}
	}

	public static void layoutDepthFirst(final Diagram graphitiDiagram, final DiagramModification mod,
			final DiagramElement element, final NodePictogramBiMap mapping) {
		for (final DiagramElement child : element.getDiagramElements()) {
			layoutDepthFirst(graphitiDiagram, mod, child, mapping);
		}

		// Get the pictogram element and lay it out if it is a shape
		final PictogramElement pe = mapping.getPictogramElement(element);
		if (pe instanceof ContainerShape) {
			layout(graphitiDiagram, mod, element, (ContainerShape) pe, mapping);
		} else if (pe instanceof Connection) {
			final Connection connection = (Connection) pe;

			// Center non-label decorators
			// Calculate the total non-label width
			final int nonLabelDecorationSpacing = 4;
			int totalNonLabelWidth = 0;
			for (final ConnectionDecorator cd : connection.getConnectionDecorators()) {
				final DiagramNode decoratorNode = mapping.getDiagramNode(cd);
				if (decoratorNode instanceof DiagramElement) {
					final DiagramElement decorationElement = (DiagramElement) decoratorNode;
					if (decorationElement.getGraphic() instanceof Poly) {
						final Poly poly = (Poly) decorationElement.getGraphic();
						AgeGraphitiGraphicsUtil.createGraphicsAlgorithm(graphitiDiagram, cd,
								decorationElement.getGraphic(), 1, 1, true, decorationElement.getStyle());
						totalNonLabelWidth += poly.right + nonLabelDecorationSpacing; // Extra padding is added to space decorations apart from each other
					}
				}
			}

			int nonLabelShiftX = -totalNonLabelWidth / 2;
			int labelY = 10;
			for (final ConnectionDecorator cd : connection.getConnectionDecorators()) {
				final DiagramNode decoratorNode = mapping.getDiagramNode(cd);
				if (decoratorNode instanceof DiagramElement) {
					final DiagramElement decorationElement = (DiagramElement) decoratorNode;

					// Special handling of labels.
					final IGaService gaService = Graphiti.getGaService();
					if (decorationElement.getGraphic() instanceof Label) {
						if (decorationElement.getLabelName() != null) {
							final Text text = gaService.createDefaultText(graphitiDiagram, cd);
							PropertyUtil.setIsStylingChild(text, true);
							text.setValue(decorationElement.getLabelName());
							TextUtil.setStyleAndSize(graphitiDiagram, text, decorationElement.getStyle().getFontSize());
							if (decorationElement.hasPosition()) {
								gaService.setLocation(text, (int) Math.round(decorationElement.getX()),
										(int) Math.round(decorationElement.getY()));
							} else {
								text.setX(-text.getWidth() / 2);
								text.setY(labelY);
							}

							mod.setSize(decorationElement, new Dimension(text.getWidth(), text.getHeight()));

							// Set the next label position based on the position of this label
							labelY += 15;
						}
					} else if (decorationElement.getGraphic() instanceof Poly) {
						final Poly poly = (Poly) decorationElement.getGraphic();
						final org.eclipse.graphiti.mm.algorithms.Polyline polyline = (org.eclipse.graphiti.mm.algorithms.Polyline) AgeGraphitiGraphicsUtil
								.createGraphicsAlgorithm(graphitiDiagram, cd, decorationElement.getGraphic(), 1, 1,
										true, decorationElement.getStyle());
						for (Point p : polyline.getPoints()) {
							p.setX(p.getX() + nonLabelShiftX);
						}

						nonLabelShiftX += Math.ceil(poly.right) + nonLabelDecorationSpacing;
					} else {
						throw new RuntimeException(
								"Unsupported connection child graphic: " + decorationElement.getGraphic());
					}
				}
			}
		}
	}

	/**
	 * Lays out a shape associated with a diagram element.
	 * The layout process includes positioning children, ensuring the element is sized properly, and updating the graphics algorithm for the shape.
	 * @param graphitiDiagram
	 * @param element
	 * @param shape
	 * @param diagramNodeProvider
	 */
	public static void layout(final Diagram graphitiDiagram, final DiagramModification mod,
			final DiagramElement element, final ContainerShape shape, final NodePictogramBiMap diagramNodeProvider) {
		final LabelPosition horizontalLabelPositionFromStyle = element.getGraphicalConfiguration().style
				.getHorizontalLabelPosition() == null ? Style.DEFAULT.getHorizontalLabelPosition()
						: element.getGraphicalConfiguration().style.getHorizontalLabelPosition();
				final LabelPosition verticalLabelPositionFromStyle = element.getGraphicalConfiguration().style
						.getVerticalLabelPosition() == null ? Style.DEFAULT.getVerticalLabelPosition()
								: element.getGraphicalConfiguration().style.getVerticalLabelPosition();

						final GraphicsAlgorithm shapeGa = shape.getGraphicsAlgorithm();
						shapeGa.setStyle(null); // Remove reference to Graphiti style.

						final Graphic gr = element.getGraphic();

						// Determine the space needed for each area
						final int dockedShapeOffset = AgeGraphitiGraphicsUtil.featureGroupDefaultSymbolWidth; // For now, only graphics which represent feature groups may have
						// shape docked at the GROUP dock area.

						final LayoutMetrics lm = new LayoutMetrics();

						final Shape nameShape = getChildShapeByName(shape, ShapeNames.primaryLabelShapeName);
						final DockArea shapeDockArea = getNonGroupDockArea(element);

						// Build a list of all the labels. These labels will be positioned based on the name label configuration
						final List<Shape> decorationShapes = new ArrayList<Shape>();
						if (nameShape != null) {
							decorationShapes.add(nameShape);
						}
						decorationShapes.addAll(getChildShapesByName(shape, ShapeNames.annotationShapeName));

						// Add decoration shapes to the list. Sort them by name so that labels will be ordered consistently.
						element.getDiagramElements().stream().filter(childElement -> childElement.isDecoration()).sorted((ce1,
								ce2) -> Strings.nullToEmpty(ce1.getLabelName()).compareToIgnoreCase(Strings.nullToEmpty(ce2.getLabelName())))
						.forEachOrdered(childElement -> {
							final PictogramElement decorationPictogramElement = diagramNodeProvider
									.getPictogramElement(childElement);
							if (decorationPictogramElement instanceof Shape) {
								decorationShapes.add((Shape) decorationPictogramElement);
							}
						});

						// Determine the size needs for the labels
						int totalLabelsWidth = 0;
						int totalLabelsHeight = 0;
						for (final Shape labelShape : decorationShapes) {
							totalLabelsWidth = Math.max(totalLabelsWidth, labelShape.getGraphicsAlgorithm().getWidth());
							totalLabelsHeight += Math.max(0, labelShape.getGraphicsAlgorithm().getHeight());
						}

						// Adjust label position if the shape is docked
						LabelPosition nameHorizontalPosition = getHorizontalLabelPosition(horizontalLabelPositionFromStyle,
								verticalLabelPositionFromStyle, shapeDockArea);
						LabelPosition nameVerticalPosition = getVerticalLabelPosition(horizontalLabelPositionFromStyle,
								verticalLabelPositionFromStyle, shapeDockArea);

						// Update the layout metrics to ensure there is room for all the labels
						final int actualLabelPaddingY = element.getGraphic() instanceof Label ? 0 : labelPadding; // Don't pad vertically if the shape consists of only a label
						updateLayoutMetricsForLabelPositions(lm, nameHorizontalPosition, nameVerticalPosition,
								totalLabelsWidth + labelPadding, totalLabelsHeight + actualLabelPaddingY);

						// Adjust inner width and height based on padding and current size
						if (!(element.getGraphic() instanceof Label)) { // Ignore labels because labels should shrink to their minimum size.
							lm.innerWidth = Math.max(lm.innerWidth, shapeGa.getWidth() - lm.leftOuterPadding - lm.rightOuterPadding);
							lm.innerHeight = Math.max(lm.innerHeight, shapeGa.getHeight() - lm.topOuterPadding - lm.bottomOuterPadding);
						}

						// Prevent children from being positioned outside of the inner area
						for (final Shape childShape : shape.getChildren()) {
							if (!PropertyUtil.isManuallyPositioned(childShape)) {
								final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
								if (childGa != null) {
									if (childGa.getX() < lm.leftOuterPadding) {
										childGa.setX(lm.leftOuterPadding);
									}

									if (childGa.getY() < lm.topOuterPadding) {
										childGa.setY(lm.topOuterPadding);
									}
								}
							}
						}

						// Group feature shapes based on docking area
						final Map<DockArea, List<Shape>> dockAreaToShapesMap = buildDockAreaToChildrenMap(shape);
						// Adjust shapes so they do not overlap
						cleanupOverlappingDockedShapes(shapeDockArea, dockAreaToShapesMap, diagramNodeProvider);

						// Handle positioning of group docked shapes
						for (final Entry<DockArea, List<Shape>> dockAreaToShapesEntry : dockAreaToShapesMap.entrySet()) {
							if (dockAreaToShapesEntry.getKey() == DockArea.GROUP) {
								for (final Shape childShape : dockAreaToShapesEntry.getValue()) {
									switch (shapeDockArea) {
									case LEFT:
									case RIGHT:
										lm.minInnerWidth = Math.max(lm.minInnerWidth,
												childShape.getGraphicsAlgorithm().getWidth() + dockedShapeOffset);
										break;

									case TOP:
									case BOTTOM:
										lm.minInnerHeight = Math.max(lm.minInnerHeight,
												childShape.getGraphicsAlgorithm().getHeight() + dockedShapeOffset);
										break;

									default:
										break;
									}
								}
							}
						}
						lm.innerWidth = Math.max(lm.innerWidth, lm.minInnerWidth);
						lm.innerHeight = Math.max(lm.innerHeight, lm.minInnerHeight);

						// Consider children when determining size
						final int[] minSizeForChildren = getMinimumSizeForChildren(shape, lm.leftOuterPadding, lm.topOuterPadding);
						lm.innerWidth = Math.max(lm.innerWidth, minSizeForChildren[0]);
						lm.innerHeight = Math.max(lm.innerHeight, minSizeForChildren[1]);

						// Create the graphics algorithm
						shapeGa.getGraphicsAlgorithmChildren().clear();

						final GraphicsAlgorithm innerGa;
						// Adjust the size of the graphics algorithm based on the rotation implied by the dock area
						if (shapeDockArea == DockArea.TOP || shapeDockArea == DockArea.BOTTOM) {
							innerGa = AgeGraphitiGraphicsUtil.createGraphicsAlgorithm(graphitiDiagram, shapeGa, gr, lm.innerHeight,
									lm.innerWidth, true, element.getGraphicalConfiguration().style);
						} else {
							// Check if diagram element is an image figure
							if (DiagramElementPredicates.supportsImage(element)
									&& Boolean.TRUE.equals(element.getStyle().getShowAsImage())) {
								innerGa = GraphitiUi.getGaService().createPlatformGraphicsAlgorithm(shapeGa,
										AgeGraphicsAlgorithmRendererFactory.IMAGE_FIGURE);
								innerGa.setWidth(lm.innerWidth);
								innerGa.setHeight(lm.innerHeight);
								// Initialize for style overrides
								innerGa.setForeground(GraphitiUi.getGaService().manageColor(graphitiDiagram, IColorConstant.BLACK));
								innerGa.setBackground(GraphitiUi.getGaService().manageColor(graphitiDiagram, IColorConstant.WHITE));
								PropertyUtil.setIsStylingChild(innerGa, true);
								final IPath imagePath = element.getStyle().getImagePath();
								PropertyUtil.setImage(innerGa, imagePath.toPortableString());
							} else {
								innerGa = AgeGraphitiGraphicsUtil.createGraphicsAlgorithm(graphitiDiagram, shapeGa, gr, lm.innerWidth,
										lm.innerHeight, true, element.getGraphicalConfiguration().style);
							}
						}

						// Rotate shape
						if (shapeDockArea != null) {
							AgeGraphitiGraphicsUtil.rotate(innerGa, shapeDockArea);
						}

						// Update variables using actual size of inner graphics algorithm
						lm.innerWidth = Math.max(innerGa.getWidth(), lm.minInnerWidth);
						lm.innerHeight = Math.max(innerGa.getHeight(), lm.minInnerHeight);

						// Update the shape's graphics algorithm based on required size
						final int innerRight = lm.getInnerRight();
						final int innerBottom = lm.getInnerBottom();
						shapeGa.setWidth(innerRight + lm.rightOuterPadding);
						shapeGa.setHeight(innerBottom + lm.bottomOuterPadding);

						// Only adjust the size of an element if it doesn't have a size. If it doens't already have a size, the incremental layout will handle it.
						if (!DiagramElementPredicates.isResizeable(element) || element.hasSize()) {
							mod.setSize(element,
									new org.osate.ge.graphics.Dimension(shapeGa.getWidth(), shapeGa.getHeight()));
						}
						// Position docked shapes
						for (final Entry<DockArea, List<Shape>> dockAreaToShapesEntry : dockAreaToShapesMap.entrySet()) {
							for (final Shape childShape : dockAreaToShapesEntry.getValue()) {
								if (dockAreaToShapesEntry.getKey() == DockArea.LEFT) {
									childShape.getGraphicsAlgorithm().setX(lm.leftOuterPadding);
								} else if (dockAreaToShapesEntry.getKey() == DockArea.RIGHT) {
									childShape.getGraphicsAlgorithm().setX(innerRight - childShape.getGraphicsAlgorithm().getWidth());
								} else if (dockAreaToShapesEntry.getKey() == DockArea.TOP) {
									childShape.getGraphicsAlgorithm().setY(lm.topOuterPadding);
								} else if (dockAreaToShapesEntry.getKey() == DockArea.BOTTOM) {
									childShape.getGraphicsAlgorithm().setY(innerBottom - childShape.getGraphicsAlgorithm().getHeight());
								} else if (dockAreaToShapesEntry.getKey() == DockArea.GROUP) {
									final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
									switch (shapeDockArea) {
									case LEFT:
									default:
										childGa.setX(dockedShapeOffset);
										break;

									case RIGHT:
										childGa.setX(lm.innerWidth - dockedShapeOffset - childGa.getWidth());
										break;

									case TOP:
										childGa.setY(dockedShapeOffset);
										break;

									case BOTTOM:
										childGa.setY(innerBottom - dockedShapeOffset - childGa.getHeight());
										break;
									}
								}
							}
						}

						// Position the inner graphics algorithm
						if (shapeDockArea == DockArea.RIGHT) {
							innerGa.setX(innerRight - innerGa.getWidth());
							innerGa.setY(lm.topOuterPadding);
						} else if (shapeDockArea == DockArea.BOTTOM) {
							innerGa.setX(lm.leftOuterPadding);
							innerGa.setY(innerBottom - innerGa.getHeight());
						} else {
							innerGa.setX(lm.leftOuterPadding);
							innerGa.setY(lm.topOuterPadding);
						}

						// Create an anchor which is used for flow specifications
						if (shapeDockArea != null) {
							org.osate.ge.graphics.Point interiorAnchorPosition;
							org.osate.ge.graphics.Point exteriorAnchorPosition;
							final org.osate.ge.graphics.Point flowSpecAnchorPosition;
							final int flowSpecOffsetLength = 50;
							final int interiorExteriorOffset = 0; // Adjustment so that connections will reach all the way to the appropriate connection point.
							switch (shapeDockArea) {
							case LEFT:
								interiorAnchorPosition = new org.osate.ge.graphics.Point(
										innerGa.getX() + innerGa.getWidth() - interiorExteriorOffset,
										innerGa.getY() + (innerGa.getHeight() / 2));
								exteriorAnchorPosition = new org.osate.ge.graphics.Point(innerGa.getX() + interiorExteriorOffset,
										interiorAnchorPosition.y);
								flowSpecAnchorPosition = new org.osate.ge.graphics.Point(
										interiorAnchorPosition.x + flowSpecOffsetLength, interiorAnchorPosition.y);
								break;

							case RIGHT:
								interiorAnchorPosition = new org.osate.ge.graphics.Point(innerGa.getX() + interiorExteriorOffset,
										innerGa.getY() + (innerGa.getHeight() / 2));
								exteriorAnchorPosition = new org.osate.ge.graphics.Point(
										innerGa.getX() + innerGa.getWidth() - interiorExteriorOffset, interiorAnchorPosition.y);
								flowSpecAnchorPosition = new org.osate.ge.graphics.Point(
										interiorAnchorPosition.x - flowSpecOffsetLength, interiorAnchorPosition.y);
								break;

							case TOP:
								interiorAnchorPosition = new org.osate.ge.graphics.Point(innerGa.getX() + (innerGa.getWidth() / 2),
										innerGa.getY() + innerGa.getHeight() - interiorExteriorOffset);
								exteriorAnchorPosition = new org.osate.ge.graphics.Point(interiorAnchorPosition.x,
										innerGa.getY() + interiorExteriorOffset);
								flowSpecAnchorPosition = new org.osate.ge.graphics.Point(interiorAnchorPosition.x,
										interiorAnchorPosition.y + flowSpecOffsetLength);
								break;

							case BOTTOM:
								interiorAnchorPosition = new org.osate.ge.graphics.Point(innerGa.getX() + (innerGa.getWidth() / 2),
										innerGa.getY() + interiorExteriorOffset);
								exteriorAnchorPosition = new org.osate.ge.graphics.Point(interiorAnchorPosition.x,
										innerGa.getY() + innerGa.getHeight() - interiorExteriorOffset);
								flowSpecAnchorPosition = new org.osate.ge.graphics.Point(interiorAnchorPosition.x,
										interiorAnchorPosition.y - flowSpecOffsetLength);
								break;

							default:
								interiorAnchorPosition = new org.osate.ge.graphics.Point(
										innerGa.getX() + innerGa.getWidth() - interiorExteriorOffset,
										innerGa.getY() + (innerGa.getHeight() / 2));
								exteriorAnchorPosition = new org.osate.ge.graphics.Point(innerGa.getX() + interiorExteriorOffset,
										interiorAnchorPosition.y);
								flowSpecAnchorPosition = new org.osate.ge.graphics.Point(0, 0);
								break;
							}

							AnchorUtil.createOrUpdateFixPointAnchor(shape, AnchorNames.FLOW_SPECIFICATION,
									(int) flowSpecAnchorPosition.x, (int) flowSpecAnchorPosition.y, true);

							AnchorUtil.createOrUpdateFixPointAnchor(shape, AnchorNames.INTERIOR_ANCHOR, (int) interiorAnchorPosition.x,
									(int) interiorAnchorPosition.y, true);

							AnchorUtil.createOrUpdateFixPointAnchor(shape, AnchorNames.EXTERIOR_ANCHOR, (int) exteriorAnchorPosition.x,
									(int) exteriorAnchorPosition.y, true);
						}

						// Determine the Y position for the labels
						int labelsY;
						switch (nameVerticalPosition) {
						case BEFORE_GRAPHIC:
							labelsY = 0;
							break;

						case GRAPHIC_BEGINNING:
						default:
							labelsY = lm.topOuterPadding + actualLabelPaddingY;
							break;

						case GRAPHIC_CENTER:
							final int centeringOffsetY = AgeGraphitiGraphicsUtil.getCenteringOffsetY(gr); // Adjustment for cases such as initial modes to make labels centered
							// around the inner shape.
							labelsY = lm.topOuterPadding + centeringOffsetY
									+ ((lm.innerHeight - centeringOffsetY) - totalLabelsHeight) / 2;
							break;

						case GRAPHIC_END:
							labelsY = innerBottom - totalLabelsHeight - actualLabelPaddingY;
							break;

						case AFTER_GRAPHIC:
							labelsY = innerBottom;
							break;
						}

						// Position Labels
						// All labels are positioned together on separate lines.
						// Labels are positioned horizontally based on the name label configuration.
						for (final Shape labelShape : decorationShapes) {
							final GraphicsAlgorithm labelGa = labelShape.getGraphicsAlgorithm();
							labelGa.setX(calculateLabelX(lm, nameHorizontalPosition, labelGa.getWidth()));
							labelGa.setY(labelsY);
							labelsY += labelGa.getHeight();
						}

						// Update the position of child diagram elements.
						for (final DiagramElement child : element.getDiagramElements()) {
							final PictogramElement childPe = diagramNodeProvider.getPictogramElement(child);
							// Only update the child's position if it already has a position. Otherwise, it may not have been layed out yet.
							if (child.hasPosition() && childPe instanceof Shape && childPe.getGraphicsAlgorithm() != null) {
								final GraphicsAlgorithm childGa = childPe.getGraphicsAlgorithm();
								final DockArea oldDockArea = child.getDockArea();
								mod.setPosition(child, new org.osate.ge.graphics.Point(childGa.getX(), childGa.getY()));
								mod.setDockArea(child, oldDockArea); // Prevent changing the dock area when positioning the shape.
							}
						}

	}

	/**
	 * Determine the x coordinate for a label
	 * @param lm the layout metrics which define the size of regions of the shape.
	 * @param horizontalLabelPosition describe how to position the labels
	 * @param labelWidth is the width of the label
	 * @return the x coordinate of the label
	 */
	private static int calculateLabelX(final LayoutMetrics lm, final LabelPosition horizontalLabelPosition,
			final int labelWidth) {
		switch (horizontalLabelPosition) {
		case BEFORE_GRAPHIC:
			return 0;

		case GRAPHIC_BEGINNING:
		default:
			return lm.leftOuterPadding + labelPadding;

		case GRAPHIC_CENTER:
			return lm.leftOuterPadding + (lm.innerWidth - labelWidth) / 2;

		case GRAPHIC_END:
			return lm.getInnerRight() - labelWidth - labelPadding;

		case AFTER_GRAPHIC:
			return lm.getInnerRight();
		}
	}

	private static void updateLayoutMetricsForLabelPositions(final LayoutMetrics lm,
			final LabelPosition nameHorizontalPosition, final LabelPosition nameVerticalPosition,
			final int totalLabelsWidth, final int totalLabelsHeight) {
		// Handle label configuration
		switch (nameHorizontalPosition) {
		case BEFORE_GRAPHIC:
			lm.leftOuterPadding = Math.max(lm.leftOuterPadding, totalLabelsWidth);
			break;

		case GRAPHIC_BEGINNING:
		case GRAPHIC_CENTER:
		case GRAPHIC_END:
		default:
			lm.minInnerWidth = Math.max(lm.minInnerWidth, totalLabelsWidth);
			break;

		case AFTER_GRAPHIC:
			lm.rightOuterPadding = Math.max(lm.rightOuterPadding, totalLabelsWidth);
			break;
		}

		// Set Y value based on the label configuration
		switch (nameVerticalPosition) {
		case BEFORE_GRAPHIC:
			lm.topOuterPadding = Math.max(lm.topOuterPadding, totalLabelsHeight);
			break;

		case GRAPHIC_BEGINNING:
		case GRAPHIC_CENTER:
		case GRAPHIC_END:
		default:
			lm.minInnerHeight = Math.max(lm.minInnerHeight, totalLabelsHeight);
			break;

		case AFTER_GRAPHIC:
			lm.bottomOuterPadding = Math.max(lm.bottomOuterPadding, totalLabelsHeight);
			break;
		}
	}

	// Determines the horizontal label position. Transforms the positions specified by the business object handler based on the dock area.
	private static LabelPosition getHorizontalLabelPosition(final LabelPosition horizontalPosition,
			final LabelPosition verticalPosition, final DockArea shapeDockArea) {
		if (shapeDockArea == null) {
			return horizontalPosition;
		}

		switch (shapeDockArea) {
		case LEFT:
			return horizontalPosition;

		case RIGHT:
			return horizontalPosition.mirror();

		case TOP:
			return verticalPosition;

		case BOTTOM:
			return verticalPosition;

		default:
			return horizontalPosition;
		}
	}

	// Determines the vertical label position. Transforms the positions specified by the business object handler based on the dock area.
	private static LabelPosition getVerticalLabelPosition(final LabelPosition horizontalPosition,
			final LabelPosition verticalPosition, final DockArea shapeDockArea) {
		if (shapeDockArea == null) {
			return verticalPosition;
		}

		switch (shapeDockArea) {
		case LEFT:
			return verticalPosition;

		case RIGHT:
			return verticalPosition;

		case TOP:
			return horizontalPosition;

		case BOTTOM:
			return horizontalPosition.mirror();

		default:
			return verticalPosition;
		}
	}

	private static int[] getMinimumSizeForChildren(final ContainerShape shape, final int innerLeftX,
			final int innerTopY) {
		// Calculate max right and bottom
		int maxRight = 0;
		int maxBottom = 0;
		for (final Shape childShape : shape.getChildren()) {
			if (childShape.isVisible()) {
				if (!PropertyUtil.isManuallyPositioned(childShape) && PropertyUtil.isLayedOut(childShape)) {
					final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
					final DockArea childDockArea = PropertyUtil.getDockArea(childShape);
					if (childDockArea == null || childDockArea == DockArea.GROUP) {
						maxRight = Math.max(maxRight, childGa.getX() + childGa.getWidth());
						maxBottom = Math.max(maxBottom, childGa.getY() + childGa.getHeight());
					} else {
						switch (childDockArea) {
						case LEFT:
						case RIGHT:
							maxRight = Math.max(maxRight, innerLeftX + childGa.getWidth());
							maxBottom = Math.max(maxBottom, childGa.getY() + childGa.getHeight());
							break;
						case TOP:
						case BOTTOM:
							maxRight = Math.max(maxRight, childGa.getX() + childGa.getWidth());
							maxBottom = Math.max(maxBottom, innerTopY + childGa.getHeight());
							break;
						default:
							break;
						}
					}
				}
			}
		}

		return new int[] { maxRight - innerLeftX, maxBottom - innerTopY };
	}

	/**
	 * Returns the first dock area that isn't the group dock area. Checks the specified shape and then ancestors.
	 * @param shape
	 * @return
	 */
	private static DockArea getNonGroupDockArea(DiagramNode diagramNode) {
		DockArea result = null;
		do {
			if (!(diagramNode instanceof DiagramElement)) {
				result = null;
				break;
			}

			result = ((DiagramElement) diagramNode).getDockArea();
			diagramNode = diagramNode.getContainer();
		} while (result != null && result == DockArea.GROUP);

		return result;
	}

	private final static Comparator<Shape> xComparator = (s1, s2) -> {
		if (s1.getGraphicsAlgorithm() == null) {
			return -1;
		} else if (s2.getGraphicsAlgorithm() == null) {
			return 1;
		}

		return Integer.compare(s1.getGraphicsAlgorithm().getX(), s2.getGraphicsAlgorithm().getX());
	};

	private final static Comparator<Shape> yComparator = (s1, s2) -> {
		if (s1.getGraphicsAlgorithm() == null) {
			return -1;
		} else if (s2.getGraphicsAlgorithm() == null) {
			return 1;
		}

		return Integer.compare(s1.getGraphicsAlgorithm().getY(), s2.getGraphicsAlgorithm().getY());
	};

	private static void cleanupOverlappingDockedShapes(final DockArea parentNonGroupDockArea,
			final Map<DockArea, List<Shape>> dockAreaToShapesMap, final NodePictogramBiMap diagramNodeProvider) {
		for (final Entry<DockArea, List<Shape>> dockAreaToShapesEntry : dockAreaToShapesMap.entrySet()) {
			if (dockAreaToShapesEntry.getKey() != null) {
				// Determine the orientation of the docked shapes
				DockArea dockArea = dockAreaToShapesEntry.getKey();
				if (dockArea == DockArea.GROUP) {
					dockArea = parentNonGroupDockArea;
				}

				final boolean vertical;
				if (dockArea == DockArea.LEFT || dockArea == DockArea.RIGHT) {
					vertical = true;
				} else if (dockArea == DockArea.TOP || dockArea == DockArea.BOTTOM) {
					vertical = false;
				} else {
					vertical = true;
				}

				// Sort shapes by order. Ignore shapes that haven't been layed out
				final List<Shape> sortedShapes = dockAreaToShapesEntry.getValue().stream().filter(s -> {
					final DiagramNode dn = diagramNodeProvider.getDiagramNode(s);
					if (!(dn instanceof DiagramElement)) {
						return false;
					}

					final DiagramElement de = (DiagramElement) dn;
					return de.hasPosition() || de.getDockArea() == DockArea.GROUP;
				}).collect(Collectors.toList());

				if (vertical) {
					Collections.sort(sortedShapes, yComparator);
					int minY = 0;
					for (Shape shape : sortedShapes) {
						if (shape.getGraphicsAlgorithm() != null) {
							final int newY = Math.max(shape.getGraphicsAlgorithm().getY(), minY);
							shape.getGraphicsAlgorithm().setY(newY);
							minY = newY + shape.getGraphicsAlgorithm().getHeight() + 5;
						}
					}
				} else {
					Collections.sort(sortedShapes, xComparator);
					int minX = 0;
					for (Shape shape : sortedShapes) {
						if (shape.getGraphicsAlgorithm() != null) {
							final int newX = Math.max(shape.getGraphicsAlgorithm().getX(), minX);
							shape.getGraphicsAlgorithm().setX(newX);
							minX = newX + shape.getGraphicsAlgorithm().getWidth() + 5;
						}
					}
				}

				// Nested docked feature need to be marked as layed out since the layout algorithm does not handle them.
				// This ensures they are taken into account when determining minimum size
				if (dockAreaToShapesEntry.getKey() == DockArea.GROUP) {
					for (Shape shape : sortedShapes) {
						PropertyUtil.setIsLayedOut(shape, true);
					}
				}
			}
		}
	}

	/**
	 * Builds a mapping between DockArea as returned by getDockArea(String) and a list of child shapes.
	 * @param shape
	 * @return
	 */
	private static Map<DockArea, List<Shape>> buildDockAreaToChildrenMap(final ContainerShape shape) {
		// Build mapping from dock area to shapes
		final Map<DockArea, List<Shape>> result = new HashMap<DockArea, List<Shape>>();
		for (final Shape child : shape.getChildren()) {
			final DockArea dockArea = PropertyUtil.getDockArea(child);
			if (dockArea != null) {
				List<Shape> dockAreaShapes = result.get(dockArea);

				// Create a new list if the shape is the first shape in the dock area
				if (dockAreaShapes == null) {
					dockAreaShapes = new ArrayList<Shape>();
					result.put(dockArea, dockAreaShapes);
				}

				dockAreaShapes.add(child);
			}
		}

		return result;
	}

	public static Shape getChildShapeByName(final ContainerShape shape, final String name) {
		return ShapeUtil.getShapeByName(shape.getChildren(), name);
	}

	private static List<Shape> getChildShapesByName(ContainerShape shape, String name) {
		final List<Shape> results = new ArrayList<Shape>();
		for (final Shape child : shape.getChildren()) {
			if (name.equals(PropertyUtil.getName(child))) {
				results.add(child);
			}
		}

		return results;
	}
}

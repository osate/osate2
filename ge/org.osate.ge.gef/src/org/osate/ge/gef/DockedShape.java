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
package org.osate.ge.gef;

import java.util.List;

import org.eclipse.gef.fx.anchors.IAnchor;
import org.eclipse.gef.fx.anchors.StaticAnchor;
import org.eclipse.gef.geometry.convert.fx.FX2Geometry;
import org.eclipse.gef.geometry.planar.IGeometry;
import org.eclipse.gef.geometry.planar.Point;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

/**
 * {@link Node} implementation which is intended to be docked to a side of a container or placed inside of
 * another {@link DockedShape}.
 *
 * When a child {@link DockedShape} is added to {@link #getNestedChildren()}, the side of the child is bound to the
 * side of the parent instance.
 *
 * The node will be resizable if the graphic is resizable. The preferred and minimum sizes will be such that
 * the node will accommodate the preferred size of all labels and nested {@link DockedNodes}. The docked shape
 * will only resize the graphic in the direction that nested shapes are positioned.
 *
 * The configured graphic will be rotated based on the side to which the shape is contained.
 *
 * Labels and nested {@link DockedShape} instances are laid out based on the configured {@link DockSide}
 * The preferred position of nested children can be set using {@link PreferredPosition#set(Node, Point2D)}.
 */
public class DockedShape extends Region
		implements ChopBoxGeometryProvider, Stylable, HasLabelBackgroundColor, ConfigureSize {
	/**
	 * Padding at the bottom of the area containing all labels
	 */
	private static final double VERTICAL_LABEL_PADDING = 3;

	/**
	 * Indicates that a value has not been specified. Used to indicate the lack of a configured width or height.
	 */
	public static double NOT_SPECIFIED = -1;

	private ObjectProperty<DockSide> side = new SimpleObjectProperty<DockSide>(DockSide.LEFT);
	private final Group graphicWrapper = new Group();
	private final Group primaryLabels = new Group();
	private final Group secondaryLabels = new Group();
	private final Group[] labelGroups = new Group[] { primaryLabels, secondaryLabels };
	private final DockedNodes dockedChildren = new DockedNodes(getSide(), this::computeMinimumNestedChildPosition);
	private final StaticAnchor interiorAnchor = new StaticAnchor(graphicWrapper,
			new org.eclipse.gef.geometry.planar.Point(0.0, 0.0));
	private final StaticAnchor exteriorAnchor = new StaticAnchor(graphicWrapper,
			new org.eclipse.gef.geometry.planar.Point(0.0, 0.0));

	/**
	 * The preferred width of the shape as specified by the the application.
	 * Used as the preferred width as long as it is greater than the minimum width and resizing is supported in that dimension.
	 */
	private double configuredWidth = NOT_SPECIFIED;

	/**
	 * The preferred height of the shape as specified by the the application.
	 * Used as the preferred height as long as it is greater than the minimum height and resizing is supported in that dimension.
	 */
	private double configuredHeight = NOT_SPECIFIED;

	/**
	 * Listener that binds the side of the child docked shape to the side of this docked shape.
	 */
	private class ChildListener implements ListChangeListener<DockedShape> {
		@Override
		public void onChanged(Change<? extends DockedShape> c) {
			while (c.next()) {
				for (final DockedShape child : c.getRemoved()) {
					child.side.unbind();
				}

				if (c.wasAdded()) {
					for (final DockedShape child : c.getAddedSubList()) {
						child.side.bind(side);
					}
				}
			}
		}
	}

	/**
	 * Creates a new instance
	 */
	public DockedShape() {
		// Disable auto sizing of the contents of groups
		graphicWrapper.setAutoSizeChildren(false);
		primaryLabels.setAutoSizeChildren(false);
		secondaryLabels.setAutoSizeChildren(false);

		this.getChildren().addAll(graphicWrapper, primaryLabels, secondaryLabels, dockedChildren.getGroup());
		dockedChildren.getNodes().addListener(new ChildListener());
		side.addListener((p, o, n) -> {
			setGraphicRotation();
			dockedChildren.setSide(n);
			requestLayout();
		});
	}

	@Override
	public void requestLayout() {
		dockedChildren.clearCache();
		super.requestLayout();
	}

	public DockSide getSide() {
		return side.get();
	}

	public void setSide(final DockSide value) {
		side.set(value);
	}

	public ObjectProperty<DockSide> sideProperty() {
		return side;
	}

	public void setGraphic(final Node value) {
		graphicWrapper.getChildren().setAll(value);
		setGraphicRotation();
	}

	public ObservableList<Node> getPrimaryLabels() {
		return primaryLabels.getChildren();
	}

	public ObservableList<Node> getSecondaryLabels() {
		return secondaryLabels.getChildren();
	}

	/**
	 * Returns the maximum of the preferred width of all labels
	 * @return the maximum preferred width of labels
	 */
	public double getMaxPrefLabelWidth() {
		return Math.max(maxPrefWidth(primaryLabels.getChildren()), maxPrefWidth(secondaryLabels.getChildren()));
	}

	/**
	 * Returns the sum of the heights of all labels
	 * @return the sum of the heights of all labels
	 */
	public double getTotalLabelHeight() {
		return maxLabelPrefHeight();
	}

	/**
	 * Updates the rotation of the contents of the graphics wrapper based on the value of the side property.
	 */
	private void setGraphicRotation() {
		final DockSide side = sideProperty().get();
		if (side == null) {
			return;
		}

		final double rotation;
		switch (side) {
		case LEFT:
			rotation = 0;
			break;
		case RIGHT:
			rotation = 180;
			break;
		case TOP:
			rotation = 90;
			break;
		case BOTTOM:
			rotation = 270;
			break;
		default:
			rotation = 0;
			break;
		}

		for (final Node child : graphicWrapper.getChildren()) {
			child.setRotate(rotation);
		}
	}

	/**
	 * The {@link #sideProperty()} of children added to this list will be bound to the side of this instance.
	 * @return an observable list containing nested docked shapes.
	 */
	public ObservableList<DockedShape> getNestedChildren() {
		return dockedChildren.getNodes();
	}

	@Override
	public final boolean isResizable() {
		// The node is resizable if all of it's graphics are resizable or if the node does not include any graphics.
		for (final Node n : graphicWrapper.getChildren()) {
			if (!n.isResizable()) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Removes a child from the container shape.
	 * @param child the child to remove.
	 */
	public void removeChild(final Node child) {
		// Assume the child is contained in a group.
		final Group g = (Group) child.getParent();
		g.getChildren().remove(g);
	}

	@Override
	public void setConfiguredWidth(final double value) {
		if (this.configuredWidth != value) {
			this.configuredWidth = value;
			requestLayout();
		}
	}

	@Override
	public void setConfiguredHeight(final double value) {
		if (this.configuredHeight != value) {
			this.configuredHeight = value;
			requestLayout();
		}
	}

	/**
	 * Anchor intended for use to connect to the docked shape from within the containing {@link ContainerShape}
	 * @return the interior anchor
	 */
	public final IAnchor getInteriorAnchor() {
		return interiorAnchor;
	}

	/**
	 * Anchor intended for use to connect to the docked shape from outside the containing {@link ContainerShape}
	 * @return the exterior anchor
	 */
	public final IAnchor getExteriorAnchor() {
		return exteriorAnchor;
	}

	@Override
	protected double computeMinWidth(final double height) {
		return computePrefWidth(height);
	}

	@Override
	protected double computeMinHeight(final double width) {
		return computePrefHeight(width);
	}

	@Override
	protected double computePrefWidth(final double height) {
		if (side.get().vertical) {
			// Left/Right
			return Math.max(maxLabelPrefWidth(), Math.max(maxPrefWidth(graphicWrapper.getChildren()),
					maxUntransformedGraphicPrefWidth() + dockedChildren.getWidth()));
		} else {
			// Top/ Bottom
			return Math.max(Math.max(maxLabelPrefWidth() + maxPrefWidth(graphicWrapper.getChildren()),
					dockedChildren.getWidth()),
					configuredWidth);
		}
	}

	@Override
	protected double computePrefHeight(final double width) {
		if (side.get().vertical) {
			// Left/Right
			return Math.max(Math.max(maxLabelPrefHeight() + maxPrefHeight(graphicWrapper.getChildren()),
					dockedChildren.getHeight()),
					configuredHeight);
		} else {
			// Top/Bottom
			return Math.max(maxLabelPrefHeight(), Math.max(maxPrefHeight(graphicWrapper.getChildren()),
					maxUntransformedGraphicPrefWidth() + dockedChildren.getHeight()));
		}
	}

	@Override
	public double computeMaxWidth(final double height) {
		if (side.get().vertical) {
			// Left/Right
			return computePrefWidth(height);
		} else {
			// Top/ Bottom
			return Math.max(
					Math.max(maxLabelPrefWidth() + maxUntransformedGraphicMaxHeight(), dockedChildren.getWidth()),
					configuredWidth);
		}
	}

	@Override
	public double computeMaxHeight(final double width) {
		if (side.get().vertical) {
			// Left/Right
			return Math.max(
					Math.max(maxLabelPrefHeight() + maxUntransformedGraphicMaxHeight(), dockedChildren.getHeight()),
					configuredHeight);
		} else {
			// Top/Bottom
			return computePrefHeight(width);
		}
	}

	/**
	 * Returns the max of the preferred widths of all labels.
	 * @return the max of the preferred widths of all the labels
	 */
	private double maxLabelPrefWidth() {
		double result = 0;
		for (final Group labelGroup : labelGroups) {
			if (labelGroup.isManaged()) {
				for (final Node label : labelGroup.getChildren()) {
					if (label.isManaged()) {
						result = Math.max(result, label.prefWidth(-1));
					}
				}
			}
		}

		return result;
	}

	/**
	 * Returns the max of the preferred heights of all labels.
	 * @return the max of the preferred label heights of all the labels
	 */
	private double maxLabelPrefHeight() {
		double result = VERTICAL_LABEL_PADDING;

		for (final Group labelGroup : labelGroups) {
			if (labelGroup.isManaged()) {
				for (final Node label : labelGroup.getChildren()) {
					if (label.isManaged()) {
						result += label.prefHeight(-1);
					}
				}
			}
		}

		return result;
	}

	/**
	 * Returns the max of the preferred widths of all children of the graphics wrapper.
	 * This value will not reflect the rotation of the graphic.
	 * It is intended to be used to determine the offset needed when positioning nested docked shapes.
	 * @return the max of the preferred width of all children of the graphics wrapper.
	 */
	private double maxUntransformedGraphicPrefWidth() {
		double result = 0;
		for (final Node graphic : graphicWrapper.getChildren()) {
			result = Math.max(result, graphic.prefWidth(-1));
		}

		return result;
	}

	/**
	 * Returns the max of the max heights of all children of the graphics wrapper.
	 * This value will not reflect the rotation of the graphic.
	 * @return the max of the preferred heights of all children of the graphics wrapper.
	 */
	private double maxUntransformedGraphicMaxHeight() {
		double result = 0;
		for (final Node graphic : graphicWrapper.getChildren()) {
			result = Math.max(result, graphic.maxHeight(-1));
		}

		return result;
	}

	@Override
	protected void layoutChildren() {
		final DockSide side = this.getSide();
		final double width = getWidth();
		final double height = getHeight();

		// Position Labels
		double y = 0;
		for (final Group labelGroup : labelGroups) {
			if (labelGroup.isManaged()) {
				for (final Node label : labelGroup.getChildren()) {
					if (label.isManaged()) {
						final double childWidth = label.prefWidth(-1);
						final double childHeight = label.prefHeight(-1);

						if (side.alignEnd) {
							if (side.vertical) {
								// Right
								label.resizeRelocate(width - childWidth, y, childWidth, childHeight);
							} else {
								// Bottom
								label.resizeRelocate(0, y, childWidth, childHeight);
							}
						} else { // Top/Left
							label.resizeRelocate(0, y, childWidth, childHeight);
						}

						y += childHeight;
					}
				}
			}
		}

		// Label padding is added regardless of whether there were any labels in order to match the previous implementation
		y += VERTICAL_LABEL_PADDING;

		//
		// Graphic
		//
		// Position the wrapper but resize the inner graphics
		// Offset for children. Dimension is dependent on the side
		for (final Node graphic : graphicWrapper.getChildren()) {
			if (side.vertical) {
				final double childWidth = graphic.prefWidth(-1);
				final double childHeight = Math.min(Math.max(graphic.minHeight(-1), height - y), graphic.maxHeight(-1));
				graphic.resize(childWidth, childHeight);

				if (side.alignEnd) {
					// Right
					graphicWrapper.relocate(width - childWidth, y);

				} else {
					// Left
					graphicWrapper.relocate(0, y);
				}
			} else {
				// Determine width and height and resize the inner graphic.
				// Width and height are swapped when referring to the inner graphic because rotation.
				// Variable names are from docked shape's orientation
				final double maxLabelWidth = computeMaxLabelWidth();
				final double childWidth = Math.min(Math.max(graphic.minHeight(-1), width - maxLabelWidth),
						graphic.maxHeight(-1));
				final double childHeight = graphic.prefWidth(-1);
				graphic.resize(childHeight, childWidth);

				if (side.alignEnd) {
					// Bottom
					graphicWrapper.relocate(maxLabelWidth, height - childHeight);
				} else {
					// Top
					graphicWrapper.relocate(maxLabelWidth, 0);
				}
			}
		}

		// Layout children
		if (side.vertical) {
			if (side.alignEnd) {
				// Right
				dockedChildren.layout(width - maxUntransformedGraphicPrefWidth(), 0);
			} else {
				// Left
				dockedChildren.layout(maxUntransformedGraphicPrefWidth(), 0);
			}
		} else {
			if (side.alignEnd) {
				// Bottom
				dockedChildren.layout(0.0, height - maxUntransformedGraphicPrefWidth());
			} else {
				// Top
				dockedChildren.layout(0.0, maxUntransformedGraphicPrefWidth());
			}
		}

		// Position anchors
		if (side.vertical) {
			final Bounds graphicWrapperBounds = graphicWrapper.getBoundsInLocal();
			final double anchorY = (graphicWrapperBounds.getMinY() + graphicWrapperBounds.getMaxY()) / 2.0;
			if (side.alignEnd) {
				// Right
				interiorAnchor.setReferencePosition(new Point(graphicWrapperBounds.getMinX() + 1, anchorY));
				exteriorAnchor.setReferencePosition(new Point(graphicWrapperBounds.getMaxX() - 1, anchorY));
			} else {
				// Left
				interiorAnchor.setReferencePosition(new Point(graphicWrapperBounds.getMaxX() - 1, anchorY));
				exteriorAnchor.setReferencePosition(new Point(graphicWrapperBounds.getMinX() + 1, anchorY));
			}
		} else {
			final Bounds graphicWrapperBounds = graphicWrapper.getBoundsInParent();
			final double anchorX = (graphicWrapperBounds.getMinX() + graphicWrapperBounds.getMaxX()) / 2.0;
			if (side.alignEnd) {
				// Bottom
				interiorAnchor.setReferencePosition(new Point(anchorX, graphicWrapperBounds.getMinY() + 1));
				exteriorAnchor.setReferencePosition(new Point(anchorX, graphicWrapperBounds.getMaxY() - 1));
			} else {
				// Top
				interiorAnchor.setReferencePosition(new Point(anchorX, graphicWrapperBounds.getMaxY() - 1));
				exteriorAnchor.setReferencePosition(new Point(anchorX, graphicWrapperBounds.getMinY() + 1));
			}
		}
	}

	/**
	 * Sets the managed and visible flags of the primary labels to the specified value.
	 * @param value whether to show the primary label nodes.
	 */
	public void setPrimaryLabelsVisible(final boolean value) {
		primaryLabels.setManaged(value);
		primaryLabels.setVisible(value);
	}

	@Override
	public void apply(final FxStyle style) {
		setPrimaryLabelsVisible(style.getPrimaryLabelsVisible());
	}

	@Override
	public void setLabelBackgroundColor(Color value) {
		LabelBackgroundColorUtil.setLabelBackgroundColor(getPrimaryLabels(), value);
		LabelBackgroundColorUtil.setLabelBackgroundColor(getSecondaryLabels(), value);
		LabelBackgroundColorUtil.setLabelBackgroundColor(getNestedChildren(), value);
	}

	@Override
	public IGeometry getChopBoxGeometry() {
		// Use the rectangle bounds of the node
		return FX2Geometry.toRectangle(getLayoutBounds());
	}

	/**
	 * Return the max of the preferred width of all labels
	 * @return the max value of all label widths
	 */
	private double computeMaxLabelWidth() {
		double maxLabelWidth = 0;
		for (final Group labelGroup : labelGroups) {
			if (labelGroup.isManaged()) {
				for (final Node label : labelGroup.getChildren()) {
					if (label.isManaged()) {
						final double childWidth = label.prefWidth(-1);
						maxLabelWidth = Math.max(childWidth, maxLabelWidth);
					}
				}
			}
		}

		return maxLabelWidth;
	}

	/**
	 * Returns the sum height of all labels along with additional padding. For vertically aligned nodes, this corresponds to the Y value of the
	 * graphic node.
	 * @return the sum of the preferred height of all labels and additional label padding.
	 */
	private double computeLabelHeightWithPadding() {
		// Position Labels
		double y = VERTICAL_LABEL_PADDING;
		for (final Group labelGroup : labelGroups) {
			if (labelGroup.isManaged()) {
				for (final Node label : labelGroup.getChildren()) {
					if (label.isManaged()) {
						final double childHeight = label.prefHeight(-1);
						y += childHeight;
					}
				}
			}
		}

		return y;
	}

	/**
	 * Returns the minimum position (X or Y depending on orientation) to use when positioning nested children
	 * @return the minimum position to use when positioning nested children
	 */
	private double computeMinimumNestedChildPosition() {
		final DockSide side = this.getSide();
		if (side.vertical) {
			return computeLabelHeightWithPadding();
		} else {
			return computeMaxLabelWidth();
		}
	}

	/**
	 * Returns the max of the preferred widths of the specified nodes.
	 * @param nodes the nodes for which to calculate the value
	 * @return the max of the preferred widths of the specified nodes.
	 */
	private static double maxPrefWidth(final List<Node> nodes) {
		double result = 0;
		for (final Node n : nodes) {
			if (n.isManaged()) {
				result = Math.max(result, n.prefWidth(-1));
			}
		}
		return result;
	}

	/**
	 * Returns the max of the preferred heights of the specified nodes.
	 * @param nodes the nodes for which to calculate the value
	 * @return the max of the preferred heights of the specified nodes.
	 */
	private static double maxPrefHeight(final List<Node> nodes) {
		double result = 0;
		for (final Node n : nodes) {
			if (n.isManaged()) {
				result = Math.max(result, n.prefHeight(-1));
			}
		}
		return result;
	}
}

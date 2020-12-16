/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.gef.layout;

import java.util.List;

import org.eclipse.gef.fx.anchors.IAnchor;
import org.eclipse.gef.fx.anchors.StaticAnchor;
import org.eclipse.gef.fx.nodes.Connection;
import org.eclipse.gef.fx.nodes.GeometryNode;
import org.eclipse.gef.fx.utils.NodeUtils;
import org.eclipse.gef.geometry.planar.IGeometry;
import org.eclipse.gef.geometry.planar.Point;
import org.osate.ge.gef.FxStyle;
import org.osate.ge.gef.graphics.GraphicNode;

import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

/**
 * Base class for connection nodes. Contains the actual connection along with associated labels and decorations.
 *
 * Decorations nodes will be rotated by this node as needed. The nodes should be specified in a manner
 * that would be appropriate for a connection going from left to right.
 *
 * Positions specified by {@link PreferredPosition} will be used for labels. Such positions are relative to the midpoint of
 * the connection. By default the primary label is positioned above the midpoint. Other labels are positioned below
 * the midpoint.
 *
 * Midpoint decorations as centered along the midpoint of the connection.
 *
 * Decorations and labels are resized to their preferred sizes.
 *
 * Connection bendpoints are specified in local coordinates.
 *
 * The node is not resizable. Region is used as the base class so that the layout bounds will have a minimum X,Y of 0.
 * JavaFX 8 does not provide a means to customize the layout bounds.
 */
public abstract class BaseConnectionNode extends Region implements GraphicNode {
	private static final int midpointDecorationSpacing = 4;

	private final Connection connection = new Connection();
	private Node primaryLabel;
	private final Group otherLabels = new Group();
	private final Group midpointDecorations = new Group();
	private final StaticAnchor midpointAnchor = new StaticAnchor(connection,
			new org.eclipse.gef.geometry.planar.Point(0.0, 0.0));

	/**
	 * Groups used for the start decoration. Specified decoration will be placed in group and shifted to center.
	 */
	private final Group startDecorationGroup = new Group();

	/**
	 * Groups used for the end decoration. Specified decoration will be placed in group and shifted to center.
	 */
	private final Group endDecorationGroup = new Group();

	public BaseConnectionNode() {
		connection.setStartDecoration(startDecorationGroup);
		connection.setEndDecoration(endDecorationGroup);
		getChildren().setAll(connection, midpointDecorations, otherLabels);

		setOutlineColor(Color.BLACK);
		setLineWidth(2.0);

		// Finish configuring curve appearance
		final GeometryNode<?> gn = (GeometryNode<?>) connection.getCurve();
		gn.setStrokeLineCap(StrokeLineCap.BUTT);
	}

	protected void setStartAnchor(final IAnchor anchor) {
		connection.setStartAnchor(anchor);
	}

	protected void setEndAnchor(final IAnchor anchor) {
		connection.setEndAnchor(anchor);
	}

	public Node getPrimaryLabel() {
		return primaryLabel;
	}

	public void setPrimaryLabel(final Node value) {
		if (primaryLabel != value) {
			if (primaryLabel != null) {
				getChildren().remove(value);
			}

			if (value != null) {
				getChildren().add(value);
			}
			primaryLabel = value;
		}
	}

	/**
	 * Returns other label nodes. Other labels are additional labels other than the primary label,.
	 * @return the other labels.
	 */
	public ObservableList<Node> getOtherLabels() {
		return otherLabels.getChildren();
	}

	/**
	 * Returns midpoint decorations. Decoration nodes that will be positioned along the connection near the midpoint.
	 * @return the midpoint decorations
	 */
	public ObservableList<Node> getMidpointDecorations() {
		return midpointDecorations.getChildren();
	}

	/**
	 * Sets the node which is displayed that the start of the connection.
	 * @param node the start decoration.
	 */
	public void setStartDecoration(final Node node) {
		startDecorationGroup.getChildren().setAll(node);
		final Bounds decorationBounds = node.getLayoutBounds();
		node.relocate(-decorationBounds.getMaxX() / 2.0, -decorationBounds.getMaxY() / 2.0);
	}

	/**
	 * Sets the node which is displayed that the end of the connection.
	 * @param node the end decoration.
	 */
	public void setEndDecoration(final Node node) {
		endDecorationGroup.getChildren().setAll(node);
		final Bounds decorationBounds = node.getLayoutBounds();
		node.relocate(-decorationBounds.getMaxX() / 2.0, -decorationBounds.getMaxY() / 2.0);
		node.setRotate(180.0);
	}

	/**
	 * Returns an anchor that is positioned at the connection's midpoint
	 * @return the midpoint anchor
	 */
	public IAnchor getMidpointAnchor() {
		return midpointAnchor;
	}

	/**
	 * Sets the bendpoints for the connection.
	 * @param bendpoints the new bendpoints.
	 */
	public void setBendpoints(final List<Point> bendpoints) {
		connection.setControlPoints(bendpoints);
	}

	@Override
	public void layoutChildren() {
		// Find the midpoint and the rotation angle at the midpoint to allow layout of midpoint decorations and
		// anchor. Only polylines are supported. This is different from the center provided by the connection.
		// The midpoint calculation combines the length of all segments and finds the appropriate segment.
		// The center returned by the connection selects a point on the center segment.
		final List<Point> points = connection.getPointsUnmodifiable();
		if (points.size() <= 1) {
			return;
		}

		Point midpoint = null;
		double midpointAngle = 0.0;
		// Calculate the total distance
		double totalDistance = 0.0;
		Point prevPoint = points.get(0);
		final List<Point> otherPoints = points.subList(1, points.size());
		for (Point p : otherPoints) {
			totalDistance += p.getDistance(prevPoint);
			prevPoint = p;
		}

		// Determine where the midpoint is
		double distanceRemaining = totalDistance / 2.0;
		prevPoint = points.get(0);
		for (Point p : otherPoints) {
			final double d = p.getDistance(prevPoint);
			if (distanceRemaining <= d) {
				// Find the point on the segment
				double s = distanceRemaining / d;
				midpoint = new Point(prevPoint.x + s * (p.x - prevPoint.x), prevPoint.y + s * (p.y - prevPoint.y));
				midpointAngle = Math.atan2(p.y - prevPoint.y, p.x - prevPoint.x) * 180.0 / Math.PI;
				break;
			} else {
				distanceRemaining -= d;
			}

			prevPoint = p;
		}

		// Position the primary label. If a preferred position is set, use it. Otherwise, position the label
		// above the connection center.
		if (primaryLabel != null) {
			final double childWidth = primaryLabel.prefWidth(-1);
			final double childHeight = primaryLabel.prefHeight(-1);
			final Point2D childRelPosition = PreferredPosition.get(primaryLabel);
			if (childRelPosition == null) {
				primaryLabel.resizeRelocate(midpoint.x - childWidth / 2.0, midpoint.y - childHeight - 2, childWidth,
						childHeight);
			} else {
				primaryLabel.resizeRelocate(midpoint.x + childRelPosition.getX(), midpoint.y + childRelPosition.getY(),
						childWidth, childHeight);
			}
		}

		// Position additional labels below the connection center. If a preferred position is set for any nodes,
		// use it.
		double labelY = midpoint.y;
		for (final Node child : otherLabels.getChildren()) {
			final Point2D childRelPosition = PreferredPosition.get(child);
			final Bounds childBounds = child.getLayoutBounds();
			if (childRelPosition == null) {
				child.relocate(midpoint.x - childBounds.getWidth() / 2.0, labelY);
			} else {
				child.relocate(midpoint.x + childRelPosition.getX(), midpoint.y + childRelPosition.getY());
			}

			labelY += childBounds.getHeight();
		}

		//
		// Layout midpoint decorations
		//
		double totalMidpointDecorationWidth = -midpointDecorationSpacing;
		for (final Node child : midpointDecorations.getChildren()) {
			totalMidpointDecorationWidth += child.getLayoutBounds().getWidth() + midpointDecorationSpacing;
		}

		// Position the midpoint decorations
		double centerDecorationX = midpoint.x - totalMidpointDecorationWidth / 2.0;
		for (final Node child : midpointDecorations.getChildren()) {
			final Bounds childBounds = child.getLayoutBounds();
			child.relocate(centerDecorationX, midpoint.y - childBounds.getHeight() / 2.0);
			centerDecorationX += childBounds.getWidth() + midpointDecorationSpacing;
		}

		// Rotate the midpoint decoration to match the orientation of the segment where it is located
		midpointDecorations.setRotate(midpointAngle);

		// Set the position of the midpoint anchor.
		midpointAnchor.setReferencePosition(midpoint);

		midpointDecorations.setManaged(!midpointDecorations.getChildren().isEmpty());
	}

	@Override
	public IGeometry getOutline() {
		return NodeUtils.getGeometricOutline(connection);
	}

	@Override
	public final void apply(final FxStyle style) {
		setOutlineColor(style.getOutlineColor());
		setLineWidth(style.getLineWidth());
		setPrimaryLabelVisible(style.isPrimaryLabelVisible());
	}

	public final void setOutlineColor(final Color value) {
		final GeometryNode<?> gn = (GeometryNode<?>) connection.getCurve();
		gn.setStroke(value);
	}

	public final void setLineWidth(final double value) {
		final GeometryNode<?> gn = (GeometryNode<?>) connection.getCurve();
		gn.setStrokeWidth(value);
		gn.setClickableAreaWidth(Math.max(10.0, value));
	}

	/**
	 * Sets the managed and visible flags of the primary label to the specified value. This setting is not retained
	 * if the primary label changes to a different node.
	 * @param value whether to show the primary label node.
	 */
	public void setPrimaryLabelVisible(final boolean value) {
		if (primaryLabel != null && primaryLabel.isVisible() != value) {
			primaryLabel.setManaged(value);
			primaryLabel.setVisible(value);
			setNeedsLayout(true);
		}
	}

	@Override
	public boolean isResizable() {
		return false;
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
		return 0;
	}

	@Override
	protected double computePrefHeight(final double width) {
		return 0;
	}

	@Override
	protected double computeMaxWidth(final double height) {
		return computePrefWidth(height);
	}

	@Override
	protected double computeMaxHeight(final double width) {
		return computePrefHeight(width);
	}
}

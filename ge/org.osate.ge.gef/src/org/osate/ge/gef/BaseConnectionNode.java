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
import org.eclipse.gef.fx.nodes.Connection;
import org.eclipse.gef.fx.nodes.GeometryNode;
import org.eclipse.gef.fx.utils.NodeUtils;
import org.eclipse.gef.geometry.planar.IGeometry;
import org.eclipse.gef.geometry.planar.Point;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

/**
 * Base class for connection nodes. Contains the actual connection along with associated labels and decorations.
 *
 * Decorations nodes will be rotated by this node as needed. Start and destination decorations should be specified in a manner
 * that would be appropriate for a start decoration of a connection going from left to right. Destination decorations will be rotated 180.0.
 *
 * Midpoint decorations as centered along the midpoint of the connection. Midpoint decorations should be specified as appropriate for a connection
 * from left to right.
 *
 * All decorations will be rotated based on the orientation of the connection.
 *
 * Positions specified by {@link PreferredPosition} will be used for labels. Such positions are relative to the midpoint of
 * the connection. By default the primary labels are positioned above the midpoint. Secondary labels are positioned below
 * the midpoint.
 *
 * Decorations and labels are resized to their preferred sizes.
 *
 * Connection bendpoints are specified in local coordinates.
 */
public abstract class BaseConnectionNode extends Group implements ChopBoxGeometryProvider, Stylable {
	private static final int MIDPOINT_DECORATION_SPACING = 4;

	/**
	 * Class intended to fix an issue that occurs when a group is empty. Groups are used to logically group certain
	 * types of nodes such as primary labels. However, when the group is empty, the group has a layout bounds
	 * with a negative with and height. This results in scrollbars appearing in undesired cases.
	 *
	 * This class provides an inner group that can be modified by the user of the client. The visibility of the wrapper
	 * group is updated based on whether the inner group is empty. This avoids the problem by hiding the groups while
	 * allowing the visibility of the inner group to the modified by the user of the class.
	 *
	 * Based on limited testing, the problem with scrollbars only occurs when the connection has bendpoints.
	 */
	private static class GroupWithWrapper {
		private final Group wrapper = new Group();
		private final Group inner = new Group();

		public GroupWithWrapper() {
			wrapper.getChildren().add(inner);

			wrapper.setVisible(false);
			inner.getChildren().addListener((ListChangeListener<Node>) c -> {
				wrapper.setVisible(!inner.getChildren().isEmpty());
			});
		}
	}

	private final Connection connection = new Connection();
	private final GroupWithWrapper primaryLabels = new GroupWithWrapper();
	private final GroupWithWrapper secondaryLabels = new GroupWithWrapper();
	private final GroupWithWrapper midpointDecorations = new GroupWithWrapper();
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

	/**
	 * Creates a new instance
	 */
	public BaseConnectionNode() {
		setPickOnBounds(false);
		getChildren().setAll(connection, midpointDecorations.wrapper, primaryLabels.wrapper, secondaryLabels.wrapper);
		connection.setStartDecoration(startDecorationGroup);
		connection.setEndDecoration(endDecorationGroup);

		// Finish configuring curve appearance
		final GeometryNode<?> gn = (GeometryNode<?>) connection.getCurve();
		gn.setStrokeLineCap(StrokeLineCap.BUTT);

		setOutlineColor(Color.BLACK);
		setLineWidth(2.0);
	}

	protected void setStartAnchor(final IAnchor anchor) {
		connection.setStartAnchor(anchor);
	}

	protected void setEndAnchor(final IAnchor anchor) {
		connection.setEndAnchor(anchor);
	}

	public ObservableList<Node> getPrimaryLabels() {
		return primaryLabels.inner.getChildren();
	}

	public ObservableList<Node> getSecondaryLabels() {
		return secondaryLabels.inner.getChildren();
	}

	/**
	 * Returns midpoint decorations. Decoration nodes that will be positioned along the connection near the midpoint.
	 * @return the midpoint decorations
	 */
	public ObservableList<Node> getMidpointDecorations() {
		return midpointDecorations.inner.getChildren();
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
	}

	/**
	 * Returns an anchor that is positioned at the connection's midpoint
	 * @return the midpoint anchor
	 */
	public IAnchor getMidpointAnchor() {
		return midpointAnchor;
	}

	/**
	 * Returns the wrapped connection
	 * @return the wrapped connection.
	 */
	public final Connection getInnerConnection() {
		return connection;
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

		double midpointAngle = 0.0;
		// Calculate the total distance
		double totalDistance = 0.0;
		Point prevPoint = points.get(0);
		final List<Point> otherPoints = points.subList(1, points.size());
		for (Point p : otherPoints) {
			totalDistance += p.getDistance(prevPoint);
			prevPoint = p;
		}

		Point midpoint = points.get(0);
		if (totalDistance != 0.0) {
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
		}

		// Position the primary label. If a preferred position is set, use it. Otherwise, position the label
		// above the connection center.
		double labelY = midpoint.y - 2.0;
		if (primaryLabels.inner.isManaged()) {
			for (final Node child : Lists.reverse(primaryLabels.inner.getChildren())) {
				final double childWidth = child.prefWidth(-1);
				final double childHeight = child.prefHeight(-1);
				final Point2D childRelPosition = PreferredPosition.get(child);
				labelY -= childHeight;
				if (childRelPosition == null) {
					child.resizeRelocate(midpoint.x - childWidth / 2.0, labelY, childWidth, childHeight);
				} else {
					child.resizeRelocate(midpoint.x + childRelPosition.getX(), midpoint.y + childRelPosition.getY(),
							childWidth, childHeight);
				}
			}
		}

		// Position additional labels below the connection center. If a preferred position is set for any nodes,
		// use it.
		labelY = midpoint.y;
		for (final Node child : secondaryLabels.inner.getChildren()) {
			final double childWidth = child.prefWidth(-1);
			final double childHeight = child.prefHeight(-1);
			final Point2D childRelPosition = PreferredPosition.get(child);
			if (childRelPosition == null) {
				child.resizeRelocate(midpoint.x - childWidth / 2.0, labelY, childWidth, childHeight);
			} else {
				child.resizeRelocate(midpoint.x + childRelPosition.getX(), midpoint.y + childRelPosition.getY(),
						childWidth, childHeight);
			}

			labelY += childHeight;
		}

		//
		// Layout midpoint decorations
		//
		double totalMidpointDecorationWidth = -MIDPOINT_DECORATION_SPACING;
		for (final Node child : midpointDecorations.inner.getChildren()) {
			totalMidpointDecorationWidth += child.getLayoutBounds().getWidth() + MIDPOINT_DECORATION_SPACING;
		}

		// Position the midpoint decorations
		double centerDecorationX = midpoint.x - totalMidpointDecorationWidth / 2.0;
		for (final Node child : midpointDecorations.inner.getChildren()) {
			final Bounds childBounds = child.getLayoutBounds();
			child.relocate(centerDecorationX, midpoint.y - childBounds.getHeight() / 2.0);
			centerDecorationX += childBounds.getWidth() + MIDPOINT_DECORATION_SPACING;
		}

		// Rotate the midpoint decoration to match the orientation of the segment where it is located
		midpointDecorations.inner.setRotate(midpointAngle);

		// Set the position of the midpoint anchor.
		midpointAnchor.setReferencePosition(midpoint);
	}

	@Override
	public IGeometry getChopBoxGeometry() {
		return NodeUtils.getGeometricOutline(connection);
	}

	@Override
	public final void apply(final FxStyle style) {
		setOutlineColor(style.getOutlineColor());
		setLineWidth(style.getLineWidth());
		setPrimaryLabelsVisible(style.getPrimaryLabelsVisible());
		setStrokeDashArray(style.getStrokeDashArray());
	}

	public final void setOutlineColor(final Color value) {
		final GeometryNode<?> gn = (GeometryNode<?>) connection.getCurve();
		gn.setStroke(value);
	}

	public final void setLineWidth(final double value) {
		final GeometryNode<?> gn = (GeometryNode<?>) connection.getCurve();
		gn.setStrokeWidth(value);
		gn.setClickableAreaWidth(Math.max(5.0, value));
	}

	public final void setStrokeDashArray(final ImmutableList<Double> value) {
		final GeometryNode<?> gn = (GeometryNode<?>) connection.getCurve();
		gn.getStrokeDashArray().setAll(value);
	}

	/**
	 * Sets the managed and visible flags of the primary labels to the specified value.
	 * @param value whether to show the primary label nodes.
	 */
	public void setPrimaryLabelsVisible(final boolean value) {
		primaryLabels.inner.setManaged(value);
		primaryLabels.inner.setVisible(value);
	}
}

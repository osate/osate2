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

import org.eclipse.gef.fx.anchors.ChopBoxStrategy;
import org.eclipse.gef.fx.anchors.DynamicAnchor;
import org.eclipse.gef.fx.anchors.DynamicAnchor.AnchorageReferenceGeometry;
import org.eclipse.gef.fx.anchors.IAnchor;
import org.eclipse.gef.geometry.convert.fx.FX2Geometry;
import org.eclipse.gef.geometry.planar.IGeometry;

import javafx.beans.binding.ObjectBinding;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

/**
 * {@link ContainerShape} is a {@link Node} which contains children which are grouped into distinct groupings. The
 * list to which a child is added will determine how it is laid out.
 *
 * This node is intended to be a general used node that is used to present most undocked diagram elements.
 * A child node is considered docked if is attached to the left, right, top, or bottom side of a {@link ContainerShape}
 *
 * Labels are positioned in an area and have padding on each side. The top and bottom padding are equal.
 * The left and right padding is equal. Padding must be at least the minimum value but will otherwise be calculated
 * based on size of docked nodes.
 *
 * The minimum size of the shape is such that all children must be sized to at least their minimum size.
 * Additionally, the minimum size includes the preferred size and preferred position of free and docked children.
 *
 * The preferred position of free and docked children can be set using {@link PreferredPosition#set(Node, Point2D)}.
 * Free shapes will be positioned at the preferred position. Docked children may be positioned at a different
 * location based to avoid overlapping with existing children. For docked children, only the X or Y value is used
 * depending on the side to which the shape is docked.
 *
 * The preferred size is dependent on the configured size. If the shape has a configured size, then the preferred
 * size is the max of the configured size and the minimum size. If the shape does not have a configured size,
 * it is calculated based on the preferred position and sizes of children.
 *
 **/
public class ContainerShape extends Region implements ChopBoxGeometryProvider, Stylable, ConfigureSize {
	/**
	 * Indicates that a value has not been specified. Used to indicate the lack of a configured width or height.
	 */
	public static final double NOT_SPECIFIED = -1;

	/**
	 * Minimum vertical padding on each side of the label area.
	 */
	private static final double MIN_VERTICAL_LABEL_PADDING = 3;

	/**
	 * Minimum horizontal padding on each side of label area.
	 */
	private static final double MIN_HORIZONTAL_LABEL_PADDING = 10;

	/**
	 * Minimum possible value returned by {@link #computeMinWidth(double)}.
	 * Some graphics do not have a minimum width provided so this serves as a minimum in cases where there are no children with a minimum width.
	 */
	private static double MIN_COMPUTED_MIN_WIDTH = 30;

	/**
	 * Minimum possible value returned by {@link #computeMinHeight(double)}
	 * Some graphics do not have a minimum height provided so this serves as a minimum in cases where there are no children with a minimum height.
	 */
	private static double MIN_COMPUTED_MIN_HEIGHT = 10;

	/**
	* Minimum possible value returned by {@link #computePrefWidth(double)} unless graphic has a max width.
	* Chosen based on visual experiments. Typically, computed values will not be used. The graphical editor
	* will set a preferred size based on an incremental layout ELK.
	*/
	private static final double MIN_COMPUTED_PREF_WIDTH = 140;

	/**
	 * Minimum value returned by {@link #computePrefHeight(double)} unless graphic has a max height.
	 * Chosen based on visual experiments. Typically, computed values will not be used. The graphical editor
	 * will set a preferred size based on an incremental layout ELK.
	 */
	private static final double MIN_COMPUTED_PREF_HEIGHT = 80;

	/**
	 * {@link ListChangeListener} which sets the {@link DockedShape#sideProperty()} of the elements of a list to
	 * a specific value when added to the list.
	 */
	private class SideSettingListListener implements ListChangeListener<DockedShape> {
		private DockSide side;

		public SideSettingListListener(final DockSide side) {
			this.side = side;
		}

		@Override
		public void onChanged(Change<? extends DockedShape> c) {
			while (c.next()) {
				if (c.wasAdded()) {
					for (final DockedShape child : c.getAddedSubList()) {
						child.setSide(side);
					}
				}
			}
		}
	}

	private final Group graphicWrapper = new Group();
	private ImageNode image;
	private final Group primaryLabels = new Group();
	private final Group secondaryLabels = new Group();
	private final Group[] labelGroups = new Group[] { primaryLabels, secondaryLabels };
	private final DockedNodes leftChildren = createDockedNodes(DockSide.LEFT);
	private final DockedNodes rightChildren = createDockedNodes(DockSide.RIGHT);
	private final DockedNodes topChildren = createDockedNodes(DockSide.TOP);
	private final DockedNodes bottomChildren = createDockedNodes(DockSide.BOTTOM);
	private final DynamicAnchor anchor = new DynamicAnchor(this, new ChopBoxStrategy());
	private final Group freeChildren = new Group();
	private LabelPosition horizontalLabelPosition = LabelPosition.CENTER;
	private LabelPosition verticalLabelPosition = LabelPosition.BEGINNING;

	/**
	 * The preferred width of the shape as specified by the the application.
	 * Used as the preferred width as long as it is greater than the minimum width.
	 */
	private double configuredWidth = NOT_SPECIFIED;

	/**
	 * The preferred height of the shape as specified by the the application.
	 * Used as the preferred height as long as it is greater than the minimum height.
	 */
	private double configuredHeight = NOT_SPECIFIED;

	/**
	 * Creates a new instance
	 */
	public ContainerShape() {
		// Prevent autosizing of children contained in the groups
		graphicWrapper.setAutoSizeChildren(false);
		primaryLabels.setAutoSizeChildren(false);
		secondaryLabels.setAutoSizeChildren(false);
		freeChildren.setAutoSizeChildren(false);

		// Add groups
		this.getChildren().addAll(graphicWrapper, primaryLabels, secondaryLabels, leftChildren.getGroup(),
				rightChildren.getGroup(), topChildren.getGroup(), bottomChildren.getGroup(), freeChildren);

		// Initialize chopbox anchor
		anchor.getComputationParameter(AnchorageReferenceGeometry.class).bind(new ObjectBinding<IGeometry>() {
			{
				bind(anchor.getAnchorage().boundsInLocalProperty());
			}

			@Override
			protected IGeometry computeValue() {
				return getChopBoxGeometry();
			}
		});
	}

	/**
	 * Creates a {@link DockedNodes} instance with an attached {@link SideSettingListListener}
	 * @param side the side for which the instance will contain nodes
	 * @return the new instance
	 */
	private DockedNodes createDockedNodes(final DockSide side) {
		final DockedNodes result = new DockedNodes(side);
		result.getNodes().addListener(new SideSettingListListener(side));
		return result;
	}

	public void setGraphic(final Node value) {
		graphicWrapper.getChildren().setAll(value);
	}

	/**
	 * Returns the child of the graphics wrapper or null. Assumes that the wrapper contains at most 1 node.
	 * @return the graphic node contained in the graphic wrapper
	 */
	private Node getGraphic() {
		final List<Node> graphicNodes = graphicWrapper.getChildren();
		return graphicNodes.isEmpty() ? null : graphicNodes.get(0);
	}

	public ObservableList<Node> getPrimaryLabels() {
		return primaryLabels.getChildren();
	}

	public ObservableList<Node> getSecondaryLabels() {
		return secondaryLabels.getChildren();
	}

	public ObservableList<DockedShape> getLeftChildren() {
		return leftChildren.getNodes();
	}

	public ObservableList<DockedShape> getRightChildren() {
		return rightChildren.getNodes();
	}

	public ObservableList<DockedShape> getTopChildren() {
		return topChildren.getNodes();
	}

	public ObservableList<DockedShape> getBottomChildren() {
		return bottomChildren.getNodes();
	}

	public ObservableList<Node> getFreeChildren() {
		return freeChildren.getChildren();
	}

	public final IAnchor getAnchor() {
		return anchor;
	}

	@Override
	public void requestLayout() {
		leftChildren.clearCache();
		rightChildren.clearCache();
		topChildren.clearCache();
		bottomChildren.clearCache();

		super.requestLayout();
	}

	@Override
	protected void layoutChildren() {
		final double width = getWidth();
		final double height = getHeight();

		if (image != null) {
			image.resizeRelocate(0, 0, width, height);
		}

		// Size and position graphics
		for (final Node graphic : graphicWrapper.getChildren()) {
			if (graphic.isManaged()) {
				graphic.resizeRelocate(0, 0, width, height);
			}
		}

		final double topLabelPadding = computeTopLabelPadding();
		final double horizontalLabelPadding = computeHorizontalLabelPadding();

		//
		// Size and position labels
		//
		double labelY = 0;
		switch (verticalLabelPosition) {
		case BEGINNING:
			labelY = topLabelPadding;
			break;
		case CENTER:
			labelY = topLabelPadding + Math.max(0, (height - Math.max(0, prefLabelHeight(width))) / 2.0);
			break;
		case END:
			labelY = Math.max(topLabelPadding, height - prefLabelHeight(width) + topLabelPadding);
			break;
		}

		// Position and size labels
		// Ensure that labels are always allocated their minimum height. Eagerly allocate additional space based on preferred
		// height.
		double remainingLabelHeightBeyondMinimum = height - computeMinLabelHeight();
		for (final Group labelGroup : labelGroups) {
			if (labelGroup.isManaged()) {
				for (final Node child : labelGroup.getChildren()) {
					if (child.isManaged()) {
						double childX = 0;
						final double childWidth = Math.min(width - 2.0 * horizontalLabelPadding, child.prefWidth(-1));
						switch (horizontalLabelPosition) {
						case BEGINNING:
							childX = horizontalLabelPadding;
							break;
						case CENTER:
							childX = (width - childWidth) / 2.0;
							break;
						case END:
							childX = width - childWidth - horizontalLabelPadding;
							break;
						}

						// final double remainingHeight = Math.max(0, height - labelY);
						final double childMinHeight = child.minHeight(childWidth);
						final double childPrefHeight = child.prefHeight(childWidth);
						final double childHeight = Math.min(childPrefHeight,
								remainingLabelHeightBeyondMinimum + childMinHeight);
						child.resizeRelocate(childX, labelY, childWidth, childHeight);

						labelY += childHeight;
						remainingLabelHeightBeyondMinimum -= (childHeight - childMinHeight);
					}
				}
			}
		}

		// Apply the cached layout
		leftChildren.layout(0, 0);
		rightChildren.layout(width, 0);
		topChildren.layout(0, 0);
		bottomChildren.layout(0, height);

		// Position and size free children
		for (final Node child : freeChildren.getChildren()) {
			if (child.isManaged()) {
				final Point2D position = getPreferredPositionOrDefault(child);
				child.resizeRelocate(position.getX(), position.getY(), child.prefWidth(-1), child.prefHeight(-1));
			}
		}
	}

	/**
	 * Returns the preferred position for the child. If the child does not have a preferred position, a default
	 * value of zero is returned.
	 * @param child is the child node to return the preferred position for.
	 * @return the preferred position.
	 */
	private Point2D getPreferredPositionOrDefault(final Node child) {
		final Point2D prefPosition = PreferredPosition.get(child);
		return prefPosition == null ? Point2D.ZERO : prefPosition;
	}

	/**
	 * Sets how labels are positioned horizontally.
	 * @param value the new horizontal label position
	 */
	public void setHorizontalLabelPosition(final LabelPosition value) {
		if (this.horizontalLabelPosition != value) {
			this.horizontalLabelPosition = value;
			setNeedsLayout(true);
		}
	}

	/**
	 * Sets how labels are positioned vertically.
	 * @param value the new vertical label position
	 */
	public void setVerticalLabelPosition(final LabelPosition value) {
		if (this.verticalLabelPosition != value) {
			this.verticalLabelPosition = value;
			setNeedsLayout(true);
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

	/**
	 * Sets the image to display in place of the graphics
	 * @param value a reference to an image to display instead of graphics. If null, the graphics will be displayed.
	 */
	public void setImage(final ImageReference value) {
		if (value == null) {
			if (this.image != null) {
				getChildren().remove(image);
				this.image = null;
			}
		} else {
			if (image == null) {
				image = new ImageNode();
				getChildren().add(0, image);
			}
			image.setImageReference(value);
		}

		final boolean showGraphics = image == null;
		graphicWrapper.setManaged(showGraphics);
		graphicWrapper.setVisible(showGraphics);
	}

	@Override
	public void apply(final FxStyle style) {
		setHorizontalLabelPosition(style.getHorizontalLabelPosition());
		setVerticalLabelPosition(style.getVerticalLabelPosition());
		setPrimaryLabelsVisible(style.getPrimaryLabelsVisible());
		setImage(style.getImage());

		// Set the label background color to the background color with a fixed opacity
		final Color bg = style.getBackgroundColor();
		setLabelBackgroundColor(new Color(bg.getRed(), bg.getGreen(), bg.getBlue(), 0.8));
	}

	private void setLabelBackgroundColor(Color value) {
		LabelBackgroundColorUtil.setLabelBackgroundColor(getPrimaryLabels(), value);
		LabelBackgroundColorUtil.setLabelBackgroundColor(getSecondaryLabels(), value);
		LabelBackgroundColorUtil.setLabelBackgroundColor(getLeftChildren(), value);
		LabelBackgroundColorUtil.setLabelBackgroundColor(getRightChildren(), value);
		LabelBackgroundColorUtil.setLabelBackgroundColor(getTopChildren(), value);
		LabelBackgroundColorUtil.setLabelBackgroundColor(getBottomChildren(), value);
		LabelBackgroundColorUtil.setLabelBackgroundColor(getFreeChildren(), value);
	}

	@Override
	public IGeometry getChopBoxGeometry() {
		// In some cases, the outline will have a 0 width unless the values of the bounds in local
		// property is retrieved. It is unclear the reason for this but this fixes an issues with
		// chop box anchors
		boundsInLocalProperty().get();

		final Node graphic = getGraphic();
		if (graphic instanceof ChopBoxGeometryProvider) {
			final IGeometry outline = ((ChopBoxGeometryProvider) graphic).getChopBoxGeometry();
			if (outline != null && outline.getBounds().getWidth() > 0) {
				return outline;
			}
		}

		// Fallback to a rectangle based on layout bounds
		return FX2Geometry.toRectangle(getLayoutBounds());
	}

	@Override
	protected double computePrefWidth(final double height) {
		return computePrefWidth(height, configuredWidth);
	}

	/**
	 * Computes the preferred width of the node. If a configured width is specified, then that value will be
	 * returned as long as it is not less than the minimum width. If the configured width is {@link #NOT_SPECIFIED}
	 * then it will be computed based on the grouping, preferred position and sizes of children.
	 *
	 * When calculating the preferred width during layout, this function is called
	 * with the configured which that has been specified by {@link #setConfiguredWidth(double)}
	 * @param height the height of the node.  See {@link #computePrefWidth(double)}
	 * @param configuredWidth is the configured width to use for computation.
	 * @return the preferred width.
	 */
	public double computePrefWidth(final double height, final double configuredWidth) {
		if (configuredWidth == NOT_SPECIFIED) {
			double result = Math.max(MIN_COMPUTED_PREF_WIDTH, configuredWidth);

			// Include the preferred with of the labels
			final double horizontalLabelPadding = computeHorizontalLabelPadding();
			for (final Group labelGroup : labelGroups) {
				if (labelGroup.isManaged()) {
					for (final Node label : labelGroup.getChildren()) {
						if (label.isManaged()) {
							result = Math.max(result, label.prefWidth(-1) + 2.0 * horizontalLabelPadding);
						}
					}
				}
			}

			// Include the minimum width needed to include free children
			result = Math.min(Math.max(result, computeMinWidthForFreeChildren()), maxWidth(height));

			return result;
		} else {
			// Use the configured width as long as it is larger than the minimum width
			return Math.min(Math.max(configuredWidth, minWidth(height)), maxWidth(height));
		}
	}

	@Override
	protected double computePrefHeight(final double width) {
		return computePrefHeight(width, configuredHeight);
	}

	/**
	 * Computes the preferred height of the node. If a configured height is specified, then that value will be
	 * returned as long as it is not less than the minimum height. If the configured height is {@link #NOT_SPECIFIED}
	 * then it will be computed based on the grouping, preferred position and sizes of children.
	 *
	 * When calculating the preferred height during layout, this function is called
	 * with the configured which that has been specified by {@link #setConfiguredHeight(double)}
	 * @param height the height of the node.  See {@link #computePrefHeight(double)}
	 * @param configuredHeight is the configured height to use for computation.
	 * @return the preferred height.
	 */
	public double computePrefHeight(final double width, final double configuredHeight) {
		if (configuredHeight == NOT_SPECIFIED) {
			// Include the space needed for labels
			double result = Math.max(MIN_COMPUTED_PREF_HEIGHT, prefLabelHeight(width));

			// Include the minimum height needed to include free children
			result = Math.min(Math.max(result, computeMinHeightForFreeChildren()), maxHeight(width));

			return result;
		} else {
			return Math.min(Math.max(configuredHeight, minHeight(width)), maxHeight(width));
		}
	}

	/**
	 * Computes the horizontal padding for the label area.
	 * @return the horizontal padding for each side of the label area.
	 */
	private double computeHorizontalLabelPadding() {
		return MIN_HORIZONTAL_LABEL_PADDING;
	}

	/**
	 * Computes the minimum vertical padding for the label area.
	 * @return the vertical padding for each side of the label area.
	 */
	private double computeMinVerticalLabelPadding() {
		return MIN_VERTICAL_LABEL_PADDING;
	}

	private double computeTopLabelPadding() {
		final Node graphic = getGraphic();
		final double graphicTopLabelPadding = graphic instanceof MinimumTopLabelPaddingProvider
				? ((MinimumTopLabelPaddingProvider) graphic).getMinimumTopLabelPadding()
				: 0.0;
		return Math.max(computeMinVerticalLabelPadding(), graphicTopLabelPadding);
	}

	private double computeBottomLabelPadding() {
		return computeMinVerticalLabelPadding();
	}

	@Override
	protected double computeMinWidth(final double height) {
		double result = Math.max(MIN_COMPUTED_MIN_WIDTH, Math.max(leftChildren.getWidth() + rightChildren.getWidth(),
				Math.max(topChildren.getWidth(), bottomChildren.getWidth())));

		// Take into consideration minimum width of graphics
		for (final Node graphic : graphicWrapper.getChildren()) {
			if (graphic.isManaged()) {
				result = Math.max(result, graphic.minWidth(-1));
			}
		}

		// Take into consideration the minimum width of labels
		final double horizontalLabelPadding = computeHorizontalLabelPadding();
		for (final Group labelGroup : labelGroups) {
			if (labelGroup.isManaged()) {
				for (final Node label : labelGroup.getChildren()) {
					if (label.isManaged()) {
						result = Math.max(result, label.minWidth(-1) + (2 * horizontalLabelPadding));
					}
				}
			}
		}

		// Include minimum width for free children
		result = Math.max(result, computeMinWidthForFreeChildren());

		return result;
	}

	@Override
	protected double computeMinHeight(final double width) {
		double result = Math.max(MIN_COMPUTED_MIN_HEIGHT, Math.max(topChildren.getHeight() + bottomChildren.getHeight(),
				Math.max(leftChildren.getHeight(), rightChildren.getHeight())));

		// Take into consideration min height of graphics
		for (final Node graphic : graphicWrapper.getChildren()) {
			if (graphic.isManaged()) {
				result = Math.max(result, graphic.minHeight(width));
			}
		}

		// Take into account the minimum space needed to have the minimum space for all labels.
		result = Math.max(result, computeMinLabelHeight());

		// Include minimum height for free children
		result = Math.max(result, computeMinHeightForFreeChildren());

		return result;
	}

	/**
	 * Computes the minimum vertical space needed for labels. This value includes vertical padding.
	 * @return the minimum height needed for labels. Includes vertical padding.
	 */
	private final double computeMinLabelHeight() {
		final double width = getWidth();

		double minLabelHeight = 0;
		for (final Group labelGroup : labelGroups) {
			if (labelGroup.isManaged()) {
				for (final Node label : labelGroup.getChildren()) {
					if (label.isManaged()) {
						minLabelHeight += label.minHeight(width);
					}
				}
			}
		}

		if (minLabelHeight > 0) {
			minLabelHeight += computeTopLabelPadding() + computeBottomLabelPadding();
		}

		return minLabelHeight;
	}

	/**
	 * Returns the width needed by free children. This will match the X coordinate of the right most bound of all
	 * free children.
	 * @return the width needed by free children based on the positions and sizes of all free children.
	 */
	private final double computeMinWidthForFreeChildren() {
		double result = 0;
		for (final Node child : freeChildren.getChildren()) {
			if (child.isManaged()) {
				final Point2D childPosition = getPreferredPositionOrDefault(child);
				final double childWidth = child.prefWidth(-1);
				final double end = childPosition.getX() + childWidth;
				result = Math.max(result, end);
			}
		}
		return result;
	}

	/**
	 * Returns the height needed by free children. This will match the Y coordinate of the bottom most bound of all
	 * free children.
	 * @return the height needed by free children based on the positions and sizes of all free children.
	 */
	private final double computeMinHeightForFreeChildren() {
		double result = 0;
		for (final Node child : freeChildren.getChildren()) {
			if (child.isManaged()) {
				final Point2D childPosition = getPreferredPositionOrDefault(child);
				final double childHeight = child.prefHeight(-1);
				final double end = childPosition.getY() + childHeight;
				result = Math.max(result, end);
			}
		}
		return result;
	}

	@Override
	protected double computeMaxWidth(final double height) {
		// Take into consideration max width of graphics
		double result = super.computeMaxWidth(height);
		for (final Node graphic : graphicWrapper.getChildren()) {
			if (graphic.isManaged()) {
				result = Math.min(result, graphic.maxWidth(-1));
			}
		}

		return result;
	}

	@Override
	protected double computeMaxHeight(final double width) {
		// Take into consideration max width of graphics
		double result = super.computeMaxHeight(width);
		for (final Node graphic : graphicWrapper.getChildren()) {
			if (graphic.isManaged()) {
				result = Math.min(result, graphic.maxWidth(-1));
			}
		}

		return result;
	}

	/**
	 * Returns the height needed for labels.
	 * @param width the of the label block including padding. May be -1.
	 * @return the sum of the preferred height of all labels and padding.
	 */
	private double prefLabelHeight(double width) {
		final double horizontalLabelPadding = computeHorizontalLabelPadding();
		final double labelWidth = width > 0 ? -1 : Math.max(width - 2 * horizontalLabelPadding, 0);
		double totalLabelHeight = 0;
		for (final Group labelGroup : labelGroups) {
			if (labelGroup.isManaged()) {
				for (final Node label : labelGroup.getChildren()) {
					if (label.isManaged()) {
						totalLabelHeight += label.prefHeight(labelWidth);
					}
				}
			}
		}

		if (totalLabelHeight > 0) {
			totalLabelHeight += computeTopLabelPadding() + computeBottomLabelPadding();
		}

		return totalLabelHeight;
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

	/**
	 * Ensures the specified node is docked to the specified side. Adds and/or removes the node if necessary.
	 * @param child the node to add or update.
	 * @param side the side on which the child should be docked.
	 */
	public void addOrUpdateDockedChild(final DockedShape child, final DockSide side) {
		if (child.getParent() != null && child.getSide() != side) {
			removeChild(child);
		}

		// Must check if parent is null to handle initial side
		if (child.getParent() == null || child.getSide() != side) {
			if (side == null) {
				throw new AgeGefRuntimeException("Null dock side specified");
			}

			switch (side) {
			case LEFT:
				getLeftChildren().add(child);
				break;
			case RIGHT:
				getRightChildren().add(child);
				break;
			case TOP:
				getTopChildren().add(child);
				break;
			case BOTTOM:
				getBottomChildren().add(child);
				break;
			default:
				throw new AgeGefRuntimeException("Unexpected dock side for child of container shape: " + side);
			}
		}
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
}
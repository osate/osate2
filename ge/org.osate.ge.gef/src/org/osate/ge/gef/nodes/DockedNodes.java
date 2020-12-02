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
package org.osate.ge.gef.nodes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;

/**
 * Contains a partition for a side containing docked shapes and performs layout of nodes is the partition.
 * Manages a cache to improve layout performance. User of the class must call {@link DockedNodes#clearCache()}
 * and {@link DockedNodes#layout(double, double)}.
 */
class DockedNodes {
	/**
	 * Entry for the docked node cache. Contains information about the position and size of a docked node.
	 */
	static class DockedNodeCacheEntry {
		/**
		 * Comparator for sorting cache entries by the X value of their preferred position.
		 * Nodes without preferred positions are greater than those with preferred positions.
		 * Such nodes are sorted to be after nodes with preferred positions.
		 */
		final static Comparator<DockedNodeCacheEntry> PREF_POSITION_X_COMPARATOR = (n1, n2) -> {
			final Point2D p1 = n1.prefPosition;
			final Point2D p2 = n2.prefPosition;
			if (p1 == null) {
				return p2 == null ? 0 : 1;
			} else if (p2 == null) {
				return -1;
			}

			return Double.compare(p1.getX(), p2.getX());
		};

		/**
		 * Comparator for sorting cache entries by the Y value of their preferred position.
		 * Nodes without preferred positions are greater than those with preferred positions.
		 * Such nodes are sorted to be after nodes with preferred positions.
		 */
		final static Comparator<DockedNodeCacheEntry> PREF_POSITION_Y_COMPARATOR = (n1, n2) -> {
			final Point2D p1 = n1.prefPosition;
			final Point2D p2 = n2.prefPosition;
			if (p1 == null) {
				return p2 == null ? 0 : 1;
			} else if (p2 == null) {
				return -1;
			}

			return Double.compare(p1.getY(), p2.getY());
		};

		/**
		 * Creates a new instance. Populates the node, width, height and prefPosition fields.
		 * The preferred position is populated using {@link PreferredPosition}
		 * @param node is the node for which the instance will store layout information.
		 */
		DockedNodeCacheEntry(final DockedShape node) {
			this.node = node;
			this.width = node.prefWidth(-1);
			this.height = node.prefHeight(-1);
			this.prefPosition = PreferredPosition.get(node);
		}

		DockedShape node;
		double width;
		double height;

		/**
		 * The preferred position of the docked node.
		 */
		Point2D prefPosition;

		/**
		 * X value of the computed layout position relative to the border of the {@link ContainerShape} on which
		 * the node is docked.
		 */
		double x;

		/**
		 * Y value of the computed layout position relative to the border of the {@link ContainerShape} on which the node is docked.
		 */
		double y;
	}

	/**
	 * Flag to indicate whether cached values are valid.
	 */
	private boolean valid = false;

	/**
	 * The partition containing the nodes that are be laid out
	 */
	private final Partition<DockedShape> partition;

	/**
	 * List of cache entries that contains how the layout information for each docked node.
	 */
	private final ArrayList<DockedNodeCacheEntry> cache = new ArrayList<>();

	/**
	 * The side for which this instance contains nodes. Determines how nodes are laid out.
	 */
	private DockSide side;

	/**
	 * Width of the bounds of the nodes. Cleared when the cache is cleared.
	 */
	private double width = 0.0;

	/**
	 * Height of the bounds of the nodes. Cleared when the cache is cleared.
	 */
	private double height = 0.0;

	/**
	 * Creates a new instance
	 * @param side determines how the nodes are laid out and the value to which to set the side property of all added nodes.
	 */
	public DockedNodes(final List<Node> allChildren, final DockSide side) {
		this.partition = new Partition<>(allChildren, false);
		setSide(side);
	}

	/**
	 * Sets the side for which this instance contains nodes. Clears cache if value is changed.
	 * @param value the new side.
	 */
	public void setSide(final DockSide value) {
		if (this.side != value) {
			this.side = value;
			clearCache();
		}
	}

	/**
	 * Clears the cache should be called when a new layout needs to be generated.
	 */
	public void clearCache() {
		cache.clear();
		width = 0;
		height = 0;
		valid = false;
	}

	/**
	 * Resizes and relocates the nodes stored in this instance based on cached values and the specified offset.
	 * @param xOffset the x-offset to add to the cached node position
	 * @param yOffset the y-offset to add to the cached node position
	 */
	public void layout(final double xOffset, final double yOffset) {
		ensureValidLayoutCache();
		for (final DockedNodeCacheEntry c : cache) {
			c.node.resizeRelocate(c.x + xOffset, c.y + yOffset, c.width, c.height);
		}
	}

	/**
	 * Returns all the nodes in the partition
	 * @return all the nodes contained in the partition
	 */
	public ObservableList<DockedShape> getNodes() {
		return partition.getNodes();
	}

	/**
	 * Width of the bounds of the nodes. Cleared when the cache is cleared.
	 * @return width of the bounds of the nodes
	 */
	public final double getWidth() {
		ensureValidLayoutCache();
		return width;
	}

	/**
	 * Height of the bounds of the nodes. Cleared when the cache is cleared.
	 * @return height of the bounds of the nodes
	 */
	public final double getHeight() {
		ensureValidLayoutCache();
		return height;
	}

	/**
	 * Ensures that values are valid. Computes the value if necessary
	 */
	private void ensureValidLayoutCache() {
		if (!valid) {
			computeCachedValues();
			valid = true;
		}
	}

	/**
	 * Computes and stores cached values. Specifically creates the cache entries containing the layout
	 * information for these docked nodes and the total width and height.
	 */
	private void computeCachedValues() {
		clearCache();
		if (partition.getNodes().isEmpty()) {
			return;
		}

		// Populate cache which objects
		for (final DockedShape n : partition.getNodes()) {
			cache.add(new DockedNodeCacheEntry(n));
		}

		// Sort the nodes in the cache
		final Comparator<DockedNodeCacheEntry> sortComparator = side.vertical
				? DockedNodeCacheEntry.PREF_POSITION_Y_COMPARATOR
				: DockedNodeCacheEntry.PREF_POSITION_X_COMPARATOR;
		cache.sort(sortComparator);

		// Calculate the position for each child and the total width and height
		if (side.vertical) {
			double y = 0;
			for (final DockedNodeCacheEntry child : cache) {
				if (child.node.isManaged()) {
					if (child.prefPosition != null) {
						y = Math.max(child.prefPosition.getY(), y);
					}
					child.x = -(side.alignEnd ? child.width : 0);
					child.y = y;
					y += child.height + ContainerShape.DOCKED_SHAPE_SPACING;

					width = Math.max(width, child.width);
					height = y - ContainerShape.DOCKED_SHAPE_SPACING;
				}
			}
		} else {
			double x = 0;
			for (final DockedNodeCacheEntry child : cache) {
				if (child.node.isManaged()) {
					if (child.prefPosition != null) {
						x = Math.max(child.prefPosition.getX(), x);
					}
					child.x = x;
					child.y = -(side.alignEnd ? child.height : 0);
					x += child.width + ContainerShape.DOCKED_SHAPE_SPACING;

					width = x - ContainerShape.DOCKED_SHAPE_SPACING;
					height = Math.max(height, child.height);
				}
			}
		}
	}
}
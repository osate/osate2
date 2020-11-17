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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;

// TODO: Rename. Need to be resizable. Feature Groups are currently resizable.
// Separate nodes for container and another for leaf?
public class FeatureNode extends Parent {
	/**
	 * Key for the property for category of nodes.
	 */
	private static final Object CATEGORY_KEY = new Object();

	/**
	 * {@link Category} s a classification of a child which determines how it will be layed out. The category
	 * of a child is determined by the child list to which it is added. A child may be moved to another category
	 * by calling {@link FeatureNode#setCategory(Node, Category)}.
	 */
	public static enum Category {
		/**
		 * Graphics are positioned and sized to match the size of the region.
		 */
		GRAPHIC,

		/**
		 * Labels are positioned based on the parent node's label configuration.
		 */
		LABEL,

		/**
		 * TODO: Document
		 */
		CHILD, // TODO: Rename
	}

	private final ObservableList<Node> graphics = FXCollections.observableArrayList();
	private final ObservableList<Node> labels = FXCollections.observableArrayList();
	private final ObservableList<Node> children = FXCollections.observableArrayList(); // TODO: Rename

	public FeatureNode() {
		// TODO: Review
		// Add listeners to each exposed child list. These listeners are responsible for updating the node's
		// category and adding / removing children from the node's children list at the appropriate location.
		// Graphics have special handling to ensure that they are before other children.
		// TODO; Fix. SHARE?

//		graphics.addListener(new GraphicListChangeListener());
//		labels.addListener(new CategoryListChangeListener(Category.LABEL));
//		children.addListener(new CategoryListChangeListener(Category.CHILD));
	}

	public ObservableList<Node> getGraphics() {
		return graphics;
	}

	public ObservableList<Node> getLabels() {
		return labels;
	}

	// TODO: Rename
	@Override
	public ObservableList<Node> getChildren() {
		return children;
	}

	// TODO: Review. Remove?
	@Override
	public final boolean isResizable() {
		// return true;
		return false;
	}

	/**
	 * Returns the list containing children with the specified category.
	 * @param category the category for which to return the list.
	 * @return is the modifiable list.
	 */
	private ObservableList<Node> childrenByCategory(final Category category) {
		switch (category) {
		case GRAPHIC:
			return graphics;
		case LABEL:
			return labels;
		case CHILD:
			return children;
		default:
			throw new IllegalArgumentException("Invalid category: " + category);
		}
	}

	/**
	 * Returns the category for the node. The category determines how the child will be layed out. It is set based
	 * on the child list the node is added to. If the node is not a child of an {@link FeatureNode} the category
	 * will be null.
	 * @param node the node for which to retrieve the category.
	 * @return the node's category.
	 */
	private static Category getCategory(final Node node) {
		return (Category) node.getProperties().get(CATEGORY_KEY);
	}

	/**
	 * Sets the category of node which is a child of {@link FeatureNode}. The category is set when adding a node to
	 * the child so calling this function on a node which isn't a child of an {@link FeatureNode} is a no-op.
	 * @param node the node to set the category for
	 * @param value the new category
	 */
	public static void setCategory(final Node node, final Category value) {
		if (node.getParent() instanceof FeatureNode) {
			final FeatureNode parent = (FeatureNode) node.getParent();
			final Category oldValue = getCategory(node);
			if (value != oldValue) {
				if (oldValue != null) {
					parent.childrenByCategory(oldValue).remove(node);
				}

				if (value != null) {
					parent.childrenByCategory(value).add(node);
				}
			}
		}
	}

}

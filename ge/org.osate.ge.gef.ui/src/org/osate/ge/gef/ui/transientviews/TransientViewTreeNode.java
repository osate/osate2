/**
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.gef.ui.transientviews;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.osate.ge.graphics.Style;

/**
 * Node class for trees used to specify the business objects depicted in a {@link TransientView}.
 * @since 1.1
 */
public class TransientViewTreeNode {
	private final TransientViewTreeNode parent;
	private final Object bo;
	private Object userData;
	private Style style = Style.EMPTY;
	private final List<TransientViewTreeNode> children = new ArrayList<>();

	/**
	 * Private constructor to prevent direct instantiation
	 * @param parent the parent node. May be null.
	 * @param bo the business object to be included in the view.
	 * @see #createChild(TransientViewTreeNode, Object)
	 * @see #createRoot()
	 */
	private TransientViewTreeNode(final TransientViewTreeNode parent, final Object bo) {
		this.parent = parent;
		this.bo = bo;
	}

	/**
	 * Creates a new instance for a root node. A root node is a node which does not have a parent.
	 * Root nodes are the base of the tree an are not associated with a business object.
	 * @return the new root node
	 */
	public static TransientViewTreeNode createRoot() {
		return new TransientViewTreeNode(null, null);
	}

	/**
	 * Creates a new child node.
	 * @param parent the parent of the node. Must not be null
	 * @param bo the business object to be included in the view. Must not be null.
	 * @return the new child node.
	 */
	public static TransientViewTreeNode createChild(final TransientViewTreeNode parent, final Object bo) {
		Objects.requireNonNull(parent, "parent must not be null");
		Objects.requireNonNull(bo, "bo must not be null");

		final TransientViewTreeNode child = new TransientViewTreeNode(parent, bo);
		parent.children.add(child);
		return child;
	}

	/**
	 * Returns the parent node
	 * @return the parent of this transient view node
	 * @since 1.2
	 */
	public final TransientViewTreeNode getParent() {
		return parent;
	}

	/**
	 * Returns the business object to include in the view
	 * @return the business object. Will return null if and only if the node is a root node.
	 */
	public final Object getBusinessObject() {
		return bo;
	}

	/**
	 * Returns the user data associated with the node.
	 * @return the user data. May return null.
	 * @see #setUserData(Object)
	 */
	public final Object getUserData() {
		return userData;
	}

	/**
	 * Sets the node's user data. The user data may be in object which the application wants to
	 * associated with the node.
	 * @param value the new user data. May be null
	 */
	public final void setUserData(final Object value) {
		this.userData = value;
	}

	/**
	 * Returns the style which will be used for the diagram element produced for the node.
	 * @return the style
	 */
	public Style getStyle() {
		return this.style;
	}

	/**
	 * Sets the style which will be used for the diagram element produced for this node.
	 * @param value the new style
	 */
	public void setStyle(final Style value) {
		this.style = Objects.requireNonNull(value, "value must not be null");
	}

	/**
	 * Returns an unmodifiable view containing the node's children.
	 * @return the node's children
	 */
	public final Collection<TransientViewTreeNode> getChildren() {
		return Collections.unmodifiableCollection(children);
	}

	/**
	 * Returns a stream containing this node and all descendant nodes.
	 * The tree must not be modified while a stream is being used.
	 * @return a stream containing this node and all descendant nodes
	 */
	public final Stream<TransientViewTreeNode> getAllDescendants() {
		return Stream.concat(Stream.of(this), getChildren().stream().flatMap(TransientViewTreeNode::getAllDescendants));
	}
}
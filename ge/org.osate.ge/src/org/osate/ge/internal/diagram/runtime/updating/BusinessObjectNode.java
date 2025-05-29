/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.diagram.runtime.updating;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

/**
 * Node in the business object tree. See {@link org.osate.ge.internal.diagram.runtime.updating}
 *
 */
public class BusinessObjectNode implements BusinessObjectContext {
	private BusinessObjectNode parent;
	private final UUID id;
	private final RelativeBusinessObjectReference relativeReference;
	private Object bo;
	private Map<RelativeBusinessObjectReference, BusinessObjectNode> children;
	private Completeness completeness = Completeness.UNKNOWN;
	private boolean defaultChildrenHaveBeenPopulated;

	/**
	 * Creates a new instance
	 * @param parent the parent of the node. The new node will be added as a child of this node.
	 * @param id unique identifier for the node. If the node is created based on a {@link DiagramElement}, this usually matches its ID.
	 * @param relativeReference the relative reference for the node's business object. May only be null for root nodes.
	 * @param bo the business object. May only be null for root nodes.
	 * @param completeness the completeness state of the node.
	 * @param defaultChildrenHaveBeenPopulated whether the child diagram elements which have been added to the diagram by default have already been added to this node.
	 */
	public BusinessObjectNode(final BusinessObjectNode parent,
			final UUID id,
			final RelativeBusinessObjectReference relativeReference,
			final Object bo,
			final Completeness completeness, final boolean defaultChildrenHaveBeenPopulated) {
		this.parent = parent;
		this.id = Objects.requireNonNull(id, "id must not be null");
		this.relativeReference = relativeReference;
		this.bo = bo;
		this.completeness = Objects.requireNonNull(completeness, "completeness must not be null");
		this.defaultChildrenHaveBeenPopulated = defaultChildrenHaveBeenPopulated;


		if(parent != null) {
			parent.addChild(this);
		}
	}

	/**
	 * Returns the relative reference for the node's business object.
	 * @return the relative reference for the node's business object.
	 */
	public final RelativeBusinessObjectReference getRelativeReference() {
		return relativeReference;
	}

	@Override
	public final BusinessObjectNode getParent() {
		return parent;
	}

	@Override
	public final Object getBusinessObject() {
		return bo;
	}

	/**
	 * Sets the node's business object
	 * @param value the new business object
	 */
	public final void setBusinessObject(final Object value) {
		this.bo = value;
	}

	/**
	 * Returns the node's unique identifier
	 * @return the node's unique identifier
	 * @see org.osate.ge.internal.diagram.runtime.DiagramElement#getId()
	 */
	public final UUID getId() {
		return id;
	}

	/**
	 * Returns the node's completeness state
	 * @return the node's completeness state
	 * @see org.osate.ge.internal.diagram.runtime.DiagramElement#getCompleteness()
	 */
	public final Completeness getCompleteness() {
		return completeness;
	}

	/**
	 * Set the node's completeness state
	 * @param value the new completeness state
	 * @see #getCompleteness()
	 */
	public final void setCompleteness(final Completeness value) {
		this.completeness = Objects.requireNonNull(value, "value must not be null");
	}

	/**
	 * Returns an unmodifiable collection containing the node's children.
	 * @return an unmodifiable collection containing the node's children. Will never return null.
	 */
	@Override
	public final Collection<BusinessObjectNode> getChildren() {
		return children == null ? Collections.emptyList() : Collections.unmodifiableCollection(children.values());
	}

	/**
	 * Returns an unmodifiable mapping between the business object of child nodes to the child nodes.
	 * @return an unmodifiable mapping between the business object of child nodes to the child nodes. Will never return null.
	 */
	public final Map<RelativeBusinessObjectReference, BusinessObjectNode> getChildrenMap() {
		return children == null ? Collections.emptyMap() : Collections.unmodifiableMap(children);
	}

	/**
	 * Returns the child business object node with the specified relative reference
	 * @param ref the relative reference of the child to return
	 * @return the child business object node with the specified reference. Returns null if such a node was not found.
	 */
	public final BusinessObjectNode getChild(final RelativeBusinessObjectReference ref) {
		if(children == null) {
			return null;
		}

		return children.get(ref);
	}

	private void addChild(final BusinessObjectNode node) {
		Objects.requireNonNull(node.relativeReference, "relativeReference must not be null");

		if(children == null) {
			children = new HashMap<>();
		}

		if (children.containsKey(node.relativeReference)) {
			throw new IllegalArgumentException("Node already has a child with reference: " + node.relativeReference);
		}

		children.put(node.relativeReference, node);
	}

	/**
	 * Removes the node from the tree. Removes the node from the parent and then sets parent to null.
	 */
	public void remove() {
		Objects.requireNonNull(relativeReference, "relativeReference must not be null");

		if (parent != null) {
			parent.children.remove(relativeReference);
			parent = null;
		}
	}

	/**
	 * Returns whether the node has not had its default children populated. This is usually true for new nodes to allow the tree updater to add
	 * children based on the content filters provided by the diagram type.
	 * @return whether the node has not had its default children populated
	 */
	public final boolean getDefaultChildrenHaveBeenPopulated() {
		return defaultChildrenHaveBeenPopulated;
	}

	/**
	 * Copies the node. The new node will be the root of a new tree
	 * @return the new node
	 * @see #copy(BusinessObjectNode)
	 */
	public BusinessObjectNode copy() {
		return copy(null);
	}

	/**
	 * Copies the node. The new node will be a child of the specified parent. The id of the node will be preserved.
	 * Id's are intended to be globally unique.
	 * @param newParent
	 * @return the new node
	 */
	private BusinessObjectNode copy(final BusinessObjectNode newParent) {
		final BusinessObjectNode newNode = new BusinessObjectNode(newParent, id, relativeReference, bo, completeness,
				defaultChildrenHaveBeenPopulated);
		for(final BusinessObjectNode child : getChildren()) {
			child.copy(newNode);
		}

		return newNode;
	}

	/**
	 * Looks for a node in the tree which has the same relative reference path as the specified search node.
	 * The path is a sequence of relative references which specify the path from the root to the node.
	 * @param tree the root node of the tree in which to search
	 * @param searchNode the node for which use to build the sequence of relative references to navigate
	 * @return the node in the tree. Returns null if the node could not be found.
	 */
	public static BusinessObjectNode findNodeByRelativeReferences(final BusinessObjectNode tree, final BusinessObjectNode searchNode) {
		// Build path to node we want to find
		final Deque<RelativeBusinessObjectReference> path = new ArrayDeque<RelativeBusinessObjectReference>();
		for(BusinessObjectNode t = searchNode; t.getParent() != null; t = t.getParent()) {
			path.push(t.relativeReference);
		}

		// Pop the path from the stack and find it in the specified tree
		BusinessObjectNode t = tree;
		while(t != null && !path.isEmpty()) {
			final RelativeBusinessObjectReference pathSegment = path.pop();
			t = t.getChild(pathSegment);
		}

		return t;
	}
}

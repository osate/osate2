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
package org.osate.ge.internal.diagram.runtime.boTree;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;

public class BusinessObjectNode implements BusinessObjectContext {
	private BusinessObjectNode parent;
	private final UUID id;
	private final RelativeBusinessObjectReference relativeReference; // May be null only for root nodes.
	private Object bo; // May be null for root nodes
	private Map<RelativeBusinessObjectReference, BusinessObjectNode> children;
	private Completeness completeness = Completeness.UNKNOWN; // DefaultTreeExpander populates this field.

	/**
	 * Returns whether the node has not had its default children populated. This is usually true for new nodes to allow the tree updater to add children based on the content filters
	 * provided by the diagram type.
	 */
	private boolean defaultChildrenHaveBeenPopulated;

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

	public final void setBusinessObject(final Object value) {
		this.bo = value;
	}

	public final UUID getId() {
		return id;
	}

	public final Completeness getCompleteness() {
		return completeness;
	}

	public final void setCompleteness(final Completeness value) {
		this.completeness = Objects.requireNonNull(value, "value must not be null");
	}

	/**
	 * Returns an unmodifiable map. Never null.
	 * @return
	 */
	@Override
	public final Collection<BusinessObjectNode> getChildren() {
		return children == null ? Collections.emptyList() : Collections.unmodifiableCollection(children.values());
	}

	/**
	 * Returns an unmodifiable map. Never null.
	 * @return
	 */
	public final Map<RelativeBusinessObjectReference, BusinessObjectNode> getChildrenMap() {
		return children == null ? Collections.emptyMap() : Collections.unmodifiableMap(children);
	}

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
			throw new RuntimeException("Node already has a child with reference: " + node.relativeReference);
		}

		children.put(node.relativeReference, node);
	}

	public void remove() {
		Objects.requireNonNull(relativeReference, "relativeReference must not be null");

		if (parent != null) {
			parent.children.remove(relativeReference);
			parent = null;
		}
	}

	public final boolean defaultChildrenHaveBeenPopulated() {
		return defaultChildrenHaveBeenPopulated;
	}

	/**
	 * Copies the node. The new node will be the root of a new tree
	 * @return
	 */
	public BusinessObjectNode copy() {
		return copy(null);
	}

	/**
	 * Copies the node. The new node will be a child of the specified parent. The id of the node will be preserved.
	 * Id's are intended to be globally unique.
	 * @param newParent
	 * @return
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
	 * Looks for a node in tree which has the same relative reference path as searchNode.
	 * @param tree
	 * @param searchNode
	 * @return
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

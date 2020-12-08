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

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;

/**
 * Represents a sub-division of a node's children. However, lists which are partitioned should only be populated or modified using
 * lists provided by {@link Partition#getNodes()}. Modifying the partition's list will update the child list.
 * Changes to the child list will not be reflected in the partition's list unless a {@link PartitionCleanerListener}
 * has been registered to the children list.
 *
 * The partition which has been specified as the primary partition will have its members appear at the start of the
 * children list and will appear in the same order in the children list as in the partition's list. Primary partitions are
 * intended to ensure the graphics nodes will have guaranteed ordering.
 *
 * The ordering of members of the auxiliary partition in the children list is not guaranteed.
 *
 * @param <T> the type of nodes contained in the partition.
 */
class Partition<T extends Node> implements Iterable<T> {
	private static final Object PARTITION_KEY = new Object();

	private final List<Node> allChildren;
	private final ObservableList<T> children = FXCollections.observableArrayList();

	/**
	 * Creates a new instance
	 * @param allChildren is the list for storing children. This list should only be modified using by modifying the members
	 * of a partition.
	 * @param priomary whether this is the primary partition. The primary partition has additional guarantees with regards to
	 * ordering. Only one primary partition should be created for a node. If more than one primary partition is created,
	 * the behavior is undefined and erroneous behavior will likely occur.
	 */
	public Partition(final List<Node> allChildren, final boolean primary) {
		this.allChildren = Objects.requireNonNull(allChildren, "allChildren must not be null");

		if (primary) {
			children.addListener(new PrimaryPartitionListener());
		} else {
			children.addListener(new AuxiliaryPartitionListener());
		}
	}

	/**
	 * Returns a list containing the nodes in the partition
	 * @return an observable list with the partition's contents
	 */
	public final ObservableList<T> getNodes() {
		return children;
	}

	@Override
	public Iterator<T> iterator() {
		return children.iterator();
	}

	/**
	 * Removes a node from its partition.
	 * @param node the node to remove from its partition
	 * @return true if the node was removed from a partition
	 */
	public static boolean remove(final Node node) {
		final Partition<?> partition = getPartition(node);
		if (partition == null) {
			return false;
		}

		return partition.getNodes().remove(node);
	}

	/**
	 * Returns the list containing children with the specified category.
	 * @param category the category for which to return the list.
	 * @return is the modifiable list.
	 */
	@SuppressWarnings("unchecked")
	private static Partition<? extends Node> getPartition(final Node node) {
		return (Partition<? extends Node>) node.getProperties().get(PARTITION_KEY);
	}

	/**
	 * This listener ensures elements in the partition are at the start or a children list. It also ensures that they are in
	 * the same order as they appear in the source list.
	 *
	 * Additionally, it stores a reference to the partition as a property.
	 *
	 * Only one listener of type {@link PrimaryPartitionListener} should be used with a children list. Otherwise the
	 * manipulated list may not contain the correct values in the correct order.
	 *
	 */
	class PrimaryPartitionListener implements ListChangeListener<Node> {
		@Override
		public void onChanged(Change<? extends Node> c) {
			while (c.next()) {
				// Rearrange children to match the order in the graphics list.
				if (c.wasPermutated()) {
					// This process isn't efficient but it is simple. Will need to revisit if graphics are
					// sorted regularly.
					// Replace each changed element with new dummy groups. This is needed to avoid exceptions
					// caused by nodes appearing in multiple places in the list.
					for (int i = c.getFrom(); i < c.getTo(); ++i) {
						final int newIndex = c.getPermutation(i);
						if (i != newIndex) {
							allChildren.set(newIndex, new Group());
						}
					}

					// Replace the groups with the appropriate elements.
					for (int i = c.getFrom(); i < c.getTo(); ++i) {
						final int newIndex = c.getPermutation(i);
						if (i != newIndex) {
							allChildren.set(newIndex, c.getList().get(newIndex));
						}
					}
				}

				// Handle removals
				for (final Node node : c.getRemoved()) {
					node.getProperties().remove(PARTITION_KEY);

					// If parent is null then ignore.
					if (node.getParent() != null) {
						allChildren.remove(node);
					}
				}

				// Handle additions
				if (c.wasAdded()) {
					// Add the nodes at the location in which they are located in the graphics node.
					for (int i = c.getFrom(); i < c.getTo(); i++) {
						final Node node = c.getList().get(i);
						remove(node);
						allChildren.add(i, node);

						// It is critical that we set the property after adding it to the children list to listeners to the
						// children list are notified before the partition is changed.
						node.getProperties().put(PARTITION_KEY, this);
					}
				}
			}
		}
	}

	/**
	 * When attached to an observable list, this listener update the children list to to ensure items that are added/removed
	 * from the list to which the listener is attached are also added and removed from the other list.
	 *
	 * Additionally, it stores a reference to the partition as a property.
	 *
	 * The ordering in the children list may not match the ordering the list for which changes are being listened.
	 */
	private class AuxiliaryPartitionListener implements ListChangeListener<Node> {
		@Override
		public void onChanged(Change<? extends Node> c) {
			while (c.next()) {
				for (final Node node : c.getRemoved()) {
					node.getProperties().remove(PARTITION_KEY);

					// If parent is null then ignore.
					if (node.getParent() != null) {
						allChildren.remove(node);
					}
				}

				if (c.wasAdded()) {
					for (final Node node : c.getAddedSubList()) {
						remove(node);
						allChildren.add(node);

						// It is critical that we set the property after adding it to the parent list to listeners to the
						// parent list are notified before the partition is changed.
						node.getProperties().put(PARTITION_KEY, Partition.this);
					}
				}
			}
		}
	}
}

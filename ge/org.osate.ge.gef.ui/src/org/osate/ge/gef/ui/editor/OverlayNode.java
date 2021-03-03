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
package org.osate.ge.gef.ui.editor;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Transform;

// TODO: Rename
public class OverlayNode extends Group implements ISelectionChangedListener {
	private final Function<DiagramElement, Node> sceneNodeProvider;
	private Map<Node, Node> selectedNodeToOverlayNodeMap = Collections.emptyMap();

	// private Set<Node> selectedNodes = Collections.emptySet();

	// TODO: Need a way to get nodes for the changed elements...
	public OverlayNode(Function<DiagramElement, Node> sceneNodeProvider) {
		this.sceneNodeProvider = sceneNodeProvider;
		this.setAutoSizeChildren(false);
	}

	// TODO: Add a dispose that will remove info to ensure we don't hold on to references? Or editor could just null things out on dispose...

	// TODO; need to listen for node chagnes too.. If node for element changes.. should refresh selection?

	@Override
	public void selectionChanged(final SelectionChangedEvent event) {
		// TODO: Identify new and removed selection
		System.err.println("TODO : SELECTION CHANGE");

		// TODO: if we can assume that there are no duplicates.. perhaps this can be optimized by using list

		// TODO: Is this guaranteed to be in the UI thread?

		// TODO: Rename, etc
		final Map<Node, Node> newSelectedNodeToOverlayNodeMap = new HashMap<>();

		// Convert selection to a set of nodes
		final Set<Node> newSelectedNodes = selectionToNodes(event.getStructuredSelection());

		// TODO: One idea would be to reuse overlay nodes.. TOo complicated? KISS until it's working

		// Iterate selection and create new nodes or copy from existing to create a new map?
		// TODO; Iterate over old map and remove if not in new one... entrySet for map can be uesd to remove..
		// TODO: Is there a retain all that notifies of removed values

		// TODO: Is there a way to do this easily without creating two new data structures?
		for (final Entry<Node, Node> existingNodeEntry : selectedNodeToOverlayNodeMap.entrySet()) {
			if (newSelectedNodes.contains(existingNodeEntry.getKey())) {
				newSelectedNodeToOverlayNodeMap.put(existingNodeEntry.getKey(), existingNodeEntry.getValue());
			} else {
				// TODO: Remove
				System.err.println("REMOVE: " + existingNodeEntry);

				// TODO: Remove all at once
				getChildren().remove(existingNodeEntry.getValue());
			}
		}

		for (final Node newNode : newSelectedNodes) {
			if (!newSelectedNodeToOverlayNodeMap.containsKey(newNode)) {
				// TODO: NEW
				System.err.println("ADD: " + newNode);
				final Node nodeOverlay = new TestOverlayNode(newNode);
				newSelectedNodeToOverlayNodeMap.put(newNode, nodeOverlay);
				// TODO: add all at once
				getChildren().add(nodeOverlay);
			}
		}

		// TODO: Will need to track things.. is there a better way of handling this? Sorted list? Map? Intead of having the function to create?

		// TODO: Diff?
		// TODO: Create overlay / whatever for new nodes
		// TODO; Remove overlay / whatever for removed nodes
		System.err.println(newSelectedNodes.size());
		selectedNodeToOverlayNodeMap = newSelectedNodeToOverlayNodeMap;
	}

	private Set<Node> selectionToNodes(final Iterable<?> selection) {
		// TODO: Rename
		final Set<Node> newSelectionNodes = new HashSet<>(); // TODO; Could be immutable set?
		for (final Object o : selection) {
			if (o instanceof DiagramElement) {
				final Node node = sceneNodeProvider.apply((DiagramElement) o);
				if (node != null) {
					newSelectionNodes.add(node);
				}
			}
		}

		return newSelectionNodes;
	}

	// TODO: Need something similar for connections
	// TODO: Move/Rename
	private static class TestOverlayNode extends Group {
		private static final double PADDING = 2.0; // TODO: Rename. Remove?
		private static final Color COLOR = new Color(0.98, 0.811, 0.6, 1.0); // TODO: This will likely be reused by connections

		private Rectangle rect;
		private ObjectBinding<Bounds> boundsInCanvasBinding; // TODO: Rename
		private DoubleBinding widthBinding;
		private DoubleBinding heightBinding;
		private DoubleBinding xBinding;
		private DoubleBinding yBinding;

		// TODO: Ideally we would listen for a transform that is relative to the canvas content. This should prevent needing to change things
		// when scrolling.

		// TODO: Internal property which is the bounds in scene of the shape..
		// bind width to that, height, x, y to that

		// TODO: Rename attachNode
		public TestOverlayNode(final Node attachNode) {
			setAutoSizeChildren(false); // TODO?

			// TODO; Rename
			boundsInCanvasBinding = new ObjectBinding<Bounds>() {
				{
					bind(localToSceneTransformProperty(), attachNode.localToSceneTransformProperty(),
							attachNode.layoutBoundsProperty());
				}

				@Override
				protected Bounds computeValue() {
					final Bounds layoutBounds = attachNode.getLayoutBounds();
					try {
						// final Transform attachedToLocalTransform = attachNode.getLocalToSceneTransform()
						// .createConcatenation(getLocalToSceneTransform().createInverse());
						final Transform attachedToLocalTransform = getLocalToSceneTransform().createInverse()
								.createConcatenation(attachNode.getLocalToSceneTransform());
						final Bounds transformedBounds = attachedToLocalTransform.transform(layoutBounds);
						return transformedBounds;
					} catch (final NonInvertibleTransformException e) {
						// TODO
						return new BoundingBox(0, 0, 0, 0);
					}
				}

			};

			// TODO: Better way of doing this that doesn't involve two listeners? Does this have the benefit of not eagerly recomuting
			// layout bounds?
			widthBinding = new DoubleBinding() {
				{
					bind(boundsInCanvasBinding);
				}

				@Override
				protected double computeValue() {
					return boundsInCanvasBinding.get().getWidth() + 2 * PADDING;
				}
			};

			heightBinding = new DoubleBinding() {
				{
					bind(boundsInCanvasBinding);
				}

				@Override
				protected double computeValue() {
					return boundsInCanvasBinding.get().getHeight() + 2 * PADDING;
				}
			};

			xBinding = new DoubleBinding() {
				{
					bind(boundsInCanvasBinding);
				}

				@Override
				protected double computeValue() {
					return boundsInCanvasBinding.get().getMinX() - PADDING;
				}
			};

			yBinding = new DoubleBinding() {
				{
					bind(boundsInCanvasBinding);
				}

				@Override
				protected double computeValue() {
					return boundsInCanvasBinding.get().getMinY() - PADDING;
				}
			};

//			widthBinding = new DoubleBinding() {
//				{
//					bind(attachNode.layoutBoundsProperty());
//				}
//
//				@Override
//				protected double computeValue() {
//					return attachNode.getLayoutBounds().getWidth() * +2 * PADDING;
//				}
//			};
//
//			heightBinding = new DoubleBinding() {
//				{
//					bind(attachNode.layoutBoundsProperty());
//				}
//
//				@Override
//				protected double computeValue() {
//					return attachNode.getLayoutBounds().getHeight() + 2 * PADDING;
//				}
//			};
//
//			xBinding = new DoubleBinding() {
//				{
//					bind(localToSceneTransformProperty(), attachNode.localToSceneTransformProperty());
//				}
//
//				@Override
//				protected double computeValue() {
//					// TODO: Consider transform of the parent
//					return attachNode.localToSceneTransformProperty().get().getTx()
//							- localToSceneTransformProperty().get().getTx() - PADDING;
//				}
//			};
//
//			yBinding = new DoubleBinding() {
//				{
//					bind(localToSceneTransformProperty(), attachNode.localToSceneTransformProperty());
//				}
//
//				@Override
//				protected double computeValue() {
//					// TODO: Consider transform of the parent
//					System.err.println("TEST: " + localToSceneTransformProperty().get().getTx());
//					return attachNode.localToSceneTransformProperty().get().getTy()
//							- localToSceneTransformProperty().get().getTy() - PADDING;
//				}
//			};

			// Can't bind layoutBoundsProperty.,. it is readonly
			// layoutBoundsProperty();
			// rect.widthProperty().bind

			// final Bounds layoutBounds = attachNode.getLayoutBounds();

			// Who does this type of stuff.

			// TODO: Bind this nodes layout bounds or other properties to a combination of the attached node.. this cshould prevent needless recomputing.
			// TODO: Need
			// final Bounds layoutBounds = attachNode.getLocalToSceneTransform().transform(attachNode.getLayoutBounds());
			// TODO: need a transform from scene to parent...

			// TODO: Padding
			rect = new Rectangle();
			rect.setFill(null);
			rect.setStroke(COLOR);
			rect.setStrokeWidth(1.0); // TODO
			rect.widthProperty().bind(widthBinding);
			rect.heightProperty().bind(heightBinding);
			rect.xProperty().bind(xBinding);
			rect.yProperty().bind(yBinding);

			// rect.setStrokeType(StrokeType.INSIDE);

			getChildren().setAll(rect);

			// TODO: Listen to changes in the layout bounds

			// TODO: Something needs to move this overlay to the position of the attached shape...
			// TODO; Transform.. rotation could cause issues.. Safe to assume there isn't any rotation?

		}

		// TODO: Create a bounds property and bin
	}

}

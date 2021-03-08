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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import org.eclipse.gef.fx.nodes.GeometryNode;
import org.eclipse.gef.geometry.planar.IGeometry;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Display;
import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.gef.ContainerShape;
import org.osate.ge.gef.DockedShape;
import org.osate.ge.gef.ui.AgeGefRuntimeException;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

import com.google.common.collect.ImmutableMap;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Transform;

/**
 * A group that contains and handles the creation and removal of overlays.
 * Each overlay is attached to another node and provides node and contains a selection indicator, resize handles, etc.
 *
 * This class assumes that the provided selection contains {@link DiagramElement} instances and that it does not contain
 * duplicates. Other objects are ignored.
 */
public class Overlays extends Group implements ISelectionChangedListener {
	private static final Color SELECTION_INDICATOR_COLOR = new Color(0.98, 0.811, 0.6, 1.0);

	private final Function<DiagramElement, Node> sceneNodeProvider;

	/**
	 * Mapping from scene nodes to the selected node overlays.
	 */
	private Map<Node, Node> nodeToSelectedNodeOverlayMap = Collections.emptyMap();

	public Overlays(Function<DiagramElement, Node> sceneNodeProvider) {
		this.sceneNodeProvider = sceneNodeProvider;
		this.setAutoSizeChildren(false);
	}

	@Override
	public void selectionChanged(final SelectionChangedEvent event) {
		refresh(event.getStructuredSelection());
	}

	// This should be called by the editor whenever a change could affect the overlay.
	// Specifically, it needs to be called whenever the diagram changes. Connection diagram elements may change to shapes and vice versa
	// which would cause the nodes to change without changing the selected diagram elements.
	public void refresh(final IStructuredSelection selection) {
		Display.getCurrent().asyncExec(() -> {
			final ImmutableMap.Builder<Node, Node> newNodeToSelectedNodeOverlayMapBuilder = ImmutableMap
					.builderWithExpectedSize(selection.size());

			// Convert selection to a set of nodes
			final List<Node> selectedNodes = selectionToSceneNodes(selection);

			// Add existing selected node overlays for selected diagram elements to new map.
			for (final Entry<Node, Node> existingNodeEntry : nodeToSelectedNodeOverlayMap.entrySet()) {
				if (selectedNodes.contains(existingNodeEntry.getKey())) {
					newNodeToSelectedNodeOverlayMapBuilder.put(existingNodeEntry.getKey(),
							existingNodeEntry.getValue());
				}
			}

			// Create selected node overlays for newly selected nodes.
			for (final Node selectedNode : selectedNodes) {
				if (!nodeToSelectedNodeOverlayMap.containsKey(selectedNode)) {
					if (selectedNode instanceof ContainerShape || selectedNode instanceof DockedShape) {
						final Node overlay = new SelectedShapeOverlay(selectedNode);
						newNodeToSelectedNodeOverlayMapBuilder.put(selectedNode, overlay);
					} else if (selectedNode instanceof BaseConnectionNode) {
						// Create overlay for connection nodes
						final Node overlay = new SelectedConnectionOverlay((BaseConnectionNode) selectedNode);
						newNodeToSelectedNodeOverlayMapBuilder.put(selectedNode, overlay);
					}
				}
			}

			nodeToSelectedNodeOverlayMap = newNodeToSelectedNodeOverlayMapBuilder.build();

			// Update children to reflect the new nodes.
			getChildren().setAll(nodeToSelectedNodeOverlayMap.values());
		});
	}

	/**
	 * Returns a list containing the scene nodes for all {@link DiagramElement} instances in the provided selection.
	 * @param selection the selection from which to retrieve diagram elements.
	 * @return the list of scene nodes
	 */
	private List<Node> selectionToSceneNodes(final IStructuredSelection selection) {
		final List<Node> nodes = new ArrayList<>(selection.size());

		for (final Object o : selection) {
			if (o instanceof DiagramElement) {
				final Node node = sceneNodeProvider.apply((DiagramElement) o);
				if (node != null) {
					nodes.add(node);
				}
			}
		}

		return nodes;
	}

	/**
	 * Overlay used for selected shapes. Specifically, {@link ContainerShape} and {@link DockedShape}.
	 */
	private static class SelectedShapeOverlay extends Group {
		private ObjectBinding<Bounds> selectedNodeBoundsInLocalBinding;
		private DoubleBinding selectionIndicatorWidthBinding;
		private DoubleBinding selectionIndicatorHeightBinding;
		private DoubleBinding selectionIndicatorXBinding;
		private DoubleBinding selectionIndicatorYBinding;
		private Rectangle selectionIndicator;

		/**
		 * Creates a new instance.
		 * @param selectedNode the node for which this instance is an overlay
		 */
		public SelectedShapeOverlay(final Node selectedNode) {
			setAutoSizeChildren(false);

			selectedNodeBoundsInLocalBinding = new ObjectBinding<Bounds>() {
				{
					bind(localToSceneTransformProperty(), selectedNode.localToSceneTransformProperty(),
							selectedNode.layoutBoundsProperty());
				}

				@Override
				protected Bounds computeValue() {
					final Bounds layoutBounds = selectedNode.getLayoutBounds();
					try {
						final Transform selectedToLocalTransform = getLocalToSceneTransform().createInverse()
								.createConcatenation(selectedNode.getLocalToSceneTransform());
						final Bounds transformedBounds = selectedToLocalTransform.transform(layoutBounds);
						return transformedBounds;
					} catch (final NonInvertibleTransformException e) {
						throw new AgeGefRuntimeException(e);
					}
				}

			};

			selectionIndicatorWidthBinding = new DoubleBinding() {
				{
					bind(selectedNodeBoundsInLocalBinding);
				}

				@Override
				protected double computeValue() {
					return selectedNodeBoundsInLocalBinding.get().getWidth();
				}
			};

			selectionIndicatorHeightBinding = new DoubleBinding() {
				{
					bind(selectedNodeBoundsInLocalBinding);
				}

				@Override
				protected double computeValue() {
					return selectedNodeBoundsInLocalBinding.get().getHeight();
				}
			};

			selectionIndicatorXBinding = new DoubleBinding() {
				{
					bind(selectedNodeBoundsInLocalBinding);
				}

				@Override
				protected double computeValue() {
					return selectedNodeBoundsInLocalBinding.get().getMinX();
				}
			};

			selectionIndicatorYBinding = new DoubleBinding() {
				{
					bind(selectedNodeBoundsInLocalBinding);
				}

				@Override
				protected double computeValue() {
					return selectedNodeBoundsInLocalBinding.get().getMinY();
				}
			};

			//
			// Selection Indicator
			//
			selectionIndicator = new Rectangle();
			selectionIndicator.setFill(null);
			selectionIndicator.setStroke(SELECTION_INDICATOR_COLOR);
			selectionIndicator.setStrokeWidth(1.5);
			selectionIndicator.widthProperty().bind(selectionIndicatorWidthBinding);
			selectionIndicator.heightProperty().bind(selectionIndicatorHeightBinding);
			selectionIndicator.xProperty().bind(selectionIndicatorXBinding);
			selectionIndicator.yProperty().bind(selectionIndicatorYBinding);

			getChildren().setAll(selectionIndicator);
		}
	}

	/**
	 * Overlay used for selected connections.
	 */
	private static class SelectedConnectionOverlay extends Group {
		private final Group selectionIndicatorContainer = new Group();

		/**
		 * Creates a new instance.
		 * @param selectedNode the node for which this instance is an overlay
		 */
		public SelectedConnectionOverlay(final BaseConnectionNode selectedNode) {
			setAutoSizeChildren(false);
			selectionIndicatorContainer.setAutoSizeChildren(false);
			getChildren().add(selectionIndicatorContainer);

			// Update transform on changes
			final ChangeListener<? super Transform> transformUpdater = ((o, oldTransform, newTransform) -> {
				try {
					selectionIndicatorContainer.getTransforms().setAll(getLocalToSceneTransform().createInverse()
							.createConcatenation(selectedNode.getLocalToSceneTransform()));
				} catch (final NonInvertibleTransformException e) {
					throw new RuntimeException(e);
				}
			});

			localToSceneTransformProperty().addListener(transformUpdater);
			selectedNode.localToSceneTransformProperty().addListener(transformUpdater);

			// Update the selection indicator whenever the curve changes
			selectedNode.getInnerConnection().curveProperty().addListener((o, oldCurve, newCurve) -> {
				updateSelectionIndicator(selectedNode);
			});

			updateSelectionIndicator(selectedNode);
		}

		private void updateSelectionIndicator(final BaseConnectionNode selectedNode) {
			selectionIndicatorContainer.getChildren().clear();

			// Create new selection indicator
			final Node curve = selectedNode.getInnerConnection().getCurve();
			if (curve instanceof GeometryNode) {
				final GeometryNode<?> gn = (GeometryNode<?>) curve;
				final IGeometry g = gn.getGeometry();
				final IGeometry copy = g.getCopy();
				final GeometryNode<IGeometry> selectionIndicator = new GeometryNode<IGeometry>(copy);
				selectionIndicator.setStroke(SELECTION_INDICATOR_COLOR);
				selectionIndicator.setStrokeWidth(4.0);
				selectionIndicator.setStrokeLineCap(StrokeLineCap.BUTT);
				selectionIndicatorContainer.getChildren().add(selectionIndicator);
			}
		}
	}
}

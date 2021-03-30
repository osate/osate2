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
package org.osate.ge.gef.ui.editor.overlays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import org.eclipse.gef.fx.nodes.Connection;
import org.eclipse.gef.geometry.euclidean.Vector;
import org.eclipse.gef.geometry.planar.Point;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Display;
import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.gef.ContainerShape;
import org.osate.ge.gef.DockedShape;
import org.osate.ge.gef.FlowIndicatorNode;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;

import com.google.common.collect.ImmutableMap;

import javafx.beans.InvalidationListener;
import javafx.beans.WeakInvalidationListener;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
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
	private final Function<DiagramElement, Node> sceneNodeProvider;

	/**
	 * Mapping from diagram elements to the selected node overlays.
	 */
	private Map<DiagramElement, SelectedNodeOverlay> diagramElementToSelectedNodeOverlayMap = Collections.emptyMap();

	public Overlays(Function<DiagramElement, Node> sceneNodeProvider) {
		this.sceneNodeProvider = sceneNodeProvider;
		this.setAutoSizeChildren(false);
	}

	@Override
	public void selectionChanged(final SelectionChangedEvent event) {
		refresh(event.getStructuredSelection());
	}

	/** Refreshes the overlays based on the current selection
	 * This should be called by the editor whenever a change could affect the overlay.
	 * Specifically, it needs to be called whenever the diagram changes. Connection diagram elements may change to shapes and vice versa
	 * which would cause the nodes to change without changing the selected diagram elements.
	 * @param selection the current selection.
	 */
	@SuppressWarnings("unchecked")
	public void refresh(final IStructuredSelection selection) {
		Display.getCurrent().asyncExec(() -> {
			final ImmutableMap.Builder<DiagramElement, SelectedNodeOverlay> newDiagramElementToSelectedNodeOverlayMapBuilder = ImmutableMap
					.builderWithExpectedSize(selection.size());

			final ArrayList<DiagramElement> selectedDiagramElements = selectionToDiagramElements(selection);

			// Add existing selected node overlays for selected diagram elements to new map.
			for (final Entry<DiagramElement, SelectedNodeOverlay> existingEntry : diagramElementToSelectedNodeOverlayMap
					.entrySet()) {
				if (selectedDiagramElements.contains(existingEntry.getKey()) && sceneNodeProvider
						.apply(existingEntry.getKey()) == existingEntry.getValue().getSelectedNode()) {
					newDiagramElementToSelectedNodeOverlayMapBuilder.put(existingEntry.getKey(),
							existingEntry.getValue());
				}
			}

			// Create selected node overlays for newly selected nodes.
			for (int i = 0; i < selectedDiagramElements.size(); i++) {
				final DiagramElement selectedDiagramElement = selectedDiagramElements.get(i);
				final boolean primary = i == selectedDiagramElements.size() - 1;
				final SelectedNodeOverlay existingOverlay = diagramElementToSelectedNodeOverlayMap
						.get(selectedDiagramElement);
				if (diagramElementToSelectedNodeOverlayMap.containsKey(selectedDiagramElement)) {
					// Set whether it is primary
					existingOverlay.setPrimary(primary);
				} else {
					final Node selectedNode = sceneNodeProvider.apply(selectedDiagramElement);
					if (selectedNode != null) {
						if (selectedNode instanceof ContainerShape || selectedNode instanceof DockedShape) {
							newDiagramElementToSelectedNodeOverlayMapBuilder.put(selectedDiagramElement,
									new SelectedShapeOverlay(selectedDiagramElement, selectedNode, primary));
						} else if (selectedNode instanceof BaseConnectionNode) {
							// Create overlay for connection nodes
							newDiagramElementToSelectedNodeOverlayMapBuilder.put(selectedDiagramElement,
									new SelectedConnectionOverlay(selectedDiagramElement,
											(BaseConnectionNode) selectedNode, primary));
						}
					}
				}
			}

			diagramElementToSelectedNodeOverlayMap = newDiagramElementToSelectedNodeOverlayMapBuilder.build();

			// Update children to reflect the new nodes.
			getChildren().setAll((Collection<? extends Node>) diagramElementToSelectedNodeOverlayMap.values());
		});
	}

	private ArrayList<DiagramElement> selectionToDiagramElements(final IStructuredSelection selection) {
		final ArrayList<DiagramElement> diagramElements = new ArrayList<>(selection.size());

		for (final Object o : selection) {
			if (o instanceof DiagramElement) {
				diagramElements.add((DiagramElement) o);
			}
		}

		return diagramElements;
	}

	/**
	 * Interface shared by shape and connection overlays
	 */
	public static interface SelectedNodeOverlay {
		Node getSelectedNode();

		void setPrimary(boolean primary);
	}

	/**
	 * Overlay used for selected shapes. Specifically, {@link ContainerShape} and {@link DockedShape}.
	 */
	private static class SelectedShapeOverlay extends Group implements SelectedNodeOverlay {
		private static Vector resizeShapeDirections[] = { new Vector(-1.0, -1.0), new Vector(0.0, -1.0),
				new Vector(1.0, -1.0), new Vector(-1.0, 0.0), new Vector(1.0, 0.0), new Vector(-1.0, 1.0),
				new Vector(0.0, 1.0), new Vector(1.0, 1.0) };

		private Node selectedNode;
		private DoubleBinding selectionIndicatorWidthBinding;
		private DoubleBinding selectionIndicatorHeightBinding;
		private DoubleBinding selectionIndicatorXBinding;
		private DoubleBinding selectionIndicatorYBinding;
		private final Group selectionIndicator = new Group();
		private Rectangle selectionIndicatorRect;
		private List<DoubleBinding> handleBindings = new ArrayList<>(16);

		/**
		 * Creates a new instance.
		 * @param de is the diagram element which is represented by the selected node.
		 * @param selectedNode the node for which this instance is an overlay
		 * @param primary whether the selected node is the primary selection
		 */
		public SelectedShapeOverlay(final DiagramElement de, final Node selectedNode, boolean primary) {
			setAutoSizeChildren(false);
			this.selectedNode = selectedNode;
			selectionIndicator.setAutoSizeChildren(false);

			this.getChildren().add(selectionIndicator);

			// Set the transform of this node so that it matches the transform of the selected node
			final ChangeListener<? super Transform> transformUpdater = ((o, oldTransform, newTransform) -> {
				try {
					selectionIndicator.getTransforms().setAll(getLocalToSceneTransform().createInverse()
							.createConcatenation(selectedNode.getLocalToSceneTransform()));
				} catch (final NonInvertibleTransformException e) {
					throw new RuntimeException(e);
				}
			});
			localToSceneTransformProperty().addListener(transformUpdater);
			selectedNode.localToSceneTransformProperty().addListener(transformUpdater);

			// Create bindings for the selection bounds
			selectionIndicatorWidthBinding = new DoubleBinding() {
				{
					bind(selectedNode.layoutBoundsProperty());
				}

				@Override
				protected double computeValue() {
					return selectedNode.layoutBoundsProperty().get().getWidth();
				}
			};

			selectionIndicatorHeightBinding = new DoubleBinding() {
				{
					bind(selectedNode.layoutBoundsProperty());
				}

				@Override
				protected double computeValue() {
					return selectedNode.layoutBoundsProperty().get().getHeight();
				}
			};

			selectionIndicatorXBinding = new DoubleBinding() {
				{
					bind(selectedNode.layoutBoundsProperty());
				}

				@Override
				protected double computeValue() {
					return selectedNode.layoutBoundsProperty().get().getMinX();
				}
			};

			selectionIndicatorYBinding = new DoubleBinding() {
				{
					bind(selectedNode.layoutBoundsProperty());
				}

				@Override
				protected double computeValue() {
					return selectedNode.layoutBoundsProperty().get().getMinY();
				}
			};

			//
			// Selection Indicator
			//
			selectionIndicatorRect = new Rectangle();
			selectionIndicatorRect.setFill(null);
			selectionIndicatorRect.setStroke(OverlayColors.SELECTION_INDICATOR_COLOR);
			selectionIndicatorRect.setStrokeWidth(0.5);
			selectionIndicatorRect.widthProperty().bind(selectionIndicatorWidthBinding);
			selectionIndicatorRect.heightProperty().bind(selectionIndicatorHeightBinding);
			selectionIndicatorRect.xProperty().bind(selectionIndicatorXBinding);
			selectionIndicatorRect.yProperty().bind(selectionIndicatorYBinding);
			selectionIndicator.getChildren().add(selectionIndicatorRect);

			if (DiagramElementPredicates.isResizeable(de)) {
				// Create resize handles
				for (final Vector resizeDirection : resizeShapeDirections) {
					// Create the resize handle
					final ResizeShapeHandle handle = new ResizeShapeHandle(de, resizeDirection, primary);
					selectionIndicator.getChildren().add(handle);

					// Create handle position bindings
					final DoubleBinding xBinding = new DoubleBinding() {
						{
							bind(selectedNode.layoutBoundsProperty());
						}

						@Override
						protected double computeValue() {
							final Bounds selectedBounds = selectedNode.layoutBoundsProperty().get();
							final double halfWidth = selectedBounds.getWidth() / 2.0;
							return selectedBounds.getMinX() + halfWidth + (halfWidth * resizeDirection.x)
									- (handle.getWidth() / 2.0);
						}
					};
					final DoubleBinding yBinding = new DoubleBinding() {
						{
							bind(selectedNode.layoutBoundsProperty());
						}

						@Override
						protected double computeValue() {
							final Bounds selectedBounds = selectedNode.layoutBoundsProperty().get();
							final double halfHeight = selectedBounds.getHeight() / 2.0;
							return selectedBounds.getMinY() + halfHeight + (halfHeight * resizeDirection.y)
									- (handle.getHeight() / 2.0);
						}
					};

					handle.xProperty().bind(xBinding);
					handle.yProperty().bind(yBinding);

					// Store bindings to avoid garbage collection
					handleBindings.add(xBinding);
					handleBindings.add(yBinding);
				}
			}
		}

		@Override
		public Node getSelectedNode() {
			return selectedNode;
		}

		@Override
		public void setPrimary(boolean value) {
			for (final Node child : selectionIndicator.getChildren()) {
				if (child instanceof Handle) {
					((Handle) child).setPrimary(value);
				}
			}
		}
	}

	/**
	 * Overlay used for selected connections.
	 */
	private static class SelectedConnectionOverlay extends Group implements SelectedNodeOverlay {
		private final DiagramElement diagramElement;
		private BaseConnectionNode selectedNode;
		private boolean primary;
		private final Group handles = new Group();

		/**
		 * Connection points. Strong reference is stored to ensure events are freed.
		 */
		private final ObservableList<Point> connectionPoints;
		private InvalidationListener invalidationListener = (InvalidationListener) c ->
		{
			updateSelectionIndicator(selectedNode);
		};

		/**
		 * Creates a new instance.
		 * @param de is the diagram element which is represented by the selected node.
		 * @param selectedNode the node for which this instance is an overlay
		 * @param primary whether the selected node is the primary selection
		 */
		public SelectedConnectionOverlay(final DiagramElement diagramElement, final BaseConnectionNode selectedNode,
				final boolean primary) {
			this.diagramElement = diagramElement;
			this.selectedNode = selectedNode;
			this.primary = primary;
			setAutoSizeChildren(false);
			handles.setAutoSizeChildren(false);
			getChildren().add(handles);

			// Update transform on changes
			final ChangeListener<? super Transform> transformUpdater = ((o, oldTransform, newTransform) -> {
				try {
					handles.getTransforms().setAll(getLocalToSceneTransform().createInverse()
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

			connectionPoints = selectedNode.getInnerConnection().getPointsUnmodifiable();
			connectionPoints.addListener(new WeakInvalidationListener(invalidationListener));

			updateSelectionIndicator(selectedNode);
		}

		private void updateSelectionIndicator(final BaseConnectionNode selectedNode) {
			// Only remove visible children. Invisible children are retained and will be removed by whatever set them to invisible.
			// This is important to ensure events are received while dragging.
			handles.getChildren().removeIf(n -> n.isVisible());

			// Create new selection indicator
			final Connection c = selectedNode.getInnerConnection();

			// Create handles for control points
			final List<Point> controlPoints = c.getControlPoints();
			for (int controlPointIndex = 0; controlPointIndex < controlPoints.size(); controlPointIndex++) {
				final org.eclipse.gef.geometry.planar.Point prev = controlPointIndex == 0 ? controlPoints.get(0)
						: controlPoints.get(controlPointIndex - 1);
				final org.eclipse.gef.geometry.planar.Point p = controlPoints.get(controlPointIndex);
				final org.eclipse.gef.geometry.planar.Point mid = new Point((prev.x + p.x) / 2.0, (prev.y + p.y) / 2.0);

				// Create a handle for the control point
				final ControlPointHandle controlPointHandle = new ControlPointHandle(diagramElement, selectedNode,
						primary, controlPointIndex);
				controlPointHandle.setCenterX(p.x);
				controlPointHandle.setCenterY(p.y);
				handles.getChildren().add(controlPointHandle);

				// Create handle for creating new control points
				final CreateControlPointHandle createControlPointHandle = new CreateControlPointHandle(diagramElement,
						selectedNode, primary, controlPointIndex);
				createControlPointHandle.setCenterX(mid.x);
				createControlPointHandle.setCenterY(mid.y);
				handles.getChildren().add(createControlPointHandle);
			}

			// Create handle for flow indicator position
			if (selectedNode instanceof FlowIndicatorNode) {
				final FlowIndicatorPositionHandle handle = new FlowIndicatorPositionHandle(diagramElement,
						(FlowIndicatorNode) selectedNode, primary);
				final org.eclipse.gef.geometry.planar.Point p = connectionPoints.get(connectionPoints.size() - 1);
				handle.setCenterX(p.x);
				handle.setCenterY(p.y);
				handles.getChildren().add(handle);
			}
		}

		@Override
		public Node getSelectedNode() {
			return selectedNode;
		}

		@Override
		public void setPrimary(boolean value) {
			if (this.primary != value) {
				this.primary = value;
				for (final Node child : handles.getChildren()) {
					if (child instanceof Handle) {
						((Handle) child).setPrimary(value);
					}
				}
			}
		}
	}
}

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

import org.eclipse.gef.fx.nodes.Connection;
import org.eclipse.gef.geometry.euclidean.Vector;
import org.eclipse.gef.geometry.planar.Point;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Display;
import org.osate.ge.gef.AgeGefRuntimeException;
import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.gef.ContainerShape;
import org.osate.ge.gef.DockedShape;
import org.osate.ge.gef.FlowIndicatorNode;
import org.osate.ge.gef.LabelNode;
import org.osate.ge.gef.ui.diagram.GefAgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;

import com.google.common.collect.ImmutableMap;

import javafx.beans.InvalidationListener;
import javafx.beans.WeakInvalidationListener;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.WeakChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Transform;

/**
 * A group for diagram overlays. Also handles the creation and removal of overlays for the current selection.
 * Each overlay is attached to another node and provides node and contains a selection indicator, resize handles, etc.
 *
 * This class assumes that the provided selection contains {@link DiagramElement} instances and that it does not contain
 * duplicates. Other objects are ignored.
 */
public class Overlays extends Group implements ISelectionChangedListener {
	private final GefAgeDiagram gefDiagram;

	/**
	 * Overlays for the current selection.
	 */
	private final Group selectionOverlays = new Group();

	/**
	 * Mapping from diagram elements to the selected node overlays.
	 */
	private Map<DiagramElement, SelectedNodeOverlay> diagramElementToSelectedNodeOverlayMap = Collections.emptyMap();

	/**
	 * Property for the transform between scene coordinates and the overlay
	 */
	private final ReadOnlyObjectWrapper<Transform> sceneToLocalTransform = new ReadOnlyObjectWrapper<Transform>();

	/**
	 * Property for the transform between diagram coordinates and the overlay
	 */
	private final ReadOnlyObjectWrapper<Transform> diagramToLocalTransform = new ReadOnlyObjectWrapper<Transform>();

	public Overlays(final GefAgeDiagram gefDiagram) {
		this.gefDiagram = gefDiagram;
		this.setAutoSizeChildren(false);

		selectionOverlays.setAutoSizeChildren(false);
		this.getChildren().add(selectionOverlays);

		// Bind properties
		sceneToLocalTransform.bind(new ObjectBinding<Transform>() {
			{
				bind(localToSceneTransformProperty());
			}

			@Override
			protected Transform computeValue() {
				try {
					return getLocalToSceneTransform().createInverse();
				} catch (final NonInvertibleTransformException e) {
					throw new AgeGefRuntimeException("Unable to create scene to overlay transform", e);
				}
			}
		});

		final ReadOnlyObjectProperty<Transform> diagramToSceneTransform = gefDiagram.getSceneNode()
				.localToSceneTransformProperty();
		diagramToLocalTransform.bind(new ObjectBinding<Transform>() {
			{
				bind(diagramToSceneTransform, sceneToLocalTransform);
			}

			@Override
			protected Transform computeValue() {
				return sceneToLocalTransform.get().createConcatenation(diagramToSceneTransform.get());

			}
		});
	}

	/**
	 * The transform between scene to the overlay coordinate system.
	 * @return the transform from scene to the overlay coordinate system.
	 */
	public final ReadOnlyObjectProperty<Transform> sceneToLocalTransformProperty() {
		return sceneToLocalTransform.getReadOnlyProperty();
	}

	/**
	 * Returns the current value of {@link #sceneToLocalTransformProperty()}
	 * @return the current value of {@link #sceneToLocalTransformProperty()}
	 */
	public final Transform getSceneToLocalTransform() {
		return sceneToLocalTransformProperty().get();
	}

	/**
	 * The transform between diagram to the overlay coordinate system.
	 * @return the transform from diagram to the overlay coordinate system.
	 */
	public final ReadOnlyObjectProperty<Transform> diagramToLocalTransformProperty() {
		return diagramToLocalTransform.getReadOnlyProperty();
	}

	/**
	 * Returns the current value of {@link #diagramToLocalTransformProperty()}
	 * @return the current value of {@link #diagramToLocalTransformProperty()}
	 */
	public final Transform getDiagramToLocalTransform() {
		return diagramToLocalTransformProperty().get();
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
				if (selectedDiagramElements.contains(existingEntry.getKey()) && gefDiagram
						.getSceneNode(existingEntry.getKey()) == existingEntry.getValue().getSelectedNode()) {
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
					final Node selectedNode = gefDiagram.getSceneNode(selectedDiagramElement);
					if (selectedNode != null) {
						if (selectedNode instanceof ContainerShape || selectedNode instanceof DockedShape
								|| selectedNode instanceof LabelNode) {
							newDiagramElementToSelectedNodeOverlayMapBuilder.put(selectedDiagramElement,
									new SelectedShapeOverlay(this, selectedDiagramElement, selectedNode, primary));
						} else if (selectedNode instanceof BaseConnectionNode) {
							// Create overlay for connection nodes
							newDiagramElementToSelectedNodeOverlayMapBuilder.put(selectedDiagramElement,
									new SelectedConnectionOverlay(this, selectedDiagramElement,
											(BaseConnectionNode) selectedNode, primary));
						}
					}
				}
			}

			diagramElementToSelectedNodeOverlayMap = newDiagramElementToSelectedNodeOverlayMapBuilder.build();

			// Update children to reflect the new nodes.
			selectionOverlays.getChildren()
					.setAll((Collection<? extends Node>) diagramElementToSelectedNodeOverlayMap.values());
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
		private final Group selectionIndicator = new Group();
		private Rectangle selectionIndicatorRect;

		/**
		 * Creates a new instance.
		 * @param overlays is the overlays object that will be used to determine the transform into local space. This instance
		 * must be in the same coordinate system as the specified overlays.
		 * @param de is the diagram element which is represented by the selected node.
		 * @param selectedNode the node for which this instance is an overlay
		 * @param primary whether the selected node is the primary selection
		 */
		public SelectedShapeOverlay(final Overlays overlays, final DiagramElement de, final Node selectedNode,
				boolean primary) {
			setAutoSizeChildren(false);
			this.selectedNode = selectedNode;
			selectionIndicator.setAutoSizeChildren(false);

			this.getChildren().add(selectionIndicator);

			// Binding which transforms the selected node's layout bounds into the local coordinate system.
			final ObjectBinding<Bounds> selectedNodeLayoutBoundsInLocal = new ObjectBinding<Bounds>() {
				{
					bind(overlays.sceneToLocalTransformProperty(), selectedNode.localToSceneTransformProperty(),
							selectedNode.layoutBoundsProperty());
				}

				@Override
				protected Bounds computeValue() {
					return overlays.getSceneToLocalTransform()
							.transform(
									selectedNode.getLocalToSceneTransform().transform(selectedNode.getLayoutBounds()));
				}
			};

			//
			// Selection Indicator
			//
			selectionIndicatorRect = new Rectangle();
			selectionIndicatorRect.setFill(null);
			selectionIndicatorRect.setStroke(OverlayColors.SELECTION_INDICATOR_COLOR);
			selectionIndicatorRect.setStrokeWidth(1.0);
			selectionIndicatorRect.widthProperty().bind(new DoubleBinding() {
				{
					bind(selectedNodeLayoutBoundsInLocal);
				}

				@Override
				protected double computeValue() {
					return selectedNodeLayoutBoundsInLocal.get().getWidth();
				}
			});
			selectionIndicatorRect.heightProperty().bind(new DoubleBinding() {
				{
					bind(selectedNodeLayoutBoundsInLocal);
				}

				@Override
				protected double computeValue() {
					return selectedNodeLayoutBoundsInLocal.get().getHeight();
				}
			});
			selectionIndicatorRect.xProperty().bind(new DoubleBinding() {
				{
					bind(selectedNodeLayoutBoundsInLocal);
				}

				@Override
				protected double computeValue() {
					return selectedNodeLayoutBoundsInLocal.get().getMinX();
				}
			});
			selectionIndicatorRect.yProperty().bind(new DoubleBinding() {
				{
					bind(selectedNodeLayoutBoundsInLocal);
				}

				@Override
				protected double computeValue() {
					return selectedNodeLayoutBoundsInLocal.get().getMinY();
				}
			});
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
							bind(selectedNodeLayoutBoundsInLocal);
						}

						@Override
						protected double computeValue() {
							final Bounds selectedBounds = selectedNodeLayoutBoundsInLocal.get();
							final double halfWidth = selectedBounds.getWidth() / 2.0;
							return selectedBounds.getMinX() + halfWidth + (halfWidth * resizeDirection.x)
									- (handle.getWidth() / 2.0);
						}
					};
					final DoubleBinding yBinding = new DoubleBinding() {
						{
							bind(selectedNodeLayoutBoundsInLocal);
						}

						@Override
						protected double computeValue() {
							final Bounds selectedBounds = selectedNodeLayoutBoundsInLocal.get();
							final double halfHeight = selectedBounds.getHeight() / 2.0;
							return selectedBounds.getMinY() + halfHeight + (halfHeight * resizeDirection.y)
									- (handle.getHeight() / 2.0);
						}
					};

					handle.xProperty().bind(xBinding);
					handle.yProperty().bind(yBinding);
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
		private final Overlays overlays;
		private final DiagramElement diagramElement;
		private BaseConnectionNode selectedNode;
		private boolean primary;
		private final Group handles = new Group();

		/**
		 * Connection points. Strong reference is stored to ensure events are freed.
		 */
		private final ObservableList<Point> connectionPoints;
		private InvalidationListener invalidationListener = (InvalidationListener) c -> {
			// This is required because control points may not be updated when this is called
			selectedNode.refresh();
			updateSelectionIndicator(selectedNode);
		};

		private ChangeListener<?> changeListener = (ChangeListener<?>) (o, oldValue, newValue) -> {
			updateSelectionIndicator(selectedNode);
		};

		/**
		 * Creates a new instance.
		 * @param overlays is the overlays object that will be used to determine the transform into local space. This instance
		 * must be in the same coordinate system as the specified overlays.
		 * @param de is the diagram element which is represented by the selected node.
		 * @param selectedNode the node for which this instance is an overlay
		 * @param primary whether the selected node is the primary selection
		 */
		@SuppressWarnings("unchecked")
		public SelectedConnectionOverlay(final Overlays overlays, final DiagramElement diagramElement,
				final BaseConnectionNode selectedNode,
				final boolean primary) {
			this.overlays = overlays;
			this.diagramElement = diagramElement;
			this.selectedNode = selectedNode;
			this.primary = primary;
			setAutoSizeChildren(false);
			handles.setAutoSizeChildren(false);
			getChildren().add(handles);

			// Update the selection indicator whenever the curve changes
			selectedNode.getInnerConnection()
					.curveProperty()
					.addListener(new WeakChangeListener<Node>((ChangeListener<Node>) changeListener));
			selectedNode.localToSceneTransformProperty()
					.addListener(new WeakChangeListener<Transform>((ChangeListener<Transform>) changeListener));

			connectionPoints = selectedNode.getInnerConnection().getPointsUnmodifiable();
			connectionPoints.addListener(new WeakInvalidationListener(invalidationListener));

			updateSelectionIndicator(selectedNode);
		}

		private void updateSelectionIndicator(final BaseConnectionNode selectedNode) {
			final Transform selectedToOverlayTransform = overlays.getSceneToLocalTransform()
					.createConcatenation(selectedNode.getLocalToSceneTransform());

			// Only remove visible children. Invisible children are retained and will be removed by whatever set them to invisible.
			// This is important to ensure events are received while dragging.
			handles.getChildren().removeIf(n -> n.isVisible());

			// Create new selection indicator
			final Connection c = selectedNode.getInnerConnection();

			// Create handles for control points
			final List<Point> allPoints = c.getPointsUnmodifiable();
			final List<Point> controlPoints = c.getControlPoints();
			for (int controlPointIndex = 0; controlPointIndex <= controlPoints.size(); controlPointIndex++) {
				final org.eclipse.gef.geometry.planar.Point prev = controlPointIndex == 0 ? allPoints.get(0)
						: controlPoints.get(controlPointIndex - 1);
				final org.eclipse.gef.geometry.planar.Point p = controlPointIndex == controlPoints.size()
						? allPoints.get(allPoints.size() - 1)
						: controlPoints.get(controlPointIndex);
				final Point2D midInLocal = selectedToOverlayTransform
						.transform((prev.x + p.x) / 2.0, (prev.y + p.y) / 2.0);

				// Create a handle for the control point
				if (controlPointIndex < controlPoints.size()) {
					final ControlPointHandle controlPointHandle = new ControlPointHandle(diagramElement, selectedNode,
							primary, controlPointIndex);
					final Point2D pInLocal = selectedToOverlayTransform.transform(p.x, p.y);
					controlPointHandle.setCenterX(pInLocal.getX());
					controlPointHandle.setCenterY(pInLocal.getY());
					handles.getChildren().add(controlPointHandle);
				}

				// Create handle for creating new control points
				final CreateControlPointHandle createControlPointHandle = new CreateControlPointHandle(diagramElement,
						selectedNode, primary, controlPointIndex);
				createControlPointHandle.setCenterX(midInLocal.getX());
				createControlPointHandle.setCenterY(midInLocal.getY());
				handles.getChildren().add(createControlPointHandle);
			}

			// Create handle for flow indicator position
			if (selectedNode instanceof FlowIndicatorNode) {
				final FlowIndicatorPositionHandle handle = new FlowIndicatorPositionHandle(diagramElement,
						(FlowIndicatorNode) selectedNode, primary);
				final org.eclipse.gef.geometry.planar.Point p = connectionPoints.get(connectionPoints.size() - 1);
				final Point2D pInLocal = selectedToOverlayTransform.transform(p.x, p.y);
				handle.setCenterX(pInLocal.getX());
				handle.setCenterY(pInLocal.getY());
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

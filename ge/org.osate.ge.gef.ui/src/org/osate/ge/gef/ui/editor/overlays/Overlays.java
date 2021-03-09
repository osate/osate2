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
import org.eclipse.gef.fx.nodes.GeometryNode;
import org.eclipse.gef.geometry.euclidean.Vector;
import org.eclipse.gef.geometry.planar.IGeometry;
import org.eclipse.gef.geometry.planar.Point;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Display;
import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.gef.ContainerShape;
import org.osate.ge.gef.DockedShape;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

import com.google.common.collect.ImmutableMap;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
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

	// This should be called by the editor whenever a change could affect the overlay.
	// Specifically, it needs to be called whenever the diagram changes. Connection diagram elements may change to shapes and vice versa
	// which would cause the nodes to change without changing the selected diagram elements.
	@SuppressWarnings("unchecked")
	public void refresh(final IStructuredSelection selection) {
		Display.getCurrent().asyncExec(() -> {
			final ImmutableMap.Builder<DiagramElement, SelectedNodeOverlay> newDiagramElementToSelectedNodeOverlayMapBuilder = ImmutableMap
					.builderWithExpectedSize(selection.size());

			final ArrayList<DiagramElement> selectedDiagramElements = selectionToDiagramElements(selection);
			// TODO; Filter out those without nodes?

			// TODO: Handle nodes being different for same diagram element...

			// TODO: Copy over
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
				final SelectedNodeOverlay existingOverlay = diagramElementToSelectedNodeOverlayMap.get(selectedDiagramElement);
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

			// TODO: Rename
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
		Node getSelectedNode(); // TODO: Rename

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

		// TODO: Document all parameters
		/**
		 * Creates a new instance.
		 * @param selectedNode the node for which this instance is an overlay
		 * @param primary whether the selected node is the primary selection
		 */
		public SelectedShapeOverlay(final DiagramElement de, final Node selectedNode, boolean primary) {
			setAutoSizeChildren(false);
			this.selectedNode = selectedNode;
			selectionIndicator.setAutoSizeChildren(false);

			this.getChildren().add(selectionIndicator);

			// Set the transform of this node so that it matches the transform of hte selected node
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

			// Create resize handles
			// TODO: Rename hv
			for (final Vector hv : resizeShapeDirections) {
				// Create the resize handle
				final ResizeShapeHandle handle = new ResizeShapeHandle(de, hv, primary);
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
						return selectedBounds.getMinX() + halfWidth + (halfWidth * hv.x) - (handle.getWidth() / 2.0);
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
						return selectedBounds.getMinY() + halfHeight + (halfHeight * hv.y) - (handle.getHeight() / 2.0);
					}
				};

				handle.xProperty().bind(xBinding);
				handle.yProperty().bind(yBinding);

				// Store bindings to avoid garbage collection
				handleBindings.add(xBinding);
				handleBindings.add(yBinding);
			}
		}

		@Override
		public Node getSelectedNode() {
			return selectedNode;
		}

		@Override
		public void setPrimary(boolean value) {
			// TODO: Share with other
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
		private final Node selectedNode;
		private boolean primary;
		private final Group selectionIndicatorContainer = new Group();

		// TODO: Document all parmaeters
		/**
		 * Creates a new instance.
		 * @param selectedNode the node for which this instance is an overlay
		 * @param primary whether the selected node is the primary selection
		 */
		public SelectedConnectionOverlay(final DiagramElement diagramElement, final BaseConnectionNode selectedNode,
				final boolean primary) {
			this.diagramElement = diagramElement;
			this.selectedNode = selectedNode;
			this.primary = primary;
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
			final Connection c = selectedNode.getInnerConnection();
			final Node curve = c.getCurve();
			if (curve instanceof GeometryNode) {
				final GeometryNode<?> gn = (GeometryNode<?>) curve;
				final IGeometry g = gn.getGeometry();
				final IGeometry copy = g.getCopy();
				final GeometryNode<IGeometry> selectionIndicator = new GeometryNode<IGeometry>(copy);
				selectionIndicator.setStroke(OverlayColors.SELECTION_INDICATOR_COLOR);
				selectionIndicator.setStrokeWidth(4.0);
				selectionIndicator.setStrokeLineCap(StrokeLineCap.BUTT);
				selectionIndicatorContainer.getChildren().add(selectionIndicator);
			}

			// Create handles for control points
			for (final org.eclipse.gef.geometry.planar.Point cp : c.getControlPoints()) {
				// Create handle
				final BendpointHandle handle = new BendpointHandle(diagramElement, primary);
				handle.setCenterX(cp.x);
				handle.setCenterY(cp.y);
				selectionIndicatorContainer.getChildren().add(handle);
			}

			// Create handles in between points to allow creating bendpoints
			final List<org.eclipse.gef.geometry.planar.Point> points = c.getPointsUnmodifiable();
			for (int i = 1; i < points.size(); i++) {
				final org.eclipse.gef.geometry.planar.Point prev = points.get(i - 1);
				final org.eclipse.gef.geometry.planar.Point p = points.get(i);
				final org.eclipse.gef.geometry.planar.Point mid = new Point((prev.x + p.x) / 2.0, (prev.y + p.y) / 2.0);

				// Create handle
				final CreateBendpointHandle handle = new CreateBendpointHandle(diagramElement, primary);
				handle.setCenterX(mid.x);
				handle.setCenterY(mid.y);
				selectionIndicatorContainer.getChildren().add(handle);
			}
		}

		@Override
		public Node getSelectedNode() {
			return selectedNode;
		}

		@Override
		public void setPrimary(boolean value) {
			for (final Node child : selectionIndicatorContainer.getChildren()) {
				if (child instanceof Handle) {
					((Handle) child).setPrimary(value);
				}
			}
		}
	}
}

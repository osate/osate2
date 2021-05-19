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
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.gef.ConnectionNode;
import org.osate.ge.gef.ContainerShape;
import org.osate.ge.gef.DockSide;
import org.osate.ge.gef.DockedShape;
import org.osate.ge.gef.LabelNode;
import org.osate.ge.gef.PreferredPosition;
import org.osate.ge.gef.ui.diagram.GefAgeDiagramUtil;
import org.osate.ge.gef.ui.editor.overlays.GuideOverlay;
import org.osate.ge.internal.diagram.runtime.AgeDiagramUtil;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.diagram.runtime.DiagramNode;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Transform;

/**
 *  {@link InputEventHandler} which handles moving diagram elements.
 */
public class MoveInputEventHandler implements InputEventHandler {
	/**
	 * Minimum mouse dragged distance in diagram coordinates before starting the move interaction.
	 * This avoids starting the move interaction when the user is attempting to perform a rename or other interaction.
	 */
	private static double MIN_MOUSE_DRAGGED_DISTANCE = 10.0;

	private final AgeEditor editor;

	/**
	 * Location of the last mouse pressed event in diagram coordinates. Used to determine if the mouse was dragged enough to
	 * start the move interaction.
	 */
	private Point2D mousePressLocationDiagram;

	/**
	 * The primary connection label from the mouse pressed event. Null if a primary connection label was not clicked.
	 */
	private Node mousePressPrimaryConnectionLabel;

	public MoveInputEventHandler(final AgeEditor editor) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");
	}

	@Override
	public Cursor getCursor(final MouseEvent mouseMoveEvent) {
		return null;
	}

	@Override
	public HandledEvent handleEvent(final InputEvent e) {
		if (!editor.getPaletteModel().isSelectToolActive()) {
			return null;
		}

		if (e instanceof MouseEvent) {
			final MouseEvent mouseEvent = (MouseEvent) e;
			if ((mouseEvent.getEventType() != MouseEvent.MOUSE_PRESSED
					&& mouseEvent.getEventType() != MouseEvent.MOUSE_DRAGGED)
					|| mouseEvent.getButton() != MouseButton.PRIMARY) {
				return null;
			}

			final DiagramElement clickedDiagramElement = InputEventHandlerUtil
					.getTargetDiagramElement(editor.getGefDiagram(), e.getTarget());
			if (clickedDiagramElement == null) {
				return null;
			}

			if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
				// Store the starting position.
				mousePressLocationDiagram = editor.getGefDiagram()
						.getSceneNode()
						.getSceneToLocalTransform()
						.transform(mouseEvent.getSceneX(), mouseEvent.getSceneY());

				// Determine if the primary label is the node being moved
				mousePressPrimaryConnectionLabel = null;
				if (DiagramElementPredicates.isConnection(clickedDiagramElement)) {
					for (Node tmp = (Node) e.getTarget(); tmp != null; tmp = tmp.getParent()) {
						if (tmp instanceof BaseConnectionNode) {
							break;
						}

						if (tmp instanceof LabelNode) {
							mousePressPrimaryConnectionLabel = tmp;
							break;
						}
					}
				}
			} else if (e.getEventType() == MouseEvent.MOUSE_DRAGGED && mousePressLocationDiagram != null) {
				final Point2D newPositionDiagram = editor.getGefDiagram()
						.getSceneNode()
						.getSceneToLocalTransform()
						.transform(mouseEvent.getSceneX(), mouseEvent.getSceneY());
				final double d = mousePressLocationDiagram.distance(newPositionDiagram);
				if (d > MIN_MOUSE_DRAGGED_DISTANCE) {
					try {
						if (mousePressPrimaryConnectionLabel == null) {
							final MouseMoveSelectedElementsInteraction newInteraction = new MouseMoveSelectedElementsInteraction(
									editor, mousePressLocationDiagram);
							return HandledEvent.newInteraction(newInteraction);
						} else {
							final BaseConnectionNode cn = InputEventHandlerUtil
									.getClosestConnection(mousePressPrimaryConnectionLabel);
							if (cn == null) {
								return null;
							}

							final MovePrimaryConnectionLabelInteraction newInteraction = new MovePrimaryConnectionLabelInteraction(
									editor, mousePressLocationDiagram, cn, mousePressPrimaryConnectionLabel);

							return HandledEvent.newInteraction(newInteraction);
						}
					} finally {
						mousePressLocationDiagram = null;
					}
				}
			}

			return HandledEvent.consumed();
		} else if (e instanceof KeyEvent) {
			if (e.getEventType() != KeyEvent.KEY_PRESSED) {
				return null;
			}

			final KeyEvent keyEvent = (KeyEvent) e;
			if (keyEvent.getCode() != KeyCode.PERIOD) {
				return null;
			}

			final KeyboardMoveSelectedElementsInteraction newInteraction = new KeyboardMoveSelectedElementsInteraction(
					editor);
			return HandledEvent.newInteraction(newInteraction);
		} else {
			return null;
		}
	}
}

/**
 * Interaction for moving a primary primary connection label using the mouse.
 */
class MovePrimaryConnectionLabelInteraction extends BaseInteraction {
	private final AgeEditor editor;
	private final Node label;
	private final Point2D initialClickLocationInDiagram;
	private final Point2D connectionMidpointPositionInDiagram;
	private final Bounds originalLabelLayoutInDiagram;

	public MovePrimaryConnectionLabelInteraction(final AgeEditor editor, final Point2D initialClickLocationInDiagram,
			final BaseConnectionNode connection, final Node label) {
		this.editor = editor;
		this.label = label;
		this.initialClickLocationInDiagram = initialClickLocationInDiagram;

		final Transform sceneToDiagramTransform = editor.getGefDiagram().getSceneNode().getSceneToLocalTransform();
		this.connectionMidpointPositionInDiagram = sceneToDiagramTransform
				.transform(connection.getLocalToSceneTransform().transform(connection.getMidpointAnchorPosition()));
		this.originalLabelLayoutInDiagram = sceneToDiagramTransform
				.transform(label.getLocalToSceneTransform().transform(label.getLayoutBounds()));
	}

	@Override
	public void close() {
		// Update scene graph based on diagram elements. This is needed to revert any scene changes that have been made
		// during the interaction and to ensure that the scene node reflects the diagram elements after modification.
		editor.getGefDiagram().updateSceneGraph();
	}

	@Override
	public Cursor getCursor() {
		return Cursor.MOVE;
	}

	@Override
	protected Interaction.InteractionState onMouseDragged(final MouseEvent e) {
		if (e.getButton() != MouseButton.PRIMARY) {
			return super.onMouseDragged(e);
		}

		final Transform sceneToDiagramTransform = editor.getGefDiagram().getSceneNode().getSceneToLocalTransform();
		final Point2D eventInDiagram = sceneToDiagramTransform.transform(e.getSceneX(), e.getSceneY());
		final Point2D totalDelta = eventInDiagram.subtract(initialClickLocationInDiagram);

		// Calculate a new position and update the preferred position of the label
		final double originalX = originalLabelLayoutInDiagram.getMinX();
		final double originalY = originalLabelLayoutInDiagram.getMinY();
		final double newPositionX = InputEventHandlerUtil.snapX(editor, originalX + totalDelta.getX(), false);
		final double newPositionY = InputEventHandlerUtil.snapX(editor, originalY + totalDelta.getY(), false);
		PreferredPosition.set(label, new Point2D(newPositionX - connectionMidpointPositionInDiagram.getX(),
				newPositionY - connectionMidpointPositionInDiagram.getY()));

		return InteractionState.IN_PROGRESS;
	}

	@Override
	protected Interaction.InteractionState onMouseReleased(final MouseEvent e) {
		if (e.getButton() != MouseButton.PRIMARY) {
			return super.onMousePressed(e);
		}

		// Move diagram elements by updating the diagram to reflect the current scene graph
		editor.getDiagram().modify("Move", m -> {
			editor.getGefDiagram().updateDiagramFromSceneGraph();
		});

		return InteractionState.COMPLETE;
	}
}

/**
 * Interaction for moving selected diagram elements using the mouse.
 * Dragging the primary mouse button moves the selected diagram elements.
 * The diagram is updated when the primary mouse button is released.
 */
class MouseMoveSelectedElementsInteraction extends BaseInteraction {
	private final AgeEditor editor;
	private final SelectedElementsMover mover;
	private final Point2D initialClickLocationInDiagram;

	public MouseMoveSelectedElementsInteraction(final AgeEditor editor, final Point2D initialClickLocationInDiagram) {
		this.editor = editor;
		this.mover = new SelectedElementsMover(editor);
		this.initialClickLocationInDiagram = initialClickLocationInDiagram;
	}

	@Override
	public void close() {
		mover.close();
	}

	@Override
	public Cursor getCursor() {
		return Cursor.MOVE;
	}

	@Override
	protected Interaction.InteractionState onMouseDragged(final MouseEvent e) {
		if (e.getButton() != MouseButton.PRIMARY) {
			return super.onMouseDragged(e);
		}

		final Transform sceneToDiagramTransform = editor.getGefDiagram().getSceneNode().getSceneToLocalTransform();
		final Point2D eventInDiagram = sceneToDiagramTransform.transform(e.getSceneX(), e.getSceneY());
		final Point2D totalDelta = eventInDiagram.subtract(initialClickLocationInDiagram);
		final boolean snapToGrid = !e.isAltDown();

		mover.updateSceneGraph(totalDelta, snapToGrid);

		return InteractionState.IN_PROGRESS;
	}

	@Override
	protected Interaction.InteractionState onMouseReleased(final MouseEvent e) {
		if (e.getButton() != MouseButton.PRIMARY) {
			return super.onMousePressed(e);
		}

		mover.apply();

		return InteractionState.COMPLETE;
	}
}

/**
 * Interaction for moving selected diagram elements using the keyboard.
 * The position of selected nodes are changed using the arrow keys.
 * The diagram is updated when the user pressed "Enter"
 */
class KeyboardMoveSelectedElementsInteraction extends BaseInteraction {
	private static double NORMAL_STEP_SIZE = 10;
	private static double SMALL_STEP_SIZE = 1;

	private final SelectedElementsMover mover;
	private Point2D totalDelta = Point2D.ZERO;

	public KeyboardMoveSelectedElementsInteraction(final AgeEditor editor) {
		this.mover = new SelectedElementsMover(editor);
	}

	@Override
	public void close() {
		mover.close();
	}

	@Override
	public Cursor getCursor() {
		return Cursor.MOVE;
	}

	@Override
	protected Interaction.InteractionState onMousePressed(final MouseEvent e) {
		return InteractionState.COMPLETE;
	}

	@Override
	protected Interaction.InteractionState onKeyPressed(final KeyEvent e) {
		final boolean snapToGrid = !e.isAltDown();
		final double stepSize = snapToGrid ? NORMAL_STEP_SIZE : SMALL_STEP_SIZE;

		if (e.getCode() == KeyCode.ENTER) {
			mover.apply();
			return InteractionState.COMPLETE;
		} else if (e.getCode() == KeyCode.LEFT) {
			shiftSelectedDiagramElements(-stepSize, 0.0, snapToGrid);
			return InteractionState.IN_PROGRESS;
		} else if (e.getCode() == KeyCode.RIGHT) {
			shiftSelectedDiagramElements(stepSize, 0.0, snapToGrid);
			return InteractionState.IN_PROGRESS;
		} else if (e.getCode() == KeyCode.UP) {
			shiftSelectedDiagramElements(0.0, -stepSize, snapToGrid);
			return InteractionState.IN_PROGRESS;
		} else if (e.getCode() == KeyCode.DOWN) {
			shiftSelectedDiagramElements(0.0, stepSize, snapToGrid);
			return InteractionState.IN_PROGRESS;
		} else {
			return super.onKeyPressed(e);
		}
	}

	private void shiftSelectedDiagramElements(final double dx, final double dy, final boolean snapToGrid) {
		totalDelta = totalDelta.add(dx, dy);
		mover.updateSceneGraph(totalDelta, snapToGrid);
	}
}

/**
 * Class which handles moving the diagram elements which are selected at the time of instantiation.
 */
class SelectedElementsMover implements AutoCloseable {
	/**
	 * Maximum number of connections to show while moving. This avoids performance issues related to updating affected
	 * connections.
	 */
	private static final int MAX_SHOWN_AFFECTED_CONNECTIONS = 5;

	private final AgeEditor editor;
	private final List<DiagramElementSnapshot> elementsToMove;
	private final GuideOverlay guides;

	// Flag which indicates whether affected connections will be shown while moving. If false then the connections are hidden
	// and the control points are updated after movement is complete.
	private final boolean showAffectedConnections;

	/**
	 * Creates a new instance. This instance will move diagram elements which are selected at the time the
	 * object is instantiated.
	 * @param editor the editor which contain the diagram.
	 */
	public SelectedElementsMover(final AgeEditor editor) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");
		this.elementsToMove = createMoveElementSnapshotsForSelection(editor);
		this.guides = new GuideOverlay(editor,
				elementsToMove.stream().map(s -> s.diagramElement).collect(Collectors.toSet()));
		this.showAffectedConnections = elementsToMove.stream()
				.flatMap(s -> s.affectedConnections.stream())
				.filter(DiagramElementPredicates::isRegularConnection)
				.count() <= MAX_SHOWN_AFFECTED_CONNECTIONS;
		if (!showAffectedConnections) {
			setAffectedConnectionsVisible(false);
		}
	}

	@Override
	public void close() {
		this.guides.close();

		if (!showAffectedConnections) {
			setAffectedConnectionsVisible(true);
		}

		// Update scene graph based on diagram elements. This is needed to revert any scene changes that have been made
		// during the interaction and to ensure that the scene node reflects the diagram elements after modification.
		editor.getGefDiagram().updateSceneGraph();
	}

	/**
	 * Updates the positions of scene graph nodes.
	 * @param totalPositionDelta the total movement since the beginning of the interaction.
	 * @param snapToGrid whether the positions should be snapped to grid. Ignored for connection labels.
	 */
	public void updateSceneGraph(final Point2D totalPositionDelta, final boolean snapToGrid) {
		final Transform sceneToDiagramTransform = editor.getGefDiagram().getSceneNode().getSceneToLocalTransform();

		// Reset guide
		guides.reset();

		// Move nodes
		for (final DiagramElementSnapshot snapshot : elementsToMove) {
			if (snapshot.sceneNode instanceof LabelNode) {
				final BaseConnectionNode cn = InputEventHandlerUtil.getClosestConnection(snapshot.sceneNode);

				// Secondary connection label
				if (cn != null) {
					// Determine the new position in diagram coordinates
					final double newPositionX = InputEventHandlerUtil.snapX(editor,
							snapshot.boundsInDiagram.getMinX() + totalPositionDelta.getX(), false);
					final double newPositionY = InputEventHandlerUtil.snapX(editor,
							snapshot.boundsInDiagram.getMinY() + totalPositionDelta.getY(), false);

					// Set the new position relative to the midpoint
					final Point2D connectionMidpointPositionInDiagram = sceneToDiagramTransform
							.transform(cn.getLocalToSceneTransform().transform(cn.getMidpointAnchorPosition()));
					PreferredPosition.set(snapshot.sceneNode,
							new Point2D(newPositionX - connectionMidpointPositionInDiagram.getX(),
									newPositionY - connectionMidpointPositionInDiagram.getY()));
				}
			} else {
				// Determine snapped position
				double newPositionX = snapshot.positionInLocal.getX() + (InputEventHandlerUtil.snapX(editor,
						snapshot.boundsInDiagram.getMinX() + totalPositionDelta.getX(), snapToGrid)
						- snapshot.boundsInDiagram.getMinX());
				double newPositionY = snapshot.positionInLocal.getY() + (InputEventHandlerUtil.snapY(editor,
						snapshot.boundsInDiagram.getMinY() + totalPositionDelta.getY(), snapToGrid)
						- snapshot.boundsInDiagram.getMinY());

				// Constrain the position to the container
				final Node container = InputEventHandlerUtil.getLogicalShapeContainer(snapshot.sceneNode);
				if (container instanceof ContainerShape) {
					final Bounds parentBounds = container.getLayoutBounds();
					newPositionX = Math.max(0,
							Math.min(newPositionX, parentBounds.getWidth() - snapshot.boundsInDiagram.getWidth()));
					newPositionY = Math.max(0,
							Math.min(newPositionY, parentBounds.getHeight() - snapshot.boundsInDiagram.getHeight()));
				}

				// Update guide overlay
				if (guides.shouldUpdate()) {
					guides.update(sceneToDiagramTransform.transform(snapshot.sceneNode.getLocalToSceneTransform()
							.transform(snapshot.sceneNode.getLayoutBounds())));
				}

				// Adjust the position and size
				final Point2D currentPreferredPosition = PreferredPosition.get(snapshot.sceneNode);
				if (currentPreferredPosition == null || currentPreferredPosition.getX() != newPositionX
						|| currentPreferredPosition.getY() != newPositionY) {
					PreferredPosition.set(snapshot.sceneNode, new Point2D(newPositionX, newPositionY));

					if (showAffectedConnections) {
						final double dx = currentPreferredPosition == null ? 0
								: (newPositionX - currentPreferredPosition.getX());
						final double dy = currentPreferredPosition == null ? 0
								: (newPositionY - currentPreferredPosition.getY());
						shiftAffectedConnections(snapshot, dx, dy);
					}

					// Update side for docked shapes
					if (snapshot.sceneNode instanceof DockedShape) {
						final DockedShape ds = (DockedShape) snapshot.sceneNode;
						if (container instanceof ContainerShape) {
							final ContainerShape cs = (ContainerShape) container;
							final Bounds containerBounds = cs.getLayoutBounds();
							final DockSide side = GefAgeDiagramUtil
									.toDockSide(AgeDiagramUtil.determineDockingPosition(containerBounds.getWidth(),
											containerBounds.getHeight(), newPositionX, newPositionY,
											snapshot.boundsInDiagram.getWidth(), snapshot.boundsInDiagram.getHeight())
											.getDefaultDockArea());
							cs.addOrUpdateDockedChild(ds, side);
						}
					}
				}
			}
		}
	}

	/**
	 * Finalizes movement and updates the diagram to match. Should only be called once.
	 */
	public void apply() {
		// Move connection bendpoints
		if (!this.showAffectedConnections) {
			for (final DiagramElementSnapshot snapshot : elementsToMove) {
				final Point2D currentPreferredPosition = PreferredPosition.get(snapshot.sceneNode);
				if (currentPreferredPosition != null) {
					final double dx = currentPreferredPosition.getX() - snapshot.positionInLocal.getX();
					final double dy = currentPreferredPosition.getY() - snapshot.positionInLocal.getY();
					shiftAffectedConnections(snapshot, dx, dy);
				}
			}
		}

		// Move diagram elements by updating the diagram to reflect the current scene graph
		editor.getDiagram().modify("Move", m -> {
			editor.getGefDiagram().updateDiagramFromSceneGraph();
		});
	}

	private void shiftAffectedConnections(final DiagramElementSnapshot snapshot, final double dx, final double dy) {
		if (dx != 0.0 || dy != 0.0) {
			for (final DiagramElement affectedConnectionDiagramElement : snapshot.affectedConnections) {
				final Node affectedConnectionSceneNode = editor.getGefDiagram()
						.getSceneNode(affectedConnectionDiagramElement);
				// Shift regular (non flow-indicator) connections.
				if (affectedConnectionSceneNode instanceof ConnectionNode) {
					final BaseConnectionNode cn = (BaseConnectionNode) affectedConnectionSceneNode;
					cn.getInnerConnection()
							.setControlPoints(cn.getInnerConnection().getControlPoints().stream().map(cp -> {
								return new org.eclipse.gef.geometry.planar.Point(cp.x + dx, cp.y + dy);
							}).collect(Collectors.toList()));
				}
			}
		}
	}

	private void setAffectedConnectionsVisible(final boolean value) {
		for (final DiagramElementSnapshot snapshot : elementsToMove) {
			for (final DiagramElement affectedConnectionDiagramElement : snapshot.affectedConnections) {
				final Node affectedConnectionSceneNode = editor.getGefDiagram()
						.getSceneNode(affectedConnectionDiagramElement);
				if (affectedConnectionSceneNode != null) {
					affectedConnectionSceneNode.setVisible(value);
				}
			}
		}
	}

	/**
	 * Creates a list of snapshots for diagram elements which will be moved by the interaction.
	 * @param editor the editor containing the scene nodes for the elements.
	 * @return the snapshots
	 */
	private static List<DiagramElementSnapshot> createMoveElementSnapshotsForSelection(final AgeEditor editor) {
		final Set<DiagramElement> selectedDiagramElements = editor.getSelectedDiagramElements();
		final List<DiagramElementSnapshot> results = new ArrayList<>(selectedDiagramElements.size());
		addSnapshots(editor, editor.getDiagram(), selectedDiagramElements, results);
		return results;
	}

	/**
	 * Creates and adds snapshots for selected descendant elements to be moved to the specified result list.
	 * Does not create snapshots for descendants of elements which have snapshots created.
	 * @param editor the editor containing the diagram
	 * @param parent the node whose children will have snapshots created.
	 * @param selectedDiagramElements the currently selected diagram elements.
	 * @param results the list to which created snapshots are aded.
	 */
	private static void addSnapshots(final AgeEditor editor, final DiagramNode parent,
			final Set<DiagramElement> selectedDiagramElements, final List<DiagramElementSnapshot> results) {
		for (final DiagramElement childDiagramElement : parent.getDiagramElements()) {
			if (selectedDiagramElements.contains(childDiagramElement)
					&& DiagramElementPredicates.isMoveable(childDiagramElement)) {
				DiagramElementSnapshot.create(editor, childDiagramElement).ifPresent(results::add);
			} else {
				addSnapshots(editor, childDiagramElement, selectedDiagramElements, results);
			}
		}
	}
}
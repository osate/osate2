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
import java.util.stream.Collectors;

import org.eclipse.gef.geometry.euclidean.Vector;
import org.osate.ge.gef.ConfigureSize;
import org.osate.ge.gef.ContainerShape;
import org.osate.ge.gef.DockSide;
import org.osate.ge.gef.DockedShape;
import org.osate.ge.gef.FlowIndicatorNode;
import org.osate.ge.gef.PreferredPosition;
import org.osate.ge.gef.ui.editor.overlays.GuideOverlay;
import org.osate.ge.gef.ui.editor.overlays.ResizeShapeHandle;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Transform;

/**
 *  {@link InputEventHandler} for resizing diagram elements. The handler allows the user to resize all selected elements
 *  using a resize handle.
 */
public class ResizeInputEventHandler implements InputEventHandler {
	private final AgeEditor editor;

	public ResizeInputEventHandler(final AgeEditor editor) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");
	}

	@Override
	public Cursor getCursor(final MouseEvent mouseMoveEvent) {
		if (!(mouseMoveEvent.getTarget() instanceof ResizeShapeHandle)) {
			return null;
		}

		final ResizeShapeHandle handle = (ResizeShapeHandle) mouseMoveEvent.getTarget();
		return ResizeInteraction.getCursor(handle);
	}

	@Override
	public HandledEvent handleEvent(final InputEvent e) {
		if (e.getEventType() != MouseEvent.MOUSE_PRESSED || ((MouseEvent) e).getButton() != MouseButton.PRIMARY
				|| !(e.getTarget() instanceof ResizeShapeHandle)) {
			return null;
		}

		return HandledEvent.newInteraction(new ResizeInteraction(editor, (MouseEvent) e));
	}
}

class ResizeInteraction extends BaseInteraction {
	private final AgeEditor editor;
	private final ResizeShapeHandle handle;
	private final Point2D initialClickLocationInDiagram;
	private final List<DiagramElementSnapshot> elementsToResize;
	private final GuideOverlay guides;

	public ResizeInteraction(final AgeEditor editor, final MouseEvent e) {
		this.editor = editor;
		this.handle = (ResizeShapeHandle) e.getTarget();
		this.initialClickLocationInDiagram = editor.getGefDiagram()
				.getSceneNode()
				.getSceneToLocalTransform()
				.transform(e.getSceneX(), e.getSceneY());
		this.elementsToResize = createResizeElementSnapshotsFromSelection(editor);
		this.guides = new GuideOverlay(editor,
				elementsToResize.stream().map(s -> s.diagramElement).collect(Collectors.toSet()));

		// Hides connections because in some cases, some anchors/connections are not updated during resize and it will cause
		// connections to render incorrectly.
		setAffectedConnectionsVisible(false);
	}

	@Override
	public void close() {
		this.guides.close();

		setAffectedConnectionsVisible(true);

		// Update scene graph based on diagram elements. This is needed to revert any scene changes that have been made
		// during the interaction and to ensure that the scene node reflects the diagram elements after modification.
		editor.getGefDiagram().updateSceneGraph();
	}

	@Override
	public Cursor getCursor() {
		return getCursor(handle);
	}

	@Override
	protected Interaction.InteractionState onMouseDragged(final MouseEvent e) {
		if (e.getButton() != MouseButton.PRIMARY) {
			return super.onMouseDragged(e);
		}

		guides.reset();

		final Transform sceneToDiagramTransform = editor.getGefDiagram().getSceneNode().getSceneToLocalTransform();
		final Point2D eventInDiagram = sceneToDiagramTransform.transform(e.getSceneX(), e.getSceneY());
		final Point2D totalDelta = eventInDiagram.subtract(initialClickLocationInDiagram);
		final boolean snapToGrid = !e.isAltDown();
		// Resize all selection diagram elements
		for (final DiagramElementSnapshot snapshot : elementsToResize) {
			// Determine position adjustment and new size
			double newPositionX = snapshot.sceneNode.getLayoutX();
			double newPositionY = snapshot.sceneNode.getLayoutY();
			double newWidth = snapshot.boundsInDiagram.getWidth();
			double newHeight = snapshot.boundsInDiagram.getHeight();
			final Vector dir = handle.getDirection();
			final Node container = InputEventHandlerUtil.getLogicalShapeContainer(snapshot.sceneNode);

			//
			// Determine the minimum layout X and Y values for shapes which will be repositioned during the resize.
			// This value is used to constrain the new position of the node when the resize results in both a movement
			// and a size change.
			//
			double minChildLayoutX = Double.POSITIVE_INFINITY;
			double minChildLayoutY = Double.POSITIVE_INFINITY;
			for (final DiagramElement childDiagramElement : snapshot.diagramElement.getDiagramElements()) {
				final Node childSceneNode = editor.getGefDiagram().getSceneNode(childDiagramElement);
				if (childSceneNode instanceof ContainerShape) {
					minChildLayoutX = Math.min(minChildLayoutX, childSceneNode.getLayoutX());
					minChildLayoutY = Math.min(minChildLayoutY, childSceneNode.getLayoutY());
				}

				// Docked shapes are only repositioned in one axis.
				if (childSceneNode instanceof DockedShape) {
					final DockSide side = ((DockedShape) childSceneNode).getSide();
					if (side.vertical) {
						minChildLayoutY = Math.min(minChildLayoutY, childSceneNode.getLayoutY());
					} else {
						minChildLayoutX = Math.min(minChildLayoutX, childSceneNode.getLayoutX());
					}
				}
			}

			if (dir.x < 0) {
				double newPositionDiagramX = InputEventHandlerUtil.snapX(editor,
						snapshot.boundsInDiagram.getMinX() + totalDelta.getX(), snapToGrid);
				// It is critical to not consider children that are being repositioned. Otherwise the minimum width
				// will change as the node is resized. The layout of such children are considered to ensure that the resize
				// does not clip children not included in the minimum width.
				final double minWidthOfNotRepositionedChildren = snapshot.sceneNode instanceof ContainerShape
						? ((ContainerShape) snapshot.sceneNode).computeMinWidth(-1, false)
						: snapshot.sceneNode.minWidth(-1);
				newPositionDiagramX = Math.min(newPositionDiagramX,
						snapshot.boundsInDiagram.getMaxX() - minWidthOfNotRepositionedChildren);
				newPositionX = snapshot.positionInLocal.getX()
						+ (newPositionDiagramX - snapshot.boundsInDiagram.getMinX());
				newPositionX = Math.min(newPositionX, snapshot.sceneNode.getLayoutX() + minChildLayoutX);
				if (container instanceof ContainerShape) {
					newPositionX = Math.max(newPositionX, 0);
				}

				newWidth = snapshot.boundsInDiagram.getWidth() + (snapshot.positionInLocal.getX() - newPositionX);
			} else if (dir.x > 0) {
				final double newMaxX = InputEventHandlerUtil.snapX(editor,
						snapshot.boundsInDiagram.getMaxX() + totalDelta.getX(), snapToGrid);
				newWidth = newMaxX - snapshot.boundsInDiagram.getMinX();
			}

			if (dir.y < 0) {
				double newPositionDiagramY = InputEventHandlerUtil.snapX(editor,
						snapshot.boundsInDiagram.getMinY() + totalDelta.getY(), snapToGrid);

				// It is critical to not consider children that are being repositioned. Otherwise the minimum height
				// will change as the node is resized. The layout of such children are considered to ensure that the resize
				// does not clip children not included in the minimum height.
				final double minHeightWithoutFreeChildren = snapshot.sceneNode instanceof ContainerShape
						? ((ContainerShape) snapshot.sceneNode).computeMinHeight(-1, false)
						: snapshot.sceneNode.minHeight(-1);
				newPositionDiagramY = Math.min(newPositionDiagramY,
						snapshot.boundsInDiagram.getMaxY() - minHeightWithoutFreeChildren);
				newPositionY = snapshot.positionInLocal.getY()
						+ (newPositionDiagramY - snapshot.boundsInDiagram.getMinY());
				newPositionY = Math.min(newPositionY, snapshot.sceneNode.getLayoutY() + minChildLayoutY);
				if (container instanceof ContainerShape) {
					newPositionY = Math.max(newPositionY, 0);
				}
				newHeight = snapshot.boundsInDiagram.getHeight() + (snapshot.positionInLocal.getY() - newPositionY);
			} else if (dir.y > 0) {
				final double newMaxY = InputEventHandlerUtil.snapX(editor,
						snapshot.boundsInDiagram.getMaxY() + totalDelta.getY(), snapToGrid);
				newHeight = newMaxY - snapshot.boundsInDiagram.getMinY();
			}

			// Adjust the position and size
			final Point2D currentPreferredPosition = PreferredPosition.get(snapshot.sceneNode);
			if (currentPreferredPosition == null || currentPreferredPosition.getX() != newPositionX
					|| currentPreferredPosition.getY() != newPositionY) {
				PreferredPosition.set(snapshot.sceneNode, new Point2D(newPositionX, newPositionY));

				final double dx = currentPreferredPosition == null ? 0
						: (newPositionX - currentPreferredPosition.getX());
				final double dy = currentPreferredPosition == null ? 0
						: (newPositionY - currentPreferredPosition.getY());

				// Reposition children so that their absolute positions do not change.
				for (final DiagramElement childDiagramElement : snapshot.diagramElement.getDiagramElements()) {
					final Node childSceneNode = editor.getGefDiagram().getSceneNode(childDiagramElement);
					if (childSceneNode instanceof ContainerShape || childSceneNode instanceof DockedShape
							|| childSceneNode instanceof FlowIndicatorNode) {
						final Point2D childPosition = PreferredPosition.get(childSceneNode);
						if (childPosition != null) {
							final double newPreferredPositionX, newPreferredPositionY;

							// Special handling of flow indicators since they will only shift in one axis.
							// This assumes the flow indicator is attaches to a vertical side.
							if (childSceneNode instanceof FlowIndicatorNode) {
								newPreferredPositionX = childPosition.getX();
								newPreferredPositionY = childPosition.getY() - dy;
							} else {
								newPreferredPositionX = childPosition.getX() - dx;
								newPreferredPositionY = childPosition.getY() - dy;
							}

							PreferredPosition.set(childSceneNode,
									new Point2D(newPreferredPositionX, newPreferredPositionY));
						}
					}
				}
			}

			final ConfigureSize configureSize = (ConfigureSize) snapshot.sceneNode;
			final double minWidth = snapshot.sceneNode.minWidth(-1);
			final double minHeight = snapshot.sceneNode.minHeight(-1);
			configureSize.setConfiguredWidth(Math.max(newWidth, minWidth));
			configureSize.setConfiguredHeight(Math.max(newHeight, minHeight));

			// Update guide overlay
			if (guides.shouldUpdate()) {
				final Bounds newBoundsInDiagram = sceneToDiagramTransform.transform(
						snapshot.sceneNode.getLocalToSceneTransform().transform(snapshot.sceneNode.getLayoutBounds()));

				// Show guides for the values in the bounds that are being changed as part of the resize
				if (dir.x < 0) {
					guides.updateX(newBoundsInDiagram.getMinX());
					guides.updateCenterX(newBoundsInDiagram.getCenterX());
				} else if (dir.x > 0) {
					guides.updateX(newBoundsInDiagram.getMaxX());
					guides.updateCenterX(newBoundsInDiagram.getCenterX());
				}

				if (dir.y < 0) {
					guides.updateY(newBoundsInDiagram.getMinY());
					guides.updateCenterY(newBoundsInDiagram.getCenterY());
				} else if (dir.y > 0) {
					guides.updateY(newBoundsInDiagram.getMaxY());
					guides.updateCenterY(newBoundsInDiagram.getCenterY());
				}
			}
		}

		return InteractionState.IN_PROGRESS;
	}

	@Override
	protected Interaction.InteractionState onMouseReleased(final MouseEvent e) {
		if (e.getButton() != MouseButton.PRIMARY) {
			return super.onMouseReleased(e);
		}

		// Resize diagram elements by updating the diagram to reflect the current scene graph
		editor.getDiagram().modify("Resize", m -> {
			editor.getGefDiagram().updateDiagramFromSceneGraph();
		});

		return InteractionState.COMPLETE;
	}


	private void setAffectedConnectionsVisible(final boolean value) {
		for (final DiagramElementSnapshot snapshot : elementsToResize) {
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
	 * Creates a list of snapshots for diagram elements which will be resized by the interaction.
	 * @param editor the editor containing the scene nodes for the elements.
	 * @return the snapshots
	 */
	public static List<DiagramElementSnapshot> createResizeElementSnapshotsFromSelection(final AgeEditor editor) {
		final List<DiagramElement> selectedDiagramElements = editor.getSelectedDiagramElements();
		final List<DiagramElementSnapshot> results = new ArrayList<>(selectedDiagramElements.size());
		for (final DiagramElement selectedDiagramElement : selectedDiagramElements) {
			if (DiagramElementPredicates.isResizeable(selectedDiagramElement)) {
				DiagramElementSnapshot.create(editor, selectedDiagramElement).ifPresent(results::add);
			}
		}

		return results;
	}

	static Cursor getCursor(final ResizeShapeHandle handle) {
		final Vector d = handle.getDirection();

		if (d.x < 0) {
			if (d.y < 0) {
				return Cursor.NW_RESIZE;
			} else if (d.y == 0.0) {
				return Cursor.W_RESIZE;
			} else { // d.y > 0.0
				return Cursor.SW_RESIZE;
			}
		} else if (d.x == 0) {
			if (d.y < 0) {
				return Cursor.N_RESIZE;
			} else if (d.y == 0.0) {
				// Invalid combination
				return null;
			} else { // d.y > 0.0
				return Cursor.S_RESIZE;
			}
		} else { // d.x > 0
			if (d.y < 0) {
				return Cursor.NE_RESIZE;
			} else if (d.y == 0.0) {
				return Cursor.E_RESIZE;
			} else { // d.y > 0.0
				return Cursor.SE_RESIZE;
			}
		}
	}
}
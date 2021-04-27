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
import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.gef.ConfigureSize;
import org.osate.ge.gef.ConnectionNode;
import org.osate.ge.gef.PreferredPosition;
import org.osate.ge.gef.ui.editor.overlays.ResizeShapeHandle;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;

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
	private ResizeShapeHandle handle;
	private Point2D initialClickLocationInDiagram;
	private final List<ElementInfo> elementsToResize = new ArrayList<>();

	public static class ElementInfo {
		final DiagramElement diagramElement;
		final Node sceneNode;
		final ConfigureSize configureSize;
		final Bounds originalLayoutBoundsInDiagram;
		final Point2D originalLayoutPositionInLocal;
		final List<DiagramElement> affectedConnections;

		ElementInfo(final DiagramElement diagramElement, final Node sceneNode, final ConfigureSize configureSize,
				final Bounds originalLayoutBoundsInDiagram, final Point2D originalLayoutPosition,
				final List<DiagramElement> affectedConnections) {
			this.diagramElement = diagramElement;
			this.sceneNode = sceneNode;
			this.configureSize = configureSize;
			this.originalLayoutBoundsInDiagram = originalLayoutBoundsInDiagram;
			this.originalLayoutPositionInLocal = originalLayoutPosition;
			this.affectedConnections = affectedConnections;
		}
	}

	public ResizeInteraction(final AgeEditor editor, final MouseEvent e) {
		this.editor = editor;
		this.handle = (ResizeShapeHandle) e.getTarget();

		final Transform sceneToDiagramTransform = editor.getGefDiagram().getSceneNode().getSceneToLocalTransform();
		initialClickLocationInDiagram = sceneToDiagramTransform.transform(e.getSceneX(), e.getSceneY());

		final List<DiagramElement> selectedDiagramElements = editor.getSelectedDiagramElementList();

		for (final DiagramElement selectedDiagramElement : selectedDiagramElements) {
			final Node sceneNode = editor.getSceneNode(selectedDiagramElement);
			if (sceneNode instanceof ConfigureSize) {
				final Bounds layoutInDiagram = sceneToDiagramTransform
						.transform(sceneNode.getLocalToSceneTransform().transform(sceneNode.getLayoutBounds()));

				// Get connections affected my moving the element
				final List<DiagramElement> affectedConnections = DiagramElementLayoutUtil
						.getConnectionsAffectedByMove(selectedDiagramElement, editor.getGefDiagram().getDiagram(), true)
						.collect(Collectors.toList());

				elementsToResize.add(
						new ElementInfo(selectedDiagramElement, sceneNode, (ConfigureSize) sceneNode, layoutInDiagram,
								new Point2D(sceneNode.getLayoutX(), sceneNode.getLayoutY()), affectedConnections));
			}
		}
	}

	@Override
	public void close() {
		// Update scene graph based on diagram element. This is needed to revert any scene changes that have been made
		// during the interaction and to ensure that the scene node reflects the diagram elements after modification.
		editor.getGefDiagram().updateSceneGraph();
	}

	@Override
	protected Interaction.InteractionState onMouseDragged(final MouseEvent e) {
		if (e.getButton() != MouseButton.PRIMARY) {
			return super.onMouseDragged(e);
		}

		final Transform sceneToDiagramTransform = editor.getGefDiagram().getSceneNode().getSceneToLocalTransform();
		final Point2D eventInDiagram = sceneToDiagramTransform.transform(e.getSceneX(), e.getSceneY());
		final Point2D eventDelta = eventInDiagram.subtract(initialClickLocationInDiagram);

		// Resize all selection diagram elements
		for (final ElementInfo info : elementsToResize) {
			// Determine position adjustment and new size
			double newPositionX = info.sceneNode.getLayoutX();
			double newPositionY = info.sceneNode.getLayoutY();
			double newWidth = info.originalLayoutBoundsInDiagram.getWidth();
			double newHeight = info.originalLayoutBoundsInDiagram.getHeight();
			final boolean snapToGrid = !e.isAltDown();
			final Vector d = handle.getDirection();
			final double minWidth = info.sceneNode.minWidth(-1);
			final double minHeight = info.sceneNode.minHeight(-1);
			if (d.x < 0) {
				double newPositionDiagramX = InputEventHandlerUtil.snapX(editor,
						info.originalLayoutBoundsInDiagram.getMinX() + eventDelta.getX(), snapToGrid);
				newPositionDiagramX = Math.min(newPositionDiagramX,
						info.originalLayoutBoundsInDiagram.getMaxX() - minWidth);

				newPositionDiagramX = Math.max(newPositionDiagramX,
						info.originalLayoutBoundsInDiagram.getMinX() - info.originalLayoutPositionInLocal.getX());
				newPositionX = info.originalLayoutPositionInLocal.getX()
						+ (newPositionDiagramX - info.originalLayoutBoundsInDiagram.getMinX());
				newWidth = info.originalLayoutBoundsInDiagram.getMaxX() - newPositionDiagramX;
			} else if (d.x > 0) {
				final double newMaxX = InputEventHandlerUtil.snapX(editor,
						info.originalLayoutBoundsInDiagram.getMaxX() + eventDelta.getX(), snapToGrid);
				newWidth = newMaxX - info.originalLayoutBoundsInDiagram.getMinX();
			}

			if (d.y < 0) {
				double newPositionDiagramY = InputEventHandlerUtil.snapX(editor,
						info.originalLayoutBoundsInDiagram.getMinY() + eventDelta.getY(), snapToGrid);
				newPositionDiagramY = Math.min(newPositionDiagramY,
						info.originalLayoutBoundsInDiagram.getMaxY() - minHeight);
				newPositionDiagramY = Math.max(newPositionDiagramY,
						info.originalLayoutBoundsInDiagram.getMinY() - info.originalLayoutPositionInLocal.getY());
				newPositionY = info.originalLayoutPositionInLocal.getY()
						+ (newPositionDiagramY - info.originalLayoutBoundsInDiagram.getMinY());
				newHeight = info.originalLayoutBoundsInDiagram.getMaxY() - newPositionDiagramY;
			} else if (d.y > 0) {
				final double newMaxY = InputEventHandlerUtil.snapX(editor,
						info.originalLayoutBoundsInDiagram.getMaxY() + eventDelta.getY(), snapToGrid);
				newHeight = newMaxY - info.originalLayoutBoundsInDiagram.getMinY();
			}

			// Adjust the position and size
			final Point2D currentPreferredPosition = PreferredPosition.get(info.sceneNode);
			if (currentPreferredPosition == null || currentPreferredPosition.getX() != newPositionX
					|| currentPreferredPosition.getY() != newPositionY) {
				PreferredPosition.set(info.sceneNode, new Point2D(newPositionX, newPositionY));

				final double dx = currentPreferredPosition == null ? 0
						: (newPositionX - currentPreferredPosition.getX());
				final double dy = currentPreferredPosition == null ? 0
						: (newPositionY - currentPreferredPosition.getY());
				if (dx != 0.0 || dy != 0.0) {
					for (final DiagramElement affectedConnectionDiagramElement : info.affectedConnections) {
						final Node affectedConnectionSceneNode = editor.getGefDiagram()
								.getSceneNode(affectedConnectionDiagramElement);
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

			info.configureSize.setConfiguredWidth(Math.max(newWidth, minWidth));
			info.configureSize.setConfiguredHeight(Math.max(newHeight, minHeight));
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
}
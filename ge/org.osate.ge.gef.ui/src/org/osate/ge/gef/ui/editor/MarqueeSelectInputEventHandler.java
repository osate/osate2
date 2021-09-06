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

import org.osate.ge.gef.ContainerShape;
import org.osate.ge.gef.DockedShape;
import org.osate.ge.gef.ui.editor.overlays.Handle;
import org.osate.ge.gef.ui.editor.overlays.Overlays;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.WeakChangeListener;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;
import javafx.scene.transform.Transform;

/**
 *  {@link InputEventHandler} for marquee selection. The marquee selection allows selecting {@link ContainerShape} and {@link DockedShape} nodes.
 *  Connections cannot be selected using the marquee tool.
 */
public class MarqueeSelectInputEventHandler implements InputEventHandler {
	private final AgeEditor editor;

	/**
	 * Creates a new instance
	 * @param editor the editor from which events originate.
	 */
	public MarqueeSelectInputEventHandler(final AgeEditor editor) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");
	}

	@Override
	public Cursor getCursor(final MouseEvent mouseMoveEvent) {
		return editor.getPaletteModel().isMarqueeToolActive()
				&& !InputEventHandlerUtil.isScrollBar(mouseMoveEvent.getTarget())
				? Cursor.CROSSHAIR
				: null;
	}

	@Override
	public HandledEvent handleEvent(final InputEvent e) {
		if (e.getEventType() != MouseEvent.MOUSE_PRESSED || ((MouseEvent) e).getButton() != MouseButton.PRIMARY
				|| InputEventHandlerUtil.isScrollBar(e.getTarget())) {
			return null;
		}

		final AgeEditorPaletteModel paletteModel = editor.getPaletteModel();
		final MouseEvent mouseEvent = (MouseEvent) e;
		final DiagramElement clickedDiagramElement = InputEventHandlerUtil
				.getTargetDiagramElement(editor.getGefDiagram(), e.getTarget());
		if (paletteModel.isMarqueeToolActive() || (paletteModel.isSelectToolActive() && clickedDiagramElement == null
				&& !(e.getTarget() instanceof Handle))) {
			final MarqueeSelectInteraction newInteraction = new MarqueeSelectInteraction(editor, mouseEvent);
			return HandledEvent.newInteraction(newInteraction);
		} else {
			return null;
		}
	}
}

/**
 * Interaction for marquee selection
 *
 */
class MarqueeSelectInteraction extends BaseInteraction {
	private final AgeEditor editor;

	/**
	 * Start of the selection in diagram coordinates.
	 */
	private final Point2D selectionStart;

	private final Rectangle selectionBoundsOverlay = new Rectangle();

	private final ChangeListener<Transform> diagramToOverlayChangeListener = (o, oldValue,
			newValue) -> selectionBoundsOverlay.getTransforms().setAll(newValue);

	/**
	 * Creates a new instance
	 * @param editor the editor for the interaction
	 * @param e the mouse pressed event that triggered the interaction
	 */
	public MarqueeSelectInteraction(final AgeEditor editor, final MouseEvent e) {
		this.editor = editor;
		this.selectionStart = editor.getGefDiagram().getSceneNode().getSceneToLocalTransform().transform(e.getSceneX(),
				e.getSceneY());

		// Update transforms so that the local coordinate system matches diagram coordinates
		final Overlays overlays = editor.getOverlays();
		overlays.diagramToLocalTransformProperty().addListener(new WeakChangeListener<>(diagramToOverlayChangeListener));
		selectionBoundsOverlay.getTransforms().setAll(overlays.diagramToLocalTransformProperty().get());

		// Create the overlay node which indicates the selection bounds
		selectionBoundsOverlay.setX(selectionStart.getX());
		selectionBoundsOverlay.setY(selectionStart.getY());
		selectionBoundsOverlay.setFill(null);
		selectionBoundsOverlay.setStrokeLineCap(StrokeLineCap.BUTT);
		selectionBoundsOverlay.setStroke(Color.BLACK);
		selectionBoundsOverlay.setStrokeType(StrokeType.INSIDE);
		selectionBoundsOverlay.setStrokeWidth(1.0);
		selectionBoundsOverlay.getStrokeDashArray().setAll(4.0, 3.0);

		overlays.getChildren().add(selectionBoundsOverlay);
	}

	@Override
	public void close() {
		((Group) selectionBoundsOverlay.getParent()).getChildren().remove(selectionBoundsOverlay);
	}

	@Override
	protected Interaction.InteractionState onMouseDragged(final MouseEvent e) {
		if (e.getButton() != MouseButton.PRIMARY) {
			return super.onMouseDragged(e);
		}

		// Transform the cursor position to diagram coordinates and update the bounds overlay
		final Point2D p = editor.getGefDiagram().getSceneNode().getSceneToLocalTransform().transform(e.getSceneX(),
				e.getSceneY());
		if (p.getX() < selectionStart.getX()) {
			selectionBoundsOverlay.setX(p.getX());
			selectionBoundsOverlay.setWidth(selectionStart.getX() - p.getX());
		} else {
			selectionBoundsOverlay.setX(selectionStart.getX());
			selectionBoundsOverlay.setWidth(p.getX() - selectionStart.getX());
		}

		if (p.getY() < selectionStart.getY()) {
			selectionBoundsOverlay.setY(p.getY());
			selectionBoundsOverlay.setHeight(selectionStart.getY() - p.getY());
		} else {
			selectionBoundsOverlay.setY(selectionStart.getY());
			selectionBoundsOverlay.setHeight(p.getY() - selectionStart.getY());
		}

		return InteractionState.IN_PROGRESS;
	}

	@Override
	protected Interaction.InteractionState onMouseReleased(final MouseEvent e) {
		if (e.getButton() != MouseButton.PRIMARY) {
			return super.onMouseReleased(e);
		}

		// Select container and docked shapes
		final Bounds selectionBounds = selectionBoundsOverlay.getLocalToSceneTransform()
				.transform(selectionBoundsOverlay.getBoundsInLocal());
		final List<DiagramElement> newSelection = new ArrayList<>();
		addChildrenToNewSelection(editor.getGefDiagram().getSceneNode(), selectionBounds, newSelection);
		editor.selectDiagramNodes(newSelection);

		return InteractionState.COMPLETE;
	}

	/**
	 * Adds diagram elements to the list of diagram elements to be selected based on the children of the specified node.
	 * @param parent the scene graph node for which children will be checked.
	 * @param selectionBounds the bounds in scene coordinates which is being selected.
	 * @param newSelection the list of diagram elements to be selected. If an appropriate child is in the selection bounds, the diagram element
	 * for it will be added to this list.
	 */
	private void addChildrenToNewSelection(final Parent parent, final Bounds selectionBounds,
			final List<DiagramElement> newSelection) {
		for (final Node child : parent.getChildrenUnmodifiable()) {
			final Bounds childBounds = child.getLocalToSceneTransform().transform(child.getBoundsInLocal());

			// Only container and docked shapes are selectable using the marquee tool
			if ((child instanceof ContainerShape || child instanceof DockedShape)
					&& selectionBounds.contains(childBounds)) {
				// Ignore objects which do not have an associated diagram element
				final DiagramElement childDiagramElement = editor.getGefDiagram().getDiagramElement(child);
				if (childDiagramElement != null) {
					newSelection.add(childDiagramElement);
				}
			} else if (child instanceof Parent && selectionBounds.intersects(childBounds)) {
				addChildrenToNewSelection((Parent) child, selectionBounds, newSelection);
			}
		}
	}
}
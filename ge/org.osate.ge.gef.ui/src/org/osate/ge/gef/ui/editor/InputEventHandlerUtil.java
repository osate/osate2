package org.osate.ge.gef.ui.editor;

import org.osate.ge.gef.AgeGefRuntimeException;
import org.osate.ge.gef.ui.diagram.GefAgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;

import javafx.event.EventTarget;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.NonInvertibleTransformException;

/**
 * Utility functions for implementing {@link InputEventHandler} and {@Interaction}
 */
public class InputEventHandlerUtil {
	/**
	 * If the event target is a {@link Node}, walks up the scene graph and returns the first {@link DiagramNode} associated with the node
	 * or ancestors.
	 * @param gefDiagram is the diagram from which to get the diagram node
	 * @param target the event target. Returns null if the event target is not a {@link Node}
	 * @return the closest diagram node to the event target. Returns null if the event target is a null.
	 */
	public static DiagramNode getTargetDiagramNode(final GefAgeDiagram gefDiagram, final EventTarget target) {
		if (!(target instanceof Node)) {
			return null;
		}

		for (Node tmp = (Node) target; tmp != null; tmp = tmp.getParent()) {
			if (tmp == gefDiagram.getSceneNode()) {
				return gefDiagram.getDiagram();
			}

			final DiagramElement de = gefDiagram.getDiagramElement(tmp);
			if (de != null) {
				return de;
			}
		}

		return null;
	}

	/**
	 * If the event target is a {@link Node}, walks up the scene graph and returns the first {@link DiagramElement} associated with the node
	 * or ancestors.
	 * @param gefDiagram is the diagram from which to get the diagram element
	 * @param target the event target. Returns null if the event target is not a {@link Node}
	 * @return the closest diagram element to the event target. Returns null if the event target is a null.
	 */
	public static DiagramElement getTargetDiagramElement(final GefAgeDiagram gefDiagram, final EventTarget target) {
		final DiagramNode diagramNode = getTargetDiagramNode(gefDiagram, target);
		return diagramNode instanceof DiagramElement ? (DiagramElement) diagramNode : null;
	}

	/**
	 * Gets the position of a mouse event in local coordinates of a node.
	 * @param e the mouse event
	 * @param local the node to which the return value will be local
	 * @return the position of the mouse event in the local coordinates system of the specified node.
	 */
	public static Point2D getLocalEventPosition(final MouseEvent e, final Node local) {
		try {
			final Point2D p = local.getLocalToSceneTransform().createInverse().transform(e.getSceneX(),
					e.getSceneY());
			return p;
		} catch (NonInvertibleTransformException ex) {
			throw new AgeGefRuntimeException(ex);
		}
	}

	/**
	 * Converts a {@link Point2D} to a {@link org.osate.ge.graphics.Point}.
	 * @param value the point to convert.
	 * @return the converted point. Returns null if value is null/
	 */
	public static org.osate.ge.graphics.Point fxToAgePoint(final Point2D value) {
		return value == null ? null : new org.osate.ge.graphics.Point(value.getX(), value.getY());
	}

	/**
	 * Rounds an X value to either the editor's grid or to the nearest integer.
	 * @param editor the editor which defines the grid
	 * @param value the value to snap
	 * @param toGrid true to snap to the grid. If false, the value will be rounded to the nearest integer.
	 * @return the rounded value
	 */
	public static double snapX(final AgeEditor editor, final double value, final boolean toGrid) {
		return snap(value, toGrid ? editor.getGridCellWidth() : 1.0);
	}

	/**
	 * Rounds an Y value to either the editor's grid or to the nearest integer.
	 * @param editor the editor which defines the grid
	 * @param value the value to snap
	 * @param toGrid true to snap to the grid. If false, the value will be rounded to the nearest integer.
	 * @return the rounded value
	 */
	public static double snapY(final AgeEditor editor, final double value, final boolean toGrid) {
		return snap(value, toGrid ? editor.getGridCellWidth() : 1.0);
	}

	private static double snap(final double value, final double multiplier) {
		return Math.round(value / multiplier) * multiplier;
	}

}

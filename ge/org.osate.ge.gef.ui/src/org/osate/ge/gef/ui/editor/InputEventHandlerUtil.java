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
	 * If the event target is a {@link Node}, walks up the scene graph and returns the first {@link DiaramNode} associated with the node
	 * or ancestors.
	 * @param gefDiagram is the diagram from which to get the diagram node
	 * @param target the event target. Returns null if the event target is not a {@link Node}
	 * @return the closest diagram node to the event target. Returns null if the event target is a null.
	 */
	public static DiagramNode getClosestDiagramNode(final GefAgeDiagram gefDiagram, final EventTarget target) {
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
	 * If the event target is a {@link Node}, walks up the scene graph and returns the first {@link DiaramElement} associated with the node
	 * or ancestors.
	 * @param gefDiagram is the diagram from which to get the diagram element
	 * @param target the event target. Returns null if the event target is not a {@link Node}
	 * @return the closest diagram element to the event target. Returns null if the event target is a null.
	 */
	public static DiagramElement getClosestDiagramElement(final GefAgeDiagram gefDiagram, final EventTarget target) {
		final DiagramNode diagramNode = getClosestDiagramNode(gefDiagram, target);
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
}

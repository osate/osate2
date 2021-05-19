package org.osate.ge.gef.ui.editor;

import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.gef.ContainerShape;
import org.osate.ge.gef.DockedShape;
import org.osate.ge.gef.ui.diagram.GefAgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.diagram.runtime.DiagramNode;

import javafx.event.EventTarget;
import javafx.geometry.Point2D;
import javafx.scene.Node;

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
			if (de != null
					&& ((DiagramElementPredicates.isMoveableShape(de)
							&& (!(de.getParent() instanceof DiagramElement)
									|| !DiagramElementPredicates.isConnection((DiagramElement) de.getParent())))
							|| DiagramElementPredicates.isConnection(de))) {
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
	 * Rounds a 2D coordinate to either the editor's grid or to the nearest integer.
	 * @param editor the editor which defines the grid
	 * @param value the value to snap in diagram coordinates
	 * @param toGrid true to snap to the grid. If false, the value will be rounded to the nearest integer.
	 * @return the rounded value
	 */
	public static Point2D snap(final AgeEditor editor, final Point2D value, final boolean toGrid) {
		return new Point2D(snapX(editor, value.getX(), toGrid), snapY(editor, value.getY(), toGrid));
	}

	/**
	 * Rounds an X value to either the editor's grid or to the nearest integer.
	 * @param editor the editor which defines the grid
	 * @param value the value to snap in diagram coordinates
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

	/**
	 * Returns the specified or the closest ancestor which is an instance of {@link BaseConnectionNode}.
	 * @param node is the node for which to get the connection.
	 * @return the connection node or null if there is no such node.
	 */
	public static BaseConnectionNode getClosestConnection(final Node node) {
		for (Node tmp = node; tmp != null; tmp = tmp.getParent()) {
			if (tmp instanceof BaseConnectionNode) {
				return (BaseConnectionNode) tmp;
			}
		}

		return null;
	}

	/**
	 * Returns the closest ancestor which is a {@link ContainerShape} or {@link DockedShape}.
	 * Does not check the node itself.
	 * @param node the node for which to get the logical container.
	 * @return the logical container. Returns null if no ancestor meets the criteria.
	 */
	public static Node getLogicalShapeContainer(final Node node) {
		for (Node tmp = node.getParent(); tmp != null; tmp = tmp.getParent()) {
			if (tmp instanceof ContainerShape || tmp instanceof DockedShape) {
				return tmp;
			}
		}

		return null;
	}
}

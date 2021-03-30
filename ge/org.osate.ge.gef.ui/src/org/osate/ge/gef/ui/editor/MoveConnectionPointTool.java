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
import java.util.stream.Collectors;

import org.eclipse.gef.fx.nodes.Connection;
import org.eclipse.gef.geometry.convert.fx.FX2Geometry;
import org.eclipse.gef.geometry.convert.fx.Geometry2FX;
import org.eclipse.gef.geometry.planar.Point;
import org.osate.ge.gef.AgeGefRuntimeException;
import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.gef.FlowIndicatorNode;
import org.osate.ge.gef.PreferredPosition;
import org.osate.ge.gef.ui.diagram.GefAgeDiagram;
import org.osate.ge.gef.ui.editor.overlays.ConnectionPointHandle;
import org.osate.ge.gef.ui.editor.overlays.ControlPointHandle;
import org.osate.ge.gef.ui.editor.overlays.CreateControlPointHandle;
import org.osate.ge.gef.ui.editor.overlays.FlowIndicatorPositionHandle;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Transform;

/**
 *  {@link InputEventHandler} for moving {@link ConnectionPointHandle}.
 *  Starts interactions for creating control points, moving control points, and moving
 *  flow indicators.
 */
public class MoveConnectionPointTool implements InputEventHandler {
	@Override
	public Cursor getCursor(final MouseEvent mouseMoveEvent) {
		return mouseMoveEvent.getTarget() instanceof ConnectionPointHandle ? Cursor.MOVE : null;
	}

	@Override
	public HandledEvent handleEvent(final GefAgeDiagram gefDiagram, InputEvent e) {
		if (e.getEventType() != MouseEvent.MOUSE_PRESSED || ((MouseEvent) e).getButton() != MouseButton.PRIMARY
				|| !(e.getTarget() instanceof ConnectionPointHandle)) {
			return null;
		}

		return HandledEvent.newInteraction(new MoveConnectionPointInteraction(gefDiagram, (MouseEvent) e));
	}
}

class MoveConnectionPointInteraction extends BaseInteraction {
	private static final double REMOVE_POINT_DISTANCE = 2.0;
	private static final double ADD_POINT_DISTANCE = 15.0;

	private GefAgeDiagram gefDiagram;

	/**
	 * The handle with which the user is interacting.
	 */
	private ConnectionPointHandle activeHandle;

	/**
	 * The index of the control point. If the control point does not exist, this is the index where the point will be inserted.
	 */
	private Integer controlPointIndex;

	/**
	 * Whether the control point exists. The point may be removed or added while the interaction is active.
	 */
	private boolean controlPointExists;

	public MoveConnectionPointInteraction(final GefAgeDiagram gefDiagram, final MouseEvent e) {
		this.gefDiagram = gefDiagram;

		final ConnectionPointHandle handle = (ConnectionPointHandle) e.getTarget();
		if (handle instanceof CreateControlPointHandle) {
			final CreateControlPointHandle createControlPointHandle = (CreateControlPointHandle) handle;
			controlPointIndex = createControlPointHandle.getInsertionIndex();
			controlPointExists = false;
		} else if (handle instanceof ControlPointHandle) {
			final ControlPointHandle controlPointHandle = (ControlPointHandle) handle;
			controlPointIndex = controlPointHandle.getControlPointIndex();
			controlPointExists = true;
		} else if (handle instanceof FlowIndicatorPositionHandle) {
			controlPointExists = true;
		} else {
			throw new AgeGefRuntimeException("Unexpected handle: " + handle);
		}

		activeHandle = handle;
	}

	@Override
	protected Interaction.InteractionState onMouseDragged(final MouseEvent e) {
		if (e.getButton() != MouseButton.PRIMARY) {
			return InteractionState.IN_PROGRESS;
		}

		if (activeHandle instanceof FlowIndicatorPositionHandle) {
			final FlowIndicatorNode c = ((FlowIndicatorPositionHandle) activeHandle).getSceneNode();
			final Node positioningReference = c.getPositioningReferenceOrThrow();

			// The the position relative to the reference
			final Point2D newPoint = InputEventHandlerUtil.getLocalEventPosition(e, positioningReference);
			final Point2D oldPosition = PreferredPosition.get(activeHandle.getSceneNode());
			PreferredPosition.set(activeHandle.getSceneNode(), newPoint);

			// Adjust positions of control points so that only the ending position of the flow indicator is moved.
			if (oldPosition != null) {
				final double dx = newPoint.getX() - oldPosition.getX();
				final double dy = newPoint.getY() - oldPosition.getY();
				c.getInnerConnection().setControlPoints(c.getInnerConnection().getControlPoints().stream()
						.map(p -> new Point(p.x - dx, p.y - dy)).collect(Collectors.toList()));
			}
		} else if (controlPointIndex != null) {
			final BaseConnectionNode c = activeHandle.getSceneNode();
			final Connection ic = c.getInnerConnection();
			final Point2D newPosition = InputEventHandlerUtil.getLocalEventPosition(e, ic);

			// Get a list of the control points and the start and end points of connection.
			final List<Point> allPoints = ic.getPointsUnmodifiable();
			final List<org.eclipse.gef.geometry.planar.Point> controlPoints = ic.getControlPoints();
			final ArrayList<org.eclipse.gef.geometry.planar.Point> endAndControlPoints = new ArrayList<>(
					controlPoints.size() + 2);
			endAndControlPoints.add(allPoints.get(0));
			endAndControlPoints.addAll(controlPoints);
			endAndControlPoints.add(allPoints.get(allPoints.size() - 1));

			// Determine whether the point should be removed or added
			final boolean remove = controlPointExists && distanceToLineSegment(newPosition, endAndControlPoints,
					controlPointIndex, controlPointIndex + 2) <= REMOVE_POINT_DISTANCE;
			final boolean add = !remove && !controlPointExists && distanceToLineSegment(newPosition,
					endAndControlPoints, controlPointIndex, controlPointIndex + 1) >= ADD_POINT_DISTANCE;

			if (remove) {
				c.getInnerConnection().removeControlPoint(controlPointIndex);
				controlPointExists = false;
			} else if (add) {
				controlPoints.add(controlPointIndex, FX2Geometry.toPoint(newPosition));
				ic.setControlPoints(controlPoints);
				controlPointExists = true;
			} else if (controlPointExists) {
				ic.setControlPoint(controlPointIndex, FX2Geometry.toPoint(newPosition));
			}
		}

		return InteractionState.IN_PROGRESS;
	}

	@Override
	protected Interaction.InteractionState onMouseReleased(final MouseEvent e) {
		if (e.getButton() != MouseButton.PRIMARY) {
			return InteractionState.IN_PROGRESS;
		}

		final BaseConnectionNode connectionNode = activeHandle.getSceneNode();
		try {
			final Transform sceneToDiagramTransform = gefDiagram.getSceneNode().getLocalToSceneTransform().createInverse();
			final Transform connectionToDiagramTransform = sceneToDiagramTransform
					.createConcatenation(connectionNode.getLocalToSceneTransform());

			gefDiagram.getDiagram().modify("Update Control Point", m -> {
				final DiagramElement diagramElementToModify = gefDiagram.getDiagramElement(connectionNode);
				if (diagramElementToModify == null) {
					throw new AgeGefRuntimeException("Unable to find diagram element");
				}

				m.setBendpoints(diagramElementToModify, connectionNode.getInnerConnection().getControlPoints().stream().map(p ->
				InputEventHandlerUtil.fxToAgePoint(
						connectionToDiagramTransform.transform(p.x, p.y))
				).collect(Collectors.toList()));

				if (connectionNode instanceof FlowIndicatorNode) {
					m.setPosition(diagramElementToModify,
							InputEventHandlerUtil.fxToAgePoint(PreferredPosition.get(connectionNode)));
				}
			});

		} catch (NonInvertibleTransformException ex) {
			throw new AgeGefRuntimeException("Unable to create diagram scene to local transform", ex);
		}

		// Reset the state of the operation
		resetState();

		return InteractionState.COMPLETE;
	}

	@Override
	public void abort() {
		resetState();

		// Update scene graph based on diagram element.
		// Changes could be reverted more efficiently but this is simple and reliable.
		gefDiagram.updateSceneGraph();
	}

	private void resetState() {
		activeHandle = null;
		controlPointIndex = null;
	}

	/**
	 * Finds the distance between a point and a line segment. The line segment is defined by referencing points in a list.
	 * @param p the point for which to get the distance
	 * @param segmentPoints a list containing points
	 * @param segmentStartIndex the index of the start of the line segment
	 * @param segmentEndIndex the index of the end of the line segment
	 * @return the distance between the point and the segment. If either of the specified indices are invalid,
	 * {@link Double#POSITIVE_INFINITY} will be returned.
	 */
	private static double distanceToLineSegment(final Point2D p, final List<Point> segmentPoints, int segmentStartIndex,
			int segmentEndIndex) {
		if (segmentStartIndex < 0 || segmentStartIndex >= segmentPoints.size()) {
			return Double.POSITIVE_INFINITY;
		}

		if (segmentEndIndex < 0 || segmentEndIndex >= segmentPoints.size()) {
			return Double.POSITIVE_INFINITY;
		}

		final Point2D segmentStart = Geometry2FX.toFXPoint(segmentPoints.get(segmentStartIndex));
		final Point2D segmentEnd = Geometry2FX.toFXPoint(segmentPoints.get(segmentEndIndex));
		return distanceToLineSegment(p, segmentStart, segmentEnd);
	}

	/**
	 * Find the distance between a point and a line segment.
	 * Based on http://geomalgorithms.com/a02-_lines.html
	 * @param p the point for which to get the distance
	 * @param segmentStart the start of the line segment
	 * @param segmentEnd the end of the line segment
	 * @return the distance between the point and the segment.
	 */
	private static double distanceToLineSegment(Point2D p, Point2D segmentStart, Point2D segmentEnd) {
		final Point2D v = segmentEnd.subtract(segmentStart);
		final Point2D w = p.subtract(segmentStart);
		final double c1 = w.dotProduct(v);

		// Before segment start
		if (c1 <= 0.0) {
			return p.distance(segmentStart);
		}

		final double c2 = v.dotProduct(v);
		// After segment end
		if (c2 <= c1) {
			return p.distance(segmentEnd);
		}

		final double b = c1 / c2;
		final Point2D pb = segmentStart.add(b * v.getX(), b * v.getY());
		return pb.distance(p);
	}
}

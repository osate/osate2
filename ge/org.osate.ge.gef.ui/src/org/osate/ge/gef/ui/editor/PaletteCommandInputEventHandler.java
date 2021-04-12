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

import java.util.Objects;
import java.util.Optional;

import org.eclipse.gef.fx.anchors.IAnchor;
import org.eclipse.gef.fx.anchors.StaticAnchor;
import org.eclipse.gef.fx.nodes.Connection;
import org.eclipse.gef.fx.nodes.GeometryNode;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.DockingPosition;
import org.osate.ge.gef.AgeGefRuntimeException;
import org.osate.ge.gef.ui.diagram.GefAgeDiagramUtil;
import org.osate.ge.gef.ui.editor.overlays.Overlays;
import org.osate.ge.internal.diagram.runtime.AgeDiagramUtil;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.operations.OperationExecutor;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.internal.ui.DefaultOperationResultsProcessor;
import org.osate.ge.operations.Operation;
import org.osate.ge.palette.CanStartConnectionContext;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.palette.GetCreateConnectionOperationContext;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.PaletteCommand;
import org.osate.ge.palette.TargetedPaletteCommand;

import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.transform.NonInvertibleTransformException;

/**
 * {@link InputEventHandler} for executing palette commands.
 */
public class PaletteCommandInputEventHandler implements InputEventHandler {
	private final AgeEditor editor;

	public PaletteCommandInputEventHandler(final AgeEditor editor) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");
	}

	@Override
	public Cursor getCursor(final MouseEvent mouseMoveEvent) {
		final PaletteCommand cmd = editor.getPaletteModel().getActivePaletteCommand();
		if (cmd instanceof TargetedPaletteCommand) {
			return getTargetedCommandOperation(mouseMoveEvent).isPresent() ? Cursors.CREATE : Cursors.NO;
		} else if (cmd instanceof CreateConnectionPaletteCommand) {
			final CreateConnectionPaletteCommand createCmd = (CreateConnectionPaletteCommand) cmd;
			final boolean canCreate = createCanStartConnectionContext(mouseMoveEvent)
					.map(createCmd::canStartConnection).orElse(false);
			return canCreate ? Cursors.PLUG : Cursors.PLUG_NO;
		}
		return null;
	}

	@Override
	public HandledEvent handleEvent(final InputEvent e) {
		if (e.getEventType() != MouseEvent.MOUSE_PRESSED || ((MouseEvent) e).getButton() != MouseButton.PRIMARY) {
			return null;
		}

		// Retrieve the active palette command
		final PaletteCommand cmd = editor.getPaletteModel().getActivePaletteCommand();
		if (cmd == null) {
			return null;
		}

		final MouseEvent me = (MouseEvent) e;
		if (cmd instanceof TargetedPaletteCommand) {
			final TargetedPaletteCommand tc = (TargetedPaletteCommand) cmd;
			createGetTargetedOperationContext((MouseEvent) e).ifPresent(c -> {
				final Node sceneNode = editor.getSceneNode((DiagramNode) c.getTarget());
				final Point2D p = getTargetPosition(sceneNode, me.getSceneX(), me.getSceneY());

				class CreateAction implements AgeAction {
					@Override
					public AgeAction execute() {
						final DiagramNode targetNode = (DiagramNode) c.getTarget();
						tc.getOperation(c).ifPresent(operation -> {
							// Perform modification
							final OperationExecutor opExecutor = new OperationExecutor(
									editor.getAadlModificationService(), editor.getReferenceService());
							opExecutor.execute(operation,
									new DefaultOperationResultsProcessor(editor, targetNode,
											InputEventHandlerUtil.fxToAgePoint(p)));
						});

						return null;
					}
				}

				final CreateAction createAction = new CreateAction();
				editor.getActionExecutor().execute("Create " + cmd.getLabel(), ExecutionMode.NORMAL, createAction);

				// Deactivate the current palette item and select the "Select" item
				editor.getPaletteModel().deactivateNonSelectItem();
			});

			return HandledEvent.handled();
		} else if (cmd instanceof CreateConnectionPaletteCommand) {
			final CreateConnectionPaletteCommand createCmd = (CreateConnectionPaletteCommand) cmd;
			final CanStartConnectionContext ctx = createCanStartConnectionContext(me).orElse(null);
			if (ctx == null || !createCmd.canStartConnection(ctx)) {
				return null;
			}

			return HandledEvent.newInteraction(
					new CreateConnectionInteraction(createCmd, (DiagramElement) ctx.getSource(), editor, me));
		} else {
			return null;
		}
	}

	private Optional<CanStartConnectionContext> createCanStartConnectionContext(final MouseEvent event) {
		final DiagramElement sourceDiagramElement = InputEventHandlerUtil.getTargetDiagramElement(
				editor.getGefDiagram(),
				event.getTarget());
		return sourceDiagramElement == null ? Optional.empty()
				: Optional.of(new CanStartConnectionContext(sourceDiagramElement, editor.getQueryService()));
	}

	private Optional<GetTargetedOperationContext> createGetTargetedOperationContext(final MouseEvent event) {
		// Find the closest diagram node
		final DiagramNode targetDiagramNode = InputEventHandlerUtil.getTargetDiagramNode(editor.getGefDiagram(),
				event.getTarget());
		if (targetDiagramNode == null) {
			return Optional.empty();
		}

		final Node targetSceneNode = editor.getGefDiagram().getSceneNode(targetDiagramNode);
		final Point2D targetPosition = getTargetPosition(targetSceneNode, event.getSceneX(), event.getSceneY());
		final DockingPosition dockingPostion = AgeDiagramUtil.determineDockingPosition(targetDiagramNode, targetPosition.getX(), targetPosition.getY(), 0,
				0);
		return Optional.of(new GetTargetedOperationContext(targetDiagramNode, dockingPostion, editor.getQueryService()));
	}

	/**
	 * Gets the operation for the active {@link TargetedPaletteCommand} based on the current moue event.
	 * @param event the latest mouse even which contains the target.
	 * @return an empty optional if the operation could not be retrieved or the current command is not a {@link TargetedPaletteCommand}
	 */
	private Optional<Operation> getTargetedCommandOperation(final MouseEvent event) {
		final PaletteCommand cmd = editor.getPaletteModel().getActivePaletteCommand();
		if (cmd instanceof TargetedPaletteCommand) {
			final TargetedPaletteCommand tc = (TargetedPaletteCommand) cmd;
			return createGetTargetedOperationContext(event).flatMap(tc::getOperation);
		} else {
			return Optional.empty();
		}
	}

	/**
	 * Gets the position relative to the specified target scene node
	 * @param targetSceneNode the node to which the returned position is relative
	 * @param sceneX the X value in the scene coordinate system
	 * @param sceneY the Y value in the scene coordinate system
	 * @return the position relative to the target scene node
	 */
	private static Point2D getTargetPosition(final Node targetSceneNode, final double sceneX,
			final double sceneY) {
		try {
			return targetSceneNode.getLocalToSceneTransform().createInverse().transform(sceneX, sceneY);
		} catch (final NonInvertibleTransformException e) {
			throw new AgeGefRuntimeException("Unable to get scene to local transform for target scene node", e);
		}
	}
}

class CreateConnectionInteraction extends BaseInteraction {
	private static final Color CONNECTION_COLOR = new Color(1.0, 0.518, 0.0, 1.0);

	private final CreateConnectionPaletteCommand cmd;
	private final BusinessObjectContext sourceBoc;
	private final AgeEditor editor;

	/**
	 * Visualization for connection being created
	 */
	private final Connection connection;
	private final StaticAnchor mouseAnchor;

	public CreateConnectionInteraction(final CreateConnectionPaletteCommand cmd,
			final DiagramElement sourceDiagramElement, final AgeEditor editor,
			final MouseEvent e) {
		this.cmd = Objects.requireNonNull(cmd, "cmd must not be null");
		this.sourceBoc = Objects.requireNonNull(sourceDiagramElement, "sourceDiagramElement must not be null");
		this.editor = Objects.requireNonNull(editor, "editor must not be null");

		// Create connection for visualizing the connection being created
		connection = new Connection();
		connection.setMouseTransparent(true);
		final IAnchor sourceAnchor = GefAgeDiagramUtil.getAnchor(editor.getGefDiagram(), sourceDiagramElement, null);
		if (sourceAnchor == null) {
			throw new AgeGefRuntimeException("Unable to get anchor");
		}
		connection.setStartAnchor(sourceAnchor);

		// Set end anchor
		final Overlays overlays = editor.getOverlays();
		final Point2D mousePosition = overlays.sceneToLocal(e.getSceneX(), e.getSceneY());
		mouseAnchor = new StaticAnchor(overlays,
				new org.eclipse.gef.geometry.planar.Point(mousePosition.getX(), mousePosition.getY()));
		connection.setEndAnchor(mouseAnchor);

		// Set style of connection
		final double zoom = editor.getZoom();
		final GeometryNode<?> gn = (GeometryNode<?>) connection.getCurve();
		gn.setStrokeLineCap(StrokeLineCap.BUTT);
		gn.setStrokeWidth(2.0 * zoom);
		gn.getStrokeDashArray().setAll(6.0 * zoom, 2.0 * zoom);
		gn.setStroke(CONNECTION_COLOR);
		overlays.getChildren().add(connection);
	}

	@Override
	public Cursor getCursor(final MouseEvent mouseMoveEvent) {
		return createGetCreateConnectionOperationContext(mouseMoveEvent)
				.flatMap(cmd::getOperation)
				.isPresent() ? Cursors.PLUG : Cursors.PLUG_NO;
	}

	@Override
	public void abort() {
		removeConnection();
	}

	private void removeConnection() {
		((Group) connection.getParent()).getChildren().remove(connection);
	}

	@Override
	protected Interaction.InteractionState onMouseMoved(final MouseEvent e) {
		updateMouseAnchorPosition(e);
		return InteractionState.IN_PROGRESS;
	}

	@Override
	protected Interaction.InteractionState onMouseDragged(final MouseEvent e) {
		updateMouseAnchorPosition(e);
		return InteractionState.IN_PROGRESS;
	}

	private void updateMouseAnchorPosition(final MouseEvent e) {
		final Point2D overlayPosition = editor.getOverlays().sceneToLocal(e.getSceneX(), e.getSceneY());
		mouseAnchor.setReferencePosition(
				new org.eclipse.gef.geometry.planar.Point(overlayPosition.getX(), overlayPosition.getY()));
	}

	@Override
	protected Interaction.InteractionState onMousePressed(final MouseEvent e) {
		// Get and execute the operation for creating the connection
		createGetCreateConnectionOperationContext(e).ifPresent(c -> {
			class CreateAction implements AgeAction {
				@Override
				public AgeAction execute() {
					cmd.getOperation(c).ifPresent(operation -> {
						// Perform modification
						final OperationExecutor opExecutor = new OperationExecutor(editor.getAadlModificationService(),
								editor.getReferenceService());
						opExecutor.execute(operation, new DefaultOperationResultsProcessor(editor));
					});

					return null;
				}
			}

			final CreateAction createAction = new CreateAction();
			editor.getActionExecutor().execute("Create " + cmd.getLabel(), ExecutionMode.NORMAL, createAction);
		});

		removeConnection();
		return InteractionState.COMPLETE;
	}

	private Optional<GetCreateConnectionOperationContext> createGetCreateConnectionOperationContext(
			final MouseEvent event) {
		final DiagramElement destinationDiagramElement = InputEventHandlerUtil
				.getTargetDiagramElement(editor.getGefDiagram(),
				event.getTarget());
		if (destinationDiagramElement == null) {
			return Optional.empty();
		}
		return Optional.of(new GetCreateConnectionOperationContext(sourceBoc, destinationDiagramElement,
				editor.getQueryService()));
	}
}
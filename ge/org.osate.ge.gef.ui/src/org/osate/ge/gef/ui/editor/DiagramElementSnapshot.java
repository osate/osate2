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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.transform.Transform;

/**
 * Stores a snapshot of details about a {@link DiagramElement} and related scene-graph {@link Node}.
 */
public class DiagramElementSnapshot {
	/**
	 * The diagram element's scene node
	 */
	final Node sceneNode;

	/**
	 * The layout bounds in diagram coordinates of the scene node when this instance was created.
	 */
	final Bounds boundsInDiagram;

	/**
	 * The layoutX and layoutY value of the scene node when this instance was created.
	 */
	final Point2D positionInLocal;

	/**
	 * List of connections that would be affected by the move. See {@link DiagramElementLayoutUtil#getConnectionsAffectedByMove}
	 */
	final List<DiagramElement> affectedConnections;

	/**
	 * Creates a new instance
	 */
	private DiagramElementSnapshot(final Node sceneNode,
			final Bounds originalLayoutBoundsInDiagram,
			final Point2D originalLayoutPosition, final List<DiagramElement> affectedConnections) {
		this.sceneNode = sceneNode;
		this.boundsInDiagram = originalLayoutBoundsInDiagram;
		this.positionInLocal = originalLayoutPosition;
		this.affectedConnections = affectedConnections;
	}

	/**
	 * Creates a new instance for the specified diagram element.
	 * @param editor the editor to use to get scene nodes.
	 * @param diagramElement the diagram for which to return the instance.
	 * @return the new instance. An empty value if unable to get the scene node.
	 */
	public static Optional<DiagramElementSnapshot> create(final AgeEditor editor, final DiagramElement diagramElement) {
		final Node sceneNode = editor.getSceneNode(diagramElement);
		if (sceneNode == null) {
			return Optional.empty();
		}

		final Transform sceneToDiagramTransform = editor.getGefDiagram().getSceneNode().getSceneToLocalTransform();
		final Bounds layoutInDiagram = sceneToDiagramTransform
				.transform(sceneNode.getLocalToSceneTransform().transform(sceneNode.getLayoutBounds()));
		final List<DiagramElement> affectedConnections = DiagramElementLayoutUtil
				.getConnectionsAffectedByMove(diagramElement, editor.getGefDiagram().getDiagram(), true)
				.collect(Collectors.toList());
		return Optional.of(new DiagramElementSnapshot(sceneNode, layoutInDiagram,
				new Point2D(sceneNode.getLayoutX(), sceneNode.getLayoutY()), affectedConnections));
	}
}
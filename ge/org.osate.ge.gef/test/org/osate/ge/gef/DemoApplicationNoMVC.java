/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.gef;

import java.util.UUID;

import org.eclipse.gef.fx.nodes.InfiniteCanvas;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.fx.DiagramEditorNode;
import org.osate.ge.fx.NodeApplication;
import org.osate.ge.fx.TestPaletteModel;
import org.osate.ge.gef.nodes.AgeShapeNode;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

// TODO: Rename/Remove once it is decided whether MVC will be used
public class DemoApplicationNoMVC {
	private static EventHandler<? super MouseEvent> mouseFilter = event -> {
		//System.err.println("TEST: " + event);

		// determine pressed/dragged/released state
		EventType<? extends Event> type = event.getEventType();
		if (type.equals(MouseEvent.MOUSE_PRESSED)) {
			final EventTarget target = event.getTarget();
			if (target instanceof Node) {
				System.err.println("MOUSE PRESSED ON : "  + target);
				System.err.println("SHAPE NODE: " + findAgeShapeNodeContainer((Node) target));

				// TODO: Get DiagramElement...

				// TODO: Highlight as an experiment

				// TODO: Allow dragging

//				// initialize the gesture
//				pressed = (Node) target;
//				startMousePosition = new Point2D(event.getSceneX(),
//						event.getSceneY());
//				press(pressed, event);
			}
			return;
		}
	};

	private static AgeShapeNode findAgeShapeNodeContainer(Node node) {
		while(node != null) {
			if(node instanceof AgeShapeNode) {
				return (AgeShapeNode) node;
			}

			node = node.getParent();
		}

		return null;
	}

	public static void main(final String[] args) {
		NodeApplication.run(() -> {
			final InfiniteCanvas canvas = new InfiniteCanvas();
			final DiagramEditorNode n = new DiagramEditorNode(new TestPaletteModel(), canvas);

			// Build model
			final AgeDiagram diagram = new AgeDiagram();
			diagram.modify("Initial", m -> {
				final DiagramElement newElement = new DiagramElement(diagram, null, null,
						new RelativeBusinessObjectReference("test1"), UUID.randomUUID());
				m.addElement(newElement);
			});

			// TODO; Populate canvas
			// TODO: This should be done some other way
			for(final DiagramElement de : diagram.getDiagramElements()) {
				canvas.getContentGroup().getChildren().add(new AgeShapeNode());
				// TODO: Synchronize with diagram element
				// TODO: Support selection, etc.
			}

			// TODO: Understand capture phase... This should be part of the editor node..
			n.addEventFilter(MouseEvent.ANY, mouseFilter);

			// TODO: Selection and Selection Handles

			// TODO: Will need to remove filter at some point

			// TODO: How does direct editing work with or without MVC

			// TODO: Select. Single, Multiple, Add/Remove, Dragging, etc

			// TODO: Moving

			// Connection example.. Adjusting bendpoints, etc..

			// TODO: What should be integrated with DiagramEditorNode. The editor part that uses AgeDiagram be a separate node.

			return n;
		});
	}
}

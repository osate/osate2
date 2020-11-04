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
package org.osate.ge.gef.ui.diagram;

import java.util.Objects;

import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.BeforeModificationsCompletedEvent;
import org.osate.ge.internal.diagram.runtime.DiagramConfigurationChangedEvent;
import org.osate.ge.internal.diagram.runtime.DiagramModificationListener;
import org.osate.ge.internal.diagram.runtime.ElementAddedEvent;
import org.osate.ge.internal.diagram.runtime.ElementRemovedEvent;
import org.osate.ge.internal.diagram.runtime.ElementUpdatedEvent;
import org.osate.ge.internal.diagram.runtime.ModificationsCompletedEvent;

import javafx.scene.Group;

// TODO: Similar to GraphitiAgeDiagram
public class GefAgeDiagram implements AutoCloseable {
	private final AgeDiagram diagram;
	private final Group diagramNode = new Group();
	// TODO; Create root node with layers. Should this be a node in and of itself that can be added? DiagramNode?

	// TODO: Layers aren't needed for this becuase this doesn't represent editor stuff like selection and handles...

	private DiagramModificationListener modificationListener = new DiagramModificationListener() {
		@Override
		public void diagramConfigurationChanged(final DiagramConfigurationChangedEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void elementAdded(final ElementAddedEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void elementRemoved(final ElementRemovedEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void elementUpdated(final ElementUpdatedEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void beforeModificationsCompleted(final BeforeModificationsCompletedEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void modificationsCompleted(final ModificationsCompletedEvent e) {
			// TODO Auto-generated method stub

		}
	};

	public GefAgeDiagram(final AgeDiagram diagram) {
		this.diagram = Objects.requireNonNull(diagram, "diagram must not be null");
		diagram.addModificationListener(modificationListener);

		// TODO: Populate diagram node based on diagram

//		for (final DiagramElement tmp : diagram.getDiagramElements()) {
//		final AgeShapeNode n = new AgeShapeNode();
//
//		this.getChildren().add(n);
//
//		// TODO: Do this somewhere else
//		update(n, tmp);
//
//		// TODO: Children
//	}
	}

//	private void update(final AgeShapeNode n, final DiagramElement de) {
//		// TODO: Don't do that here?
//		// TODO: Do some graphics have fixed height.. Should check whether size and position exists before setting?
//		// n.resizeRelocate(de.getX(), de.getY(), de.getWidth(), de.getHeight());
//		n.setPrefWidth(de.getWidth());
//		n.setPrefHeight(de.getHeight());
//		n.relocate(de.getX(), de.getY()); // TODO; WIll be overridden during layout.. Is this the appropriate field?
//		// TODO; Set dock area. On parent or on element itself
//
//		// TODO: Parent layout will occur while moving... will want to preserve drag position
//	}

	// TODO: Rename?
	public Group getNode() {
		return diagramNode;
	}

	@Override
	public void close() {
		diagram.removeModificationListener(modificationListener);
	};
}

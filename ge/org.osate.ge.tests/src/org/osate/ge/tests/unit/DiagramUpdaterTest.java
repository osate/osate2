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
package org.osate.ge.tests.unit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.osate.ge.tests.unit.TestBusinessObject.*;

import java.util.Collection;
import java.util.EnumSet;

import org.junit.Before;
import org.junit.Test;
import org.osate.ge.DockingPosition;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.graphics.internal.AgeConnection;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DockArea;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.services.impl.SimpleActionExecutor;

public class DiagramUpdaterTest {
	private AgeDiagram diagram;
	private DiagramUpdater diagramUpdater;
	private final TestBusinessObjectModel testModel = new TestBusinessObjectModel();

	@Before
	public void beforeTest() {
		testModel.setModel(newBO(
				newBO(
						newBO(2),
						newBO(4),
						newBO(
								newBO(6),
								newBO(8),
								newBO(10)
								)
						),
				newBO(
						newBO(12)
						)
				));

		diagram = new AgeDiagram();
		diagramUpdater = new DiagramUpdater(testModel, testModel, new SimpleActionExecutor(), testModel, testModel);
	}

	// Test that the diagram elements are created as expected
	@Test
	public void testDiagramElementCreation() {
		diagramUpdater.updateDiagram(diagram);
		assignPositions(diagram.getDiagramElements());
		checkElements(diagram.getDiagramElements(), testModel.getModel());
	}

	// Test that when update is called multiple times, elements are not duplicated
	@Test
	public void testDiagramElementUpdating() {
		diagramUpdater.updateDiagram(diagram);
		assignPositions(diagram.getDiagramElements());

		diagramUpdater.updateDiagram(diagram);
		checkElements(diagram.getDiagramElements(), testModel.getModel());
	}

	// Test that when all objects are removed from the model, all elements are removed from the diagram.
	@Test
	public void testDiagramElementRemovalOfAll() {
		diagramUpdater.updateDiagram(diagram);
		assignPositions(diagram.getDiagramElements());

		testModel.setModel(newBO());
		diagramUpdater.updateDiagram(diagram);
		assertThat(diagram.getDiagramElements().size(), is(equalTo(0)));
	}

	// Test that when part of the model is removed
	@Test
	public void testDiagramElementPartialRemoval() {
		diagramUpdater.updateDiagram(diagram);
		assignPositions(diagram.getDiagramElements());
		checkElements(diagram.getDiagramElements(), testModel.getModel());
		testModel.setModel(newBO(testModel.getModel().children[0].children));
		diagramUpdater.updateDiagram(diagram);
		assignPositions(diagram.getDiagramElements());
		checkElements(diagram.getDiagramElements(), testModel.getModel());
	}

	// Test that when a business object is replace by a new one with the same reference.
	@Test
	public void testDiagramElementUpdateBusinessObject() {
		diagramUpdater.updateDiagram(diagram);
		assignPositions(diagram.getDiagramElements());
		checkElements(diagram.getDiagramElements(), testModel.getModel());
		final TestBusinessObject owner = testModel.getModel().children[1];
		final TestBusinessObject newBusinessObject = newBO(owner.children[0].value); // Create a copy with the same value. It is assumed that this element does not container children
		owner.children[0] = newBusinessObject;
		diagramUpdater.updateDiagram(diagram);

		final DiagramElement element = diagram.getByRelativeReference(owner.getRelativeReference()).
				getByRelativeReference(newBusinessObject.getRelativeReference());
		assertThat(element.getBusinessObject(), is(sameInstance(newBusinessObject)));

		checkElements(diagram.getDiagramElements(), testModel.getModel());
	}

	// Test that when a business object is replaced by a new one with a different reference that the diagram elements are updated appropriately
	@Test
	public void testDiagramElementReplaceBusinessObjectWithNew() {
		diagramUpdater.updateDiagram(diagram);
		assignPositions(diagram.getDiagramElements());
		checkElements(diagram.getDiagramElements(), testModel.getModel());
		final TestBusinessObject owner = testModel.getModel().children[1];
		final TestBusinessObject newBusinessObject = newBO(42);
		owner.children[0] = newBusinessObject;
		diagramUpdater.updateDiagram(diagram);

		// Get the new element
		final DiagramElement element = diagram.getByRelativeReference(owner.getRelativeReference()).
				getByRelativeReference(newBusinessObject.getRelativeReference());
		assertThat(element, is(notNullValue()));
		assertThat(element.getPosition(), is(nullValue()));
		assertThat(element.getBusinessObject(), is(sameInstance(newBusinessObject)));

		final DiagramElement e = diagram.getByRelativeReference(owner.getRelativeReference()).
				getByRelativeReference(newBusinessObject.getRelativeReference());
		diagram.modify("Set Position", m -> m.setPosition(e, newBusinessObject.getTestPosition()));

		checkElements(diagram.getDiagramElements(), testModel.getModel());
	}

	// Test that when a business object is ghosted and re-added, that the position is restored.
	@Test
	public void testDiagramElementGhostingAndReadd() {
		diagramUpdater.updateDiagram(diagram);
		assignPositions(diagram.getDiagramElements());
		checkElements(diagram.getDiagramElements(), testModel.getModel());

		// Remove a business object from the tree and update the diagram. This will remove the element from the diagram
		final TestBusinessObject owner = testModel.getModel().children[0];
		final TestBusinessObject oldBusinessObject = owner.children[0];
		final TestBusinessObject newBusinessObject = newBO(42);
		owner.children[0] = newBusinessObject;
		diagramUpdater.updateDiagram(diagram);

		// Re-add the business object to the tree and update the diagram. Verify that the element is re-added and the position is restored.
		owner.children[0] = oldBusinessObject;
		diagramUpdater.updateDiagram(diagram);
		checkElements(diagram.getDiagramElements(), testModel.getModel());
	}

	// Test that element docking are works as expected
	@Test
	public void testDockArea() {
		// Assign a Docking Position to an Element
		final TestBusinessObject testBoParent = testModel.getModel().children[0];
		final TestBusinessObject testBo = testBoParent.children[2];
		testBo.setDefaultDockingPosition(DockingPosition.LEFT);

		// Update the diagram and assign positions
		diagramUpdater.updateDiagram(diagram);
		assignPositions(diagram.getDiagramElements());

		// Check that the contents of test diagram element have the appropriate docking area
		checkElements(diagram.getDiagramElements(), testModel.getModel());

		// Check that Changing the Docking Area and updating the diagram does not reset the docking area.
		final DiagramElement dockableDiagramElement = diagram.getByRelativeReference(testBoParent.getRelativeReference()).
				getByRelativeReference(testBo.getRelativeReference());
		assertThat(dockableDiagramElement.getDockArea(),
				is(equalTo(testBo.getDefaultDockingPosition().getDefaultDockArea())));
		final DockArea newDockArea = DockingPosition.RIGHT.getDefaultDockArea();

		diagram.modify("Set Dock Area", m -> m.setDockArea(dockableDiagramElement, newDockArea));

		diagramUpdater.updateDiagram(diagram);
		assertThat(dockableDiagramElement.getDockArea(), is(equalTo(newDockArea)));

	}

	@Test
	public void testConnectionEndPointsAreSet() {
		testModel.setModel(newBO(
				newBO(1), // Connection
				newBO(2),
				newBO(4)
				));
		testModel.getModel().children[0].makeConnection(testModel.getModel().children[1], testModel.getModel().children[2]);
		diagramUpdater.updateDiagram(diagram);

		final DiagramElement testConnectionDiagramElement = diagram.getByRelativeReference(testModel.getModel().children[0].getRelativeReference());
		assertThat(testConnectionDiagramElement, notNullValue());
		assertThat(testConnectionDiagramElement.getGraphic(), instanceOf(AgeConnection.class));
		assertThat(testConnectionDiagramElement.getStartElement(), notNullValue());
		assertThat(testConnectionDiagramElement.getEndElement(), notNullValue());
	}

	@Test
	public void testConnectionWithoutStartElementIsRemoved() {
		testModel.setModel(newBO(
				newBO(1), // Connection
				newBO(2),
				newBO(4)
				));

		testModel.getModel().children[0].makeConnection(null, testModel.getModel().children[2]);
		diagramUpdater.updateDiagram(diagram);

		final DiagramElement testDiagramElement = diagram.getByRelativeReference(testModel.getModel().children[0].getRelativeReference());
		assertThat(testDiagramElement, nullValue());
	}

	@Test
	public void testConnectionWithoutEndElementIsRemoved() {
		testModel.setModel(newBO(
				newBO(1), // Connection
				newBO(2),
				newBO(4)
				));

		testModel.getModel().children[0].makeConnection(testModel.getModel().children[1], null);
		diagramUpdater.updateDiagram(diagram);

		final DiagramElement testDiagramElement = diagram.getByRelativeReference(testModel.getModel().children[0].getRelativeReference());
		assertThat(testDiagramElement, nullValue());
	}

	@Test
	public void testConnectionWhichReferencesInvalidConnectonIsRemoved() {
		testModel.setModel(newBO(
				newBO(1), // Connection
				newBO(2),
				newBO(3) // Invalid Connection
				));

		testModel.getModel().children[0].makeConnection(testModel.getModel().children[1], testModel.getModel().children[2]);
		testModel.getModel().children[2].makeConnection(null, null); // Invalid connection
		diagramUpdater.updateDiagram(diagram);

		final DiagramElement testDiagramElement = diagram.getByRelativeReference(testModel.getModel().children[0].getRelativeReference());
		assertThat(testDiagramElement, nullValue());
	}

	private void assignPositions(final Collection<DiagramElement> elements) {
		diagram.modify("Assign Positions", m -> assignPositions(m, elements));
	}

	private static void assignPositions(final DiagramModification m, final Collection<DiagramElement> elements) {
		for(final DiagramElement element : elements) {
			final TestBusinessObject bo = (TestBusinessObject)element.getBusinessObject();
			m.setPosition(element, bo.getTestPosition());

			// Assign positions to children
			assignPositions(m, element.getDiagramElements());
		}
	}

	private static enum CheckFlag {
		CHECK_POSITION,
		CHECK_DOCK_AREA;

		public static final EnumSet<CheckFlag> ALL = EnumSet.allOf(CheckFlag.class);
	}

	private static void checkElements(final Collection<DiagramElement> elements, final TestBusinessObject parentBO) {
		checkElements(elements, parentBO, null, CheckFlag.ALL);
	}

	private static void checkElements(final Collection<DiagramElement> elements, final TestBusinessObject parentBO, final DockArea parentDockArea, final EnumSet<CheckFlag> flags) {
		// Check the number of elements in the model
		assertThat(elements.size(), is(equalTo(parentBO.children.length)));

		// Check that each element in the model is in the element set
		for(final TestBusinessObject child : parentBO.children) {
			boolean foundBO = false;
			final RelativeBusinessObjectReference modelChildRef = child.getRelativeReference();
			for(final DiagramElement e : elements) {
				final RelativeBusinessObjectReference elementRef = ((TestBusinessObject)e.getBusinessObject()).getRelativeReference();
				if(elementRef.equals(modelChildRef)) {
					foundBO = true;
					break;
				}
			}

			assertThat("The diagram does not contain an element for the business object: " + child, foundBO);
		}

		// Finish checking each element
		for(final DiagramElement e : elements) {
			// Check the position of the element
			final TestBusinessObject testBo = (TestBusinessObject)e.getBusinessObject();
			if(flags.contains(CheckFlag.CHECK_POSITION)) {
				assertThat(e.getPosition(), is(equalTo(testBo.getTestPosition())));
			}

			final DockArea dockArea = getExpectedDockArea(testBo, parentDockArea);
			if(flags.contains(CheckFlag.CHECK_DOCK_AREA)) {
				assertThat(e.getDockArea(), is(equalTo(dockArea)));
			}

			// Check the children
			checkElements(e.getDiagramElements(), (TestBusinessObject)e.getBusinessObject(), dockArea, flags);
		}
	}

	public static DockArea getExpectedDockArea(final TestBusinessObject bo, final DockArea parentDockArea) {
		// Return the dock area based on the default docking position if the parent isn't docked. Otherwise, ensure that the dock area is set to GROUP.
		final DockArea boDockArea = bo.getDefaultDockingPosition().getDefaultDockArea();
		if(boDockArea == null) {
			return null;
		} else if(parentDockArea == null) {
			return bo.getDefaultDockingPosition().getDefaultDockArea();
		} else {
			return DockArea.GROUP;
		}
	}
}

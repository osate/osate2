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

package org.osate.ge.tests.endToEnd;

import static org.osate.ge.aadl2.internal.AadlReferenceUtil.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestCommands.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestUtil.*;
import static org.osate.ge.tests.endToEnd.util.UiTestUtil.*;

import java.util.function.BiFunction;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.junit.Test;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.ba.BehaviorAnnexReferenceUtil;
import org.osate.ge.tests.endToEnd.util.DiagramElementReference;
import org.osate.ge.tests.endToEnd.util.DiagramReference;

public class BehaviorAnnexTest {
	private static final String BA_TEST = "ba_test";
	private static final String DATA_PKG = "data_test";
	private static final String DATA_CLASSIFIER = "temp";

	@Test
	public void testBehaviorAnnex() {
		prepareForTesting();
		createAadlProject(BA_TEST);

		// Create package
		createNewPackageWithPackageDiagram(BA_TEST, BA_TEST);

		// Create package for data classifier reference
		createNewPackageWithPackageDiagram(BA_TEST, DATA_PKG);

		// Create Data Type
		createElementAndLayout(defaultDiagram(BA_TEST, DATA_PKG), packageElement(DATA_PKG), "Data Type",
				getClassifierRelativeReference("new_classifier"), DATA_CLASSIFIER);

		// Create default diagram for testing classifiers
		final DiagramReference diagram = defaultDiagram(BA_TEST, BA_TEST);
		final DiagramElementReference pkgElement = packageElement(BA_TEST);
		final RelativeBusinessObjectReference pkgRef = getRelativeReferenceForPackage(BA_TEST);

		// Open text editor
		doubleClickInAadlNavigator(BA_TEST, BA_TEST + ".aadl");

		// Setup classifiers for testing
		final String typeName = "Abstract_type";
		final String modeName = "src_state";
		setupClassifiers(diagram, pkgElement, pkgRef, typeName, modeName);

		// Use Open -> Behavior Annex Diagram command to create new behavior annex diagram
		final BiFunction<DiagramElementReference, String, DiagramReference> openBehaviorAnnexDiagramCommand = (ref,
				diagramPrefix) -> openDiagramFromReference(ref, diagramPrefix, 0);

		// Run tests for type
		testBehaviorSpecification(BehaviorAnnexReferenceUtil.getSpecificationRelativeReference(0),
				typeName, diagram, pkgRef, modeName, openBehaviorAnnexDiagramCommand);

		// Open text editor
		doubleClickInAadlNavigator(BA_TEST, BA_TEST + ".aadl");

		// Use Open -> New Diagram... command to create new Behavior Annex diagram
		final BiFunction<DiagramElementReference, String, DiagramReference> openNewDiagramCommand = (ref,
				newStatePrefix) -> openNewDiagramFromReference(ref, newStatePrefix, 1);

		// Run tests for impl
		testBehaviorSpecification(BehaviorAnnexReferenceUtil.getSpecificationRelativeReference(1),
				typeName + ".impl2", diagram, pkgRef, modeName, openNewDiagramCommand);
	}

	/*
	 * - Create an abstract type
	 * - - - Create mode
	 * - Create an abstract impl
	 * - - - Create data subcomponent in impl
	 * - Create another abstract impl extending first impl
	 * - - - Refine data subcomponent
	 */
	private static void setupClassifiers(final DiagramReference diagram, final DiagramElementReference pkgElement,
			final RelativeBusinessObjectReference pkgRef, final String typeName, final String modeName) {
		// Create type
		createElementAndLayout(diagram, pkgElement, "Abstract Type", getClassifierRelativeReference("new_classifier"),
				typeName);

		// Create mode to test when source states have the same name as modes
		createElementAndLayout(diagram, pkgElement.join(getClassifierRelativeReference(typeName)), "Mode",
				getModeRelativeReference(typeName + "_new_mode"), modeName);

		// Create impl
		createImplementationWithExistingType(diagram, pkgElement, "Abstract Implementation", "impl1", BA_TEST,
				typeName);

		final DiagramElementReference abstractImpl1 = pkgElement
				.join(getClassifierRelativeReference("Abstract_type.impl1"));

		// Create data subcomponent
		createElementAndLayout(diagram, abstractImpl1, "Data Subcomponent",
				getSubcomponentRelativeReference("Abstract_type_impl1_new_subcomponent"), "dataSub");

		createImplementationWithExistingType(diagram, pkgElement, "Abstract Implementation", "impl2", BA_TEST,
				"Abstract_type.impl1");

		final DiagramElementReference abstractImpl2 = pkgElement
				.join(getClassifierRelativeReference(typeName + ".impl2"));

		// Show
		showContentsAndLayout(diagram, abstractImpl2);

		// Set dataSub refined
		clickCheckboxInPropertiesView(diagram, "AADL", 0, element(pkgRef,
				getClassifierRelativeReference("Abstract_type.impl2"), getSubcomponentRelativeReference("dataSub")));
	}

	/*
	 * - Create BA with initial state in classifier type
	 * - Set BA in mode
	 * - Create source Behavior State
	 * - Execute open diagram for ba
	 * - Create destination Behavior State
	 * - Create behavior variable with data classifier set as Base_Types::String
	 * - Set data classifier for variable to data classifier data_test::temp
	 * - Create a behavior transition between source and destination
	 * - Test state and transition properties for classifier
	 */
	private static void testBehaviorSpecification(final RelativeBusinessObjectReference behaviorSpecification,
			final String classifierName,
			final DiagramReference diagram, final RelativeBusinessObjectReference pkgRef, final String modeName,
			final BiFunction<DiagramElementReference, String, DiagramReference> openDiagram) {
		// Create behavior specification
		createBehaviorAnnexWithInitialState(diagram, pkgRef, classifierName, behaviorSpecification, modeName);

		final RelativeBusinessObjectReference classifierRef = getClassifierRelativeReference(classifierName);
		final DiagramElementReference specificationDiagramRef = new DiagramElementReference(pkgRef, classifierRef,
				behaviorSpecification);

		// Set in mode
		clickCheckboxInPropertiesView(diagram, "AADL", 0, specificationDiagramRef);

		// Source state with same name as mode
		final DiagramElementReference srcState = specificationDiagramRef
				.join(BehaviorAnnexReferenceUtil.getStateRelativeReference(modeName));
		final DiagramReference baDiagram = openDiagram.apply(srcState, classifierName.replace(".", "_"));

		// New specification reference for BA diagram
		final DiagramElementReference baDiagramSpecRef = new DiagramElementReference(behaviorSpecification);
		testBehaviorStates(baDiagram, baDiagramSpecRef);

		testBehaviorVariable(baDiagram, baDiagramSpecRef);

		testBehaviorTransition(
				new DiagramElementReference(behaviorSpecification,
						BehaviorAnnexReferenceUtil.getStateRelativeReference(modeName)),
				baDiagram, behaviorSpecification);


		saveAndCloseDiagramEditor(baDiagram);
	}

	private static void testBehaviorVariable(final DiagramReference baDiagram,
			final DiagramElementReference baDiagramSpecRef) {
		// Create variable
		final String newVariableName = "ba_variable";
		createBehaviorVariable(baDiagram, baDiagramSpecRef, "Base_Types::String", "new_behavior_variable",
				newVariableName);

		// Test deletion
		deleteElement(baDiagram,
				baDiagramSpecRef.join(BehaviorAnnexReferenceUtil.getVariableRelativeReference(newVariableName)));

		createBehaviorVariable(baDiagram, baDiagramSpecRef, "Base_Types::String", "new_behavior_variable",
				newVariableName);

		// Change variable data classifier
		setBehaviorVariableDataClassifier(baDiagram,
				baDiagramSpecRef.join(BehaviorAnnexReferenceUtil.getVariableRelativeReference(newVariableName)),
				DATA_PKG + "::" + DATA_CLASSIFIER);
	}

	private static void testBehaviorStates(final DiagramReference baDiagram,
			final DiagramElementReference baDiagramSpecRef) {
		// Create state to delete
		createElementAndLayout(baDiagram, baDiagramSpecRef, "Behavior State",
				BehaviorAnnexReferenceUtil.getStateRelativeReference("new_state"), "delete_state");

		// Test deletion
		final DiagramElementReference stateToDelete = baDiagramSpecRef
				.join(BehaviorAnnexReferenceUtil.getStateRelativeReference("delete_state"));
		deleteElement(baDiagram, stateToDelete);

		// Create destination state
		createElementAndLayout(baDiagram, baDiagramSpecRef, "Behavior State",
				BehaviorAnnexReferenceUtil.getStateRelativeReference("new_state"), "dest_state");
	}

	private static void testBehaviorTransition(final DiagramElementReference src, final DiagramReference baDiagram,
			final RelativeBusinessObjectReference behaviorSpecification) {
		final DiagramElementReference dest = new DiagramElementReference(behaviorSpecification)
				.join(BehaviorAnnexReferenceUtil.getStateRelativeReference("dest_state"));

		clickCheckboxInPropertiesView(baDiagram, "AADL", 1, dest);

		final RelativeBusinessObjectReference transitionRef = BehaviorAnnexReferenceUtil
				.getTransitionRelativeReference(0);
		// Create a transition between the states
		createConnectionElement(baDiagram, src, dest, "Behavior Transition",
				element(behaviorSpecification, transitionRef));

		// Rename transition
		renameElementFromContextMenu(baDiagram, element(behaviorSpecification), transitionRef, "new_transition",
				transitionRef);

		// Test renaming for states with same name of a mode with transition
		renameElementDirectEdit(baDiagram, element(behaviorSpecification),
				BehaviorAnnexReferenceUtil.getStateRelativeReference("src_state"), "new_mode");
		renameElementDirectEdit(baDiagram, element(behaviorSpecification),
				BehaviorAnnexReferenceUtil.getStateRelativeReference("new_mode"), "src_state");

		// Test delete transition
		deleteElement(baDiagram, element(behaviorSpecification).join(transitionRef));

		// Set completeness
		clickCheckboxInPropertiesView(baDiagram, "AADL", 0, src);
	}

	// Open Behavior Annex diagram
	private static DiagramReference openDiagramFromReference(final DiagramElementReference ref,
			final String newStatePrefix,
			final int index) {
		final String diagramName = BA_TEST + "_" + newStatePrefix + "_" + BehaviorAnnexReferenceUtil.ANNEX_NAME;
		// Look for existing diagram
		final IFile diagramFile = (IFile) ResourcesPlugin.getWorkspace().getRoot()
				.findMember(BA_TEST + "/diagrams/" + diagramName + ".aadl_diagram");
		if (diagramFile == null) {
			// Create diagram if necessary
			clickContextMenuOfOutlineViewItem(ref.toOutlineTreeItemPath(),
					new String[] { "Open", "Behavior Annex Diagram" });

			waitForWindowWithTitle("Create New Diagram?");
			clickButtonForShell("Create New Diagram?", "Yes");

			waitForWindowWithTitle("Create Diagram");
			clickButtonForShell("Create Diagram", "OK");
		}

		final DiagramReference baDiagram = defaultDiagram(BA_TEST, diagramName);
		waitForDiagramActive(baDiagram);

		return baDiagram;
	}

	// Create Behavior Annex diagram
	private static DiagramReference openNewDiagramFromReference(final DiagramElementReference ref,
			final String newStatePrefix,
			final int index) {
		clickContextMenuOfOutlineViewItem(ref.toOutlineTreeItemPath(), new String[] { "Open", "New Diagram..." });

		waitForWindowWithTitle("Create Diagram");
		clickButtonForShell("Create Diagram", "OK");

		final DiagramReference baDiagram = defaultDiagram(BA_TEST,
				BA_TEST + "_" + newStatePrefix + "_" + BehaviorAnnexReferenceUtil.ANNEX_NAME);
		waitForDiagramActive(baDiagram);

		return baDiagram;
	}
}

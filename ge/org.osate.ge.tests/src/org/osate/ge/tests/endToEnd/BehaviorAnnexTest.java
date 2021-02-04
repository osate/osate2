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
	private static final String TYPE = " Type";
	private static final String NAME_SUFFIX = "_type";
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
		final RelativeBusinessObjectReference pkgRef = getRelativeReferenceForPackage(BA_TEST);
		final DiagramElementReference pkgElement = packageElement(BA_TEST);

		// Test classifiers
		createAndTestBehaviorSpecificationForClassifier("Abstract", diagram, pkgElement, pkgRef);
	}

	/*
	 * - Create a type
	 * - Create BA in classifier type
	 * - Create source Behavior State
	 * - Execute Open -> Behavior Annex Diagram
	 * - Create destination Behavior State
	 * - Create behavior variable with data classifier set as Base_Types::Character
	 * - Set data classifier for variable to data classifier data_test::temp
	 * - Create a behavior transition between source and destination
	 * - Test state and transition properties for classifier
	 * - Repeat for impl, but execute Open -> New Diagram...
	 */
	private static void createAndTestBehaviorSpecificationForClassifier(final String classifier,
			final DiagramReference diagram,
			final DiagramElementReference pkgElement, final RelativeBusinessObjectReference pkgRef) {
		final String classifierName = getName(classifier);
		// Create type
		createElementAndLayout(diagram, pkgElement, getType(classifier),
				getClassifierRelativeReference("new_classifier"), classifierName);

		// Create impl
		createImplementationWithExistingType(diagram, pkgElement, classifier + " Implementation", "impl1", BA_TEST,
				classifierName);

		final DiagramElementReference abstractImpl1 = pkgElement
				.join(getClassifierRelativeReference("Abstract_type.impl1"));

		// Create data subcomponent
		createElementAndLayout(diagram, abstractImpl1, "Data Subcomponent",
				getSubcomponentRelativeReference("Abstract_type_impl1_new_subcomponent"), "dataSub");

		createImplementationWithExistingType(diagram, pkgElement, classifier + " Implementation", "impl2", BA_TEST,
				"Abstract_type.impl1");

		final DiagramElementReference abstractImpl2 = pkgElement
				.join(getClassifierRelativeReference("Abstract_type.impl2"));

		// Show
		showContentsAndLayout(diagram, abstractImpl2);

		// Set dataSub refined
		clickCheckboxInPropertiesView(diagram, "AADL", 0, element(pkgRef,
				getClassifierRelativeReference("Abstract_type.impl2"), getSubcomponentRelativeReference("dataSub")));

		final String srcStateName = "src_state";
		// Create mode to test when source states have the same name as modes
		createElementAndLayout(diagram, pkgElement.join(getClassifierRelativeReference(classifierName)), "Mode",
				getModeRelativeReference(classifierName + "_new_mode"), srcStateName);

		// Use Open -> Behavior Annex Diagram command to create new behavior annex diagram
		final BiFunction<DiagramElementReference, String, DiagramReference> openBehaviorAnnexDiagramCommand = (ref,
				newStatePrefix) -> openDiagramFromReference(ref, newStatePrefix, 0);

		// Run tests for type
		createAndTestBehaviorSpecification(BehaviorAnnexReferenceUtil.getSpecificationRelativeReference(0),
				classifierName, diagram, pkgRef, srcStateName, openBehaviorAnnexDiagramCommand);

		// Open text editor
		doubleClickInAadlNavigator(BA_TEST, BA_TEST + ".aadl");

		// Use Open -> New Diagram... command to create new Behavior Annex diagram
		final BiFunction<DiagramElementReference, String, DiagramReference> openNewDiagramCommand = (ref,
				newStatePrefix) -> openNewDiagramFromReference(ref, newStatePrefix, 1);

		// Run tests for impl
		createAndTestBehaviorSpecification(BehaviorAnnexReferenceUtil.getSpecificationRelativeReference(1),
				classifierName + ".impl2", diagram, pkgRef, srcStateName, openNewDiagramCommand);
	}

	private static void createAndTestBehaviorSpecification(final RelativeBusinessObjectReference behaviorSpecification,
			final String classifierName,
			final DiagramReference diagram, final RelativeBusinessObjectReference pkgRef, final String srcStateName,
			final BiFunction<DiagramElementReference, String, DiagramReference> openDiagram) {
		// Create behavior specification
		createBehaviorAnnexWithState(diagram, pkgRef, classifierName, behaviorSpecification, srcStateName);

		final RelativeBusinessObjectReference classifierRef = getClassifierRelativeReference(classifierName);
		final DiagramElementReference specificationDiagramRef = new DiagramElementReference(pkgRef, classifierRef,
				behaviorSpecification);
		final DiagramElementReference src = specificationDiagramRef
				.join(BehaviorAnnexReferenceUtil.getStateRelativeReference(srcStateName));
		final String newStatePrefix = classifierName.replace(".", "_");
		final DiagramReference baDiagram = openDiagram.apply(src, newStatePrefix);

		// New specification reference for BA diagram
		final DiagramElementReference baDiagramSpecRef = new DiagramElementReference(behaviorSpecification);

		// Create state to delete
		createElementAndLayout(baDiagram, baDiagramSpecRef, "Behavior State",
				BehaviorAnnexReferenceUtil.getStateRelativeReference("new_state"), "delete_state");

		// Test deletion
		final DiagramElementReference stateToDelete = new DiagramElementReference(behaviorSpecification)
				.join(BehaviorAnnexReferenceUtil.getStateRelativeReference("delete_state"));
		deleteElement(baDiagram, stateToDelete);

		// Create destination state
		createElementAndLayout(baDiagram, baDiagramSpecRef, "Behavior State",
				BehaviorAnnexReferenceUtil.getStateRelativeReference("new_state"), "dest_state");

		// Create variable
		final String newVariableName = "ba_variable";
		createBehaviorVariable(baDiagram, baDiagramSpecRef, "Base_Types::String", "new_behavior_variable",
				newVariableName);
		deleteElement(baDiagram,
				baDiagramSpecRef.join(BehaviorAnnexReferenceUtil.getVariableRelativeReference(newVariableName)));

		createBehaviorVariable(baDiagram, baDiagramSpecRef, "Base_Types::String", "new_behavior_variable",
				newVariableName);

		// Change variable data classifier
		setBehaviorVariableDataClassifier(baDiagram,
				baDiagramSpecRef.join(BehaviorAnnexReferenceUtil.getVariableRelativeReference(newVariableName)),
				DATA_PKG + "::" + DATA_CLASSIFIER);

		final DiagramElementReference dest = new DiagramElementReference(behaviorSpecification)
				.join(BehaviorAnnexReferenceUtil.getStateRelativeReference("dest_state"));
		testBehaviorSpecification(
				new DiagramElementReference(behaviorSpecification,
						BehaviorAnnexReferenceUtil.getStateRelativeReference(srcStateName)),
				dest, baDiagram, behaviorSpecification);

		saveAndCloseDiagramEditor(baDiagram);
	}

	private static void testBehaviorSpecification(final DiagramElementReference src, final DiagramElementReference dest,
			final DiagramReference diagram, final RelativeBusinessObjectReference behaviorSpecification) {
		clickCheckboxInPropertiesView(diagram, "AADL", 1, dest);

		// Swap complete states from src to destination for classifiers
		// that require complete states and do not allow dispatch conditions
		clickCheckboxInPropertiesView(diagram, "AADL", 0, dest);
		clickCheckboxInPropertiesView(diagram, "AADL", 0, src);

		final RelativeBusinessObjectReference transitionRef = BehaviorAnnexReferenceUtil
				.getTransitionRelativeReference(0);

		// Create a transition between the states
		createConnectionElement(diagram, src, dest, "Behavior Transition",
				element(behaviorSpecification, transitionRef));

		renameElementFromContextMenu(diagram, element(behaviorSpecification), transitionRef, "new_transition",
				transitionRef);

		typeInStyledTextInPropertiesView(diagram, "AADL", 0, "on dispatch",
				element(behaviorSpecification, transitionRef));

		renameElementDirectEdit(diagram, element(behaviorSpecification),
				BehaviorAnnexReferenceUtil.getStateRelativeReference("src_state"), "new_mode");
		renameElementDirectEdit(diagram, element(behaviorSpecification),
				BehaviorAnnexReferenceUtil.getStateRelativeReference("new_mode"), "src_state");

		selectDiagramElements(diagram, element(behaviorSpecification));

		selectDiagramElements(diagram, element(behaviorSpecification, transitionRef));
		typeInStyledTextInPropertiesView(diagram, "AADL", 0, "", element(behaviorSpecification, transitionRef));

		deleteElement(diagram, element(behaviorSpecification, transitionRef));

		// Set completeness
		clickCheckboxInPropertiesView(diagram, "AADL", 0, src);
	}

	// Open Behavior Annex diagram
	private static DiagramReference openDiagramFromReference(final DiagramElementReference ref,
			final String newStatePrefix,
			final int index) {
		final String diagramName = BA_TEST + "_" + newStatePrefix + "_behavior_specification";
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
				BA_TEST + "_" + newStatePrefix + "_behavior_specification");
		waitForDiagramActive(baDiagram);

		return baDiagram;
	}

	private static String getName(final String name) {
		return new StringBuilder(name.replace(" ", "_")).append(NAME_SUFFIX).toString();
	}

	private static String getType(final String name) {
		return new StringBuilder(name).append(TYPE).toString();
	}
}

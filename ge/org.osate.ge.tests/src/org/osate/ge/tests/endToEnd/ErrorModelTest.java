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

import org.junit.Test;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.errormodel.ErrorModelReferenceUtil;
import org.osate.ge.errormodel.ui.properties.ErrorModelLibraryPropertySection;
import org.osate.ge.errormodel.ui.properties.ErrorTypeAliasPropertySection;
import org.osate.ge.errormodel.ui.properties.TransitionBranchPropertySection;
import org.osate.ge.errormodel.ui.properties.TypeSetAliasPropertySection;
import org.osate.ge.errormodel.ui.properties.TypeSetPropertySection;
import org.osate.ge.tests.endToEnd.util.DiagramElementReference;
import org.osate.ge.tests.endToEnd.util.DiagramReference;

/**
 * This class is an end to end test focusing on EMV2 annex support.
 */
public class ErrorModelTest {
	private static final String EMV2_TEST = "emv2_test";
	private static final String OTHER = "other";

	@Test
	public void testErrorModel() {
		prepareForTesting();
		createAadlProject(EMV2_TEST);

		// Create package
		createNewPackageWithPackageDiagram(EMV2_TEST, EMV2_TEST);

		final DiagramReference diagram = defaultDiagram(EMV2_TEST, EMV2_TEST);
		final RelativeBusinessObjectReference pkgRef = getRelativeReferenceForPackage(EMV2_TEST);
		final DiagramElementReference pkgElement = packageElement(EMV2_TEST);

		// Open text editor
		// TODO: Remove this once things work without text editor open
		doubleClickInAadlNavigator(EMV2_TEST, EMV2_TEST + ".aadl");

		// Create several error types
		createElementAndLayout(diagram, pkgElement, "Error Type",
				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("new_error_type"), "t1");

		createElementAndLayout(diagram, pkgElement, "Error Type",
				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("new_error_type"), "t2");

		createElementAndLayout(diagram, pkgElement, "Error Type",
				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("new_error_type"), "t3");

		createElementAndLayout(diagram, pkgElement, "Error Type",
				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("new_error_type"), "t4");

		// Create error type extension
		createElementAndLayout(diagram, pkgElement, "Error Type",
				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("new_error_type"), "t1_ext");
		final DiagramElementReference t1ExtElement = element(pkgRef,
				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("t1_ext"));
		createConnectionAndLayout(diagram, t1ExtElement,
				element(pkgRef, ErrorModelReferenceUtil.getRelativeReferenceForErrorType("t1")), "Error Type Extension",
				t1ExtElement, ErrorModelReferenceUtil.getRelativeReferenceForErrorTypeExtension(), null);

		// Create error type alias
		createElementAndLayout(diagram, pkgElement, "Error Type Alias",
				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("new_error_type_alias"), "ta1", () -> {
					waitForWindowWithTitle("Select Error Type to Alias");
					selectListItem(0, "emv2_test::t1");
					clickButton("OK");
				});

		// Verify the aliased error type and adjust it using the property section
		{
			openAadlPropertiesTab(diagram,
					element(pkgRef, ErrorModelReferenceUtil.getRelativeReferenceForErrorType("ta1")));

			// Check label to ensure that the aliased type matches the expected value
			waitUntilCLabelWithIdTextMatches(ErrorTypeAliasPropertySection.WIDGET_ID_ALIASED_TYPE_LABEL,
					"emv2_test::t1");

			clickButtonWithId(ErrorTypeAliasPropertySection.WIDGET_ID_ALIASED_TYPE_CHOOSE_BUTTON);
			waitForWindowWithTitle("Select Aliased Type");
			selectListItem(0, "emv2_test::t2");
			clickButton("OK");

			// Check the label to ensure it reflects the changes
			waitUntilCLabelWithIdTextMatches(ErrorTypeAliasPropertySection.WIDGET_ID_ALIASED_TYPE_LABEL,
					"emv2_test::t2");
		}

		// Create error type set
		createElementAndLayout(diagram, pkgElement, "Error Type Set",
				ErrorModelReferenceUtil.getRelativeReferenceForTypeSet("new_error_type_set"), "ts1", () -> {
					waitForWindowWithTitle("Select Type Tokens");

					// Add types
					clickButton("Add Error Type(s)");
					waitForWindowWithTitle("Add Types");
					selectListItems(0, "ErrorLibrary::AboveRange", "emv2_test::t1");
					clickButton("OK");

					// Add type product
					clickButton("Add Type Product");
					waitForWindowWithTitle("Select Error Types for Product");
					selectListItems(0, "emv2_test::t2", "emv2_test::t3");
					clickButton("OK");

					// Add type product
					clickButton("Add Type Product");
					waitForWindowWithTitle("Select Error Types for Product");
					selectListItems(0, "emv2_test::t2", "emv2_test::t3", "emv2_test::t4");
					clickButton("OK");

					// Remove the type product
					selectListItems(0, "emv2_test::t2 * emv2_test::t3 * emv2_test::t4");
					clickButton("Remove");

					// Add type product
					selectListItems(0, "emv2_test::t2 * emv2_test::t3");
					clickButton("Edit Type Product");
					waitForWindowWithTitle("Select Error Types for Product");
					selectListItems(0, "emv2_test::t2", "emv2_test::t4");
					clickButton("OK");

					clickButton("OK");
				});

		// Verify error type set and add additional types using the property section
		{
			openAadlPropertiesTab(diagram, element(pkgRef, ErrorModelReferenceUtil.getRelativeReferenceForTypeSet("ts1")));

			// Check label to ensure that the types match the expected value
			waitUntilCLabelWithIdTextMatches(TypeSetPropertySection.WIDGET_ID_TYPE_TOKENS_LABEL,
					"emv2_test::t1, ErrorLibrary::AboveRange, emv2_test::t2 * emv2_test::t4");

			clickButtonWithId(TypeSetPropertySection.WIDGET_ID_TYPE_TOKENS_CHOOSE_BUTTON);
			waitForWindowWithTitle("Edit Type Set");

			// Add types
			clickButton("Add Error Type(s)");
			waitForWindowWithTitle("Add Types");
			selectListItems(0, "emv2_test::t1", "emv2_test::t3");
			clickButton("OK");

			clickButton("OK");

			// Check the label to ensure it reflects the changes
			waitUntilCLabelWithIdTextMatches(TypeSetPropertySection.WIDGET_ID_TYPE_TOKENS_LABEL,
					"emv2_test::t1, ErrorLibrary::AboveRange, emv2_test::t2 * emv2_test::t4, emv2_test::t1, emv2_test::t3");
		}

		// Create a second type set
		createElementAndLayout(diagram, pkgElement, "Error Type Set",
				ErrorModelReferenceUtil.getRelativeReferenceForTypeSet("new_error_type_set"), "ts2", () -> {
					waitForWindowWithTitle("Select Type Tokens");

					// Add types
					clickButton("Add Error Type(s)");
					waitForWindowWithTitle("Add Types");
					selectListItems(0, "emv2_test::t1");
					clickButton("OK");

					clickButton("OK");
				});

		// Create type set alias
		createElementAndLayout(diagram, pkgElement, "Error Type Set Alias",
				ErrorModelReferenceUtil.getRelativeReferenceForTypeSet("new_error_type_set_alias"), "tsa1", () -> {
					waitForWindowWithTitle("Select Type Set to Alias");
					selectListItem(0, "emv2_test::ts1");
					clickButton("OK");
				});

		// Verify the aliased type set and adjust it using the property section
		{
			openAadlPropertiesTab(diagram,
					element(pkgRef, ErrorModelReferenceUtil.getRelativeReferenceForTypeSet("tsa1")));

			// Check label to ensure that the aliased type set matches the expected value
			waitUntilCLabelWithIdTextMatches(TypeSetAliasPropertySection.WIDGET_ID_ALIASED_TYPE_SET_LABEL,
					"emv2_test::ts1");

			clickButtonWithId(TypeSetAliasPropertySection.WIDGET_ID_ALIASED_TYPE_SET_CHOOSE_BUTTON);
			waitForWindowWithTitle("Select Aliased Type Set");
			selectListItem(0, "emv2_test::ts2");
			clickButton("OK");

			// Check the label to ensure it reflects the changes
			waitUntilCLabelWithIdTextMatches(TypeSetAliasPropertySection.WIDGET_ID_ALIASED_TYPE_SET_LABEL,
					"emv2_test::ts2");
		}

		// Create package to which an error type library will be added.
		createNewPackageWithPackageDiagram(EMV2_TEST, OTHER);

		final DiagramReference otherDiagram = defaultDiagram(EMV2_TEST, OTHER);
		final RelativeBusinessObjectReference otherPkgRef = getRelativeReferenceForPackage(OTHER);
		final DiagramElementReference otherPkgElement = packageElement(OTHER);

		// Open text editor
		// TODO: Remove this once things work without text editor open
		doubleClickInAadlNavigator(EMV2_TEST, OTHER + ".aadl");

		// Create an error type. This will create the error type library
		createElementAndLayout(otherDiagram, otherPkgElement, "Error Type",
				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("new_error_type"), "ot1");

		// Set an extended library, verify, and then remove it.
		{
			openAadlPropertiesTab(otherDiagram, otherPkgElement);

			// Check current value of the list
			waitUntilListWithIdItemsExists(ErrorModelLibraryPropertySection.WIDGET_ID_EXTENDED_LIBRARIES_LIST);

			clickButtonWithId(ErrorModelLibraryPropertySection.WIDGET_ID_EXTENDED_LIBRARIES_ADD_BUTTON);
			waitForWindowWithTitle("Select Error Library to Extend");
			selectListItems(0, EMV2_TEST);
			clickButton("OK");

			// Wait until the extended library appears in the list
			waitUntilListWithIdItemsExists(ErrorModelLibraryPropertySection.WIDGET_ID_EXTENDED_LIBRARIES_LIST,
					EMV2_TEST);

			// Remove the extension
			selectListWithIdItem(ErrorModelLibraryPropertySection.WIDGET_ID_EXTENDED_LIBRARIES_LIST, EMV2_TEST);
			clickButtonWithId(ErrorModelLibraryPropertySection.WIDGET_ID_EXTENDED_LIBRARIES_REMOVE_BUTTON);
			waitUntilListWithIdItemsExists(ErrorModelLibraryPropertySection.WIDGET_ID_EXTENDED_LIBRARIES_LIST);
		}

		// Create a state machine
		createElementAndLayout(otherDiagram, otherPkgElement, "Error Behavior State Machine",
				ErrorModelReferenceUtil.getRelativeReferenceForStateMachine("new_state_machine"), "esm1");
		final RelativeBusinessObjectReference esm1Ref = ErrorModelReferenceUtil
				.getRelativeReferenceForStateMachine("esm1");
		final DiagramElementReference esm1Element = element(otherPkgRef, esm1Ref);

		// Create states
		createElementAndLayout(otherDiagram, esm1Element, "Error Behavior State",
				ErrorModelReferenceUtil.getRelativeReferenceForState("new_state"), "s1");

		createElementAndLayout(otherDiagram, esm1Element, "Error Behavior State",
				ErrorModelReferenceUtil.getRelativeReferenceForState("new_state"), "s2");

		createElementAndLayout(otherDiagram, esm1Element, "Error Behavior State",
				ErrorModelReferenceUtil.getRelativeReferenceForState("new_state"), "s3");

		// Create Events
		createElementAndLayout(otherDiagram, esm1Element, "Error Event",
				ErrorModelReferenceUtil.getRelativeReferenceForEvent("new_event"), "e1");
		createElementAndLayout(otherDiagram, esm1Element, "Repair Event",
				ErrorModelReferenceUtil.getRelativeReferenceForEvent("new_event"), "e2");
		createElementAndLayout(otherDiagram, esm1Element, "Recover Event",
				ErrorModelReferenceUtil.getRelativeReferenceForEvent("new_event"), "e3");

		// Create a basic transition
		final DiagramElementReference s1Element = element(otherPkgRef, esm1Ref,
				ErrorModelReferenceUtil.getRelativeReferenceForState("s1"));
		final DiagramElementReference s2Element = element(otherPkgRef, esm1Ref,
				ErrorModelReferenceUtil.getRelativeReferenceForState("s2"));
		final DiagramElementReference s3Element = element(otherPkgRef, esm1Ref,
				ErrorModelReferenceUtil.getRelativeReferenceForState("s3"));

		createConnectionAndLayout(otherDiagram, s1Element, s2Element, "Error Behavior Transition", esm1Element,
				ErrorModelReferenceUtil.getRelativeReferenceForNamedTransition("new_transition"), "t1", () -> {
					waitForWindowWithTitle("Select Event");
					selectListItems(0, "e2");
					clickButton("OK");
				});

		// Create a transition branch
		final DiagramElementReference t1Element = element(otherPkgRef, esm1Ref,
				ErrorModelReferenceUtil.getRelativeReferenceForNamedTransition("t1"));
		createConnectionAndLayout(otherDiagram, t1Element, s3Element, "Error Behavior Transition", t1Element,
				ErrorModelReferenceUtil.getRelativeReferenceForTransitionBranch("s3", 0), null);

		// Set the initial state
		{
			openAadlPropertiesTab(otherDiagram,
					element(otherPkgRef, esm1Ref, ErrorModelReferenceUtil.getRelativeReferenceForState("s1")));

			// Check the initial box
			waitUntilCheckboxCheckedState("Initial", false);
			clickCheckbox("Initial");

			// Verify
			selectDiagramElements(otherDiagram, otherPkgElement);
			openAadlPropertiesTab(otherDiagram,
					element(otherPkgRef, esm1Ref, ErrorModelReferenceUtil.getRelativeReferenceForState("s1")));
			waitUntilCheckboxCheckedState("Initial", true);
		}

		// Set the value of the probability for branches
		{
			openAadlPropertiesTab(otherDiagram,
					element(otherPkgRef, esm1Ref, ErrorModelReferenceUtil.getRelativeReferenceForNamedTransition("t1"),
							ErrorModelReferenceUtil.getRelativeReferenceForTransitionBranch("s2", 0)));
			setTextFieldWithIdText(TransitionBranchPropertySection.WIDGET_ID_PROBABILITY, "0.3");
			focusDiagramEditor(otherDiagram); // Value is saved when focus changes

			openAadlPropertiesTab(otherDiagram,
					element(otherPkgRef, esm1Ref, ErrorModelReferenceUtil.getRelativeReferenceForNamedTransition("t1"),
							ErrorModelReferenceUtil.getRelativeReferenceForTransitionBranch("s3", 0)));
			setTextFieldWithIdText(TransitionBranchPropertySection.WIDGET_ID_PROBABILITY, "0.7");
			focusDiagramEditor(otherDiagram); // Value is saved when focus changes

			// Select another element
			selectDiagramElements(otherDiagram, otherPkgElement);

			// Verify
			openAadlPropertiesTab(otherDiagram,
					element(otherPkgRef, esm1Ref, ErrorModelReferenceUtil.getRelativeReferenceForNamedTransition("t1"),
							ErrorModelReferenceUtil.getRelativeReferenceForTransitionBranch("s2", 0)));
			waitUntilTextFieldWithIdTextMatches(TransitionBranchPropertySection.WIDGET_ID_PROBABILITY, "0.3");

			openAadlPropertiesTab(otherDiagram,
					element(otherPkgRef, esm1Ref, ErrorModelReferenceUtil.getRelativeReferenceForNamedTransition("t1"),
							ErrorModelReferenceUtil.getRelativeReferenceForTransitionBranch("s3", 0)));
			waitUntilTextFieldWithIdTextMatches(TransitionBranchPropertySection.WIDGET_ID_PROBABILITY, "0.7");
		}

		// TODO: Remove when text editor is no longer opened as part of test.
		saveAndCloseTextEditorByTitle(OTHER + ".aadl");
		saveAndCloseTextEditorByTitle(EMV2_TEST + ".aadl");
	}
}

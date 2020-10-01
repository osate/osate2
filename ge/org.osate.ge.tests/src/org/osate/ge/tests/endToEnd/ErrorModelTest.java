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

/**
 * This class is an end to end test focusing on EMV2 annex support.
 */
public class ErrorModelTest {
	// Disabled until the graphical editor error model plugin is promoted out of experimental
//	private static final String EMV2_TEST = "emv2_test";
//	private static final String ERROR_FLOW_TEST = "error_flow_test";
//	private static final String OTHER = "other";
//
//	@Test
//	public void testErrorModelLibrary() {
//		prepareForTesting();
//		createAadlProject(EMV2_TEST);
//
//		// Create package
//		createNewPackageWithPackageDiagram(EMV2_TEST, EMV2_TEST);
//
//		final DiagramReference diagram = defaultDiagram(EMV2_TEST, EMV2_TEST);
//		final RelativeBusinessObjectReference pkgRef = getRelativeReferenceForPackage(EMV2_TEST);
//		final DiagramElementReference pkgElement = packageElement(EMV2_TEST);
//
//		// Open text editor
//		doubleClickInAadlNavigator(EMV2_TEST, EMV2_TEST + ".aadl");
//
//		// Create several error types
//		createElementAndLayout(diagram, pkgElement, "Error Type",
//				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("new_error_type"), "t1");
//
//		createElementAndLayout(diagram, pkgElement, "Error Type",
//				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("new_error_type"), "t2");
//
//		createElementAndLayout(diagram, pkgElement, "Error Type",
//				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("new_error_type"), "t3");
//
//		createElementAndLayout(diagram, pkgElement, "Error Type",
//				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("new_error_type"), "t4");
//
//		// Create error type extension
//		createElementAndLayout(diagram, pkgElement, "Error Type",
//				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("new_error_type"), "t1_ext");
//		final DiagramElementReference t1ExtElement = element(pkgRef,
//				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("t1_ext"));
//		createConnectionAndLayout(diagram, t1ExtElement,
//				element(pkgRef, ErrorModelReferenceUtil.getRelativeReferenceForErrorType("t1")), "Error Type Extension",
//				t1ExtElement, ErrorModelReferenceUtil.getRelativeReferenceForErrorTypeExtension(), null);
//
//		// Create error type alias
//		createElementAndLayout(diagram, pkgElement, "Error Type Alias",
//				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("new_error_type_alias"), "ta1", () -> {
//					waitForWindowWithTitle("Select Error Type to Alias");
//					selectListItem(0, "emv2_test::t1");
//					clickButton("OK");
//				});
//
//		// Verify the aliased error type and adjust it using the property section
//		{
//			openAadlPropertiesTab(diagram,
//					element(pkgRef, ErrorModelReferenceUtil.getRelativeReferenceForErrorType("ta1")));
//
//			// Check label to ensure that the aliased type matches the expected value
//			waitUntilBorderedCLabelWithIdTextMatches(ErrorTypeAliasPropertySection.WIDGET_ID_ALIASED_TYPE_LABEL,
//					"emv2_test::t1");
//
//			clickButtonWithId(ErrorTypeAliasPropertySection.WIDGET_ID_ALIASED_TYPE_CHOOSE_BUTTON);
//			waitForWindowWithTitle("Select Aliased Type");
//			selectListItem(0, "emv2_test::t2");
//			clickButton("OK");
//
//			// Check the label to ensure it reflects the changes
//			waitUntilBorderedCLabelWithIdTextMatches(ErrorTypeAliasPropertySection.WIDGET_ID_ALIASED_TYPE_LABEL,
//					"emv2_test::t2");
//		}
//
//		// Create error type set
//		createElementAndLayout(diagram, pkgElement, "Error Type Set",
//				ErrorModelReferenceUtil.getRelativeReferenceForTypeSet("new_error_type_set"), "ts1", () -> {
//					waitForWindowWithTitle("Select Type Tokens");
//
//					// Add types
//					clickButton("Add Error Type(s)");
//					waitForWindowWithTitle("Add Types");
//					selectListItems(0, "ErrorLibrary::AboveRange", "emv2_test::t1");
//					clickButton("OK");
//
//					// Add type product
//					clickButton("Add Type Product");
//					waitForWindowWithTitle("Select Error Types for Product");
//					selectListItems(0, "emv2_test::t2", "emv2_test::t3");
//					clickButton("OK");
//
//					// Add type product
//					clickButton("Add Type Product");
//					waitForWindowWithTitle("Select Error Types for Product");
//					selectListItems(0, "emv2_test::t2", "emv2_test::t3", "emv2_test::t4");
//					clickButton("OK");
//
//					// Remove the type product
//					selectListItems(0, "emv2_test::t2 * emv2_test::t3 * emv2_test::t4");
//					clickButton("Remove");
//
//					// Add type product
//					selectListItems(0, "emv2_test::t2 * emv2_test::t3");
//					clickButton("Edit Type Product");
//					waitForWindowWithTitle("Select Error Types for Product");
//					selectListItems(0, "emv2_test::t2", "emv2_test::t4");
//					clickButton("OK");
//
//					clickButton("OK");
//				});
//
//		// Verify error type set and add additional types using the property section
//		{
//			openAadlPropertiesTab(diagram, element(pkgRef, ErrorModelReferenceUtil.getRelativeReferenceForTypeSet("ts1")));
//
//			// Check label to ensure that the types match the expected value
//			waitUntilBorderedCLabelWithIdTextMatches(TypeSetPropertySection.WIDGET_ID_TYPE_TOKENS_LABEL,
//					"emv2_test::t1, ErrorLibrary::AboveRange, emv2_test::t2 * emv2_test::t4");
//
//			clickButtonWithId(TypeSetPropertySection.WIDGET_ID_TYPE_TOKENS_CHOOSE_BUTTON);
//			waitForWindowWithTitle("Edit Type Set");
//
//			// Add types
//			clickButton("Add Error Type(s)");
//			waitForWindowWithTitle("Add Types");
//			selectListItems(0, "emv2_test::t1", "emv2_test::t3");
//			clickButton("OK");
//
//			clickButton("OK");
//
//			// Check the label to ensure it reflects the changes
//			waitUntilBorderedCLabelWithIdTextMatches(TypeSetPropertySection.WIDGET_ID_TYPE_TOKENS_LABEL,
//					"emv2_test::t1, ErrorLibrary::AboveRange, emv2_test::t2 * emv2_test::t4, emv2_test::t1, emv2_test::t3");
//		}
//
//		// Create a second type set
//		createElementAndLayout(diagram, pkgElement, "Error Type Set",
//				ErrorModelReferenceUtil.getRelativeReferenceForTypeSet("new_error_type_set"), "ts2", () -> {
//					waitForWindowWithTitle("Select Type Tokens");
//
//					// Add types
//					clickButton("Add Error Type(s)");
//					waitForWindowWithTitle("Add Types");
//					selectListItems(0, "emv2_test::t1");
//					clickButton("OK");
//
//					clickButton("OK");
//				});
//
//		// Create type set alias
//		createElementAndLayout(diagram, pkgElement, "Error Type Set Alias",
//				ErrorModelReferenceUtil.getRelativeReferenceForTypeSet("new_error_type_set_alias"), "tsa1", () -> {
//					waitForWindowWithTitle("Select Type Set to Alias");
//					selectListItem(0, "emv2_test::ts1");
//					clickButton("OK");
//				});
//
//		// Verify the aliased type set and adjust it using the property section
//		{
//			openAadlPropertiesTab(diagram,
//					element(pkgRef, ErrorModelReferenceUtil.getRelativeReferenceForTypeSet("tsa1")));
//
//			// Check label to ensure that the aliased type set matches the expected value
//			waitUntilBorderedCLabelWithIdTextMatches(TypeSetAliasPropertySection.WIDGET_ID_ALIASED_TYPE_SET_LABEL,
//					"emv2_test::ts1");
//
//			clickButtonWithId(TypeSetAliasPropertySection.WIDGET_ID_ALIASED_TYPE_SET_CHOOSE_BUTTON);
//			waitForWindowWithTitle("Select Aliased Type Set");
//			selectListItem(0, "emv2_test::ts2");
//			clickButton("OK");
//
//			// Check the label to ensure it reflects the changes
//			waitUntilBorderedCLabelWithIdTextMatches(TypeSetAliasPropertySection.WIDGET_ID_ALIASED_TYPE_SET_LABEL,
//					"emv2_test::ts2");
//		}
//
//		// Create package to which an error type library will be added.
//		createNewPackageWithPackageDiagram(EMV2_TEST, OTHER);
//
//		final DiagramReference otherDiagram = defaultDiagram(EMV2_TEST, OTHER);
//		final RelativeBusinessObjectReference otherPkgRef = getRelativeReferenceForPackage(OTHER);
//		final DiagramElementReference otherPkgElement = packageElement(OTHER);
//
//		// Open text editor
//		// TODO: Remove this once things work without text editor open
//		doubleClickInAadlNavigator(EMV2_TEST, OTHER + ".aadl");
//
//		// Create an error type. This will create the error type library
//		createElementAndLayout(otherDiagram, otherPkgElement, "Error Type",
//				ErrorModelReferenceUtil.getRelativeReferenceForErrorType("new_error_type"), "ot1");
//
//		// Set an extended library, verify, and then remove it.
//		{
//			openAadlPropertiesTab(otherDiagram, otherPkgElement);
//
//			// Check current value of the list
//			waitUntilListWithIdItemsExists(ErrorModelLibraryPropertySection.WIDGET_ID_EXTENDED_LIBRARIES_LIST);
//
//			clickButtonWithId(ErrorModelLibraryPropertySection.WIDGET_ID_EXTENDED_LIBRARIES_ADD_BUTTON);
//			waitForWindowWithTitle("Select Error Library to Extend");
//			selectListItems(0, EMV2_TEST);
//			clickButton("OK");
//
//			// Wait until the extended library appears in the list
//			waitUntilListWithIdItemsExists(ErrorModelLibraryPropertySection.WIDGET_ID_EXTENDED_LIBRARIES_LIST,
//					EMV2_TEST);
//
//			// Remove the extension
//			selectListWithIdItem(ErrorModelLibraryPropertySection.WIDGET_ID_EXTENDED_LIBRARIES_LIST, EMV2_TEST);
//			clickButtonWithId(ErrorModelLibraryPropertySection.WIDGET_ID_EXTENDED_LIBRARIES_REMOVE_BUTTON);
//			waitUntilListWithIdItemsExists(ErrorModelLibraryPropertySection.WIDGET_ID_EXTENDED_LIBRARIES_LIST);
//		}
//
//		// Create a state machine
//		createElementAndLayout(otherDiagram, otherPkgElement, "Error Behavior State Machine",
//				ErrorModelReferenceUtil.getRelativeReferenceForStateMachine("new_state_machine"), "esm1");
//		final RelativeBusinessObjectReference esm1Ref = ErrorModelReferenceUtil
//				.getRelativeReferenceForStateMachine("esm1");
//		final DiagramElementReference esm1Element = element(otherPkgRef, esm1Ref);
//
//		// Create states
//		createElementAndLayout(otherDiagram, esm1Element, "Error State",
//				ErrorModelReferenceUtil.getRelativeReferenceForState("new_state"), "s1");
//
//		createElementAndLayout(otherDiagram, esm1Element, "Error State",
//				ErrorModelReferenceUtil.getRelativeReferenceForState("new_state"), "s2");
//
//		createElementAndLayout(otherDiagram, esm1Element, "Error State",
//				ErrorModelReferenceUtil.getRelativeReferenceForState("new_state"), "s3");
//
//		// Create Events
//		createElementAndLayout(otherDiagram, esm1Element, "Error Event",
//				ErrorModelReferenceUtil.getRelativeReferenceForEvent("new_event"), "e1");
//		createElementAndLayout(otherDiagram, esm1Element, "Repair Event",
//				ErrorModelReferenceUtil.getRelativeReferenceForEvent("new_event"), "e2");
//		createElementAndLayout(otherDiagram, esm1Element, "Recover Event",
//				ErrorModelReferenceUtil.getRelativeReferenceForEvent("new_event"), "e3");
//
//		// Create a basic transition
//		final DiagramElementReference s1Element = element(otherPkgRef, esm1Ref,
//				ErrorModelReferenceUtil.getRelativeReferenceForState("s1"));
//		final DiagramElementReference s2Element = element(otherPkgRef, esm1Ref,
//				ErrorModelReferenceUtil.getRelativeReferenceForState("s2"));
//		final DiagramElementReference s3Element = element(otherPkgRef, esm1Ref,
//				ErrorModelReferenceUtil.getRelativeReferenceForState("s3"));
//
//		createConnectionAndLayout(otherDiagram, s1Element, s2Element, "Error Behavior Transition", esm1Element,
//				ErrorModelReferenceUtil.getRelativeReferenceForNamedTransition("new_transition"), "t1", () -> {
//					waitForWindowWithTitle("Select Event");
//					selectListItems(0, "e2");
//					clickButton("OK");
//				});
//
//		// Create a transition branch
//		final DiagramElementReference t1Element = element(otherPkgRef, esm1Ref,
//				ErrorModelReferenceUtil.getRelativeReferenceForNamedTransition("t1"));
//		createConnectionAndLayout(otherDiagram, t1Element, s3Element, "Error Behavior Transition", t1Element,
//				ErrorModelReferenceUtil.getRelativeReferenceForTransitionBranch("s3", 0), null);
//
//		// Set the initial state
//		{
//			openAadlPropertiesTab(otherDiagram,
//					element(otherPkgRef, esm1Ref, ErrorModelReferenceUtil.getRelativeReferenceForState("s1")));
//
//			// Check the initial box
//			waitUntilCheckboxCheckedState("Initial", false);
//			clickCheckbox("Initial");
//
//			// Verify
//			selectDiagramElements(otherDiagram, otherPkgElement);
//			openAadlPropertiesTab(otherDiagram,
//					element(otherPkgRef, esm1Ref, ErrorModelReferenceUtil.getRelativeReferenceForState("s1")));
//			waitUntilCheckboxCheckedState("Initial", true);
//		}
//
//		// Set the value of the probability for branches
//		{
//			openAadlPropertiesTab(otherDiagram,
//					element(otherPkgRef, esm1Ref, ErrorModelReferenceUtil.getRelativeReferenceForNamedTransition("t1"),
//							ErrorModelReferenceUtil.getRelativeReferenceForTransitionBranch("s2", 0)));
//			setTextFieldWithIdText(TransitionBranchPropertySection.WIDGET_ID_PROBABILITY, "0.3");
//			focusDiagramEditor(otherDiagram); // Value is saved when focus changes
//
//			openAadlPropertiesTab(otherDiagram,
//					element(otherPkgRef, esm1Ref, ErrorModelReferenceUtil.getRelativeReferenceForNamedTransition("t1"),
//							ErrorModelReferenceUtil.getRelativeReferenceForTransitionBranch("s3", 0)));
//			setTextFieldWithIdText(TransitionBranchPropertySection.WIDGET_ID_PROBABILITY, "0.7");
//			focusDiagramEditor(otherDiagram); // Value is saved when focus changes
//
//			// Select another element
//			selectDiagramElements(otherDiagram, otherPkgElement);
//
//			// Verify
//			openAadlPropertiesTab(otherDiagram,
//					element(otherPkgRef, esm1Ref, ErrorModelReferenceUtil.getRelativeReferenceForNamedTransition("t1"),
//							ErrorModelReferenceUtil.getRelativeReferenceForTransitionBranch("s2", 0)));
//			waitUntilTextFieldWithIdTextMatches(TransitionBranchPropertySection.WIDGET_ID_PROBABILITY, "0.3");
//
//			openAadlPropertiesTab(otherDiagram,
//					element(otherPkgRef, esm1Ref, ErrorModelReferenceUtil.getRelativeReferenceForNamedTransition("t1"),
//							ErrorModelReferenceUtil.getRelativeReferenceForTransitionBranch("s3", 0)));
//			waitUntilTextFieldWithIdTextMatches(TransitionBranchPropertySection.WIDGET_ID_PROBABILITY, "0.7");
//		}
//	}
//
//	@Test
//	public void testErrorFlows() {
//		prepareForTesting();
//		createAadlProject(ERROR_FLOW_TEST);
//
//		// Create a package
//		createNewPackageWithPackageDiagram(ERROR_FLOW_TEST, ERROR_FLOW_TEST);
//		final DiagramReference diagram = defaultDiagram(ERROR_FLOW_TEST, ERROR_FLOW_TEST);
//		final DiagramElementReference pkgElement = packageElement(ERROR_FLOW_TEST);
//		final RelativeBusinessObjectReference pkgRef = getRelativeReferenceForPackage(ERROR_FLOW_TEST);
//
//		// Open text editor
//		doubleClickInAadlNavigator(ERROR_FLOW_TEST, ERROR_FLOW_TEST + ".aadl");
//
//		//
//		// Create system implementation to use as the subsystem
//		//
//		createImplementationWithNewType(diagram, pkgElement, "System Implementation", "impl", "subsystem");
//		final DiagramElementReference subsystemRef = element(pkgRef,
//				getClassifierRelativeReference("subsystem.impl"));
//
//		// Create and rename propagation point
//		createElementAndLayout(diagram, subsystemRef, "Propagation Point",
//				ErrorModelReferenceUtil
//						.getRelativeReferenceForPropagationPoint("subsystem_impl_new_propagation_point"),
//				"ss_pp1");
//
//		//
//		// Create top level system implementation
//		//
//		createImplementationWithNewType(diagram, pkgElement, "System Implementation", "impl", "test_system");
//		final DiagramElementReference sysImplElement = element(pkgRef, getClassifierRelativeReference("test_system.impl"));
//
//		//
//		// Create subsystem
//		//
//		createElementAndLayout(diagram, sysImplElement, "System Subcomponent",
//				getSubcomponentRelativeReference("test_system_impl_new_subcomponent"), "sc1");
//		final DiagramElementReference sc1Ref = sysImplElement.join(getSubcomponentRelativeReference("sc1"));
//		setSubcomponentClassifierFromPropertiesView(diagram, ERROR_FLOW_TEST + "::subsystem.impl", sc1Ref);
//		showContentsAndLayout(diagram, sc1Ref);
//		final DiagramElementReference sc1Pp1Ref = sc1Ref
//				.join(ErrorModelReferenceUtil.getRelativeReferenceForPropagationPoint("ss_pp1"));
//
//		//
//		// Propagation Points
//		//
//		// Create and rename propagation point
//		createElementAndLayout(diagram, sysImplElement,
//				"Propagation Point",
//				ErrorModelReferenceUtil
//						.getRelativeReferenceForPropagationPoint("test_system_impl_new_propagation_point"),
//				"pp1");
//
//		// Create another propagation point and delete it.
//		createElementAndLayout(diagram, sysImplElement,
//				"Propagation Point",
//				ErrorModelReferenceUtil
//						.getRelativeReferenceForPropagationPoint("test_system_impl_new_propagation_point"),
//				"pp2");
//		deleteElement(diagram,
//				sysImplElement.join(ErrorModelReferenceUtil.getRelativeReferenceForPropagationPoint("pp2")));
//
//		//
//		// Feature Group Type
//		//
//		createElementAndLayout(diagram, pkgElement, "Feature Group Type",
//				getClassifierRelativeReference("new_classifier"), "test_fgt");
//		createElementAndLayout(diagram, pkgElement.join(getClassifierRelativeReference("test_fgt")),
//				"Data Port", getFeatureRelativeReference("test_fgt_new_feature"), "i1");
//
//		//
//		// Propagations
//		//
//		createElementAndLayout(diagram, sysImplElement, "Data Port",
//				getFeatureRelativeReference("test_system_new_feature"), "o1");
//		createElementAndLayout(diagram, sysImplElement, "Feature Group",
//				getFeatureRelativeReference("test_system_new_feature"), "fg1");
//		final DiagramElementReference fg1Element = sysImplElement.join(getFeatureRelativeReference("fg1"));
//		setExtendedOrFeatureClassifierFromPropertiesView(diagram, ERROR_FLOW_TEST + "::test_fgt",
//				fg1Element);
//
//		// Show elements
//		clickContextMenuOfDiagramElement(diagram, sysImplElement, "Show Contents", "Error Propagation Point Keywords");
//		showContentsAndLayout(diagram, fg1Element);
//
//		// Create propagation for port
//		final DiagramElementReference o1Ref = sysImplElement.join(getFeatureRelativeReference("o1"));
//		createShapeElement(diagram, o1Ref, "Out Error Propagation",
//				ErrorModelReferenceUtil.getRelativeReferenceForPropagation(false, DirectionType.OUT),
//				ErrorModelTest::selectSingleErrorType);
//		final DiagramElementReference o1PropagationRef = o1Ref
//				.join(ErrorModelReferenceUtil.getRelativeReferenceForPropagation(false, DirectionType.OUT));
//
//		// Create propagation for feature group port
//		final DiagramElementReference i1Ref = fg1Element.join(getFeatureRelativeReference("i1"));
//		createShapeElement(diagram,
//				i1Ref,
//				"In Error Propagation",
//				ErrorModelReferenceUtil.getRelativeReferenceForPropagation(false, DirectionType.IN),
//				ErrorModelTest::selectSingleErrorType);
//		final DiagramElementReference i1PropagationRef = i1Ref.join(ErrorModelReferenceUtil.getRelativeReferenceForPropagation(false, DirectionType.IN));
//
//		// Create propagation for propagation point
//		final DiagramElementReference pp1Ref = sysImplElement
//				.join(ErrorModelReferenceUtil.getRelativeReferenceForPropagationPoint("pp1"));
//		createShapeElement(diagram,
//				pp1Ref,
//				"Out Error Containment",
//				ErrorModelReferenceUtil.getRelativeReferenceForPropagation(true, DirectionType.OUT),
//				ErrorModelTest::selectSingleErrorType);
//		final DiagramElementReference pp1PropagationRef = pp1Ref
//				.join(ErrorModelReferenceUtil.getRelativeReferenceForPropagation(true, DirectionType.OUT));
//
//		// Create propagation for keyword propagation
//		createShapeElement(diagram,
//				sysImplElement.join(ErrorModelReferenceUtil.getRelativeReferenceForKeywordPropagationPoint(
//						KeywordPropagationPointType.BINDINGS.getKind())),
//				"In Error Containment",
//				ErrorModelReferenceUtil.getRelativeReferenceForPropagation(true, DirectionType.IN),
//				ErrorModelTest::selectSingleErrorType);
//
//		// Verify error propagation type set is correct and can be set using the property section
//		{
//			openAadlPropertiesTab(diagram, o1PropagationRef);
//			addTypeToSelectedPropagationTypeSet();
//		}
//
//		// Select two not-identical type sets and confirm label
//		openAadlPropertiesTab(diagram, o1PropagationRef, pp1PropagationRef);
//		waitUntilBorderedCLabelWithIdTextMatches(ErrorPropagationPropertySection.WIDGET_ID_TYPE_TOKENS_LABEL,
//				"<Multiple Type Sets Selected>");
//
//		// Select two other propagations with identical type sets and change
//		openAadlPropertiesTab(diagram, i1PropagationRef, pp1PropagationRef);
//		addTypeToSelectedPropagationTypeSet();
//
//
//		layoutDiagram(diagram, sysImplElement);
//
//		//
//		// Propagation Path
//		//
//		createConnectionAndLayout(diagram,
//				o1Ref,
//				sc1Pp1Ref,
//				"Propagation Path",
//				sysImplElement,
//				ErrorModelReferenceUtil.getRelativeReferenceForPropagationPath(
//						"test_system_impl_new_propagation_path"),
//				"test_propagation_path1");
//
//		deleteElement(diagram, sysImplElement
//				.join(ErrorModelReferenceUtil.getRelativeReferenceForPropagationPath("test_propagation_path1")));
//
//		//
//		// Error Flows
//		//
//		createConnectionAndLayout(diagram, i1Ref, o1Ref, "Error Path", sysImplElement,
//				ErrorModelReferenceUtil.getRelativeReferenceForErrorFlow("test_system_impl_new_error_flow"), "epath1");
//		final DiagramElementReference errorPathElement = sysImplElement
//				.join(ErrorModelReferenceUtil.getRelativeReferenceForErrorFlow("epath1"));
//		createFlowIndicatorAndLayout(diagram, sysImplElement, "Error Source", o1Ref,
//				ErrorModelReferenceUtil.getRelativeReferenceForErrorFlow("test_system_impl_new_error_flow"), "esrc1");
//		final DiagramElementReference errorSourceElement = sysImplElement
//				.join(ErrorModelReferenceUtil.getRelativeReferenceForErrorFlow("esrc1"));
//		createFlowIndicatorAndLayout(diagram, sysImplElement, "Error Sink", i1Ref,
//				ErrorModelReferenceUtil.getRelativeReferenceForErrorFlow("test_system_impl_new_error_flow"), "esnk1");
//
//		// Error Type Set - Add
//		{
//			openAadlPropertiesTab(diagram, errorPathElement);
//
//			// Select the error type set for the error flow
//			clickButtonWithId(ErrorFlowPropertySection.WIDGET_ID_ERROR_TYPE_SET_TOKENS_CHOOSE_BUTTON);
//			waitForWindowWithTitle("Edit Type Set");
//			clickButton("Add Error Type(s)");
//			waitForWindowWithTitle("Add Types");
//			selectListItems(0, "ErrorLibrary::AboveRange");
//			clickButton("OK");
//			clickButton("OK");
//
//			// Check the label to ensure it reflects the changes
//			waitUntilBorderedCLabelWithIdTextMatches(ErrorFlowPropertySection.WIDGET_ID_ERROR_TYPE_SET_TOKENS_LABEL,
//					"ErrorLibrary::AboveRange");
//		}
//
//		// Error Type Set - Clear
//		{
//			openAadlPropertiesTab(diagram, errorPathElement);
//
//			// Select the error type set for the error flow
//			clickButtonWithId(ErrorFlowPropertySection.WIDGET_ID_ERROR_TYPE_SET_TOKENS_CHOOSE_BUTTON);
//			waitForWindowWithTitle("Edit Type Set");
//			selectListItems(0, "ErrorLibrary::AboveRange");
//			clickButton("Remove");
//			clickButton("OK");
//
//			// Check the label to ensure it reflects the changes
//			waitUntilBorderedCLabelWithIdTextMatches(ErrorFlowPropertySection.WIDGET_ID_ERROR_TYPE_SET_TOKENS_LABEL,
//					"");
//		}
//
//		// Target Error Type Instance - Add
//		{
//			openAadlPropertiesTab(diagram, errorPathElement);
//
//			// Select the error type set for the error flow
//			clickButtonWithId(ErrorPathPropertySection.WIDGET_ID_ERROR_TARGET_ERROR_TYPE_INSTANCE_CHOOSE_BUTTON);
//			waitForWindowWithTitle("Edit Type Set");
//			clickButton("Add Error Type(s)");
//			waitForWindowWithTitle("Add Types");
//			selectListItems(0, "ErrorLibrary::AboveRange");
//			clickButton("OK");
//			clickButton("OK");
//
//			// Check the label to ensure it reflects the changes
//			waitUntilBorderedCLabelWithIdTextMatches(
//					ErrorPathPropertySection.WIDGET_ID_ERROR_TARGET_ERROR_TYPE_INSTANCE_LABEL,
//					"ErrorLibrary::AboveRange");
//		}
//
//		// Target Error Type Instance - Clear
//		{
//			openAadlPropertiesTab(diagram, errorPathElement);
//
//			// Select the error type set for the error flow
//			clickButtonWithId(ErrorPathPropertySection.WIDGET_ID_ERROR_TARGET_ERROR_TYPE_INSTANCE_CHOOSE_BUTTON);
//			waitForWindowWithTitle("Edit Type Set");
//			selectListItems(0, "ErrorLibrary::AboveRange");
//			clickButton("Remove");
//			clickButton("OK");
//
//			// Check the label to ensure it reflects the changes
//			waitUntilBorderedCLabelWithIdTextMatches(
//					ErrorPathPropertySection.WIDGET_ID_ERROR_TARGET_ERROR_TYPE_INSTANCE_LABEL,
//					"");
//		}
//
//		// Set the error behavior of the classifier. This is needed to select a state for the error source
//		{
//			openAadlPropertiesTab(diagram, sysImplElement);
//
//			// Select button to choose the error behavior
//			clickButtonWithId(ErrorModelSubclausePropertySection.WIDGET_ID_BEHAVIOR_CHOOSE_BUTTON);
//			waitForWindowWithTitle("Select Error Behavior State Machine");
//			selectListItem(0, "ErrorLibrary::FailAndRecover");
//			clickButton("OK");
//
//			// Check the label to ensure it reflects the changes
//			waitUntilBorderedCLabelWithIdTextMatches(ErrorModelSubclausePropertySection.WIDGET_ID_BEHAVIOR_VALUE_LABEL,
//					"ErrorLibrary::FailAndRecover");
//		}
//
//		// Fault Source - Text Description
//		{
//			openAadlPropertiesTab(diagram, errorSourceElement);
//
//			// Select button to choose the error behavior
//			clickButtonWithId(ErrorSourcePropertySection.WIDGET_ID_FAULT_SOURCE_CHOOSE_BUTTON);
//			waitForWindowWithTitle("Edit Fault Source");
//			clickRadioButton("Description");
//			setTextFieldWithIdText(FaultSourceEditorDialog.WIDGET_ID_DESCRIPTION_TEXT, "Test Fault Source");
//			clickButton("OK");
//
//			// Check the label to ensure it reflects the changes
//			waitUntilBorderedCLabelWithIdTextMatches(ErrorSourcePropertySection.WIDGET_ID_FAULT_SOURCE_LABEL,
//					"Test Fault Source");
//		}
//
//		// Fault Source - Error Type Set
//		{
//			openAadlPropertiesTab(diagram, errorSourceElement);
//
//			// Select button to choose the error behavior
//			clickButtonWithId(ErrorSourcePropertySection.WIDGET_ID_FAULT_SOURCE_CHOOSE_BUTTON);
//			waitForWindowWithTitle("Edit Fault Source");
//			clickRadioButton("Error Type Set");
//
//			// Select the Error Behavior State
//			clickButtonWithId(FaultSourceEditorDialog.WIDGET_ID_STATE_MODIFY_BUTTON);
//			waitForWindowWithTitle("Select");
//			selectListItem(0, "Failed");
//			clickButton("OK");
//
//			// Select the Type Set
//			clickButtonWithId(FaultSourceEditorDialog.WIDGET_ID_TYPE_SET_MODIFY_BUTTON);
//			waitForWindowWithTitle("Edit Type Set");
//			clickButton("Add Error Type(s)");
//			waitForWindowWithTitle("Add Types");
//			selectListItems(0, "ErrorLibrary::BadValue");
//			clickButton("OK");
//			clickButton("OK");
//
//			clickButton("OK");
//
//			// Check the label to ensure it reflects the changes
//			waitUntilBorderedCLabelWithIdTextMatches(ErrorSourcePropertySection.WIDGET_ID_FAULT_SOURCE_LABEL,
//					"Failed {ErrorLibrary::BadValue}");
//		}
//
//		// Set the fault condition
//		{
//			openAadlPropertiesTab(diagram, errorSourceElement);
//			setFocusToTextFieldWithId(ErrorSourcePropertySection.WIDGET_ID_FAULT_CONDITION_TEXT);
//			final String faultCondition = "Test Fault Condition";
//			setTextFieldWithIdText(ErrorSourcePropertySection.WIDGET_ID_FAULT_CONDITION_TEXT,
//					"Test Fault Condition");
//			focusDiagramEditor(diagram);
//			waitForDiagramElementCondition(diagram, errorSourceElement,
//					"Fault condition does not match '" + faultCondition + "'",
//					de -> {
//						return de.getBusinessObject(ErrorSource.class)
//								.map(s -> s.getFlowcondition() == null ? null : s.getFlowcondition().getDescription())
//								.filter(d -> Objects.equals(d, faultCondition)).isPresent();
//					});
//		}
//
//		//
//		// Delete error flows
//		//
//		deleteElement(diagram, errorSourceElement);
//		deleteElement(diagram, sysImplElement.join(ErrorModelReferenceUtil.getRelativeReferenceForErrorFlow("epath1")));
//
//		//
//		// Delete a propagation
//		//
//		deleteElement(diagram,
//				o1Ref.join(ErrorModelReferenceUtil.getRelativeReferenceForPropagation(false, DirectionType.OUT)));
//
//		saveAndCloseTextEditorByTitle(ERROR_FLOW_TEST + ".aadl");
//		saveAndCloseDiagramEditor(diagram);
//	}
//
//	/**
//	 * Helper function for tests that require selecting an error type from the "Select Type Tokens" dialog.
//	 */
//	private static void selectSingleErrorType() {
//		waitForWindowWithTitle("Select Type Tokens");
//
//		// Add types
//		clickButton("Add Error Type(s)");
//		waitForWindowWithTitle("Add Types");
//		selectListItems(0, "ErrorLibrary::AboveRange");
//		clickButton("OK");
//
//		clickButton("OK");
//	}
//
//	/**
//	 * Helper function for tests that require adding an error type to a type set.
//	 * Assumes that a single error type has already been set using {@link #selectSingleErrorType()}
//	 */
//	private static void addTypeToSelectedPropagationTypeSet() {
//		// Check label to ensure that the types match the expected value
//		waitUntilBorderedCLabelWithIdTextMatches(ErrorPropagationPropertySection.WIDGET_ID_TYPE_TOKENS_LABEL,
//				"ErrorLibrary::AboveRange");
//
//		clickButtonWithId(ErrorPropagationPropertySection.WIDGET_ID_TYPE_TOKENS_CHOOSE_BUTTON);
//		waitForWindowWithTitle("Edit Type Set");
//
//		// Add types
//		clickButton("Add Error Type(s)");
//		waitForWindowWithTitle("Add Types");
//		selectListItems(0, "ErrorLibrary::BelowRange");
//		clickButton("OK");
//
//		clickButton("OK");
//
//		// Check the label to ensure it reflects the changes
//		waitUntilBorderedCLabelWithIdTextMatches(ErrorPropagationPropertySection.WIDGET_ID_TYPE_TOKENS_LABEL,
//				"ErrorLibrary::AboveRange, ErrorLibrary::BelowRange");
//	}
}

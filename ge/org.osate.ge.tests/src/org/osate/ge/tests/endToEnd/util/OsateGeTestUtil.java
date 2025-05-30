/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.tests.endToEnd.util;

import static org.osate.ge.aadl2.internal.AadlReferenceUtil.*;
import static org.osate.ge.tests.endToEnd.util.UiTestUtil.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.gef.ui.editor.AgeEditor;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.swt.BorderedCLabel;

/**
 * Additional assertions and commands for testing the OSATE Graphical Editor.
 * Used by OsateGeTestCommands to build define more complex commands.
 *
 * Intended to contain commands and assertions which can be written based on UiTestUtil but which are lower level than those contained in
 * OsateGeTestCommands.
 */
public class OsateGeTestUtil {
	private final static String AADL_NAVIGATOR = "AADL Navigator";

	// All methods are static
	private OsateGeTestUtil() {
	}

	public static void assertOsateWindowIsActive() {
		assertActiveWindowTitleContains("OSATE2");
	}

	/**
	 * Asserts that the OSATE window is active and the navigator is visible
	 */
	public static void assertAadlNavigatorIsVisible() {
		assertOsateWindowIsActive();
		assertViewIsVisible(AADL_NAVIGATOR);
	}

	public static void waitUntilProjectExistsInAadlNavigator(final String projectName) {
		waitUntil(() -> doesItemExistsInTreeView(AADL_NAVIGATOR, projectName),
				"Project '" + projectName + "' not found in AADL navigator");
	}

	public static void selectProjectInAadlNavigator(final String projectName) {
		selectItemInTreeView(AADL_NAVIGATOR, projectName);
	}

	public static void doubleClickInAadlNavigator(final String... itemTexts) {
		doubleClickItemInTreeView(AADL_NAVIGATOR, itemTexts);
	}

	public static void waitForDiagramActive(final DiagramReference diagram) {
		waitUntil(() -> isDiagramEditorActive(diagram),
				"Editor for diagram path segments '" + diagram + "' is not active.");
	}

	public static void setTextField(final int index, final String value, final String expectedOriginalValue) {
		assertTextFieldText("Original value is not the expected value", index, expectedOriginalValue);
		org.osate.ge.tests.endToEnd.util.UiTestUtil.setTextFieldText(index, value);
	}

	/**
	 * If an editor for the specified diagram is not active, it double clicks the diagram in the aadl navigator and waits for the
	 * the editor to become active.
	 */
	public static void openDiagramEditor(final DiagramReference diagram) {
		// Don't do anything if diagram is active
		if (!isDiagramEditorActive(diagram)) {
			doubleClickInAadlNavigator(diagram.pathSegments.toArray(new String[diagram.pathSegments.size()]));
			waitForDiagramActive(diagram);
		}
	}

	/**
	 * Returns whether the OSATE Diagram Editor is open with its input set to the path indicated by the path segments.
	 * The diagram file extension should not be included in the path segments.
	 */
	public static boolean isDiagramEditorOpen(final DiagramReference diagram) {
		return isEditorOpen(AgeEditor.class, diagram.getInputName());
	}

	/**
	 * Wait until the editor for the diagram to be closed
	 */
	public static void waitForDiagramClosed(final DiagramReference diagram) {
		waitUntil(() -> !isDiagramEditorOpen(diagram),
				"Editor for diagram path segments '" + diagram + "' is open.");
	}

	/**
	 * Checks all rows in the simple table which is the nth table in the active window.
	 * Assumes the table is a simple table with checkboxes. Such a table does not have any columns.
	 */
	public static void checkItemsInSimpleTable(final String... itemTexts) {
		Arrays.stream(itemTexts).forEach(itemText -> checkItemInSimpleTable(0, itemText));
	}

	public static void clickContextMenuOfDiagramElement(final DiagramReference diagram,
			final DiagramElementReference element,
			final String... texts) {
		openDiagramEditor(diagram);

		selectDiagramElements(diagram, element);

		clickContextMenuOfFocused(texts);
	}

	/**
	 * Create a shape element the on the specified diagram within the referenced element.
	 * @param diagram diagram the element will be created on
	 * @param parentElement the parent of the new element
	 * @param paletteItem the type of element to create
	 * @param referenceAfterCreate the default name of the created element
	 */
	public static void createShapeElement(final DiagramReference diagram, final DiagramElementReference parentElement,
			final String paletteItem, final RelativeBusinessObjectReference referenceAfterCreate) {
		createShapeElement(diagram, parentElement, paletteItem, referenceAfterCreate, () -> {
		});
	}

	/**
	 * Create a shape element the on the specified diagram within the referenced element.
	 * @param diagram diagram the element will be created on
	 * @param parentElement the parent of the new element
	 * @param paletteItem the type of element to create
	 * @param referenceAfterCreate the default name of the created element
	 * @param postExecPaletteItem runnable to call after the palette item is executed
	 */
	public static void createShapeElement(final DiagramReference diagram, final DiagramElementReference parentElement,
			final String paletteItem, final RelativeBusinessObjectReference referenceAfterCreate,
			final Runnable postExecPaletteItem) {
		openDiagramEditor(diagram);

		selectPaletteItem(diagram, paletteItem);
		clickDiagramElement(diagram, parentElement);
		postExecPaletteItem.run();
		activateSelectionTool(diagram);

		// Wait for element to be created
		waitForDiagramElementToExist(diagram, parentElement.join(referenceAfterCreate));
	}

	/**
	 * Creates an element represented a a flow indicator on the specified diagram.
	 * This function assumes that the element is created by targeting an element and that the resulting
	 * element is a child of the parent element.
	 * @param diagram the diagram the flow specification will be created on
	 * @param parentElement the parent element of the referenced feature
	 * @param paletteItem the type of the element to create
	 * @param endpointElement the element the flow specification will attached to
	 * @param referenceAfterCreate the reference of the created flow specification
	 */
	public static void createFlowIndicator(final DiagramReference diagram,
			final DiagramElementReference parentElement, final String paletteItem,
			final DiagramElementReference endpointElement,
			final RelativeBusinessObjectReference referenceAfterCreate) {
		openDiagramEditor(diagram);

		selectPaletteItem(diagram, paletteItem);
		clickDiagramElement(diagram, endpointElement);
		activateSelectionTool(diagram);

		// Wait for element to be created
		waitForDiagramElementToExist(diagram, parentElement.join(referenceAfterCreate));
	}

	/**
	 * Creates a connection element on the specified diagram with referenced
	 * source and destination.
	 * @param diagram the diagram the connection will be created on
	 * @param src the source of the connection
	 * @param dest the destination of the connection
	 * @param paletteItem the type of connection to be created
	 * @param referenceAfterCreate the reference of the created connection
	 */
	public static void createConnectionElement(final DiagramReference diagram, final DiagramElementReference src,
			final DiagramElementReference dest, final String paletteItem,
			final DiagramElementReference referenceAfterCreate) {
		createConnectionElement(diagram, src, dest, paletteItem, referenceAfterCreate, () -> {
		});
	}

	/**
	 * Creates a connection element on the specified diagram with referenced
	 * source and destination.
	 * @param diagram the diagram the connection will be created on
	 * @param src the source of the connection
	 * @param dest the destination of the connection
	 * @param paletteItem the type of connection to be created
	 * @param referenceAfterCreate the reference of the created connection
	 * @param postExecPaletteItem runnable to call after the palette item is executed
	 */
	public static void createConnectionElement(final DiagramReference diagram, final DiagramElementReference src,
			final DiagramElementReference dest, final String paletteItem,
			final DiagramElementReference referenceAfterCreate, final Runnable postExecPaletteItem) {
		openDiagramEditor(diagram);

		selectPaletteItem(diagram, paletteItem);
		clickDiagramElement(diagram, src);
		clickDiagramElement(diagram, dest);
		postExecPaletteItem.run();
		activateSelectionTool(diagram);

		// Wait for element to be created
		waitForDiagramElementToExist(diagram, referenceAfterCreate);
	}

	/**
	 * Returns whether the specified element exists
	 */
	public static boolean elementExists(final DiagramReference diagram, final DiagramElementReference element) {
		assertDiagramEditorActive(diagram);
		return getDiagramElement(diagram, element).isPresent();
	}

	/**
	 * Waits until the diagram element exists
	 */
	public static void waitForDiagramElementToExist(final DiagramReference diagram,
			final DiagramElementReference element) {
		waitUntil(() -> {
			assertDiagramEditorActive(diagram);
			return getDiagramElement(diagram, element).isPresent();
		}, "Expected element '" + element + "' doesn't exist.");
	}

	/**
	 * Waits until a condition is met for a diagram condition
	 */
	public static void waitForDiagramElementCondition(final DiagramReference diagram,
			final DiagramElementReference element, final String failureMessage, Predicate<DiagramElement> condition) {
		waitUntil(() -> {
			return getDiagramElement(diagram, element).filter(condition).isPresent();
		}, failureMessage);
	}

	/**
	 * Waits until the diagram element is removed
	 */
	public static void waitForDiagramElementRemoval(final DiagramReference diagram,
			final DiagramElementReference element) {
		waitUntil(() -> {
			assertDiagramEditorActive(diagram);
			return !getDiagramElement(diagram, element).isPresent();
		}, "Expected removed element '" + element + "' to not exist.");
	}

	/**
	 * Creates a diagram element reference from derived from relative references.
	 */
	public static DiagramElementReference element(final RelativeBusinessObjectReference... pathToElement) {
		return new DiagramElementReference(pathToElement);
	}

	/**
	 * Creates a diagram element reference for the package specified.
	 */
	public static DiagramElementReference packageElement(final String packageQualifiedName) {
		return new DiagramElementReference(getRelativeReferenceForPackage(packageQualifiedName));
	}

	/**
	 * Returns a reference to the diagram located in the diagrams folder for the specified project.
	 * @param projectName
	 * @param diagramName should not include file extension.
	 * @return the diagram reference
	 */
	public static DiagramReference defaultDiagram(final String projectName, final String diagramName) {
		return diagram(projectName, "diagrams", diagramName);
	}

	private static DiagramReference diagram(final String... diagramPathSegments) {
		final String[] segmentsWithExtension = diagramPathSegments.clone();
		segmentsWithExtension[segmentsWithExtension.length
				- 1] = segmentsWithExtension[segmentsWithExtension.length - 1] + ".aadl_diagram";
		return new DiagramReference(segmentsWithExtension);
	}

	/**
	 * Selects referenced element and clicks
	 * the radio button with text in the properties view specified tab.
	 */
	public static void clickRadioButtonInPropertiesView(final DiagramReference diagram, final String tabLabel,
			final String btnLabel,
			final DiagramElementReference... elements) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, elements);
		clickRadioButtonInPropertiesView(tabLabel, btnLabel);
	}

	/**
	 * Selects referenced element and clicks the nth
	 * check box with in the properties view specified tab.
	 */
	public static void clickCheckboxInPropertiesView(final DiagramReference diagram, final String tabLabel,
			final int index, final DiagramElementReference... elements) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, elements);
		clickCheckboxInPropertiesView(tabLabel, index);
	}

	/**
	 * Selects referenced element and clicks the check box
	 * with the specified id in the properties view specified tab.
	 */
	public static void clickCheckboxByIdInPropertiesView(final DiagramReference diagram, final String tabLabel,
			final String id, final boolean newCheckboxState, final DiagramElementReference... elements) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, elements);
		clickCheckboxByIdInPropertiesView(tabLabel, id);
		waitUntilCheckboxCheckedStateById(id, newCheckboxState);
	}

	private static void clickCheckboxInPropertiesView(final String tabLabel, final int index) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickPropertiesViewTab(tabLabel);
		clickCheckbox(index);
	}

	private static void clickCheckboxByIdInPropertiesView(final String tabLabel, final String id) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickPropertiesViewTab(tabLabel);
		clickCheckboxById(id);
	}

	private static void clickRadioButtonInPropertiesView(final String tabLabel, final String btnLabel) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickPropertiesViewTab(tabLabel);
		clickRadioButton(btnLabel);
	}

	/**
	 * Clicks the button with text in the properties view specified tab.
	 */
	public static void clickButtonInPropertiesView(final String tabLabel, final String btnLabel) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickPropertiesViewTab(tabLabel);
		clickButton(btnLabel);
	}

	/**
	 * Clicks the button with id in the properties view specified tab.
	 */
	public static void clickButtonByIdInPropertiesView(final String tabLabel, final String id) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickPropertiesViewTab(tabLabel);
		clickButtonWithId(id);
	}

	/**
	 * Waits until a list item exists
	 */
	public static void waitUntilListWithIdItemExists(final String id,
			final String text) {
		waitUntil(() -> doesItemExistsInListWithId(id, text), "Expected list item '" + text + "' does not exist.");
	}

	/**
	 * Waits until a list with items exist
	 */
	public static void waitUntilListWithIdItemsExists(final String id, final String... texts) {
		waitUntil(() -> itemsMatchInListWithId(id, texts),
				"List items do not match expected value: '" + Arrays.toString(texts) + "'.");
	}

	/**
	 * Waits until a list item does not exists
	 */
	public static void waitUntilListWithIdItemNotExists(final String id, final String text) {
		waitUntil(() -> !doesItemExistsInListWithId(id, text), "Expected list item '" + text + "' exists.");
	}

	/**
	 * Waits until a check box's check state matches the specified value
	 */
	public static void waitUntilCheckboxCheckedState(final String text, final boolean value) {
		waitUntil(() -> isCheckboxChecked(text) == value, "Check box '" + text + "' check state is not " + value + ".");
	}

	/**
	 * Waits until a check box's check state matches the specified value
	 */
	public static void waitUntilCheckboxCheckedStateById(final String id, final boolean value) {
		waitUntil(() -> Objects.equals(isCheckboxCheckedById(id), value),
				"Check box id '" + id + "' check state is not " + value + ".");
	}

	/**
	 * Waits until a radio buttons selected state matches the specified value
	 */
	public static void waitUntilRadioButtonSelectedState(final String text, final boolean value) {
		waitUntil(() -> isRadioButtonSelected(text) == value,
				"Radio button '" + text + "' selected state is not " + value + ".");
	}

	/**
	 * Waits until the text contained in a Label with the specified ID matches the specified value.
	 */
	public static void waitUntilLabelWithIdTextMatches(final String id, final String value) {
		waitUntil(() -> Objects.deepEquals(getTextForLabelWithId(id), value),
				"Label text of '" + id + "' is not '" + value + "'. Label Value '" + getTextForLabelWithId(id) + "'");
	}

	/**
	 * Waits until the text contained in a {@link BorderedCLabel} with the specified ID matches the specified value.
	 */
	public static void waitUntilBorderedCLabelWithIdTextMatches(final String id, final String value) {
		waitUntil(() -> Objects.deepEquals(getTextForBorderedClabelWithId(id), value),
				"Label text of '" + id + "' is not '" + value + "'. Label Value '" + getTextForBorderedClabelWithId(id) + "'");
	}

	/**
	 * Waits until the text contained in a text field with the specified index matches the specified value.
	 */
	public static void waitUntilTextFieldWithIdTextMatches(final String id, final String value) {
		waitUntil(() -> Objects.deepEquals(getTextForTextFieldWithId(id), value), "Text field text of text field'"
				+ id + "' is not '" + value + "'. Text Value '" + getTextForTextFieldWithId(id) + "'");
	}
}

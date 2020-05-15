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
package org.osate.ge.tests.endToEnd.util;

import static org.junit.Assert.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestCommands.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestUtil.*;
import static org.osate.ge.tests.endToEnd.util.UiTestUtil.*;
import static org.osate.ge.tests.endToEnd.util.UiTestUtil.setTextField;

import org.osate.ge.swt.prototypes.PrototypeEditor;
import org.osate.ge.swt.prototypes.PrototypesEditor;

/**
 * High level commands for testing the portions of the OSATE Graphical editor related to AADL prototypes.
 */
public class OsateGePrototypeTestCommands {
	// All methods are static
	private OsateGePrototypeTestCommands() {
	}

	/**
	 * Creates a new prototype using the Properties view.
	 * @param expectedPrototypeName the expected name for the new prototype
	 * @param elements the elements for which to create the prototype
	 */
	public static void createPrototype(final DiagramReference diagram,
			final String expectedPrototypeName, final DiagramElementReference... elements) {
		openAadlTabInPropertiesView(diagram, elements);

		// Ensure prototype does not exist in the list
		assertFalse("Prototype " + expectedPrototypeName + " already exists in list",
				doesItemExistsInListWithId(PrototypesEditor.WIDGET_ID_PROTOTYPE_LIST, expectedPrototypeName));

		clickButton("Add");

		// Wait for prototype to exist
		waitUntilListWithIdItemExists(PrototypesEditor.WIDGET_ID_PROTOTYPE_LIST, expectedPrototypeName);
	}

	/**
	 * Removes a new prototype using the Properties view.
	 * @param prototypeName is the name of the prototype to remove
	 * @param elements the elements for which to remove the prototype
	 */
	public static void removePrototype(final DiagramReference diagram, final String prototypeName,
			final DiagramElementReference... elements) {
		selectPrototypeForEditingInPropertiesView(diagram, prototypeName, elements);

		clickButton("Remove");

		// Wait for prototype to no longer exists
		waitUntilListWithIdItemNotExists(PrototypesEditor.WIDGET_ID_PROTOTYPE_LIST, prototypeName);
	}

	/**
	 * Renames a prototype using the properties view
	 * @param diagram
	 * @param currentName the current name for the prototype
	 * @param newName the new name for the prototype
	 * @param elements is the diagram elements to select
	 */
	public static void renamePrototype(final DiagramReference diagram, final String currentName,
			final String newName, final DiagramElementReference... elements) {
		selectPrototypeForEditingInPropertiesView(diagram, currentName, elements);

		// Rename
		clickButton("Rename");
		waitForWindowWithTitle("Rename");
		setTextField(0, newName);
		clickButton("OK");

		// Wait for prototype to no longer exists
		waitUntilListWithIdItemNotExists(PrototypesEditor.WIDGET_ID_PROTOTYPE_LIST, currentName);

		// Wait for prototype to exist
		waitUntilListWithIdItemExists(PrototypesEditor.WIDGET_ID_PROTOTYPE_LIST, newName);
	}

	/**
	 * Sets a prototype's type using the Properties view.
	 * @param diagram
	 * @param prototypeName the name of the prototype to modify
	 * @param prototypeType is the new type of the prototype
	 * @param elements is the diagram elements to select
	 */
	public static void setPrototypeType(final DiagramReference diagram, final String prototypeName,
			final String prototypeType, final DiagramElementReference... elements) {
		selectPrototypeForEditingInPropertiesView(diagram, prototypeName, elements);

		// Set type
		setComboBoxWithIdSelection(PrototypeEditor.WIDGET_ID_TYPE_COMBO, prototypeType);

		// Wait until the UI is updated with the type
		waitUntilComboBoxWithIdSelect(PrototypeEditor.WIDGET_ID_TYPE_COMBO, prototypeType);
	}

	/**
	 * Sets whether a prototype is an array using the Properties view.
	 * @param diagram
	 * @param prototypeName the name of the prototype to modify
	 * @param currentValue whether it is expected to currently be an array.
	 * @param newValue whether to set it as an array. Must be different from currentValue.
	 * @param elements is the diagram elements to select
	 */
	public static void setPrototypeArray(final DiagramReference diagram, final String prototypeName,
			final boolean currentValue, final boolean newValue, final DiagramElementReference... elements) {
		assertNotEquals("Old value must not match new value", newValue, currentValue);

		selectPrototypeForEditingInPropertiesView(diagram, prototypeName, elements);

		assertEquals("Array check box does not match expected value", currentValue, isCheckboxChecked("Array"));
		clickCheckbox("Array");
		waitUntilCheckboxCheckedState("Array", newValue);
	}

	/**
	 * Sets the prototype's direction  using the Properties view.
	 * @param diagram
	 * @param prototypeName the name of the prototype to modify
	 * @param newValue the label for the direction to select.
	 * @param elements is the diagram elements to select
	 */
	public static void setPrototypeDirection(final DiagramReference diagram,
			final String prototypeName, final String directionLabel, final DiagramElementReference... elements) {
		selectPrototypeForEditingInPropertiesView(diagram, prototypeName, elements);

		// Select the radio button for the direction and wait until the state is updated
		clickRadioButton(directionLabel);
		waitUntilRadioButtonSelectedState(directionLabel, true);
	}

	/**
	 * Sets the prototype's constraining classifier using the Properties view.
	 * @param diagram
	 * @param prototypeName the name of the prototype to modify
	 * @param constrainingClassifier the qualified name of the constraining classifier. Case-sensitive.
	 * @param elements is the diagram elements to select
	 */
	public static void setPrototypeConstrainingClassifier(final DiagramReference diagram,
			final String prototypeName, final String constrainingClassifier,
			final DiagramElementReference... elements) {
		selectPrototypeForEditingInPropertiesView(diagram, prototypeName, elements);

		// Click the choose button and select the classifier
		clickButtonWithId(PrototypeEditor.WIDGET_ID_CHOOSE_CLASSIFIER_BUTTON);
		waitForWindowWithTitle("Select");
		doubleClickListItem(0, constrainingClassifier);

		// Wait for the updated value
		waitUntilCLabelWithIdTextMatches(PrototypeEditor.WIDGET_ID_CLASSIFIER_LABEL, constrainingClassifier);
	}

	/**
	 * Sets whether the prototype is refined using the Properties view.
	 * @param diagram
	 * @param prototypeName the name of the prototype to modify
	 * @param generalClassifier the qualified name of the classifier containing the prototype being refined. Case-sensitive.
	 * @param currentValue whether it is expected to currently refined.
	 * @param newValue whether to set it as refined. Must be different from currentValue.
	 * @param elements is the diagram elements to select
	 */
	public static void setPrototypeRefined(final DiagramReference diagram, final String prototypeName,
			final String generalClassifier, final boolean currentValue, final boolean newValue,
			final DiagramElementReference... elements) {
		assertNotEquals("Old value must not match new value", newValue, currentValue);

		selectPrototypeForEditingInPropertiesView(diagram, prototypeName, elements);

		final String checkboxLabel = "Refine " + generalClassifier + "." + prototypeName;
		assertEquals(checkboxLabel + " checked status does not match expected value", currentValue,
				isCheckboxChecked(checkboxLabel));
		clickCheckbox(checkboxLabel);
		waitUntilCheckboxCheckedState(checkboxLabel, newValue);
	}

	/**
	 * Selects the specified elements, open the AADL tab of the properties view, and selects the specified prototype.
	 * @param diagram is the diagram for which to open the editor.
	 * @param prototypeName is the name of the prototype to select.
	 * @param elements is the diagram elements to select.
	 */
	private static void selectPrototypeForEditingInPropertiesView(final DiagramReference diagram,
			final String prototypeName, final DiagramElementReference... elements) {
		openAadlTabInPropertiesView(diagram, elements);

		// Ensure prototype exists in the list and select it
		assertTrue("Prototype " + prototypeName + " does not exist in list",
				doesItemExistsInListWithId(PrototypesEditor.WIDGET_ID_PROTOTYPE_LIST, prototypeName));
		selectListWithIdItem(PrototypesEditor.WIDGET_ID_PROTOTYPE_LIST, prototypeName);
	}
}

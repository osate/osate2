package org.osate.ge.tests.endToEnd.util;

import static org.junit.Assert.*;
import static org.osate.ge.tests.endToEnd.util.SwtBotFunctions.*;

public class MidLevelFunctions {
	private final static String AADL_NAVIGATOR = "AADL Navigator";

	// All methods are static
	private MidLevelFunctions() {
	}

	public static void assertOsateShellIsActive() {
		assertActiveShellTitleContains("OSATE2");
	}

	/**
	 * Asserts that the OSATE shell is active and the navigator is visible
	 */
	public static void assertAadlNavigatorIsVisible() {
		assertOsateShellIsActive();
		assertViewIsVisible(AADL_NAVIGATOR);
	}

	public static void waitUntilProjectExistsInAadlNavigator(final String projectName) {
		waitUntil(() -> doesItemExistsInTreeView(AADL_NAVIGATOR, projectName),
				"Project '" + projectName + "' not found in AADL navigator");
	}

	public static void assertProjectExistsInAadlNavigator(final String projectName) {
		assertAadlNavigatorIsVisible();
		assertItemExistsInTreeView(AADL_NAVIGATOR, projectName);
	}

	public static void selectProjectInAadlNavigator(final String projectName) {
		selectItemInTreeView(AADL_NAVIGATOR, projectName);
	}

	public static void waitForDiagramActive(final String diagramName) {
		// Wait until the project appears in the AADL navigator
		waitUntil(() -> isDiagramEditorActive(diagramName), "Editor for diagram '" + diagramName + "' is not active.");
	}

	public static void assertDiagramEditorActive(final String diagramName) {
		assertTrue(isDiagramEditorActive(diagramName));
	}

	public static void setTextField(final int index, final String value, final String expectedOriginalValue) {
		assertTextFieldText("Original value is not the expected value", index, expectedOriginalValue);
		org.osate.ge.tests.endToEnd.util.SwtBotFunctions.setTextField(index, value);
	}
}

package org.osate.ge.tests.endToEnd.util;

import static org.junit.Assert.*;
import static org.osate.ge.tests.endToEnd.util.UiTestUtil.*;

import java.util.Arrays;

import org.eclipse.emf.common.util.URI;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

/**
 * Assertions and commands for testing the OSATE Graphical Editor. Used by OsateGeTestCommands to build define more complex commands.
 *
 */
public class OsateGeTestUtil {
	private final static String AADL_NAVIGATOR = "AADL Navigator";

	// All methods are static
	private OsateGeTestUtil() {
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

	public static void waitForDiagramActive(final String... diagramPathSegments) {
		// Wait until the project appears in the AADL navigator
		waitUntil(() -> isDiagramEditorActive(diagramPathSegments),
				"Editor for diagram path segments '" + Arrays.toString(diagramPathSegments) + "' is not active.");
	}

	public static void assertDiagramEditorActive(final String... diagramPathSegments) {
		assertTrue(isDiagramEditorActive(diagramPathSegments));
	}

	public static void setTextField(final int index, final String value, final String expectedOriginalValue) {
		assertTextFieldText("Original value is not the expected value", index, expectedOriginalValue);
		org.osate.ge.tests.endToEnd.util.UiTestUtil.setTextField(index, value);
	}

	/**
	 * Returns whether the OSATE Diagram Editor is active with its input set to the path indicated by the path segments.
	 * The diagram file extension should not be included in the path segments.
	 */
	public static boolean isDiagramEditorActive(final String... diagramPathSegments) {
		final String uri = URI.createPlatformResourceURI(String.join("/", diagramPathSegments), false).toString()
				+ ".aadl_diagram#/0";
		return isEditorActive(AgeDiagramEditor.class, uri);
	}

	/**
	 * Checks all rows in the simple table which is the nth table in the active shell.
	 * Assumes the table is a simple table with checkboxes. Such a table does not have any columns.
	 */
	public static void checkItemsInSimpleTable(final int tableIndex, final String... itemTexts) {
		Arrays.stream(itemTexts).forEach(itemText -> checkItemInSimpleTable(0, itemText));
	}
}

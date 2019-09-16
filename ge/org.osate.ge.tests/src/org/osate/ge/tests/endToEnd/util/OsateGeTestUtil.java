package org.osate.ge.tests.endToEnd.util;

import static org.osate.ge.internal.services.impl.DeclarativeReferenceBuilder.*;
import static org.osate.ge.tests.endToEnd.util.UiTestUtil.*;

import java.util.Arrays;

import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

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

	public static void doubleClickInAadlNavigator(final String... itemTexts) {
		doubleClickItemInTreeView(AADL_NAVIGATOR, itemTexts);
	}

	public static void waitForDiagramActive(final DiagramReference diagram) {
		waitUntil(() -> isDiagramEditorActive(diagram),
				"Editor for diagram path segments '" + diagram + "' is not active.");
	}

	public static void setTextField(final int index, final String value, final String expectedOriginalValue) {
		assertTextFieldText("Original value is not the expected value", index, expectedOriginalValue);
		org.osate.ge.tests.endToEnd.util.UiTestUtil.setTextField(index, value);
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
		return isEditorOpen(AgeDiagramEditor.class, diagram.getUri());
	}

	/**
	 * Wait until the editor for the diagram to be closed
	 */
	public static void waitForDiagramClosed(final DiagramReference diagram) {
		waitUntil(() -> !isDiagramEditorOpen(diagram),
				"Editor for diagram path segments '" + diagram + "' is open.");
	}

	/**
	 * Checks all rows in the simple table which is the nth table in the active shell.
	 * Assumes the table is a simple table with checkboxes. Such a table does not have any columns.
	 */
	public static void checkItemsInSimpleTable(final int tableIndex, final String... itemTexts) {
		Arrays.stream(itemTexts).forEach(itemText -> checkItemInSimpleTable(0, itemText));
	}

	public static void clickContextMenuOfDiagramElement(final DiagramReference diagram,
			final DiagramElementReference element,
			final String... texts) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, element);

		// TODO: Assert selected element
		clickContextMenuOfFocused(texts);
	}

	/**
	 * Create a shape element the active diagram within the referenced element.
	 * @param paletteItem the text for the palette item to use
	 */
	public static void createShapeElement(final DiagramReference diagram, DiagramElementReference parentElement,
			final String paletteItem, final RelativeBusinessObjectReference referenceAfterCreate) {
		openDiagramEditor(diagram);

		activatePaletteItem(diagram, paletteItem);
		clickDiagramElement(diagram, parentElement);
		activateSelectionTool(diagram);

		// Wait for element to be created
		waitForDiagramElementToExist(diagram, parentElement.join(referenceAfterCreate));
	}

	/**
	 * Waits until the diagram element exists
	 */
	public static void waitForDiagramElementToExist(final DiagramReference diagram,
			final DiagramElementReference element) {
		waitUntil(() -> {
			// TODO:
			assertDiagramEditorActive(diagram);
			return getDiagramElement(diagram, element).isPresent();
		}, "Expected element '" + element + "' doesn't exist.");
	}

	public static DiagramElementReference element(final RelativeBusinessObjectReference... pathToElement) {
		return new DiagramElementReference(pathToElement);
	}

	public static DiagramElementReference packageElement(final String packageQualifiedName) {
		return new DiagramElementReference(getPackageRelativeReference(packageQualifiedName));
	}

	public static DiagramReference diagram(final String... diagramPathSegments) {
		final String[] segmentsWithExtension = diagramPathSegments.clone();
		segmentsWithExtension[segmentsWithExtension.length
				- 1] = segmentsWithExtension[segmentsWithExtension.length - 1] + ".aadl_diagram";
		return new DiagramReference(segmentsWithExtension);
	}

	/**
	 * Returns a reference to the diagram located in the diagrams folder for the specified project.
	 * @param projectName
	 * @param diagramName should not include file extension.
	 * @return
	 */
	public static DiagramReference defaultDiagram(final String projectName, final String diagramName) {
		return diagram(projectName, "diagrams", diagramName);
	}

	// TODO: Review. Argument ordering... Assumptions. Name
	public static void clickButtonInPropertiesView(final DiagramReference diagram, final String btnLabel,
			final DiagramElementReference... elements) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, elements);
		clickButtonInPropertiesView(btnLabel, "AADL");
	}

	// TODO: Review. Argument ordering... Assumptions. Name
	public static void clickRadioButtonInPropertiesView(final DiagramReference diagram, final String btnLabel,
			final String tabLabel,
			final DiagramElementReference... elements) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, elements);
		clickRadioButtonInPropertyView(btnLabel, tabLabel);
	}

	// Change to show TAB?
	private static void clickRadioButtonInPropertyView(final String btnLabel, final String tabLabel) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickViewTab(tabLabel);
		clickRadioButton(btnLabel);
	}

	// TODO keep public? can remove? rename? duplicate
	public static void clickButtonInPropertiesView(final String btnLabel, final String tabLabel) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickViewTab(tabLabel);
		clickButton(btnLabel);
	}
}

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
		openDiagramEditor(diagram);

		activatePaletteItem(diagram, paletteItem);
		clickDiagramElement(diagram, parentElement);
		activateSelectionTool(diagram);

		// Wait for element to be created
		waitForDiagramElementToExist(diagram, parentElement.join(referenceAfterCreate));
	}

	/**
	 * Creates a flow specification on the specified diagram on the referenced feature.
	 * @param diagram the diagram the flow specification will be created on
	 * @param parentElement the parent element of the referenced feature
	 * @param paletteItem the type of the element to create
	 * @param featureRef the feature the flow specification will attached to
	 * @param referenceAfterCreate the reference of the created flow specification
	 */
	public static void createFlowSpecificationElement(final DiagramReference diagram,
			final DiagramElementReference parentElement, final String paletteItem,
			final RelativeBusinessObjectReference featureRef,
			final RelativeBusinessObjectReference referenceAfterCreate) {
		openDiagramEditor(diagram);

		activatePaletteItem(diagram, paletteItem);
		clickDiagramElement(diagram, parentElement.join(featureRef));
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
		openDiagramEditor(diagram);

		activatePaletteItem(diagram, paletteItem);
		clickDiagramElement(diagram, src);
		clickDiagramElement(diagram, dest);
		activateSelectionTool(diagram);

		// Wait for element to be created
		waitForDiagramElementToExist(diagram, referenceAfterCreate);
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
	 * Creates a diagram element reference from derived from relative references.
	 */
	public static DiagramElementReference element(final RelativeBusinessObjectReference... pathToElement) {
		return new DiagramElementReference(pathToElement);
	}

	/**
	 * Creates a diagram element reference for the package specified.
	 */
	public static DiagramElementReference packageElement(final String packageQualifiedName) {
		return new DiagramElementReference(getPackageRelativeReference(packageQualifiedName));
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
	public static void clickCheckBoxInPropertiesView(final DiagramReference diagram, final String tabLabel,
			final int index, final DiagramElementReference... elements) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, elements);
		clickCheckBoxInPropertiesView(tabLabel, index);
	}

	private static void clickCheckBoxInPropertiesView(final String tabLabel, final int index) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickViewTab(tabLabel);
		clickCheckBox(index);
	}

	private static void clickRadioButtonInPropertiesView(final String tabLabel, final String btnLabel) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickViewTab(tabLabel);
		clickRadioButton(btnLabel);
	}

	/**
	 * Clicks the button with text in the properties view specified tab.
	 */
	public static void clickButtonInPropertiesView(final String tabLabel, final String btnLabel) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickViewTab(tabLabel);
		clickButton(btnLabel);
	}
}

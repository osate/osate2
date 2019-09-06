package org.osate.ge.tests.endToEnd.util;

import static org.junit.Assert.*;
import static org.osate.ge.tests.endToEnd.util.UiTestUtil.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.EditPart;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.ui.IEditorReference;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
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

	public static int getDiagramEditPartsSize(final String[] diagramPathSegments) {
		assertDiagramEditorActive(diagramPathSegments);
		return getEditPartsSize(getURI(diagramPathSegments));
	}

	private static String getURI(final String... diagramPathSegments) {
		return URI.createPlatformResourceURI(String.join("/", diagramPathSegments), false).toString()
				+ ".aadl_diagram#/0";
	}

	public static void activateTool(final String[] diagramPathSegments, final String toolType) {
		assertDiagramEditorActive(diagramPathSegments);
		activateToolType(getURI(diagramPathSegments), toolType);
	}

	public static void activateDefaultTool(final String[] diagramPathSegments) {
		assertDiagramEditorActive(diagramPathSegments);
		activateDefaultToolType(getURI(diagramPathSegments));
	}

	public static void waitForDiagramActive(final String... diagramPathSegments) {
		waitUntil(() -> isDiagramEditorActive(diagramPathSegments),
				"Editor for diagram path segments '" + Arrays.toString(diagramPathSegments) + "' is not active.");
	}

	public static void setActiveDiagramEditor(final String... diagramPathSegments) {
		final String uri = URI.createPlatformResourceURI(String.join("/", diagramPathSegments), false).toString()
				+ ".aadl_diagram#/0";
		showEditor(uri);
		assertTrue("Diagram '" + uri + "' is not active.", isEditorActive(AgeDiagramEditor.class, uri));
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
		return isEditorActive(AgeDiagramEditor.class, getDiagramUri(diagramPathSegments));
	}

	/**
	 * Saves and closes the specified editor
	 */
	public static void saveDiagramEditor(final String... diagramPathSegments) {
		saveEditor(AgeDiagramEditor.class, getDiagramUri(diagramPathSegments));
	}
	
	/**
	 * Saves and closes the specified diagram editor
	 */
	public static void saveAndCloseDiagramEditor(final String... diagramPathSegments) {
		saveAndCloseEditor(AgeDiagramEditor.class, getDiagramUri(diagramPathSegments));
	}

	/**
	 * Returns whether the OSATE Diagram Editor is open with its input set to the path indicated by the path segments.
	 * The diagram file extension should not be included in the path segments.
	 */
	public static boolean isDiagramEditorOpen(final String... diagramPathSegments) {
		return isEditorOpen(AgeDiagramEditor.class, getDiagramUri(diagramPathSegments));
	}

	private static String getDiagramUri(final String... diagramPathSegments) {
		return URI.createPlatformResourceURI(String.join("/", diagramPathSegments), false).toString()
				+ ".aadl_diagram#/0";
	}

	/**
	 * Wait until the editor for the diagram to be closed
	 */
	public static void waitForDiagramClosed(final String... diagramPathSegments) {
		waitUntil(() -> !isDiagramEditorOpen(diagramPathSegments),
				"Editor for diagram path segments '" + Arrays.toString(diagramPathSegments) + "' is open.");
	}

	// public static IEditorReference getEditorReference(final String... diagramPathSegments) {
	/// final String uri
	// }

	/**
	 * Checks all rows in the simple table which is the nth table in the active shell.
	 * Assumes the table is a simple table with checkboxes. Such a table does not have any columns.
	 */
	public static void checkItemsInSimpleTable(final int tableIndex, final String... itemTexts) {
		Arrays.stream(itemTexts).forEach(itemText -> checkItemInSimpleTable(0, itemText));
	}

	/**
	 * Select elements specified by relative references from diagram root element.
	 * @param editorRef the editor the element is located on
	 * @param refs the relative references to element from diagram root element
	 */
	public static void selectElements(final String[] diagramPathSegments,
			final RelativeBusinessObjectReference[]... refs) {
		assertDiagramEditorActive(diagramPathSegments);
		final IEditorReference editorRef = getDiagramEditor(getURI(diagramPathSegments));
		final AgeDiagramEditor editor = (AgeDiagramEditor) editorRef.getEditor(false);
		final List<EditPart> editPartsToSelect = new ArrayList<>();
		for (int i = 0; i < refs.length; i++) {
			final RelativeBusinessObjectReference[] ref = refs[i];
			final DiagramElement de = getElementByRelativeReferences(editor, ref)
				.orElseThrow(
							() -> new RuntimeException(
									"Cannot find relative reference for '" + relativeReferences(ref) + "'."));
			final PictogramElement pe = editor.getDiagramTypeProvider().getFeatureProvider()
				.getPictogramElementForBusinessObject(de.getBusinessObject());
			final EditPart editPart = editor.getDiagramBehavior().getEditPartForPictogramElement(pe);
			editPartsToSelect.add(editPart);
		}
		selectEditParts(editorRef, editPartsToSelect);
	}

	public static void clickRenameFromContextMenu(final String[] diagramPathSegments, final String newName) {
		assertDiagramEditorActive(diagramPathSegments);
		renameFromContextMenu(getURI(diagramPathSegments), newName);
	}

	public static void clickElement(final String[] diagramPathSegments,
			final RelativeBusinessObjectReference... refs) {
		assertDiagramEditorActive(diagramPathSegments);
		final IEditorReference editorRef = getDiagramEditor(getURI(diagramPathSegments));
		final AgeDiagramEditor editor = (AgeDiagramEditor) editorRef.getEditor(false);
		final DiagramElement de = getElementByRelativeReferences(editor, refs).orElseThrow(
				() -> new RuntimeException("Cannot find relative reference for '" + relativeReferences(refs) + "'."));
		final PictogramElement pe = editor.getDiagramTypeProvider().getFeatureProvider()
				.getPictogramElementForBusinessObject(de.getBusinessObject());
		final EditPart editPart = editor.getDiagramBehavior().getEditPartForPictogramElement(pe);

		clickEditPart(editorRef, editPart);
	}

	private static String relativeReferences(final RelativeBusinessObjectReference... refs) {
		final StringBuilder sb = new StringBuilder();
		for (final RelativeBusinessObjectReference ref : refs) {
			sb.append("[" + ref.toSegmentArray()[0] + "," + ref.toSegmentArray()[1] + "]");
		}

		return sb.toString();
	}

	private static Optional<DiagramElement> getElementByRelativeReferences(final AgeDiagramEditor editor,
			final RelativeBusinessObjectReference... refs) {
		final AgeDiagram ageDiagram = editor.getAgeDiagram();
		final List<RelativeBusinessObjectReference> refsAsList = Arrays.asList(refs);
		final Iterator<RelativeBusinessObjectReference> it = refsAsList.iterator();
		RelativeBusinessObjectReference rel = it.next();
		DiagramElement de = Objects.requireNonNull(ageDiagram.getByRelativeReference(rel),
				"Relative reference '" + relativeReferences(rel) + "'.");
		while (it.hasNext()) {
			rel = it.next();
			de = Objects.requireNonNull(de.getByRelativeReference(rel),
					"Relative reference '" + relativeReferences(rel) + "'.");
		}

		return Optional.ofNullable(de);
	}

	/**
	 * Create a shape element the active diagram within the referenced element.
	 * @param toolType the type of the new element
	 * @param refs the relative reference from the root diagram element to the parent of the new element
	 */
	public static void createShapeElement(final String[] diagramPathSegments, final String toolType,
			final RelativeBusinessObjectReference... refs) {
		assertDiagramEditorActive(diagramPathSegments);

		// Initial edit parts
		final int editPartsBefore = getDiagramEditPartsSize(diagramPathSegments);

		activateToolType(getURI(diagramPathSegments), toolType);
		clickElement(diagramPathSegments, refs);
		activateDefaultToolType(getURI(diagramPathSegments));

		// Wait for element to be created
		waitForElementToBeCreated(diagramPathSegments, editPartsBefore);
	}

	/**
	 * Waits for more edit parts to be created on the active editor than initial edit part size.
	 */
	public static void waitForElementToBeCreated(final String[] diagramPathSegments, final int initEditPartSize) {
		waitUntil(() -> getEditPartsSize(getURI(diagramPathSegments)) > initEditPartSize, "Element was not created.");
	}
}

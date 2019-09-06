package org.osate.ge.tests.endToEnd.util;

import static org.junit.Assert.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestUtil.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestUtil.setTextField;
import static org.osate.ge.tests.endToEnd.util.UiTestUtil.*;

import java.util.Arrays;
import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;

/**
 * High level commands for testing the OSATE Graphical editor.
 */
public class OsateGeTestCommands {
	// All methods are static
	private OsateGeTestCommands() {
	}

	static {
		// Exceptions in static blocks can sometimes not be reported. Because of this we catch it and print to standard error before rethrowing.
		try {
			assertEquals("Unsupported Eclipse product. Run test with the expected Eclipse product.",
					"org.osate.branding.osate2", Platform.getProduct().getId());
		} catch (final RuntimeException ex) {
			System.err.println(ex.toString());
			throw ex;
		}
	}

	/**
	 * Creates a new AADL Project
	 * Preconditions: OSATE Shell is active and AADL Navigator is visible.
	 * Postconditions: Project has been created and exists in the AADL Navigator
	 * @param name is the name of the AADL project to create.
	 */
	public static void createAadlProject(final String name) {
		assertOsateShellIsActive();
		assertAadlNavigatorIsVisible();
		clickMenu("File", "New", "AADL Project");

		// Configure new project
		waitForWindowWithTitle("New");
		setTextField(0, name, "");
		clickButton("Finish");

		// Verify results
		waitUntilProjectExistsInAadlNavigator(name);
	}

	/**
	 * Creates a new AADL Project with the specified referenced projects
	 * Preconditions: OSATE Shell is active and AADL Navigator is visible.
	 * Postconditions: Project has been created and exists in the AADL Navigator
	 * @param name is the name of the AADL project to create.
	 */
	public static void createAadlProjectWithReferencedProjects(final String name, final String... projectsToReference) {
		assertOsateShellIsActive();
		assertAadlNavigatorIsVisible();
		clickMenu("File", "New", "AADL Project");

		// Configure new project
		waitForWindowWithTitle("New");
		setTextField(0, name, "");
		clickButton("Next >");

		// Configure referenced projects
		waitForWindowWithTitle("New");
		checkItemsInSimpleTable(0, projectsToReference);
		clickButton("Finish");

		// Verify results
		waitUntilProjectExistsInAadlNavigator(name);
		assertReferencedProjects(name, projectsToReference);
	}

	private static void assertReferencedProjects(final String projectName, final String[] expectedReferencedProjects) {
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		assertNotNull(project);
		try {
			final IProject[] actualReferencedProjects = project.getReferencedProjects();
			assertEquals(expectedReferencedProjects.length, actualReferencedProjects.length);
			for (final String expectedProjectName : expectedReferencedProjects) {
				assertTrue("Project '" + expectedProjectName + "' not referenced",
						Arrays.stream(actualReferencedProjects)
								.anyMatch(p -> Objects.equals(expectedProjectName, p.getName())));
			}
		} catch (CoreException ex) {
			ex.printStackTrace();
			fail(ex.toString());
		}
	}

	/**
	 * Version of {@link #createNewPackageWithDiagram(String, String, String, String)} which uses the package as the diagram name and creates a package diagram.
	 */
	public static void createNewPackageWithPackageDiagram(final String projectName, final String packageName) {
		createNewPackageWithDiagram(projectName, packageName, packageName, "Package Diagram");
	}

	/**
	 * Version of {@link #createNewPackageWithDiagram(String, String, String, String)} which creates a package diagram.
	 */
	public static void createNewPackageWithPackageDiagram(final String projectName, final String packageName,
			final String diagramName) {
		createNewPackageWithDiagram(projectName, packageName, diagramName, "Package Diagram");
	}

	/**
	 * Version of {@link #createNewPackageWithDiagram(String, String, String, String)} which uses the package as the diagram name.
	 */
	public static void createNewPackageWithDiagram(final String projectName, final String packageName,
			final String diagramType) {
		createNewPackageWithDiagram(projectName, packageName, packageName, "Package Diagram");
	}

	/**
	 * Creates a new AADL package using the diagram wizard and opens it with the Diagram Editor.
	 * Preconditions: OSATE Shell is active and specified project is in the AADL Navigator
	 * Postconditions: diagram editor for the new diagram is active.
	 * @param projectName the name of the project to create
	 * @param packageName the name of the package to create
	 * @param diagramName the name of the diagram to create
	 * @param diagramType the type of diagram to create
	 */
	public static void createNewPackageWithDiagram(final String projectName, final String packageName,
			final String diagramName,
			final String diagramType) {
		// Open the new AADL Package wizard
		selectProjectInAadlNavigator(projectName);
		clickContextMenuOfFocused("New", "AADL Package");

		// Complete the wizard
		waitForWindowWithTitle("New AADL Package File");
		setTextField(0, packageName, "");
		clickRadioButton("Diagram Editor");
		clickButton("Finish");

		// Create the diagram
		waitForWindowWithTitle("Create Diagram");
		setTextField(0, diagramName, packageName.replaceAll("::", "_"));
		setComboBoxSelection(0, diagramType);
		clickButton("OK");

		// Wait for completion
		waitForDiagramActive(projectName, "diagrams", diagramName);
	}

	/**
	 * Sets the active editor.
	 * @param projectName the project name
	 * @param diagramName the diagram name
	 */
	public static void setActiveEditor(final String projectName, final String diagramName) {
		final String[] diagramPathSegments = { projectName, "diagrams", diagramName };
		setActiveDiagramEditor(diagramPathSegments);
		waitForDiagramActive(diagramPathSegments);
	}

	/**
	 * Creates an implementation and type.
	 * @param toolType the type to create
	 * @param implName the implementation name
	 * @param typeName the type name
	 * @param refs the relative reference from the root diagram element to the package of the new implementation
	 */
	public static void createImplementationWithNewType(final String projectName, final String diagramName,
			final String toolType, final String implName, final String typeName,
			final RelativeBusinessObjectReference... refs) {
		// final IEditorReference editorRef = getActiveEditor();
		final String[] diagramPathSegments = { projectName, "diagrams", diagramName };
		// Initial edit parts
		final int editPartsBefore = getDiagramEditPartsSize(diagramPathSegments);

		activateTool(diagramPathSegments, toolType);
		clickElement(diagramPathSegments, refs);

		waitForWindowWithTitle("Create Component Implementation");
		setTextField(0, implName, "");

		clickRadioButton("New Component Type");
		setTextField(1, typeName, "");

		clickButton("OK");
		activateDefaultTool(diagramPathSegments);

		waitForElementToBeCreated(diagramPathSegments, editPartsBefore);

		layoutElementFromContextMenu(diagramPathSegments, refs);
	}

	// TODO not implemented
	public static void createImplementationWithExistingType(final String toolType, final String implName,
			final String typeName, final RelativeBusinessObjectReference... refs) {
		// final IEditorReference editorRef = getActiveEditor();
		/*
		 * activateToolType(editorRef, toolType);
		 * clickElement(editorRef, refs);
		 * activateDefaultTool(editorRef);
		 *
		 * waitForWindowWithTitle("Create Component Implementation");
		 * setTextField(0, implName, "");
		 * clickRadioButton("Existing");
		 */
	}

	public static void setSubcomponentToNewTypeFromPropertiesView(final String projectName, final String diagramName,
			final RelativeBusinessObjectReference[] refs,
			final String packageName, final String newTypeName) {
		final String[] diagramPathSegments = { projectName, "diagrams", diagramName };

		selectElements(diagramPathSegments, refs);

		clickButtonInPropertiesView("Create...", "AADL");

		waitForWindowWithTitle("Create Component Classifier");

		clickRadioButton("New Component Type");

		clickButton("...");

		waitForWindowWithTitle("Select a Package");

		clickTableItem(0, packageName);

		clickButton("OK");

		waitForWindowWithTitle("Create Component Classifier");

		setTextField(0, newTypeName, "");

		clickButton("OK");
	}

	public static void createElementAndLayout(final String projectName, final String diagramName, final String toolType,
			final String name,
			final RelativeBusinessObjectReference[] pathToNewElement,
			final RelativeBusinessObjectReference layoutElement) {
		final String[] diagramPathSegments = { projectName, "diagrams", diagramName };
		createShapeElement(diagramPathSegments, toolType,
				Arrays.copyOfRange(pathToNewElement, 0, pathToNewElement.length - 1));
		renameElementFromContextMenu(diagramPathSegments, name, pathToNewElement);

		// Layout
		layoutElementFromContextMenu(diagramPathSegments, layoutElement);
	}



	// TODO
	public static void createConnectionElement(final String toolType, final RelativeBusinessObjectReference[] srcRef,
			final RelativeBusinessObjectReference[] destRef) {

	}

	// TODO: fix wording properties or property?
	private static void setClassifierFromPropertyView(final String classifier) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickViewTab("AADL");
		clickButton("Choose...");
		waitForWindowWithTitle("Select a Classifier");

		clickTableItem(0, classifier);
		clickButton("OK");
	}

	// Change to show TAB?
	// Click button after
	private static void clickRadioButtonInPropertyView(final String btnLabel, final String tabLabel) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickViewTab(tabLabel);
		clickRadioButton(btnLabel);
	}

	private static void clickButtonInPropertiesView(final String btnLabel, final String tabLabel) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickViewTab(tabLabel);
		clickButton(btnLabel);
	}

	public static void setClassifierFromPropertyView(final String projectName, final String diagramName,
			final String classifier, final RelativeBusinessObjectReference[]... refs) {
		final String[] diagramPathSegments = { projectName, "diagrams", diagramName };
		// assertDiagramEditorActive(diagramPathSegments);
		selectElements(diagramPathSegments, refs);
		setClassifierFromPropertyView(classifier);
	}

	public static void clickButtonInPropertiesView(final String projectName, final String diagramName,
			final String btnLabel,
			final RelativeBusinessObjectReference[]... refs) {
		final String[] diagramPathSegments = { projectName, "diagrams", diagramName };
		selectElements(diagramPathSegments, refs);
		clickButtonInPropertiesView(btnLabel, "AADL");
	}

	public static void clickRadioButtonInPropertyView(final String projectName, final String diagramName,
			final String btnLabel,
			final RelativeBusinessObjectReference[]... refs) {
		final String[] diagramPathSegments = { projectName, "diagrams", diagramName };

		selectElements(diagramPathSegments, refs);
		clickRadioButtonInPropertyView(btnLabel, "AADL");
	}

	private static void layoutElementFromContextMenu(final String[] diagramPathSegments,
			final RelativeBusinessObjectReference... ref) {
		clickElement(diagramPathSegments, ref);
		clickContextMenuOfFocused("Layout", "Layout Diagram");
	}

	/**
	 * Renames an element using the diagram context menu.
	 * @param newName the name of the new element
	 * @param refs the relative reference from the root diagram element to the element to rename
	 */
	private static void renameElementFromContextMenu(final String[] diagramPathSegments,
			final String newName,
			final RelativeBusinessObjectReference... refs) {
		// final IEditorReference editorRef = getActiveEditor();
		selectElements(diagramPathSegments, refs);
		clickRenameFromContextMenu(diagramPathSegments, newName);
		// TODO rework?
		final RelativeBusinessObjectReference[] newRefs = new RelativeBusinessObjectReference[refs.length];
		for (int i = 0; i < refs.length - 1; i++) {
			newRefs[i] = refs[i];
		}

		final RelativeBusinessObjectReference ref = refs[refs.length - 1];
		newRefs[refs.length - 1] = new RelativeBusinessObjectReference(ref.toSegmentArray()[0], newName);
		selectElements(diagramPathSegments, newRefs);
	}
}

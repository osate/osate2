package org.osate.ge.tests.endToEnd.util;

import static org.junit.Assert.*;
import static org.osate.ge.internal.services.impl.DeclarativeReferenceBuilder.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestUtil.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestUtil.setTextField;
import static org.osate.ge.tests.endToEnd.util.UiTestUtil.*;
import static org.osate.ge.tests.endToEnd.util.UiTestUtil.setTextField;

import java.util.Arrays;
import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;

import com.google.common.collect.ImmutableList;

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
		waitForDiagramActive(defaultDiagram(projectName, diagramName));
	}

	/**
	 * Creates an implementation and type.
	 * @param toolType the type to create
	 * @param implName the implementation name
	 * @param typeName the type name
	 */
	// TODO: Review
	public static void createImplementationWithNewType(final DiagramReference diagram,
			final DiagramElementReference pkg, final String toolType, final String implName, final String typeName) {
		openDiagramEditor(diagram);

		activatePaletteItem(diagram, toolType);
		clickDiagramElement(diagram, pkg);

		waitForWindowWithTitle("Create Component Implementation");
		setTextField(0, implName, "");

		clickRadioButton("New Component Type");
		setTextField(1, typeName, "");

		clickButton("OK");
		activateSelectionTool(diagram);

		waitForDiagramElementToExist(diagram, pkg.join(getClassifierRelativeReference(typeName + "." + implName)));

		layoutElementFromContextMenu(diagram, pkg);
	}

	public static void createImplementationWithExistingType(final DiagramReference diagram,
			final DiagramElementReference pkg, final String toolType, final String implName, final String classifierPkg, final String classifier) {
		openDiagramEditor(diagram);

		activatePaletteItem(diagram, toolType);
		clickDiagramElement(diagram, pkg);

		waitForWindowWithTitle("Create Component Implementation");
		setTextField(0, implName, "");

		clickRadioButton("Existing");
		clickButton("...");
		waitForWindowWithTitle("Select Base Classifier");

		clickTableItem(0, classifierPkg + "::" + classifier);
		clickButton("OK");

		waitForWindowWithTitle("Create Component Implementation");
		clickButton("OK");

		waitForDiagramElementToExist(diagram, pkg.join(getClassifierRelativeReference(classifier + "." + implName)));

		layoutElementFromContextMenu(diagram, pkg);
	}

	public static void setSubcomponentToNewTypeFromPropertiesView(final DiagramReference diagram,
			final DiagramElementReference element,
			final String packageName, final String newTypeName) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, element);

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

	/**
	 * Creates a diagram element using a palette tool which will be represented as a shape.
	 * Preconditions: OSATE shell is active. Specified parent element exists.
	 * Postconditions: new diagram element has been created, renamed to match the specified name, and the diagram layout has been updated.
	 * @param diagram is the diagram in which to create the diagram element
	 * @param parentElement reference to the element in which the new diagram element will be created
	 * @param toolType is the text of the palette item to use to create the element
	 * @param newReferenceAfterCreate is the relative reference of the diagram element which will be created by the tool
	 * @param finalName is the name to which the element should be renamed
	 */
	public static void createElementAndLayout(final DiagramReference diagram,
			final DiagramElementReference parentElement,
			final String toolType,
			final RelativeBusinessObjectReference newReferenceAfterCreate,
			final String finalName) {
		createShapeElement(diagram, parentElement, toolType, newReferenceAfterCreate);
		renameElementFromContextMenu(diagram, parentElement, newReferenceAfterCreate, finalName);
		layoutElementFromContextMenu(diagram, parentElement);
	}

	public static void createConnection(final DiagramReference diagram, final DiagramElementReference src,
			final DiagramElementReference dest, final String toolType,
			final DiagramElementReference parent, final RelativeBusinessObjectReference newReferenceAfterCreate,
			final String newName) {
		openDiagramEditor(diagram);
		createConnectionElement(diagram, src, dest, toolType, parent.join(newReferenceAfterCreate));
		renameElementFromOutlineView(diagram, parent, newReferenceAfterCreate, newName);
		layoutElementFromContextMenu(diagram, parent);
	}

	public static void showContentsAndLayout(final DiagramReference diagram, final DiagramElementReference element) {
		// Show contents
		clickContextMenuOfDiagramElement(diagram, element, "Show Contents", "All");

		layoutElementFromContextMenu(diagram, element);
	}

	public static void bindPropertyAssociations(final DiagramReference diagram, final DiagramElementReference[] toBind,
			final DiagramElementReference[] target, final String bindType) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, toBind);

		clickToolbarItem("Bind...");

		waitForWindowWithTitle("Bind");

		setComboBoxSelection(0, bindType);
		selectDiagramElements(diagram, target);

		clickButton("OK");
	}

	// TODO: Document
	public static void setClassifierFromPropertiesView(final DiagramReference diagram, final String classifier,
			final DiagramElementReference... elements) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, elements);
		setClassifierFromPropertiesView(classifier);
	}


	private static void setClassifierFromPropertiesView(final String classifier) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickViewTab("AADL");
		clickButton("Choose...");
		waitForWindowWithTitle("Select a Classifier");

		clickTableItem(0, classifier);
		clickButton("OK");
	}

	// TODO: Rename
	private static void layoutElementFromContextMenu(final DiagramReference diagram,
			final DiagramElementReference element) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, element);
		clickContextMenuOfFocused("Layout", "Layout Diagram");
	}

	/**
	 * Renames an element using the diagram context menu.
	 * @param newName the name of the new element
	 * @param element is the element to rename
	 */
	public static void renameElementFromContextMenu(final DiagramReference diagram,
			final DiagramElementReference parent, final RelativeBusinessObjectReference element,
			final String newName) {
		clickContextMenuOfDiagramElement(diagram, parent.join(element), "Rename...");
		waitForWindowWithTitle("Rename");
		setTextField(0, newName);
		clickButton("OK");

		// TODO: Rework. Assert that the element has been renamed
		waitForDiagramElementToExist(diagram,
				parent.join(new RelativeBusinessObjectReference(element.getSegments().get(0), newName)));
	}

	public static void renameElementFromDiagram(final DiagramReference diagram, final DiagramElementReference parent,
			final RelativeBusinessObjectReference afterCreate, final String newName) {
		renameElementDirectEdit(diagram, parent, afterCreate, newName);

		// Wait for element to be created
		waitForDiagramElementToExist(diagram,
				parent.join(new RelativeBusinessObjectReference(afterCreate.getSegments().get(0), newName)));
	}

	/**
	 * Renames an element using the diagram context menu.
	 * @param newName the name of the new element
	 * @param element is the element to rename
	 */
	public static void renameElementFromOutlineView(final DiagramReference diagram,
			final DiagramElementReference parent, final RelativeBusinessObjectReference afterCreate,
			final String newName) {
		final ImmutableList<RelativeBusinessObjectReference> pathToElement = parent.join(afterCreate).pathToElement;
		final String[] outlineTreeItems = new String[pathToElement.size()];
		for (int i = 0; i < pathToElement.size(); i++) {
			outlineTreeItems[i] = pathToElement.get(i).getSegments().get(1);
		}

		clickContextMenuOfOutlineViewItem("Rename...", outlineTreeItems);
		waitForWindowWithTitle("Rename");
		setTextField(0, newName);
		clickButton("OK");


		waitForDiagramElementToExist(diagram,
				parent.join(new RelativeBusinessObjectReference(afterCreate.getSegments().get(0), newName)));
	}
}

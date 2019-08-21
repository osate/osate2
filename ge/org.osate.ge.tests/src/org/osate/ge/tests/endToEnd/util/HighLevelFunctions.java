package org.osate.ge.tests.endToEnd.util;

import static org.junit.Assert.*;
import static org.osate.ge.tests.endToEnd.util.MidLevelFunctions.*;
import static org.osate.ge.tests.endToEnd.util.MidLevelFunctions.setTextField;
import static org.osate.ge.tests.endToEnd.util.SwtBotFunctions.*;

import org.eclipse.core.runtime.Platform;

public class HighLevelFunctions {
	// All methods are static
	private HighLevelFunctions() {
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
		waitForWindowWithTitle("New");
		setTextField(0, name, "");
		clickButton("Finish");
		waitUntilProjectExistsInAadlNavigator(name);
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
		waitForDiagramActive(diagramName);
	}
}

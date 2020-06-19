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
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.ui.editor.FlowContributionItem;
import org.osate.ge.internal.ui.properties.AbstractFeaturePrototypePropertySection;
import org.osate.ge.internal.ui.properties.SetSubcomponentClassifierPropertySection;
import org.osate.ge.swt.classifiers.PrototypeBindingsField;

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
		clickMenu(Menus.FILE_NEW_AADL_PROJECT);

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
		clickMenu(Menus.FILE_NEW_AADL_PROJECT);

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

	public static void saveAndClose(final DiagramReference diagram) {
		saveAndCloseDiagramEditor(diagram);
		waitForDiagramClosed(diagram);
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
			final String diagramName, final String diagramType) {
		// Open the new AADL Package wizard
		selectProjectInAadlNavigator(projectName);
		clickContextMenuOfFocused("New", "AADL Package");

		// Complete the wizard
		waitForWindowWithTitle("New AADL Package File");
		setTextField(0, packageName, "");
		clickRadioButton("Diagram Editor");
		// Display.getDefault().syncExec(() -> {
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

		layoutDiagram(diagram, pkg);
	}

	/**
	 * Creates an implementation using an existing type.
	 * @param toolType the type to create
	 * @param implName the implementation name
	 * @param classifierPkg the name of the classifiers package
	 * @param classifier the name of the existing classifier
	 */
	public static void createImplementationWithExistingType(final DiagramReference diagram,
			final DiagramElementReference pkg, final String toolType, final String implName, final String classifierPkg,
			final String classifier) {
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

		layoutDiagram(diagram, pkg);
	}

	/**
	 * Sets an elements classifier by creating a new type using the Properties view.
	 * @param element the element to set classifier
	 * @param packageName the package of new type
	 * @param newTypeName the new types name
	 */
	public static void setSubcomponentToNewTypeFromPropertiesView(final DiagramReference diagram,
			final DiagramElementReference element, final String packageName, final String newTypeName) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, element);

		clickButtonInPropertiesView("AADL", "Create...");

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
			final DiagramElementReference parentElement, final String toolType,
			final RelativeBusinessObjectReference newReferenceAfterCreate, final String finalName) {
		createShapeElement(diagram, parentElement, toolType, newReferenceAfterCreate);
		renameElementFromContextMenu(diagram, parentElement, newReferenceAfterCreate, finalName);
		layoutDiagram(diagram, parentElement);
	}

	/**
	 * Creates a flow specification using the palette tool.
	 * Preconditions: OSATE shell is active.  Specified parent element exists.
	 * Postconditions: New flow specification has been created, renamed to match the specified name
	 * @param diagram is the diagram in which to create the flow specification
	 * @param parentElement is the reference to the element in which the flow specification will be created
	 * @param toolType is the text of the palette item to use to create the flow specifcation
	 * @param featureRef is the relative reference of the feature that the flow specification will be attached to
	 * @param newReferenceAfterCreate is the relative reference of the diagram element which will be created by the tool.
	 * @param finalName is the name to which the element should be renamed
	 */
	public static void createFlowSpecification(final DiagramReference diagram,
			final DiagramElementReference parentElement, final String toolType,
			final RelativeBusinessObjectReference featureRef,
			final RelativeBusinessObjectReference newReferenceAfterCreate, final String finalName) {
		createFlowSpecificationElement(diagram, parentElement, toolType, featureRef, newReferenceAfterCreate);
		renameElementFromOutlineView(diagram, parentElement, newReferenceAfterCreate, finalName);
	}

	/**
	 * Creates an end to end flow using the segments specified.  The segments
	 * will be selected in the order received.
	 * Preconditions: OSATE shell is active.  Flow segments exist.
	 * Postconditions: New end to end flow specification has been created and highlighted
	 * @param classifier is the reference to the diagram element to select to enable tool item
	 * @param eteQualifiedName the qualified name of the end to end flow
	 * @param flowSegments is the reference to the segments that will make up the the end to end flow
	 */
	public static void createEndToEndFlowSpecification(final DiagramReference diagram,
			final DiagramElementReference classifier, final String eteQualifiedName,
			final DiagramElementReference... flowSegments) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, classifier);

		clickToolbarItem("Create End to End Flow Specification");

		waitForWindowWithTitle("End To End Flow Specification Tool");

		clickElements(flowSegments);

		final String eteName = eteQualifiedName.substring(eteQualifiedName.lastIndexOf(':') + 1);
		setTextForShell("End To End Flow Specification Tool", 0, eteName);
		sendTextKeyUpEvent("End To End Flow Specification Tool", 0, SWT.KeyUp, new Event());

		clickButtonForShell("End To End Flow Specification Tool", "OK");

		// Highlight flow to ensure it was created successfully
		setComboBoxWithIdSelection(FlowContributionItem.highlightFlow, eteQualifiedName);

		// Set selection to default
		setComboBoxWithIdSelection(FlowContributionItem.highlightFlow, "<Flows>");
	}

	private static void clickElements(final DiagramElementReference[] elements) {
		for (final DiagramElementReference flowSegment : elements) {
			final ImmutableList<RelativeBusinessObjectReference> pathToElement = flowSegment.pathToElement;
			final String[] outlineTreeItems = new String[pathToElement.size()];
			for (int i = 0; i < pathToElement.size(); i++) {
				outlineTreeItems[i] = pathToElement.get(i).getSegments().get(1);
			}

			clickElementInOutlineView(outlineTreeItems);
		}
	}

	/**
	 * Creates a flow implementation using the segments specified.  The segments
	 * will be selected in the order received.
	 * Preconditions: OSATE shell is active.  Flow segments exist.
	 * Postconditions: New flow implementation has been created and highlighted
	 * @param classifier is the reference to the diagram element to select to enable tool item
	 * @param flowImpQualifiedlName the qualified name of the flow implementation
	 * @param flowSegments is the reference to the segments that will make up the flow implementation
	 */
	public static void createFlowImplementation(final DiagramReference diagram,
			final DiagramElementReference classifier, final String flowImpQualifiedlName,
			final DiagramElementReference... flowSegments) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, classifier);

		clickToolbarItem("Create Flow Implementation");

		waitForWindowWithTitle("Flow Implementation Tool");

		clickElements(flowSegments);

		clickButtonForShell("Flow Implementation Tool", "OK");

		// Highlight flow to ensure it was created successfully
		setComboBoxWithIdSelection(FlowContributionItem.highlightFlow, flowImpQualifiedlName);

		// Set selection to default
		setComboBoxWithIdSelection(FlowContributionItem.highlightFlow, "<Flows>");
	}

	/**
	 * Creates a diagram element using a palette tool which will be represented as a connection.
	 * Preconditions: OSATE shell is active. Specified parent element exists.
	 * Postconditions: new diagram element has been created, renamed to match the specified name, and the diagram layout has been updated.
	 * @param diagram is the diagram in which to create the connection
	 * @param src the source of the connection
	 * @param dest the destination of the connection
	 * @param toolType the type of connection to create using the palette
	 * @param parentElement the parent of the new connection
	 * @param newReferenceAfterCreate the reference to the connection
	 * @param finalName the new name of the connection
	 */
	public static void createConnectionAndLayout(final DiagramReference diagram, final DiagramElementReference src,
			final DiagramElementReference dest, final String toolType, final DiagramElementReference parentElement,
			final RelativeBusinessObjectReference newReferenceAfterCreate, final String finalName) {
		openDiagramEditor(diagram);
		createConnectionElement(diagram, src, dest, toolType, parentElement.join(newReferenceAfterCreate));
		renameElementFromOutlineView(diagram, parentElement, newReferenceAfterCreate, finalName);
		layoutDiagram(diagram, parentElement);
	}

	/**
	 * Show contents of element using the context menu.
	 */
	public static void showContentsAndLayout(final DiagramReference diagram, final DiagramElementReference element) {
		// Show contents
		clickContextMenuOfDiagramElement(diagram, element, Menus.SHOW_CONTENTS_ALL);
		layoutDiagram(diagram, element);
	}

	/**
	 * Create binding property associations for elements using the bind tool.
	 * @param elementsToBind the elements to bind
	 * @param targetElements the elements being bound to
	 * @param bindType the type of binding
	 */
	public static void createBindPropertyAssociations(final DiagramReference diagram,
			final DiagramElementReference[] elementsToBind, final DiagramElementReference[] targetElements,
			final String bindType) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, elementsToBind);

		clickToolbarItem("Bind...");

		waitForWindowWithTitle("Bind");

		setComboBoxSelection(0, bindType);
		selectDiagramElements(diagram, targetElements);

		clickButton("OK");
	}

	/**
	 * Sets the extended classifier of feature classifier for elements using the Properties view.
	 * @param classifier the classifier qualified name
	 * @param elements the elements to set classifier
	 */
	public static void setExtendedOrFeatureClassifierFromPropertiesView(final DiagramReference diagram, final String classifier,
			final DiagramElementReference... elements) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, elements);

		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickPropertiesViewTab("AADL");
		clickButton("Choose...");
		waitForWindowWithTitle("Select a Classifier");

		clickTableItem(0, classifier);
		clickButton("OK");
	}

	/**
	 * Variant of {@link #setSubcomponentClassifierFromPropertiesView(DiagramReference, String, Runnable, String, DiagramElementReference...)
	 * Assumes the final label will match the specified classifier value.
	 */
	public static void setSubcomponentClassifierFromPropertiesView(final DiagramReference diagram,
			final String classifier, final DiagramElementReference... elements) {
		setSubcomponentClassifierFromPropertiesView(diagram, classifier, () -> {
		}, classifier, elements);
	}

	/**
	 * Sets the classifier for subcomponent elements using the Properties view.
	 * @param classifier the classifier qualified name
	 * @param extra is a runnable called before selecting OK to perform additional operations. For example: to configure bindings.
	 * @param expectedNewLabelText the text label that is expected after editing.
	 * @param elements the elements for which to set the classifier
	 */
	public static void setSubcomponentClassifierFromPropertiesView(final DiagramReference diagram,
			final String classifier, Runnable extra, final String expectedNewLabelText, final DiagramElementReference... elements) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, elements);

		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickPropertiesViewTab("AADL");
		clickButtonWithId(SetSubcomponentClassifierPropertySection.WIDGET_ID_CHOOSE_CLASSIFIER_BUTTON);
		waitForWindowWithTitle("Select Classifier and Prototype Bindings");

		selectListItem(0, classifier);

		extra.run();

		clickButton("OK");

		// Wait until the current classifier label has been updated
		waitUntilCLabelWithIdTextMatches(SetSubcomponentClassifierPropertySection.WIDGET_ID_CURRENT_CLASSIFIER_LABEL,
				expectedNewLabelText);
	}

	public static void checkSubcomponentClassifier(final DiagramReference diagram, final String labelText,
			final DiagramElementReference... elements) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, elements);

		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickPropertiesViewTab("AADL");

		// Wait until the current classifier label is the expected value
		waitUntilCLabelWithIdTextMatches(SetSubcomponentClassifierPropertySection.WIDGET_ID_CURRENT_CLASSIFIER_LABEL,
				labelText);
	}

	/**
	 * Edits a classifier's bindings using the Properties view.
	 * @param modifier is a runnable called to perform actual edits before selecting OK.
	 * @param expectedNewLabelText the text for the classifier's current prototype bindings label that is expected after editing.
	 * @param elements the elements for which to edit bindings.
	 */
	public static void setClassifierBindingsFromPropertiesView(final DiagramReference diagram, final Runnable modifier,
			final String expectedNewLabelText,
			final DiagramElementReference... elements) {
		setClassifierPrototypeBindingsFromPropertiesView(diagram, modifier, false, expectedNewLabelText, elements);
	}

	/**
	 * Edits a classifier's bindings using the Properties view.
	 * @param modifier is a runnable called to perform actual edits before selecting OK.
	 * @param expectedNewLabelText the text for the classifier's current prototype bindings label that is expected after editing.
	 * @param cancel whether to cancel the edit. If true then "Cancel" is selected rather than "OK".
	 * @param elements the elements for which to edit bindings.
	 */
	public static void setClassifierPrototypeBindingsFromPropertiesView(final DiagramReference diagram, final Runnable modifier,
			final boolean cancel,
			final String expectedNewLabelText,
			final DiagramElementReference... elements) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, elements);

		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickPropertiesViewTab("AADL");
		clickButtonWithId(PrototypeBindingsField.WIDGET_ID_EDIT_BUTTON);
		waitForWindowWithTitle("Edit Prototype Bindings");

		modifier.run();

		if (cancel) {
			clickButton("Cancel");
		} else {
			clickButton("OK");
		}

		// Wait until the classifier's prototype bindings label has been updated
		waitUntilCLabelWithIdTextMatches(PrototypeBindingsField.WIDGET_ID_SELECTED_LABEL, expectedNewLabelText);
	}

	/**
	 * Waits until the current prototype bindings label for the specified classifier matches the given label text
	 */
	public static void checkClassifierPrototypeBindings(final DiagramReference diagram, final String labelText,
			final DiagramElementReference... elements) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, elements);

		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickPropertiesViewTab("AADL");

		// Wait until the classifier's prototype bindings label is the expected value
		waitUntilCLabelWithIdTextMatches(PrototypeBindingsField.WIDGET_ID_SELECTED_LABEL, labelText);
	}

	/**
	 * Sets the feature prototype for elements using the Properties view.
	 * @param prototype the prototype qualified name
	 * @param elements the elements for which to set the prototype.
	 */
	public static void setFeaturePrototypeFromPropertiesView(final DiagramReference diagram, final String prototype,
			final DiagramElementReference... elements) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, elements);

		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickPropertiesViewTab("AADL");
		clickButtonWithId(AbstractFeaturePrototypePropertySection.WIDGET_ID_CHOOSE_BUTTON);
		waitForWindowWithTitle("Select Feature Prototype");

		selectListItem(0, prototype);
		clickButton("OK");
	}

	/**
	 * Sets the direction for directional features. Assumes that the only radio buttons with the specified label are the direction buttons.
	 * @param directionLabel is the label for the radio button for the direction.
	 * @param elements the element for which to set the direction.
	 */
	public static void setFeatureDirectionFromPropertiesView(final DiagramReference diagram,
			final String directionLabel,
			final DiagramElementReference... elements) {
		clickRadioButtonInPropertiesView(diagram, "AADL", directionLabel, elements);
	}

	private static void layoutDiagram(final DiagramReference diagram,
			final DiagramElementReference element) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, element);
		clickContextMenuOfFocused("Layout", "Layout Diagram");

		// Layout again because in some cases the ports may overlap. Laying out multiple times works around this issue.
		clickContextMenuOfFocused("Layout", "Layout Diagram");
	}

	/**
	 * Renames an element using the diagram context menu.
	 * @param parent the parent of the new element
	 * @param element is the element to rename
	 * @param newName the name of the new element
	 */
	public static void renameElementFromContextMenu(final DiagramReference diagram,
			final DiagramElementReference parent, final RelativeBusinessObjectReference element, final String newName) {
		clickContextMenuOfDiagramElement(diagram, parent.join(element), "Rename...");
		waitForWindowWithTitle("Rename");
		setTextField(0, newName);
		clickButton("OK");

		// Assert that the element has been renamed
		waitForDiagramElementToExist(diagram,
				parent.join(new RelativeBusinessObjectReference(element.getSegments().get(0), newName)));
	}

	/**
	 * Rename an element using direct edit feature.
	 * @param parent the parent of the new element
	 * @param element is the element to rename
	 * @param newName the name of the new element
	 */
	public static void renameElementFromDiagramEditor(final DiagramReference diagram, final DiagramElementReference parent,
			final RelativeBusinessObjectReference element, final String newName) {
		renameElementDirectEdit(diagram, parent, element, newName);

		// Wait for element to be created
		waitForDiagramElementToExist(diagram,
				parent.join(new RelativeBusinessObjectReference(element.getSegments().get(0), newName)));
	}

	/**
	 * Rename an element using the outline view.
	 * @param parent the parent of the new element
	 * @param element is the element to rename
	 * @param newName the name of the new element
	 */
	public static void renameElementFromOutlineView(final DiagramReference diagram,
			final DiagramElementReference parent, final RelativeBusinessObjectReference element,
			final String newName) {
		final ImmutableList<RelativeBusinessObjectReference> pathToElement = parent.join(element).pathToElement;
		final String[] outlineTreeItems = new String[pathToElement.size()];
		for (int i = 0; i < pathToElement.size(); i++) {
			outlineTreeItems[i] = pathToElement.get(i).getSegments().get(1);
		}

		clickContextMenuOfOutlineViewItem(outlineTreeItems, new String[] { "Rename..." });
		waitForWindowWithTitle("Rename");
		setTextField(0, newName);
		clickButton("OK");

		// Wait for element to be renamed
		waitForDiagramElementToExist(diagram,
				parent.join(new RelativeBusinessObjectReference(element.getSegments().get(0), newName)));
	}

	/**
	 * Adds a numeric array dimension to elements using the properties view
	 * @param size the size of the dimension
	 * @param element the element to which to add the dimension
	 */
	public static void addArrayDimension(final DiagramReference diagram, final int size,
			final DiagramElementReference element) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, element);
		addArrayDimension(size);
	}

	private static void addArrayDimension(final int size) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickPropertiesViewTab("AADL");
		final int dimensionCount = getNumberOfTableRows(0);
		clickButton("Add");
		waitForWindowWithTitle("Modify Dimension");

		setComboBoxSelection(0, "Number");
		setSpinnerValue(0, size);
		clickButton("OK");
		assertTableItemText(0, dimensionCount, "[" + size + "]");
	}

	/**
	 * Modifies an array dimension by turning it into a numeric array dimension with the specified size using the properties view
	 * @param dimensionIndex the index of the dimension to modify
	 * @param size the size of the dimension
	 * @param element the element for which to modify the dimension
	 * @param
	 */
	public static void modifyArrayDimension(final DiagramReference diagram, final int dimensionIndex, final int size,
			final DiagramElementReference element) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, element);
		modifyArrayDimension(dimensionIndex, size);
	}

	private static void modifyArrayDimension(final int dimensionIndex, final int size) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickPropertiesViewTab("AADL");
		clickTableItem(0, dimensionIndex);
		clickButton("Modify...");
		waitForWindowWithTitle("Modify Dimension");

		setComboBoxSelection(0, "Number");
		setSpinnerValue(0, size);
		clickButton("OK");

		assertTableItemText(0, dimensionIndex, "[" + size + "]");
	}

	/**
	 * Delete an array dimension using the properties view
	 * @param dimensionIndex the index of the dimension to delete
	 * @param element the element for which to modify the dimension
	 * @param
	 */
	public static void deleteArrayDimension(final DiagramReference diagram, final int dimensionIndex,
			final DiagramElementReference element) {
		openDiagramEditor(diagram);
		selectDiagramElements(diagram, element);
		deleteArrayDimension(dimensionIndex);
	}

	private static void deleteArrayDimension(final int dimensionIndex) {
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickPropertiesViewTab("AADL");
		final int dimensionCount = getNumberOfTableRows(0);
		clickTableItem(0, dimensionIndex);
		clickButton("Delete");
		waitForWindowWithTitle("Confirm");
		clickButton("Yes");
		assertNumberOfTableRows(0, dimensionCount - 1);
	}

	/**
	 * Opens a diagram editor, selects the specified diagram elements, and activates the AADL tab in
	 * the properties view.
	 * @param diagram the diagram for which to open the diagram editor
	 * @param elements is the elements which to select.
	 */
	public static void openAadlTabInPropertiesView(final DiagramReference diagram,
			final DiagramElementReference... elements) {
		openDiagramEditor(diagram);

		selectDiagramElements(diagram, elements);
		assertViewIsVisible("Properties");
		setViewFocus("Properties");

		clickPropertiesViewTab("AADL");
	}
}

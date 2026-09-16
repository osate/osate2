/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ui.tests.propertyview;

import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.assertNoErrorsInProject;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.closeAllEditors;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.closeEditorWithoutSaving;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.deleteProject;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.importModelProject;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.openEditor;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.prepareWorkbench;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.selectInEditor;

import org.eclipse.core.resources.IProject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.osate.ui.tests.propertyview.util.AadlPropertyViewBot;

/**
 * Setup shared by the tests of the AADL Property Values view.
 * <p>
 * Each test class imports the {@value #PROJECT} model project from this bundle's {@code models} directory, opens the
 * AADL Property Values view from scratch, and opens {@value #MODEL_FILE} in the AADL text editor. Every test then
 * selects an element by moving the caret in that editor, which is how a user makes the view show an element, and reads
 * the result out of the view's tree.
 * <p>
 * Before each test the editor is closed and reopened. The view modifies the editor's document rather than the file on
 * disk, so this is what discards the modifications a test made through the view, and it also guarantees that the tests
 * do not depend on each other's order.
 */
public abstract class AadlPropertyViewTestBase {
	/** The model project in this bundle's {@code models} directory that the tests import. */
	protected static final String PROJECT = "property_view_test";

	/** The AADL package that the tests select their elements in. */
	protected static final String MODEL_FILE = "Property_View_Model.aadl";

	/** The property set that declares one property per kind of property value. */
	protected static final String PROPERTY_SET = "Property_View_Properties";

	/** A second property set in the model project, whose name sorts before {@link #PROPERTY_SET}. */
	protected static final String EXTRA_PROPERTY_SET = "Extra_View_Properties";

	/**
	 * A predeclared property set with properties that apply to a component implementation and that have default values,
	 * so it appears in the view as soon as the default values are shown. Used where a test needs a property set that the
	 * model does not import.
	 */
	protected static final String NOT_IMPORTED_PROPERTY_SET = "Modeling_Properties";

	/*
	 * The snippets that the tests pass to selectInEditor to select an element of the model. Each one ends with the name
	 * of the element it selects, because that is where selectInEditor puts the caret. An implementation is named by the
	 * "implementation" keyword as well, so that the snippet cannot be confused with the reference to the same
	 * implementation in a subcomponent declaration or in an extends clause.
	 */

	/** The public section of the package, which cannot have properties. */
	protected static final String PACKAGE_SECTION = "public";

	/** An implementation without any property association of its own. */
	protected static final String PLAIN_IMPL = "implementation Plain.Impl";

	/** An implementation with one local property association per kind of property value. */
	protected static final String VALUED_IMPL = "implementation Valued.Impl";

	/** An implementation whose record value leaves one field of the record type unset. */
	protected static final String VALUED_PARTIAL = "implementation Valued.Partial";

	/** An implementation that inherits every property association of the one it extends. */
	protected static final String VALUED_DERIVED = "implementation Valued.Derived";

	/** An implementation with subcomponents and contained property associations. */
	protected static final String CONTAINER_IMPL = "implementation Container.Impl";

	/** An implementation with a modal property association. */
	protected static final String SWITCHED_IMPL = "implementation Switched.Impl";

	/** The subcomponent that a contained property association applies to on its own. */
	protected static final String ONLY_CHILD = "only_child";

	/** One of the two subcomponents that a single contained property association applies to. */
	protected static final String FIRST_CHILD = "first_child";

	private static IProject project;

	@BeforeClass
	public static void importModelAndOpenView() {
		prepareWorkbench();
		project = importModelProject(PROJECT);
		assertNoErrorsInProject(project);
		AadlPropertyViewBot.reopen();
	}

	/**
	 * Leaves the workbench as it was found: no model project, no editors, and no property view. The view is closed
	 * because SWTBot looks for a widget in every shell, so an open view with a visible filter box would be a candidate
	 * for a plain {@code bot.text()} in an unrelated test.
	 */
	@AfterClass
	public static void discardModel() {
		closeAllEditors();
		AadlPropertyViewBot.close();
		deleteProject(PROJECT);
	}

	/**
	 * Reopens the editor on a pristine document, returns the view's filters to their initial state, and leaves the view
	 * showing its "no properties to show" message, so that the first selection a test makes is always a change.
	 */
	@Before
	public void reopenEditorAndResetView() {
		closeEditorWithoutSaving(MODEL_FILE);
		openEditor(project, MODEL_FILE);
		/*
		 * The filter box is part of the tree, so it can only be cleared while the tree is shown. The plain
		 * implementation has no property association of its own, but selecting it still puts the view on its tree page.
		 */
		selectInEditor(MODEL_FILE, PLAIN_IMPL);
		AadlPropertyViewBot.tree();
		AadlPropertyViewBot.resetFilters();
		selectInEditor(MODEL_FILE, PACKAGE_SECTION);
		AadlPropertyViewBot.assertNoPropertiesShown();
	}
}

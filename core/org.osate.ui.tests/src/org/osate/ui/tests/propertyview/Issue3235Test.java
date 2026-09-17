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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.LOCAL;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.LOCAL_CONTAINED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.MAKE_LOCAL;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.MAKE_LOCAL_CONTAINED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.REMOVE;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.SHARED_LOCAL_CONTAINED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.UNDEFINED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.VALUE_COLUMN;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertStatus;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertValue;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.clickContextMenu;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.contextMenuEnablement;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.item;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.showUndefinedProperties;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.assertNoErrorsInProject;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.closeAllEditors;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.closeEditorWithoutSaving;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.deleteProject;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.editorText;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.importModelProject;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.openEditor;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.prepareWorkbench;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.selectInEditor;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.SWT;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.ui.tests.propertyview.util.AadlPropertyViewBot;

/**
 * A shared contained association must not be editable or removable from one of its targets.
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class Issue3235Test {
	private static final String PROJECT = "issue3235";
	private static final String MODEL_FILE = "Issue3235.aadl";
	private static final String PROPERTY_SET = "Issue3235_Properties";
	private static final String[] FLAG_PATH = { PROPERTY_SET, "Flag_Property" };
	private static IProject project;

	@BeforeClass
	public static void importModel() {
		prepareWorkbench();
		project = importModelProject(PROJECT);
		assertNoErrorsInProject(project);
		AadlPropertyViewBot.reopen();
	}

	@AfterClass
	public static void discardModel() {
		closeAllEditors();
		AadlPropertyViewBot.close();
		deleteProject(PROJECT);
	}

	@Before
	public void openPristineModel() {
		closeEditorWithoutSaving(MODEL_FILE);
		openEditor(project, MODEL_FILE);
		selectInEditor(MODEL_FILE, "implementation Plain.Impl");
		AadlPropertyViewBot.tree();
		AadlPropertyViewBot.resetFilters();
		selectChild("second_child");
		showUndefinedProperties(true);
	}

	@Test
	public void testRemoveDoesNotDeleteOtherChildValue() {
		assertValue("true", FLAG_PATH);
		var originalText = editorText(MODEL_FILE);
		selectChild("first_child");

		// Exercise the destructive action if the bug makes it available, then check the unselected child first.
		boolean removeEnabled = contextMenuEnablement(FLAG_PATH, List.of(REMOVE)).get(REMOVE);
		if (removeEnabled) {
			clickContextMenu(FLAG_PATH, REMOVE);
			assertStatus(UNDEFINED, FLAG_PATH);
		}
		selectChild("second_child");
		assertValue("true", FLAG_PATH);
		assertStatus(SHARED_LOCAL_CONTAINED, FLAG_PATH);
		assertEquals("The shared association must remain unchanged", originalText, editorText(MODEL_FILE));
		assertFalse("Remove must be disabled for a shared association", removeEnabled);
	}

	@Test
	public void testSharedScalarIsReadOnlyForBothChildren() {
		for (var child : List.of("first_child", "second_child")) {
			selectChild(child);
			assertValue("true", FLAG_PATH);
			assertStatus(SHARED_LOCAL_CONTAINED, FLAG_PATH);
			assertReadOnly(FLAG_PATH);
		}
	}

	@Test
	public void testSharedRecordFieldIsReadOnly() {
		selectChild("first_child");
		assertValue("1", PROPERTY_SET, "Record_Property", "First");
		assertStatus(SHARED_LOCAL_CONTAINED, PROPERTY_SET, "Record_Property", "First");
		assertReadOnly(PROPERTY_SET, "Record_Property", "First");
	}

	@Test
	public void testSharedListElementIsReadOnly() {
		selectChild("first_child");
		assertValue("1", PROPERTY_SET, "List_Property", "# 0");
		assertReadOnly(PROPERTY_SET, "List_Property", "# 0");
	}

	@Test
	public void testSharedRangeDeltaIsReadOnly() {
		selectChild("first_child");
		assertValue("2", PROPERTY_SET, "Range_Property", "delta");
		assertReadOnly(PROPERTY_SET, "Range_Property", "delta");
	}

	@Test
	public void testMakeLocalThenRemovePreservesOtherChild() {
		makeLocalThenRemove(MAKE_LOCAL, LOCAL);
	}

	@Test
	public void testMakeLocalContainedThenRemovePreservesOtherChild() {
		makeLocalThenRemove(MAKE_LOCAL_CONTAINED, LOCAL_CONTAINED);
	}

	private static void makeLocalThenRemove(String action, String expectedStatus) {
		selectChild("first_child");
		clickContextMenu(FLAG_PATH, action);
		assertStatus(expectedStatus, FLAG_PATH);
		assertValue("true", FLAG_PATH);
		clickContextMenu(FLAG_PATH, REMOVE);
		assertStatus(UNDEFINED, FLAG_PATH);
		assertValue("", FLAG_PATH);

		selectChild("second_child");
		assertStatus(LOCAL_CONTAINED, FLAG_PATH);
		assertValue("true", FLAG_PATH);
	}

	private static void selectChild(String child) {
		// Force a selection change even when the previous selection is the same child.
		selectInEditor(MODEL_FILE, "public");
		AadlPropertyViewBot.assertNoPropertiesShown();
		selectInEditor(MODEL_FILE, child);
		AadlPropertyViewBot.tree();
	}

	private static void assertReadOnly(String... path) {
		SWTBotTreeItem treeItem = item(path);
		boolean greyedOut = UIThreadRunnable.syncExec(() -> treeItem.widget.getDisplay()
				.getSystemColor(SWT.COLOR_DARK_GRAY)
				.equals(treeItem.widget.getForeground(VALUE_COLUMN)));
		assertTrue("A shared value must be greyed out", greyedOut);
		assertFalse("Remove must be disabled for a shared value",
				contextMenuEnablement(path, List.of(REMOVE)).get(REMOVE));
	}
}

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
import static org.junit.Assert.fail;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertPropertySets;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.assertNoErrorsInProject;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.closeAllEditors;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.deleteProject;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.importModelProject;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.openEditor;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.prepareWorkbench;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.selectInEditor;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.ui.tests.propertyview.util.AadlPropertyViewBot;

/**
 * Workspace property sets must be selectable in the property view's filter dialog, alongside contributed sets.
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class Issue3234Test {
	private static final String PROJECT = "issue3234";
	private static final String MODEL_FILE = "Issue3234.aadl";
	private static final String WORKSPACE_GROUP = "Workspace Property Sets";
	private static final List<String> ALL_SETS = List.of("First_Properties", "Second_Properties", "Timing_Properties");
	private static final SWTWorkbenchBot bot = new SWTWorkbenchBot();
	private static IProject project;
	private SWTBotShell dialog;

	@BeforeClass
	public static void importModel() {
		prepareWorkbench();
		project = importModelProject(PROJECT);
		assertNoErrorsInProject(project);
	}

	@Before
	public void openView() {
		AadlPropertyViewBot.reopen();
		openEditor(project, MODEL_FILE);
		selectInEditor(MODEL_FILE, "implementation T.impl");
		assertPropertySets(ALL_SETS);
	}

	@After
	public void closeDialogAndEditor() {
		if (dialog != null && dialog.isOpen()) {
			closeDialog("Cancel");
		}
		closeAllEditors();
		AadlPropertyViewBot.close();
	}

	@AfterClass
	public static void discardModel() {
		deleteProject(PROJECT);
	}

	@Test
	public void selectAllPreservesWorkspacePropertySets() {
		filterPropertySets(true);
		assertPropertySets(ALL_SETS);

		filterPropertySets(false);
		assertPropertySets(List.of());

		filterPropertySets(true);
		assertPropertySets(ALL_SETS);
	}

	@Test
	public void workspaceGroupOrderAndIndividualSelections() {
		openDialog();
		var groups = dialog.bot().tree().getAllItems();
		assertEquals("Predeclared Property Sets", groups[0].getText());
		assertTrue(groups[0].expand().getNodes().contains("Timing_Properties"));
		assertEquals(WORKSPACE_GROUP, groups[1].getText());
		var workspace = groups[1].expand();
		assertEquals(List.of("First_Properties", "Second_Properties", "Unused_Properties"),
				Arrays.stream(workspace.getItems()).map(SWTBotTreeItem::getText).toList());
		workspace.getNode("First_Properties").uncheck();
		assertTrue(workspace.isChecked());
		assertTrue(workspace.isGrayed());
		closeDialog("OK");
		assertPropertySets(List.of("Second_Properties", "Timing_Properties"));

		openDialog();
		workspace = dialog.bot().tree().getTreeItem(WORKSPACE_GROUP).expand();
		assertFalse(workspace.getNode("First_Properties").isChecked());
		assertTrue(workspace.getNode("Second_Properties").isChecked());
		assertTrue(workspace.isGrayed());
		dialog.bot().button("Select All").click();
		closeDialog("Cancel");
		assertPropertySets(List.of("Second_Properties", "Timing_Properties"));

		openDialog();
		workspace = dialog.bot().tree().getTreeItem(WORKSPACE_GROUP).expand();
		assertFalse(workspace.getNode("First_Properties").isChecked());
		workspace.uncheck();
		closeDialog("OK");
		assertPropertySets(List.of("Timing_Properties"));

		openDialog();
		workspace = dialog.bot().tree().getTreeItem(WORKSPACE_GROUP).expand();
		assertFalse(workspace.isChecked());
		assertFalse(workspace.isGrayed());
		workspace.check();
		closeDialog("OK");
		assertPropertySets(ALL_SETS);
	}

	private void openDialog() {
		var view = AadlPropertyViewBot.view();
		// Invoke the existing action without entering Cocoa's native popup-menu loop.
		UIThreadRunnable.asyncExec(() -> {
			var menu = view.getViewReference().getView(false).getViewSite().getActionBars().getMenuManager();
			for (var item : menu.getItems()) {
				if (item instanceof ActionContributionItem contribution
						&& contribution.getAction().getText().equals("Property Set Filters...")) {
					contribution.getAction().run();
					return;
				}
			}
			fail("Property Set Filters action is missing");
		});
		dialog = bot.shell("Property Set Filters");
		dialog.activate();
	}

	private void filterPropertySets(boolean selectAll) {
		openDialog();
		dialog.bot().button(selectAll ? "Select All" : "Deselect All").click();
		closeDialog("OK");
	}

	private void closeDialog(String button) {
		dialog.bot().button(button).click();
		bot.waitUntil(Conditions.shellCloses(dialog));
		dialog = null;
	}
}

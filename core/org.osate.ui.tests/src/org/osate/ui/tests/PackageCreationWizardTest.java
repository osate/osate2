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
package org.osate.ui.tests;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public class PackageCreationWizardTest {
	private final static SWTWorkbenchBot bot = new SWTWorkbenchBot();

	@BeforeClass
	public static void closeWelcome() {
		for (SWTBotView view : bot.views()) {
			if (view.getTitle().equals("Welcome")) {
				view.close();
			}
		}
	}

	@Test
	public void testNewTextPackage() {
		// Create project TestProject
		bot.menu("AADL Project").click();
		final SWTBotShell newProjectDialog = bot.shell("New");
		bot.text().setText("TestProject");
		bot.waitUntil(Conditions.widgetIsEnabled(bot.button("Finish")));
		bot.button("Finish").click();
		bot.waitUntil(Conditions.shellCloses(newProjectDialog));

		// Check that TestProject is in the navigator
		final SWTBotTree navigatorTree = bot.viewByTitle("AADL Navigator").bot().tree();
		final SWTBotTreeItem testProject = navigatorTree.getTreeItem("TestProject");

		// Create TestTextPackage and open with Text Editor
		testProject.contextMenu("AADL Package").click();
		final SWTBotShell newPackageDialog = bot.shell("New AADL Package File");
		bot.text().setText("TestTextPackage");
		bot.waitUntil(Conditions.widgetIsEnabled(bot.button("Finish")));
		bot.button("Finish").click();
		bot.waitUntil(Conditions.shellCloses(newPackageDialog), 10_000);

		// Check that TestTextPackage is in an open editor
		final String editorContents = bot.editorByTitle("TestTextPackage.aadl").toTextEditor().getText();
		final StringBuilder expected = new StringBuilder("package TestTextPackage");
		expected.append(System.lineSeparator());
		expected.append("public");
		expected.append(System.lineSeparator());
		expected.append('\t');
		expected.append(System.lineSeparator());
		expected.append("end TestTextPackage;");
		Assert.assertEquals(expected.toString(), editorContents);

		// Delete TestProject
		testProject.contextMenu("Delete").click();
		final SWTBotShell deleteDialog = bot.shell("Delete Resources");
		bot.checkBox("Delete project contents on disk (cannot be undone)").click();
		bot.button("OK").click();
		bot.waitUntil(Conditions.shellCloses(deleteDialog));

		// Check that the workspace is empty
		Assert.assertEquals(0, navigatorTree.getAllItems().length);
	}

	@Test
	public void testNewDiagramPackage() {
		// Create project TestProject
		bot.menu("File") //
				.menu("New")//
				.menu("AADL Project")//
				.click();
		final SWTBotShell newProjectDialog = bot.shell("New");
		bot.text().setText("TestProject");
		bot.waitUntil(Conditions.widgetIsEnabled(bot.button("Finish")));
		bot.button("Finish").click();
		bot.waitUntil(Conditions.shellCloses(newProjectDialog));

		// Check that TestProject is in the navigator
		final SWTBotTree navigatorTree = bot.viewByTitle("AADL Navigator").bot().tree();
		final SWTBotTreeItem testProject = navigatorTree.getTreeItem("TestProject");

		// Create TestDiagramPackage and open with the Diagram Editor
		testProject.contextMenu("AADL Package").click();
		final SWTBotShell newPackageDialog = bot.shell("New AADL Package File");
		bot.text().setText("TestDiagramPackage");
		bot.radio("Diagram Editor").click();
		bot.waitUntil(Conditions.widgetIsEnabled(bot.button("Finish")));
		bot.button("Finish").click();
		bot.waitUntil(Conditions.shellIsActive("Create Diagram"), 10_000);
		final SWTBotShell createDiagramDialog = bot.shell("Create Diagram");
		bot.button("OK").click();
		bot.waitUntil(Conditions.shellCloses(createDiagramDialog));
		bot.waitUntil(Conditions.shellCloses(newPackageDialog));

		// Check that TestDiagramPackage is in an open editor
		final SWTBotEditor graphicalEditor = bot.editorByTitle("TestDiagramPackage.aadl_diagram");
		Assert.assertEquals("org.osate.ge.editor.AgeDiagramEditor", graphicalEditor.getReference().getId());

		// Delete TestProject
		testProject.contextMenu("Delete").click();
		final SWTBotShell deleteDialog = bot.shell("Delete Resources");
		bot.checkBox("Delete project contents on disk (cannot be undone)").click();
		bot.button("OK").click();
		bot.waitUntil(Conditions.shellCloses(deleteDialog));

		// Check that the workspace is empty
		Assert.assertEquals(0, navigatorTree.getAllItems().length);
	}

	@Test
	public void testDuplicateNameError() {
		// Create project A
		bot.menu("AADL Project").click();
		final SWTBotShell newProjectADialog = bot.shell("New");
		bot.text().setText("A");
		bot.waitUntil(Conditions.widgetIsEnabled(bot.button("Finish")));
		bot.button("Finish").click();
		bot.waitUntil(Conditions.shellCloses(newProjectADialog));

		// Create project B
		bot.menu("AADL Project").click();
		final SWTBotShell newProjectBDialog = bot.shell("New");
		bot.text().setText("B");
		bot.waitUntil(Conditions.widgetIsEnabled(bot.button("Next >")));
		bot.button("Next >").click();
		bot.table().getTableItem("A").check();
		bot.button("Finish").click();
		bot.waitUntil(Conditions.shellCloses(newProjectBDialog), 50_000);

		// Check that A and B are in the navigator
		final SWTBotTree navigatorTree = bot.viewByTitle("AADL Navigator").bot().tree();
		final SWTBotTreeItem a = navigatorTree.getTreeItem("A");
		final SWTBotTreeItem b = navigatorTree.getTreeItem("B");

		// Create p1 and open with Text Editor
		a.contextMenu("AADL Package").click();
		final SWTBotShell newPackageP1 = bot.shell("New AADL Package File");
		bot.text().setText("p1");
		bot.waitUntil(Conditions.widgetIsEnabled(bot.button("Finish")));
		bot.button("Finish").click();
		bot.waitUntil(Conditions.shellCloses(newPackageP1), 10_000);

		// Create p2 and open with Text Editor
		b.contextMenu("AADL Package").click();
		final SWTBotShell newPackageP2 = bot.shell("New AADL Package File");
		bot.text().setText("p2");
		bot.waitUntil(Conditions.widgetIsEnabled(bot.button("Finish")));
		bot.button("Finish").click();
		bot.waitUntil(Conditions.shellCloses(newPackageP2), 10_000);

		// Check for error when trying to create p1 and p2 in A.
		a.contextMenu("AADL Package").click();
		final SWTBotShell newPackageInAError = bot.shell("New AADL Package File");
		bot.text().setText("p1");
		Assert.assertEquals(" Package 'p1' already exists in the selected project: 'p1.aadl'", bot.text(1).getText());
		bot.text().setText("p2");
		Assert.assertEquals(
				" Package 'p2' already exists in project 'B' that depends on the selected project: 'p2.aadl'",
				bot.text(1).getText());
		bot.button("Cancel").click();
		bot.waitUntil(Conditions.shellCloses(newPackageInAError));

		// Check for error when trying to create p1 and p2 in B.
		b.contextMenu("AADL Package").click();
		final SWTBotShell newPackageInBError = bot.shell("New AADL Package File");
		bot.text().setText("p1");
		Assert.assertEquals(
				" Package 'p1' already exists in project 'A' that the selected project depends on: 'p1.aadl'",
				bot.text(1).getText());
		bot.text().setText("p2");
		Assert.assertEquals(" Package 'p2' already exists in the selected project: 'p2.aadl'", bot.text(1).getText());
		bot.button("Cancel").click();
		bot.waitUntil(Conditions.shellCloses(newPackageInBError));

		// Delete A
		a.contextMenu("Delete").click();
		final SWTBotShell deleteADialog = bot.shell("Delete Resources");
		bot.checkBox("Delete project contents on disk (cannot be undone)").click();
		bot.button("OK").click();
		bot.waitUntil(Conditions.shellCloses(deleteADialog));

		// Delete B
		b.contextMenu("Delete").click();
		final SWTBotShell deleteBDialog = bot.shell("Delete Resources");
		bot.checkBox("Delete project contents on disk (cannot be undone)").click();
		bot.button("OK").click();
		bot.waitUntil(Conditions.shellCloses(deleteBDialog));

		// Check that the workspace is empty
		Assert.assertEquals(0, navigatorTree.getAllItems().length);
	}
}
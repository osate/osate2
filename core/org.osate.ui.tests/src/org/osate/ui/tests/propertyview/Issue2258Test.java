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
import static org.junit.Assert.assertTrue;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertPropertySets;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.collapseAll;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.item;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.setFilter;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.assertNoErrorsInProject;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.closeAllEditors;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.deleteProject;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.importModelProject;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.openEditor;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.prepareWorkbench;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.selectInEditor;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.ui.tests.propertyview.util.AadlPropertyViewBot;

/**
 * Switching model elements retains property-set expansion and the visible property, even when preceding rows change.
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class Issue2258Test {
	private static final String PROJECT = "issue2258";
	private static final String MODEL_FILE = "Issue2258.aadl";
	private static final String WATCH = "Watch_Properties";
	private static final String EARLIER = "Earlier_Properties";
	private static IProject project;

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
		select("First");
	}

	@After
	public void closeView() {
		closeAllEditors();
		AadlPropertyViewBot.close();
	}

	@AfterClass
	public static void discardModel() {
		deleteProject(PROJECT);
	}

	@Test
	public void remembersExpansionAndExplicitCollapseAcrossSelections() {
		assertExpanded(WATCH, false);
		item(WATCH).expand();
		select("Second");
		assertExpanded(WATCH, true);
		item(WATCH).collapse();
		select("First");
		assertExpanded(WATCH, false);
		assertExpanded(EARLIER, false);
	}

	@Test
	public void retainsExpansionWhileAPropertySetIsAbsent() {
		item(WATCH).expand();
		select("Empty");
		select("First");
		assertExpanded(WATCH, true);
	}

	@Test
	public void retainsViewportAcrossASelectionWithoutProperties() {
		item(WATCH).expand();
		scrollTo("P20");
		selectInEditor(MODEL_FILE, "public");
		AadlPropertyViewBot.assertNoPropertiesShown();
		select("Second");
		assertExpanded(WATCH, true);
		assertTop("P20");
	}

	@Test
	public void visibilityTogglesRetainExpansionAndScrollPosition() {
		item(WATCH).expand();
		scrollTo("P20");
		AadlPropertyViewBot.showUndefinedProperties(true);
		assertExpanded(WATCH, true);
		assertTop("P20");
		AadlPropertyViewBot.showUndefinedProperties(false);
		assertExpanded(WATCH, true);
		assertTop("P20");
	}

	@Test
	public void collapseAllAlsoForgetsTemporarilyAbsentSets() {
		item(EARLIER).expand();
		item(WATCH).expand();
		select("Second");
		collapseAll();
		select("First");
		assertExpanded(EARLIER, false);
		assertExpanded(WATCH, false);
	}

	@Test
	public void keepsTheTopPropertyWhenPrecedingRowsDisappear() {
		item(EARLIER).expand();
		item(WATCH).expand();
		scrollTo("P20");
		select("Second");
		assertTop("P20");
		select("First");
		assertTop("P20");
	}

	@Test
	public void fallsBackToThePropertySetWhenTheTopPropertyIsAbsent() {
		item(WATCH).expand();
		scrollTo("P20");
		select("Sparse");
		assertExpanded(WATCH, true);
		assertTop(WATCH);
	}

	@Test
	public void searchDoesNotReplaceBrowsingExpansionOrScrollPosition() {
		item(WATCH).expand();
		scrollTo("P20");
		setFilter("Padding");
		assertPropertySets(List.of(EARLIER));
		setFilter("");
		assertPropertySets(List.of(EARLIER, WATCH));
		assertExpanded(EARLIER, false);
		assertExpanded(WATCH, true);
		assertTop("P20");
		select("Second");
		assertTop("P20");
	}

	@Test
	public void modelRefreshRetainsExpansionAndScrollPosition() {
		item(WATCH).expand();
		scrollTo("P20");
		UIThreadRunnable.syncExec(() -> {
			var editor = (ITextEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();
			var document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
			try {
				// Remove the preceding set without moving the caret or interacting with the property tree.
				int offset = document.get().indexOf("        Earlier_Properties::Padding => 1;");
				document.replace(offset, "        Earlier_Properties::Padding => 1;".length(), "");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
		assertPropertySets(List.of(WATCH));
		assertExpanded(WATCH, true);
		assertTop("P20");
	}

	@Test
	public void explicitPropertySelectionTakesPrecedenceOverTheScrollAnchor() {
		item(WATCH).expand();
		scrollTo("P20");
		selectInEditor(MODEL_FILE, "Watch_Properties::P59 => 59");
		var property = item(WATCH, "P59");
		Tree tree = AadlPropertyViewBot.tree().widget;
		new SWTWorkbenchBot().waitUntil(new DefaultCondition() {
			@Override
			public boolean test() {
				return UIThreadRunnable.syncExec(
						() -> tree.getSelectionCount() == 1 && tree.getSelection()[0] == property.widget);
			}

			@Override
			public String getFailureMessage() {
				return "The property selected in the editor was not selected in the property view";
			}
		});
		assertTrue("The explicitly selected property must be visible", UIThreadRunnable.syncExec(() -> {
			var bounds = property.widget.getBounds();
			var client = tree.getClientArea();
			return bounds.y >= client.y && bounds.y + bounds.height <= client.y + client.height;
		}));
	}

	private static void select(String implementation) {
		selectInEditor(MODEL_FILE, "implementation S." + implementation);
		assertPropertySets(switch (implementation) {
		case "First" -> List.of(EARLIER, WATCH);
		case "Empty" -> List.of();
		default -> List.of(WATCH);
		});
	}

	private static void assertExpanded(String propertySet, boolean expanded) {
		// Only look up the root item. The shared helpers expand ancestors when looking up a property.
		assertEquals("Expansion of " + propertySet, expanded, item(propertySet).isExpanded());
	}

	private static void scrollTo(String property) {
		Tree tree = AadlPropertyViewBot.tree().widget;
		UIThreadRunnable.syncExec(() -> {
			var target = child(tree, property);
			tree.setTopItem(target);
			assertEquals("The fixture must have enough rows to scroll", property, tree.getTopItem().getText());
		});
	}

	private static TreeItem child(Tree tree, String property) {
		for (var set : tree.getItems()) {
			if (WATCH.equals(set.getText())) {
				for (var child : set.getItems()) {
					if (property.equals(child.getText())) {
						return child;
					}
				}
			}
		}
		throw new AssertionError("Property is not materialized: " + property);
	}

	private static void assertTop(String text) {
		Tree tree = AadlPropertyViewBot.tree().widget;
		assertEquals("Top visible row", text, UIThreadRunnable.syncExec(() -> tree.getTopItem().getText()));
	}
}

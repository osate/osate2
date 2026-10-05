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
package org.osate.ui.tests.preferences;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.assertNoErrorsInProject;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.deleteProject;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.importModelProject;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.prepareWorkbench;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.waitForBuild;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.SWT;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.pluginsupport.PluginSupportPlugin;
import org.osate.pluginsupport.PredeclaredProperties;
import org.osate.ui.navigator.AadlContributionLabelProvider;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

/** Tests the contributed-resource preferences through their public API and preference dialog. */
@RunWith(SWTBotJunit4ClassRunner.class)
public class Issue2861Test {
	private static final SWTWorkbenchBot bot = new SWTWorkbenchBot();
	private static final URI REPLACEMENT = URI.createPlatformResourceURI("/issue2861/SEI.aadl", true);
	private Map<URI, URI> savedOverrides;
	private List<URI> savedDisabled;
	private SWTBotShell dialog;

	@Before
	public void setUp() {
		prepareWorkbench();
		savedOverrides = PredeclaredProperties.getOverriddenResources();
		savedDisabled = PredeclaredProperties.getDisabledContributions();
		PredeclaredProperties.setOverriddenResources(Map.of());
		PredeclaredProperties.setDisabledContributions(List.of());
	}

	@After
	public void tearDown() {
		if (dialog != null && dialog.isOpen()) {
			closeDialog("Cancel");
		}
		PredeclaredProperties.setOverriddenResources(Map.of());
		PredeclaredProperties.setDisabledContributions(savedDisabled);
		PredeclaredProperties.setOverriddenResources(savedOverrides);
		deleteProject("issue2861");
	}

	@Test
	public void requiredContributionCannotBeDisabled() {
		var required = contribution("AADL_Project.aadl");
		PredeclaredProperties.setDisabledContributions(List.of(required));
		assertFalse(PredeclaredProperties.getDisabledContributions().contains(required));
		assertTrue(PredeclaredProperties.getEffectiveContributedResources().contains(required));
	}

	@Test
	public void disablingUpdatesEffectiveResourcesAndNavigatorDescription() {
		var uri = contribution("SEI.aadl");
		assertTrue(PredeclaredProperties.getEffectiveContributedResources().contains(uri));
		PredeclaredProperties.setDisabledContributions(List.of(uri));
		assertFalse(PredeclaredProperties.getEffectiveContributedResources().contains(uri));
		assertTrue(new AadlContributionLabelProvider()
				.getDescription(new ContributedAadlStorage(null, uri, true)).contains("Disabled"));
		PredeclaredProperties.setDisabledContributions(List.of());
		assertTrue(PredeclaredProperties.getEffectiveContributedResources().contains(uri));
	}

	@Test
	public void overrideAndDisableAreMutuallyExclusive() {
		var uri = contribution("SEI.aadl");
		PredeclaredProperties.setDisabledContributions(List.of(uri));
		PredeclaredProperties.setOverriddenResources(Map.of(uri, REPLACEMENT));
		assertTrue(PredeclaredProperties.getDisabledContributions().isEmpty());
		assertTrue(PredeclaredProperties.getEffectiveContributedResources().contains(REPLACEMENT));
		PredeclaredProperties.setDisabledContributions(List.of(REPLACEMENT));
		assertEquals(List.of(uri), PredeclaredProperties.getDisabledContributions());
		assertFalse(PredeclaredProperties.getOverriddenResources().containsKey(uri));
		assertFalse(PredeclaredProperties.getEffectiveContributedResources().contains(REPLACEMENT));
	}

	@Test
	public void legacyPreferencesPreserveDisableAndProtectRequiredContribution() {
		var uri = contribution("SEI.aadl");
		var required = contribution("AADL_Project.aadl");
		var store = PluginSupportPlugin.getDefault().getPreferenceStore();
		store.setValue("contributed.resource.override.key.0", uri.toString());
		store.setValue("contributed.resource.override.value.0", REPLACEMENT.toString());
		store.setValue("contributed.resource.numOverrides", 1);
		store.setValue("contributed.resource.disabled.0", REPLACEMENT.toString());
		store.setValue("contributed.resource.disabled.1", required.toString());
		store.setValue("contributed.resource.disabled.numOverrides", 2);
		assertEquals(List.of(uri), PredeclaredProperties.getDisabledContributions());
		assertFalse(PredeclaredProperties.getOverriddenResources().containsKey(uri));
		assertTrue(PredeclaredProperties.getEffectiveContributedResources().contains(required));
		assertFalse(PredeclaredProperties.getEffectiveContributedResources().contains(REPLACEMENT));
	}

	@Test
	public void dialogUsesActionsAndStatusAndCancelDiscardsChanges() {
		openDialog();
		var tree = dialog.bot().tree(1);
		assertEquals(List.of("Resource", "Status"), tree.columns());
		UIThreadRunnable.syncExec(() -> assertEquals(0, tree.widget.getStyle() & SWT.CHECK));
		var group = tree.getTreeItem("Plug-in Contributions");
		group.select();
		assertFalse(dialog.bot().button("Disable").isEnabled());
		assertFalse(dialog.bot().button("Override...").isEnabled());
		assertFalse(dialog.bot().button("Restore").isEnabled());
		find(group, "AADL_Project.aadl").select();
		assertFalse(dialog.bot().button("Disable").isEnabled());
		assertTrue(dialog.bot().button("Override...").isEnabled());
		var sei = find(group, "SEI.aadl");
		sei.select();
		assertTrue(sei.cell(1).startsWith("Contributed by "));
		dialog.bot().button("Disable").click();
		assertEquals("Disabled", sei.cell(1));
		assertTrue(dialog.bot().button("Restore").isEnabled());
		closeDialog("Cancel");
		assertTrue(PredeclaredProperties.getDisabledContributions().isEmpty());
	}

	@Test
	public void applyRestoreAndReopen() {
		openDialog();
		select("SEI.aadl");
		dialog.bot().button("Disable").click();
		dialog.bot().button("Apply").click();
		assertTrue(PredeclaredProperties.getDisabledContributions().contains(contribution("SEI.aadl")));
		closeDialog("Cancel");
		openDialog();
		assertEquals("Disabled", select("SEI.aadl").cell(1));
		dialog.bot().button("Restore").click();
		closeDialog("Apply and Close");
		assertTrue(PredeclaredProperties.getDisabledContributions().isEmpty());
	}

	@Test
	public void overrideDisabledResourceAndRestore() {
		var project = importModelProject("issue2861");
		assertNoErrorsInProject(project);
		PredeclaredProperties.setDisabledContributions(List.of(contribution("SEI.aadl")));
		openDialog();
		select("SEI.aadl");
		dialog.bot().button("Override...").click();
		var replacementDialog = bot.shell("Choose the Replacement Resource");
		replacementDialog.bot().tree().getTreeItem("issue2861").expand().getNode("SEI.aadl").select();
		replacementDialog.bot().button("OK").click();
		bot.waitUntil(Conditions.shellCloses(replacementDialog));
		assertEquals("Overridden by /issue2861/SEI.aadl", select("SEI.aadl").cell(1));
		assertFalse(dialog.bot().button("Disable").isEnabled());
		closeDialog("Apply and Close");
		assertTrue(PredeclaredProperties.getDisabledContributions().isEmpty());
		assertEquals(REPLACEMENT, PredeclaredProperties.getOverriddenResources().get(contribution("SEI.aadl")));
		openDialog();
		select("SEI.aadl");
		dialog.bot().button("Restore").click();
		closeDialog("Apply and Close");
		assertTrue(PredeclaredProperties.getOverriddenResources().isEmpty());
		assertTrue(PredeclaredProperties.getEffectiveContributedResources().contains(contribution("SEI.aadl")));
	}

	private static URI contribution(String filename) {
		return PredeclaredProperties.getContributedResources().stream()
				.filter(uri -> filename.equals(uri.lastSegment())).findFirst().orElseThrow();
	}

	private void openDialog() {
		UIThreadRunnable.asyncExec(() -> PreferencesUtil.createPreferenceDialogOn(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				"org.osate.ui.preferences.OsateContributedResourcesPage", null, null).open());
		dialog = bot.shell("Preferences");
		dialog.activate();
	}

	private void closeDialog(String button) {
		dialog.bot().button(button).click();
		bot.waitUntil(Conditions.shellCloses(dialog));
		dialog = null;
		waitForBuild();
	}

	private SWTBotTreeItem select(String filename) {
		var item = find(dialog.bot().tree(1).getTreeItem("Plug-in Contributions"), filename);
		item.select();
		return item;
	}

	private static SWTBotTreeItem find(SWTBotTreeItem parent, String filename) {
		parent.expand();
		for (var item : parent.getItems()) {
			if (item.getText().equals(filename)) {
				return item;
			}
			if (item.getText().equals("Predeclared_Property_Sets")) {
				var found = find(item, filename);
				if (found != null) {
					return found;
				}
			}
		}
		return null;
	}
}

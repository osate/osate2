/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ui.internal.properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jface.preference.IPreferenceNode;
import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osate.annexsupport.AnnexModel;
import org.osate.annexsupport.AnnexModel.UserSetting;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.pluginsupport.PredeclaredProperties;
import org.osate.ui.OsateUiPlugin;
import org.osate.ui.internal.preferences.AnnexPreferencePage;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/* NB: The parts of this that synchronized behavior between project properties
 * and workspace preferences are based on the web page
 * <http://www.eclipse.org/articles/Article-Mutatis-mutandis/overlay-pages.html>
 */
public class AnnexPropertyPage extends PropertyPage {
	private Composite composite;
	private Preferences preferences;
	private IProject project;
	private boolean isValid;

	Button useWorkspaceSettingsButton;
	Button useProjectSettingsButton;
	Button configureButton;

	@Override
	protected Control createContents(final Composite parent) {
		// Get the project
		project = Adapters.adapt(getElement(), IProject.class);
		if (project == null) {
			IResource resource = Adapters.adapt(getElement(), IResource.class);
			Assert.isNotNull(resource, "unable to adapt element to a project"); //$NON-NLS-1$
			project = resource.getProject();
		}

		// Get the project's preferences
		final IScopeContext context = new ProjectScope(project);
		preferences = context.getNode("org.osate.ui.internal.annex");
		isValid = true;

		// Create the overall composite to fill up
		// final Composite
		composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		// Create the buttons for choosing between workspace and project preferences
		final Composite selectionGroup = new Composite(composite, SWT.NONE);
		final GridLayout sgLayout = new GridLayout(2, false);
		sgLayout.marginHeight = 0;
		sgLayout.marginWidth = 0;
		selectionGroup.setLayout(sgLayout);
		selectionGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));

		final Composite radioGroup = new Composite(selectionGroup, SWT.NONE);
		radioGroup.setLayout(new GridLayout());
		radioGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		useWorkspaceSettingsButton = new Button(radioGroup, SWT.RADIO);
		useWorkspaceSettingsButton.setText("Use workspace settings");

		useProjectSettingsButton = new Button(radioGroup, SWT.RADIO);
		useProjectSettingsButton.setText("Use project settings");

		configureButton = new Button(selectionGroup, SWT.PUSH);
		configureButton.setText("Configure Workspace Settings ...");

		Label label = new Label(composite, SWT.NONE);
		label.setText("Selected annexes are enabled");

		UserSetting setting = AnnexModel.getUserPreference(project);
		// get all installed annexes/plugins
		for (String annex : AnnexRegistry.getAllAnnexNames()) {
			// create a preference checkbox for each installed annex/plugin
			Button checkBox = new Button(composite, SWT.CHECK);
			checkBox.setText(annex);
			checkBox.setEnabled(setting.equals(UserSetting.USE_PROJECT_PREFERENCE));
			checkBox.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));

			if (setting.equals(UserSetting.USE_WORKSPACE_PREFERENCE)) {
				checkBox.setSelection(AnnexModel.getAnnexEnabled(annex));
			} else {
				checkBox.setSelection(AnnexModel.getAnnexEnabled(project, annex));
			}
		}

		// Configure button status
		if (setting.equals(UserSetting.USE_WORKSPACE_PREFERENCE)) {
			useWorkspaceSettingsButton.setSelection(true);
			useProjectSettingsButton.setSelection(false);
			configureButton.setEnabled(true);
		} else {
			useWorkspaceSettingsButton.setSelection(false);
			useProjectSettingsButton.setSelection(true);
			configureButton.setEnabled(false);
		}

		// Add listeners
		useWorkspaceSettingsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				configureButton.setEnabled(true);
				for (Control control : composite.getChildren()) {
					if (control instanceof Button) {
						control.setEnabled(false);
					}
				}
			}
		});
		useProjectSettingsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				configureButton.setEnabled(false);
				for (Control control : composite.getChildren()) {
					if (control instanceof Button) {
						control.setEnabled(true);
					}
				}
			}
		});
		configureButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				configureWorkspaceSettings();
			}
		});

		// return the whole thing
		return composite;
	}

	@Override
	public boolean performOk() {
		if (isValid) {
			boolean useWorkspace = useWorkspaceSettingsButton.getSelection();
			AnnexModel.setWorkspacePref(useWorkspace, project);

			if (!useWorkspace) {
				for (Control control : composite.getChildren()) {
					if (control instanceof Button) {
						control.setEnabled(true);
						AnnexModel.setAnnexEnabled(((Button) control).getSelection(), project,
								((Button) control).getText());
					}
				}

				PredeclaredProperties.closeAndReopenProjects();
			}
			try {
				preferences.flush();
			} catch (final BackingStoreException e) {
				OsateUiPlugin.log(e);
			}
		}

		return isValid;
	}

	@Override
	protected void performDefaults() {
		useWorkspaceSettingsButton.setSelection(true);
		useProjectSettingsButton.setSelection(false);
		configureButton.setEnabled(true);

		// default to using workspace preferences. it does not matter what project preferences are set to
		for (Control control : composite.getChildren()) {
			if (control instanceof Button) {
				control.setEnabled(false);
			}
		}

		// Why? Because the default implementation does this
		updateApplyButton();

		PredeclaredProperties.closeAndReopenProjects();
	}

	private void configureWorkspaceSettings() {
		final IPreferencePage page = new AnnexPreferencePage();
		page.setTitle(getTitle());
		final IPreferenceNode targetNode = new PreferenceNode("org.osate.ui.preferences.OsateAnnexPage", page);
		final PreferenceManager manager = new PreferenceManager();
		manager.addToRoot(targetNode);

		final PreferenceDialog dialog = new PreferenceDialog(getControl().getShell(), manager);
		BusyIndicator.showWhile(getControl().getDisplay(), () -> {
			dialog.create();
			dialog.setMessage(targetNode.getLabelText());
			dialog.open();
		});
	}
}
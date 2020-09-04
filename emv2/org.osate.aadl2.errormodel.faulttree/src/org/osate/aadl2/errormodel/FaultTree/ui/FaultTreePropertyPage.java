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

package org.osate.aadl2.errormodel.FaultTree.ui;

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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osate.aadl2.errormodel.FaultTree.util.FaultTreeModel;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/* NB: The parts of this that synchronized behavior between project properties
 * and workspace preferences are based on the web page
 * <http://www.eclipse.org/articles/Article-Mutatis-mutandis/overlay-pages.html>
 */
/**
 * @since 5.0
 */
public class FaultTreePropertyPage extends PropertyPage {
	private static String BAD_VALUE = "Must be an integer >= 1";

	private Text maxPrecisionText;
	private Preferences preferences;
	private boolean isValid;

	@Override
	protected Control createContents(final Composite parent) {
		// Get the project
		IProject project = Adapters.adapt(getElement(), IProject.class);
		if (project == null) {
			IResource resource = Adapters.adapt(getElement(), IResource.class);
			Assert.isNotNull(resource, "unable to adapt element to a project"); //$NON-NLS-1$
			project = resource.getProject();
		}

		// Get the project's preferences
		final IScopeContext context = new ProjectScope(project);
		preferences = context.getNode(FaultTreeModel.PREFS_QUALIFIER);
		isValid = true;

		// Create the overall composite to fill up
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		// Create the buttons for choosing between workspace and project preferences
		final Composite selectionGroup = new Composite(composite, SWT.NONE);
		final GridLayout sgLayout = new GridLayout(2, false);
		sgLayout.marginHeight = 0;
		sgLayout.marginWidth = 0;
		selectionGroup.setLayout(sgLayout);
		selectionGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));

		// Create the actual property field that we want to edit
		final Label label = new Label(composite, SWT.NONE);
		label.setText("Probability precision preferences for fault tree analysis:");
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 1, 1));

		maxPrecisionText = new Text(composite, SWT.BORDER);
		maxPrecisionText.setText(Integer.toString(FaultTreeModel.getPrecision()));
		maxPrecisionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		maxPrecisionText.setEnabled(false);

		configureWorkspaceSettings();

		final Text localText = maxPrecisionText;
		maxPrecisionText.addModifyListener(event -> {
			final String s = localText.getText();
			try {
				final int v = Integer.parseInt(s);
				if (v < 1) {
					enterErrorState();
				} else {
					clearErrorState();
				}
			} catch (final NumberFormatException e) {
				enterErrorState();
			}
		});

		// return the whole thing
		return composite;
	}

	/*
	 * private int getPrecision() {
	 * return preferences.getInt(FaultTreeModel.PREF_PRECISION, getPrecision());
	 * }
	 */
	private void enterErrorState() {
		isValid = false;
		setErrorMessage(BAD_VALUE);
	}

	private void clearErrorState() {
		isValid = true;
		setErrorMessage(null);
	}

	@Override
	public boolean performOk() {
		if (isValid) {
			preferences.putInt(FaultTreeModel.PREF_PRECISION, Integer.parseInt(maxPrecisionText.getText()));
			// preferences.putBoolean(InstantiateModel.PREF_SOM_USE_WORKSPACE, useWorkspaceSettingsButton.getSelection());
			try {
				preferences.flush();
			} catch (final BackingStoreException e) {
				// TODO replace log OsateUiPlugin.log(e);
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void performDefaults() {
		maxPrecisionText.setText(Integer.toString(FaultTreeModel.getPrecision()));
		maxPrecisionText.setEnabled(false);

		// Why? Because the default implementation does this
		updateApplyButton();
	}

	private void configureWorkspaceSettings() {
		final IPreferencePage page = new FaultTreePreferencePage();
		page.setTitle(getTitle());
		final IPreferenceNode targetNode = new PreferenceNode("org.osate.ui.preferences.OsateFaultTreePage", page);
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
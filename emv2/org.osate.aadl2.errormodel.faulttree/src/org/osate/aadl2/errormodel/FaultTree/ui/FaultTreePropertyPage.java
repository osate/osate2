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
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.Assert;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osate.aadl2.errormodel.FaultTree.util.FaultTreeModel;

/* NB: The parts of this that synchronized behavior between project properties
 * and workspace preferences are based on the web page
 * <http://www.eclipse.org/articles/Article-Mutatis-mutandis/overlay-pages.html>
 */
/**
 * @since 5.0
 */
public class FaultTreePropertyPage extends PropertyPage {
	private static String BAD_VALUE = "Number of decimal digits must be between 1 and 16";

	private Text PrecisionText;
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

		final Composite radioGroup = new Composite(selectionGroup, SWT.NONE);
		radioGroup.setLayout(new GridLayout());
		radioGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		useWorkspaceSettingsButton = new Button(radioGroup, SWT.RADIO);
		useWorkspaceSettingsButton.setText("Use workspace settings");

		useProjectSettingsButton = new Button(radioGroup, SWT.RADIO);
		useProjectSettingsButton.setText("Use project settings");

		configureButton = new Button(selectionGroup, SWT.PUSH);
		configureButton.setText("Configure Workspace Settings ...");

		// Create the actual property field that we want to edit
		final Label label = new Label(composite, SWT.NONE);
		label.setText("Probability precision (number of decimal digits):");
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 1, 1));

		PrecisionText = new Text(composite, SWT.BORDER);
		PrecisionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		// Configure button status
		if (useWorkspacePreferences()) {
			useWorkspaceSettingsButton.setSelection(true);
			useProjectSettingsButton.setSelection(false);
			configureButton.setEnabled(true);
			PrecisionText.setText(Integer.toString(FaultTreeModel.getPrecision()));
			PrecisionText.setEnabled(false);
		} else {
			useWorkspaceSettingsButton.setSelection(false);
			useProjectSettingsButton.setSelection(true);
			configureButton.setEnabled(false);
			PrecisionText.setText(Integer.toString(FaultTreeModel.getPrecision(project)));
			PrecisionText.setEnabled(true);
		}

		// Add listeners
		useWorkspaceSettingsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				configureButton.setEnabled(true);
				PrecisionText.setEnabled(false);
			}
		});
		useProjectSettingsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				configureButton.setEnabled(false);
				PrecisionText.setEnabled(true);
			}
		});
		configureButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				configureWorkspaceSettings();
			}
		});

		final Text localText = PrecisionText;
		PrecisionText.addModifyListener(event -> {
			final String s = localText.getText();
			try {
				final int v = Integer.parseInt(s);
				if (v < 1 || v > 16) {
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

	private boolean useWorkspacePreferences() {
		return FaultTreeModel.getWorkspacePref(project);
	}

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
			boolean useWorkspace = useWorkspaceSettingsButton.getSelection();
			FaultTreeModel.setWorkspacePref(useWorkspace, project);
			if (!useWorkspace) {
				FaultTreeModel.setPrecision(Integer.parseInt(PrecisionText.getText()), project);
			}
		}

		return isValid;
	}

	@Override
	protected void performDefaults() {
		PrecisionText.setText(Integer.toString(FaultTreeModel.getPrecision()));

		useWorkspaceSettingsButton.setSelection(true);
		useProjectSettingsButton.setSelection(false);
		configureButton.setEnabled(true);
		PrecisionText.setEnabled(false);

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
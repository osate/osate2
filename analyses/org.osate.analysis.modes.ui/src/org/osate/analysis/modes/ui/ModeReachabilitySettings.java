/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.analysis.modes.ui;

import java.io.IOException;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.osate.analysis.modes.ui.preferences.Constants;
import org.osate.ui.dialogs.Dialog;

public final class ModeReachabilitySettings extends TitleAreaDialog {

	private static final String[] LABELS = { "Generate HTML report", "Generate DOT graph",
			"Generate SMV file (experimental)" };
	private static final String[] KEYS = { Constants.GENERATE_HTML, Constants.GENERATE_DOT,
			Constants.GENERATE_SMV };

	private final IDialogSettings settings;
	private final IPreferenceStore prefStore;

	private boolean hideDialog = false;

	private final Boolean[] values = new Boolean[3];
	private final Button[] buttons = new Button[3];

	public ModeReachabilitySettings(Shell parentShell, IDialogSettings settings, IPreferenceStore prefStore) {
		super(parentShell);
		this.settings = settings;
		this.prefStore = prefStore;
		for (int i = 0; i < KEYS.length; i++) {
			values[i] = getBoolean(KEYS[i]);
		}
	}

	public boolean hideDialog() {
		return prefStore.getBoolean(Constants.HIDE_DIALOG);
	}

	@Override
	protected void configureShell(final Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Check SOM Reachability");
	}

	@Override
	public void create() {
		super.create();
		setTitle("Settings for Checking System Operation Mode Reachability");
		setMessage(
				"Configure the settings for the SOM reachability analysis. Clicking \"OK\" runs the analysis and causes "
						+ "the settings to be used the next time the analysis is executed. Clicking \"Cancel\" "
						+ "leaves the remembered settings as they were.");
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		setHelpAvailable(false);
		// PlatformUI.getWorkbench().getHelpSystem().setHelp(getShell(), "org.osate.analysis.flows.flow_latency_dialog");

		final Composite root = (Composite) super.createDialogArea(parent);

		final ScrolledComposite scroller = new ScrolledComposite(root, SWT.H_SCROLL | SWT.V_SCROLL);
		scroller.setLayoutData(new GridData(GridData.FILL_BOTH));

		final Composite myWorkArea = new Composite(scroller, SWT.NONE);
		scroller.setContent(myWorkArea);
		myWorkArea.setLayout(new GridLayout(2, true));

		createReportGroup(myWorkArea);

		// If we are showing the dialog, then the value of HIDE_DIALOG must be false.
		hideDialog = false;
		final Button hide = new Button(myWorkArea, SWT.CHECK);
		hide.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		hide.setText("Don't show this dialog again");
		hide.setToolTipText("Check this button to hide this dialog in the future.  Use the" + System.lineSeparator()
				+ "OSATE > Analysis > SOM Reachability preference page to bring it back.");
		hide.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				hideDialog = hide.getSelection();
			}
		});

		final Composite prefButtons = new Composite(myWorkArea, SWT.NONE);
		prefButtons.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		prefButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button defaults = new Button(prefButtons, SWT.PUSH);
		defaults.setText("Restore Defaults");
		defaults.setToolTipText("Restore the setting above to the defaults from the " + System.lineSeparator()
				+ "OSATE > Analysis > SOM Reachability preference page.");

		defaults.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				for (int i = 0; i < KEYS.length; i++) {
					values[i] = prefStore.getBoolean(KEYS[i]);
					buttons[i].setSelection(values[i]);
				}
			}
		});

		// Don't bother having a "save preferences" button if the preferences aren't persistable
		if (prefStore instanceof IPersistentPreferenceStore) {
			final Button save = new Button(prefButtons, SWT.PUSH);
			save.setText("Save as Defaults");
			save.setToolTipText(
					"Make the above settings the defaults as in the OSATE > Analysis > SOM Reachability preference page.");
			save.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent event) {
					for (int i = 0; i < KEYS.length; i++) {
						prefStore.setValue(KEYS[i], values[i]);
					}
					savePreferences();
				}
			});
		}

		myWorkArea.layout();
		final Point workAreaSizeOriginal = myWorkArea.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		myWorkArea.setSize(workAreaSizeOriginal);

		/*
		 * This is sleazy. We only need the scroller because on Windows and Linux (but not OS X it seems) fiddling
		 * with the system magnification/dpi/zoom settings can cause the contents of the window to be enlarged, but
		 * for some reason the bounds of the dialog remain sized at 100%. So we want to put out "work area" in
		 * the a scroller for this case. But we need to size the work area based on the size of the dialog so
		 * it doesn't look funny. Just using its computed size (see immediately above) is not sufficient, because
		 * it might be too narrow in the overall dialog and look strange. So we now wait for the scroller itself
		 * to be resized when the dialog/shell/window sets its initial size and then set the size of the
		 * "work area" to the minimum of its existing size and the new size. Then we can remove the listener.
		 */
		scroller.addControlListener(new ControlListener() {
			@Override
			public void controlResized(ControlEvent e) {
				final Point newSize = scroller.getSize();
				final int newWidth = workAreaSizeOriginal.x < newSize.x ? newSize.x : workAreaSizeOriginal.x;
				final int newHeight = workAreaSizeOriginal.y < newSize.y ? newSize.y : workAreaSizeOriginal.y;
				myWorkArea.setSize(new Point(newWidth, newHeight));
				// Don't need the listener any more
				scroller.removeControlListener(this);
			}

			@Override
			public void controlMoved(ControlEvent e) {
				// don't care
			}
		});

		return root;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void okPressed() {
		// Update the last used preferences
		for (int i = 0; i < KEYS.length; i++) {
			settings.put(KEYS[i], values[i]);
		}
		// Save the show dialog pref -- maybe
		// Note, we can only go from false to true here becuse if don't show was true, the dialog wouldn't have been shown
		if (hideDialog) {
			if (MessageDialog.openQuestion(getShell(), "Confirm change",
					"This options dialog will be hidden in the future.  You can restore it by going "
							+ "to the OSATE > Analysis > SOM Reachability preference page.  Do you wish to make this change?")) {
				prefStore.setValue(Constants.HIDE_DIALOG, hideDialog);
			}
		}

		savePreferences();
		super.okPressed();
	}

	private void savePreferences() {
		if (prefStore.needsSaving()) {
			final Job saveJob = Job.create("Save latency prefences", monitor -> {
				try {
					((IPersistentPreferenceStore) prefStore).save();
				} catch (final IOException e) {
					Display.getDefault().asyncExec(() -> {
						Dialog.showError("Error", "There was a problem saving the preferences: " + e.getMessage());
					});
				}
			});
			saveJob.schedule();
		}
	}

	private Group createReportGroup(final Composite parent) {
		final Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new RowLayout(SWT.VERTICAL));
		final GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 2;
		group.setLayoutData(layoutData);
		group.setText("Report selection");

		for (int i = 0; i < KEYS.length; i++) {
			buttons[i] = new Button(group, SWT.CHECK);
			buttons[i].setText(LABELS[i]);
			buttons[i].setSelection(values[i]);
			final var j = i;
			buttons[j].addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent event) {
					values[j] = buttons[j].getSelection();
				}
			});
		}

		return group;
	}

	boolean getBoolean(String key) {
		return settings.get(key) != null ? settings.getBoolean(key) : prefStore.getBoolean(key);
	}

}

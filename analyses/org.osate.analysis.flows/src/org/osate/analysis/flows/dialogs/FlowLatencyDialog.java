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
package org.osate.analysis.flows.dialogs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.jobs.Job;
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
import org.eclipse.ui.PlatformUI;
import org.osate.analysis.flows.preferences.Constants;
import org.osate.ui.dialogs.Dialog;

public final class FlowLatencyDialog extends TitleAreaDialog {
	private static final String[] PREF_IDS = { Constants.ASYNCHRONOUS_SYSTEM, Constants.PARTITONING_POLICY,
			Constants.WORST_CASE_DEADLINE, Constants.BESTCASE_EMPTY_QUEUE, Constants.DISABLE_QUEUING_LATENCY };
	private static final String[] LAST_USED_PREF_IDS = { Constants.ASYNCHRONOUS_SYSTEM_LAST_USED,
			Constants.PARTITONING_POLICY_LAST_USED, Constants.WORST_CASE_DEADLINE_LAST_USED,
			Constants.BESTCASE_EMPTY_QUEUE_LAST_USED, Constants.DISABLE_QUEUING_LATENCY_LAST_USED };

	private final IPreferenceStore latencyPrefs;
	private boolean dontShowDialog = false;
	public final Map<String, String> localValues = new HashMap<>(); // indexed by LAST_USED_PREF_IDS
	private final Map<String, Button> valueToButton = new HashMap<>(); // index by the preference value strings

	public FlowLatencyDialog(Shell parentShell, final IPreferenceStore prefs) {
		super(parentShell);
		latencyPrefs = prefs;
		for (String prefId : LAST_USED_PREF_IDS) {
			localValues.put(prefId, latencyPrefs.getString(prefId));
		}
	}

	public boolean dontShowDialog() {
		return latencyPrefs.getBoolean(Constants.DONT_SHOW_DIALOG);
	}

	@Override
	protected void configureShell(final Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Flow Latency Analysis");
	}

	@Override
	public void create() {
		super.create();
		setTitle("Check Flow Latency");
		setMessage(
				"Configure the settings for the flow latency analysis.  Clicking \"Ok\" runs the analysis and causes "
						+ "the settings to be used the next time the analysis is executed.  Clicking \"Cancel\" "
						+ "leaves the remembered settings as they were.");
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		setHelpAvailable(true);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getShell(), "org.osate.analysis.flows.flow_latency_dialog");

		final Composite root = (Composite) super.createDialogArea(parent);

		final ScrolledComposite scroller = new ScrolledComposite(root, SWT.H_SCROLL | SWT.V_SCROLL);
		scroller.setLayoutData(new GridData(GridData.FILL_BOTH));

		final Composite myWorkArea = new Composite(scroller, SWT.NONE);
		scroller.setContent(myWorkArea);
		myWorkArea.setLayout(new GridLayout(2, true));

		createGroup(myWorkArea, "System type", Constants.ASYNCHRONOUS_SYSTEM_LAST_USED,
				new String[] { "Asynchronous system (AS)", "Synchronous system (SS)" },
				new String[] { Constants.ASYNCHRONOUS_SYSTEM_YES, Constants.ASYNCHRONOUS_SYSTEM_NO });
		createGroup(myWorkArea, "Partition output policy", Constants.PARTITONING_POLICY_LAST_USED,
				new String[] { "Partition end (PE)", "Major frame delayed (MF)" },
				new String[] { Constants.PARTITIONING_POLICY_PARTITION_END_STR,
						Constants.PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR });
		createGroup(myWorkArea, "For worst-case processing time use", Constants.WORST_CASE_DEADLINE_LAST_USED,
				new String[] { "Deadline (DL)", "Maximum compute execution time (ET)" },
				new String[] { Constants.WORST_CASE_DEADLINE_YES, Constants.WORST_CASE_DEADLINE_NO });
		createGroup(myWorkArea, "For best-case queuing latency on incoming ports",
				Constants.BESTCASE_EMPTY_QUEUE_LAST_USED,
				new String[] { "Assume an empty queue (EQ)", "Assume a full queue (FQ)" },
				new String[] { Constants.BESTCASE_EMPTY_QUEUE_YES, Constants.BESTCASE_EMPTY_QUEUE_NO });
		createGroup(myWorkArea, "Disable queuing latency in the results", Constants.DISABLE_QUEUING_LATENCY_LAST_USED,
				new String[] { "Disable", "Enable" },
				new String[] { Constants.DISABLE_QUEUING_LATENCY_YES, Constants.DISABLE_QUEUING_LATENCY_NO });

		/*
		 * If we are showing the dialog, then the value of DONT_SHOW_DIALOG is false.
		 */
		dontShowDialog = false;
		final Button hide = new Button(myWorkArea, SWT.CHECK);
		hide.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		hide.setText("Don't show this dialog again");
		hide.setToolTipText("Check this button to hide this dialog in the future.  Use the" + System.lineSeparator()
				+ "OSATE > Analysis > Flow Latency preference pane to bring it back.");
		hide.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				dontShowDialog = hide.getSelection();
			}
		});

		final Composite prefButtons = new Composite(myWorkArea, SWT.NONE);
		prefButtons.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		prefButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button defaults = new Button(prefButtons, SWT.PUSH);
		defaults.setText("Restore Defaults");
		defaults.setToolTipText("Restore the setting above to the defaults from the " + System.lineSeparator()
				+ "OSATE > Analysis > Flow Latency preference pane.");
		defaults.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				/*
				 * Clear all selections first, then set them because setSelection()
				 * doesn't understand the other radio buttons in the same group.
				 */
				for (final String value : valueToButton.keySet()) {
					valueToButton.get(value).setSelection(false);
				}

				for (int i = 0; i < PREF_IDS.length; i++) {
					final String prefValue = latencyPrefs.getString(PREF_IDS[i]);
					valueToButton.get(prefValue).setSelection(true);
					localValues.put(LAST_USED_PREF_IDS[i], prefValue);
				}
			}
		});

		/*
		 * Don't bother having a "save preferences" button if the preferences aren't persistable
		 */
		if (latencyPrefs instanceof IPersistentPreferenceStore) {
			final Button save = new Button(prefButtons, SWT.PUSH);
			save.setText("Save as Defaults");
			save.setToolTipText("Make the above settings the defaults as in the" + System.lineSeparator()
					+ "OSATE > Analysis > Flow Latency preference pane.");
			save.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent event) {
					for (int i = 0; i < PREF_IDS.length; i++) {
						latencyPrefs.setValue(PREF_IDS[i], localValues.get(LAST_USED_PREF_IDS[i]));
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
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void okPressed() {
		// Update the last used preferences
		for (int i = 0; i < LAST_USED_PREF_IDS.length; i++) {
			latencyPrefs.setValue(LAST_USED_PREF_IDS[i], localValues.get(LAST_USED_PREF_IDS[i]));
		}
		// Save the show dialog pref
		latencyPrefs.setValue(Constants.DONT_SHOW_DIALOG, dontShowDialog);
		savePreferences();

		super.okPressed();
	}

	private void savePreferences() {
		if (latencyPrefs.needsSaving()) {
			final Job saveJob = Job.create("Save latency prefencees", monitor -> {
				try {
					((IPersistentPreferenceStore) latencyPrefs).save();
				} catch (final IOException e) {
					Display.getDefault().asyncExec(() -> {
						Dialog.showError("Error", "There was a problem saving the preferences: " + e.getMessage());
					});
				}
			});
			saveJob.schedule();
		}
	}

	private Group createGroup(final Composite parent, final String title, final String prefId, final String[] labels,
			final String[] values) {
		final Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new RowLayout(SWT.VERTICAL));
		final GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 2;
		group.setLayoutData(layoutData);
		group.setText(title);

		final String prefValue = latencyPrefs.getString(prefId);
		for (int i = 0; i < labels.length; i++) {
			final Button radio = new Button(group, SWT.RADIO);
			radio.setText(labels[i]);
			final String choiceValue = values[i];
			radio.setSelection(prefValue.equalsIgnoreCase(choiceValue));
			radio.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent event) {
					if (radio.getSelection()) {
						localValues.put(prefId, choiceValue);
					}
				}
			});
			valueToButton.put(choiceValue, radio);
		}

		return group;
	}
}

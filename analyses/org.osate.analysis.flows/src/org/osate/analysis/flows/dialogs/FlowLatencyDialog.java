package org.osate.analysis.flows.dialogs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.osate.analysis.flows.preferences.Constants;
import org.osate.ui.dialogs.Dialog;

public final class FlowLatencyDialog extends TitleAreaDialog {
	private static final String[] PREF_IDS = { Constants.ASYNCHRONOUS_SYSTEM, Constants.PARTITONING_POLICY,
			Constants.WORST_CASE_DEADLINE, Constants.BESTCASE_EMPTY_QUEUE };
	private static final String[] LAST_USED_PREF_IDS = { Constants.ASYNCHRONOUS_SYSTEM_LAST_USED,
			Constants.PARTITONING_POLICY_LAST_USED, Constants.WORST_CASE_DEADLINE_LAST_USED,
			Constants.BESTCASE_EMPTY_QUEUE_LAST_USED };

	private final IPreferenceStore latencyPrefs;
	private boolean dontShowDialog = false;
	public final Map<String, String> localValues = new HashMap<>(); // indexed by LAST_USED_PREF_IDS
	private final Map<String, Button> valueToButton = new HashMap<>(); // index by the preference value strings

	public FlowLatencyDialog(Shell parentShell, final IPreferenceStore prefs) {
		super(parentShell);
		// FIXME: there should be help available, see https://github.com/osate/osate2/issues/1560
		setHelpAvailable(false);
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
		final Composite root = (Composite) super.createDialogArea(parent);
		final Composite myWorkArea = new Composite(root, SWT.NONE);
		myWorkArea.setLayoutData(new GridData(GridData.FILL_BOTH));
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

		return root;
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

package org.osate.analysis.flows.dialogs;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.TitleAreaDialog;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.osate.analysis.flows.preferences.Constants;

public class FlowLatencyDialog extends TitleAreaDialog {
	private static final String[] PREF_IDS = { Constants.SYNCHRONOUS_SYSTEM, Constants.PARTITONING_POLICY,
			Constants.WORST_CASE_DEADLINE, Constants.BESTCASE_EMPTY_QUEUE };

	private final IPreferenceStore latencyPrefs;
	private final Map<String, String> localValues = new HashMap<>();
	private final Map<String, Button> valueToButton = new HashMap<>();

	public FlowLatencyDialog(Shell parentShell, final IPreferenceStore prefs) {
		super(parentShell);
		latencyPrefs = prefs;
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
		setMessage("Configure the settings for the flow latency analysis.");
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite root = (Composite) super.createDialogArea(parent);
		final Composite myWorkArea = new Composite(root, SWT.NONE);
		myWorkArea.setLayoutData(new GridData(GridData.FILL_BOTH));
		myWorkArea.setLayout(new GridLayout(2, true));

		createGroup(myWorkArea, "System type", Constants.SYNCHRONOUS_SYSTEM,
				new String[] { "Asynchronous system (AS)", "Synchronous system (SS)" },
				new String[] { Constants.SYNCHRONOUS_SYSTEM_NO, Constants.SYNCHRONOUS_SYSTEM_YES });
		createGroup(myWorkArea, "Partition output policy", Constants.PARTITONING_POLICY,
				new String[] { "Partition end (PE)", "Major frame delayed (MF)" },
				new String[] { Constants.PARTITIONING_POLICY_PARTITION_END_STR,
						Constants.PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR });
		createGroup(myWorkArea, "For worst-case processing time use", Constants.WORST_CASE_DEADLINE,
				new String[] { "Deadline (DL)", "Maximum compute execution time (ET)" },
				new String[] { Constants.WORST_CASE_DEADLINE_YES, Constants.WORST_CASE_DEADLINE_NO });
		createGroup(myWorkArea, "For best-case queuing latency on incoming ports", Constants.BESTCASE_EMPTY_QUEUE,
				new String[] { "Assume an empty queue (EQ)", "Assume a full queue (FQ)" },
				new String[] { Constants.BESTCASE_EMPTY_QUEUE_YES, Constants.BESTCASE_EMPTY_QUEUE_NO });

		final Button hide = new Button(myWorkArea, SWT.CHECK);
		hide.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		hide.setText("Don't show this dialog again");
		hide.setToolTipText("Check this button to hide this dialog in the future.  Use the" + System.lineSeparator()
				+ "OSATE > Analysis > Flow Latency preference pane to bring it back.");

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

				for (final String prefId : PREF_IDS) {
					final String prefValue = latencyPrefs.getString(prefId);
					valueToButton.get(prefValue).setSelection(true);
					localValues.put(prefId, prefValue);
				}
			}
		});

		final Button save = new Button(prefButtons, SWT.PUSH);
		save.setText("Save to Preferences");
		save.setToolTipText("Save the settings above to the OSATE preferences.");

		return root;
	}

	private Group createGroup(final Composite parent, final String title, final String prefId,
			final String[] labels, final String[] values) {
		final Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new RowLayout(SWT.VERTICAL));
		final GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 2;
		group.setLayoutData(layoutData);
		group.setText(title);

		final String prefValue = latencyPrefs.getString(prefId);
		localValues.put(prefId, prefValue);
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
						System.out.println("Setting " + prefId + " to " + choiceValue);
					}
				}
			});
			valueToButton.put(choiceValue, radio);
		}

		return group;
	}
}

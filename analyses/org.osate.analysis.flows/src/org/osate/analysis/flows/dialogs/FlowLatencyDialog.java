package org.osate.analysis.flows.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class FlowLatencyDialog extends TitleAreaDialog {

	public FlowLatencyDialog(Shell parentShell) {
		super(parentShell);

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

		createGroup(myWorkArea, "System type", "Asynchronous system (AS)", "Synchronous system (SS)");
		createGroup(myWorkArea, "Partition output policy", "Partition end (PE)", "Major frame delayed (MF)");
		createGroup(myWorkArea, "For worst-case processing time use", "Deadline (DL)",
				"Maximum compute execution time (ET)");
		createGroup(myWorkArea, "For best-case queuing latency on incoming ports", "Assume an empty queue (EQ)",
				"Assume a full queue (FQ)");

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

		final Button save = new Button(prefButtons, SWT.PUSH);
		save.setText("Save to Preferences");
		save.setToolTipText("Save the settings above to the OSATE preferences.");

		return root;
	}

	private Group createGroup(final Composite parent, final String title, final String... choices) {
		final Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new RowLayout(SWT.VERTICAL));
		final GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 2;
		group.setLayoutData(layoutData);
		group.setText(title);

		for (String choice : choices) {
			final Button radio = new Button(group, SWT.RADIO);
			radio.setText(choice);
		}
		return group;
	}
}

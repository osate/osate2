package org.osate.analysis.flows.dialogs;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class FlowLatencyDialog extends TrayDialog {

	public FlowLatencyDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite composite = (Composite) super.createDialogArea(parent);
		return composite;
	}
}

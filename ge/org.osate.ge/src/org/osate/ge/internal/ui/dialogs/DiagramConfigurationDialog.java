package org.osate.ge.internal.ui.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.widgets.Shell;

public class DiagramConfigurationDialog {
	private final TitleAreaDialog dlg;
	
	public DiagramConfigurationDialog(final Shell shell) {
		dlg = new TitleAreaDialog(shell);
	}
	
	public void open() {
		dlg.open();
	}
	
	public static void main (String [] args) {
		final DiagramConfigurationDialog dlg = new DiagramConfigurationDialog(null);
		dlg.open();
	}
}

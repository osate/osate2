package org.osate.ui.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

public final class InstantiationResultsDialog extends Dialog {
	public InstantiationResultsDialog(final Shell shell) {
		super(shell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	@Override
	protected void configureShell(final Shell shell) {
		super.configureShell(shell);
		shell.setText("Instantiation Results");
	}

	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite composite = (Composite) super.createDialogArea(parent);

		/* Do we need a message on top? */

		final TableViewer viewer = new TableViewer(composite,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		/* May need to add a scroll pane type thing? */

		/*
		 * Columns:
		 * - ComponentImplementation
		 * - Instantiation status
		 * - Error message
		 */

		final TableViewerColumn col1 = new TableViewerColumn(viewer, SWT.NONE);
		col1.getColumn().setText("Component Implementation");
		col1.getColumn().setWidth(200);
//		col1.setLabelProvider(labelProvider);

		final TableViewerColumn col2 = new TableViewerColumn(viewer, SWT.NONE);
		col2.getColumn().setText("Status");
		col2.getColumn().setWidth(200);
//		col2.setLabelProvider(labelProvider);

		final TableViewerColumn col3 = new TableViewerColumn(viewer, SWT.NONE);
		col3.getColumn().setText("Error Message");
		col3.getColumn().setWidth(200);
//		col3.setLabelProvider(labelProvider);

//		viewer.setContentProvider(provider);
		final GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		viewer.getControl().setLayoutData(layoutData);

		return composite;
	}
}

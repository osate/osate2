package org.osate.ui.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.osate.aadl2.ComponentImplementation;

public final class InstantiationResultsDialog extends Dialog {
	private final String message;
	private final Model model;

	public InstantiationResultsDialog(final Shell shell, final String msg, final boolean cancelled, final int lastTried,
			final ComponentImplementation[] cis, final boolean[] successful, final String[] errMsgs,
			final Exception[] exceptions) {
		super(shell);
		setShellStyle(getShellStyle() | SWT.RESIZE);

		message = msg;
		model = new Model(cancelled, lastTried, cis, successful, errMsgs, exceptions);
	}

	private final static class Model {
		final Integer[] elements;

		final String[] name;
		final String[] status;
		final String[] errorMessage;

		public Model(final boolean cancelled, final int lastTried, final ComponentImplementation[] compImpls,
				final boolean[] successful, final String[] errorMessages, final Exception[] exceptions) {
			final int size = compImpls.length;
			elements = new Integer[size];
			for (int i = 0; i < size; i++) {
				elements[i] = Integer.valueOf(i);
			}

			name = new String[size];
			status = new String[size];
			errorMessage = new String[size];

			for (int i = 0; i < size; i++) {
				name[i] = compImpls[i].getQualifiedName();
				if (!cancelled || i < lastTried) {
					if (successful[i]) {
						status[i] = "Successfully instantiated";
					} else {
						if (errorMessages[i] != null) {
							errorMessage[i] = errorMessages[i];
						} else if (exceptions[i] != null) {
							final Exception e = exceptions[i];

							/*
							 * NB. Inherited these specific exception checks from the original
							 * InstantiateHandler (now obsolete).
							 */
							if (e instanceof UnsupportedOperationException) {
								errorMessage[i] = "Operation is not supported: " + e.getMessage();
							} else {
								errorMessage[i] = e.getClass().getCanonicalName() + " during instantiation";
							}
						}
					}
				} else {
					status[i] = "Not instantiated";
				}
			}
		}

		public Integer[] getElements() {
			return elements;
		}

		public String getName(final int idx) {
			return name[idx];
		}

		public String getStatus(final int idx) {
			return status[idx];
		}

		public String getErrorMessage(final int idx) {
			final String errMsg = errorMessage[idx];
			return errMsg == null ? "" : errMsg;
		}
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
		final Label label = new Label(composite, SWT.NONE);
		label.setText(message); // "Message goes here. Message goes here. Message goes here.");
		label.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false));

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
		col1.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return model.getName((Integer) element);
			}
		});

		final TableViewerColumn col2 = new TableViewerColumn(viewer, SWT.NONE);
		col2.getColumn().setText("Status");
		col2.getColumn().setWidth(200);
		col2.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return model.getStatus((Integer) element);
			}
		});

		final TableViewerColumn col3 = new TableViewerColumn(viewer, SWT.NONE);
		col3.getColumn().setText("Error Message");
		col3.getColumn().setWidth(200);
		col3.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return model.getErrorMessage((Integer) element);
			}
		});

		final GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		viewer.getControl().setLayoutData(layoutData);
		viewer.setContentProvider(new ModelContentProvider());
		viewer.setInput(model);

		return composite;
	}

	private static final class ModelContentProvider implements IStructuredContentProvider {
		@Override
		public Object[] getElements(final Object inputElement) {
			return ((Model) inputElement).getElements();
		}
	}
}

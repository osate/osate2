package org.osate.ui.dialogs;

import java.util.Map;

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
import org.osate.ui.handlers.InstantiateComponentHandler.Result;

public final class InstantiationResultsDialog extends Dialog {
	private final Model model;

	public InstantiationResultsDialog(final Shell shell, final Map<ComponentImplementation, Result> results) {
		super(shell);
		setShellStyle(getShellStyle() | SWT.RESIZE);

		model = new Model(results);
	}

	private final static class Model {
		private final String message;

		private final Integer[] elements;

		private final String[] name;
		private final String[] status;
		private final String[] errorMessage;

		private static String buildMessage(final boolean allGood, final boolean cancelled, final boolean errs,
				final boolean logged) {
			final StringBuilder sb = new StringBuilder();
			if (allGood) {
				sb.append("All models created successfully.");
			} else {
				if (cancelled) {
					sb.append("Instantiation cancelled.  ");
				}
				if (errs) {
					if (logged) {
						sb.append("Errors and exceptions during intantiation.  Please open the \"Error Log\" view.");
					} else {
						sb.append("Errors during instantiation");
					}
				} else if (logged) {
					sb.append("Exceptions during instantiation.  Please open the \"Error Log\" view.");
				}
			}
			return sb.toString();
		}

//		public Model(final boolean allGood, final boolean cancelled, final int lastTried,
//				final ComponentImplementation[] compImpls,
//				final boolean[] successful, final String[] errorMessages, final Exception[] exceptions) {
//			final int size = compImpls.length;
//			elements = new Integer[size];
//			for (int i = 0; i < size; i++) {
//				elements[i] = Integer.valueOf(i);
//			}
//
//			name = new String[size];
//			status = new String[size];
//			errorMessage = new String[size];
//
//			boolean errs = false;
//			boolean logged = false;
//			for (int i = 0; i < size; i++) {
//				name[i] = compImpls[i].getQualifiedName();
//				if (!cancelled || i < lastTried) {
//					if (successful[i]) {
//						status[i] = "Instantiated";
//					} else {
//						if (errorMessages[i] != null) {
//							errs = true;
//							status[i] = "Error";
//							errorMessage[i] = errorMessages[i];
//						} else if (exceptions[i] != null) {
//							logged = true;
//							final Exception e = exceptions[i];
//
//							/*
//							 * NB. Inherited these specific exception checks from the original
//							 * InstantiateHandler (now obsolete).
//							 */
//							status[i] = "Exception";
//							if (e instanceof UnsupportedOperationException) {
//								errorMessage[i] = "Operation is not supported: " + e.getMessage();
//							} else {
//								errorMessage[i] = e.getClass().getCanonicalName() + " during instantiation";
//							}
//						}
//					}
//				} else {
//					status[i] = "Not instantiated";
//				}
//			}
//
//			message = buildMessage(allGood, cancelled, errs, logged);
//		}

		public Model(final Map<ComponentImplementation, Result> results) {
			final int size = results.size();

			elements = new Integer[size];
			for (int i = 0; i < size; i++) {
				elements[i] = Integer.valueOf(i);
			}

			name = new String[size];
			status = new String[size];
			errorMessage = new String[size];

			boolean allGood = true;
			boolean cancelled = false;
			boolean errors = false;
			boolean logged = false;
			int i = 0;
			for (final Map.Entry<ComponentImplementation, Result> entry : results.entrySet()) {
				final Result current = entry.getValue();

				name[i] = entry.getKey().getQualifiedName();
				if (current.successful) {
					status[i] = "Instantiated";
				} else {
					allGood = false;
					if (current.cancelled) {
						cancelled = false;
						status[i] = "Cancelled";
					} else {
						// Cannot have error message or exceptions if cancelled
						if (current.errorMessage != null) {
							errors = true;
							status[i] = "Error";
							errorMessage[i] = current.errorMessage;
						} else if (current.exception != null) {
							logged = true;
							final Exception e = current.exception;

							/*
							 * NB. Inherited these specific exception checks from the original
							 * InstantiateHandler (now obsolete).
							 */
							status[i] = "Exception";
							if (e instanceof UnsupportedOperationException) {
								errorMessage[i] = "Operation is not supported: " + e.getMessage();
							} else {
								errorMessage[i] = e.getClass().getCanonicalName() + " during instantiation";
							}
						}
					}
				}

				i += 1;
			}

			message = buildMessage(allGood, cancelled, errors, logged);
		}

		public String getMessage() {
			return message;
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
		label.setText(model.getMessage());
		label.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false));

		final TableViewer viewer = new TableViewer(composite,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		final TableViewerColumn col1 = new TableViewerColumn(viewer, SWT.NONE);
		col1.getColumn().setText("Component Implementation");
		col1.getColumn().setWidth(350);
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

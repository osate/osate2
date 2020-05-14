package org.osate.ui.dialogs;

import java.io.IOException;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.osate.core.OsateCorePlugin;
import org.osate.ui.handlers.AbstractMultiJobHandler.Result;

/* TODO: I don't like that this class depends on AbstractMultiJobHandler.Result.  The dialog sholdn't have
 * dependencies on a UI handler.  The result class either needs to be moved somewhere else, or this
 * class needs to be made sufficiently abstract that the implementation doesn't care about that class
 * specifically.
 */
/**
 * @since 3.0
 */
public final class InstantiationResultsDialog<T> extends Dialog {
	private final String actionName;
	private final String labelName;
	private final Model<T> model;

	private final IPreferenceStore prefs;
	private boolean hideInFutureOriginal;
	private boolean hideInFuture;

	/**
	 * @since 4.0
	 */
	public InstantiationResultsDialog(final Shell shell, final String actionName, final String labelName,
			final Function<T, String> labelProvider, final Map<T, Result> results, final IPreferenceStore prefs) {
		super(shell);
		setShellStyle(getShellStyle() | SWT.RESIZE);

		this.actionName = actionName;
		this.labelName = labelName;
		this.model = new Model<T>(actionName, labelProvider, results);
		this.prefs = prefs;
	}

	private static String toFirstUpperCase(final String input) {
		return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
	}

	private static final class Model<T> {
		private final String message;

		private final Integer[] elements;

		private final String[] name;
		private final String[] status;
		private final String[] errorMessage;

		private String buildMessage(final String actionName, final boolean allGood, final boolean cancelled,
				final boolean errs,
				final boolean logged) {
			final StringBuilder sb = new StringBuilder();
			if (allGood) {
				sb.append("All models created successfully.");
			} else {
				if (cancelled) {
					sb.append(toFirstUpperCase(actionName));
					sb.append(" cancelled.  ");
				}
				if (errs) {
					if (logged) {
						sb.append("Errors and exceptions during ");
						sb.append(actionName.toLowerCase());
						sb.append(".  Please open the \"Error Log\" view.");
					} else {
						sb.append("Errors during ");
						sb.append(actionName.toLowerCase());
					}
				} else if (logged) {
					sb.append("Exceptions during ");
					sb.append(actionName.toLowerCase());
					sb.append(".  Please open the \"Error Log\" view.");
				}
			}
			return sb.toString();
		}

		public Model(final String actionName, final Function<T, String> labelProvider, final Map<T, Result> results) {
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
			for (final Map.Entry<T, Result> entry : results.entrySet()) {
				final Result current = entry.getValue();

				name[i] = labelProvider.apply(entry.getKey());
				if (current.successful) {
					status[i] = "OK";
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
								errorMessage[i] = "Operation not supported: " + e.getMessage();
							} else {
								errorMessage[i] = e.getClass().getCanonicalName();
							}
						}
					}
				}

				i += 1;
			}

			message = buildMessage(actionName, allGood, cancelled, errors, logged);
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
		shell.setText(toFirstUpperCase(actionName) + " Results");
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
		col1.getColumn().setText(labelName);
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

		hideInFutureOriginal = !prefs.getBoolean(OsateCorePlugin.ALWAYS_SHOW_INSTANTIATION_RESULTS);
		hideInFuture = hideInFutureOriginal;
		final Button hide = new Button(composite, SWT.CHECK);
		hide.setSelection(hideInFuture);
		hide.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		hide.setText("Don't show this dialog when successful");
		hide.setToolTipText("Check this button to only show this dialog when an instantiation "
				+ "is cancelled or fails.  Use the \"OSATE > Instantiation\" preference pane to bring it back.");
		hide.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				hideInFuture = hide.getSelection();
			}
		});

		return composite;
	}

	@Override
	protected void okPressed() {
		boolean doSave = true;
		if (hideInFuture && !hideInFutureOriginal) {
			// User just toggled the "don't show option"
			doSave = MessageDialog.openQuestion(getShell(), "Confirm change",
					"This results dialog will be hidden in the future.  You can restore it by going to the \"OSATE > Instantiation\" preference pane.  Do you wish to make this change?");
		}

		if (doSave) {
			prefs.setValue(OsateCorePlugin.ALWAYS_SHOW_INSTANTIATION_RESULTS, !hideInFuture);
			final Job saveJob = Job.create("Save prefences", monitor -> {
				try {
					((IPersistentPreferenceStore) prefs).save();
				} catch (final IOException e) {
					Display.getDefault().asyncExec(() -> {
						MessageDialog.openError(getShell(), "Error",
								"There was a problem saving the preferences: " + e.getMessage());
					});
				}
			});
			saveJob.schedule();
		}

		super.okPressed();
	}

	private static final class ModelContentProvider implements IStructuredContentProvider {
		@SuppressWarnings("rawtypes")
		@Override
		public Object[] getElements(final Object inputElement) {
			return ((Model) inputElement).getElements();
		}
	}
}

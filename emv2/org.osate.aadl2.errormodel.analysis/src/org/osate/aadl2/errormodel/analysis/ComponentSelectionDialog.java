package org.osate.aadl2.errormodel.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class ComponentSelectionDialog extends Dialog {
	private String message;
	private List<String> selectedComponents;
	private List<String> componentsList;

	public ComponentSelectionDialog(Shell parent, List<String> components) {
		this(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		componentsList = components;

	}

	public ComponentSelectionDialog(Shell parent, int style) {
		super(parent, style);
		setText("Select the components");
		setMessage("Please select the components under investigation:");
		selectedComponents = new ArrayList<String>();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Open the dialog box, display the content and wait for the result from the user
	 * @return The list of modules names selected by the user.
	 */
	public List<String> open() {
		Shell shell = new Shell(getParent(), getStyle());
		shell.setText(getText());
		createContents(shell);
		shell.pack();
		shell.open();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return selectedComponents;
	}

	/**
	* Create all the widgets necessary to create the dialog
	* @param shell
	*/
	private void createContents(final Shell shell) {
		shell.setLayout(new GridLayout(2, true));

		// Show the message
		Label label = new Label(shell, SWT.NONE);
		label.setText(message);
		GridData data = new GridData();
		data.horizontalSpan = 2;
		label.setLayoutData(data);

		final Table table = new Table(shell, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		/**
		 * Add the data to the table. For each
		 * item to be displayed, we create an item with
		 * a text field and a checkbox.
		 */
		for (String moduleName : componentsList) {
			TableItem ti = new TableItem(table, SWT.NONE);
			ti.setText(moduleName);
		}
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;
		table.setLayoutData(data);

		/**
		 * The OK button that register the selected
		 * items.
		 */
		Button ok = new Button(shell, SWT.PUSH);
		ok.setText("OK");
		data = new GridData(GridData.FILL_HORIZONTAL);
		ok.setLayoutData(data);
		ok.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				for (TableItem ti : table.getItems()) {
					if (ti.getChecked()) {
						selectedComponents.add(ti.getText());
					}
				}
				shell.close();
			}
		});

		// Create the cancel button and add a handler
		// so that pressing it will set input to null
		Button cancel = new Button(shell, SWT.PUSH);
		cancel.setText("Cancel");
		data = new GridData(GridData.FILL_HORIZONTAL);
		cancel.setLayoutData(data);
		cancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				selectedComponents = null;
				shell.close();
			}
		});

		// Set the OK button as the default, so
		// user can type input and press Enter
		// to dismiss
		shell.setDefaultButton(ok);
	}
}

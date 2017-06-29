/*
 * Copyright 2013 Carnegie Mellon University
 * 
 * The AADL/DSM Bridge (org.osate.importer.lattix ) (the �Content� or �Material�) 
 * is based upon work funded and supported by the Department of Defense under 
 * Contract No. FA8721-05-C-0003 with Carnegie Mellon University for the operation 
 * of the Software Engineering Institute, a federally funded research and development 
 * center.

 * Any opinions, findings and conclusions or recommendations expressed in this 
 * Material are those of the author(s) and do not necessarily reflect the 
 * views of the United States Department of Defense. 

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING 
 * INSTITUTE MATERIAL IS FURNISHED ON AN �AS-IS� BASIS. CARNEGIE MELLON 
 * UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, 
 * AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR 
 * PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF 
 * THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF 
 * ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT 
 * INFRINGEMENT.
 * 
 * This Material has been approved for public release and unlimited 
 * distribution except as restricted below. 
 * 
 * This Material is provided to you under the terms and conditions of the 
 * Eclipse Public License Version 1.0 ("EPL"). A copy of the EPL is 
 * provided with this Content and is also available at 
 * http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Carnegie Mellon� is registered in the U.S. Patent and Trademark 
 * Office by Carnegie Mellon University. 
 * 
 * DM-0000232
 * 
 */

package org.osate.importer.lattix.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.Utils;
import org.osate.importer.lattix.common.Matrix;
import org.osate.importer.lattix.ldmimporter.LdmImporter;
import org.osate.importer.lattix.vdid.Activator;
import org.osate.importer.model.Component;
import org.osgi.framework.Bundle;

/**
 * Internal class to display the Modules to be imported
 * @author jdelange
 *
 */
class ModulesSelectionDialog extends Dialog {
	private String message;
	private List<String> selectedModules;
	private List<String> modulesList;

	public ModulesSelectionDialog(Shell parent, List<String> ml) {
		this(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		this.modulesList = ml;

	}

	public ModulesSelectionDialog(Shell parent, int style) {
		super(parent, style);
		setText("Select your modules");
		setMessage("Please select the modules to import:");
		this.selectedModules = new ArrayList<String>();
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
		return this.selectedModules;
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
		for (String moduleName : modulesList) {
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
						selectedModules.add(ti.getText());
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
				selectedModules = null;
				shell.close();
			}
		});

		// Set the OK button as the default, so
		// user can type input and press Enter
		// to dismiss
		shell.setDefaultButton(ok);
	}
}

public final class DoImportLdm extends AbstractHandler {

	private String inputFile;
	private String outputDirectory;
	List<String> selectedModules;

	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	public String getMarkerType() {
		return "edu.cmu.sei.vdid.dsm.ExcelReportGeneratorObjectMarker";
	}

	protected String getActionName() {
		return "Lattix Importer";
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		outputDirectory = Utils.getSelectedDirectory();

		if (outputDirectory == null) {
			System.out.println("Selection is not a directory" + outputDirectory);
			return null;
		}

		final Display d = PlatformUI.getWorkbench().getDisplay();

		Job aadlGenerator = new Job("LDM2AADL") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Generating AADL files from LDM", 100);

				LdmImporter.convert(inputFile, outputDirectory, selectedModules);

				/**
				 * Here, we try to refresh the current workspace
				 * and display the new created files.
				 */
				try {
					for (IProject p : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
						p.refreshLocal(IResource.DEPTH_INFINITE, null);
					}
				} catch (CoreException e) {
					OsateDebug.osateDebug("[DoImportLdm] Error when refreshing the workspace");
					e.printStackTrace();
				}
				monitor.done();

				return Status.OK_STATUS;
			}
		};

		d.syncExec(new Runnable() {
			@Override
			public void run() {
				IWorkbenchWindow window;
				Shell sh;
				List<String> modulesList;

				window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				sh = window.getShell();

				FileDialog fd = new FileDialog(sh, SWT.OPEN);
				inputFile = fd.open();

				/**
				 * Then, we open a new window 
				 * to choose the module to be included
				 * in the model. The result
				 * is stored in the list selectedModules that is
				 * then reused by the generator to filter the
				 * used nodules.
				 */
				Matrix matrix = LdmImporter.loadFile(inputFile);
				modulesList = new ArrayList<String>();
				for (Component m : matrix.getModules()) {
					modulesList.add(m.getName());
				}

				ModulesSelectionDialog msd = new ModulesSelectionDialog(sh, modulesList);
				selectedModules = msd.open();

			}
		});

		/**
		 * if selectedModules is null, it means that the user
		 * presses the cancel button when he had to choose
		 * the modules to be included in the generated
		 * AADL model. Then, we cancel the AADL model
		 * production.
		 */
		if (selectedModules != null) {
			aadlGenerator.schedule();
		}

		return null;
	}
}
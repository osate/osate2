/*
 * Copyright 2014 Carnegie Mellon University
 * 

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
 * Carnegie Mellon is registered in the U.S. Patent and Trademark 
 * Office by Carnegie Mellon University. 
 * 
 */

package org.osate.importer.scade.actions;

import java.io.File;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.osate.importer.Utils;
import org.osate.importer.model.Model;
import org.osate.importer.scade.Activator;
import org.osate.importer.scade.FileImport;
import org.osate.importer.scade.generator.AadlProjectCreator;
import org.osgi.framework.Bundle;

public final class DoImportModel implements IWorkbenchWindowActionDelegate {

	private String inputFile;
	private String outputDirectory;
	List<String> selectedModules;
	private static String workingDirectory;
	private static boolean filterSystem = false;

	public static boolean filterSystem() {
		return filterSystem;
	}

	public static void setFilterSystem(boolean f) {
		filterSystem = f;
	}

	public static String getWorkingDirectory() {
		return workingDirectory;
	}

	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	public String getMarkerType() {
		return "org.osate.importer.SimulinkImporterMarker";
	}

	protected String getActionName() {
		return "Simulink Importer";
	}

	public void run(IAction action) {

		final Display d = PlatformUI.getWorkbench().getDisplay();
		String fileSuffix;

		fileSuffix = "unknown";
		outputDirectory = Utils.getSelectedDirectory();

		if (outputDirectory == null) {
			org.osate.ui.dialogs.Dialog.showInfo("SCADE Importer",
					"Please select a directory where the model will be created");

			return;
		}

		d.syncExec(new Runnable() {

			public void run() {
				IWorkbenchWindow window;
				Shell sh;
				List<String> modulesList;

				window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				sh = window.getShell();

				FileDialog fd = new FileDialog(sh, SWT.OPEN);
				inputFile = fd.open();
				String parentDirectory = new File(inputFile).getParent();

				if (parentDirectory != null) {
					workingDirectory = parentDirectory;
				}
//				OsateDebug.osateDebug("parent=" + parentDirectory);
				/**
				 * Then, we open a new window 
				 * to choose the module to be included
				 * in the model. The result
				 * is stored in the list selectedModules that is
				 * then reused by the generator to filter the
				 * used nodules.
				 */

			}
		});

		if ((inputFile.length() > 5) && inputFile.contains(".")) {
			fileSuffix = inputFile.substring(inputFile.lastIndexOf('.') + 1, inputFile.length());
		}

		if (fileSuffix.equalsIgnoreCase("xscade") || fileSuffix.equalsIgnoreCase("etp")) {
			Job aadlGenerator;

			aadlGenerator = null;

			if (fileSuffix.equalsIgnoreCase("xscade")) {
				aadlGenerator = new Job("SCADE2AADL") {
					protected IStatus run(IProgressMonitor monitor) {
						monitor.beginTask("Generating AADL files from SCADE", 100);

						Model genericModel = new Model();
						FileImport.loadXscadeFile(inputFile, genericModel);
						AadlProjectCreator.createProject(outputDirectory, genericModel);

						Utils.refreshWorkspace(monitor);
						monitor.done();
						return Status.OK_STATUS;
					}
				};
			}

			if (fileSuffix.equalsIgnoreCase("etp")) {
				aadlGenerator = new Job("SCADE2AADL") {
					protected IStatus run(IProgressMonitor monitor) {
						List<Model> projectModels;

						monitor.beginTask("Generating AADL files from SCADE", 100);

						Model genericModel = new Model();
						projectModels = FileImport.loadProjectFile(inputFile, workingDirectory);

						for (Model m : projectModels) {
							AadlProjectCreator.createProject(outputDirectory, m);
						}

						Utils.refreshWorkspace(monitor);
						monitor.done();
						return Status.OK_STATUS;
					}
				};
			}

			if (aadlGenerator != null) {
				aadlGenerator.schedule();
			}

		} else {
			org.osate.ui.dialogs.Dialog.showInfo("SCADE Importer",
					"Please select a file with the xscade extension. Found suffix: " + fileSuffix);
			return;
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	public void dispose() {

	}

	public void init(IWorkbenchWindow window) {
	}
}

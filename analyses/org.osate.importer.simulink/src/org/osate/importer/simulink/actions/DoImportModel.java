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

package org.osate.importer.simulink.actions;

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
import org.osate.importer.simulink.Activator;
import org.osate.importer.simulink.FileImport;
import org.osate.importer.simulink.generator.AadlProjectCreator;
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

		outputDirectory = Utils.getSelectedDirectory();

		if (outputDirectory == null) {
			org.osate.ui.dialogs.Dialog.showInfo("Simulink Importer",
					"Please select a directory where the model will be created");

//			System.out.println("Selection is not a directory" + outputDirectory);
			return;
		}

		final Display d = PlatformUI.getWorkbench().getDisplay();

		d.syncExec(new Runnable() {

			public void run() {
				IWorkbenchWindow window;
				Shell sh;

				window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				sh = window.getShell();

				FileDialog fd = new FileDialog(sh, SWT.OPEN);
				inputFile = fd.open();
				String parentDirectory = new File(inputFile).getParent();
				workingDirectory = parentDirectory;
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

		Job aadlGenerator = new Job("SIMULINK2AADL") {
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Generating AADL files from Simulink model", 100);

				/**
				 * Initialize global structures.
				 */
				FileImport.init();
				Model genericModel = FileImport.loadFile(inputFile);
				AadlProjectCreator.createProject(outputDirectory, genericModel);

				Utils.refreshWorkspace(monitor);
				monitor.done();
				return Status.OK_STATUS;
			}
		};
		aadlGenerator.schedule();

	}

	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	public void dispose() {

	}

	public void init(IWorkbenchWindow window) {
	}
}

/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */

package org.osate.importer.simulink.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osate.importer.Utils;
import org.osate.importer.model.Model;
import org.osate.importer.simulink.FileImport;
import org.osate.importer.simulink.generator.AadlProjectCreator;

public final class DoImportModel extends AbstractHandler {
	private String inputFile;
	private String outputDirectory;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		outputDirectory = Utils.getSelectedDirectory();

		if (outputDirectory == null) {
			org.osate.ui.dialogs.Dialog.showInfo("Simulink Importer",
					"Please select a directory where the model will be created");

			return null;
		}

		final Display d = PlatformUI.getWorkbench().getDisplay();

		d.syncExec(new Runnable() {
			@Override
			public void run() {
				IWorkbenchWindow window;
				Shell sh;

				window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				sh = window.getShell();

				FileDialog fd = new FileDialog(sh, SWT.OPEN);
				inputFile = fd.open();
			}
		});

		Job aadlGenerator = new Job("SIMULINK2AADL") {
			@Override
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
		return null;
	}
}
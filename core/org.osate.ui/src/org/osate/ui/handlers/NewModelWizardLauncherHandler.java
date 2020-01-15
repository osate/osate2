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
package org.osate.ui.handlers;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Launches a "new Aadl model wizard" when the user clicks on
 * one of the two "new Aadl model" buttons on the toolbar.
 *
 * @author jseibel
 */
abstract class NewModelWizardLauncherHandler extends AbstractHandler {
	@Override
	public final Object execute(ExecutionEvent event) throws ExecutionException {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		ArrayList<IProject> openProjects = new ArrayList<IProject>();
		for (int i = 0; i < projects.length; i++) {
			if (projects[i].isOpen()) {
				openProjects.add(projects[i]);
			}
		}
		if (openProjects.size() == 0) {
			MessageDialog.openWarning(null, "Cannot Create New Spec",
					"There are no open projects to create a new spec in.");
		} else {
			IWorkbenchWizard wizard = createWizard();
			IWorkbench workbench = HandlerUtil.getActiveWorkbenchWindow(event).getWorkbench();
			wizard.init(workbench, getSelection(event));
			WizardDialog dialog = new WizardDialog(workbench.getActiveWorkbenchWindow().getShell(), wizard);
			dialog.open();
		}
		return null;
	}

	protected abstract IWorkbenchWizard createWizard();

	private IStructuredSelection getSelection(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
			return (IStructuredSelection) selection;
		} else {
			return null;
		}
	}
}
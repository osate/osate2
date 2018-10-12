/*******************************************************************************
 * Copyright (c) 2009 Andrey Loskutov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Andrey Loskutov - initial API and implementation
 *     Carnegie Mellon University Software Engineering Institute - moved into OSATE
 *******************************************************************************/
package org.osate.ui.wizards.workingsets;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;

/**
 * @author Andrey
 */
public class WorkingSetExportWizard extends Wizard implements IExportWizard {
	private Shell shell;
	private ExportPage mainPage;

	public WorkingSetExportWizard() {
		super();
	}

	@Override
	public boolean performFinish() {
		return mainPage.finish();
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		shell = workbench.getActiveWorkbenchWindow().getShell();
	}

	@Override
	public void addPages() {
		super.addPages();
		mainPage = new ExportPage("Working Set Export", shell);
		addPage(mainPage);
		setWindowTitle(mainPage.getName());
	}
}

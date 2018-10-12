/*******************************************************************************
 * Copyright (c) 2012 Andrey Loskutov.
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
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

public class WorkingSetImportWizard extends Wizard implements IImportWizard {
	private Shell shell;
    private ImportPage mainPage;
    private IStructuredSelection selection;

    public WorkingSetImportWizard() {
        super();
    }

    @Override
    public boolean performFinish() {
        return mainPage != null? mainPage.finish() : false;
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection sel) {
    	shell = workbench.getActiveWorkbenchWindow().getShell();
        this.selection = sel;
    }

    @Override
    public void addPages() {
        super.addPages();
        mainPage = new ImportPage("Working Set Import", shell);
        mainPage.setInitialSelection(selection);
		addPage(mainPage);
	}
}

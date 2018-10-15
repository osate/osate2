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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.XMLMemento;
import org.osate.ui.OsateUiPlugin;

/**
 * @author Andrey
 */
public class ExportPage extends WSPage {

	private static final String TITLE = "Export working sets to the local file system";
	private static final String DESCRIPTION = "Select working sets to export and the file path to store";
	
	private final Shell shell;

	protected ExportPage(String pageName, Shell shell) {
		super(pageName, TITLE, DESCRIPTION, "icons/workingsets/export_wiz.gif", shell, SWT.SAVE);
		this.shell = shell;
	}

	private boolean storeSets() {
		validateInput();
		String pathname = getFileString();
		if (pathname == null) {
			return false;
		}
		File file = new File(pathname);
		XMLMemento memento = XMLMemento.createWriteRoot("workingSets");
		Object[] sets = getSelectedWorkingSets();
		for (int i = 0; i < sets.length; i++) {
			IMemento childMem = memento.createChild("workingSet");
			IWorkingSet set = (IWorkingSet) sets[i];
			set.saveState(childMem);
		}

		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			memento.save(writer);
		} catch (IOException e) {
			OsateUiPlugin.log(e);
			MessageDialog.openError(shell, "Working Set Export", e.getMessage());
			return false;
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					OsateUiPlugin.log(e);
				}
			}
		}
		try {
			String lastUsedFile = file.getCanonicalPath();
			IPreferenceStore store = OsateUiPlugin.getDefault().getPreferenceStore();
			store.setValue(LAST_USED_WS_FILE, lastUsedFile);
		} catch (IOException e) {
			OsateUiPlugin.log(e);
		}
		return true;
	}

	public boolean finish() {
		return storeSets();
	}

	@Override
	protected IStructuredContentProvider createContentProvider() {
		return new WorkingSetContentProvider();
	}

	public static class WorkingSetContentProvider implements ITreeContentProvider {

		public WorkingSetContentProvider() {
			super();
		}

		@Override
		public void dispose() {
			// noop
		}

		@Override
		public void inputChanged(Viewer viewer1, Object oldInput, Object newInput) {
			// noop
		}

		@Override
		public Object[] getElements(Object inputElement) {
			IWorkingSet[] workingSets = PlatformUI.getWorkbench().getWorkingSetManager().getAllWorkingSets();
			List<IWorkingSet> sets = new ArrayList<IWorkingSet>();
			for (int i = 0; i < workingSets.length; i++) {
				IWorkingSet workingSet = workingSets[i];
				if (!workingSet.isAggregateWorkingSet()) {
					sets.add(workingSet);
				}
			}
			return sets.toArray(new IWorkingSet[sets.size()]);
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			return new Object[0];
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return false;
		}
	}

}

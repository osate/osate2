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
